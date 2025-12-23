package com.kwad.sdk.pngencrypt.chunk;

import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f extends e {
    private final List<PngChunk> aVV;

    @Override // com.kwad.sdk.pngencrypt.chunk.e
    public final String toString() {
        return "ChunkList: written: " + OD().size() + " queue: " + this.aVV.size();
    }
}
