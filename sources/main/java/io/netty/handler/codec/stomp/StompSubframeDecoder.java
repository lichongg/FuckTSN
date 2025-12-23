package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.AsciiString;
import io.netty.util.internal.AppendableCharSequence;
import io.netty.util.internal.ObjectUtil;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class StompSubframeDecoder extends ReplayingDecoder<State> {
    private static final int DEFAULT_CHUNK_SIZE = 8132;
    private static final int DEFAULT_MAX_LINE_LENGTH = 1024;
    private int alreadyReadChunkSize;
    private long contentLength;
    private LastStompContentSubframe lastContent;
    private final int maxChunkSize;
    private final int maxLineLength;
    private final boolean validateHeaders;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum State {
        SKIP_CONTROL_CHARACTERS,
        READ_HEADERS,
        READ_CONTENT,
        FINALIZE_FRAME_READ,
        BAD_FRAME,
        INVALID_CHUNK
    }

    public StompSubframeDecoder() {
        this(1024, DEFAULT_CHUNK_SIZE);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.stomp.StompSubframeDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State = iArr;
            try {
                iArr[State.SKIP_CONTROL_CHARACTERS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State[State.READ_HEADERS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State[State.BAD_FRAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State[State.READ_CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State[State.FINALIZE_FRAME_READ.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public StompSubframeDecoder(boolean z5) {
        this(1024, DEFAULT_CHUNK_SIZE, z5);
    }

    private static long getContentLength(StompHeaders stompHeaders, long j6) {
        AsciiString asciiString = StompHeaders.CONTENT_LENGTH;
        long j7 = stompHeaders.getLong(asciiString, j6);
        if (j7 >= 0) {
            return j7;
        }
        throw new DecoderException(((Object) asciiString) + " must be non-negative");
    }

    private void invalidHeader(String str, String str2) {
        if (str != null) {
            str2 = str + ":" + str2;
        }
        throw new IllegalArgumentException("a header value or name contains a prohibited character ':', " + str2);
    }

    private void invalidLineLength() {
        throw new TooLongFrameException("An STOMP line is larger than " + this.maxLineLength + " bytes.");
    }

    private StompCommand readCommand(ByteBuf byteBuf) {
        StompCommand stompCommand;
        String readLine = readLine(byteBuf, 16);
        try {
            stompCommand = StompCommand.valueOf(readLine);
        } catch (IllegalArgumentException unused) {
            stompCommand = null;
        }
        if (stompCommand == null) {
            try {
                stompCommand = StompCommand.valueOf(readLine.toUpperCase(Locale.US));
            } catch (IllegalArgumentException unused2) {
            }
        }
        if (stompCommand != null) {
            return stompCommand;
        }
        throw new DecoderException("failed to read command from channel");
    }

    private State readHeaders(ByteBuf byteBuf, StompHeaders stompHeaders) {
        while (readHeader(stompHeaders, new AppendableCharSequence(128), byteBuf)) {
        }
        if (stompHeaders.contains(StompHeaders.CONTENT_LENGTH)) {
            long contentLength = getContentLength(stompHeaders, 0L);
            this.contentLength = contentLength;
            if (contentLength == 0) {
                return State.FINALIZE_FRAME_READ;
            }
        }
        return State.READ_CONTENT;
    }

    private String readLine(ByteBuf byteBuf, int i6) {
        AppendableCharSequence appendableCharSequence = new AppendableCharSequence(i6);
        int i7 = 0;
        while (true) {
            byte readByte = byteBuf.readByte();
            if (readByte != 13) {
                if (readByte == 10) {
                    return appendableCharSequence.toString();
                }
                if (i7 >= this.maxLineLength) {
                    invalidLineLength();
                }
                i7++;
                appendableCharSequence.append((char) readByte);
            }
        }
    }

    private void resetDecoder() {
        checkpoint(State.SKIP_CONTROL_CHARACTERS);
        this.contentLength = -1L;
        this.alreadyReadChunkSize = 0;
        this.lastContent = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ea A[Catch: Exception -> 0x0092, TryCatch #2 {Exception -> 0x0092, blocks: (B:11:0x0042, B:17:0x00e3, B:19:0x00ea, B:20:0x00ee, B:22:0x0055, B:24:0x005c, B:27:0x0061, B:29:0x0069, B:32:0x0071, B:34:0x0085, B:35:0x0094, B:37:0x009d, B:39:0x00b0, B:41:0x00b8, B:42:0x00c8, B:44:0x00d7, B:45:0x00f7, B:47:0x00bf), top: B:10:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0055 A[Catch: Exception -> 0x0092, TryCatch #2 {Exception -> 0x0092, blocks: (B:11:0x0042, B:17:0x00e3, B:19:0x00ea, B:20:0x00ee, B:22:0x0055, B:24:0x005c, B:27:0x0061, B:29:0x0069, B:32:0x0071, B:34:0x0085, B:35:0x0094, B:37:0x009d, B:39:0x00b0, B:41:0x00b8, B:42:0x00c8, B:44:0x00d7, B:45:0x00f7, B:47:0x00bf), top: B:10:0x0042 }] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void decode(io.netty.channel.ChannelHandlerContext r7, io.netty.buffer.ByteBuf r8, java.util.List<java.lang.Object> r9) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.stomp.StompSubframeDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    public StompSubframeDecoder(int i6, int i7) {
        this(i6, i7, false);
    }

    private boolean readHeader(StompHeaders stompHeaders, AppendableCharSequence appendableCharSequence, ByteBuf byteBuf) {
        appendableCharSequence.reset();
        String str = null;
        int i6 = 0;
        boolean z5 = false;
        while (true) {
            byte readByte = byteBuf.readByte();
            if (readByte == 58 && str == null) {
                str = appendableCharSequence.toString();
                appendableCharSequence.reset();
                z5 = true;
            } else if (readByte == 13) {
                continue;
            } else {
                if (readByte == 10) {
                    break;
                }
                if (i6 >= this.maxLineLength) {
                    invalidLineLength();
                }
                if (readByte == 58 && str != null) {
                    z5 = false;
                }
                i6++;
                appendableCharSequence.append((char) readByte);
            }
        }
        if (str == null && i6 == 0) {
            return false;
        }
        if (z5) {
            stompHeaders.add((StompHeaders) str, appendableCharSequence.toString());
        } else if (this.validateHeaders) {
            invalidHeader(str, appendableCharSequence.toString());
        }
        return true;
    }

    private static void skipControlCharacters(ByteBuf byteBuf) {
        while (true) {
            byte readByte = byteBuf.readByte();
            if (readByte != 13 && readByte != 10) {
                byteBuf.readerIndex(byteBuf.readerIndex() - 1);
                return;
            }
        }
    }

    private static void skipNullCharacter(ByteBuf byteBuf) {
        byte readByte = byteBuf.readByte();
        if (readByte == 0) {
            return;
        }
        throw new IllegalStateException("unexpected byte in buffer " + ((int) readByte) + " while expecting NULL byte");
    }

    public StompSubframeDecoder(int i6, int i7, boolean z5) {
        super(State.SKIP_CONTROL_CHARACTERS);
        this.contentLength = -1L;
        ObjectUtil.checkPositive(i6, "maxLineLength");
        ObjectUtil.checkPositive(i7, "maxChunkSize");
        this.maxChunkSize = i7;
        this.maxLineLength = i6;
        this.validateHeaders = z5;
    }
}
