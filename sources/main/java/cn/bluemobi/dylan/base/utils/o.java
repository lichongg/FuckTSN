package cn.bluemobi.dylan.base.utils;

import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.bumptech.glide.load.resource.bitmap.i0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class o {
    public static void c(Context context, String str, ImageView imageView, int i6) {
        com.bumptech.glide.b.D(context).a(str).b(com.bumptech.glide.request.h.U0(new i0(6)).t(com.bumptech.glide.load.engine.j.f15240b).I0(true)).m1(imageView);
    }

    public static void d(Context context, String str, ImageView imageView, @DrawableRes int i6, @DrawableRes int i7, int i8) {
        com.bumptech.glide.b.D(context).a(str).b(com.bumptech.glide.request.h.U0(new i0(6)).y0(i6).z(i7).t(com.bumptech.glide.load.engine.j.f15240b).I0(true)).m1(imageView);
    }

    public static void a(Context context, String str, ImageView imageView) {
        com.bumptech.glide.b.D(context).a(str).m1(imageView);
    }

    public static void b(Context context, String str, ImageView imageView, @DrawableRes int i6, @DrawableRes int i7) {
        com.bumptech.glide.b.D(context).a(str).y0(i6).z(i7).m1(imageView);
    }

    public static void e(Context context, String str, ImageView imageView) {
        com.bumptech.glide.b.D(context).a(str).b(com.bumptech.glide.request.h.X0().t(com.bumptech.glide.load.engine.j.f15240b).I0(true)).m1(imageView);
    }

    public static void f(Context context, String str, ImageView imageView, @DrawableRes int i6, @DrawableRes int i7) {
        com.bumptech.glide.b.D(context).a(str).b(com.bumptech.glide.request.h.X0().y0(i6).z(i7).t(com.bumptech.glide.load.engine.j.f15240b).I0(true)).m1(imageView);
    }
}
