package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class k2 extends f0 implements j1, y1 {

    /* renamed from: d, reason: collision with root package name */
    public l2 f49343d;

    @Override // kotlinx.coroutines.y1
    @Nullable
    public q2 a() {
        return null;
    }

    @Override // kotlinx.coroutines.y1
    public boolean isActive() {
        return true;
    }

    @NotNull
    public final l2 A() {
        l2 l2Var = this.f49343d;
        if (l2Var != null) {
            return l2Var;
        }
        kotlin.jvm.internal.g0.S("job");
        return null;
    }

    public final void B(@NotNull l2 l2Var) {
        this.f49343d = l2Var;
    }

    @Override // kotlinx.coroutines.internal.y
    @NotNull
    public String toString() {
        return u0.a(this) + '@' + u0.b(this) + "[job@" + u0.b(A()) + ']';
    }

    @Override // kotlinx.coroutines.j1
    public void dispose() {
        A().j1(this);
    }
}
