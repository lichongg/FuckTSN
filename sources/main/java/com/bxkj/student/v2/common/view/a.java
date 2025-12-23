package com.bxkj.student.v2.common.view;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.v;
import kotlin.n1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.d3;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.flow.k;
import kotlinx.coroutines.flow.s;
import kotlinx.coroutines.flow.x;
import kotlinx.coroutines.flow.z;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f21069a = new a();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final s<AbstractC0279a> f21070b;

    /* renamed from: c, reason: collision with root package name */
    private static final long f21071c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final x<AbstractC0279a> f21072d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final r0 f21073e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private static e2 f21074f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bxkj.student.v2.common.view.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0279a {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.v2.common.view.a$a$a, reason: collision with other inner class name */
        public static final class C0280a extends AbstractC0279a {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final C0280a f21075a = new C0280a();

            private C0280a() {
                super(null);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.v2.common.view.a$a$b */
        public static final class b extends AbstractC0279a {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final b f21076a = new b();

            private b() {
                super(null);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.v2.common.view.a$a$c */
        public static final class c extends AbstractC0279a {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final c f21077a = new c();

            private c() {
                super(null);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.v2.common.view.a$a$d */
        public static final class d extends AbstractC0279a {

            /* renamed from: a, reason: collision with root package name */
            private final long f21078a;

            public d(long j6) {
                super(null);
                this.f21078a = j6;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof d) && this.f21078a == ((d) obj).f21078a;
            }

            public static /* synthetic */ d c(d dVar, long j6, int i6, Object obj) {
                if ((i6 & 1) != 0) {
                    j6 = dVar.f21078a;
                }
                return dVar.b(j6);
            }

            public final long a() {
                return this.f21078a;
            }

            @NotNull
            public final d b(long j6) {
                return new d(j6);
            }

            public final long d() {
                return this.f21078a;
            }

            public int hashCode() {
                return androidx.camera.camera2.internal.compat.params.e.a(this.f21078a);
            }

            @NotNull
            public String toString() {
                return "Ticked(remainingSeconds=" + this.f21078a + ")";
            }
        }

        public /* synthetic */ AbstractC0279a(v vVar) {
            this();
        }

        private AbstractC0279a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.common.view.CountdownService$startCountdown$1", f = "CountdownService.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f21079a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.student.v2.common.view.CountdownService$startCountdown$1$1", f = "CountdownService.kt", i = {1, 2, 3}, l = {38, 41, 44, 46}, m = "invokeSuspend", n = {"remainingSeconds", "remainingSeconds", "remainingSeconds"}, s = {"J$0", "J$0", "J$0"})
        /* renamed from: com.bxkj.student.v2.common.view.a$b$a, reason: collision with other inner class name */
        static final class C0281a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            long f21080a;

            /* renamed from: b, reason: collision with root package name */
            int f21081b;

            C0281a(kotlin.coroutines.e<? super C0281a> eVar) {
                super(2, eVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new C0281a(eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
                return ((C0281a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:11:0x0058, code lost:
            
                if (kotlinx.coroutines.a1.b(1000, r11) == r0) goto L30;
             */
            /* JADX WARN: Code restructure failed: missing block: B:15:0x0070, code lost:
            
                if (r12.emit(r1, r11) == r0) goto L30;
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x0084, code lost:
            
                if (r12.emit(r1, r11) != r0) goto L18;
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x0086, code lost:
            
                return r0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:29:0x0043, code lost:
            
                if (r12.emit(r1, r11) == r0) goto L30;
             */
            /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0087  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0084 -> B:8:0x004a). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                /*
                    r11 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                    int r1 = r11.f21081b
                    r2 = 0
                    r4 = 4
                    r5 = 3
                    r6 = 2
                    r7 = 1
                    if (r1 == 0) goto L34
                    if (r1 == r7) goto L30
                    if (r1 == r6) goto L2a
                    if (r1 == r5) goto L24
                    if (r1 != r4) goto L1c
                    long r7 = r11.f21080a
                    kotlin.g0.n(r12)
                    goto L4a
                L1c:
                    java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r12.<init>(r0)
                    throw r12
                L24:
                    long r7 = r11.f21080a
                    kotlin.g0.n(r12)
                    goto L73
                L2a:
                    long r7 = r11.f21080a
                    kotlin.g0.n(r12)
                    goto L5b
                L30:
                    kotlin.g0.n(r12)
                    goto L46
                L34:
                    kotlin.g0.n(r12)
                    kotlinx.coroutines.flow.s r12 = com.bxkj.student.v2.common.view.a.b()
                    com.bxkj.student.v2.common.view.a$a$c r1 = com.bxkj.student.v2.common.view.a.AbstractC0279a.c.f21077a
                    r11.f21081b = r7
                    java.lang.Object r12 = r12.emit(r1, r11)
                    if (r12 != r0) goto L46
                    goto L86
                L46:
                    long r7 = com.bxkj.student.v2.common.view.a.a()
                L4a:
                    int r12 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                    if (r12 <= 0) goto L87
                    r11.f21080a = r7
                    r11.f21081b = r6
                    r9 = 1000(0x3e8, double:4.94E-321)
                    java.lang.Object r12 = kotlinx.coroutines.a1.b(r9, r11)
                    if (r12 != r0) goto L5b
                    goto L86
                L5b:
                    r9 = -1
                    long r7 = r7 + r9
                    int r12 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                    if (r12 != 0) goto L73
                    kotlinx.coroutines.flow.s r12 = com.bxkj.student.v2.common.view.a.b()
                    com.bxkj.student.v2.common.view.a$a$b r1 = com.bxkj.student.v2.common.view.a.AbstractC0279a.b.f21076a
                    r11.f21080a = r7
                    r11.f21081b = r5
                    java.lang.Object r12 = r12.emit(r1, r11)
                    if (r12 != r0) goto L73
                    goto L86
                L73:
                    kotlinx.coroutines.flow.s r12 = com.bxkj.student.v2.common.view.a.b()
                    com.bxkj.student.v2.common.view.a$a$d r1 = new com.bxkj.student.v2.common.view.a$a$d
                    r1.<init>(r7)
                    r11.f21080a = r7
                    r11.f21081b = r4
                    java.lang.Object r12 = r12.emit(r1, r11)
                    if (r12 != r0) goto L4a
                L86:
                    return r0
                L87:
                    kotlin.n1 r12 = kotlin.n1.f44123a
                    return r12
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.common.view.a.b.C0281a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        b(kotlin.coroutines.e<? super b> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new b(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((b) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f21079a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                C0281a c0281a = new C0281a(null);
                this.f21079a = 1;
                if (d3.e(c0281a, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    static {
        s<AbstractC0279a> a6 = z.a(0, 1, BufferOverflow.DROP_LATEST);
        f21070b = a6;
        f21071c = 5L;
        f21072d = k.l(a6);
        f21073e = s0.a(g1.a());
    }

    public final void c() {
        e2 e2Var = f21074f;
        if (e2Var != null) {
            e2.a.b(e2Var, null, 1, null);
        }
        f21070b.c(AbstractC0279a.C0280a.f21075a);
    }

    @NotNull
    public final x<AbstractC0279a> d() {
        return f21072d;
    }

    @NotNull
    public final r0 e() {
        return f21073e;
    }

    public final void f() {
        e2 f6;
        e2 e2Var = f21074f;
        if (e2Var != null) {
            e2.a.b(e2Var, null, 1, null);
        }
        f6 = kotlinx.coroutines.k.f(f21073e, null, null, new b(null), 3, null);
        f21074f = f6;
    }

    private a() {
    }
}
