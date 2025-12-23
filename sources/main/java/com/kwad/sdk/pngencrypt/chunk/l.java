package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class l extends p {
    private long aWk;
    private long aWl;
    private int aWm;

    public l(com.kwad.sdk.pngencrypt.k kVar) {
        super("oFFs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 9) {
            throw new PngjException("bad chunk length " + dVar);
        }
        long g6 = com.kwad.sdk.pngencrypt.n.g(dVar.data, 0);
        this.aWk = g6;
        if (g6 < 0) {
            this.aWk = g6 + IjkMediaMeta.AV_CH_WIDE_RIGHT;
        }
        long g7 = com.kwad.sdk.pngencrypt.n.g(dVar.data, 4);
        this.aWl = g7;
        if (g7 < 0) {
            this.aWl = g7 + IjkMediaMeta.AV_CH_WIDE_RIGHT;
        }
        this.aWm = com.kwad.sdk.pngencrypt.n.e(dVar.data, 8);
    }
}
