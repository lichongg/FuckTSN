package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o3 extends m0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o3 f49416a = new o3();

    @Override // kotlinx.coroutines.m0
    public boolean isDispatchNeeded(@NotNull kotlin.coroutines.i iVar) {
        return false;
    }

    @Override // kotlinx.coroutines.m0
    public void dispatch(@NotNull kotlin.coroutines.i iVar, @NotNull Runnable runnable) {
        s3 s3Var = (s3) iVar.get(s3.f49446b);
        if (s3Var == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        s3Var.f49447a = true;
    }

    @Override // kotlinx.coroutines.m0
    @ExperimentalCoroutinesApi
    @NotNull
    public m0 limitedParallelism(int i6) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override // kotlinx.coroutines.m0
    @NotNull
    public String toString() {
        return "Dispatchers.Unconfined";
    }

    private o3() {
    }
}
