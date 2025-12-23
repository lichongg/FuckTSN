package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class QPDecoderStream extends FilterInputStream {
    protected byte[] ba;
    protected int spaces;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read;
        int i6 = this.spaces;
        if (i6 > 0) {
            this.spaces = i6 - 1;
            return 32;
        }
        int read2 = ((FilterInputStream) this).in.read();
        if (read2 == 32) {
            while (true) {
                read = ((FilterInputStream) this).in.read();
                if (read != 32) {
                    break;
                }
                this.spaces++;
            }
            if (read == 13 || read == 10 || read == -1) {
                this.spaces = 0;
                return read;
            }
            ((PushbackInputStream) ((FilterInputStream) this).in).unread(read);
            return 32;
        }
        if (read2 == 61) {
            int read3 = ((FilterInputStream) this).in.read();
            if (read3 == 10) {
                return read();
            }
            if (read3 == 13) {
                int read4 = ((FilterInputStream) this).in.read();
                if (read4 != 10) {
                    ((PushbackInputStream) ((FilterInputStream) this).in).unread(read4);
                }
                return read();
            }
            if (read3 == -1) {
                return -1;
            }
            byte[] bArr = this.ba;
            bArr[0] = (byte) read3;
            bArr[1] = (byte) ((FilterInputStream) this).in.read();
            try {
                return ASCIIUtility.parseInt(this.ba, 0, 2, 16);
            } catch (NumberFormatException unused) {
                ((PushbackInputStream) ((FilterInputStream) this).in).unread(this.ba);
            }
        }
        return read2;
    }

    public QPDecoderStream(InputStream inputStream) {
        super(new PushbackInputStream(inputStream, 2));
        this.ba = new byte[2];
        this.spaces = 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return ((FilterInputStream) this).in.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i6, int i7) throws IOException {
        int i8 = 0;
        while (true) {
            if (i8 >= i7) {
                break;
            }
            int read = read();
            if (read != -1) {
                bArr[i6 + i8] = (byte) read;
                i8++;
            } else if (i8 == 0) {
                return -1;
            }
        }
        return i8;
    }
}
