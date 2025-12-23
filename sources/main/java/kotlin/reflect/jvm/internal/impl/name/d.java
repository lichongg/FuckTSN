package kotlin.reflect.jvm.internal.impl.name;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.text.u;
import kotlin.text.v0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFqNameUnsafe.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FqNameUnsafe.kt\norg/jetbrains/kotlin/name/FqNameUnsafe\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,189:1\n1#2:190\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f46342e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final f f46343f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Pattern f46344g;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f46345a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private transient c f46346b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private transient d f46347c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private transient f f46348d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }

        @JvmStatic
        @NotNull
        public final d a(@NotNull f shortName) {
            g0.p(shortName, "shortName");
            String b6 = shortName.b();
            g0.o(b6, "asString(...)");
            return new d(b6, c.f46339d.i(), shortName, null);
        }
    }

    public /* synthetic */ d(String str, d dVar, f fVar, v vVar) {
        this(str, dVar, fVar);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && g0.g(this.f46345a, ((d) obj).f46345a);
    }

    static {
        f k6 = f.k("<root>");
        g0.o(k6, "special(...)");
        f46343f = k6;
        Pattern compile = Pattern.compile("\\.");
        g0.o(compile, "compile(...)");
        f46344g = compile;
    }

    public d(@NotNull String fqName, @NotNull c safe) {
        g0.p(fqName, "fqName");
        g0.p(safe, "safe");
        this.f46345a = fqName;
        this.f46346b = safe;
    }

    private final void c() {
        int d6 = d(this.f46345a);
        if (d6 < 0) {
            this.f46348d = f.d(this.f46345a);
            this.f46347c = c.f46339d.i();
            return;
        }
        String substring = this.f46345a.substring(d6 + 1);
        g0.o(substring, "substring(...)");
        this.f46348d = f.d(substring);
        String substring2 = this.f46345a.substring(0, d6);
        g0.o(substring2, "substring(...)");
        this.f46347c = new d(substring2);
    }

    @NotNull
    public final String a() {
        return this.f46345a;
    }

    @NotNull
    public final d b(@NotNull f name) {
        String str;
        g0.p(name, "name");
        if (e()) {
            str = name.b();
        } else {
            str = this.f46345a + '.' + name.b();
        }
        g0.m(str);
        return new d(str, this, name);
    }

    public final boolean e() {
        return this.f46345a.length() == 0;
    }

    public final boolean f() {
        return this.f46346b != null || u.G3(a(), v0.f47961e, 0, false, 6, null) < 0;
    }

    @NotNull
    public final d g() {
        d dVar = this.f46347c;
        if (dVar != null) {
            return dVar;
        }
        if (e()) {
            throw new IllegalStateException("root");
        }
        c();
        d dVar2 = this.f46347c;
        g0.m(dVar2);
        return dVar2;
    }

    public int hashCode() {
        return this.f46345a.hashCode();
    }

    @NotNull
    public final f j() {
        f fVar = this.f46348d;
        if (fVar != null) {
            return fVar;
        }
        if (e()) {
            throw new IllegalStateException("root");
        }
        c();
        f fVar2 = this.f46348d;
        g0.m(fVar2);
        return fVar2;
    }

    public final boolean l(@NotNull f segment) {
        boolean q22;
        g0.p(segment, "segment");
        if (e()) {
            return false;
        }
        int G3 = u.G3(this.f46345a, '.', 0, false, 6, null);
        if (G3 == -1) {
            G3 = this.f46345a.length();
        }
        int i6 = G3;
        String b6 = segment.b();
        g0.o(b6, "asString(...)");
        if (i6 == b6.length()) {
            q22 = kotlin.text.g0.q2(this.f46345a, 0, b6, 0, i6, (r12 & 16) != 0 ? false : false);
            if (q22) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final c m() {
        c cVar = this.f46346b;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c(this);
        this.f46346b = cVar2;
        return cVar2;
    }

    private final int d(String str) {
        int length = str.length() - 1;
        boolean z5 = false;
        while (length >= 0) {
            char charAt = str.charAt(length);
            if (charAt == '.' && !z5) {
                return length;
            }
            if (charAt == '`') {
                z5 = !z5;
            } else if (charAt == '\\') {
                length--;
            }
            length--;
        }
        return -1;
    }

    private static final List<f> i(d dVar) {
        if (dVar.e()) {
            return new ArrayList();
        }
        List<f> i6 = i(dVar.g());
        i6.add(dVar.j());
        return i6;
    }

    @NotNull
    public final List<f> h() {
        return i(this);
    }

    @NotNull
    public final f k() {
        if (e()) {
            return f46343f;
        }
        return j();
    }

    @NotNull
    public String toString() {
        if (e()) {
            String b6 = f46343f.b();
            g0.o(b6, "asString(...)");
            return b6;
        }
        return this.f46345a;
    }

    public d(@NotNull String fqName) {
        g0.p(fqName, "fqName");
        this.f46345a = fqName;
    }

    private d(String str, d dVar, f fVar) {
        this.f46345a = str;
        this.f46347c = dVar;
        this.f46348d = fVar;
    }
}
