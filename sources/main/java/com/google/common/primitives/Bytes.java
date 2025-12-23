package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Bytes {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @GwtCompatible
    private static class ByteArrayAsList extends AbstractList<Byte> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final byte[] array;
        final int end;
        final int start;

        ByteArrayAsList(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteArrayAsList)) {
                return super.equals(obj);
            }
            ByteArrayAsList byteArrayAsList = (ByteArrayAsList) obj;
            int size = size();
            if (byteArrayAsList.size() != size) {
                return false;
            }
            for (int i6 = 0; i6 < size; i6++) {
                if (this.array[this.start + i6] != byteArrayAsList.array[byteArrayAsList.start + i6]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        ByteArrayAsList(byte[] bArr, int i6, int i7) {
            this.array = bArr;
            this.start = i6;
            this.end = i7;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Byte) && Bytes.indexOf(this.array, ((Byte) obj).byteValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public Byte get(int i6) {
            Preconditions.checkElementIndex(i6, size());
            return Byte.valueOf(this.array[this.start + i6]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i6 = 1;
            for (int i7 = this.start; i7 < this.end; i7++) {
                i6 = (i6 * 31) + Bytes.hashCode(this.array[i7]);
            }
            return i6;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int indexOf;
            if (!(obj instanceof Byte) || (indexOf = Bytes.indexOf(this.array, ((Byte) obj).byteValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return indexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int lastIndexOf;
            if (!(obj instanceof Byte) || (lastIndexOf = Bytes.lastIndexOf(this.array, ((Byte) obj).byteValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return lastIndexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Byte set(int i6, Byte b6) {
            Preconditions.checkElementIndex(i6, size());
            byte[] bArr = this.array;
            int i7 = this.start;
            byte b7 = bArr[i7 + i6];
            bArr[i7 + i6] = ((Byte) Preconditions.checkNotNull(b6)).byteValue();
            return Byte.valueOf(b7);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        byte[] toByteArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            sb.append((int) this.array[this.start]);
            int i6 = this.start;
            while (true) {
                i6++;
                if (i6 >= this.end) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append((int) this.array[i6]);
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Byte> subList(int i6, int i7) {
            Preconditions.checkPositionIndexes(i6, i7, size());
            if (i6 == i7) {
                return Collections.EMPTY_LIST;
            }
            byte[] bArr = this.array;
            int i8 = this.start;
            return new ByteArrayAsList(bArr, i6 + i8, i8 + i7);
        }
    }

    public static List<Byte> asList(byte... bArr) {
        return bArr.length == 0 ? Collections.EMPTY_LIST : new ByteArrayAsList(bArr);
    }

    public static byte[] concat(byte[]... bArr) {
        int i6 = 0;
        for (byte[] bArr2 : bArr) {
            i6 += bArr2.length;
        }
        byte[] bArr3 = new byte[i6];
        int i7 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, i7, bArr4.length);
            i7 += bArr4.length;
        }
        return bArr3;
    }

    public static boolean contains(byte[] bArr, byte b6) {
        for (byte b7 : bArr) {
            if (b7 == b6) {
                return true;
            }
        }
        return false;
    }

    public static byte[] ensureCapacity(byte[] bArr, int i6, int i7) {
        Preconditions.checkArgument(i6 >= 0, "Invalid minLength: %s", i6);
        Preconditions.checkArgument(i7 >= 0, "Invalid padding: %s", i7);
        return bArr.length < i6 ? Arrays.copyOf(bArr, i6 + i7) : bArr;
    }

    public static int indexOf(byte[] bArr, byte b6) {
        return indexOf(bArr, b6, 0, bArr.length);
    }

    public static int lastIndexOf(byte[] bArr, byte b6) {
        return lastIndexOf(bArr, b6, 0, bArr.length);
    }

    public static void reverse(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        reverse(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(byte[] bArr, byte b6, int i6, int i7) {
        while (i6 < i7) {
            if (bArr[i6] == b6) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(byte[] bArr, byte b6, int i6, int i7) {
        for (int i8 = i7 - 1; i8 >= i6; i8--) {
            if (bArr[i8] == b6) {
                return i8;
            }
        }
        return -1;
    }

    public static byte[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof ByteArrayAsList) {
            return ((ByteArrayAsList) collection).toByteArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        byte[] bArr = new byte[length];
        for (int i6 = 0; i6 < length; i6++) {
            bArr[i6] = ((Number) Preconditions.checkNotNull(array[i6])).byteValue();
        }
        return bArr;
    }

    private Bytes() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int indexOf(byte[] r5, byte[] r6) {
        /*
            java.lang.String r0 = "array"
            com.google.common.base.Preconditions.checkNotNull(r5, r0)
            java.lang.String r0 = "target"
            com.google.common.base.Preconditions.checkNotNull(r6, r0)
            int r0 = r6.length
            r1 = 0
            if (r0 != 0) goto Lf
            return r1
        Lf:
            r0 = 0
        L10:
            int r2 = r5.length
            int r3 = r6.length
            int r2 = r2 - r3
            int r2 = r2 + 1
            if (r0 >= r2) goto L2a
            r2 = 0
        L18:
            int r3 = r6.length
            if (r2 >= r3) goto L29
            int r3 = r0 + r2
            r3 = r5[r3]
            r4 = r6[r2]
            if (r3 == r4) goto L26
            int r0 = r0 + 1
            goto L10
        L26:
            int r2 = r2 + 1
            goto L18
        L29:
            return r0
        L2a:
            r5 = -1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Bytes.indexOf(byte[], byte[]):int");
    }

    public static void reverse(byte[] bArr, int i6, int i7) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i6, i7, bArr.length);
        for (int i8 = i7 - 1; i6 < i8; i8--) {
            byte b6 = bArr[i6];
            bArr[i6] = bArr[i8];
            bArr[i8] = b6;
            i6++;
        }
    }

    public static int hashCode(byte b6) {
        return b6;
    }
}
