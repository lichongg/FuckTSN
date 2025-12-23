package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h extends o1 {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final Thread f49212g;

    @Override // kotlinx.coroutines.p1
    @NotNull
    protected Thread P() {
        return this.f49212g;
    }

    public h(@NotNull Thread thread) {
        this.f49212g = thread;
    }
}
