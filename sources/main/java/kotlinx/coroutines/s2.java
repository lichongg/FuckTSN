package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@InternalCoroutinesApi
/* loaded from: D:\Downloads\app\classes8.dex */
public final class s2 implements j1, v {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final s2 f49445a = new s2();

    @Override // kotlinx.coroutines.v
    public boolean b(@NotNull Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.v
    @Nullable
    public e2 getParent() {
        return null;
    }

    @NotNull
    public String toString() {
        return "NonDisposableHandle";
    }

    private s2() {
    }

    @Override // kotlinx.coroutines.j1
    public void dispose() {
    }
}
