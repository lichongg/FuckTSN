package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ViewParentCompat {
    private static final String TAG = "ViewParentCompat";
    private static int[] sTempNestedScrollConsumed;

    public static void onNestedPreScroll(@NonNull ViewParent viewParent, @NonNull View view, int i6, int i7, @NonNull int[] iArr) {
        onNestedPreScroll(viewParent, view, i6, i7, iArr, 0);
    }

    public static void onNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i6, int i7, int i8, int i9) {
        onNestedScroll(viewParent, view, i6, i7, i8, i9, 0, getTempNestedScrollConsumed());
    }

    public static void onNestedScrollAccepted(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i6) {
        onNestedScrollAccepted(viewParent, view, view2, i6, 0);
    }

    public static boolean onStartNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i6) {
        return onStartNestedScroll(viewParent, view, view2, i6, 0);
    }

    public static void onStopNestedScroll(@NonNull ViewParent viewParent, @NonNull View view) {
        onStopNestedScroll(viewParent, view, 0);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static boolean onNestedFling(ViewParent viewParent, View view, float f6, float f7, boolean z5) {
            return viewParent.onNestedFling(view, f6, f7, z5);
        }

        @DoNotInline
        static boolean onNestedPreFling(ViewParent viewParent, View view, float f6, float f7) {
            return viewParent.onNestedPreFling(view, f6, f7);
        }

        @DoNotInline
        static void onNestedPreScroll(ViewParent viewParent, View view, int i6, int i7, int[] iArr) {
            viewParent.onNestedPreScroll(view, i6, i7, iArr);
        }

        @DoNotInline
        static void onNestedScroll(ViewParent viewParent, View view, int i6, int i7, int i8, int i9) {
            viewParent.onNestedScroll(view, i6, i7, i8, i9);
        }

        @DoNotInline
        static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i6) {
            viewParent.onNestedScrollAccepted(view, view2, i6);
        }

        @DoNotInline
        static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i6) {
            return viewParent.onStartNestedScroll(view, view2, i6);
        }

        @DoNotInline
        static void onStopNestedScroll(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }

    private static int[] getTempNestedScrollConsumed() {
        int[] iArr = sTempNestedScrollConsumed;
        if (iArr == null) {
            sTempNestedScrollConsumed = new int[2];
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        return sTempNestedScrollConsumed;
    }

    public static void onNestedPreScroll(@NonNull ViewParent viewParent, @NonNull View view, int i6, int i7, @NonNull int[] iArr, int i8) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedPreScroll(view, i6, i7, iArr, i8);
        } else if (i8 == 0) {
            try {
                Api21Impl.onNestedPreScroll(viewParent, view, i6, i7, iArr);
            } catch (AbstractMethodError unused) {
                Objects.toString(viewParent);
            }
        }
    }

    public static void onNestedScrollAccepted(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i6, int i7) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScrollAccepted(view, view2, i6, i7);
        } else if (i7 == 0) {
            try {
                Api21Impl.onNestedScrollAccepted(viewParent, view, view2, i6);
            } catch (AbstractMethodError unused) {
                Objects.toString(viewParent);
            }
        }
    }

    public static boolean onStartNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i6, int i7) {
        if (viewParent instanceof NestedScrollingParent2) {
            return ((NestedScrollingParent2) viewParent).onStartNestedScroll(view, view2, i6, i7);
        }
        if (i7 != 0) {
            return false;
        }
        try {
            return Api21Impl.onStartNestedScroll(viewParent, view, view2, i6);
        } catch (AbstractMethodError unused) {
            Objects.toString(viewParent);
            return false;
        }
    }

    public static void onStopNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i6) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onStopNestedScroll(view, i6);
        } else if (i6 == 0) {
            try {
                Api21Impl.onStopNestedScroll(viewParent, view);
            } catch (AbstractMethodError unused) {
                Objects.toString(viewParent);
            }
        }
    }

    private ViewParentCompat() {
    }

    public static void notifySubtreeAccessibilityStateChanged(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i6) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i6);
    }

    public static boolean onNestedFling(@NonNull ViewParent viewParent, @NonNull View view, float f6, float f7, boolean z5) {
        try {
            return Api21Impl.onNestedFling(viewParent, view, f6, f7, z5);
        } catch (AbstractMethodError unused) {
            Objects.toString(viewParent);
            return false;
        }
    }

    public static boolean onNestedPreFling(@NonNull ViewParent viewParent, @NonNull View view, float f6, float f7) {
        try {
            return Api21Impl.onNestedPreFling(viewParent, view, f6, f7);
        } catch (AbstractMethodError unused) {
            Objects.toString(viewParent);
            return false;
        }
    }

    public static void onNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i6, int i7, int i8, int i9, int i10) {
        onNestedScroll(viewParent, view, i6, i7, i8, i9, i10, getTempNestedScrollConsumed());
    }

    @Deprecated
    public static boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void onNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i6, int i7, int i8, int i9, int i10, @NonNull int[] iArr) {
        if (viewParent instanceof NestedScrollingParent3) {
            ((NestedScrollingParent3) viewParent).onNestedScroll(view, i6, i7, i8, i9, i10, iArr);
            return;
        }
        iArr[0] = iArr[0] + i8;
        iArr[1] = iArr[1] + i9;
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScroll(view, i6, i7, i8, i9, i10);
        } else if (i10 == 0) {
            try {
                Api21Impl.onNestedScroll(viewParent, view, i6, i7, i8, i9);
            } catch (AbstractMethodError unused) {
                Objects.toString(viewParent);
            }
        }
    }
}
