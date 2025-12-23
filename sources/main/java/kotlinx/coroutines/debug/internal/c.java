package kotlinx.coroutines.debug.internal;

import kotlin.jvm.internal.g0;
import kotlinx.coroutines.internal.s0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int f48520a = -1640531527;

    /* renamed from: b, reason: collision with root package name */
    private static final int f48521b = 16;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final s0 f48522c = new s0("REHASH");

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final j f48523d = new j(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final j f48524e = new j(Boolean.TRUE);

    /* JADX INFO: Access modifiers changed from: private */
    public static final j d(Object obj) {
        return obj == null ? f48523d : g0.g(obj, Boolean.TRUE) ? f48524e : new j(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void e() {
        throw new UnsupportedOperationException("not implemented");
    }
}
