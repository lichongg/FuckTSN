package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k {
    public static final boolean a(@NotNull a version) {
        g0.p(version, "version");
        return (version.a() == 1 && version.b() >= 4) || version.a() > 1;
    }

    public static final boolean b(@NotNull a version) {
        g0.p(version, "version");
        return a(version);
    }
}
