package com.bxkj.student.v2.vm.sports.record;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.lifecycle.MutableLiveData;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.v2.common.data.j;
import com.bxkj.student.v2.common.utils.h;
import com.bxkj.student.v2.vm.sports.record.RecordDetailVM;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tencent.bugly.BuglyStrategy;
import com.umeng.analytics.AnalyticsConfig;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.f0;
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
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRecordDetailVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordDetailVM.kt\ncom/bxkj/student/v2/vm/sports/record/RecordDetailVM\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,264:1\n1#2:265\n774#3:266\n865#3,2:267\n774#3:269\n865#3,2:270\n*S KotlinDebug\n*F\n+ 1 RecordDetailVM.kt\ncom/bxkj/student/v2/vm/sports/record/RecordDetailVM\n*L\n241#1:266\n241#1:267,2\n244#1:269\n244#1:270,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class RecordDetailVM extends BaseViewModel {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final s f22638h = t.c(new Function0() { // from class: com.bxkj.student.v2.vm.sports.record.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.c G;
            G = RecordDetailVM.G();
            return G;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private MutableLiveData<Map<String, Object>> f22639i = new MutableLiveData<>();

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private MutableLiveData<Map<String, Object>> f22640j = new MutableLiveData<>();

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private String f22641k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    private String f22642l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private String f22643m;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordDetailVM$getDetailLocal$1", f = "RecordDetailVM.kt", i = {1}, l = {82, 85}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
    static final class a extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22644a;

        /* renamed from: b, reason: collision with root package name */
        int f22645b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordDetailVM$getDetailLocal$1$1", f = "RecordDetailVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        @SourceDebugExtension({"SMAP\nRecordDetailVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordDetailVM.kt\ncom/bxkj/student/v2/vm/sports/record/RecordDetailVM$getDetailLocal$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,264:1\n1563#2:265\n1634#2,3:266\n*S KotlinDebug\n*F\n+ 1 RecordDetailVM.kt\ncom/bxkj/student/v2/vm/sports/record/RecordDetailVM$getDetailLocal$1$1\n*L\n87#1:265\n87#1:266,3\n*E\n"})
        /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordDetailVM$a$a, reason: collision with other inner class name */
        static final class C0300a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f22647a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ List<m0.d> f22648b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ RecordDetailVM f22649c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0300a(List<m0.d> list, RecordDetailVM recordDetailVM, kotlin.coroutines.e<? super C0300a> eVar) {
                super(2, eVar);
                this.f22648b = list;
                this.f22649c = recordDetailVM;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final n1 l(Map map, List list) {
                map.put("paceMinute", list);
                return n1.f44123a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final n1 m(Map map, List list) {
                map.put("paceKm", list);
                return n1.f44123a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final n1 n(Map map, List list) {
                map.put("distanceMinute", list);
                return n1.f44123a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final n1 p(Map map, int i6) {
                map.put("exceptionStepDistanceCount", Integer.valueOf(i6));
                return n1.f44123a;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new C0300a(this.f22648b, this.f22649c, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
                return ((C0300a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                String C;
                String C2;
                String C3;
                kotlin.coroutines.intrinsics.a.l();
                if (this.f22647a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                g0.n(obj);
                List<m0.d> list = this.f22648b;
                if (list != null && !list.isEmpty()) {
                    List<m0.d> list2 = this.f22648b;
                    ArrayList arrayList = new ArrayList(f0.d0(list2, 10));
                    for (m0.d dVar : list2) {
                        com.orhanobut.logger.j.d("本地跑步记录数据=" + dVar, new Object[0]);
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put("identify", dVar != null ? dVar.I() : null);
                        if (dVar != null) {
                            linkedHashMap.put("speed", com.bxkj.student.run.app.utils.i.b(Double.parseDouble(dVar.C()), Long.parseLong(dVar.B())));
                            linkedHashMap.put("avgspeed", com.bxkj.student.run.app.utils.i.a(Double.parseDouble(dVar.C()), Long.parseLong(dVar.B())));
                        }
                        linkedHashMap.put("sportRange", com.bxkj.student.run.app.utils.i.c((dVar == null || (C3 = dVar.C()) == null) ? 0.0d : Double.parseDouble(C3)));
                        linkedHashMap.put("sportTime", dVar != null ? dVar.B() : null);
                        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
                        linkedHashMap.put("nickName", TextUtils.isEmpty(aVar.a().U()) ? dVar != null ? dVar.T() : null : aVar.a().U());
                        linkedHashMap.put("userName", dVar != null ? dVar.T() : null);
                        c0 c0Var = c0.f16887a;
                        linkedHashMap.put("gitudeLatitude", c0Var.z(dVar != null ? dVar.J() : null));
                        linkedHashMap.put("stepNumbers", dVar != null ? dVar.R() : null);
                        linkedHashMap.put("isException", dVar != null ? dVar.U() : null);
                        linkedHashMap.put(AnalyticsConfig.RTD_START_TIME, dVar != null ? dVar.Q() : null);
                        linkedHashMap.put("heartRate", "-");
                        linkedHashMap.put("calorie", "-");
                        linkedHashMap.put("rate", "-");
                        linkedHashMap.put("rate", "-");
                        ArrayMap<String, Object> jsonToMap = JsonParse.jsonToMap(dVar != null ? dVar.N() : null);
                        linkedHashMap.put("sportsSetMap", jsonToMap);
                        linkedHashMap.put("sportType", c0Var.t(jsonToMap, "runType"));
                        linkedHashMap.put("geofence", c0Var.t(jsonToMap, "geofence"));
                        linkedHashMap.put("pointList", c0Var.n(jsonToMap, "list"));
                        linkedHashMap.put("okPointList", c0Var.z(dVar != null ? dVar.L() : null));
                        linkedHashMap.put("isSequencePoint", c0Var.t(jsonToMap, "isSequencePoint"));
                        j.a aVar2 = com.bxkj.student.v2.common.data.j.f20683a;
                        double d6 = 1000;
                        linkedHashMap.put("stepSetting", kotlin.coroutines.jvm.internal.a.f(aVar2.c(c0Var.k(jsonToMap, "isStepRecursion"), c0Var.f(jsonToMap, "totalRange"), c0Var.k(jsonToMap, "step"), com.bxkj.student.run.app.utils.i.e((dVar == null || (C2 = dVar.C()) == null) ? 0.0d : Double.parseDouble(C2)) * d6)));
                        linkedHashMap.put("rangeSetting", c0Var.t(jsonToMap, "totalRange"));
                        linkedHashMap.put("startQualifiedTimeSetting", c0Var.t(jsonToMap, "startQualifiedTime"));
                        linkedHashMap.put("endQualifiedTimeSetting", kotlin.coroutines.jvm.internal.a.f(aVar2.d(c0Var.f(jsonToMap, "totalRange"), c0Var.k(jsonToMap, "endQualifiedTime"), com.bxkj.student.run.app.utils.i.e((dVar == null || (C = dVar.C()) == null) ? 0.0d : Double.parseDouble(C)) * d6)));
                        arrayList.add(linkedHashMap);
                    }
                    if (!arrayList.isEmpty()) {
                        final Map<String, ? extends Object> map = (Map) arrayList.get(0);
                        j.a aVar3 = com.bxkj.student.v2.common.data.j.f20683a;
                        c0 c0Var2 = c0.f16887a;
                        aVar3.b(c0Var2.g(map, "limitStride", 2.3d), c0Var2.n(map, "gitudeLatitude"), new Function1() { // from class: com.bxkj.student.v2.vm.sports.record.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                n1 l6;
                                l6 = RecordDetailVM.a.C0300a.l(map, (List) obj2);
                                return l6;
                            }
                        }, new Function1() { // from class: com.bxkj.student.v2.vm.sports.record.c
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                n1 m6;
                                m6 = RecordDetailVM.a.C0300a.m(map, (List) obj2);
                                return m6;
                            }
                        }, new Function1() { // from class: com.bxkj.student.v2.vm.sports.record.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                n1 n6;
                                n6 = RecordDetailVM.a.C0300a.n(map, (List) obj2);
                                return n6;
                            }
                        }, new Function1() { // from class: com.bxkj.student.v2.vm.sports.record.e
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                n1 p5;
                                p5 = RecordDetailVM.a.C0300a.p(map, ((Integer) obj2).intValue());
                                return p5;
                            }
                        });
                        com.orhanobut.logger.j.d("localList=" + map, new Object[0]);
                        this.f22649c.M(map);
                    }
                }
                return n1.f44123a;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordDetailVM$getDetailLocal$1$result$1", f = "RecordDetailVM.kt", i = {0, 0}, l = {83}, m = "invokeSuspend", n = {"it", "$i$a$-let-RecordDetailVM$getDetailLocal$1$result$1$1"}, s = {"L$0", "I$0"})
        @SourceDebugExtension({"SMAP\nRecordDetailVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordDetailVM.kt\ncom/bxkj/student/v2/vm/sports/record/RecordDetailVM$getDetailLocal$1$result$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,264:1\n1#2:265\n*E\n"})
        static final class b extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super List<? extends m0.d>>, Object> {

            /* renamed from: a, reason: collision with root package name */
            Object f22650a;

            /* renamed from: b, reason: collision with root package name */
            int f22651b;

            /* renamed from: c, reason: collision with root package name */
            int f22652c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ RecordDetailVM f22653d;

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(r0 r0Var, kotlin.coroutines.e<? super List<? extends m0.d>> eVar) {
                return invoke2(r0Var, (kotlin.coroutines.e<? super List<m0.d>>) eVar);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(RecordDetailVM recordDetailVM, kotlin.coroutines.e<? super b> eVar) {
                super(2, eVar);
                this.f22653d = recordDetailVM;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new b(this.f22653d, eVar);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(r0 r0Var, kotlin.coroutines.e<? super List<m0.d>> eVar) {
                return ((b) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object l6 = kotlin.coroutines.intrinsics.a.l();
                int i6 = this.f22652c;
                if (i6 != 0) {
                    if (i6 == 1) {
                        g0.n(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    g0.n(obj);
                    String A = this.f22653d.A();
                    if (A != null) {
                        com.bxkj.student.v2.repository.sports.a aVar = new com.bxkj.student.v2.repository.sports.a();
                        this.f22650a = kotlin.coroutines.jvm.internal.j.a(A);
                        this.f22651b = 0;
                        this.f22652c = 1;
                        obj = aVar.a(A, this);
                        if (obj == l6) {
                            return l6;
                        }
                    } else {
                        return null;
                    }
                }
                return (List) obj;
            }
        }

        a(kotlin.coroutines.e<? super a> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return RecordDetailVM.this.new a(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0053, code lost:
        
            if (kotlinx.coroutines.i.h(r1, r4, r6) == r0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0055, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
        
            if (r7 == r0) goto L15;
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
                int r1 = r6.f22645b
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L23
                if (r1 == r4) goto L1f
                if (r1 != r3) goto L17
                java.lang.Object r0 = r6.f22644a
                java.util.List r0 = (java.util.List) r0
                kotlin.g0.n(r7)
                goto L56
            L17:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1f:
                kotlin.g0.n(r7)
                goto L3a
            L23:
                kotlin.g0.n(r7)
                kotlinx.coroutines.m0 r7 = kotlinx.coroutines.g1.c()
                com.bxkj.student.v2.vm.sports.record.RecordDetailVM$a$b r1 = new com.bxkj.student.v2.vm.sports.record.RecordDetailVM$a$b
                com.bxkj.student.v2.vm.sports.record.RecordDetailVM r5 = com.bxkj.student.v2.vm.sports.record.RecordDetailVM.this
                r1.<init>(r5, r2)
                r6.f22645b = r4
                java.lang.Object r7 = kotlinx.coroutines.i.h(r7, r1, r6)
                if (r7 != r0) goto L3a
                goto L55
            L3a:
                java.util.List r7 = (java.util.List) r7
                kotlinx.coroutines.m0 r1 = kotlinx.coroutines.g1.a()
                com.bxkj.student.v2.vm.sports.record.RecordDetailVM$a$a r4 = new com.bxkj.student.v2.vm.sports.record.RecordDetailVM$a$a
                com.bxkj.student.v2.vm.sports.record.RecordDetailVM r5 = com.bxkj.student.v2.vm.sports.record.RecordDetailVM.this
                r4.<init>(r7, r5, r2)
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.j.a(r7)
                r6.f22644a = r7
                r6.f22645b = r3
                java.lang.Object r7 = kotlinx.coroutines.i.h(r1, r4, r6)
                if (r7 != r0) goto L56
            L55:
                return r0
            L56:
                kotlin.n1 r7 = kotlin.n1.f44123a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.record.RecordDetailVM.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordDetailVM$getDetailOnline$1", f = "RecordDetailVM.kt", i = {0, 0, 1, 1, 1}, l = {39, 41}, m = "invokeSuspend", n = {"it", "$i$a$-let-RecordDetailVM$getDetailOnline$1$result$1", "result", "it", "$i$a$-let-RecordDetailVM$getDetailOnline$1$1"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0"})
    @SourceDebugExtension({"SMAP\nRecordDetailVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordDetailVM.kt\ncom/bxkj/student/v2/vm/sports/record/RecordDetailVM$getDetailOnline$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,264:1\n1#2:265\n*E\n"})
    static final class b extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22654a;

        /* renamed from: b, reason: collision with root package name */
        Object f22655b;

        /* renamed from: c, reason: collision with root package name */
        int f22656c;

        /* renamed from: d, reason: collision with root package name */
        int f22657d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordDetailVM$getDetailOnline$1$1$1", f = "RecordDetailVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f22659a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f22660b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f22661c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ RecordDetailVM f22662d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Map<String, Object> map, Map<String, Object> map2, RecordDetailVM recordDetailVM, kotlin.coroutines.e<? super a> eVar) {
                super(2, eVar);
                this.f22660b = map;
                this.f22661c = map2;
                this.f22662d = recordDetailVM;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final n1 l(Map map, List list) {
                map.put("paceMinute", list);
                return n1.f44123a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final n1 m(Map map, List list) {
                map.put("paceKm", list);
                return n1.f44123a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final n1 n(Map map, List list) {
                map.put("distanceMinute", list);
                return n1.f44123a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final n1 p(Map map, int i6) {
                map.put("exceptionStepDistanceCount", Integer.valueOf(i6));
                return n1.f44123a;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new a(this.f22660b, this.f22661c, this.f22662d, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
                return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.a.l();
                if (this.f22659a == 0) {
                    g0.n(obj);
                    h.a aVar = com.bxkj.student.v2.common.utils.h.f20892a;
                    j.a aVar2 = com.bxkj.student.v2.common.data.j.f20683a;
                    c0 c0Var = c0.f16887a;
                    aVar.x(aVar2.i(c0Var.g(this.f22661c, "limitSpeed", aVar.l())));
                    double g6 = c0Var.g(this.f22660b, "limitStride", aVar.n());
                    List<Map<String, Object>> n6 = c0Var.n(this.f22660b, "gitudeLatitude");
                    final Map<String, Object> map = this.f22660b;
                    Function1<? super List<Double>, n1> function1 = new Function1() { // from class: com.bxkj.student.v2.vm.sports.record.f
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            n1 l6;
                            l6 = RecordDetailVM.b.a.l(map, (List) obj2);
                            return l6;
                        }
                    };
                    final Map<String, Object> map2 = this.f22660b;
                    Function1<? super List<Double>, n1> function12 = new Function1() { // from class: com.bxkj.student.v2.vm.sports.record.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            n1 m6;
                            m6 = RecordDetailVM.b.a.m(map2, (List) obj2);
                            return m6;
                        }
                    };
                    final Map<String, Object> map3 = this.f22660b;
                    Function1<? super List<Double>, n1> function13 = new Function1() { // from class: com.bxkj.student.v2.vm.sports.record.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            n1 n7;
                            n7 = RecordDetailVM.b.a.n(map3, (List) obj2);
                            return n7;
                        }
                    };
                    final Map<String, Object> map4 = this.f22660b;
                    aVar2.b(g6, n6, function1, function12, function13, new Function1() { // from class: com.bxkj.student.v2.vm.sports.record.i
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            n1 p5;
                            p5 = RecordDetailVM.b.a.p(map4, ((Integer) obj2).intValue());
                            return p5;
                        }
                    });
                    this.f22662d.M(this.f22660b);
                    return n1.f44123a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        b(kotlin.coroutines.e<? super b> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return RecordDetailVM.this.new b(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((b) create(eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0072, code lost:
        
            if (kotlinx.coroutines.i.h(r5, r6, r7) == r0) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0074, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x004a, code lost:
        
            if (r8 == r0) goto L20;
         */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r7.f22657d
                r2 = 0
                r3 = 0
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2c
                if (r1 == r5) goto L24
                if (r1 != r4) goto L1c
                java.lang.Object r0 = r7.f22655b
                java.util.Map r0 = (java.util.Map) r0
                java.lang.Object r0 = r7.f22654a
                java.util.Map r0 = (java.util.Map) r0
                kotlin.g0.n(r8)
                goto L75
            L1c:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L24:
                java.lang.Object r1 = r7.f22654a
                java.lang.String r1 = (java.lang.String) r1
                kotlin.g0.n(r8)
                goto L4d
            L2c:
                kotlin.g0.n(r8)
                com.bxkj.student.v2.vm.sports.record.RecordDetailVM r8 = com.bxkj.student.v2.vm.sports.record.RecordDetailVM.this
                java.lang.String r8 = r8.z()
                if (r8 == 0) goto L50
                com.bxkj.student.v2.repository.sports.a r1 = new com.bxkj.student.v2.repository.sports.a
                r1.<init>()
                java.lang.Object r6 = kotlin.coroutines.jvm.internal.j.a(r8)
                r7.f22654a = r6
                r7.f22656c = r3
                r7.f22657d = r5
                java.lang.Object r8 = r1.d(r8, r7)
                if (r8 != r0) goto L4d
                goto L74
            L4d:
                java.util.Map r8 = (java.util.Map) r8
                goto L51
            L50:
                r8 = r2
            L51:
                if (r8 == 0) goto L75
                com.bxkj.student.v2.vm.sports.record.RecordDetailVM r1 = com.bxkj.student.v2.vm.sports.record.RecordDetailVM.this
                kotlinx.coroutines.m0 r5 = kotlinx.coroutines.g1.a()
                com.bxkj.student.v2.vm.sports.record.RecordDetailVM$b$a r6 = new com.bxkj.student.v2.vm.sports.record.RecordDetailVM$b$a
                r6.<init>(r8, r8, r1, r2)
                java.lang.Object r1 = kotlin.coroutines.jvm.internal.j.a(r8)
                r7.f22654a = r1
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.j.a(r8)
                r7.f22655b = r8
                r7.f22656c = r3
                r7.f22657d = r4
                java.lang.Object r8 = kotlinx.coroutines.i.h(r5, r6, r7)
                if (r8 != r0) goto L75
            L74:
                return r0
            L75:
                kotlin.n1 r8 = kotlin.n1.f44123a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.record.RecordDetailVM.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordDetailVM$getLoginUserInfo$1", f = "RecordDetailVM.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nRecordDetailVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordDetailVM.kt\ncom/bxkj/student/v2/vm/sports/record/RecordDetailVM$getLoginUserInfo$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,264:1\n1#2:265\n*E\n"})
    static final class c extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22663a;

        c(kotlin.coroutines.e<? super c> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return RecordDetailVM.this.new c(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((c) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22663a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.c C = RecordDetailVM.this.C();
                this.f22663a = 1;
                obj = C.g(this);
                if (obj == l6) {
                    return l6;
                }
            }
            Map<String, Object> map = (Map) obj;
            if (map != null) {
                RecordDetailVM.this.F().postValue(map);
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.record.RecordDetailVM$getShareCircleUrl$1", f = "RecordDetailVM.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nRecordDetailVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordDetailVM.kt\ncom/bxkj/student/v2/vm/sports/record/RecordDetailVM$getShareCircleUrl$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,264:1\n1#2:265\n*E\n"})
    static final class d extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22665a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Map<String, ? extends Object>, n1> f22666b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(Function1<? super Map<String, ? extends Object>, n1> function1, kotlin.coroutines.e<? super d> eVar) {
            super(1, eVar);
            this.f22666b = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return new d(this.f22666b, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((d) create(eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22665a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                com.bxkj.student.v2.repository.sports.a aVar = new com.bxkj.student.v2.repository.sports.a();
                this.f22665a = 1;
                obj = aVar.b(this);
                if (obj == l6) {
                    return l6;
                }
            }
            Map<String, ? extends Object> map = (Map) obj;
            if (map != null) {
                this.f22666b.invoke(map);
            }
            return n1.f44123a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.c C() {
        return (com.bxkj.student.v2.repository.c) this.f22638h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.c G() {
        return new com.bxkj.student.v2.repository.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(Map<String, Object> map) {
        Object obj;
        Object obj2;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        c0 c0Var = c0.f16887a;
        map.put("app_format_sportRange", decimalFormat.format(c0Var.f(map, "sportRange")));
        map.put("app_format_sportTime", com.bxkj.student.run.app.utils.i.g(c0Var.o(map, "sportTime")));
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = c0Var.h(map, "paceMinute").iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            double doubleValue = ((Number) obj).doubleValue();
            if (doubleValue > 0.0d && doubleValue < 3.0d) {
                break;
            }
        }
        if (((Double) obj) != null) {
            sb.append("配速");
        }
        c0 c0Var2 = c0.f16887a;
        List<Integer> m6 = c0Var2.m(map, "stepNumbers");
        if (m6.isEmpty()) {
            m6 = null;
        }
        if (m6 != null) {
            List<Integer> list = m6;
            int H5 = f0.H5(list);
            map.put("stepCount", String.valueOf(H5));
            map.put("stepMinute", Double.valueOf(Math.floor(f0.Q1(list))));
            if (H5 != 0) {
                map.put("stepDistance", String.valueOf((int) ((c0Var2.f(map, "sportRange") * BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH) / H5)));
            }
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj2 = it2.next();
                    if (((Number) obj2).intValue() > c0.f16887a.l(map, "limitStepFrequency", com.bxkj.student.v2.common.utils.h.f20892a.j())) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            if (((Integer) obj2) != null) {
                if ((sb.length() > 0 ? this : null) != null) {
                    sb.append("、");
                }
                sb.append("步频");
            }
            c0 c0Var3 = c0.f16887a;
            if ((c0Var3.k(map, "stepDistance") > kotlin.math.b.K0(c0Var3.g(map, "limitStride", com.bxkj.student.v2.common.utils.h.f20892a.n()) * ((double) 100)) ? this : null) != null) {
                if ((sb.length() > 0 ? this : null) != null) {
                    sb.append("、");
                }
                sb.append("步幅");
            }
        }
        if ((sb.length() > 0 ? this : null) != null) {
            map.put("exceptionData", ((Object) sb) + "数据异常，可以替祖国拿金牌了。但这样可能会导致您的成绩无效！请规范跑步！");
            com.orhanobut.logger.j.d("exceptionData=" + c0.f16887a.t(map, "exceptionData"), new Object[0]);
        }
        c0 c0Var4 = c0.f16887a;
        map.put("app_format_avgspeed", decimalFormat.format(c0Var4.f(map, "avgspeed")));
        Double n42 = f0.n4(c0Var4.h(map, "paceKm"));
        map.put("bestPaceKm", n42 != null ? com.bxkj.student.v2.common.data.j.f20683a.f(n42.doubleValue()) : "-");
        List<Double> h6 = c0Var4.h(map, "paceMinute");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it3 = h6.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next = it3.next();
            if (!(((Number) next).doubleValue() == 0.0d)) {
                arrayList.add(next);
            }
        }
        Double n43 = f0.n4(arrayList);
        if (n43 != null) {
            map.put("fastSpeed", Double.valueOf(com.bxkj.student.v2.common.data.j.f20683a.h(n43.doubleValue())));
        }
        List<Double> h7 = c0.f16887a.h(map, "paceMinute");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : h7) {
            if (!(((Number) obj3).doubleValue() == 0.0d)) {
                arrayList2.add(obj3);
            }
        }
        Double V3 = f0.V3(arrayList2);
        if (V3 != null) {
            map.put("slowSpeed", Double.valueOf(com.bxkj.student.v2.common.data.j.f20683a.h(V3.doubleValue())));
        }
        this.f22640j.postValue(map);
    }

    @Nullable
    public final String A() {
        return this.f22642l;
    }

    public final void B() {
        BaseViewModel.j(this, new c(null), null, null, null, null, null, null, null, 254, null);
    }

    public final void D(@NotNull Function1<? super Map<String, ? extends Object>, n1> success) {
        kotlin.jvm.internal.g0.p(success, "success");
        BaseViewModel.j(this, new d(success, null), null, null, null, null, null, null, null, 254, null);
    }

    @Nullable
    public final String E() {
        return this.f22643m;
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> F() {
        return this.f22639i;
    }

    public final void H(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22640j = mutableLiveData;
    }

    public final void I(@Nullable String str) {
        this.f22641k = str;
    }

    public final void J(@Nullable String str) {
        this.f22642l = str;
    }

    public final void K(@Nullable String str) {
        this.f22643m = str;
    }

    public final void L(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22639i = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> w() {
        return this.f22640j;
    }

    public final void x() {
        BaseViewModel.j(this, new a(null), null, null, null, null, null, null, null, 254, null);
    }

    public final void y() {
        BaseViewModel.j(this, new b(null), null, null, null, null, null, null, null, 254, null);
    }

    @Nullable
    public final String z() {
        return this.f22641k;
    }
}
