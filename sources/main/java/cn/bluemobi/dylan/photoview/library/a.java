package cn.bluemobi.dylan.photoview.library;

import android.annotation.TargetApi;
import android.view.View;
import androidx.core.view.MotionEventCompat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int f1304a = 16;

    public static int a(int i6) {
        return c(i6);
    }

    @TargetApi(5)
    private static int b(int i6) {
        return (i6 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    @TargetApi(11)
    private static int c(int i6) {
        return (i6 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    public static void d(View view, Runnable runnable) {
        e(view, runnable);
    }

    @TargetApi(16)
    private static void e(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
