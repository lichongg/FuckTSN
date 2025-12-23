package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@CanIgnoreReturnValue
@Beta
/* loaded from: D:\Downloads\app\classes5.dex */
public interface PrimitiveSink {
    PrimitiveSink putBoolean(boolean z5);

    PrimitiveSink putByte(byte b6);

    PrimitiveSink putBytes(ByteBuffer byteBuffer);

    PrimitiveSink putBytes(byte[] bArr);

    PrimitiveSink putBytes(byte[] bArr, int i6, int i7);

    PrimitiveSink putChar(char c6);

    PrimitiveSink putDouble(double d6);

    PrimitiveSink putFloat(float f6);

    PrimitiveSink putInt(int i6);

    PrimitiveSink putLong(long j6);

    PrimitiveSink putShort(short s5);

    PrimitiveSink putString(CharSequence charSequence, Charset charset);

    PrimitiveSink putUnencodedChars(CharSequence charSequence);
}
