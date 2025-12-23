package androidx.room.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCloseBarrier.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CloseBarrier.kt\nandroidx/room/concurrent/CloseBarrier\n+ 2 Synchronized.jvmAndroid.kt\nandroidx/room/concurrent/Synchronized_jvmAndroidKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Atomics.kt\nandroidx/room/concurrent/AtomicsKt\n*L\n1#1,106:1\n22#2:107\n22#2:108\n22#2:110\n1#3:109\n40#4,2:111\n*S KotlinDebug\n*F\n+ 1 CloseBarrier.kt\nandroidx/room/concurrent/CloseBarrier\n*L\n53#1:107\n69#1:108\n83#1:110\n89#1:111,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class CloseBarrier {

    @NotNull
    private final AtomicInteger blockers;

    @NotNull
    private final Function0<n1> closeAction;

    @NotNull
    private final AtomicBoolean closeInitiated;

    public final boolean block$room_runtime_release() {
        synchronized (this) {
            if (isClosed()) {
                return false;
            }
            this.blockers.incrementAndGet();
            return true;
        }
    }

    public final void close$room_runtime_release() {
        synchronized (this) {
            if (this.closeInitiated.compareAndSet(false, true)) {
                n1 n1Var = n1.f44123a;
                while (this.blockers.get() != 0) {
                }
                this.closeAction.invoke();
            }
        }
    }

    public final void unblock$room_runtime_release() {
        synchronized (this) {
            this.blockers.decrementAndGet();
            if (this.blockers.get() < 0) {
                throw new IllegalStateException("Unbalanced call to unblock() detected.");
            }
            n1 n1Var = n1.f44123a;
        }
    }

    public CloseBarrier(@NotNull Function0<n1> closeAction) {
        g0.p(closeAction, "closeAction");
        this.closeAction = closeAction;
        this.blockers = new AtomicInteger(0);
        this.closeInitiated = new AtomicBoolean(false);
    }

    private final boolean isClosed() {
        return this.closeInitiated.get();
    }
}
