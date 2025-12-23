package kotlin.reflect.jvm.internal.impl.km;

import java.util.Map;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.collections.i1;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f45115a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Map<String, e> f45116b;

    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull String className, @NotNull Map<String, ? extends e> arguments) {
        g0.p(className, "className");
        g0.p(arguments, "arguments");
        this.f45115a = className;
        this.f45116b = arguments;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence d(Pair pair) {
        g0.p(pair, "<destruct>");
        return ((String) pair.component1()) + " = " + ((e) pair.component2());
    }

    @NotNull
    public final Map<String, e> b() {
        return this.f45116b;
    }

    @NotNull
    public final String c() {
        return this.f45115a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return g0.g(this.f45115a, dVar.f45115a) && g0.g(this.f45116b, dVar.f45116b);
    }

    public int hashCode() {
        return (this.f45115a.hashCode() * 31) + this.f45116b.hashCode();
    }

    @NotNull
    public String toString() {
        return '@' + this.f45115a + '(' + f0.r3(i1.J1(this.f45116b), null, null, null, 0, null, c.f45114a, 31, null) + ')';
    }
}
