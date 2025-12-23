package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class QPEncoderStream extends FilterOutputStream {
    private static final char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private int bytesPerLine;
    private int count;
    private boolean gotCR;
    private boolean gotSpace;

    public QPEncoderStream(OutputStream outputStream, int i6) {
        super(outputStream);
        this.count = 0;
        this.gotSpace = false;
        this.gotCR = false;
        this.bytesPerLine = i6 - 1;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i6, int i7) throws IOException {
        for (int i8 = 0; i8 < i7; i8++) {
            write(bArr[i6 + i8]);
        }
    }

    private void outputCRLF() throws IOException {
        ((FilterOutputStream) this).out.write(13);
        ((FilterOutputStream) this).out.write(10);
        this.count = 0;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        ((FilterOutputStream) this).out.flush();
    }

    protected void output(int i6, boolean z5) throws IOException {
        if (!z5) {
            int i7 = this.count + 1;
            this.count = i7;
            if (i7 > this.bytesPerLine) {
                ((FilterOutputStream) this).out.write(61);
                ((FilterOutputStream) this).out.write(13);
                ((FilterOutputStream) this).out.write(10);
                this.count = 1;
            }
            ((FilterOutputStream) this).out.write(i6);
            return;
        }
        int i8 = this.count + 3;
        this.count = i8;
        if (i8 > this.bytesPerLine) {
            ((FilterOutputStream) this).out.write(61);
            ((FilterOutputStream) this).out.write(13);
            ((FilterOutputStream) this).out.write(10);
            this.count = 3;
        }
        ((FilterOutputStream) this).out.write(61);
        OutputStream outputStream = ((FilterOutputStream) this).out;
        char[] cArr = hex;
        outputStream.write(cArr[i6 >> 4]);
        ((FilterOutputStream) this).out.write(cArr[i6 & 15]);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i6) throws IOException {
        int i7 = i6 & 255;
        if (this.gotSpace) {
            if (i7 != 13 && i7 != 10) {
                output(32, false);
            } else {
                output(32, true);
            }
            this.gotSpace = false;
        }
        if (i7 == 13) {
            this.gotCR = true;
            outputCRLF();
            return;
        }
        if (i7 == 10) {
            if (!this.gotCR) {
                outputCRLF();
            }
        } else if (i7 == 32) {
            this.gotSpace = true;
        } else if (i7 >= 32 && i7 < 127 && i7 != 61) {
            output(i7, false);
        } else {
            output(i7, true);
        }
        this.gotCR = false;
    }

    public QPEncoderStream(OutputStream outputStream) {
        this(outputStream, 76);
    }
}
