package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j extends t {
    private boolean aWh;
    private String aWi;
    private String aWj;

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        int[] iArr = new int[3];
        int i6 = 0;
        int i7 = 0;
        while (true) {
            byte[] bArr = dVar.data;
            if (i6 >= bArr.length) {
                break;
            }
            if (bArr[i6] == 0) {
                iArr[i7] = i6;
                i7++;
                if (i7 == 1) {
                    i6 += 2;
                }
                if (i7 == 3) {
                    break;
                }
            }
            i6++;
        }
        if (i7 != 3) {
            new PngjException("Bad formed PngChunkITXT chunk");
        }
        this.key = b.c(dVar.data, 0, iArr[0]);
        int i8 = iArr[0];
        byte[] bArr2 = dVar.data;
        boolean z5 = bArr2[i8 + 1] != 0;
        this.aWh = z5;
        int i9 = i8 + 2;
        if (z5 && bArr2[i9] != 0) {
            new PngjException("Bad formed PngChunkITXT chunk - bad compression method ");
        }
        this.aWi = b.c(dVar.data, i9, iArr[1] - i9);
        byte[] bArr3 = dVar.data;
        int i10 = iArr[1];
        this.aWj = b.d(bArr3, i10 + 1, (iArr[2] - i10) - 1);
        int i11 = iArr[2] + 1;
        if (this.aWh) {
            byte[] bArr4 = dVar.data;
            this.aWB = b.i(b.b(bArr4, i11, bArr4.length - i11, false));
        } else {
            byte[] bArr5 = dVar.data;
            this.aWB = b.d(bArr5, i11, bArr5.length - i11);
        }
    }

    public j(com.kwad.sdk.pngencrypt.k kVar) {
        super("iTXt", kVar);
        this.aWh = false;
        this.aWi = "";
        this.aWj = "";
    }
}
