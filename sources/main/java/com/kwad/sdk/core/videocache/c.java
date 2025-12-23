package com.kwad.sdk.core.videocache;

import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class c {
    public final File aKK;
    public final com.kwad.sdk.core.videocache.a.c aKL;
    public final com.kwad.sdk.core.videocache.a.a aKM;
    public final com.kwad.sdk.core.videocache.d.c aKN;
    public final com.kwad.sdk.core.videocache.b.b aKO;
    public final int aKP;
    public final int aKQ;

    final File eG(String str) {
        return new File(this.aKK, this.aKL.generate(str));
    }

    c(File file, com.kwad.sdk.core.videocache.a.c cVar, com.kwad.sdk.core.videocache.a.a aVar, com.kwad.sdk.core.videocache.d.c cVar2, com.kwad.sdk.core.videocache.b.b bVar, int i6, int i7) {
        this.aKK = file;
        this.aKL = cVar;
        this.aKM = aVar;
        this.aKN = cVar2;
        this.aKO = bVar;
        this.aKP = i6;
        this.aKQ = i7;
    }
}
