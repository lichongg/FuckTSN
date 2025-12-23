package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.PrematureChannelClosureException;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.AppendableCharSequence;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class HttpObjectDecoder extends ByteToMessageDecoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String EMPTY_VALUE = "";
    private long chunkSize;
    private final boolean chunkedSupported;
    private long contentLength;
    private State currentState;
    private final HeaderParser headerParser;
    private final LineParser lineParser;
    private final int maxChunkSize;
    private HttpMessage message;
    private CharSequence name;
    private volatile boolean resetRequested;
    private LastHttpContent trailer;
    protected final boolean validateHeaders;
    private CharSequence value;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class HeaderParser implements ByteProcessor {
        private final int maxLength;
        private final AppendableCharSequence seq;
        private int size;

        public void reset() {
            this.size = 0;
        }

        protected TooLongFrameException newException(int i6) {
            return new TooLongFrameException("HTTP header is larger than " + i6 + " bytes.");
        }

        public AppendableCharSequence parse(ByteBuf byteBuf) {
            int i6 = this.size;
            this.seq.reset();
            int forEachByte = byteBuf.forEachByte(this);
            if (forEachByte == -1) {
                this.size = i6;
                return null;
            }
            byteBuf.readerIndex(forEachByte + 1);
            return this.seq;
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b6) throws Exception {
            char c6 = (char) (b6 & 255);
            if (c6 == '\r') {
                return true;
            }
            if (c6 == '\n') {
                return false;
            }
            int i6 = this.size + 1;
            this.size = i6;
            int i7 = this.maxLength;
            if (i6 > i7) {
                throw newException(i7);
            }
            this.seq.append(c6);
            return true;
        }

        HeaderParser(AppendableCharSequence appendableCharSequence, int i6) {
            this.seq = appendableCharSequence;
            this.maxLength = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class LineParser extends HeaderParser {
        @Override // io.netty.handler.codec.http.HttpObjectDecoder.HeaderParser
        protected TooLongFrameException newException(int i6) {
            return new TooLongFrameException("An HTTP line is larger than " + i6 + " bytes.");
        }

        LineParser(AppendableCharSequence appendableCharSequence, int i6) {
            super(appendableCharSequence, i6);
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder.HeaderParser
        public AppendableCharSequence parse(ByteBuf byteBuf) {
            reset();
            return super.parse(byteBuf);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum State {
        SKIP_CONTROL_CHARS,
        READ_INITIAL,
        READ_HEADER,
        READ_VARIABLE_LENGTH_CONTENT,
        READ_FIXED_LENGTH_CONTENT,
        READ_CHUNK_SIZE,
        READ_CHUNKED_CONTENT,
        READ_CHUNK_DELIMITER,
        READ_CHUNK_FOOTER,
        BAD_MESSAGE,
        UPGRADED
    }

    protected HttpObjectDecoder() {
        this(4096, 8192, 8192, true);
    }

    private static String[] splitInitialLine(AppendableCharSequence appendableCharSequence) {
        int findNonWhitespace = findNonWhitespace(appendableCharSequence, 0);
        int findWhitespace = findWhitespace(appendableCharSequence, findNonWhitespace);
        int findNonWhitespace2 = findNonWhitespace(appendableCharSequence, findWhitespace);
        int findWhitespace2 = findWhitespace(appendableCharSequence, findNonWhitespace2);
        int findNonWhitespace3 = findNonWhitespace(appendableCharSequence, findWhitespace2);
        int findEndOfString = findEndOfString(appendableCharSequence);
        return new String[]{appendableCharSequence.subStringUnsafe(findNonWhitespace, findWhitespace), appendableCharSequence.subStringUnsafe(findNonWhitespace2, findWhitespace2), findNonWhitespace3 < findEndOfString ? appendableCharSequence.subStringUnsafe(findNonWhitespace3, findEndOfString) : ""};
    }

    protected abstract HttpMessage createInvalidMessage();

    protected abstract HttpMessage createMessage(String[] strArr) throws Exception;

    protected abstract boolean isDecodingRequest();

    public void reset() {
        this.resetRequested = true;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.http.HttpObjectDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State = iArr;
            try {
                iArr[State.SKIP_CONTROL_CHARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_SIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_INITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_HEADER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_VARIABLE_LENGTH_CONTENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_FIXED_LENGTH_CONTENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNKED_CONTENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_DELIMITER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_FOOTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.BAD_MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.UPGRADED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    protected HttpObjectDecoder(int i6, int i7, int i8, boolean z5) {
        this(i6, i7, i8, z5, true);
    }

    private long contentLength() {
        if (this.contentLength == Long.MIN_VALUE) {
            this.contentLength = HttpUtil.getContentLength(this.message, -1L);
        }
        return this.contentLength;
    }

    private HttpContent invalidChunk(ByteBuf byteBuf, Exception exc) {
        this.currentState = State.BAD_MESSAGE;
        byteBuf.skipBytes(byteBuf.readableBytes());
        DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER);
        defaultLastHttpContent.setDecoderResult(DecoderResult.failure(exc));
        this.message = null;
        this.trailer = null;
        return defaultLastHttpContent;
    }

    private HttpMessage invalidMessage(ByteBuf byteBuf, Exception exc) {
        this.currentState = State.BAD_MESSAGE;
        byteBuf.skipBytes(byteBuf.readableBytes());
        if (this.message == null) {
            this.message = createInvalidMessage();
        }
        this.message.setDecoderResult(DecoderResult.failure(exc));
        HttpMessage httpMessage = this.message;
        this.message = null;
        return httpMessage;
    }

    private State readHeaders(ByteBuf byteBuf) {
        HttpMessage httpMessage = this.message;
        HttpHeaders headers = httpMessage.headers();
        AppendableCharSequence parse = this.headerParser.parse(byteBuf);
        if (parse == null) {
            return null;
        }
        if (parse.length() > 0) {
            do {
                char charAt = parse.charAt(0);
                CharSequence charSequence = this.name;
                if (charSequence == null || !(charAt == ' ' || charAt == '\t')) {
                    if (charSequence != null) {
                        headers.add(charSequence, this.value);
                    }
                    splitHeader(parse);
                } else {
                    String trim = parse.toString().trim();
                    this.value = String.valueOf(this.value) + ' ' + trim;
                }
                parse = this.headerParser.parse(byteBuf);
                if (parse == null) {
                    return null;
                }
            } while (parse.length() > 0);
        }
        CharSequence charSequence2 = this.name;
        if (charSequence2 != null) {
            headers.add(charSequence2, this.value);
        }
        this.name = null;
        this.value = null;
        if (!isContentAlwaysEmpty(httpMessage)) {
            return HttpUtil.isTransferEncodingChunked(httpMessage) ? State.READ_CHUNK_SIZE : contentLength() >= 0 ? State.READ_FIXED_LENGTH_CONTENT : State.READ_VARIABLE_LENGTH_CONTENT;
        }
        HttpUtil.setTransferEncodingChunked(httpMessage, false);
        return State.SKIP_CONTROL_CHARS;
    }

    private LastHttpContent readTrailingHeaders(ByteBuf byteBuf) {
        AppendableCharSequence parse = this.headerParser.parse(byteBuf);
        if (parse == null) {
            return null;
        }
        LastHttpContent lastHttpContent = this.trailer;
        if (parse.length() == 0 && lastHttpContent == null) {
            return LastHttpContent.EMPTY_LAST_CONTENT;
        }
        if (lastHttpContent == null) {
            lastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER, this.validateHeaders);
            this.trailer = lastHttpContent;
        }
        CharSequence charSequence = null;
        while (parse.length() > 0) {
            char charAt = parse.charAt(0);
            if (charSequence == null || !(charAt == ' ' || charAt == '\t')) {
                splitHeader(parse);
                CharSequence charSequence2 = this.name;
                if (!HttpHeaderNames.CONTENT_LENGTH.contentEqualsIgnoreCase(charSequence2) && !HttpHeaderNames.TRANSFER_ENCODING.contentEqualsIgnoreCase(charSequence2) && !HttpHeaderNames.TRAILER.contentEqualsIgnoreCase(charSequence2)) {
                    lastHttpContent.trailingHeaders().add(charSequence2, this.value);
                }
                charSequence = this.name;
                this.name = null;
                this.value = null;
            } else {
                List<String> all = lastHttpContent.trailingHeaders().getAll(charSequence);
                if (!all.isEmpty()) {
                    int size = all.size() - 1;
                    String trim = parse.toString().trim();
                    all.set(size, all.get(size) + trim);
                }
            }
            parse = this.headerParser.parse(byteBuf);
            if (parse == null) {
                return null;
            }
        }
        this.trailer = null;
        return lastHttpContent;
    }

    private void resetNow() {
        HttpResponse httpResponse;
        HttpMessage httpMessage = this.message;
        this.message = null;
        this.name = null;
        this.value = null;
        this.contentLength = Long.MIN_VALUE;
        this.lineParser.reset();
        this.headerParser.reset();
        this.trailer = null;
        if (!isDecodingRequest() && (httpResponse = (HttpResponse) httpMessage) != null && isSwitchingToNonHttp1Protocol(httpResponse)) {
            this.currentState = State.UPGRADED;
        } else {
            this.resetRequested = false;
            this.currentState = State.SKIP_CONTROL_CHARS;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:101:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012b A[Catch: Exception -> 0x0138, TryCatch #2 {Exception -> 0x0138, blocks: (B:99:0x0122, B:103:0x012b, B:105:0x0133, B:107:0x013b), top: B:98:0x0122 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x014c A[Catch: Exception -> 0x016f, TryCatch #0 {Exception -> 0x016f, blocks: (B:53:0x0145, B:57:0x014c, B:61:0x015a, B:65:0x0168, B:68:0x0171, B:70:0x017a, B:73:0x017d, B:75:0x018b, B:77:0x018f, B:79:0x0195, B:80:0x019c, B:81:0x019d), top: B:52:0x0145 }] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void decode(io.netty.channel.ChannelHandlerContext r8, io.netty.buffer.ByteBuf r9, java.util.List<java.lang.Object> r10) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 470
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.HttpObjectDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    protected boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
        if (httpMessage instanceof HttpResponse) {
            HttpResponse httpResponse = (HttpResponse) httpMessage;
            int code = httpResponse.status().code();
            if (code >= 100 && code < 200) {
                return (code == 101 && !httpResponse.headers().contains(HttpHeaderNames.SEC_WEBSOCKET_ACCEPT) && httpResponse.headers().contains((CharSequence) HttpHeaderNames.UPGRADE, (CharSequence) HttpHeaderValues.WEBSOCKET, true)) ? false : true;
            }
            if (code == 204 || code == 304) {
                return true;
            }
        }
        return false;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        int i6;
        if ((obj instanceof HttpExpectationFailedEvent) && ((i6 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[this.currentState.ordinal()]) == 2 || i6 == 5 || i6 == 6)) {
            reset();
        }
        super.userEventTriggered(channelHandlerContext, obj);
    }

    protected HttpObjectDecoder(int i6, int i7, int i8, boolean z5, boolean z6) {
        this(i6, i7, i8, z5, z6, 128);
    }

    private static int findEndOfString(AppendableCharSequence appendableCharSequence) {
        for (int length = appendableCharSequence.length() - 1; length > 0; length--) {
            if (!Character.isWhitespace(appendableCharSequence.charAtUnsafe(length))) {
                return length + 1;
            }
        }
        return 0;
    }

    private static int findNonWhitespace(AppendableCharSequence appendableCharSequence, int i6) {
        while (i6 < appendableCharSequence.length()) {
            if (!Character.isWhitespace(appendableCharSequence.charAtUnsafe(i6))) {
                return i6;
            }
            i6++;
        }
        return appendableCharSequence.length();
    }

    private static int findWhitespace(AppendableCharSequence appendableCharSequence, int i6) {
        while (i6 < appendableCharSequence.length()) {
            if (Character.isWhitespace(appendableCharSequence.charAtUnsafe(i6))) {
                return i6;
            }
            i6++;
        }
        return appendableCharSequence.length();
    }

    private static int getChunkSize(String str) {
        String trim = str.trim();
        for (int i6 = 0; i6 < trim.length(); i6++) {
            char charAt = trim.charAt(i6);
            if (charAt == ';' || Character.isWhitespace(charAt) || Character.isISOControl(charAt)) {
                trim = trim.substring(0, i6);
                break;
            }
        }
        return Integer.parseInt(trim, 16);
    }

    private static boolean skipControlCharacters(ByteBuf byteBuf) {
        boolean z5;
        int writerIndex = byteBuf.writerIndex();
        int readerIndex = byteBuf.readerIndex();
        while (true) {
            if (writerIndex > readerIndex) {
                int i6 = readerIndex + 1;
                short unsignedByte = byteBuf.getUnsignedByte(readerIndex);
                if (!Character.isISOControl(unsignedByte) && !Character.isWhitespace(unsignedByte)) {
                    z5 = true;
                    break;
                }
                readerIndex = i6;
            } else {
                z5 = false;
                break;
            }
        }
        byteBuf.readerIndex(readerIndex);
        return z5;
    }

    private void splitHeader(AppendableCharSequence appendableCharSequence) {
        char charAt;
        int length = appendableCharSequence.length();
        int findNonWhitespace = findNonWhitespace(appendableCharSequence, 0);
        int i6 = findNonWhitespace;
        while (i6 < length && (charAt = appendableCharSequence.charAt(i6)) != ':' && !Character.isWhitespace(charAt)) {
            i6++;
        }
        int i7 = i6;
        while (true) {
            if (i7 >= length) {
                break;
            }
            if (appendableCharSequence.charAt(i7) == ':') {
                i7++;
                break;
            }
            i7++;
        }
        this.name = appendableCharSequence.subStringUnsafe(findNonWhitespace, i6);
        int findNonWhitespace2 = findNonWhitespace(appendableCharSequence, i7);
        if (findNonWhitespace2 == length) {
            this.value = "";
        } else {
            this.value = appendableCharSequence.subStringUnsafe(findNonWhitespace2, findEndOfString(appendableCharSequence));
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        super.decodeLast(channelHandlerContext, byteBuf, list);
        if (this.resetRequested) {
            resetNow();
        }
        HttpMessage httpMessage = this.message;
        if (httpMessage != null) {
            boolean isTransferEncodingChunked = HttpUtil.isTransferEncodingChunked(httpMessage);
            if (this.currentState == State.READ_VARIABLE_LENGTH_CONTENT && !byteBuf.isReadable() && !isTransferEncodingChunked) {
                list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                resetNow();
            } else {
                if (this.currentState == State.READ_HEADER) {
                    list.add(invalidMessage(Unpooled.EMPTY_BUFFER, new PrematureChannelClosureException("Connection closed before received headers")));
                    resetNow();
                    return;
                }
                if (!isDecodingRequest() && !isTransferEncodingChunked && contentLength() <= 0) {
                    list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                }
                resetNow();
            }
        }
    }

    protected boolean isSwitchingToNonHttp1Protocol(HttpResponse httpResponse) {
        if (httpResponse.status().code() != HttpResponseStatus.SWITCHING_PROTOCOLS.code()) {
            return false;
        }
        String str = httpResponse.headers().get(HttpHeaderNames.UPGRADE);
        if (str != null) {
            if (str.contains(HttpVersion.HTTP_1_0.text()) || str.contains(HttpVersion.HTTP_1_1.text())) {
                return false;
            }
            return true;
        }
        return true;
    }

    protected HttpObjectDecoder(int i6, int i7, int i8, boolean z5, boolean z6, int i9) {
        this.contentLength = Long.MIN_VALUE;
        this.currentState = State.SKIP_CONTROL_CHARS;
        ObjectUtil.checkPositive(i6, "maxInitialLineLength");
        ObjectUtil.checkPositive(i7, "maxHeaderSize");
        ObjectUtil.checkPositive(i8, "maxChunkSize");
        AppendableCharSequence appendableCharSequence = new AppendableCharSequence(i9);
        this.lineParser = new LineParser(appendableCharSequence, i6);
        this.headerParser = new HeaderParser(appendableCharSequence, i7);
        this.maxChunkSize = i8;
        this.chunkedSupported = z5;
        this.validateHeaders = z6;
    }
}
