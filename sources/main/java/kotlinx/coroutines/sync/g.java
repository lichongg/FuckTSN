package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.i;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.p0;
import kotlinx.coroutines.internal.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSemaphore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreSegment\n*L\n1#1,397:1\n371#1,2:398\n*S KotlinDebug\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreSegment\n*L\n384#1:398,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class g extends p0<g> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final AtomicReferenceArray f49648e;

    @NotNull
    public String toString() {
        return "SemaphoreSegment[id=" + this.f49297c + ", hashCode=" + hashCode() + ']';
    }

    @NotNull
    public final AtomicReferenceArray v() {
        return this.f49648e;
    }

    public g(long j6, @Nullable g gVar, int i6) {
        super(j6, gVar, i6);
        int i7;
        i7 = f.f49643f;
        this.f49648e = new AtomicReferenceArray(i7);
    }

    @Override // kotlinx.coroutines.internal.p0
    public int p() {
        int i6;
        i6 = f.f49643f;
        return i6;
    }

    @Override // kotlinx.coroutines.internal.p0
    public void q(int i6, @Nullable Throwable th, @NotNull i iVar) {
        s0 s0Var;
        s0Var = f.f49642e;
        v().set(i6, s0Var);
        r();
    }

    public final boolean t(int i6, @Nullable Object obj, @Nullable Object obj2) {
        return com.google.common.util.concurrent.b.a(v(), i6, obj, obj2);
    }

    @Nullable
    public final Object u(int i6) {
        return v().get(i6);
    }

    @Nullable
    public final Object w(int i6, @Nullable Object obj) {
        return v().getAndSet(i6, obj);
    }

    public final void x(int i6, @Nullable Object obj) {
        v().set(i6, obj);
    }
}
