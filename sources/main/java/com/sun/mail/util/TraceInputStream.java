package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class TraceInputStream extends FilterInputStream {
    private boolean quote;
    private boolean trace;
    private OutputStream traceOut;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = ((FilterInputStream) this).in.read();
        if (this.trace && read != -1) {
            if (this.quote) {
                writeByte(read);
                return read;
            }
            this.traceOut.write(read);
        }
        return read;
    }

    private final void writeByte(int i6) throws IOException {
        int i7 = i6 & 255;
        if (i7 > 127) {
            this.traceOut.write(77);
            this.traceOut.write(45);
            i7 = i6 & 127;
        }
        if (i7 == 13) {
            this.traceOut.write(92);
            this.traceOut.write(114);
            return;
        }
        if (i7 == 10) {
            this.traceOut.write(92);
            this.traceOut.write(110);
            this.traceOut.write(10);
        } else if (i7 == 9) {
            this.traceOut.write(92);
            this.traceOut.write(116);
        } else if (i7 >= 32) {
            this.traceOut.write(i7);
        } else {
            this.traceOut.write(94);
            this.traceOut.write(i7 + 64);
        }
    }

    public void setQuote(boolean z5) {
        this.quote = z5;
    }

    public void setTrace(boolean z5) {
        this.trace = z5;
    }

    public TraceInputStream(InputStream inputStream, OutputStream outputStream) {
        super(inputStream);
        this.trace = false;
        this.quote = false;
        this.traceOut = outputStream;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i6, int i7) throws IOException {
        int read = ((FilterInputStream) this).in.read(bArr, i6, i7);
        if (this.trace && read != -1) {
            if (this.quote) {
                for (int i8 = 0; i8 < read; i8++) {
                    writeByte(bArr[i6 + i8]);
                }
            } else {
                this.traceOut.write(bArr, i6, read);
            }
        }
        return read;
    }
}
