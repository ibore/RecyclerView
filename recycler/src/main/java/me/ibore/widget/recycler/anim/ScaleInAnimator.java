package me.ibore.widget.recycler.anim;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Interpolator;

public class ScaleInAnimator extends BaseItemAnimator {

  public ScaleInAnimator() {
  }

  public ScaleInAnimator(Interpolator interpolator) {
    mInterpolator = interpolator;
  }

  @Override
  protected void animateRemoveImpl(final RecyclerView.ViewHolder holder) {
    ViewCompat.animate(holder.itemView)
        .scaleX(0)
        .scaleY(0)
        .setDuration(getRemoveDuration())
        .setInterpolator(mInterpolator)
        .setListener(new DefaultRemoveVpaListener(holder))
        .setStartDelay(getRemoveDelay(holder))
        .start();
  }

  @Override
  protected void preAnimateAddImpl(RecyclerView.ViewHolder holder) {
    ViewCompat.setScaleX(holder.itemView, 0);
    ViewCompat.setScaleY(holder.itemView, 0);
  }

  @Override
  protected void animateAddImpl(final RecyclerView.ViewHolder holder) {
    ViewCompat.animate(holder.itemView)
        .scaleX(1)
        .scaleY(1)
        .setDuration(getAddDuration())
        .setInterpolator(mInterpolator)
        .setListener(new DefaultAddVpaListener(holder))
        .setStartDelay(getAddDelay(holder))
        .start();
  }
}
