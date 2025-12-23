package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p1 {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f47311e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final p1 f47312a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.i1 f47313b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<c2> f47314c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final Map<kotlin.reflect.jvm.internal.impl.descriptors.j1, c2> f47315d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nTypeAliasExpansion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAliasExpansion.kt\norg/jetbrains/kotlin/types/TypeAliasExpansion$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,43:1\n1563#2:44\n1634#2,3:45\n*S KotlinDebug\n*F\n+ 1 TypeAliasExpansion.kt\norg/jetbrains/kotlin/types/TypeAliasExpansion$Companion\n*L\n34#1:44\n34#1:45,3\n*E\n"})
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final p1 a(@Nullable p1 p1Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.i1 typeAliasDescriptor, @NotNull List<? extends c2> arguments) {
            kotlin.jvm.internal.g0.p(typeAliasDescriptor, "typeAliasDescriptor");
            kotlin.jvm.internal.g0.p(arguments, "arguments");
            List<kotlin.reflect.jvm.internal.impl.descriptors.j1> parameters = typeAliasDescriptor.o().getParameters();
            kotlin.jvm.internal.g0.o(parameters, "getParameters(...)");
            List<kotlin.reflect.jvm.internal.impl.descriptors.j1> list = parameters;
            ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.j1) it.next()).a());
            }
            return new p1(p1Var, typeAliasDescriptor, arguments, kotlin.collections.i1.B0(kotlin.collections.f0.o6(arrayList, arguments)), null);
        }
    }

    public /* synthetic */ p1(p1 p1Var, kotlin.reflect.jvm.internal.impl.descriptors.i1 i1Var, List list, Map map, kotlin.jvm.internal.v vVar) {
        this(p1Var, i1Var, list, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private p1(p1 p1Var, kotlin.reflect.jvm.internal.impl.descriptors.i1 i1Var, List<? extends c2> list, Map<kotlin.reflect.jvm.internal.impl.descriptors.j1, ? extends c2> map) {
        this.f47312a = p1Var;
        this.f47313b = i1Var;
        this.f47314c = list;
        this.f47315d = map;
    }

    @NotNull
    public final List<c2> a() {
        return this.f47314c;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.i1 b() {
        return this.f47313b;
    }

    @Nullable
    public final c2 c(@NotNull w1 constructor) {
        kotlin.jvm.internal.g0.p(constructor, "constructor");
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = constructor.c();
        if (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.j1) {
            return this.f47315d.get(c6);
        }
        return null;
    }

    public final boolean d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.i1 descriptor) {
        kotlin.jvm.internal.g0.p(descriptor, "descriptor");
        if (kotlin.jvm.internal.g0.g(this.f47313b, descriptor)) {
            return true;
        }
        p1 p1Var = this.f47312a;
        return p1Var != null ? p1Var.d(descriptor) : false;
    }
}
