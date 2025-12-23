package okio;

import com.baidu.mobads.sdk.internal.by;
import com.google.common.base.Ascii;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.collections.n;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.text.v0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Buffer.kt\nokio/Buffer\n+ 2 Util.kt\nokio/-SegmentedByteString\n+ 3 Buffer.kt\nokio/internal/-Buffer\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 BufferedSource.kt\nokio/internal/-BufferedSource\n*L\n1#1,649:1\n88#2:650\n85#2:683\n85#2:685\n73#2:745\n73#2:771\n82#2:810\n76#2:821\n88#2:1014\n73#2:1029\n85#2:1133\n242#3,32:651\n277#3,10:686\n290#3,18:696\n412#3,2:714\n110#3:716\n414#3:717\n112#3,18:718\n311#3,9:736\n320#3,15:746\n338#3,10:761\n348#3,3:772\n346#3,25:775\n374#3,10:800\n384#3:811\n382#3,9:812\n391#3,7:822\n389#3,20:829\n652#3,60:849\n715#3,56:909\n773#3:965\n776#3:966\n777#3,6:968\n787#3,7:974\n797#3,6:984\n805#3,5:990\n837#3,6:995\n847#3:1001\n848#3,11:1003\n859#3,5:1015\n868#3,9:1020\n878#3,61:1030\n603#3:1091\n606#3:1092\n607#3,5:1094\n614#3:1099\n617#3,7:1100\n626#3,20:1107\n418#3:1127\n421#3,5:1128\n426#3,10:1134\n437#3,7:1144\n442#3,2:1151\n943#3:1153\n944#3,87:1155\n1034#3,48:1242\n573#3:1290\n580#3,21:1291\n1085#3,7:1312\n1095#3,7:1319\n1105#3,4:1326\n1112#3,8:1330\n1123#3,10:1338\n1136#3,14:1348\n447#3,35:1362\n513#3,40:1397\n556#3:1437\n558#3,13:1439\n1153#3:1452\n1204#3:1453\n1205#3,39:1455\n1246#3,2:1494\n1248#3,4:1497\n1255#3,3:1501\n1259#3,4:1505\n110#3:1509\n1263#3,22:1510\n112#3,18:1532\n1338#3,2:1550\n1341#3:1553\n110#3:1554\n1342#3,50:1555\n112#3,18:1605\n1401#3,12:1623\n1416#3,32:1635\n1451#3,12:1667\n1466#3,18:1679\n1488#3:1697\n1489#3:1699\n1494#3,34:1700\n1#4:684\n1#4:967\n1#4:1002\n1#4:1093\n1#4:1154\n1#4:1438\n1#4:1454\n1#4:1496\n1#4:1504\n1#4:1552\n1#4:1698\n26#5,3:981\n*S KotlinDebug\n*F\n+ 1 Buffer.kt\nokio/Buffer\n*L\n167#1:650\n197#1:683\n235#1:685\n261#1:745\n264#1:771\n267#1:810\n267#1:821\n337#1:1014\n340#1:1029\n376#1:1133\n181#1:651,32\n252#1:686,10\n255#1:696,18\n258#1:714,2\n258#1:716\n258#1:717\n258#1:718,18\n261#1:736,9\n261#1:746,15\n264#1:761,10\n264#1:772,3\n264#1:775,25\n267#1:800,10\n267#1:811\n267#1:812,9\n267#1:822,7\n267#1:829,20\n279#1:849,60\n282#1:909,56\n284#1:965\n287#1:966\n287#1:968,6\n289#1:974,7\n294#1:984,6\n297#1:990,5\n331#1:995,6\n337#1:1001\n337#1:1003,11\n337#1:1015,5\n340#1:1020,9\n340#1:1030,61\n342#1:1091\n345#1:1092\n345#1:1094,5\n347#1:1099\n350#1:1100,7\n353#1:1107,20\n373#1:1127\n376#1:1128,5\n376#1:1134,10\n378#1:1144,7\n381#1:1151,2\n386#1:1153\n386#1:1155,87\n389#1:1242,48\n412#1:1290\n418#1:1291,21\n439#1:1312,7\n443#1:1319,7\n445#1:1326,4\n447#1:1330,8\n451#1:1338,10\n455#1:1348,14\n459#1:1362,35\n462#1:1397,40\n465#1:1437\n465#1:1439,13\n467#1:1452\n467#1:1453\n467#1:1455,39\n469#1:1494,2\n469#1:1497,4\n480#1:1501,3\n480#1:1505,4\n480#1:1509\n480#1:1510,22\n480#1:1532,18\n496#1:1550,2\n496#1:1553\n496#1:1554\n496#1:1555,50\n496#1:1605,18\n506#1:1623,12\n576#1:1635,32\n578#1:1667,12\n586#1:1679,18\n594#1:1697\n594#1:1699\n596#1:1700,34\n287#1:967\n337#1:1002\n345#1:1093\n386#1:1154\n465#1:1438\n467#1:1454\n469#1:1496\n480#1:1504\n496#1:1552\n594#1:1698\n291#1:981,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {

    @JvmField
    @Nullable
    public Segment head;
    private long size;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Buffer.kt\nokio/Buffer$UnsafeCursor\n+ 2 Buffer.kt\nokio/internal/-Buffer\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,649:1\n1549#2:650\n1550#2:652\n1554#2:653\n1555#2,68:655\n1626#2:723\n1627#2,32:725\n1659#2,18:758\n1680#2:776\n1681#2,18:778\n1703#2:796\n1705#2,7:798\n1#3:651\n1#3:654\n1#3:724\n1#3:777\n1#3:797\n85#4:757\n*S KotlinDebug\n*F\n+ 1 Buffer.kt\nokio/Buffer$UnsafeCursor\n*L\n636#1:650\n636#1:652\n638#1:653\n638#1:655,68\n640#1:723\n640#1:725,32\n640#1:758,18\n642#1:776\n642#1:778,18\n645#1:796\n645#1:798,7\n636#1:651\n638#1:654\n640#1:724\n642#1:777\n645#1:797\n640#1:757\n*E\n"})
    public static final class UnsafeCursor implements Closeable {

        @JvmField
        @Nullable
        public Buffer buffer;

        @JvmField
        @Nullable
        public byte[] data;

        @JvmField
        public boolean readWrite;

        @Nullable
        private Segment segment;

        @JvmField
        public long offset = -1;

        @JvmField
        public int start = -1;

        @JvmField
        public int end = -1;

        public final long resizeBuffer(long j6) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
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
                setSegment$okio(null);
                this.offset = j6;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (j6 > size) {
                long j9 = j6 - size;
                boolean z5 = true;
                for (long j10 = 0; j9 > j10; j10 = 0) {
                    Segment writableSegment$okio = buffer.writableSegment$okio(1);
                    int min = (int) Math.min(j9, 8192 - writableSegment$okio.limit);
                    writableSegment$okio.limit += min;
                    j9 -= min;
                    if (z5) {
                        setSegment$okio(writableSegment$okio);
                        this.offset = size;
                        this.data = writableSegment$okio.data;
                        int i7 = writableSegment$okio.limit;
                        this.start = i7 - min;
                        this.end = i7;
                        z5 = false;
                    }
                }
            }
            buffer.setSize$okio(j6);
            return size;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.buffer = null;
            setSegment$okio(null);
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final long expandBuffer(int i6) {
            if (i6 <= 0) {
                throw new IllegalArgumentException(("minByteCount <= 0: " + i6).toString());
            }
            if (i6 > 8192) {
                throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + i6).toString());
            }
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
            }
            long size = buffer.size();
            Segment writableSegment$okio = buffer.writableSegment$okio(i6);
            int i7 = 8192 - writableSegment$okio.limit;
            writableSegment$okio.limit = 8192;
            long j6 = i7;
            buffer.setSize$okio(size + j6);
            setSegment$okio(writableSegment$okio);
            this.offset = size;
            this.data = writableSegment$okio.data;
            this.start = 8192 - i7;
            this.end = 8192;
            return j6;
        }

        @Nullable
        public final Segment getSegment$okio() {
            return this.segment;
        }

        public final int next() {
            long j6 = this.offset;
            Buffer buffer = this.buffer;
            g0.m(buffer);
            if (j6 == buffer.size()) {
                throw new IllegalStateException("no more bytes");
            }
            long j7 = this.offset;
            return seek(j7 == -1 ? 0L : j7 + (this.end - this.start));
        }

        public final int seek(long j6) {
            Segment segment;
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (j6 < -1 || j6 > buffer.size()) {
                throw new ArrayIndexOutOfBoundsException("offset=" + j6 + " > size=" + buffer.size());
            }
            if (j6 == -1 || j6 == buffer.size()) {
                setSegment$okio(null);
                this.offset = j6;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            }
            long size = buffer.size();
            Segment segment2 = buffer.head;
            long j7 = 0;
            if (getSegment$okio() != null) {
                long j8 = this.offset;
                int i6 = this.start;
                g0.m(getSegment$okio());
                long j9 = j8 - (i6 - r9.pos);
                if (j9 > j6) {
                    segment = segment2;
                    segment2 = getSegment$okio();
                    size = j9;
                } else {
                    segment = getSegment$okio();
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
            if (this.readWrite) {
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
            setSegment$okio(segment);
            this.offset = j6;
            g0.m(segment);
            this.data = segment.data;
            int i9 = segment.pos + ((int) (j6 - j7));
            this.start = i9;
            int i10 = segment.limit;
            this.end = i10;
            return i10 - i9;
        }

        public final void setSegment$okio(@Nullable Segment segment) {
            this.segment = segment;
        }
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, OutputStream outputStream, long j6, long j7, int i6, Object obj) throws IOException {
        if ((i6 & 2) != 0) {
            j6 = 0;
        }
        long j8 = j6;
        if ((i6 & 4) != 0) {
            j7 = buffer.size - j8;
        }
        return buffer.copyTo(outputStream, j8, j7);
    }

    @JvmOverloads
    @NotNull
    public final Buffer copyTo(@NotNull OutputStream out) throws IOException {
        g0.p(out, "out");
        return copyTo$default(this, out, 0L, 0L, 6, (Object) null);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer emit() {
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer emitCompleteSegments() {
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b6) {
        return indexOf(b6, 0L, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString targetBytes) {
        g0.p(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0L);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j6, @NotNull ByteString bytes) {
        g0.p(bytes, "bytes");
        return rangeEquals(j6, bytes, 0, bytes.size());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(@NotNull ByteBuffer sink) throws IOException {
        g0.p(sink, "sink");
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(sink.remaining(), segment.limit - segment.pos);
        sink.put(segment.data, segment.pos, min);
        int i6 = segment.pos + min;
        segment.pos = i6;
        this.size -= min;
        if (i6 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }

    @Override // okio.BufferedSource
    @NotNull
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @Override // okio.BufferedSource
    @NotNull
    public ByteString readByteString() {
        return readByteString(size());
    }

    @NotNull
    public final Buffer readFrom(@NotNull InputStream input) throws IOException {
        g0.p(input, "input");
        readFrom(input, Long.MAX_VALUE, true);
        return this;
    }

    @Override // okio.BufferedSource
    public void readFully(@NotNull Buffer sink, long j6) throws EOFException {
        g0.p(sink, "sink");
        if (size() >= j6) {
            sink.write(this, j6);
        } else {
            sink.write(this, size());
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readString(@NotNull Charset charset) {
        g0.p(charset, "charset");
        return readString(this.size, charset);
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8() {
        return readString(this.size, kotlin.text.e.f47851b);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public int select(@NotNull Options options) {
        g0.p(options, "options");
        int selectPrefix$default = okio.internal.Buffer.selectPrefix$default(this, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        skip(options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    @NotNull
    public final ByteString snapshot() {
        if (size() <= 2147483647L) {
            return snapshot((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    @NotNull
    public final Segment writableSegment$okio(int i6) {
        if (i6 < 1 || i6 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        Segment segment = this.head;
        if (segment != null) {
            g0.m(segment);
            Segment segment2 = segment.prev;
            g0.m(segment2);
            return (segment2.limit + i6 > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        Segment take = SegmentPool.take();
        this.head = take;
        take.prev = take;
        take.next = take;
        return take;
    }

    @JvmOverloads
    @NotNull
    public final Buffer writeTo(@NotNull OutputStream out) throws IOException {
        g0.p(out, "out");
        return writeTo$default(this, out, 0L, 2, null);
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            unsafeCursor = SegmentedByteString.getDEFAULT__new_UnsafeCursor();
        }
        return buffer.readAndWriteUnsafe(unsafeCursor);
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            unsafeCursor = SegmentedByteString.getDEFAULT__new_UnsafeCursor();
        }
        return buffer.readUnsafe(unsafeCursor);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer buffer, OutputStream outputStream, long j6, int i6, Object obj) throws IOException {
        if ((i6 & 2) != 0) {
            j6 = buffer.size;
        }
        return buffer.writeTo(outputStream, j6);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* renamed from: -deprecated_size, reason: not valid java name */
    public final long m297deprecated_size() {
        return this.size;
    }

    @NotNull
    public Buffer clone() {
        return copy();
    }

    @NotNull
    public final Buffer copy() {
        Buffer buffer = new Buffer();
        if (size() == 0) {
            return buffer;
        }
        Segment segment = this.head;
        g0.m(segment);
        Segment sharedCopy = segment.sharedCopy();
        buffer.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = sharedCopy.prev;
            g0.m(segment3);
            g0.m(segment2);
            segment3.push(segment2.sharedCopy());
        }
        buffer.setSize$okio(size());
        return buffer;
    }

    @JvmOverloads
    @NotNull
    public final Buffer copyTo(@NotNull OutputStream out, long j6) throws IOException {
        g0.p(out, "out");
        return copyTo$default(this, out, j6, 0L, 4, (Object) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        if (size() != buffer.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        Segment segment = this.head;
        g0.m(segment);
        Segment segment2 = buffer.head;
        g0.m(segment2);
        int i6 = segment.pos;
        int i7 = segment2.pos;
        long j6 = 0;
        while (j6 < size()) {
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

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    public int hashCode() {
        Segment segment = this.head;
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
        } while (segment != this.head);
        return i6;
    }

    @NotNull
    public final ByteString hmacSha1(@NotNull ByteString key) {
        g0.p(key, "key");
        return hmac("HmacSHA1", key);
    }

    @NotNull
    public final ByteString hmacSha256(@NotNull ByteString key) {
        g0.p(key, "key");
        return hmac("HmacSHA256", key);
    }

    @NotNull
    public final ByteString hmacSha512(@NotNull ByteString key) {
        g0.p(key, "key");
        return hmac("HmacSHA512", key);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b6, long j6) {
        return indexOf(b6, j6, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString targetBytes, long j6) {
        int i6;
        int i7;
        g0.p(targetBytes, "targetBytes");
        long j7 = 0;
        if (j6 < 0) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j6).toString());
        }
        Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        if (size() - j6 < j6) {
            j7 = size();
            while (j7 > j6) {
                segment = segment.prev;
                g0.m(segment);
                j7 -= segment.limit - segment.pos;
            }
            if (targetBytes.size() == 2) {
                byte b6 = targetBytes.getByte(0);
                byte b7 = targetBytes.getByte(1);
                while (j7 < size()) {
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
                while (j7 < size()) {
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
            while (j7 < size()) {
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
            while (j7 < size()) {
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

    @Override // okio.BufferedSource
    @NotNull
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.Buffer$inputStream$1
            @Override // java.io.InputStream
            public int read() {
                if (Buffer.this.size() > 0) {
                    return Buffer.this.readByte() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size(), Integer.MAX_VALUE);
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] sink, int i6, int i7) {
                g0.p(sink, "sink");
                return Buffer.this.read(sink, i6, i7);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        };
    }

    @NotNull
    public final ByteString md5() {
        return digest(by.f10823a);
    }

    @Override // okio.BufferedSink
    @NotNull
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.Buffer$outputStream$1
            @Override // java.io.OutputStream
            public void write(int i6) {
                Buffer.this.writeByte(i6);
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(byte[] data, int i6, int i7) {
                g0.p(data, "data");
                Buffer.this.write(data, i6, i7);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }
        };
    }

    @Override // okio.BufferedSource
    @NotNull
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j6, @NotNull ByteString bytes, int i6, int i7) {
        g0.p(bytes, "bytes");
        return i7 >= 0 && j6 >= 0 && ((long) i7) + j6 <= size() && i6 >= 0 && i6 + i7 <= bytes.size() && (i7 == 0 || okio.internal.Buffer.commonIndexOf(this, bytes, j6, j6 + 1, i6, i7) != -1);
    }

    @Override // okio.BufferedSource
    public long readAll(@NotNull Sink sink) throws IOException {
        g0.p(sink, "sink");
        long size = size();
        if (size > 0) {
            sink.write(this, size);
        }
        return size;
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readAndWriteUnsafe(@NotNull UnsafeCursor unsafeCursor) {
        g0.p(unsafeCursor, "unsafeCursor");
        return okio.internal.Buffer.commonReadAndWriteUnsafe(this, unsafeCursor);
    }

    @Override // okio.BufferedSource
    @NotNull
    public byte[] readByteArray(long j6) throws EOFException {
        if (j6 < 0 || j6 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j6).toString());
        }
        if (size() < j6) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j6];
        readFully(bArr);
        return bArr;
    }

    @Override // okio.BufferedSource
    @NotNull
    public ByteString readByteString(long j6) throws EOFException {
        if (j6 < 0 || j6 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j6).toString());
        }
        if (size() < j6) {
            throw new EOFException();
        }
        if (j6 < 4096) {
            return new ByteString(readByteArray(j6));
        }
        ByteString snapshot = snapshot((int) j6);
        skip(j6);
        return snapshot;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a5, code lost:
    
        setSize$okio(size() - r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ae, code lost:
    
        if (r2 == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b0, code lost:
    
        r14 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b3, code lost:
    
        if (r1 >= r14) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00bb, code lost:
    
        if (size() == r17) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00bd, code lost:
    
        if (r2 == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00bf, code lost:
    
        r1 = "Expected a digit";
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e7, code lost:
    
        throw new java.lang.NumberFormatException(r1 + " but was 0x" + okio.SegmentedByteString.toHexString(getByte(r17)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c2, code lost:
    
        r1 = "Expected a digit or '-'";
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ed, code lost:
    
        throw new java.io.EOFException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ee, code lost:
    
        if (r2 == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f0, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f2, code lost:
    
        return -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b2, code lost:
    
        r14 = 1;
     */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readDecimalLong() throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    @NotNull
    public final Buffer readFrom(@NotNull InputStream input, long j6) throws IOException {
        g0.p(input, "input");
        if (j6 >= 0) {
            readFrom(input, j6, false);
            return this;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readString(long j6, @NotNull Charset charset) throws EOFException {
        g0.p(charset, "charset");
        if (j6 < 0 || j6 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j6).toString());
        }
        if (this.size < j6) {
            throw new EOFException();
        }
        if (j6 == 0) {
            return "";
        }
        Segment segment = this.head;
        g0.m(segment);
        int i6 = segment.pos;
        if (i6 + j6 > segment.limit) {
            return new String(readByteArray(j6), charset);
        }
        int i7 = (int) j6;
        String str = new String(segment.data, i6, i7, charset);
        int i8 = segment.pos + i7;
        segment.pos = i8;
        this.size -= j6;
        if (i8 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return str;
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readUnsafe(@NotNull UnsafeCursor unsafeCursor) {
        g0.p(unsafeCursor, "unsafeCursor");
        return okio.internal.Buffer.commonReadUnsafe(this, unsafeCursor);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8(long j6) throws EOFException {
        return readString(j6, kotlin.text.e.f47851b);
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return okio.internal.Buffer.readUtf8Line(this, indexOf);
        }
        if (size() != 0) {
            return readUtf8(size());
        }
        return null;
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict(long j6) throws EOFException {
        if (j6 < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j6).toString());
        }
        long j7 = j6 != Long.MAX_VALUE ? j6 + 1 : Long.MAX_VALUE;
        long indexOf = indexOf((byte) 10, 0L, j7);
        if (indexOf != -1) {
            return okio.internal.Buffer.readUtf8Line(this, indexOf);
        }
        if (j7 < size() && getByte(j7 - 1) == 13 && getByte(j7) == 10) {
            return okio.internal.Buffer.readUtf8Line(this, j7);
        }
        Buffer buffer = new Buffer();
        copyTo(buffer, 0L, Math.min(32, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j6) + " content=" + buffer.readByteString().hex() + v0.F);
    }

    @Override // okio.BufferedSource
    public boolean request(long j6) {
        return this.size >= j6;
    }

    @Override // okio.BufferedSource
    public void require(long j6) throws EOFException {
        if (this.size < j6) {
            throw new EOFException();
        }
    }

    public final void setSize$okio(long j6) {
        this.size = j6;
    }

    @NotNull
    public final ByteString sha1() {
        return digest("SHA-1");
    }

    @NotNull
    public final ByteString sha256() {
        return digest("SHA-256");
    }

    @NotNull
    public final ByteString sha512() {
        return digest("SHA-512");
    }

    @JvmName(name = "size")
    public final long size() {
        return this.size;
    }

    @Override // okio.BufferedSource
    public void skip(long j6) throws EOFException {
        while (j6 > 0) {
            Segment segment = this.head;
            if (segment == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j6, segment.limit - segment.pos);
            long j7 = min;
            setSize$okio(size() - j7);
            j6 -= j7;
            int i6 = segment.pos + min;
            segment.pos = i6;
            if (i6 == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @Override // okio.BufferedSink
    public long writeAll(@NotNull Source source) throws IOException {
        g0.p(source, "source");
        long j6 = 0;
        while (true) {
            long read = source.read(this, 8192L);
            if (read == -1) {
                return j6;
            }
            j6 += read;
        }
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeByte(int i6) {
        Segment writableSegment$okio = writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i7 = writableSegment$okio.limit;
        writableSegment$okio.limit = i7 + 1;
        bArr[i7] = (byte) i6;
        setSize$okio(size() + 1);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeDecimalLong(long j6) {
        boolean z5;
        if (j6 == 0) {
            return writeByte(48);
        }
        if (j6 < 0) {
            j6 = -j6;
            if (j6 < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z5 = true;
        } else {
            z5 = false;
        }
        int countDigitsIn = okio.internal.Buffer.countDigitsIn(j6);
        if (z5) {
            countDigitsIn++;
        }
        Segment writableSegment$okio = writableSegment$okio(countDigitsIn);
        byte[] bArr = writableSegment$okio.data;
        int i6 = writableSegment$okio.limit + countDigitsIn;
        while (j6 != 0) {
            long j7 = 10;
            i6--;
            bArr[i6] = okio.internal.Buffer.getHEX_DIGIT_BYTES()[(int) (j6 % j7)];
            j6 /= j7;
        }
        if (z5) {
            bArr[i6 - 1] = 45;
        }
        writableSegment$okio.limit += countDigitsIn;
        setSize$okio(size() + countDigitsIn);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeHexadecimalUnsignedLong(long j6) {
        if (j6 == 0) {
            return writeByte(48);
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
        Segment writableSegment$okio = writableSegment$okio(i6);
        byte[] bArr = writableSegment$okio.data;
        int i7 = writableSegment$okio.limit;
        for (int i8 = (i7 + i6) - 1; i8 >= i7; i8--) {
            bArr[i8] = okio.internal.Buffer.getHEX_DIGIT_BYTES()[(int) (15 & j6)];
            j6 >>>= 4;
        }
        writableSegment$okio.limit += i6;
        setSize$okio(size() + i6);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeInt(int i6) {
        Segment writableSegment$okio = writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i7 = writableSegment$okio.limit;
        bArr[i7] = (byte) ((i6 >>> 24) & 255);
        bArr[i7 + 1] = (byte) ((i6 >>> 16) & 255);
        bArr[i7 + 2] = (byte) ((i6 >>> 8) & 255);
        bArr[i7 + 3] = (byte) (i6 & 255);
        writableSegment$okio.limit = i7 + 4;
        setSize$okio(size() + 4);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeIntLe(int i6) {
        return writeInt(SegmentedByteString.reverseBytes(i6));
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeLong(long j6) {
        Segment writableSegment$okio = writableSegment$okio(8);
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
        setSize$okio(size() + 8);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeLongLe(long j6) {
        return writeLong(SegmentedByteString.reverseBytes(j6));
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeShort(int i6) {
        Segment writableSegment$okio = writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i7 = writableSegment$okio.limit;
        bArr[i7] = (byte) ((i6 >>> 8) & 255);
        bArr[i7 + 1] = (byte) (i6 & 255);
        writableSegment$okio.limit = i7 + 2;
        setSize$okio(size() + 2);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeShortLe(int i6) {
        return writeShort((int) SegmentedByteString.reverseBytes((short) i6));
    }

    @JvmOverloads
    @NotNull
    public final Buffer writeTo(@NotNull OutputStream out, long j6) throws IOException {
        g0.p(out, "out");
        SegmentedByteString.checkOffsetAndCount(this.size, 0L, j6);
        Segment segment = this.head;
        long j7 = j6;
        while (j7 > 0) {
            g0.m(segment);
            int min = (int) Math.min(j7, segment.limit - segment.pos);
            out.write(segment.data, segment.pos, min);
            int i6 = segment.pos + min;
            segment.pos = i6;
            long j8 = min;
            this.size -= j8;
            j7 -= j8;
            if (i6 == segment.limit) {
                Segment pop = segment.pop();
                this.head = pop;
                SegmentPool.recycle(segment);
                segment = pop;
            }
        }
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeUtf8CodePoint(int i6) {
        if (i6 < 128) {
            writeByte(i6);
            return this;
        }
        if (i6 < 2048) {
            Segment writableSegment$okio = writableSegment$okio(2);
            byte[] bArr = writableSegment$okio.data;
            int i7 = writableSegment$okio.limit;
            bArr[i7] = (byte) ((i6 >> 6) | 192);
            bArr[i7 + 1] = (byte) ((i6 & 63) | 128);
            writableSegment$okio.limit = i7 + 2;
            setSize$okio(size() + 2);
            return this;
        }
        if (55296 <= i6 && i6 < 57344) {
            writeByte(63);
            return this;
        }
        if (i6 < 65536) {
            Segment writableSegment$okio2 = writableSegment$okio(3);
            byte[] bArr2 = writableSegment$okio2.data;
            int i8 = writableSegment$okio2.limit;
            bArr2[i8] = (byte) ((i6 >> 12) | 224);
            bArr2[i8 + 1] = (byte) (((i6 >> 6) & 63) | 128);
            bArr2[i8 + 2] = (byte) ((i6 & 63) | 128);
            writableSegment$okio2.limit = i8 + 3;
            setSize$okio(size() + 3);
            return this;
        }
        if (i6 > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x" + SegmentedByteString.toHexString(i6));
        }
        Segment writableSegment$okio3 = writableSegment$okio(4);
        byte[] bArr3 = writableSegment$okio3.data;
        int i9 = writableSegment$okio3.limit;
        bArr3[i9] = (byte) ((i6 >> 18) | 240);
        bArr3[i9 + 1] = (byte) (((i6 >> 12) & 63) | 128);
        bArr3[i9 + 2] = (byte) (((i6 >> 6) & 63) | 128);
        bArr3[i9 + 3] = (byte) ((i6 & 63) | 128);
        writableSegment$okio3.limit = i9 + 4;
        setSize$okio(size() + 4);
        return this;
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j6, long j7, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            j6 = 0;
        }
        return buffer.copyTo(buffer2, j6, j7);
    }

    private final ByteString digest(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        Segment segment = this.head;
        if (segment != null) {
            byte[] bArr = segment.data;
            int i6 = segment.pos;
            messageDigest.update(bArr, i6, segment.limit - i6);
            Segment segment2 = segment.next;
            g0.m(segment2);
            while (segment2 != segment) {
                byte[] bArr2 = segment2.data;
                int i7 = segment2.pos;
                messageDigest.update(bArr2, i7, segment2.limit - i7);
                segment2 = segment2.next;
                g0.m(segment2);
            }
        }
        byte[] digest = messageDigest.digest();
        g0.o(digest, "digest(...)");
        return new ByteString(digest);
    }

    private final ByteString hmac(String str, ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.internalArray$okio(), str));
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i6 = segment.pos;
                mac.update(bArr, i6, segment.limit - i6);
                Segment segment2 = segment.next;
                g0.m(segment2);
                while (segment2 != segment) {
                    byte[] bArr2 = segment2.data;
                    int i7 = segment2.pos;
                    mac.update(bArr2, i7, segment2.limit - i7);
                    segment2 = segment2.next;
                    g0.m(segment2);
                }
            }
            byte[] doFinal = mac.doFinal();
            g0.o(doFinal, "doFinal(...)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e6) {
            throw new IllegalArgumentException(e6);
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    @JvmName(name = "-deprecated_getByte")
    /* renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m296deprecated_getByte(long j6) {
        return getByte(j6);
    }

    public final void clear() {
        skip(size());
    }

    public final long completeSegmentByteCount() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = this.head;
        g0.m(segment);
        Segment segment2 = segment.prev;
        g0.m(segment2);
        if (segment2.limit < 8192 && segment2.owner) {
            return size - (r3 - segment2.pos);
        }
        return size;
    }

    @JvmOverloads
    @NotNull
    public final Buffer copyTo(@NotNull OutputStream out, long j6, long j7) throws IOException {
        g0.p(out, "out");
        long j8 = j6;
        SegmentedByteString.checkOffsetAndCount(this.size, j8, j7);
        if (j7 != 0) {
            Segment segment = this.head;
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
                int min = (int) Math.min(segment2.limit - r2, j9);
                out.write(segment2.data, (int) (segment2.pos + j8), min);
                j9 -= min;
                segment2 = segment2.next;
                j8 = 0;
            }
        }
        return this;
    }

    @JvmName(name = "getByte")
    public final byte getByte(long j6) {
        SegmentedByteString.checkOffsetAndCount(size(), j6, 1L);
        Segment segment = this.head;
        if (segment != null) {
            if (size() - j6 < j6) {
                long size = size();
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
                if (j8 <= j6) {
                    segment = segment.next;
                    g0.m(segment);
                    j7 = j8;
                } else {
                    g0.m(segment);
                    return segment.data[(int) ((segment.pos + j6) - j7)];
                }
            }
        } else {
            g0.m(null);
            throw null;
        }
    }

    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString bytes) throws IOException {
        g0.p(bytes, "bytes");
        return indexOf(bytes, 0L);
    }

    @Override // okio.BufferedSource
    public byte readByte() throws EOFException {
        if (size() != 0) {
            Segment segment = this.head;
            g0.m(segment);
            int i6 = segment.pos;
            int i7 = segment.limit;
            int i8 = i6 + 1;
            byte b6 = segment.data[i6];
            setSize$okio(size() - 1);
            if (i8 == i7) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
                return b6;
            }
            segment.pos = i8;
            return b6;
        }
        throw new EOFException();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a7 A[EDGE_INSN: B:40:0x00a7->B:37:0x00a7 BREAK  A[LOOP:0: B:4:0x000d->B:39:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009f  */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readHexadecimalUnsignedLong() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.size()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lb1
            r0 = 0
            r4 = r2
            r1 = 0
        Ld:
            okio.Segment r6 = r15.head
            kotlin.jvm.internal.g0.m(r6)
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L18:
            if (r8 >= r9) goto L93
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L27
            r11 = 57
            if (r10 > r11) goto L27
            int r11 = r10 + (-48)
            goto L3c
        L27:
            r11 = 97
            if (r10 < r11) goto L32
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L32
            int r11 = r10 + (-87)
            goto L3c
        L32:
            r11 = 65
            if (r10 < r11) goto L74
            r11 = 70
            if (r10 > r11) goto L74
            int r11 = r10 + (-55)
        L3c:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4c
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L18
        L4c:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeHexadecimalUnsignedLong(r4)
            okio.Buffer r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L74:
            if (r0 == 0) goto L78
            r1 = 1
            goto L93
        L78:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = okio.SegmentedByteString.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L93:
            if (r8 != r9) goto L9f
            okio.Segment r7 = r6.pop()
            r15.head = r7
            okio.SegmentPool.recycle(r6)
            goto La1
        L9f:
            r6.pos = r8
        La1:
            if (r1 != 0) goto La7
            okio.Segment r6 = r15.head
            if (r6 != 0) goto Ld
        La7:
            long r1 = r15.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.setSize$okio(r1)
            return r4
        Lb1:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    @Override // okio.BufferedSource
    public int readInt() throws EOFException {
        if (size() >= 4) {
            Segment segment = this.head;
            g0.m(segment);
            int i6 = segment.pos;
            int i7 = segment.limit;
            if (i7 - i6 < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = segment.data;
            int i8 = i6 + 3;
            int i9 = ((bArr[i6 + 1] & 255) << 16) | ((bArr[i6] & 255) << 24) | ((bArr[i6 + 2] & 255) << 8);
            int i10 = i6 + 4;
            int i11 = (bArr[i8] & 255) | i9;
            setSize$okio(size() - 4);
            if (i10 == i7) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
                return i11;
            }
            segment.pos = i10;
            return i11;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws EOFException {
        return SegmentedByteString.reverseBytes(readInt());
    }

    @Override // okio.BufferedSource
    public long readLong() throws EOFException {
        if (size() >= 8) {
            Segment segment = this.head;
            g0.m(segment);
            int i6 = segment.pos;
            int i7 = segment.limit;
            if (i7 - i6 < 8) {
                return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
            }
            byte[] bArr = segment.data;
            int i8 = i6 + 7;
            long j6 = ((bArr[i6 + 3] & 255) << 32) | ((bArr[i6] & 255) << 56) | ((bArr[i6 + 1] & 255) << 48) | ((bArr[i6 + 2] & 255) << 40) | ((bArr[i6 + 4] & 255) << 24) | ((bArr[i6 + 5] & 255) << 16) | ((bArr[i6 + 6] & 255) << 8);
            int i9 = i6 + 8;
            long j7 = j6 | (bArr[i8] & 255);
            setSize$okio(size() - 8);
            if (i9 == i7) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
                return j7;
            }
            segment.pos = i9;
            return j7;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public long readLongLe() throws EOFException {
        return SegmentedByteString.reverseBytes(readLong());
    }

    @Override // okio.BufferedSource
    public short readShort() throws EOFException {
        if (size() >= 2) {
            Segment segment = this.head;
            g0.m(segment);
            int i6 = segment.pos;
            int i7 = segment.limit;
            if (i7 - i6 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = segment.data;
            int i8 = i6 + 1;
            int i9 = (bArr[i6] & 255) << 8;
            int i10 = i6 + 2;
            int i11 = (bArr[i8] & 255) | i9;
            setSize$okio(size() - 2);
            if (i10 == i7) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i10;
            }
            return (short) i11;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws EOFException {
        return SegmentedByteString.reverseBytes(readShort());
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i6;
        int i7;
        int i8;
        if (size() != 0) {
            byte b6 = getByte(0L);
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
            } else if ((b6 & 248) == 240) {
                i6 = b6 & 7;
                i7 = 4;
                i8 = 65536;
            } else {
                skip(1L);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            long j6 = i7;
            if (size() >= j6) {
                for (int i9 = 1; i9 < i7; i9++) {
                    long j7 = i9;
                    byte b7 = getByte(j7);
                    if ((b7 & 192) == 128) {
                        i6 = (i6 << 6) | (b7 & Utf8.REPLACEMENT_BYTE);
                    } else {
                        skip(j7);
                        return Utf8.REPLACEMENT_CODE_POINT;
                    }
                }
                skip(j6);
                if (i6 > 1114111) {
                    return Utf8.REPLACEMENT_CODE_POINT;
                }
                if ((55296 <= i6 && i6 < 57344) || i6 < i8) {
                    return Utf8.REPLACEMENT_CODE_POINT;
                }
                return i6;
            }
            throw new EOFException("size < " + i7 + ": " + size() + " (to read code point prefixed 0x" + SegmentedByteString.toHexString(b6) + ')');
        }
        throw new EOFException();
    }

    @NotNull
    public String toString() {
        return snapshot().toString();
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeString(@NotNull String string, @NotNull Charset charset) {
        g0.p(string, "string");
        g0.p(charset, "charset");
        return writeString(string, 0, string.length(), charset);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeUtf8(@NotNull String string) {
        g0.p(string, "string");
        return writeUtf8(string, 0, string.length());
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j6, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            j6 = 0;
        }
        return buffer.copyTo(buffer2, j6);
    }

    private final void readFrom(InputStream inputStream, long j6, boolean z5) throws IOException {
        while (true) {
            if (j6 <= 0 && !z5) {
                return;
            }
            Segment writableSegment$okio = writableSegment$okio(1);
            int read = inputStream.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j6, 8192 - writableSegment$okio.limit));
            if (read == -1) {
                if (writableSegment$okio.pos == writableSegment$okio.limit) {
                    this.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                }
                if (!z5) {
                    throw new EOFException();
                }
                return;
            }
            writableSegment$okio.limit += read;
            long j7 = read;
            this.size += j7;
            j6 -= j7;
        }
    }

    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString bytes, long j6) throws IOException {
        g0.p(bytes, "bytes");
        return indexOf(bytes, j6, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    @Nullable
    public <T> T select(@NotNull TypedOptions<T> options) {
        g0.p(options, "options");
        int select = select(options.getOptions$okio());
        if (select == -1) {
            return null;
        }
        return options.get(select);
    }

    @NotNull
    public final ByteString snapshot(int i6) {
        if (i6 == 0) {
            return ByteString.EMPTY;
        }
        SegmentedByteString.checkOffsetAndCount(size(), 0L, i6);
        Segment segment = this.head;
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
        Segment segment2 = this.head;
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

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeUtf8(@NotNull String string, int i6, int i7) {
        char charAt;
        g0.p(string, "string");
        if (i6 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i6).toString());
        }
        if (i7 >= i6) {
            if (i7 > string.length()) {
                throw new IllegalArgumentException(("endIndex > string.length: " + i7 + " > " + string.length()).toString());
            }
            while (i6 < i7) {
                char charAt2 = string.charAt(i6);
                if (charAt2 < 128) {
                    Segment writableSegment$okio = writableSegment$okio(1);
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
                    setSize$okio(size() + i11);
                } else {
                    if (charAt2 < 2048) {
                        Segment writableSegment$okio2 = writableSegment$okio(2);
                        byte[] bArr2 = writableSegment$okio2.data;
                        int i12 = writableSegment$okio2.limit;
                        bArr2[i12] = (byte) ((charAt2 >> 6) | 192);
                        bArr2[i12 + 1] = (byte) ((charAt2 & '?') | 128);
                        writableSegment$okio2.limit = i12 + 2;
                        setSize$okio(size() + 2);
                    } else if (charAt2 >= 55296 && charAt2 <= 57343) {
                        int i13 = i6 + 1;
                        char charAt3 = i13 < i7 ? string.charAt(i13) : (char) 0;
                        if (charAt2 <= 56319 && 56320 <= charAt3 && charAt3 < 57344) {
                            int i14 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + 65536;
                            Segment writableSegment$okio3 = writableSegment$okio(4);
                            byte[] bArr3 = writableSegment$okio3.data;
                            int i15 = writableSegment$okio3.limit;
                            bArr3[i15] = (byte) ((i14 >> 18) | 240);
                            bArr3[i15 + 1] = (byte) (((i14 >> 12) & 63) | 128);
                            bArr3[i15 + 2] = (byte) (((i14 >> 6) & 63) | 128);
                            bArr3[i15 + 3] = (byte) ((i14 & 63) | 128);
                            writableSegment$okio3.limit = i15 + 4;
                            setSize$okio(size() + 4);
                            i6 += 2;
                        } else {
                            writeByte(63);
                            i6 = i13;
                        }
                    } else {
                        Segment writableSegment$okio4 = writableSegment$okio(3);
                        byte[] bArr4 = writableSegment$okio4.data;
                        int i16 = writableSegment$okio4.limit;
                        bArr4[i16] = (byte) ((charAt2 >> '\f') | 224);
                        bArr4[i16 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                        bArr4[i16 + 2] = (byte) ((charAt2 & '?') | 128);
                        writableSegment$okio4.limit = i16 + 3;
                        setSize$okio(size() + 3);
                    }
                    i6++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i7 + " < " + i6).toString());
    }

    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString bytes, long j6, long j7) throws IOException {
        g0.p(bytes, "bytes");
        return okio.internal.Buffer.commonIndexOf$default(this, bytes, j6, j7, 0, 0, 24, null);
    }

    @Override // okio.BufferedSource
    public void readFully(@NotNull byte[] sink) throws EOFException {
        g0.p(sink, "sink");
        int i6 = 0;
        while (i6 < sink.length) {
            int read = read(sink, i6, sink.length - i6);
            if (read == -1) {
                throw new EOFException();
            }
            i6 += read;
        }
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeString(@NotNull String string, int i6, int i7, @NotNull Charset charset) {
        g0.p(string, "string");
        g0.p(charset, "charset");
        if (i6 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i6).toString());
        }
        if (i7 >= i6) {
            if (i7 <= string.length()) {
                if (g0.g(charset, kotlin.text.e.f47851b)) {
                    return writeUtf8(string, i6, i7);
                }
                String substring = string.substring(i6, i7);
                g0.o(substring, "substring(...)");
                byte[] bytes = substring.getBytes(charset);
                g0.o(bytes, "getBytes(...)");
                return write(bytes, 0, bytes.length);
            }
            throw new IllegalArgumentException(("endIndex > string.length: " + i7 + " > " + string.length()).toString());
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i7 + " < " + i6).toString());
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b6, long j6, long j7) {
        Segment segment;
        int i6;
        long j8 = 0;
        if (0 > j6 || j6 > j7) {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j6 + " toIndex=" + j7).toString());
        }
        if (j7 > size()) {
            j7 = size();
        }
        if (j6 == j7 || (segment = this.head) == null) {
            return -1L;
        }
        if (size() - j6 < j6) {
            j8 = size();
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

    @Override // java.nio.channels.WritableByteChannel
    public int write(@NotNull ByteBuffer source) throws IOException {
        g0.p(source, "source");
        int remaining = source.remaining();
        int i6 = remaining;
        while (i6 > 0) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i6, 8192 - writableSegment$okio.limit);
            source.get(writableSegment$okio.data, writableSegment$okio.limit, min);
            i6 -= min;
            writableSegment$okio.limit += min;
        }
        this.size += remaining;
        return remaining;
    }

    @Override // okio.BufferedSource
    public int read(@NotNull byte[] sink) {
        g0.p(sink, "sink");
        return read(sink, 0, sink.length);
    }

    @Override // okio.BufferedSource
    public int read(@NotNull byte[] sink, int i6, int i7) {
        g0.p(sink, "sink");
        SegmentedByteString.checkOffsetAndCount(sink.length, i6, i7);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i7, segment.limit - segment.pos);
        byte[] bArr = segment.data;
        int i8 = segment.pos;
        n.v0(bArr, sink, i6, i8, i8 + min);
        segment.pos += min;
        setSize$okio(size() - min);
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @NotNull
    public final Buffer copyTo(@NotNull Buffer out, long j6) {
        g0.p(out, "out");
        return copyTo(out, j6, this.size - j6);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull ByteString byteString) {
        g0.p(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    @NotNull
    public final Buffer copyTo(@NotNull Buffer out, long j6, long j7) {
        g0.p(out, "out");
        long j8 = j6;
        SegmentedByteString.checkOffsetAndCount(size(), j8, j7);
        if (j7 != 0) {
            out.setSize$okio(out.size() + j7);
            Segment segment = this.head;
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
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull ByteString byteString, int i6, int i7) {
        g0.p(byteString, "byteString");
        byteString.write$okio(this, i6, i7);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull byte[] source) {
        g0.p(source, "source");
        return write(source, 0, source.length);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull byte[] source, int i6, int i7) {
        g0.p(source, "source");
        long j6 = i7;
        SegmentedByteString.checkOffsetAndCount(source.length, i6, j6);
        int i8 = i7 + i6;
        while (i6 < i8) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i8 - i6, 8192 - writableSegment$okio.limit);
            int i9 = i6 + min;
            n.v0(source, writableSegment$okio.data, writableSegment$okio.limit, i6, i9);
            writableSegment$okio.limit += min;
            i6 = i9;
        }
        setSize$okio(size() + j6);
        return this;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @NotNull
    public Buffer buffer() {
        return this;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @NotNull
    public Buffer getBuffer() {
        return this;
    }

    @Override // okio.Source
    public long read(@NotNull Buffer sink, long j6) {
        g0.p(sink, "sink");
        if (j6 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        }
        if (size() == 0) {
            return -1L;
        }
        if (j6 > size()) {
            j6 = size();
        }
        sink.write(this, j6);
        return j6;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull Source source, long j6) throws IOException {
        g0.p(source, "source");
        while (j6 > 0) {
            long read = source.read(this, j6);
            if (read == -1) {
                throw new EOFException();
            }
            j6 -= read;
        }
        return this;
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer source, long j6) {
        Segment segment;
        g0.p(source, "source");
        if (source != this) {
            SegmentedByteString.checkOffsetAndCount(source.size(), 0L, j6);
            while (j6 > 0) {
                Segment segment2 = source.head;
                g0.m(segment2);
                int i6 = segment2.limit;
                g0.m(source.head);
                if (j6 < i6 - r1.pos) {
                    Segment segment3 = this.head;
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
                            setSize$okio(size() + j6);
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
                Segment segment7 = this.head;
                if (segment7 == null) {
                    this.head = segment6;
                    segment6.prev = segment6;
                    segment6.next = segment6;
                } else {
                    g0.m(segment7);
                    Segment segment8 = segment7.prev;
                    g0.m(segment8);
                    segment8.push(segment6).compact();
                }
                source.setSize$okio(source.size() - j7);
                setSize$okio(size() + j7);
                j6 -= j7;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }
}
