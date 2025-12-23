package com.kwad.sdk.pngencrypt.chunk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class s extends p {
    private int[] aWA;
    private int aWw;
    private int aWx;
    private int aWy;
    private int aWz;

    public s(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.aWA = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.aUW;
        if (kVar.aVd) {
            this.aWw = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
            return;
        }
        if (!kVar.aVe) {
            this.aWx = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
            this.aWy = com.kwad.sdk.pngencrypt.n.f(dVar.data, 2);
            this.aWz = com.kwad.sdk.pngencrypt.n.f(dVar.data, 4);
        } else {
            int length = dVar.data.length;
            this.aWA = new int[length];
            for (int i6 = 0; i6 < length; i6++) {
                this.aWA[i6] = dVar.data[i6] & 255;
            }
        }
    }
}
