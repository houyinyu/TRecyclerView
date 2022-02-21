package com.hyy.trecyclerview.itemView;

import android.content.Context;

import android.view.View;
import android.widget.RelativeLayout;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.hyy.trecyclerview.R;
import com.hyy.trecyclerview.pojo.BannerVo;
import com.trecyclerview.holder.AbsHolder;
import com.trecyclerview.holder.AbsItemHolder;

/**
 * @author：tqzhang on 18/8/22 13:57
 */
public class banner extends AbsItemHolder<BannerVo, banner.ViewHolder> {
    public banner(Context context) {
        super(context);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.banner;
    }

    @Override
    public ViewHolder createViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull BannerVo item) {
        RecyclerView.LayoutParams clp = (RecyclerView.LayoutParams) holder.mBannerView.getLayoutParams();
        if (clp instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) clp).setFullSpan(true);
        }
    }

    static class ViewHolder extends AbsHolder {

        private RelativeLayout mBannerView;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mBannerView=getViewById(R.id.rl_root_view);
        }

    }

}
