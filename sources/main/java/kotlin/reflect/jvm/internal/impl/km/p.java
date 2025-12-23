package kotlin.reflect.jvm.internal.impl.km;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f45261c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private u f45262a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private String f45263b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return g0.g(this.f45262a, pVar.f45262a) && g0.g(this.f45263b, pVar.f45263b);
    }

    public p(@NotNull u type, @Nullable String str) {
        g0.p(type, "type");
        this.f45262a = type;
        this.f45263b = str;
    }

    @Nullable
    public final String a() {
        return this.f45263b;
    }

    @NotNull
    public final u getType() {
        return this.f45262a;
    }

    public int hashCode() {
        int hashCode = this.f45262a.hashCode() * 31;
        String str = this.f45263b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "KmFlexibleTypeUpperBound(type=" + this.f45262a + ", typeFlexibilityId=" + this.f45263b + ')';
    }
}
