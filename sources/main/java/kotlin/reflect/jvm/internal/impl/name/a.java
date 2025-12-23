package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCallableId.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallableId.kt\norg/jetbrains/kotlin/name/CallableId\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final C0904a f46326f = new C0904a(null);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final f f46327g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final c f46328h;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final c f46329a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final c f46330b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final f f46331c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final b f46332d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final c f46333e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nCallableId.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallableId.kt\norg/jetbrains/kotlin/name/CallableId$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
    /* renamed from: kotlin.reflect.jvm.internal.impl.name.a$a, reason: collision with other inner class name */
    public static final class C0904a {
        public /* synthetic */ C0904a(v vVar) {
            this();
        }

        private C0904a() {
        }
    }

    private a(c cVar, c cVar2, f fVar, b bVar, c cVar3) {
        this.f46329a = cVar;
        this.f46330b = cVar2;
        this.f46331c = fVar;
        this.f46332d = bVar;
        this.f46333e = cVar3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return g0.g(this.f46329a, aVar.f46329a) && g0.g(this.f46330b, aVar.f46330b) && g0.g(this.f46331c, aVar.f46331c);
    }

    static {
        f fVar = h.f46368n;
        f46327g = fVar;
        f46328h = c.f46338c.a(fVar);
    }

    public int hashCode() {
        int hashCode = (527 + this.f46329a.hashCode()) * 31;
        c cVar = this.f46330b;
        return ((hashCode + (cVar != null ? cVar.hashCode() : 0)) * 31) + this.f46331c.hashCode();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(u.w2(this.f46329a.a(), '.', '/', false, 4, null));
        sb.append("/");
        c cVar = this.f46330b;
        if (cVar != null) {
            sb.append(cVar);
            sb.append(".");
        }
        sb.append(this.f46331c);
        return sb.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NotNull c packageName, @NotNull f callableName) {
        this(packageName, null, callableName, null, null);
        g0.p(packageName, "packageName");
        g0.p(callableName, "callableName");
    }
}
