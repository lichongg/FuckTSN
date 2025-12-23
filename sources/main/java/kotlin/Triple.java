package kotlin;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Triple<A, B, C> implements Serializable {
    private final A first;
    private final B second;
    private final C third;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        return kotlin.jvm.internal.g0.g(this.first, triple.first) && kotlin.jvm.internal.g0.g(this.second, triple.second) && kotlin.jvm.internal.g0.g(this.third, triple.third);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Triple copy$default(Triple triple, Object obj, Object obj2, Object obj3, int i6, Object obj4) {
        if ((i6 & 1) != 0) {
            obj = triple.first;
        }
        if ((i6 & 2) != 0) {
            obj2 = triple.second;
        }
        if ((i6 & 4) != 0) {
            obj3 = triple.third;
        }
        return triple.copy(obj, obj2, obj3);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
        return this.third;
    }

    @NotNull
    public final Triple<A, B, C> copy(A a6, B b6, C c6) {
        return new Triple<>(a6, b6, c6);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public final C getThird() {
        return this.third;
    }

    public int hashCode() {
        A a6 = this.first;
        int hashCode = (a6 == null ? 0 : a6.hashCode()) * 31;
        B b6 = this.second;
        int hashCode2 = (hashCode + (b6 == null ? 0 : b6.hashCode())) * 31;
        C c6 = this.third;
        return hashCode2 + (c6 != null ? c6.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return '(' + this.first + ", " + this.second + ", " + this.third + ')';
    }

    public Triple(A a6, B b6, C c6) {
        this.first = a6;
        this.second = b6;
        this.third = c6;
    }
}
