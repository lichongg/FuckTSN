package com.kwad.sdk.pngencrypt;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int aTC;
    private boolean aTD;
    private long aTE;
    private byte[] buf;
    private boolean eof;
    private int offset;
    private InputStream stream;

    public a(InputStream inputStream) {
        this(inputStream, 16384);
    }

    public final int a(f fVar) {
        return a(fVar, Integer.MAX_VALUE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.eof = true;
        this.buf = null;
        this.aTC = 0;
        this.offset = 0;
        InputStream inputStream = this.stream;
        if (inputStream != null && this.aTD) {
            com.kwad.sdk.pngencrypt.a.a.closeQuietly(inputStream);
        }
        this.stream = null;
    }

    private a(InputStream inputStream, int i6) {
        this.eof = false;
        this.aTD = true;
        this.aTE = 0L;
        this.stream = inputStream;
        this.buf = new byte[16384];
    }

    private void NO() {
        if (this.aTC > 0 || this.eof) {
            return;
        }
        try {
            this.offset = 0;
            int read = this.stream.read(this.buf);
            this.aTC = read;
            if (read == 0) {
                new PngjException("This should not happen: stream.read(buf) returned 0");
            } else if (read < 0) {
                close();
            } else {
                this.aTE += read;
            }
        } catch (IOException e6) {
            new PngjException(e6);
        }
    }

    private int a(f fVar, int i6) {
        NO();
        if (i6 <= 0 || i6 >= this.aTC) {
            i6 = this.aTC;
        }
        if (i6 <= 0) {
            if (!this.eof) {
                new PngjException("This should not happen");
            }
            return fVar.isDone() ? -1 : 0;
        }
        int a6 = fVar.a(this.buf, this.offset, i6);
        if (a6 > 0) {
            this.offset += a6;
            this.aTC -= a6;
        }
        if (a6 > 0) {
            return a6;
        }
        if (!fVar.isDone()) {
            new PngjException("This should not happen!");
        }
        return -1;
    }

    public final int b(f fVar, int i6) {
        int i7 = 36;
        while (i7 > 0) {
            int a6 = a(fVar, i7);
            if (a6 <= 0) {
                return a6;
            }
            i7 -= a6;
        }
        return 36;
    }

    public final void bP(boolean z5) {
        this.aTD = z5;
    }
}
