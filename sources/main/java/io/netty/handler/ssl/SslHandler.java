package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.AbstractCoalescingBufferQueue;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ChannelPromiseNotifier;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ImmediateExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.PromiseNotifier;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SslHandler extends ByteToMessageDecoder implements ChannelOutboundHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_PLAINTEXT_LENGTH = 16384;
    private boolean closeNotify;
    private volatile long closeNotifyFlushTimeoutMillis;
    private volatile long closeNotifyReadTimeoutMillis;
    private volatile ChannelHandlerContext ctx;
    private final Executor delegatedTaskExecutor;
    private final SSLEngine engine;
    private final SslEngineType engineType;
    private boolean firedChannelRead;
    private boolean flushedBeforeHandshake;
    private Promise<Channel> handshakePromise;
    private boolean handshakeStarted;
    private volatile long handshakeTimeoutMillis;
    private final boolean jdkCompatibilityMode;
    private boolean needsFlush;
    private boolean outboundClosed;
    private int packetLength;
    private SslHandlerCoalescingBufferQueue pendingUnencryptedWrites;
    private boolean processTask;
    private boolean readDuringHandshake;
    private boolean sentFirstMessage;
    private final ByteBuffer[] singleBuffer;
    private final LazyChannelPromise sslClosePromise;
    private final boolean startTls;
    volatile int wrapDataSize;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SslHandler.class);
    private static final Pattern IGNORABLE_CLASS_IN_STACK = Pattern.compile("^.*(?:Socket|Datagram|Sctp|Udt)Channel.*$");
    private static final Pattern IGNORABLE_ERROR_MESSAGE = Pattern.compile("^.*(?:connection.*(?:reset|closed|abort|broken)|broken.*pipe).*$", 2);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class LazyChannelPromise extends DefaultPromise<Channel> {
        private LazyChannelPromise() {
        }

        @Override // io.netty.util.concurrent.DefaultPromise
        protected void checkDeadLock() {
            if (SslHandler.this.ctx == null) {
                return;
            }
            super.checkDeadLock();
        }

        @Override // io.netty.util.concurrent.DefaultPromise
        protected EventExecutor executor() {
            if (SslHandler.this.ctx != null) {
                return SslHandler.this.ctx.executor();
            }
            throw new IllegalStateException();
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'TCNATIVE' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class SslEngineType {
        private static final /* synthetic */ SslEngineType[] $VALUES;
        public static final SslEngineType CONSCRYPT;
        public static final SslEngineType JDK;
        public static final SslEngineType TCNATIVE;
        final ByteToMessageDecoder.Cumulator cumulator;
        final boolean wantsDirectBuffer;

        abstract int calculatePendingData(SslHandler sslHandler, int i6);

        abstract int calculateWrapBufferCapacity(SslHandler sslHandler, int i6, int i7);

        abstract boolean jdkCompatibilityMode(SSLEngine sSLEngine);

        abstract SSLEngineResult unwrap(SslHandler sslHandler, ByteBuf byteBuf, int i6, int i7, ByteBuf byteBuf2) throws SSLException;

        static {
            ByteToMessageDecoder.Cumulator cumulator = ByteToMessageDecoder.COMPOSITE_CUMULATOR;
            SslEngineType sslEngineType = new SslEngineType("TCNATIVE", 0, true, cumulator) { // from class: io.netty.handler.ssl.SslHandler.SslEngineType.1
                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                boolean jdkCompatibilityMode(SSLEngine sSLEngine) {
                    return ((ReferenceCountedOpenSslEngine) sSLEngine).jdkCompatibilityMode;
                }

                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                int calculatePendingData(SslHandler sslHandler, int i6) {
                    int sslPending = ((ReferenceCountedOpenSslEngine) sslHandler.engine).sslPending();
                    if (sslPending > 0) {
                        return sslPending;
                    }
                    return i6;
                }

                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                int calculateWrapBufferCapacity(SslHandler sslHandler, int i6, int i7) {
                    return ((ReferenceCountedOpenSslEngine) sslHandler.engine).calculateMaxLengthForWrap(i6, i7);
                }

                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                int getPacketBufferSize(SslHandler sslHandler) {
                    return ((ReferenceCountedOpenSslEngine) sslHandler.engine).maxEncryptedPacketLength0();
                }

                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                SSLEngineResult unwrap(SslHandler sslHandler, ByteBuf byteBuf, int i6, int i7, ByteBuf byteBuf2) throws SSLException {
                    SSLEngineResult unwrap;
                    int nioBufferCount = byteBuf.nioBufferCount();
                    int writerIndex = byteBuf2.writerIndex();
                    if (nioBufferCount > 1) {
                        ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = (ReferenceCountedOpenSslEngine) sslHandler.engine;
                        try {
                            sslHandler.singleBuffer[0] = SslHandler.toByteBuffer(byteBuf2, writerIndex, byteBuf2.writableBytes());
                            unwrap = referenceCountedOpenSslEngine.unwrap(byteBuf.nioBuffers(i6, i7), sslHandler.singleBuffer);
                        } finally {
                            sslHandler.singleBuffer[0] = null;
                        }
                    } else {
                        unwrap = sslHandler.engine.unwrap(SslHandler.toByteBuffer(byteBuf, i6, i7), SslHandler.toByteBuffer(byteBuf2, writerIndex, byteBuf2.writableBytes()));
                    }
                    byteBuf2.writerIndex(writerIndex + unwrap.bytesProduced());
                    return unwrap;
                }
            };
            TCNATIVE = sslEngineType;
            SslEngineType sslEngineType2 = new SslEngineType("CONSCRYPT", true ? 1 : 0, true ? 1 : 0, cumulator) { // from class: io.netty.handler.ssl.SslHandler.SslEngineType.2
                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                boolean jdkCompatibilityMode(SSLEngine sSLEngine) {
                    return true;
                }

                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                int calculateWrapBufferCapacity(SslHandler sslHandler, int i6, int i7) {
                    return ((ConscryptAlpnSslEngine) sslHandler.engine).calculateOutNetBufSize(i6, i7);
                }

                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                SSLEngineResult unwrap(SslHandler sslHandler, ByteBuf byteBuf, int i6, int i7, ByteBuf byteBuf2) throws SSLException {
                    SSLEngineResult unwrap;
                    int nioBufferCount = byteBuf.nioBufferCount();
                    int writerIndex = byteBuf2.writerIndex();
                    if (nioBufferCount > 1) {
                        try {
                            sslHandler.singleBuffer[0] = SslHandler.toByteBuffer(byteBuf2, writerIndex, byteBuf2.writableBytes());
                            unwrap = ((ConscryptAlpnSslEngine) sslHandler.engine).unwrap(byteBuf.nioBuffers(i6, i7), sslHandler.singleBuffer);
                        } finally {
                            sslHandler.singleBuffer[0] = null;
                        }
                    } else {
                        unwrap = sslHandler.engine.unwrap(SslHandler.toByteBuffer(byteBuf, i6, i7), SslHandler.toByteBuffer(byteBuf2, writerIndex, byteBuf2.writableBytes()));
                    }
                    byteBuf2.writerIndex(writerIndex + unwrap.bytesProduced());
                    return unwrap;
                }

                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                int calculatePendingData(SslHandler sslHandler, int i6) {
                    return i6;
                }
            };
            CONSCRYPT = sslEngineType2;
            SslEngineType sslEngineType3 = new SslEngineType("JDK", 2, 0 == true ? 1 : 0, ByteToMessageDecoder.MERGE_CUMULATOR) { // from class: io.netty.handler.ssl.SslHandler.SslEngineType.3
                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                boolean jdkCompatibilityMode(SSLEngine sSLEngine) {
                    return true;
                }

                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                int calculateWrapBufferCapacity(SslHandler sslHandler, int i6, int i7) {
                    return sslHandler.engine.getSession().getPacketBufferSize();
                }

                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                SSLEngineResult unwrap(SslHandler sslHandler, ByteBuf byteBuf, int i6, int i7, ByteBuf byteBuf2) throws SSLException {
                    int position;
                    int writerIndex = byteBuf2.writerIndex();
                    ByteBuffer byteBuffer = SslHandler.toByteBuffer(byteBuf, i6, i7);
                    int position2 = byteBuffer.position();
                    SSLEngineResult unwrap = sslHandler.engine.unwrap(byteBuffer, SslHandler.toByteBuffer(byteBuf2, writerIndex, byteBuf2.writableBytes()));
                    byteBuf2.writerIndex(writerIndex + unwrap.bytesProduced());
                    if (unwrap.bytesConsumed() == 0 && (position = byteBuffer.position() - position2) != unwrap.bytesConsumed()) {
                        return new SSLEngineResult(unwrap.getStatus(), unwrap.getHandshakeStatus(), position, unwrap.bytesProduced());
                    }
                    return unwrap;
                }

                @Override // io.netty.handler.ssl.SslHandler.SslEngineType
                int calculatePendingData(SslHandler sslHandler, int i6) {
                    return i6;
                }
            };
            JDK = sslEngineType3;
            $VALUES = new SslEngineType[]{sslEngineType, sslEngineType2, sslEngineType3};
        }

        private SslEngineType(String str, int i6, boolean z5, ByteToMessageDecoder.Cumulator cumulator) {
            this.wantsDirectBuffer = z5;
            this.cumulator = cumulator;
        }

        static SslEngineType forEngine(SSLEngine sSLEngine) {
            return sSLEngine instanceof ReferenceCountedOpenSslEngine ? TCNATIVE : sSLEngine instanceof ConscryptAlpnSslEngine ? CONSCRYPT : JDK;
        }

        public static SslEngineType valueOf(String str) {
            return (SslEngineType) Enum.valueOf(SslEngineType.class, str);
        }

        public static SslEngineType[] values() {
            return (SslEngineType[]) $VALUES.clone();
        }

        int getPacketBufferSize(SslHandler sslHandler) {
            return sslHandler.engine.getSession().getPacketBufferSize();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class SslHandlerCoalescingBufferQueue extends AbstractCoalescingBufferQueue {
        @Override // io.netty.channel.AbstractCoalescingBufferQueue
        protected ByteBuf removeEmptyValue() {
            return null;
        }

        SslHandlerCoalescingBufferQueue(Channel channel, int i6) {
            super(channel, i6);
        }

        @Override // io.netty.channel.AbstractCoalescingBufferQueue
        protected ByteBuf compose(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) {
            int i6 = SslHandler.this.wrapDataSize;
            if (!(byteBuf instanceof CompositeByteBuf)) {
                return SslHandler.attemptCopyToCumulation(byteBuf, byteBuf2, i6) ? byteBuf : copyAndCompose(byteBufAllocator, byteBuf, byteBuf2);
            }
            CompositeByteBuf compositeByteBuf = (CompositeByteBuf) byteBuf;
            int numComponents = compositeByteBuf.numComponents();
            if (numComponents != 0 && SslHandler.attemptCopyToCumulation(compositeByteBuf.internalComponent(numComponents - 1), byteBuf2, i6)) {
                return compositeByteBuf;
            }
            compositeByteBuf.addComponent(true, byteBuf2);
            return compositeByteBuf;
        }

        @Override // io.netty.channel.AbstractCoalescingBufferQueue
        protected ByteBuf composeFirst(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf) {
            if (!(byteBuf instanceof CompositeByteBuf)) {
                return byteBuf;
            }
            CompositeByteBuf compositeByteBuf = (CompositeByteBuf) byteBuf;
            ByteBuf directBuffer = byteBufAllocator.directBuffer(compositeByteBuf.readableBytes());
            try {
                directBuffer.writeBytes(compositeByteBuf);
            } catch (Throwable th) {
                directBuffer.release();
                PlatformDependent.throwException(th);
            }
            compositeByteBuf.release();
            return directBuffer;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class SslTasksRunner implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final boolean inUnwrap;

        SslTasksRunner(boolean z5) {
            this.inUnwrap = z5;
        }

        private void handleException(final Throwable th) {
            if (SslHandler.this.ctx.executor().inEventLoop()) {
                SslHandler.this.processTask = false;
                safeExceptionCaught(th);
            } else {
                try {
                    SslHandler.this.ctx.executor().execute(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.SslTasksRunner.2
                        @Override // java.lang.Runnable
                        public void run() {
                            SslHandler.this.processTask = false;
                            SslTasksRunner.this.safeExceptionCaught(th);
                        }
                    });
                } catch (RejectedExecutionException unused) {
                    SslHandler.this.processTask = false;
                    SslHandler.this.ctx.fireExceptionCaught(th);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void resumeOnEventExecutor() {
            SslHandler.this.processTask = false;
            try {
                int i6 = AnonymousClass9.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SslHandler.this.engine.getHandshakeStatus().ordinal()];
                if (i6 == 1) {
                    SslHandler.this.executeDelegatedTasks(this.inUnwrap);
                    return;
                }
                if (i6 == 2) {
                    SslHandler.this.setHandshakeSuccess();
                } else if (i6 != 3) {
                    if (i6 != 4) {
                        if (i6 != 5) {
                            throw new AssertionError();
                        }
                        SslHandler sslHandler = SslHandler.this;
                        sslHandler.unwrapNonAppData(sslHandler.ctx);
                        tryDecodeAgain();
                        return;
                    }
                    try {
                        SslHandler sslHandler2 = SslHandler.this;
                        if (!sslHandler2.wrapNonAppData(sslHandler2.ctx, false) && this.inUnwrap) {
                            SslHandler sslHandler3 = SslHandler.this;
                            sslHandler3.unwrapNonAppData(sslHandler3.ctx);
                        }
                        SslHandler sslHandler4 = SslHandler.this;
                        sslHandler4.forceFlush(sslHandler4.ctx);
                        tryDecodeAgain();
                        return;
                    } catch (Throwable th) {
                        taskError(th);
                        return;
                    }
                }
                SslHandler.this.setHandshakeSuccessIfStillHandshaking();
                try {
                    SslHandler sslHandler5 = SslHandler.this;
                    sslHandler5.wrap(sslHandler5.ctx, this.inUnwrap);
                    if (this.inUnwrap) {
                        SslHandler sslHandler6 = SslHandler.this;
                        sslHandler6.unwrapNonAppData(sslHandler6.ctx);
                    }
                    SslHandler sslHandler7 = SslHandler.this;
                    sslHandler7.forceFlush(sslHandler7.ctx);
                    tryDecodeAgain();
                } catch (Throwable th2) {
                    taskError(th2);
                }
            } catch (Throwable th3) {
                safeExceptionCaught(th3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void safeExceptionCaught(Throwable th) {
            try {
                SslHandler sslHandler = SslHandler.this;
                sslHandler.exceptionCaught(sslHandler.ctx, wrapIfNeeded(th));
            } catch (Throwable th2) {
                SslHandler.this.ctx.fireExceptionCaught(th2);
            }
        }

        private void taskError(Throwable th) {
            if (!this.inUnwrap) {
                SslHandler sslHandler = SslHandler.this;
                sslHandler.setHandshakeFailure(sslHandler.ctx, th);
                SslHandler sslHandler2 = SslHandler.this;
                sslHandler2.forceFlush(sslHandler2.ctx);
                return;
            }
            try {
                SslHandler sslHandler3 = SslHandler.this;
                sslHandler3.handleUnwrapThrowable(sslHandler3.ctx, th);
            } catch (Throwable th2) {
                safeExceptionCaught(th2);
            }
        }

        private void tryDecodeAgain() {
            try {
                SslHandler sslHandler = SslHandler.this;
                sslHandler.channelRead(sslHandler.ctx, Unpooled.EMPTY_BUFFER);
            } finally {
                try {
                    SslHandler sslHandler2 = SslHandler.this;
                    sslHandler2.channelReadComplete0(sslHandler2.ctx);
                } catch (Throwable th) {
                }
            }
            SslHandler sslHandler22 = SslHandler.this;
            sslHandler22.channelReadComplete0(sslHandler22.ctx);
        }

        private Throwable wrapIfNeeded(Throwable th) {
            return !this.inUnwrap ? th : th instanceof DecoderException ? th : new DecoderException(th);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SslHandler.runAllDelegatedTasks(SslHandler.this.engine);
                SslHandler.this.ctx.executor().execute(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.SslTasksRunner.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SslTasksRunner.this.resumeOnEventExecutor();
                    }
                });
            } catch (Throwable th) {
                handleException(th);
            }
        }
    }

    public SslHandler(SSLEngine sSLEngine) {
        this(sSLEngine, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeOutbound0(ChannelPromise channelPromise) {
        this.outboundClosed = true;
        this.engine.closeOutbound();
        try {
            flush(this.ctx, channelPromise);
        } catch (Exception e6) {
            if (channelPromise.tryFailure(e6)) {
                return;
            }
            logger.warn("{} flush() raised a masked exception.", this.ctx.channel(), e6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [io.netty.channel.ChannelPromise] */
    /* JADX WARN: Type inference failed for: r7v2, types: [io.netty.channel.ChannelPromise] */
    private void closeOutboundAndChannel(ChannelHandlerContext channelHandlerContext, final ChannelPromise channelPromise, boolean z5) throws Exception {
        this.outboundClosed = true;
        this.engine.closeOutbound();
        if (!channelHandlerContext.channel().isActive()) {
            if (z5) {
                channelHandlerContext.disconnect(channelPromise);
                return;
            } else {
                channelHandlerContext.close(channelPromise);
                return;
            }
        }
        ChannelPromise newPromise = channelHandlerContext.newPromise();
        try {
            flush(channelHandlerContext, newPromise);
            if (this.closeNotify) {
                this.sslClosePromise.addListener((GenericFutureListener) new FutureListener<Channel>() { // from class: io.netty.handler.ssl.SslHandler.3
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(Future<Channel> future) {
                        channelPromise.setSuccess();
                    }
                });
            } else {
                this.closeNotify = true;
                safeClose(channelHandlerContext, newPromise, channelHandlerContext.newPromise().addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelPromiseNotifier(false, channelPromise)));
            }
        } catch (Throwable th) {
            if (this.closeNotify) {
                this.sslClosePromise.addListener((GenericFutureListener) new FutureListener<Channel>() { // from class: io.netty.handler.ssl.SslHandler.3
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(Future<Channel> future) {
                        channelPromise.setSuccess();
                    }
                });
            } else {
                this.closeNotify = true;
                safeClose(channelHandlerContext, newPromise, channelHandlerContext.newPromise().addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelPromiseNotifier(false, channelPromise)));
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeDelegatedTasks(boolean z5) {
        this.processTask = true;
        try {
            this.delegatedTaskExecutor.execute(new SslTasksRunner(z5));
        } catch (RejectedExecutionException e6) {
            this.processTask = false;
            throw e6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forceFlush(ChannelHandlerContext channelHandlerContext) {
        this.needsFlush = false;
        channelHandlerContext.flush();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHandshakeFailure(ChannelHandlerContext channelHandlerContext, Throwable th) {
        setHandshakeFailure(channelHandlerContext, th, true, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009c, code lost:
    
        if (r2 != 5) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009e, code lost:
    
        finishWrap(r13, r3, r4, r14, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a5, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c0, code lost:
    
        throw new java.lang.IllegalStateException("Unknown handshake status: " + r9.getHandshakeStatus());
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void wrap(io.netty.channel.ChannelHandlerContext r13, boolean r14) throws javax.net.ssl.SSLException {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.SslHandler.wrap(io.netty.channel.ChannelHandlerContext, boolean):void");
    }

    @Deprecated
    public ChannelFuture close() {
        return closeOutbound();
    }

    public ChannelFuture closeOutbound() {
        return closeOutbound(this.ctx.newPromise());
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        closeOutboundAndChannel(channelHandlerContext, channelPromise, true);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.startTls && !this.sentFirstMessage) {
            this.sentFirstMessage = true;
            this.pendingUnencryptedWrites.writeAndRemoveAll(channelHandlerContext);
            forceFlush(channelHandlerContext);
            startHandshakeProcessing();
            return;
        }
        if (this.processTask) {
            return;
        }
        try {
            wrapAndFlush(channelHandlerContext);
        } catch (Throwable th) {
            setHandshakeFailure(channelHandlerContext, th);
            PlatformDependent.throwException(th);
        }
    }

    public Future<Channel> renegotiate() {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext != null) {
            return renegotiate(channelHandlerContext.executor().newPromise());
        }
        throw new IllegalStateException();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.ssl.SslHandler$9, reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus;
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$Status;

        static {
            int[] iArr = new int[SSLEngineResult.Status.values().length];
            $SwitchMap$javax$net$ssl$SSLEngineResult$Status = iArr;
            try {
                iArr[SSLEngineResult.Status.BUFFER_OVERFLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[SSLEngineResult.HandshakeStatus.values().length];
            $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus = iArr2;
            try {
                iArr2[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public SslHandler(SSLEngine sSLEngine, boolean z5) {
        this(sSLEngine, z5, ImmediateExecutor.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addCloseListener(ChannelFuture channelFuture, ChannelPromise channelPromise) {
        channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelPromiseNotifier(false, channelPromise));
    }

    private ByteBuf allocateOutNetBuf(ChannelHandlerContext channelHandlerContext, int i6, int i7) {
        return allocate(channelHandlerContext, this.engineType.calculateWrapBufferCapacity(this, i6, i7));
    }

    private void applyHandshakeTimeout() {
        final Promise<Channel> promise = this.handshakePromise;
        long j6 = this.handshakeTimeoutMillis;
        if (j6 <= 0 || promise.isDone()) {
            return;
        }
        final ScheduledFuture<?> schedule = this.ctx.executor().schedule(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.5
            @Override // java.lang.Runnable
            public void run() {
                if (promise.isDone()) {
                    return;
                }
                SSLException sSLException = new SSLException("handshake timed out");
                try {
                    if (promise.tryFailure(sSLException)) {
                        SslUtils.handleHandshakeFailure(SslHandler.this.ctx, sSLException, true);
                    }
                } finally {
                    SslHandler sslHandler = SslHandler.this;
                    sslHandler.releaseAndFailAll(sslHandler.ctx, sSLException);
                }
            }
        }, j6, TimeUnit.MILLISECONDS);
        promise.addListener((GenericFutureListener<? extends Future<? super Channel>>) new FutureListener<Channel>() { // from class: io.netty.handler.ssl.SslHandler.6
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<Channel> future) throws Exception {
                schedule.cancel(false);
            }
        });
    }

    private void decodeJdkCompatible(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws NotSslRecordException {
        int i6 = this.packetLength;
        if (i6 <= 0) {
            int readableBytes = byteBuf.readableBytes();
            if (readableBytes < 5) {
                return;
            }
            int encryptedPacketLength = SslUtils.getEncryptedPacketLength(byteBuf, byteBuf.readerIndex());
            if (encryptedPacketLength == -2) {
                NotSslRecordException notSslRecordException = new NotSslRecordException("not an SSL/TLS record: " + ByteBufUtil.hexDump(byteBuf));
                byteBuf.skipBytes(byteBuf.readableBytes());
                setHandshakeFailure(channelHandlerContext, notSslRecordException);
                throw notSslRecordException;
            }
            if (encryptedPacketLength > readableBytes) {
                this.packetLength = encryptedPacketLength;
                return;
            }
            i6 = encryptedPacketLength;
        } else if (byteBuf.readableBytes() < i6) {
            return;
        }
        this.packetLength = 0;
        try {
            byteBuf.skipBytes(unwrap(channelHandlerContext, byteBuf, byteBuf.readerIndex(), i6));
        } catch (Throwable th) {
            handleUnwrapThrowable(channelHandlerContext, th);
        }
    }

    private void finishWrap(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ChannelPromise channelPromise, boolean z5, boolean z6) {
        if (byteBuf == null) {
            byteBuf = Unpooled.EMPTY_BUFFER;
        } else if (!byteBuf.isReadable()) {
            byteBuf.release();
            byteBuf = Unpooled.EMPTY_BUFFER;
        }
        if (channelPromise != null) {
            channelHandlerContext.write(byteBuf, channelPromise);
        } else {
            channelHandlerContext.write(byteBuf);
        }
        if (z5) {
            this.needsFlush = true;
        }
        if (z6) {
            readIfNeeded(channelHandlerContext);
        }
    }

    private void flushIfNeeded(ChannelHandlerContext channelHandlerContext) {
        if (this.needsFlush) {
            forceFlush(channelHandlerContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUnwrapThrowable(ChannelHandlerContext channelHandlerContext, Throwable th) {
        ChannelHandlerContext channelHandlerContext2;
        Throwable th2;
        try {
            if (this.handshakePromise.tryFailure(th)) {
                channelHandlerContext.fireUserEventTriggered((Object) new SslHandshakeCompletionEvent(th));
            }
            wrapAndFlush(channelHandlerContext);
            setHandshakeFailure(channelHandlerContext, th, true, false, true);
            th2 = th;
        } catch (SSLException e6) {
            channelHandlerContext2 = channelHandlerContext;
            th2 = th;
            try {
                logger.debug("SSLException during trying to call SSLEngine.wrap(...) because of an previous SSLException, ignoring...", (Throwable) e6);
                setHandshakeFailure(channelHandlerContext2, th2, true, false, true);
            } catch (Throwable th3) {
                th = th3;
                setHandshakeFailure(channelHandlerContext2, th2, true, false, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            channelHandlerContext2 = channelHandlerContext;
            th2 = th;
            setHandshakeFailure(channelHandlerContext2, th2, true, false, true);
            throw th;
        }
        PlatformDependent.throwException(th2);
    }

    private void handshake() {
        if (this.engine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING && !this.handshakePromise.isDone()) {
            ChannelHandlerContext channelHandlerContext = this.ctx;
            try {
                this.engine.beginHandshake();
                wrapNonAppData(channelHandlerContext, false);
            } catch (Throwable th) {
                try {
                    setHandshakeFailure(channelHandlerContext, th);
                } finally {
                    forceFlush(channelHandlerContext);
                }
            }
        }
    }

    private boolean ignoreException(Throwable th) {
        if (!(th instanceof SSLException) && (th instanceof IOException) && this.sslClosePromise.isDone()) {
            String message = th.getMessage();
            if (message != null && IGNORABLE_ERROR_MESSAGE.matcher(message).matches()) {
                return true;
            }
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                String className = stackTraceElement.getClassName();
                String methodName = stackTraceElement.getMethodName();
                if (!className.startsWith("io.netty.") && "read".equals(methodName)) {
                    if (IGNORABLE_CLASS_IN_STACK.matcher(className).matches()) {
                        return true;
                    }
                    try {
                        Class<?> loadClass = PlatformDependent.getClassLoader(getClass()).loadClass(className);
                        if (!SocketChannel.class.isAssignableFrom(loadClass) && !DatagramChannel.class.isAssignableFrom(loadClass)) {
                            if (PlatformDependent.javaVersion() >= 7 && "com.sun.nio.sctp.SctpChannel".equals(loadClass.getSuperclass().getName())) {
                                return true;
                            }
                        }
                        return true;
                    } catch (Throwable th2) {
                        logger.debug("Unexpected exception while loading class {} classname {}", getClass(), className, th2);
                    }
                }
            }
        }
        return false;
    }

    private static boolean inEventLoop(Executor executor) {
        return (executor instanceof EventExecutor) && ((EventExecutor) executor).inEventLoop();
    }

    private static IllegalStateException newPendingWritesNullException() {
        return new IllegalStateException("pendingUnencryptedWrites is null, handlerRemoved0 called?");
    }

    private void notifyClosePromise(Throwable th) {
        if (th == null) {
            if (this.sslClosePromise.trySuccess(this.ctx.channel())) {
                this.ctx.fireUserEventTriggered((Object) SslCloseCompletionEvent.SUCCESS);
            }
        } else if (this.sslClosePromise.tryFailure(th)) {
            this.ctx.fireUserEventTriggered((Object) new SslCloseCompletionEvent(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseAndFailAll(ChannelHandlerContext channelHandlerContext, Throwable th) {
        SslHandlerCoalescingBufferQueue sslHandlerCoalescingBufferQueue = this.pendingUnencryptedWrites;
        if (sslHandlerCoalescingBufferQueue != null) {
            sslHandlerCoalescingBufferQueue.releaseAndFailAll(channelHandlerContext, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renegotiateOnEventLoop(Promise<Channel> promise) {
        Promise<Channel> promise2 = this.handshakePromise;
        if (!promise2.isDone()) {
            promise2.addListener((GenericFutureListener<? extends Future<? super Channel>>) new PromiseNotifier(promise));
            return;
        }
        this.handshakePromise = promise;
        handshake();
        applyHandshakeTimeout();
    }

    private boolean runDelegatedTasks(boolean z5) {
        Executor executor = this.delegatedTaskExecutor;
        if (executor == ImmediateExecutor.INSTANCE || inEventLoop(executor)) {
            runAllDelegatedTasks(this.engine);
            return true;
        }
        executeDelegatedTasks(z5);
        return false;
    }

    private void setHandshakeFailure(ChannelHandlerContext channelHandlerContext, Throwable th, boolean z5, boolean z6, boolean z7) {
        String message;
        try {
            this.outboundClosed = true;
            this.engine.closeOutbound();
            if (z5) {
                try {
                    this.engine.closeInbound();
                } catch (SSLException e6) {
                    InternalLogger internalLogger = logger;
                    if (internalLogger.isDebugEnabled() && ((message = e6.getMessage()) == null || (!message.contains("possible truncation attack") && !message.contains("closing inbound before receiving peer's close_notify")))) {
                        internalLogger.debug("{} SSLEngine.closeInbound() raised an exception.", channelHandlerContext.channel(), e6);
                    }
                }
            }
            if (this.handshakePromise.tryFailure(th) || z7) {
                SslUtils.handleHandshakeFailure(channelHandlerContext, th, z6);
            }
        } finally {
            releaseAndFailAll(channelHandlerContext, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHandshakeFailureTransportFailure(ChannelHandlerContext channelHandlerContext, Throwable th) {
        try {
            SSLException sSLException = new SSLException("failure when writing TLS control frames", th);
            releaseAndFailAll(channelHandlerContext, sSLException);
            if (this.handshakePromise.tryFailure(sSLException)) {
                channelHandlerContext.fireUserEventTriggered((Object) new SslHandshakeCompletionEvent(sSLException));
            }
        } finally {
            channelHandlerContext.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHandshakeSuccess() {
        this.handshakePromise.trySuccess(this.ctx.channel());
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("{} HANDSHAKEN: {}", this.ctx.channel(), this.engine.getSession().getCipherSuite());
        }
        this.ctx.fireUserEventTriggered((Object) SslHandshakeCompletionEvent.SUCCESS);
        if (!this.readDuringHandshake || this.ctx.channel().config().isAutoRead()) {
            return;
        }
        this.readDuringHandshake = false;
        this.ctx.read();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setHandshakeSuccessIfStillHandshaking() {
        if (this.handshakePromise.isDone()) {
            return false;
        }
        setHandshakeSuccess();
        return true;
    }

    private void startHandshakeProcessing() {
        if (this.handshakeStarted) {
            return;
        }
        this.handshakeStarted = true;
        if (this.engine.getUseClientMode()) {
            handshake();
        }
        applyHandshakeTimeout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00aa, code lost:
    
        if (r15 != javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_UNWRAP) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ac, code lost:
    
        readIfNeeded(r20);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int unwrap(io.netty.channel.ChannelHandlerContext r20, io.netty.buffer.ByteBuf r21, int r22, int r23) throws javax.net.ssl.SSLException {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.SslHandler.unwrap(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unwrapNonAppData(ChannelHandlerContext channelHandlerContext) throws SSLException {
        unwrap(channelHandlerContext, Unpooled.EMPTY_BUFFER, 0, 0);
    }

    private void wrapAndFlush(ChannelHandlerContext channelHandlerContext) throws SSLException {
        if (this.pendingUnencryptedWrites.isEmpty()) {
            this.pendingUnencryptedWrites.add(Unpooled.EMPTY_BUFFER, channelHandlerContext.newPromise());
        }
        if (!this.handshakePromise.isDone()) {
            this.flushedBeforeHandshake = true;
        }
        try {
            wrap(channelHandlerContext, false);
        } finally {
            forceFlush(channelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!this.startTls) {
            startHandshakeProcessing();
        }
        channelHandlerContext.fireChannelActive();
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        ClosedChannelException closedChannelException = new ClosedChannelException();
        setHandshakeFailure(channelHandlerContext, closedChannelException, !this.outboundClosed, this.handshakeStarted, false);
        notifyClosePromise(closedChannelException);
        super.channelInactive(channelHandlerContext);
    }

    @Deprecated
    public ChannelFuture close(ChannelPromise channelPromise) {
        return closeOutbound(channelPromise);
    }

    public ChannelFuture closeOutbound(final ChannelPromise channelPromise) {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext.executor().inEventLoop()) {
            closeOutbound0(channelPromise);
            return channelPromise;
        }
        channelHandlerContext.executor().execute(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.1
            @Override // java.lang.Runnable
            public void run() {
                SslHandler.this.closeOutbound0(channelPromise);
            }
        });
        return channelPromise;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws SSLException {
        if (this.processTask) {
            return;
        }
        if (this.jdkCompatibilityMode) {
            decodeJdkCompatible(channelHandlerContext, byteBuf);
        } else {
            decodeNonJdkCompatible(channelHandlerContext, byteBuf);
        }
    }

    public SSLEngine engine() {
        return this.engine;
    }

    public final long getCloseNotifyFlushTimeoutMillis() {
        return this.closeNotifyFlushTimeoutMillis;
    }

    public final long getCloseNotifyReadTimeoutMillis() {
        return this.closeNotifyReadTimeoutMillis;
    }

    public long getHandshakeTimeoutMillis() {
        return this.handshakeTimeoutMillis;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
        this.pendingUnencryptedWrites = new SslHandlerCoalescingBufferQueue(channelHandlerContext.channel(), 16);
        if (channelHandlerContext.channel().isActive()) {
            startHandshakeProcessing();
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!this.pendingUnencryptedWrites.isEmpty()) {
            this.pendingUnencryptedWrites.releaseAndFailAll(channelHandlerContext, new ChannelException("Pending write on removal of SslHandler"));
        }
        this.pendingUnencryptedWrites = null;
        Object obj = this.engine;
        if (obj instanceof ReferenceCounted) {
            ((ReferenceCounted) obj).release();
        }
    }

    public Future<Channel> handshakeFuture() {
        return this.handshakePromise;
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!this.handshakePromise.isDone()) {
            this.readDuringHandshake = true;
        }
        channelHandlerContext.read();
    }

    public final void setCloseNotifyFlushTimeoutMillis(long j6) {
        if (j6 >= 0) {
            this.closeNotifyFlushTimeoutMillis = j6;
            return;
        }
        throw new IllegalArgumentException("closeNotifyFlushTimeoutMillis: " + j6 + " (expected: >= 0)");
    }

    public final void setCloseNotifyReadTimeoutMillis(long j6) {
        if (j6 >= 0) {
            this.closeNotifyReadTimeoutMillis = j6;
            return;
        }
        throw new IllegalArgumentException("closeNotifyReadTimeoutMillis: " + j6 + " (expected: >= 0)");
    }

    public void setHandshakeTimeout(long j6, TimeUnit timeUnit) {
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        setHandshakeTimeoutMillis(timeUnit.toMillis(j6));
    }

    public void setHandshakeTimeoutMillis(long j6) {
        if (j6 >= 0) {
            this.handshakeTimeoutMillis = j6;
            return;
        }
        throw new IllegalArgumentException("handshakeTimeoutMillis: " + j6 + " (expected: >= 0)");
    }

    public final void setWrapDataSize(int i6) {
        this.wrapDataSize = i6;
    }

    public Future<Channel> sslCloseFuture() {
        return this.sslClosePromise;
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (!(obj instanceof ByteBuf)) {
            UnsupportedMessageTypeException unsupportedMessageTypeException = new UnsupportedMessageTypeException(obj, (Class<?>[]) new Class[]{ByteBuf.class});
            ReferenceCountUtil.safeRelease(obj);
            channelPromise.setFailure((Throwable) unsupportedMessageTypeException);
        } else {
            SslHandlerCoalescingBufferQueue sslHandlerCoalescingBufferQueue = this.pendingUnencryptedWrites;
            if (sslHandlerCoalescingBufferQueue != null) {
                sslHandlerCoalescingBufferQueue.add((ByteBuf) obj, channelPromise);
            } else {
                ReferenceCountUtil.safeRelease(obj);
                channelPromise.setFailure((Throwable) newPendingWritesNullException());
            }
        }
    }

    public SslHandler(SSLEngine sSLEngine, Executor executor) {
        this(sSLEngine, false, executor);
    }

    private ByteBuf allocate(ChannelHandlerContext channelHandlerContext, int i6) {
        ByteBufAllocator alloc = channelHandlerContext.alloc();
        if (this.engineType.wantsDirectBuffer) {
            return alloc.directBuffer(i6);
        }
        return alloc.buffer(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean attemptCopyToCumulation(ByteBuf byteBuf, ByteBuf byteBuf2, int i6) {
        int readableBytes = byteBuf2.readableBytes();
        int capacity = byteBuf.capacity();
        if (i6 - byteBuf.readableBytes() < readableBytes || ((!byteBuf.isWritable(readableBytes) || capacity < i6) && (capacity >= i6 || !ByteBufUtil.ensureWritableSuccess(byteBuf.ensureWritable(readableBytes, false))))) {
            return false;
        }
        byteBuf.writeBytes(byteBuf2);
        byteBuf2.release();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void channelReadComplete0(ChannelHandlerContext channelHandlerContext) {
        discardSomeReadBytes();
        flushIfNeeded(channelHandlerContext);
        readIfNeeded(channelHandlerContext);
        this.firedChannelRead = false;
        channelHandlerContext.fireChannelReadComplete();
    }

    private void decodeNonJdkCompatible(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        try {
            byteBuf.skipBytes(unwrap(channelHandlerContext, byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes()));
        } catch (Throwable th) {
            handleUnwrapThrowable(channelHandlerContext, th);
        }
    }

    public static boolean isEncrypted(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() >= 5) {
            if (SslUtils.getEncryptedPacketLength(byteBuf, byteBuf.readerIndex()) != -2) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("buffer must have at least 5 readable bytes");
    }

    private void readIfNeeded(ChannelHandlerContext channelHandlerContext) {
        if (!channelHandlerContext.channel().config().isAutoRead()) {
            if (!this.firedChannelRead || !this.handshakePromise.isDone()) {
                channelHandlerContext.read();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void runAllDelegatedTasks(SSLEngine sSLEngine) {
        while (true) {
            Runnable delegatedTask = sSLEngine.getDelegatedTask();
            if (delegatedTask == null) {
                return;
            } else {
                delegatedTask.run();
            }
        }
    }

    private void safeClose(final ChannelHandlerContext channelHandlerContext, final ChannelFuture channelFuture, final ChannelPromise channelPromise) {
        if (!channelHandlerContext.channel().isActive()) {
            channelHandlerContext.close(channelPromise);
            return;
        }
        final ScheduledFuture<?> scheduledFuture = null;
        if (!channelFuture.isDone()) {
            long j6 = this.closeNotifyFlushTimeoutMillis;
            if (j6 > 0) {
                scheduledFuture = channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (channelFuture.isDone()) {
                            return;
                        }
                        SslHandler.logger.warn("{} Last write attempt timed out; force-closing the connection.", channelHandlerContext.channel());
                        ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
                        SslHandler.addCloseListener(channelHandlerContext2.close(channelHandlerContext2.newPromise()), channelPromise);
                    }
                }, j6, TimeUnit.MILLISECONDS);
            }
        }
        channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.ssl.SslHandler.8
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture2) throws Exception {
                java.util.concurrent.ScheduledFuture scheduledFuture2 = scheduledFuture;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(false);
                }
                final long j7 = SslHandler.this.closeNotifyReadTimeoutMillis;
                if (j7 <= 0) {
                    ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
                    SslHandler.addCloseListener(channelHandlerContext2.close(channelHandlerContext2.newPromise()), channelPromise);
                } else {
                    final ScheduledFuture<?> schedule = !SslHandler.this.sslClosePromise.isDone() ? channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SslHandler.this.sslClosePromise.isDone()) {
                                return;
                            }
                            SslHandler.logger.debug("{} did not receive close_notify in {}ms; force-closing the connection.", channelHandlerContext.channel(), Long.valueOf(j7));
                            ChannelHandlerContext channelHandlerContext3 = channelHandlerContext;
                            SslHandler.addCloseListener(channelHandlerContext3.close(channelHandlerContext3.newPromise()), channelPromise);
                        }
                    }, j7, TimeUnit.MILLISECONDS) : null;
                    SslHandler.this.sslClosePromise.addListener((GenericFutureListener) new FutureListener<Channel>() { // from class: io.netty.handler.ssl.SslHandler.8.2
                        @Override // io.netty.util.concurrent.GenericFutureListener
                        public void operationComplete(Future<Channel> future) throws Exception {
                            java.util.concurrent.ScheduledFuture scheduledFuture3 = schedule;
                            if (scheduledFuture3 != null) {
                                scheduledFuture3.cancel(false);
                            }
                            ChannelHandlerContext channelHandlerContext3 = channelHandlerContext;
                            SslHandler.addCloseListener(channelHandlerContext3.close(channelHandlerContext3.newPromise()), channelPromise);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteBuffer toByteBuffer(ByteBuf byteBuf, int i6, int i7) {
        if (byteBuf.nioBufferCount() == 1) {
            return byteBuf.internalNioBuffer(i6, i7);
        }
        return byteBuf.nioBuffer(i6, i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wrapNonAppData(final ChannelHandlerContext channelHandlerContext, boolean z5) throws SSLException {
        ByteBufAllocator alloc = channelHandlerContext.alloc();
        ByteBuf byteBuf = null;
        while (!channelHandlerContext.isRemoved()) {
            try {
                if (byteBuf == null) {
                    byteBuf = allocateOutNetBuf(channelHandlerContext, 2048, 1);
                }
                SSLEngineResult wrap = wrap(alloc, this.engine, Unpooled.EMPTY_BUFFER, byteBuf);
                if (wrap.bytesProduced() > 0) {
                    channelHandlerContext.write(byteBuf).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.ssl.SslHandler.2
                        @Override // io.netty.util.concurrent.GenericFutureListener
                        public void operationComplete(ChannelFuture channelFuture) {
                            Throwable cause = channelFuture.cause();
                            if (cause != null) {
                                SslHandler.this.setHandshakeFailureTransportFailure(channelHandlerContext, cause);
                            }
                        }
                    });
                    if (z5) {
                        this.needsFlush = true;
                    }
                    byteBuf = null;
                }
                SSLEngineResult.HandshakeStatus handshakeStatus = wrap.getHandshakeStatus();
                int i6 = AnonymousClass9.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[handshakeStatus.ordinal()];
                if (i6 != 1) {
                    if (i6 != 2) {
                        if (i6 != 3) {
                            if (i6 != 4) {
                                if (i6 == 5) {
                                    if (z5) {
                                        if (byteBuf != null) {
                                            byteBuf.release();
                                        }
                                        return false;
                                    }
                                    unwrapNonAppData(channelHandlerContext);
                                } else {
                                    throw new IllegalStateException("Unknown handshake status: " + wrap.getHandshakeStatus());
                                }
                            }
                        } else {
                            setHandshakeSuccessIfStillHandshaking();
                            if (!z5) {
                                unwrapNonAppData(channelHandlerContext);
                            }
                            if (byteBuf != null) {
                                byteBuf.release();
                            }
                            return true;
                        }
                    } else {
                        setHandshakeSuccess();
                        if (byteBuf != null) {
                            byteBuf.release();
                        }
                        return false;
                    }
                } else if (!runDelegatedTasks(z5)) {
                }
                if ((wrap.bytesProduced() == 0 && handshakeStatus != SSLEngineResult.HandshakeStatus.NEED_TASK) || (wrap.bytesConsumed() == 0 && wrap.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING)) {
                    break;
                }
            } finally {
                if (byteBuf != null) {
                    byteBuf.release();
                }
            }
        }
        return false;
    }

    public String applicationProtocol() {
        Object engine = engine();
        if (!(engine instanceof ApplicationProtocolAccessor)) {
            return null;
        }
        return ((ApplicationProtocolAccessor) engine).getNegotiatedApplicationProtocol();
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.bind(socketAddress, channelPromise);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelReadComplete0(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        closeOutboundAndChannel(channelHandlerContext, channelPromise, false);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.deregister(channelPromise);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        if (ignoreException(th)) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("{} Swallowing a harmless 'connection reset by peer / broken pipe' error that occurred while writing close_notify in response to the peer's close_notify", channelHandlerContext.channel(), th);
            }
            if (channelHandlerContext.channel().isActive()) {
                channelHandlerContext.close();
                return;
            }
            return;
        }
        channelHandlerContext.fireExceptionCaught(th);
    }

    @Deprecated
    public long getCloseNotifyTimeoutMillis() {
        return getCloseNotifyFlushTimeoutMillis();
    }

    public final void setCloseNotifyFlushTimeout(long j6, TimeUnit timeUnit) {
        setCloseNotifyFlushTimeoutMillis(timeUnit.toMillis(j6));
    }

    public final void setCloseNotifyReadTimeout(long j6, TimeUnit timeUnit) {
        setCloseNotifyReadTimeoutMillis(timeUnit.toMillis(j6));
    }

    @Deprecated
    public void setCloseNotifyTimeout(long j6, TimeUnit timeUnit) {
        setCloseNotifyFlushTimeout(j6, timeUnit);
    }

    @Deprecated
    public void setCloseNotifyTimeoutMillis(long j6) {
        setCloseNotifyFlushTimeoutMillis(j6);
    }

    public SslHandler(SSLEngine sSLEngine, boolean z5, Executor executor) {
        this.singleBuffer = new ByteBuffer[1];
        this.handshakePromise = new LazyChannelPromise();
        this.sslClosePromise = new LazyChannelPromise();
        this.handshakeTimeoutMillis = 10000L;
        this.closeNotifyFlushTimeoutMillis = 3000L;
        this.wrapDataSize = 16384;
        if (sSLEngine == null) {
            throw new NullPointerException("engine");
        }
        if (executor != null) {
            this.engine = sSLEngine;
            SslEngineType forEngine = SslEngineType.forEngine(sSLEngine);
            this.engineType = forEngine;
            this.delegatedTaskExecutor = executor;
            this.startTls = z5;
            this.jdkCompatibilityMode = forEngine.jdkCompatibilityMode(sSLEngine);
            setCumulator(forEngine.cumulator);
            return;
        }
        throw new NullPointerException("delegatedTaskExecutor");
    }

    public Future<Channel> renegotiate(final Promise<Channel> promise) {
        if (promise != null) {
            ChannelHandlerContext channelHandlerContext = this.ctx;
            if (channelHandlerContext != null) {
                EventExecutor executor = channelHandlerContext.executor();
                if (!executor.inEventLoop()) {
                    executor.execute(new Runnable() { // from class: io.netty.handler.ssl.SslHandler.4
                        @Override // java.lang.Runnable
                        public void run() {
                            SslHandler.this.renegotiateOnEventLoop(promise);
                        }
                    });
                    return promise;
                }
                renegotiateOnEventLoop(promise);
                return promise;
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("promise");
    }

    private void flush(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        SslHandlerCoalescingBufferQueue sslHandlerCoalescingBufferQueue = this.pendingUnencryptedWrites;
        if (sslHandlerCoalescingBufferQueue != null) {
            sslHandlerCoalescingBufferQueue.add(Unpooled.EMPTY_BUFFER, channelPromise);
        } else {
            channelPromise.setFailure((Throwable) newPendingWritesNullException());
        }
        flush(channelHandlerContext);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0086 A[Catch: all -> 0x002c, LOOP:0: B:12:0x004b->B:14:0x0086, LOOP_END, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x002c, blocks: (B:10:0x001c, B:12:0x004b, B:14:0x0086), top: B:9:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007c A[EDGE_INSN: B:15:0x007c->B:16:0x007c BREAK  A[LOOP:0: B:12:0x004b->B:14:0x0086], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private javax.net.ssl.SSLEngineResult wrap(io.netty.buffer.ByteBufAllocator r8, javax.net.ssl.SSLEngine r9, io.netty.buffer.ByteBuf r10, io.netty.buffer.ByteBuf r11) throws javax.net.ssl.SSLException {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            int r2 = r10.readerIndex()     // Catch: java.lang.Throwable -> L2e
            int r3 = r10.readableBytes()     // Catch: java.lang.Throwable -> L2e
            boolean r4 = r10.isDirect()     // Catch: java.lang.Throwable -> L2e
            r5 = 1
            if (r4 != 0) goto L31
            io.netty.handler.ssl.SslHandler$SslEngineType r4 = r7.engineType     // Catch: java.lang.Throwable -> L2e
            boolean r4 = r4.wantsDirectBuffer     // Catch: java.lang.Throwable -> L2e
            if (r4 != 0) goto L18
            goto L31
        L18:
            io.netty.buffer.ByteBuf r8 = r8.directBuffer(r3)     // Catch: java.lang.Throwable -> L2e
            r8.writeBytes(r10, r2, r3)     // Catch: java.lang.Throwable -> L2c
            java.nio.ByteBuffer[] r2 = r7.singleBuffer     // Catch: java.lang.Throwable -> L2c
            int r4 = r8.readerIndex()     // Catch: java.lang.Throwable -> L2c
            java.nio.ByteBuffer r3 = r8.internalNioBuffer(r4, r3)     // Catch: java.lang.Throwable -> L2c
            r2[r0] = r3     // Catch: java.lang.Throwable -> L2c
            goto L4b
        L2c:
            r9 = move-exception
            goto L92
        L2e:
            r9 = move-exception
            r8 = r1
            goto L92
        L31:
            boolean r8 = r10 instanceof io.netty.buffer.CompositeByteBuf     // Catch: java.lang.Throwable -> L2e
            if (r8 != 0) goto L46
            int r8 = r10.nioBufferCount()     // Catch: java.lang.Throwable -> L2e
            if (r8 != r5) goto L46
            java.nio.ByteBuffer[] r8 = r7.singleBuffer     // Catch: java.lang.Throwable -> L2e
            java.nio.ByteBuffer r2 = r10.internalNioBuffer(r2, r3)     // Catch: java.lang.Throwable -> L2e
            r8[r0] = r2     // Catch: java.lang.Throwable -> L2e
            r2 = r8
        L44:
            r8 = r1
            goto L4b
        L46:
            java.nio.ByteBuffer[] r2 = r10.nioBuffers()     // Catch: java.lang.Throwable -> L2e
            goto L44
        L4b:
            int r3 = r11.writerIndex()     // Catch: java.lang.Throwable -> L2c
            int r4 = r11.writableBytes()     // Catch: java.lang.Throwable -> L2c
            java.nio.ByteBuffer r3 = r11.nioBuffer(r3, r4)     // Catch: java.lang.Throwable -> L2c
            javax.net.ssl.SSLEngineResult r3 = r9.wrap(r2, r3)     // Catch: java.lang.Throwable -> L2c
            int r4 = r3.bytesConsumed()     // Catch: java.lang.Throwable -> L2c
            r10.skipBytes(r4)     // Catch: java.lang.Throwable -> L2c
            int r4 = r11.writerIndex()     // Catch: java.lang.Throwable -> L2c
            int r6 = r3.bytesProduced()     // Catch: java.lang.Throwable -> L2c
            int r4 = r4 + r6
            r11.writerIndex(r4)     // Catch: java.lang.Throwable -> L2c
            int[] r4 = io.netty.handler.ssl.SslHandler.AnonymousClass9.$SwitchMap$javax$net$ssl$SSLEngineResult$Status     // Catch: java.lang.Throwable -> L2c
            javax.net.ssl.SSLEngineResult$Status r6 = r3.getStatus()     // Catch: java.lang.Throwable -> L2c
            int r6 = r6.ordinal()     // Catch: java.lang.Throwable -> L2c
            r4 = r4[r6]     // Catch: java.lang.Throwable -> L2c
            if (r4 == r5) goto L86
            java.nio.ByteBuffer[] r9 = r7.singleBuffer
            r9[r0] = r1
            if (r8 == 0) goto L85
            r8.release()
        L85:
            return r3
        L86:
            javax.net.ssl.SSLSession r3 = r9.getSession()     // Catch: java.lang.Throwable -> L2c
            int r3 = r3.getPacketBufferSize()     // Catch: java.lang.Throwable -> L2c
            r11.ensureWritable(r3)     // Catch: java.lang.Throwable -> L2c
            goto L4b
        L92:
            java.nio.ByteBuffer[] r10 = r7.singleBuffer
            r10[r0] = r1
            if (r8 == 0) goto L9b
            r8.release()
        L9b:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.SslHandler.wrap(io.netty.buffer.ByteBufAllocator, javax.net.ssl.SSLEngine, io.netty.buffer.ByteBuf, io.netty.buffer.ByteBuf):javax.net.ssl.SSLEngineResult");
    }
}
