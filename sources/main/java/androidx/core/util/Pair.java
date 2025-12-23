package androidx.core.util;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class Pair<F, S> {
    public final F first;
    public final S second;

    @NonNull
    public static <A, B> Pair<A, B> create(A a6, B b6) {
        return new Pair<>(a6, b6);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return ObjectsCompat.equals(pair.first, this.first) && ObjectsCompat.equals(pair.second, this.second);
    }

    public int hashCode() {
        F f6 = this.first;
        int hashCode = f6 == null ? 0 : f6.hashCode();
        S s5 = this.second;
        return hashCode ^ (s5 != null ? s5.hashCode() : 0);
    }

    @NonNull
    public String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }

    public Pair(F f6, S s5) {
        this.first = f6;
        this.second = s5;
    }
}
