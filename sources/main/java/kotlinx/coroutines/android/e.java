package kotlinx.coroutines.android;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.coroutines.i;
import kotlin.jvm.internal.v;
import kotlin.n1;
import kotlinx.coroutines.j1;
import kotlinx.coroutines.p2;
import kotlinx.coroutines.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class e extends p2 implements z0 {
    public /* synthetic */ e(v vVar) {
        this();
    }

    @NotNull
    public abstract e v();

    private e() {
    }

    @NotNull
    public j1 m(long j6, @NotNull Runnable runnable, @NotNull i iVar) {
        return z0.a.b(this, j6, runnable, iVar);
    }

    @Override // kotlinx.coroutines.z0
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @Nullable
    public Object r(long j6, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return z0.a.a(this, j6, eVar);
    }
}
