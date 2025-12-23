package com.bxkj.student.v2.vm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.data.b;
import com.bxkj.base.v2.http.result.OldApiResult;
import com.bxkj.student.App;
import com.bxkj.student.v2.common.db.AppDatabase;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.f0;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlin.s;
import kotlin.t;
import kotlin.text.u;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.r0;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMainViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainViewModel.kt\ncom/bxkj/student/v2/vm/MainViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,618:1\n1563#2:619\n1634#2,3:620\n1869#2:623\n1870#2:625\n1878#2,3:626\n1563#2:629\n1634#2,3:630\n1#3:624\n*S KotlinDebug\n*F\n+ 1 MainViewModel.kt\ncom/bxkj/student/v2/vm/MainViewModel\n*L\n264#1:619\n264#1:620,3\n298#1:623\n298#1:625\n309#1:626,3\n413#1:629\n413#1:630,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class MainViewModel extends BaseViewModel {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final s f22159h = t.c(new Function0() { // from class: com.bxkj.student.v2.vm.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.my.a v5;
            v5 = MainViewModel.v();
            return v5;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private MutableLiveData<List<Map<String, Object>>> f22160i = new MutableLiveData<>();

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private MutableLiveData<List<Map<String, Object>>> f22161j = new MutableLiveData<>();

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private MutableLiveData<String> f22162k = new MutableLiveData<>();

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private MutableLiveData<Map<String, Object>> f22163l = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private MutableLiveData<List<Map<String, Object>>> f22164m = new MutableLiveData<>();

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private MutableLiveData<List<Map<String, Object>>> f22165n = new MutableLiveData<>();

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private MutableLiveData<List<Map<String, Object>>> f22166o = new MutableLiveData<>();

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private MutableLiveData<Map<String, Object>> f22167p = new MutableLiveData<>();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private MutableLiveData<Map<String, Object>> f22168q = new MutableLiveData<>();

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    private MutableLiveData<Boolean> f22169r = new MutableLiveData<>();

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    private final s f22170s = t.c(new Function0() { // from class: com.bxkj.student.v2.vm.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.c k02;
            k02 = MainViewModel.k0();
            return k02;
        }
    });

    /* renamed from: t, reason: collision with root package name */
    private final long f22171t = 1722837718539L;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    private MutableLiveData<Boolean> f22172u = new MutableLiveData<>();

    /* renamed from: v, reason: collision with root package name */
    private boolean f22173v;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$clickArticle$1", f = "MainViewModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVREAGE_BITRATE_DIFF}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22174a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f22176c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f22176c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return MainViewModel.this.new a(this.f22176c, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22174a;
            try {
                if (i6 != 0) {
                    if (i6 == 1) {
                        g0.n(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    g0.n(obj);
                    com.bxkj.student.v2.repository.c b02 = MainViewModel.this.b0();
                    String str = this.f22176c;
                    this.f22174a = 1;
                    if (b02.a(str, this) == l6) {
                        return l6;
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$downloadMenuIcon$2", f = "MainViewModel.kt", i = {0, 0}, l = {org.apache.commons.net.nntp.h.E}, m = "invokeSuspend", n = {"it", "$i$a$-let-MainViewModel$downloadMenuIcon$2$2"}, s = {"L$0", "I$0"})
    @SourceDebugExtension({"SMAP\nMainViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainViewModel.kt\ncom/bxkj/student/v2/vm/MainViewModel$downloadMenuIcon$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,618:1\n1#2:619\n*E\n"})
    static final class b extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22177a;

        /* renamed from: b, reason: collision with root package name */
        int f22178b;

        /* renamed from: c, reason: collision with root package name */
        int f22179c;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f22181e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f22182f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, String str2, kotlin.coroutines.e<? super b> eVar) {
            super(2, eVar);
            this.f22181e = str;
            this.f22182f = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return MainViewModel.this.new b(this.f22181e, this.f22182f, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((b) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22179c;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                File G = MainViewModel.this.G(this.f22181e, this.f22182f);
                if (G != null) {
                    if (!G.exists()) {
                        G = null;
                    }
                    if (G != null) {
                        String str = this.f22182f;
                        com.bxkj.student.v2.common.db.dao.l w5 = AppDatabase.f20686a.a().w();
                        if (w5 != null) {
                            String path = G.getPath();
                            kotlin.jvm.internal.g0.o(path, "getPath(...)");
                            this.f22177a = kotlin.coroutines.jvm.internal.j.a(G);
                            this.f22178b = 0;
                            this.f22179c = 1;
                            if (w5.i(path, str, this) == l6) {
                                return l6;
                            }
                        }
                    }
                }
                return null;
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$downloadMenuIconS$2", f = "MainViewModel.kt", i = {0, 0}, l = {452}, m = "invokeSuspend", n = {"it", "$i$a$-let-MainViewModel$downloadMenuIconS$2$2"}, s = {"L$0", "I$0"})
    @SourceDebugExtension({"SMAP\nMainViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainViewModel.kt\ncom/bxkj/student/v2/vm/MainViewModel$downloadMenuIconS$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,618:1\n1#2:619\n*E\n"})
    static final class c extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22183a;

        /* renamed from: b, reason: collision with root package name */
        int f22184b;

        /* renamed from: c, reason: collision with root package name */
        int f22185c;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f22187e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f22188f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, String str2, kotlin.coroutines.e<? super c> eVar) {
            super(2, eVar);
            this.f22187e = str;
            this.f22188f = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return MainViewModel.this.new c(this.f22187e, this.f22188f, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((c) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22185c;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                File G = MainViewModel.this.G(this.f22187e, this.f22188f + "s");
                if (G != null) {
                    if (!G.exists()) {
                        G = null;
                    }
                    if (G != null) {
                        String str = this.f22188f;
                        com.bxkj.student.v2.common.db.dao.l w5 = AppDatabase.f20686a.a().w();
                        if (w5 != null) {
                            String path = G.getPath();
                            kotlin.jvm.internal.g0.o(path, "getPath(...)");
                            this.f22183a = kotlin.coroutines.jvm.internal.j.a(G);
                            this.f22184b = 0;
                            this.f22185c = 1;
                            if (w5.b(path, str, this) == l6) {
                                return l6;
                            }
                        }
                    }
                }
                return null;
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$getAllClassifyMenusWithChildren$2", f = "MainViewModel.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nMainViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainViewModel.kt\ncom/bxkj/student/v2/vm/MainViewModel$getAllClassifyMenusWithChildren$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,618:1\n1491#2:619\n1516#2,3:620\n1519#2,3:630\n1563#2:633\n1634#2,2:634\n1563#2:636\n1634#2,3:637\n1636#2:640\n382#3,7:623\n*S KotlinDebug\n*F\n+ 1 MainViewModel.kt\ncom/bxkj/student/v2/vm/MainViewModel$getAllClassifyMenusWithChildren$2\n*L\n120#1:619\n120#1:620,3\n120#1:630,3\n126#1:633\n126#1:634,2\n133#1:636\n133#1:637,3\n126#1:640\n120#1:623,7\n*E\n"})
    static final class d extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super List<? extends Map<String, ? extends Object>>>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22189a;

        d(kotlin.coroutines.e<? super d> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new d(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super List<? extends Map<String, ? extends Object>>> eVar) {
            return ((d) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0039  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r27) {
            /*
                Method dump skipped, instructions count: 487
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.MainViewModel.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$getBanner$1", f = "MainViewModel.kt", i = {}, l = {571}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nMainViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainViewModel.kt\ncom/bxkj/student/v2/vm/MainViewModel$getBanner$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,618:1\n1#2:619\n*E\n"})
    static final class e extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22190a;

        e(kotlin.coroutines.e<? super e> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return MainViewModel.this.new e(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((e) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22190a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                b.a aVar = com.bxkj.base.v2.data.b.f16998d;
                if (!com.bxkj.base.v2.common.ext.g.f(aVar.a().v())) {
                    com.bxkj.student.v2.repository.c b02 = MainViewModel.this.b0();
                    this.f22190a = 1;
                    obj = b02.b(this);
                    if (obj == l6) {
                        return l6;
                    }
                } else {
                    com.orhanobut.logger.j.e("获取首页轮播图接口当天只调用一次", new Object[0]);
                    MainViewModel.this.N().postValue(f0.d6(c0.f16887a.z(aVar.a().k())));
                    return n1.f44123a;
                }
            }
            List<Map<String, Object>> list = (List) obj;
            b.a aVar2 = com.bxkj.base.v2.data.b.f16998d;
            aVar2.a().t0(System.currentTimeMillis());
            com.bxkj.base.v2.data.b a6 = aVar2.a();
            String jSONString = JSON.toJSONString(list);
            kotlin.jvm.internal.g0.o(jSONString, "toJSONString(...)");
            a6.i0(jSONString);
            if (list != null) {
                MainViewModel.this.N().postValue(list);
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$getClassifyMenu$1", f = "MainViewModel.kt", i = {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {165, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, 192, 198}, m = "invokeSuspend", n = {"classifyMenuWithChildren", "classifyMenuWithChildren", "onlineClassifyMenu", "it", "needUpdate", "$this$forEach$iv", "element$iv", "it", "menuType", "childMenuList", "$i$a$-let-MainViewModel$getClassifyMenu$1$2", "$i$f$forEach", "$i$a$-forEach-MainViewModel$getClassifyMenu$1$2$1", "classifyMenuWithChildren", "onlineClassifyMenu", "it", "needUpdate", "$i$a$-let-MainViewModel$getClassifyMenu$1$2"}, s = {"L$0", "L$0", "L$1", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "I$0"})
    @SourceDebugExtension({"SMAP\nMainViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainViewModel.kt\ncom/bxkj/student/v2/vm/MainViewModel$getClassifyMenu$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,618:1\n1563#2:619\n1634#2,3:620\n1869#2,2:623\n*S KotlinDebug\n*F\n+ 1 MainViewModel.kt\ncom/bxkj/student/v2/vm/MainViewModel$getClassifyMenu$1\n*L\n177#1:619\n177#1:620,3\n188#1:623,2\n*E\n"})
    static final class f extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22192a;

        /* renamed from: b, reason: collision with root package name */
        Object f22193b;

        /* renamed from: c, reason: collision with root package name */
        Object f22194c;

        /* renamed from: d, reason: collision with root package name */
        Object f22195d;

        /* renamed from: e, reason: collision with root package name */
        Object f22196e;

        /* renamed from: f, reason: collision with root package name */
        Object f22197f;

        /* renamed from: g, reason: collision with root package name */
        Object f22198g;

        /* renamed from: h, reason: collision with root package name */
        Object f22199h;

        /* renamed from: i, reason: collision with root package name */
        Object f22200i;

        /* renamed from: j, reason: collision with root package name */
        Object f22201j;

        /* renamed from: k, reason: collision with root package name */
        Object f22202k;

        /* renamed from: l, reason: collision with root package name */
        int f22203l;

        /* renamed from: m, reason: collision with root package name */
        int f22204m;

        /* renamed from: n, reason: collision with root package name */
        int f22205n;

        /* renamed from: o, reason: collision with root package name */
        int f22206o;

        f(kotlin.coroutines.e<? super f> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return MainViewModel.this.new f(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((f) create(eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0209, code lost:
        
            if (r0.x0(r21, "2", r3, r4, r22) == r8) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00d3, code lost:
        
            if (r1 == r8) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0098, code lost:
        
            if (r0 == r8) goto L40;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:16:0x01be  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x014a  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x01c8  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x01c2  */
        /* JADX WARN: Type inference failed for: r6v6, types: [java.util.List] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x01af -> B:14:0x01b2). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r23) {
            /*
                Method dump skipped, instructions count: 527
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.MainViewModel.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$getClassifyMenu$2", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class g extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22208a;

        g(kotlin.coroutines.e<? super g> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return MainViewModel.this.new g(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((g) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22208a == 0) {
                g0.n(obj);
                MainViewModel.this.o0(false);
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$getHomeMenu$1", f = "MainViewModel.kt", i = {1, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4}, l = {71, 75, 87, 103, 105}, m = "invokeSuspend", n = {"localNavMenu", "localNavMenu", "homeMenu", "localNavMenu", "homeMenu", "resultDataMap", "onlineNavMenus", "informationLinkUrl", "commonMenus", "localNavMenu", "homeMenu", "resultDataMap", "onlineNavMenus", "informationLinkUrl", "commonMenus"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    @SourceDebugExtension({"SMAP\nMainViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainViewModel.kt\ncom/bxkj/student/v2/vm/MainViewModel$getHomeMenu$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,618:1\n1#2:619\n*E\n"})
    static final class h extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22210a;

        /* renamed from: b, reason: collision with root package name */
        Object f22211b;

        /* renamed from: c, reason: collision with root package name */
        Object f22212c;

        /* renamed from: d, reason: collision with root package name */
        Object f22213d;

        /* renamed from: e, reason: collision with root package name */
        Object f22214e;

        /* renamed from: f, reason: collision with root package name */
        Object f22215f;

        /* renamed from: g, reason: collision with root package name */
        int f22216g;

        h(kotlin.coroutines.e<? super h> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return MainViewModel.this.new h(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((h) create(eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x01f0, code lost:
        
            if (com.bxkj.student.v2.vm.MainViewModel.y0(r0, r1, "1", r3, null, r15, 8, null) != r8) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00aa, code lost:
        
            if (r3 == r8) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0089, code lost:
        
            if (r0 == r8) goto L48;
         */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0149  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x014c  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x01b3  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r16) {
            /*
                Method dump skipped, instructions count: 502
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.MainViewModel.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$getLatestUnreadNotice$1", f = "MainViewModel.kt", i = {}, l = {599}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nMainViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainViewModel.kt\ncom/bxkj/student/v2/vm/MainViewModel$getLatestUnreadNotice$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,618:1\n1#2:619\n*E\n"})
    static final class i extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22218a;

        i(kotlin.coroutines.e<? super i> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return MainViewModel.this.new i(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((i) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22218a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                if (!com.bxkj.base.v2.common.ext.g.e(com.bxkj.base.v2.data.b.f16998d.a().x())) {
                    com.bxkj.student.v2.repository.c b02 = MainViewModel.this.b0();
                    this.f22218a = 1;
                    obj = com.bxkj.student.v2.repository.c.f(b02, null, this, 1, null);
                    if (obj == l6) {
                        return l6;
                    }
                } else {
                    com.orhanobut.logger.j.e("获取首页重要通知接口1个小时只调用一次", new Object[0]);
                    return n1.f44123a;
                }
            }
            Map<String, Object> map = (Map) obj;
            com.bxkj.base.v2.data.b.f16998d.a().v0(System.currentTimeMillis());
            if (map != null) {
                MainViewModel.this.W().postValue(map);
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel", f = "MainViewModel.kt", i = {0, 1}, l = {263, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME}, m = "getLocalMenu", n = {"menuType", "menuType"}, s = {"L$0", "L$0"})
    static final class j extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f22220a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f22221b;

        /* renamed from: d, reason: collision with root package name */
        int f22223d;

        j(kotlin.coroutines.e<? super j> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f22221b = obj;
            this.f22223d |= Integer.MIN_VALUE;
            return MainViewModel.this.Y(null, this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$getLoginUserInfo$1", f = "MainViewModel.kt", i = {}, l = {547}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nMainViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainViewModel.kt\ncom/bxkj/student/v2/vm/MainViewModel$getLoginUserInfo$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,618:1\n1#2:619\n*E\n"})
    static final class k extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22224a;

        k(kotlin.coroutines.e<? super k> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return MainViewModel.this.new k(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((k) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22224a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.c b02 = MainViewModel.this.b0();
                this.f22224a = 1;
                obj = b02.g(this);
                if (obj == l6) {
                    return l6;
                }
            }
            Map<String, Object> map = (Map) obj;
            if (map != null) {
                MainViewModel.this.e0().postValue(map);
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$getMyMenu$1", f = "MainViewModel.kt", i = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4}, l = {213, 219, org.apache.commons.net.ftp.l.f50688o, 246, 252}, m = "invokeSuspend", n = {"localMyMenu", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "mutableMapOf", "nextLeverMenuType", "$i$f$map", "$i$f$mapTo", "$i$a$-map-MainViewModel$getMyMenu$1$1", "localMyMenu", "localMyMenu", "onlineMyMenu", "it", "needUpdate", "$this$forEach$iv", "element$iv", "it", "menuType", "childMenuList", "$i$a$-let-MainViewModel$getMyMenu$1$4", "$i$f$forEach", "$i$a$-forEach-MainViewModel$getMyMenu$1$4$1", "localMyMenu", "onlineMyMenu", "it", "needUpdate", "$i$a$-let-MainViewModel$getMyMenu$1$4"}, s = {"L$0", "L$1", "L$3", "L$4", "L$6", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2", "L$0", "L$0", "L$1", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "I$0"})
    @SourceDebugExtension({"SMAP\nMainViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainViewModel.kt\ncom/bxkj/student/v2/vm/MainViewModel$getMyMenu$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,618:1\n1563#2:619\n1634#2,3:620\n1563#2:624\n1634#2,3:625\n1869#2,2:628\n1#3:623\n*S KotlinDebug\n*F\n+ 1 MainViewModel.kt\ncom/bxkj/student/v2/vm/MainViewModel$getMyMenu$1\n*L\n214#1:619\n214#1:620,3\n232#1:624\n232#1:625,3\n243#1:628,2\n*E\n"})
    static final class l extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22226a;

        /* renamed from: b, reason: collision with root package name */
        Object f22227b;

        /* renamed from: c, reason: collision with root package name */
        Object f22228c;

        /* renamed from: d, reason: collision with root package name */
        Object f22229d;

        /* renamed from: e, reason: collision with root package name */
        Object f22230e;

        /* renamed from: f, reason: collision with root package name */
        Object f22231f;

        /* renamed from: g, reason: collision with root package name */
        Object f22232g;

        /* renamed from: h, reason: collision with root package name */
        Object f22233h;

        /* renamed from: i, reason: collision with root package name */
        Object f22234i;

        /* renamed from: j, reason: collision with root package name */
        Object f22235j;

        /* renamed from: k, reason: collision with root package name */
        Object f22236k;

        /* renamed from: l, reason: collision with root package name */
        Object f22237l;

        /* renamed from: m, reason: collision with root package name */
        Object f22238m;

        /* renamed from: n, reason: collision with root package name */
        int f22239n;

        /* renamed from: o, reason: collision with root package name */
        int f22240o;

        /* renamed from: p, reason: collision with root package name */
        int f22241p;

        /* renamed from: q, reason: collision with root package name */
        int f22242q;

        l(kotlin.coroutines.e<? super l> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return MainViewModel.this.new l(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((l) create(eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x02cb, code lost:
        
            if (r1 == r8) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0321, code lost:
        
            if (r0.x0(r19, "5", r3, r4, r24) == r8) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x01f9, code lost:
        
            if (r3 != r8) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00f5, code lost:
        
            if (r0 == r8) goto L55;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0264  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x02e1  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x011f  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x01a6  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x01c4  */
        /* JADX WARN: Type inference failed for: r4v22, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r6v15, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r6v18, types: [java.util.List] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x02cb -> B:15:0x02ce). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0187 -> B:35:0x0193). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) {
            /*
                Method dump skipped, instructions count: 807
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.MainViewModel.l.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$getVersionCode$1", f = "MainViewModel.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
    static final class m extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22244a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Map<String, Object>> f22246c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(Ref.ObjectRef<Map<String, Object>> objectRef, kotlin.coroutines.e<? super m> eVar) {
            super(1, eVar);
            this.f22246c = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return MainViewModel.this.new m(this.f22246c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((m) create(eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Type inference failed for: r4v7, types: [T, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22244a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.my.a K = MainViewModel.this.K();
                this.f22244a = 1;
                obj = K.b(this);
                if (obj == l6) {
                    return l6;
                }
            }
            OldApiResult oldApiResult = (OldApiResult) obj;
            if (oldApiResult != null) {
                this.f22246c.element = oldApiResult.getData();
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$getVersionCode$2", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class n extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22247a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Map<String, Object>, n1> f22248b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Map<String, Object>> f22249c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        n(Function1<? super Map<String, Object>, n1> function1, Ref.ObjectRef<Map<String, Object>> objectRef, kotlin.coroutines.e<? super n> eVar) {
            super(1, eVar);
            this.f22248b = function1;
            this.f22249c = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new n(this.f22248b, this.f22249c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((n) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22247a == 0) {
                g0.n(obj);
                this.f22248b.invoke(this.f22249c.element);
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$isDefaultPass$1", f = "MainViewModel.kt", i = {}, l = {583}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nMainViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainViewModel.kt\ncom/bxkj/student/v2/vm/MainViewModel$isDefaultPass$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,618:1\n1#2:619\n*E\n"})
    static final class o extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22250a;

        o(kotlin.coroutines.e<? super o> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return MainViewModel.this.new o(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((o) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22250a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.c b02 = MainViewModel.this.b0();
                this.f22250a = 1;
                obj = b02.j(this);
                if (obj == l6) {
                    return l6;
                }
            }
            Map<String, Object> map = (Map) obj;
            if (map != null) {
                MainViewModel.this.i0().postValue(map);
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel$logout$1", f = "MainViewModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY}, m = "invokeSuspend", n = {}, s = {})
    static final class p extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22252a;

        p(kotlin.coroutines.e<? super p> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return MainViewModel.this.new p(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((p) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22252a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.c b02 = MainViewModel.this.b0();
                this.f22252a = 1;
                if (b02.k(this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.MainViewModel", f = "MainViewModel.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX, 303, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR, 357, MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_STALL_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND, 406, TTAdConstant.DEEPLINK_FALL_BACK_CODE}, m = "updateLocalData", n = {"onlineMenus", "menuType", "refreshLiveData", "forceUpdate", "needUpdate", "onlineMenus", "menuType", "refreshLiveData", "forceUpdate", "needUpdate", "$this$forEach$iv", "element$iv", "localMenu", "localMenuKey", "find", "$i$f$forEach", "$i$a$-forEach-MainViewModel$updateLocalData$2", "onlineMenus", "menuType", "refreshLiveData", "forceUpdate", "needUpdate", "$this$forEachIndexed$iv", "item$iv", "map", "key", "lastUploadTime", CommonNetImpl.NAME, "sort", "isShow", "isEnabled", "linkUrl", "isShowIndex", "isShowH5Title", "$i$f$forEachIndexed", "index$iv", "index", "$i$a$-forEachIndexed-MainViewModel$updateLocalData$3", "isLogin", "onlineMenus", "menuType", "refreshLiveData", "forceUpdate", "needUpdate", "$this$forEachIndexed$iv", "item$iv", "map", "key", "lastUploadTime", CommonNetImpl.NAME, "sort", "isShow", "isEnabled", "linkUrl", "isShowIndex", "isShowH5Title", "navMenu", "localMenuInfo", "$i$f$forEachIndexed", "index$iv", "index", "$i$a$-forEachIndexed-MainViewModel$updateLocalData$3", "isLogin", "onlineMenus", "menuType", "refreshLiveData", "forceUpdate", "needUpdate", "$this$forEachIndexed$iv", "item$iv", "map", "key", "lastUploadTime", CommonNetImpl.NAME, "sort", "isShow", "isEnabled", "linkUrl", "isShowIndex", "isShowH5Title", "navMenu", "localMenuInfo", "iconSUrl", "iconUrl", "it", "$i$f$forEachIndexed", "index$iv", "index", "$i$a$-forEachIndexed-MainViewModel$updateLocalData$3", "isLogin", "$i$a$-let-MainViewModel$updateLocalData$3$3", "onlineMenus", "menuType", "refreshLiveData", "forceUpdate", "needUpdate", "$this$forEachIndexed$iv", "item$iv", "map", "key", "lastUploadTime", CommonNetImpl.NAME, "sort", "isShow", "isEnabled", "linkUrl", "isShowIndex", "isShowH5Title", "navMenu", "localMenuInfo", "iconSUrl", "iconUrl", "it", "$i$f$forEachIndexed", "index$iv", "index", "$i$a$-forEachIndexed-MainViewModel$updateLocalData$3", "isLogin", "$i$a$-let-MainViewModel$updateLocalData$3$6", "onlineMenus", "menuType", "refreshLiveData", "forceUpdate", "needUpdate", "$this$forEachIndexed$iv", "item$iv", "map", "key", "lastUploadTime", CommonNetImpl.NAME, "sort", "isShow", "isEnabled", "linkUrl", "isShowIndex", "isShowH5Title", "localMenuInfo", "it", "$i$f$forEachIndexed", "index$iv", "index", "$i$a$-forEachIndexed-MainViewModel$updateLocalData$3", "isLogin", "$i$a$-let-MainViewModel$updateLocalData$3$8", "onlineMenus", "menuType", "refreshLiveData", "forceUpdate", "needUpdate", "$this$forEachIndexed$iv", "item$iv", "map", "key", "lastUploadTime", CommonNetImpl.NAME, "sort", "isShow", "isEnabled", "linkUrl", "isShowIndex", "isShowH5Title", "iconFile", "localMenuInfo", "iconUrl", "it", "$i$f$forEachIndexed", "index$iv", "index", "$i$a$-forEachIndexed-MainViewModel$updateLocalData$3", "isLogin", "$i$a$-let-MainViewModel$updateLocalData$3$11", "$i$a$-let-MainViewModel$updateLocalData$3$11$2", "onlineMenus", "menuType", "refreshLiveData", "forceUpdate", "needUpdate", "$this$forEachIndexed$iv", "item$iv", "map", "key", "lastUploadTime", CommonNetImpl.NAME, "sort", "isShow", "isEnabled", "linkUrl", "isShowIndex", "isShowH5Title", "iconFile", "localMenuInfo", "iconSUrl", "it", "$i$f$forEachIndexed", "index$iv", "index", "$i$a$-forEachIndexed-MainViewModel$updateLocalData$3", "isLogin", "$i$a$-let-MainViewModel$updateLocalData$3$15", "$i$a$-let-MainViewModel$updateLocalData$3$15$2", "onlineMenus", "menuType", "refreshLiveData", "forceUpdate", "needUpdate", "it", "$i$a$-let-MainViewModel$updateLocalData$5", "onlineMenus", "menuType", "refreshLiveData", "forceUpdate", "needUpdate", "it", "localMenu", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "mutableMapOf", "nextLeverMenuType", "$i$a$-let-MainViewModel$updateLocalData$5", "$i$f$map", "$i$f$mapTo", "$i$a$-map-MainViewModel$updateLocalData$5$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "I$0", "I$1", "I$2", "I$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "I$0", "I$1", "I$2", "I$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "I$0", "I$1", "I$2", "I$3", "Z$0", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "I$0", "I$1", "I$2", "I$3", "Z$0", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "I$0", "I$1", "I$2", "I$3", "Z$0", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "I$0", "I$1", "I$2", "I$3", "Z$0", "I$4", "I$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "I$0", "I$1", "I$2", "I$3", "Z$0", "I$4", "I$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$14", "L$15", "I$0", "I$1", "I$2", "I$3"})
    static final class q extends ContinuationImpl {
        int A;
        int B;
        int C;
        boolean D;
        /* synthetic */ Object E;
        int G;

        /* renamed from: a, reason: collision with root package name */
        Object f22254a;

        /* renamed from: b, reason: collision with root package name */
        Object f22255b;

        /* renamed from: c, reason: collision with root package name */
        Object f22256c;

        /* renamed from: d, reason: collision with root package name */
        Object f22257d;

        /* renamed from: e, reason: collision with root package name */
        Object f22258e;

        /* renamed from: f, reason: collision with root package name */
        Object f22259f;

        /* renamed from: g, reason: collision with root package name */
        Object f22260g;

        /* renamed from: h, reason: collision with root package name */
        Object f22261h;

        /* renamed from: i, reason: collision with root package name */
        Object f22262i;

        /* renamed from: j, reason: collision with root package name */
        Object f22263j;

        /* renamed from: k, reason: collision with root package name */
        Object f22264k;

        /* renamed from: l, reason: collision with root package name */
        Object f22265l;

        /* renamed from: m, reason: collision with root package name */
        Object f22266m;

        /* renamed from: n, reason: collision with root package name */
        Object f22267n;

        /* renamed from: o, reason: collision with root package name */
        Object f22268o;

        /* renamed from: p, reason: collision with root package name */
        Object f22269p;

        /* renamed from: q, reason: collision with root package name */
        Object f22270q;

        /* renamed from: r, reason: collision with root package name */
        Object f22271r;

        /* renamed from: s, reason: collision with root package name */
        Object f22272s;

        /* renamed from: t, reason: collision with root package name */
        Object f22273t;

        /* renamed from: u, reason: collision with root package name */
        Object f22274u;

        /* renamed from: v, reason: collision with root package name */
        Object f22275v;

        /* renamed from: w, reason: collision with root package name */
        Object f22276w;

        /* renamed from: x, reason: collision with root package name */
        int f22277x;

        /* renamed from: y, reason: collision with root package name */
        int f22278y;

        /* renamed from: z, reason: collision with root package name */
        int f22279z;

        q(kotlin.coroutines.e<? super q> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.E = obj;
            this.G |= Integer.MIN_VALUE;
            return MainViewModel.this.x0(null, null, null, null, this);
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x12d7 -> B:12:0x00c1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:212:0x0dc7 -> B:45:0x0dcb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:213:0x0dd7 -> B:46:0x0ddd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:217:0x0dfc -> B:47:0x1163). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:272:0x0705 -> B:252:0x0607). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:273:0x0715 -> B:254:0x0712). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:274:0x0748 -> B:256:0x0752). Please report as a decompilation issue!!! */
    public final java.lang.Object x0(java.util.List<? extends java.util.Map<java.lang.String, ? extends java.lang.Object>> r49, java.lang.String r50, androidx.lifecycle.MutableLiveData<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> r51, java.lang.Boolean r52, kotlin.coroutines.e<? super java.lang.Boolean> r53) {
        /*
            Method dump skipped, instructions count: 4958
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.MainViewModel.x0(java.util.List, java.lang.String, androidx.lifecycle.MutableLiveData, java.lang.Boolean, kotlin.coroutines.e):java.lang.Object");
    }

    private final File E(String str) {
        return new File(new File(App.f17573d.a().getFilesDir().getPath(), "icon"), str + com.bxkj.base.v2.common.utils.g0.f16898c);
    }

    /* JADX WARN: Finally extract failed */
    private final File H(String str, String str2) {
        try {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            SSLSocketFactory b6 = com.bxkj.base.v2.http.e.b();
            kotlin.jvm.internal.g0.o(b6, "getSSLSocketFactory(...)");
            TrustManager trustManager = com.bxkj.base.v2.http.e.c()[0];
            kotlin.jvm.internal.g0.n(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            OkHttpClient.Builder sslSocketFactory = builder.sslSocketFactory(b6, (X509TrustManager) trustManager);
            HostnameVerifier a6 = com.bxkj.base.v2.http.e.a();
            kotlin.jvm.internal.g0.o(a6, "getHostnameVerifier(...)");
            Response execute = sslSocketFactory.hostnameVerifier(a6).build().newCall(new Request.Builder().url(str).build()).execute();
            try {
                V(Response.header$default(execute, "Content-Type", null, 2, null));
                ResponseBody body = execute.body();
                if (body == null) {
                    kotlin.io.b.a(execute, null);
                    return null;
                }
                File file = new File(App.f17573d.a().getFilesDir().getPath(), "icon");
                if (!file.exists()) {
                    file.mkdir();
                }
                File file2 = new File(file, str2 + com.bxkj.base.v2.common.utils.g0.f16898c);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    InputStream byteStream = body.byteStream();
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = byteStream.read(bArr);
                            if (read == -1) {
                                n1 n1Var = n1.f44123a;
                                kotlin.io.b.a(byteStream, null);
                                kotlin.io.b.a(fileOutputStream, null);
                                kotlin.io.b.a(execute, null);
                                return file2;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    kotlin.io.b.a(execute, th);
                    throw th2;
                }
            }
        } catch (Exception e6) {
            File file3 = new File(new File(App.f17573d.a().getFilesDir().getPath(), "icon"), str2 + com.bxkj.base.v2.common.utils.g0.f16898c);
            if (file3.exists()) {
                file3.delete();
            }
            com.orhanobut.logger.j.d(com.bxkj.base.v2.common.ext.e.a(e6), new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.my.a K() {
        return (com.bxkj.student.v2.repository.my.a) this.f22159h.getValue();
    }

    private final String V(String str) {
        if (str != null) {
            if (u.l3(str, "image/jpeg", false, 2, null)) {
                return "jpg";
            }
            u.l3(str, "image/png", false, 2, null);
        }
        return "png";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0064, code lost:
    
        if (r8 == r1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0086, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0084, code lost:
    
        if (r8 == r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x013a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object Y(java.lang.String r7, kotlin.coroutines.e<? super java.util.List<? extends java.util.Map<java.lang.String, java.lang.Object>>> r8) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.MainViewModel.Y(java.lang.String, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.c b0() {
        return (com.bxkj.student.v2.repository.c) this.f22170s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.c k0() {
        return new com.bxkj.student.v2.repository.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.my.a v() {
        return new com.bxkj.student.v2.repository.my.a();
    }

    static /* synthetic */ Object y0(MainViewModel mainViewModel, List list, String str, MutableLiveData mutableLiveData, Boolean bool, kotlin.coroutines.e eVar, int i6, Object obj) {
        if ((i6 & 8) != 0) {
            bool = Boolean.FALSE;
        }
        return mainViewModel.x0(list, str, mutableLiveData, bool, eVar);
    }

    public final void F(@NotNull String id) {
        kotlin.jvm.internal.g0.p(id, "id");
        kotlinx.coroutines.k.f(ViewModelKt.getViewModelScope(this), null, null, new a(id, null), 3, null);
    }

    public final void M() {
        BaseViewModel.j(this, new e(null), null, null, null, null, null, null, null, 254, null);
    }

    @NotNull
    public final MutableLiveData<List<Map<String, Object>>> N() {
        return this.f22166o;
    }

    @NotNull
    public final MutableLiveData<List<Map<String, Object>>> O() {
        return this.f22160i;
    }

    public final void P() {
        BaseViewModel.j(this, new f(null), null, null, null, new g(null), null, null, null, org.apache.commons.net.telnet.f.f51103s, null);
    }

    @NotNull
    public final MutableLiveData<List<Map<String, Object>>> Q() {
        return this.f22164m;
    }

    @NotNull
    public final MutableLiveData<Boolean> R() {
        return this.f22172u;
    }

    public final void S() {
        BaseViewModel.j(this, new h(null), null, null, null, null, null, null, null, 254, null);
    }

    @NotNull
    public final MutableLiveData<List<Map<String, Object>>> T() {
        return this.f22161j;
    }

    @NotNull
    public final MutableLiveData<String> U() {
        return this.f22162k;
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> W() {
        return this.f22168q;
    }

    public final void X() {
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        if (aVar.a().Y() && aVar.a().c0()) {
            BaseViewModel.j(this, new i(null), null, null, null, null, null, null, null, 254, null);
        }
    }

    @NotNull
    public final MutableLiveData<Boolean> Z() {
        return this.f22169r;
    }

    public final void a0() {
        BaseViewModel.j(this, new k(null), null, null, null, null, null, null, null, 254, null);
    }

    public final void c0() {
        BaseViewModel.j(this, new l(null), null, null, null, null, null, null, null, 254, null);
    }

    @NotNull
    public final MutableLiveData<List<Map<String, Object>>> d0() {
        return this.f22165n;
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> e0() {
        return this.f22163l;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.LinkedHashMap] */
    public final void f0(@NotNull Function1<? super Map<String, Object>, n1> result) {
        kotlin.jvm.internal.g0.p(result, "result");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new LinkedHashMap();
        BaseViewModel.l(this, new m(objectRef, null), null, null, null, new n(result, objectRef, null), null, 46, null);
    }

    public final boolean g0() {
        return this.f22173v;
    }

    public final void h0() {
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        if (aVar.a().Y() && aVar.a().c0()) {
            BaseViewModel.j(this, new o(null), null, null, null, null, null, null, null, 254, null);
        }
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> i0() {
        return this.f22167p;
    }

    public final void j0() {
        BaseViewModel.j(this, new p(null), null, null, null, null, null, null, null, 254, null);
    }

    public final void l0(@NotNull MutableLiveData<List<Map<String, Object>>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22166o = mutableLiveData;
    }

    public final void m0(@NotNull MutableLiveData<List<Map<String, Object>>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22160i = mutableLiveData;
    }

    public final void n0(@NotNull MutableLiveData<List<Map<String, Object>>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22164m = mutableLiveData;
    }

    public final void o0(boolean z5) {
        this.f22173v = z5;
    }

    public final void p0(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22167p = mutableLiveData;
    }

    public final void q0(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22172u = mutableLiveData;
    }

    public final void r0(@NotNull MutableLiveData<List<Map<String, Object>>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22161j = mutableLiveData;
    }

    public final void s0(@NotNull MutableLiveData<String> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22162k = mutableLiveData;
    }

    public final void t0(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22168q = mutableLiveData;
    }

    public final void u0(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22169r = mutableLiveData;
    }

    public final void v0(@NotNull MutableLiveData<List<Map<String, Object>>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22165n = mutableLiveData;
    }

    public final void w0(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22163l = mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File G(String str, String str2) {
        File E = E(str2);
        if (E.exists()) {
            com.orhanobut.logger.j.m("图标已经缓存 " + E.getName(), new Object[0]);
            return E;
        }
        com.orhanobut.logger.j.e("从网络下载图片 url = " + str + " name = " + str2, new Object[0]);
        return H(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object I(String str, String str2, kotlin.coroutines.e<? super n1> eVar) {
        return kotlinx.coroutines.i.h(g1.c(), new b(str, str2, null), eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object J(String str, String str2, kotlin.coroutines.e<? super n1> eVar) {
        return kotlinx.coroutines.i.h(g1.c(), new c(str, str2, null), eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object L(kotlin.coroutines.e<? super List<? extends Map<String, ? extends Object>>> eVar) {
        return kotlinx.coroutines.i.h(g1.c(), new d(null), eVar);
    }
}
