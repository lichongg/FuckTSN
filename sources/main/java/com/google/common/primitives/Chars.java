package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.jvm.internal.q;
import okhttp3.internal.ws.WebSocketProtocol;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Chars {
    public static final int BYTES = 2;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @GwtCompatible
    private static class CharArrayAsList extends AbstractList<Character> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final char[] array;
        final int end;
        final int start;

        CharArrayAsList(char[] cArr) {
            this(cArr, 0, cArr.length);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CharArrayAsList)) {
                return super.equals(obj);
            }
            CharArrayAsList charArrayAsList = (CharArrayAsList) obj;
            int size = size();
            if (charArrayAsList.size() != size) {
                return false;
            }
            for (int i6 = 0; i6 < size; i6++) {
                if (this.array[this.start + i6] != charArrayAsList.array[charArrayAsList.start + i6]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        CharArrayAsList(char[] cArr, int i6, int i7) {
            this.array = cArr;
            this.start = i6;
            this.end = i7;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Character) && Chars.indexOf(this.array, ((Character) obj).charValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public Character get(int i6) {
            Preconditions.checkElementIndex(i6, size());
            return Character.valueOf(this.array[this.start + i6]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i6 = 1;
            for (int i7 = this.start; i7 < this.end; i7++) {
                i6 = (i6 * 31) + Chars.hashCode(this.array[i7]);
            }
            return i6;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int indexOf;
            if (!(obj instanceof Character) || (indexOf = Chars.indexOf(this.array, ((Character) obj).charValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return indexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int lastIndexOf;
            if (!(obj instanceof Character) || (lastIndexOf = Chars.lastIndexOf(this.array, ((Character) obj).charValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return lastIndexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Character set(int i6, Character ch) {
            Preconditions.checkElementIndex(i6, size());
            char[] cArr = this.array;
            int i7 = this.start;
            char c6 = cArr[i7 + i6];
            cArr[i7 + i6] = ((Character) Preconditions.checkNotNull(ch)).charValue();
            return Character.valueOf(c6);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        char[] toCharArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 3);
            sb.append('[');
            sb.append(this.array[this.start]);
            int i6 = this.start;
            while (true) {
                i6++;
                if (i6 >= this.end) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.array[i6]);
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Character> subList(int i6, int i7) {
            Preconditions.checkPositionIndexes(i6, i7, size());
            if (i6 == i7) {
                return Collections.EMPTY_LIST;
            }
            char[] cArr = this.array;
            int i8 = this.start;
            return new CharArrayAsList(cArr, i6 + i8, i8 + i7);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum LexicographicalComparator implements Comparator<char[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(char[] cArr, char[] cArr2) {
            int min = Math.min(cArr.length, cArr2.length);
            for (int i6 = 0; i6 < min; i6++) {
                int compare = Chars.compare(cArr[i6], cArr2[i6]);
                if (compare != 0) {
                    return compare;
                }
            }
            return cArr.length - cArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Chars.lexicographicalComparator()";
        }
    }

    public static List<Character> asList(char... cArr) {
        return cArr.length == 0 ? Collections.EMPTY_LIST : new CharArrayAsList(cArr);
    }

    public static char checkedCast(long j6) {
        char c6 = (char) j6;
        Preconditions.checkArgument(((long) c6) == j6, "Out of range: %s", j6);
        return c6;
    }

    public static int compare(char c6, char c7) {
        return c6 - c7;
    }

    public static char[] concat(char[]... cArr) {
        int i6 = 0;
        for (char[] cArr2 : cArr) {
            i6 += cArr2.length;
        }
        char[] cArr3 = new char[i6];
        int i7 = 0;
        for (char[] cArr4 : cArr) {
            System.arraycopy(cArr4, 0, cArr3, i7, cArr4.length);
            i7 += cArr4.length;
        }
        return cArr3;
    }

    public static boolean contains(char[] cArr, char c6) {
        for (char c7 : cArr) {
            if (c7 == c6) {
                return true;
            }
        }
        return false;
    }

    public static char[] ensureCapacity(char[] cArr, int i6, int i7) {
        Preconditions.checkArgument(i6 >= 0, "Invalid minLength: %s", i6);
        Preconditions.checkArgument(i7 >= 0, "Invalid padding: %s", i7);
        return cArr.length < i6 ? Arrays.copyOf(cArr, i6 + i7) : cArr;
    }

    @GwtIncompatible
    public static char fromByteArray(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 2, "array too small: %s < %s", bArr.length, 2);
        return fromBytes(bArr[0], bArr[1]);
    }

    public static int indexOf(char[] cArr, char c6) {
        return indexOf(cArr, c6, 0, cArr.length);
    }

    public static int lastIndexOf(char[] cArr, char c6) {
        return lastIndexOf(cArr, c6, 0, cArr.length);
    }

    public static char max(char... cArr) {
        Preconditions.checkArgument(cArr.length > 0);
        char c6 = cArr[0];
        for (int i6 = 1; i6 < cArr.length; i6++) {
            char c7 = cArr[i6];
            if (c7 > c6) {
                c6 = c7;
            }
        }
        return c6;
    }

    public static char min(char... cArr) {
        Preconditions.checkArgument(cArr.length > 0);
        char c6 = cArr[0];
        for (int i6 = 1; i6 < cArr.length; i6++) {
            char c7 = cArr[i6];
            if (c7 < c6) {
                c6 = c7;
            }
        }
        return c6;
    }

    public static void reverse(char[] cArr) {
        Preconditions.checkNotNull(cArr);
        reverse(cArr, 0, cArr.length);
    }

    public static void sortDescending(char[] cArr) {
        Preconditions.checkNotNull(cArr);
        sortDescending(cArr, 0, cArr.length);
    }

    @Beta
    public static char constrainToRange(char c6, char c7, char c8) {
        Preconditions.checkArgument(c7 <= c8, "min (%s) must be less than or equal to max (%s)", c7, c8);
        return c6 < c7 ? c7 : c6 < c8 ? c6 : c8;
    }

    @GwtIncompatible
    public static char fromBytes(byte b6, byte b7) {
        return (char) ((b6 << 8) | (b7 & 255));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(char[] cArr, char c6, int i6, int i7) {
        while (i6 < i7) {
            if (cArr[i6] == c6) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(char[] cArr, char c6, int i6, int i7) {
        for (int i8 = i7 - 1; i8 >= i6; i8--) {
            if (cArr[i8] == c6) {
                return i8;
            }
        }
        return -1;
    }

    public static Comparator<char[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static char[] toArray(Collection<Character> collection) {
        if (collection instanceof CharArrayAsList) {
            return ((CharArrayAsList) collection).toCharArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        char[] cArr = new char[length];
        for (int i6 = 0; i6 < length; i6++) {
            cArr[i6] = ((Character) Preconditions.checkNotNull(array[i6])).charValue();
        }
        return cArr;
    }

    @GwtIncompatible
    public static byte[] toByteArray(char c6) {
        return new byte[]{(byte) (c6 >> '\b'), (byte) c6};
    }

    private Chars() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int indexOf(char[] r5, char[] r6) {
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
            char r3 = r5[r3]
            char r4 = r6[r2]
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Chars.indexOf(char[], char[]):int");
    }

    public static String join(String str, char... cArr) {
        Preconditions.checkNotNull(str);
        int length = cArr.length;
        if (length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder((str.length() * (length - 1)) + length);
        sb.append(cArr[0]);
        for (int i6 = 1; i6 < length; i6++) {
            sb.append(str);
            sb.append(cArr[i6]);
        }
        return sb.toString();
    }

    public static void reverse(char[] cArr, int i6, int i7) {
        Preconditions.checkNotNull(cArr);
        Preconditions.checkPositionIndexes(i6, i7, cArr.length);
        for (int i8 = i7 - 1; i6 < i8; i8--) {
            char c6 = cArr[i6];
            cArr[i6] = cArr[i8];
            cArr[i8] = c6;
            i6++;
        }
    }

    public static char saturatedCast(long j6) {
        if (j6 > WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            return q.f44042c;
        }
        if (j6 < 0) {
            return (char) 0;
        }
        return (char) j6;
    }

    public static void sortDescending(char[] cArr, int i6, int i7) {
        Preconditions.checkNotNull(cArr);
        Preconditions.checkPositionIndexes(i6, i7, cArr.length);
        Arrays.sort(cArr, i6, i7);
        reverse(cArr, i6, i7);
    }

    public static int hashCode(char c6) {
        return c6;
    }
}
