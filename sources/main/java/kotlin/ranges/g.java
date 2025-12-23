package kotlin.ranges;

import java.lang.Comparable;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.1")
/* loaded from: D:\Downloads\app\classes8.dex */
public interface g<T extends Comparable<? super T>> extends h<T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public static <T extends Comparable<? super T>> boolean a(@NotNull g<T> gVar, @NotNull T value) {
            g0.p(value, "value");
            return gVar.a(gVar.getStart(), value) && gVar.a(value, gVar.getEndInclusive());
        }

        public static <T extends Comparable<? super T>> boolean b(@NotNull g<T> gVar) {
            return !gVar.a(gVar.getStart(), gVar.getEndInclusive());
        }
    }

    boolean a(@NotNull T t5, @NotNull T t6);

    @Override // kotlin.ranges.h
    boolean contains(@NotNull T t5);

    @Override // kotlin.ranges.h
    boolean isEmpty();
}
