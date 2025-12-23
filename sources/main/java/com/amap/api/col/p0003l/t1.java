package com.amap.api.col.p0003l;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.TextOptions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class t1 {

    /* renamed from: a, reason: collision with root package name */
    private static Paint f7255a = new Paint();

    /* renamed from: b, reason: collision with root package name */
    private static Rect f7256b = new Rect();

    public static float a(int i6, boolean z5) {
        if (z5) {
            if (i6 != 1) {
                return i6 != 2 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }
        if (i6 != 8) {
            return i6 != 16 ? 0.5f : 1.0f;
        }
        return 0.0f;
    }

    public static MarkerOptions b(TextOptions textOptions) {
        if (textOptions == null) {
            return null;
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(textOptions.getPosition());
        markerOptions.visible(textOptions.isVisible());
        markerOptions.zIndex(textOptions.getZIndex());
        markerOptions.rotateAngle(textOptions.getRotate());
        markerOptions.icon(c(textOptions));
        markerOptions.anchor(a(textOptions.getAlignX(), true), a(textOptions.getAlignY(), false));
        return markerOptions;
    }

    public static BitmapDescriptor c(TextOptions textOptions) {
        if (textOptions == null) {
            return null;
        }
        f7255a.setTypeface(textOptions.getTypeface());
        f7255a.setSubpixelText(true);
        f7255a.setAntiAlias(true);
        f7255a.setStrokeWidth(5.0f);
        f7255a.setStrokeCap(Paint.Cap.ROUND);
        f7255a.setTextSize(textOptions.getFontSize());
        f7255a.setTextAlign(Paint.Align.CENTER);
        f7255a.setColor(textOptions.getFontColor());
        Paint.FontMetrics fontMetrics = f7255a.getFontMetrics();
        int i6 = (int) (fontMetrics.descent - fontMetrics.ascent);
        int i7 = (int) (((i6 - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
        if (textOptions.getText() != null) {
            f7255a.getTextBounds(textOptions.getText(), 0, textOptions.getText().length(), f7256b);
        }
        Bitmap createBitmap = Bitmap.createBitmap(f7256b.width() + 6, i6, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(textOptions.getBackgroundColor());
        if (textOptions.getText() != null) {
            canvas.drawText(textOptions.getText(), f7256b.centerX() + 3, i7, f7255a);
        }
        return BitmapDescriptorFactory.fromBitmap(createBitmap);
    }
}
