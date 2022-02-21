package com.trecyclerview.footview;

import android.content.Context;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.trecyclerview.R;
import com.trecyclerview.pojo.FootVo;

import static com.trecyclerview.footview.LoadingMoreFooter.STATE_LOADING;
import static com.trecyclerview.footview.LoadingMoreFooter.STATE_NOMORE;
import static com.trecyclerview.footview.LoadingMoreFooter.STATE_NO_NET_WORK;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/**
 * @author：tqzhang on 18/6/20 13:41
 */
public class FootViewHolder extends AbsFootView<FootVo, FootViewHolder.ViewHolder> {

    private int mProgressStyle;


    private String mLoadingHint;

    private String mLoadFinishHint;

    public FootViewHolder(Context context, int progressStyle) {
        super(context);
        this.mProgressStyle = progressStyle;
    }

    public FootViewHolder(Context context, int progressStyle, String loadingHint, String loadFinishHint) {
        super(context);
        this.mProgressStyle = progressStyle;
        this.mLoadingHint = loadingHint;
        this.mLoadFinishHint = loadFinishHint;
    }

    @Override
    protected @NonNull
    RecyclerView.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ViewHolder(inflater.inflate(R.layout.listview_foot, parent, false));

    }

    @Override
    protected void onBindHolder(@NonNull final ViewHolder holder, @NonNull FootVo mFootData) {

        RecyclerView.LayoutParams clp = (RecyclerView.LayoutParams) holder.mRootView.getLayoutParams();
        if (clp instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) clp).setFullSpan(true);
        }
        holder.loadingProgressBar.setProgressStyle(mProgressStyle);

        if (!TextUtils.isEmpty(mLoadingHint)) {
            holder.loadingProgressBar.setLoadingHint(mLoadingHint);
        }
        if (!TextUtils.isEmpty(mLoadFinishHint)) {
            holder.loadingProgressBar.setNoMoreHint(mLoadFinishHint);
        }
        if (mFootData.state == STATE_NOMORE) {
            holder.loadingProgressBar.setState(STATE_NOMORE);
        } else if (mFootData.state == STATE_LOADING) {
            holder.loadingProgressBar.setState(STATE_LOADING);
        } else if (mFootData.state == STATE_NO_NET_WORK) {
            holder.loadingProgressBar.setState(STATE_NO_NET_WORK);
        }

    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout mRootView;
        LoadingMoreFooter loadingProgressBar;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mRootView = itemView.findViewById(R.id.foot_view);
            loadingProgressBar = itemView.findViewById(R.id.loading_progress_bar);
        }
    }
}
