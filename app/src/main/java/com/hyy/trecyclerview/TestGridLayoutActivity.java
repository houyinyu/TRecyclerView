package com.hyy.trecyclerview;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hyy.trecyclerview.pojo.BannerVo;
import com.hyy.trecyclerview.pojo.ItemVo;
import com.trecyclerview.adapter.ItemData;

import java.util.Collections;
import java.util.List;


/**
 * @author：tqzhang on 18/8/22 13:48
 */
public class TestGridLayoutActivity extends AppCompatActivity {
    private RecyclerView tRecyclerView;
    private ItemData itemData;
    private MyAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        tRecyclerView = findViewById(R.id.recycler_view);
        itemData = new ItemData();
        GridLayoutManager layoutManager = new GridLayoutManager(TestGridLayoutActivity.this, 2);
        adapter = new MyAdapter();
        tRecyclerView.setAdapter(adapter);
        tRecyclerView.setLayoutManager(layoutManager);
        initData();
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
        private List<ItemVo> list;

        public MyAdapter() {
            list = Collections.emptyList();
        }

        public void setList(List list) {
            this.list = list;
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type, parent, false);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return list == null ? 0 : list.size();
        }


        public class Holder extends RecyclerView.ViewHolder {
            public Holder(View itemView) {
                super(itemView);
            }
        }

    }
    private void initData() {
        itemData.clear();
        itemData.add(new BannerVo());
        for (int i = 0; i < 80; i++) {
            itemData.add(new ItemVo());
        }
        adapter.setList(itemData);
        adapter.notifyDataSetChanged();
    }
}
