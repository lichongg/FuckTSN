package io.netty.bootstrap;

import io.netty.bootstrap.AbstractBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ReflectiveChannelFactory;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractBootstrap<B extends AbstractBootstrap<B, C>, C extends Channel> implements Cloneable {
    private final Map<AttributeKey<?>, Object> attrs;
    private volatile ChannelFactory<? extends C> channelFactory;
    volatile EventLoopGroup group;
    private volatile ChannelHandler handler;
    private volatile SocketAddress localAddress;
    private final Map<ChannelOption<?>, Object> options;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class PendingRegistrationPromise extends DefaultChannelPromise {
        private volatile boolean registered;

        void registered() {
            this.registered = true;
        }

        @Override // io.netty.channel.DefaultChannelPromise, io.netty.util.concurrent.DefaultPromise
        protected EventExecutor executor() {
            return this.registered ? super.executor() : GlobalEventExecutor.INSTANCE;
        }

        PendingRegistrationPromise(Channel channel) {
            super(channel);
        }
    }

    AbstractBootstrap() {
        this.options = new LinkedHashMap();
        this.attrs = new LinkedHashMap();
    }

    static <K, V> Map<K, V> copiedMap(Map<K, V> map) {
        synchronized (map) {
            try {
                if (map.isEmpty()) {
                    return Collections.EMPTY_MAP;
                }
                return Collections.unmodifiableMap(new LinkedHashMap(map));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static void setChannelOptions(Channel channel, Map<ChannelOption<?>, Object> map, InternalLogger internalLogger) {
        for (Map.Entry<ChannelOption<?>, Object> entry : map.entrySet()) {
            setChannelOption(channel, entry.getKey(), entry.getValue(), internalLogger);
        }
    }

    public ChannelFuture bind() {
        validate();
        SocketAddress socketAddress = this.localAddress;
        if (socketAddress != null) {
            return doBind(socketAddress);
        }
        throw new IllegalStateException("localAddress not set");
    }

    @Deprecated
    public B channelFactory(ChannelFactory<? extends C> channelFactory) {
        ObjectUtil.checkNotNull(channelFactory, "channelFactory");
        if (this.channelFactory != null) {
            throw new IllegalStateException("channelFactory set already");
        }
        this.channelFactory = channelFactory;
        return self();
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public abstract B mo127clone();

    public abstract AbstractBootstrapConfig<B, C> config();

    public B group(EventLoopGroup eventLoopGroup) {
        ObjectUtil.checkNotNull(eventLoopGroup, "group");
        if (this.group != null) {
            throw new IllegalStateException("group set already");
        }
        this.group = eventLoopGroup;
        return self();
    }

    public B handler(ChannelHandler channelHandler) {
        this.handler = (ChannelHandler) ObjectUtil.checkNotNull(channelHandler, "handler");
        return self();
    }

    abstract void init(Channel channel) throws Exception;

    final ChannelFuture initAndRegister() {
        C c6 = null;
        try {
            c6 = this.channelFactory.newChannel();
            init(c6);
            ChannelFuture register = config().group().register(c6);
            if (register.cause() != null) {
                if (c6.isRegistered()) {
                    c6.close();
                    return register;
                }
                c6.unsafe().closeForcibly();
            }
            return register;
        } catch (Throwable th) {
            if (c6 == null) {
                return new DefaultChannelPromise(new FailedChannel(), GlobalEventExecutor.INSTANCE).setFailure(th);
            }
            c6.unsafe().closeForcibly();
            return new DefaultChannelPromise(c6, GlobalEventExecutor.INSTANCE).setFailure(th);
        }
    }

    public B localAddress(SocketAddress socketAddress) {
        this.localAddress = socketAddress;
        return self();
    }

    public <T> B attr(AttributeKey<T> attributeKey, T t5) {
        ObjectUtil.checkNotNull(attributeKey, "key");
        if (t5 == null) {
            synchronized (this.attrs) {
                this.attrs.remove(attributeKey);
            }
        } else {
            synchronized (this.attrs) {
                this.attrs.put(attributeKey, t5);
            }
        }
        return self();
    }

    final Map<AttributeKey<?>, Object> attrs() {
        return copiedMap(this.attrs);
    }

    final Map<AttributeKey<?>, Object> attrs0() {
        return this.attrs;
    }

    public B channel(Class<? extends C> cls) {
        return channelFactory((io.netty.channel.ChannelFactory) new ReflectiveChannelFactory((Class) ObjectUtil.checkNotNull(cls, "channelClass")));
    }

    public <T> B option(ChannelOption<T> channelOption, T t5) {
        ObjectUtil.checkNotNull(channelOption, "option");
        if (t5 == null) {
            synchronized (this.options) {
                this.options.remove(channelOption);
            }
        } else {
            synchronized (this.options) {
                this.options.put(channelOption, t5);
            }
        }
        return self();
    }

    final Map<ChannelOption<?>, Object> options() {
        return copiedMap(this.options);
    }

    final Map<ChannelOption<?>, Object> options0() {
        return this.options;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + '(' + config() + ')';
    }

    public B validate() {
        if (this.group == null) {
            throw new IllegalStateException("group not set");
        }
        if (this.channelFactory != null) {
            return self();
        }
        throw new IllegalStateException("channel or channelFactory not set");
    }

    private ChannelFuture doBind(final SocketAddress socketAddress) {
        final ChannelFuture initAndRegister = initAndRegister();
        final Channel channel = initAndRegister.channel();
        if (initAndRegister.cause() != null) {
            return initAndRegister;
        }
        if (initAndRegister.isDone()) {
            ChannelPromise newPromise = channel.newPromise();
            doBind0(initAndRegister, channel, socketAddress, newPromise);
            return newPromise;
        }
        final PendingRegistrationPromise pendingRegistrationPromise = new PendingRegistrationPromise(channel);
        initAndRegister.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.bootstrap.AbstractBootstrap.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                Throwable cause = channelFuture.cause();
                if (cause != null) {
                    pendingRegistrationPromise.setFailure(cause);
                } else {
                    pendingRegistrationPromise.registered();
                    AbstractBootstrap.doBind0(initAndRegister, channel, socketAddress, pendingRegistrationPromise);
                }
            }
        });
        return pendingRegistrationPromise;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doBind0(final ChannelFuture channelFuture, final Channel channel, final SocketAddress socketAddress, final ChannelPromise channelPromise) {
        channel.eventLoop().execute(new Runnable() { // from class: io.netty.bootstrap.AbstractBootstrap.2
            @Override // java.lang.Runnable
            public void run() {
                if (ChannelFuture.this.isSuccess()) {
                    channel.bind(socketAddress, channelPromise).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE_ON_FAILURE);
                } else {
                    channelPromise.setFailure(ChannelFuture.this.cause());
                }
            }
        });
    }

    private static void setChannelOption(Channel channel, ChannelOption<?> channelOption, Object obj, InternalLogger internalLogger) {
        try {
            if (!channel.config().setOption(channelOption, obj)) {
                internalLogger.warn("Unknown channel option '{}' for channel '{}'", channelOption, channel);
            }
        } catch (Throwable th) {
            internalLogger.warn("Failed to set channel option '{}' with value '{}' for channel '{}'", channelOption, obj, channel, th);
        }
    }

    static void setChannelOptions(Channel channel, Map.Entry<ChannelOption<?>, Object>[] entryArr, InternalLogger internalLogger) {
        for (Map.Entry<ChannelOption<?>, Object> entry : entryArr) {
            setChannelOption(channel, entry.getKey(), entry.getValue(), internalLogger);
        }
    }

    final ChannelHandler handler() {
        return this.handler;
    }

    public B localAddress(int i6) {
        return localAddress(new InetSocketAddress(i6));
    }

    public ChannelFuture register() {
        validate();
        return initAndRegister();
    }

    AbstractBootstrap(AbstractBootstrap<B, C> abstractBootstrap) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.options = linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        this.attrs = linkedHashMap2;
        this.group = abstractBootstrap.group;
        this.channelFactory = abstractBootstrap.channelFactory;
        this.handler = abstractBootstrap.handler;
        this.localAddress = abstractBootstrap.localAddress;
        synchronized (abstractBootstrap.options) {
            linkedHashMap.putAll(abstractBootstrap.options);
        }
        synchronized (abstractBootstrap.attrs) {
            linkedHashMap2.putAll(abstractBootstrap.attrs);
        }
    }

    public B localAddress(String str, int i6) {
        return localAddress(SocketUtils.socketAddress(str, i6));
    }

    public ChannelFuture bind(int i6) {
        return bind(new InetSocketAddress(i6));
    }

    public B localAddress(InetAddress inetAddress, int i6) {
        return localAddress(new InetSocketAddress(inetAddress, i6));
    }

    public ChannelFuture bind(String str, int i6) {
        return bind(SocketUtils.socketAddress(str, i6));
    }

    public B channelFactory(io.netty.channel.ChannelFactory<? extends C> channelFactory) {
        return channelFactory((ChannelFactory) channelFactory);
    }

    @Deprecated
    public final EventLoopGroup group() {
        return this.group;
    }

    final SocketAddress localAddress() {
        return this.localAddress;
    }

    public ChannelFuture bind(InetAddress inetAddress, int i6) {
        return bind(new InetSocketAddress(inetAddress, i6));
    }

    final ChannelFactory<? extends C> channelFactory() {
        return this.channelFactory;
    }

    public ChannelFuture bind(SocketAddress socketAddress) {
        validate();
        return doBind((SocketAddress) ObjectUtil.checkNotNull(socketAddress, "localAddress"));
    }

    private B self() {
        return this;
    }
}
