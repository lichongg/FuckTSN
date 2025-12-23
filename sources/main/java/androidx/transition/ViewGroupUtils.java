package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class ViewGroupUtils {
    private static Method sGetChildDrawingOrderMethod = null;
    private static boolean sGetChildDrawingOrderMethodFetched = false;
    private static boolean sTryHiddenSuppressLayout = true;

    static int getChildDrawingOrder(@NonNull ViewGroup viewGroup, int i6) {
        int childDrawingOrder;
        if (Build.VERSION.SDK_INT >= 29) {
            childDrawingOrder = viewGroup.getChildDrawingOrder(i6);
            return childDrawingOrder;
        }
        if (!sGetChildDrawingOrderMethodFetched) {
            try {
                Class cls = Integer.TYPE;
                Method declaredMethod = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", cls, cls);
                sGetChildDrawingOrderMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            sGetChildDrawingOrderMethodFetched = true;
        }
        Method method = sGetChildDrawingOrderMethod;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewGroup, Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i6))).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return i6;
    }

    static ViewGroupOverlayImpl getOverlay(@NonNull ViewGroup viewGroup) {
        return new ViewGroupOverlayApi18(viewGroup);
    }

    @RequiresApi(18)
    @SuppressLint({"NewApi"})
    private static void hiddenSuppressLayout(@NonNull ViewGroup viewGroup, boolean z5) {
        if (sTryHiddenSuppressLayout) {
            try {
                viewGroup.suppressLayout(z5);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSuppressLayout = false;
            }
        }
    }

    static void suppressLayout(@NonNull ViewGroup viewGroup, boolean z5) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z5);
        } else {
            hiddenSuppressLayout(viewGroup, z5);
        }
    }

    private ViewGroupUtils() {
    }
}
