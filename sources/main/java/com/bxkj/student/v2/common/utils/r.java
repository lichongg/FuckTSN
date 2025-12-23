package com.bxkj.student.v2.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bxkj.student.R;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final r f20922a = new r();

    @NotNull
    public final Bitmap a(@NotNull Context mContext, @NotNull View view) {
        g0.p(mContext, "mContext");
        g0.p(view, "view");
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        g0.o(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(ContextCompat.getColor(mContext, R.color.color_home_bg));
        view.draw(canvas);
        return createBitmap;
    }

    private r() {
    }
}
