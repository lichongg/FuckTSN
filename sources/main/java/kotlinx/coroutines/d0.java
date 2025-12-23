package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class d0 {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f48475b = AtomicIntegerFieldUpdater.newUpdater(d0.class, "_handled");

    @Volatile
    private volatile int _handled;

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @NotNull
    public final Throwable f48476a;

    public d0(@NotNull Throwable th, boolean z5) {
        this.f48476a = th;
        this._handled = z5 ? 1 : 0;
    }

    public final boolean a() {
        return f48475b.get(this) != 0;
    }

    public final boolean b() {
        return f48475b.compareAndSet(this, 0, 1);
    }

    @NotNull
    public String toString() {
        return u0.a(this) + '[' + this.f48476a + ']';
    }

    public /* synthetic */ d0(Throwable th, boolean z5, int i6, kotlin.jvm.internal.v vVar) {
        this(th, (i6 & 2) != 0 ? false : z5);
    }
}
