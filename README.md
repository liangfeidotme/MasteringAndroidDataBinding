# 完全掌握 Android Data Binding

本教程是跟着 [Data Binding Guide](https://developer.android.com/tools/data-binding/guide.html) 学习过程中得出的一些实践经验，同时修改了官方教程的一些错误，每一个知识点都有对应的源码，争取做到实践与理论相结合。

Data Binding 解决了 Android UI 编程中的一个痛点，官方原生支持 MVVM 模型可以让我们在不改变既有代码框架的前提下，非常容易地使用这些新特性。其实在此之前，已经有些第三方的框架（[RoboAndroid](http://robobinding.github.io/RoboBinding/getting_started.zh.html)) 可以支持 MVVM 模型，无耐由于框架的侵入性太强，导致一直没有流行起来。 


## 准备

### Android Studio 更新到 1.3 版本

打开 Preferences，找到 **Appearances & Behavior** 下的 **Updates** 选项，把 **Automatically Check updates for** 修改成 **Canary Channel**。

<img src="http://img01.taobaocdn.com/imgextra/i1/160310864/TB2mN_5cVXXXXaEXpXXXXXXXXXX_!!160310864.png" style="width:100%" />

**注意**

*Data Binding 是一个 support 包，因此与 Android M 没什么关系，可以不用下载 Android MNC Preview 的 SDK。*


### 新建一个 Project

修改 Project 的 [build.gradle](https://github.com/LyndonChin/MasteringAndroidDataBinding/blob/master/build.gradle)，为 build script 添加一条依赖，Gradle 版本为 1.2.3。


```
classpath 'com.android.tools.build:gradle:1.2.3'
classpath 'com.android.databinding:dataBinder:1.0-rc0'
```

为用到 Data Binding 的模块添加插件，修改对应的 [build.gradle](https://github.com/LyndonChin/MasteringAndroidDataBinding/blob/master/app/build.gradle)。

```
apply plugin: 'com.android.databinding'
```


**注意**

如果 Module 用到的 **buildToolsVersion** 高于 **22.0.1**，比如 **23 rc1**，那 `com.android.databinding:dataBinder` 的版本要改为 **1.3.0-beta1**，否则会出现如下错误：

<img src="http://img02.taobaocdn.com/imgextra/i2/160310864/TB2r9D5cVXXXXaPXpXXXXXXXXXX_!!160310864.png" style="width:100%">


## 基础


工程创建完成后，我们通过一个最简单的例子来说明 Data Binding 的基本用法。

### 布局文件

使用 Data Binding 之后，xml的布局文件就不再单纯地展示 UI 元素，还需要定义 UI 元素用到的变量。所以，它的根节点不再是一个 `ViewGroup`，而是变成了 `layout`，并且新增了一个节点 `data`。

```
<layout xmlns:android="http://schemas.android.com/apk/res/android">
    <data>
    </data>
    <!--原先的根节点（Root Element）-->
    <LinearLayout>
    ....
    </LinearLayout>
</layout>
```
要实现 MVVM 的 ViewModel 就需要把数据与UI进行绑定，`data` 节点就为此提供了一个桥梁，我们先在 `data` 中声明一个 `variable`，这个变量会为 UI 元素提供数据（例如 TextView 的 android:text），然后在 Java 代码中把"后台"数据与这个 `variable` 进行绑定。

如果要用一个表格来展示用户的基本信息，用 Data Binding 应该怎么实现呢？

### 数据对象

添加一个 POJO 类 - `User`，非常简单，四个属性以及他们的 getter 和 setter。

```
public class User {
    private final String firstName;
    private final String lastName;
    private String displayName;
    private int age;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName, int age) {
        this(firstName, lastName);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDisplayName() {
        return firstName + " " + lastName;
    }

    public boolean isAdult() {
        return age >= 18;
    }
}
```

稍后，我们会新建一个 `User` 类型的变量，然后把它跟布局文件中声明的变量进行绑定。

### 定义 Variable

再回到布局文件，在 `data` 节点中声明一个变量 `user`。

```
<data>
	<variable name="user" type="com.liangfeizc.databindingsamples.basic.User" />
</data>
```

其中 `type` 属性就是我们在 Java 文件中定义的 `User` 类。

当然，`data` 节点也支持 `import`，所以上面的代码可以换一种形式来写。

```
<data>
    <import type="com.liangfeizc.databindingsamples.basic.User" />
    <variable name="user" type="User" />
</data>
```

然后我们刚才在 build.gradle 中添加的那个插件 - `com.android.databinding`会根据xml文件的名称 **Generate** 一个继承自 `ViewDataBinding` 的类。

例如，这里 xml 的文件名叫 `activity_basic.xml`，那么生成的类就是 `ActivityBasicBinding`。

**注意**

`java.lang.*` 包中的类会被自动导入，可以直接使用，例如要定义一个 `String` 类型的变量：

```
<variable name="firstName" type="String" />
```

### 绑定 Variable

修改 `BasicActivity` 的 `onCreate` 方法，用 `DatabindingUtil.setContentView()` 来替换掉 `setContentView()`，然后创建一个 `user` 对象，通过 `binding.setUser(user)` 与 `variable` 进行绑定。

```
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityBasicBinding binding = DataBindingUtil.setContentView(
            this, R.layout.activity_basic);
    User user = new User("fei", "Liang");
    binding.setUser(user);
}
```

**注意**

`ActivityBasicBinding` 类是自动生成的，所有的 set 方法也是根据 `variable` 名称生成的。例如，我们定义了两个变量。

```
<data>
    <variable name="firstName" type="String" />
    <variable name="firstName" type=""
</data>
```

那么就会生成对应的两个 set 方法。

```
setFirstName(String firstName);
setLastName(String lastName);
```

至此，一个简单的数据绑定就完成了，可参考[完整代码](https://github.com/LyndonChin/MasteringAndroidDataBinding/tree/master/app/src/main/java/com/liangfeizc/databindingsamples/basic)

未完待续
---

* [Generated Binding](https://developer.android.com/tools/data-binding/guide.html#generated_binding)
* [Attribute Setters](https://developer.android.com/tools/data-binding/guide.html#attribute_setters)
* [Converters](https://developer.android.com/tools/data-binding/guide.html#converters)
