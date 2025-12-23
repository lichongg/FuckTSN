package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.reflect.jvm.internal.impl.builtins.functions.e;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFunctionTypeKindExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FunctionTypeKindExtractor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionTypeKindExtractor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,70:1\n1491#2:71\n1516#2,3:72\n1519#2,3:82\n1761#2,3:85\n382#3,7:75\n*S KotlinDebug\n*F\n+ 1 FunctionTypeKindExtractor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionTypeKindExtractor\n*L\n32#1:71\n32#1:72,3\n32#1:82,3\n54#1:85,3\n32#1:75,7\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f44428c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final f f44429d = new f(f0.Q(e.a.f44424f, e.d.f44427f, e.b.f44425f, e.c.f44426f));

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<e> f44430a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Map<kotlin.reflect.jvm.internal.impl.name.c, List<e>> f44431b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final f a() {
            return f.f44429d;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final e f44432a;

        /* renamed from: b, reason: collision with root package name */
        private final int f44433b;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return g0.g(this.f44432a, bVar.f44432a) && this.f44433b == bVar.f44433b;
        }

        public b(@NotNull e kind, int i6) {
            g0.p(kind, "kind");
            this.f44432a = kind;
            this.f44433b = i6;
        }

        @NotNull
        public final e a() {
            return this.f44432a;
        }

        public final int b() {
            return this.f44433b;
        }

        @NotNull
        public final e c() {
            return this.f44432a;
        }

        public int hashCode() {
            return (this.f44432a.hashCode() * 31) + this.f44433b;
        }

        @NotNull
        public String toString() {
            return "KindWithArity(kind=" + this.f44432a + ", arity=" + this.f44433b + ')';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@NotNull List<? extends e> kinds) {
        g0.p(kinds, "kinds");
        this.f44430a = kinds;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : kinds) {
            kotlin.reflect.jvm.internal.impl.name.c b6 = ((e) obj).b();
            Object obj2 = linkedHashMap.get(b6);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(b6, obj2);
            }
            ((List) obj2).add(obj);
        }
        this.f44431b = linkedHashMap;
    }

    @Nullable
    public final e b(@NotNull kotlin.reflect.jvm.internal.impl.name.c packageFqName, @NotNull String className) {
        g0.p(packageFqName, "packageFqName");
        g0.p(className, "className");
        b c6 = c(packageFqName, className);
        if (c6 != null) {
            return c6.c();
        }
        return null;
    }

    @Nullable
    public final b c(@NotNull kotlin.reflect.jvm.internal.impl.name.c packageFqName, @NotNull String className) {
        g0.p(packageFqName, "packageFqName");
        g0.p(className, "className");
        List<e> list = this.f44431b.get(packageFqName);
        if (list == null) {
            return null;
        }
        for (e eVar : list) {
            if (u.H2(className, eVar.a(), false, 2, null)) {
                String substring = className.substring(eVar.a().length());
                g0.o(substring, "substring(...)");
                Integer d6 = d(substring);
                if (d6 != null) {
                    return new b(eVar, d6.intValue());
                }
            }
        }
        return null;
    }

    private final Integer d(String str) {
        if (str.length() == 0) {
            return null;
        }
        int length = str.length();
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            int charAt = str.charAt(i7) - '0';
            if (charAt < 0 || charAt >= 10) {
                return null;
            }
            i6 = (i6 * 10) + charAt;
        }
        return Integer.valueOf(i6);
    }
}
