package com.baidu.mobads.sdk.internal.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
final class AnimateLayoutChangeDetector {

    /* renamed from: a, reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f11101a;

    /* renamed from: b, reason: collision with root package name */
    private LinearLayoutManager f11102b;

    boolean a() {
        return (!b() || this.f11102b.getChildCount() <= 1) && c();
    }

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f11101a = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    private boolean b() {
        int top2;
        int i6;
        int bottom;
        int i7;
        int childCount = this.f11102b.getChildCount();
        if (childCount == 0) {
            return true;
        }
        boolean z5 = this.f11102b.getOrientation() == 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, childCount, 2);
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = this.f11102b.getChildAt(i8);
            if (childAt == null) {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f11101a;
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
        Arrays.sort(iArr, new Comparator<int[]>() { // from class: com.baidu.mobads.sdk.internal.widget.AnimateLayoutChangeDetector.1
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

    private boolean c() {
        int childCount = this.f11102b.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            if (a(this.f11102b.getChildAt(i6))) {
                return true;
            }
        }
        return false;
    }

    AnimateLayoutChangeDetector(@NonNull LinearLayoutManager linearLayoutManager) {
        this.f11102b = linearLayoutManager;
    }

    private static boolean a(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                if (a(viewGroup.getChildAt(i6))) {
                    return true;
                }
            }
        }
        return false;
    }
}
