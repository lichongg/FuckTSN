package kotlin.text;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f47933a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.ranges.m f47934b;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return kotlin.jvm.internal.g0.g(this.f47933a, mVar.f47933a) && kotlin.jvm.internal.g0.g(this.f47934b, mVar.f47934b);
    }

    public m(@NotNull String value, @NotNull kotlin.ranges.m range) {
        kotlin.jvm.internal.g0.p(value, "value");
        kotlin.jvm.internal.g0.p(range, "range");
        this.f47933a = value;
        this.f47934b = range;
    }

    public static /* synthetic */ m d(m mVar, String str, kotlin.ranges.m mVar2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = mVar.f47933a;
        }
        if ((i6 & 2) != 0) {
            mVar2 = mVar.f47934b;
        }
        return mVar.c(str, mVar2);
    }

    @NotNull
    public final String a() {
        return this.f47933a;
    }

    @NotNull
    public final kotlin.ranges.m b() {
        return this.f47934b;
    }

    @NotNull
    public final m c(@NotNull String value, @NotNull kotlin.ranges.m range) {
        kotlin.jvm.internal.g0.p(value, "value");
        kotlin.jvm.internal.g0.p(range, "range");
        return new m(value, range);
    }

    @NotNull
    public final kotlin.ranges.m e() {
        return this.f47934b;
    }

    @NotNull
    public final String f() {
        return this.f47933a;
    }

    public int hashCode() {
        return (this.f47933a.hashCode() * 31) + this.f47934b.hashCode();
    }

    @NotNull
    public String toString() {
        return "MatchGroup(value=" + this.f47933a + ", range=" + this.f47934b + ')';
    }
}
