package kotlin.reflect.jvm.internal.impl.km;

import kotlin.contracts.ExperimentalContracts;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ExperimentalContracts
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final Object f45160a;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && g0.g(this.f45160a, ((i) obj).f45160a);
    }

    public int hashCode() {
        Object obj = this.f45160a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @NotNull
    public String toString() {
        return "KmConstantValue(value=" + this.f45160a + ')';
    }

    public i(@Nullable Object obj) {
        this.f45160a = obj;
    }
}
