package kotlinx.coroutines;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n3 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", i = {0, 0, 0}, l = {104}, m = "withTimeoutOrNull", n = {"block", "coroutine", "timeMillis"}, s = {"L$0", "L$1", "J$0"})
    static final class a<T> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        long f49400a;

        /* renamed from: b, reason: collision with root package name */
        Object f49401b;

        /* renamed from: c, reason: collision with root package name */
        Object f49402c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f49403d;

        /* renamed from: e, reason: collision with root package name */
        int f49404e;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f49403d = obj;
            this.f49404e |= Integer.MIN_VALUE;
            return n3.e(0L, null, this);
        }

        a(kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r4 == null) goto L9;
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlinx.coroutines.TimeoutCancellationException a(long r2, @org.jetbrains.annotations.NotNull kotlinx.coroutines.z0 r4, @org.jetbrains.annotations.NotNull kotlinx.coroutines.e2 r5) {
        /*
            boolean r0 = r4 instanceof kotlinx.coroutines.b1
            if (r0 == 0) goto L7
            kotlinx.coroutines.b1 r4 = (kotlinx.coroutines.b1) r4
            goto L8
        L7:
            r4 = 0
        L8:
            if (r4 == 0) goto L18
            kotlin.time.h$a r0 = kotlin.time.h.f48019b
            kotlin.time.DurationUnit r0 = kotlin.time.DurationUnit.MILLISECONDS
            long r0 = kotlin.time.j.x(r2, r0)
            java.lang.String r4 = r4.h(r0)
            if (r4 != 0) goto L2e
        L18:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Timed out waiting for "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r2 = " ms"
            r4.append(r2)
            java.lang.String r4 = r4.toString()
        L2e:
            kotlinx.coroutines.TimeoutCancellationException r2 = new kotlinx.coroutines.TimeoutCancellationException
            r2.<init>(r4, r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.n3.a(long, kotlinx.coroutines.z0, kotlinx.coroutines.e2):kotlinx.coroutines.TimeoutCancellationException");
    }

    private static final <U, T extends U> Object b(m3<U, ? super T> m3Var, Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2) {
        h2.y(m3Var, a1.d(m3Var.f49294d.getContext()).m(m3Var.f49393e, m3Var, m3Var.getContext()));
        return o4.b.f(m3Var, m3Var, function2);
    }

    @Nullable
    public static final <T> Object c(long j6, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super T> eVar) {
        if (j6 <= 0) {
            throw new TimeoutCancellationException("Timed out immediately");
        }
        Object b6 = b(new m3(j6, eVar), function2);
        if (b6 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return b6;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.m3] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object e(long r7, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.r0, ? super kotlin.coroutines.e<? super T>, ? extends java.lang.Object> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super T> r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.n3.a
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.n3$a r0 = (kotlinx.coroutines.n3.a) r0
            int r1 = r0.f49404e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49404e = r1
            goto L18
        L13:
            kotlinx.coroutines.n3$a r0 = new kotlinx.coroutines.n3$a
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f49403d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f49404e
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 != r4) goto L34
            java.lang.Object r7 = r0.f49402c
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r8 = r0.f49401b
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            kotlin.g0.n(r10)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L32
            return r10
        L32:
            r8 = move-exception
            goto L6f
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            kotlin.g0.n(r10)
            r5 = 0
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 > 0) goto L46
            return r3
        L46:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            r0.f49401b = r9     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            r0.f49402c = r10     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            r0.f49400a = r7     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            r0.f49404e = r4     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            kotlinx.coroutines.m3 r2 = new kotlinx.coroutines.m3     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            r2.<init>(r7, r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            r10.element = r2     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            java.lang.Object r7 = b(r2, r9)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            java.lang.Object r8 = kotlin.coroutines.intrinsics.a.l()     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            if (r7 != r8) goto L6b
            kotlin.coroutines.jvm.internal.e.c(r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            goto L6b
        L68:
            r8 = move-exception
            r7 = r10
            goto L6f
        L6b:
            if (r7 != r1) goto L6e
            return r1
        L6e:
            return r7
        L6f:
            kotlinx.coroutines.e2 r9 = r8.coroutine
            T r7 = r7.element
            if (r9 != r7) goto L76
            return r3
        L76:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.n3.e(long, kotlin.jvm.functions.Function2, kotlin.coroutines.e):java.lang.Object");
    }

    @Nullable
    public static final <T> Object d(long j6, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return c(a1.e(j6), function2, eVar);
    }

    @Nullable
    public static final <T> Object f(long j6, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return e(a1.e(j6), function2, eVar);
    }
}
