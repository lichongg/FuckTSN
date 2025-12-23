package com.bjtsn.base.v2.netty4android.client;

import android.os.SystemClock;
import com.orhanobut.logger.j;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nNettyTcpClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NettyTcpClient.kt\ncom/bjtsn/base/v2/netty4android/client/NettyTcpClient\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,339:1\n1#2:340\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f14512a;

    /* renamed from: b, reason: collision with root package name */
    private final int f14513b;

    /* renamed from: c, reason: collision with root package name */
    private final int f14514c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private EventLoopGroup f14515d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private s.b<com.bxkj.base.v2.netty4android.client.command.a> f14516e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private Channel f14517f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f14518g;

    /* renamed from: h, reason: collision with root package name */
    private int f14519h;

    /* renamed from: i, reason: collision with root package name */
    private int f14520i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f14521j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f14522k;

    /* renamed from: l, reason: collision with root package name */
    private long f14523l;

    /* renamed from: m, reason: collision with root package name */
    private long f14524m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f14525n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    private Object f14526o;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private String f14529c;

        /* renamed from: d, reason: collision with root package name */
        private int f14530d;

        /* renamed from: e, reason: collision with root package name */
        private int f14531e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f14532f;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        private Object f14534h;

        /* renamed from: a, reason: collision with root package name */
        private int f14527a = Integer.MAX_VALUE;

        /* renamed from: b, reason: collision with root package name */
        private long f14528b = 5000;

        /* renamed from: g, reason: collision with root package name */
        private long f14533g = 5;

        @NotNull
        public final d a() {
            String str = this.f14529c;
            g0.m(str);
            d dVar = new d(str, this.f14530d, this.f14531e, null);
            dVar.f14519h = this.f14527a;
            dVar.f14523l = this.f14528b;
            dVar.f14524m = this.f14533g;
            dVar.f14525n = this.f14532f;
            dVar.f14526o = this.f14534h;
            return dVar;
        }

        @NotNull
        public final a b(@NotNull Object heartBeatData) {
            g0.p(heartBeatData, "heartBeatData");
            this.f14534h = heartBeatData;
            return this;
        }

        @NotNull
        public final a c(long j6) {
            this.f14533g = j6;
            return this;
        }

        @NotNull
        public final a d(@NotNull String host) {
            g0.p(host, "host");
            this.f14529c = host;
            return this;
        }

        @NotNull
        public final a e(int i6) {
            this.f14531e = i6;
            return this;
        }

        @NotNull
        public final a f(int i6) {
            this.f14527a = i6;
            return this;
        }

        @NotNull
        public final a g(long j6) {
            this.f14528b = j6;
            return this;
        }

        @NotNull
        public final a h(boolean z5) {
            this.f14532f = z5;
            return this;
        }

        @NotNull
        public final a i(int i6) {
            this.f14530d = i6;
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends Thread {
        b() {
            super("Netty-Client");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            d.this.f14521j = true;
            d dVar = d.this;
            dVar.f14520i = dVar.u();
            d.this.o();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c extends ChannelInitializer<SocketChannel> {
        c() {
        }

        @Override // io.netty.channel.ChannelInitializer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void initChannel(SocketChannel ch) throws Exception {
            g0.p(ch, "ch");
            if (d.this.w()) {
                ch.pipeline().addLast("ping", new IdleStateHandler(0L, d.this.s(), 0L, TimeUnit.SECONDS));
            }
            ch.pipeline().addLast(new com.bxkj.base.v2.netty4android.client.handler.c(null, 1, null));
            ch.pipeline().addLast(new com.bxkj.base.v2.netty4android.client.handler.b(null, 1, null));
            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
            ch.pipeline().addLast(new com.bxkj.base.v2.netty4android.client.handler.d(d.this.f14516e, d.this.t(), d.this.w(), d.this.f14526o));
        }
    }

    public /* synthetic */ d(String str, int i6, int i7, v vVar) {
        this(str, i6, i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009b, code lost:
    
        if (r0 != null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c0, code lost:
    
        r0.shutdownGracefully();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00be, code lost:
    
        if (r0 == null) goto L60;
     */
    /* JADX WARN: Type inference failed for: r0v24, types: [io.netty.channel.ChannelFuture] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void o() {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bjtsn.base.v2.netty4android.client.d.o():void");
    }

    private final void x() {
        int i6;
        j.d("客户端主动重新连接", new Object[0]);
        if (!this.f14521j || (i6 = this.f14520i) <= 0 || this.f14518g) {
            return;
        }
        this.f14520i = i6 - 1;
        SystemClock.sleep(this.f14523l);
        if (!this.f14521j || this.f14520i <= 0 || this.f14518g) {
            return;
        }
        o();
    }

    public final void q() {
        j.d("客户端主动断开连接", new Object[0]);
        this.f14521j = false;
        EventLoopGroup eventLoopGroup = this.f14515d;
        if (eventLoopGroup != null) {
            eventLoopGroup.shutdownGracefully();
        }
    }

    private d(String str, int i6, int i7) {
        this.f14512a = str;
        this.f14513b = i6;
        this.f14514c = i7;
        this.f14519h = Integer.MAX_VALUE;
        this.f14520i = Integer.MAX_VALUE;
        this.f14521j = true;
        this.f14523l = 5000L;
        this.f14524m = 5L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(s.a aVar, Future future) {
        if (aVar != null) {
            aVar.a(future.isSuccess());
        }
    }

    @Nullable
    public final n1 B(@NotNull com.bxkj.base.v2.netty4android.client.command.a data, @NotNull final Function1<? super Boolean, n1> listener) {
        g0.p(data, "data");
        g0.p(listener, "listener");
        Channel channel = this.f14517f;
        if (channel == null) {
            return null;
        }
        if (this.f14518g) {
            channel.writeAndFlush(data).addListener(new GenericFutureListener() { // from class: com.bjtsn.base.v2.netty4android.client.c
                @Override // io.netty.util.concurrent.GenericFutureListener
                public final void operationComplete(Future future) {
                    d.C(Function1.this, future);
                }
            });
        }
        return n1.f44123a;
    }

    public final void D(boolean z5) {
        this.f14518g = z5;
    }

    public final void E(@NotNull s.b<com.bxkj.base.v2.netty4android.client.command.a> listener) {
        g0.p(listener, "listener");
        this.f14516e = listener;
    }

    public final void n() {
        if (this.f14522k) {
            return;
        }
        new b().start();
    }

    public final boolean r() {
        return this.f14518g;
    }

    public final long s() {
        return this.f14524m;
    }

    public final int t() {
        return this.f14514c;
    }

    public final int u() {
        return this.f14519h;
    }

    public final long v() {
        return this.f14523l;
    }

    public final boolean w() {
        return this.f14525n;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [io.netty.channel.ChannelFuture] */
    @Nullable
    public final ChannelFuture y(@NotNull com.bxkj.base.v2.netty4android.client.command.a data, @Nullable final s.a aVar) {
        g0.p(data, "data");
        Channel channel = this.f14517f;
        if (channel != null) {
            if (!this.f14518g) {
                channel = null;
            }
            if (channel != null) {
                channel.writeAndFlush(data);
                return channel.writeAndFlush(data).addListener(new GenericFutureListener() { // from class: com.bjtsn.base.v2.netty4android.client.b
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public final void operationComplete(Future future) {
                        d.A(s.a.this, future);
                    }
                });
            }
        }
        return null;
    }

    public final boolean z(@NotNull com.bxkj.base.v2.netty4android.client.command.a data) {
        g0.p(data, "data");
        Channel channel = this.f14517f;
        if (channel == null || !this.f14518g) {
            return false;
        }
        return channel.writeAndFlush(data).awaitUninterruptibly().isSuccess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function1 function1, Future future) {
        function1.invoke(Boolean.valueOf(future.isSuccess()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(d dVar, Future future) {
        if (future.isSuccess()) {
            j.d("连接成功", new Object[0]);
            dVar.f14520i = dVar.f14519h;
            dVar.f14518g = true;
        } else {
            s.b<com.bxkj.base.v2.netty4android.client.command.a> bVar = dVar.f14516e;
            if (bVar != null) {
                bVar.c();
            }
            j.d("连接失败", new Object[0]);
            dVar.f14518g = false;
        }
        dVar.f14522k = false;
    }
}
