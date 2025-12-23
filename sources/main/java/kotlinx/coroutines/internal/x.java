package kotlinx.coroutines.internal;

import kotlin.PublishedApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static final int f49315a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f49316b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f49317c = 2;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Object f49318d = new s0("CONDITION_FALSE");

    @NotNull
    public static final Object a() {
        return f49318d;
    }

    @PublishedApi
    @NotNull
    public static final y f(@NotNull Object obj) {
        y yVar;
        m0 m0Var = obj instanceof m0 ? (m0) obj : null;
        if (m0Var != null && (yVar = m0Var.f49283a) != null) {
            return yVar;
        }
        kotlin.jvm.internal.g0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (y) obj;
    }

    @PublishedApi
    public static /* synthetic */ void b() {
    }

    @PublishedApi
    public static /* synthetic */ void c() {
    }

    @PublishedApi
    public static /* synthetic */ void d() {
    }

    @PublishedApi
    public static /* synthetic */ void e() {
    }
}
