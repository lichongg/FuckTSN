package com.bxkj.student.v2.repository.sports;

import com.baidu.idl.face.platform.common.ConstantHelper;
import com.baidu.mobads.sdk.internal.bn;
import com.bxkj.student.v2.common.db.AppDatabase;
import com.bxkj.student.v2.common.db.dao.x;
import com.kuaishou.weapon.p0.t;
import com.umeng.analytics.AnalyticsConfig;
import java.util.List;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSportsRepository.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportsRepository.kt\ncom/bxkj/student/v2/repository/sports/SportsRepository\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,168:1\n1788#2,4:169\n1788#2,4:173\n1788#2,4:177\n1#3:181\n*S KotlinDebug\n*F\n+ 1 SportsRepository.kt\ncom/bxkj/student/v2/repository/sports/SportsRepository\n*L\n86#1:169,4\n87#1:173,4\n88#1:177,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class g {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.repository.sports.SportsRepository", f = "SportsRepository.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {97, 117}, m = "commitV3_2", n = {"sportRange", "speed", "avgSpeed", bn.f10754j, bn.f10753i, ConstantHelper.LOG_OS, "version", "appVersion", "pointList", "stepNumbers", "isSequencePoint", "gitudeLatitude", "okPointList", "isFaceStatus", "uploadType", "identify", "geofence", "limitSpeed", "limitStride", "limitStepFrequency", "gpsDistance", "isRunningOpenDevelop", "paramMap", "latLngList", "f", t.f36152m, "h", "d", "sportType", AnalyticsConfig.RTD_START_TIME, "endTime", "sportTime", "isOpenDevelopInStart", "sportRange", "speed", "avgSpeed", bn.f10754j, bn.f10753i, ConstantHelper.LOG_OS, "version", "appVersion", "pointList", "stepNumbers", "isSequencePoint", "gitudeLatitude", "okPointList", "isFaceStatus", "uploadType", "identify", "geofence", "limitSpeed", "limitStride", "limitStepFrequency", "gpsDistance", "isRunningOpenDevelop", "paramMap", "latLngList", "f", t.f36152m, "h", "d", "jsonParam", "timestamp", "aesEncrypt", "key", "data", "sportType", AnalyticsConfig.RTD_START_TIME, "endTime", "sportTime", "isOpenDevelopInStart"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "I$0", "J$0", "J$1", "J$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "I$0", "J$0", "J$1", "J$2", "Z$0"})
    static final class a extends ContinuationImpl {
        Object A;
        Object B;
        Object C;
        Object D;
        Object E;
        Object F;
        Object G;
        Object H;
        Object I;
        Object J;
        Object K;
        boolean L;
        /* synthetic */ Object M;
        int O;

        /* renamed from: a, reason: collision with root package name */
        int f21234a;

        /* renamed from: b, reason: collision with root package name */
        long f21235b;

        /* renamed from: c, reason: collision with root package name */
        long f21236c;

        /* renamed from: d, reason: collision with root package name */
        long f21237d;

        /* renamed from: e, reason: collision with root package name */
        Object f21238e;

        /* renamed from: f, reason: collision with root package name */
        Object f21239f;

        /* renamed from: g, reason: collision with root package name */
        Object f21240g;

        /* renamed from: h, reason: collision with root package name */
        Object f21241h;

        /* renamed from: i, reason: collision with root package name */
        Object f21242i;

        /* renamed from: j, reason: collision with root package name */
        Object f21243j;

        /* renamed from: k, reason: collision with root package name */
        Object f21244k;

        /* renamed from: l, reason: collision with root package name */
        Object f21245l;

        /* renamed from: m, reason: collision with root package name */
        Object f21246m;

        /* renamed from: n, reason: collision with root package name */
        Object f21247n;

        /* renamed from: o, reason: collision with root package name */
        Object f21248o;

        /* renamed from: p, reason: collision with root package name */
        Object f21249p;

        /* renamed from: q, reason: collision with root package name */
        Object f21250q;

        /* renamed from: r, reason: collision with root package name */
        Object f21251r;

        /* renamed from: s, reason: collision with root package name */
        Object f21252s;

        /* renamed from: t, reason: collision with root package name */
        Object f21253t;

        /* renamed from: u, reason: collision with root package name */
        Object f21254u;

        /* renamed from: v, reason: collision with root package name */
        Object f21255v;

        /* renamed from: w, reason: collision with root package name */
        Object f21256w;

        /* renamed from: x, reason: collision with root package name */
        Object f21257x;

        /* renamed from: y, reason: collision with root package name */
        Object f21258y;

        /* renamed from: z, reason: collision with root package name */
        Object f21259z;

        a(kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.M = obj;
            this.O |= Integer.MIN_VALUE;
            return g.this.a(0, 0L, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.repository.sports.SportsRepository", f = "SportsRepository.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {165}, m = "passPointCameraV2", n = {"identify", "remark", master.flame.danmaku.danmaku.parser.b.f50156c, "paramMap", "timestamp", "aesEncrypt", "key", "data", "requestBody"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"})
    static final class b extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f21260a;

        /* renamed from: b, reason: collision with root package name */
        Object f21261b;

        /* renamed from: c, reason: collision with root package name */
        Object f21262c;

        /* renamed from: d, reason: collision with root package name */
        Object f21263d;

        /* renamed from: e, reason: collision with root package name */
        Object f21264e;

        /* renamed from: f, reason: collision with root package name */
        Object f21265f;

        /* renamed from: g, reason: collision with root package name */
        Object f21266g;

        /* renamed from: h, reason: collision with root package name */
        Object f21267h;

        /* renamed from: i, reason: collision with root package name */
        Object f21268i;

        /* renamed from: j, reason: collision with root package name */
        /* synthetic */ Object f21269j;

        /* renamed from: l, reason: collision with root package name */
        int f21271l;

        b(kotlin.coroutines.e<? super b> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21269j = obj;
            this.f21271l |= Integer.MIN_VALUE;
            return g.this.d(null, null, null, this);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|1|(2:3|(6:5|6|(1:(1:(2:10|11)(2:13|14))(4:15|16|17|18))(12:43|(3:45|(3:161|(4:164|(3:175|176|177)|178|162)|183)(1:49)|50)(1:184)|(3:52|(3:137|(4:140|(3:151|152|153)|154|138)|159)(1:56)|57)(1:160)|(3:59|(3:113|(4:116|(3:127|128|129)|130|114)|135)(1:63)|64)(1:136)|65|(1:67)(1:112)|(1:69)|(3:71|(1:73)(1:76)|(1:75))|77|78|79|(15:81|82|83|84|85|86|87|88|89|90|91|92|93|(1:95)|29)(4:109|37|27|(1:29)(1:30)))|19|20|(7:22|23|24|25|26|27|(0)(0))(4:36|37|27|(0)(0))))|185|6|(0)(0)|19|20|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x04dd, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x04de, code lost:
    
        r47 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x048a A[Catch: Exception -> 0x04dd, TRY_LEAVE, TryCatch #4 {Exception -> 0x04dd, blocks: (B:20:0x0486, B:22:0x048a), top: B:19:0x0486 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x06bd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x06be A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /* JADX WARN: Type inference failed for: r20v24, types: [java.util.Map] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(int r47, long r48, long r50, long r52, @org.jetbrains.annotations.Nullable java.lang.String r54, @org.jetbrains.annotations.Nullable java.lang.String r55, @org.jetbrains.annotations.Nullable java.lang.String r56, @org.jetbrains.annotations.Nullable java.lang.String r57, @org.jetbrains.annotations.Nullable java.lang.String r58, @org.jetbrains.annotations.Nullable java.lang.String r59, @org.jetbrains.annotations.Nullable java.lang.String r60, @org.jetbrains.annotations.Nullable java.lang.String r61, @org.jetbrains.annotations.Nullable java.lang.String r62, @org.jetbrains.annotations.Nullable java.lang.String r63, @org.jetbrains.annotations.Nullable java.lang.String r64, @org.jetbrains.annotations.Nullable java.lang.String r65, @org.jetbrains.annotations.Nullable java.lang.String r66, @org.jetbrains.annotations.Nullable java.lang.String r67, @org.jetbrains.annotations.Nullable java.lang.Integer r68, @org.jetbrains.annotations.Nullable java.lang.String r69, @org.jetbrains.annotations.Nullable java.lang.String r70, @org.jetbrains.annotations.Nullable java.lang.String r71, @org.jetbrains.annotations.Nullable java.lang.String r72, @org.jetbrains.annotations.Nullable java.lang.String r73, @org.jetbrains.annotations.Nullable java.lang.String r74, boolean r75, @org.jetbrains.annotations.Nullable java.lang.String r76, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super com.bxkj.student.v2.common.data.CommitResult<java.lang.Object>> r77) {
        /*
            Method dump skipped, instructions count: 1727
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.sports.g.a(int, long, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, kotlin.coroutines.e):java.lang.Object");
    }

    @Nullable
    public final Object b(@NotNull String str, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        x x5 = AppDatabase.f20686a.a().x();
        if (x5 == null) {
            return null;
        }
        Object deleteByIdentify = x5.deleteByIdentify(str, eVar);
        return deleteByIdentify == kotlin.coroutines.intrinsics.a.l() ? deleteByIdentify : n1.f44123a;
    }

    @Nullable
    public final Object c(@NotNull String str, @NotNull kotlin.coroutines.e<? super List<m0.d>> eVar) {
        x x5 = AppDatabase.f20686a.a().x();
        if (x5 != null) {
            return x5.getLocalRecordById(str, eVar);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(@org.jetbrains.annotations.NotNull java.lang.String r17, @org.jetbrains.annotations.NotNull java.lang.String r18, @org.jetbrains.annotations.NotNull java.io.File r19, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r20) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.sports.g.d(java.lang.String, java.lang.String, java.io.File, kotlin.coroutines.e):java.lang.Object");
    }

    @Nullable
    public final Object e(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        x x5 = AppDatabase.f20686a.a().x();
        if (x5 == null) {
            return null;
        }
        Object g6 = x5.g(str, str2, str3, str4, eVar);
        return g6 == kotlin.coroutines.intrinsics.a.l() ? g6 : n1.f44123a;
    }

    @Nullable
    public final Object f(@NotNull String str, @NotNull String str2, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        x x5 = AppDatabase.f20686a.a().x();
        if (x5 == null) {
            return null;
        }
        Object n6 = x5.n(str, str2, eVar);
        return n6 == kotlin.coroutines.intrinsics.a.l() ? n6 : n1.f44123a;
    }

    @Nullable
    public final Object g(@NotNull String str, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        x x5 = AppDatabase.f20686a.a().x();
        if (x5 == null) {
            return null;
        }
        Object h6 = x5.h(str, eVar);
        return h6 == kotlin.coroutines.intrinsics.a.l() ? h6 : n1.f44123a;
    }

    @Nullable
    public final Object h(@NotNull String str, @NotNull String str2, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        x x5 = AppDatabase.f20686a.a().x();
        if (x5 == null) {
            return null;
        }
        Object k6 = x5.k(str, str2, eVar);
        return k6 == kotlin.coroutines.intrinsics.a.l() ? k6 : n1.f44123a;
    }
}
