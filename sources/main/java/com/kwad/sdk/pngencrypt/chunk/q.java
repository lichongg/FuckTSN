package com.kwad.sdk.pngencrypt.chunk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class q extends t {
    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        byte[] bArr;
        int i6 = 0;
        while (true) {
            bArr = dVar.data;
            if (i6 >= bArr.length || bArr[i6] == 0) {
                break;
            } else {
                i6++;
            }
        }
        this.key = b.c(bArr, 0, i6);
        int i7 = i6 + 1;
        byte[] bArr2 = dVar.data;
        this.aWB = i7 < bArr2.length ? b.c(bArr2, i7, bArr2.length - i7) : "";
    }

    public q(com.kwad.sdk.pngencrypt.k kVar) {
        super("tEXt", kVar);
    }
}
