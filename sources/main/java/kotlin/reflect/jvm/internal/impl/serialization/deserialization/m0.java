package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class m0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.d f47019a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.h f47020b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final e1 f47021c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends m0 {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        private final ProtoBuf.Class f47022d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        private final a f47023e;

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.name.b f47024f;

        /* renamed from: g, reason: collision with root package name */
        @NotNull
        private final ProtoBuf.Class.Kind f47025g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f47026h;

        /* renamed from: i, reason: collision with root package name */
        private final boolean f47027i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull ProtoBuf.Class classProto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h typeTable, @Nullable e1 e1Var, @Nullable a aVar) {
            super(nameResolver, typeTable, e1Var, null);
            kotlin.jvm.internal.g0.p(classProto, "classProto");
            kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
            kotlin.jvm.internal.g0.p(typeTable, "typeTable");
            this.f47022d = classProto;
            this.f47023e = aVar;
            this.f47024f = k0.a(nameResolver, classProto.getFqName());
            ProtoBuf.Class.Kind d6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46211f.d(classProto.getFlags());
            this.f47025g = d6 == null ? ProtoBuf.Class.Kind.CLASS : d6;
            Boolean d7 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46212g.d(classProto.getFlags());
            kotlin.jvm.internal.g0.o(d7, "get(...)");
            this.f47026h = d7.booleanValue();
            Boolean d8 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46213h.d(classProto.getFlags());
            kotlin.jvm.internal.g0.o(d8, "get(...)");
            this.f47027i = d8.booleanValue();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.m0
        @NotNull
        public kotlin.reflect.jvm.internal.impl.name.c a() {
            return this.f47024f.a();
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.name.b e() {
            return this.f47024f;
        }

        @NotNull
        public final ProtoBuf.Class f() {
            return this.f47022d;
        }

        @NotNull
        public final ProtoBuf.Class.Kind g() {
            return this.f47025g;
        }

        @Nullable
        public final a h() {
            return this.f47023e;
        }

        public final boolean i() {
            return this.f47026h;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends m0 {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.name.c f47028d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h typeTable, @Nullable e1 e1Var) {
            super(nameResolver, typeTable, e1Var, null);
            kotlin.jvm.internal.g0.p(fqName, "fqName");
            kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
            kotlin.jvm.internal.g0.p(typeTable, "typeTable");
            this.f47028d = fqName;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.m0
        @NotNull
        public kotlin.reflect.jvm.internal.impl.name.c a() {
            return this.f47028d;
        }
    }

    public /* synthetic */ m0(kotlin.reflect.jvm.internal.impl.metadata.deserialization.d dVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.h hVar, e1 e1Var, kotlin.jvm.internal.v vVar) {
        this(dVar, hVar, e1Var);
    }

    @NotNull
    public abstract kotlin.reflect.jvm.internal.impl.name.c a();

    private m0(kotlin.reflect.jvm.internal.impl.metadata.deserialization.d dVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.h hVar, e1 e1Var) {
        this.f47019a = dVar;
        this.f47020b = hVar;
        this.f47021c = e1Var;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.d b() {
        return this.f47019a;
    }

    @Nullable
    public final e1 c() {
        return this.f47021c;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.h d() {
        return this.f47020b;
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName() + ": " + a();
    }
}
