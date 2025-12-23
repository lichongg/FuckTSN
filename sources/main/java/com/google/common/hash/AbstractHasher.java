package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@CanIgnoreReturnValue
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class AbstractHasher implements Hasher {
    @Override // com.google.common.hash.PrimitiveSink
    public final Hasher putBoolean(boolean z5) {
        return putByte(z5 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.common.hash.PrimitiveSink
    public Hasher putChar(char c6) {
        putByte((byte) c6);
        putByte((byte) (c6 >>> '\b'));
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink
    public final Hasher putDouble(double d6) {
        return putLong(Double.doubleToRawLongBits(d6));
    }

    @Override // com.google.common.hash.PrimitiveSink
    public final Hasher putFloat(float f6) {
        return putInt(Float.floatToRawIntBits(f6));
    }

    @Override // com.google.common.hash.PrimitiveSink
    public Hasher putInt(int i6) {
        putByte((byte) i6);
        putByte((byte) (i6 >>> 8));
        putByte((byte) (i6 >>> 16));
        putByte((byte) (i6 >>> 24));
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink
    public Hasher putLong(long j6) {
        for (int i6 = 0; i6 < 64; i6 += 8) {
            putByte((byte) (j6 >>> i6));
        }
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink
    public Hasher putShort(short s5) {
        putByte((byte) s5);
        putByte((byte) (s5 >>> 8));
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink
    public Hasher putString(CharSequence charSequence, Charset charset) {
        return putBytes(charSequence.toString().getBytes(charset));
    }

    @Override // com.google.common.hash.PrimitiveSink
    public Hasher putUnencodedChars(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i6 = 0; i6 < length; i6++) {
            putChar(charSequence.charAt(i6));
        }
        return this;
    }

    AbstractHasher() {
    }

    @Override // com.google.common.hash.Hasher
    public <T> Hasher putObject(T t5, Funnel<? super T> funnel) {
        funnel.funnel(t5, this);
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink
    public Hasher putBytes(byte[] bArr) {
        return putBytes(bArr, 0, bArr.length);
    }

    @Override // com.google.common.hash.PrimitiveSink
    public Hasher putBytes(byte[] bArr, int i6, int i7) {
        Preconditions.checkPositionIndexes(i6, i6 + i7, bArr.length);
        for (int i8 = 0; i8 < i7; i8++) {
            putByte(bArr[i6 + i8]);
        }
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink
    public Hasher putBytes(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            putBytes(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.limit());
            return this;
        }
        for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
            putByte(byteBuffer.get());
        }
        return this;
    }
}
