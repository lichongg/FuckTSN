package kotlinx.coroutines.stream;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.flow.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class b<T> implements i<T> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f49590b = AtomicIntegerFieldUpdater.newUpdater(b.class, "consumed");

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Stream<T> f49591a;

    @Volatile
    private volatile int consumed = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.stream.StreamFlow", f = "Stream.kt", i = {0, 0}, l = {26}, m = "collect", n = {"this", "collector"}, s = {"L$0", "L$1"})
    static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f49592a;

        /* renamed from: b, reason: collision with root package name */
        Object f49593b;

        /* renamed from: c, reason: collision with root package name */
        Object f49594c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f49595d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b<T> f49596e;

        /* renamed from: f, reason: collision with root package name */
        int f49597f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(b<T> bVar, e<? super a> eVar) {
            super(eVar);
            this.f49596e = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f49595d = obj;
            this.f49597f |= Integer.MIN_VALUE;
            return this.f49596e.collect(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005c A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #0 {all -> 0x0036, blocks: (B:11:0x0031, B:14:0x0056, B:16:0x005c), top: B:10:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.i
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.j<? super T> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.stream.b.a
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.stream.b$a r0 = (kotlinx.coroutines.stream.b.a) r0
            int r1 = r0.f49597f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49597f = r1
            goto L18
        L13:
            kotlinx.coroutines.stream.b$a r0 = new kotlinx.coroutines.stream.b$a
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f49595d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f49597f
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r6 = r0.f49594c
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r2 = r0.f49593b
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) r2
            java.lang.Object r4 = r0.f49592a
            kotlinx.coroutines.stream.b r4 = (kotlinx.coroutines.stream.b) r4
            kotlin.g0.n(r7)     // Catch: java.lang.Throwable -> L36
            r7 = r2
            goto L56
        L36:
            r6 = move-exception
            goto L79
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            kotlin.g0.n(r7)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r7 = kotlinx.coroutines.stream.b.f49590b
            r2 = 0
            boolean r7 = r7.compareAndSet(r5, r2, r3)
            if (r7 == 0) goto L7f
            java.util.stream.Stream<T> r7 = r5.f49591a     // Catch: java.lang.Throwable -> L77
            java.util.Iterator r7 = kotlin.streams.jdk8.i.a(r7)     // Catch: java.lang.Throwable -> L77
            r4 = r7
            r7 = r6
            r6 = r4
            r4 = r5
        L56:
            boolean r2 = r6.hasNext()     // Catch: java.lang.Throwable -> L36
            if (r2 == 0) goto L6f
            java.lang.Object r2 = r6.next()     // Catch: java.lang.Throwable -> L36
            r0.f49592a = r4     // Catch: java.lang.Throwable -> L36
            r0.f49593b = r7     // Catch: java.lang.Throwable -> L36
            r0.f49594c = r6     // Catch: java.lang.Throwable -> L36
            r0.f49597f = r3     // Catch: java.lang.Throwable -> L36
            java.lang.Object r2 = r7.emit(r2, r0)     // Catch: java.lang.Throwable -> L36
            if (r2 != r1) goto L56
            return r1
        L6f:
            java.util.stream.Stream<T> r6 = r4.f49591a
            kotlinx.coroutines.stream.a.a(r6)
            kotlin.n1 r6 = kotlin.n1.f44123a
            return r6
        L77:
            r6 = move-exception
            r4 = r5
        L79:
            java.util.stream.Stream<T> r7 = r4.f49591a
            kotlinx.coroutines.stream.a.a(r7)
            throw r6
        L7f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Stream.consumeAsFlow can be collected only once"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.stream.b.collect(kotlinx.coroutines.flow.j, kotlin.coroutines.e):java.lang.Object");
    }

    public b(@NotNull Stream<T> stream) {
        this.f49591a = stream;
    }
}
