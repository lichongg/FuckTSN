package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class BASE64EncoderStream extends FilterOutputStream {
    private static byte[] newline = {13, 10};
    private static final char[] pem_array = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private byte[] buffer;
    private int bufsize;
    private int bytesPerLine;
    private int count;
    private int lineLimit;
    private boolean noCRLF;
    private byte[] outbuf;

    public BASE64EncoderStream(OutputStream outputStream, int i6) {
        super(outputStream);
        this.bufsize = 0;
        this.count = 0;
        this.noCRLF = false;
        this.buffer = new byte[3];
        if (i6 == Integer.MAX_VALUE || i6 < 4) {
            this.noCRLF = true;
            i6 = 76;
        }
        int i7 = (i6 / 4) * 4;
        this.bytesPerLine = i7;
        this.lineLimit = (i7 / 4) * 3;
        if (this.noCRLF) {
            this.outbuf = new byte[i7];
            return;
        }
        byte[] bArr = new byte[i7 + 2];
        this.outbuf = bArr;
        bArr[i7] = 13;
        bArr[i7 + 1] = 10;
    }

    private void encode() throws IOException {
        int encodedSize = encodedSize(this.bufsize);
        ((FilterOutputStream) this).out.write(encode(this.buffer, 0, this.bufsize, this.outbuf), 0, encodedSize);
        int i6 = this.count + encodedSize;
        this.count = i6;
        if (i6 >= this.bytesPerLine) {
            if (!this.noCRLF) {
                ((FilterOutputStream) this).out.write(newline);
            }
            this.count = 0;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        try {
            flush();
            if (this.count > 0 && !this.noCRLF) {
                ((FilterOutputStream) this).out.write(newline);
                ((FilterOutputStream) this).out.flush();
            }
            ((FilterOutputStream) this).out.close();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        try {
            if (this.bufsize > 0) {
                encode();
                this.bufsize = 0;
            }
            ((FilterOutputStream) this).out.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i6, int i7) throws IOException {
        int i8 = i7 + i6;
        while (this.bufsize != 0 && i6 < i8) {
            try {
                write(bArr[i6]);
                i6++;
            } catch (Throwable th) {
                throw th;
            }
        }
        int i9 = ((this.bytesPerLine - this.count) / 4) * 3;
        int i10 = i6 + i9;
        if (i10 < i8) {
            int encodedSize = encodedSize(i9);
            if (!this.noCRLF) {
                byte[] bArr2 = this.outbuf;
                int i11 = encodedSize + 1;
                bArr2[encodedSize] = 13;
                encodedSize += 2;
                bArr2[i11] = 10;
            }
            ((FilterOutputStream) this).out.write(encode(bArr, i6, i9, this.outbuf), 0, encodedSize);
            this.count = 0;
            i6 = i10;
        }
        while (true) {
            int i12 = this.lineLimit;
            if (i6 + i12 >= i8) {
                break;
            }
            ((FilterOutputStream) this).out.write(encode(bArr, i6, i12, this.outbuf));
            i6 += this.lineLimit;
        }
        if (i6 + 3 < i8) {
            int i13 = ((i8 - i6) / 3) * 3;
            int encodedSize2 = encodedSize(i13);
            ((FilterOutputStream) this).out.write(encode(bArr, i6, i13, this.outbuf), 0, encodedSize2);
            i6 += i13;
            this.count += encodedSize2;
        }
        while (i6 < i8) {
            write(bArr[i6]);
            i6++;
        }
    }

    private static int encodedSize(int i6) {
        return ((i6 + 2) / 3) * 4;
    }

    public static byte[] encode(byte[] bArr) {
        return bArr.length == 0 ? bArr : encode(bArr, 0, bArr.length, null);
    }

    private static byte[] encode(byte[] bArr, int i6, int i7, byte[] bArr2) {
        if (bArr2 == null) {
            bArr2 = new byte[encodedSize(i7)];
        }
        int i8 = 0;
        while (i7 >= 3) {
            int i9 = i6 + 2;
            int i10 = ((bArr[i6 + 1] & 255) | ((bArr[i6] & 255) << 8)) << 8;
            i6 += 3;
            int i11 = i10 | (bArr[i9] & 255);
            char[] cArr = pem_array;
            bArr2[i8 + 3] = (byte) cArr[i11 & 63];
            bArr2[i8 + 2] = (byte) cArr[(i11 >> 6) & 63];
            bArr2[i8 + 1] = (byte) cArr[(i11 >> 12) & 63];
            bArr2[i8] = (byte) cArr[(i11 >> 18) & 63];
            i7 -= 3;
            i8 += 4;
        }
        if (i7 == 1) {
            int i12 = (bArr[i6] & 255) << 4;
            bArr2[i8 + 3] = 61;
            bArr2[i8 + 2] = 61;
            char[] cArr2 = pem_array;
            bArr2[i8 + 1] = (byte) cArr2[i12 & 63];
            bArr2[i8] = (byte) cArr2[(i12 >> 6) & 63];
            return bArr2;
        }
        if (i7 == 2) {
            int i13 = ((bArr[i6 + 1] & 255) | ((bArr[i6] & 255) << 8)) << 2;
            bArr2[i8 + 3] = 61;
            char[] cArr3 = pem_array;
            bArr2[i8 + 2] = (byte) cArr3[i13 & 63];
            bArr2[i8 + 1] = (byte) cArr3[(i13 >> 6) & 63];
            bArr2[i8] = (byte) cArr3[(i13 >> 12) & 63];
        }
        return bArr2;
    }

    public BASE64EncoderStream(OutputStream outputStream) {
        this(outputStream, 76);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(int i6) throws IOException {
        byte[] bArr = this.buffer;
        int i7 = this.bufsize;
        int i8 = i7 + 1;
        this.bufsize = i8;
        bArr[i7] = (byte) i6;
        if (i8 == 3) {
            encode();
            this.bufsize = 0;
        }
    }
}
