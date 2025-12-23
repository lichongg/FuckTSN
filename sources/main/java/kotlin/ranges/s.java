package kotlin.ranges;

import java.lang.Comparable;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.9")
@WasExperimental(markerClass = {ExperimentalStdlibApi.class})
/* loaded from: D:\Downloads\app\classes8.dex */
public interface s<T extends Comparable<? super T>> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public static <T extends Comparable<? super T>> boolean a(@NotNull s<T> sVar, @NotNull T value) {
            g0.p(value, "value");
            return value.compareTo(sVar.getStart()) >= 0 && value.compareTo(sVar.d()) < 0;
        }

        public static <T extends Comparable<? super T>> boolean b(@NotNull s<T> sVar) {
            if (sVar.getStart().compareTo(sVar.d()) >= 0) {
                return true;
            }
            return false;
        }
    }

    boolean contains(@NotNull T t5);

    @NotNull
    T d();

    @NotNull
    T getStart();

    boolean isEmpty();
}
