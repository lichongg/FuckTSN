package com.bxkj.base.v2.netty4android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LifecycleService;
import com.bjtsn.base.v2.netty4android.client.d;
import com.bxkj.base.BaseApp;
import com.bxkj.base.util.b0;
import com.bxkj.base.v2.common.ext.g;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.data.b;
import com.bxkj.base.v2.http.result.ApiResult;
import com.bxkj.base.v2.netty4android.client.command.b;
import com.orhanobut.logger.j;
import java.util.Map;
import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.k;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nNettySocketService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NettySocketService.kt\ncom/bxkj/base/v2/netty4android/service/NettySocketService\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,289:1\n1#2:290\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class NettySocketService extends LifecycleService {

    /* renamed from: b, reason: collision with root package name */
    private int f17136b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private com.bxkj.base.v2.netty4android.client.heart.a f17137c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private d f17138d;

    /* renamed from: a, reason: collision with root package name */
    private final int f17135a = 5;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final NettySocketService$refreshTokenBroadCastReceiver$1 f17139e = new BroadcastReceiver() { // from class: com.bxkj.base.v2.netty4android.service.NettySocketService$refreshTokenBroadCastReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            j.d("NettySocketService->接收到了刷新Token成功通知", new Object[0]);
            NettySocketService.this.n();
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.base.v2.netty4android.service.NettySocketService$receiveCommand$1", f = "NettySocketService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<r0, e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f17140a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bxkj.base.v2.netty4android.client.command.a f17141b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(com.bxkj.base.v2.netty4android.client.command.a aVar, e<? super a> eVar) {
            super(2, eVar);
            this.f17141b = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(Object obj, e<?> eVar) {
            return new a(this.f17141b, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, e<? super n1> eVar) {
            return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f17140a == 0) {
                g0.n(obj);
                this.f17141b.a();
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements s.b<com.bxkj.base.v2.netty4android.client.command.a> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.base.v2.netty4android.service.NettySocketService$startConnect$1$onClientStatusConnectChanged$1", f = "NettySocketService.kt", i = {}, l = {220}, m = "invokeSuspend", n = {}, s = {})
        static final class a extends SuspendLambda implements Function2<r0, e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f17143a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ NettySocketService f17144b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(NettySocketService nettySocketService, e<? super a> eVar) {
                super(2, eVar);
                this.f17144b = nettySocketService;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final e<n1> create(Object obj, e<?> eVar) {
                return new a(this.f17144b, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, e<? super n1> eVar) {
                return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object l6 = kotlin.coroutines.intrinsics.a.l();
                int i6 = this.f17143a;
                if (i6 != 0) {
                    if (i6 == 1) {
                        g0.n(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    g0.n(obj);
                    this.f17143a = 1;
                    if (a1.b(10000L, this) == l6) {
                        return l6;
                    }
                }
                this.f17144b.n();
                return n1.f44123a;
            }
        }

        b() {
        }

        @Override // s.b
        public void b(int i6, int i7) {
            j.d("onClientStatusConnectChanged:" + i6, new Object[0]);
            if (i6 == 0) {
                j.d("onClientStatusConnectChanged->连接断开", new Object[0]);
                com.bxkj.base.v2.netty4android.client.heart.a aVar = NettySocketService.this.f17137c;
                if (aVar != null) {
                    aVar.a();
                }
                k.f(LifecycleOwnerKt.getLifecycleScope(NettySocketService.this), g1.c(), null, new a(NettySocketService.this, null), 2, null);
                return;
            }
            if (i6 != 1) {
                return;
            }
            b.a aVar2 = com.bxkj.base.v2.data.b.f16998d;
            aVar2.a().s0(System.currentTimeMillis());
            NettySocketService nettySocketService = NettySocketService.this;
            b.a aVar3 = com.bxkj.base.v2.netty4android.client.command.b.f17084a;
            String S = aVar2.a().S();
            String R = aVar2.a().R();
            String D = aVar2.a().D();
            String h6 = b0.h(BaseApp.c());
            kotlin.jvm.internal.g0.o(h6, "getVersionName(...)");
            nettySocketService.k(aVar3.a(S, R, D, h6, aVar2.a().J()));
        }

        @Override // s.b
        public void c() {
            NettySocketService.this.f17136b++;
        }

        @Override // s.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(com.bxkj.base.v2.netty4android.client.command.a msg, int i6) {
            kotlin.jvm.internal.g0.p(msg, "msg");
            NettySocketService.this.j(msg);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.base.v2.netty4android.service.NettySocketService$startGetSocketConfig$1", f = "NettySocketService.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<r0, e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f17145a;

        c(e<? super c> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final e<n1> create(Object obj, e<?> eVar) {
            return NettySocketService.this.new c(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, e<? super n1> eVar) {
            return ((c) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Map<String, ? extends Object> map;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f17145a;
            try {
                if (i6 == 0) {
                    g0.n(obj);
                    com.bxkj.base.v2.http.b b6 = com.bxkj.base.v2.http.c.f17076a.b();
                    this.f17145a = 1;
                    obj = com.bxkj.base.v2.http.a.a(b6, null, this, 1, null);
                    if (obj == l6) {
                        return l6;
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    g0.n(obj);
                }
                ApiResult apiResult = (ApiResult) obj;
                if (apiResult != null && (map = (Map) apiResult.apiData()) != null) {
                    NettySocketService nettySocketService = NettySocketService.this;
                    b.a aVar = com.bxkj.base.v2.data.b.f16998d;
                    aVar.a().Q0(System.currentTimeMillis());
                    com.bxkj.base.v2.data.b a6 = aVar.a();
                    c0 c0Var = c0.f16887a;
                    a6.R0(c0Var.k(map, "serverOpen"));
                    if (c0Var.k(map, "serverOpen") == 1) {
                        aVar.a().A0(c0Var.t(map, IjkMediaPlayer.OnNativeInvokeListener.ARG_IP));
                        aVar.a().B0(c0Var.k(map, "port"));
                        aVar.a().C0(c0Var.t(map, "secret"));
                        nettySocketService.m();
                    } else {
                        j.m("socket服务器设置sokect配置未开启", new Object[0]);
                        nettySocketService.h();
                    }
                }
            } catch (Exception e6) {
                if ((e6 instanceof HttpException) && ((HttpException) e6).code() == 401) {
                    j.e("由于获取sokect配置接口401，已经登录失效，请重新登录", new Object[0]);
                }
                j.e("socket" + e6, new Object[0]);
            }
            return n1.f44123a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        com.bxkj.base.v2.netty4android.client.heart.a aVar = this.f17137c;
        if (aVar != null) {
            aVar.a();
        }
        stopSelf();
    }

    private final void i() {
        d dVar = this.f17138d;
        if (dVar != null) {
            dVar.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        if (!aVar.a().Y()) {
            j.e("startSocketConnect->用户未登录，不再连接", new Object[0]);
            return;
        }
        if (!aVar.a().c0()) {
            j.e("startSocketConnect->用户Token未刷新成功，不再连接", new Object[0]);
            return;
        }
        if (aVar.a().O() == 0) {
            j.e("startSocketConnect->服务器设置sokect配置未开启，不再连接", new Object[0]);
            h();
            return;
        }
        if (this.f17136b >= this.f17135a) {
            j.e("startSocketConnect->超过最大连接失败次数，不再连接", new Object[0]);
            return;
        }
        if (aVar.a().B().length() == 0) {
            h();
            j.e("startSocketConnect->IP为空，不再连接", new Object[0]);
            return;
        }
        if (aVar.a().C() == 0) {
            h();
            j.e("startSocketConnect->端口为空，不再连接", new Object[0]);
            return;
        }
        if (aVar.a().D().length() == 0) {
            h();
            j.e("startSocketConnect->秘钥为空，不再连接", new Object[0]);
            return;
        }
        i();
        if (this.f17138d == null) {
            this.f17138d = new d.a().d(aVar.a().B()).i(aVar.a().C()).f(0).g(0L).h(true).c(60L).b(com.bxkj.base.v2.netty4android.client.command.b.f17084a.b()).e(0).a();
        }
        d dVar = this.f17138d;
        if (dVar == null || dVar.r()) {
            return;
        }
        d dVar2 = this.f17138d;
        if (dVar2 != null) {
            dVar2.n();
        }
        d dVar3 = this.f17138d;
        if (dVar3 != null) {
            dVar3.E(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        d dVar = this.f17138d;
        if (dVar != null && dVar.r()) {
            j.e("getAppSocketServer->socket已经连接，不再连接", new Object[0]);
            return;
        }
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        if (!aVar.a().Y()) {
            j.e("getAppSocketServer->用户未登录，不再连接", new Object[0]);
            return;
        }
        if (!aVar.a().c0()) {
            j.e("getAppSocketServer->用户Token未刷新成功，不再连接", new Object[0]);
            return;
        }
        if (this.f17136b >= this.f17135a) {
            j.e("getAppSocketServer->超过最大连接失败次数，不再连接", new Object[0]);
        } else if (!g.f(aVar.a().N())) {
            k.f(LifecycleOwnerKt.getLifecycleScope(this), g1.c(), null, new c(null), 2, null);
        } else {
            j.e("getAppSocketServer->当天只调用一次接口", new Object[0]);
            m();
        }
    }

    public final void j(@NotNull com.bxkj.base.v2.netty4android.client.command.a command) {
        kotlin.jvm.internal.g0.p(command, "command");
        com.bxkj.base.v2.data.b.f16998d.a().s0(System.currentTimeMillis());
        k.f(LifecycleOwnerKt.getLifecycleScope(this), g1.c(), null, new a(command, null), 2, null);
    }

    public final void k(@NotNull final com.bxkj.base.v2.netty4android.client.command.a command) {
        kotlin.jvm.internal.g0.p(command, "command");
        d dVar = this.f17138d;
        if (dVar != null) {
            dVar.B(command, new Function1() { // from class: com.bxkj.base.v2.netty4android.service.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 l6;
                    l6 = NettySocketService.l(com.bxkj.base.v2.netty4android.client.command.a.this, ((Boolean) obj).booleanValue());
                    return l6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 l(com.bxkj.base.v2.netty4android.client.command.a aVar, boolean z5) {
        Boolean valueOf = Boolean.valueOf(z5);
        if (z5) {
            valueOf = null;
        }
        if (valueOf != null) {
            j.e(aVar + " 消息发送失败", new Object[0]);
        }
        return n1.f44123a;
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        IntentFilter intentFilter = new IntentFilter(BaseApp.c().getPackageName() + ".REFRESH_TOKEN_FINISH");
        registerReceiver(this.f17139e, intentFilter, BaseApp.c().getPackageName() + ".sports.permissions.V3_Sports_BROADCAST", null);
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f17139e);
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i6, int i7) {
        super.onStartCommand(intent, i6, i7);
        com.bxkj.base.v2.netty4android.client.heart.a aVar = this.f17137c;
        if (aVar == null) {
            BaseApp c6 = BaseApp.c();
            kotlin.jvm.internal.g0.o(c6, "getApp(...)");
            aVar = new com.bxkj.base.v2.netty4android.client.heart.a(c6);
        }
        this.f17137c = aVar;
        aVar.b();
        if (intent != null) {
            if (!intent.hasExtra(com.umeng.ccg.a.f41544t)) {
                intent = null;
            }
            if (intent != null) {
                int intExtra = intent.getIntExtra(com.umeng.ccg.a.f41544t, 0);
                if (intExtra != 1) {
                    if (intExtra == 2) {
                        j.g("NettySocketService->ACTION_DISCONNECT", new Object[0]);
                        i();
                    }
                } else {
                    j.g("NettySocketService->ACTION_CONNECT", new Object[0]);
                    n();
                }
            }
        }
        return 1;
    }
}
