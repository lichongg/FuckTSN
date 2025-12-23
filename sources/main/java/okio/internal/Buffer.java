package okio.internal;

import com.google.common.base.Ascii;
import java.io.EOFException;
import kotlin.collections.n;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.text.v0;
import okio.Buffer;
import okio.ByteString;
import okio.C1101SegmentedByteString;
import okio.Options;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Utf8;
import okio._JvmPlatformKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "-Buffer")
@SourceDebugExtension({"SMAP\nBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Buffer.kt\nokio/internal/-Buffer\n+ 2 Util.kt\nokio/-SegmentedByteString\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1712:1\n110#1,20:1735\n110#1,20:1768\n110#1:1788\n112#1,18:1790\n110#1,20:1808\n73#2:1713\n73#2:1714\n73#2:1715\n73#2:1716\n73#2:1717\n73#2:1718\n73#2:1719\n73#2:1720\n73#2:1721\n73#2:1722\n73#2:1723\n73#2:1724\n82#2:1725\n82#2:1726\n76#2:1727\n76#2:1728\n76#2:1729\n76#2:1730\n76#2:1731\n76#2:1732\n76#2:1733\n76#2:1734\n85#2:1755\n88#2:1757\n73#2:1758\n73#2:1759\n73#2:1760\n73#2:1761\n73#2:1762\n73#2:1763\n73#2:1764\n73#2:1765\n73#2:1766\n73#2:1767\n88#2:1789\n85#2:1828\n1#3:1756\n*S KotlinDebug\n*F\n+ 1 Buffer.kt\nokio/internal/-Buffer\n*L\n413#1:1735,20\n1262#1:1768,20\n1305#1:1788\n1305#1:1790,18\n1341#1:1808,20\n176#1:1713\n200#1:1714\n319#1:1715\n324#1:1716\n347#1:1717\n348#1:1718\n349#1:1719\n350#1:1720\n356#1:1721\n357#1:1722\n358#1:1723\n359#1:1724\n383#1:1725\n384#1:1726\n390#1:1727\n391#1:1728\n392#1:1729\n393#1:1730\n394#1:1731\n395#1:1732\n396#1:1733\n397#1:1734\n425#1:1755\n858#1:1757\n876#1:1758\n878#1:1759\n882#1:1760\n884#1:1761\n888#1:1762\n890#1:1763\n894#1:1764\n896#1:1765\n916#1:1766\n919#1:1767\n1317#1:1789\n1658#1:1828\n*E\n"})
/* renamed from: okio.internal.-Buffer, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Buffer {
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;

    @NotNull
    private static final byte[] HEX_DIGIT_BYTES = _JvmPlatformKt.asUtf8ToByteArray("0123456789abcdef");

    @NotNull
    private static final long[] DigitCountToLargestValue = {-1, 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, 9999999999L, 99999999999L, 999999999999L, 9999999999999L, 99999999999999L, 999999999999999L, 9999999999999999L, 99999999999999999L, 999999999999999999L, Long.MAX_VALUE};

    public static final long commonIndexOf(@NotNull okio.Buffer buffer, byte b6, long j6, long j7) {
        Segment segment;
        int i6;
        g0.p(buffer, "<this>");
        long j8 = 0;
        if (0 > j6 || j6 > j7) {
            throw new IllegalArgumentException(("size=" + buffer.size() + " fromIndex=" + j6 + " toIndex=" + j7).toString());
        }
        if (j7 > buffer.size()) {
            j7 = buffer.size();
        }
        if (j6 == j7 || (segment = buffer.head) == null) {
            return -1L;
        }
        if (buffer.size() - j6 < j6) {
            j8 = buffer.size();
            while (j8 > j6) {
                segment = segment.prev;
                g0.m(segment);
                j8 -= segment.limit - segment.pos;
            }
            while (j8 < j7) {
                byte[] bArr = segment.data;
                int min = (int) Math.min(segment.limit, (segment.pos + j7) - j8);
                i6 = (int) ((segment.pos + j6) - j8);
                while (i6 < min) {
                    if (bArr[i6] != b6) {
                        i6++;
                    }
                }
                j8 += segment.limit - segment.pos;
                segment = segment.next;
                g0.m(segment);
                j6 = j8;
            }
            return -1L;
        }
        while (true) {
            long j9 = (segment.limit - segment.pos) + j8;
            if (j9 > j6) {
                break;
            }
            segment = segment.next;
            g0.m(segment);
            j8 = j9;
        }
        while (j8 < j7) {
            byte[] bArr2 = segment.data;
            int min2 = (int) Math.min(segment.limit, (segment.pos + j7) - j8);
            i6 = (int) ((segment.pos + j6) - j8);
            while (i6 < min2) {
                if (bArr2[i6] != b6) {
                    i6++;
                }
            }
            j8 += segment.limit - segment.pos;
            segment = segment.next;
            g0.m(segment);
            j6 = j8;
        }
        return -1L;
        return (i6 - segment.pos) + j8;
    }

    public static final int commonRead(@NotNull okio.Buffer buffer, @NotNull byte[] sink) {
        g0.p(buffer, "<this>");
        g0.p(sink, "sink");
        return buffer.read(sink, 0, sink.length);
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull okio.Buffer buffer) {
        g0.p(buffer, "<this>");
        return buffer.readByteArray(buffer.size());
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull okio.Buffer buffer) {
        g0.p(buffer, "<this>");
        return buffer.readByteString(buffer.size());
    }

    public static final void commonReadFully(@NotNull okio.Buffer buffer, @NotNull byte[] sink) {
        g0.p(buffer, "<this>");
        g0.p(sink, "sink");
        int i6 = 0;
        while (i6 < sink.length) {
            int read = buffer.read(sink, i6, sink.length - i6);
            if (read == -1) {
                throw new EOFException();
            }
            i6 += read;
        }
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull okio.Buffer buffer) {
        g0.p(buffer, "<this>");
        if (buffer.size() <= 2147483647L) {
            return buffer.snapshot((int) buffer.size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + buffer.size()).toString());
    }

    @NotNull
    public static final okio.Buffer commonWrite(@NotNull okio.Buffer buffer, @NotNull ByteString byteString, int i6, int i7) {
        g0.p(buffer, "<this>");
        g0.p(byteString, "byteString");
        byteString.write$okio(buffer, i6, i7);
        return buffer;
    }

    @NotNull
    public static final okio.Buffer commonWriteUtf8(@NotNull okio.Buffer buffer, @NotNull String string, int i6, int i7) {
        char charAt;
        g0.p(buffer, "<this>");
        g0.p(string, "string");
        if (i6 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i6).toString());
        }
        if (i7 < i6) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i7 + " < " + i6).toString());
        }
        if (i7 > string.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i7 + " > " + string.length()).toString());
        }
        while (i6 < i7) {
            char charAt2 = string.charAt(i6);
            if (charAt2 < 128) {
                Segment writableSegment$okio = buffer.writableSegment$okio(1);
                byte[] bArr = writableSegment$okio.data;
                int i8 = writableSegment$okio.limit - i6;
                int min = Math.min(i7, 8192 - i8);
                int i9 = i6 + 1;
                bArr[i6 + i8] = (byte) charAt2;
                while (true) {
                    i6 = i9;
                    if (i6 >= min || (charAt = string.charAt(i6)) >= 128) {
                        break;
                    }
                    i9 = i6 + 1;
                    bArr[i6 + i8] = (byte) charAt;
                }
                int i10 = writableSegment$okio.limit;
                int i11 = (i8 + i6) - i10;
                writableSegment$okio.limit = i10 + i11;
                buffer.setSize$okio(buffer.size() + i11);
            } else {
                if (charAt2 < 2048) {
                    Segment writableSegment$okio2 = buffer.writableSegment$okio(2);
                    byte[] bArr2 = writableSegment$okio2.data;
                    int i12 = writableSegment$okio2.limit;
                    bArr2[i12] = (byte) ((charAt2 >> 6) | 192);
                    bArr2[i12 + 1] = (byte) ((charAt2 & '?') | 128);
                    writableSegment$okio2.limit = i12 + 2;
                    buffer.setSize$okio(buffer.size() + 2);
                } else if (charAt2 < 55296 || charAt2 > 57343) {
                    Segment writableSegment$okio3 = buffer.writableSegment$okio(3);
                    byte[] bArr3 = writableSegment$okio3.data;
                    int i13 = writableSegment$okio3.limit;
                    bArr3[i13] = (byte) ((charAt2 >> '\f') | 224);
                    bArr3[i13 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                    bArr3[i13 + 2] = (byte) ((charAt2 & '?') | 128);
                    writableSegment$okio3.limit = i13 + 3;
                    buffer.setSize$okio(buffer.size() + 3);
                } else {
                    int i14 = i6 + 1;
                    char charAt3 = i14 < i7 ? string.charAt(i14) : (char) 0;
                    if (charAt2 > 56319 || 56320 > charAt3 || charAt3 >= 57344) {
                        buffer.writeByte(63);
                        i6 = i14;
                    } else {
                        int i15 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + 65536;
                        Segment writableSegment$okio4 = buffer.writableSegment$okio(4);
                        byte[] bArr4 = writableSegment$okio4.data;
                        int i16 = writableSegment$okio4.limit;
                        bArr4[i16] = (byte) ((i15 >> 18) | 240);
                        bArr4[i16 + 1] = (byte) (((i15 >> 12) & 63) | 128);
                        bArr4[i16 + 2] = (byte) (((i15 >> 6) & 63) | 128);
                        bArr4[i16 + 3] = (byte) ((i15 & 63) | 128);
                        writableSegment$okio4.limit = i16 + 4;
                        buffer.setSize$okio(buffer.size() + 4);
                        i6 += 2;
                    }
                }
                i6++;
            }
        }
        return buffer;
    }

    public static final void commonClear(@NotNull okio.Buffer buffer) {
        g0.p(buffer, "<this>");
        buffer.skip(buffer.size());
    }

    public static final void commonClose(@NotNull Buffer.UnsafeCursor unsafeCursor) {
        g0.p(unsafeCursor, "<this>");
        if (unsafeCursor.buffer == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        unsafeCursor.buffer = null;
        unsafeCursor.setSegment$okio(null);
        unsafeCursor.offset = -1L;
        unsafeCursor.data = null;
        unsafeCursor.start = -1;
        unsafeCursor.end = -1;
    }

    public static final long commonCompleteSegmentByteCount(@NotNull okio.Buffer buffer) {
        g0.p(buffer, "<this>");
        long size = buffer.size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = buffer.head;
        g0.m(segment);
        Segment segment2 = segment.prev;
        g0.m(segment2);
        return (segment2.limit >= 8192 || !segment2.owner) ? size : size - (r2 - segment2.pos);
    }

    @NotNull
    public static final okio.Buffer commonCopy(@NotNull okio.Buffer buffer) {
        g0.p(buffer, "<this>");
        okio.Buffer buffer2 = new okio.Buffer();
        if (buffer.size() == 0) {
            return buffer2;
        }
        Segment segment = buffer.head;
        g0.m(segment);
        Segment sharedCopy = segment.sharedCopy();
        buffer2.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = sharedCopy.prev;
            g0.m(segment3);
            g0.m(segment2);
            segment3.push(segment2.sharedCopy());
        }
        buffer2.setSize$okio(buffer.size());
        return buffer2;
    }

    @NotNull
    public static final okio.Buffer commonCopyTo(@NotNull okio.Buffer buffer, @NotNull okio.Buffer out, long j6, long j7) {
        g0.p(buffer, "<this>");
        g0.p(out, "out");
        long j8 = j6;
        SegmentedByteString.checkOffsetAndCount(buffer.size(), j8, j7);
        if (j7 != 0) {
            out.setSize$okio(out.size() + j7);
            Segment segment = buffer.head;
            while (true) {
                g0.m(segment);
                int i6 = segment.limit;
                int i7 = segment.pos;
                if (j8 < i6 - i7) {
                    break;
                }
                j8 -= i6 - i7;
                segment = segment.next;
            }
            Segment segment2 = segment;
            long j9 = j7;
            while (j9 > 0) {
                g0.m(segment2);
                Segment sharedCopy = segment2.sharedCopy();
                int i8 = sharedCopy.pos + ((int) j8);
                sharedCopy.pos = i8;
                sharedCopy.limit = Math.min(i8 + ((int) j9), sharedCopy.limit);
                Segment segment3 = out.head;
                if (segment3 == null) {
                    sharedCopy.prev = sharedCopy;
                    sharedCopy.next = sharedCopy;
                    out.head = sharedCopy;
                } else {
                    g0.m(segment3);
                    Segment segment4 = segment3.prev;
                    g0.m(segment4);
                    segment4.push(sharedCopy);
                }
                j9 -= sharedCopy.limit - sharedCopy.pos;
                segment2 = segment2.next;
                j8 = 0;
            }
        }
        return buffer;
    }

    public static final boolean commonEquals(@NotNull okio.Buffer buffer, @Nullable Object obj) {
        g0.p(buffer, "<this>");
        if (buffer == obj) {
            return true;
        }
        if (!(obj instanceof okio.Buffer)) {
            return false;
        }
        okio.Buffer buffer2 = (okio.Buffer) obj;
        if (buffer.size() != buffer2.size()) {
            return false;
        }
        if (buffer.size() == 0) {
            return true;
        }
        Segment segment = buffer.head;
        g0.m(segment);
        Segment segment2 = buffer2.head;
        g0.m(segment2);
        int i6 = segment.pos;
        int i7 = segment2.pos;
        long j6 = 0;
        while (j6 < buffer.size()) {
            long min = Math.min(segment.limit - i6, segment2.limit - i7);
            long j7 = 0;
            while (j7 < min) {
                int i8 = i6 + 1;
                int i9 = i7 + 1;
                if (segment.data[i6] != segment2.data[i7]) {
                    return false;
                }
                j7++;
                i6 = i8;
                i7 = i9;
            }
            if (i6 == segment.limit) {
                segment = segment.next;
                g0.m(segment);
                i6 = segment.pos;
            }
            if (i7 == segment2.limit) {
                segment2 = segment2.next;
                g0.m(segment2);
                i7 = segment2.pos;
            }
            j6 += min;
        }
        return true;
    }

    public static final long commonExpandBuffer(@NotNull Buffer.UnsafeCursor unsafeCursor, int i6) {
        g0.p(unsafeCursor, "<this>");
        if (i6 <= 0) {
            throw new IllegalArgumentException(("minByteCount <= 0: " + i6).toString());
        }
        if (i6 > 8192) {
            throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + i6).toString());
        }
        okio.Buffer buffer = unsafeCursor.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (!unsafeCursor.readWrite) {
            throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
        }
        long size = buffer.size();
        Segment writableSegment$okio = buffer.writableSegment$okio(i6);
        int i7 = 8192 - writableSegment$okio.limit;
        writableSegment$okio.limit = 8192;
        long j6 = i7;
        buffer.setSize$okio(size + j6);
        unsafeCursor.setSegment$okio(writableSegment$okio);
        unsafeCursor.offset = size;
        unsafeCursor.data = writableSegment$okio.data;
        unsafeCursor.start = 8192 - i7;
        unsafeCursor.end = 8192;
        return j6;
    }

    public static final byte commonGet(@NotNull okio.Buffer buffer, long j6) {
        g0.p(buffer, "<this>");
        SegmentedByteString.checkOffsetAndCount(buffer.size(), j6, 1L);
        Segment segment = buffer.head;
        if (segment == null) {
            g0.m(null);
            throw null;
        }
        if (buffer.size() - j6 < j6) {
            long size = buffer.size();
            while (size > j6) {
                segment = segment.prev;
                g0.m(segment);
                size -= segment.limit - segment.pos;
            }
            g0.m(segment);
            return segment.data[(int) ((segment.pos + j6) - size)];
        }
        long j7 = 0;
        while (true) {
            long j8 = (segment.limit - segment.pos) + j7;
            if (j8 > j6) {
                g0.m(segment);
                return segment.data[(int) ((segment.pos + j6) - j7)];
            }
            segment = segment.next;
            g0.m(segment);
            j7 = j8;
        }
    }

    public static final int commonHashCode(@NotNull okio.Buffer buffer) {
        g0.p(buffer, "<this>");
        Segment segment = buffer.head;
        if (segment == null) {
            return 0;
        }
        int i6 = 1;
        do {
            int i7 = segment.limit;
            for (int i8 = segment.pos; i8 < i7; i8++) {
                i6 = (i6 * 31) + segment.data[i8];
            }
            segment = segment.next;
            g0.m(segment);
        } while (segment != buffer.head);
        return i6;
    }

    public static /* synthetic */ long commonIndexOf$default(okio.Buffer buffer, ByteString byteString, long j6, long j7, int i6, int i7, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            j7 = Long.MAX_VALUE;
        }
        return commonIndexOf(buffer, byteString, j6, j7, (i8 & 8) != 0 ? 0 : i6, (i8 & 16) != 0 ? byteString.size() : i7);
    }

    public static final long commonIndexOfElement(@NotNull okio.Buffer buffer, @NotNull ByteString targetBytes, long j6) {
        int i6;
        int i7;
        g0.p(buffer, "<this>");
        g0.p(targetBytes, "targetBytes");
        long j7 = 0;
        if (j6 < 0) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j6).toString());
        }
        Segment segment = buffer.head;
        if (segment == null) {
            return -1L;
        }
        if (buffer.size() - j6 < j6) {
            j7 = buffer.size();
            while (j7 > j6) {
                segment = segment.prev;
                g0.m(segment);
                j7 -= segment.limit - segment.pos;
            }
            if (targetBytes.size() == 2) {
                byte b6 = targetBytes.getByte(0);
                byte b7 = targetBytes.getByte(1);
                while (j7 < buffer.size()) {
                    byte[] bArr = segment.data;
                    i6 = (int) ((segment.pos + j6) - j7);
                    int i8 = segment.limit;
                    while (i6 < i8) {
                        byte b8 = bArr[i6];
                        if (b8 != b6 && b8 != b7) {
                            i6++;
                        }
                        i7 = segment.pos;
                    }
                    j7 += segment.limit - segment.pos;
                    segment = segment.next;
                    g0.m(segment);
                    j6 = j7;
                }
            } else {
                byte[] internalArray$okio = targetBytes.internalArray$okio();
                while (j7 < buffer.size()) {
                    byte[] bArr2 = segment.data;
                    i6 = (int) ((segment.pos + j6) - j7);
                    int i9 = segment.limit;
                    while (i6 < i9) {
                        byte b9 = bArr2[i6];
                        for (byte b10 : internalArray$okio) {
                            if (b9 == b10) {
                                i7 = segment.pos;
                            }
                        }
                        i6++;
                    }
                    j7 += segment.limit - segment.pos;
                    segment = segment.next;
                    g0.m(segment);
                    j6 = j7;
                }
            }
            return -1L;
        }
        while (true) {
            long j8 = (segment.limit - segment.pos) + j7;
            if (j8 > j6) {
                break;
            }
            segment = segment.next;
            g0.m(segment);
            j7 = j8;
        }
        if (targetBytes.size() == 2) {
            byte b11 = targetBytes.getByte(0);
            byte b12 = targetBytes.getByte(1);
            while (j7 < buffer.size()) {
                byte[] bArr3 = segment.data;
                i6 = (int) ((segment.pos + j6) - j7);
                int i10 = segment.limit;
                while (i6 < i10) {
                    byte b13 = bArr3[i6];
                    if (b13 != b11 && b13 != b12) {
                        i6++;
                    }
                    i7 = segment.pos;
                }
                j7 += segment.limit - segment.pos;
                segment = segment.next;
                g0.m(segment);
                j6 = j7;
            }
        } else {
            byte[] internalArray$okio2 = targetBytes.internalArray$okio();
            while (j7 < buffer.size()) {
                byte[] bArr4 = segment.data;
                i6 = (int) ((segment.pos + j6) - j7);
                int i11 = segment.limit;
                while (i6 < i11) {
                    byte b14 = bArr4[i6];
                    for (byte b15 : internalArray$okio2) {
                        if (b14 == b15) {
                            i7 = segment.pos;
                        }
                    }
                    i6++;
                }
                j7 += segment.limit - segment.pos;
                segment = segment.next;
                g0.m(segment);
                j6 = j7;
            }
        }
        return -1L;
        return (i6 - i7) + j7;
    }

    public static final int commonNext(@NotNull Buffer.UnsafeCursor unsafeCursor) {
        g0.p(unsafeCursor, "<this>");
        long j6 = unsafeCursor.offset;
        okio.Buffer buffer = unsafeCursor.buffer;
        g0.m(buffer);
        if (j6 == buffer.size()) {
            throw new IllegalStateException("no more bytes");
        }
        long j7 = unsafeCursor.offset;
        return unsafeCursor.seek(j7 == -1 ? 0L : j7 + (unsafeCursor.end - unsafeCursor.start));
    }

    public static final boolean commonRangeEquals(@NotNull okio.Buffer buffer, long j6, @NotNull ByteString bytes, int i6, int i7) {
        g0.p(buffer, "<this>");
        g0.p(bytes, "bytes");
        return i7 >= 0 && j6 >= 0 && ((long) i7) + j6 <= buffer.size() && i6 >= 0 && i6 + i7 <= bytes.size() && (i7 == 0 || commonIndexOf(buffer, bytes, j6, 1 + j6, i6, i7) != -1);
    }

    public static final int commonRead(@NotNull okio.Buffer buffer, @NotNull byte[] sink, int i6, int i7) {
        g0.p(buffer, "<this>");
        g0.p(sink, "sink");
        SegmentedByteString.checkOffsetAndCount(sink.length, i6, i7);
        Segment segment = buffer.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i7, segment.limit - segment.pos);
        byte[] bArr = segment.data;
        int i8 = segment.pos;
        n.v0(bArr, sink, i6, i8, i8 + min);
        segment.pos += min;
        buffer.setSize$okio(buffer.size() - min);
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public static final long commonReadAll(@NotNull okio.Buffer buffer, @NotNull Sink sink) {
        g0.p(buffer, "<this>");
        g0.p(sink, "sink");
        long size = buffer.size();
        if (size > 0) {
            sink.write(buffer, size);
        }
        return size;
    }

    @NotNull
    public static final Buffer.UnsafeCursor commonReadAndWriteUnsafe(@NotNull okio.Buffer buffer, @NotNull Buffer.UnsafeCursor unsafeCursor) {
        g0.p(buffer, "<this>");
        g0.p(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(unsafeCursor);
        if (resolveDefaultParameter.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        resolveDefaultParameter.buffer = buffer;
        resolveDefaultParameter.readWrite = true;
        return resolveDefaultParameter;
    }

    public static final byte commonReadByte(@NotNull okio.Buffer buffer) {
        g0.p(buffer, "<this>");
        if (buffer.size() == 0) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        g0.m(segment);
        int i6 = segment.pos;
        int i7 = segment.limit;
        int i8 = i6 + 1;
        byte b6 = segment.data[i6];
        buffer.setSize$okio(buffer.size() - 1);
        if (i8 != i7) {
            segment.pos = i8;
            return b6;
        }
        buffer.head = segment.pop();
        SegmentPool.recycle(segment);
        return b6;
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull okio.Buffer buffer, long j6) {
        g0.p(buffer, "<this>");
        if (j6 < 0 || j6 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j6).toString());
        }
        if (buffer.size() < j6) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j6];
        buffer.readFully(bArr);
        return bArr;
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull okio.Buffer buffer, long j6) {
        g0.p(buffer, "<this>");
        if (j6 < 0 || j6 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j6).toString());
        }
        if (buffer.size() < j6) {
            throw new EOFException();
        }
        if (j6 < 4096) {
            return new ByteString(buffer.readByteArray(j6));
        }
        ByteString snapshot = buffer.snapshot((int) j6);
        buffer.skip(j6);
        return snapshot;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00aa, code lost:
    
        r19.setSize$okio(r19.size() - r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b3, code lost:
    
        if (r2 == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b5, code lost:
    
        r14 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b8, code lost:
    
        if (r1 >= r14) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c0, code lost:
    
        if (r19.size() == r17) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c2, code lost:
    
        if (r2 == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c4, code lost:
    
        r1 = "Expected a digit";
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ec, code lost:
    
        throw new java.lang.NumberFormatException(r1 + " but was 0x" + okio.SegmentedByteString.toHexString(r19.getByte(r17)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c7, code lost:
    
        r1 = "Expected a digit or '-'";
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f2, code lost:
    
        throw new java.io.EOFException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f3, code lost:
    
        if (r2 == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f5, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f7, code lost:
    
        return -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b7, code lost:
    
        r14 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadDecimalLong(@org.jetbrains.annotations.NotNull okio.Buffer r19) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.Buffer.commonReadDecimalLong(okio.Buffer):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ac A[EDGE_INSN: B:40:0x00ac->B:37:0x00ac BREAK  A[LOOP:0: B:4:0x0012->B:39:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadHexadecimalUnsignedLong(@org.jetbrains.annotations.NotNull okio.Buffer r15) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.g0.p(r15, r0)
            long r0 = r15.size()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lb6
            r0 = 0
            r4 = r2
            r1 = 0
        L12:
            okio.Segment r6 = r15.head
            kotlin.jvm.internal.g0.m(r6)
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L1d:
            if (r8 >= r9) goto L98
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L2c
            r11 = 57
            if (r10 > r11) goto L2c
            int r11 = r10 + (-48)
            goto L41
        L2c:
            r11 = 97
            if (r10 < r11) goto L37
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L37
            int r11 = r10 + (-87)
            goto L41
        L37:
            r11 = 65
            if (r10 < r11) goto L79
            r11 = 70
            if (r10 > r11) goto L79
            int r11 = r10 + (-55)
        L41:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L51
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L1d
        L51:
            okio.Buffer r15 = new okio.Buffer
            r15.<init>()
            okio.Buffer r15 = r15.writeHexadecimalUnsignedLong(r4)
            okio.Buffer r15 = r15.writeByte(r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Number too large: "
            r1.append(r2)
            java.lang.String r15 = r15.readUtf8()
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            r0.<init>(r15)
            throw r0
        L79:
            if (r0 == 0) goto L7d
            r1 = 1
            goto L98
        L7d:
            java.lang.NumberFormatException r15 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            r0.append(r1)
            java.lang.String r1 = okio.SegmentedByteString.toHexString(r10)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        L98:
            if (r8 != r9) goto La4
            okio.Segment r7 = r6.pop()
            r15.head = r7
            okio.SegmentPool.recycle(r6)
            goto La6
        La4:
            r6.pos = r8
        La6:
            if (r1 != 0) goto Lac
            okio.Segment r6 = r15.head
            if (r6 != 0) goto L12
        Lac:
            long r1 = r15.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.setSize$okio(r1)
            return r4
        Lb6:
            java.io.EOFException r15 = new java.io.EOFException
            r15.<init>()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.Buffer.commonReadHexadecimalUnsignedLong(okio.Buffer):long");
    }

    public static final int commonReadInt(@NotNull okio.Buffer buffer) {
        g0.p(buffer, "<this>");
        if (buffer.size() < 4) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        g0.m(segment);
        int i6 = segment.pos;
        int i7 = segment.limit;
        if (i7 - i6 < 4) {
            return (buffer.readByte() & 255) | ((buffer.readByte() & 255) << 24) | ((buffer.readByte() & 255) << 16) | ((buffer.readByte() & 255) << 8);
        }
        byte[] bArr = segment.data;
        int i8 = i6 + 3;
        int i9 = ((bArr[i6 + 1] & 255) << 16) | ((bArr[i6] & 255) << 24) | ((bArr[i6 + 2] & 255) << 8);
        int i10 = i6 + 4;
        int i11 = (bArr[i8] & 255) | i9;
        buffer.setSize$okio(buffer.size() - 4);
        if (i10 != i7) {
            segment.pos = i10;
            return i11;
        }
        buffer.head = segment.pop();
        SegmentPool.recycle(segment);
        return i11;
    }

    public static final long commonReadLong(@NotNull okio.Buffer buffer) {
        g0.p(buffer, "<this>");
        if (buffer.size() < 8) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        g0.m(segment);
        int i6 = segment.pos;
        int i7 = segment.limit;
        if (i7 - i6 < 8) {
            return ((buffer.readInt() & 4294967295L) << 32) | (4294967295L & buffer.readInt());
        }
        byte[] bArr = segment.data;
        int i8 = i6 + 7;
        long j6 = ((bArr[i6 + 3] & 255) << 32) | ((bArr[i6] & 255) << 56) | ((bArr[i6 + 1] & 255) << 48) | ((bArr[i6 + 2] & 255) << 40) | ((bArr[i6 + 4] & 255) << 24) | ((bArr[i6 + 5] & 255) << 16) | ((bArr[i6 + 6] & 255) << 8);
        int i9 = i6 + 8;
        long j7 = j6 | (bArr[i8] & 255);
        buffer.setSize$okio(buffer.size() - 8);
        if (i9 != i7) {
            segment.pos = i9;
            return j7;
        }
        buffer.head = segment.pop();
        SegmentPool.recycle(segment);
        return j7;
    }

    public static final short commonReadShort(@NotNull okio.Buffer buffer) {
        g0.p(buffer, "<this>");
        if (buffer.size() < 2) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        g0.m(segment);
        int i6 = segment.pos;
        int i7 = segment.limit;
        if (i7 - i6 < 2) {
            return (short) ((buffer.readByte() & 255) | ((buffer.readByte() & 255) << 8));
        }
        byte[] bArr = segment.data;
        int i8 = i6 + 1;
        int i9 = (bArr[i6] & 255) << 8;
        int i10 = i6 + 2;
        int i11 = (bArr[i8] & 255) | i9;
        buffer.setSize$okio(buffer.size() - 2);
        if (i10 == i7) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i10;
        }
        return (short) i11;
    }

    @NotNull
    public static final Buffer.UnsafeCursor commonReadUnsafe(@NotNull okio.Buffer buffer, @NotNull Buffer.UnsafeCursor unsafeCursor) {
        g0.p(buffer, "<this>");
        g0.p(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(unsafeCursor);
        if (resolveDefaultParameter.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        resolveDefaultParameter.buffer = buffer;
        resolveDefaultParameter.readWrite = false;
        return resolveDefaultParameter;
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull okio.Buffer buffer, long j6) {
        g0.p(buffer, "<this>");
        if (j6 < 0 || j6 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j6).toString());
        }
        if (buffer.size() < j6) {
            throw new EOFException();
        }
        if (j6 == 0) {
            return "";
        }
        Segment segment = buffer.head;
        g0.m(segment);
        int i6 = segment.pos;
        if (i6 + j6 > segment.limit) {
            return _Utf8Kt.commonToUtf8String$default(buffer.readByteArray(j6), 0, 0, 3, null);
        }
        int i7 = (int) j6;
        String commonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, i6, i6 + i7);
        segment.pos += i7;
        buffer.setSize$okio(buffer.size() - j6);
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return commonToUtf8String;
    }

    public static final int commonReadUtf8CodePoint(@NotNull okio.Buffer buffer) {
        int i6;
        int i7;
        int i8;
        g0.p(buffer, "<this>");
        if (buffer.size() == 0) {
            throw new EOFException();
        }
        byte b6 = buffer.getByte(0L);
        if ((b6 & 128) == 0) {
            i6 = b6 & Byte.MAX_VALUE;
            i7 = 1;
            i8 = 0;
        } else if ((b6 & 224) == 192) {
            i6 = b6 & Ascii.US;
            i7 = 2;
            i8 = 128;
        } else if ((b6 & 240) == 224) {
            i6 = b6 & 15;
            i7 = 3;
            i8 = 2048;
        } else {
            if ((b6 & 248) != 240) {
                buffer.skip(1L);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i6 = b6 & 7;
            i7 = 4;
            i8 = 65536;
        }
        long j6 = i7;
        if (buffer.size() < j6) {
            throw new EOFException("size < " + i7 + ": " + buffer.size() + " (to read code point prefixed 0x" + SegmentedByteString.toHexString(b6) + ')');
        }
        for (int i9 = 1; i9 < i7; i9++) {
            long j7 = i9;
            byte b7 = buffer.getByte(j7);
            if ((b7 & 192) != 128) {
                buffer.skip(j7);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i6 = (i6 << 6) | (b7 & Utf8.REPLACEMENT_BYTE);
        }
        buffer.skip(j6);
        return i6 > 1114111 ? Utf8.REPLACEMENT_CODE_POINT : ((55296 > i6 || i6 >= 57344) && i6 >= i8) ? i6 : Utf8.REPLACEMENT_CODE_POINT;
    }

    @Nullable
    public static final String commonReadUtf8Line(@NotNull okio.Buffer buffer) {
        g0.p(buffer, "<this>");
        long indexOf = buffer.indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(buffer, indexOf);
        }
        if (buffer.size() != 0) {
            return buffer.readUtf8(buffer.size());
        }
        return null;
    }

    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull okio.Buffer buffer, long j6) {
        g0.p(buffer, "<this>");
        if (j6 < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j6).toString());
        }
        long j7 = j6 != Long.MAX_VALUE ? j6 + 1 : Long.MAX_VALUE;
        long indexOf = buffer.indexOf((byte) 10, 0L, j7);
        if (indexOf != -1) {
            return readUtf8Line(buffer, indexOf);
        }
        if (j7 < buffer.size() && buffer.getByte(j7 - 1) == 13 && buffer.getByte(j7) == 10) {
            return readUtf8Line(buffer, j7);
        }
        okio.Buffer buffer2 = new okio.Buffer();
        buffer.copyTo(buffer2, 0L, Math.min(32, buffer.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(buffer.size(), j6) + " content=" + buffer2.readByteString().hex() + v0.F);
    }

    public static final long commonResizeBuffer(@NotNull Buffer.UnsafeCursor unsafeCursor, long j6) {
        g0.p(unsafeCursor, "<this>");
        okio.Buffer buffer = unsafeCursor.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (!unsafeCursor.readWrite) {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
        }
        long size = buffer.size();
        if (j6 <= size) {
            if (j6 < 0) {
                throw new IllegalArgumentException(("newSize < 0: " + j6).toString());
            }
            long j7 = size - j6;
            while (true) {
                if (j7 <= 0) {
                    break;
                }
                Segment segment = buffer.head;
                g0.m(segment);
                Segment segment2 = segment.prev;
                g0.m(segment2);
                int i6 = segment2.limit;
                long j8 = i6 - segment2.pos;
                if (j8 > j7) {
                    segment2.limit = i6 - ((int) j7);
                    break;
                }
                buffer.head = segment2.pop();
                SegmentPool.recycle(segment2);
                j7 -= j8;
            }
            unsafeCursor.setSegment$okio(null);
            unsafeCursor.offset = j6;
            unsafeCursor.data = null;
            unsafeCursor.start = -1;
            unsafeCursor.end = -1;
        } else if (j6 > size) {
            long j9 = j6 - size;
            boolean z5 = true;
            for (long j10 = 0; j9 > j10; j10 = 0) {
                Segment writableSegment$okio = buffer.writableSegment$okio(1);
                int min = (int) Math.min(j9, 8192 - writableSegment$okio.limit);
                writableSegment$okio.limit += min;
                j9 -= min;
                if (z5) {
                    unsafeCursor.setSegment$okio(writableSegment$okio);
                    unsafeCursor.offset = size;
                    unsafeCursor.data = writableSegment$okio.data;
                    int i7 = writableSegment$okio.limit;
                    unsafeCursor.start = i7 - min;
                    unsafeCursor.end = i7;
                    z5 = false;
                }
            }
        }
        buffer.setSize$okio(j6);
        return size;
    }

    public static final int commonSeek(@NotNull Buffer.UnsafeCursor unsafeCursor, long j6) {
        Segment segment;
        g0.p(unsafeCursor, "<this>");
        okio.Buffer buffer = unsafeCursor.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (j6 < -1 || j6 > buffer.size()) {
            throw new ArrayIndexOutOfBoundsException("offset=" + j6 + " > size=" + buffer.size());
        }
        if (j6 == -1 || j6 == buffer.size()) {
            unsafeCursor.setSegment$okio(null);
            unsafeCursor.offset = j6;
            unsafeCursor.data = null;
            unsafeCursor.start = -1;
            unsafeCursor.end = -1;
            return -1;
        }
        long size = buffer.size();
        Segment segment2 = buffer.head;
        long j7 = 0;
        if (unsafeCursor.getSegment$okio() != null) {
            long j8 = unsafeCursor.offset;
            int i6 = unsafeCursor.start;
            g0.m(unsafeCursor.getSegment$okio());
            long j9 = j8 - (i6 - r9.pos);
            if (j9 > j6) {
                segment = segment2;
                segment2 = unsafeCursor.getSegment$okio();
                size = j9;
            } else {
                segment = unsafeCursor.getSegment$okio();
                j7 = j9;
            }
        } else {
            segment = segment2;
        }
        if (size - j6 > j6 - j7) {
            while (true) {
                g0.m(segment);
                int i7 = segment.limit;
                int i8 = segment.pos;
                if (j6 < (i7 - i8) + j7) {
                    break;
                }
                j7 += i7 - i8;
                segment = segment.next;
            }
        } else {
            while (size > j6) {
                g0.m(segment2);
                segment2 = segment2.prev;
                g0.m(segment2);
                size -= segment2.limit - segment2.pos;
            }
            j7 = size;
            segment = segment2;
        }
        if (unsafeCursor.readWrite) {
            g0.m(segment);
            if (segment.shared) {
                Segment unsharedCopy = segment.unsharedCopy();
                if (buffer.head == segment) {
                    buffer.head = unsharedCopy;
                }
                segment = segment.push(unsharedCopy);
                Segment segment3 = segment.prev;
                g0.m(segment3);
                segment3.pop();
            }
        }
        unsafeCursor.setSegment$okio(segment);
        unsafeCursor.offset = j6;
        g0.m(segment);
        unsafeCursor.data = segment.data;
        int i9 = segment.pos + ((int) (j6 - j7));
        unsafeCursor.start = i9;
        int i10 = segment.limit;
        unsafeCursor.end = i10;
        return i10 - i9;
    }

    public static final int commonSelect(@NotNull okio.Buffer buffer, @NotNull Options options) {
        g0.p(buffer, "<this>");
        g0.p(options, "options");
        int selectPrefix$default = selectPrefix$default(buffer, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        buffer.skip(options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public static final void commonSkip(@NotNull okio.Buffer buffer, long j6) {
        g0.p(buffer, "<this>");
        while (j6 > 0) {
            Segment segment = buffer.head;
            if (segment == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j6, segment.limit - segment.pos);
            long j7 = min;
            buffer.setSize$okio(buffer.size() - j7);
            j6 -= j7;
            int i6 = segment.pos + min;
            segment.pos = i6;
            if (i6 == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    @NotNull
    public static final Segment commonWritableSegment(@NotNull okio.Buffer buffer, int i6) {
        g0.p(buffer, "<this>");
        if (i6 < 1 || i6 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        Segment segment = buffer.head;
        if (segment != null) {
            g0.m(segment);
            Segment segment2 = segment.prev;
            g0.m(segment2);
            return (segment2.limit + i6 > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        Segment take = SegmentPool.take();
        buffer.head = take;
        take.prev = take;
        take.next = take;
        return take;
    }

    @NotNull
    public static final okio.Buffer commonWrite(@NotNull okio.Buffer buffer, @NotNull byte[] source) {
        g0.p(buffer, "<this>");
        g0.p(source, "source");
        return buffer.write(source, 0, source.length);
    }

    public static /* synthetic */ okio.Buffer commonWrite$default(okio.Buffer buffer, ByteString byteString, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = byteString.size();
        }
        g0.p(buffer, "<this>");
        g0.p(byteString, "byteString");
        byteString.write$okio(buffer, i6, i7);
        return buffer;
    }

    public static final long commonWriteAll(@NotNull okio.Buffer buffer, @NotNull Source source) {
        g0.p(buffer, "<this>");
        g0.p(source, "source");
        long j6 = 0;
        while (true) {
            long read = source.read(buffer, 8192L);
            if (read == -1) {
                return j6;
            }
            j6 += read;
        }
    }

    @NotNull
    public static final okio.Buffer commonWriteByte(@NotNull okio.Buffer buffer, int i6) {
        g0.p(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i7 = writableSegment$okio.limit;
        writableSegment$okio.limit = i7 + 1;
        bArr[i7] = (byte) i6;
        buffer.setSize$okio(buffer.size() + 1);
        return buffer;
    }

    @NotNull
    public static final okio.Buffer commonWriteDecimalLong(@NotNull okio.Buffer buffer, long j6) {
        boolean z5;
        g0.p(buffer, "<this>");
        if (j6 == 0) {
            return buffer.writeByte(48);
        }
        if (j6 < 0) {
            j6 = -j6;
            if (j6 < 0) {
                return buffer.writeUtf8("-9223372036854775808");
            }
            z5 = true;
        } else {
            z5 = false;
        }
        int countDigitsIn = countDigitsIn(j6);
        if (z5) {
            countDigitsIn++;
        }
        Segment writableSegment$okio = buffer.writableSegment$okio(countDigitsIn);
        byte[] bArr = writableSegment$okio.data;
        int i6 = writableSegment$okio.limit + countDigitsIn;
        while (j6 != 0) {
            long j7 = 10;
            i6--;
            bArr[i6] = getHEX_DIGIT_BYTES()[(int) (j6 % j7)];
            j6 /= j7;
        }
        if (z5) {
            bArr[i6 - 1] = 45;
        }
        writableSegment$okio.limit += countDigitsIn;
        buffer.setSize$okio(buffer.size() + countDigitsIn);
        return buffer;
    }

    @NotNull
    public static final okio.Buffer commonWriteHexadecimalUnsignedLong(@NotNull okio.Buffer buffer, long j6) {
        g0.p(buffer, "<this>");
        if (j6 == 0) {
            return buffer.writeByte(48);
        }
        long j7 = (j6 >>> 1) | j6;
        long j8 = j7 | (j7 >>> 2);
        long j9 = j8 | (j8 >>> 4);
        long j10 = j9 | (j9 >>> 8);
        long j11 = j10 | (j10 >>> 16);
        long j12 = j11 | (j11 >>> 32);
        long j13 = j12 - ((j12 >>> 1) & 6148914691236517205L);
        long j14 = ((j13 >>> 2) & 3689348814741910323L) + (j13 & 3689348814741910323L);
        long j15 = ((j14 >>> 4) + j14) & 1085102592571150095L;
        long j16 = j15 + (j15 >>> 8);
        long j17 = j16 + (j16 >>> 16);
        int i6 = (int) ((((j17 & 63) + ((j17 >>> 32) & 63)) + 3) / 4);
        Segment writableSegment$okio = buffer.writableSegment$okio(i6);
        byte[] bArr = writableSegment$okio.data;
        int i7 = writableSegment$okio.limit;
        for (int i8 = (i7 + i6) - 1; i8 >= i7; i8--) {
            bArr[i8] = getHEX_DIGIT_BYTES()[(int) (15 & j6)];
            j6 >>>= 4;
        }
        writableSegment$okio.limit += i6;
        buffer.setSize$okio(buffer.size() + i6);
        return buffer;
    }

    @NotNull
    public static final okio.Buffer commonWriteInt(@NotNull okio.Buffer buffer, int i6) {
        g0.p(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i7 = writableSegment$okio.limit;
        bArr[i7] = (byte) ((i6 >>> 24) & 255);
        bArr[i7 + 1] = (byte) ((i6 >>> 16) & 255);
        bArr[i7 + 2] = (byte) ((i6 >>> 8) & 255);
        bArr[i7 + 3] = (byte) (i6 & 255);
        writableSegment$okio.limit = i7 + 4;
        buffer.setSize$okio(buffer.size() + 4);
        return buffer;
    }

    @NotNull
    public static final okio.Buffer commonWriteLong(@NotNull okio.Buffer buffer, long j6) {
        g0.p(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i6 = writableSegment$okio.limit;
        bArr[i6] = (byte) ((j6 >>> 56) & 255);
        bArr[i6 + 1] = (byte) ((j6 >>> 48) & 255);
        bArr[i6 + 2] = (byte) ((j6 >>> 40) & 255);
        bArr[i6 + 3] = (byte) ((j6 >>> 32) & 255);
        bArr[i6 + 4] = (byte) ((j6 >>> 24) & 255);
        bArr[i6 + 5] = (byte) ((j6 >>> 16) & 255);
        bArr[i6 + 6] = (byte) ((j6 >>> 8) & 255);
        bArr[i6 + 7] = (byte) (j6 & 255);
        writableSegment$okio.limit = i6 + 8;
        buffer.setSize$okio(buffer.size() + 8);
        return buffer;
    }

    @NotNull
    public static final okio.Buffer commonWriteShort(@NotNull okio.Buffer buffer, int i6) {
        g0.p(buffer, "<this>");
        Segment writableSegment$okio = buffer.writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i7 = writableSegment$okio.limit;
        bArr[i7] = (byte) ((i6 >>> 8) & 255);
        bArr[i7 + 1] = (byte) (i6 & 255);
        writableSegment$okio.limit = i7 + 2;
        buffer.setSize$okio(buffer.size() + 2);
        return buffer;
    }

    @NotNull
    public static final okio.Buffer commonWriteUtf8CodePoint(@NotNull okio.Buffer buffer, int i6) {
        g0.p(buffer, "<this>");
        if (i6 < 128) {
            buffer.writeByte(i6);
            return buffer;
        }
        if (i6 < 2048) {
            Segment writableSegment$okio = buffer.writableSegment$okio(2);
            byte[] bArr = writableSegment$okio.data;
            int i7 = writableSegment$okio.limit;
            bArr[i7] = (byte) ((i6 >> 6) | 192);
            bArr[i7 + 1] = (byte) ((i6 & 63) | 128);
            writableSegment$okio.limit = i7 + 2;
            buffer.setSize$okio(buffer.size() + 2);
            return buffer;
        }
        if (55296 <= i6 && i6 < 57344) {
            buffer.writeByte(63);
            return buffer;
        }
        if (i6 < 65536) {
            Segment writableSegment$okio2 = buffer.writableSegment$okio(3);
            byte[] bArr2 = writableSegment$okio2.data;
            int i8 = writableSegment$okio2.limit;
            bArr2[i8] = (byte) ((i6 >> 12) | 224);
            bArr2[i8 + 1] = (byte) (((i6 >> 6) & 63) | 128);
            bArr2[i8 + 2] = (byte) ((i6 & 63) | 128);
            writableSegment$okio2.limit = i8 + 3;
            buffer.setSize$okio(buffer.size() + 3);
            return buffer;
        }
        if (i6 > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x" + SegmentedByteString.toHexString(i6));
        }
        Segment writableSegment$okio3 = buffer.writableSegment$okio(4);
        byte[] bArr3 = writableSegment$okio3.data;
        int i9 = writableSegment$okio3.limit;
        bArr3[i9] = (byte) ((i6 >> 18) | 240);
        bArr3[i9 + 1] = (byte) (((i6 >> 12) & 63) | 128);
        bArr3[i9 + 2] = (byte) (((i6 >> 6) & 63) | 128);
        bArr3[i9 + 3] = (byte) ((i6 & 63) | 128);
        writableSegment$okio3.limit = i9 + 4;
        buffer.setSize$okio(buffer.size() + 4);
        return buffer;
    }

    @NotNull
    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(@NotNull Segment segment, int i6, @NotNull byte[] bytes, int i7, int i8) {
        g0.p(segment, "segment");
        g0.p(bytes, "bytes");
        int i9 = segment.limit;
        byte[] bArr = segment.data;
        while (i7 < i8) {
            if (i6 == i9) {
                segment = segment.next;
                g0.m(segment);
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i6 = segment.pos;
                i9 = segment.limit;
            }
            if (bArr[i6] != bytes[i7]) {
                return false;
            }
            i6++;
            i7++;
        }
        return true;
    }

    @NotNull
    public static final String readUtf8Line(@NotNull okio.Buffer buffer, long j6) {
        g0.p(buffer, "<this>");
        if (j6 > 0) {
            long j7 = j6 - 1;
            if (buffer.getByte(j7) == 13) {
                String readUtf8 = buffer.readUtf8(j7);
                buffer.skip(2L);
                return readUtf8;
            }
        }
        String readUtf82 = buffer.readUtf8(j6);
        buffer.skip(1L);
        return readUtf82;
    }

    public static final <T> T seek(@NotNull okio.Buffer buffer, long j6, @NotNull Function2<? super Segment, ? super Long, ? extends T> lambda) {
        g0.p(buffer, "<this>");
        g0.p(lambda, "lambda");
        Segment segment = buffer.head;
        if (segment == null) {
            return lambda.invoke(null, -1L);
        }
        if (buffer.size() - j6 < j6) {
            long size = buffer.size();
            while (size > j6) {
                segment = segment.prev;
                g0.m(segment);
                size -= segment.limit - segment.pos;
            }
            return lambda.invoke(segment, Long.valueOf(size));
        }
        long j7 = 0;
        while (true) {
            long j8 = (segment.limit - segment.pos) + j7;
            if (j8 > j6) {
                return lambda.invoke(segment, Long.valueOf(j7));
            }
            segment = segment.next;
            g0.m(segment);
            j7 = j8;
        }
    }

    public static final int selectPrefix(@NotNull okio.Buffer buffer, @NotNull Options options, boolean z5) {
        int i6;
        int i7;
        Segment segment;
        int i8;
        int i9;
        g0.p(buffer, "<this>");
        g0.p(options, "options");
        Segment segment2 = buffer.head;
        if (segment2 == null) {
            return z5 ? -2 : -1;
        }
        byte[] bArr = segment2.data;
        int i10 = segment2.pos;
        int i11 = segment2.limit;
        int[] trie$okio = options.getTrie$okio();
        Segment segment3 = segment2;
        int i12 = 0;
        int i13 = -1;
        loop0: while (true) {
            int i14 = i12 + 1;
            int i15 = trie$okio[i12];
            int i16 = i12 + 2;
            int i17 = trie$okio[i14];
            if (i17 != -1) {
                i13 = i17;
            }
            if (segment3 == null) {
                break;
            }
            if (i15 >= 0) {
                i6 = i10 + 1;
                int i18 = bArr[i10] & 255;
                int i19 = i16 + i15;
                while (i16 != i19) {
                    if (i18 == trie$okio[i16]) {
                        i7 = trie$okio[i16 + i15];
                        if (i6 == i11) {
                            segment3 = segment3.next;
                            g0.m(segment3);
                            i6 = segment3.pos;
                            bArr = segment3.data;
                            i11 = segment3.limit;
                            if (segment3 == segment2) {
                                segment3 = null;
                            }
                        }
                        if (i7 >= 0) {
                            return i7;
                        }
                        i12 = -i7;
                        i10 = i6;
                    } else {
                        i16++;
                    }
                }
                break loop0;
            }
            int i20 = i16 + (i15 * (-1));
            while (true) {
                int i21 = i10 + 1;
                int i22 = i16 + 1;
                if ((bArr[i10] & 255) != trie$okio[i16]) {
                    break loop0;
                }
                boolean z6 = i22 == i20;
                if (i21 == i11) {
                    g0.m(segment3);
                    Segment segment4 = segment3.next;
                    g0.m(segment4);
                    i9 = segment4.pos;
                    byte[] bArr2 = segment4.data;
                    i8 = segment4.limit;
                    if (segment4 != segment2) {
                        segment = segment4;
                        bArr = bArr2;
                    } else {
                        if (!z6) {
                            break loop0;
                        }
                        bArr = bArr2;
                        segment = null;
                    }
                } else {
                    segment = segment3;
                    i8 = i11;
                    i9 = i21;
                }
                if (z6) {
                    i7 = trie$okio[i22];
                    i6 = i9;
                    i11 = i8;
                    segment3 = segment;
                    break;
                }
                i10 = i9;
                i11 = i8;
                segment3 = segment;
                i16 = i22;
            }
        }
        if (z5) {
            return -2;
        }
        return i13;
    }

    public static /* synthetic */ int selectPrefix$default(okio.Buffer buffer, Options options, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return selectPrefix(buffer, options, z5);
    }

    @NotNull
    public static final okio.Buffer commonWrite(@NotNull okio.Buffer buffer, @NotNull byte[] source, int i6, int i7) {
        g0.p(buffer, "<this>");
        g0.p(source, "source");
        long j6 = i7;
        SegmentedByteString.checkOffsetAndCount(source.length, i6, j6);
        int i8 = i7 + i6;
        while (i6 < i8) {
            Segment writableSegment$okio = buffer.writableSegment$okio(1);
            int min = Math.min(i8 - i6, 8192 - writableSegment$okio.limit);
            int i9 = i6 + min;
            n.v0(source, writableSegment$okio.data, writableSegment$okio.limit, i6, i9);
            writableSegment$okio.limit += min;
            i6 = i9;
        }
        buffer.setSize$okio(buffer.size() + j6);
        return buffer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int countDigitsIn(long j6) {
        int i6;
        int numberOfLeadingZeros = ((64 - Long.numberOfLeadingZeros(j6)) * 10) >>> 5;
        if (j6 > DigitCountToLargestValue[numberOfLeadingZeros]) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        return numberOfLeadingZeros + i6;
    }

    public static final void commonReadFully(@NotNull okio.Buffer buffer, @NotNull okio.Buffer sink, long j6) {
        g0.p(buffer, "<this>");
        g0.p(sink, "sink");
        if (buffer.size() >= j6) {
            sink.write(buffer, j6);
        } else {
            sink.write(buffer, buffer.size());
            throw new EOFException();
        }
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull okio.Buffer buffer, int i6) {
        g0.p(buffer, "<this>");
        if (i6 == 0) {
            return ByteString.EMPTY;
        }
        SegmentedByteString.checkOffsetAndCount(buffer.size(), 0L, i6);
        Segment segment = buffer.head;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i6) {
            g0.m(segment);
            int i10 = segment.limit;
            int i11 = segment.pos;
            if (i10 != i11) {
                i8 += i10 - i11;
                i9++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i9][];
        int[] iArr = new int[i9 * 2];
        Segment segment2 = buffer.head;
        int i12 = 0;
        while (i7 < i6) {
            g0.m(segment2);
            bArr[i12] = segment2.data;
            i7 += segment2.limit - segment2.pos;
            iArr[i12] = Math.min(i7, i6);
            iArr[i12 + i9] = segment2.pos;
            segment2.shared = true;
            i12++;
            segment2 = segment2.next;
        }
        return new C1101SegmentedByteString(bArr, iArr);
    }

    @NotNull
    public static final okio.Buffer commonWrite(@NotNull okio.Buffer buffer, @NotNull Source source, long j6) {
        g0.p(buffer, "<this>");
        g0.p(source, "source");
        while (j6 > 0) {
            long read = source.read(buffer, j6);
            if (read == -1) {
                throw new EOFException();
            }
            j6 -= read;
        }
        return buffer;
    }

    public static final long commonRead(@NotNull okio.Buffer buffer, @NotNull okio.Buffer sink, long j6) {
        g0.p(buffer, "<this>");
        g0.p(sink, "sink");
        if (j6 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        }
        if (buffer.size() == 0) {
            return -1L;
        }
        if (j6 > buffer.size()) {
            j6 = buffer.size();
        }
        sink.write(buffer, j6);
        return j6;
    }

    public static final void commonWrite(@NotNull okio.Buffer buffer, @NotNull okio.Buffer source, long j6) {
        Segment segment;
        g0.p(buffer, "<this>");
        g0.p(source, "source");
        if (source != buffer) {
            SegmentedByteString.checkOffsetAndCount(source.size(), 0L, j6);
            while (j6 > 0) {
                Segment segment2 = source.head;
                g0.m(segment2);
                int i6 = segment2.limit;
                g0.m(source.head);
                if (j6 < i6 - r1.pos) {
                    Segment segment3 = buffer.head;
                    if (segment3 != null) {
                        g0.m(segment3);
                        segment = segment3.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((segment.limit + j6) - (segment.shared ? 0 : segment.pos) <= 8192) {
                            Segment segment4 = source.head;
                            g0.m(segment4);
                            segment4.writeTo(segment, (int) j6);
                            source.setSize$okio(source.size() - j6);
                            buffer.setSize$okio(buffer.size() + j6);
                            return;
                        }
                    }
                    Segment segment5 = source.head;
                    g0.m(segment5);
                    source.head = segment5.split((int) j6);
                }
                Segment segment6 = source.head;
                g0.m(segment6);
                long j7 = segment6.limit - segment6.pos;
                source.head = segment6.pop();
                Segment segment7 = buffer.head;
                if (segment7 == null) {
                    buffer.head = segment6;
                    segment6.prev = segment6;
                    segment6.next = segment6;
                } else {
                    g0.m(segment7);
                    Segment segment8 = segment7.prev;
                    g0.m(segment8);
                    segment8.push(segment6).compact();
                }
                source.setSize$okio(source.size() - j7);
                buffer.setSize$okio(buffer.size() + j7);
                j6 -= j7;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    public static final long commonIndexOf(@NotNull okio.Buffer buffer, @NotNull ByteString bytes, long j6, long j7, int i6, int i7) {
        Segment segment;
        int i8;
        long j8 = j6;
        long j9 = j7;
        g0.p(buffer, "<this>");
        g0.p(bytes, "bytes");
        long j10 = i7;
        SegmentedByteString.checkOffsetAndCount(bytes.size(), i6, j10);
        if (i7 <= 0) {
            throw new IllegalArgumentException("byteCount == 0");
        }
        long j11 = 0;
        if (j8 < 0) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j8).toString());
        }
        if (j8 > j9) {
            throw new IllegalArgumentException(("fromIndex > toIndex: " + j8 + " > " + j9).toString());
        }
        if (j9 > buffer.size()) {
            j9 = buffer.size();
        }
        long j12 = -1;
        if (j8 == j9 || (segment = buffer.head) == null) {
            return -1L;
        }
        if (buffer.size() - j8 < j8) {
            j11 = buffer.size();
            while (j11 > j8) {
                segment = segment.prev;
                g0.m(segment);
                j11 -= segment.limit - segment.pos;
                j12 = j12;
            }
            long j13 = j12;
            byte[] internalArray$okio = bytes.internalArray$okio();
            byte b6 = internalArray$okio[i6];
            long min = Math.min(j9, (buffer.size() - j10) + 1);
            while (j11 < min) {
                byte[] bArr = segment.data;
                long j14 = j8;
                int min2 = (int) Math.min(segment.limit, (segment.pos + min) - j11);
                i8 = (int) ((segment.pos + j14) - j11);
                while (i8 < min2) {
                    if (bArr[i8] != b6 || !rangeEquals(segment, i8 + 1, internalArray$okio, i6 + 1, i7)) {
                        i8++;
                    }
                }
                j11 += segment.limit - segment.pos;
                segment = segment.next;
                g0.m(segment);
                j8 = j11;
            }
            return j13;
        }
        while (true) {
            long j15 = (segment.limit - segment.pos) + j11;
            if (j15 > j8) {
                break;
            }
            segment = segment.next;
            g0.m(segment);
            j11 = j15;
        }
        byte[] internalArray$okio2 = bytes.internalArray$okio();
        byte b7 = internalArray$okio2[i6];
        long min3 = Math.min(j9, (buffer.size() - j10) + 1);
        while (j11 < min3) {
            byte[] bArr2 = segment.data;
            long j16 = j8;
            int min4 = (int) Math.min(segment.limit, (segment.pos + min3) - j11);
            i8 = (int) ((segment.pos + j16) - j11);
            while (i8 < min4) {
                if (bArr2[i8] != b7 || !rangeEquals(segment, i8 + 1, internalArray$okio2, i6 + 1, i7)) {
                    i8++;
                }
            }
            j11 += segment.limit - segment.pos;
            segment = segment.next;
            g0.m(segment);
            j8 = j11;
        }
        return -1L;
        return (i8 - segment.pos) + j11;
    }
}
