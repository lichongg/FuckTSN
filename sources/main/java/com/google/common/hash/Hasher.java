package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@CanIgnoreReturnValue
@Beta
/* loaded from: D:\Downloads\app\classes5.dex */
public interface Hasher extends PrimitiveSink {
    HashCode hash();

    @Deprecated
    int hashCode();

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBoolean(boolean z5);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putByte(byte b6);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(ByteBuffer byteBuffer);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(byte[] bArr);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(byte[] bArr, int i6, int i7);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putChar(char c6);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putDouble(double d6);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putFloat(float f6);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putInt(int i6);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putLong(long j6);

    <T> Hasher putObject(T t5, Funnel<? super T> funnel);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putShort(short s5);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putString(CharSequence charSequence, Charset charset);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putUnencodedChars(CharSequence charSequence);
}
