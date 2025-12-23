package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nWebSocketReader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebSocketReader.kt\nokhttp3/internal/ws/WebSocketReader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n1#2:311\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class WebSocketReader implements Closeable {
    private boolean closed;

    @NotNull
    private final Buffer controlFrameBuffer;

    @NotNull
    private final FrameCallback frameCallback;
    private long frameLength;
    private final boolean isClient;
    private boolean isControlFrame;
    private boolean isFinalFrame;

    @Nullable
    private final Buffer.UnsafeCursor maskCursor;

    @Nullable
    private final byte[] maskKey;

    @NotNull
    private final Buffer messageFrameBuffer;

    @Nullable
    private MessageInflater messageInflater;
    private final boolean noContextTakeover;
    private int opcode;
    private final boolean perMessageDeflate;
    private boolean readingCompressedMessage;

    @NotNull
    private final BufferedSource source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface FrameCallback {
        void onReadClose(int i6, @NotNull String str);

        void onReadMessage(@NotNull String str) throws IOException;

        void onReadMessage(@NotNull ByteString byteString) throws IOException;

        void onReadPing(@NotNull ByteString byteString);

        void onReadPong(@NotNull ByteString byteString);
    }

    public WebSocketReader(boolean z5, @NotNull BufferedSource source, @NotNull FrameCallback frameCallback, boolean z6, boolean z7) {
        g0.p(source, "source");
        g0.p(frameCallback, "frameCallback");
        this.isClient = z5;
        this.source = source;
        this.frameCallback = frameCallback;
        this.perMessageDeflate = z6;
        this.noContextTakeover = z7;
        this.controlFrameBuffer = new Buffer();
        this.messageFrameBuffer = new Buffer();
        this.maskKey = z5 ? null : new byte[4];
        this.maskCursor = z5 ? null : new Buffer.UnsafeCursor();
    }

    private final void readControlFrame() throws IOException {
        short s5;
        String str;
        long j6 = this.frameLength;
        if (j6 > 0) {
            this.source.readFully(this.controlFrameBuffer, j6);
            if (!this.isClient) {
                Buffer buffer = this.controlFrameBuffer;
                Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                g0.m(unsafeCursor);
                buffer.readAndWriteUnsafe(unsafeCursor);
                this.maskCursor.seek(0L);
                WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                Buffer.UnsafeCursor unsafeCursor2 = this.maskCursor;
                byte[] bArr = this.maskKey;
                g0.m(bArr);
                webSocketProtocol.toggleMask(unsafeCursor2, bArr);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                long size = this.controlFrameBuffer.size();
                if (size == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (size != 0) {
                    s5 = this.controlFrameBuffer.readShort();
                    str = this.controlFrameBuffer.readUtf8();
                    String closeCodeExceptionMessage = WebSocketProtocol.INSTANCE.closeCodeExceptionMessage(s5);
                    if (closeCodeExceptionMessage != null) {
                        throw new ProtocolException(closeCodeExceptionMessage);
                    }
                } else {
                    s5 = 1005;
                    str = "";
                }
                this.frameCallback.onReadClose(s5, str);
                this.closed = true;
                return;
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.readByteString());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.readByteString());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + _UtilJvmKt.toHexString(this.opcode));
        }
    }

    private final void readHeader() throws IOException, ProtocolException {
        boolean z5;
        if (this.closed) {
            throw new IOException("closed");
        }
        long timeoutNanos = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        try {
            int and = _UtilCommonKt.and(this.source.readByte(), 255);
            this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            int i6 = and & 15;
            this.opcode = i6;
            boolean z6 = (and & 128) != 0;
            this.isFinalFrame = z6;
            boolean z7 = (and & 8) != 0;
            this.isControlFrame = z7;
            if (z7 && !z6) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z8 = (and & 64) != 0;
            if (i6 == 1 || i6 == 2) {
                if (!z8) {
                    z5 = false;
                } else {
                    if (!this.perMessageDeflate) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    z5 = true;
                }
                this.readingCompressedMessage = z5;
            } else if (z8) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((and & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((and & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            int and2 = _UtilCommonKt.and(this.source.readByte(), 255);
            boolean z9 = (and2 & 128) != 0;
            if (z9 == this.isClient) {
                throw new ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j6 = and2 & 127;
            this.frameLength = j6;
            if (j6 == 126) {
                this.frameLength = _UtilCommonKt.and(this.source.readShort(), 65535);
            } else if (j6 == 127) {
                long readLong = this.source.readLong();
                this.frameLength = readLong;
                if (readLong < 0) {
                    throw new ProtocolException("Frame length 0x" + _UtilJvmKt.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.isControlFrame && this.frameLength > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z9) {
                BufferedSource bufferedSource = this.source;
                byte[] bArr = this.maskKey;
                g0.m(bArr);
                bufferedSource.readFully(bArr);
            }
        } catch (Throwable th) {
            this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private final void readMessage() throws IOException {
        while (!this.closed) {
            long j6 = this.frameLength;
            if (j6 > 0) {
                this.source.readFully(this.messageFrameBuffer, j6);
                if (!this.isClient) {
                    Buffer buffer = this.messageFrameBuffer;
                    Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                    g0.m(unsafeCursor);
                    buffer.readAndWriteUnsafe(unsafeCursor);
                    this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
                    WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                    Buffer.UnsafeCursor unsafeCursor2 = this.maskCursor;
                    byte[] bArr = this.maskKey;
                    g0.m(bArr);
                    webSocketProtocol.toggleMask(unsafeCursor2, bArr);
                    this.maskCursor.close();
                }
            }
            if (this.isFinalFrame) {
                return;
            }
            readUntilNonControlFrame();
            if (this.opcode != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + _UtilJvmKt.toHexString(this.opcode));
            }
        }
        throw new IOException("closed");
    }

    private final void readMessageFrame() throws IOException {
        int i6 = this.opcode;
        if (i6 != 1 && i6 != 2) {
            throw new ProtocolException("Unknown opcode: " + _UtilJvmKt.toHexString(i6));
        }
        readMessage();
        if (this.readingCompressedMessage) {
            MessageInflater messageInflater = this.messageInflater;
            if (messageInflater == null) {
                messageInflater = new MessageInflater(this.noContextTakeover);
                this.messageInflater = messageInflater;
            }
            messageInflater.inflate(this.messageFrameBuffer);
        }
        if (i6 == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
        } else {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
        }
    }

    private final void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (!this.isControlFrame) {
                return;
            } else {
                readControlFrame();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        MessageInflater messageInflater = this.messageInflater;
        if (messageInflater != null) {
            _UtilCommonKt.closeQuietly(messageInflater);
        }
        _UtilCommonKt.closeQuietly(this.source);
    }

    @NotNull
    public final BufferedSource getSource() {
        return this.source;
    }

    public final void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
