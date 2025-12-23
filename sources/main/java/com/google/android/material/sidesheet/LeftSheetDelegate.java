package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class LeftSheetDelegate extends SheetDelegate {
    final SideSheetBehavior<? extends View> sheetBehavior;

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getSheetEdge() {
        return 1;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    boolean isExpandingOutwards(float f6) {
        return f6 > 0.0f;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int calculateInnerMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getCoplanarSiblingAdjacentMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getExpandedOffset() {
        return Math.max(0, this.sheetBehavior.getParentInnerEdge() + this.sheetBehavior.getInnerMargin());
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getHiddenOffset() {
        return (-this.sheetBehavior.getChildWidth()) - this.sheetBehavior.getInnerMargin();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getMaxViewPositionHorizontal() {
        return this.sheetBehavior.getInnerMargin();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getMinViewPositionHorizontal() {
        return -this.sheetBehavior.getChildWidth();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    void updateCoplanarSiblingAdjacentMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i6) {
        marginLayoutParams.leftMargin = i6;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    void updateCoplanarSiblingLayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i6, int i7) {
        if (i6 <= this.sheetBehavior.getParentWidth()) {
            marginLayoutParams.leftMargin = i7;
        }
    }

    LeftSheetDelegate(@NonNull SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.sheetBehavior = sideSheetBehavior;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    float calculateSlideOffset(int i6) {
        float hiddenOffset = getHiddenOffset();
        return (i6 - hiddenOffset) / (getExpandedOffset() - hiddenOffset);
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    <V extends View> int getOuterEdge(@NonNull V v5) {
        return v5.getRight() + this.sheetBehavior.getInnerMargin();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    public int getParentInnerEdge(@NonNull CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getLeft();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    boolean isReleasedCloseToInnerEdge(@NonNull View view) {
        if (view.getRight() < (getExpandedOffset() - getHiddenOffset()) / 2) {
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
        if (Math.abs(view.getLeft() + (f6 * this.sheetBehavior.getHideFriction())) > this.sheetBehavior.getHideThreshold()) {
            return true;
        }
        return false;
    }
}
