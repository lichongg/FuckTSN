package okhttp3.internal;

import androidx.camera.view.p;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class TagsKt {
    @NotNull
    public static final <T> T computeIfAbsent(@NotNull AtomicReference<Tags> atomicReference, @NotNull kotlin.reflect.d<T> type, @NotNull Function0<? extends T> compute) {
        Tags tags;
        g0.p(atomicReference, "<this>");
        g0.p(type, "type");
        g0.p(compute, "compute");
        T t5 = null;
        do {
            tags = atomicReference.get();
            T t6 = (T) tags.get(type);
            if (t6 != null) {
                return t6;
            }
            if (t5 == null) {
                t5 = compute.invoke();
            }
        } while (!p.a(atomicReference, tags, tags.plus(type, t5)));
        return t5;
    }
}
