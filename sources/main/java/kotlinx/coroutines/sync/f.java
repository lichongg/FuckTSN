package kotlinx.coroutines.sync;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d0;
import kotlinx.coroutines.internal.s0;
import kotlinx.coroutines.internal.x0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final int f49638a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final s0 f49639b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final s0 f49640c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final s0 f49641d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final s0 f49642e;

    /* renamed from: f, reason: collision with root package name */
    private static final int f49643f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.sync.SemaphoreKt", f = "Semaphore.kt", i = {0, 0}, l = {86}, m = "withPermit", n = {"$this$withPermit", com.umeng.ccg.a.f41544t}, s = {"L$0", "L$1"})
    @SourceDebugExtension({"SMAP\nSemaphore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt$withPermit$1\n*L\n1#1,397:1\n*E\n"})
    static final class a<T> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f49644a;

        /* renamed from: b, reason: collision with root package name */
        Object f49645b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f49646c;

        /* renamed from: d, reason: collision with root package name */
        int f49647d;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f49646c = obj;
            this.f49647d |= Integer.MIN_VALUE;
            return f.k(null, null, this);
        }

        a(kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
        }
    }

    private static final <T> Object l(d dVar, Function0<? extends T> function0, kotlin.coroutines.e<? super T> eVar) {
        d0.e(0);
        dVar.c(eVar);
        d0.e(1);
        try {
            return function0.invoke();
        } finally {
            d0.d(1);
            dVar.release();
            d0.c(1);
        }
    }

    static {
        int e6;
        int e7;
        e6 = x0.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        f49638a = e6;
        f49639b = new s0("PERMIT");
        f49640c = new s0("TAKEN");
        f49641d = new s0("BROKEN");
        f49642e = new s0("CANCELLED");
        e7 = x0.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
        f49643f = e7;
    }

    @NotNull
    public static final d a(int i6, int i7) {
        return new e(i6, i7);
    }

    public static /* synthetic */ d b(int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        return a(i6, i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g j(long j6, g gVar) {
        return new g(j6, gVar, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object k(@org.jetbrains.annotations.NotNull kotlinx.coroutines.sync.d r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super T> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.sync.f.a
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.sync.f$a r0 = (kotlinx.coroutines.sync.f.a) r0
            int r1 = r0.f49647d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49647d = r1
            goto L18
        L13:
            kotlinx.coroutines.sync.f$a r0 = new kotlinx.coroutines.sync.f$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f49646c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f49647d
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.f49645b
            r5 = r4
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            java.lang.Object r4 = r0.f49644a
            kotlinx.coroutines.sync.d r4 = (kotlinx.coroutines.sync.d) r4
            kotlin.g0.n(r6)
            goto L4a
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.g0.n(r6)
            r0.f49644a = r4
            r0.f49645b = r5
            r0.f49647d = r3
            java.lang.Object r6 = r4.c(r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            java.lang.Object r5 = r5.invoke()     // Catch: java.lang.Throwable -> L58
            kotlin.jvm.internal.d0.d(r3)
            r4.release()
            kotlin.jvm.internal.d0.c(r3)
            return r5
        L58:
            r5 = move-exception
            kotlin.jvm.internal.d0.d(r3)
            r4.release()
            kotlin.jvm.internal.d0.c(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.f.k(kotlinx.coroutines.sync.d, kotlin.jvm.functions.Function0, kotlin.coroutines.e):java.lang.Object");
    }
}
