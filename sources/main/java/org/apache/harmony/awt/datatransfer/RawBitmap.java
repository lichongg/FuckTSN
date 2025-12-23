package org.apache.harmony.awt.datatransfer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class RawBitmap {
    public final int bMask;
    public final int bits;
    public final Object buffer;
    public final int gMask;
    public final int height;
    public final int rMask;
    public final int stride;
    public final int width;

    public RawBitmap(int i6, int i7, int i8, int i9, int i10, int i11, int i12, Object obj) {
        this.width = i6;
        this.height = i7;
        this.stride = i8;
        this.bits = i9;
        this.rMask = i10;
        this.gMask = i11;
        this.bMask = i12;
        this.buffer = obj;
    }

    public int[] getHeader() {
        return new int[]{this.width, this.height, this.stride, this.bits, this.rMask, this.gMask, this.bMask};
    }

    public RawBitmap(int[] iArr, Object obj) {
        this.width = iArr[0];
        this.height = iArr[1];
        this.stride = iArr[2];
        this.bits = iArr[3];
        this.rMask = iArr[4];
        this.gMask = iArr[5];
        this.bMask = iArr[6];
        this.buffer = obj;
    }
}
