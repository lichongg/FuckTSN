package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import java.io.Closeable;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class b implements f, Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final byte[] aTL;
    private final int aTM;
    private byte[] aTN;
    private int aTO;
    protected boolean aTP;
    protected boolean aTQ;
    private int aTR;
    private long aTS;
    private DeflatedChunksSet aTT;
    private ChunkReader aTU;
    private long aTV;
    private ErrorBehaviour aTW;
    protected boolean closed;

    public b() {
        this(n.Ot());
    }

    protected boolean NR() {
        return true;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public int a(byte[] bArr, int i6, int i7) {
        if (this.closed) {
            return -1;
        }
        if (i7 == 0) {
            return 0;
        }
        if (i7 < 0) {
            new PngjException("This should not happen. Bad length: " + i7);
        }
        if (!this.aTP) {
            int i8 = this.aTM;
            int i9 = this.aTO;
            int i10 = i8 - i9;
            if (i10 <= i7) {
                i7 = i10;
            }
            System.arraycopy(bArr, i6, this.aTN, i9, i7);
            int i11 = this.aTO + i7;
            this.aTO = i11;
            if (i11 == this.aTM) {
                g(this.aTN);
                this.aTO = 0;
                this.aTP = true;
            }
            this.aTS += i7;
            return i7;
        }
        ChunkReader chunkReader = this.aTU;
        if (chunkReader != null && !chunkReader.isDone()) {
            int a6 = this.aTU.a(bArr, i6, i7);
            if (a6 < 0) {
                return -1;
            }
            this.aTS += a6;
            return a6;
        }
        int i12 = this.aTO;
        int i13 = 8 - i12;
        if (i13 <= i7) {
            i7 = i13;
        }
        System.arraycopy(bArr, i6, this.aTN, i12, i7);
        int i14 = this.aTO + i7;
        this.aTO = i14;
        this.aTS += i7;
        if (i14 == 8) {
            this.aTR++;
            c(n.g(this.aTN, 0), com.kwad.sdk.pngencrypt.chunk.b.i(this.aTN, 4), this.aTS - 8);
            this.aTO = 0;
        }
        return i7;
    }

    protected abstract DeflatedChunksSet gt(String str);

    protected boolean gu(String str) {
        return false;
    }

    protected boolean y(int i6, String str) {
        return false;
    }

    private b(byte[] bArr) {
        this.aTN = new byte[8];
        this.aTO = 0;
        this.aTP = false;
        this.aTQ = false;
        this.closed = false;
        this.aTR = 0;
        this.aTS = 0L;
        this.aTW = ErrorBehaviour.STRICT;
        this.aTL = bArr;
        int length = bArr == null ? 0 : bArr.length;
        this.aTM = length;
        this.aTP = length <= 0;
    }

    private static String NU() {
        return "IHDR";
    }

    private static String NV() {
        return "IEND";
    }

    public final long NS() {
        return this.aTS;
    }

    public final DeflatedChunksSet NT() {
        return this.aTT;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        DeflatedChunksSet deflatedChunksSet = this.aTT;
        if (deflatedChunksSet != null) {
            deflatedChunksSet.close();
        }
        this.closed = true;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.aTQ;
    }

    private static void g(byte[] bArr) {
        if (!Arrays.equals(bArr, n.Ot())) {
            new PngjException("Bad signature:" + Arrays.toString(bArr));
        }
    }

    protected void c(int i6, String str, long j6) {
        boolean z5;
        b bVar;
        if (str.length() != 4 || !com.kwad.sdk.pngencrypt.chunk.b.aVM.matcher(str).matches()) {
            new PngjException("Bad chunk id: " + str);
        }
        if (i6 < 0) {
            new PngjException("Bad chunk len: " + i6);
        }
        if (str.equals("IDAT")) {
            this.aTV += i6;
        }
        boolean NR = NR();
        boolean y5 = y(i6, str);
        boolean gu = gu(str);
        DeflatedChunksSet deflatedChunksSet = this.aTT;
        if (deflatedChunksSet != null && !deflatedChunksSet.isClosed()) {
            z5 = this.aTT.gx(str);
        } else {
            z5 = false;
        }
        if (gu && !y5) {
            if (!z5) {
                DeflatedChunksSet deflatedChunksSet2 = this.aTT;
                if (deflatedChunksSet2 != null && !deflatedChunksSet2.isDone()) {
                    new PngjException("new IDAT-like chunk when previous was not done");
                }
                this.aTT = gt(str);
            }
            bVar = this;
            bVar.aTU = new d(i6, str, NR, j6, this.aTT) { // from class: com.kwad.sdk.pngencrypt.b.1
                @Override // com.kwad.sdk.pngencrypt.d, com.kwad.sdk.pngencrypt.ChunkReader
                protected final void NQ() {
                    super.NQ();
                    b.this.a(this);
                }
            };
        } else {
            bVar = this;
            bVar.aTU = bVar.a(str, i6, j6, y5);
        }
        ChunkReader chunkReader = bVar.aTU;
        if (chunkReader != null && !NR) {
            chunkReader.bQ(false);
        }
    }

    private ChunkReader a(String str, int i6, long j6, boolean z5) {
        return new ChunkReader(i6, str, j6, z5 ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.BUFFER) { // from class: com.kwad.sdk.pngencrypt.b.2
            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            protected final void NQ() {
                b.this.a(this);
            }

            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            protected final void a(int i7, byte[] bArr, int i8, int i9) {
                new PngjException("should never happen");
            }
        };
    }

    protected void a(ChunkReader chunkReader) {
        if (this.aTR == 1 && !NU().equals(chunkReader.NP().aoB)) {
            String str = "Bad first chunk: " + chunkReader.NP().aoB + " expected: " + NU();
            if (this.aTW.f36352c < ErrorBehaviour.SUPER_LENIENT.f36352c) {
                new PngjException(str);
            }
        }
        NV();
        if (chunkReader.NP().aoB.equals(NV())) {
            this.aTQ = true;
            close();
        }
    }
}
