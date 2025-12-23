package kotlin.reflect.jvm.internal.impl.types;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class d2 implements c2 {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c2)) {
            return false;
        }
        c2 c2Var = (c2) obj;
        return b() == c2Var.b() && c() == c2Var.c() && getType().equals(c2Var.getType());
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = c().hashCode();
        if (j2.w(getType())) {
            return (hashCode2 * 31) + 19;
        }
        int i6 = hashCode2 * 31;
        if (b()) {
            hashCode = 17;
        } else {
            hashCode = getType().hashCode();
        }
        return i6 + hashCode;
    }

    public String toString() {
        if (b()) {
            return "*";
        }
        if (c() == Variance.INVARIANT) {
            return getType().toString();
        }
        return c() + " " + getType();
    }
}
