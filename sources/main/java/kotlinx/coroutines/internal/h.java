package kotlinx.coroutines.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h implements kotlinx.coroutines.r0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.coroutines.i f49266a;

    @Override // kotlinx.coroutines.r0
    @NotNull
    public kotlin.coroutines.i getCoroutineContext() {
        return this.f49266a;
    }

    @NotNull
    public String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + ')';
    }

    public h(@NotNull kotlin.coroutines.i iVar) {
        this.f49266a = iVar;
    }
}
