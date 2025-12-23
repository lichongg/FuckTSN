package kotlin.coroutines.jvm.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b implements kotlin.coroutines.e<Object> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f43769a = new b();

    @Override // kotlin.coroutines.e
    @NotNull
    public kotlin.coroutines.i getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override // kotlin.coroutines.e
    public void resumeWith(@NotNull Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    @NotNull
    public String toString() {
        return "This continuation is already complete";
    }

    private b() {
    }
}
