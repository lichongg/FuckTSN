package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class t {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends t {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final Field f47586a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull Field field) {
            super(null);
            kotlin.jvm.internal.g0.p(field, "field");
            this.f47586a = field;
        }

        @Override // kotlin.reflect.jvm.internal.t
        @NotNull
        public String a() {
            StringBuilder sb = new StringBuilder();
            String name = this.f47586a.getName();
            kotlin.jvm.internal.g0.o(name, "getName(...)");
            sb.append(kotlin.reflect.jvm.internal.impl.load.java.h0.b(name));
            sb.append("()");
            Class<?> type = this.f47586a.getType();
            kotlin.jvm.internal.g0.o(type, "getType(...)");
            sb.append(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.f(type));
            return sb.toString();
        }

        @NotNull
        public final Field b() {
            return this.f47586a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends t {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final Method f47587a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private final Method f47588b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull Method getterMethod, @Nullable Method method) {
            super(null);
            kotlin.jvm.internal.g0.p(getterMethod, "getterMethod");
            this.f47587a = getterMethod;
            this.f47588b = method;
        }

        @Override // kotlin.reflect.jvm.internal.t
        @NotNull
        public String a() {
            String d6;
            d6 = m3.d(this.f47587a);
            return d6;
        }

        @NotNull
        public final Method b() {
            return this.f47587a;
        }

        @Nullable
        public final Method c() {
            return this.f47588b;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nRuntimeTypeMapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RuntimeTypeMapper.kt\nkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,302:1\n1#2:303\n*E\n"})
    public static final class c extends t {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.descriptors.w0 f47589a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final ProtoBuf.Property f47590b;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        private final JvmProtoBuf.JvmPropertySignature f47591c;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.d f47592d;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.h f47593e;

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        private final String f47594f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.w0 descriptor, @NotNull ProtoBuf.Property proto, @NotNull JvmProtoBuf.JvmPropertySignature signature, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h typeTable) {
            super(null);
            String str;
            kotlin.jvm.internal.g0.p(descriptor, "descriptor");
            kotlin.jvm.internal.g0.p(proto, "proto");
            kotlin.jvm.internal.g0.p(signature, "signature");
            kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
            kotlin.jvm.internal.g0.p(typeTable, "typeTable");
            this.f47589a = descriptor;
            this.f47590b = proto;
            this.f47591c = signature;
            this.f47592d = nameResolver;
            this.f47593e = typeTable;
            if (signature.hasGetter()) {
                str = nameResolver.getString(signature.getGetter().getName()) + nameResolver.getString(signature.getGetter().getDesc());
            } else {
                d.a d6 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h.d(kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h.f46317a, proto, nameResolver, typeTable, false, 8, null);
                if (d6 == null) {
                    throw new KotlinReflectionInternalError("No field signature for property: " + descriptor);
                }
                String b6 = d6.b();
                str = kotlin.reflect.jvm.internal.impl.load.java.h0.b(b6) + c() + "()" + d6.c();
            }
            this.f47594f = str;
        }

        private final String c() {
            String str;
            kotlin.reflect.jvm.internal.impl.descriptors.k b6 = this.f47589a.b();
            kotlin.jvm.internal.g0.o(b6, "getContainingDeclaration(...)");
            if (kotlin.jvm.internal.g0.g(this.f47589a.getVisibility(), kotlin.reflect.jvm.internal.impl.descriptors.r.f44947d) && (b6 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n)) {
                ProtoBuf.Class Z0 = ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n) b6).Z0();
                GeneratedMessageLite.f<ProtoBuf.Class, Integer> classModuleName = JvmProtoBuf.f46267i;
                kotlin.jvm.internal.g0.o(classModuleName, "classModuleName");
                Integer num = (Integer) kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.a(Z0, classModuleName);
                if (num == null || (str = this.f47592d.getString(num.intValue())) == null) {
                    str = "main";
                }
                return kotlin.text.v0.f47959c + kotlin.reflect.jvm.internal.impl.name.g.b(str);
            }
            if (!kotlin.jvm.internal.g0.g(this.f47589a.getVisibility(), kotlin.reflect.jvm.internal.impl.descriptors.r.f44944a) || !(b6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.l0)) {
                return "";
            }
            kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var = this.f47589a;
            kotlin.jvm.internal.g0.n(w0Var, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.s b02 = ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n0) w0Var).b0();
            if (!(b02 instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.r)) {
                return "";
            }
            kotlin.reflect.jvm.internal.impl.load.kotlin.r rVar = (kotlin.reflect.jvm.internal.impl.load.kotlin.r) b02;
            if (rVar.f() == null) {
                return "";
            }
            return kotlin.text.v0.f47959c + rVar.h().b();
        }

        @Override // kotlin.reflect.jvm.internal.t
        @NotNull
        public String a() {
            return this.f47594f;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.descriptors.w0 b() {
            return this.f47589a;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.d d() {
            return this.f47592d;
        }

        @NotNull
        public final ProtoBuf.Property e() {
            return this.f47590b;
        }

        @NotNull
        public final JvmProtoBuf.JvmPropertySignature f() {
            return this.f47591c;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.h g() {
            return this.f47593e;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d extends t {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final r.e f47595a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private final r.e f47596b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull r.e getterSignature, @Nullable r.e eVar) {
            super(null);
            kotlin.jvm.internal.g0.p(getterSignature, "getterSignature");
            this.f47595a = getterSignature;
            this.f47596b = eVar;
        }

        @Override // kotlin.reflect.jvm.internal.t
        @NotNull
        public String a() {
            return this.f47595a.a();
        }

        @NotNull
        public final r.e b() {
            return this.f47595a;
        }

        @Nullable
        public final r.e c() {
            return this.f47596b;
        }
    }

    public /* synthetic */ t(kotlin.jvm.internal.v vVar) {
        this();
    }

    @NotNull
    public abstract String a();

    private t() {
    }
}
