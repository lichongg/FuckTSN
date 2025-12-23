package kotlinx.coroutines.flow.internal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class v<T> implements kotlin.coroutines.e<T>, kotlin.coroutines.jvm.internal.c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.coroutines.e<T> f49035a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.coroutines.i f49036b;

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public kotlin.coroutines.jvm.internal.c getCallerFrame() {
        kotlin.coroutines.e<T> eVar = this.f49035a;
        if (eVar instanceof kotlin.coroutines.jvm.internal.c) {
            return (kotlin.coroutines.jvm.internal.c) eVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.e
    @NotNull
    public kotlin.coroutines.i getContext() {
        return this.f49036b;
    }

    @Override // kotlin.coroutines.e
    public void resumeWith(@NotNull Object obj) {
        this.f49035a.resumeWith(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v(@NotNull kotlin.coroutines.e<? super T> eVar, @NotNull kotlin.coroutines.i iVar) {
        this.f49035a = eVar;
        this.f49036b = iVar;
    }
}
