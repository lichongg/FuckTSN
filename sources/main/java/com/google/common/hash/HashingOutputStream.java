package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
/* loaded from: D:\Downloads\app\classes5.dex */
public final class HashingOutputStream extends FilterOutputStream {
    private final Hasher hasher;

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i6) throws IOException {
        this.hasher.putByte((byte) i6);
        ((FilterOutputStream) this).out.write(i6);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    public HashCode hash() {
        return this.hasher.hash();
    }

    public HashingOutputStream(HashFunction hashFunction, OutputStream outputStream) {
        super((OutputStream) Preconditions.checkNotNull(outputStream));
        this.hasher = (Hasher) Preconditions.checkNotNull(hashFunction.newHasher());
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i6, int i7) throws IOException {
        this.hasher.putBytes(bArr, i6, i7);
        ((FilterOutputStream) this).out.write(bArr, i6, i7);
    }
}
