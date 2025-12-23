package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {
    public final byte[] aVN;
    private CRC32 aVQ;
    public final String aoB;
    public final int len;
    public byte[] data = null;
    private long aVO = 0;
    public byte[] aVP = new byte[4];

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.aoB;
        if (str == null) {
            if (dVar.aoB != null) {
                return false;
            }
        } else if (!str.equals(dVar.aoB)) {
            return false;
        }
        return this.aVO == dVar.aVO;
    }

    private void OA() {
        byte[] bArr = this.data;
        if (bArr == null || bArr.length < this.len) {
            this.data = new byte[this.len];
        }
    }

    final ByteArrayInputStream OB() {
        return new ByteArrayInputStream(this.data);
    }

    public final long OC() {
        return this.aVO;
    }

    public final void aU(long j6) {
        this.aVO = j6;
    }

    public final void bS(boolean z5) {
        int value = (int) this.aVQ.getValue();
        int g6 = com.kwad.sdk.pngencrypt.n.g(this.aVP, 0);
        if (value != g6) {
            String format = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.aoB, Long.valueOf(this.aVO), Integer.valueOf(g6), Integer.valueOf(value));
            if (z5) {
                new PngjException(format);
            }
        }
    }

    public final void e(byte[] bArr, int i6, int i7) {
        if (this.aVQ == null) {
            this.aVQ = new CRC32();
        }
        this.aVQ.update(bArr, i6, i7);
    }

    public final int hashCode() {
        String str = this.aoB;
        int hashCode = str == null ? 0 : str.hashCode();
        long j6 = this.aVO;
        return ((hashCode + 31) * 31) + ((int) (j6 ^ (j6 >>> 32)));
    }

    public final String toString() {
        return "chunkid=" + b.h(this.aVN) + " len=" + this.len;
    }

    public d(int i6, String str, boolean z5) {
        this.len = i6;
        this.aoB = str;
        this.aVN = b.gy(str);
        for (int i7 = 0; i7 < 4; i7++) {
            byte b6 = this.aVN[i7];
            if (b6 < 65 || b6 > 122 || (b6 > 90 && b6 < 97)) {
                new PngjException("Bad id chunk: must be ascii letters " + str);
            }
        }
        if (z5) {
            OA();
        }
    }
}
