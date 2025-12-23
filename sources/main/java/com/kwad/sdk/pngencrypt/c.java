package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import com.kwad.sdk.pngencrypt.chunk.ChunkLoadBehaviour;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c extends b {
    protected k aTY;
    protected k aTZ;
    protected e aUa;
    protected int aUb = -1;
    protected com.kwad.sdk.pngencrypt.chunk.e aUc = null;
    private long aUe = 0;
    private boolean aUf = true;
    private boolean aUg = false;
    private Set<String> aUh = new HashSet();
    private long aUi = 0;
    private long aUj = 0;
    private long aUk = 0;
    private ChunkLoadBehaviour aUm = ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS;
    protected final boolean aUd = false;
    private g aUl = new com.kwad.sdk.pngencrypt.chunk.a();

    @Override // com.kwad.sdk.pngencrypt.b
    protected final void a(ChunkReader chunkReader) {
        super.a(chunkReader);
        if (chunkReader.NP().aoB.equals("IHDR")) {
            com.kwad.sdk.pngencrypt.chunk.i iVar = new com.kwad.sdk.pngencrypt.chunk.i(null);
            iVar.a(chunkReader.NP());
            k OK = iVar.OK();
            this.aTY = OK;
            this.aTZ = OK;
            if (iVar.OI()) {
                this.aUa = new e(this.aTZ);
            }
            this.aUc = new com.kwad.sdk.pngencrypt.chunk.e(this.aTY);
        }
        ChunkReader.ChunkReaderMode chunkReaderMode = chunkReader.aTF;
        ChunkReader.ChunkReaderMode chunkReaderMode2 = ChunkReader.ChunkReaderMode.BUFFER;
        if (chunkReaderMode == chunkReaderMode2 && gw(chunkReader.NP().aoB)) {
            this.aUe += chunkReader.NP().len;
        }
        if (chunkReader.aTF == chunkReaderMode2 || this.aUg) {
            this.aUc.a(this.aUl.a(chunkReader.NP(), NZ()), this.aUb);
        }
    }

    public final void bR(boolean z5) {
        this.aUf = false;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.pngencrypt.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] aUn;

        static {
            int[] iArr = new int[ChunkLoadBehaviour.values().length];
            aUn = iArr;
            try {
                iArr[ChunkLoadBehaviour.LOAD_CHUNK_IF_SAFE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aUn[ChunkLoadBehaviour.LOAD_CHUNK_NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private int NW() {
        return this.aUb;
    }

    private k Ob() {
        return this.aTZ;
    }

    private void gv(String str) {
        if (str.equals("IHDR")) {
            if (this.aUb < 0) {
                this.aUb = 0;
                return;
            }
            new PngjException("unexpected chunk " + str);
            return;
        }
        if (str.equals("PLTE")) {
            int i6 = this.aUb;
            if (i6 == 0 || i6 == 1) {
                this.aUb = 2;
                return;
            }
            new PngjException("unexpected chunk here " + str);
            return;
        }
        if (str.equals("IDAT")) {
            int i7 = this.aUb;
            if (i7 >= 0 && i7 <= 4) {
                this.aUb = 4;
                return;
            }
            new PngjException("unexpected chunk " + str);
            return;
        }
        if (str.equals("IEND")) {
            if (this.aUb >= 4) {
                this.aUb = 6;
                return;
            }
            new PngjException("unexpected chunk " + str);
            return;
        }
        int i8 = this.aUb;
        if (i8 <= 1) {
            this.aUb = 1;
        } else if (i8 <= 3) {
            this.aUb = 3;
        } else {
            this.aUb = 5;
        }
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final boolean NR() {
        return this.aUf;
    }

    public final k NZ() {
        return this.aTY;
    }

    public final e Oa() {
        return this.aUa;
    }

    public final void aR(long j6) {
        this.aUi = j6;
    }

    public final void aS(long j6) {
        this.aUj = j6;
    }

    public final void aT(long j6) {
        this.aUk = j6;
    }

    @Override // com.kwad.sdk.pngencrypt.b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.aUb != 6) {
            this.aUb = 6;
        }
        super.close();
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final DeflatedChunksSet gt(String str) {
        return new j(str, this.aUd, Ob(), this.aUa);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final boolean gu(String str) {
        return str.equals("IDAT");
    }

    public c(boolean z5) {
    }

    private static boolean gw(String str) {
        if (!com.kwad.sdk.pngencrypt.chunk.b.gz(str)) {
            return true;
        }
        return false;
    }

    public final boolean NX() {
        if (NW() < 4) {
            return true;
        }
        return false;
    }

    public final j NY() {
        DeflatedChunksSet NT = NT();
        if (NT instanceof j) {
            return (j) NT;
        }
        return null;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final void c(int i6, String str, long j6) {
        gv(str);
        super.c(i6, str, j6);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean y(int i6, String str) {
        if (super.y(i6, str)) {
            return true;
        }
        if (this.aUi > 0 && i6 + NS() > this.aUi) {
            new PngjException("Maximum total bytes to read exceeeded: " + this.aUi + " offset:" + NS() + " len=" + i6);
        }
        if (this.aUh.contains(str)) {
            return true;
        }
        if (com.kwad.sdk.pngencrypt.chunk.b.gz(str)) {
            return false;
        }
        long j6 = this.aUj;
        if (j6 > 0 && i6 > j6) {
            return true;
        }
        long j7 = this.aUk;
        if (j7 > 0 && i6 > j7 - this.aUe) {
            return true;
        }
        int i7 = AnonymousClass1.aUn[this.aUm.ordinal()];
        if (i7 != 1) {
            if (i7 == 2) {
                return true;
            }
        } else if (!com.kwad.sdk.pngencrypt.chunk.b.gB(str)) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.pngencrypt.b, com.kwad.sdk.pngencrypt.f
    public final int a(byte[] bArr, int i6, int i7) {
        return super.a(bArr, i6, i7);
    }
}
