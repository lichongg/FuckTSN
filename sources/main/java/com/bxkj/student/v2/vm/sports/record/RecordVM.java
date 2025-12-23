package com.bxkj.student.v2.vm.sports.record;

import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.utils.c0;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.umeng.analytics.AnalyticsConfig;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
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
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRecordVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordVM.kt\ncom/bxkj/student/v2/vm/sports/record/RecordVM\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,327:1\n1563#2:328\n1634#2,2:329\n1636#2:332\n1#3:331\n*S KotlinDebug\n*F\n+ 1 RecordVM.kt\ncom/bxkj/student/v2/vm/sports/record/RecordVM\n*L\n184#1:328\n184#1:329,2\n184#1:332\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class RecordVM extends BaseViewModel {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private Map<String, Object> f22667h = new LinkedHashMap();

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private String f22668i = "";

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private Map<String, Boolean> f22669j = new LinkedHashMap();

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final s f22670k = t.c(new Function0() { // from class: com.bxkj.student.v2.vm.sports.record.j
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.sports.b M;
            M = RecordVM.M();
            return M;
        }
    });

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private final s f22671l = t.c(new Function0() { // from class: com.bxkj.student.v2.vm.sports.record.k
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.sports.g Q;
            Q = RecordVM.Q();
            return Q;
        }
    });

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private final s f22672m = t.c(new Function0() { // from class: com.bxkj.student.v2.vm.sports.record.l
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.face.c C;
            C = RecordVM.C();
            return C;
        }
    });

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordVM", f = "RecordVM.kt", i = {0, 0, 0, 0}, l = {178}, m = "getLocalRecord", n = {"resultList", "formatter", "current", "datePageIndex"}, s = {"L$0", "L$1", "L$2", "I$0"})
    static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        int f22673a;

        /* renamed from: b, reason: collision with root package name */
        Object f22674b;

        /* renamed from: c, reason: collision with root package name */
        Object f22675c;

        /* renamed from: d, reason: collision with root package name */
        Object f22676d;

        /* renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f22677e;

        /* renamed from: g, reason: collision with root package name */
        int f22679g;

        a(kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f22677e = obj;
            this.f22679g |= Integer.MIN_VALUE;
            return RecordVM.this.G(0, null, this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordVM$getRecordListV3$1", f = "RecordVM.kt", i = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {46, 77, 108}, m = "invokeSuspend", n = {"result", "it", "recordList", "list", "it", "calcMoth", "$i$a$-let-RecordVM$getRecordListV3$1$1", "$i$a$-let-RecordVM$getRecordListV3$1$1$5", AnalyticsConfig.RTD_START_TIME, "endTime", "result", "it", "recordList", "list", "it", "calcMoth", "localList", "element$iv", "it", "calcMoth", "$this$forEach$iv", "$i$a$-let-RecordVM$getRecordListV3$1$1", "$i$a$-let-RecordVM$getRecordListV3$1$1$5", AnalyticsConfig.RTD_START_TIME, "endTime", "$i$f$forEach", "$i$a$-forEach-RecordVM$getRecordListV3$1$1$5$4", AnalyticsConfig.RTD_START_TIME, "endTime"}, s = {"L$0", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "J$0", "J$1", "L$0", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "I$0", "I$1", "J$0", "J$1", "I$2", "I$3", "J$2", "J$3"})
    @SourceDebugExtension({"SMAP\nRecordVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordVM.kt\ncom/bxkj/student/v2/vm/sports/record/RecordVM$getRecordListV3$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,327:1\n1#2:328\n1563#3:329\n1634#3,3:330\n1021#3,2:333\n1869#3,2:335\n*S KotlinDebug\n*F\n+ 1 RecordVM.kt\ncom/bxkj/student/v2/vm/sports/record/RecordVM$getRecordListV3$1\n*L\n80#1:329\n80#1:330,3\n103#1:333,2\n104#1:335,2\n*E\n"})
    static final class b extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {
        final /* synthetic */ int A;
        final /* synthetic */ Function1<List<Map<String, Object>>, n1> B;
        final /* synthetic */ Function0<n1> C;

        /* renamed from: a, reason: collision with root package name */
        Object f22680a;

        /* renamed from: b, reason: collision with root package name */
        Object f22681b;

        /* renamed from: c, reason: collision with root package name */
        Object f22682c;

        /* renamed from: d, reason: collision with root package name */
        Object f22683d;

        /* renamed from: e, reason: collision with root package name */
        Object f22684e;

        /* renamed from: f, reason: collision with root package name */
        Object f22685f;

        /* renamed from: g, reason: collision with root package name */
        Object f22686g;

        /* renamed from: h, reason: collision with root package name */
        Object f22687h;

        /* renamed from: i, reason: collision with root package name */
        Object f22688i;

        /* renamed from: j, reason: collision with root package name */
        Object f22689j;

        /* renamed from: k, reason: collision with root package name */
        Object f22690k;

        /* renamed from: l, reason: collision with root package name */
        Object f22691l;

        /* renamed from: m, reason: collision with root package name */
        Object f22692m;

        /* renamed from: n, reason: collision with root package name */
        Object f22693n;

        /* renamed from: o, reason: collision with root package name */
        Object f22694o;

        /* renamed from: p, reason: collision with root package name */
        int f22695p;

        /* renamed from: q, reason: collision with root package name */
        int f22696q;

        /* renamed from: r, reason: collision with root package name */
        int f22697r;

        /* renamed from: s, reason: collision with root package name */
        int f22698s;

        /* renamed from: t, reason: collision with root package name */
        long f22699t;

        /* renamed from: u, reason: collision with root package name */
        long f22700u;

        /* renamed from: v, reason: collision with root package name */
        long f22701v;

        /* renamed from: w, reason: collision with root package name */
        long f22702w;

        /* renamed from: x, reason: collision with root package name */
        int f22703x;

        /* renamed from: z, reason: collision with root package name */
        final /* synthetic */ String f22705z;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1\n+ 2 RecordVM.kt\ncom/bxkj/student/v2/vm/sports/record/RecordVM$getRecordListV3$1\n*L\n1#1,328:1\n103#2:329\n*E\n"})
        public static final class a<T> implements Comparator {
            @Override // java.util.Comparator
            public final int compare(T t5, T t6) {
                c0 c0Var = c0.f16887a;
                return kotlin.comparisons.a.l(Long.valueOf(c0Var.o((Map) t6, AnalyticsConfig.RTD_START_TIME)), Long.valueOf(c0Var.o((Map) t5, AnalyticsConfig.RTD_START_TIME)));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(String str, int i6, Function1<? super List<Map<String, Object>>, n1> function1, Function0<n1> function0, kotlin.coroutines.e<? super b> eVar) {
            super(1, eVar);
            this.f22705z = str;
            this.A = i6;
            this.B = function1;
            this.C = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return RecordVM.this.new b(this.f22705z, this.A, this.B, this.C, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((b) create(eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:137:0x0141, code lost:
        
            if (r0 == r7) goto L26;
         */
        /* JADX WARN: Removed duplicated region for block: B:119:0x01ed  */
        /* JADX WARN: Removed duplicated region for block: B:124:0x0511  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x03b3  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x050a  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x051e  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0522  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0272  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x0388  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x0377  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0474  */
        /* JADX WARN: Type inference failed for: r10v14, types: [T, java.util.List] */
        /* JADX WARN: Type inference failed for: r11v1, types: [T, java.util.ArrayList] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0468 -> B:7:0x0470). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r45) {
            /*
                Method dump skipped, instructions count: 1337
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.record.RecordVM.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordVM$getRecordListV3$2", f = "RecordVM.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK}, m = "invokeSuspend", n = {"e"}, s = {"L$0"})
    static final class c extends SuspendLambda implements Function2<Exception, kotlin.coroutines.e<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22706a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f22707b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f22708c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecordVM f22709d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f22710e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1<List<Map<String, Object>>, n1> f22711f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(String str, RecordVM recordVM, int i6, Function1<? super List<Map<String, Object>>, n1> function1, kotlin.coroutines.e<? super c> eVar) {
            super(2, eVar);
            this.f22708c = str;
            this.f22709d = recordVM;
            this.f22710e = i6;
            this.f22711f = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            c cVar = new c(this.f22708c, this.f22709d, this.f22710e, this.f22711f, eVar);
            cVar.f22707b = obj;
            return cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Exception exc = (Exception) this.f22707b;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22706a;
            boolean z5 = true;
            if (i6 == 0) {
                g0.n(obj);
                if (com.bxkj.base.v2.common.ext.e.b(exc)) {
                    com.orhanobut.logger.j.d("服务器挂了，获取本地跑步记录", new Object[0]);
                    if (kotlin.jvm.internal.g0.g(this.f22708c, "0") || kotlin.jvm.internal.g0.g(this.f22708c, "-1")) {
                        RecordVM recordVM = this.f22709d;
                        int i7 = this.f22710e;
                        Function1<List<Map<String, Object>>, n1> function1 = this.f22711f;
                        this.f22707b = kotlin.coroutines.jvm.internal.j.a(exc);
                        this.f22706a = 1;
                        if (recordVM.G(i7, function1, this) == l6) {
                            return l6;
                        }
                    } else {
                        this.f22711f.invoke(new ArrayList());
                    }
                } else {
                    z5 = false;
                }
            } else {
                if (i6 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                g0.n(obj);
            }
            return kotlin.coroutines.jvm.internal.a.a(z5);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Exception exc, kotlin.coroutines.e<? super Boolean> eVar) {
            return ((c) create(exc, eVar)).invokeSuspend(n1.f44123a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordVM$getRecordListV3$3", f = "RecordVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22712a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f22713b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Function0<n1> function0, kotlin.coroutines.e<? super d> eVar) {
            super(1, eVar);
            this.f22713b = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new d(this.f22713b, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((d) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22712a == 0) {
                g0.n(obj);
                this.f22713b.invoke();
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordVM$getSportsAppeal$1", f = "RecordVM.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nRecordVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordVM.kt\ncom/bxkj/student/v2/vm/sports/record/RecordVM$getSportsAppeal$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,327:1\n1#2:328\n*E\n"})
    static final class e extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22714a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Map<String, ? extends Object>, n1> f22715b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        e(Function1<? super Map<String, ? extends Object>, n1> function1, kotlin.coroutines.e<? super e> eVar) {
            super(1, eVar);
            this.f22715b = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new e(this.f22715b, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((e) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22714a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.sports.a aVar = new com.bxkj.student.v2.repository.sports.a();
                this.f22714a = 1;
                obj = aVar.c(this);
                if (obj == l6) {
                    return l6;
                }
            }
            Map<String, ? extends Object> map = (Map) obj;
            if (map != null) {
                this.f22715b.invoke(map);
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordVM$uploadV3$1", f = "RecordVM.kt", i = {1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5}, l = {254, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME, 273, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN, MediaPlayer.MEDIA_PLAYER_OPTION_START_DIRECTLLY_AFTER_PREPARED}, m = "invokeSuspend", n = {"result", "$this$invokeSuspend_u24lambda_u246", "map", "it", "$i$a$-apply-RecordVM$uploadV3$1$2", "$i$a$-let-RecordVM$uploadV3$1$2$1", "result", "$this$invokeSuspend_u24lambda_u246", "map", "it", "$this$forEach$iv", "element$iv", "faceDb", "faceDb", "faceFile", OptionalModuleUtils.FACE, "$i$a$-apply-RecordVM$uploadV3$1$2", "$i$a$-let-RecordVM$uploadV3$1$2$1", "$i$f$forEach", "$i$a$-forEach-RecordVM$uploadV3$1$2$1$1", "$i$a$-let-RecordVM$uploadV3$1$2$1$1$1", "$i$a$-let-RecordVM$uploadV3$1$2$1$1$1$2", "result", "$this$invokeSuspend_u24lambda_u246", "map", "it", "$this$forEach$iv", "element$iv", "faceDb", "faceDb", "faceFile", OptionalModuleUtils.FACE, "$i$a$-apply-RecordVM$uploadV3$1$2", "$i$a$-let-RecordVM$uploadV3$1$2$1", "$i$f$forEach", "$i$a$-forEach-RecordVM$uploadV3$1$2$1$1", "$i$a$-let-RecordVM$uploadV3$1$2$1$1$1", "$i$a$-let-RecordVM$uploadV3$1$2$1$1$1$2", "result", "$this$invokeSuspend_u24lambda_u246", "map", "it", "sportsSetMap", "$i$a$-apply-RecordVM$uploadV3$1$2", "$i$a$-let-RecordVM$uploadV3$1$2$1", "result", "$this$invokeSuspend_u24lambda_u246", "map", "it", "sportsSetMap", "commitV3", "$i$a$-apply-RecordVM$uploadV3$1$2", "$i$a$-let-RecordVM$uploadV3$1$2$1"}, s = {"L$0", "L$5", "L$6", "L$7", "I$0", "I$1", "L$0", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "L$0", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "L$0", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "L$0", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1"})
    @SourceDebugExtension({"SMAP\nRecordVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordVM.kt\ncom/bxkj/student/v2/vm/sports/record/RecordVM$uploadV3$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,327:1\n1#2:328\n1869#3,2:329\n*S KotlinDebug\n*F\n+ 1 RecordVM.kt\ncom/bxkj/student/v2/vm/sports/record/RecordVM$uploadV3$1\n*L\n260#1:329,2\n*E\n"})
    static final class f extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22716a;

        /* renamed from: b, reason: collision with root package name */
        Object f22717b;

        /* renamed from: c, reason: collision with root package name */
        Object f22718c;

        /* renamed from: d, reason: collision with root package name */
        Object f22719d;

        /* renamed from: e, reason: collision with root package name */
        Object f22720e;

        /* renamed from: f, reason: collision with root package name */
        Object f22721f;

        /* renamed from: g, reason: collision with root package name */
        Object f22722g;

        /* renamed from: h, reason: collision with root package name */
        Object f22723h;

        /* renamed from: i, reason: collision with root package name */
        Object f22724i;

        /* renamed from: j, reason: collision with root package name */
        Object f22725j;

        /* renamed from: k, reason: collision with root package name */
        Object f22726k;

        /* renamed from: l, reason: collision with root package name */
        Object f22727l;

        /* renamed from: m, reason: collision with root package name */
        Object f22728m;

        /* renamed from: n, reason: collision with root package name */
        Object f22729n;

        /* renamed from: o, reason: collision with root package name */
        Object f22730o;

        /* renamed from: p, reason: collision with root package name */
        int f22731p;

        /* renamed from: q, reason: collision with root package name */
        int f22732q;

        /* renamed from: r, reason: collision with root package name */
        int f22733r;

        /* renamed from: s, reason: collision with root package name */
        int f22734s;

        /* renamed from: t, reason: collision with root package name */
        int f22735t;

        /* renamed from: u, reason: collision with root package name */
        int f22736u;

        /* renamed from: v, reason: collision with root package name */
        int f22737v;

        /* renamed from: x, reason: collision with root package name */
        final /* synthetic */ String f22739x;

        /* renamed from: y, reason: collision with root package name */
        final /* synthetic */ Function1<String, n1> f22740y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        f(String str, Function1<? super String, n1> function1, kotlin.coroutines.e<? super f> eVar) {
            super(1, eVar);
            this.f22739x = str;
            this.f22740y = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return RecordVM.this.new f(this.f22739x, this.f22740y, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((f) create(eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:76:0x017b, code lost:
        
            if (r0 == r9) goto L15;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x058e  */
        /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x01fe  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0320  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0446  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x04a7  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0541  */
        /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x04aa  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0449  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x01e3  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0377  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0592  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0320 -> B:18:0x032f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0343 -> B:19:0x034d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r48) {
            /*
                Method dump skipped, instructions count: 1456
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.record.RecordVM.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Long, Long> B(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        List m52 = u.m5(str, new String[]{"-"}, false, 0, 6, null);
        int parseInt = Integer.parseInt((String) m52.get(0));
        int parseInt2 = Integer.parseInt((String) m52.get(1)) - 1;
        calendar.set(1, parseInt);
        calendar.set(2, parseInt2);
        calendar.set(5, 1);
        String format = simpleDateFormat.format(calendar.getTime());
        kotlin.jvm.internal.g0.o(format, "format(...)");
        String substring = format.substring(0, 10);
        kotlin.jvm.internal.g0.o(substring, "substring(...)");
        String str2 = substring + " 00:00:00";
        calendar.set(5, calendar.getActualMaximum(5));
        String format2 = simpleDateFormat.format(calendar.getTime());
        kotlin.jvm.internal.g0.o(format2, "format(...)");
        String substring2 = format2.substring(0, 10);
        kotlin.jvm.internal.g0.o(substring2, "substring(...)");
        return new Pair<>(Long.valueOf(simpleDateFormat.parse(str2).getTime()), Long.valueOf(simpleDateFormat.parse(substring2 + " 23:59:59").getTime()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.face.c C() {
        return new com.bxkj.student.v2.repository.face.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.face.c F() {
        return (com.bxkj.student.v2.repository.face.c) this.f22672m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object G(int r17, kotlin.jvm.functions.Function1<? super java.util.List<java.util.Map<java.lang.String, java.lang.Object>>, kotlin.n1> r18, kotlin.coroutines.e<? super kotlin.n1> r19) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.record.RecordVM.G(int, kotlin.jvm.functions.Function1, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.sports.b J() {
        return (com.bxkj.student.v2.repository.sports.b) this.f22670k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.sports.g L() {
        return (com.bxkj.student.v2.repository.sports.g) this.f22671l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.sports.b M() {
        return new com.bxkj.student.v2.repository.sports.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.sports.g Q() {
        return new com.bxkj.student.v2.repository.sports.g();
    }

    @NotNull
    public final String D() {
        return this.f22668i;
    }

    @NotNull
    public final Map<String, Boolean> E() {
        return this.f22669j;
    }

    public final void H(@NotNull String status, int i6, @NotNull Function1<? super List<Map<String, Object>>, n1> resultList, @NotNull Function0<n1> requestFinish) {
        kotlin.jvm.internal.g0.p(status, "status");
        kotlin.jvm.internal.g0.p(resultList, "resultList");
        kotlin.jvm.internal.g0.p(requestFinish, "requestFinish");
        BaseViewModel.j(this, new b(status, i6, resultList, requestFinish, null), null, new c(status, this, i6, resultList, null), null, new d(requestFinish, null), null, null, null, org.apache.commons.net.ftp.l.O, null);
    }

    @NotNull
    public final Map<String, Object> I() {
        return this.f22667h;
    }

    public final void K(@NotNull Function1<? super Map<String, ? extends Object>, n1> success) {
        kotlin.jvm.internal.g0.p(success, "success");
        BaseViewModel.j(this, new e(success, null), null, null, null, null, null, null, null, 254, null);
    }

    public final void N(@NotNull String str) {
        kotlin.jvm.internal.g0.p(str, "<set-?>");
        this.f22668i = str;
    }

    public final void O(@NotNull Map<String, Boolean> map) {
        kotlin.jvm.internal.g0.p(map, "<set-?>");
        this.f22669j = map;
    }

    public final void P(@NotNull Map<String, Object> map) {
        kotlin.jvm.internal.g0.p(map, "<set-?>");
        this.f22667h = map;
    }

    public final void R(@NotNull String identify, @NotNull Function1<? super String, n1> success) {
        kotlin.jvm.internal.g0.p(identify, "identify");
        kotlin.jvm.internal.g0.p(success, "success");
        BaseViewModel.j(this, new f(identify, success, null), null, null, null, null, null, null, null, 254, null);
    }
}
