package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import kotlin.j1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class FlexBuffers {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ReadBuf EMPTY_BB = new ArrayReadWriteBuf(new byte[]{0}, 1);
    public static final int FBT_BLOB = 25;
    public static final int FBT_BOOL = 26;
    public static final int FBT_FLOAT = 3;
    public static final int FBT_INDIRECT_FLOAT = 8;
    public static final int FBT_INDIRECT_INT = 6;
    public static final int FBT_INDIRECT_UINT = 7;
    public static final int FBT_INT = 1;
    public static final int FBT_KEY = 4;
    public static final int FBT_MAP = 9;
    public static final int FBT_NULL = 0;
    public static final int FBT_STRING = 5;
    public static final int FBT_UINT = 2;
    public static final int FBT_VECTOR = 10;
    public static final int FBT_VECTOR_BOOL = 36;
    public static final int FBT_VECTOR_FLOAT = 13;
    public static final int FBT_VECTOR_FLOAT2 = 18;
    public static final int FBT_VECTOR_FLOAT3 = 21;
    public static final int FBT_VECTOR_FLOAT4 = 24;
    public static final int FBT_VECTOR_INT = 11;
    public static final int FBT_VECTOR_INT2 = 16;
    public static final int FBT_VECTOR_INT3 = 19;
    public static final int FBT_VECTOR_INT4 = 22;
    public static final int FBT_VECTOR_KEY = 14;
    public static final int FBT_VECTOR_STRING_DEPRECATED = 15;
    public static final int FBT_VECTOR_UINT = 12;
    public static final int FBT_VECTOR_UINT2 = 17;
    public static final int FBT_VECTOR_UINT3 = 20;
    public static final int FBT_VECTOR_UINT4 = 23;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Blob extends Sized {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final Blob EMPTY = new Blob(FlexBuffers.EMPTY_BB, 1, 1);

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            return this.bb.getString(this.end, size());
        }

        public static Blob empty() {
            return EMPTY;
        }

        public ByteBuffer data() {
            ByteBuffer wrap = ByteBuffer.wrap(this.bb.data());
            wrap.position(this.end);
            wrap.limit(this.end + size());
            return wrap.asReadOnlyBuffer().slice();
        }

        public byte get(int i6) {
            return this.bb.get(this.end + i6);
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb) {
            sb.append('\"');
            sb.append(this.bb.getString(this.end, size()));
            sb.append('\"');
            return sb;
        }

        Blob(ReadBuf readBuf, int i6, int i7) {
            super(readBuf, i6, i7);
        }

        public byte[] getBytes() {
            int size = size();
            byte[] bArr = new byte[size];
            for (int i6 = 0; i6 < size; i6++) {
                bArr[i6] = this.bb.get(this.end + i6);
            }
            return bArr;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Key extends Object {
        private static final Key EMPTY = new Key(FlexBuffers.EMPTY_BB, 0, 0);

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb) {
            sb.append(toString());
            return sb;
        }

        public static Key empty() {
            return EMPTY;
        }

        int compareTo(byte[] bArr) {
            byte b6;
            byte b7;
            int i6 = this.end;
            int i7 = 0;
            do {
                b6 = this.bb.get(i6);
                b7 = bArr[i7];
                if (b6 == 0) {
                    return b6 - b7;
                }
                i6++;
                i7++;
                if (i7 == bArr.length) {
                    return b6 - b7;
                }
            } while (b6 == b7);
            return b6 - b7;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return key.end == this.end && key.byteWidth == this.byteWidth;
        }

        public int hashCode() {
            return this.end ^ this.byteWidth;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            int i6 = this.end;
            while (this.bb.get(i6) != 0) {
                i6++;
            }
            int i7 = this.end;
            return this.bb.getString(i7, i6 - i7);
        }

        Key(ReadBuf readBuf, int i6, int i7) {
            super(readBuf, i6, i7);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class KeyVector {
        private final TypedVector vec;

        public int size() {
            return this.vec.size();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i6 = 0; i6 < this.vec.size(); i6++) {
                this.vec.get(i6).toString(sb);
                if (i6 != this.vec.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }

        KeyVector(TypedVector typedVector) {
            this.vec = typedVector;
        }

        public Key get(int i6) {
            if (i6 >= size()) {
                return Key.EMPTY;
            }
            TypedVector typedVector = this.vec;
            int i7 = typedVector.end + (i6 * typedVector.byteWidth);
            TypedVector typedVector2 = this.vec;
            ReadBuf readBuf = typedVector2.bb;
            return new Key(readBuf, FlexBuffers.indirect(readBuf, i7, typedVector2.byteWidth), 1);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Map extends Vector {
        private static final Map EMPTY_MAP = new Map(FlexBuffers.EMPTY_BB, 1, 1);

        public Reference get(String str) {
            return get(str.getBytes(StandardCharsets.UTF_8));
        }

        public static Map empty() {
            return EMPTY_MAP;
        }

        public Reference get(byte[] bArr) {
            KeyVector keys = keys();
            int size = keys.size();
            int binarySearch = binarySearch(keys, bArr);
            return (binarySearch < 0 || binarySearch >= size) ? Reference.NULL_REFERENCE : get(binarySearch);
        }

        public KeyVector keys() {
            int i6 = this.end - (this.byteWidth * 3);
            ReadBuf readBuf = this.bb;
            int indirect = FlexBuffers.indirect(readBuf, i6, this.byteWidth);
            ReadBuf readBuf2 = this.bb;
            int i7 = this.byteWidth;
            return new KeyVector(new TypedVector(readBuf, indirect, FlexBuffers.readInt(readBuf2, i6 + i7, i7), 4));
        }

        public Vector values() {
            return new Vector(this.bb, this.end, this.byteWidth);
        }

        Map(ReadBuf readBuf, int i6, int i7) {
            super(readBuf, i6, i7);
        }

        private int binarySearch(KeyVector keyVector, byte[] bArr) {
            int size = keyVector.size() - 1;
            int i6 = 0;
            while (i6 <= size) {
                int i7 = (i6 + size) >>> 1;
                int compareTo = keyVector.get(i7).compareTo(bArr);
                if (compareTo < 0) {
                    i6 = i7 + 1;
                } else if (compareTo > 0) {
                    size = i7 - 1;
                } else {
                    return i7;
                }
            }
            return -(i6 + 1);
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector, androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb) {
            sb.append("{ ");
            KeyVector keys = keys();
            int size = size();
            Vector values = values();
            for (int i6 = 0; i6 < size; i6++) {
                sb.append('\"');
                sb.append(keys.get(i6).toString());
                sb.append("\" : ");
                sb.append(values.get(i6).toString());
                if (i6 != size - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" }");
            return sb;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Reference {
        private static final Reference NULL_REFERENCE = new Reference(FlexBuffers.EMPTY_BB, 0, 1, 0);
        private ReadBuf bb;
        private int byteWidth;
        private int end;
        private int parentWidth;
        private int type;

        Reference(ReadBuf readBuf, int i6, int i7, int i8) {
            this(readBuf, i6, i7, 1 << (i8 & 3), i8 >> 2);
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        Reference(ReadBuf readBuf, int i6, int i7, int i8, int i9) {
            this.bb = readBuf;
            this.end = i6;
            this.parentWidth = i7;
            this.byteWidth = i8;
            this.type = i9;
        }

        public double asFloat() {
            int i6 = this.type;
            if (i6 == 3) {
                return FlexBuffers.readDouble(this.bb, this.end, this.parentWidth);
            }
            if (i6 == 1) {
                return FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
            }
            if (i6 != 2) {
                if (i6 == 5) {
                    return Double.parseDouble(asString());
                }
                if (i6 == 6) {
                    ReadBuf readBuf = this.bb;
                    return FlexBuffers.readInt(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
                }
                if (i6 == 7) {
                    ReadBuf readBuf2 = this.bb;
                    return FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth);
                }
                if (i6 == 8) {
                    ReadBuf readBuf3 = this.bb;
                    return FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth);
                }
                if (i6 == 10) {
                    return asVector().size();
                }
                if (i6 != 26) {
                    return 0.0d;
                }
            }
            return FlexBuffers.readUInt(this.bb, this.end, this.parentWidth);
        }

        public int asInt() {
            long readUInt;
            int i6 = this.type;
            if (i6 == 1) {
                return FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
            }
            if (i6 == 2) {
                readUInt = FlexBuffers.readUInt(this.bb, this.end, this.parentWidth);
            } else {
                if (i6 == 3) {
                    return (int) FlexBuffers.readDouble(this.bb, this.end, this.parentWidth);
                }
                if (i6 == 5) {
                    return Integer.parseInt(asString());
                }
                if (i6 == 6) {
                    ReadBuf readBuf = this.bb;
                    return FlexBuffers.readInt(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
                }
                if (i6 != 7) {
                    if (i6 == 8) {
                        ReadBuf readBuf2 = this.bb;
                        return (int) FlexBuffers.readDouble(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth);
                    }
                    if (i6 == 10) {
                        return asVector().size();
                    }
                    if (i6 != 26) {
                        return 0;
                    }
                    return FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
                }
                ReadBuf readBuf3 = this.bb;
                readUInt = FlexBuffers.readUInt(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.parentWidth);
            }
            return (int) readUInt;
        }

        public long asLong() {
            int i6 = this.type;
            if (i6 == 1) {
                return FlexBuffers.readLong(this.bb, this.end, this.parentWidth);
            }
            if (i6 == 2) {
                return FlexBuffers.readUInt(this.bb, this.end, this.parentWidth);
            }
            if (i6 == 3) {
                return (long) FlexBuffers.readDouble(this.bb, this.end, this.parentWidth);
            }
            if (i6 == 5) {
                try {
                    return Long.parseLong(asString());
                } catch (NumberFormatException unused) {
                    return 0L;
                }
            }
            if (i6 == 6) {
                ReadBuf readBuf = this.bb;
                return FlexBuffers.readLong(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            if (i6 == 7) {
                ReadBuf readBuf2 = this.bb;
                return FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.parentWidth);
            }
            if (i6 == 8) {
                ReadBuf readBuf3 = this.bb;
                return (long) FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth);
            }
            if (i6 == 10) {
                return asVector().size();
            }
            if (i6 != 26) {
                return 0L;
            }
            return FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
        }

        public long asUInt() {
            int i6 = this.type;
            if (i6 == 2) {
                return FlexBuffers.readUInt(this.bb, this.end, this.parentWidth);
            }
            if (i6 == 1) {
                return FlexBuffers.readLong(this.bb, this.end, this.parentWidth);
            }
            if (i6 == 3) {
                return (long) FlexBuffers.readDouble(this.bb, this.end, this.parentWidth);
            }
            if (i6 == 10) {
                return asVector().size();
            }
            if (i6 == 26) {
                return FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
            }
            if (i6 == 5) {
                return Long.parseLong(asString());
            }
            if (i6 == 6) {
                ReadBuf readBuf = this.bb;
                return FlexBuffers.readLong(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            if (i6 == 7) {
                ReadBuf readBuf2 = this.bb;
                return FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth);
            }
            if (i6 != 8) {
                return 0L;
            }
            ReadBuf readBuf3 = this.bb;
            return (long) FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.parentWidth);
        }

        public int getType() {
            return this.type;
        }

        public boolean isBlob() {
            return this.type == 25;
        }

        public boolean isBoolean() {
            return this.type == 26;
        }

        public boolean isFloat() {
            int i6 = this.type;
            return i6 == 3 || i6 == 8;
        }

        public boolean isInt() {
            int i6 = this.type;
            return i6 == 1 || i6 == 6;
        }

        public boolean isKey() {
            return this.type == 4;
        }

        public boolean isMap() {
            return this.type == 9;
        }

        public boolean isNull() {
            return this.type == 0;
        }

        public boolean isString() {
            return this.type == 5;
        }

        public boolean isTypedVector() {
            return FlexBuffers.isTypedVector(this.type);
        }

        public boolean isUInt() {
            int i6 = this.type;
            return i6 == 2 || i6 == 7;
        }

        public boolean isVector() {
            int i6 = this.type;
            return i6 == 10 || i6 == 9;
        }

        StringBuilder toString(StringBuilder sb) {
            int i6 = this.type;
            if (i6 != 36) {
                switch (i6) {
                    case 0:
                        sb.append("null");
                        return sb;
                    case 1:
                    case 6:
                        sb.append(asLong());
                        return sb;
                    case 2:
                    case 7:
                        sb.append(asUInt());
                        return sb;
                    case 3:
                    case 8:
                        sb.append(asFloat());
                        return sb;
                    case 4:
                        Key asKey = asKey();
                        sb.append('\"');
                        StringBuilder key = asKey.toString(sb);
                        key.append('\"');
                        return key;
                    case 5:
                        sb.append('\"');
                        sb.append(asString());
                        sb.append('\"');
                        return sb;
                    case 9:
                        return asMap().toString(sb);
                    case 10:
                        return asVector().toString(sb);
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        throw new FlexBufferException("not_implemented:" + this.type);
                    case 25:
                        return asBlob().toString(sb);
                    case 26:
                        sb.append(asBoolean());
                        return sb;
                    default:
                        return sb;
                }
            }
            sb.append(asVector());
            return sb;
        }

        public Blob asBlob() {
            if (!isBlob() && !isString()) {
                return Blob.empty();
            }
            ReadBuf readBuf = this.bb;
            return new Blob(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
        }

        public boolean asBoolean() {
            if (isBoolean()) {
                if (this.bb.get(this.end) == 0) {
                    return false;
                }
                return true;
            }
            if (asUInt() == 0) {
                return false;
            }
            return true;
        }

        public Key asKey() {
            if (isKey()) {
                ReadBuf readBuf = this.bb;
                return new Key(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            return Key.empty();
        }

        public Map asMap() {
            if (isMap()) {
                ReadBuf readBuf = this.bb;
                return new Map(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            return Map.empty();
        }

        public String asString() {
            if (isString()) {
                int indirect = FlexBuffers.indirect(this.bb, this.end, this.parentWidth);
                ReadBuf readBuf = this.bb;
                int i6 = this.byteWidth;
                return this.bb.getString(indirect, (int) FlexBuffers.readUInt(readBuf, indirect - i6, i6));
            }
            if (isKey()) {
                int indirect2 = FlexBuffers.indirect(this.bb, this.end, this.byteWidth);
                int i7 = indirect2;
                while (this.bb.get(i7) != 0) {
                    i7++;
                }
                return this.bb.getString(indirect2, i7 - indirect2);
            }
            return "";
        }

        public Vector asVector() {
            if (isVector()) {
                ReadBuf readBuf = this.bb;
                return new Vector(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            int i6 = this.type;
            if (i6 == 15) {
                ReadBuf readBuf2 = this.bb;
                return new TypedVector(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth, 4);
            }
            if (FlexBuffers.isTypedVector(i6)) {
                ReadBuf readBuf3 = this.bb;
                return new TypedVector(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth, FlexBuffers.toTypedVectorElementType(this.type));
            }
            return Vector.empty();
        }

        public boolean isIntOrUInt() {
            if (!isInt() && !isUInt()) {
                return false;
            }
            return true;
        }

        public boolean isNumeric() {
            if (!isIntOrUInt() && !isFloat()) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class Sized extends Object {
        protected final int size;

        public int size() {
            return this.size;
        }

        Sized(ReadBuf readBuf, int i6, int i7) {
            super(readBuf, i6, i7);
            this.size = FlexBuffers.readInt(this.bb, i6 - i7, i7);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class TypedVector extends Vector {
        private static final TypedVector EMPTY_VECTOR = new TypedVector(FlexBuffers.EMPTY_BB, 1, 1, 1);
        private final int elemType;

        public static TypedVector empty() {
            return EMPTY_VECTOR;
        }

        public int getElemType() {
            return this.elemType;
        }

        public boolean isEmptyVector() {
            return this == EMPTY_VECTOR;
        }

        TypedVector(ReadBuf readBuf, int i6, int i7, int i8) {
            super(readBuf, i6, i7);
            this.elemType = i8;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector
        public Reference get(int i6) {
            if (i6 >= size()) {
                return Reference.NULL_REFERENCE;
            }
            return new Reference(this.bb, this.end + (i6 * this.byteWidth), this.byteWidth, 1, this.elemType);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class Unsigned {
        static long intToUnsignedLong(int i6) {
            return i6 & 4294967295L;
        }

        static int byteToUnsignedInt(byte b6) {
            return b6 & 255;
        }

        Unsigned() {
        }

        static int shortToUnsignedInt(short s5) {
            return s5 & j1.f43986d;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Vector extends Sized {
        private static final Vector EMPTY_VECTOR = new Vector(FlexBuffers.EMPTY_BB, 1, 1);

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        public static Vector empty() {
            return EMPTY_VECTOR;
        }

        public boolean isEmpty() {
            return this == EMPTY_VECTOR;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb) {
            sb.append("[ ");
            int size = size();
            for (int i6 = 0; i6 < size; i6++) {
                get(i6).toString(sb);
                if (i6 != size - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" ]");
            return sb;
        }

        Vector(ReadBuf readBuf, int i6, int i7) {
            super(readBuf, i6, i7);
        }

        public Reference get(int i6) {
            long size = size();
            long j6 = i6;
            if (j6 >= size) {
                return Reference.NULL_REFERENCE;
            }
            return new Reference(this.bb, this.end + (i6 * this.byteWidth), this.byteWidth, Unsigned.byteToUnsignedInt(this.bb.get((int) (this.end + (size * this.byteWidth) + j6))));
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }
    }

    @Deprecated
    public static Reference getRoot(ByteBuffer byteBuffer) {
        return getRoot(byteBuffer.hasArray() ? new ArrayReadWriteBuf(byteBuffer.array(), byteBuffer.limit()) : new ByteBufferReadWriteBuf(byteBuffer));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indirect(ReadBuf readBuf, int i6, int i7) {
        return (int) (i6 - readUInt(readBuf, i6, i7));
    }

    static boolean isTypeInline(int i6) {
        return i6 <= 3 || i6 == 26;
    }

    static boolean isTypedVectorElementType(int i6) {
        return (i6 >= 1 && i6 <= 4) || i6 == 26;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double readDouble(ReadBuf readBuf, int i6, int i7) {
        if (i7 == 4) {
            return readBuf.getFloat(i6);
        }
        if (i7 != 8) {
            return -1.0d;
        }
        return readBuf.getDouble(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long readLong(ReadBuf readBuf, int i6, int i7) {
        int i8;
        if (i7 == 1) {
            i8 = readBuf.get(i6);
        } else if (i7 == 2) {
            i8 = readBuf.getShort(i6);
        } else {
            if (i7 != 4) {
                if (i7 != 8) {
                    return -1L;
                }
                return readBuf.getLong(i6);
            }
            i8 = readBuf.getInt(i6);
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long readUInt(ReadBuf readBuf, int i6, int i7) {
        if (i7 == 1) {
            return Unsigned.byteToUnsignedInt(readBuf.get(i6));
        }
        if (i7 == 2) {
            return Unsigned.shortToUnsignedInt(readBuf.getShort(i6));
        }
        if (i7 == 4) {
            return Unsigned.intToUnsignedLong(readBuf.getInt(i6));
        }
        if (i7 != 8) {
            return -1L;
        }
        return readBuf.getLong(i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class FlexBufferException extends RuntimeException {
        FlexBufferException(String str) {
            super(str);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class Object {
        ReadBuf bb;
        int byteWidth;
        int end;

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        public abstract StringBuilder toString(StringBuilder sb);

        Object(ReadBuf readBuf, int i6, int i7) {
            this.bb = readBuf;
            this.end = i6;
            this.byteWidth = i7;
        }
    }

    public static Reference getRoot(ReadBuf readBuf) {
        int limit = readBuf.limit();
        byte b6 = readBuf.get(limit - 1);
        int i6 = limit - 2;
        return new Reference(readBuf, i6 - b6, b6, Unsigned.byteToUnsignedInt(readBuf.get(i6)));
    }

    static boolean isTypedVector(int i6) {
        return (i6 >= 11 && i6 <= 15) || i6 == 36;
    }

    static int toTypedVector(int i6, int i7) {
        if (i7 == 0) {
            return i6 + 10;
        }
        if (i7 == 2) {
            return i6 + 15;
        }
        if (i7 == 3) {
            return i6 + 18;
        }
        if (i7 != 4) {
            return 0;
        }
        return i6 + 21;
    }

    static int toTypedVectorElementType(int i6) {
        return i6 - 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int readInt(ReadBuf readBuf, int i6, int i7) {
        return (int) readLong(readBuf, i6, i7);
    }
}
