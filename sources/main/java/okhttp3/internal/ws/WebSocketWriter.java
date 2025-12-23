package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import okhttp3.internal._UtilCommonKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nWebSocketWriter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebSocketWriter.kt\nokhttp3/internal/ws/WebSocketWriter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,215:1\n1#2:216\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class WebSocketWriter implements Closeable {
    private final boolean isClient;

    @Nullable
    private final Buffer.UnsafeCursor maskCursor;

    @Nullable
    private final byte[] maskKey;

    @NotNull
    private final Buffer messageBuffer;

    @Nullable
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;

    @NotNull
    private final Random random;

    @NotNull
    private final BufferedSink sink;

    @NotNull
    private final Buffer sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean z5, @NotNull BufferedSink sink, @NotNull Random random, boolean z6, boolean z7, long j6) {
        g0.p(sink, "sink");
        g0.p(random, "random");
        this.isClient = z5;
        this.sink = sink;
        this.random = random;
        this.perMessageDeflate = z6;
        this.noContextTakeover = z7;
        this.minimumDeflateSize = j6;
        this.messageBuffer = new Buffer();
        this.sinkBuffer = sink.getBuffer();
        this.maskKey = z5 ? new byte[4] : null;
        this.maskCursor = z5 ? new Buffer.UnsafeCursor() : null;
    }

    private final void writeControlFrame(int i6, ByteString byteString) throws IOException {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int size = byteString.size();
        if (size > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.sinkBuffer.writeByte(i6 | 128);
        if (this.isClient) {
            this.sinkBuffer.writeByte(size | 128);
            Random random = this.random;
            byte[] bArr = this.maskKey;
            g0.m(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.write(this.maskKey);
            if (size > 0) {
                long size2 = this.sinkBuffer.size();
                this.sinkBuffer.write(byteString);
                Buffer buffer = this.sinkBuffer;
                Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                g0.m(unsafeCursor);
                buffer.readAndWriteUnsafe(unsafeCursor);
                this.maskCursor.seek(size2);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.writeByte(size);
            this.sinkBuffer.write(byteString);
        }
        this.sink.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MessageDeflater messageDeflater = this.messageDeflater;
        if (messageDeflater != null) {
            _UtilCommonKt.closeQuietly(messageDeflater);
        }
        _UtilCommonKt.closeQuietly(this.sink);
    }

    @NotNull
    public final Random getRandom() {
        return this.random;
    }

    @NotNull
    public final BufferedSink getSink() {
        return this.sink;
    }

    public final void writeClose(int i6, @Nullable ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.EMPTY;
        if (i6 != 0 || byteString != null) {
            if (i6 != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(i6);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i6);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        try {
            writeControlFrame(8, byteString2);
        } finally {
            this.writerClosed = true;
        }
    }

    public final void writeMessageFrame(int i6, @NotNull ByteString data) throws IOException {
        g0.p(data, "data");
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        this.messageBuffer.write(data);
        int i7 = i6 | 128;
        if (this.perMessageDeflate && data.size() >= this.minimumDeflateSize) {
            MessageDeflater messageDeflater = this.messageDeflater;
            if (messageDeflater == null) {
                messageDeflater = new MessageDeflater(this.noContextTakeover);
                this.messageDeflater = messageDeflater;
            }
            messageDeflater.deflate(this.messageBuffer);
            i7 = i6 | 192;
        }
        long size = this.messageBuffer.size();
        this.sinkBuffer.writeByte(i7);
        int i8 = this.isClient ? 128 : 0;
        if (size <= 125) {
            this.sinkBuffer.writeByte(i8 | ((int) size));
        } else if (size <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            this.sinkBuffer.writeByte(i8 | 126);
            this.sinkBuffer.writeShort((int) size);
        } else {
            this.sinkBuffer.writeByte(i8 | 127);
            this.sinkBuffer.writeLong(size);
        }
        if (this.isClient) {
            Random random = this.random;
            byte[] bArr = this.maskKey;
            g0.m(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.write(this.maskKey);
            if (size > 0) {
                Buffer buffer = this.messageBuffer;
                Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                g0.m(unsafeCursor);
                buffer.readAndWriteUnsafe(unsafeCursor);
                this.maskCursor.seek(0L);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        this.sinkBuffer.write(this.messageBuffer, size);
        this.sink.flush();
    }

    public final void writePing(@NotNull ByteString payload) throws IOException {
        g0.p(payload, "payload");
        writeControlFrame(9, payload);
    }

    public final void writePong(@NotNull ByteString payload) throws IOException {
        g0.p(payload, "payload");
        writeControlFrame(10, payload);
    }
}
