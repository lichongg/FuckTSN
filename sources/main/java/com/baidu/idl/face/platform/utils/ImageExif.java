package com.baidu.idl.face.platform.utils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ImageExif {
    private static final String TAG = "CameraExif";

    /* JADX WARN: Code restructure failed: missing block: B:32:0x005d, code lost:
    
        if (r8 <= 8) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005f, code lost:
    
        r2 = pack(r10, r1, 4, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0066, code lost:
    
        if (r2 == 1229531648) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006b, code lost:
    
        if (r2 == 1296891946) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006d, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006e, code lost:
    
        if (r2 != 1229531648) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0071, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0072, code lost:
    
        r2 = pack(r10, r1 + 4, 4, r4) + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007b, code lost:
    
        if (r2 < 10) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007d, code lost:
    
        if (r2 <= r8) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0080, code lost:
    
        r1 = r1 + r2;
        r8 = r8 - r2;
        r2 = pack(r10, r1 - 2, 2, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0088, code lost:
    
        r3 = r2 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008a, code lost:
    
        if (r2 <= 0) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008e, code lost:
    
        if (r8 < 12) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0096, code lost:
    
        if (pack(r10, r1, 2, r4) != 274) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00af, code lost:
    
        r1 = r1 + 12;
        r8 = r8 - 12;
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0098, code lost:
    
        r10 = pack(r10, r1 + 8, 2, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x009e, code lost:
    
        if (r10 == 3) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a1, code lost:
    
        if (r10 == 6) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a3, code lost:
    
        if (r10 == 8) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a5, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a6, code lost:
    
        return 270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a9, code lost:
    
        return 90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ac, code lost:
    
        return 180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b5, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x005b, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x005c, code lost:
    
        r8 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getOrientation(byte[] r10) {
        /*
            r0 = 0
            if (r10 != 0) goto L4
            return r0
        L4:
            r1 = 0
        L5:
            int r2 = r1 + 3
            int r3 = r10.length
            r4 = 1
            r5 = 4
            r6 = 8
            r7 = 2
            if (r2 >= r3) goto L5c
            int r2 = r1 + 1
            r3 = r10[r1]
            r8 = 255(0xff, float:3.57E-43)
            r3 = r3 & r8
            if (r3 != r8) goto L5b
            r3 = r10[r2]
            r3 = r3 & r8
            if (r3 != r8) goto L1f
        L1d:
            r1 = r2
            goto L5
        L1f:
            int r2 = r1 + 2
            r8 = 216(0xd8, float:3.03E-43)
            if (r3 == r8) goto L1d
            if (r3 != r4) goto L28
            goto L1d
        L28:
            r8 = 217(0xd9, float:3.04E-43)
            if (r3 == r8) goto L5b
            r8 = 218(0xda, float:3.05E-43)
            if (r3 != r8) goto L31
            goto L5b
        L31:
            int r8 = pack(r10, r2, r7, r0)
            if (r8 < r7) goto L5a
            int r2 = r2 + r8
            int r9 = r10.length
            if (r2 <= r9) goto L3c
            goto L5a
        L3c:
            r9 = 225(0xe1, float:3.15E-43)
            if (r3 != r9) goto L1d
            if (r8 < r6) goto L1d
            int r3 = r1 + 4
            int r3 = pack(r10, r3, r5, r0)
            r9 = 1165519206(0x45786966, float:3974.5874)
            if (r3 != r9) goto L1d
            int r3 = r1 + 8
            int r3 = pack(r10, r3, r7, r0)
            if (r3 != 0) goto L1d
            int r1 = r1 + 10
            int r8 = r8 + (-8)
            goto L5d
        L5a:
            return r0
        L5b:
            r1 = r2
        L5c:
            r8 = 0
        L5d:
            if (r8 <= r6) goto Lb5
            int r2 = pack(r10, r1, r5, r0)
            r3 = 1229531648(0x49492a00, float:823968.0)
            if (r2 == r3) goto L6e
            r9 = 1296891946(0x4d4d002a, float:2.1495875E8)
            if (r2 == r9) goto L6e
            return r0
        L6e:
            if (r2 != r3) goto L71
            goto L72
        L71:
            r4 = 0
        L72:
            int r2 = r1 + 4
            int r2 = pack(r10, r2, r5, r4)
            int r2 = r2 + r7
            r3 = 10
            if (r2 < r3) goto Lb5
            if (r2 <= r8) goto L80
            goto Lb5
        L80:
            int r1 = r1 + r2
            int r8 = r8 - r2
            int r2 = r1 + (-2)
            int r2 = pack(r10, r2, r7, r4)
        L88:
            int r3 = r2 + (-1)
            if (r2 <= 0) goto Lb5
            r2 = 12
            if (r8 < r2) goto Lb5
            int r2 = pack(r10, r1, r7, r4)
            r5 = 274(0x112, float:3.84E-43)
            if (r2 != r5) goto Laf
            int r1 = r1 + r6
            int r10 = pack(r10, r1, r7, r4)
            r1 = 3
            if (r10 == r1) goto Lac
            r1 = 6
            if (r10 == r1) goto La9
            if (r10 == r6) goto La6
            return r0
        La6:
            r10 = 270(0x10e, float:3.78E-43)
            return r10
        La9:
            r10 = 90
            return r10
        Lac:
            r10 = 180(0xb4, float:2.52E-43)
            return r10
        Laf:
            int r1 = r1 + 12
            int r8 = r8 + (-12)
            r2 = r3
            goto L88
        Lb5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.face.platform.utils.ImageExif.getOrientation(byte[]):int");
    }

    private static int pack(byte[] bArr, int i6, int i7, boolean z5) {
        int i8;
        if (z5) {
            i6 += i7 - 1;
            i8 = -1;
        } else {
            i8 = 1;
        }
        int i9 = 0;
        while (true) {
            int i10 = i7 - 1;
            if (i7 <= 0) {
                return i9;
            }
            if (i6 >= 0 && bArr != null && i6 < bArr.length) {
                i9 = (i9 << 8) | (bArr[i6] & 255);
            }
            i6 += i8;
            i7 = i10;
        }
    }
}
