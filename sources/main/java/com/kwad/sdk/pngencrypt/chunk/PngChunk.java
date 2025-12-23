package com.kwad.sdk.pngencrypt.chunk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class PngChunk {
    protected final com.kwad.sdk.pngencrypt.k aUW;
    public final boolean aVW;
    public final boolean aVX;
    public final boolean aVY;
    protected d aVZ;
    private boolean aWa = false;
    protected int aWb = -1;
    public final String aoB;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ChunkOrderingConstraint {
        NONE,
        BEFORE_PLTE_AND_IDAT,
        AFTER_PLTE_BEFORE_IDAT,
        AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED,
        BEFORE_IDAT,
        AFTER_IDAT,
        NA;

        public final boolean isOk(int i6, boolean z5) {
            if (this == NONE) {
                return true;
            }
            return this == BEFORE_IDAT ? i6 < 4 : this == BEFORE_PLTE_AND_IDAT ? i6 < 2 : this == AFTER_PLTE_BEFORE_IDAT ? z5 ? i6 < 4 : i6 < 4 && i6 > 2 : this == AFTER_IDAT && i6 > 4;
        }

        public final boolean mustGoAfterIDAT() {
            return this == AFTER_IDAT;
        }

        public final boolean mustGoAfterPLTE() {
            return this == AFTER_PLTE_BEFORE_IDAT || this == AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED;
        }

        public final boolean mustGoBeforeIDAT() {
            return this == BEFORE_IDAT || this == BEFORE_PLTE_AND_IDAT || this == AFTER_PLTE_BEFORE_IDAT;
        }

        public final boolean mustGoBeforePLTE() {
            return this == BEFORE_PLTE_AND_IDAT;
        }
    }

    protected abstract void a(d dVar);

    private long OC() {
        d dVar = this.aVZ;
        if (dVar != null) {
            return dVar.OC();
        }
        return -1L;
    }

    private int OE() {
        d dVar = this.aVZ;
        if (dVar != null) {
            return dVar.len;
        }
        return -1;
    }

    final void b(d dVar) {
        this.aVZ = dVar;
    }

    final void ep(int i6) {
        this.aWb = i6;
    }

    public String toString() {
        return "chunk id= " + this.aoB + " (len=" + OE() + " offset=" + OC() + ")";
    }

    public PngChunk(String str, com.kwad.sdk.pngencrypt.k kVar) {
        this.aoB = str;
        this.aUW = kVar;
        this.aVW = b.gz(str);
        this.aVX = b.gA(str);
        this.aVY = b.gB(str);
    }
}
