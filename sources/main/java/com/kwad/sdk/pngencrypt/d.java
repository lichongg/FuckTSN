package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class d extends ChunkReader {
    protected final DeflatedChunksSet aUo;
    protected boolean aUp;
    protected boolean aUq;
    protected byte[] aUr;
    protected int aUs;

    public d(int i6, String str, long j6, DeflatedChunksSet deflatedChunksSet) {
        super(i6, str, j6, ChunkReader.ChunkReaderMode.PROCESS);
        this.aUp = false;
        this.aUq = false;
        this.aUs = -1;
        this.aUo = deflatedChunksSet;
        deflatedChunksSet.a(this);
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    protected void NQ() {
        int g6;
        if (!this.aUq || this.aUs < 0 || (g6 = n.g(this.aUr, 0)) == this.aUs) {
            return;
        }
        new PngjException("bad chunk sequence for fDAT chunk " + g6 + " expected " + this.aUs);
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    protected final void a(int i6, byte[] bArr, int i7, int i8) {
        if (this.aUq && i6 < 4) {
            while (i6 < 4 && i8 > 0) {
                this.aUr[i6] = bArr[i7];
                i6++;
                i7++;
                i8--;
            }
        }
        if (i8 > 0) {
            this.aUo.b(bArr, i7, i8);
            if (this.aUp) {
                System.arraycopy(bArr, i7, NP().data, this.aTH, i8);
            }
        }
    }

    public final void ee(int i6) {
        this.aUs = i6;
    }
}
