package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class n extends k {
    private String aWp;
    private int aWq;
    private int[] aWr;

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        byte[] bArr;
        int f6;
        int f7;
        int f8;
        int f9;
        int i6;
        int i7 = 0;
        while (true) {
            bArr = dVar.data;
            if (i7 >= bArr.length) {
                i7 = -1;
                break;
            } else if (bArr[i7] == 0) {
                break;
            } else {
                i7++;
            }
        }
        if (i7 <= 0 || i7 > bArr.length - 2) {
            throw new PngjException("bad sPLT chunk: no separator found");
        }
        this.aWp = b.c(bArr, 0, i7);
        int e6 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i7 + 1);
        this.aWq = e6;
        int i8 = i7 + 2;
        int length = (dVar.data.length - i8) / (e6 == 8 ? 6 : 10);
        this.aWr = new int[length * 5];
        int i9 = i8;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            if (this.aWq == 8) {
                f6 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i9);
                f7 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i9 + 1);
                int i12 = i9 + 3;
                f8 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i9 + 2);
                i6 = i9 + 4;
                f9 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i12);
            } else {
                f6 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i9);
                f7 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i9 + 2);
                f8 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i9 + 4);
                f9 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i9 + 6);
                i6 = i9 + 8;
            }
            int f10 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i6);
            i9 = i6 + 2;
            int[] iArr = this.aWr;
            iArr[i10] = f6;
            iArr[i10 + 1] = f7;
            iArr[i10 + 2] = f8;
            int i13 = i10 + 4;
            iArr[i10 + 3] = f9;
            i10 += 5;
            iArr[i13] = f10;
        }
    }

    public n(com.kwad.sdk.pngencrypt.k kVar) {
        super("sPLT", kVar);
    }

    public final String OM() {
        return this.aWp;
    }
}
