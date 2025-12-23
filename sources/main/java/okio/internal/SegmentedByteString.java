package okio.internal;

import kotlin.collections.n;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import okio.Buffer;
import okio.ByteString;
import okio.C1101SegmentedByteString;
import okio.Segment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "-SegmentedByteString")
@SourceDebugExtension({"SMAP\nSegmentedByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SegmentedByteString.kt\nokio/internal/-SegmentedByteString\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,250:1\n63#1,12:252\n85#1,14:264\n85#1,14:278\n85#1,14:292\n85#1,14:306\n63#1,12:320\n1#2:251\n*S KotlinDebug\n*F\n+ 1 SegmentedByteString.kt\nokio/internal/-SegmentedByteString\n*L\n147#1:252,12\n160#1:264,14\n182#1:278,14\n202#1:292,14\n219#1:306,14\n239#1:320,12\n*E\n"})
/* renamed from: okio.internal.-SegmentedByteString, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class SegmentedByteString {
    public static final boolean commonRangeEquals(@NotNull C1101SegmentedByteString c1101SegmentedByteString, int i6, @NotNull ByteString other, int i7, int i8) {
        g0.p(c1101SegmentedByteString, "<this>");
        g0.p(other, "other");
        if (i6 < 0 || i6 > c1101SegmentedByteString.size() - i8) {
            return false;
        }
        int i9 = i8 + i6;
        int segment = segment(c1101SegmentedByteString, i6);
        while (i6 < i9) {
            int i10 = segment == 0 ? 0 : c1101SegmentedByteString.getDirectory$okio()[segment - 1];
            int i11 = c1101SegmentedByteString.getDirectory$okio()[segment] - i10;
            int i12 = c1101SegmentedByteString.getDirectory$okio()[c1101SegmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i9, i11 + i10) - i6;
            if (!other.rangeEquals(i7, c1101SegmentedByteString.getSegments$okio()[segment], i12 + (i6 - i10), min)) {
                return false;
            }
            i7 += min;
            i6 += min;
            segment++;
        }
        return true;
    }

    public static final void forEachSegment(@NotNull C1101SegmentedByteString c1101SegmentedByteString, @NotNull Function3<? super byte[], ? super Integer, ? super Integer, n1> action) {
        g0.p(c1101SegmentedByteString, "<this>");
        g0.p(action, "action");
        int length = c1101SegmentedByteString.getSegments$okio().length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = c1101SegmentedByteString.getDirectory$okio()[length + i6];
            int i9 = c1101SegmentedByteString.getDirectory$okio()[i6];
            action.invoke(c1101SegmentedByteString.getSegments$okio()[i6], Integer.valueOf(i8), Integer.valueOf(i9 - i7));
            i6++;
            i7 = i9;
        }
    }

    public static final int binarySearch(@NotNull int[] iArr, int i6, int i7, int i8) {
        g0.p(iArr, "<this>");
        int i9 = i8 - 1;
        while (i7 <= i9) {
            int i10 = (i7 + i9) >>> 1;
            int i11 = iArr[i10];
            if (i11 < i6) {
                i7 = i10 + 1;
            } else {
                if (i11 <= i6) {
                    return i10;
                }
                i9 = i10 - 1;
            }
        }
        return (-i7) - 1;
    }

    public static final void commonCopyInto(@NotNull C1101SegmentedByteString c1101SegmentedByteString, int i6, @NotNull byte[] target, int i7, int i8) {
        g0.p(c1101SegmentedByteString, "<this>");
        g0.p(target, "target");
        long j6 = i8;
        okio.SegmentedByteString.checkOffsetAndCount(c1101SegmentedByteString.size(), i6, j6);
        okio.SegmentedByteString.checkOffsetAndCount(target.length, i7, j6);
        int i9 = i8 + i6;
        int segment = segment(c1101SegmentedByteString, i6);
        while (i6 < i9) {
            int i10 = segment == 0 ? 0 : c1101SegmentedByteString.getDirectory$okio()[segment - 1];
            int i11 = c1101SegmentedByteString.getDirectory$okio()[segment] - i10;
            int i12 = c1101SegmentedByteString.getDirectory$okio()[c1101SegmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i9, i11 + i10) - i6;
            int i13 = i12 + (i6 - i10);
            n.v0(c1101SegmentedByteString.getSegments$okio()[segment], target, i7, i13, i13 + min);
            i7 += min;
            i6 += min;
            segment++;
        }
    }

    public static final boolean commonEquals(@NotNull C1101SegmentedByteString c1101SegmentedByteString, @Nullable Object obj) {
        g0.p(c1101SegmentedByteString, "<this>");
        if (obj == c1101SegmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == c1101SegmentedByteString.size() && c1101SegmentedByteString.rangeEquals(0, byteString, 0, c1101SegmentedByteString.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(@NotNull C1101SegmentedByteString c1101SegmentedByteString) {
        g0.p(c1101SegmentedByteString, "<this>");
        return c1101SegmentedByteString.getDirectory$okio()[c1101SegmentedByteString.getSegments$okio().length - 1];
    }

    public static final int commonHashCode(@NotNull C1101SegmentedByteString c1101SegmentedByteString) {
        g0.p(c1101SegmentedByteString, "<this>");
        int hashCode$okio = c1101SegmentedByteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = c1101SegmentedByteString.getSegments$okio().length;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1;
        while (i6 < length) {
            int i9 = c1101SegmentedByteString.getDirectory$okio()[length + i6];
            int i10 = c1101SegmentedByteString.getDirectory$okio()[i6];
            byte[] bArr = c1101SegmentedByteString.getSegments$okio()[i6];
            int i11 = (i10 - i7) + i9;
            while (i9 < i11) {
                i8 = (i8 * 31) + bArr[i9];
                i9++;
            }
            i6++;
            i7 = i10;
        }
        c1101SegmentedByteString.setHashCode$okio(i8);
        return i8;
    }

    public static final byte commonInternalGet(@NotNull C1101SegmentedByteString c1101SegmentedByteString, int i6) {
        g0.p(c1101SegmentedByteString, "<this>");
        okio.SegmentedByteString.checkOffsetAndCount(c1101SegmentedByteString.getDirectory$okio()[c1101SegmentedByteString.getSegments$okio().length - 1], i6, 1L);
        int segment = segment(c1101SegmentedByteString, i6);
        return c1101SegmentedByteString.getSegments$okio()[segment][(i6 - (segment == 0 ? 0 : c1101SegmentedByteString.getDirectory$okio()[segment - 1])) + c1101SegmentedByteString.getDirectory$okio()[c1101SegmentedByteString.getSegments$okio().length + segment]];
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull C1101SegmentedByteString c1101SegmentedByteString, int i6, int i7) {
        g0.p(c1101SegmentedByteString, "<this>");
        int resolveDefaultParameter = okio.SegmentedByteString.resolveDefaultParameter(c1101SegmentedByteString, i7);
        if (i6 < 0) {
            throw new IllegalArgumentException(("beginIndex=" + i6 + " < 0").toString());
        }
        if (resolveDefaultParameter > c1101SegmentedByteString.size()) {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + c1101SegmentedByteString.size() + ')').toString());
        }
        int i8 = resolveDefaultParameter - i6;
        if (i8 < 0) {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " < beginIndex=" + i6).toString());
        }
        if (i6 == 0 && resolveDefaultParameter == c1101SegmentedByteString.size()) {
            return c1101SegmentedByteString;
        }
        if (i6 == resolveDefaultParameter) {
            return ByteString.EMPTY;
        }
        int segment = segment(c1101SegmentedByteString, i6);
        int segment2 = segment(c1101SegmentedByteString, resolveDefaultParameter - 1);
        byte[][] bArr = (byte[][]) n.l1(c1101SegmentedByteString.getSegments$okio(), segment, segment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (segment <= segment2) {
            int i9 = segment;
            int i10 = 0;
            while (true) {
                iArr[i10] = Math.min(c1101SegmentedByteString.getDirectory$okio()[i9] - i6, i8);
                int i11 = i10 + 1;
                iArr[i10 + bArr.length] = c1101SegmentedByteString.getDirectory$okio()[c1101SegmentedByteString.getSegments$okio().length + i9];
                if (i9 == segment2) {
                    break;
                }
                i9++;
                i10 = i11;
            }
        }
        int i12 = segment != 0 ? c1101SegmentedByteString.getDirectory$okio()[segment - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i6 - i12);
        return new C1101SegmentedByteString(bArr, iArr);
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull C1101SegmentedByteString c1101SegmentedByteString) {
        g0.p(c1101SegmentedByteString, "<this>");
        byte[] bArr = new byte[c1101SegmentedByteString.size()];
        int length = c1101SegmentedByteString.getSegments$okio().length;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < length) {
            int i9 = c1101SegmentedByteString.getDirectory$okio()[length + i6];
            int i10 = c1101SegmentedByteString.getDirectory$okio()[i6];
            int i11 = i10 - i7;
            n.v0(c1101SegmentedByteString.getSegments$okio()[i6], bArr, i8, i9, i9 + i11);
            i8 += i11;
            i6++;
            i7 = i10;
        }
        return bArr;
    }

    public static final void commonWrite(@NotNull C1101SegmentedByteString c1101SegmentedByteString, @NotNull Buffer buffer, int i6, int i7) {
        g0.p(c1101SegmentedByteString, "<this>");
        g0.p(buffer, "buffer");
        int i8 = i6 + i7;
        int segment = segment(c1101SegmentedByteString, i6);
        while (i6 < i8) {
            int i9 = segment == 0 ? 0 : c1101SegmentedByteString.getDirectory$okio()[segment - 1];
            int i10 = c1101SegmentedByteString.getDirectory$okio()[segment] - i9;
            int i11 = c1101SegmentedByteString.getDirectory$okio()[c1101SegmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i8, i10 + i9) - i6;
            int i12 = i11 + (i6 - i9);
            Segment segment2 = new Segment(c1101SegmentedByteString.getSegments$okio()[segment], i12, i12 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                g0.m(segment3);
                Segment segment4 = segment3.prev;
                g0.m(segment4);
                segment4.push(segment2);
            }
            i6 += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + i7);
    }

    public static final int segment(@NotNull C1101SegmentedByteString c1101SegmentedByteString, int i6) {
        g0.p(c1101SegmentedByteString, "<this>");
        int binarySearch = binarySearch(c1101SegmentedByteString.getDirectory$okio(), i6 + 1, 0, c1101SegmentedByteString.getSegments$okio().length);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    private static final void forEachSegment(C1101SegmentedByteString c1101SegmentedByteString, int i6, int i7, Function3<? super byte[], ? super Integer, ? super Integer, n1> function3) {
        int segment = segment(c1101SegmentedByteString, i6);
        while (i6 < i7) {
            int i8 = segment == 0 ? 0 : c1101SegmentedByteString.getDirectory$okio()[segment - 1];
            int i9 = c1101SegmentedByteString.getDirectory$okio()[segment] - i8;
            int i10 = c1101SegmentedByteString.getDirectory$okio()[c1101SegmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i7, i9 + i8) - i6;
            function3.invoke(c1101SegmentedByteString.getSegments$okio()[segment], Integer.valueOf(i10 + (i6 - i8)), Integer.valueOf(min));
            i6 += min;
            segment++;
        }
    }

    public static final boolean commonRangeEquals(@NotNull C1101SegmentedByteString c1101SegmentedByteString, int i6, @NotNull byte[] other, int i7, int i8) {
        g0.p(c1101SegmentedByteString, "<this>");
        g0.p(other, "other");
        if (i6 < 0 || i6 > c1101SegmentedByteString.size() - i8 || i7 < 0 || i7 > other.length - i8) {
            return false;
        }
        int i9 = i8 + i6;
        int segment = segment(c1101SegmentedByteString, i6);
        while (i6 < i9) {
            int i10 = segment == 0 ? 0 : c1101SegmentedByteString.getDirectory$okio()[segment - 1];
            int i11 = c1101SegmentedByteString.getDirectory$okio()[segment] - i10;
            int i12 = c1101SegmentedByteString.getDirectory$okio()[c1101SegmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i9, i11 + i10) - i6;
            if (!okio.SegmentedByteString.arrayRangeEquals(c1101SegmentedByteString.getSegments$okio()[segment], i12 + (i6 - i10), other, i7, min)) {
                return false;
            }
            i7 += min;
            i6 += min;
            segment++;
        }
        return true;
    }
}
