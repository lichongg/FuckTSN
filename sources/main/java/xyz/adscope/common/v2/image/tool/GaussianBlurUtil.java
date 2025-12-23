package xyz.adscope.common.v2.image.tool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class GaussianBlurUtil {
    private static final float BITMAP_SCALE = 0.4f;

    public static Bitmap blurAndAddOverlay(Context context, Bitmap bitmap, float f6) {
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * 0.4f), Math.round(bitmap.getHeight() * 0.4f), false);
        Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
        RenderScript create = RenderScript.create(context);
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
        Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
        Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
        create2.setRadius(f6);
        create2.setInput(createFromBitmap);
        create2.forEach(createFromBitmap2);
        createFromBitmap2.copyTo(createBitmap);
        int width = createBitmap.getWidth();
        int height = createBitmap.getHeight();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap createBitmap2 = Bitmap.createBitmap(width, height, config);
        new Canvas(createBitmap2).drawColor(Color.parseColor("#33000000"));
        Bitmap createBitmap3 = Bitmap.createBitmap(createBitmap.getWidth(), createBitmap.getHeight(), config);
        Canvas canvas = new Canvas(createBitmap3);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
        return createBitmap3;
    }

    public static Bitmap blurBitmap(Context context, Bitmap bitmap, float f6) {
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * 0.4f), Math.round(bitmap.getHeight() * 0.4f), false);
        Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
        RenderScript create = RenderScript.create(context);
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
        Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
        Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
        create2.setRadius(f6);
        create2.setInput(createFromBitmap);
        create2.forEach(createFromBitmap2);
        createFromBitmap2.copyTo(createBitmap);
        return createBitmap;
    }
}
