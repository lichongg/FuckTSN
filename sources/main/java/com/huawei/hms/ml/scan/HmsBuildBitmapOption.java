package com.huawei.hms.ml.scan;

import android.graphics.Bitmap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class HmsBuildBitmapOption {
    public static final String TYPE_BUILD_BITMAP_BACKCOLOR = "BitmapBackColor";
    public static final String TYPE_BUILD_BITMAP_COLOR = "BitmapColor";
    public static final String TYPE_BUILD_BITMAP_CONTENT = "BitmapContent";
    public static final String TYPE_BUILD_BITMAP_FOTMAT = "BitmapFormat";
    public static final String TYPE_BUILD_BITMAP_HEIGHT = "BitmapHeight";
    public static final String TYPE_BUILD_BITMAP_MARGIN = "BitmapMargin";
    public static final String TYPE_BUILD_BITMAP_WIDTH = "BitmapWidth";
    public final ErrorCorrectionLevel QRErrorCorrection;
    public final int bimapColor;
    public final int bitmapBackgroundColor;
    public final Bitmap logoBitmap;
    public final int margin;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.huawei.hms.ml.scan.HmsBuildBitmapOption$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Creator {
        private Bitmap logobitmap;
        private int margin = 1;
        private int bimapBackgroundColor = -1;
        private int bimapColor = -1;
        private ErrorCorrectionLevel QRErrorCorrection = ErrorCorrectionLevel.L;

        public HmsBuildBitmapOption create() {
            return new HmsBuildBitmapOption(this.margin, this.bimapColor, this.bimapBackgroundColor, this.QRErrorCorrection, this.logobitmap, null);
        }

        public Creator setBitmapBackgroundColor(int i6) {
            this.bimapBackgroundColor = i6;
            return this;
        }

        public Creator setBitmapColor(int i6) {
            this.bimapColor = i6;
            return this;
        }

        public Creator setBitmapMargin(int i6) {
            this.margin = i6;
            return this;
        }

        public Creator setQRErrorCorrection(ErrorCorrectionLevel errorCorrectionLevel) {
            this.QRErrorCorrection = errorCorrectionLevel;
            return this;
        }

        public Creator setQRLogoBitmap(Bitmap bitmap) {
            this.logobitmap = bitmap;
            return this;
        }
    }

    /* synthetic */ HmsBuildBitmapOption(int i6, int i7, int i8, ErrorCorrectionLevel errorCorrectionLevel, Bitmap bitmap, AnonymousClass1 anonymousClass1) {
        this(i6, i7, i8, errorCorrectionLevel, bitmap);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ErrorCorrectionLevel {
        L("L"),
        M("M"),
        Q("Q"),
        H("H");

        public final String value;

        ErrorCorrectionLevel(String str) {
            this.value = str;
        }
    }

    private HmsBuildBitmapOption(int i6, int i7, int i8, ErrorCorrectionLevel errorCorrectionLevel, Bitmap bitmap) {
        this.margin = i6;
        this.bitmapBackgroundColor = i8;
        this.bimapColor = i7;
        this.QRErrorCorrection = errorCorrectionLevel;
        this.logoBitmap = bitmap;
    }

    public String toString() {
        return "{margin:" + this.margin + ";bitmapBackgroundColor:" + this.bitmapBackgroundColor + ";bimapColor:" + this.bimapColor + "}";
    }
}
