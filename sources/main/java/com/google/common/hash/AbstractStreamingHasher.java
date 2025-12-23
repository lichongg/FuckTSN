package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@CanIgnoreReturnValue
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class AbstractStreamingHasher extends AbstractHasher {
    private final ByteBuffer buffer;
    private final int bufferSize;
    private final int chunkSize;

    protected AbstractStreamingHasher(int i6) {
        this(i6, i6);
    }

    protected abstract HashCode makeHash();

    protected abstract void process(ByteBuffer byteBuffer);

    protected AbstractStreamingHasher(int i6, int i7) {
        Preconditions.checkArgument(i7 % i6 == 0);
        this.buffer = ByteBuffer.allocate(i7 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.bufferSize = i7;
        this.chunkSize = i6;
    }

    private void munch() {
        this.buffer.flip();
        while (this.buffer.remaining() >= this.chunkSize) {
            process(this.buffer);
        }
        this.buffer.compact();
    }

    private void munchIfFull() {
        if (this.buffer.remaining() < 8) {
            munch();
        }
    }

    @Override // com.google.common.hash.PrimitiveSink
    public final Hasher putByte(byte b6) {
        this.buffer.put(b6);
        munchIfFull();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
    public final Hasher putChar(char c6) {
        this.buffer.putChar(c6);
        munchIfFull();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
    public final Hasher putInt(int i6) {
        this.buffer.putInt(i6);
        munchIfFull();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
    public final Hasher putLong(long j6) {
        this.buffer.putLong(j6);
        munchIfFull();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
    public final Hasher putShort(short s5) {
        this.buffer.putShort(s5);
        munchIfFull();
        return this;
    }

    private Hasher putBytesInternal(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.buffer.remaining()) {
            this.buffer.put(byteBuffer);
            munchIfFull();
            return this;
        }
        int position = this.bufferSize - this.buffer.position();
        for (int i6 = 0; i6 < position; i6++) {
            this.buffer.put(byteBuffer.get());
        }
        munch();
        while (byteBuffer.remaining() >= this.chunkSize) {
            process(byteBuffer);
        }
        this.buffer.put(byteBuffer);
        return this;
    }

    @Override // com.google.common.hash.Hasher
    public final HashCode hash() {
        munch();
        this.buffer.flip();
        if (this.buffer.remaining() > 0) {
            processRemaining(this.buffer);
            ByteBuffer byteBuffer = this.buffer;
            byteBuffer.position(byteBuffer.limit());
        }
        return makeHash();
    }

    protected void processRemaining(ByteBuffer byteBuffer) {
        byteBuffer.position(byteBuffer.limit());
        byteBuffer.limit(this.chunkSize + 7);
        while (true) {
            int position = byteBuffer.position();
            int i6 = this.chunkSize;
            if (position < i6) {
                byteBuffer.putLong(0L);
            } else {
                byteBuffer.limit(i6);
                byteBuffer.flip();
                process(byteBuffer);
                return;
            }
        }
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBytes(byte[] bArr, int i6, int i7) {
        return putBytesInternal(ByteBuffer.wrap(bArr, i6, i7).order(ByteOrder.LITTLE_ENDIAN));
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBytes(ByteBuffer byteBuffer) {
        ByteOrder order = byteBuffer.order();
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            return putBytesInternal(byteBuffer);
        } finally {
            byteBuffer.order(order);
        }
    }
}
