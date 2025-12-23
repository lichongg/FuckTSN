package kotlin;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class InitializedLazyImpl<T> implements s<T>, Serializable {
    private final T value;

    @Override // kotlin.s
    public boolean isInitialized() {
        return true;
    }

    @Override // kotlin.s
    public T getValue() {
        return this.value;
    }

    public InitializedLazyImpl(T t5) {
        this.value = t5;
    }

    @NotNull
    public String toString() {
        return String.valueOf(getValue());
    }
}
