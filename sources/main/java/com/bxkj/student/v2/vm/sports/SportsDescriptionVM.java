package com.bxkj.student.v2.vm.sports;

import androidx.lifecycle.MutableLiveData;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.student.v2.common.db.AppDatabase;
import com.bxkj.student.v2.common.db.dao.q0;
import com.tencent.open.SocialConstants;
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
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class SportsDescriptionVM extends BaseViewModel {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private MutableLiveData<Map<String, Object>> f22387h = new MutableLiveData<>();

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private final s f22388i = t.c(new Function0() { // from class: com.bxkj.student.v2.vm.sports.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.bxkj.student.v2.repository.sports.d z5;
            z5 = SportsDescriptionVM.z();
            return z5;
        }
    });

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsDescriptionVM$getSportsDescription$1", f = "SportsDescriptionVM.kt", i = {1, 1, 1, 1}, l = {28, 32}, m = "invokeSuspend", n = {"result", SocialConstants.PARAM_COMMENT, "it", "$i$a$-let-SportsDescriptionVM$getSportsDescription$1$1"}, s = {"L$0", "L$1", "L$2", "I$0"})
    static final class a extends SuspendLambda implements Function1<kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22389a;

        /* renamed from: b, reason: collision with root package name */
        Object f22390b;

        /* renamed from: c, reason: collision with root package name */
        Object f22391c;

        /* renamed from: d, reason: collision with root package name */
        int f22392d;

        /* renamed from: e, reason: collision with root package name */
        int f22393e;

        a(kotlin.coroutines.e<? super a> eVar) {
            super(1, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
            return SportsDescriptionVM.this.new a(eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0087, code lost:
        
            if (r3.insert(r4, r7) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0089, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
        
            if (r8 == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r7.f22393e
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2a
                if (r1 == r3) goto L26
                if (r1 != r2) goto L1e
                java.lang.Object r0 = r7.f22391c
                java.lang.String r0 = (java.lang.String) r0
                java.lang.Object r0 = r7.f22390b
                java.lang.String r0 = (java.lang.String) r0
                java.lang.Object r0 = r7.f22389a
                java.util.Map r0 = (java.util.Map) r0
                kotlin.g0.n(r8)
                goto L8a
            L1e:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L26:
                kotlin.g0.n(r8)
                goto L3c
            L2a:
                kotlin.g0.n(r8)
                com.bxkj.student.v2.vm.sports.SportsDescriptionVM r8 = com.bxkj.student.v2.vm.sports.SportsDescriptionVM.this
                com.bxkj.student.v2.repository.sports.d r8 = com.bxkj.student.v2.vm.sports.SportsDescriptionVM.u(r8)
                r7.f22393e = r3
                java.lang.Object r8 = r8.a(r7)
                if (r8 != r0) goto L3c
                goto L89
            L3c:
                java.util.Map r8 = (java.util.Map) r8
                com.bxkj.student.v2.vm.sports.SportsDescriptionVM r1 = com.bxkj.student.v2.vm.sports.SportsDescriptionVM.this
                androidx.lifecycle.MutableLiveData r1 = r1.v()
                r1.postValue(r8)
                com.bxkj.base.v2.common.utils.c0 r1 = com.bxkj.base.v2.common.utils.c0.f16887a
                java.lang.String r3 = "content"
                java.lang.String r1 = r1.t(r8, r3)
                com.bxkj.student.v2.common.db.AppDatabase$a r3 = com.bxkj.student.v2.common.db.AppDatabase.f20686a
                com.bxkj.student.v2.common.db.AppDatabase r3 = r3.a()
                com.bxkj.student.v2.common.db.dao.q0 r3 = r3.y()
                if (r3 == 0) goto L8a
                m0.e r4 = new m0.e
                com.bxkj.base.v2.data.b$a r5 = com.bxkj.base.v2.data.b.f16998d
                com.bxkj.base.v2.data.b r5 = r5.a()
                java.lang.String r5 = r5.R()
                java.lang.String r6 = "-2"
                r4.<init>(r5, r6, r1)
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.j.a(r8)
                r7.f22389a = r8
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.j.a(r1)
                r7.f22390b = r8
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.j.a(r1)
                r7.f22391c = r8
                r8 = 0
                r7.f22392d = r8
                r7.f22393e = r2
                java.lang.Object r8 = r3.insert(r4, r7)
                if (r8 != r0) goto L8a
            L89:
                return r0
            L8a:
                kotlin.n1 r8 = kotlin.n1.f44123a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.SportsDescriptionVM.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsDescriptionVM$getSportsDescription$2", f = "SportsDescriptionVM.kt", i = {0}, l = {40}, m = "invokeSuspend", n = {"e"}, s = {"L$0"})
    @SourceDebugExtension({"SMAP\nSportsDescriptionVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportsDescriptionVM.kt\ncom/bxkj/student/v2/vm/sports/SportsDescriptionVM$getSportsDescription$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,52:1\n1#2:53\n*E\n"})
    static final class b extends SuspendLambda implements Function2<Exception, kotlin.coroutines.e<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22395a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f22396b;

        b(kotlin.coroutines.e<? super b> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            b bVar = SportsDescriptionVM.this.new b(eVar);
            bVar.f22396b = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Exception exc = (Exception) this.f22396b;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22395a;
            boolean z5 = true;
            if (i6 == 0) {
                g0.n(obj);
                if (!com.bxkj.base.v2.common.ext.e.b(exc)) {
                    z5 = false;
                    return kotlin.coroutines.jvm.internal.a.a(z5);
                }
                com.orhanobut.logger.j.d("离线跑步获取跑步说明", new Object[0]);
                q0 y5 = AppDatabase.f20686a.a().y();
                if (y5 != null) {
                    this.f22396b = kotlin.coroutines.jvm.internal.j.a(exc);
                    this.f22395a = 1;
                    obj = y5.b("-2", this);
                    if (obj == l6) {
                        return l6;
                    }
                }
                SportsDescriptionVM.this.f().postValue("服务器维护中，请稍后再进行跑步");
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
                    MutableLiveData<Map<String, Object>> v5 = SportsDescriptionVM.this.v();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("content", str);
                    v5.postValue(linkedHashMap);
                    return kotlin.coroutines.jvm.internal.a.a(z5);
                }
            }
            SportsDescriptionVM.this.f().postValue("服务器维护中，请稍后再进行跑步");
            return kotlin.coroutines.jvm.internal.a.a(z5);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Exception exc, kotlin.coroutines.e<? super Boolean> eVar) {
            return ((b) create(exc, eVar)).invokeSuspend(n1.f44123a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.sports.d x() {
        return (com.bxkj.student.v2.repository.sports.d) this.f22388i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.sports.d z() {
        return new com.bxkj.student.v2.repository.sports.d();
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> v() {
        return this.f22387h;
    }

    public final void w() {
        BaseViewModel.j(this, new a(null), null, new b(null), null, null, null, null, null, 250, null);
    }

    public final void y(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        kotlin.jvm.internal.g0.p(mutableLiveData, "<set-?>");
        this.f22387h = mutableLiveData;
    }
}
