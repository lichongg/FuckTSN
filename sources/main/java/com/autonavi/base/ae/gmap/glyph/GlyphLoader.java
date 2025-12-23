package com.autonavi.base.ae.gmap.glyph;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GlyphLoader {
    private static Map<String, Typeface> FontFaceMap = new HashMap();

    private static String decodeUnicode(short s5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append((char) s5);
        return stringBuffer.toString();
    }

    private static native long nativeCreateGlyphLoader();

    private static native void nativeDestroyGlyphLoader(long j6);

    private static FontMetricsRequestParam genFontMetricsParam(byte[] bArr) {
        FontMetricsRequestParam fontMetricsRequestParam = new FontMetricsRequestParam();
        fontMetricsRequestParam.fFontSize = GLConvertUtil.getInt(bArr, 0) * 0.001f;
        fontMetricsRequestParam.nFontStyleCode = GLConvertUtil.getInt(bArr, 4);
        int i6 = 12;
        if (1 == GLConvertUtil.getInt(bArr, 8)) {
            int i7 = GLConvertUtil.getInt(bArr, 12);
            fontMetricsRequestParam.strName = new String(bArr, 16, i7);
            i6 = 16 + i7;
        }
        fontMetricsRequestParam.languageArr = new String(bArr, i6 + 4, GLConvertUtil.getInt(bArr, i6));
        return fontMetricsRequestParam;
    }

    private static GlyphRequestParam genGlyphRequestParam(byte[] bArr) {
        GlyphRequestParam glyphRequestParam = new GlyphRequestParam();
        int i6 = GLConvertUtil.getInt(bArr, 0);
        glyphRequestParam.strBuffer = new String(bArr, 4, i6);
        Font font = new Font();
        font.nFontStyleCode = GLConvertUtil.getInt(bArr, i6 + 4);
        font.nFontSize = GLConvertUtil.getInt(bArr, i6 + 8);
        int i7 = GLConvertUtil.getInt(bArr, i6 + 12);
        int i8 = i6 + 16;
        font.strName = new String(bArr, i8, i7);
        int i9 = i8 + i7;
        FontMetrics fontMetrics = new FontMetrics();
        fontMetrics.fAscent = GLConvertUtil.getInt(bArr, i9) * 0.001f;
        fontMetrics.fDescent = GLConvertUtil.getInt(bArr, i9 + 4) * 0.001f;
        fontMetrics.fLeading = GLConvertUtil.getInt(bArr, i9 + 8) * 0.001f;
        fontMetrics.fHeight = GLConvertUtil.getInt(bArr, i9 + 12) * 0.001f;
        font.fontMetrics = fontMetrics;
        glyphRequestParam.font = font;
        glyphRequestParam.drawingMode = GLConvertUtil.getInt(bArr, i9 + 16);
        glyphRequestParam.strokeWidth = GLConvertUtil.getInt(bArr, i9 + 20) * 0.001f;
        int i10 = i9 + 28;
        glyphRequestParam.languageArr = new String(bArr, i10, GLConvertUtil.getInt(bArr, i9 + 24));
        glyphRequestParam.isEmoji = GLConvertUtil.getInt(bArr, i10);
        glyphRequestParam.isSDF = GLConvertUtil.getInt(bArr, i9 + 32);
        int i11 = i9 + 40;
        if (1 == GLConvertUtil.getInt(bArr, i9 + 36)) {
            GlyphMetrics glyphMetrics = new GlyphMetrics();
            glyphMetrics.nWidth = GLConvertUtil.getInt(bArr, i11);
            glyphMetrics.nHeight = GLConvertUtil.getInt(bArr, i9 + 44);
            glyphMetrics.fLeft = GLConvertUtil.getInt(bArr, i9 + 48) * 0.001f;
            glyphMetrics.fTop = GLConvertUtil.getInt(bArr, i9 + 52) * 0.001f;
            glyphMetrics.fAdvance = GLConvertUtil.getInt(bArr, i9 + 56) * 0.001f;
            glyphRequestParam.fGlyphMetrics = glyphMetrics;
        }
        return glyphRequestParam;
    }

    private static GlyphMetrics loadGlyphMetrics(String str, FontStyle fontStyle, float f6, String str2, boolean z5, float f7, boolean z6, boolean z7) {
        GlyphMetrics glyphMetrics = new GlyphMetrics();
        if (fontStyle == null || TextUtils.isEmpty(str)) {
            return glyphMetrics;
        }
        try {
            if (z6) {
                glyphMetrics.bSuccess = true;
                glyphMetrics.fLeft = 0.0f;
                glyphMetrics.fTop = 0.0f;
                int i6 = (int) f6;
                glyphMetrics.nWidth = i6;
                glyphMetrics.nHeight = i6;
                glyphMetrics.fAdvance = f6;
                return glyphMetrics;
            }
            TextPaint newTextPaint = newTextPaint(fontStyle, f6, str2, z5, f7);
            Rect rect = new Rect();
            newTextPaint.getTextBounds(str, 0, str.length(), rect);
            if (rect.width() == 0 && rect.height() == 0) {
                float measureText = newTextPaint.measureText(" ", 0, 1);
                float abs = Math.abs(newTextPaint.getFontMetrics().ascent) + Math.abs(newTextPaint.getFontMetrics().descent);
                rect.top = 0;
                rect.left = 0;
                rect.right = (int) measureText;
                rect.bottom = (int) abs;
            }
            if (z5 && f7 > 0.0f) {
                float f8 = f7 / 2.0f;
                rect.top = (int) (rect.top - f8);
                rect.left = (int) (rect.left - f8);
                rect.right = (int) (rect.right + f8);
                rect.bottom = (int) (rect.bottom + f8);
            }
            glyphMetrics.bSuccess = true;
            glyphMetrics.fLeft = rect.left;
            glyphMetrics.fTop = Math.abs(newTextPaint.getFontMetrics().ascent) - Math.abs(rect.top);
            glyphMetrics.nWidth = rect.width();
            glyphMetrics.nHeight = rect.height();
            glyphMetrics.fAdvance = newTextPaint.measureText(str);
            newTextPaint.setTypeface(null);
            return glyphMetrics;
        } catch (Exception unused) {
            glyphMetrics.bSuccess = false;
            return glyphMetrics;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a9 A[Catch: Exception -> 0x012c, TryCatch #0 {Exception -> 0x012c, blocks: (B:11:0x003b, B:13:0x0052, B:15:0x0058, B:19:0x0084, B:20:0x00a3, B:22:0x00a9, B:29:0x00ba, B:31:0x00f7, B:34:0x00fd, B:36:0x0101, B:38:0x010f, B:41:0x0113, B:43:0x0119, B:44:0x011e, B:45:0x011c, B:47:0x00b2, B:48:0x0128), top: B:10:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f7 A[Catch: Exception -> 0x012c, TryCatch #0 {Exception -> 0x012c, blocks: (B:11:0x003b, B:13:0x0052, B:15:0x0058, B:19:0x0084, B:20:0x00a3, B:22:0x00a9, B:29:0x00ba, B:31:0x00f7, B:34:0x00fd, B:36:0x0101, B:38:0x010f, B:41:0x0113, B:43:0x0119, B:44:0x011e, B:45:0x011c, B:47:0x00b2, B:48:0x0128), top: B:10:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0119 A[Catch: Exception -> 0x012c, TryCatch #0 {Exception -> 0x012c, blocks: (B:11:0x003b, B:13:0x0052, B:15:0x0058, B:19:0x0084, B:20:0x00a3, B:22:0x00a9, B:29:0x00ba, B:31:0x00f7, B:34:0x00fd, B:36:0x0101, B:38:0x010f, B:41:0x0113, B:43:0x0119, B:44:0x011e, B:45:0x011c, B:47:0x00b2, B:48:0x0128), top: B:10:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011c A[Catch: Exception -> 0x012c, TryCatch #0 {Exception -> 0x012c, blocks: (B:11:0x003b, B:13:0x0052, B:15:0x0058, B:19:0x0084, B:20:0x00a3, B:22:0x00a9, B:29:0x00ba, B:31:0x00f7, B:34:0x00fd, B:36:0x0101, B:38:0x010f, B:41:0x0113, B:43:0x0119, B:44:0x011e, B:45:0x011c, B:47:0x00b2, B:48:0x0128), top: B:10:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.autonavi.base.ae.gmap.glyph.GlyphRaster loadGlyphRaster(java.lang.String r8, com.autonavi.base.ae.gmap.glyph.FontStyle r9, float r10, java.lang.String r11, boolean r12, float r13, boolean r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.glyph.GlyphLoader.loadGlyphRaster(java.lang.String, com.autonavi.base.ae.gmap.glyph.FontStyle, float, java.lang.String, boolean, float, boolean, boolean):com.autonavi.base.ae.gmap.glyph.GlyphRaster");
    }

    public static GlyphRaster loadPathRaster(String str, FontStyle fontStyle, float f6, String str2, boolean z5, float f7) {
        GlyphRaster glyphRaster = new GlyphRaster();
        if (fontStyle == null || TextUtils.isEmpty(str)) {
            return glyphRaster;
        }
        try {
            TextPaint newTextPaint = newTextPaint(fontStyle, f6, str2, false, 0.0f);
            Rect rect = new Rect();
            newTextPaint.getTextBounds(str, 0, str.length(), rect);
            int width = rect.width();
            int height = rect.height();
            Bitmap.Config config = Bitmap.Config.ALPHA_8;
            new Canvas(Bitmap.createBitmap(width, height, config)).drawText(str, 0 - rect.left, 0 - rect.top, newTextPaint);
            TextPaint newTextPaint2 = newTextPaint(fontStyle, f6, str2, z5, f7);
            Rect rect2 = new Rect();
            newTextPaint2.getTextBounds(str, 0, str.length(), rect2);
            if (z5 && f7 > 0.0f) {
                float f8 = f7 * 0.5f;
                rect2.top = (int) (rect2.top - f8);
                rect2.left = (int) (rect2.left - f8);
                rect2.right = (int) (rect2.right + f8);
                rect2.bottom = (int) (rect2.bottom + f8);
            }
            if (!rect2.isEmpty()) {
                Bitmap createBitmap = Bitmap.createBitmap(rect2.width(), rect2.height(), config);
                Canvas canvas = new Canvas(createBitmap);
                float f9 = 0 - rect2.left;
                float f10 = 0 - rect2.top;
                Path path = new Path();
                newTextPaint.getTextPath(str, 0, str.length(), f9, f10, path);
                canvas.drawPath(path, newTextPaint2);
                int width2 = rect2.width() * rect2.height();
                byte[] bArr = new byte[width2];
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                glyphRaster.bitmapWidth = rect2.width();
                glyphRaster.bitmapHeight = rect2.height();
                glyphRaster.bitmapPixelMode = 0;
                glyphRaster.bitmapSize = width2;
                createBitmap.copyPixelsToBuffer(wrap);
                createBitmap.recycle();
                glyphRaster.bitmapBuffer = bArr;
                glyphRaster.bSuccess = true;
            }
            newTextPaint.setTypeface(null);
            newTextPaint2.setTypeface(null);
            return glyphRaster;
        } catch (Exception unused) {
            glyphRaster.bSuccess = false;
            return glyphRaster;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0052, code lost:
    
        if (r3 != false) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.text.TextPaint newTextPaint(com.autonavi.base.ae.gmap.glyph.FontStyle r2, float r3, java.lang.String r4, boolean r5, float r6) {
        /*
            android.text.TextPaint r0 = new android.text.TextPaint
            r0.<init>()
            if (r2 != 0) goto L8
            return r0
        L8:
            r1 = -1
            r0.setColor(r1)
            r1 = 1
            r0.setAntiAlias(r1)
            r0.setFilterBitmap(r1)
            r0.setTextSize(r3)
            android.graphics.Paint$Align r3 = android.graphics.Paint.Align.LEFT
            r0.setTextAlign(r3)
            if (r5 == 0) goto L26
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.STROKE
            r0.setStyle(r3)
            r0.setStrokeWidth(r6)
            goto L2b
        L26:
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.FILL
            r0.setStyle(r3)
        L2b:
            int r3 = r2.getSlant()
            r5 = 2
            r6 = 0
            if (r3 == 0) goto L37
            if (r3 == r1) goto L39
            if (r3 == r5) goto L39
        L37:
            r3 = 0
            goto L3a
        L39:
            r3 = 1
        L3a:
            int r2 = r2.getWeight()
            switch(r2) {
                case 0: goto L41;
                case 100: goto L41;
                case 200: goto L41;
                case 300: goto L41;
                case 400: goto L41;
                case 500: goto L43;
                case 600: goto L43;
                case 700: goto L43;
                case 800: goto L43;
                case 900: goto L43;
                case 1000: goto L43;
                default: goto L41;
            }
        L41:
            r2 = 0
            goto L44
        L43:
            r2 = 1
        L44:
            if (r2 == 0) goto L4c
            if (r3 == 0) goto L4c
            r0.setFakeBoldText(r1)
            goto L55
        L4c:
            if (r2 == 0) goto L52
            r0.setFakeBoldText(r1)
            goto L55
        L52:
            if (r3 == 0) goto L55
            goto L56
        L55:
            r5 = 0
        L56:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.NumberFormatException -> L5e
            r3 = 23
            if (r2 < r3) goto L5f
            r1 = 0
            goto L5f
        L5e:
        L5f:
            boolean r2 = r4.isEmpty()
            if (r2 != 0) goto L8c
            if (r1 == 0) goto L68
            goto L8c
        L68:
            java.util.Map<java.lang.String, android.graphics.Typeface> r2 = com.autonavi.base.ae.gmap.glyph.GlyphLoader.FontFaceMap     // Catch: java.lang.Exception -> L85
            monitor-enter(r2)     // Catch: java.lang.Exception -> L85
            java.util.Map<java.lang.String, android.graphics.Typeface> r3 = com.autonavi.base.ae.gmap.glyph.GlyphLoader.FontFaceMap     // Catch: java.lang.Throwable -> L7f
            java.lang.Object r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L7f
            android.graphics.Typeface r3 = (android.graphics.Typeface) r3     // Catch: java.lang.Throwable -> L7f
            if (r3 != 0) goto L81
            android.graphics.Typeface r3 = android.graphics.Typeface.createFromFile(r4)     // Catch: java.lang.Throwable -> L7f
            java.util.Map<java.lang.String, android.graphics.Typeface> r6 = com.autonavi.base.ae.gmap.glyph.GlyphLoader.FontFaceMap     // Catch: java.lang.Throwable -> L7f
            r6.put(r4, r3)     // Catch: java.lang.Throwable -> L7f
            goto L81
        L7f:
            r3 = move-exception
            goto L83
        L81:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L7f
            goto L92
        L83:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L7f
            throw r3     // Catch: java.lang.Exception -> L85
        L85:
            android.graphics.Typeface r2 = android.graphics.Typeface.DEFAULT
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r2, r5)
            goto L92
        L8c:
            android.graphics.Typeface r2 = android.graphics.Typeface.DEFAULT
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r2, r5)
        L92:
            r0.setTypeface(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.glyph.GlyphLoader.newTextPaint(com.autonavi.base.ae.gmap.glyph.FontStyle, float, java.lang.String, boolean, float):android.text.TextPaint");
    }

    public static long createGlyphLoader() {
        return nativeCreateGlyphLoader();
    }

    public static void destroyGlyphLoader(long j6) {
        nativeDestroyGlyphLoader(j6);
    }

    private static FontMetrics getFontMetrics(byte[] bArr) {
        FontMetricsRequestParam genFontMetricsParam = genFontMetricsParam(bArr);
        TextPaint newTextPaint = newTextPaint(new FontStyle(genFontMetricsParam.nFontStyleCode), genFontMetricsParam.fFontSize, genFontMetricsParam.strName, false, 0.0f);
        Paint.FontMetrics fontMetrics = newTextPaint.getFontMetrics();
        FontMetrics fontMetrics2 = new FontMetrics();
        fontMetrics2.bSuccess = true;
        fontMetrics2.fAscent = Math.abs(fontMetrics.ascent);
        fontMetrics2.fDescent = Math.abs(fontMetrics.descent);
        fontMetrics2.fLeading = Math.abs(fontMetrics.leading);
        fontMetrics2.fHeight = Math.abs(fontMetrics.ascent) + Math.abs(fontMetrics.descent);
        newTextPaint.setTypeface(null);
        return fontMetrics2;
    }

    private static GlyphMetrics getGlyphMetrics(byte[] bArr) {
        boolean z5;
        boolean z6;
        GlyphRequestParam genGlyphRequestParam = genGlyphRequestParam(bArr);
        FontStyle fontStyle = new FontStyle(genGlyphRequestParam.font.nFontStyleCode);
        if (genGlyphRequestParam.drawingMode != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        String str = genGlyphRequestParam.strBuffer;
        Font font = genGlyphRequestParam.font;
        float f6 = font.nFontSize;
        String str2 = font.strName;
        boolean z7 = false;
        float f7 = genGlyphRequestParam.strokeWidth;
        if (genGlyphRequestParam.isEmoji > 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (genGlyphRequestParam.isSDF > 0) {
            z7 = true;
        }
        return loadGlyphMetrics(str, fontStyle, f6, str2, z5, f7, z6, z7);
    }

    private static GlyphRaster getGlyphRaster(byte[] bArr) {
        boolean z5;
        boolean z6;
        GlyphRequestParam genGlyphRequestParam = genGlyphRequestParam(bArr);
        FontStyle fontStyle = new FontStyle(genGlyphRequestParam.font.nFontStyleCode);
        int i6 = genGlyphRequestParam.drawingMode;
        if (i6 != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (i6 == 3) {
            return loadPathRaster(genGlyphRequestParam.strBuffer, fontStyle, r2.nFontSize, genGlyphRequestParam.font.strName, z5, 2.0f * genGlyphRequestParam.strokeWidth);
        }
        String str = genGlyphRequestParam.strBuffer;
        Font font = genGlyphRequestParam.font;
        float f6 = font.nFontSize;
        String str2 = font.strName;
        boolean z7 = false;
        float f7 = genGlyphRequestParam.strokeWidth;
        if (genGlyphRequestParam.isEmoji > 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (genGlyphRequestParam.isSDF > 0) {
            z7 = true;
        }
        return loadGlyphRaster(str, fontStyle, f6, str2, z5, f7, z6, z7);
    }

    private static String decodeUnicode(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
