package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class x1 extends f2 {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f47366c = new a(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nTypeSubstitution.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeSubstitution.kt\norg/jetbrains/kotlin/types/TypeConstructorSubstitution$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,207:1\n1563#2:208\n1634#2,3:209\n*S KotlinDebug\n*F\n+ 1 TypeSubstitution.kt\norg/jetbrains/kotlin/types/TypeConstructorSubstitution$Companion\n*L\n96#1:208\n96#1:209,3\n*E\n"})
    public static final class a {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.types.x1$a$a, reason: collision with other inner class name */
        public static final class C0923a extends x1 {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Map<w1, c2> f47367d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f47368e;

            /* JADX WARN: Multi-variable type inference failed */
            C0923a(Map<w1, ? extends c2> map, boolean z5) {
                this.f47367d = map;
                this.f47368e = z5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.f2
            public boolean a() {
                return this.f47368e;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.f2
            public boolean f() {
                return this.f47367d.isEmpty();
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.x1
            public c2 k(w1 key) {
                kotlin.jvm.internal.g0.p(key, "key");
                return this.f47367d.get(key);
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        public static /* synthetic */ x1 e(a aVar, Map map, boolean z5, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                z5 = false;
            }
            return aVar.d(map, z5);
        }

        @JvmStatic
        @NotNull
        public final f2 a(@NotNull t0 kotlinType) {
            kotlin.jvm.internal.g0.p(kotlinType, "kotlinType");
            return b(kotlinType.I0(), kotlinType.G0());
        }

        @JvmStatic
        @NotNull
        public final f2 b(@NotNull w1 typeConstructor, @NotNull List<? extends c2> arguments) {
            kotlin.jvm.internal.g0.p(typeConstructor, "typeConstructor");
            kotlin.jvm.internal.g0.p(arguments, "arguments");
            List<kotlin.reflect.jvm.internal.impl.descriptors.j1> parameters = typeConstructor.getParameters();
            kotlin.jvm.internal.g0.o(parameters, "getParameters(...)");
            kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var = (kotlin.reflect.jvm.internal.impl.descriptors.j1) kotlin.collections.f0.A3(parameters);
            if (j1Var == null || !j1Var.E()) {
                return new o0(parameters, arguments);
            }
            List<kotlin.reflect.jvm.internal.impl.descriptors.j1> parameters2 = typeConstructor.getParameters();
            kotlin.jvm.internal.g0.o(parameters2, "getParameters(...)");
            List<kotlin.reflect.jvm.internal.impl.descriptors.j1> list = parameters2;
            ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.j1) it.next()).o());
            }
            return e(this, kotlin.collections.i1.B0(kotlin.collections.f0.o6(arrayList, arguments)), false, 2, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final x1 c(@NotNull Map<w1, ? extends c2> map) {
            kotlin.jvm.internal.g0.p(map, "map");
            return e(this, map, false, 2, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final x1 d(@NotNull Map<w1, ? extends c2> map, boolean z5) {
            kotlin.jvm.internal.g0.p(map, "map");
            return new C0923a(map, z5);
        }
    }

    @Nullable
    public abstract c2 k(@NotNull w1 w1Var);

    @JvmStatic
    @NotNull
    public static final f2 i(@NotNull w1 w1Var, @NotNull List<? extends c2> list) {
        return f47366c.b(w1Var, list);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final x1 j(@NotNull Map<w1, ? extends c2> map) {
        return f47366c.c(map);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.f2
    @Nullable
    public c2 e(@NotNull t0 key) {
        kotlin.jvm.internal.g0.p(key, "key");
        return k(key.I0());
    }
}
