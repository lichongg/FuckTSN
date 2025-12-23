package com.alibaba.fastjson.asm;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Label {
    int inputStackTop;
    Label next;
    int outputStackMax;
    int position;
    private int referenceCount;
    private int[] srcAndRefPositions;
    int status;
    Label successor;

    private void addReference(int i6, int i7) {
        if (this.srcAndRefPositions == null) {
            this.srcAndRefPositions = new int[6];
        }
        int i8 = this.referenceCount;
        int[] iArr = this.srcAndRefPositions;
        if (i8 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.srcAndRefPositions = iArr2;
        }
        int[] iArr3 = this.srcAndRefPositions;
        int i9 = this.referenceCount;
        int i10 = i9 + 1;
        this.referenceCount = i10;
        iArr3[i9] = i6;
        this.referenceCount = i9 + 2;
        iArr3[i10] = i7;
    }

    void put(MethodWriter methodWriter, ByteVector byteVector, int i6) {
        if ((this.status & 2) != 0) {
            byteVector.putShort(this.position - i6);
        } else {
            addReference(i6, byteVector.length);
            byteVector.putShort(-1);
        }
    }

    void resolve(MethodWriter methodWriter, int i6, byte[] bArr) {
        this.status |= 2;
        this.position = i6;
        int i7 = 0;
        while (i7 < this.referenceCount) {
            int[] iArr = this.srcAndRefPositions;
            int i8 = i7 + 1;
            int i9 = iArr[i7];
            i7 += 2;
            int i10 = iArr[i8];
            int i11 = i6 - i9;
            bArr[i10] = (byte) (i11 >>> 8);
            bArr[i10 + 1] = (byte) i11;
        }
    }
}
