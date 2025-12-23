package com.bxkj.student.v2.common.utils.safe;

import android.os.Build;
import android.os.Debug;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.BaseApp;
import com.bxkj.student.App;
import com.bxkj.student.v2.common.db.AppDatabase;
import com.oplus.omes.stdsco.probe.ProbeClient;
import java.util.LinkedHashMap;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.j;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.k;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f20940a = new e();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.common.utils.safe.EnvironmentCheck$initMySafeCheckEnvironmentCheck$1", f = "EnvironmentCheck.kt", i = {0}, l = {43}, m = "invokeSuspend", n = {"mySafe"}, s = {"L$0"})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f20941a;

        /* renamed from: b, reason: collision with root package name */
        int f20942b;

        a(kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new a(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z5;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f20942b;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("sign", kotlin.coroutines.jvm.internal.a.a(c0.b.f1042a.c(App.f17573d.a())));
                linkedHashMap.put("root", kotlin.coroutines.jvm.internal.a.a(g.f20947a.d()));
                linkedHashMap.put("emulator", kotlin.coroutines.jvm.internal.a.a(d.f20939a.a()));
                linkedHashMap.put("hook", kotlin.coroutines.jvm.internal.a.a(f.f20946a.c()));
                if (!c.f20938a.d() && !Debug.isDebuggerConnected()) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                linkedHashMap.put("debug", kotlin.coroutines.jvm.internal.a.a(z5));
                linkedHashMap.put("breakpoint", kotlin.coroutines.jvm.internal.a.a(h.f20948a.a()));
                linkedHashMap.put("supported_abis", Build.SUPPORTED_ABIS);
                com.bxkj.student.v2.common.db.dao.b u5 = AppDatabase.f20686a.a().u();
                if (u5 != null) {
                    String str = JSON.toJSONString(linkedHashMap).toString();
                    this.f20941a = j.a(linkedHashMap);
                    this.f20942b = 1;
                    if (u5.e(str, this) == l6) {
                        return l6;
                    }
                }
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements com.oplus.omes.stdsco.probe.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f20943a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.student.v2.common.utils.safe.EnvironmentCheck$initOppoSavedEnvironmentCheck$1$onSuccess$1$1", f = "EnvironmentCheck.kt", i = {}, l = {52, 53}, m = "invokeSuspend", n = {}, s = {})
        static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f20944a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f20945b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, kotlin.coroutines.e<? super a> eVar) {
                super(2, eVar);
                this.f20945b = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new a(this.f20945b, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
                return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
            
                if (r5 == r0) goto L19;
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
            
                return r0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
            
                if (r5.a(r1, r4) == r0) goto L19;
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
                    int r1 = r4.f20944a
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L1e
                    if (r1 == r3) goto L1a
                    if (r1 != r2) goto L12
                    kotlin.g0.n(r5)
                    goto L4d
                L12:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r0)
                    throw r5
                L1a:
                    kotlin.g0.n(r5)
                    goto L38
                L1e:
                    kotlin.g0.n(r5)
                    com.bxkj.student.v2.common.db.AppDatabase$a r5 = com.bxkj.student.v2.common.db.AppDatabase.f20686a
                    com.bxkj.student.v2.common.db.AppDatabase r5 = r5.a()
                    com.bxkj.student.v2.common.db.dao.b r5 = r5.u()
                    if (r5 == 0) goto L38
                    java.lang.String r1 = r4.f20945b
                    r4.f20944a = r3
                    java.lang.Object r5 = r5.a(r1, r4)
                    if (r5 != r0) goto L38
                    goto L4c
                L38:
                    com.bxkj.student.v2.common.db.AppDatabase$a r5 = com.bxkj.student.v2.common.db.AppDatabase.f20686a
                    com.bxkj.student.v2.common.db.AppDatabase r5 = r5.a()
                    com.bxkj.student.v2.common.db.dao.b r5 = r5.u()
                    if (r5 == 0) goto L50
                    r4.f20944a = r2
                    java.lang.Object r5 = r5.f(r4)
                    if (r5 != r0) goto L4d
                L4c:
                    return r0
                L4d:
                    m0.a r5 = (m0.a) r5
                    goto L51
                L50:
                    r5 = 0
                L51:
                    com.orhanobut.logger.j.c(r5)
                    kotlin.n1 r5 = kotlin.n1.f44123a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.common.utils.safe.e.b.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        b(FragmentActivity fragmentActivity) {
            this.f20943a = fragmentActivity;
        }

        @Override // com.oplus.omes.stdsco.probe.a
        public void onSuccess(String str) {
            com.orhanobut.logger.j.h(str);
            if (str != null) {
                k.f(LifecycleOwnerKt.getLifecycleScope(this.f20943a), g1.c(), null, new a(str, null), 2, null);
            }
        }

        @Override // com.oplus.omes.stdsco.probe.a
        public void onError(String str) {
        }
    }

    public final void a(@NotNull FragmentActivity activity) {
        kotlin.jvm.internal.g0.p(activity, "activity");
        b(activity);
        c(activity);
    }

    private e() {
    }

    private final void b(FragmentActivity fragmentActivity) {
        k.f(LifecycleOwnerKt.getLifecycleScope(fragmentActivity), g1.c(), null, new a(null), 2, null);
    }

    private final void c(FragmentActivity fragmentActivity) {
        ProbeClient.a(BaseApp.c(), new b(fragmentActivity));
    }
}
