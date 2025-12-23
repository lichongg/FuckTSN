package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class RedisDecoder extends ByteToMessageDecoder {
    private final boolean decodeInlineCommands;
    private final int maxInlineMessageLength;
    private final RedisMessagePool messagePool;
    private int remainingBulkLength;
    private State state;
    private final ToPositiveLongProcessor toPositiveLongProcessor;
    private RedisMessageType type;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum State {
        DECODE_TYPE,
        DECODE_INLINE,
        DECODE_LENGTH,
        DECODE_BULK_STRING_EOL,
        DECODE_BULK_STRING_CONTENT
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ToPositiveLongProcessor implements ByteProcessor {
        private long result;

        private ToPositiveLongProcessor() {
        }

        /* synthetic */ ToPositiveLongProcessor(AnonymousClass1 anonymousClass1) {
            this();
        }

        public long content() {
            return this.result;
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b6) throws Exception {
            if (b6 >= 48 && b6 <= 57) {
                this.result = (this.result * 10) + (b6 - 48);
                return true;
            }
            throw new RedisCodecException("bad byte in number: " + ((int) b6));
        }

        public void reset() {
            this.result = 0L;
        }
    }

    public RedisDecoder() {
        this(false);
    }

    private static ByteBuf readLine(ByteBuf byteBuf) {
        int forEachByte;
        if (!byteBuf.isReadable(2) || (forEachByte = byteBuf.forEachByte(ByteProcessor.FIND_LF)) < 0) {
            return null;
        }
        ByteBuf readSlice = byteBuf.readSlice((forEachByte - byteBuf.readerIndex()) - 1);
        readEndOfLine(byteBuf);
        return readSlice;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.redis.RedisDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$redis$RedisMessageType;

        static {
            int[] iArr = new int[RedisMessageType.values().length];
            $SwitchMap$io$netty$handler$codec$redis$RedisMessageType = iArr;
            try {
                iArr[RedisMessageType.ARRAY_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisMessageType[RedisMessageType.BULK_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisMessageType[RedisMessageType.INLINE_COMMAND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisMessageType[RedisMessageType.SIMPLE_STRING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisMessageType[RedisMessageType.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisMessageType[RedisMessageType.INTEGER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State = iArr2;
            try {
                iArr2[State.DECODE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State[State.DECODE_INLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State[State.DECODE_LENGTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State[State.DECODE_BULK_STRING_EOL.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State[State.DECODE_BULK_STRING_CONTENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public RedisDecoder(boolean z5) {
        this(65536, FixedRedisMessagePool.INSTANCE, z5);
    }

    private boolean decodeBulkString(ByteBuf byteBuf, List<Object> list) throws Exception {
        int i6 = this.remainingBulkLength;
        if (i6 == -1) {
            list.add(FullBulkStringRedisMessage.NULL_INSTANCE);
            resetDecoder();
            return true;
        }
        if (i6 == 0) {
            this.state = State.DECODE_BULK_STRING_EOL;
            return decodeBulkStringEndOfLine(byteBuf, list);
        }
        list.add(new BulkStringHeaderRedisMessage(i6));
        this.state = State.DECODE_BULK_STRING_CONTENT;
        return decodeBulkStringContent(byteBuf, list);
    }

    private RedisMessage newInlineRedisMessage(RedisMessageType redisMessageType, ByteBuf byteBuf) {
        int i6 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$redis$RedisMessageType[redisMessageType.ordinal()];
        if (i6 == 3) {
            return new InlineCommandRedisMessage(byteBuf.toString(CharsetUtil.UTF_8));
        }
        if (i6 == 4) {
            SimpleStringRedisMessage simpleString = this.messagePool.getSimpleString(byteBuf);
            return simpleString != null ? simpleString : new SimpleStringRedisMessage(byteBuf.toString(CharsetUtil.UTF_8));
        }
        if (i6 == 5) {
            ErrorRedisMessage error = this.messagePool.getError(byteBuf);
            return error != null ? error : new ErrorRedisMessage(byteBuf.toString(CharsetUtil.UTF_8));
        }
        if (i6 == 6) {
            IntegerRedisMessage integer = this.messagePool.getInteger(byteBuf);
            return integer != null ? integer : new IntegerRedisMessage(parseRedisNumber(byteBuf));
        }
        throw new RedisCodecException("bad type: " + redisMessageType);
    }

    private long parsePositiveNumber(ByteBuf byteBuf) {
        this.toPositiveLongProcessor.reset();
        byteBuf.forEachByte(this.toPositiveLongProcessor);
        return this.toPositiveLongProcessor.content();
    }

    private void resetDecoder() {
        this.state = State.DECODE_TYPE;
        this.remainingBulkLength = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x003c, code lost:
    
        throw new io.netty.handler.codec.redis.RedisCodecException("Unknown state: " + r1.state);
     */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void decode(io.netty.channel.ChannelHandlerContext r2, io.netty.buffer.ByteBuf r3, java.util.List<java.lang.Object> r4) throws java.lang.Exception {
        /*
            r1 = this;
        L0:
            int[] r2 = io.netty.handler.codec.redis.RedisDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State     // Catch: java.lang.Exception -> L20 io.netty.handler.codec.redis.RedisCodecException -> L22
            io.netty.handler.codec.redis.RedisDecoder$State r0 = r1.state     // Catch: java.lang.Exception -> L20 io.netty.handler.codec.redis.RedisCodecException -> L22
            int r0 = r0.ordinal()     // Catch: java.lang.Exception -> L20 io.netty.handler.codec.redis.RedisCodecException -> L22
            r2 = r2[r0]     // Catch: java.lang.Exception -> L20 io.netty.handler.codec.redis.RedisCodecException -> L22
            r0 = 1
            if (r2 == r0) goto L52
            r0 = 2
            if (r2 == r0) goto L4b
            r0 = 3
            if (r2 == r0) goto L44
            r0 = 4
            if (r2 == r0) goto L3d
            r0 = 5
            if (r2 != r0) goto L24
            boolean r2 = r1.decodeBulkStringContent(r3, r4)     // Catch: java.lang.Exception -> L20 io.netty.handler.codec.redis.RedisCodecException -> L22
            if (r2 != 0) goto L0
            goto L58
        L20:
            r2 = move-exception
            goto L59
        L22:
            r2 = move-exception
            goto L62
        L24:
            io.netty.handler.codec.redis.RedisCodecException r2 = new io.netty.handler.codec.redis.RedisCodecException     // Catch: java.lang.Exception -> L20 io.netty.handler.codec.redis.RedisCodecException -> L22
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L20 io.netty.handler.codec.redis.RedisCodecException -> L22
            r3.<init>()     // Catch: java.lang.Exception -> L20 io.netty.handler.codec.redis.RedisCodecException -> L22
            java.lang.String r4 = "Unknown state: "
            r3.append(r4)     // Catch: java.lang.Exception -> L20 io.netty.handler.codec.redis.RedisCodecException -> L22
            io.netty.handler.codec.redis.RedisDecoder$State r4 = r1.state     // Catch: java.lang.Exception -> L20 io.netty.handler.codec.redis.RedisCodecException -> L22
            r3.append(r4)     // Catch: java.lang.Exception -> L20 io.netty.handler.codec.redis.RedisCodecException -> L22
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L20 io.netty.handler.codec.redis.RedisCodecException -> L22
            r2.<init>(r3)     // Catch: java.lang.Exception -> L20 io.netty.handler.codec.redis.RedisCodecException -> L22
            throw r2     // Catch: java.lang.Exception -> L20 io.netty.handler.codec.redis.RedisCodecException -> L22
        L3d:
            boolean r2 = r1.decodeBulkStringEndOfLine(r3, r4)     // Catch: java.lang.Exception -> L20 io.netty.handler.codec.redis.RedisCodecException -> L22
            if (r2 != 0) goto L0
            goto L58
        L44:
            boolean r2 = r1.decodeLength(r3, r4)     // Catch: java.lang.Exception -> L20 io.netty.handler.codec.redis.RedisCodecException -> L22
            if (r2 != 0) goto L0
            goto L58
        L4b:
            boolean r2 = r1.decodeInline(r3, r4)     // Catch: java.lang.Exception -> L20 io.netty.handler.codec.redis.RedisCodecException -> L22
            if (r2 != 0) goto L0
            goto L58
        L52:
            boolean r2 = r1.decodeType(r3)     // Catch: java.lang.Exception -> L20 io.netty.handler.codec.redis.RedisCodecException -> L22
            if (r2 != 0) goto L0
        L58:
            return
        L59:
            r1.resetDecoder()
            io.netty.handler.codec.redis.RedisCodecException r3 = new io.netty.handler.codec.redis.RedisCodecException
            r3.<init>(r2)
            throw r3
        L62:
            r1.resetDecoder()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.redis.RedisDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    public RedisDecoder(int i6, RedisMessagePool redisMessagePool) {
        this(i6, redisMessagePool, false);
    }

    private boolean decodeBulkStringContent(ByteBuf byteBuf, List<Object> list) throws Exception {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes != 0) {
            int i6 = this.remainingBulkLength;
            if (i6 != 0 || readableBytes >= 2) {
                if (readableBytes >= i6 + 2) {
                    ByteBuf readSlice = byteBuf.readSlice(i6);
                    readEndOfLine(byteBuf);
                    list.add(new DefaultLastBulkStringRedisContent(readSlice.retain()));
                    resetDecoder();
                    return true;
                }
                int min = Math.min(i6, readableBytes);
                this.remainingBulkLength -= min;
                list.add(new DefaultBulkStringRedisContent(byteBuf.readSlice(min).retain()));
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean decodeBulkStringEndOfLine(ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.readableBytes() < 2) {
            return false;
        }
        readEndOfLine(byteBuf);
        list.add(FullBulkStringRedisMessage.EMPTY_INSTANCE);
        resetDecoder();
        return true;
    }

    private boolean decodeInline(ByteBuf byteBuf, List<Object> list) throws Exception {
        ByteBuf readLine = readLine(byteBuf);
        if (readLine == null) {
            if (byteBuf.readableBytes() <= this.maxInlineMessageLength) {
                return false;
            }
            throw new RedisCodecException("length: " + byteBuf.readableBytes() + " (expected: <= " + this.maxInlineMessageLength + ")");
        }
        list.add(newInlineRedisMessage(this.type, readLine));
        resetDecoder();
        return true;
    }

    private boolean decodeLength(ByteBuf byteBuf, List<Object> list) throws Exception {
        ByteBuf readLine = readLine(byteBuf);
        if (readLine == null) {
            return false;
        }
        long parseRedisNumber = parseRedisNumber(readLine);
        if (parseRedisNumber >= -1) {
            int i6 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$redis$RedisMessageType[this.type.ordinal()];
            if (i6 != 1) {
                if (i6 == 2) {
                    if (parseRedisNumber <= IjkMediaMeta.AV_CH_STEREO_LEFT) {
                        this.remainingBulkLength = (int) parseRedisNumber;
                        return decodeBulkString(byteBuf, list);
                    }
                    throw new RedisCodecException("length: " + parseRedisNumber + " (expected: <= 536870912)");
                }
                throw new RedisCodecException("bad type: " + this.type);
            }
            list.add(new ArrayHeaderRedisMessage(parseRedisNumber));
            resetDecoder();
            return true;
        }
        throw new RedisCodecException("length: " + parseRedisNumber + " (expected: >= -1)");
    }

    private boolean decodeType(ByteBuf byteBuf) throws Exception {
        State state;
        if (!byteBuf.isReadable()) {
            return false;
        }
        RedisMessageType readFrom = RedisMessageType.readFrom(byteBuf, this.decodeInlineCommands);
        this.type = readFrom;
        if (readFrom.isInline()) {
            state = State.DECODE_INLINE;
        } else {
            state = State.DECODE_LENGTH;
        }
        this.state = state;
        return true;
    }

    private long parseRedisNumber(ByteBuf byteBuf) {
        int i6;
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes > 0 && byteBuf.getByte(byteBuf.readerIndex()) == 45) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        if (readableBytes > i6) {
            if (readableBytes <= i6 + 19) {
                if (i6 != 0) {
                    return -parsePositiveNumber(byteBuf.skipBytes(i6));
                }
                return parsePositiveNumber(byteBuf);
            }
            throw new RedisCodecException("too many characters to be a valid RESP Integer: " + byteBuf.toString(CharsetUtil.US_ASCII));
        }
        throw new RedisCodecException("no number to parse: " + byteBuf.toString(CharsetUtil.US_ASCII));
    }

    private static void readEndOfLine(ByteBuf byteBuf) {
        short readShort = byteBuf.readShort();
        if (RedisConstants.EOL_SHORT == readShort) {
            return;
        }
        byte[] shortToBytes = RedisCodecUtil.shortToBytes(readShort);
        throw new RedisCodecException("delimiter: [" + ((int) shortToBytes[0]) + "," + ((int) shortToBytes[1]) + "] (expected: \\r\\n)");
    }

    public RedisDecoder(int i6, RedisMessagePool redisMessagePool, boolean z5) {
        this.toPositiveLongProcessor = new ToPositiveLongProcessor(null);
        this.state = State.DECODE_TYPE;
        if (i6 > 0 && i6 <= 536870912) {
            this.maxInlineMessageLength = i6;
            this.messagePool = redisMessagePool;
            this.decodeInlineCommands = z5;
        } else {
            throw new RedisCodecException("maxInlineMessageLength: " + i6 + " (expected: <= 536870912)");
        }
    }
}
