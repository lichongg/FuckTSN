package kotlin.comparisons;

import java.util.Comparator;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class j implements Comparator<Comparable<? super Object>> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f43754a = new j();

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(@NotNull Comparable<Object> a6, @NotNull Comparable<Object> b6) {
        g0.p(a6, "a");
        g0.p(b6, "b");
        return a6.compareTo(b6);
    }

    @Override // java.util.Comparator
    @NotNull
    public final Comparator<Comparable<? super Object>> reversed() {
        return k.f43755a;
    }

    private j() {
    }
}
