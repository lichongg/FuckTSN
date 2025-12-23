package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
class AppendableWriter extends Writer {
    private boolean closed;
    private final Appendable target;

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        Appendable appendable = this.target;
        if (appendable instanceof Closeable) {
            ((Closeable) appendable).close();
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i6, int i7) throws IOException {
        checkNotClosed();
        this.target.append(new String(cArr, i6, i7));
    }

    private void checkNotClosed() throws IOException {
        if (this.closed) {
            throw new IOException("Cannot write to a closed writer.");
        }
    }

    AppendableWriter(Appendable appendable) {
        this.target = (Appendable) Preconditions.checkNotNull(appendable);
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        checkNotClosed();
        Appendable appendable = this.target;
        if (appendable instanceof Flushable) {
            ((Flushable) appendable).flush();
        }
    }

    @Override // java.io.Writer
    public void write(int i6) throws IOException {
        checkNotClosed();
        this.target.append((char) i6);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c6) throws IOException {
        checkNotClosed();
        this.target.append(c6);
        return this;
    }

    @Override // java.io.Writer
    public void write(@NullableDecl String str) throws IOException {
        checkNotClosed();
        this.target.append(str);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(@NullableDecl CharSequence charSequence) throws IOException {
        checkNotClosed();
        this.target.append(charSequence);
        return this;
    }

    @Override // java.io.Writer
    public void write(@NullableDecl String str, int i6, int i7) throws IOException {
        checkNotClosed();
        this.target.append(str, i6, i7 + i6);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(@NullableDecl CharSequence charSequence, int i6, int i7) throws IOException {
        checkNotClosed();
        this.target.append(charSequence, i6, i7);
        return this;
    }
}
