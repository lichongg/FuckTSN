package kotlin;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class h0<T> implements s<T>, Serializable {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f43794d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater<h0<?>, Object> f43795e = AtomicReferenceFieldUpdater.newUpdater(h0.class, Object.class, "b");

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private volatile Function0<? extends T> f43796a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private volatile Object f43797b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Object f43798c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    public h0(@NotNull Function0<? extends T> initializer) {
        kotlin.jvm.internal.g0.p(initializer, "initializer");
        this.f43796a = initializer;
        h1 h1Var = h1.f43799a;
        this.f43797b = h1Var;
        this.f43798c = h1Var;
    }

    private final void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.s
    public T getValue() {
        T t5 = (T) this.f43797b;
        h1 h1Var = h1.f43799a;
        if (t5 != h1Var) {
            return t5;
        }
        Function0<? extends T> function0 = this.f43796a;
        if (function0 != null) {
            T invoke = function0.invoke();
            if (androidx.concurrent.futures.a.a(f43795e, this, h1Var, invoke)) {
                this.f43796a = null;
                return invoke;
            }
        }
        return (T) this.f43797b;
    }

    @Override // kotlin.s
    public boolean isInitialized() {
        return this.f43797b != h1.f43799a;
    }

    @NotNull
    public String toString() {
        if (isInitialized()) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }

    private static /* synthetic */ void a() {
    }
}
