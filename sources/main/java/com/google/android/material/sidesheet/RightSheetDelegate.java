package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class RightSheetDelegate extends SheetDelegate {
    final SideSheetBehavior<? extends View> sheetBehavior;

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getSheetEdge() {
        return 0;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    boolean isExpandingOutwards(float f6) {
        return f6 < 0.0f;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int calculateInnerMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getCoplanarSiblingAdjacentMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getHiddenOffset() {
        return this.sheetBehavior.getParentWidth();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getMaxViewPositionHorizontal() {
        return this.sheetBehavior.getParentWidth();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    void updateCoplanarSiblingAdjacentMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i6) {
        marginLayoutParams.rightMargin = i6;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    void updateCoplanarSiblingLayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i6, int i7) {
        int parentWidth = this.sheetBehavior.getParentWidth();
        if (i6 <= parentWidth) {
            marginLayoutParams.rightMargin = parentWidth - i6;
        }
    }

    RightSheetDelegate(@NonNull SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.sheetBehavior = sideSheetBehavior;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    float calculateSlideOffset(int i6) {
        float hiddenOffset = getHiddenOffset();
        return (hiddenOffset - i6) / (hiddenOffset - getExpandedOffset());
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getExpandedOffset() {
        return Math.max(0, (getHiddenOffset() - this.sheetBehavior.getChildWidth()) - this.sheetBehavior.getInnerMargin());
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getMinViewPositionHorizontal() {
        return getExpandedOffset();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    <V extends View> int getOuterEdge(@NonNull V v5) {
        return v5.getLeft() - this.sheetBehavior.getInnerMargin();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public int getParentInnerEdge(@NonNull CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getRight();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    boolean isReleasedCloseToInnerEdge(@NonNull View view) {
        if (view.getLeft() > (getHiddenOffset() + getExpandedOffset()) / 2) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    boolean isSwipeSignificant(float f6, float f7) {
        if (SheetUtils.isSwipeMostlyHorizontal(f6, f7) && Math.abs(f6) > this.sheetBehavior.getSignificantVelocityThreshold()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    boolean shouldHide(@NonNull View view, float f6) {
        if (Math.abs(view.getRight() + (f6 * this.sheetBehavior.getHideFriction())) > this.sheetBehavior.getHideThreshold()) {
            return true;
        }
        return false;
    }
}
