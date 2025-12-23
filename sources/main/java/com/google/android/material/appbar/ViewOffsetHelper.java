package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class ViewOffsetHelper {
    private int layoutLeft;
    private int layoutTop;
    private int offsetLeft;
    private int offsetTop;
    private final View view;
    private boolean verticalOffsetEnabled = true;
    private boolean horizontalOffsetEnabled = true;

    void applyOffsets() {
        View view = this.view;
        ViewCompat.offsetTopAndBottom(view, this.offsetTop - (view.getTop() - this.layoutTop));
        View view2 = this.view;
        ViewCompat.offsetLeftAndRight(view2, this.offsetLeft - (view2.getLeft() - this.layoutLeft));
    }

    public int getLayoutLeft() {
        return this.layoutLeft;
    }

    public int getLayoutTop() {
        return this.layoutTop;
    }

    public int getLeftAndRightOffset() {
        return this.offsetLeft;
    }

    public int getTopAndBottomOffset() {
        return this.offsetTop;
    }

    public boolean isHorizontalOffsetEnabled() {
        return this.horizontalOffsetEnabled;
    }

    public boolean isVerticalOffsetEnabled() {
        return this.verticalOffsetEnabled;
    }

    void onViewLayout() {
        this.layoutTop = this.view.getTop();
        this.layoutLeft = this.view.getLeft();
    }

    public void setHorizontalOffsetEnabled(boolean z5) {
        this.horizontalOffsetEnabled = z5;
    }

    public boolean setLeftAndRightOffset(int i6) {
        if (!this.horizontalOffsetEnabled || this.offsetLeft == i6) {
            return false;
        }
        this.offsetLeft = i6;
        applyOffsets();
        return true;
    }

    public boolean setTopAndBottomOffset(int i6) {
        if (!this.verticalOffsetEnabled || this.offsetTop == i6) {
            return false;
        }
        this.offsetTop = i6;
        applyOffsets();
        return true;
    }

    public void setVerticalOffsetEnabled(boolean z5) {
        this.verticalOffsetEnabled = z5;
    }

    public ViewOffsetHelper(View view) {
        this.view = view;
    }
}
