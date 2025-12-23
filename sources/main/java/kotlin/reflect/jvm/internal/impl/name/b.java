package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nClassId.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassId.kt\norg/jetbrains/kotlin/name/ClassId\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 addToStdlib.kt\norg/jetbrains/kotlin/utils/addToStdlib/AddToStdlibKt\n*L\n1#1,141:1\n1#2:142\n231#3:143\n231#3:144\n*S KotlinDebug\n*F\n+ 1 ClassId.kt\norg/jetbrains/kotlin/name/ClassId\n*L\n37#1:143\n47#1:144\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f46334d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final c f46335a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final c f46336b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f46337c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }

        public static /* synthetic */ b b(a aVar, String str, boolean z5, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                z5 = false;
            }
            return aVar.a(str, z5);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final b a(@NotNull String string, boolean z5) {
            String x22;
            String str;
            g0.p(string, "string");
            int G3 = u.G3(string, '`', 0, false, 6, null);
            if (G3 == -1) {
                G3 = string.length();
            }
            int W3 = u.W3(string, "/", G3, false, 4, null);
            if (W3 == -1) {
                x22 = u.x2(string, "`", "", false, 4, null);
                str = "";
            } else {
                String substring = string.substring(0, W3);
                g0.o(substring, "substring(...)");
                String w22 = u.w2(substring, '/', '.', false, 4, null);
                String substring2 = string.substring(W3 + 1);
                g0.o(substring2, "substring(...)");
                x22 = u.x2(substring2, "`", "", false, 4, null);
                str = w22;
            }
            return new b(new c(str), new c(x22), z5);
        }

        @JvmStatic
        @NotNull
        public final b c(@NotNull c topLevelFqName) {
            g0.p(topLevelFqName, "topLevelFqName");
            return new b(topLevelFqName.d(), topLevelFqName.f());
        }
    }

    public b(@NotNull c packageFqName, @NotNull c relativeClassName, boolean z5) {
        g0.p(packageFqName, "packageFqName");
        g0.p(relativeClassName, "relativeClassName");
        this.f46335a = packageFqName;
        this.f46336b = relativeClassName;
        this.f46337c = z5;
        relativeClassName.c();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return g0.g(this.f46335a, bVar.f46335a) && g0.g(this.f46336b, bVar.f46336b) && this.f46337c == bVar.f46337c;
    }

    @JvmStatic
    @NotNull
    public static final b k(@NotNull c cVar) {
        return f46334d.c(cVar);
    }

    @NotNull
    public final c a() {
        if (this.f46335a.c()) {
            return this.f46336b;
        }
        return new c(this.f46335a.a() + '.' + this.f46336b.a());
    }

    @NotNull
    public final String b() {
        if (this.f46335a.c()) {
            return c(this.f46336b);
        }
        return u.w2(this.f46335a.a(), '.', '/', false, 4, null) + "/" + c(this.f46336b);
    }

    @NotNull
    public final b d(@NotNull f name) {
        g0.p(name, "name");
        return new b(this.f46335a, this.f46336b.b(name), this.f46337c);
    }

    @Nullable
    public final b e() {
        c d6 = this.f46336b.d();
        if (d6.c()) {
            return null;
        }
        return new b(this.f46335a, d6, this.f46337c);
    }

    @NotNull
    public final c f() {
        return this.f46335a;
    }

    @NotNull
    public final c g() {
        return this.f46336b;
    }

    @NotNull
    public final f h() {
        return this.f46336b.f();
    }

    public int hashCode() {
        return (((this.f46335a.hashCode() * 31) + this.f46336b.hashCode()) * 31) + kotlin.reflect.jvm.internal.impl.km.f.a(this.f46337c);
    }

    public final boolean i() {
        return this.f46337c;
    }

    public final boolean j() {
        return !this.f46336b.d().c();
    }

    @NotNull
    public String toString() {
        if (!this.f46335a.c()) {
            return b();
        }
        return '/' + b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(@NotNull c packageFqName, @NotNull f topLevelName) {
        this(packageFqName, c.f46338c.a(topLevelName), false);
        g0.p(packageFqName, "packageFqName");
        g0.p(topLevelName, "topLevelName");
    }

    private static final String c(c cVar) {
        String a6 = cVar.a();
        if (u.k3(a6, '/', false, 2, null)) {
            return '`' + a6 + '`';
        }
        return a6;
    }
}
