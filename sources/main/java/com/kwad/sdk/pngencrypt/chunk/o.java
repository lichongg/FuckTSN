package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class o extends p {
    private byte aWs;

    public o(com.kwad.sdk.pngencrypt.k kVar) {
        super("sTER", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len == 1) {
            this.aWs = dVar.data[0];
        } else {
            throw new PngjException("bad chunk length " + dVar);
        }
    }
}
