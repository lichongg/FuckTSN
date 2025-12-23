package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
final class CharSequenceReader extends Reader {
    private int mark;
    private int pos;
    private CharSequence seq;

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.seq = null;
    }

    @Override // java.io.Reader
    public synchronized void mark(int i6) throws IOException {
        Preconditions.checkArgument(i6 >= 0, "readAheadLimit (%s) may not be negative", i6);
        checkOpen();
        this.mark = this.pos;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader, java.lang.Readable
    public synchronized int read(CharBuffer charBuffer) throws IOException {
        Preconditions.checkNotNull(charBuffer);
        checkOpen();
        if (!hasRemaining()) {
            return -1;
        }
        int min = Math.min(charBuffer.remaining(), remaining());
        for (int i6 = 0; i6 < min; i6++) {
            CharSequence charSequence = this.seq;
            int i7 = this.pos;
            this.pos = i7 + 1;
            charBuffer.put(charSequence.charAt(i7));
        }
        return min;
    }

    @Override // java.io.Reader
    public synchronized boolean ready() throws IOException {
        checkOpen();
        return true;
    }

    @Override // java.io.Reader
    public synchronized void reset() throws IOException {
        checkOpen();
        this.pos = this.mark;
    }

    @Override // java.io.Reader
    public synchronized long skip(long j6) throws IOException {
        int min;
        Preconditions.checkArgument(j6 >= 0, "n (%s) may not be negative", j6);
        checkOpen();
        min = (int) Math.min(remaining(), j6);
        this.pos += min;
        return min;
    }

    private void checkOpen() throws IOException {
        if (this.seq == null) {
            throw new IOException("reader closed");
        }
    }

    private int remaining() {
        return this.seq.length() - this.pos;
    }

    public CharSequenceReader(CharSequence charSequence) {
        this.seq = (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    private boolean hasRemaining() {
        if (remaining() > 0) {
            return true;
        }
        return false;
    }

    @Override // java.io.Reader
    public synchronized int read() throws IOException {
        char c6;
        checkOpen();
        if (hasRemaining()) {
            CharSequence charSequence = this.seq;
            int i6 = this.pos;
            this.pos = i6 + 1;
            c6 = charSequence.charAt(i6);
        } else {
            c6 = 65535;
        }
        return c6;
    }

    @Override // java.io.Reader
    public synchronized int read(char[] cArr, int i6, int i7) throws IOException {
        Preconditions.checkPositionIndexes(i6, i6 + i7, cArr.length);
        checkOpen();
        if (!hasRemaining()) {
            return -1;
        }
        int min = Math.min(i7, remaining());
        for (int i8 = 0; i8 < min; i8++) {
            CharSequence charSequence = this.seq;
            int i9 = this.pos;
            this.pos = i9 + 1;
            cArr[i6 + i8] = charSequence.charAt(i9);
        }
        return min;
    }
}
