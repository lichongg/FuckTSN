package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class m0<T> implements s<T>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private Function0<? extends T> f44111a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private volatile Object f44112b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Object f44113c;

    public m0(@NotNull Function0<? extends T> initializer, @Nullable Object obj) {
        kotlin.jvm.internal.g0.p(initializer, "initializer");
        this.f44111a = initializer;
        this.f44112b = h1.f43799a;
        this.f44113c = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.s
    public T getValue() {
        T t5;
        T t6 = (T) this.f44112b;
        h1 h1Var = h1.f43799a;
        if (t6 != h1Var) {
            return t6;
        }
        synchronized (this.f44113c) {
            t5 = (T) this.f44112b;
            if (t5 == h1Var) {
                Function0<? extends T> function0 = this.f44111a;
                kotlin.jvm.internal.g0.m(function0);
                t5 = function0.invoke();
                this.f44112b = t5;
                this.f44111a = null;
            }
        }
        return t5;
    }

    @Override // kotlin.s
    public boolean isInitialized() {
        return this.f44112b != h1.f43799a;
    }

    @NotNull
    public String toString() {
        if (isInitialized()) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }

    public /* synthetic */ m0(Function0 function0, Object obj, int i6, kotlin.jvm.internal.v vVar) {
        this(function0, (i6 & 2) != 0 ? null : obj);
    }
}
