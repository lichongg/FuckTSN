package kotlinx.coroutines.internal;

import androidx.core.internal.view.SupportMenu;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.p0;
import kotlinx.coroutines.t2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/Segment\n+ 2 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n*L\n1#1,269:1\n252#2,4:270\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/Segment\n*L\n225#1:270,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class p0<S extends p0<S>> extends g<S> implements t2 {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f49296d = AtomicIntegerFieldUpdater.newUpdater(p0.class, "cleanedAndPointers");

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    public final long f49297c;

    @Volatile
    private volatile int cleanedAndPointers;

    public abstract int p();

    public abstract void q(int i6, @Nullable Throwable th, @NotNull kotlin.coroutines.i iVar);

    @Override // kotlinx.coroutines.internal.g
    public boolean h() {
        return f49296d.get(this) == p() && !i();
    }

    public final boolean o() {
        return f49296d.addAndGet(this, SupportMenu.CATEGORY_MASK) == p() && !i();
    }

    public final void r() {
        if (f49296d.incrementAndGet(this) == p()) {
            l();
        }
    }

    public final boolean s() {
        int i6;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f49296d;
        do {
            i6 = atomicIntegerFieldUpdater.get(this);
            if (i6 == p() && !i()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i6, 65536 + i6));
        return true;
    }

    public p0(long j6, @Nullable S s5, int i6) {
        super(s5);
        this.f49297c = j6;
        this.cleanedAndPointers = i6 << 16;
    }
}
