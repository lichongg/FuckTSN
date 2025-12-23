package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBuiltInSerializerProtocol.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuiltInSerializerProtocol.kt\norg/jetbrains/kotlin/serialization/deserialization/builtins/BuiltInSerializerProtocol\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,46:1\n1#2:47\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a extends c4.a {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f46819r = new a();

    @NotNull
    public final String q(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        g0.p(fqName, "fqName");
        return s(fqName) + ".kotlin_builtins";
    }

    @NotNull
    public final String r(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        g0.p(fqName, "fqName");
        return u.w2(fqName.a(), '.', '/', false, 4, null) + '/' + q(fqName);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private a() {
        /*
            r18 = this;
            kotlin.reflect.jvm.internal.impl.protobuf.f r1 = kotlin.reflect.jvm.internal.impl.protobuf.f.d()
            z3.b.a(r1)
            java.lang.String r0 = "apply(...)"
            kotlin.jvm.internal.g0.o(r1, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, java.lang.Integer> r2 = z3.b.f56813a
            java.lang.String r0 = "packageFqName"
            kotlin.jvm.internal.g0.o(r2, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r3 = z3.b.f56815c
            java.lang.String r0 = "constructorAnnotation"
            kotlin.jvm.internal.g0.o(r3, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r4 = z3.b.f56814b
            java.lang.String r0 = "classAnnotation"
            kotlin.jvm.internal.g0.o(r4, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r5 = z3.b.f56816d
            java.lang.String r0 = "functionAnnotation"
            kotlin.jvm.internal.g0.o(r5, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r7 = z3.b.f56817e
            java.lang.String r0 = "propertyAnnotation"
            kotlin.jvm.internal.g0.o(r7, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r8 = z3.b.f56818f
            java.lang.String r0 = "propertyGetterAnnotation"
            kotlin.jvm.internal.g0.o(r8, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r9 = z3.b.f56819g
            java.lang.String r0 = "propertySetterAnnotation"
            kotlin.jvm.internal.g0.o(r9, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r13 = z3.b.f56821i
            java.lang.String r0 = "enumEntryAnnotation"
            kotlin.jvm.internal.g0.o(r13, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value> r14 = z3.b.f56820h
            java.lang.String r0 = "compileTimeValue"
            kotlin.jvm.internal.g0.o(r14, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r15 = z3.b.f56822j
            java.lang.String r0 = "parameterAnnotation"
            kotlin.jvm.internal.g0.o(r15, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r0 = z3.b.f56823k
            java.lang.String r6 = "typeAnnotation"
            kotlin.jvm.internal.g0.o(r0, r6)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r6 = z3.b.f56824l
            java.lang.String r10 = "typeParameterAnnotation"
            kotlin.jvm.internal.g0.o(r6, r10)
            r17 = r6
            r6 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r16 = r0
            r0 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a.<init>():void");
    }

    private final String s(kotlin.reflect.jvm.internal.impl.name.c cVar) {
        if (cVar.c()) {
            return "default-package";
        }
        String b6 = cVar.f().b();
        g0.o(b6, "asString(...)");
        return b6;
    }
}
