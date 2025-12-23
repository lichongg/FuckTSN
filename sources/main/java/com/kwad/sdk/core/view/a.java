package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends ImageSpan {
    public a(@NonNull Context context, Bitmap bitmap) {
        super(context, bitmap);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(@NonNull Canvas canvas, CharSequence charSequence, int i6, int i7, float f6, int i8, int i9, int i10, @NonNull Paint paint) {
        Drawable drawable = getDrawable();
        canvas.save();
        canvas.translate(f6, (((i10 - i8) - drawable.getBounds().bottom) / 2) + i8);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(@NonNull Paint paint, CharSequence charSequence, int i6, int i7, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getDrawable().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i8 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int i9 = (bounds.bottom - bounds.top) / 2;
            int i10 = i8 / 4;
            int i11 = i9 - i10;
            int i12 = -(i9 + i10);
            fontMetricsInt.ascent = i12;
            fontMetricsInt.top = i12;
            fontMetricsInt.bottom = i11;
            fontMetricsInt.descent = i11;
        }
        return bounds.right;
    }
}
