package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class a implements Comparable<a> {
    @NotNull
    public abstract DeprecationLevelValue b();

    public abstract boolean c();

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull a other) {
        g0.p(other, "other");
        int compareTo = b().compareTo(other.b());
        if (compareTo == 0 && !c() && other.c()) {
            return 1;
        }
        return compareTo;
    }
}
