package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class i extends p {
    private int aUH;
    private int aUI;
    private int aWc;
    private int aWd;
    private int aWe;
    private int aWf;
    private int aWg;

    private void eu(int i6) {
        this.aWe = 0;
    }

    private void ev(int i6) {
        this.aWf = 0;
    }

    private void ew(int i6) {
        this.aWg = 0;
    }

    public i(com.kwad.sdk.pngencrypt.k kVar) {
        super("IHDR", kVar);
        if (kVar != null) {
            OJ();
        }
    }

    private int OF() {
        return this.aWc;
    }

    private int OG() {
        return this.aWd;
    }

    private int OH() {
        return this.aWg;
    }

    private void OJ() {
        eq(this.aUW.aUI);
        er(this.aUW.aUH);
        es(this.aUW.aVa);
        com.kwad.sdk.pngencrypt.k kVar = this.aUW;
        int i6 = kVar.aVc ? 4 : 0;
        if (kVar.aVe) {
            i6++;
        }
        if (!kVar.aVd) {
            i6 += 2;
        }
        et(i6);
        eu(0);
        ev(0);
        ew(0);
    }

    private void OL() {
        if (this.aUI <= 0 || this.aUH <= 0 || this.aWe != 0 || this.aWf != 0) {
            throw new PngjException("bad IHDR: col/row/compmethod/filmethod invalid");
        }
        int i6 = this.aWc;
        if (i6 != 1 && i6 != 2 && i6 != 4 && i6 != 8 && i6 != 16) {
            throw new PngjException("bad IHDR: bitdepth invalid");
        }
        int i7 = this.aWg;
        if (i7 < 0 || i7 > 1) {
            throw new PngjException("bad IHDR: interlace invalid");
        }
        int i8 = this.aWd;
        if (i8 != 0) {
            if (i8 != 6 && i8 != 2) {
                if (i8 == 3) {
                    if (i6 == 16) {
                        throw new PngjException("bad IHDR: bitdepth invalid");
                    }
                    return;
                } else if (i8 != 4) {
                    throw new PngjException("bad IHDR: invalid colormodel");
                }
            }
            if (i6 != 8 && i6 != 16) {
                throw new PngjException("bad IHDR: bitdepth invalid");
            }
        }
    }

    private int Ol() {
        return this.aUH;
    }

    private int Om() {
        return this.aUI;
    }

    private void eq(int i6) {
        this.aUI = i6;
    }

    private void er(int i6) {
        this.aUH = i6;
    }

    private void es(int i6) {
        this.aWc = i6;
    }

    private void et(int i6) {
        this.aWd = i6;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 13) {
            throw new PngjException("Bad IDHR len " + dVar.len);
        }
        ByteArrayInputStream OB = dVar.OB();
        this.aUI = com.kwad.sdk.pngencrypt.n.f(OB);
        this.aUH = com.kwad.sdk.pngencrypt.n.f(OB);
        this.aWc = com.kwad.sdk.pngencrypt.n.e(OB);
        this.aWd = com.kwad.sdk.pngencrypt.n.e(OB);
        this.aWe = com.kwad.sdk.pngencrypt.n.e(OB);
        this.aWf = com.kwad.sdk.pngencrypt.n.e(OB);
        this.aWg = com.kwad.sdk.pngencrypt.n.e(OB);
    }

    public final boolean OI() {
        if (OH() == 1) {
            return true;
        }
        return false;
    }

    public final com.kwad.sdk.pngencrypt.k OK() {
        boolean z5;
        boolean z6;
        boolean z7;
        OL();
        if ((OG() & 4) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if ((OG() & 1) != 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (OG() != 0 && OG() != 4) {
            z7 = false;
        } else {
            z7 = true;
        }
        return new com.kwad.sdk.pngencrypt.k(Om(), Ol(), OF(), z5, z7, z6);
    }
}
