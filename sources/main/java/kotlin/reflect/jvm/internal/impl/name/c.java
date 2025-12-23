package kotlin.reflect.jvm.internal.impl.name;

import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFqName.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FqName.kt\norg/jetbrains/kotlin/name/FqName\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,128:1\n1#2:129\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f46338c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final c f46339d = new c("");

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final d f46340a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private transient c f46341b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }

        @JvmStatic
        @NotNull
        public final c a(@NotNull f shortName) {
            g0.p(shortName, "shortName");
            return new c(d.f46342e.a(shortName));
        }
    }

    public c(@NotNull String fqName) {
        g0.p(fqName, "fqName");
        this.f46340a = new d(fqName, this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && g0.g(this.f46340a, ((c) obj).f46340a);
    }

    @NotNull
    public final String a() {
        return this.f46340a.a();
    }

    @NotNull
    public final c b(@NotNull f name) {
        g0.p(name, "name");
        return new c(this.f46340a.b(name), this);
    }

    public final boolean c() {
        return this.f46340a.e();
    }

    @NotNull
    public final c d() {
        c cVar = this.f46341b;
        if (cVar != null) {
            return cVar;
        }
        if (c()) {
            throw new IllegalStateException("root");
        }
        c cVar2 = new c(this.f46340a.g());
        this.f46341b = cVar2;
        return cVar2;
    }

    @NotNull
    public final List<f> e() {
        return this.f46340a.h();
    }

    @NotNull
    public final f f() {
        return this.f46340a.j();
    }

    @NotNull
    public final f g() {
        return this.f46340a.k();
    }

    public final boolean h(@NotNull f segment) {
        g0.p(segment, "segment");
        return this.f46340a.l(segment);
    }

    public int hashCode() {
        return this.f46340a.hashCode();
    }

    @NotNull
    public final d i() {
        return this.f46340a;
    }

    @NotNull
    public String toString() {
        return this.f46340a.toString();
    }

    public c(@NotNull d fqName) {
        g0.p(fqName, "fqName");
        this.f46340a = fqName;
    }

    private c(d dVar, c cVar) {
        this.f46340a = dVar;
        this.f46341b = cVar;
    }
}
