package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class p2 extends m0 {
    @NotNull
    public abstract p2 t();

    @Override // kotlinx.coroutines.m0
    @NotNull
    public m0 limitedParallelism(int i6) {
        kotlinx.coroutines.internal.t.a(i6);
        return this;
    }

    @Override // kotlinx.coroutines.m0
    @NotNull
    public String toString() {
        String u5 = u();
        if (u5 == null) {
            return u0.a(this) + '@' + u0.b(this);
        }
        return u5;
    }

    @InternalCoroutinesApi
    @Nullable
    protected final String u() {
        p2 p2Var;
        p2 e6 = g1.e();
        if (this == e6) {
            return "Dispatchers.Main";
        }
        try {
            p2Var = e6.t();
        } catch (UnsupportedOperationException unused) {
            p2Var = null;
        }
        if (this != p2Var) {
            return null;
        }
        return "Dispatchers.Main.immediate";
    }
}
