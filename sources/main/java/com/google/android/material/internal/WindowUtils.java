package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class WindowUtils {
    private static final String TAG = "WindowUtils";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class Api14Impl {
        private static Point getRealSizeForDisplay(Display display) {
            Point point = new Point();
            try {
                Method declaredMethod = Display.class.getDeclaredMethod("getRealSize", Point.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(display, point);
                return point;
            } catch (IllegalAccessException unused) {
                String unused2 = WindowUtils.TAG;
                return point;
            } catch (NoSuchMethodException unused3) {
                String unused4 = WindowUtils.TAG;
                return point;
            } catch (InvocationTargetException unused5) {
                String unused6 = WindowUtils.TAG;
                return point;
            }
        }

        private Api14Impl() {
        }

        @NonNull
        static Rect getCurrentWindowBounds(@NonNull WindowManager windowManager) {
            int i6;
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point realSizeForDisplay = getRealSizeForDisplay(defaultDisplay);
            Rect rect = new Rect();
            int i7 = realSizeForDisplay.x;
            if (i7 != 0 && (i6 = realSizeForDisplay.y) != 0) {
                rect.right = i7;
                rect.bottom = i6;
                return rect;
            }
            defaultDisplay.getRectSize(rect);
            return rect;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(api = 17)
    private static class Api17Impl {
        private Api17Impl() {
        }

        @NonNull
        static Rect getCurrentWindowBounds(@NonNull WindowManager windowManager) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            Rect rect = new Rect();
            rect.right = point.x;
            rect.bottom = point.y;
            return rect;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(api = 30)
    private static class Api30Impl {
        private Api30Impl() {
        }

        @NonNull
        static Rect getCurrentWindowBounds(@NonNull WindowManager windowManager) {
            WindowMetrics currentWindowMetrics;
            Rect bounds;
            currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            bounds = currentWindowMetrics.getBounds();
            return bounds;
        }
    }

    @NonNull
    public static Rect getCurrentWindowBounds(@NonNull Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        return Build.VERSION.SDK_INT >= 30 ? Api30Impl.getCurrentWindowBounds(windowManager) : Api17Impl.getCurrentWindowBounds(windowManager);
    }

    private WindowUtils() {
    }
}
