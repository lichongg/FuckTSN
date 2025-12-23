package kotlin.collections;

import java.util.Iterator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class k0 extends j0 {
    public static final <T> void i0(@NotNull Iterator<? extends T> it, @NotNull Function1<? super T, kotlin.n1> operation) {
        kotlin.jvm.internal.g0.p(it, "<this>");
        kotlin.jvm.internal.g0.p(operation, "operation");
        while (it.hasNext()) {
            operation.invoke(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> Iterator<T> j0(Iterator<? extends T> it) {
        kotlin.jvm.internal.g0.p(it, "<this>");
        return it;
    }

    @NotNull
    public static final <T> Iterator<a1<T>> k0(@NotNull Iterator<? extends T> it) {
        kotlin.jvm.internal.g0.p(it, "<this>");
        return new c1(it);
    }
}
