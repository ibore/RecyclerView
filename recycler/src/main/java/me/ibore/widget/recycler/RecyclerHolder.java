package me.ibore.widget.recycler;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * description:
 * author: Ibore Xie
 * date: 2017-11-26 00:22
 * website: ibore.me
 */

public class RecyclerHolder<VH extends RecyclerHolder> extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;

    public RecyclerHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<>();
    }



}
