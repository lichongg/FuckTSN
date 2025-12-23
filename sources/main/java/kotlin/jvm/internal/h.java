package kotlin.jvm.internal;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h {
    @NotNull
    public static final <T> Iterator<T> a(@NotNull T[] array) {
        g0.p(array, "array");
        return new g(array);
    }
}
