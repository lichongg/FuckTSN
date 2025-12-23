package kotlinx.coroutines;

import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nExecutors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Executors.kt\nkotlinx/coroutines/ResumeUndispatchedRunnable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,207:1\n1#2:208\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class x2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final m0 f49679a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final p<kotlin.n1> f49680b;

    @Override // java.lang.Runnable
    public void run() {
        this.f49680b.P(this.f49679a, kotlin.n1.f44123a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x2(@NotNull m0 m0Var, @NotNull p<? super kotlin.n1> pVar) {
        this.f49679a = m0Var;
        this.f49680b = pVar;
    }
}
