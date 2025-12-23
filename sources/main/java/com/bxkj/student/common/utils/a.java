package com.bxkj.student.common.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.utils.u;
import com.bxkj.student.App;
import com.bxkj.student.R;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final C0203a f17792a = new C0203a(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bxkj.student.common.utils.a$a, reason: collision with other inner class name */
    public static final class C0203a {
        public /* synthetic */ C0203a(v vVar) {
            this();
        }

        private C0203a() {
        }

        private final Bitmap c(int i6, Bitmap bitmap, String str) {
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setTextSize(u.a(15.0f, App.f17573d.a()));
            paint.setColor(i6);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
            paint.getTextBounds(str, 0, str.length(), new Rect());
            canvas.drawText(str, bitmap.getWidth() / 2, bitmap.getHeight() / 2, paint);
            return bitmap;
        }

        @NotNull
        public final Bitmap a(@NotNull String text) {
            g0.p(text, "text");
            Drawable drawable = ContextCompat.getDrawable(App.f17573d.a(), R.mipmap.point_number);
            g0.n(drawable, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
            Bitmap copy = ((BitmapDrawable) drawable).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
            int parseColor = Color.parseColor("#b2b2b2");
            g0.m(copy);
            return c(parseColor, copy, text);
        }

        @NotNull
        public final Bitmap b(@NotNull String text) {
            g0.p(text, "text");
            Drawable drawable = ContextCompat.getDrawable(App.f17573d.a(), R.mipmap.point_ok_nuber);
            g0.n(drawable, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
            Bitmap copy = ((BitmapDrawable) drawable).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
            int parseColor = Color.parseColor("#3ecda1");
            g0.m(copy);
            return c(parseColor, copy, text);
        }
    }
}
