package com.huawei.hms.ml.scan;

import android.graphics.Bitmap;
import android.graphics.YuvImage;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class HmsScanFrame {
    private Bitmap bitmap;
    private int height;
    private int width;
    private YuvImage yuvImage;

    public HmsScanFrame(YuvImage yuvImage) {
        if (yuvImage.getYuvData() == null || yuvImage.getYuvFormat() != 17) {
            return;
        }
        this.yuvImage = yuvImage;
        this.width = yuvImage.getWidth();
        this.height = yuvImage.getHeight();
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public YuvImage getYuvImage() {
        return this.yuvImage;
    }

    public HmsScanFrame(Bitmap bitmap) {
        this.bitmap = bitmap;
        if (bitmap == null) {
            return;
        }
        this.width = bitmap.getWidth();
        this.height = bitmap.getHeight();
    }
}
