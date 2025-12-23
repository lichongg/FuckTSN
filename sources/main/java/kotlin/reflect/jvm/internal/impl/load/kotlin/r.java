package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJvmPackagePartSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmPackagePartSource.kt\norg/jetbrains/kotlin/load/kotlin/JvmPackagePartSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,68:1\n1#2:69\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class r implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.s {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.resolve.jvm.d f45984b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final kotlin.reflect.jvm.internal.impl.resolve.jvm.d f45985c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.x<kotlin.reflect.jvm.internal.impl.metadata.deserialization.c> f45986d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final t0 f45987e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final DeserializedContainerAbiStability f45988f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private final x f45989g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final String f45990h;

    public r(@NotNull kotlin.reflect.jvm.internal.impl.resolve.jvm.d className, @Nullable kotlin.reflect.jvm.internal.impl.resolve.jvm.d dVar, @NotNull ProtoBuf.Package packageProto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver, @Nullable kotlin.reflect.jvm.internal.impl.serialization.deserialization.x<kotlin.reflect.jvm.internal.impl.metadata.deserialization.c> xVar, @NotNull t0 preReleaseInfo, @NotNull DeserializedContainerAbiStability abiStability, @Nullable x xVar2) {
        String string;
        kotlin.jvm.internal.g0.p(className, "className");
        kotlin.jvm.internal.g0.p(packageProto, "packageProto");
        kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
        kotlin.jvm.internal.g0.p(preReleaseInfo, "preReleaseInfo");
        kotlin.jvm.internal.g0.p(abiStability, "abiStability");
        this.f45984b = className;
        this.f45985c = dVar;
        this.f45986d = xVar;
        this.f45987e = preReleaseInfo;
        this.f45988f = abiStability;
        this.f45989g = xVar2;
        GeneratedMessageLite.f<ProtoBuf.Package, Integer> packageModuleName = JvmProtoBuf.f46271m;
        kotlin.jvm.internal.g0.o(packageModuleName, "packageModuleName");
        Integer num = (Integer) kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.a(packageProto, packageModuleName);
        this.f45990h = (num == null || (string = nameResolver.getString(num.intValue())) == null) ? "main" : string;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.s
    @NotNull
    public String a() {
        return "Class '" + d().a().a() + '\'';
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1
    @NotNull
    public f1 b() {
        f1 NO_SOURCE_FILE = f1.f44684a;
        kotlin.jvm.internal.g0.o(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.b d() {
        kotlin.reflect.jvm.internal.impl.name.c g6 = e().g();
        kotlin.jvm.internal.g0.o(g6, "getPackageFqName(...)");
        return new kotlin.reflect.jvm.internal.impl.name.b(g6, h());
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.jvm.d e() {
        return this.f45984b;
    }

    @Nullable
    public kotlin.reflect.jvm.internal.impl.resolve.jvm.d f() {
        return this.f45985c;
    }

    @Nullable
    public final x g() {
        return this.f45989g;
    }

    @NotNull
    public String toString() {
        return r.class.getSimpleName() + ": " + e();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.f h() {
        String f6 = e().f();
        kotlin.jvm.internal.g0.o(f6, "getInternalName(...)");
        kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(kotlin.text.u.N5(f6, '/', null, 2, null));
        kotlin.jvm.internal.g0.o(h6, "identifier(...)");
        return h6;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public r(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.load.kotlin.x r11, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package r12, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d r13, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.serialization.deserialization.x<kotlin.reflect.jvm.internal.impl.metadata.deserialization.c> r14, boolean r15, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability r16) {
        /*
            r10 = this;
            java.lang.String r0 = "kotlinClass"
            kotlin.jvm.internal.g0.p(r11, r0)
            java.lang.String r0 = "packageProto"
            kotlin.jvm.internal.g0.p(r12, r0)
            java.lang.String r0 = "nameResolver"
            kotlin.jvm.internal.g0.p(r13, r0)
            java.lang.String r0 = "abiStability"
            r8 = r16
            kotlin.jvm.internal.g0.p(r8, r0)
            kotlin.reflect.jvm.internal.impl.name.b r0 = r11.c()
            kotlin.reflect.jvm.internal.impl.resolve.jvm.d r2 = kotlin.reflect.jvm.internal.impl.resolve.jvm.d.b(r0)
            java.lang.String r0 = "byClassId(...)"
            kotlin.jvm.internal.g0.o(r2, r0)
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader r0 = r11.e()
            java.lang.String r0 = r0.e()
            r1 = 0
            if (r0 == 0) goto L3c
            int r3 = r0.length()
            if (r3 <= 0) goto L39
            kotlin.reflect.jvm.internal.impl.resolve.jvm.d r0 = kotlin.reflect.jvm.internal.impl.resolve.jvm.d.d(r0)
            goto L3a
        L39:
            r0 = r1
        L3a:
            r3 = r0
            goto L3d
        L3c:
            r3 = r1
        L3d:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t0 r7 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t0
            r0 = 2
            r7.<init>(r15, r1, r0, r1)
            r1 = r10
            r9 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.r.<init>(kotlin.reflect.jvm.internal.impl.load.kotlin.x, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, kotlin.reflect.jvm.internal.impl.metadata.deserialization.d, kotlin.reflect.jvm.internal.impl.serialization.deserialization.x, boolean, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability):void");
    }
}
