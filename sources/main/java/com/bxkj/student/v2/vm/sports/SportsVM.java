package com.bxkj.student.v2.vm.sports;

import androidx.lifecycle.ViewModelKt;
import com.alibaba.fastjson.JSON;
import com.amap.api.maps.model.LatLng;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.http.exception.ApiException;
import com.bxkj.student.v2.common.data.PointData;
import com.bxkj.student.v2.common.data.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.collections.f0;
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
import kotlinx.coroutines.a1;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.h2;
import kotlinx.coroutines.r0;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class SportsVM extends BaseViewModel {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private Map<String, Object> f22544h = new LinkedHashMap();

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private final s f22545i = t.c(new Function0() { // from class: com.bxkj.student.v2.vm.sports.j
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.sports.b O;
            O = SportsVM.O();
            return O;
        }
    });

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private final s f22546j = t.c(new Function0() { // from class: com.bxkj.student.v2.vm.sports.k
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.sports.g U;
            U = SportsVM.U();
            return U;
        }
    });

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final s f22547k = t.c(new Function0() { // from class: com.bxkj.student.v2.vm.sports.l
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.face.c H;
            H = SportsVM.H();
            return H;
        }
    });

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private final s f22548l = t.c(new Function0() { // from class: com.bxkj.student.v2.vm.sports.m
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.sports.e T;
            T = SportsVM.T();
            return T;
        }
    });

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private e2 f22549m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    private e2 f22550n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    private e2 f22551o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    private e2 f22552p;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$commitV3$1", f = "SportsVM.kt", i = {0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 6, 6, 6}, l = {70, 74, 78, 87, 92, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START}, m = "invokeSuspend", n = {"uploadType", "sportsType", "uploadType", "sportsType", "uploadType", "$this$forEach$iv", "element$iv", "faceDb", "it", "faceFile", OptionalModuleUtils.FACE, "sportsType", "$i$f$forEach", "$i$a$-forEach-SportsVM$commitV3$1$3", "$i$a$-let-SportsVM$commitV3$1$3$1", "$i$a$-let-SportsVM$commitV3$1$3$1$2", "uploadType", "$this$forEach$iv", "element$iv", "faceDb", "it", "faceFile", OptionalModuleUtils.FACE, "sportsType", "$i$f$forEach", "$i$a$-forEach-SportsVM$commitV3$1$3", "$i$a$-let-SportsVM$commitV3$1$3$1", "$i$a$-let-SportsVM$commitV3$1$3$1$2", "uploadType", "sportsType", "uploadType", "commitV3", "sportsType", "uploadType", "commitV3", "sportsType"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "L$1", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0"})
    @SourceDebugExtension({"SMAP\nSportsVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportsVM.kt\ncom/bxkj/student/v2/vm/sports/SportsVM$commitV3$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,333:1\n1#2:334\n1869#3,2:335\n*S KotlinDebug\n*F\n+ 1 SportsVM.kt\ncom/bxkj/student/v2/vm/sports/SportsVM$commitV3$1\n*L\n74#1:335,2\n*E\n"})
    static final class a extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22553a;

        /* renamed from: b, reason: collision with root package name */
        int f22554b;

        /* renamed from: c, reason: collision with root package name */
        int f22555c;

        /* renamed from: d, reason: collision with root package name */
        int f22556d;

        /* renamed from: e, reason: collision with root package name */
        int f22557e;

        /* renamed from: f, reason: collision with root package name */
        Object f22558f;

        /* renamed from: g, reason: collision with root package name */
        Object f22559g;

        /* renamed from: h, reason: collision with root package name */
        Object f22560h;

        /* renamed from: i, reason: collision with root package name */
        Object f22561i;

        /* renamed from: j, reason: collision with root package name */
        Object f22562j;

        /* renamed from: k, reason: collision with root package name */
        Object f22563k;

        /* renamed from: l, reason: collision with root package name */
        Object f22564l;

        /* renamed from: m, reason: collision with root package name */
        Object f22565m;

        /* renamed from: n, reason: collision with root package name */
        Object f22566n;

        /* renamed from: o, reason: collision with root package name */
        Object f22567o;

        /* renamed from: p, reason: collision with root package name */
        int f22568p;

        /* renamed from: r, reason: collision with root package name */
        final /* synthetic */ String f22570r;

        /* renamed from: s, reason: collision with root package name */
        final /* synthetic */ long f22571s;

        /* renamed from: t, reason: collision with root package name */
        final /* synthetic */ long f22572t;

        /* renamed from: u, reason: collision with root package name */
        final /* synthetic */ long f22573u;

        /* renamed from: v, reason: collision with root package name */
        final /* synthetic */ List<Map<String, Object>> f22574v;

        /* renamed from: w, reason: collision with root package name */
        final /* synthetic */ Function2<String, String, n1> f22575w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(String str, long j6, long j7, long j8, List<? extends Map<String, ? extends Object>> list, Function2<? super String, ? super String, n1> function2, kotlin.coroutines.e<? super a> eVar) {
            super(1, eVar);
            this.f22570r = str;
            this.f22571s = j6;
            this.f22572t = j7;
            this.f22573u = j8;
            this.f22574v = list;
            this.f22575w = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SportsVM.this.new a(this.f22570r, this.f22571s, this.f22572t, this.f22573u, this.f22574v, this.f22575w, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x0255, code lost:
        
            r19 = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x013a, code lost:
        
            if (r2 == r9) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0102, code lost:
        
            if (r2 == r9) goto L16;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0418  */
        /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0158  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x023c  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0259  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x02f1  */
        /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x02f4  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x041b  */
        /* JADX WARN: Type inference failed for: r2v12, types: [T, java.lang.String] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x023c -> B:20:0x0244). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r37) {
            /*
                Method dump skipped, instructions count: 1088
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.SportsVM.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$commitV3$2", f = "SportsVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22576a;

        b(kotlin.coroutines.e<? super b> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SportsVM.this.new b(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((b) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22576a == 0) {
                g0.n(obj);
                e2 e2Var = SportsVM.this.f22550n;
                if (e2Var != null) {
                    e2.a.b(e2Var, null, 1, null);
                }
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$commitV3$3", f = "SportsVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<Exception, kotlin.coroutines.e<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22578a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f22580c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f22581d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f22582e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f22583f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Function1<String, n1> f22584g;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$commitV3$3$1", f = "SportsVM.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE}, m = "invokeSuspend", n = {}, s = {})
        static final class a extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f22585a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ SportsVM f22586b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f22587c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f22588d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ long f22589e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f22590f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ Function1<String, n1> f22591g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(SportsVM sportsVM, String str, String str2, long j6, String str3, Function1<? super String, n1> function1, kotlin.coroutines.e<? super a> eVar) {
                super(1, eVar);
                this.f22586b = sportsVM;
                this.f22587c = str;
                this.f22588d = str2;
                this.f22589e = j6;
                this.f22590f = str3;
                this.f22591g = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
                return new a(this.f22586b, this.f22587c, this.f22588d, this.f22589e, this.f22590f, this.f22591g, eVar);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
                return ((a) create(eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                a aVar;
                Object l6 = kotlin.coroutines.intrinsics.a.l();
                int i6 = this.f22585a;
                if (i6 != 0) {
                    if (i6 == 1) {
                        g0.n(obj);
                        aVar = this;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    g0.n(obj);
                    com.bxkj.student.v2.repository.sports.g L = this.f22586b.L();
                    String str = this.f22587c;
                    String str2 = this.f22588d;
                    String valueOf = String.valueOf(this.f22589e);
                    String str3 = this.f22590f;
                    this.f22585a = 1;
                    aVar = this;
                    if (L.e(str, str2, valueOf, str3, aVar) == l6) {
                        return l6;
                    }
                }
                aVar.f22591g.invoke(aVar.f22590f);
                com.orhanobut.logger.j.d("离线跑步，保存跑步记录！", new Object[0]);
                return n1.f44123a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(String str, String str2, long j6, String str3, Function1<? super String, n1> function1, kotlin.coroutines.e<? super c> eVar) {
            super(2, eVar);
            this.f22580c = str;
            this.f22581d = str2;
            this.f22582e = j6;
            this.f22583f = str3;
            this.f22584g = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return SportsVM.this.new c(this.f22580c, this.f22581d, this.f22582e, this.f22583f, this.f22584g, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Exception exc, kotlin.coroutines.e<? super Boolean> eVar) {
            return ((c) create(exc, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22578a == 0) {
                g0.n(obj);
                SportsVM sportsVM = SportsVM.this;
                BaseViewModel.j(sportsVM, new a(sportsVM, this.f22580c, this.f22581d, this.f22582e, this.f22583f, this.f22584g, null), null, null, null, null, null, null, null, 254, null);
                return kotlin.coroutines.jvm.internal.a.a(true);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$deleteThisRecorder$1", f = "SportsVM.kt", i = {0, 1, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_RES_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC}, m = "invokeSuspend", n = {"identify", "identify", "identify"}, s = {"L$0", "L$0", "L$0"})
    @SourceDebugExtension({"SMAP\nSportsVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportsVM.kt\ncom/bxkj/student/v2/vm/sports/SportsVM$deleteThisRecorder$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,333:1\n1869#2:334\n1870#2:336\n1#3:335\n*S KotlinDebug\n*F\n+ 1 SportsVM.kt\ncom/bxkj/student/v2/vm/sports/SportsVM$deleteThisRecorder$1\n*L\n275#1:334\n275#1:336\n*E\n"})
    static final class d extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22592a;

        /* renamed from: b, reason: collision with root package name */
        int f22593b;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f22595d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Function0<n1> function0, kotlin.coroutines.e<? super d> eVar) {
            super(1, eVar);
            this.f22595d = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SportsVM.this.new d(this.f22595d, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((d) create(eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x00ab, code lost:
        
            if (r7.a(r1, r6) == r0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0063, code lost:
        
            if (r7 == r0) goto L34;
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
                int r1 = r6.f22593b
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L32
                if (r1 == r4) goto L2a
                if (r1 == r3) goto L22
                if (r1 != r2) goto L1a
                java.lang.Object r0 = r6.f22592a
                java.lang.String r0 = (java.lang.String) r0
                kotlin.g0.n(r7)
                goto Lae
            L1a:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L22:
                java.lang.Object r1 = r6.f22592a
                java.lang.String r1 = (java.lang.String) r1
                kotlin.g0.n(r7)
                goto L66
            L2a:
                java.lang.Object r1 = r6.f22592a
                java.lang.String r1 = (java.lang.String) r1
                kotlin.g0.n(r7)
                goto L55
            L32:
                kotlin.g0.n(r7)
                com.bxkj.base.v2.common.utils.c0 r7 = com.bxkj.base.v2.common.utils.c0.f16887a
                com.bxkj.student.v2.common.data.i$a r1 = com.bxkj.student.v2.common.data.i.f20657a
                java.util.Map r1 = r1.B()
                java.lang.String r5 = "identify"
                java.lang.String r7 = r7.t(r1, r5)
                com.bxkj.student.v2.vm.sports.SportsVM r1 = com.bxkj.student.v2.vm.sports.SportsVM.this
                com.bxkj.student.v2.repository.sports.g r1 = com.bxkj.student.v2.vm.sports.SportsVM.D(r1)
                r6.f22592a = r7
                r6.f22593b = r4
                java.lang.Object r1 = r1.b(r7, r6)
                if (r1 != r0) goto L54
                goto Lad
            L54:
                r1 = r7
            L55:
                com.bxkj.student.v2.vm.sports.SportsVM r7 = com.bxkj.student.v2.vm.sports.SportsVM.this
                com.bxkj.student.v2.repository.sports.b r7 = com.bxkj.student.v2.vm.sports.SportsVM.B(r7)
                r6.f22592a = r1
                r6.f22593b = r3
                java.lang.Object r7 = r7.b(r1, r6)
                if (r7 != r0) goto L66
                goto Lad
            L66:
                java.util.List r7 = (java.util.List) r7
                if (r7 == 0) goto L99
                java.lang.Iterable r7 = (java.lang.Iterable) r7
                java.util.Iterator r7 = r7.iterator()
            L70:
                boolean r3 = r7.hasNext()
                if (r3 == 0) goto L99
                java.lang.Object r3 = r7.next()
                m0.b r3 = (m0.b) r3
                if (r3 == 0) goto L70
                java.io.File r4 = new java.io.File
                java.lang.String r3 = r3.j()
                r4.<init>(r3)
                boolean r3 = r4.exists()
                if (r3 == 0) goto L8e
                goto L8f
            L8e:
                r4 = 0
            L8f:
                if (r4 == 0) goto L70
                boolean r3 = r4.delete()
                kotlin.coroutines.jvm.internal.a.a(r3)
                goto L70
            L99:
                com.bxkj.student.v2.vm.sports.SportsVM r7 = com.bxkj.student.v2.vm.sports.SportsVM.this
                com.bxkj.student.v2.repository.sports.b r7 = com.bxkj.student.v2.vm.sports.SportsVM.B(r7)
                java.lang.Object r3 = kotlin.coroutines.jvm.internal.j.a(r1)
                r6.f22592a = r3
                r6.f22593b = r2
                java.lang.Object r7 = r7.a(r1, r6)
                if (r7 != r0) goto Lae
            Lad:
                return r0
            Lae:
                kotlin.jvm.functions.Function0<kotlin.n1> r7 = r6.f22595d
                r7.invoke()
                kotlin.n1 r7 = kotlin.n1.f44123a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.SportsVM.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$passPointCameraV2$1", f = "SportsVM.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME}, m = "invokeSuspend", n = {}, s = {})
    static final class e extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22596a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f22598c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f22599d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ File f22600e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f22601f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, String str2, File file, Function0<n1> function0, kotlin.coroutines.e<? super e> eVar) {
            super(1, eVar);
            this.f22598c = str;
            this.f22599d = str2;
            this.f22600e = file;
            this.f22601f = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SportsVM.this.new e(this.f22598c, this.f22599d, this.f22600e, this.f22601f, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((e) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22596a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.sports.g L = SportsVM.this.L();
                String str = this.f22598c;
                String str2 = this.f22599d;
                File file = this.f22600e;
                this.f22596a = 1;
                if (L.d(str, str2, file, this) == l6) {
                    return l6;
                }
            }
            this.f22601f.invoke();
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$resumeContinue$1", f = "SportsVM.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT}, m = "invokeSuspend", n = {}, s = {})
    static final class f extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22602a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f22604c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f22605d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, Function0<n1> function0, kotlin.coroutines.e<? super f> eVar) {
            super(1, eVar);
            this.f22604c = str;
            this.f22605d = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SportsVM.this.new f(this.f22604c, this.f22605d, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((f) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22602a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.sports.e K = SportsVM.this.K();
                String str = this.f22604c;
                this.f22602a = 1;
                if (K.a(str, this) == l6) {
                    return l6;
                }
            }
            this.f22605d.invoke();
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$resumeContinue$2", f = "SportsVM.kt", i = {}, l = {300}, m = "invokeSuspend", n = {}, s = {})
    static final class g extends SuspendLambda implements Function2<ApiException, kotlin.coroutines.e<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22606a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f22607b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, kotlin.coroutines.e<? super g> eVar) {
            super(2, eVar);
            this.f22607b = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new g(this.f22607b, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(ApiException apiException, kotlin.coroutines.e<? super Boolean> eVar) {
            return ((g) create(apiException, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22606a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.sports.g gVar = new com.bxkj.student.v2.repository.sports.g();
                String str = this.f22607b;
                this.f22606a = 1;
                if (gVar.f("3", str, this) == l6) {
                    return l6;
                }
            }
            return kotlin.coroutines.jvm.internal.a.a(false);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$resumeContinue$3", f = "SportsVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class h extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22608a;

        h(kotlin.coroutines.e<? super h> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SportsVM.this.new h(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((h) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22608a == 0) {
                g0.n(obj);
                e2 e2Var = SportsVM.this.f22552p;
                if (e2Var != null) {
                    e2.a.b(e2Var, null, 1, null);
                }
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$resumeContinue$4", f = "SportsVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class i extends SuspendLambda implements Function2<Exception, kotlin.coroutines.e<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22610a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f22611b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f22612c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(Function0<n1> function0, kotlin.coroutines.e<? super i> eVar) {
            super(2, eVar);
            this.f22612c = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            i iVar = new i(this.f22612c, eVar);
            iVar.f22611b = obj;
            return iVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Exception exc = (Exception) this.f22611b;
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22610a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            g0.n(obj);
            boolean z5 = false;
            if (com.bxkj.base.v2.common.ext.e.b(exc)) {
                com.orhanobut.logger.j.e(exc.toString(), new Object[0]);
                com.orhanobut.logger.j.d("离线跑步直接没办法验证超时时间", new Object[0]);
                this.f22612c.invoke();
                z5 = true;
            }
            return kotlin.coroutines.jvm.internal.a.a(z5);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Exception exc, kotlin.coroutines.e<? super Boolean> eVar) {
            return ((i) create(exc, eVar)).invokeSuspend(n1.f44123a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$resumeLocalData$1", f = "SportsVM.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nSportsVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportsVM.kt\ncom/bxkj/student/v2/vm/sports/SportsVM$resumeLocalData$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,333:1\n1#2:334\n1869#3,2:335\n*S KotlinDebug\n*F\n+ 1 SportsVM.kt\ncom/bxkj/student/v2/vm/sports/SportsVM$resumeLocalData$1\n*L\n250#1:335,2\n*E\n"})
    static final class j extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22613a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f22615c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<m0.d> f22616d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(String str, Ref.ObjectRef<m0.d> objectRef, kotlin.coroutines.e<? super j> eVar) {
            super(1, eVar);
            this.f22615c = str;
            this.f22616d = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SportsVM.this.new j(this.f22615c, this.f22616d, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((j) create(eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v9, types: [T, java.lang.Object, m0.d] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            double parseDouble;
            List list;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22613a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.sports.g L = SportsVM.this.L();
                String str = this.f22615c;
                this.f22613a = 1;
                obj = L.c(str, this);
                if (obj == l6) {
                    return l6;
                }
            }
            List list2 = (List) obj;
            if (list2 != null) {
                List<Integer> list3 = null;
                if (list2.isEmpty()) {
                    list2 = null;
                }
                if (list2 != null) {
                    Ref.ObjectRef<m0.d> objectRef = this.f22616d;
                    int i7 = 0;
                    ?? r11 = (m0.d) list2.get(0);
                    if (r11 != 0) {
                        objectRef.element = r11;
                        com.orhanobut.logger.j.d("从数据库恢复的数据" + ((Object) r11), new Object[0]);
                        i.a aVar = com.bxkj.student.v2.common.data.i.f20657a;
                        aVar.x().clear();
                        List<Map<String, Object>> x5 = aVar.x();
                        c0 c0Var = c0.f16887a;
                        x5.addAll(f0.d6(c0Var.z(r11.L())));
                        aVar.r0(Long.parseLong(r11.Q()));
                        aVar.U(Long.parseLong(r11.B()));
                        aVar.W(Double.parseDouble(r11.C()));
                        aVar.k0(Integer.parseInt(r11.W()));
                        if (r11.H().length() == 0) {
                            parseDouble = 0.0d;
                        } else {
                            parseDouble = Double.parseDouble(r11.H());
                        }
                        aVar.c0(parseDouble);
                        String a6 = com.bxkj.student.run.app.utils.i.a(Double.parseDouble(r11.C()), Long.parseLong(r11.B()));
                        kotlin.jvm.internal.g0.o(a6, "calAvgSpeed(...)");
                        aVar.T(a6);
                        aVar.Y(Double.parseDouble(r11.F()));
                        String M = r11.M();
                        if (u.a2(M, "null", true)) {
                            M = null;
                        }
                        if (M != null) {
                            if (M.length() <= 0) {
                                M = null;
                            }
                            if (M != null) {
                                Map<String, Object> A = c0Var.A(M);
                                aVar.o0(new LatLng(c0Var.f(A, "latitude"), c0Var.f(A, "longitude")));
                            }
                        }
                        String b6 = com.bxkj.student.run.app.utils.i.b(Double.parseDouble(r11.C()), Long.parseLong(r11.B()));
                        kotlin.jvm.internal.g0.o(b6, "calPace(...)");
                        aVar.m0(b6);
                        aVar.j().setValue(kotlin.coroutines.jvm.internal.a.f(Integer.parseInt(r11.G())));
                        aVar.k().setValue(kotlin.coroutines.jvm.internal.a.a(Boolean.parseBoolean(r11.V())));
                        aVar.S();
                        List parseArray = JSON.parseArray(r11.J(), PointData.class);
                        aVar.s().clear();
                        if (parseArray != null) {
                            if (!parseArray.isEmpty()) {
                                list = parseArray;
                            } else {
                                list = null;
                            }
                            if (list != null) {
                                aVar.s().addAll(f0.x2(parseArray));
                                PointData pointData = (PointData) list.get(list.size() - 1);
                                if (pointData != null) {
                                    pointData.setI(true);
                                }
                                LatLng latLng = new LatLng(((PointData) parseArray.get(0)).getA(), ((PointData) parseArray.get(0)).getO());
                                aVar.q0(latLng);
                                aVar.Q(latLng);
                                aVar.a0(latLng);
                                aVar.M(latLng);
                            }
                        }
                        List parseArray2 = JSON.parseArray(r11.R(), Integer.TYPE);
                        aVar.H().clear();
                        List<Integer> H = aVar.H();
                        kotlin.jvm.internal.g0.m(parseArray2);
                        H.addAll(parseArray2);
                        if (parseArray2.size() > 0) {
                            list3 = parseArray2;
                        }
                        if (list3 != null) {
                            for (Integer num : list3) {
                                kotlin.jvm.internal.g0.m(num);
                                i7 += num.intValue();
                            }
                            i.a aVar2 = com.bxkj.student.v2.common.data.i.f20657a;
                            aVar2.u0(i7);
                            aVar2.R(i7);
                        }
                    }
                }
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$resumeLocalData$2", f = "SportsVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class k extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22617a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<m0.d, n1> f22618b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<m0.d> f22619c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        k(Function1<? super m0.d, n1> function1, Ref.ObjectRef<m0.d> objectRef, kotlin.coroutines.e<? super k> eVar) {
            super(1, eVar);
            this.f22618b = function1;
            this.f22619c = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new k(this.f22618b, this.f22619c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((k) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22617a == 0) {
                g0.n(obj);
                this.f22618b.invoke(this.f22619c.element);
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$saveToLocal$1", f = "SportsVM.kt", i = {0, 0}, l = {182}, m = "invokeSuspend", n = {"identify", "endTime"}, s = {"L$0", "J$0"})
    static final class l extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22620a;

        /* renamed from: b, reason: collision with root package name */
        long f22621b;

        /* renamed from: c, reason: collision with root package name */
        int f22622c;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f22624e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f22625f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f22626g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(String str, String str2, Function0<n1> function0, kotlin.coroutines.e<? super l> eVar) {
            super(1, eVar);
            this.f22624e = str;
            this.f22625f = str2;
            this.f22626g = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SportsVM.this.new l(this.f22624e, this.f22625f, this.f22626g, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((l) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            l lVar;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22622c;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                    lVar = this;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                String t5 = c0.f16887a.t(SportsVM.this.M(), "identify");
                long currentTimeMillis = System.currentTimeMillis();
                com.bxkj.student.v2.repository.sports.g L = SportsVM.this.L();
                String str = this.f22624e;
                String str2 = this.f22625f;
                String valueOf = String.valueOf(currentTimeMillis);
                this.f22620a = kotlin.coroutines.jvm.internal.j.a(t5);
                this.f22621b = currentTimeMillis;
                this.f22622c = 1;
                lVar = this;
                if (L.e(str, str2, valueOf, t5, lVar) == l6) {
                    return l6;
                }
            }
            lVar.f22626g.invoke();
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$startCheckExceptionTimeOut$1", f = "SportsVM.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME}, m = "invokeSuspend", n = {}, s = {})
    static final class m extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22627a;

        m(kotlin.coroutines.e<? super m> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return SportsVM.this.new m(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((m) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22627a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                this.f22627a = 1;
                if (a1.b(5000L, this) == l6) {
                    return l6;
                }
            }
            com.orhanobut.logger.j.d("3秒未请求到接口主动取消", new Object[0]);
            e2 e2Var = SportsVM.this.f22551o;
            if (e2Var != null) {
                ResponseBody.Companion companion = ResponseBody.Companion;
                MediaType parse = MediaType.Companion.parse("text/plain");
                byte[] bytes = "3秒未请求到接口主动取消".getBytes(kotlin.text.e.f47851b);
                kotlin.jvm.internal.g0.o(bytes, "getBytes(...)");
                h2.g(e2Var, "3秒未请求到接口主动取消", new HttpException(retrofit2.c0.c(502, companion.create(parse, bytes))));
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsVM$startTimeOut$1", f = "SportsVM.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
    static final class n extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22629a;

        n(kotlin.coroutines.e<? super n> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return SportsVM.this.new n(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((n) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22629a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                this.f22629a = 1;
                if (a1.b(5000L, this) == l6) {
                    return l6;
                }
            }
            com.orhanobut.logger.j.d("3秒未请求到接口主动取消", new Object[0]);
            e2 e2Var = SportsVM.this.f22549m;
            if (e2Var != null) {
                ResponseBody.Companion companion = ResponseBody.Companion;
                MediaType parse = MediaType.Companion.parse("text/plain");
                byte[] bytes = "3秒未请求到接口主动取消".getBytes(kotlin.text.e.f47851b);
                kotlin.jvm.internal.g0.o(bytes, "getBytes(...)");
                h2.g(e2Var, "3秒未请求到接口主动取消", new HttpException(retrofit2.c0.c(502, companion.create(parse, bytes))));
            }
            return n1.f44123a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.face.c H() {
        return new com.bxkj.student.v2.repository.face.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.face.c I() {
        return (com.bxkj.student.v2.repository.face.c) this.f22547k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.sports.b J() {
        return (com.bxkj.student.v2.repository.sports.b) this.f22545i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.sports.e K() {
        return (com.bxkj.student.v2.repository.sports.e) this.f22548l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.sports.g L() {
        return (com.bxkj.student.v2.repository.sports.g) this.f22546j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.sports.b O() {
        return new com.bxkj.student.v2.repository.sports.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.sports.e T() {
        return new com.bxkj.student.v2.repository.sports.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.sports.g U() {
        return new com.bxkj.student.v2.repository.sports.g();
    }

    public final void F(@NotNull String isValid, @NotNull String isException, @NotNull Function2<? super String, ? super String, n1> success, @NotNull Function1<? super String, n1> fail) {
        kotlin.jvm.internal.g0.p(isValid, "isValid");
        kotlin.jvm.internal.g0.p(isException, "isException");
        kotlin.jvm.internal.g0.p(success, "success");
        kotlin.jvm.internal.g0.p(fail, "fail");
        c0 c0Var = c0.f16887a;
        Map<String, ? extends Object> map = this.f22544h;
        String uuid = UUID.randomUUID().toString();
        kotlin.jvm.internal.g0.o(uuid, "toString(...)");
        String u5 = c0Var.u(map, "identify", uuid);
        i.a aVar = com.bxkj.student.v2.common.data.i.f20657a;
        long D = aVar.D();
        long h6 = aVar.h();
        long e6 = aVar.e();
        List<Map<String, Object>> n6 = c0Var.n(this.f22544h, "list");
        com.orhanobut.logger.j.d("sportsSetMap=" + this.f22544h, new Object[0]);
        com.orhanobut.logger.j.d("复核距离=" + com.bxkj.student.run.app.utils.i.c(aVar.g()) + "\n轨迹距离=" + com.bxkj.student.run.app.utils.i.c(aVar.o()), new Object[0]);
        W();
        this.f22549m = BaseViewModel.j(this, new a(u5, D, h6, e6, n6, success, null), null, null, null, new b(null), new c(isException, isValid, h6, u5, fail, null), null, null, 206, null);
    }

    public final void G(@NotNull Function0<n1> success) {
        kotlin.jvm.internal.g0.p(success, "success");
        BaseViewModel.j(this, new d(success, null), null, null, null, null, null, null, null, 254, null);
    }

    @NotNull
    public final Map<String, Object> M() {
        return this.f22544h;
    }

    public final void N(@NotNull String identify, @NotNull String remark, @NotNull File cameraFile, @NotNull Function0<n1> result) {
        kotlin.jvm.internal.g0.p(identify, "identify");
        kotlin.jvm.internal.g0.p(remark, "remark");
        kotlin.jvm.internal.g0.p(cameraFile, "cameraFile");
        kotlin.jvm.internal.g0.p(result, "result");
        BaseViewModel.j(this, new e(identify, remark, cameraFile, result, null), null, null, null, null, null, null, null, 254, null);
    }

    public final void P(@NotNull Function0<n1> canContinue) {
        kotlin.jvm.internal.g0.p(canContinue, "canContinue");
        c0 c0Var = c0.f16887a;
        if (c0Var.d(this.f22544h, "serverUnavailable")) {
            com.orhanobut.logger.j.d("如果开始跑步的时候服务器不可用，恢复跑步的时候直接恢复跑步", new Object[0]);
            canContinue.invoke();
            return;
        }
        String t5 = c0Var.t(this.f22544h, "identify");
        e2 e2Var = this.f22552p;
        if (e2Var != null) {
            e2.a.b(e2Var, null, 1, null);
        }
        V();
        this.f22551o = BaseViewModel.j(this, new f(t5, canContinue, null), new g(t5, null), null, null, new h(null), new i(canContinue, null), null, null, 204, null);
    }

    public final void Q(@NotNull String identify, @NotNull Function1<? super m0.d, n1> complete) {
        kotlin.jvm.internal.g0.p(identify, "identify");
        kotlin.jvm.internal.g0.p(complete, "complete");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BaseViewModel.l(this, new j(identify, objectRef, null), null, null, null, new k(complete, objectRef, null), null, 46, null);
    }

    public final void R(@NotNull String isValid, @NotNull String isException, @NotNull Function0<n1> success) {
        kotlin.jvm.internal.g0.p(isValid, "isValid");
        kotlin.jvm.internal.g0.p(isException, "isException");
        kotlin.jvm.internal.g0.p(success, "success");
        BaseViewModel.l(this, new l(isException, isValid, success, null), null, null, null, null, null, 62, null);
    }

    public final void S(@NotNull Map<String, Object> map) {
        kotlin.jvm.internal.g0.p(map, "<set-?>");
        this.f22544h = map;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        e2 e2Var = this.f22550n;
        if (e2Var != null) {
            e2.a.b(e2Var, null, 1, null);
        }
        e2 e2Var2 = this.f22552p;
        if (e2Var2 != null) {
            e2.a.b(e2Var2, null, 1, null);
        }
        super.onCleared();
    }

    private final void V() {
        e2 f6;
        f6 = kotlinx.coroutines.k.f(ViewModelKt.getViewModelScope(this), null, null, new m(null), 3, null);
        this.f22552p = f6;
    }

    private final void W() {
        e2 f6;
        f6 = kotlinx.coroutines.k.f(ViewModelKt.getViewModelScope(this), null, null, new n(null), 3, null);
        this.f22550n = f6;
    }
}
