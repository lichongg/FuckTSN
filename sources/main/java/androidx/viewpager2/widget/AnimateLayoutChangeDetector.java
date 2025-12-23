package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AnimateLayoutChangeDetector {
    private static final ViewGroup.MarginLayoutParams ZERO_MARGIN_LAYOUT_PARAMS;
    private LinearLayoutManager mLayoutManager;

    private boolean hasRunningChangingLayoutTransition() {
        int childCount = this.mLayoutManager.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            if (hasRunningChangingLayoutTransition(this.mLayoutManager.getChildAt(i6))) {
                return true;
            }
        }
        return false;
    }

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        ZERO_MARGIN_LAYOUT_PARAMS = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    private boolean arePagesLaidOutContiguously() {
        int top2;
        int i6;
        int bottom;
        int i7;
        int childCount = this.mLayoutManager.getChildCount();
        if (childCount == 0) {
            return true;
        }
        boolean z5 = this.mLayoutManager.getOrientation() == 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, childCount, 2);
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = this.mLayoutManager.getChildAt(i8);
            if (childAt == null) {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : ZERO_MARGIN_LAYOUT_PARAMS;
            int[] iArr2 = iArr[i8];
            if (z5) {
                top2 = childAt.getLeft();
                i6 = marginLayoutParams.leftMargin;
            } else {
                top2 = childAt.getTop();
                i6 = marginLayoutParams.topMargin;
            }
            iArr2[0] = top2 - i6;
            int[] iArr3 = iArr[i8];
            if (z5) {
                bottom = childAt.getRight();
                i7 = marginLayoutParams.rightMargin;
            } else {
                bottom = childAt.getBottom();
                i7 = marginLayoutParams.bottomMargin;
            }
            iArr3[1] = bottom + i7;
        }
        Arrays.sort(iArr, new Comparator<int[]>() { // from class: androidx.viewpager2.widget.AnimateLayoutChangeDetector.1
            @Override // java.util.Comparator
            public int compare(int[] iArr4, int[] iArr5) {
                return iArr4[0] - iArr5[0];
            }
        });
        for (int i9 = 1; i9 < childCount; i9++) {
            if (iArr[i9 - 1][1] != iArr[i9][0]) {
                return false;
            }
        }
        int[] iArr4 = iArr[0];
        int i10 = iArr4[1];
        int i11 = iArr4[0];
        return i11 <= 0 && iArr[childCount - 1][1] >= i10 - i11;
    }

    AnimateLayoutChangeDetector(@NonNull LinearLayoutManager linearLayoutManager) {
        this.mLayoutManager = linearLayoutManager;
    }

    private static boolean hasRunningChangingLayoutTransition(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                if (hasRunningChangingLayoutTransition(viewGroup.getChildAt(i6))) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean mayHaveInterferingAnimations() {
        if ((!arePagesLaidOutContiguously() || this.mLayoutManager.getChildCount() <= 1) && hasRunningChangingLayoutTransition()) {
            return true;
        }
        return false;
    }
}
