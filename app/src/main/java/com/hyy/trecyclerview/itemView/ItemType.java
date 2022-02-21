package com.hyy.trecyclerview.itemView;

import android.content.Context;
import android.view.View;


import androidx.annotation.NonNull;

import com.hyy.trecyclerview.R;
import com.hyy.trecyclerview.pojo.ItemVo;
import com.trecyclerview.holder.AbsHolder;
import com.trecyclerview.holder.AbsItemHolder;

/**
 * @author：tqzhang on 18/8/22 13:57
 */
public class ItemType extends AbsItemHolder<ItemVo, ItemType.ViewHolder> {
    public ItemType(Context context) {
        super(context);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.type;
    }

    @Override
    public ViewHolder createViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull ItemVo item) {

    }

    static class ViewHolder extends AbsHolder {

        ViewHolder(@NonNull final View itemView) {
            super(itemView);
        }

    }

}
