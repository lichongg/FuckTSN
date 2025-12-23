package com.umeng.analytics.pro;

import java.util.BitSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class cw extends ck {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements cs {
        @Override // com.umeng.analytics.pro.cs
        public cq a(de deVar) {
            return new cw(deVar);
        }
    }

    public void a(BitSet bitSet, int i6) throws bx {
        for (byte b6 : b(bitSet, i6)) {
            a(b6);
        }
    }

    public BitSet b(int i6) throws bx {
        int ceil = (int) Math.ceil(i6 / 8.0d);
        byte[] bArr = new byte[ceil];
        for (int i7 = 0; i7 < ceil; i7++) {
            bArr[i7] = u();
        }
        return a(bArr);
    }

    @Override // com.umeng.analytics.pro.cq
    public Class<? extends cy> D() {
        return db.class;
    }

    public cw(de deVar) {
        super(deVar);
    }

    public static BitSet a(byte[] bArr) {
        BitSet bitSet = new BitSet();
        for (int i6 = 0; i6 < bArr.length * 8; i6++) {
            if ((bArr[(bArr.length - (i6 / 8)) - 1] & (1 << (i6 % 8))) > 0) {
                bitSet.set(i6);
            }
        }
        return bitSet;
    }

    public static byte[] b(BitSet bitSet, int i6) {
        int ceil = (int) Math.ceil(i6 / 8.0d);
        byte[] bArr = new byte[ceil];
        for (int i7 = 0; i7 < bitSet.length(); i7++) {
            if (bitSet.get(i7)) {
                int i8 = (ceil - (i7 / 8)) - 1;
                bArr[i8] = (byte) ((1 << (i7 % 8)) | bArr[i8]);
            }
        }
        return bArr;
    }
}
