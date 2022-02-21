package com.trecyclerview.holder;

import android.util.SparseArray;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.recyclerview.widget.RecyclerView;


/**
 * @author：tqzhang on 18/8/15 15:05
 */
public abstract class AbsHolder extends RecyclerView.ViewHolder {

    private final SparseArray<View> views;

    public View convertView;


    public AbsHolder(final View view) {
        super(view);
        this.views = new SparseArray<>();
        this.convertView = view;
    }

    public <T extends View> T getViewById(@IdRes int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

}