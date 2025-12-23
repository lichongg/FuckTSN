package kotlin.collections;

import com.daimajia.numberprogressbar.BuildConfig;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.BuilderInference;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class w1 extends v1 {
    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final <E> Set<E> i(int i6, @BuilderInference Function1<? super Set<E>, kotlin.n1> builderAction) {
        kotlin.jvm.internal.g0.p(builderAction, "builderAction");
        Set e6 = v1.e(i6);
        builderAction.invoke(e6);
        return v1.a(e6);
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final <E> Set<E> j(@BuilderInference Function1<? super Set<E>, kotlin.n1> builderAction) {
        kotlin.jvm.internal.g0.p(builderAction, "builderAction");
        Set d6 = v1.d();
        builderAction.invoke(d6);
        return v1.a(d6);
    }

    @NotNull
    public static <T> Set<T> k() {
        return EmptySet.INSTANCE;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> HashSet<T> l() {
        return new HashSet<>();
    }

    @NotNull
    public static final <T> HashSet<T> m(@NotNull T... elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        return (HashSet) a0.Iy(elements, new HashSet(k1.j(elements.length)));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> LinkedHashSet<T> n() {
        return new LinkedHashSet<>();
    }

    @NotNull
    public static <T> LinkedHashSet<T> o(@NotNull T... elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        return (LinkedHashSet) a0.Iy(elements, new LinkedHashSet(k1.j(elements.length)));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> Set<T> p() {
        return new LinkedHashSet();
    }

    @NotNull
    public static <T> Set<T> q(@NotNull T... elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        return (Set) a0.Iy(elements, new LinkedHashSet(k1.j(elements.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Set<T> r(@NotNull Set<? extends T> set) {
        kotlin.jvm.internal.g0.p(set, "<this>");
        int size = set.size();
        return size != 0 ? size != 1 ? set : v1.f(set.iterator().next()) : k();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> Set<T> s(Set<? extends T> set) {
        return set == 0 ? k() : set;
    }

    @NotNull
    public static <T> Set<T> u(@NotNull T... elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        return a0.Fz(elements);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <T> Set<T> v(@Nullable T t5) {
        return t5 != null ? v1.f(t5) : k();
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <T> Set<T> w(@NotNull T... elements) {
        kotlin.jvm.internal.g0.p(elements, "elements");
        return (Set) a0.mb(elements, new LinkedHashSet());
    }

    @InlineOnly
    private static final <T> Set<T> t() {
        return k();
    }
}
