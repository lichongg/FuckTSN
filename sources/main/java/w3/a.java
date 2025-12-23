package w3;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a extends b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f54737a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f54738b;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return g0.g(this.f54737a, aVar.f54737a) && g0.g(this.f54738b, aVar.f54738b);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull String name, @NotNull String descriptor) {
        super(null);
        g0.p(name, "name");
        g0.p(descriptor, "descriptor");
        this.f54737a = name;
        this.f54738b = descriptor;
    }

    @Override // w3.b
    @NotNull
    public String a() {
        return this.f54738b;
    }

    @Override // w3.b
    @NotNull
    public String b() {
        return this.f54737a;
    }

    public int hashCode() {
        return (this.f54737a.hashCode() * 31) + this.f54738b.hashCode();
    }

    @Override // w3.b
    @NotNull
    public String toString() {
        return b() + ':' + a();
    }
}
