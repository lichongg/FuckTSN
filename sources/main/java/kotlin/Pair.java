package kotlin;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Pair<A, B> implements Serializable {
    private final A first;
    private final B second;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return kotlin.jvm.internal.g0.g(this.first, pair.first) && kotlin.jvm.internal.g0.g(this.second, pair.second);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Pair copy$default(Pair pair, Object obj, Object obj2, int i6, Object obj3) {
        if ((i6 & 1) != 0) {
            obj = pair.first;
        }
        if ((i6 & 2) != 0) {
            obj2 = pair.second;
        }
        return pair.copy(obj, obj2);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    @NotNull
    public final Pair<A, B> copy(A a6, B b6) {
        return new Pair<>(a6, b6);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public int hashCode() {
        A a6 = this.first;
        int hashCode = (a6 == null ? 0 : a6.hashCode()) * 31;
        B b6 = this.second;
        return hashCode + (b6 != null ? b6.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }

    public Pair(A a6, B b6) {
        this.first = a6;
        this.second = b6;
    }
}
