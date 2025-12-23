package kotlinx.coroutines;

import kotlin.coroutines.i;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/DelayKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,162:1\n314#2,11:163\n314#2,11:174\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/DelayKt\n*L\n106#1:163,11\n127#1:174,11\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a1 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.DelayKt", f = "Delay.kt", i = {}, l = {163}, m = "awaitCancellation", n = {}, s = {})
    static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f48080a;

        /* renamed from: b, reason: collision with root package name */
        int f48081b;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48080a = obj;
            this.f48081b |= Integer.MIN_VALUE;
            return a1.a(this);
        }

        a(kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.coroutines.e<?> r4) {
        /*
            boolean r0 = r4 instanceof kotlinx.coroutines.a1.a
            if (r0 == 0) goto L13
            r0 = r4
            kotlinx.coroutines.a1$a r0 = (kotlinx.coroutines.a1.a) r0
            int r1 = r0.f48081b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48081b = r1
            goto L18
        L13:
            kotlinx.coroutines.a1$a r0 = new kotlinx.coroutines.a1$a
            r0.<init>(r4)
        L18:
            java.lang.Object r4 = r0.f48080a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48081b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L2d:
            kotlin.g0.n(r4)
            goto L52
        L31:
            kotlin.g0.n(r4)
            r0.f48081b = r3
            kotlinx.coroutines.q r4 = new kotlinx.coroutines.q
            kotlin.coroutines.e r2 = kotlin.coroutines.intrinsics.a.e(r0)
            r4.<init>(r2, r3)
            r4.Q()
            java.lang.Object r4 = r4.x()
            java.lang.Object r2 = kotlin.coroutines.intrinsics.a.l()
            if (r4 != r2) goto L4f
            kotlin.coroutines.jvm.internal.e.c(r0)
        L4f:
            if (r4 != r1) goto L52
            return r1
        L52:
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.a1.a(kotlin.coroutines.e):java.lang.Object");
    }

    @Nullable
    public static final Object b(long j6, @NotNull kotlin.coroutines.e<? super kotlin.n1> eVar) {
        if (j6 <= 0) {
            return kotlin.n1.f44123a;
        }
        q qVar = new q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
        qVar.Q();
        if (j6 < Long.MAX_VALUE) {
            d(qVar.getContext()).i(j6, qVar);
        }
        Object x5 = qVar.x();
        if (x5 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return x5 == kotlin.coroutines.intrinsics.a.l() ? x5 : kotlin.n1.f44123a;
    }

    @NotNull
    public static final z0 d(@NotNull kotlin.coroutines.i iVar) {
        i.b bVar = iVar.get(kotlin.coroutines.f.f43765o0);
        z0 z0Var = bVar instanceof z0 ? (z0) bVar : null;
        return z0Var == null ? w0.a() : z0Var;
    }

    public static final long e(long j6) {
        if (kotlin.time.h.k(j6, kotlin.time.h.f48019b.T()) > 0) {
            return kotlin.ranges.t.v(kotlin.time.h.x(j6), 1L);
        }
        return 0L;
    }

    @Nullable
    public static final Object c(long j6, @NotNull kotlin.coroutines.e<? super kotlin.n1> eVar) {
        Object b6 = b(e(j6), eVar);
        if (b6 == kotlin.coroutines.intrinsics.a.l()) {
            return b6;
        }
        return kotlin.n1.f44123a;
    }
}
