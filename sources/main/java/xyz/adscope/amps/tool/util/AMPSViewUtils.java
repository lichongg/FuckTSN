package xyz.adscope.amps.tool.util;

import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSViewUtils {
    public static <T extends View> T findViewByType(ViewGroup viewGroup, Class<T> cls) {
        T t5;
        for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
            View childAt = viewGroup.getChildAt(i6);
            if (cls.isInstance(childAt) && isViewVisibleOnScreen(childAt)) {
                return cls.cast(childAt);
            }
            if ((childAt instanceof ViewGroup) && (t5 = (T) findViewByType((ViewGroup) childAt, cls)) != null) {
                return t5;
            }
        }
        return null;
    }

    public static boolean isViewVisibleOnScreen(View view) {
        if (view == null || !view.isShown()) {
            return false;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return false;
        }
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        return rect.intersects(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }
}
