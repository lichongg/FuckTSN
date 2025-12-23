package io.netty.bootstrap;

import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ServerBootstrap extends AbstractBootstrap<ServerBootstrap, ServerChannel> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ServerBootstrap.class);
    private final Map<AttributeKey<?>, Object> childAttrs;
    private volatile EventLoopGroup childGroup;
    private volatile ChannelHandler childHandler;
    private final Map<ChannelOption<?>, Object> childOptions;
    private final ServerBootstrapConfig config;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ServerBootstrapAcceptor extends ChannelInboundHandlerAdapter {
        private final Map.Entry<AttributeKey<?>, Object>[] childAttrs;
        private final EventLoopGroup childGroup;
        private final ChannelHandler childHandler;
        private final Map.Entry<ChannelOption<?>, Object>[] childOptions;
        private final Runnable enableAutoReadTask;

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
            final Channel channel = (Channel) obj;
            channel.pipeline().addLast(this.childHandler);
            AbstractBootstrap.setChannelOptions(channel, this.childOptions, ServerBootstrap.logger);
            for (Map.Entry<AttributeKey<?>, Object> entry : this.childAttrs) {
                channel.attr(entry.getKey()).set(entry.getValue());
            }
            try {
                this.childGroup.register(channel).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.bootstrap.ServerBootstrap.ServerBootstrapAcceptor.2
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        if (channelFuture.isSuccess()) {
                            return;
                        }
                        ServerBootstrapAcceptor.forceClose(channel, channelFuture.cause());
                    }
                });
            } catch (Throwable th) {
                forceClose(channel, th);
            }
        }

        ServerBootstrapAcceptor(final Channel channel, EventLoopGroup eventLoopGroup, ChannelHandler channelHandler, Map.Entry<ChannelOption<?>, Object>[] entryArr, Map.Entry<AttributeKey<?>, Object>[] entryArr2) {
            this.childGroup = eventLoopGroup;
            this.childHandler = channelHandler;
            this.childOptions = entryArr;
            this.childAttrs = entryArr2;
            this.enableAutoReadTask = new Runnable() { // from class: io.netty.bootstrap.ServerBootstrap.ServerBootstrapAcceptor.1
                @Override // java.lang.Runnable
                public void run() {
                    channel.config().setAutoRead(true);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void forceClose(Channel channel, Throwable th) {
            channel.unsafe().closeForcibly();
            ServerBootstrap.logger.warn("Failed to register an accepted channel: {}", channel, th);
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
            ChannelConfig config = channelHandlerContext.channel().config();
            if (config.isAutoRead()) {
                config.setAutoRead(false);
                channelHandlerContext.channel().eventLoop().schedule(this.enableAutoReadTask, 1L, TimeUnit.SECONDS);
            }
            channelHandlerContext.fireExceptionCaught(th);
        }
    }

    public ServerBootstrap() {
        this.childOptions = new LinkedHashMap();
        this.childAttrs = new LinkedHashMap();
        this.config = new ServerBootstrapConfig(this);
    }

    public ServerBootstrap childHandler(ChannelHandler channelHandler) {
        this.childHandler = (ChannelHandler) ObjectUtil.checkNotNull(channelHandler, "childHandler");
        return this;
    }

    private static Map.Entry<AttributeKey<?>, Object>[] newAttrArray(int i6) {
        return new Map.Entry[i6];
    }

    private static Map.Entry<ChannelOption<?>, Object>[] newOptionArray(int i6) {
        return new Map.Entry[i6];
    }

    public <T> ServerBootstrap childAttr(AttributeKey<T> attributeKey, T t5) {
        ObjectUtil.checkNotNull(attributeKey, "childKey");
        if (t5 == null) {
            this.childAttrs.remove(attributeKey);
            return this;
        }
        this.childAttrs.put(attributeKey, t5);
        return this;
    }

    final Map<AttributeKey<?>, Object> childAttrs() {
        return AbstractBootstrap.copiedMap(this.childAttrs);
    }

    @Deprecated
    public EventLoopGroup childGroup() {
        return this.childGroup;
    }

    final ChannelHandler childHandler() {
        return this.childHandler;
    }

    public <T> ServerBootstrap childOption(ChannelOption<T> channelOption, T t5) {
        ObjectUtil.checkNotNull(channelOption, "childOption");
        if (t5 == null) {
            synchronized (this.childOptions) {
                this.childOptions.remove(channelOption);
            }
            return this;
        }
        synchronized (this.childOptions) {
            this.childOptions.put(channelOption, t5);
        }
        return this;
    }

    final Map<ChannelOption<?>, Object> childOptions() {
        return AbstractBootstrap.copiedMap(this.childOptions);
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    public final AbstractBootstrapConfig<ServerBootstrap, ServerChannel> config() {
        return this.config;
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    public ServerBootstrap group(EventLoopGroup eventLoopGroup) {
        return group(eventLoopGroup, eventLoopGroup);
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    public ServerBootstrap validate() {
        super.validate();
        if (this.childHandler == null) {
            throw new IllegalStateException("childHandler not set");
        }
        if (this.childGroup == null) {
            logger.warn("childGroup is not set. Using parentGroup instead.");
            this.childGroup = this.config.group();
        }
        return this;
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    /* renamed from: clone, reason: avoid collision after fix types in other method */
    public ServerBootstrap mo127clone() {
        return new ServerBootstrap(this);
    }

    public ServerBootstrap group(EventLoopGroup eventLoopGroup, EventLoopGroup eventLoopGroup2) {
        super.group(eventLoopGroup);
        ObjectUtil.checkNotNull(eventLoopGroup2, "childGroup");
        if (this.childGroup == null) {
            this.childGroup = eventLoopGroup2;
            return this;
        }
        throw new IllegalStateException("childGroup set already");
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    void init(Channel channel) throws Exception {
        final Map.Entry[] entryArr;
        final Map.Entry[] entryArr2;
        Map<ChannelOption<?>, Object> options0 = options0();
        synchronized (options0) {
            AbstractBootstrap.setChannelOptions(channel, options0, logger);
        }
        Map<AttributeKey<?>, Object> attrs0 = attrs0();
        synchronized (attrs0) {
            try {
                for (Map.Entry<AttributeKey<?>, Object> entry : attrs0.entrySet()) {
                    channel.attr(entry.getKey()).set(entry.getValue());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ChannelPipeline pipeline = channel.pipeline();
        final EventLoopGroup eventLoopGroup = this.childGroup;
        final ChannelHandler channelHandler = this.childHandler;
        synchronized (this.childOptions) {
            entryArr = (Map.Entry[]) this.childOptions.entrySet().toArray(newOptionArray(0));
        }
        synchronized (this.childAttrs) {
            entryArr2 = (Map.Entry[]) this.childAttrs.entrySet().toArray(newAttrArray(0));
        }
        pipeline.addLast(new ChannelInitializer<Channel>() { // from class: io.netty.bootstrap.ServerBootstrap.1
            @Override // io.netty.channel.ChannelInitializer
            public void initChannel(final Channel channel2) throws Exception {
                final ChannelPipeline pipeline2 = channel2.pipeline();
                ChannelHandler handler = ServerBootstrap.this.config.handler();
                if (handler != null) {
                    pipeline2.addLast(handler);
                }
                channel2.eventLoop().execute(new Runnable() { // from class: io.netty.bootstrap.ServerBootstrap.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChannelPipeline channelPipeline = pipeline2;
                        Channel channel3 = channel2;
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        channelPipeline.addLast(new ServerBootstrapAcceptor(channel3, eventLoopGroup, channelHandler, entryArr, entryArr2));
                    }
                });
            }
        });
    }

    private ServerBootstrap(ServerBootstrap serverBootstrap) {
        super(serverBootstrap);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.childOptions = linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        this.childAttrs = linkedHashMap2;
        this.config = new ServerBootstrapConfig(this);
        this.childGroup = serverBootstrap.childGroup;
        this.childHandler = serverBootstrap.childHandler;
        synchronized (serverBootstrap.childOptions) {
            linkedHashMap.putAll(serverBootstrap.childOptions);
        }
        synchronized (serverBootstrap.childAttrs) {
            linkedHashMap2.putAll(serverBootstrap.childAttrs);
        }
    }
}
