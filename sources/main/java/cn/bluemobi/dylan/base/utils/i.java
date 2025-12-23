package cn.bluemobi.dylan.base.utils;

import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Field;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class i {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f1226a;

        /* renamed from: b, reason: collision with root package name */
        public int f1227b;
    }

    public static int a(BitmapFactory.Options options, int i6, int i7) {
        int i8 = options.outWidth;
        int i9 = options.outHeight;
        if (i8 > i6 || i9 > i7) {
            return Math.max(Math.round((i8 * 1.0f) / i6), Math.round((i9 * 1.0f) / i7));
        }
        return 1;
    }

    private static int b(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int i6 = declaredField.getInt(obj);
            if (i6 <= 0 || i6 >= Integer.MAX_VALUE) {
                return 0;
            }
            return i6;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static a c(ImageView imageView) {
        a aVar = new a();
        DisplayMetrics displayMetrics = imageView.getContext().getResources().getDisplayMetrics();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int width = imageView.getWidth();
        if (width <= 0 && layoutParams != null) {
            width = layoutParams.width;
        }
        if (width <= 0) {
            width = b(imageView, "mMaxWidth");
        }
        if (width <= 0) {
            width = displayMetrics.widthPixels;
        }
        int height = imageView.getHeight();
        if (height <= 0 && layoutParams != null) {
            height = layoutParams.height;
        }
        if (height <= 0) {
            height = b(imageView, "mMaxHeight");
        }
        if (height <= 0) {
            height = displayMetrics.heightPixels;
        }
        aVar.f1226a = width;
        aVar.f1227b = height;
        return aVar;
    }
}
