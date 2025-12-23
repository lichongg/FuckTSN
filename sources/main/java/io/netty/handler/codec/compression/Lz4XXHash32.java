package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import net.jpountz.xxhash.XXHash32;
import net.jpountz.xxhash.XXHashFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class Lz4XXHash32 extends ByteBufChecksum {
    private static final XXHash32 XXHASH32 = XXHashFactory.fastestInstance().hash32();
    private final int seed;
    private boolean used;
    private int value;

    @Override // java.util.zip.Checksum
    public void reset() {
        this.used = false;
    }

    @Override // java.util.zip.Checksum
    public void update(int i6) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        if (this.used) {
            return this.value & 268435455;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i6, int i7) {
        if (this.used) {
            throw new IllegalStateException();
        }
        this.value = XXHASH32.hash(bArr, i6, i7, this.seed);
        this.used = true;
    }

    public Lz4XXHash32(int i6) {
        this.seed = i6;
    }

    @Override // io.netty.handler.codec.compression.ByteBufChecksum
    public void update(ByteBuf byteBuf, int i6, int i7) {
        if (!this.used) {
            if (byteBuf.hasArray()) {
                this.value = XXHASH32.hash(byteBuf.array(), byteBuf.arrayOffset() + i6, i7, this.seed);
            } else {
                this.value = XXHASH32.hash(CompressionUtil.safeNioBuffer(byteBuf, i6, i7), this.seed);
            }
            this.used = true;
            return;
        }
        throw new IllegalStateException();
    }
}
