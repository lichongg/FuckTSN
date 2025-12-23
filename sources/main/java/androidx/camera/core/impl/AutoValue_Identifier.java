package androidx.camera.core.impl;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_Identifier extends Identifier {
    private final Object value;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Identifier) {
            return this.value.equals(((Identifier) obj).getValue());
        }
        return false;
    }

    @Override // androidx.camera.core.impl.Identifier
    @NonNull
    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Identifier{value=" + this.value + "}";
    }

    AutoValue_Identifier(Object obj) {
        if (obj != null) {
            this.value = obj;
            return;
        }
        throw new NullPointerException("Null value");
    }
}
