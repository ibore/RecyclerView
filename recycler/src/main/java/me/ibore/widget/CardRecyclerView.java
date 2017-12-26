package me.ibore.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import me.ibore.widget.recycler.manager.CardManager;


/**
 * Created by Administrator on 2017/12/26.
 */

public class CardRecyclerView extends RecyclerView {

    public CardRecyclerView(Context context) {
        this(context, null);
    }

    public CardRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CardRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public int getVisibleCardCount() {
        if (getAdapter().getVisibleCardCount() <= 0)
            throw new IllegalArgumentException("visibleCardCount must be over zero !!!");
        return getAdapter().getVisibleCardCount();
    }

    @Override
    public void setAdapter(Adapter adapter) {
        if (adapter instanceof CardAdapter)
            super.setAdapter(adapter);
        else
            throw new IllegalArgumentException("");
    }

    @Override
    public CardAdapter getAdapter() {
        return (CardAdapter) super.getAdapter();
    }

    @Override
    public void setLayoutManager(LayoutManager layout) {
        if (layout instanceof CardManager)
            super.setLayoutManager(layout);
        else
            throw new IllegalArgumentException("");
    }

    @Override
    public CardManager getLayoutManager() {
        return (CardManager) super.getLayoutManager();
    }

    public void dropCard(int orientation) {
        if (getChildCount() > 0)
            getLayoutManager().dropCardNoTouch(orientation);
    }

    public void dropCard() {
        if (getAdapter().isEnableDataRecycle()) {
            getAdapter().recycleData();
        } else
            getAdapter().delItem(0);
    }

    public static abstract class CardAdapter<VH extends ViewHolder> extends Adapter<VH> {

        protected abstract void delItem(int position);

        protected abstract void recycleData();

        public int getVisibleCardCount() {
            return 3;
        }

        protected boolean isEnableDataRecycle() {
            return false;
        }

    }

}
