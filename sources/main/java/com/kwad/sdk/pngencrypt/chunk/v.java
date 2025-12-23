package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class v extends t {
    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        byte[] bArr;
        int i6 = 0;
        while (true) {
            bArr = dVar.data;
            if (i6 >= bArr.length) {
                i6 = -1;
                break;
            } else if (bArr[i6] == 0) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 < 0 || i6 > bArr.length - 2) {
            new PngjException("bad zTXt chunk: no separator found");
        }
        this.key = b.c(dVar.data, 0, i6);
        if (dVar.data[i6 + 1] != 0) {
            new PngjException("bad zTXt chunk: unknown compression method");
        }
        this.aWB = b.h(b.b(dVar.data, i6 + 2, (r5.length - i6) - 2, false));
    }

    public v(com.kwad.sdk.pngencrypt.k kVar) {
        super("zTXt", kVar);
    }
}
