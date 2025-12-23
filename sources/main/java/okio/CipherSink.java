package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCipherSink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CipherSink.kt\nokio/CipherSink\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,148:1\n1#2:149\n85#3:150\n*S KotlinDebug\n*F\n+ 1 CipherSink.kt\nokio/CipherSink\n*L\n47#1:150\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class CipherSink implements Sink {
    private final int blockSize;

    @NotNull
    private final Cipher cipher;
    private boolean closed;

    @NotNull
    private final BufferedSink sink;

    public CipherSink(@NotNull BufferedSink sink, @NotNull Cipher cipher) {
        g0.p(sink, "sink");
        g0.p(cipher, "cipher");
        this.sink = sink;
        this.cipher = cipher;
        int blockSize = cipher.getBlockSize();
        this.blockSize = blockSize;
        if (blockSize > 0) {
            return;
        }
        throw new IllegalArgumentException(("Block cipher required " + cipher).toString());
    }

    private final Throwable doFinal() {
        int outputSize = this.cipher.getOutputSize(0);
        Throwable th = null;
        if (outputSize == 0) {
            return null;
        }
        if (outputSize > 8192) {
            try {
                BufferedSink bufferedSink = this.sink;
                byte[] doFinal = this.cipher.doFinal();
                g0.o(doFinal, "doFinal(...)");
                bufferedSink.write(doFinal);
                return null;
            } catch (Throwable th2) {
                return th2;
            }
        }
        Buffer buffer = this.sink.getBuffer();
        Segment writableSegment$okio = buffer.writableSegment$okio(outputSize);
        try {
            int doFinal2 = this.cipher.doFinal(writableSegment$okio.data, writableSegment$okio.limit);
            writableSegment$okio.limit += doFinal2;
            buffer.setSize$okio(buffer.size() + doFinal2);
        } catch (Throwable th3) {
            th = th3;
        }
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
        return th;
    }

    private final int update(Buffer buffer, long j6) {
        Segment segment = buffer.head;
        g0.m(segment);
        int min = (int) Math.min(j6, segment.limit - segment.pos);
        Buffer buffer2 = this.sink.getBuffer();
        int outputSize = this.cipher.getOutputSize(min);
        int i6 = min;
        while (outputSize > 8192) {
            int i7 = this.blockSize;
            if (i6 <= i7) {
                BufferedSink bufferedSink = this.sink;
                byte[] update = this.cipher.update(buffer.readByteArray(j6));
                g0.o(update, "update(...)");
                bufferedSink.write(update);
                return (int) j6;
            }
            i6 -= i7;
            outputSize = this.cipher.getOutputSize(i6);
        }
        Segment writableSegment$okio = buffer2.writableSegment$okio(outputSize);
        int update2 = this.cipher.update(segment.data, segment.pos, i6, writableSegment$okio.data, writableSegment$okio.limit);
        writableSegment$okio.limit += update2;
        buffer2.setSize$okio(buffer2.size() + update2);
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            buffer2.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
        this.sink.emitCompleteSegments();
        buffer.setSize$okio(buffer.size() - i6);
        int i8 = segment.pos + i6;
        segment.pos = i8;
        if (i8 == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return i6;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        Throwable doFinal = doFinal();
        try {
            this.sink.close();
        } catch (Throwable th) {
            if (doFinal == null) {
                doFinal = th;
            }
        }
        if (doFinal != null) {
            throw doFinal;
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.sink.flush();
    }

    @NotNull
    public final Cipher getCipher() {
        return this.cipher;
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer source, long j6) throws IOException {
        g0.p(source, "source");
        SegmentedByteString.checkOffsetAndCount(source.size(), 0L, j6);
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        long j7 = j6;
        while (j7 > 0) {
            j7 -= update(source, j7);
        }
    }
}
