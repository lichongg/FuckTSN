package com.kwad.sdk.pngencrypt;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class ChunkReader implements f {
    public final ChunkReaderMode aTF;
    private final com.kwad.sdk.pngencrypt.chunk.d aTG;
    private boolean aTJ;
    protected int aTH = 0;
    private int aTI = 0;
    protected ErrorBehaviour aTK = ErrorBehaviour.STRICT;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP
    }

    protected abstract void NQ();

    @Override // com.kwad.sdk.pngencrypt.f
    public final int a(byte[] bArr, int i6, int i7) {
        int i8 = 0;
        if (i7 == 0) {
            return 0;
        }
        if (i7 < 0) {
            new PngjException("negative length??");
        }
        if (this.aTH == 0 && this.aTI == 0 && this.aTJ) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.aTG;
            dVar.e(dVar.aVN, 0, 4);
        }
        com.kwad.sdk.pngencrypt.chunk.d dVar2 = this.aTG;
        int i9 = dVar2.len - this.aTH;
        if (i9 > i7) {
            i9 = i7;
        }
        if (i9 > 0 || this.aTI == 0) {
            if (this.aTJ && this.aTF != ChunkReaderMode.BUFFER && i9 > 0) {
                dVar2.e(bArr, i6, i9);
            }
            ChunkReaderMode chunkReaderMode = this.aTF;
            if (chunkReaderMode == ChunkReaderMode.BUFFER) {
                byte[] bArr2 = this.aTG.data;
                if (bArr2 != bArr && i9 > 0) {
                    System.arraycopy(bArr, i6, bArr2, this.aTH, i9);
                }
            } else if (chunkReaderMode == ChunkReaderMode.PROCESS) {
                a(this.aTH, bArr, i6, i9);
            }
            this.aTH += i9;
            i6 += i9;
            i7 -= i9;
        }
        int i10 = this.aTH;
        com.kwad.sdk.pngencrypt.chunk.d dVar3 = this.aTG;
        if (i10 == dVar3.len) {
            int i11 = this.aTI;
            int i12 = 4 - i11;
            if (i12 <= i7) {
                i7 = i12;
            }
            if (i7 > 0) {
                byte[] bArr3 = dVar3.aVP;
                if (bArr != bArr3) {
                    System.arraycopy(bArr, i6, bArr3, i11, i7);
                }
                int i13 = this.aTI + i7;
                this.aTI = i13;
                if (i13 == 4) {
                    if (this.aTJ) {
                        if (this.aTF == ChunkReaderMode.BUFFER) {
                            com.kwad.sdk.pngencrypt.chunk.d dVar4 = this.aTG;
                            dVar4.e(dVar4.data, 0, dVar4.len);
                        }
                        this.aTG.bS(this.aTK == ErrorBehaviour.STRICT);
                    }
                    NQ();
                }
            }
            i8 = i7;
        }
        if (i9 > 0 || i8 > 0) {
            return i9 + i8;
        }
        return -1;
    }

    protected abstract void a(int i6, byte[] bArr, int i7, int i8);

    public final void bQ(boolean z5) {
        this.aTJ = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChunkReader chunkReader = (ChunkReader) obj;
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.aTG;
        if (dVar == null) {
            if (chunkReader.aTG != null) {
                return false;
            }
        } else if (!dVar.equals(chunkReader.aTG)) {
            return false;
        }
        return true;
    }

    public final com.kwad.sdk.pngencrypt.chunk.d NP() {
        return this.aTG;
    }

    public int hashCode() {
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.aTG;
        return (dVar == null ? 0 : dVar.hashCode()) + 31;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.aTI == 4;
    }

    public String toString() {
        return this.aTG.toString();
    }

    public ChunkReader(int i6, String str, long j6, ChunkReaderMode chunkReaderMode) {
        boolean z5;
        if (chunkReaderMode == null || str.length() != 4 || i6 < 0) {
            new PngjException("Bad chunk paramenters: " + chunkReaderMode);
        }
        this.aTF = chunkReaderMode;
        if (chunkReaderMode == ChunkReaderMode.BUFFER) {
            z5 = true;
        } else {
            z5 = false;
        }
        com.kwad.sdk.pngencrypt.chunk.d dVar = new com.kwad.sdk.pngencrypt.chunk.d(i6, str, z5);
        this.aTG = dVar;
        dVar.aU(j6);
        this.aTJ = chunkReaderMode != ChunkReaderMode.SKIP;
    }
}
