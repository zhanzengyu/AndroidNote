package com.nesger.androidproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * https://github.com/nesger/AndroidNote/blob/master/utils/BaseRecyclerViewAdapter.java
 * @param <T>
 */
public abstract class BaseRecyclerViewAdapter<T>  extends RecyclerView.Adapter<BaseRecyclerViewAdapter.ViewHolder> {

    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mList;

    public BaseRecyclerViewAdapter(Context context, int layoutId, List<T> list) {
        this.mContext = context;
        this.mLayoutId = layoutId;
        this.mList = (list == null) ? new ArrayList<T>() : list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ViewHolder.getInstance(mContext, mLayoutId, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        if (mList.size() > 0) convert(holder, mList.get(position), position);

        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(holder.itemView, holder.getLayoutPosition());
                }
            });
        }

        if (mOnItemLongClickListener != null) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemLongClickListener.onItemLongClick(holder.itemView, holder.getLayoutPosition());
                    // 返回true 表示消耗了事件 事件不会继续传递
                    return true;
                }
            });
        }
    }

    public abstract void convert(ViewHolder holder, T t, int position);

    @Override
    public int getItemCount() {
        return mList.size();
    }

    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        private View mItemView;
        private SparseArray<View> mViews;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemView = itemView;
            mViews = new SparseArray<>();
        }

        public static ViewHolder getInstance(Context context, int layoutId, ViewGroup parent) {
            View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
            return new ViewHolder(itemView);
        }

        public <T extends View> T getView(int viewId) {
            View view = mViews.get(viewId);
            if (view == null) {
                view = mItemView.findViewById(viewId);
                mViews.put(viewId, view);
            }
            return (T) view;
        }

    }
}
