package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.FlexBuffers;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class FlexBuffersBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BUILDER_FLAG_NONE = 0;
    public static final int BUILDER_FLAG_SHARE_ALL = 7;
    public static final int BUILDER_FLAG_SHARE_KEYS = 1;
    public static final int BUILDER_FLAG_SHARE_KEYS_AND_STRINGS = 3;
    public static final int BUILDER_FLAG_SHARE_KEY_VECTORS = 4;
    public static final int BUILDER_FLAG_SHARE_STRINGS = 2;
    private static final int WIDTH_16 = 1;
    private static final int WIDTH_32 = 2;
    private static final int WIDTH_64 = 3;
    private static final int WIDTH_8 = 0;
    private final ReadWriteBuf bb;
    private boolean finished;
    private final int flags;
    private Comparator<Value> keyComparator;
    private final HashMap<String, Integer> keyPool;
    private final ArrayList<Value> stack;
    private final HashMap<String, Integer> stringPool;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class Value {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final double dValue;
        long iValue;
        int key;
        final int minBitWidth;
        final int type;

        Value(int i6, int i7, int i8, long j6) {
            this.key = i6;
            this.type = i7;
            this.minBitWidth = i8;
            this.iValue = j6;
            this.dValue = Double.MIN_VALUE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int elemWidth(int i6, int i7) {
            return elemWidth(this.type, this.minBitWidth, this.iValue, i6, i7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int paddingBytes(int i6, int i7) {
            return ((~i6) + 1) & (i7 - 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte storedPackedType() {
            return storedPackedType(0);
        }

        static Value blob(int i6, int i7, int i8, int i9) {
            return new Value(i6, i8, i9, i7);
        }

        static Value bool(int i6, boolean z5) {
            return new Value(i6, 26, 0, z5 ? 1L : 0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int elemWidth(int i6, int i7, long j6, int i8, int i9) {
            if (FlexBuffers.isTypeInline(i6)) {
                return i7;
            }
            for (int i10 = 1; i10 <= 32; i10 *= 2) {
                int widthUInBits = FlexBuffersBuilder.widthUInBits((int) (((paddingBytes(i8, i10) + i8) + (i9 * i10)) - j6));
                if ((1 << widthUInBits) == i10) {
                    return widthUInBits;
                }
            }
            return 3;
        }

        static Value float32(int i6, float f6) {
            return new Value(i6, 3, 2, f6);
        }

        static Value float64(int i6, double d6) {
            return new Value(i6, 3, 3, d6);
        }

        static Value int16(int i6, int i7) {
            return new Value(i6, 1, 1, i7);
        }

        static Value int32(int i6, int i7) {
            return new Value(i6, 1, 2, i7);
        }

        static Value int64(int i6, long j6) {
            return new Value(i6, 1, 3, j6);
        }

        static Value int8(int i6, int i7) {
            return new Value(i6, 1, 0, i7);
        }

        private static byte packedType(int i6, int i7) {
            return (byte) (i6 | (i7 << 2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte storedPackedType(int i6) {
            return packedType(storedWidth(i6), this.type);
        }

        private int storedWidth(int i6) {
            return FlexBuffers.isTypeInline(this.type) ? Math.max(this.minBitWidth, i6) : this.minBitWidth;
        }

        static Value uInt16(int i6, int i7) {
            return new Value(i6, 2, 1, i7);
        }

        static Value uInt32(int i6, int i7) {
            return new Value(i6, 2, 2, i7);
        }

        static Value uInt64(int i6, long j6) {
            return new Value(i6, 2, 3, j6);
        }

        static Value uInt8(int i6, int i7) {
            return new Value(i6, 2, 0, i7);
        }

        Value(int i6, int i7, int i8, double d6) {
            this.key = i6;
            this.type = i7;
            this.minBitWidth = i8;
            this.dValue = d6;
            this.iValue = Long.MIN_VALUE;
        }
    }

    public FlexBuffersBuilder(int i6) {
        this(new ArrayReadWriteBuf(i6), 1);
    }

    private int align(int i6) {
        int i7 = 1 << i6;
        int paddingBytes = Value.paddingBytes(this.bb.writePosition(), i7);
        while (true) {
            int i8 = paddingBytes - 1;
            if (paddingBytes == 0) {
                return i7;
            }
            this.bb.put((byte) 0);
            paddingBytes = i8;
        }
    }

    private Value createKeyVector(int i6, int i7) {
        long j6 = i7;
        int max = Math.max(0, widthUInBits(j6));
        int i8 = i6;
        while (i8 < this.stack.size()) {
            int i9 = i8 + 1;
            max = Math.max(max, Value.elemWidth(4, 0, this.stack.get(i8).key, this.bb.writePosition(), i9));
            i8 = i9;
        }
        int align = align(max);
        writeInt(j6, align);
        int writePosition = this.bb.writePosition();
        while (i6 < this.stack.size()) {
            int i10 = this.stack.get(i6).key;
            writeOffset(this.stack.get(i6).key, align);
            i6++;
        }
        return new Value(-1, FlexBuffers.toTypedVector(4, 0), max, writePosition);
    }

    static int widthUInBits(long j6) {
        if (j6 <= FlexBuffers.Unsigned.byteToUnsignedInt((byte) -1)) {
            return 0;
        }
        if (j6 <= FlexBuffers.Unsigned.shortToUnsignedInt((short) -1)) {
            return 1;
        }
        return j6 <= FlexBuffers.Unsigned.intToUnsignedLong(-1) ? 2 : 3;
    }

    private Value writeBlob(int i6, byte[] bArr, int i7, boolean z5) {
        int widthUInBits = widthUInBits(bArr.length);
        writeInt(bArr.length, align(widthUInBits));
        int writePosition = this.bb.writePosition();
        this.bb.put(bArr, 0, bArr.length);
        if (z5) {
            this.bb.put((byte) 0);
        }
        return Value.blob(i6, writePosition, i7, widthUInBits);
    }

    private void writeDouble(double d6, int i6) {
        if (i6 == 4) {
            this.bb.putFloat((float) d6);
        } else if (i6 == 8) {
            this.bb.putDouble(d6);
        }
    }

    private void writeInt(long j6, int i6) {
        if (i6 == 1) {
            this.bb.put((byte) j6);
            return;
        }
        if (i6 == 2) {
            this.bb.putShort((short) j6);
        } else if (i6 == 4) {
            this.bb.putInt((int) j6);
        } else {
            if (i6 != 8) {
                return;
            }
            this.bb.putLong(j6);
        }
    }

    public int putBlob(byte[] bArr) {
        return putBlob(null, bArr);
    }

    public void putBoolean(boolean z5) {
        putBoolean(null, z5);
    }

    public void putFloat(float f6) {
        putFloat((String) null, f6);
    }

    public void putInt(int i6) {
        putInt((String) null, i6);
    }

    public int putString(String str) {
        return putString(null, str);
    }

    public void putUInt(int i6) {
        putUInt(null, i6);
    }

    public void putUInt64(BigInteger bigInteger) {
        putUInt64(null, bigInteger.longValue());
    }

    public FlexBuffersBuilder() {
        this(256);
    }

    private Value createVector(int i6, int i7, int i8, boolean z5, boolean z6, Value value) {
        int i9;
        int i10;
        int i11 = i8;
        long j6 = i11;
        int max = Math.max(0, widthUInBits(j6));
        if (value != null) {
            max = Math.max(max, value.elemWidth(this.bb.writePosition(), 0));
            i9 = 3;
        } else {
            i9 = 1;
        }
        int i12 = 4;
        int i13 = max;
        for (int i14 = i7; i14 < this.stack.size(); i14++) {
            i13 = Math.max(i13, this.stack.get(i14).elemWidth(this.bb.writePosition(), i14 + i9));
            if (z5 && i14 == i7) {
                i12 = this.stack.get(i14).type;
                if (!FlexBuffers.isTypedVectorElementType(i12)) {
                    throw new FlexBuffers.FlexBufferException("TypedVector does not support this element type");
                }
            }
        }
        int i15 = i7;
        int align = align(i13);
        if (value != null) {
            writeOffset(value.iValue, align);
            writeInt(1 << value.minBitWidth, align);
        }
        if (!z6) {
            writeInt(j6, align);
        }
        int writePosition = this.bb.writePosition();
        for (int i16 = i15; i16 < this.stack.size(); i16++) {
            writeAny(this.stack.get(i16), align);
        }
        if (!z5) {
            while (i15 < this.stack.size()) {
                this.bb.put(this.stack.get(i15).storedPackedType(i13));
                i15++;
            }
        }
        if (value != null) {
            i10 = 9;
        } else if (z5) {
            if (!z6) {
                i11 = 0;
            }
            i10 = FlexBuffers.toTypedVector(i12, i11);
        } else {
            i10 = 10;
        }
        return new Value(i6, i10, i13, writePosition);
    }

    private int putKey(String str) {
        if (str == null) {
            return -1;
        }
        int writePosition = this.bb.writePosition();
        if ((this.flags & 1) == 0) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            this.bb.put(bytes, 0, bytes.length);
            this.bb.put((byte) 0);
            this.keyPool.put(str, Integer.valueOf(writePosition));
            return writePosition;
        }
        Integer num = this.keyPool.get(str);
        if (num != null) {
            return num.intValue();
        }
        byte[] bytes2 = str.getBytes(StandardCharsets.UTF_8);
        this.bb.put(bytes2, 0, bytes2.length);
        this.bb.put((byte) 0);
        this.keyPool.put(str, Integer.valueOf(writePosition));
        return writePosition;
    }

    private void putUInt64(String str, long j6) {
        this.stack.add(Value.uInt64(putKey(str), j6));
    }

    private void writeAny(Value value, int i6) {
        int i7 = value.type;
        if (i7 != 0 && i7 != 1 && i7 != 2) {
            if (i7 == 3) {
                writeDouble(value.dValue, i6);
                return;
            } else if (i7 != 26) {
                writeOffset(value.iValue, i6);
                return;
            }
        }
        writeInt(value.iValue, i6);
    }

    private void writeOffset(long j6, int i6) {
        writeInt((int) (this.bb.writePosition() - j6), i6);
    }

    private Value writeString(int i6, String str) {
        return writeBlob(i6, str.getBytes(StandardCharsets.UTF_8), 5, true);
    }

    public ByteBuffer finish() {
        int align = align(this.stack.get(0).elemWidth(this.bb.writePosition(), 0));
        writeAny(this.stack.get(0), align);
        this.bb.put(this.stack.get(0).storedPackedType());
        this.bb.put((byte) align);
        this.finished = true;
        return ByteBuffer.wrap(this.bb.data(), 0, this.bb.writePosition());
    }

    public ReadWriteBuf getBuffer() {
        return this.bb;
    }

    public int putBlob(String str, byte[] bArr) {
        Value writeBlob = writeBlob(putKey(str), bArr, 25, false);
        this.stack.add(writeBlob);
        return (int) writeBlob.iValue;
    }

    public void putBoolean(String str, boolean z5) {
        this.stack.add(Value.bool(putKey(str), z5));
    }

    public void putFloat(String str, float f6) {
        this.stack.add(Value.float32(putKey(str), f6));
    }

    public void putInt(String str, int i6) {
        putInt(str, i6);
    }

    public int putString(String str, String str2) {
        long j6;
        int putKey = putKey(str);
        if ((this.flags & 2) != 0) {
            Integer num = this.stringPool.get(str2);
            if (num != null) {
                this.stack.add(Value.blob(putKey, num.intValue(), 5, widthUInBits(str2.length())));
                return num.intValue();
            }
            Value writeString = writeString(putKey, str2);
            this.stringPool.put(str2, Integer.valueOf((int) writeString.iValue));
            this.stack.add(writeString);
            j6 = writeString.iValue;
        } else {
            Value writeString2 = writeString(putKey, str2);
            this.stack.add(writeString2);
            j6 = writeString2.iValue;
        }
        return (int) j6;
    }

    public void putUInt(long j6) {
        putUInt(null, j6);
    }

    public int startMap() {
        return this.stack.size();
    }

    public int startVector() {
        return this.stack.size();
    }

    @Deprecated
    public FlexBuffersBuilder(ByteBuffer byteBuffer, int i6) {
        this(new ArrayReadWriteBuf(byteBuffer.array()), i6);
    }

    private void putUInt(String str, long j6) {
        Value uInt64;
        int putKey = putKey(str);
        int widthUInBits = widthUInBits(j6);
        if (widthUInBits == 0) {
            uInt64 = Value.uInt8(putKey, (int) j6);
        } else if (widthUInBits == 1) {
            uInt64 = Value.uInt16(putKey, (int) j6);
        } else if (widthUInBits == 2) {
            uInt64 = Value.uInt32(putKey, (int) j6);
        } else {
            uInt64 = Value.uInt64(putKey, j6);
        }
        this.stack.add(uInt64);
    }

    public int endMap(String str, int i6) {
        int putKey = putKey(str);
        ArrayList<Value> arrayList = this.stack;
        Collections.sort(arrayList.subList(i6, arrayList.size()), this.keyComparator);
        Value createVector = createVector(putKey, i6, this.stack.size() - i6, false, false, createKeyVector(i6, this.stack.size() - i6));
        while (this.stack.size() > i6) {
            this.stack.remove(r9.size() - 1);
        }
        this.stack.add(createVector);
        return (int) createVector.iValue;
    }

    public int endVector(String str, int i6, boolean z5, boolean z6) {
        Value createVector = createVector(putKey(str), i6, this.stack.size() - i6, z5, z6, null);
        while (this.stack.size() > i6) {
            this.stack.remove(r9.size() - 1);
        }
        this.stack.add(createVector);
        return (int) createVector.iValue;
    }

    public void putFloat(double d6) {
        putFloat((String) null, d6);
    }

    public void putInt(String str, long j6) {
        int putKey = putKey(str);
        if (-128 <= j6 && j6 <= 127) {
            this.stack.add(Value.int8(putKey, (int) j6));
            return;
        }
        if (-32768 <= j6 && j6 <= 32767) {
            this.stack.add(Value.int16(putKey, (int) j6));
        } else if (-2147483648L <= j6 && j6 <= 2147483647L) {
            this.stack.add(Value.int32(putKey, (int) j6));
        } else {
            this.stack.add(Value.int64(putKey, j6));
        }
    }

    public FlexBuffersBuilder(ReadWriteBuf readWriteBuf, int i6) {
        this.stack = new ArrayList<>();
        this.keyPool = new HashMap<>();
        this.stringPool = new HashMap<>();
        this.finished = false;
        this.keyComparator = new Comparator<Value>() { // from class: androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.1
            @Override // java.util.Comparator
            public int compare(Value value, Value value2) {
                byte b6;
                byte b7;
                int i7 = value.key;
                int i8 = value2.key;
                do {
                    b6 = FlexBuffersBuilder.this.bb.get(i7);
                    b7 = FlexBuffersBuilder.this.bb.get(i8);
                    if (b6 == 0) {
                        return b6 - b7;
                    }
                    i7++;
                    i8++;
                } while (b6 == b7);
                return b6 - b7;
            }
        };
        this.bb = readWriteBuf;
        this.flags = i6;
    }

    public void putFloat(String str, double d6) {
        this.stack.add(Value.float64(putKey(str), d6));
    }

    public void putInt(long j6) {
        putInt((String) null, j6);
    }

    public FlexBuffersBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, 1);
    }
}
