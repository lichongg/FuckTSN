package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ViewGroupCompat {
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static int getNestedScrollAxes(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }

        @DoNotInline
        static boolean isTransitionGroup(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        @DoNotInline
        static void setTransitionGroup(ViewGroup viewGroup, boolean z5) {
            viewGroup.setTransitionGroup(z5);
        }
    }

    private ViewGroupCompat() {
    }

    public static int getLayoutMode(@NonNull ViewGroup viewGroup) {
        return viewGroup.getLayoutMode();
    }

    public static int getNestedScrollAxes(@NonNull ViewGroup viewGroup) {
        return Api21Impl.getNestedScrollAxes(viewGroup);
    }

    public static boolean isTransitionGroup(@NonNull ViewGroup viewGroup) {
        return Api21Impl.isTransitionGroup(viewGroup);
    }

    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return viewGroup.onRequestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void setLayoutMode(@NonNull ViewGroup viewGroup, int i6) {
        viewGroup.setLayoutMode(i6);
    }

    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean z5) {
        viewGroup.setMotionEventSplittingEnabled(z5);
    }

    public static void setTransitionGroup(@NonNull ViewGroup viewGroup, boolean z5) {
        Api21Impl.setTransitionGroup(viewGroup, z5);
    }
}
