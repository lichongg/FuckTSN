package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class TraceOutputStream extends FilterOutputStream {
    private boolean quote;
    private boolean trace;
    private OutputStream traceOut;

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i6) throws IOException {
        if (this.trace) {
            if (this.quote) {
                writeByte(i6);
            } else {
                this.traceOut.write(i6);
            }
        }
        ((FilterOutputStream) this).out.write(i6);
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

    public TraceOutputStream(OutputStream outputStream, OutputStream outputStream2) {
        super(outputStream);
        this.trace = false;
        this.quote = false;
        this.traceOut = outputStream2;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i6, int i7) throws IOException {
        if (this.trace) {
            if (this.quote) {
                for (int i8 = 0; i8 < i7; i8++) {
                    writeByte(bArr[i6 + i8]);
                }
            } else {
                this.traceOut.write(bArr, i6, i7);
            }
        }
        ((FilterOutputStream) this).out.write(bArr, i6, i7);
    }
}
