package kotlinx.coroutines.scheduling;

import kotlin.jvm.JvmField;
import kotlinx.coroutines.u0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m extends j {

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    @NotNull
    public final Runnable f49506c;

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f49506c.run();
        } finally {
            this.f49504b.o();
        }
    }

    @NotNull
    public String toString() {
        return "Task[" + u0.a(this.f49506c) + '@' + u0.b(this.f49506c) + ", " + this.f49503a + ", " + this.f49504b + ']';
    }

    public m(@NotNull Runnable runnable, long j6, @NotNull k kVar) {
        super(j6, kVar);
        this.f49506c = runnable;
    }
}
