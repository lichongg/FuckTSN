package kotlinx.coroutines;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private static final int f49428a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static final int f49429b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f49430c = 2;

    /* renamed from: d, reason: collision with root package name */
    private static final int f49431d = 29;

    /* renamed from: e, reason: collision with root package name */
    private static final int f49432e = 536870911;

    /* renamed from: f, reason: collision with root package name */
    private static final int f49433f = 536870911;

    /* renamed from: g, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlinx.coroutines.internal.s0 f49434g = new kotlinx.coroutines.internal.s0("RESUME_TOKEN");

    private static final int a(int i6, int i7) {
        return (i6 << 29) + i7;
    }

    private static final int b(int i6) {
        return i6 >> 29;
    }

    private static final int c(int i6) {
        return i6 & 536870911;
    }
}
