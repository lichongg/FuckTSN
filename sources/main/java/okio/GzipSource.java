package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.j1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nGzipSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GzipSource.kt\nokio/GzipSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 RealBufferedSource.kt\nokio/RealBufferedSource\n+ 4 GzipSource.kt\nokio/-GzipSourceExtensions\n+ 5 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,222:1\n1#2:223\n63#3:224\n63#3:226\n63#3:228\n63#3:229\n63#3:230\n63#3:232\n63#3:234\n204#4:225\n204#4:227\n204#4:231\n204#4:233\n88#5:235\n*S KotlinDebug\n*F\n+ 1 GzipSource.kt\nokio/GzipSource\n*L\n103#1:224\n105#1:226\n117#1:228\n118#1:229\n120#1:230\n131#1:232\n142#1:234\n104#1:225\n115#1:227\n128#1:231\n139#1:233\n185#1:235\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class GzipSource implements Source {

    @NotNull
    private final CRC32 crc;

    @NotNull
    private final Inflater inflater;

    @NotNull
    private final InflaterSource inflaterSource;
    private byte section;

    @NotNull
    private final RealBufferedSource source;

    public GzipSource(@NotNull Source source) {
        g0.p(source, "source");
        RealBufferedSource realBufferedSource = new RealBufferedSource(source);
        this.source = realBufferedSource;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new InflaterSource((BufferedSource) realBufferedSource, inflater);
        this.crc = new CRC32();
    }

    private final void checkEqual(String str, int i6, int i7) {
        if (i7 == i6) {
            return;
        }
        throw new IOException(str + ": actual 0x" + u.k4(SegmentedByteString.toHexString(i7), 8, '0') + " != expected 0x" + u.k4(SegmentedByteString.toHexString(i6), 8, '0'));
    }

    private final void consumeHeader() throws IOException {
        this.source.require(10L);
        byte b6 = this.source.bufferField.getByte(3L);
        boolean z5 = ((b6 >> 1) & 1) == 1;
        if (z5) {
            updateCrc(this.source.bufferField, 0L, 10L);
        }
        checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8L);
        if (((b6 >> 2) & 1) == 1) {
            this.source.require(2L);
            if (z5) {
                updateCrc(this.source.bufferField, 0L, 2L);
            }
            long readShortLe = this.source.bufferField.readShortLe() & j1.f43986d;
            this.source.require(readShortLe);
            if (z5) {
                updateCrc(this.source.bufferField, 0L, readShortLe);
            }
            this.source.skip(readShortLe);
        }
        if (((b6 >> 3) & 1) == 1) {
            long indexOf = this.source.indexOf((byte) 0);
            if (indexOf == -1) {
                throw new EOFException();
            }
            if (z5) {
                updateCrc(this.source.bufferField, 0L, indexOf + 1);
            }
            this.source.skip(indexOf + 1);
        }
        if (((b6 >> 4) & 1) == 1) {
            long indexOf2 = this.source.indexOf((byte) 0);
            if (indexOf2 == -1) {
                throw new EOFException();
            }
            if (z5) {
                updateCrc(this.source.bufferField, 0L, indexOf2 + 1);
            }
            this.source.skip(indexOf2 + 1);
        }
        if (z5) {
            checkEqual("FHCRC", this.source.readShortLe(), (short) this.crc.getValue());
            this.crc.reset();
        }
    }

    private final void consumeTrailer() throws IOException {
        checkEqual("CRC", this.source.readIntLe(), (int) this.crc.getValue());
        checkEqual("ISIZE", this.source.readIntLe(), (int) this.inflater.getBytesWritten());
    }

    private final void updateCrc(Buffer buffer, long j6, long j7) {
        Segment segment = buffer.head;
        g0.m(segment);
        while (true) {
            int i6 = segment.limit;
            int i7 = segment.pos;
            if (j6 < i6 - i7) {
                break;
            }
            j6 -= i6 - i7;
            segment = segment.next;
            g0.m(segment);
        }
        while (j7 > 0) {
            int min = (int) Math.min(segment.limit - r7, j7);
            this.crc.update(segment.data, (int) (segment.pos + j6), min);
            j7 -= min;
            segment = segment.next;
            g0.m(segment);
            j6 = 0;
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inflaterSource.close();
    }

    @Override // okio.Source
    public long read(@NotNull Buffer sink, long j6) throws IOException {
        GzipSource gzipSource;
        g0.p(sink, "sink");
        if (j6 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        }
        if (j6 == 0) {
            return 0L;
        }
        if (this.section == 0) {
            consumeHeader();
            this.section = (byte) 1;
        }
        if (this.section == 1) {
            long size = sink.size();
            long read = this.inflaterSource.read(sink, j6);
            if (read != -1) {
                updateCrc(sink, size, read);
                return read;
            }
            gzipSource = this;
            gzipSource.section = (byte) 2;
        } else {
            gzipSource = this;
        }
        if (gzipSource.section == 2) {
            consumeTrailer();
            gzipSource.section = (byte) 3;
            if (!gzipSource.source.exhausted()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }
}
