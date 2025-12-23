package kotlinx.coroutines.debug.internal;

import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@PublishedApi
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k implements kotlin.coroutines.jvm.internal.c {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final kotlin.coroutines.jvm.internal.c f48552a;

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public final StackTraceElement f48553b;

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public kotlin.coroutines.jvm.internal.c getCallerFrame() {
        return this.f48552a;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @NotNull
    public StackTraceElement getStackTraceElement() {
        return this.f48553b;
    }

    public k(@Nullable kotlin.coroutines.jvm.internal.c cVar, @NotNull StackTraceElement stackTraceElement) {
        this.f48552a = cVar;
        this.f48553b = stackTraceElement;
    }
}
