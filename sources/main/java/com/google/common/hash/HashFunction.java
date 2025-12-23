package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Immutable
@Beta
/* loaded from: D:\Downloads\app\classes5.dex */
public interface HashFunction {
    int bits();

    HashCode hashBytes(ByteBuffer byteBuffer);

    HashCode hashBytes(byte[] bArr);

    HashCode hashBytes(byte[] bArr, int i6, int i7);

    HashCode hashInt(int i6);

    HashCode hashLong(long j6);

    <T> HashCode hashObject(T t5, Funnel<? super T> funnel);

    HashCode hashString(CharSequence charSequence, Charset charset);

    HashCode hashUnencodedChars(CharSequence charSequence);

    Hasher newHasher();

    Hasher newHasher(int i6);
}
