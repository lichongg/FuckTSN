package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.memcache.AbstractMemcacheObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractBinaryMemcacheMessage extends AbstractMemcacheObject implements BinaryMemcacheMessage {
    private long cas;
    private byte dataType;
    private ByteBuf extras;
    private byte extrasLength;
    private ByteBuf key;
    private short keyLength;
    private byte magic;
    private int opaque;
    private byte opcode;
    private int totalBodyLength;

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public long cas() {
        return this.cas;
    }

    void copyMeta(AbstractBinaryMemcacheMessage abstractBinaryMemcacheMessage) {
        abstractBinaryMemcacheMessage.magic = this.magic;
        abstractBinaryMemcacheMessage.opcode = this.opcode;
        abstractBinaryMemcacheMessage.keyLength = this.keyLength;
        abstractBinaryMemcacheMessage.extrasLength = this.extrasLength;
        abstractBinaryMemcacheMessage.dataType = this.dataType;
        abstractBinaryMemcacheMessage.totalBodyLength = this.totalBodyLength;
        abstractBinaryMemcacheMessage.opaque = this.opaque;
        abstractBinaryMemcacheMessage.cas = this.cas;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public byte dataType() {
        return this.dataType;
    }

    @Override // io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        ByteBuf byteBuf = this.key;
        if (byteBuf != null) {
            byteBuf.release();
        }
        ByteBuf byteBuf2 = this.extras;
        if (byteBuf2 != null) {
            byteBuf2.release();
        }
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public ByteBuf extras() {
        return this.extras;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public byte extrasLength() {
        return this.extrasLength;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public ByteBuf key() {
        return this.key;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public short keyLength() {
        return this.keyLength;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public byte magic() {
        return this.magic;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public int opaque() {
        return this.opaque;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public byte opcode() {
        return this.opcode;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public BinaryMemcacheMessage setCas(long j6) {
        this.cas = j6;
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public BinaryMemcacheMessage setDataType(byte b6) {
        this.dataType = b6;
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public BinaryMemcacheMessage setExtras(ByteBuf byteBuf) {
        ByteBuf byteBuf2 = this.extras;
        if (byteBuf2 != null) {
            byteBuf2.release();
        }
        this.extras = byteBuf;
        short s5 = this.extrasLength;
        byte readableBytes = byteBuf == null ? (byte) 0 : (byte) byteBuf.readableBytes();
        this.extrasLength = readableBytes;
        this.totalBodyLength = (this.totalBodyLength + readableBytes) - s5;
        return this;
    }

    BinaryMemcacheMessage setExtrasLength(byte b6) {
        this.extrasLength = b6;
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public BinaryMemcacheMessage setKey(ByteBuf byteBuf) {
        ByteBuf byteBuf2 = this.key;
        if (byteBuf2 != null) {
            byteBuf2.release();
        }
        this.key = byteBuf;
        short s5 = this.keyLength;
        short readableBytes = byteBuf == null ? (short) 0 : (short) byteBuf.readableBytes();
        this.keyLength = readableBytes;
        this.totalBodyLength = (this.totalBodyLength + readableBytes) - s5;
        return this;
    }

    BinaryMemcacheMessage setKeyLength(short s5) {
        this.keyLength = s5;
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public BinaryMemcacheMessage setMagic(byte b6) {
        this.magic = b6;
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public BinaryMemcacheMessage setOpaque(int i6) {
        this.opaque = i6;
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public BinaryMemcacheMessage setOpcode(byte b6) {
        this.opcode = b6;
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public BinaryMemcacheMessage setTotalBodyLength(int i6) {
        this.totalBodyLength = i6;
        return this;
    }

    @Override // io.netty.handler.codec.memcache.binary.BinaryMemcacheMessage
    public int totalBodyLength() {
        return this.totalBodyLength;
    }

    protected AbstractBinaryMemcacheMessage(ByteBuf byteBuf, ByteBuf byteBuf2) {
        short readableBytes;
        this.key = byteBuf;
        if (byteBuf == null) {
            readableBytes = 0;
        } else {
            readableBytes = (short) byteBuf.readableBytes();
        }
        this.keyLength = readableBytes;
        this.extras = byteBuf2;
        byte readableBytes2 = byteBuf2 != null ? (byte) byteBuf2.readableBytes() : (byte) 0;
        this.extrasLength = readableBytes2;
        this.totalBodyLength = this.keyLength + readableBytes2;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public BinaryMemcacheMessage retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public BinaryMemcacheMessage touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public BinaryMemcacheMessage retain(int i6) {
        super.retain(i6);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public BinaryMemcacheMessage touch(Object obj) {
        ByteBuf byteBuf = this.key;
        if (byteBuf != null) {
            byteBuf.touch(obj);
        }
        ByteBuf byteBuf2 = this.extras;
        if (byteBuf2 != null) {
            byteBuf2.touch(obj);
        }
        return this;
    }
}
