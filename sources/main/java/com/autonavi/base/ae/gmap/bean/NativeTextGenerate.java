package com.autonavi.base.ae.gmap.bean;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.amap.api.col.p0003l.b3;
import com.amap.api.col.p0003l.d;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class NativeTextGenerate {

    @JBindingExclude
    private static volatile NativeTextGenerate instance;

    @JBindingExclude
    private TextPaint text_paint_bitmap;

    @JBindingExclude
    private TextPaint text_paint_size;

    @JBindingExclude
    private float density = 1.0f;

    @JBindingExclude
    private final int kTextLayoutLeftToRight = 0;

    @JBindingExclude
    private final int kTextLayoutUpToDown = 1;

    @JBindingExclude
    private final int kTextAlignmentCenter = 0;

    @JBindingExclude
    private final int kTextAlignmentLeft = 1;

    @JBindingExclude
    private final int kTextAlignmentRight = 2;

    @JBindingInclude
    BitmapDescriptor getIconBitmap(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] uncompress = FileUtil.uncompress(FileUtil.readFileContentsFromAssetsByPreName(d.f5883f, AMapEngineUtils.MAP_ICONS_ASSETS_NAME, str + "_"));
            if (uncompress != null) {
                return BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeByteArray(uncompress, 0, uncompress.length));
            }
        } catch (Throwable th) {
            b3.D(th);
        }
        return null;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @JBindingInclude
    static class TextGeneratePOIStyleDesc {
        int fontSize = 0;
        int fontColor = 0;
        int fontBorderColor = 0;
        int fontBgColor = 0;
        int boldFont = 0;

        TextGeneratePOIStyleDesc() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @JBindingInclude
    static class TextGenerateTextBitmap {
        byte[] data;
        public int dataId;
        int dataLength;
        double height;
        BitmapDescriptor imageData;
        String text;
        double width;

        TextGenerateTextBitmap() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @JBindingInclude
    static class TextGenerateTextStyle {
        int singleLineCharaterLimit = 7;
        int textAlignment = 0;
        int layoutDirection = 0;

        TextGenerateTextStyle() {
        }
    }

    @JBindingInclude
    public static NativeTextGenerate getInstance() {
        if (instance == null) {
            synchronized (NativeTextGenerate.class) {
                try {
                    if (instance == null) {
                        instance = new NativeTextGenerate();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    @JBindingExclude
    private StaticLayout setPaintStyle(TextPaint textPaint, TextGenerateTextBitmap textGenerateTextBitmap, TextGenerateTextStyle textGenerateTextStyle, TextGeneratePOIStyleDesc textGeneratePOIStyleDesc) {
        if (textGenerateTextBitmap == null || textGenerateTextStyle == null || textGeneratePOIStyleDesc == null) {
            return null;
        }
        float f6 = textGeneratePOIStyleDesc.fontSize * this.density;
        textPaint.setColor(textGeneratePOIStyleDesc.fontColor);
        textPaint.setTextSize(f6);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAntiAlias(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTypeface(textGeneratePOIStyleDesc.boldFont == 1 ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        int i6 = textGenerateTextStyle.textAlignment;
        if (i6 == 0) {
            textPaint.setTextAlign(Paint.Align.CENTER);
        } else if (i6 != 2) {
            textPaint.setTextAlign(Paint.Align.LEFT);
        } else {
            textPaint.setTextAlign(Paint.Align.RIGHT);
        }
        int length = textGenerateTextBitmap.text.length();
        int i7 = textGenerateTextStyle.singleLineCharaterLimit;
        if (length > i7 || length % i7 != 0) {
            int i8 = (length / i7) + 1;
            i7 = (length / i8) + (length % i8 <= 0 ? 0 : 1);
        }
        return new StaticLayout(textGenerateTextBitmap.text, textPaint, (int) (f6 * i7), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
    }

    @JBindingInclude
    void calculateTextBoundSize(TextGenerateTextBitmap textGenerateTextBitmap, TextGenerateTextStyle textGenerateTextStyle, TextGeneratePOIStyleDesc textGeneratePOIStyleDesc) {
        if (textGenerateTextBitmap == null || textGenerateTextStyle == null || textGeneratePOIStyleDesc == null) {
            return;
        }
        StaticLayout paintStyle = setPaintStyle(this.text_paint_size, textGenerateTextBitmap, textGenerateTextStyle, textGeneratePOIStyleDesc);
        float measureText = this.text_paint_size.measureText(textGenerateTextBitmap.text);
        Paint.FontMetrics fontMetrics = this.text_paint_size.getFontMetrics();
        textGenerateTextBitmap.width = measureText;
        textGenerateTextBitmap.height = fontMetrics.descent - fontMetrics.ascent;
        textGenerateTextBitmap.width = paintStyle.getWidth();
        textGenerateTextBitmap.height = paintStyle.getHeight();
    }

    @JBindingInclude
    void generateTextBitmap(TextGenerateTextBitmap textGenerateTextBitmap, TextGenerateTextStyle textGenerateTextStyle, TextGeneratePOIStyleDesc textGeneratePOIStyleDesc) {
        if (textGenerateTextBitmap == null || textGenerateTextStyle == null || textGeneratePOIStyleDesc == null) {
            return;
        }
        StaticLayout paintStyle = setPaintStyle(this.text_paint_bitmap, textGenerateTextBitmap, textGenerateTextStyle, textGeneratePOIStyleDesc);
        Bitmap createBitmap = Bitmap.createBitmap((int) textGenerateTextBitmap.width, (int) textGenerateTextBitmap.height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int i6 = textGenerateTextStyle.textAlignment;
        if (i6 == 0) {
            canvas.translate(((float) textGenerateTextBitmap.width) / 2.0f, 0.0f);
        } else if (i6 == 2) {
            canvas.translate((float) textGenerateTextBitmap.width, 0.0f);
        }
        paintStyle.draw(canvas);
        this.text_paint_bitmap.setStyle(Paint.Style.STROKE);
        this.text_paint_bitmap.setStrokeWidth(1.0f);
        this.text_paint_bitmap.setColor(textGeneratePOIStyleDesc.fontBorderColor);
        paintStyle.draw(canvas);
        int i7 = (int) (textGenerateTextBitmap.width * textGenerateTextBitmap.height * 4.0d);
        textGenerateTextBitmap.dataLength = i7;
        textGenerateTextBitmap.data = new byte[i7];
        textGenerateTextBitmap.dataId = b3.V();
        createBitmap.copyPixelsToBuffer(ByteBuffer.wrap(textGenerateTextBitmap.data));
    }

    @JBindingInclude
    byte[] getMapStyleJsonData() {
        try {
            return FileUtil.uncompress(FileUtil.readFileContentsFromAssets(d.f5883f, "map_custom/terrain/terrainStyle.data"));
        } catch (Throwable th) {
            b3.D(th);
            return null;
        }
    }

    @JBindingExclude
    public void setDensity(float f6) {
        this.density = f6;
    }

    @JBindingExclude
    private NativeTextGenerate() {
        this.text_paint_size = null;
        this.text_paint_bitmap = null;
        this.text_paint_size = new TextPaint();
        this.text_paint_bitmap = new TextPaint();
    }
}
