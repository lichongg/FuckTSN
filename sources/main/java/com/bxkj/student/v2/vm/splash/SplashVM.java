package com.bxkj.student.v2.vm.splash;

import androidx.lifecycle.ViewModelKt;
import cn.bluemobi.dylan.http.Http;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.App;
import com.bxkj.student.run.app.utils.i;
import com.orhanobut.logger.j;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlin.text.u;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.k;
import kotlinx.coroutines.r0;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import retrofit2.HttpException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class SplashVM extends BaseViewModel {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final com.bxkj.student.v2.repository.splash.b f22359h = new com.bxkj.student.v2.repository.splash.b();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.splash.SplashVM$autoLogin$1", f = "SplashVM.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nSplashVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SplashVM.kt\ncom/bxkj/student/v2/vm/splash/SplashVM$autoLogin$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,164:1\n1#2:165\n*E\n"})
    static final class a extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22360a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f22362c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Ref.IntRef intRef, kotlin.coroutines.e<? super a> eVar) {
            super(1, eVar);
            this.f22362c = intRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SplashVM.this.new a(this.f22362c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22360a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.splash.b bVar = SplashVM.this.f22359h;
                String I = com.bxkj.base.v2.data.b.f16998d.a().I();
                this.f22360a = 1;
                obj = bVar.a(I, this);
                if (obj == l6) {
                    return l6;
                }
            }
            Map<String, ? extends Object> map = (Map) obj;
            b.a aVar = com.bxkj.base.v2.data.b.f16998d;
            com.bxkj.base.v2.data.b a6 = aVar.a();
            Object obj2 = map.get("access_token");
            Object obj3 = "";
            if (obj2 == null) {
                obj2 = "";
            }
            a6.e0(String.valueOf(obj2));
            com.bxkj.base.v2.data.b a7 = aVar.a();
            Object obj4 = map.get("refresh_token");
            if (obj4 != null) {
                obj3 = obj4;
            }
            a7.K0(String.valueOf(obj3));
            this.f22362c.element = (int) Double.parseDouble(c0.f16887a.t(map, "dept_id"));
            aVar.a().k0(String.valueOf(this.f22362c.element));
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.splash.SplashVM$autoLogin$2", f = "SplashVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<Exception, kotlin.coroutines.e<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22363a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f22364b;

        b(kotlin.coroutines.e<? super b> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            b bVar = new b(eVar);
            bVar.f22364b = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Response i6;
            Request request;
            Exception exc = (Exception) this.f22364b;
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22363a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            g0.n(obj);
            boolean z5 = false;
            if (exc instanceof HttpException) {
                HttpException httpException = (HttpException) exc;
                if (httpException.code() == 426) {
                    retrofit2.c0<?> response = httpException.response();
                    if (u.l3(String.valueOf((response == null || (i6 = response.i()) == null || (request = i6.request()) == null) ? null : request.url()), "grant_type=refresh_token", false, 2, null)) {
                        z5 = true;
                    }
                }
            }
            return kotlin.coroutines.jvm.internal.a.a(z5);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Exception exc, kotlin.coroutines.e<? super Boolean> eVar) {
            return ((b) create(exc, eVar)).invokeSuspend(n1.f44123a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.splash.SplashVM$autoLogin$3", f = "SplashVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22365a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Integer, n1> f22366b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f22367c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super Integer, n1> function1, Ref.IntRef intRef, kotlin.coroutines.e<? super c> eVar) {
            super(1, eVar);
            this.f22366b = function1;
            this.f22367c = intRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new c(this.f22366b, this.f22367c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((c) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22365a == 0) {
                g0.n(obj);
                this.f22366b.invoke(kotlin.coroutines.jvm.internal.a.f(this.f22367c.element));
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.splash.SplashVM$getAppId$1", f = "SplashVM.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nSplashVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SplashVM.kt\ncom/bxkj/student/v2/vm/splash/SplashVM$getAppId$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,164:1\n1#2:165\n*E\n"})
    static final class d extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22368a;

        d(kotlin.coroutines.e<? super d> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SplashVM.this.new d(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((d) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22368a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.splash.b bVar = SplashVM.this.f22359h;
                this.f22368a = 1;
                obj = bVar.b(this);
                if (obj == l6) {
                    return l6;
                }
            }
            String str = (String) obj;
            if (str != null) {
                com.bxkj.base.v2.data.b.f16998d.a().h0(str);
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.splash.SplashVM$getSchoolInfo$1", f = "SplashVM.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
    static final class e extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22370a;

        e(kotlin.coroutines.e<? super e> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SplashVM.this.new e(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((e) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22370a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.splash.b bVar = SplashVM.this.f22359h;
                this.f22370a = 1;
                obj = bVar.c(this);
                if (obj == l6) {
                    return l6;
                }
            }
            Map<String, ? extends Object> map = (Map) obj;
            c0 c0Var = c0.f16887a;
            String t5 = c0Var.t(map, "schName");
            LoginUser.getLoginUser().setSysType(c0Var.k(map, "sysType"));
            b.a aVar = com.bxkj.base.v2.data.b.f16998d;
            aVar.a().G0(c0Var.k(map, "isOpenLive"));
            aVar.a().I0(c0Var.l(map, "isOpenSQZS", 1));
            aVar.a().F0(c0Var.l(map, "isOpenGGLBT", 1));
            aVar.a().V0(c0Var.l(map, "isJiguangPush", 1));
            aVar.a().H0(c0Var.l(map, "openPhoneLogin", 0));
            aVar.a().p0(c0Var.k(map, "insideNetwork"));
            aVar.a().q0(c0Var.t(map, "insideNetworkMsg"));
            if (LoginUser.getLoginUser().getSysType() == 2) {
                aVar.a().O0(t5);
                aVar.a().M0(c0Var.t(map, "schoolCode"));
                aVar.a().P0(c0Var.u(map, "lan_url", com.bxkj.student.v2.retrofit.b.f21275a.a()));
                com.bxkj.student.v2.retrofit.e.f21288a.b();
            } else {
                LoginUser.getLoginUser().setSchoolName(t5);
                LoginUser.getLoginUser().setIsOpenKeep(c0Var.k(map, "isOpenKeep"));
                LoginUser.getLoginUser().setIsOpenEncry(c0Var.t(map, "isOpenEncry"));
                LoginUser.getLoginUser().setAppId(c0Var.t(map, "openId"));
                LoginUser.getLoginUser().setServerUrl(c0Var.t(map, "urlSite"));
                LoginUser.getLoginUser().setOldToNewH5(c0Var.t(map, "oldToNewH5"));
                Http.changeBaseUrl(LoginUser.getLoginUser().getServerUrl());
            }
            com.bxkj.student.common.jpush.a.f17746a.e();
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.splash.SplashVM$getSchoolLogo$1", f = "SplashVM.kt", i = {2, 2}, l = {101, 109, 113}, m = "invokeSuspend", n = {"resultDataMap", "activateUrl"}, s = {"L$0", "L$1"})
    static final class f extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22372a;

        /* renamed from: b, reason: collision with root package name */
        Object f22373b;

        /* renamed from: c, reason: collision with root package name */
        int f22374c;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1<String, n1> f22376e;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.student.v2.vm.splash.SplashVM$getSchoolLogo$1$1", f = "SplashVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f22377a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function1<String, n1> f22378b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(Function1<? super String, n1> function1, kotlin.coroutines.e<? super a> eVar) {
                super(2, eVar);
                this.f22378b = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new a(this.f22378b, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
                return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.a.l();
                if (this.f22377a == 0) {
                    g0.n(obj);
                    this.f22378b.invoke(com.bxkj.base.v2.data.b.f16998d.a().K());
                    return n1.f44123a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.student.v2.vm.splash.SplashVM$getSchoolLogo$1$2", f = "SplashVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class b extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f22379a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function1<String, n1> f22380b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f22381c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            b(Function1<? super String, n1> function1, String str, kotlin.coroutines.e<? super b> eVar) {
                super(2, eVar);
                this.f22380b = function1;
                this.f22381c = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new b(this.f22380b, this.f22381c, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
                return ((b) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.a.l();
                if (this.f22379a == 0) {
                    g0.n(obj);
                    this.f22380b.invoke(this.f22381c);
                    return n1.f44123a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        f(Function1<? super String, n1> function1, kotlin.coroutines.e<? super f> eVar) {
            super(2, eVar);
            this.f22376e = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return SplashVM.this.new f(this.f22376e, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((f) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x00ae, code lost:
        
            if (kotlinx.coroutines.i.h(r5, r6, r9) != r0) goto L32;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r9.f22374c
                r2 = 0
                r3 = 0
                r4 = 3
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L33
                if (r1 == r6) goto L2f
                if (r1 == r5) goto L2b
                if (r1 != r4) goto L23
                java.lang.Object r0 = r9.f22373b
                java.lang.String r0 = (java.lang.String) r0
                java.lang.Object r0 = r9.f22372a
                java.util.Map r0 = (java.util.Map) r0
                kotlin.g0.n(r10)     // Catch: java.lang.Exception -> L20
                goto Lba
            L20:
                r10 = move-exception
                goto Lb1
            L23:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L2b:
                kotlin.g0.n(r10)     // Catch: java.lang.Exception -> L20
                goto L73
            L2f:
                kotlin.g0.n(r10)     // Catch: java.lang.Exception -> L20
                goto L4a
            L33:
                kotlin.g0.n(r10)
                kotlinx.coroutines.p2 r10 = kotlinx.coroutines.g1.e()     // Catch: java.lang.Exception -> L20
                com.bxkj.student.v2.vm.splash.SplashVM$f$a r1 = new com.bxkj.student.v2.vm.splash.SplashVM$f$a     // Catch: java.lang.Exception -> L20
                kotlin.jvm.functions.Function1<java.lang.String, kotlin.n1> r7 = r9.f22376e     // Catch: java.lang.Exception -> L20
                r1.<init>(r7, r3)     // Catch: java.lang.Exception -> L20
                r9.f22374c = r6     // Catch: java.lang.Exception -> L20
                java.lang.Object r10 = kotlinx.coroutines.i.h(r10, r1, r9)     // Catch: java.lang.Exception -> L20
                if (r10 != r0) goto L4a
                goto Lb0
            L4a:
                com.bxkj.base.v2.data.b$a r10 = com.bxkj.base.v2.data.b.f16998d     // Catch: java.lang.Exception -> L20
                com.bxkj.base.v2.data.b r10 = r10.a()     // Catch: java.lang.Exception -> L20
                long r6 = r10.y()     // Catch: java.lang.Exception -> L20
                boolean r10 = com.bxkj.base.v2.common.ext.g.f(r6)     // Catch: java.lang.Exception -> L20
                if (r10 == 0) goto L64
                java.lang.String r10 = "获取学校图标接口当天只调用一次"
                java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L20
                com.orhanobut.logger.j.e(r10, r0)     // Catch: java.lang.Exception -> L20
                kotlin.n1 r10 = kotlin.n1.f44123a     // Catch: java.lang.Exception -> L20
                return r10
            L64:
                com.bxkj.student.v2.vm.splash.SplashVM r10 = com.bxkj.student.v2.vm.splash.SplashVM.this     // Catch: java.lang.Exception -> L20
                com.bxkj.student.v2.repository.splash.b r10 = com.bxkj.student.v2.vm.splash.SplashVM.t(r10)     // Catch: java.lang.Exception -> L20
                r9.f22374c = r5     // Catch: java.lang.Exception -> L20
                java.lang.Object r10 = r10.d(r9)     // Catch: java.lang.Exception -> L20
                if (r10 != r0) goto L73
                goto Lb0
            L73:
                java.util.Map r10 = (java.util.Map) r10     // Catch: java.lang.Exception -> L20
                com.bxkj.base.v2.common.utils.c0 r1 = com.bxkj.base.v2.common.utils.c0.f16887a     // Catch: java.lang.Exception -> L20
                java.lang.String r5 = "activateUrl"
                java.lang.String r1 = r1.t(r10, r5)     // Catch: java.lang.Exception -> L20
                com.bxkj.base.v2.data.b$a r5 = com.bxkj.base.v2.data.b.f16998d     // Catch: java.lang.Exception -> L20
                com.bxkj.base.v2.data.b r6 = r5.a()     // Catch: java.lang.Exception -> L20
                long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L20
                r6.w0(r7)     // Catch: java.lang.Exception -> L20
                com.bxkj.base.v2.data.b r5 = r5.a()     // Catch: java.lang.Exception -> L20
                r5.N0(r1)     // Catch: java.lang.Exception -> L20
                kotlinx.coroutines.p2 r5 = kotlinx.coroutines.g1.e()     // Catch: java.lang.Exception -> L20
                com.bxkj.student.v2.vm.splash.SplashVM$f$b r6 = new com.bxkj.student.v2.vm.splash.SplashVM$f$b     // Catch: java.lang.Exception -> L20
                kotlin.jvm.functions.Function1<java.lang.String, kotlin.n1> r7 = r9.f22376e     // Catch: java.lang.Exception -> L20
                r6.<init>(r7, r1, r3)     // Catch: java.lang.Exception -> L20
                java.lang.Object r10 = kotlin.coroutines.jvm.internal.j.a(r10)     // Catch: java.lang.Exception -> L20
                r9.f22372a = r10     // Catch: java.lang.Exception -> L20
                java.lang.Object r10 = kotlin.coroutines.jvm.internal.j.a(r1)     // Catch: java.lang.Exception -> L20
                r9.f22373b = r10     // Catch: java.lang.Exception -> L20
                r9.f22374c = r4     // Catch: java.lang.Exception -> L20
                java.lang.Object r10 = kotlinx.coroutines.i.h(r5, r6, r9)     // Catch: java.lang.Exception -> L20
                if (r10 != r0) goto Lba
            Lb0:
                return r0
            Lb1:
                java.lang.String r10 = com.bxkj.base.v2.common.ext.e.a(r10)
                java.lang.Object[] r0 = new java.lang.Object[r2]
                com.orhanobut.logger.j.e(r10, r0)
            Lba:
                kotlin.n1 r10 = kotlin.n1.f44123a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.splash.SplashVM.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.splash.SplashVM$preDownloadImage$1", f = "SplashVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nSplashVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SplashVM.kt\ncom/bxkj/student/v2/vm/splash/SplashVM$preDownloadImage$1\n+ 2 Timing.kt\nkotlin/system/TimingKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,164:1\n29#2,2:165\n31#2:170\n13805#3:167\n13806#3:169\n1#4:168\n*S KotlinDebug\n*F\n+ 1 SplashVM.kt\ncom/bxkj/student/v2/vm/splash/SplashVM$preDownloadImage$1\n*L\n127#1:165,2\n127#1:170\n135#1:167\n135#1:169\n*E\n"})
    static final class g extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22382a;

        g(kotlin.coroutines.e<? super g> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new g(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((g) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            File file;
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22382a == 0) {
                g0.n(obj);
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    App.a aVar = App.f17573d;
                    File file2 = new File(aVar.a().getFilesDir().getPath(), "icon");
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    String[] list = aVar.a().getAssets().list("icon");
                    if (list != null) {
                        for (String str : list) {
                            File file3 = new File(file2, str);
                            File file4 = null;
                            if (!file3.exists()) {
                                file = file3;
                            } else {
                                file = null;
                            }
                            if (file != null) {
                                try {
                                    InputStream open = App.f17573d.a().getAssets().open("icon/" + str);
                                    try {
                                        FileOutputStream fileOutputStream = new FileOutputStream(file3);
                                        try {
                                            byte[] bArr = new byte[4096];
                                            while (true) {
                                                int read = open.read(bArr);
                                                if (read == -1) {
                                                    break;
                                                }
                                                fileOutputStream.write(bArr, 0, read);
                                            }
                                            fileOutputStream.flush();
                                            n1 n1Var = n1.f44123a;
                                            kotlin.io.b.a(fileOutputStream, null);
                                            kotlin.io.b.a(open, null);
                                        } finally {
                                        }
                                    } finally {
                                    }
                                } catch (Exception e6) {
                                    j.e(com.bxkj.base.v2.common.ext.e.a(e6), new Object[0]);
                                    if (!file3.exists()) {
                                        file4 = file3;
                                    }
                                    if (file4 != null) {
                                        kotlin.coroutines.jvm.internal.a.a(file3.delete());
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e7) {
                    j.e(com.bxkj.base.v2.common.ext.e.a(e7), new Object[0]);
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                j.d("下载图标耗时 " + i.g(currentTimeMillis2) + "  " + currentTimeMillis2, new Object[0]);
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void u(@NotNull Function1<? super Integer, n1> finish) {
        kotlin.jvm.internal.g0.p(finish, "finish");
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 1;
        BaseViewModel.l(this, new a(intRef, null), null, new b(null), null, new c(finish, intRef, null), null, 42, null);
    }

    public final void v() {
        BaseViewModel.l(this, new d(null), null, null, null, null, null, 62, null);
    }

    public final void w() {
        BaseViewModel.l(this, new e(null), null, null, null, null, null, 62, null);
    }

    public final void x(@NotNull Function1<? super String, n1> result) {
        kotlin.jvm.internal.g0.p(result, "result");
        k.f(ViewModelKt.getViewModelScope(this), g1.c(), null, new f(result, null), 2, null);
    }

    public final void y() {
        k.f(ViewModelKt.getViewModelScope(this), g1.c(), null, new g(null), 2, null);
    }
}
