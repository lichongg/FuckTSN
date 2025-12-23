package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCipherSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CipherSource.kt\nokio/CipherSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,120:1\n1#2:121\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class CipherSource implements Source {
    private final int blockSize;

    @NotNull
    private final Buffer buffer;

    @NotNull
    private final Cipher cipher;
    private boolean closed;

    /* renamed from: final, reason: not valid java name */
    private boolean f4final;

    @NotNull
    private final BufferedSource source;

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        this.source.close();
    }

    public CipherSource(@NotNull BufferedSource source, @NotNull Cipher cipher) {
        g0.p(source, "source");
        g0.p(cipher, "cipher");
        this.source = source;
        this.cipher = cipher;
        int blockSize = cipher.getBlockSize();
        this.blockSize = blockSize;
        this.buffer = new Buffer();
        if (blockSize > 0) {
            return;
        }
        throw new IllegalArgumentException(("Block cipher required " + cipher).toString());
    }

    private final void doFinal() {
        int outputSize = this.cipher.getOutputSize(0);
        if (outputSize == 0) {
            return;
        }
        Segment writableSegment$okio = this.buffer.writableSegment$okio(outputSize);
        int doFinal = this.cipher.doFinal(writableSegment$okio.data, writableSegment$okio.pos);
        writableSegment$okio.limit += doFinal;
        Buffer buffer = this.buffer;
        buffer.setSize$okio(buffer.size() + doFinal);
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            this.buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
    }

    private final void refill() {
        while (this.buffer.size() == 0 && !this.f4final) {
            if (this.source.exhausted()) {
                this.f4final = true;
                doFinal();
                return;
            }
            update();
        }
    }

    private final void update() {
        Segment segment = this.source.getBuffer().head;
        g0.m(segment);
        int i6 = segment.limit - segment.pos;
        int outputSize = this.cipher.getOutputSize(i6);
        int i7 = i6;
        while (outputSize > 8192) {
            int i8 = this.blockSize;
            if (i7 <= i8) {
                this.f4final = true;
                Buffer buffer = this.buffer;
                byte[] doFinal = this.cipher.doFinal(this.source.readByteArray());
                g0.o(doFinal, "doFinal(...)");
                buffer.write(doFinal);
                return;
            }
            i7 -= i8;
            outputSize = this.cipher.getOutputSize(i7);
        }
        Segment writableSegment$okio = this.buffer.writableSegment$okio(outputSize);
        int update = this.cipher.update(segment.data, segment.pos, i7, writableSegment$okio.data, writableSegment$okio.pos);
        this.source.skip(i7);
        writableSegment$okio.limit += update;
        Buffer buffer2 = this.buffer;
        buffer2.setSize$okio(buffer2.size() + update);
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            this.buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
    }

    @NotNull
    public final Cipher getCipher() {
        return this.cipher;
    }

    @Override // okio.Source
    public long read(@NotNull Buffer sink, long j6) throws IOException {
        g0.p(sink, "sink");
        if (j6 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (j6 == 0) {
            return 0L;
        }
        refill();
        return this.buffer.read(sink, j6);
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }
}
