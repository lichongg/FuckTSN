package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteOrder;
import kotlin.j1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class AbstractUnsafeSwappedByteBuf extends SwappedByteBuf {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean nativeByteOrder;
    private final AbstractByteBuf wrapped;

    protected abstract int _getInt(AbstractByteBuf abstractByteBuf, int i6);

    protected abstract long _getLong(AbstractByteBuf abstractByteBuf, int i6);

    protected abstract short _getShort(AbstractByteBuf abstractByteBuf, int i6);

    protected abstract void _setInt(AbstractByteBuf abstractByteBuf, int i6, int i7);

    protected abstract void _setLong(AbstractByteBuf abstractByteBuf, int i6, long j6);

    protected abstract void _setShort(AbstractByteBuf abstractByteBuf, int i6, short s5);

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final int getInt(int i6) {
        this.wrapped.checkIndex(i6, 4);
        int _getInt = _getInt(this.wrapped, i6);
        return this.nativeByteOrder ? _getInt : Integer.reverseBytes(_getInt);
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final long getLong(int i6) {
        this.wrapped.checkIndex(i6, 8);
        long _getLong = _getLong(this.wrapped, i6);
        return this.nativeByteOrder ? _getLong : Long.reverseBytes(_getLong);
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final short getShort(int i6) {
        this.wrapped.checkIndex(i6, 2);
        short _getShort = _getShort(this.wrapped, i6);
        return this.nativeByteOrder ? _getShort : Short.reverseBytes(_getShort);
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setInt(int i6, int i7) {
        this.wrapped.checkIndex(i6, 4);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        if (!this.nativeByteOrder) {
            i7 = Integer.reverseBytes(i7);
        }
        _setInt(abstractByteBuf, i6, i7);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setLong(int i6, long j6) {
        this.wrapped.checkIndex(i6, 8);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        if (!this.nativeByteOrder) {
            j6 = Long.reverseBytes(j6);
        }
        _setLong(abstractByteBuf, i6, j6);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setShort(int i6, int i7) {
        this.wrapped.checkIndex(i6, 2);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        short s5 = (short) i7;
        if (!this.nativeByteOrder) {
            s5 = Short.reverseBytes(s5);
        }
        _setShort(abstractByteBuf, i6, s5);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeInt(int i6) {
        this.wrapped.ensureWritable0(4);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        int i7 = abstractByteBuf.writerIndex;
        if (!this.nativeByteOrder) {
            i6 = Integer.reverseBytes(i6);
        }
        _setInt(abstractByteBuf, i7, i6);
        this.wrapped.writerIndex += 4;
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeLong(long j6) {
        this.wrapped.ensureWritable0(8);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        int i6 = abstractByteBuf.writerIndex;
        if (!this.nativeByteOrder) {
            j6 = Long.reverseBytes(j6);
        }
        _setLong(abstractByteBuf, i6, j6);
        this.wrapped.writerIndex += 8;
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeShort(int i6) {
        this.wrapped.ensureWritable0(2);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        int i7 = abstractByteBuf.writerIndex;
        short s5 = (short) i6;
        if (!this.nativeByteOrder) {
            s5 = Short.reverseBytes(s5);
        }
        _setShort(abstractByteBuf, i7, s5);
        this.wrapped.writerIndex += 2;
        return this;
    }

    AbstractUnsafeSwappedByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
        boolean z5;
        this.wrapped = abstractByteBuf;
        boolean z6 = PlatformDependent.BIG_ENDIAN_NATIVE_ORDER;
        if (order() == ByteOrder.BIG_ENDIAN) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.nativeByteOrder = z6 == z5;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final char getChar(int i6) {
        return (char) getShort(i6);
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final double getDouble(int i6) {
        return Double.longBitsToDouble(getLong(i6));
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final float getFloat(int i6) {
        return Float.intBitsToFloat(getInt(i6));
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final long getUnsignedInt(int i6) {
        return getInt(i6) & 4294967295L;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final int getUnsignedShort(int i6) {
        return getShort(i6) & j1.f43986d;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setChar(int i6, int i7) {
        setShort(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setDouble(int i6, double d6) {
        setLong(i6, Double.doubleToRawLongBits(d6));
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setFloat(int i6, float f6) {
        setInt(i6, Float.floatToRawIntBits(f6));
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeChar(int i6) {
        writeShort(i6);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeDouble(double d6) {
        writeLong(Double.doubleToRawLongBits(d6));
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeFloat(float f6) {
        writeInt(Float.floatToRawIntBits(f6));
        return this;
    }
}
