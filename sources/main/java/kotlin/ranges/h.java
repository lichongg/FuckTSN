package kotlin.ranges;

import java.lang.Comparable;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface h<T extends Comparable<? super T>> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public static <T extends Comparable<? super T>> boolean a(@NotNull h<T> hVar, @NotNull T value) {
            g0.p(value, "value");
            return value.compareTo(hVar.getStart()) >= 0 && value.compareTo(hVar.getEndInclusive()) <= 0;
        }

        public static <T extends Comparable<? super T>> boolean b(@NotNull h<T> hVar) {
            if (hVar.getStart().compareTo(hVar.getEndInclusive()) > 0) {
                return true;
            }
            return false;
        }
    }

    boolean contains(@NotNull T t5);

    @NotNull
    T getEndInclusive();

    @NotNull
    T getStart();

    boolean isEmpty();
}
