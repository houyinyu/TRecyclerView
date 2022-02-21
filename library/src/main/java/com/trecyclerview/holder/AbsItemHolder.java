package com.trecyclerview.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trecyclerview.adapter.VHolder;

/**
 * @author：tqzhang on 18/8/15 15:04
 */
public abstract class AbsItemHolder<T, VH extends AbsHolder> extends VHolder<T, VH> {

    protected Context mContext;

    public AbsItemHolder(Context context) {
        this.mContext = context;
    }

    @Override
    protected @NonNull
    RecyclerView.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return createViewHolder(inflater.inflate(getLayoutResId(), parent, false));
    }

    public abstract int getLayoutResId();


    public abstract VH createViewHolder(View view);


}
