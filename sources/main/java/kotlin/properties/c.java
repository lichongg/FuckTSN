package kotlin.properties;

import kotlin.jvm.internal.g0;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class c<V> implements f<Object, V> {

    /* renamed from: a, reason: collision with root package name */
    private V f44137a;

    @Override // kotlin.properties.f, kotlin.properties.e
    public V a(@Nullable Object obj, @NotNull n<?> property) {
        g0.p(property, "property");
        return this.f44137a;
    }

    @Override // kotlin.properties.f
    public void b(@Nullable Object obj, @NotNull n<?> property, V v5) {
        g0.p(property, "property");
        V v6 = this.f44137a;
        if (d(property, v6, v5)) {
            this.f44137a = v5;
            c(property, v6, v5);
        }
    }

    protected void c(@NotNull n<?> property, V v5, V v6) {
        g0.p(property, "property");
    }

    protected boolean d(@NotNull n<?> property, V v5, V v6) {
        g0.p(property, "property");
        return true;
    }

    @NotNull
    public String toString() {
        return "ObservableProperty(value=" + this.f44137a + ')';
    }

    public c(V v5) {
        this.f44137a = v5;
    }
}
