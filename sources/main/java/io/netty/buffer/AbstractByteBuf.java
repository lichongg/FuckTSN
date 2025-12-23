package io.netty.buffer;

import androidx.core.view.ViewCompat;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;
import kotlin.j1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractByteBuf extends ByteBuf {
    private static final String LEGACY_PROP_CHECK_ACCESSIBLE = "io.netty.buffer.bytebuf.checkAccessible";
    private static final String PROP_CHECK_ACCESSIBLE = "io.netty.buffer.checkAccessible";
    private static final String PROP_CHECK_BOUNDS = "io.netty.buffer.checkBounds";
    static final boolean checkAccessible;
    private static final boolean checkBounds;
    static final ResourceLeakDetector<ByteBuf> leakDetector;
    private static final InternalLogger logger;
    private int markedReaderIndex;
    private int markedWriterIndex;
    private int maxCapacity;
    int readerIndex;
    int writerIndex;

    protected abstract byte _getByte(int i6);

    protected abstract int _getInt(int i6);

    protected abstract int _getIntLE(int i6);

    protected abstract long _getLong(int i6);

    protected abstract long _getLongLE(int i6);

    protected abstract short _getShort(int i6);

    protected abstract short _getShortLE(int i6);

    protected abstract int _getUnsignedMedium(int i6);

    protected abstract int _getUnsignedMediumLE(int i6);

    protected abstract void _setByte(int i6, int i7);

    protected abstract void _setInt(int i6, int i7);

    protected abstract void _setIntLE(int i6, int i7);

    protected abstract void _setLong(int i6, long j6);

    protected abstract void _setLongLE(int i6, long j6);

    protected abstract void _setMedium(int i6, int i7);

    protected abstract void _setMediumLE(int i6, int i7);

    protected abstract void _setShort(int i6, int i7);

    protected abstract void _setShortLE(int i6, int i7);

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(byte b6) {
        return bytesBefore(readerIndex(), readableBytes(), b6);
    }

    protected final void checkDstIndex(int i6, int i7, int i8, int i9) {
        checkIndex(i6, i7);
        if (checkBounds) {
            checkRangeBounds("dstIndex", i8, i7, i9);
        }
    }

    protected final void checkIndex(int i6) {
        checkIndex(i6, 1);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf clear() {
        this.writerIndex = 0;
        this.readerIndex = 0;
        return this;
    }

    final void discardMarks() {
        this.markedWriterIndex = 0;
        this.markedReaderIndex = 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int i6) {
        ObjectUtil.checkPositiveOrZero(i6, "minWritableBytes");
        ensureWritable0(i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor byteProcessor) {
        ensureAccessible();
        try {
            return forEachByteAsc0(this.readerIndex, this.writerIndex, byteProcessor);
        } catch (Exception e6) {
            PlatformDependent.throwException(e6);
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByteDesc(ByteProcessor byteProcessor) {
        ensureAccessible();
        try {
            return forEachByteDesc0(this.writerIndex - 1, this.readerIndex, byteProcessor);
        } catch (Exception e6) {
            PlatformDependent.throwException(e6);
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, byte[] bArr) {
        getBytes(i6, bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getInt(int i6) {
        checkIndex(i6, 4);
        return _getInt(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getIntLE(int i6) {
        checkIndex(i6, 4);
        return _getIntLE(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShort(int i6) {
        checkIndex(i6, 2);
        return _getShort(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShortLE(int i6) {
        checkIndex(i6, 2);
        return _getShortLE(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i6) {
        checkIndex(i6, 3);
        return _getUnsignedMedium(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i6) {
        checkIndex(i6, 3);
        return _getUnsignedMediumLE(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable() {
        return this.writerIndex > this.readerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isWritable() {
        return capacity() > this.writerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxCapacity() {
        return this.maxCapacity;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte readByte() {
        checkReadableBytes0(1);
        int i6 = this.readerIndex;
        byte _getByte = _getByte(i6);
        this.readerIndex = i6 + 1;
        return _getByte;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int i6) {
        checkReadableBytes(i6);
        if (i6 == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBuf buffer = alloc().buffer(i6, this.maxCapacity);
        buffer.writeBytes(this, this.readerIndex, i6);
        this.readerIndex += i6;
        return buffer;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readInt() {
        checkReadableBytes0(4);
        int _getInt = _getInt(this.readerIndex);
        this.readerIndex += 4;
        return _getInt;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readIntLE() {
        checkReadableBytes0(4);
        int _getIntLE = _getIntLE(this.readerIndex);
        this.readerIndex += 4;
        return _getIntLE;
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShort() {
        checkReadableBytes0(2);
        short _getShort = _getShort(this.readerIndex);
        this.readerIndex += 2;
        return _getShort;
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShortLE() {
        checkReadableBytes0(2);
        short _getShortLE = _getShortLE(this.readerIndex);
        this.readerIndex += 2;
        return _getShortLE;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedMedium() {
        checkReadableBytes0(3);
        int _getUnsignedMedium = _getUnsignedMedium(this.readerIndex);
        this.readerIndex += 3;
        return _getUnsignedMedium;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedMediumLE() {
        checkReadableBytes0(3);
        int _getUnsignedMediumLE = _getUnsignedMediumLE(this.readerIndex);
        this.readerIndex += 3;
        return _getUnsignedMediumLE;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readerIndex() {
        return this.readerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return slice().retain();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, byte[] bArr) {
        setBytes(i6, bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setCharSequence(int i6, CharSequence charSequence, Charset charset) {
        return setCharSequence0(i6, charSequence, charset, false);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i6, int i7) {
        checkIndex(i6, 4);
        _setInt(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i6, int i7) {
        checkIndex(i6, 4);
        _setIntLE(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i6, int i7) {
        checkIndex(i6, 3);
        _setMedium(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i6, int i7) {
        checkIndex(i6, 3);
        _setMediumLE(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i6, int i7) {
        checkIndex(i6, 2);
        _setShort(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i6, int i7) {
        checkIndex(i6, 2);
        _setShortLE(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return slice(this.readerIndex, readableBytes());
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(Charset charset) {
        return toString(this.readerIndex, readableBytes(), charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeByte(int i6) {
        ensureWritable0(1);
        int i7 = this.writerIndex;
        this.writerIndex = i7 + 1;
        _setByte(i7, i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr, int i6, int i7) {
        ensureWritable(i7);
        setBytes(this.writerIndex, bArr, i6, i7);
        this.writerIndex += i7;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeInt(int i6) {
        ensureWritable0(4);
        _setInt(this.writerIndex, i6);
        this.writerIndex += 4;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeIntLE(int i6) {
        ensureWritable0(4);
        _setIntLE(this.writerIndex, i6);
        this.writerIndex += 4;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMedium(int i6) {
        ensureWritable0(3);
        _setMedium(this.writerIndex, i6);
        this.writerIndex += 3;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int i6) {
        ensureWritable0(3);
        _setMediumLE(this.writerIndex, i6);
        this.writerIndex += 3;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShort(int i6) {
        ensureWritable0(2);
        _setShort(this.writerIndex, i6);
        this.writerIndex += 2;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int i6) {
        ensureWritable0(2);
        _setShortLE(this.writerIndex, i6);
        this.writerIndex += 2;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writerIndex() {
        return this.writerIndex;
    }

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) AbstractByteBuf.class);
        logger = internalLoggerFactory;
        if (SystemPropertyUtil.contains(PROP_CHECK_ACCESSIBLE)) {
            checkAccessible = SystemPropertyUtil.getBoolean(PROP_CHECK_ACCESSIBLE, true);
        } else {
            checkAccessible = SystemPropertyUtil.getBoolean(LEGACY_PROP_CHECK_ACCESSIBLE, true);
        }
        boolean z5 = SystemPropertyUtil.getBoolean(PROP_CHECK_BOUNDS, true);
        checkBounds = z5;
        if (internalLoggerFactory.isDebugEnabled()) {
            internalLoggerFactory.debug("-D{}: {}", PROP_CHECK_ACCESSIBLE, Boolean.valueOf(checkAccessible));
            internalLoggerFactory.debug("-D{}: {}", PROP_CHECK_BOUNDS, Boolean.valueOf(z5));
        }
        leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ByteBuf.class);
    }

    private static void checkIndexBounds(int i6, int i7, int i8) {
        if (i6 < 0 || i6 > i7 || i7 > i8) {
            throw new IndexOutOfBoundsException(String.format("readerIndex: %d, writerIndex: %d (expected: 0 <= readerIndex <= writerIndex <= capacity(%d))", Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)));
        }
    }

    private int setCharSequence0(int i6, CharSequence charSequence, Charset charset, boolean z5) {
        if (charset.equals(CharsetUtil.UTF_8)) {
            int utf8MaxBytes = ByteBufUtil.utf8MaxBytes(charSequence);
            if (z5) {
                ensureWritable0(utf8MaxBytes);
                checkIndex0(i6, utf8MaxBytes);
            } else {
                checkIndex(i6, utf8MaxBytes);
            }
            return ByteBufUtil.writeUtf8(this, i6, charSequence, charSequence.length());
        }
        if (!charset.equals(CharsetUtil.US_ASCII) && !charset.equals(CharsetUtil.ISO_8859_1)) {
            byte[] bytes = charSequence.toString().getBytes(charset);
            if (z5) {
                ensureWritable0(bytes.length);
            }
            setBytes(i6, bytes);
            return bytes.length;
        }
        int length = charSequence.length();
        if (z5) {
            ensureWritable0(length);
            checkIndex0(i6, length);
        } else {
            checkIndex(i6, length);
        }
        return ByteBufUtil.writeAscii(this, i6, charSequence, length);
    }

    protected final void adjustMarkers(int i6) {
        int i7 = this.markedReaderIndex;
        if (i7 > i6) {
            this.markedReaderIndex = i7 - i6;
            this.markedWriterIndex -= i6;
            return;
        }
        this.markedReaderIndex = 0;
        int i8 = this.markedWriterIndex;
        if (i8 <= i6) {
            this.markedWriterIndex = 0;
        } else {
            this.markedWriterIndex = i8 - i6;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(int i6, byte b6) {
        checkReadableBytes(i6);
        return bytesBefore(readerIndex(), i6, b6);
    }

    protected final void checkIndex(int i6, int i7) {
        ensureAccessible();
        checkIndex0(i6, i7);
    }

    final void checkIndex0(int i6, int i7) {
        if (checkBounds) {
            checkRangeBounds("index", i6, i7, capacity());
        }
    }

    protected final void checkReadableBytes(int i6) {
        ObjectUtil.checkPositiveOrZero(i6, "minimumReadableBytes");
        checkReadableBytes0(i6);
    }

    @Override // io.netty.buffer.ByteBuf, java.lang.Comparable
    public int compareTo(ByteBuf byteBuf) {
        return ByteBufUtil.compare(this, byteBuf);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy() {
        return copy(this.readerIndex, readableBytes());
    }

    protected final void ensureAccessible() {
        if (checkAccessible && !isAccessible()) {
            throw new IllegalReferenceCountException(0);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ByteBuf) && ByteBufUtil.equals(this, (ByteBuf) obj);
        }
        return true;
    }

    int forEachByteAsc0(int i6, int i7, ByteProcessor byteProcessor) throws Exception {
        while (i6 < i7) {
            if (!byteProcessor.process(_getByte(i6))) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    int forEachByteDesc0(int i6, int i7, ByteProcessor byteProcessor) throws Exception {
        while (i6 >= i7) {
            if (!byteProcessor.process(_getByte(i6))) {
                return i6;
            }
            i6--;
        }
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, ByteBuf byteBuf) {
        getBytes(i6, byteBuf, byteBuf.writableBytes());
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int i6, int i7, Charset charset) {
        return (CharsetUtil.US_ASCII.equals(charset) || CharsetUtil.ISO_8859_1.equals(charset)) ? new AsciiString(ByteBufUtil.getBytes(this, i6, i7, true), false) : toString(i6, i7, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLong(int i6) {
        checkIndex(i6, 8);
        return _getLong(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLongLE(int i6) {
        checkIndex(i6, 8);
        return _getLongLE(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable(int i6) {
        return this.writerIndex - this.readerIndex >= i6;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isWritable(int i6) {
        return capacity() - this.writerIndex >= i6;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf markReaderIndex() {
        this.markedReaderIndex = this.readerIndex;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf markWriterIndex() {
        this.markedWriterIndex = this.writerIndex;
        return this;
    }

    protected final void maxCapacity(int i6) {
        this.maxCapacity = i6;
    }

    protected SwappedByteBuf newSwappedByteBuf() {
        return new SwappedByteBuf(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        return nioBuffer(this.readerIndex, readableBytes());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        return nioBuffers(this.readerIndex, readableBytes());
    }

    @Override // io.netty.buffer.ByteBuf
    public CharSequence readCharSequence(int i6, Charset charset) {
        CharSequence charSequence = getCharSequence(this.readerIndex, i6, charset);
        this.readerIndex += i6;
        return charSequence;
    }

    @Override // io.netty.buffer.ByteBuf
    public long readLong() {
        checkReadableBytes0(8);
        long _getLong = _getLong(this.readerIndex);
        this.readerIndex += 8;
        return _getLong;
    }

    @Override // io.netty.buffer.ByteBuf
    public long readLongLE() {
        checkReadableBytes0(8);
        long _getLongLE = _getLongLE(this.readerIndex);
        this.readerIndex += 8;
        return _getLongLE;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readableBytes() {
        return this.writerIndex - this.readerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readerIndex(int i6) {
        if (checkBounds) {
            checkIndexBounds(i6, this.writerIndex, capacity());
        }
        this.readerIndex = i6;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf resetReaderIndex() {
        readerIndex(this.markedReaderIndex);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf resetWriterIndex() {
        writerIndex(this.markedWriterIndex);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int i6, int i7) {
        return slice(i6, i7).retain();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, ByteBuf byteBuf) {
        setBytes(i6, byteBuf, byteBuf.readableBytes());
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIndex(int i6, int i7) {
        if (checkBounds) {
            checkIndexBounds(i6, i7, capacity());
        }
        setIndex0(i6, i7);
        return this;
    }

    final void setIndex0(int i6, int i7) {
        this.readerIndex = i6;
        this.writerIndex = i7;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i6, long j6) {
        checkIndex(i6, 8);
        _setLong(i6, j6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i6, long j6) {
        checkIndex(i6, 8);
        _setLongLE(i6, j6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i6, int i7) {
        if (i7 != 0) {
            checkIndex(i6, i7);
            int i8 = i7 & 7;
            for (int i9 = i7 >>> 3; i9 > 0; i9--) {
                _setLong(i6, 0L);
                i6 += 8;
            }
            if (i8 == 4) {
                _setInt(i6, 0);
                return this;
            }
            if (i8 < 4) {
                while (i8 > 0) {
                    _setByte(i6, 0);
                    i6++;
                    i8--;
                }
            } else {
                _setInt(i6, 0);
                int i10 = i6 + 4;
                for (int i11 = i8 - 4; i11 > 0; i11--) {
                    _setByte(i10, 0);
                    i10++;
                }
            }
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice(int i6, int i7) {
        ensureAccessible();
        return new UnpooledSlicedByteBuf(this, i6, i7);
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(int i6, int i7, Charset charset) {
        return ByteBufUtil.decodeString(this, i6, i7, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        int charSequence0 = setCharSequence0(this.writerIndex, charSequence, charset, true);
        this.writerIndex += charSequence0;
        return charSequence0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeLong(long j6) {
        ensureWritable0(8);
        _setLong(this.writerIndex, j6);
        this.writerIndex += 8;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeLongLE(long j6) {
        ensureWritable0(8);
        _setLongLE(this.writerIndex, j6);
        this.writerIndex += 8;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int i6) {
        if (i6 == 0) {
            return this;
        }
        ensureWritable(i6);
        int i7 = this.writerIndex;
        checkIndex0(i7, i6);
        int i8 = i6 & 7;
        for (int i9 = i6 >>> 3; i9 > 0; i9--) {
            _setLong(i7, 0L);
            i7 += 8;
        }
        if (i8 == 4) {
            _setInt(i7, 0);
            i7 += 4;
        } else if (i8 < 4) {
            while (i8 > 0) {
                _setByte(i7, 0);
                i7++;
                i8--;
            }
        } else {
            _setInt(i7, 0);
            i7 += 4;
            for (int i10 = i8 - 4; i10 > 0; i10--) {
                _setByte(i7, 0);
                i7++;
            }
        }
        this.writerIndex = i7;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writerIndex(int i6) {
        if (checkBounds) {
            checkIndexBounds(this.readerIndex, i6, capacity());
        }
        this.writerIndex = i6;
        return this;
    }

    protected AbstractByteBuf(int i6) {
        ObjectUtil.checkPositiveOrZero(i6, "maxCapacity");
        this.maxCapacity = i6;
    }

    private static void checkRangeBounds(String str, int i6, int i7, int i8) {
        if (!MathUtil.isOutOfBounds(i6, i7, i8)) {
        } else {
            throw new IndexOutOfBoundsException(String.format("%s: %d, length: %d (expected: range(0, %d))", str, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)));
        }
    }

    private static void checkReadableBounds(ByteBuf byteBuf, int i6) {
        if (i6 <= byteBuf.readableBytes()) {
        } else {
            throw new IndexOutOfBoundsException(String.format("length(%d) exceeds src.readableBytes(%d) where src is: %s", Integer.valueOf(i6), Integer.valueOf(byteBuf.readableBytes()), byteBuf));
        }
    }

    private void checkReadableBytes0(int i6) {
        ensureAccessible();
        if (checkBounds && this.readerIndex > this.writerIndex - i6) {
            throw new IndexOutOfBoundsException(String.format("readerIndex(%d) + length(%d) exceeds writerIndex(%d): %s", Integer.valueOf(this.readerIndex), Integer.valueOf(i6), Integer.valueOf(this.writerIndex), this));
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        if (isReadOnly()) {
            return this;
        }
        return Unpooled.unmodifiableBuffer(this);
    }

    protected final void checkNewCapacity(int i6) {
        ensureAccessible();
        if (checkBounds) {
            if (i6 < 0 || i6 > maxCapacity()) {
                throw new IllegalArgumentException("newCapacity: " + i6 + " (expected: 0-" + maxCapacity() + ')');
            }
        }
    }

    protected final void checkSrcIndex(int i6, int i7, int i8, int i9) {
        checkIndex(i6, i7);
        if (checkBounds) {
            checkRangeBounds("srcIndex", i8, i7, i9);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardReadBytes() {
        ensureAccessible();
        int i6 = this.readerIndex;
        if (i6 == 0) {
            return this;
        }
        int i7 = this.writerIndex;
        if (i6 != i7) {
            setBytes(0, this, i6, i7 - i6);
            int i8 = this.writerIndex;
            int i9 = this.readerIndex;
            this.writerIndex = i8 - i9;
            adjustMarkers(i9);
            this.readerIndex = 0;
            return this;
        }
        adjustMarkers(i6);
        this.readerIndex = 0;
        this.writerIndex = 0;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardSomeReadBytes() {
        ensureAccessible();
        int i6 = this.readerIndex;
        if (i6 != 0) {
            if (i6 == this.writerIndex) {
                adjustMarkers(i6);
                this.readerIndex = 0;
                this.writerIndex = 0;
                return this;
            }
            if (i6 >= (capacity() >>> 1)) {
                int i7 = this.readerIndex;
                setBytes(0, this, i7, this.writerIndex - i7);
                int i8 = this.writerIndex;
                int i9 = this.readerIndex;
                this.writerIndex = i8 - i9;
                adjustMarkers(i9);
                this.readerIndex = 0;
            }
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        ensureAccessible();
        return new UnpooledDuplicatedByteBuf(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public int ensureWritable(int i6, boolean z5) {
        ensureAccessible();
        ObjectUtil.checkPositiveOrZero(i6, "minWritableBytes");
        if (i6 <= writableBytes()) {
            return 0;
        }
        int maxCapacity = maxCapacity();
        int writerIndex = writerIndex();
        if (i6 > maxCapacity - writerIndex) {
            if (!z5 || capacity() == maxCapacity) {
                return 1;
            }
            capacity(maxCapacity);
            return 3;
        }
        int i7 = i6 + writerIndex;
        int calculateNewCapacity = alloc().calculateNewCapacity(i7, maxCapacity);
        int maxFastWritableBytes = writerIndex + maxFastWritableBytes();
        if (calculateNewCapacity > maxFastWritableBytes && i7 <= maxFastWritableBytes) {
            calculateNewCapacity = maxFastWritableBytes;
        }
        capacity(calculateNewCapacity);
        return 2;
    }

    final void ensureWritable0(int i6) {
        ensureAccessible();
        if (i6 <= writableBytes()) {
            return;
        }
        int writerIndex = writerIndex();
        if (checkBounds && i6 > this.maxCapacity - writerIndex) {
            throw new IndexOutOfBoundsException(String.format("writerIndex(%d) + minWritableBytes(%d) exceeds maxCapacity(%d): %s", Integer.valueOf(writerIndex), Integer.valueOf(i6), Integer.valueOf(this.maxCapacity), this));
        }
        int i7 = i6 + writerIndex;
        int calculateNewCapacity = alloc().calculateNewCapacity(i7, this.maxCapacity);
        int maxFastWritableBytes = writerIndex + maxFastWritableBytes();
        if (calculateNewCapacity > maxFastWritableBytes && i7 <= maxFastWritableBytes) {
            calculateNewCapacity = maxFastWritableBytes;
        }
        capacity(calculateNewCapacity);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean getBoolean(int i6) {
        if (getByte(i6) != 0) {
            return true;
        }
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte getByte(int i6) {
        checkIndex(i6);
        return _getByte(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i6, ByteBuf byteBuf, int i7) {
        getBytes(i6, byteBuf, byteBuf.writerIndex(), i7);
        byteBuf.writerIndex(byteBuf.writerIndex() + i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public char getChar(int i6) {
        return (char) getShort(i6);
    }

    @Override // io.netty.buffer.ByteBuf
    public double getDouble(int i6) {
        return Double.longBitsToDouble(getLong(i6));
    }

    @Override // io.netty.buffer.ByteBuf
    public float getFloat(int i6) {
        return Float.intBitsToFloat(getInt(i6));
    }

    @Override // io.netty.buffer.ByteBuf
    public int getMedium(int i6) {
        int unsignedMedium = getUnsignedMedium(i6);
        if ((8388608 & unsignedMedium) != 0) {
            return unsignedMedium | ViewCompat.MEASURED_STATE_MASK;
        }
        return unsignedMedium;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getMediumLE(int i6) {
        int unsignedMediumLE = getUnsignedMediumLE(i6);
        if ((8388608 & unsignedMediumLE) != 0) {
            return unsignedMediumLE | ViewCompat.MEASURED_STATE_MASK;
        }
        return unsignedMediumLE;
    }

    @Override // io.netty.buffer.ByteBuf
    public short getUnsignedByte(int i6) {
        return (short) (getByte(i6) & 255);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedInt(int i6) {
        return getInt(i6) & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int i6) {
        return getIntLE(i6) & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShort(int i6) {
        return getShort(i6) & j1.f43986d;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int i6) {
        return getShortLE(i6) & j1.f43986d;
    }

    @Override // io.netty.buffer.ByteBuf
    public int hashCode() {
        return ByteBufUtil.hashCode(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public int indexOf(int i6, int i7, byte b6) {
        return ByteBufUtil.indexOf(this, i6, i7, b6);
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxWritableBytes() {
        return maxCapacity() - this.writerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        if (byteOrder == order()) {
            return this;
        }
        if (byteOrder != null) {
            return newSwappedByteBuf();
        }
        throw new NullPointerException("endianness");
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean readBoolean() {
        if (readByte() != 0) {
            return true;
        }
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public char readChar() {
        return (char) readShort();
    }

    @Override // io.netty.buffer.ByteBuf
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // io.netty.buffer.ByteBuf
    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // io.netty.buffer.ByteBuf
    public int readMedium() {
        int readUnsignedMedium = readUnsignedMedium();
        if ((8388608 & readUnsignedMedium) != 0) {
            return readUnsignedMedium | ViewCompat.MEASURED_STATE_MASK;
        }
        return readUnsignedMedium;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readMediumLE() {
        int readUnsignedMediumLE = readUnsignedMediumLE();
        if ((8388608 & readUnsignedMediumLE) != 0) {
            return readUnsignedMediumLE | ViewCompat.MEASURED_STATE_MASK;
        }
        return readUnsignedMediumLE;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i6) {
        checkReadableBytes(i6);
        ByteBuf retainedSlice = retainedSlice(this.readerIndex, i6);
        this.readerIndex += i6;
        return retainedSlice;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i6) {
        checkReadableBytes(i6);
        ByteBuf slice = slice(this.readerIndex, i6);
        this.readerIndex += i6;
        return slice;
    }

    @Override // io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        return (short) (readByte() & 255);
    }

    @Override // io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        return readInt() & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public long readUnsignedIntLE() {
        return readIntLE() & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        return readShort() & j1.f43986d;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShortLE() {
        return readShortLE() & j1.f43986d;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return duplicate().retain();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBoolean(int i6, boolean z5) {
        setByte(i6, z5 ? 1 : 0);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i6, int i7) {
        checkIndex(i6);
        _setByte(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i6, ByteBuf byteBuf, int i7) {
        checkIndex(i6, i7);
        if (byteBuf != null) {
            if (checkBounds) {
                checkReadableBounds(byteBuf, i7);
            }
            setBytes(i6, byteBuf, byteBuf.readerIndex(), i7);
            byteBuf.readerIndex(byteBuf.readerIndex() + i7);
            return this;
        }
        throw new NullPointerException("src");
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setChar(int i6, int i7) {
        setShort(i6, i7);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setDouble(int i6, double d6) {
        setLong(i6, Double.doubleToRawLongBits(d6));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setFloat(int i6, float f6) {
        setInt(i6, Float.floatToRawIntBits(f6));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf skipBytes(int i6) {
        checkReadableBytes(i6);
        this.readerIndex += i6;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString() {
        if (refCnt() == 0) {
            return StringUtil.simpleClassName(this) + "(freed)";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        sb.append("(ridx: ");
        sb.append(this.readerIndex);
        sb.append(", widx: ");
        sb.append(this.writerIndex);
        sb.append(", cap: ");
        sb.append(capacity());
        if (this.maxCapacity != Integer.MAX_VALUE) {
            sb.append('/');
            sb.append(this.maxCapacity);
        }
        ByteBuf unwrap = unwrap();
        if (unwrap != null) {
            sb.append(", unwrapped: ");
            sb.append(unwrap);
        }
        sb.append(')');
        return sb.toString();
    }

    @Override // io.netty.buffer.ByteBuf
    public int writableBytes() {
        return capacity() - this.writerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBoolean(boolean z5) {
        writeByte(z5 ? 1 : 0);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeChar(int i6) {
        writeShort(i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeDouble(double d6) {
        writeLong(Double.doubleToRawLongBits(d6));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeFloat(float f6) {
        writeInt(Float.floatToRawIntBits(f6));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(int i6, int i7, byte b6) {
        int indexOf = indexOf(i6, i7 + i6, b6);
        if (indexOf < 0) {
            return -1;
        }
        return indexOf - i6;
    }

    protected final void checkDstIndex(int i6, int i7, int i8) {
        checkReadableBytes(i6);
        if (checkBounds) {
            checkRangeBounds("dstIndex", i7, i6, i8);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(int i6, int i7, ByteProcessor byteProcessor) {
        checkIndex(i6, i7);
        try {
            return forEachByteAsc0(i6, i7 + i6, byteProcessor);
        } catch (Exception e6) {
            PlatformDependent.throwException(e6);
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByteDesc(int i6, int i7, ByteProcessor byteProcessor) {
        checkIndex(i6, i7);
        try {
            return forEachByteDesc0((i7 + i6) - 1, i6, byteProcessor);
        } catch (Exception e6) {
            PlatformDependent.throwException(e6);
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr) {
        writeBytes(bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf) {
        writeBytes(byteBuf, byteBuf.readableBytes());
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr, int i6, int i7) {
        checkReadableBytes(i7);
        getBytes(this.readerIndex, bArr, i6, i7);
        this.readerIndex += i7;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i6) {
        if (checkBounds) {
            checkReadableBounds(byteBuf, i6);
        }
        writeBytes(byteBuf, byteBuf.readerIndex(), i6);
        byteBuf.readerIndex(byteBuf.readerIndex() + i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr) {
        readBytes(bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf) {
        readBytes(byteBuf, byteBuf.writableBytes());
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i6, int i7) {
        ensureWritable(i7);
        setBytes(this.writerIndex, byteBuf, i6, i7);
        this.writerIndex += i7;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i6) {
        if (checkBounds && i6 > byteBuf.writableBytes()) {
            throw new IndexOutOfBoundsException(String.format("length(%d) exceeds dst.writableBytes(%d) where dst is: %s", Integer.valueOf(i6), Integer.valueOf(byteBuf.writableBytes()), byteBuf));
        }
        readBytes(byteBuf, byteBuf.writerIndex(), i6);
        byteBuf.writerIndex(byteBuf.writerIndex() + i6);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        ensureWritable0(remaining);
        setBytes(this.writerIndex, byteBuffer);
        this.writerIndex += remaining;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(InputStream inputStream, int i6) throws IOException {
        ensureWritable(i6);
        int bytes = setBytes(this.writerIndex, inputStream, i6);
        if (bytes > 0) {
            this.writerIndex += bytes;
        }
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i6, int i7) {
        checkReadableBytes(i7);
        getBytes(this.readerIndex, byteBuf, i6, i7);
        this.readerIndex += i7;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i6) throws IOException {
        ensureWritable(i6);
        int bytes = setBytes(this.writerIndex, scatteringByteChannel, i6);
        if (bytes > 0) {
            this.writerIndex += bytes;
        }
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkReadableBytes(remaining);
        getBytes(this.readerIndex, byteBuffer);
        this.readerIndex += remaining;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(FileChannel fileChannel, long j6, int i6) throws IOException {
        ensureWritable(i6);
        int bytes = setBytes(this.writerIndex, fileChannel, j6, i6);
        if (bytes > 0) {
            this.writerIndex += bytes;
        }
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i6) throws IOException {
        checkReadableBytes(i6);
        int bytes = getBytes(this.readerIndex, gatheringByteChannel, i6);
        this.readerIndex += bytes;
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(FileChannel fileChannel, long j6, int i6) throws IOException {
        checkReadableBytes(i6);
        int bytes = getBytes(this.readerIndex, fileChannel, j6, i6);
        this.readerIndex += bytes;
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(OutputStream outputStream, int i6) throws IOException {
        checkReadableBytes(i6);
        getBytes(this.readerIndex, outputStream, i6);
        this.readerIndex += i6;
        return this;
    }
}
