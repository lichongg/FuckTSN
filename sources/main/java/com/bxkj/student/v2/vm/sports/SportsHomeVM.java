package com.bxkj.student.v2.vm.sports;

import android.app.Activity;
import android.os.Debug;
import android.os.SystemClock;
import androidx.collection.ArrayMap;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.JsonParse;
import com.amap.api.maps.model.LatLng;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.http.exception.ApiException;
import com.bxkj.student.App;
import com.bxkj.student.v2.common.data.i;
import com.bxkj.student.v2.common.data.j;
import com.bxkj.student.v2.common.db.AppDatabase;
import com.bxkj.student.v2.common.db.dao.q0;
import com.bxkj.student.v2.common.utils.h;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.umeng.analytics.AnalyticsConfig;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.collections.i1;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.h2;
import kotlinx.coroutines.r0;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSportsHomeVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportsHomeVM.kt\ncom/bxkj/student/v2/vm/sports/SportsHomeVM\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,596:1\n1#2:597\n1869#3,2:598\n*S KotlinDebug\n*F\n+ 1 SportsHomeVM.kt\ncom/bxkj/student/v2/vm/sports/SportsHomeVM\n*L\n494#1:598,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class SportsHomeVM extends BaseViewModel {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final kotlin.s f22398h = kotlin.t.c(new Function0() { // from class: com.bxkj.student.v2.vm.sports.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.sports.e F0;
            F0 = SportsHomeVM.F0();
            return F0;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private final kotlin.s f22399i = kotlin.t.c(new Function0() { // from class: com.bxkj.student.v2.vm.sports.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.sports.g G0;
            G0 = SportsHomeVM.G0();
            return G0;
        }
    });

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private final kotlin.s f22400j = kotlin.t.c(new Function0() { // from class: com.bxkj.student.v2.vm.sports.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.sports.b o02;
            o02 = SportsHomeVM.o0();
            return o02;
        }
    });

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final kotlin.s f22401k = kotlin.t.c(new Function0() { // from class: com.bxkj.student.v2.vm.sports.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.face.c M;
            M = SportsHomeVM.M();
            return M;
        }
    });

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private final kotlin.s f22402l = kotlin.t.c(new Function0() { // from class: com.bxkj.student.v2.vm.sports.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.c m02;
            m02 = SportsHomeVM.m0();
            return m02;
        }
    });

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private MutableLiveData<Map<String, Object>> f22403m = new MutableLiveData<>();

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private MutableLiveData<Map<String, Object>> f22404n = new MutableLiveData<>();

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private MutableLiveData<Map<String, Object>> f22405o = new MutableLiveData<>();

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private MutableLiveData<Map<String, Object>> f22406p = new MutableLiveData<>();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private MutableLiveData<Map<String, Object>> f22407q = new MutableLiveData<>();

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    private MutableLiveData<Map<String, Object>> f22408r = new MutableLiveData<>();

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    private MutableLiveData<Map<String, Object>> f22409s = new MutableLiveData<>();

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    private MutableLiveData<List<m0.d>> f22410t = new MutableLiveData<>();

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    private MutableLiveData<List<m0.d>> f22411u = new MutableLiveData<>();

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    private MutableLiveData<Map<String, Object>> f22412v = new MutableLiveData<>();

    /* renamed from: w, reason: collision with root package name */
    @Nullable
    private e2 f22413w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    private e2 f22414x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    private e2 f22415y;

    /* renamed from: z, reason: collision with root package name */
    @Nullable
    private e2 f22416z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$checkExerciseRecord$1", f = "SportsHomeVM.kt", i = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {449, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME, 465, 471, 474}, m = "invokeSuspend", n = {"unConfirmSportsList", "transform", "map", "$this$forEach$iv", "element$iv", "it", "it", "$i$f$forEach", "$i$a$-forEach-SportsHomeVM$checkExerciseRecord$1$2", "$i$a$-let-SportsHomeVM$checkExerciseRecord$1$2$1", "unConfirmSportsList", "transform", "map", "identifys", "$i$a$-let-SportsHomeVM$checkExerciseRecord$1$7", "unConfirmSportsList", "transform", "map", "identifys", "$this$forEach$iv", "element$iv", "it", "identify", "it", "$i$a$-let-SportsHomeVM$checkExerciseRecord$1$7", "$i$f$forEach", "$i$a$-forEach-SportsHomeVM$checkExerciseRecord$1$7$1", "serverConfirmCount", "$i$a$-let-SportsHomeVM$checkExerciseRecord$1$7$1$2", "unConfirmSportsList", "transform", "map", "identifys", "$this$forEach$iv", "element$iv", "it", "identify", "$i$a$-let-SportsHomeVM$checkExerciseRecord$1$7", "$i$f$forEach", "$i$a$-forEach-SportsHomeVM$checkExerciseRecord$1$7$1", "serverConfirmCount"}, s = {"L$0", "L$1", "L$2", "L$3", "L$6", "L$7", "L$8", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$4", "I$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$4", "L$5", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2", "I$3"})
    @SourceDebugExtension({"SMAP\nSportsHomeVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportsHomeVM.kt\ncom/bxkj/student/v2/vm/sports/SportsHomeVM$checkExerciseRecord$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,596:1\n1563#2:597\n1634#2,3:598\n774#2:601\n865#2,2:602\n1869#2:604\n1870#2:606\n774#2:607\n865#2,2:608\n1563#2:610\n1634#2,3:611\n1#3:605\n216#4,2:614\n*S KotlinDebug\n*F\n+ 1 SportsHomeVM.kt\ncom/bxkj/student/v2/vm/sports/SportsHomeVM$checkExerciseRecord$1\n*L\n452#1:597\n452#1:598,3\n455#1:601\n455#1:602,2\n455#1:604\n455#1:606\n459#1:607\n459#1:608,2\n460#1:610\n460#1:611,3\n465#1:614,2\n*E\n"})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22417a;

        /* renamed from: b, reason: collision with root package name */
        Object f22418b;

        /* renamed from: c, reason: collision with root package name */
        Object f22419c;

        /* renamed from: d, reason: collision with root package name */
        Object f22420d;

        /* renamed from: e, reason: collision with root package name */
        Object f22421e;

        /* renamed from: f, reason: collision with root package name */
        Object f22422f;

        /* renamed from: g, reason: collision with root package name */
        Object f22423g;

        /* renamed from: h, reason: collision with root package name */
        Object f22424h;

        /* renamed from: i, reason: collision with root package name */
        Object f22425i;

        /* renamed from: j, reason: collision with root package name */
        Object f22426j;

        /* renamed from: k, reason: collision with root package name */
        Object f22427k;

        /* renamed from: l, reason: collision with root package name */
        int f22428l;

        /* renamed from: m, reason: collision with root package name */
        int f22429m;

        /* renamed from: n, reason: collision with root package name */
        int f22430n;

        /* renamed from: o, reason: collision with root package name */
        int f22431o;

        /* renamed from: p, reason: collision with root package name */
        int f22432p;

        /* renamed from: q, reason: collision with root package name */
        int f22433q;

        /* JADX INFO: Access modifiers changed from: private */
        public static final String i(m0.d dVar) {
            return (dVar != null ? dVar.I() : null) + "开始时间" + com.bxkj.base.v2.common.utils.g.a(dVar != null ? dVar.Q() : null) + "确认次数" + (dVar != null ? Integer.valueOf(dVar.A()) : null);
        }

        a(kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return SportsHomeVM.this.new a(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:41:0x0397, code lost:
        
            if (r7 == r0) goto L129;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x02ab A[Catch: Exception -> 0x0052, TryCatch #0 {Exception -> 0x0052, blocks: (B:10:0x0048, B:12:0x039a, B:14:0x02a5, B:16:0x02ab, B:18:0x02c5, B:19:0x02cd, B:21:0x02d3, B:23:0x02dd, B:24:0x02e5, B:29:0x02f0, B:31:0x02f6, B:40:0x0345, B:48:0x008d, B:51:0x00a9, B:53:0x0291, B:55:0x0295, B:57:0x00d4, B:59:0x0179, B:61:0x017f, B:63:0x0189, B:68:0x01d7, B:69:0x01e3, B:71:0x01e9, B:73:0x01f2, B:78:0x01ff, B:85:0x0203, B:86:0x0210, B:88:0x0216, B:90:0x021e, B:92:0x0224, B:96:0x0228, B:100:0x0235, B:102:0x024b, B:108:0x025d, B:115:0x00d9, B:117:0x00fc, B:119:0x0105, B:120:0x0115, B:122:0x011b, B:124:0x0128, B:126:0x0140, B:127:0x014c, B:129:0x0152, B:131:0x015b, B:136:0x0168, B:143:0x016c, B:147:0x00e2), top: B:2:0x0010 }] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0295 A[Catch: Exception -> 0x0052, TryCatch #0 {Exception -> 0x0052, blocks: (B:10:0x0048, B:12:0x039a, B:14:0x02a5, B:16:0x02ab, B:18:0x02c5, B:19:0x02cd, B:21:0x02d3, B:23:0x02dd, B:24:0x02e5, B:29:0x02f0, B:31:0x02f6, B:40:0x0345, B:48:0x008d, B:51:0x00a9, B:53:0x0291, B:55:0x0295, B:57:0x00d4, B:59:0x0179, B:61:0x017f, B:63:0x0189, B:68:0x01d7, B:69:0x01e3, B:71:0x01e9, B:73:0x01f2, B:78:0x01ff, B:85:0x0203, B:86:0x0210, B:88:0x0216, B:90:0x021e, B:92:0x0224, B:96:0x0228, B:100:0x0235, B:102:0x024b, B:108:0x025d, B:115:0x00d9, B:117:0x00fc, B:119:0x0105, B:120:0x0115, B:122:0x011b, B:124:0x0128, B:126:0x0140, B:127:0x014c, B:129:0x0152, B:131:0x015b, B:136:0x0168, B:143:0x016c, B:147:0x00e2), top: B:2:0x0010 }] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x017f A[Catch: Exception -> 0x0052, TryCatch #0 {Exception -> 0x0052, blocks: (B:10:0x0048, B:12:0x039a, B:14:0x02a5, B:16:0x02ab, B:18:0x02c5, B:19:0x02cd, B:21:0x02d3, B:23:0x02dd, B:24:0x02e5, B:29:0x02f0, B:31:0x02f6, B:40:0x0345, B:48:0x008d, B:51:0x00a9, B:53:0x0291, B:55:0x0295, B:57:0x00d4, B:59:0x0179, B:61:0x017f, B:63:0x0189, B:68:0x01d7, B:69:0x01e3, B:71:0x01e9, B:73:0x01f2, B:78:0x01ff, B:85:0x0203, B:86:0x0210, B:88:0x0216, B:90:0x021e, B:92:0x0224, B:96:0x0228, B:100:0x0235, B:102:0x024b, B:108:0x025d, B:115:0x00d9, B:117:0x00fc, B:119:0x0105, B:120:0x0115, B:122:0x011b, B:124:0x0128, B:126:0x0140, B:127:0x014c, B:129:0x0152, B:131:0x015b, B:136:0x0168, B:143:0x016c, B:147:0x00e2), top: B:2:0x0010 }] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x01ce  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x01d7 A[Catch: Exception -> 0x0052, TryCatch #0 {Exception -> 0x0052, blocks: (B:10:0x0048, B:12:0x039a, B:14:0x02a5, B:16:0x02ab, B:18:0x02c5, B:19:0x02cd, B:21:0x02d3, B:23:0x02dd, B:24:0x02e5, B:29:0x02f0, B:31:0x02f6, B:40:0x0345, B:48:0x008d, B:51:0x00a9, B:53:0x0291, B:55:0x0295, B:57:0x00d4, B:59:0x0179, B:61:0x017f, B:63:0x0189, B:68:0x01d7, B:69:0x01e3, B:71:0x01e9, B:73:0x01f2, B:78:0x01ff, B:85:0x0203, B:86:0x0210, B:88:0x0216, B:90:0x021e, B:92:0x0224, B:96:0x0228, B:100:0x0235, B:102:0x024b, B:108:0x025d, B:115:0x00d9, B:117:0x00fc, B:119:0x0105, B:120:0x0115, B:122:0x011b, B:124:0x0128, B:126:0x0140, B:127:0x014c, B:129:0x0152, B:131:0x015b, B:136:0x0168, B:143:0x016c, B:147:0x00e2), top: B:2:0x0010 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0341 -> B:13:0x039c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0397 -> B:12:0x039a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0187 -> B:56:0x01cb). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x01c7 -> B:56:0x01cb). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r30) {
            /*
                Method dump skipped, instructions count: 941
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.SportsHomeVM.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$checkSendFaceResult$1", f = "SportsHomeVM.kt", i = {}, l = {589}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22435a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<Object, n1> f22437c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Function1<Object, n1> function1, kotlin.coroutines.e<? super b> eVar) {
            super(1, eVar);
            this.f22437c = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SportsHomeVM.this.new b(this.f22437c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((b) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22435a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.sports.e c02 = SportsHomeVM.this.c0();
                this.f22435a = 1;
                obj = c02.c(this);
                if (obj == l6) {
                    return l6;
                }
            }
            this.f22437c.invoke(obj);
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getLatestUnreadNotice$1", f = "SportsHomeVM.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_TIMESTAMP_MONOTONIC}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nSportsHomeVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportsHomeVM.kt\ncom/bxkj/student/v2/vm/sports/SportsHomeVM$getLatestUnreadNotice$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,596:1\n1#2:597\n*E\n"})
    static final class c extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22438a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<Map<String, Object>, n1> f22440c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super Map<String, Object>, n1> function1, kotlin.coroutines.e<? super c> eVar) {
            super(1, eVar);
            this.f22440c = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SportsHomeVM.this.new c(this.f22440c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((c) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22438a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.c U = SportsHomeVM.this.U();
                this.f22438a = 1;
                obj = U.e("2", this);
                if (obj == l6) {
                    return l6;
                }
            }
            Map<String, Object> map = (Map) obj;
            if (map != null) {
                this.f22440c.invoke(map);
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getLoginUserInfo$1", f = "SportsHomeVM.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nSportsHomeVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportsHomeVM.kt\ncom/bxkj/student/v2/vm/sports/SportsHomeVM$getLoginUserInfo$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,596:1\n1#2:597\n*E\n"})
    static final class d extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22441a;

        d(kotlin.coroutines.e<? super d> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SportsHomeVM.this.new d(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((d) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22441a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.c U = SportsHomeVM.this.U();
                this.f22441a = 1;
                obj = U.g(this);
                if (obj == l6) {
                    return l6;
                }
            }
            Map<String, Object> map = (Map) obj;
            if (map != null) {
                SportsHomeVM.this.j0().postValue(map);
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getNtpTime$1", f = "SportsHomeVM.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class e extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22443a;

        /* renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f22444b;

        e(kotlin.coroutines.e<? super e> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            e eVar2 = new e(eVar);
            eVar2.f22444b = obj;
            return eVar2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((e) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            r0 r0Var = (r0) this.f22444b;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22443a;
            if (i6 == 0) {
                g0.n(obj);
                com.bxkj.student.v2.common.utils.m mVar = com.bxkj.student.v2.common.utils.m.f20909a;
                this.f22444b = r0Var;
                this.f22443a = 1;
                obj = mVar.a(this);
                if (obj == l6) {
                    return l6;
                }
            } else {
                if (i6 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                g0.n(obj);
            }
            Long l7 = (Long) obj;
            if (l7 != null) {
                long longValue = l7.longValue();
                i.a aVar = com.bxkj.student.v2.common.data.i.f20657a;
                aVar.i0(longValue);
                aVar.j0(SystemClock.elapsedRealtime());
                com.orhanobut.logger.j.d("NTP 时间: " + com.bxkj.base.v2.common.ext.g.d(l7.longValue()), new Object[0]);
            } else {
                com.orhanobut.logger.j.d("获取 NTP 时间失败", new Object[0]);
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getOfflineSet$3", f = "SportsHomeVM.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_RES_FINSIH_TIME}, m = "invokeSuspend", n = {}, s = {})
    static final class f extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22445a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f22446b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ SportsHomeVM f22447c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(int i6, SportsHomeVM sportsHomeVM, kotlin.coroutines.e<? super f> eVar) {
            super(1, eVar);
            this.f22446b = i6;
            this.f22447c = sportsHomeVM;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new f(this.f22446b, this.f22447c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((f) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22445a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                q0 y5 = AppDatabase.f20686a.a().y();
                if (y5 != null) {
                    String valueOf = String.valueOf(this.f22446b);
                    this.f22445a = 1;
                    obj = y5.b(valueOf, this);
                    if (obj == l6) {
                        return l6;
                    }
                } else {
                    str = null;
                    if (str == null && str.length() != 0) {
                        Map J0 = i1.J0(c0.f16887a.A(str));
                        J0.put("identify", UUID.randomUUID().toString());
                        J0.put("serverUnavailable", kotlin.coroutines.jvm.internal.a.a(true));
                        this.f22447c.x0(J0, this.f22446b);
                    } else {
                        this.f22447c.f().postValue("服务器维护中，请稍后再进行跑步");
                    }
                    return n1.f44123a;
                }
            }
            str = (String) obj;
            if (str == null) {
            }
            this.f22447c.f().postValue("服务器维护中，请稍后再进行跑步");
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getSportSetV2$1", f = "SportsHomeVM.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {198, 217, 221}, m = "invokeSuspend", n = {"paramMap", "paramMap", "jsonParam", "timestamp", "aesEncrypt", "originAesKey", "key", "data", "paramMap", "jsonParam", "timestamp", "aesEncrypt", "originAesKey", "key", "data", "sportsResult", "it", "resultJson", "$i$a$-let-SportsHomeVM$getSportSetV2$1$2"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "I$1"})
    static final class g extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22448a;

        /* renamed from: b, reason: collision with root package name */
        Object f22449b;

        /* renamed from: c, reason: collision with root package name */
        Object f22450c;

        /* renamed from: d, reason: collision with root package name */
        Object f22451d;

        /* renamed from: e, reason: collision with root package name */
        Object f22452e;

        /* renamed from: f, reason: collision with root package name */
        Object f22453f;

        /* renamed from: g, reason: collision with root package name */
        Object f22454g;

        /* renamed from: h, reason: collision with root package name */
        Object f22455h;

        /* renamed from: i, reason: collision with root package name */
        Object f22456i;

        /* renamed from: j, reason: collision with root package name */
        Object f22457j;

        /* renamed from: k, reason: collision with root package name */
        Object f22458k;

        /* renamed from: l, reason: collision with root package name */
        int f22459l;

        /* renamed from: m, reason: collision with root package name */
        int f22460m;

        /* renamed from: n, reason: collision with root package name */
        int f22461n;

        /* renamed from: o, reason: collision with root package name */
        final /* synthetic */ int f22462o;

        /* renamed from: p, reason: collision with root package name */
        final /* synthetic */ LatLng f22463p;

        /* renamed from: q, reason: collision with root package name */
        final /* synthetic */ SportsHomeVM f22464q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(int i6, LatLng latLng, SportsHomeVM sportsHomeVM, kotlin.coroutines.e<? super g> eVar) {
            super(1, eVar);
            this.f22462o = i6;
            this.f22463p = latLng;
            this.f22464q = sportsHomeVM;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new g(this.f22462o, this.f22463p, this.f22464q, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((g) create(eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x01a1  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0194  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instructions count: 564
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.SportsHomeVM.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getSportSetV2$2", f = "SportsHomeVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class h extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22465a;

        h(kotlin.coroutines.e<? super h> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SportsHomeVM.this.new h(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((h) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22465a == 0) {
                g0.n(obj);
                e2 e2Var = SportsHomeVM.this.f22414x;
                if (e2Var != null) {
                    e2.a.b(e2Var, null, 1, null);
                }
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getSportSetV2$3", f = "SportsHomeVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class i extends SuspendLambda implements Function2<Exception, kotlin.coroutines.e<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22467a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f22468b;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f22470d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(int i6, kotlin.coroutines.e<? super i> eVar) {
            super(2, eVar);
            this.f22470d = i6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            i iVar = SportsHomeVM.this.new i(this.f22470d, eVar);
            iVar.f22468b = obj;
            return iVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z5;
            Exception exc = (Exception) this.f22468b;
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22467a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            g0.n(obj);
            if (com.bxkj.base.v2.common.ext.e.b(exc)) {
                SportsHomeVM.this.Y(this.f22470d);
                z5 = true;
            } else {
                z5 = false;
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
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getSportsMenu$1", f = "SportsHomeVM.kt", i = {1, 1, 1}, l = {95, 97}, m = "invokeSuspend", n = {"sportsResult", "it", "$i$a$-let-SportsHomeVM$getSportsMenu$1$1"}, s = {"L$0", "L$2", "I$0"})
    static final class j extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22471a;

        /* renamed from: b, reason: collision with root package name */
        Object f22472b;

        /* renamed from: c, reason: collision with root package name */
        Object f22473c;

        /* renamed from: d, reason: collision with root package name */
        int f22474d;

        /* renamed from: e, reason: collision with root package name */
        int f22475e;

        j(kotlin.coroutines.e<? super j> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SportsHomeVM.this.new j(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((j) create(eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
        
            if (r9 == r0) goto L19;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r8.f22475e
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2a
                if (r1 == r3) goto L26
                if (r1 != r2) goto L1e
                java.lang.Object r0 = r8.f22473c
                java.util.Map r0 = (java.util.Map) r0
                java.lang.Object r0 = r8.f22472b
                com.bxkj.student.v2.vm.sports.SportsHomeVM r0 = (com.bxkj.student.v2.vm.sports.SportsHomeVM) r0
                java.lang.Object r1 = r8.f22471a
                java.util.Map r1 = (java.util.Map) r1
                kotlin.g0.n(r9)
                goto L80
            L1e:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L26:
                kotlin.g0.n(r9)
                goto L3c
            L2a:
                kotlin.g0.n(r9)
                com.bxkj.student.v2.vm.sports.SportsHomeVM r9 = com.bxkj.student.v2.vm.sports.SportsHomeVM.this
                com.bxkj.student.v2.repository.sports.e r9 = com.bxkj.student.v2.vm.sports.SportsHomeVM.E(r9)
                r8.f22475e = r3
                java.lang.Object r9 = r9.f(r8)
                if (r9 != r0) goto L3c
                goto L7e
            L3c:
                r1 = r9
                java.util.Map r1 = (java.util.Map) r1
                if (r1 == 0) goto L84
                com.bxkj.student.v2.vm.sports.SportsHomeVM r9 = com.bxkj.student.v2.vm.sports.SportsHomeVM.this
                com.bxkj.student.v2.common.db.AppDatabase$a r3 = com.bxkj.student.v2.common.db.AppDatabase.f20686a
                com.bxkj.student.v2.common.db.AppDatabase r3 = r3.a()
                com.bxkj.student.v2.common.db.dao.q0 r3 = r3.y()
                if (r3 == 0) goto L81
                m0.e r4 = new m0.e
                com.bxkj.base.v2.data.b$a r5 = com.bxkj.base.v2.data.b.f16998d
                com.bxkj.base.v2.data.b r5 = r5.a()
                java.lang.String r5 = r5.R()
                java.lang.String r6 = com.alibaba.fastjson.JSON.toJSONString(r1)
                java.lang.String r7 = "toJSONString(...)"
                kotlin.jvm.internal.g0.o(r6, r7)
                java.lang.String r7 = "-1"
                r4.<init>(r5, r7, r6)
                r8.f22471a = r1
                r8.f22472b = r9
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.j.a(r1)
                r8.f22473c = r5
                r5 = 0
                r8.f22474d = r5
                r8.f22475e = r2
                java.lang.Object r2 = r3.insert(r4, r8)
                if (r2 != r0) goto L7f
            L7e:
                return r0
            L7f:
                r0 = r9
            L80:
                r9 = r0
            L81:
                com.bxkj.student.v2.vm.sports.SportsHomeVM.I(r9, r1)
            L84:
                kotlin.n1 r9 = kotlin.n1.f44123a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.SportsHomeVM.j.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getSportsMenu$2", f = "SportsHomeVM.kt", i = {0}, l = {110}, m = "invokeSuspend", n = {"e"}, s = {"L$0"})
    static final class k extends SuspendLambda implements Function2<Exception, kotlin.coroutines.e<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22477a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f22478b;

        k(kotlin.coroutines.e<? super k> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            k kVar = SportsHomeVM.this.new k(eVar);
            kVar.f22478b = obj;
            return kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Exception exc = (Exception) this.f22478b;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22477a;
            boolean z5 = true;
            if (i6 == 0) {
                g0.n(obj);
                if (!com.bxkj.base.v2.common.ext.e.b(exc)) {
                    z5 = false;
                    return kotlin.coroutines.jvm.internal.a.a(z5);
                }
                com.orhanobut.logger.j.d("离线跑步获取跑步总记录数", new Object[0]);
                q0 y5 = AppDatabase.f20686a.a().y();
                if (y5 != null) {
                    this.f22478b = kotlin.coroutines.jvm.internal.j.a(exc);
                    this.f22477a = 1;
                    obj = y5.b("-1", this);
                    if (obj == l6) {
                        return l6;
                    }
                }
                SportsHomeVM.this.f().postValue("服务器维护中，请稍后再进行锻炼");
                return kotlin.coroutines.jvm.internal.a.a(z5);
            }
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            g0.n(obj);
            String str = (String) obj;
            if (str != null) {
                if (str.length() <= 0) {
                    str = null;
                }
                if (str != null) {
                    SportsHomeVM.this.z0(i1.J0(c0.f16887a.A(str)));
                    return kotlin.coroutines.jvm.internal.a.a(z5);
                }
            }
            SportsHomeVM.this.f().postValue("服务器维护中，请稍后再进行锻炼");
            return kotlin.coroutines.jvm.internal.a.a(z5);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Exception exc, kotlin.coroutines.e<? super Boolean> eVar) {
            return ((k) create(exc, eVar)).invokeSuspend(n1.f44123a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getSportsStartTime$1", f = "SportsHomeVM.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_END_TIME}, m = "invokeSuspend", n = {}, s = {})
    static final class l extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22480a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f22482c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(String str, kotlin.coroutines.e<? super l> eVar) {
            super(1, eVar);
            this.f22482c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SportsHomeVM.this.new l(this.f22482c, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((l) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22480a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.common.data.i.f20657a.s0(0L);
                com.bxkj.student.v2.repository.sports.e c02 = SportsHomeVM.this.c0();
                String str = this.f22482c;
                this.f22480a = 1;
                obj = c02.h(str, this);
                if (obj == l6) {
                    return l6;
                }
            }
            i.a aVar = com.bxkj.student.v2.common.data.i.f20657a;
            aVar.s0(c0.f16887a.o((Map) obj, AnalyticsConfig.RTD_START_TIME));
            aVar.t0(SystemClock.elapsedRealtime());
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getSportsStartTime$2", f = "SportsHomeVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class m extends SuspendLambda implements Function2<Exception, kotlin.coroutines.e<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22483a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f22484b;

        m(kotlin.coroutines.e<? super m> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            m mVar = new m(eVar);
            mVar.f22484b = obj;
            return mVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Exception exc = (Exception) this.f22484b;
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22483a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            g0.n(obj);
            return kotlin.coroutines.jvm.internal.a.a(com.bxkj.base.v2.common.ext.e.b(exc));
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Exception exc, kotlin.coroutines.e<? super Boolean> eVar) {
            return ((m) create(exc, eVar)).invokeSuspend(n1.f44123a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getWeather$1", f = "SportsHomeVM.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LATENCYTIME}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nSportsHomeVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportsHomeVM.kt\ncom/bxkj/student/v2/vm/sports/SportsHomeVM$getWeather$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,596:1\n1#2:597\n*E\n"})
    static final class n extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22485a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f22487c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Map<String, Object>, n1> f22488d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        n(String str, Function1<? super Map<String, Object>, n1> function1, kotlin.coroutines.e<? super n> eVar) {
            super(1, eVar);
            this.f22487c = str;
            this.f22488d = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SportsHomeVM.this.new n(this.f22487c, this.f22488d, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((n) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22485a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.sports.e c02 = SportsHomeVM.this.c0();
                String str = this.f22487c;
                this.f22485a = 1;
                obj = c02.k(str, this);
                if (obj == l6) {
                    return l6;
                }
            }
            Map<String, Object> map = (Map) obj;
            if (map != null) {
                this.f22488d.invoke(map);
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getWeather$2", f = "SportsHomeVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class o extends SuspendLambda implements Function2<Exception, kotlin.coroutines.e<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22489a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Map<String, Object>, n1> f22490b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        o(Function1<? super Map<String, Object>, n1> function1, kotlin.coroutines.e<? super o> eVar) {
            super(2, eVar);
            this.f22490b = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new o(this.f22490b, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Exception exc, kotlin.coroutines.e<? super Boolean> eVar) {
            return ((o) create(exc, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22489a == 0) {
                g0.n(obj);
                this.f22490b.invoke(new LinkedHashMap());
                return kotlin.coroutines.jvm.internal.a.a(true);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$queryLocalSports$1", f = "SportsHomeVM.kt", i = {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODER_STALL, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_PRIMING_WORK_AROUND}, m = "invokeSuspend", n = {"resultList", "resultList", "resultList2", "it", "$this$forEach$iv", "element$iv", "it", "it", "$i$a$-let-SportsHomeVM$queryLocalSports$1$2", "$i$f$forEach", "$i$a$-forEach-SportsHomeVM$queryLocalSports$1$2$1", "$i$a$-let-SportsHomeVM$queryLocalSports$1$2$1$3"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3"})
    @SourceDebugExtension({"SMAP\nSportsHomeVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportsHomeVM.kt\ncom/bxkj/student/v2/vm/sports/SportsHomeVM$queryLocalSports$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,596:1\n1#2:597\n1869#3,2:598\n*S KotlinDebug\n*F\n+ 1 SportsHomeVM.kt\ncom/bxkj/student/v2/vm/sports/SportsHomeVM$queryLocalSports$1\n*L\n368#1:598,2\n*E\n"})
    static final class p extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22491a;

        /* renamed from: b, reason: collision with root package name */
        Object f22492b;

        /* renamed from: c, reason: collision with root package name */
        Object f22493c;

        /* renamed from: d, reason: collision with root package name */
        Object f22494d;

        /* renamed from: e, reason: collision with root package name */
        Object f22495e;

        /* renamed from: f, reason: collision with root package name */
        Object f22496f;

        /* renamed from: g, reason: collision with root package name */
        Object f22497g;

        /* renamed from: h, reason: collision with root package name */
        Object f22498h;

        /* renamed from: i, reason: collision with root package name */
        int f22499i;

        /* renamed from: j, reason: collision with root package name */
        int f22500j;

        /* renamed from: k, reason: collision with root package name */
        int f22501k;

        /* renamed from: l, reason: collision with root package name */
        int f22502l;

        /* renamed from: m, reason: collision with root package name */
        int f22503m;

        p(kotlin.coroutines.e<? super p> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SportsHomeVM.this.new p(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((p) create(eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x0097, code lost:
        
            if (r4 == r1) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x006a, code lost:
        
            if (r2 == r1) goto L40;
         */
        /* JADX WARN: Removed duplicated region for block: B:10:0x00bd  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                Method dump skipped, instructions count: 306
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.SportsHomeVM.p.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$resumeContinue$1", f = "SportsHomeVM.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_UNRELIABLE, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND}, m = "invokeSuspend", n = {}, s = {})
    static final class q extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22505a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ m0.d f22507c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayMap<String, Object> f22508d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f22509e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(m0.d dVar, ArrayMap<String, Object> arrayMap, Function0<n1> function0, kotlin.coroutines.e<? super q> eVar) {
            super(1, eVar);
            this.f22507c = dVar;
            this.f22508d = arrayMap;
            this.f22509e = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SportsHomeVM.this.new q(this.f22507c, this.f22508d, this.f22509e, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((q) create(eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x005d, code lost:
        
            if (r5.f("0", r1, r4) == r0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x005f, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
        
            if (r5.a(r1, r4) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r4.f22505a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.g0.n(r5)
                goto L60
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                kotlin.g0.n(r5)
                goto L36
            L1e:
                kotlin.g0.n(r5)
                com.bxkj.student.v2.vm.sports.SportsHomeVM r5 = com.bxkj.student.v2.vm.sports.SportsHomeVM.this
                com.bxkj.student.v2.repository.sports.e r5 = com.bxkj.student.v2.vm.sports.SportsHomeVM.E(r5)
                m0.d r1 = r4.f22507c
                java.lang.String r1 = r1.I()
                r4.f22505a = r3
                java.lang.Object r5 = r5.a(r1, r4)
                if (r5 != r0) goto L36
                goto L5f
            L36:
                com.bxkj.student.v2.vm.sports.SportsHomeVM r5 = com.bxkj.student.v2.vm.sports.SportsHomeVM.this
                androidx.collection.ArrayMap<java.lang.String, java.lang.Object> r1 = r4.f22508d
                kotlin.jvm.internal.g0.m(r1)
                m0.d r3 = r4.f22507c
                java.lang.String r3 = r3.O()
                int r3 = java.lang.Integer.parseInt(r3)
                com.bxkj.student.v2.vm.sports.SportsHomeVM.H(r5, r1, r3)
                com.bxkj.student.v2.repository.sports.g r5 = new com.bxkj.student.v2.repository.sports.g
                r5.<init>()
                m0.d r1 = r4.f22507c
                java.lang.String r1 = r1.I()
                r4.f22505a = r2
                java.lang.String r2 = "0"
                java.lang.Object r5 = r5.f(r2, r1, r4)
                if (r5 != r0) goto L60
            L5f:
                return r0
            L60:
                kotlin.jvm.functions.Function0<kotlin.n1> r5 = r4.f22509e
                r5.invoke()
                kotlin.n1 r5 = kotlin.n1.f44123a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.SportsHomeVM.q.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$resumeContinue$2", f = "SportsHomeVM.kt", i = {}, l = {401}, m = "invokeSuspend", n = {}, s = {})
    static final class r extends SuspendLambda implements Function2<ApiException, kotlin.coroutines.e<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22510a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ m0.d f22511b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(m0.d dVar, kotlin.coroutines.e<? super r> eVar) {
            super(2, eVar);
            this.f22511b = dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new r(this.f22511b, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(ApiException apiException, kotlin.coroutines.e<? super Boolean> eVar) {
            return ((r) create(apiException, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22510a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.sports.g gVar = new com.bxkj.student.v2.repository.sports.g();
                String I = this.f22511b.I();
                this.f22510a = 1;
                if (gVar.f("3", I, this) == l6) {
                    return l6;
                }
            }
            return kotlin.coroutines.jvm.internal.a.a(false);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$resumeContinue$3", f = "SportsHomeVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class s extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22512a;

        s(kotlin.coroutines.e<? super s> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SportsHomeVM.this.new s(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((s) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22512a == 0) {
                g0.n(obj);
                e2 e2Var = SportsHomeVM.this.f22416z;
                if (e2Var != null) {
                    e2.a.b(e2Var, null, 1, null);
                }
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$resumeContinue$4", f = "SportsHomeVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class t extends SuspendLambda implements Function2<Exception, kotlin.coroutines.e<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22514a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f22515b;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayMap<String, Object> f22517d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ m0.d f22518e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f22519f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(ArrayMap<String, Object> arrayMap, m0.d dVar, Function0<n1> function0, kotlin.coroutines.e<? super t> eVar) {
            super(2, eVar);
            this.f22517d = arrayMap;
            this.f22518e = dVar;
            this.f22519f = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            t tVar = SportsHomeVM.this.new t(this.f22517d, this.f22518e, this.f22519f, eVar);
            tVar.f22515b = obj;
            return tVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Exception exc = (Exception) this.f22515b;
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22514a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            g0.n(obj);
            boolean b6 = com.bxkj.base.v2.common.ext.e.b(exc);
            boolean z5 = false;
            if (b6) {
                com.orhanobut.logger.j.d("离线跑步直接没办法验证超时时间", new Object[0]);
                SportsHomeVM sportsHomeVM = SportsHomeVM.this;
                ArrayMap<String, Object> arrayMap = this.f22517d;
                kotlin.jvm.internal.g0.m(arrayMap);
                sportsHomeVM.x0(arrayMap, Integer.parseInt(this.f22518e.O()));
                this.f22519f.invoke();
                z5 = true;
            }
            return kotlin.coroutines.jvm.internal.a.a(z5);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Exception exc, kotlin.coroutines.e<? super Boolean> eVar) {
            return ((t) create(exc, eVar)).invokeSuspend(n1.f44123a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$setWeather$1", f = "SportsHomeVM.kt", i = {}, l = {IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED_BASELINE}, m = "invokeSuspend", n = {}, s = {})
    static final class u extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22520a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f22522c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f22523d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u(String str, String str2, kotlin.coroutines.e<? super u> eVar) {
            super(1, eVar);
            this.f22522c = str;
            this.f22523d = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SportsHomeVM.this.new u(this.f22522c, this.f22523d, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((u) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22520a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.sports.e c02 = SportsHomeVM.this.c0();
                String str = this.f22522c;
                String str2 = this.f22523d;
                this.f22520a = 1;
                if (c02.l(str, str2, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$setWeather$2", f = "SportsHomeVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class v extends SuspendLambda implements Function2<Exception, kotlin.coroutines.e<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22524a;

        v(kotlin.coroutines.e<? super v> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new v(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Exception exc, kotlin.coroutines.e<? super Boolean> eVar) {
            return ((v) create(exc, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22524a == 0) {
                g0.n(obj);
                return kotlin.coroutines.jvm.internal.a.a(true);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM", f = "SportsHomeVM.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 4, 4, 4}, l = {494, 498, 507, 514, 550}, m = "silentUploadV3", n = {"sportsDb", "sportsDb", "$this$forEach$iv", "element$iv", "faceDb", "faceDb", "faceFile", OptionalModuleUtils.FACE, "$i$f$forEach", "$i$a$-forEach-SportsHomeVM$silentUploadV3$2", "$i$a$-let-SportsHomeVM$silentUploadV3$2$1", "$i$a$-let-SportsHomeVM$silentUploadV3$2$1$2", "sportsDb", "$this$forEach$iv", "element$iv", "faceDb", "faceDb", "faceFile", OptionalModuleUtils.FACE, "$i$f$forEach", "$i$a$-forEach-SportsHomeVM$silentUploadV3$2", "$i$a$-let-SportsHomeVM$silentUploadV3$2$1", "$i$a$-let-SportsHomeVM$silentUploadV3$2$1$2", "sportsDb", "sportsSetMap", "sportsDb", "sportsSetMap", "commitV3"}, s = {"L$0", "L$0", "L$1", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class w extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f22525a;

        /* renamed from: b, reason: collision with root package name */
        Object f22526b;

        /* renamed from: c, reason: collision with root package name */
        Object f22527c;

        /* renamed from: d, reason: collision with root package name */
        Object f22528d;

        /* renamed from: e, reason: collision with root package name */
        Object f22529e;

        /* renamed from: f, reason: collision with root package name */
        Object f22530f;

        /* renamed from: g, reason: collision with root package name */
        Object f22531g;

        /* renamed from: h, reason: collision with root package name */
        Object f22532h;

        /* renamed from: i, reason: collision with root package name */
        int f22533i;

        /* renamed from: j, reason: collision with root package name */
        int f22534j;

        /* renamed from: k, reason: collision with root package name */
        int f22535k;

        /* renamed from: l, reason: collision with root package name */
        int f22536l;

        /* renamed from: m, reason: collision with root package name */
        /* synthetic */ Object f22537m;

        /* renamed from: o, reason: collision with root package name */
        int f22539o;

        w(kotlin.coroutines.e<? super w> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f22537m = obj;
            this.f22539o |= Integer.MIN_VALUE;
            return SportsHomeVM.this.E0(null, this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$startCheckExceptionTimeOut$1", f = "SportsHomeVM.kt", i = {}, l = {org.apache.commons.net.nntp.h.f50924w}, m = "invokeSuspend", n = {}, s = {})
    static final class x extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22540a;

        x(kotlin.coroutines.e<? super x> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return SportsHomeVM.this.new x(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((x) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22540a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                this.f22540a = 1;
                if (a1.b(5000L, this) == l6) {
                    return l6;
                }
            }
            com.orhanobut.logger.j.d("3秒未请求到接口主动取消", new Object[0]);
            e2 e2Var = SportsHomeVM.this.f22415y;
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
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$startTimeOut$1", f = "SportsHomeVM.kt", i = {}, l = {246}, m = "invokeSuspend", n = {}, s = {})
    static final class y extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22542a;

        y(kotlin.coroutines.e<? super y> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return SportsHomeVM.this.new y(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((y) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22542a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                this.f22542a = 1;
                if (a1.b(3000L, this) == l6) {
                    return l6;
                }
            }
            com.orhanobut.logger.j.d("3秒未请求到接口主动取消", new Object[0]);
            e2 e2Var = SportsHomeVM.this.f22413w;
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
    public final void Y(int i6) {
        com.orhanobut.logger.j.d("离线跑步", new Object[0]);
        BaseViewModel.l(this, new f(i6, this, null), null, null, null, null, null, 62, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.sports.e F0() {
        return new com.bxkj.student.v2.repository.sports.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.sports.g G0() {
        return new com.bxkj.student.v2.repository.sports.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.face.c M() {
        return new com.bxkj.student.v2.repository.face.c();
    }

    private final com.bxkj.student.v2.repository.face.c Q() {
        return (com.bxkj.student.v2.repository.face.c) this.f22401k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.c U() {
        return (com.bxkj.student.v2.repository.c) this.f22402l.getValue();
    }

    private final com.bxkj.student.v2.repository.sports.b Z() {
        return (com.bxkj.student.v2.repository.sports.b) this.f22400j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.sports.e c0() {
        return (com.bxkj.student.v2.repository.sports.e) this.f22398h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.sports.g e0() {
        return (com.bxkj.student.v2.repository.sports.g) this.f22399i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.c m0() {
        return new com.bxkj.student.v2.repository.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.sports.b o0() {
        return new com.bxkj.student.v2.repository.sports.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(Map<String, Object> map, int i6) {
        h.a aVar = com.bxkj.student.v2.common.utils.h.f20892a;
        j.a aVar2 = com.bxkj.student.v2.common.data.j.f20683a;
        c0 c0Var = c0.f16887a;
        aVar.x(aVar2.i(c0Var.g(map, "limitSpeed", aVar.l())));
        aVar.B(c0Var.g(map, "startStride", aVar.p()));
        aVar.s(c0Var.g(map, "avgStride", aVar.f()));
        aVar.z(c0Var.g(map, "endStride", aVar.n()));
        aVar.w(c0Var.l(map, "startLimitStepFrequency", aVar.k()));
        aVar.A(c0Var.l(map, "startStepFrequency", aVar.o()));
        aVar.y(c0Var.l(map, "endStepFrequency", aVar.m()));
        aVar.v(c0Var.l(map, "endLimitStepFrequency", aVar.j()));
        aVar.C(c0Var.l(map, "stepCheckDistance", aVar.r()));
        aVar.t(c0Var.l(map, "coefficient", aVar.h()));
        com.orhanobut.logger.j.d(" DriftUtils.maxSpeed=" + aVar.l() + "\n DriftUtils.minStride=" + aVar.p() + "\n DriftUtils.avgStride=" + aVar.f() + "\n DriftUtils.maxStride=" + aVar.n() + "\n DriftUtils.limitMinStep=" + aVar.k() + "\n DriftUtils.minStep=" + aVar.o() + "\n DriftUtils.maxStep=" + aVar.m() + "\n DriftUtils.limitMaxStep=" + aVar.j() + "\n DriftUtils.coefficient=" + aVar.h(), new Object[0]);
        com.bxkj.student.v2.ui.sports.safe.b bVar = com.bxkj.student.v2.ui.sports.safe.b.f21524a;
        bVar.d(c0Var.u(map, "developTips", bVar.a()));
        if (c0Var.l(map, "isCheckDevelop", 1) != 1 || !bVar.b()) {
            Map<String, Object> map2 = !c0Var.d(map, "userOpenDevelop") ? map : null;
            if (map2 != null) {
                map2.put("userOpenDevelop", Boolean.valueOf(com.bxkj.student.v2.common.data.i.f20657a.J()));
            }
            this.f22409s.postValue(map);
            return;
        }
        com.bxkj.student.v2.common.data.i.f20657a.l0(true);
        Activity a6 = com.bxkj.student.v2.common.utils.a.f20868a.a();
        if (a6 != null) {
            ContextExtKt.o(a6, bVar.a(), new Function1() { // from class: com.bxkj.student.v2.vm.sports.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 y02;
                    y02 = SportsHomeVM.y0((iOSOneButtonDialog) obj);
                    return y02;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 y0(iOSOneButtonDialog it) {
        kotlin.jvm.internal.g0.p(it, "it");
        com.bxkj.student.v2.ui.sports.safe.b.f21524a.c();
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(Map<String, Object> map) {
        c0 c0Var = c0.f16887a;
        Map<String, Object> J0 = i1.J0(c0Var.q(i1.J0(map), "morningRun"));
        this.f22404n.postValue(J0);
        Map<String, Object> J02 = i1.J0(c0Var.q(i1.J0(map), "sunRun"));
        this.f22405o.postValue(J02);
        Map<String, Object> J03 = i1.J0(c0Var.q(i1.J0(map), "freedomRun"));
        this.f22406p.postValue(J03);
        Map<String, Object> J04 = i1.J0(c0Var.q(i1.J0(map), "exerciseSite"));
        this.f22407q.postValue(J04);
        Map<String, Object> J05 = i1.J0(c0Var.q(i1.J0(map), "directionRun"));
        this.f22408r.postValue(J05);
        if (kotlin.jvm.internal.g0.g("0", J0.get("isShow")) && kotlin.jvm.internal.g0.g("0", J02.get("isShow")) && kotlin.jvm.internal.g0.g("0", J03.get("isShow")) && kotlin.jvm.internal.g0.g("0", J04.get("isShow")) && kotlin.jvm.internal.g0.g("0", J05.get("isShow"))) {
            f().postValue("系统未开放锻炼，请联系管理员");
        }
    }

    public final void A0(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22405o = mutableLiveData;
    }

    public final void B0(@NotNull MutableLiveData<List<m0.d>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22410t = mutableLiveData;
    }

    public final void C0(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22412v = mutableLiveData;
    }

    public final void D0(@NotNull String city, @NotNull String weather) {
        kotlin.jvm.internal.g0.p(city, "city");
        kotlin.jvm.internal.g0.p(weather, "weather");
        BaseViewModel.l(this, new u(city, weather, null), null, null, null, null, new v(null), 30, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x01b7, code lost:
    
        if (r10.a(r15, r1) != r3) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x01cc, code lost:
    
        r4 = r13;
        r13 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x033e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARN: Type inference failed for: r13v12, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.lang.Iterable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x01b7 -> B:24:0x01bb). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object E0(@org.jetbrains.annotations.NotNull m0.d r51, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r52) {
        /*
            Method dump skipped, instructions count: 831
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.SportsHomeVM.E0(m0.d, kotlin.coroutines.e):java.lang.Object");
    }

    public final void L(@NotNull Function1<Object, n1> success) {
        kotlin.jvm.internal.g0.p(success, "success");
        BaseViewModel.j(this, new b(success, null), null, null, null, null, null, null, null, 254, null);
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> N() {
        return this.f22408r;
    }

    @NotNull
    public final MutableLiveData<List<m0.d>> O() {
        return this.f22411u;
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> P() {
        return this.f22407q;
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> R() {
        return this.f22406p;
    }

    public final void S(@NotNull Function1<? super Map<String, Object>, n1> success) {
        kotlin.jvm.internal.g0.p(success, "success");
        BaseViewModel.j(this, new c(success, null), null, null, null, null, null, null, null, 254, null);
    }

    public final void T() {
        BaseViewModel.j(this, new d(null), null, null, null, null, null, null, null, 254, null);
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> V() {
        return this.f22403m;
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> W() {
        return this.f22404n;
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> a0() {
        return this.f22409s;
    }

    public final void b0(int i6, @Nullable LatLng latLng) {
        if (!c0.b.f1042a.c(App.f17573d.a())) {
            f().postValue("系统内部错误，错误码【1001】");
            return;
        }
        if (com.bxkj.student.v2.common.utils.safe.g.f20947a.d()) {
            f().postValue("系统内部错误，错误码【1002】");
            return;
        }
        if (com.bxkj.student.v2.common.utils.safe.d.f20939a.a()) {
            f().postValue("系统内部错误，错误码【1003】");
            return;
        }
        if (com.bxkj.student.v2.common.utils.safe.f.f20946a.c()) {
            f().postValue("系统内部错误，错误码【1004】");
            return;
        }
        if (com.bxkj.student.v2.common.utils.safe.c.f20938a.d() || Debug.isDebuggerConnected()) {
            f().postValue("系统内部错误，错误码【1005】");
        } else if (com.bxkj.student.v2.common.utils.safe.h.f20948a.a()) {
            f().postValue("系统内部错误，错误码【1006】");
        } else {
            this.f22413w = BaseViewModel.j(this, new g(i6, latLng, this, null), null, null, null, new h(null), new i(i6, null), null, null, 206, null);
        }
    }

    public final void d0() {
        BaseViewModel.j(this, new j(null), null, new k(null), null, null, null, null, null, 250, null);
    }

    public final void f0(@NotNull String identity) {
        kotlin.jvm.internal.g0.p(identity, "identity");
        BaseViewModel.l(this, new l(identity, null), null, new m(null), null, null, null, 58, null);
    }

    @Nullable
    public final Map<String, Object> g0(int i6) {
        return i6 != 0 ? i6 != 1 ? i6 != 2 ? i6 != 5 ? i6 != 6 ? this.f22403m.getValue() : this.f22408r.getValue() : this.f22407q.getValue() : this.f22404n.getValue() : this.f22405o.getValue() : this.f22406p.getValue();
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> h0() {
        return this.f22405o;
    }

    @NotNull
    public final MutableLiveData<List<m0.d>> i0() {
        return this.f22410t;
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> j0() {
        return this.f22412v;
    }

    public final void l0(@NotNull String city, @NotNull Function1<? super Map<String, Object>, n1> success) {
        kotlin.jvm.internal.g0.p(city, "city");
        kotlin.jvm.internal.g0.p(success, "success");
        BaseViewModel.l(this, new n(city, success, null), null, null, null, null, new o(success, null), 30, null);
    }

    public final void n0() {
        BaseViewModel.j(this, new p(null), null, null, null, null, null, null, null, 254, null);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        e2 e2Var = this.f22414x;
        if (e2Var != null) {
            e2.a.b(e2Var, null, 1, null);
        }
        e2 e2Var2 = this.f22416z;
        if (e2Var2 != null) {
            e2.a.b(e2Var2, null, 1, null);
        }
        super.onCleared();
    }

    public final void p0(@NotNull m0.d sportsDb, @NotNull Function0<n1> canContinue) {
        kotlin.jvm.internal.g0.p(sportsDb, "sportsDb");
        kotlin.jvm.internal.g0.p(canContinue, "canContinue");
        ArrayMap<String, Object> jsonToMap = JsonParse.jsonToMap(sportsDb.N());
        kotlin.jvm.internal.g0.m(jsonToMap);
        jsonToMap.put("isFromLocalToContinue", Boolean.TRUE);
        if (!c0.f16887a.d(jsonToMap, "serverUnavailable")) {
            H0();
            this.f22415y = BaseViewModel.j(this, new q(sportsDb, jsonToMap, canContinue, null), new r(sportsDb, null), null, null, new s(null), new t(jsonToMap, sportsDb, canContinue, null), null, null, 204, null);
        } else {
            com.orhanobut.logger.j.d("如果开始跑步的时候服务器不可用，恢复跑步的时候直接恢复跑步", new Object[0]);
            x0(jsonToMap, Integer.parseInt(sportsDb.O()));
            canContinue.invoke();
        }
    }

    public final void q0(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22408r = mutableLiveData;
    }

    public final void r0(@NotNull MutableLiveData<List<m0.d>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22411u = mutableLiveData;
    }

    public final void s0(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22407q = mutableLiveData;
    }

    public final void t0(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22406p = mutableLiveData;
    }

    public final void u0(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22403m = mutableLiveData;
    }

    public final void v0(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22404n = mutableLiveData;
    }

    public final void w0(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22409s = mutableLiveData;
    }

    private final void H0() {
        e2 f6;
        f6 = kotlinx.coroutines.k.f(ViewModelKt.getViewModelScope(this), null, null, new x(null), 3, null);
        this.f22416z = f6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I0() {
        e2 f6;
        f6 = kotlinx.coroutines.k.f(ViewModelKt.getViewModelScope(this), null, null, new y(null), 3, null);
        this.f22414x = f6;
    }

    public final void K() {
        kotlinx.coroutines.k.f(ViewModelKt.getViewModelScope(this), g1.c(), null, new a(null), 2, null);
    }

    public final void X() {
        kotlinx.coroutines.k.f(ViewModelKt.getViewModelScope(this), null, null, new e(null), 3, null);
    }

    public final void k0() {
    }
}
