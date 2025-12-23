package com.autonavi.base.amap.mapcore.tools;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.amap.api.col.p0003l.b3;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TextTextureGenerator {
    private static final int ALIGNCENTER = 51;
    private static final int ALIGNLEFT = 49;
    private static final int ALIGNRIGHT = 50;
    static final int AN_LABEL_MAXCHARINLINE = 7;
    static final int AN_LABEL_MULITYLINE_SPAN = 2;
    private int TEXT_FONTSIZE = -1;
    private int TEXT_FONTSIZE_TRUE = -1;
    private float base_line = 0.0f;
    private float start_x = 0.0f;
    private Paint text_paint = null;

    public static int GetNearstSize2N(int i6) {
        int i7 = 1;
        while (i6 > i7) {
            i7 *= 2;
        }
        return i7;
    }

    public byte[] getCharsWidths(int[] iArr) {
        int length = iArr.length;
        byte[] bArr = new byte[length];
        for (int i6 = 0; i6 < length; i6++) {
            Paint paint = this.text_paint;
            new StringBuilder().append((char) iArr[i6]);
            bArr[i6] = (byte) (new float[]{paint.measureText(r5.toString())}[0] + (this.TEXT_FONTSIZE - this.TEXT_FONTSIZE_TRUE));
        }
        return bArr;
    }

    private void createTextParam() {
        float f6;
        float f7;
        Paint.FontMetrics fontMetrics;
        int i6 = this.TEXT_FONTSIZE - 2;
        this.TEXT_FONTSIZE_TRUE = i6;
        Paint newPaint = newPaint(null, i6, 49);
        this.text_paint = newPaint;
        float f8 = (this.TEXT_FONTSIZE - this.TEXT_FONTSIZE_TRUE) / 2.0f;
        this.start_x = f8;
        try {
            fontMetrics = newPaint.getFontMetrics();
            f6 = fontMetrics.descent;
        } catch (Exception unused) {
            f6 = 7.3242188f;
        }
        try {
            f7 = fontMetrics.ascent;
        } catch (Exception unused2) {
            f7 = -27.832031f;
            this.base_line = ((this.TEXT_FONTSIZE_TRUE - (f6 + f7)) / 2.0f) + f8 + 0.5f;
        }
        this.base_line = ((this.TEXT_FONTSIZE_TRUE - (f6 + f7)) / 2.0f) + f8 + 0.5f;
    }

    private static Paint newPaint(String str, int i6, int i7) {
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(-1);
        textPaint.setTextSize(i6);
        textPaint.setAntiAlias(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        switch (i7) {
            case 49:
                textPaint.setTextAlign(Paint.Align.LEFT);
                break;
            case 50:
                textPaint.setTextAlign(Paint.Align.RIGHT);
                break;
            case 51:
                textPaint.setTextAlign(Paint.Align.CENTER);
                break;
            default:
                textPaint.setTextAlign(Paint.Align.LEFT);
                break;
        }
        return textPaint;
    }

    public byte[] getTextPixelBuffer(int i6, int i7) {
        if (this.TEXT_FONTSIZE != i7) {
            this.TEXT_FONTSIZE = i7;
            createTextParam();
        }
        char c6 = (char) i6;
        try {
            char[] cArr = {c6};
            float f6 = this.base_line;
            int i8 = this.TEXT_FONTSIZE;
            Bitmap createBitmap = Bitmap.createBitmap(i8, i8, Bitmap.Config.ALPHA_8);
            Canvas canvas = new Canvas(createBitmap);
            int i9 = this.TEXT_FONTSIZE;
            byte[] bArr = new byte[i9 * i9];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            float measureText = this.text_paint.measureText(String.valueOf(c6));
            char c7 = cArr[0];
            float f7 = (c7 <= 0 || c7 >= 256) ? f6 : f6 - 1.5f;
            Paint.Align textAlign = this.text_paint.getTextAlign();
            float textSize = this.text_paint.getTextSize();
            float f8 = measureText - this.TEXT_FONTSIZE_TRUE;
            Paint.Align align = Paint.Align.CENTER;
            if (textAlign == align || f8 < 4.0f) {
                canvas.drawText(cArr, 0, 1, this.start_x, f7, this.text_paint);
            } else {
                this.text_paint.setTextAlign(align);
                this.text_paint.setTextSize(this.TEXT_FONTSIZE_TRUE - f8);
                canvas.drawText(cArr, 0, 1, (this.TEXT_FONTSIZE_TRUE - f8) / 2.0f, f7, this.text_paint);
                this.text_paint.setTextAlign(textAlign);
                this.text_paint.setTextSize(textSize);
            }
            createBitmap.copyPixelsToBuffer(wrap);
            b3.B(createBitmap);
            return bArr;
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }

    public TextTextureGenerator() {
        createTextParam();
    }

    public static float getFontHeight(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float getFontlength(Paint paint, String str) {
        return paint.measureText(str);
    }
}
