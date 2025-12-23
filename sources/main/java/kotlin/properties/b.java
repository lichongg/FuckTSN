package kotlin.properties;

import kotlin.jvm.internal.g0;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class b<T> implements f<Object, T> {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private T f44136a;

    @Override // kotlin.properties.f, kotlin.properties.e
    @NotNull
    public T a(@Nullable Object obj, @NotNull n<?> property) {
        g0.p(property, "property");
        T t5 = this.f44136a;
        if (t5 != null) {
            return t5;
        }
        throw new IllegalStateException("Property " + property.getName() + " should be initialized before get.");
    }

    @Override // kotlin.properties.f
    public void b(@Nullable Object obj, @NotNull n<?> property, @NotNull T value) {
        g0.p(property, "property");
        g0.p(value, "value");
        this.f44136a = value;
    }

    @NotNull
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("NotNullProperty(");
        if (this.f44136a != null) {
            str = "value=" + this.f44136a;
        } else {
            str = "value not initialized yet";
        }
        sb.append(str);
        sb.append(')');
        return sb.toString();
    }
}
