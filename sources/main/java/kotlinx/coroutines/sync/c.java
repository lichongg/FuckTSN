package kotlinx.coroutines.sync;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d0;
import kotlinx.coroutines.internal.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final s0 f49615a = new s0("NO_OWNER");

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final s0 f49616b = new s0("ALREADY_LOCKED_BY_OWNER");

    /* renamed from: c, reason: collision with root package name */
    private static final int f49617c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static final int f49618d = 1;

    /* renamed from: e, reason: collision with root package name */
    private static final int f49619e = 2;

    /* renamed from: f, reason: collision with root package name */
    private static final int f49620f = 0;

    /* renamed from: g, reason: collision with root package name */
    private static final int f49621g = 1;

    /* renamed from: h, reason: collision with root package name */
    private static final int f49622h = 2;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.sync.MutexKt", f = "Mutex.kt", i = {0, 0, 0}, l = {125}, m = "withLock", n = {"$this$withLock", "owner", com.umeng.ccg.a.f41544t}, s = {"L$0", "L$1", "L$2"})
    @SourceDebugExtension({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexKt$withLock$1\n*L\n1#1,310:1\n*E\n"})
    static final class a<T> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f49623a;

        /* renamed from: b, reason: collision with root package name */
        Object f49624b;

        /* renamed from: c, reason: collision with root package name */
        Object f49625c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f49626d;

        /* renamed from: e, reason: collision with root package name */
        int f49627e;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f49626d = obj;
            this.f49627e |= Integer.MIN_VALUE;
            return c.e(null, null, null, this);
        }

        a(kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
        }
    }

    private static final <T> Object f(kotlinx.coroutines.sync.a aVar, Object obj, Function0<? extends T> function0, kotlin.coroutines.e<? super T> eVar) {
        d0.e(0);
        aVar.lock(obj, eVar);
        d0.e(1);
        try {
            return function0.invoke();
        } finally {
            d0.d(1);
            aVar.unlock(obj);
            d0.c(1);
        }
    }

    public static /* synthetic */ Object g(kotlinx.coroutines.sync.a aVar, Object obj, Function0 function0, kotlin.coroutines.e eVar, int i6, Object obj2) {
        if ((i6 & 1) != 0) {
            obj = null;
        }
        d0.e(0);
        aVar.lock(obj, eVar);
        d0.e(1);
        try {
            return function0.invoke();
        } finally {
            d0.d(1);
            aVar.unlock(obj);
            d0.c(1);
        }
    }

    @NotNull
    public static final kotlinx.coroutines.sync.a a(boolean z5) {
        return new b(z5);
    }

    public static /* synthetic */ kotlinx.coroutines.sync.a b(boolean z5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = false;
        }
        return a(z5);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.sync.a r4, @org.jetbrains.annotations.Nullable java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super T> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.sync.c.a
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.sync.c$a r0 = (kotlinx.coroutines.sync.c.a) r0
            int r1 = r0.f49627e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49627e = r1
            goto L18
        L13:
            kotlinx.coroutines.sync.c$a r0 = new kotlinx.coroutines.sync.c$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f49626d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f49627e
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.f49625c
            r6 = r4
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            java.lang.Object r5 = r0.f49624b
            java.lang.Object r4 = r0.f49623a
            kotlinx.coroutines.sync.a r4 = (kotlinx.coroutines.sync.a) r4
            kotlin.g0.n(r7)
            goto L4e
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            kotlin.g0.n(r7)
            r0.f49623a = r4
            r0.f49624b = r5
            r0.f49625c = r6
            r0.f49627e = r3
            java.lang.Object r7 = r4.lock(r5, r0)
            if (r7 != r1) goto L4e
            return r1
        L4e:
            java.lang.Object r6 = r6.invoke()     // Catch: java.lang.Throwable -> L5c
            kotlin.jvm.internal.d0.d(r3)
            r4.unlock(r5)
            kotlin.jvm.internal.d0.c(r3)
            return r6
        L5c:
            r6 = move-exception
            kotlin.jvm.internal.d0.d(r3)
            r4.unlock(r5)
            kotlin.jvm.internal.d0.c(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.c.e(kotlinx.coroutines.sync.a, java.lang.Object, kotlin.jvm.functions.Function0, kotlin.coroutines.e):java.lang.Object");
    }
}
