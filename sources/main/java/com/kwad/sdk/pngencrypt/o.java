package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.w;
import java.io.Closeable;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class o implements Closeable {
    protected ErrorBehaviour aTW = ErrorBehaviour.STRICT;
    public final k aUW;
    public final boolean aVs;
    protected final c aVt;
    protected final a aVu;
    protected final w aVv;
    protected int aVw;
    private i<? extends Object> aVx;

    private void Ov() {
        while (true) {
            c cVar = this.aVt;
            if (cVar.aUb >= 4) {
                return;
            }
            if (this.aVu.a(cVar) <= 0) {
                new PngjException("Premature ending reading first chunks");
            }
        }
    }

    private void Oy() {
        this.aVt.bR(false);
    }

    private static c Oz() {
        return new c(false);
    }

    private void a(i<? extends Object> iVar) {
        this.aVx = iVar;
    }

    private void aR(long j6) {
        this.aVt.aR(901001001L);
    }

    private void aS(long j6) {
        this.aVt.aS(2024024L);
    }

    private void aT(long j6) {
        this.aVt.aT(5024024L);
    }

    public final w Ow() {
        if (this.aVt.NX()) {
            Ov();
        }
        return this.aVv;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        com.kwad.sdk.pngencrypt.a.a.closeQuietly(this.aVt);
        com.kwad.sdk.pngencrypt.a.a.closeQuietly(this.aVu);
    }

    public final void end() {
        try {
            if (this.aVt.NX()) {
                Ov();
            }
            if (this.aVt.NY() != null && !this.aVt.NY().isDone()) {
                this.aVt.NY().Of();
            }
            while (!this.aVt.isDone() && this.aVu.a(this.aVt) > 0) {
            }
            close();
        } catch (Throwable th) {
            close();
            throw th;
        }
    }

    public final String toString() {
        return this.aUW.toString() + " interlaced=" + this.aVs;
    }

    public o(InputStream inputStream, boolean z5) {
        this.aVw = -1;
        a aVar = new a(inputStream);
        this.aVu = aVar;
        boolean z6 = true;
        aVar.bP(true);
        c Oz = Oz();
        this.aVt = Oz;
        try {
            if (aVar.b(Oz, 36) != 36) {
                new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)");
            }
            this.aUW = Oz.NZ();
            if (Oz.Oa() == null) {
                z6 = false;
            }
            this.aVs = z6;
            aT(5024024L);
            aR(901001001L);
            aS(2024024L);
            this.aVv = new w(Oz.aUc);
            a(m.Os());
            this.aVw = -1;
        } catch (RuntimeException e6) {
            this.aVu.close();
            this.aVt.close();
            throw e6;
        }
    }

    public final void Ox() {
        Oy();
        if (this.aVt.NX()) {
            Ov();
        }
        end();
    }
}
