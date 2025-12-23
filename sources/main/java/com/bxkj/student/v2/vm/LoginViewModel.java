package com.bxkj.student.v2.vm;

import android.content.Intent;
import androidx.databinding.ObservableField;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.amap.api.services.core.AMapException;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.data.b;
import com.bxkj.base.v2.http.result.ApiResult;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.orhanobut.logger.j;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlin.s;
import kotlin.t;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.k;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import u.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLoginViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LoginViewModel.kt\ncom/bxkj/student/v2/vm/LoginViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,177:1\n1#2:178\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public class LoginViewModel extends BaseViewModel {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final MutableLiveData<Map<String, Object>> f22106h = new MutableLiveData<>();

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private ObservableField<String> f22107i = new ObservableField<>();

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private ObservableField<String> f22108j = new ObservableField<>();

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private MutableLiveData<Map<String, Object>> f22109k = new MutableLiveData<>();

    /* renamed from: l, reason: collision with root package name */
    private int f22110l = 1;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private final s f22111m = t.c(new Function0() { // from class: com.bxkj.student.v2.vm.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.b O;
            O = LoginViewModel.O(LoginViewModel.this);
            return O;
        }
    });

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private final s f22112n = t.c(new Function0() { // from class: com.bxkj.student.v2.vm.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.a y5;
            y5 = LoginViewModel.y();
            return y5;
        }
    });

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.LoginViewModel$autoLogin$1", f = "LoginViewModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_REAL_TIME}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nLoginViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LoginViewModel.kt\ncom/bxkj/student/v2/vm/LoginViewModel$autoLogin$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,177:1\n1#2:178\n*E\n"})
    static final class a extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22113a;

        a(kotlin.coroutines.e<? super a> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return LoginViewModel.this.new a(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22113a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.splash.b bVar = new com.bxkj.student.v2.repository.splash.b();
                String I = com.bxkj.base.v2.data.b.f16998d.a().I();
                this.f22113a = 1;
                obj = bVar.a(I, this);
                if (obj == l6) {
                    return l6;
                }
            }
            Map<String, Object> map = (Map) obj;
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
            LoginViewModel.this.D().postValue(map);
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.LoginViewModel$autoLogin$2", f = "LoginViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22115a;

        b(kotlin.coroutines.e<? super b> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new b(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((b) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22115a == 0) {
                g0.n(obj);
                b.a aVar = com.bxkj.base.v2.data.b.f16998d;
                aVar.a().z0(true);
                j.d("登录页刷新Token成功", new Object[0]);
                aVar.a().L0(true);
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.LoginViewModel$getFindPassword$1", f = "LoginViewModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22116a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2<String, String, n1> f22118c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(Function2<? super String, ? super String, n1> function2, kotlin.coroutines.e<? super c> eVar) {
            super(1, eVar);
            this.f22118c = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return LoginViewModel.this.new c(this.f22118c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((c) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Map<String, ? extends Object> map;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22116a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.a A = LoginViewModel.this.A();
                this.f22116a = 1;
                obj = A.b(this);
                if (obj == l6) {
                    return l6;
                }
            }
            ApiResult apiResult = (ApiResult) obj;
            if (apiResult != null) {
                map = (Map) apiResult.apiData();
            } else {
                map = null;
            }
            c0 c0Var = c0.f16887a;
            this.f22118c.invoke(c0Var.t(map, CommonNetImpl.NAME), c0Var.t(map, "linkUrl"));
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.LoginViewModel$getHelpUrl$1", f = "LoginViewModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22119a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2<String, String, n1> f22121c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(Function2<? super String, ? super String, n1> function2, kotlin.coroutines.e<? super d> eVar) {
            super(1, eVar);
            this.f22121c = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return LoginViewModel.this.new d(this.f22121c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((d) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Map<String, ? extends Object> map;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22119a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.a A = LoginViewModel.this.A();
                this.f22119a = 1;
                obj = A.c(this);
                if (obj == l6) {
                    return l6;
                }
            }
            ApiResult apiResult = (ApiResult) obj;
            if (apiResult != null) {
                map = (Map) apiResult.apiData();
            } else {
                map = null;
            }
            c0 c0Var = c0.f16887a;
            this.f22121c.invoke(c0Var.t(map, CommonNetImpl.NAME), c0Var.t(map, "linkUrl"));
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.LoginViewModel$getLoginNeedAuth$1", f = "LoginViewModel.kt", i = {1}, l = {34, 37}, m = "invokeSuspend", n = {"resultDataMap"}, s = {"L$0"})
    static final class e extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22122a;

        /* renamed from: b, reason: collision with root package name */
        int f22123b;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<String, n1> f22125d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.student.v2.vm.LoginViewModel$getLoginNeedAuth$1$1", f = "LoginViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f22126a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function1<String, n1> f22127b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f22128c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(Function1<? super String, n1> function1, Map<String, Object> map, kotlin.coroutines.e<? super a> eVar) {
                super(2, eVar);
                this.f22127b = function1;
                this.f22128c = map;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new a(this.f22127b, this.f22128c, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
                return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.a.l();
                if (this.f22126a == 0) {
                    g0.n(obj);
                    this.f22127b.invoke(c0.f16887a.t(this.f22128c, "loginTypes"));
                    return n1.f44123a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        e(Function1<? super String, n1> function1, kotlin.coroutines.e<? super e> eVar) {
            super(2, eVar);
            this.f22125d = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return LoginViewModel.this.new e(this.f22125d, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((e) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0066, code lost:
        
            if (kotlinx.coroutines.i.h(r1, r3, r6) == r0) goto L21;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r6.f22123b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L24
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                java.lang.Object r0 = r6.f22122a
                java.util.Map r0 = (java.util.Map) r0
                kotlin.g0.n(r7)     // Catch: java.lang.Exception -> L16
                goto L73
            L16:
                r7 = move-exception
                goto L69
            L18:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L20:
                kotlin.g0.n(r7)     // Catch: java.lang.Exception -> L16
                goto L36
            L24:
                kotlin.g0.n(r7)
                com.bxkj.student.v2.vm.LoginViewModel r7 = com.bxkj.student.v2.vm.LoginViewModel.this     // Catch: java.lang.Exception -> L16
                com.bxkj.student.v2.repository.b r7 = com.bxkj.student.v2.vm.LoginViewModel.w(r7)     // Catch: java.lang.Exception -> L16
                r6.f22123b = r3     // Catch: java.lang.Exception -> L16
                java.lang.Object r7 = r7.a(r6)     // Catch: java.lang.Exception -> L16
                if (r7 != r0) goto L36
                goto L68
            L36:
                java.util.Map r7 = (java.util.Map) r7     // Catch: java.lang.Exception -> L16
                com.bxkj.student.v2.vm.LoginViewModel r1 = com.bxkj.student.v2.vm.LoginViewModel.this     // Catch: java.lang.Exception -> L16
                androidx.lifecycle.MutableLiveData r1 = r1.C()     // Catch: java.lang.Exception -> L16
                r1.postValue(r7)     // Catch: java.lang.Exception -> L16
                com.bxkj.student.v2.vm.LoginViewModel r1 = com.bxkj.student.v2.vm.LoginViewModel.this     // Catch: java.lang.Exception -> L16
                com.bxkj.base.v2.common.utils.c0 r3 = com.bxkj.base.v2.common.utils.c0.f16887a     // Catch: java.lang.Exception -> L16
                java.lang.String r4 = "isOpenRoleAuthAudit"
                int r3 = r3.k(r7, r4)     // Catch: java.lang.Exception -> L16
                r1.Q(r3)     // Catch: java.lang.Exception -> L16
                kotlinx.coroutines.p2 r1 = kotlinx.coroutines.g1.e()     // Catch: java.lang.Exception -> L16
                com.bxkj.student.v2.vm.LoginViewModel$e$a r3 = new com.bxkj.student.v2.vm.LoginViewModel$e$a     // Catch: java.lang.Exception -> L16
                kotlin.jvm.functions.Function1<java.lang.String, kotlin.n1> r4 = r6.f22125d     // Catch: java.lang.Exception -> L16
                r5 = 0
                r3.<init>(r4, r7, r5)     // Catch: java.lang.Exception -> L16
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.j.a(r7)     // Catch: java.lang.Exception -> L16
                r6.f22122a = r7     // Catch: java.lang.Exception -> L16
                r6.f22123b = r2     // Catch: java.lang.Exception -> L16
                java.lang.Object r7 = kotlinx.coroutines.i.h(r1, r3, r6)     // Catch: java.lang.Exception -> L16
                if (r7 != r0) goto L73
            L68:
                return r0
            L69:
                java.lang.String r7 = com.bxkj.base.v2.common.ext.e.a(r7)
                r0 = 0
                java.lang.Object[] r0 = new java.lang.Object[r0]
                com.orhanobut.logger.j.e(r7, r0)
            L73:
                kotlin.n1 r7 = kotlin.n1.f44123a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.LoginViewModel.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.LoginViewModel$getPhoneLoginUrl$1", f = "LoginViewModel.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
    static final class f extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22129a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2<String, String, n1> f22131c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        f(Function2<? super String, ? super String, n1> function2, kotlin.coroutines.e<? super f> eVar) {
            super(1, eVar);
            this.f22131c = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return LoginViewModel.this.new f(this.f22131c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((f) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Map<String, ? extends Object> map;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22129a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.a A = LoginViewModel.this.A();
                this.f22129a = 1;
                obj = A.d(this);
                if (obj == l6) {
                    return l6;
                }
            }
            ApiResult apiResult = (ApiResult) obj;
            if (apiResult != null) {
                map = (Map) apiResult.apiData();
            } else {
                map = null;
            }
            c0 c0Var = c0.f16887a;
            this.f22131c.invoke(c0Var.t(map, CommonNetImpl.NAME), c0Var.t(map, "linkUrl"));
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.LoginViewModel$login$1", f = "LoginViewModel.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
    static final class g extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22132a;

        g(kotlin.coroutines.e<? super g> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return LoginViewModel.this.new g(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((g) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22132a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.b F = LoginViewModel.this.F();
                this.f22132a = 1;
                obj = F.c(this);
                if (obj == l6) {
                    return l6;
                }
            }
            LoginViewModel.this.L((Map) obj);
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.LoginViewModel$loginThird$1", f = "LoginViewModel.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {})
    static final class h extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22134a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f22136c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f22137d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(String str, String str2, kotlin.coroutines.e<? super h> eVar) {
            super(1, eVar);
            this.f22136c = str;
            this.f22137d = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return LoginViewModel.this.new h(this.f22136c, this.f22137d, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((h) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22134a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.b F = LoginViewModel.this.F();
                String str = this.f22136c;
                String str2 = this.f22137d;
                this.f22134a = 1;
                obj = F.d(str, str2, this);
                if (obj == l6) {
                    return l6;
                }
            }
            LoginViewModel.this.L((Map) obj);
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.LoginViewModel$loginThirdCheck$1", f = "LoginViewModel.kt", i = {1, 1}, l = {90, 93}, m = "invokeSuspend", n = {"it", "$i$a$-let-LoginViewModel$loginThirdCheck$1$1"}, s = {"L$0", "I$0"})
    static final class i extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22138a;

        /* renamed from: b, reason: collision with root package name */
        int f22139b;

        /* renamed from: c, reason: collision with root package name */
        int f22140c;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f22142e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f22143f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f22144g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f22145h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f22146i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f22147j;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.student.v2.vm.LoginViewModel$loginThirdCheck$1$1$1", f = "LoginViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f22148a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ FragmentActivity f22149b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f22150c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f22151d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f22152e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f22153f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f22154g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ LoginViewModel f22155h;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.bxkj.student.v2.vm.LoginViewModel$i$a$a, reason: collision with other inner class name */
            public static final class C0299a implements b.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ LoginViewModel f22156a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ String f22157b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ String f22158c;

                @Override // u.b.a
                public void a(int i6, Intent intent) {
                    if (i6 == -1) {
                        this.f22156a.M(this.f22157b, kotlin.jvm.internal.g0.g(this.f22158c, "1") ? "wechatlogin" : "qqlogin");
                    }
                }

                C0299a(LoginViewModel loginViewModel, String str, String str2) {
                    this.f22156a = loginViewModel;
                    this.f22157b = str;
                    this.f22158c = str2;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(FragmentActivity fragmentActivity, Map<String, ? extends Object> map, String str, String str2, String str3, String str4, LoginViewModel loginViewModel, kotlin.coroutines.e<? super a> eVar) {
                super(2, eVar);
                this.f22149b = fragmentActivity;
                this.f22150c = map;
                this.f22151d = str;
                this.f22152e = str2;
                this.f22153f = str3;
                this.f22154g = str4;
                this.f22155h = loginViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new a(this.f22149b, this.f22150c, this.f22151d, this.f22152e, this.f22153f, this.f22154g, this.f22155h, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
                return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.a.l();
                if (this.f22148a == 0) {
                    g0.n(obj);
                    com.bxkj.student.v2.common.utils.i iVar = com.bxkj.student.v2.common.utils.i.f20904a;
                    FragmentActivity fragmentActivity = this.f22149b;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Map<String, ? extends Object> map = this.f22150c;
                    String str = this.f22151d;
                    String str2 = this.f22152e;
                    String str3 = this.f22153f;
                    String str4 = this.f22154g;
                    LoginViewModel loginViewModel = this.f22155h;
                    linkedHashMap.put(CommonNetImpl.NAME, "身份认证");
                    linkedHashMap.put("linkUrl", c0.f16887a.t(map, "data"));
                    linkedHashMap.put("openId", str);
                    linkedHashMap.put("type", str2);
                    linkedHashMap.put("thirdName", str3);
                    linkedHashMap.put("thirdImage", str4);
                    linkedHashMap.put("isOpenRoleAuthAudit", kotlin.coroutines.jvm.internal.a.f(loginViewModel.J()));
                    n1 n1Var = n1.f44123a;
                    iVar.c(fragmentActivity, linkedHashMap, new C0299a(this.f22155h, this.f22151d, this.f22152e));
                    return n1Var;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(String str, String str2, Function0<n1> function0, FragmentActivity fragmentActivity, String str3, String str4, kotlin.coroutines.e<? super i> eVar) {
            super(1, eVar);
            this.f22142e = str;
            this.f22143f = str2;
            this.f22144g = function0;
            this.f22145h = fragmentActivity;
            this.f22146i = str3;
            this.f22147j = str4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return LoginViewModel.this.new i(this.f22142e, this.f22143f, this.f22144g, this.f22145h, this.f22146i, this.f22147j, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((i) create(eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x007f, code lost:
        
            if (kotlinx.coroutines.i.h(r13, r3, r12) == r0) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0081, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0035, code lost:
        
            if (r13 == r0) goto L23;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r12.f22140c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r0 = r12.f22138a
                java.util.Map r0 = (java.util.Map) r0
                kotlin.g0.n(r13)
                goto L85
            L16:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1e:
                kotlin.g0.n(r13)
                goto L38
            L22:
                kotlin.g0.n(r13)
                com.bxkj.student.v2.vm.LoginViewModel r13 = com.bxkj.student.v2.vm.LoginViewModel.this
                com.bxkj.student.v2.repository.b r13 = com.bxkj.student.v2.vm.LoginViewModel.w(r13)
                java.lang.String r1 = r12.f22142e
                java.lang.String r4 = r12.f22143f
                r12.f22140c = r3
                java.lang.Object r13 = r13.e(r1, r4, r12)
                if (r13 != r0) goto L38
                goto L81
            L38:
                java.util.Map r13 = (java.util.Map) r13
                if (r13 == 0) goto L85
                java.util.Map r5 = kotlin.collections.i1.D0(r13)
                if (r5 == 0) goto L85
                kotlin.jvm.functions.Function0<kotlin.n1> r13 = r12.f22144g
                androidx.fragment.app.FragmentActivity r4 = r12.f22145h
                java.lang.String r6 = r12.f22142e
                java.lang.String r7 = r12.f22143f
                java.lang.String r8 = r12.f22146i
                java.lang.String r9 = r12.f22147j
                com.bxkj.student.v2.vm.LoginViewModel r10 = com.bxkj.student.v2.vm.LoginViewModel.this
                com.bxkj.base.v2.common.utils.c0 r1 = com.bxkj.base.v2.common.utils.c0.f16887a
                java.lang.String r3 = "code"
                int r3 = r1.k(r5, r3)
                if (r3 != 0) goto L82
                java.lang.String r3 = "data"
                java.lang.String r1 = r1.t(r5, r3)
                int r1 = r1.length()
                if (r1 <= 0) goto L82
                kotlinx.coroutines.p2 r13 = kotlinx.coroutines.g1.e()
                com.bxkj.student.v2.vm.LoginViewModel$i$a r3 = new com.bxkj.student.v2.vm.LoginViewModel$i$a
                r11 = 0
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
                java.lang.Object r1 = kotlin.coroutines.jvm.internal.j.a(r5)
                r12.f22138a = r1
                r1 = 0
                r12.f22139b = r1
                r12.f22140c = r2
                java.lang.Object r13 = kotlinx.coroutines.i.h(r13, r3, r12)
                if (r13 != r0) goto L85
            L81:
                return r0
            L82:
                r13.invoke()
            L85:
                kotlin.n1 r13 = kotlin.n1.f44123a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.LoginViewModel.i.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.a A() {
        return (com.bxkj.student.v2.repository.a) this.f22112n.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.b F() {
        return (com.bxkj.student.v2.repository.b) this.f22111m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.b O(LoginViewModel loginViewModel) {
        return new com.bxkj.student.v2.repository.b(loginViewModel);
    }

    private final void x() {
        BaseViewModel.j(this, new a(null), null, null, null, new b(null), null, null, null, org.apache.commons.net.telnet.f.f51103s, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.a y() {
        return new com.bxkj.student.v2.repository.a();
    }

    public final void B(@NotNull Function2<? super String, ? super String, n1> success) {
        kotlin.jvm.internal.g0.p(success, "success");
        BaseViewModel.j(this, new d(success, null), null, null, null, null, null, null, null, 254, null);
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> C() {
        return this.f22106h;
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> D() {
        return this.f22109k;
    }

    public final void E(@NotNull Function1<? super String, n1> result) {
        kotlin.jvm.internal.g0.p(result, "result");
        k.f(ViewModelKt.getViewModelScope(this), g1.c(), null, new e(result, null), 2, null);
    }

    @NotNull
    public final ObservableField<String> G() {
        return this.f22108j;
    }

    public final void H(@NotNull Function2<? super String, ? super String, n1> success) {
        kotlin.jvm.internal.g0.p(success, "success");
        BaseViewModel.j(this, new f(success, null), null, null, null, null, null, null, null, 254, null);
    }

    @NotNull
    public final ObservableField<String> I() {
        return this.f22107i;
    }

    public final int J() {
        return this.f22110l;
    }

    public final void L(@NotNull Map<String, ? extends Object> resultDataMap) {
        kotlin.jvm.internal.g0.p(resultDataMap, "resultDataMap");
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        aVar.a().S0(false);
        com.bxkj.base.v2.data.b a6 = aVar.a();
        Object obj = resultDataMap.get(SocializeConstants.TENCENT_UID);
        if (obj == null) {
            obj = "";
        }
        a6.U0(String.valueOf(obj));
        if (aVar.a().R().length() <= 0) {
            Object obj2 = resultDataMap.get("code");
            Object obj3 = obj2 != null ? obj2 : "";
            Object obj4 = resultDataMap.get("msg");
            if (obj4 == null) {
                obj4 = AMapException.AMAP_CLIENT_UNKNOWN_ERROR;
            }
            if (kotlin.jvm.internal.g0.g(obj3, 1)) {
                e().postValue("登录失败," + obj4);
                return;
            }
            return;
        }
        com.bxkj.base.v2.data.b a7 = aVar.a();
        Object obj5 = resultDataMap.get("username");
        if (obj5 == null) {
            obj5 = "";
        }
        a7.W0(String.valueOf(obj5));
        com.bxkj.base.v2.data.b a8 = aVar.a();
        Object obj6 = resultDataMap.get("access_token");
        if (obj6 == null) {
            obj6 = "";
        }
        a8.e0(String.valueOf(obj6));
        com.bxkj.base.v2.data.b a9 = aVar.a();
        Object obj7 = resultDataMap.get("refresh_token");
        if (obj7 == null) {
            obj7 = "";
        }
        a9.K0(String.valueOf(obj7));
        com.bxkj.base.v2.data.b a10 = aVar.a();
        Object obj8 = resultDataMap.get("refresh_token");
        if (obj8 == null) {
            obj8 = "";
        }
        a10.K0(String.valueOf(obj8));
        int parseDouble = (int) Double.parseDouble(c0.f16887a.t(resultDataMap, "dept_id"));
        aVar.a().X0("");
        aVar.a().k0(String.valueOf(parseDouble));
        x();
    }

    public final void M(@NotNull String openId, @NotNull String type) {
        kotlin.jvm.internal.g0.p(openId, "openId");
        kotlin.jvm.internal.g0.p(type, "type");
        BaseViewModel.j(this, new h(openId, type, null), null, null, null, null, null, null, null, 254, null);
    }

    public final void N(@NotNull FragmentActivity mActivity, @NotNull String openId, @NotNull String type, @NotNull String thirdName, @NotNull String thirdImage, @NotNull Function0<n1> success) {
        kotlin.jvm.internal.g0.p(mActivity, "mActivity");
        kotlin.jvm.internal.g0.p(openId, "openId");
        kotlin.jvm.internal.g0.p(type, "type");
        kotlin.jvm.internal.g0.p(thirdName, "thirdName");
        kotlin.jvm.internal.g0.p(thirdImage, "thirdImage");
        kotlin.jvm.internal.g0.p(success, "success");
        BaseViewModel.j(this, new i(openId, type, success, mActivity, thirdName, thirdImage, null), null, null, null, null, null, null, null, 254, null);
    }

    public final void P(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22109k = mutableLiveData;
    }

    public final void Q(int i6) {
        this.f22110l = i6;
    }

    public final void R(@NotNull ObservableField<String> observableField) {
        kotlin.jvm.internal.g0.p(observableField, "<set-?>");
        this.f22108j = observableField;
    }

    public final void S(@NotNull ObservableField<String> observableField) {
        kotlin.jvm.internal.g0.p(observableField, "<set-?>");
        this.f22107i = observableField;
    }

    public final void z(@NotNull Function2<? super String, ? super String, n1> success) {
        kotlin.jvm.internal.g0.p(success, "success");
        BaseViewModel.j(this, new c(success, null), null, null, null, null, null, null, null, 254, null);
    }

    public final void K() {
        d().setValue("正在登录...");
        BaseViewModel.j(this, new g(null), null, null, null, null, null, null, null, 254, null);
    }
}
