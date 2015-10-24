# 完全掌握 Android Data Binding

> 微博求粉 [liangfeizc-Android](http://weibo.com/u/1670598115)

本教程是跟着 [Data Binding Guide](https://developer.android.com/tools/data-binding/guide.html) 学习过程中得出的一些实践经验，同时修改了官方教程的一些错误，每一个知识点都有对应的源码，争取做到实践与理论相结合。

Data Binding 解决了 Android UI 编程中的一个痛点，官方原生支持 MVVM 模型可以让我们在不改变既有代码框架的前提下，非常容易地使用这些新特性。

Data Binding 框架一出，是不是也意味着像 *RoboGuice、ButterKnife* 这样的依赖注入框架也会慢慢失去市场，因为在 Java 代码中直接使用 `View` 变量的情况会越来越少。

## 准备

### Android Studio 更新到 1.3 版本

打开 Preferences，找到 **Appearances & Behavior** 下的 **Updates** 选项，把 **Automatically Check updates for** 修改成 **Canary Channel**。

<img src="http://img01.taobaocdn.com/imgextra/i1/160310864/TB2mN_5cVXXXXaEXpXXXXXXXXXX_!!160310864.png" style="width:100%" />

**注意**

*Data Binding 是一个 support 包，因此与 Android M 没什么关系，可以不用下载 Android MNC Preview 的 SDK。*


### 新建一个 Project

修改 Project 的 [build.gradle](https://github.com/LyndonChin/MasteringAndroidDataBinding/blob/master/build.gradle)，保持 `gradle` 和 `dataBinder` 都是最新版，否则会由于 Android Studio 的一次升级导致 Data Binding 失效。


```groovy
classpath 'com.android.tools.build:gradle:1.3.+'
classpath 'com.android.databinding:dataBinder:1.+'
```

为用到 Data Binding 的模块(Module)添加插件，修改对应的 [build.gradle](https://github.com/LyndonChin/MasteringAndroidDataBinding/blob/master/app/build.gradle)。

```groovy
apply plugin: 'com.android.databinding'
```

## 基础

工程创建完成后，我们通过一个最简单的例子来说明 Data Binding 的基本用法。

### 布局文件

使用 Data Binding 之后，xml的布局文件就不再单纯地展示 UI 元素，还需要定义 UI 元素用到的变量。所以，它的根节点不再是一个 `ViewGroup`，而是变成了 `layout`，并且新增了一个节点 `data`。

```xml
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

```java
public class User {
    private final String firstName;
    private final String lastName;
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
}
```

稍后，我们会新建一个 `User` 类型的变量，然后把它跟布局文件中声明的变量进行绑定。

### 定义 Variable

再回到布局文件，在 `data` 节点中声明一个变量 `user`。

```xml
<data>
	<variable name="user" type="com.liangfeizc.databindingsamples.basic.User" />
</data>
```

其中 `type` 属性就是我们在 Java 文件中定义的 `User` 类。

当然，`data` 节点也支持 `import`，所以上面的代码可以换一种形式来写。

```xml
<data>
    <import type="com.liangfeizc.databindingsamples.basic.User" />
    <variable name="user" type="User" />
</data>
```

然后我们刚才在 build.gradle 中添加的那个插件 - `com.android.databinding`会根据xml文件的名称 **Generate** 一个继承自 `ViewDataBinding` 的类。

例如，这里 xml 的文件名叫 `activity_basic.xml`，那么生成的类就是 `ActivityBasicBinding`。

**注意**

`java.lang.*` 包中的类会被自动导入，可以直接使用，例如要定义一个 `String` 类型的变量：

```xml
<variable name="firstName" type="String" />
```

### 绑定 Variable

修改 `BasicActivity` 的 `onCreate` 方法，用 `DatabindingUtil.setContentView()` 来替换掉 `setContentView()`，然后创建一个 `user` 对象，通过 `binding.setUser(user)` 与 `variable` 进行绑定。

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityBasicBinding binding = DataBindingUtil.setContentView(
            this, R.layout.activity_basic);
    User user = new User("fei", "Liang");
    binding.setUser(user);
}
```

除了使用框架自动生成的 `ActivityBasicBinding`，我们也可以使用自定义的类名。

```xml
<data class="com.example.CustomBinding">
</data>
```

**注意**

`ActivityBasicBinding` 类是自动生成的，所有的 set 方法也是根据 `variable` 名称生成的。例如，我们定义了两个变量。

```xml
<data>
    <variable name="firstName" type="String" />
    <variable name="lastName" type="String" />
</data>
```

那么就会生成对应的两个 set 方法。

```java
setFirstName(String firstName);
setLastName(String lastName);
```


### 使用 Variable

数据与 Variable 绑定之后，xml 的 UI 元素就可以直接使用了。

```xml
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@{user.lastName}" />
```

至此，一个简单的数据绑定就完成了，可参考[完整代码](https://github.com/LyndonChin/MasteringAndroidDataBinding/tree/master/app/src/main/java/com/liangfeizc/databindingsamples/basic)

## 高级用法

### 使用类方法

首先为类添加一个静态方法

```java
public class MyStringUtils {
    public static String capitalize(final String word) {
        if (word.length() > 1) {
            return String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1);
        }
        return word;
    }
}
```

然后在 xml 的 `data` 节点中导入：

```xml
<import type="com.liangfeizc.databindingsamples.utils.MyStringUtils" />
```

使用方法与 Java 语法一样：

```java
<TextView
	android:layout_width="wrap_content"
	android:layout_height="wrap_content"
	android:text="@{StringUtils.capitalize(user.firstName)}" />
```

### 类型别名

如果我们在 `data` 节点了导入了两个同名的类怎么办？

```xml
<import type="com.example.home.data.User" />
<import type="com.examle.detail.data.User" />
<variable name="user" type="User" />
```

这样一来出现了两个 `User` 类，那 `user` 变量要用哪一个呢？不用担心，`import` 还有一个 `alias` 属性。

```xml
<import type="com.example.home.data.User" />
<import type="com.examle.detail.data.User" alias="DetailUser" />
<variable name="user" type="DetailUser" />
```

### Null Coalescing 运算符

```java
android:text="@{user.displayName ?? user.lastName}"
```

就等价于

```java
android:text="@{user.displayName != null ? user.displayName : user.lastName}"
```

### 属性值

通过 `@{}` 可以直接把 Java 中定义的属性值赋值给 xml 属性。

```xml
<TextView
   android:text="@{user.lastName}"
   android:layout_width="wrap_content"
   android:layout_height="wrap_content"
   android:visibility="@{user.isAdult ? View.VISIBLE : View.GONE}"/>
```

### 使用资源数据

这个例子，官方教程有错误，可以参考[Android Data Binder 的一个bug](http://blog.csdn.net/feelang/article/details/46342699)，完整代码[在此](https://github.com/LyndonChin/MasteringAndroidDataBinding/blob/master/app/src/main/res/layout/activity_resource.xml)。

```xml
<TextView
    android:padding="@{large? (int)@dimen/largePadding : (int)@dimen/smallPadding}"
    android:background="@android:color/black"
    android:textColor="@android:color/white"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/hello_world" />
```

## Observable Binding

本来这一节的标题应该叫**双向绑定**，但是很遗憾，现在的 **Data Binding** 暂时支持单向绑定，还没有达到 **Angular.js** 的威力。

要实现 Observable Binding，首先得有一个实现了 `android.databinding.Observable` 的类，为了方便，Android 原生提供了已经封装好的一个类 - `BaseObservable`，并且实现了监听器的注册机制。

我们可以直接继承 `BaseObservable`。

```java
public class ObservableUser extends BaseObservable {
    private String firstName;
    private String lastName;
    @Bindable
    public String getFirstName() {
        return firstName;
    }
    @Bindable
    public String getLastName() {
        return lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }
}
```

`BR` 是编译阶段生成的一个类，功能与 `R.java` 类似，用 `@Bindable` 标记过 `getter` 方法会在 `BR` 中生成一个 *entry*，当我们

通过代码可以看出，当数据发生变化时还是需要手动发出通知。 通过调用`notifyPropertyChanged(BR.firstName)`来通知系统 `BR.firstName` 这个 `entry` 的数据已经发生变化，需要更新 UI。


除此之外，还有一种更细粒度的绑定方式，可以具体到成员变量，这种方式无需继承 `BaseObservable`，一个简单的 **POJO** 就可以实现。

```java
public class PlainUser {
    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();
    public final ObservableInt age = new ObservableInt();
}
```

系统为我们提供了所有的 **primitive type** 所对应的 **Observable**类，例如 `ObservableInt`、`ObservableFloat`、`ObservableBoolean` 等等，还有一个 `ObservableField` 对应着 **reference type**。

剩下的数据绑定与前面介绍的方式一样，具体可参考[ObservableActivity](https://github.com/LyndonChin/MasteringAndroidDataBinding/blob/master/app/src/main/java/com/liangfeizc/databindingsamples/observable/ObservableActivity.java)

## 带 ID 的 View

**Data Binding** 有效降低了代码的冗余性，甚至完全没有必要再去获取一个 View 实例，但是情况不是绝对的，万一我们真的就需要了呢？不用担心，只要给 View 定义一个 ID，**Data Binding** 就会为我们生成一个对应的 `final` 变量。

```xml
<TextView
    android:id="@+id/firstName"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content" />
```

上面代码中定义了一个 ID 为 *firstName** 的 `TextView`，那么它对应的变量就是

```java
public final TextView firstName;
```

具体代码可参考 [ViewWithIDsActivity.java](https://github.com/LyndonChin/MasteringAndroidDataBinding/blob/master/app/src/main/java/com/liangfeizc/databindingsamples/viewids/ViewWithIDsActivity.java) 。

## ViewStubs

xml中的 `ViewStub` 经过 binding 之后会转换成 `ViewStubProxy`, 具体代码可参考 [ViewStubActivity.java](https://github.com/LyndonChin/MasteringAndroidDataBinding/blob/master/app/src/main/java/com/liangfeizc/databindingsamples/viewstub/ViewStubActivity.java)

简单用代码说明一下，xml 文件与之前的代码一样，根节点改为 `layout`，在 `LinearLayout` 中添加一个 `ViewStub`，添加 **ID**。

```xml
<layout xmlns:android="http://schemas.android.com/apk/res/android">
    <LinearLayout
        ...>
        <ViewStub
            android:id="@+id/view_stub"
            android:layout="@layout/view_stub"
            ... />
    </LinearLayout>
</layout>
```

在 Java 代码中获取 `binding` 实例，为 `ViewStubProy` 注册 `ViewStub.OnInflateListener` 事件，搞定！

```java
binding = DataBindingUtil.setContentView(this, R.layout.activity_view_stub);
binding.viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
	@Override
	public void onInflate(ViewStub stub, View inflated) {
		ViewStubBinding binding = DataBindingUtil.bind(inflated);
		User user = new User("fee", "lang");
		binding.setUser(user);
	}
});
```

## Dynamic Variables

完整代码可以参考 [dynamic](https://github.com/LyndonChin/MasteringAndroidDataBinding/tree/master/app/src/main/java/com/liangfeizc/databindingsamples/dynamic)

以 `RecyclerView` 为例，`Adapter` 的 **DataBinding** 需要动态生成，因此我们可以在 `onCreateViewHolder` 的时候创建这个 **DataBinding**，然后在 `onBindViewHolder` 中获取这个 **DataBinding**。

```java
public static class BindingHolder extends RecyclerView.ViewHolder {
    private ViewDataBinding binding;
    public BindingHolder(View itemView) {
        super(itemView);
    }
    public ViewDataBinding getBinding() {
        return binding;
    }
    public void setBinding(ViewDataBinding binding) {
        this.binding = binding;
    }
}
@Override
public BindingHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    ViewDataBinding binding = DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.getContext()),
            R.layout.list_item,
            viewGroup,
            false);
    BindingHolder holder = new BindingHolder(binding.getRoot());
    holder.setBinding(binding);
    return holder;
}
@Override
public void onBindViewHolder(BindingHolder holder, int position) {
    User user = users.get(position);
    holder.getBinding().setVariable(BR.user, user);
    holder.getBinding().executePendingBindings();
}
```

注意此处 `DataBindingUtil` 的用法：

```java
ViewDataBinding binding = DataBindingUtil.inflate(
	LayoutInflater.from(viewGroup.getContext()),
	R.layout.list_item,
	viewGroup,
	false);
```

---

还有另外一种比较简洁的方式，直接在构造 Holder 时把 View 与自动生成的 XXXBinding 进行绑定。

```java
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
    private static final int USER_COUNT = 10;

    @NonNull
    private List<User> mUsers;

    public UserAdapter() {
        mUsers = new ArrayList<>(10);
        for (int i = 0; i < USER_COUNT; i ++) {
            User user = new User(RandomNames.nextFirstName(), RandomNames.nextLastName());
            mUsers.add(user);
        }
    }

    public static class UserHolder extends RecyclerView.ViewHolder {
        private UserItemBinding mBinding;

        public UserHolder(View itemView) {
            super(itemView);
            mBinding = UserItemBinding.bind(itemView);
        }

        public void bind(@NonNull User user) {
            mBinding.setUser(user);
        }
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.user_item, viewGroup, false);
        return new UserHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        holder.bind(mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }
}
```

## Attribute setters

有了 **Data Binding**，即使属性没有在 `declare-styleable` 中定义，我们也可以通过 xml 进行赋值操作。
为了演示这个功能，我自定义了一个 View - [UserView](https://github.com/LyndonChin/MasteringAndroidDataBinding/blob/master/app/src/main/java/com/liangfeizc/databindingsamples/attributesetters/UserView.java)，其中 [R.styleable.UserView](https://github.com/LyndonChin/MasteringAndroidDataBinding/blob/master/app/src/main/res/values/styles.xml) 中只定义了一个 `age` 属性，其中 `firstName` 和 `lastName` 只有对应的两个 `setter` 方法。

只要有 `setter` 方法就可以这样为属性赋值：

```xml
<com.liangfeizc.databindingsamples.attributesetters.UserView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:paddingLeft="@dimen/largePadding"
    app:onClickListener="@{activity.clickListener}"
    app:firstName="@{@string/firstName}"
    app:lastName="@{@string/lastName}"
    app:age="27" />
```

`onClickListener` 也是同样道理，只不过我们是在 `Activity` 中定义了一个 `Listener`。

## 转换器 (Converters)

**重要**

使用 **Converter** 一定要保证它不会影响到其他的属性，例如这个 `@BindingConversion` - [](https://github.com/LyndonChin/MasteringAndroidDataBinding/blob/master/app/src/main/java/com/liangfeizc/databindingsamples/converters/ConversionsActivity.java#L44-57) 就会影响到[android:visibility](https://github.com/LyndonChin/MasteringAndroidDataBinding/blob/master/app/src/main/res/layout/activity_basic.xml#L76), 因为他们都是都符合从 int 到 int 的转换。

---

具体代码可参考 [ConversionsActivity.java](https://github.com/LyndonChin/MasteringAndroidDataBinding/blob/master/app/src/main/java/com/liangfeizc/databindingsamples/converters/ConversionsActivity.java)。

在 xml 中为属性赋值时，如果变量的类型与属性不一致，通过 **DataBinding** 可以进行转换。

```xml
<Button
    android:onClick="toggleIsError"
    android:text="@{isError.get() ? @color/red : @color/white}"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```

只需要定义一个标记了 `@BindingConversion` 的静态方法即可：

```java
@BindingConversion
public static int convertColorToString(int color) {
    switch (color) {
        case Color.RED:
            return R.string.red;
        case Color.WHITE:
            return R.string.white;
    }
    return R.string.app_name;
}
```

## include

用法可以参考代码 [IncludeActivity.java](https://github.com/LyndonChin/MasteringAndroidDataBinding/blob/master/app/src/main/java/com/liangfeizc/databindingsamples/includes/IncludeActivity.java)。

如果在非根节点的 ViewGroup 中使用 `include` 会导致 crash，已经在 StackOverflow 上提了一个问题[Android Data Binding makes app crash when using include tag in a non-root ViewGroup](http://stackoverflow.com/questions/30887906/android-data-binding-makes-app-crash-when-using-include-tag-in-a-non-root-viewgr)

---

* [我的微博](http://weibo.com/u/1670598115)
* [个人博客](http://www.liangfeizc.com)
* [twitter](https://twitter.com/JpRyouhi)
* [facebook](https://www.facebook.com/fee.lang.zc)
