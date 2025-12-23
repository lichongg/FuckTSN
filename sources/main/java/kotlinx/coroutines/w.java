package kotlinx.coroutines;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class w extends f2 implements v {

    /* renamed from: e, reason: collision with root package name */
    @JvmField
    @NotNull
    public final x f49673e;

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.n1 invoke(Throwable th) {
        z(th);
        return kotlin.n1.f44123a;
    }

    @Override // kotlinx.coroutines.f0
    public void z(@Nullable Throwable th) {
        this.f49673e.g(A());
    }

    public w(@NotNull x xVar) {
        this.f49673e = xVar;
    }

    @Override // kotlinx.coroutines.v
    public boolean b(@NotNull Throwable th) {
        return A().n0(th);
    }

    @Override // kotlinx.coroutines.v
    @NotNull
    public e2 getParent() {
        return A();
    }
}
