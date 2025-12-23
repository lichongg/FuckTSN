package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final m f47039a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.d f47040b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.k f47041c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.h f47042d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.j f47043e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.a f47044f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.s f47045g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final v0 f47046h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private final j0 f47047i;

    public o(@NotNull m components, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k containingDeclaration, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h typeTable, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.j versionRequirementTable, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.a metadataVersion, @Nullable kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.s sVar, @Nullable v0 v0Var, @NotNull List<ProtoBuf.TypeParameter> typeParameters) {
        String a6;
        kotlin.jvm.internal.g0.p(components, "components");
        kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
        kotlin.jvm.internal.g0.p(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.g0.p(typeTable, "typeTable");
        kotlin.jvm.internal.g0.p(versionRequirementTable, "versionRequirementTable");
        kotlin.jvm.internal.g0.p(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.g0.p(typeParameters, "typeParameters");
        this.f47039a = components;
        this.f47040b = nameResolver;
        this.f47041c = containingDeclaration;
        this.f47042d = typeTable;
        this.f47043e = versionRequirementTable;
        this.f47044f = metadataVersion;
        this.f47045g = sVar;
        this.f47046h = new v0(this, v0Var, typeParameters, "Deserializer for \"" + containingDeclaration.getName() + '\"', (sVar == null || (a6 = sVar.a()) == null) ? "[container not found]" : a6);
        this.f47047i = new j0(this);
    }

    public static /* synthetic */ o b(o oVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar, List list, kotlin.reflect.jvm.internal.impl.metadata.deserialization.d dVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.h hVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.j jVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.a aVar, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            dVar = oVar.f47040b;
        }
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.d dVar2 = dVar;
        if ((i6 & 8) != 0) {
            hVar = oVar.f47042d;
        }
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.h hVar2 = hVar;
        if ((i6 & 16) != 0) {
            jVar = oVar.f47043e;
        }
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.j jVar2 = jVar;
        if ((i6 & 32) != 0) {
            aVar = oVar.f47044f;
        }
        return oVar.a(kVar, list, dVar2, hVar2, jVar2, aVar);
    }

    @NotNull
    public final o a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k descriptor, @NotNull List<ProtoBuf.TypeParameter> typeParameterProtos, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h typeTable, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.j versionRequirementTable, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.a metadataVersion) {
        kotlin.jvm.internal.g0.p(descriptor, "descriptor");
        kotlin.jvm.internal.g0.p(typeParameterProtos, "typeParameterProtos");
        kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
        kotlin.jvm.internal.g0.p(typeTable, "typeTable");
        kotlin.jvm.internal.g0.p(versionRequirementTable, "versionRequirementTable");
        kotlin.jvm.internal.g0.p(metadataVersion, "metadataVersion");
        return new o(this.f47039a, nameResolver, descriptor, typeTable, kotlin.reflect.jvm.internal.impl.metadata.deserialization.k.b(metadataVersion) ? versionRequirementTable : this.f47043e, metadataVersion, this.f47045g, this.f47046h, typeParameterProtos);
    }

    @NotNull
    public final m c() {
        return this.f47039a;
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.s d() {
        return this.f47045g;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.k e() {
        return this.f47041c;
    }

    @NotNull
    public final j0 f() {
        return this.f47047i;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.d g() {
        return this.f47040b;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.storage.n h() {
        return this.f47039a.u();
    }

    @NotNull
    public final v0 i() {
        return this.f47046h;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.h j() {
        return this.f47042d;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.j k() {
        return this.f47043e;
    }
}
