package com.hyy.trecyclerview.itemView;

import android.content.Context;
import android.view.View;


import androidx.annotation.NonNull;

import com.hyy.trecyclerview.R;
import com.hyy.trecyclerview.pojo.Item2Vo;
import com.trecyclerview.holder.AbsHolder;
import com.trecyclerview.holder.AbsItemHolder;

/**
 * @author：tqzhang on 18/8/22 13:57
 */
public class ItemType2 extends AbsItemHolder<Item2Vo, ItemType2.ViewHolder> {
    public ItemType2(Context context) {
        super(context);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.type_2;
    }

    @Override
    public ViewHolder createViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Item2Vo item) {

    }

    static class ViewHolder extends AbsHolder {

        ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

    }

}
