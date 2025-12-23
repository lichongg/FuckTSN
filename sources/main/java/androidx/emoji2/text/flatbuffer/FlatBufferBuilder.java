package androidx.emoji2.text.flatbuffer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class FlatBufferBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    ByteBuffer bb;
    ByteBufferFactory bb_factory;
    boolean finished;
    boolean force_defaults;
    int minalign;
    boolean nested;
    int num_vtables;
    int object_start;
    int space;
    final Utf8 utf8;
    int vector_num_elems;
    int[] vtable;
    int vtable_in_use;
    int[] vtables;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ByteBufferBackedInputStream extends InputStream {
        ByteBuffer buf;

        @Override // java.io.InputStream
        public int read() throws IOException {
            try {
                return this.buf.get() & 255;
            } catch (BufferUnderflowException unused) {
                return -1;
            }
        }

        public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
            this.buf = byteBuffer;
        }
    }

    public FlatBufferBuilder(int i6, ByteBufferFactory byteBufferFactory) {
        this(i6, byteBufferFactory, null, Utf8.getDefault());
    }

    public void addBoolean(boolean z5) {
        prep(1, 0);
        putBoolean(z5);
    }

    public void addByte(byte b6) {
        prep(1, 0);
        putByte(b6);
    }

    public void addDouble(double d6) {
        prep(8, 0);
        putDouble(d6);
    }

    public void addFloat(float f6) {
        prep(4, 0);
        putFloat(f6);
    }

    public void addInt(int i6) {
        prep(4, 0);
        putInt(i6);
    }

    public void addLong(long j6) {
        prep(8, 0);
        putLong(j6);
    }

    public void addOffset(int i6) {
        prep(4, 0);
        putInt((offset() - i6) + 4);
    }

    public void addShort(short s5) {
        prep(2, 0);
        putShort(s5);
    }

    public int createByteVector(byte[] bArr) {
        int length = bArr.length;
        startVector(1, length, 1);
        ByteBuffer byteBuffer = this.bb;
        int i6 = this.space - length;
        this.space = i6;
        byteBuffer.position(i6);
        this.bb.put(bArr);
        return endVector();
    }

    public int createString(CharSequence charSequence) {
        int encodedLength = this.utf8.encodedLength(charSequence);
        addByte((byte) 0);
        startVector(1, encodedLength, 1);
        ByteBuffer byteBuffer = this.bb;
        int i6 = this.space - encodedLength;
        this.space = i6;
        byteBuffer.position(i6);
        this.utf8.encodeUtf8(charSequence, this.bb);
        return endVector();
    }

    protected void finish(int i6, boolean z5) {
        prep(this.minalign, (z5 ? 4 : 0) + 4);
        addOffset(i6);
        if (z5) {
            addInt(this.bb.capacity() - this.space);
        }
        this.bb.position(this.space);
        this.finished = true;
    }

    public void finishSizePrefixed(int i6) {
        finish(i6, true);
    }

    public void pad(int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            ByteBuffer byteBuffer = this.bb;
            int i8 = this.space - 1;
            this.space = i8;
            byteBuffer.put(i8, (byte) 0);
        }
    }

    public byte[] sizedByteArray(int i6, int i7) {
        finished();
        byte[] bArr = new byte[i7];
        this.bb.position(i6);
        this.bb.get(bArr);
        return bArr;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class HeapByteBufferFactory extends ByteBufferFactory {
        public static final HeapByteBufferFactory INSTANCE = new HeapByteBufferFactory();

        @Override // androidx.emoji2.text.flatbuffer.FlatBufferBuilder.ByteBufferFactory
        public ByteBuffer newByteBuffer(int i6) {
            return ByteBuffer.allocate(i6).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public FlatBufferBuilder(int i6, ByteBufferFactory byteBufferFactory, ByteBuffer byteBuffer, Utf8 utf8) {
        this.minalign = 1;
        this.vtable = null;
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.vtables = new int[16];
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        this.force_defaults = false;
        i6 = i6 <= 0 ? 1 : i6;
        this.bb_factory = byteBufferFactory;
        if (byteBuffer != null) {
            this.bb = byteBuffer;
            byteBuffer.clear();
            this.bb.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.bb = byteBufferFactory.newByteBuffer(i6);
        }
        this.utf8 = utf8;
        this.space = this.bb.capacity();
    }

    public void addBoolean(int i6, boolean z5, boolean z6) {
        if (this.force_defaults || z5 != z6) {
            addBoolean(z5);
            slot(i6);
        }
    }

    public void addByte(int i6, byte b6, int i7) {
        if (this.force_defaults || b6 != i7) {
            addByte(b6);
            slot(i6);
        }
    }

    public void addDouble(int i6, double d6, double d7) {
        if (this.force_defaults || d6 != d7) {
            addDouble(d6);
            slot(i6);
        }
    }

    public void addFloat(int i6, float f6, double d6) {
        if (this.force_defaults || f6 != d6) {
            addFloat(f6);
            slot(i6);
        }
    }

    public void addInt(int i6, int i7, int i8) {
        if (this.force_defaults || i7 != i8) {
            addInt(i7);
            slot(i6);
        }
    }

    public void addLong(int i6, long j6, long j7) {
        if (this.force_defaults || j6 != j7) {
            addLong(j6);
            slot(i6);
        }
    }

    public void addShort(int i6, short s5, int i7) {
        if (this.force_defaults || s5 != i7) {
            addShort(s5);
            slot(i6);
        }
    }

    public void addStruct(int i6, int i7, int i8) {
        if (i7 != i8) {
            Nested(i7);
            slot(i6);
        }
    }

    public void clear() {
        this.space = this.bb.capacity();
        this.bb.clear();
        this.minalign = 1;
        while (true) {
            int i6 = this.vtable_in_use;
            if (i6 <= 0) {
                this.vtable_in_use = 0;
                this.nested = false;
                this.finished = false;
                this.object_start = 0;
                this.num_vtables = 0;
                this.vector_num_elems = 0;
                return;
            }
            int[] iArr = this.vtable;
            int i7 = i6 - 1;
            this.vtable_in_use = i7;
            iArr[i7] = 0;
        }
    }

    public <T extends Table> int createSortedVectorOfTables(T t5, int[] iArr) {
        t5.sortTables(iArr, this.bb);
        return createVectorOfTables(iArr);
    }

    public ByteBuffer createUnintializedVector(int i6, int i7, int i8) {
        int i9 = i6 * i7;
        startVector(i6, i7, i8);
        ByteBuffer byteBuffer = this.bb;
        int i10 = this.space - i9;
        this.space = i10;
        byteBuffer.position(i10);
        ByteBuffer order = this.bb.slice().order(ByteOrder.LITTLE_ENDIAN);
        order.limit(i9);
        return order;
    }

    public int endTable() {
        int i6;
        if (this.vtable == null || !this.nested) {
            throw new AssertionError("FlatBuffers: endTable called without startTable");
        }
        addInt(0);
        int offset = offset();
        int i7 = this.vtable_in_use - 1;
        while (i7 >= 0 && this.vtable[i7] == 0) {
            i7--;
        }
        for (int i8 = i7; i8 >= 0; i8--) {
            int i9 = this.vtable[i8];
            addShort((short) (i9 != 0 ? offset - i9 : 0));
        }
        addShort((short) (offset - this.object_start));
        addShort((short) ((i7 + 3) * 2));
        int i10 = 0;
        loop2: while (true) {
            if (i10 >= this.num_vtables) {
                i6 = 0;
                break;
            }
            int capacity = this.bb.capacity() - this.vtables[i10];
            int i11 = this.space;
            short s5 = this.bb.getShort(capacity);
            if (s5 == this.bb.getShort(i11)) {
                for (int i12 = 2; i12 < s5; i12 += 2) {
                    if (this.bb.getShort(capacity + i12) != this.bb.getShort(i11 + i12)) {
                        break;
                    }
                }
                i6 = this.vtables[i10];
                break loop2;
            }
            i10++;
        }
        if (i6 != 0) {
            int capacity2 = this.bb.capacity() - offset;
            this.space = capacity2;
            this.bb.putInt(capacity2, i6 - offset);
        } else {
            int i13 = this.num_vtables;
            int[] iArr = this.vtables;
            if (i13 == iArr.length) {
                this.vtables = Arrays.copyOf(iArr, i13 * 2);
            }
            int[] iArr2 = this.vtables;
            int i14 = this.num_vtables;
            this.num_vtables = i14 + 1;
            iArr2[i14] = offset();
            ByteBuffer byteBuffer = this.bb;
            byteBuffer.putInt(byteBuffer.capacity() - offset, offset() - offset);
        }
        this.nested = false;
        return offset;
    }

    public int endVector() {
        if (!this.nested) {
            throw new AssertionError("FlatBuffers: endVector called without startVector");
        }
        this.nested = false;
        putInt(this.vector_num_elems);
        return offset();
    }

    public void finishSizePrefixed(int i6, String str) {
        finish(i6, str, true);
    }

    public void finished() {
        if (!this.finished) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    public FlatBufferBuilder forceDefaults(boolean z5) {
        this.force_defaults = z5;
        return this;
    }

    public FlatBufferBuilder init(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this.bb_factory = byteBufferFactory;
        this.bb = byteBuffer;
        byteBuffer.clear();
        this.bb.order(ByteOrder.LITTLE_ENDIAN);
        this.minalign = 1;
        this.space = this.bb.capacity();
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.object_start = 0;
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        return this;
    }

    public void notNested() {
        if (this.nested) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    public int offset() {
        return this.bb.capacity() - this.space;
    }

    public void prep(int i6, int i7) {
        if (i6 > this.minalign) {
            this.minalign = i6;
        }
        int i8 = ((~((this.bb.capacity() - this.space) + i7)) + 1) & (i6 - 1);
        while (this.space < i8 + i6 + i7) {
            int capacity = this.bb.capacity();
            ByteBuffer byteBuffer = this.bb;
            ByteBuffer growByteBuffer = growByteBuffer(byteBuffer, this.bb_factory);
            this.bb = growByteBuffer;
            if (byteBuffer != growByteBuffer) {
                this.bb_factory.releaseByteBuffer(byteBuffer);
            }
            this.space += this.bb.capacity() - capacity;
        }
        pad(i8);
    }

    public void putBoolean(boolean z5) {
        ByteBuffer byteBuffer = this.bb;
        int i6 = this.space - 1;
        this.space = i6;
        byteBuffer.put(i6, z5 ? (byte) 1 : (byte) 0);
    }

    public void putByte(byte b6) {
        ByteBuffer byteBuffer = this.bb;
        int i6 = this.space - 1;
        this.space = i6;
        byteBuffer.put(i6, b6);
    }

    public void putDouble(double d6) {
        ByteBuffer byteBuffer = this.bb;
        int i6 = this.space - 8;
        this.space = i6;
        byteBuffer.putDouble(i6, d6);
    }

    public void putFloat(float f6) {
        ByteBuffer byteBuffer = this.bb;
        int i6 = this.space - 4;
        this.space = i6;
        byteBuffer.putFloat(i6, f6);
    }

    public void putInt(int i6) {
        ByteBuffer byteBuffer = this.bb;
        int i7 = this.space - 4;
        this.space = i7;
        byteBuffer.putInt(i7, i6);
    }

    public void putLong(long j6) {
        ByteBuffer byteBuffer = this.bb;
        int i6 = this.space - 8;
        this.space = i6;
        byteBuffer.putLong(i6, j6);
    }

    public void putShort(short s5) {
        ByteBuffer byteBuffer = this.bb;
        int i6 = this.space - 2;
        this.space = i6;
        byteBuffer.putShort(i6, s5);
    }

    public void required(int i6, int i7) {
        int capacity = this.bb.capacity() - i6;
        if (this.bb.getShort((capacity - this.bb.getInt(capacity)) + i7) != 0) {
            return;
        }
        throw new AssertionError("FlatBuffers: field " + i7 + " must be set");
    }

    public void slot(int i6) {
        this.vtable[i6] = offset();
    }

    @Deprecated
    private int dataStart() {
        finished();
        return this.space;
    }

    static ByteBuffer growByteBuffer(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        int i6;
        int capacity = byteBuffer.capacity();
        if (((-1073741824) & capacity) == 0) {
            if (capacity == 0) {
                i6 = 1;
            } else {
                i6 = capacity << 1;
            }
            byteBuffer.position(0);
            ByteBuffer newByteBuffer = byteBufferFactory.newByteBuffer(i6);
            newByteBuffer.position(newByteBuffer.clear().capacity() - capacity);
            newByteBuffer.put(byteBuffer);
            return newByteBuffer;
        }
        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    }

    public static boolean isFieldPresent(Table table, int i6) {
        if (table.__offset(i6) != 0) {
            return true;
        }
        return false;
    }

    public void Nested(int i6) {
        if (i6 == offset()) {
        } else {
            throw new AssertionError("FlatBuffers: struct must be serialized inline.");
        }
    }

    public int createVectorOfTables(int[] iArr) {
        notNested();
        startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            addOffset(iArr[length]);
        }
        return endVector();
    }

    public ByteBuffer dataBuffer() {
        finished();
        return this.bb;
    }

    public InputStream sizedInputStream() {
        finished();
        ByteBuffer duplicate = this.bb.duplicate();
        duplicate.position(this.space);
        duplicate.limit(this.bb.capacity());
        return new ByteBufferBackedInputStream(duplicate);
    }

    public void startTable(int i6) {
        notNested();
        int[] iArr = this.vtable;
        if (iArr == null || iArr.length < i6) {
            this.vtable = new int[i6];
        }
        this.vtable_in_use = i6;
        Arrays.fill(this.vtable, 0, i6, 0);
        this.nested = true;
        this.object_start = offset();
    }

    public void startVector(int i6, int i7, int i8) {
        notNested();
        this.vector_num_elems = i7;
        int i9 = i6 * i7;
        prep(4, i9);
        prep(i8, i9);
        this.nested = true;
    }

    public void addOffset(int i6, int i7, int i8) {
        if (this.force_defaults || i7 != i8) {
            addOffset(i7);
            slot(i6);
        }
    }

    public byte[] sizedByteArray() {
        return sizedByteArray(this.space, this.bb.capacity() - this.space);
    }

    public int createByteVector(byte[] bArr, int i6, int i7) {
        startVector(1, i7, 1);
        ByteBuffer byteBuffer = this.bb;
        int i8 = this.space - i7;
        this.space = i8;
        byteBuffer.position(i8);
        this.bb.put(bArr, i6, i7);
        return endVector();
    }

    public void finish(int i6) {
        finish(i6, false);
    }

    public int createString(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        addByte((byte) 0);
        startVector(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.bb;
        int i6 = this.space - remaining;
        this.space = i6;
        byteBuffer2.position(i6);
        this.bb.put(byteBuffer);
        return endVector();
    }

    protected void finish(int i6, String str, boolean z5) {
        prep(this.minalign, (z5 ? 4 : 0) + 8);
        if (str.length() == 4) {
            for (int i7 = 3; i7 >= 0; i7--) {
                addByte((byte) str.charAt(i7));
            }
            finish(i6, z5);
            return;
        }
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    }

    public int createByteVector(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        startVector(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.bb;
        int i6 = this.space - remaining;
        this.space = i6;
        byteBuffer2.position(i6);
        this.bb.put(byteBuffer);
        return endVector();
    }

    public void finish(int i6, String str) {
        finish(i6, str, false);
    }

    public FlatBufferBuilder(int i6) {
        this(i6, HeapByteBufferFactory.INSTANCE, null, Utf8.getDefault());
    }

    public FlatBufferBuilder() {
        this(1024);
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this(byteBuffer.capacity(), byteBufferFactory, byteBuffer, Utf8.getDefault());
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, new HeapByteBufferFactory());
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class ByteBufferFactory {
        public abstract ByteBuffer newByteBuffer(int i6);

        public void releaseByteBuffer(ByteBuffer byteBuffer) {
        }
    }
}
