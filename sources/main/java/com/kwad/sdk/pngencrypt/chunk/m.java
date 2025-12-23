package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class m extends p {
    private int aWn;
    private int[] aWo;

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        ex(dVar.len / 3);
        int i6 = 0;
        for (int i7 = 0; i7 < this.aWn; i7++) {
            byte[] bArr = dVar.data;
            int i8 = bArr[i6] & 255;
            int i9 = i6 + 2;
            int i10 = bArr[i6 + 1] & 255;
            i6 += 3;
            a(i7, i8, i10, bArr[i9] & 255);
        }
    }

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("PLTE", kVar);
        this.aWn = 0;
    }

    private void ex(int i6) {
        this.aWn = i6;
        if (i6 <= 0 || i6 > 256) {
            throw new PngjException("invalid pallette - nentries=" + this.aWn);
        }
        int[] iArr = this.aWo;
        if (iArr == null || iArr.length != i6) {
            this.aWo = new int[i6];
        }
    }

    private void a(int i6, int i7, int i8, int i9) {
        this.aWo[i6] = (i7 << 16) | (i8 << 8) | i9;
    }
}
