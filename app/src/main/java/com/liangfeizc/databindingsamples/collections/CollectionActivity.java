package com.liangfeizc.databindingsamples.collections;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;

import com.liangfeizc.databindingsamples.R;
import com.liangfeizc.databindingsamples.databinding.CollectionsBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CollectionsBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_collection);

        String[] literals = new String[]{"liang", "fei"};

        List<String> list = new ArrayList<>();
        SparseArray<String> sparse = new SparseArray<>(2);

        String key = "firstName";
        int index = 0;

        for (int i = 0; i < literals.length; i++) {
            list.add(literals[i]);
            sparse.put(0, literals[i]);
        }

        Map<String, String> map = new HashMap<>();
        map.put(key, "liang");
        map.put("lastName", "fei");

        binding.setIndex(index);
        binding.setKey(key);
        binding.setList(list);
        binding.setSparse(sparse);
        binding.setMap(map);
    }
}

