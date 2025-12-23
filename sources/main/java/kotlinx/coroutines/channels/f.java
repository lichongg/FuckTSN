package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.internal.s0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final s0 f48188a = new s0("NO_ELEMENT");

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and StateFlow, and is no longer supported")
    @ObsoleteCoroutinesApi
    @NotNull
    public static final <E> d<E> a(int i6) {
        if (i6 == -2) {
            return new e(j.f48222t0.a());
        }
        if (i6 == -1) {
            return new t();
        }
        if (i6 == 0) {
            throw new IllegalArgumentException("Unsupported 0 capacity for BroadcastChannel");
        }
        if (i6 != Integer.MAX_VALUE) {
            return new e(i6);
        }
        throw new IllegalArgumentException("Unsupported UNLIMITED capacity for BroadcastChannel");
    }
}
