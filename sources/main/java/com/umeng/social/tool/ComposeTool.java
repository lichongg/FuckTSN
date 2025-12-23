package com.umeng.social.tool;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.core.view.ViewCompat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ComposeTool {
    public static ComposeDirection direction = ComposeDirection.CUSTOM;
    public static int textColor = ViewCompat.MEASURED_STATE_MASK;
    public static int textsize = 18;
    public static int backgroundColor = -1;
    public static Typeface typeface = Typeface.DEFAULT;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ComposeDirection {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        LEFTUP,
        LEFTDOWN,
        RIGHTUP,
        RIGHTDOWN,
        CUSTOM
    }

    public static Bitmap createCompose(Bitmap bitmap, Bitmap bitmap2, boolean z5, int i6) {
        if (bitmap == null || bitmap2 == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(z5 ? Math.max(width, width2) : width2 + width + i6, z5 ? height2 + height + i6 : Math.max(height, height2), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        if (z5) {
            canvas.drawBitmap(bitmap2, 0.0f, height + i6, (Paint) null);
            return createBitmap;
        }
        canvas.drawBitmap(bitmap2, width + i6, 0.0f, (Paint) null);
        return createBitmap;
    }

    public static Bitmap createWaterMask(Bitmap bitmap, Bitmap bitmap2, int i6, int i7) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int i8 = (width / 2) - (width2 / 2);
        int height2 = (height / 2) - (bitmap2.getHeight() / 2);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        if (direction == ComposeDirection.CUSTOM) {
            canvas.drawBitmap(bitmap2, i6, i7, (Paint) null);
            return createBitmap;
        }
        if (direction == ComposeDirection.UP) {
            canvas.drawBitmap(bitmap2, i8, 0.0f, (Paint) null);
            return createBitmap;
        }
        if (direction == ComposeDirection.DOWN) {
            canvas.drawBitmap(bitmap2, i8, height - r4, (Paint) null);
            return createBitmap;
        }
        if (direction == ComposeDirection.LEFT) {
            canvas.drawBitmap(bitmap2, 0.0f, height2, (Paint) null);
            return createBitmap;
        }
        if (direction == ComposeDirection.RIGHT) {
            canvas.drawBitmap(bitmap2, width - width2, height2, (Paint) null);
            return createBitmap;
        }
        if (direction == ComposeDirection.LEFTUP) {
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
            return createBitmap;
        }
        if (direction == ComposeDirection.LEFTDOWN) {
            canvas.drawBitmap(bitmap2, 0.0f, height - r4, (Paint) null);
            return createBitmap;
        }
        if (direction == ComposeDirection.RIGHTUP) {
            canvas.drawBitmap(bitmap2, width - width2, 0.0f, (Paint) null);
            return createBitmap;
        }
        if (direction == ComposeDirection.RIGHTDOWN) {
            canvas.drawBitmap(bitmap2, width - width2, height - r4, (Paint) null);
        }
        return createBitmap;
    }

    public static Bitmap createTextImage(String str, Bitmap bitmap, int i6, int i7) {
        Bitmap.Config config = bitmap.getConfig();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        TextPaint textPaint = new TextPaint(1);
        textPaint.setColor(textColor);
        textPaint.setTextSize(textsize);
        textPaint.setDither(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTypeface(typeface);
        StaticLayout staticLayout = new StaticLayout(str, textPaint, width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        textPaint.getTextBounds(str, 0, str.length(), new Rect());
        Bitmap copy = bitmap.copy(config, true);
        Bitmap createBitmap = Bitmap.createBitmap(width + (i6 * 2), height + staticLayout.getHeight() + (i7 * 4), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(backgroundColor);
        float f6 = i6;
        canvas.drawBitmap(copy, f6, staticLayout.getHeight() + (i7 * 3), (Paint) null);
        canvas.translate(f6, i7);
        staticLayout.draw(canvas);
        return createBitmap;
    }
}
