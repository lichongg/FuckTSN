package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Iterator;
import java.util.Set;
import kotlin.collections.u1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nClassDeserializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/ClassDeserializer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,91:1\n1#2:92\n295#3,2:93\n*S KotlinDebug\n*F\n+ 1 ClassDeserializer.kt\norg/jetbrains/kotlin/serialization/deserialization/ClassDeserializer\n*L\n57#1:93,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final b f46985c = new b(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Set<kotlin.reflect.jvm.internal.impl.name.b> f46986d = u1.f(kotlin.reflect.jvm.internal.impl.name.b.f46334d.c(o.a.f44589d.m()));

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final m f46987a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Function1<a, kotlin.reflect.jvm.internal.impl.descriptors.d> f46988b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.name.b f46989a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private final h f46990b;

        public a(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId, @Nullable h hVar) {
            kotlin.jvm.internal.g0.p(classId, "classId");
            this.f46989a = classId;
            this.f46990b = hVar;
        }

        @Nullable
        public final h a() {
            return this.f46990b;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.name.b b() {
            return this.f46989a;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof a) && kotlin.jvm.internal.g0.g(this.f46989a, ((a) obj).f46989a);
        }

        public int hashCode() {
            return this.f46989a.hashCode();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.v vVar) {
            this();
        }

        private b() {
        }

        @NotNull
        public final Set<kotlin.reflect.jvm.internal.impl.name.b> a() {
            return k.f46986d;
        }
    }

    public k(@NotNull m components) {
        kotlin.jvm.internal.g0.p(components, "components");
        this.f46987a = components;
        this.f46988b = components.u().c(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.d c(k kVar, a key) {
        kotlin.jvm.internal.g0.p(key, "key");
        return kVar.d(key);
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.d f(k kVar, kotlin.reflect.jvm.internal.impl.name.b bVar, h hVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            hVar = null;
        }
        return kVar.e(bVar, hVar);
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.descriptors.d e(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId, @Nullable h hVar) {
        kotlin.jvm.internal.g0.p(classId, "classId");
        return this.f46988b.invoke(new a(classId, hVar));
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.d d(a aVar) {
        Object obj;
        o a6;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n nVar;
        kotlin.reflect.jvm.internal.impl.name.b b6 = aVar.b();
        Iterator<r3.b> it = this.f46987a.l().iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.d b7 = it.next().b(b6);
            if (b7 != null) {
                return b7;
            }
        }
        if (f46986d.contains(b6)) {
            return null;
        }
        h a7 = aVar.a();
        if (a7 == null && (a7 = this.f46987a.e().a(b6)) == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.d a8 = a7.a();
        ProtoBuf.Class b8 = a7.b();
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.a c6 = a7.c();
        e1 d6 = a7.d();
        kotlin.reflect.jvm.internal.impl.name.b e6 = b6.e();
        if (e6 != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.d f6 = f(this, e6, null, 2, null);
            if (f6 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n) {
                nVar = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n) f6;
            } else {
                nVar = null;
            }
            if (nVar == null || !nVar.f1(b6.h())) {
                return null;
            }
            a6 = nVar.Y0();
        } else {
            Iterator<T> it2 = kotlin.reflect.jvm.internal.impl.descriptors.q0.c(this.f46987a.s(), b6.f()).iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj = it2.next();
                    kotlin.reflect.jvm.internal.impl.descriptors.l0 l0Var = (kotlin.reflect.jvm.internal.impl.descriptors.l0) obj;
                    if (!(l0Var instanceof q) || ((q) l0Var).F0(b6.h())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            kotlin.reflect.jvm.internal.impl.descriptors.l0 l0Var2 = (kotlin.reflect.jvm.internal.impl.descriptors.l0) obj;
            if (l0Var2 == null) {
                return null;
            }
            m mVar = this.f46987a;
            ProtoBuf.TypeTable typeTable = b8.getTypeTable();
            kotlin.jvm.internal.g0.o(typeTable, "getTypeTable(...)");
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.h hVar = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.h(typeTable);
            j.a aVar2 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.j.f46256b;
            ProtoBuf.VersionRequirementTable versionRequirementTable = b8.getVersionRequirementTable();
            kotlin.jvm.internal.g0.o(versionRequirementTable, "getVersionRequirementTable(...)");
            a6 = mVar.a(l0Var2, a8, hVar, aVar2.a(versionRequirementTable), c6, null);
            c6 = c6;
        }
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n(a6, b8, a8, c6, d6);
    }
}
