package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class SheetDelegate {
    abstract int calculateInnerMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams);

    abstract float calculateSlideOffset(int i6);

    abstract int getCoplanarSiblingAdjacentMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams);

    abstract int getExpandedOffset();

    abstract int getHiddenOffset();

    abstract int getMaxViewPositionHorizontal();

    abstract int getMinViewPositionHorizontal();

    abstract <V extends View> int getOuterEdge(@NonNull V v5);

    abstract int getParentInnerEdge(@NonNull CoordinatorLayout coordinatorLayout);

    abstract int getSheetEdge();

    abstract boolean isExpandingOutwards(float f6);

    abstract boolean isReleasedCloseToInnerEdge(@NonNull View view);

    abstract boolean isSwipeSignificant(float f6, float f7);

    abstract boolean shouldHide(@NonNull View view, float f6);

    abstract void updateCoplanarSiblingAdjacentMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i6);

    abstract void updateCoplanarSiblingLayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i6, int i7);

    SheetDelegate() {
    }
}
