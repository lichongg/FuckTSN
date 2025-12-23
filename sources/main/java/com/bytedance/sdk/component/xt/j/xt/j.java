package com.bytedance.sdk.component.xt.j.xt;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class j implements cw, xt, Cloneable, ByteChannel {
    private static final byte[] cw = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: j, reason: collision with root package name */
    m f27321j;
    long xt;

    public String cw() {
        try {
            return j(this.xt, oq.f27325j);
        } catch (EOFException e6) {
            throw new AssertionError(e6);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        long j6 = this.xt;
        if (j6 != jVar.xt) {
            return false;
        }
        long j7 = 0;
        if (j6 == 0) {
            return true;
        }
        m mVar = this.f27321j;
        m mVar2 = jVar.f27321j;
        int i6 = mVar.xt;
        int i7 = mVar2.xt;
        while (j7 < this.xt) {
            long min = Math.min(mVar.cw - i6, mVar2.cw - i7);
            int i8 = 0;
            while (i8 < min) {
                int i9 = i6 + 1;
                int i10 = i7 + 1;
                if (mVar.f27322j[i6] != mVar2.f27322j[i7]) {
                    return false;
                }
                i8++;
                i6 = i9;
                i7 = i10;
            }
            if (i6 == mVar.cw) {
                mVar = mVar.f27323m;
                i6 = mVar.xt;
            }
            if (i7 == mVar2.cw) {
                mVar2 = mVar2.f27323m;
                i7 = mVar2.xt;
            }
            j7 += min;
        }
        return true;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public boolean j() {
        return this.xt == 0;
    }

    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public j clone() {
        j jVar = new j();
        if (this.xt == 0) {
            return jVar;
        }
        m j6 = this.f27321j.j();
        jVar.f27321j = j6;
        j6.ae = j6;
        j6.f27323m = j6;
        m mVar = this.f27321j;
        while (true) {
            mVar = mVar.f27323m;
            if (mVar == this.f27321j) {
                jVar.xt = this.xt;
                return jVar;
            }
            jVar.f27321j.ae.j(mVar.j());
        }
    }

    public byte xt() {
        long j6 = this.xt;
        if (j6 == 0) {
            throw new IllegalStateException("size == 0");
        }
        m mVar = this.f27321j;
        int i6 = mVar.xt;
        int i7 = mVar.cw;
        int i8 = i6 + 1;
        byte b6 = mVar.f27322j[i6];
        this.xt = j6 - 1;
        if (i8 != i7) {
            mVar.xt = i8;
            return b6;
        }
        this.f27321j = mVar.xt();
        ae.j(mVar);
        return b6;
    }

    public int hashCode() {
        m mVar = this.f27321j;
        if (mVar == null) {
            return 0;
        }
        int i6 = 1;
        do {
            int i7 = mVar.cw;
            for (int i8 = mVar.xt; i8 < i7; i8++) {
                i6 = (i6 * 31) + mVar.f27322j[i8];
            }
            mVar = mVar.f27323m;
        } while (mVar != this.f27321j);
        return i6;
    }

    public String j(long j6, Charset charset) throws EOFException {
        oq.j(this.xt, 0L, j6);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j6 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j6)));
        }
        if (j6 == 0) {
            return "";
        }
        m mVar = this.f27321j;
        int i6 = mVar.xt;
        if (i6 + j6 > mVar.cw) {
            return new String(j(j6), charset);
        }
        String str = new String(mVar.f27322j, i6, (int) j6, charset);
        int i7 = (int) (mVar.xt + j6);
        mVar.xt = i7;
        this.xt -= j6;
        if (i7 == mVar.cw) {
            this.f27321j = mVar.xt();
            ae.j(mVar);
        }
        return str;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        m mVar = this.f27321j;
        if (mVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), mVar.cw - mVar.xt);
        byteBuffer.put(mVar.f27322j, mVar.xt, min);
        int i6 = mVar.xt + min;
        mVar.xt = i6;
        this.xt -= min;
        if (i6 == mVar.cw) {
            this.f27321j = mVar.xt();
            ae.j(mVar);
        }
        return min;
    }

    public final r up() {
        long j6 = this.xt;
        if (j6 <= 2147483647L) {
            return r((int) j6);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.xt);
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i6 = remaining;
        while (i6 > 0) {
            m cw2 = cw(1);
            int min = Math.min(i6, 8192 - cw2.cw);
            byteBuffer.get(cw2.f27322j, cw2.cw, min);
            i6 -= min;
            cw2.cw += min;
        }
        this.xt += remaining;
        return remaining;
    }

    m cw(int i6) {
        if (i6 > 0 && i6 <= 8192) {
            m mVar = this.f27321j;
            if (mVar == null) {
                m j6 = ae.j();
                this.f27321j = j6;
                j6.ae = j6;
                j6.f27323m = j6;
                return j6;
            }
            m mVar2 = mVar.ae;
            return (mVar2.cw + i6 > 8192 || !mVar2.up) ? mVar2.j(ae.j()) : mVar2;
        }
        throw new IllegalArgumentException();
    }

    public String toString() {
        return up().toString();
    }

    public final r r(int i6) {
        if (i6 == 0) {
            return r.cw;
        }
        return new tl(this, i6);
    }

    public j xt(byte[] bArr, int i6, int i7) {
        if (bArr != null) {
            long j6 = i7;
            oq.j(bArr.length, i6, j6);
            int i8 = i7 + i6;
            while (i6 < i8) {
                m cw2 = cw(1);
                int min = Math.min(i8 - i6, 8192 - cw2.cw);
                System.arraycopy(bArr, i6, cw2.f27322j, cw2.cw, min);
                i6 += min;
                cw2.cw += min;
            }
            this.xt += j6;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public byte[] j(long j6) throws EOFException {
        oq.j(this.xt, 0L, j6);
        if (j6 <= 2147483647L) {
            byte[] bArr = new byte[(int) j6];
            j(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j6)));
    }

    public void j(byte[] bArr) throws EOFException {
        int i6 = 0;
        while (i6 < bArr.length) {
            int j6 = j(bArr, i6, bArr.length - i6);
            if (j6 == -1) {
                throw new EOFException();
            }
            i6 += j6;
        }
    }

    public j xt(int i6) {
        m cw2 = cw(1);
        byte[] bArr = cw2.f27322j;
        int i7 = cw2.cw;
        cw2.cw = i7 + 1;
        bArr[i7] = (byte) i6;
        this.xt++;
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    public int j(byte[] bArr, int i6, int i7) {
        oq.j(bArr.length, i6, i7);
        m mVar = this.f27321j;
        if (mVar == null) {
            return -1;
        }
        int min = Math.min(i7, mVar.cw - mVar.xt);
        System.arraycopy(mVar.f27322j, mVar.xt, bArr, i6, min);
        int i8 = mVar.xt + min;
        mVar.xt = i8;
        this.xt -= min;
        if (i8 == mVar.cw) {
            this.f27321j = mVar.xt();
            ae.j(mVar);
        }
        return min;
    }

    public j xt(long j6) {
        if (j6 == 0) {
            return xt(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j6)) / 4) + 1;
        m cw2 = cw(numberOfTrailingZeros);
        byte[] bArr = cw2.f27322j;
        int i6 = cw2.cw;
        for (int i7 = (i6 + numberOfTrailingZeros) - 1; i7 >= i6; i7--) {
            bArr[i7] = cw[(int) (15 & j6)];
            j6 >>>= 4;
        }
        cw2.cw += numberOfTrailingZeros;
        this.xt += numberOfTrailingZeros;
        return this;
    }

    public j j(String str) {
        return j(str, 0, str.length());
    }

    public j j(String str, int i6, int i7) {
        char charAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(i6)));
        }
        if (i7 >= i6) {
            if (i7 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i7 + " > " + str.length());
            }
            while (i6 < i7) {
                char charAt2 = str.charAt(i6);
                if (charAt2 < 128) {
                    m cw2 = cw(1);
                    byte[] bArr = cw2.f27322j;
                    int i8 = cw2.cw - i6;
                    int min = Math.min(i7, 8192 - i8);
                    int i9 = i6 + 1;
                    bArr[i6 + i8] = (byte) charAt2;
                    while (true) {
                        i6 = i9;
                        if (i6 >= min || (charAt = str.charAt(i6)) >= 128) {
                            break;
                        }
                        i9 = i6 + 1;
                        bArr[i6 + i8] = (byte) charAt;
                    }
                    int i10 = cw2.cw;
                    int i11 = (i8 + i6) - i10;
                    cw2.cw = i10 + i11;
                    this.xt += i11;
                } else {
                    if (charAt2 < 2048) {
                        xt((charAt2 >> 6) | 192);
                        xt((charAt2 & '?') | 128);
                    } else if (charAt2 >= 55296 && charAt2 <= 57343) {
                        int i12 = i6 + 1;
                        char charAt3 = i12 < i7 ? str.charAt(i12) : (char) 0;
                        if (charAt2 <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                            int i13 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 65536;
                            xt((i13 >> 18) | 240);
                            xt(((i13 >> 12) & 63) | 128);
                            xt(((i13 >> 6) & 63) | 128);
                            xt((i13 & 63) | 128);
                            i6 += 2;
                        } else {
                            xt(63);
                            i6 = i12;
                        }
                    } else {
                        xt((charAt2 >> '\f') | 224);
                        xt(((charAt2 >> 6) & 63) | 128);
                        xt((charAt2 & '?') | 128);
                    }
                    i6++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i7 + " < " + i6);
    }

    public j j(int i6) {
        if (i6 < 128) {
            xt(i6);
            return this;
        }
        if (i6 < 2048) {
            xt((i6 >> 6) | 192);
            xt((i6 & 63) | 128);
            return this;
        }
        if (i6 < 65536) {
            if (i6 >= 55296 && i6 <= 57343) {
                xt(63);
                return this;
            }
            xt((i6 >> 12) | 224);
            xt(((i6 >> 6) & 63) | 128);
            xt((i6 & 63) | 128);
            return this;
        }
        if (i6 <= 1114111) {
            xt((i6 >> 18) | 240);
            xt(((i6 >> 12) & 63) | 128);
            xt(((i6 >> 6) & 63) | 128);
            xt((i6 & 63) | 128);
            return this;
        }
        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i6));
    }

    public j j(String str, int i6, int i7, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i6 < 0) {
            throw new IllegalAccessError("beginIndex < 0: ".concat(String.valueOf(i6)));
        }
        if (i7 >= i6) {
            if (i7 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i7 + " > " + str.length());
            }
            if (charset != null) {
                if (charset.equals(oq.f27325j)) {
                    return j(str, i6, i7);
                }
                byte[] bytes = str.substring(i6, i7).getBytes(charset);
                return xt(bytes, 0, bytes.length);
            }
            throw new IllegalArgumentException("charset == null");
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i7 + " < " + i6);
    }
}
