package com.bytedance.sdk.component.widget.recycler.j.cw;

import android.view.View;
import android.view.ViewParent;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class tl {
    public static boolean j(ViewParent viewParent, View view, View view2, int i6, int i7) {
        if (viewParent instanceof m) {
            return ((m) viewParent).j(view, view2, i6, i7);
        }
        if (i7 != 0) {
            return false;
        }
        try {
            return viewParent.onStartNestedScroll(view, view2, i6);
        } catch (AbstractMethodError e6) {
            vl.cw("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e6);
            return false;
        }
    }

    public static void xt(ViewParent viewParent, View view, View view2, int i6, int i7) {
        if ((viewParent instanceof m) || i7 != 0) {
            return;
        }
        try {
            viewParent.onNestedScrollAccepted(view, view2, i6);
        } catch (AbstractMethodError e6) {
            vl.cw("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e6);
        }
    }

    public static void j(ViewParent viewParent, View view, int i6) {
        if ((viewParent instanceof m) || i6 != 0) {
            return;
        }
        try {
            viewParent.onStopNestedScroll(view);
        } catch (AbstractMethodError e6) {
            vl.cw("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e6);
        }
    }

    public static void j(ViewParent viewParent, View view, int i6, int i7, int i8, int i9, int i10) {
        if ((viewParent instanceof m) || i10 != 0) {
            return;
        }
        try {
            viewParent.onNestedScroll(view, i6, i7, i8, i9);
        } catch (AbstractMethodError e6) {
            vl.cw("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e6);
        }
    }

    public static void j(ViewParent viewParent, View view, int i6, int i7, int[] iArr, int i8) {
        if (viewParent instanceof m) {
            ((m) viewParent).j(view, i6, i7, iArr, i8);
            return;
        }
        if (i8 == 0) {
            try {
                viewParent.onNestedPreScroll(view, i6, i7, iArr);
            } catch (AbstractMethodError e6) {
                vl.cw("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e6);
            }
        }
    }

    public static boolean j(ViewParent viewParent, View view, float f6, float f7, boolean z5) {
        try {
            return viewParent.onNestedFling(view, f6, f7, z5);
        } catch (AbstractMethodError e6) {
            vl.cw("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e6);
            return false;
        }
    }

    public static boolean j(ViewParent viewParent, View view, float f6, float f7) {
        try {
            return viewParent.onNestedPreFling(view, f6, f7);
        } catch (AbstractMethodError e6) {
            vl.cw("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e6);
            return false;
        }
    }
}
