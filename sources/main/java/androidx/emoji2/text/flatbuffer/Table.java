package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class Table {
    protected ByteBuffer bb;
    protected int bb_pos;
    Utf8 utf8 = Utf8.getDefault();
    private int vtable_size;
    private int vtable_start;

    protected static int compareStrings(int i6, int i7, ByteBuffer byteBuffer) {
        int i8 = i6 + byteBuffer.getInt(i6);
        int i9 = i7 + byteBuffer.getInt(i7);
        int i10 = byteBuffer.getInt(i8);
        int i11 = byteBuffer.getInt(i9);
        int i12 = i8 + 4;
        int i13 = i9 + 4;
        int min = Math.min(i10, i11);
        for (int i14 = 0; i14 < min; i14++) {
            int i15 = i14 + i12;
            int i16 = i14 + i13;
            if (byteBuffer.get(i15) != byteBuffer.get(i16)) {
                return byteBuffer.get(i15) - byteBuffer.get(i16);
            }
        }
        return i10 - i11;
    }

    protected int __indirect(int i6) {
        return i6 + this.bb.getInt(i6);
    }

    protected int __offset(int i6) {
        if (i6 < this.vtable_size) {
            return this.bb.getShort(this.vtable_start + i6);
        }
        return 0;
    }

    protected void __reset(int i6, ByteBuffer byteBuffer) {
        this.bb = byteBuffer;
        if (byteBuffer == null) {
            this.bb_pos = 0;
            this.vtable_start = 0;
            this.vtable_size = 0;
        } else {
            this.bb_pos = i6;
            int i7 = i6 - byteBuffer.getInt(i6);
            this.vtable_start = i7;
            this.vtable_size = this.bb.getShort(i7);
        }
    }

    protected String __string(int i6) {
        return __string(i6, this.bb, this.utf8);
    }

    protected Table __union(Table table, int i6) {
        return __union(table, i6, this.bb);
    }

    protected int keysCompare(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return 0;
    }

    protected void sortTables(int[] iArr, final ByteBuffer byteBuffer) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i6 = 0; i6 < iArr.length; i6++) {
            numArr[i6] = Integer.valueOf(iArr[i6]);
        }
        Arrays.sort(numArr, new Comparator<Integer>() { // from class: androidx.emoji2.text.flatbuffer.Table.1
            @Override // java.util.Comparator
            public int compare(Integer num, Integer num2) {
                return Table.this.keysCompare(num, num2, byteBuffer);
            }
        });
        for (int i7 = 0; i7 < iArr.length; i7++) {
            iArr[i7] = numArr[i7].intValue();
        }
    }

    protected static int __indirect(int i6, ByteBuffer byteBuffer) {
        return i6 + byteBuffer.getInt(i6);
    }

    protected static int __offset(int i6, int i7, ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity() - i7;
        return byteBuffer.getShort((i6 + capacity) - byteBuffer.getInt(capacity)) + capacity;
    }

    protected static String __string(int i6, ByteBuffer byteBuffer, Utf8 utf8) {
        int i7 = i6 + byteBuffer.getInt(i6);
        return utf8.decodeUtf8(byteBuffer, i7 + 4, byteBuffer.getInt(i7));
    }

    protected static Table __union(Table table, int i6, ByteBuffer byteBuffer) {
        table.__reset(__indirect(i6, byteBuffer), byteBuffer);
        return table;
    }

    protected int __vector(int i6) {
        int i7 = i6 + this.bb_pos;
        return i7 + this.bb.getInt(i7) + 4;
    }

    protected int __vector_len(int i6) {
        int i7 = i6 + this.bb_pos;
        return this.bb.getInt(i7 + this.bb.getInt(i7));
    }

    public ByteBuffer getByteBuffer() {
        return this.bb;
    }

    protected static boolean __has_identifier(ByteBuffer byteBuffer, String str) {
        if (str.length() == 4) {
            for (int i6 = 0; i6 < 4; i6++) {
                if (str.charAt(i6) != ((char) byteBuffer.get(byteBuffer.position() + 4 + i6))) {
                    return false;
                }
            }
            return true;
        }
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    }

    protected ByteBuffer __vector_as_bytebuffer(int i6, int i7) {
        int __offset = __offset(i6);
        if (__offset == 0) {
            return null;
        }
        ByteBuffer order = this.bb.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        int __vector = __vector(__offset);
        order.position(__vector);
        order.limit(__vector + (__vector_len(__offset) * i7));
        return order;
    }

    protected ByteBuffer __vector_in_bytebuffer(ByteBuffer byteBuffer, int i6, int i7) {
        int __offset = __offset(i6);
        if (__offset == 0) {
            return null;
        }
        int __vector = __vector(__offset);
        byteBuffer.rewind();
        byteBuffer.limit((__vector_len(__offset) * i7) + __vector);
        byteBuffer.position(__vector);
        return byteBuffer;
    }

    protected static int compareStrings(int i6, byte[] bArr, ByteBuffer byteBuffer) {
        int i7 = i6 + byteBuffer.getInt(i6);
        int i8 = byteBuffer.getInt(i7);
        int length = bArr.length;
        int i9 = i7 + 4;
        int min = Math.min(i8, length);
        for (int i10 = 0; i10 < min; i10++) {
            int i11 = i10 + i9;
            if (byteBuffer.get(i11) != bArr[i10]) {
                return byteBuffer.get(i11) - bArr[i10];
            }
        }
        return i8 - length;
    }

    public void __reset() {
        __reset(0, null);
    }
}
