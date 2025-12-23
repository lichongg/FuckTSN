package com.baidu.idl.main.facesdk.model;

import android.graphics.Bitmap;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BDFaceImageInstance {
    public byte[] data;
    public int height;
    public BDFaceSDKCommon.BDFaceImageType imageType;
    private long index = 0;
    public int width;

    public BDFaceImageInstance(byte[] bArr, int i6, int i7, int i8) {
        this.height = i6;
        this.width = i7;
        this.data = bArr;
        this.imageType = BDFaceSDKCommon.BDFaceImageType.values()[i8];
    }

    private native int create(byte[] bArr, int i6, int i7, int i8, float f6, int i9);

    private native int createInt(int[] iArr, int i6, int i7, int i8, float f6, int i9);

    public native int destory();

    public native BDFaceImageInstance getImage();

    public BDFaceImageInstance(byte[] bArr, int i6, int i7, BDFaceSDKCommon.BDFaceImageType bDFaceImageType, float f6, int i8) {
        if (bArr == null || i6 <= 0 || i7 <= 0) {
            return;
        }
        create(bArr, i6, i7, bDFaceImageType.ordinal(), f6, i8);
    }

    public BDFaceImageInstance(Bitmap bitmap) {
        if (bitmap != null) {
            int[] iArr = new int[bitmap.getWidth() * bitmap.getHeight()];
            bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            createInt(iArr, bitmap.getHeight(), bitmap.getWidth(), BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_BGRA.ordinal(), 0.0f, 0);
        }
    }
}
