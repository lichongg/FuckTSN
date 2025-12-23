package com.kwad.sdk.pngencrypt.chunk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements com.kwad.sdk.pngencrypt.g {
    boolean aVG;

    public a() {
        this(true);
    }

    @Override // com.kwad.sdk.pngencrypt.g
    public final PngChunk a(d dVar, com.kwad.sdk.pngencrypt.k kVar) {
        PngChunk a6 = a(dVar.aoB, kVar);
        if (a6 == null) {
            a6 = c(dVar.aoB, kVar);
        }
        if (a6 == null) {
            a6 = b(dVar.aoB, kVar);
        }
        a6.b(dVar);
        if (this.aVG && dVar.data != null) {
            a6.a(dVar);
        }
        return a6;
    }

    private a(boolean z5) {
        this.aVG = true;
    }

    private static PngChunk b(String str, com.kwad.sdk.pngencrypt.k kVar) {
        return new u(str, kVar);
    }

    private static PngChunk c(String str, com.kwad.sdk.pngencrypt.k kVar) {
        if (str.equals("oFFs")) {
            return new l(kVar);
        }
        if (str.equals("sTER")) {
            return new o(kVar);
        }
        return null;
    }

    private static PngChunk a(String str, com.kwad.sdk.pngencrypt.k kVar) {
        if (str.equals("IDAT")) {
            return new g(kVar);
        }
        if (str.equals("IHDR")) {
            return new i(kVar);
        }
        if (str.equals("PLTE")) {
            return new m(kVar);
        }
        if (str.equals("IEND")) {
            return new h(kVar);
        }
        if (str.equals("tEXt")) {
            return new q(kVar);
        }
        if (str.equals("iTXt")) {
            return new j(kVar);
        }
        if (str.equals("zTXt")) {
            return new v(kVar);
        }
        if (str.equals("tIME")) {
            return new r(kVar);
        }
        if (str.equals("tRNS")) {
            return new s(kVar);
        }
        if (str.equals("sPLT")) {
            return new n(kVar);
        }
        return null;
    }
}
