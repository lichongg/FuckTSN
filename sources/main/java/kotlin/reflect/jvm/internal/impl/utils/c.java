package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c {
    public static final boolean a(@NotNull Throwable th) {
        g0.p(th, "<this>");
        Class<?> cls = th.getClass();
        while (!g0.g(cls.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            cls = cls.getSuperclass();
            if (cls == null) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final RuntimeException b(@NotNull Throwable e6) {
        g0.p(e6, "e");
        throw e6;
    }
}
