package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
class MultiReader extends Reader {

    @NullableDecl
    private Reader current;
    private final Iterator<? extends CharSource> it;

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Reader reader = this.current;
        if (reader != null) {
            try {
                reader.close();
            } finally {
                this.current = null;
            }
        }
    }

    @Override // java.io.Reader
    public int read(@NullableDecl char[] cArr, int i6, int i7) throws IOException {
        Reader reader = this.current;
        if (reader == null) {
            return -1;
        }
        int read = reader.read(cArr, i6, i7);
        if (read != -1) {
            return read;
        }
        advance();
        return read(cArr, i6, i7);
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        Reader reader = this.current;
        return reader != null && reader.ready();
    }

    @Override // java.io.Reader
    public long skip(long j6) throws IOException {
        Preconditions.checkArgument(j6 >= 0, "n is negative");
        if (j6 > 0) {
            while (true) {
                Reader reader = this.current;
                if (reader == null) {
                    break;
                }
                long skip = reader.skip(j6);
                if (skip > 0) {
                    return skip;
                }
                advance();
            }
        }
        return 0L;
    }

    MultiReader(Iterator<? extends CharSource> it) throws IOException {
        this.it = it;
        advance();
    }

    private void advance() throws IOException {
        close();
        if (this.it.hasNext()) {
            this.current = this.it.next().openStream();
        }
    }
}
