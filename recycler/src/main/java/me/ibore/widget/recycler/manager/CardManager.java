package me.ibore.widget.recycler.manager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import me.ibore.widget.CardRecyclerView;

/**
 * description: Card
 * author: Ibore Xie
 * date: 2017-11-26 00:22
 * website: ibore.me
 */

public abstract class CardManager extends RecyclerView.LayoutManager implements View.OnTouchListener {
    protected int mScreenWidth;
    protected int mScreenHeight;
    protected CardRecyclerView mRecyclerView;

    protected OnCardDragListener mListener;

    public CardManager(Context context, CardRecyclerView recyclerView) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        mScreenWidth = wm.getDefaultDisplay().getWidth();
        mScreenHeight = wm.getDefaultDisplay().getHeight();
        mRecyclerView = recyclerView;
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                RecyclerView.LayoutParams.WRAP_CONTENT);
    }

    public abstract void onLayoutCards(RecyclerView.Recycler recycler, RecyclerView.State state);

    public void dropCardNoTouch(int orientation) {
    }

    @Override
    public final void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {

        if (getItemCount() <= 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }

        // remove all attached child views
        detachAndScrapAttachedViews(recycler);

        // re-layout
        onLayoutCards(recycler, state);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    public void setOnCardDragListener(OnCardDragListener listener) {
        this.mListener = listener;
    }

    public interface OnCardDragListener {

        void onDraggingStateChanged(View view, boolean isDragging, boolean isDropped, float offsetX, float offsetY);

        void onCardDragging(View view, float offsetX, float offsetY);
    }
}
