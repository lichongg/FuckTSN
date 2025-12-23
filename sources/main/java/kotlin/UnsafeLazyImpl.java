package kotlin;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class UnsafeLazyImpl<T> implements s<T>, Serializable {

    @Nullable
    private Object _value;

    @Nullable
    private Function0<? extends T> initializer;

    public UnsafeLazyImpl(@NotNull Function0<? extends T> initializer) {
        kotlin.jvm.internal.g0.p(initializer, "initializer");
        this.initializer = initializer;
        this._value = h1.f43799a;
    }

    private final void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.s
    public T getValue() {
        if (this._value == h1.f43799a) {
            Function0<? extends T> function0 = this.initializer;
            kotlin.jvm.internal.g0.m(function0);
            this._value = function0.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    @Override // kotlin.s
    public boolean isInitialized() {
        return this._value != h1.f43799a;
    }

    @NotNull
    public String toString() {
        if (isInitialized()) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }
}
