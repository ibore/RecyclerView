package me.ibore.widget.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.List;

/**
 * description:
 * author: Ibore Xie
 * date: 2017-11-26 00:24
 * website: ibore.me
 */

public abstract class RecyclerAdapter<T, VH extends RecyclerHolder<VH>> extends RecyclerView.Adapter<VH> {

    private List<T> mDatas;

    private static final int LOAD = 0x1000;
    private static final int HEADER = 0x1001;
    private static final int FOOTER = 0x1002;
    private static final int LOADMORE = 0x1003;
    private FrameLayout mLoadView;
    private FrameLayout mLoadMoreView;
    private LinearLayout mHeaderView;
    private LinearLayout mFooterView;

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerHolder holder;
        switch (viewType) {
            case LOAD:
                holder = new RecyclerHolder(mLoadView);
                break;
            case LOADMORE:
                holder = new RecyclerHolder(mLoadMoreView);
                break;
            case HEADER:
                holder = new RecyclerHolder(mHeaderView);
                break;
            case FOOTER:
                holder = new RecyclerHolder(mFooterView);
                break;
            default:
                holder = onCreateRecyclerHolder(parent, viewType);
                break;
        }
        return (VH) holder;
    }

    /**
     * 创建RecyclerHolder
     * @param parent ViewGroup
     * @param viewType
     * @return
     */
    protected abstract RecyclerHolder onCreateRecyclerHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(RecyclerHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
