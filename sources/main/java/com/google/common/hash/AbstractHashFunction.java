package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Immutable
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class AbstractHashFunction implements HashFunction {
    @Override // com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr) {
        return hashBytes(bArr, 0, bArr.length);
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashInt(int i6) {
        return newHasher(4).putInt(i6).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i6, int i7) {
        Preconditions.checkPositionIndexes(i6, i6 + i7, bArr.length);
        return newHasher(i7).putBytes(bArr, i6, i7).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashLong(long j6) {
        return newHasher(8).putLong(j6).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher(int i6) {
        Preconditions.checkArgument(i6 >= 0, "expectedInputSize must be >= 0 but was %s", i6);
        return newHasher();
    }

    AbstractHashFunction() {
    }

    @Override // com.google.common.hash.HashFunction
    public <T> HashCode hashObject(T t5, Funnel<? super T> funnel) {
        return newHasher().putObject(t5, funnel).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return newHasher().putString(charSequence, charset).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        return newHasher(charSequence.length() * 2).putUnencodedChars(charSequence).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public HashCode hashBytes(ByteBuffer byteBuffer) {
        return newHasher(byteBuffer.remaining()).putBytes(byteBuffer).hash();
    }
}
