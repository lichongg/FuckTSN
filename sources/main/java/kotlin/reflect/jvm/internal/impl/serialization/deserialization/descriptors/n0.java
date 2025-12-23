package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n0 extends kotlin.reflect.jvm.internal.impl.descriptors.impl.k0 implements c {

    @NotNull
    private final ProtoBuf.Property E;

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.d F;

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.h G;

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.j H;

    @Nullable
    private final s I;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k containingDeclaration, @Nullable w0 w0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, @NotNull Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s visibility, boolean z5, @NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull CallableMemberDescriptor.Kind kind, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, @NotNull ProtoBuf.Property proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h typeTable, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.j versionRequirementTable, @Nullable s sVar) {
        super(containingDeclaration, w0Var, annotations, modality, visibility, z5, name, kind, e1.f44683a, z6, z7, z10, false, z8, z9);
        kotlin.jvm.internal.g0.p(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.g0.p(annotations, "annotations");
        kotlin.jvm.internal.g0.p(modality, "modality");
        kotlin.jvm.internal.g0.p(visibility, "visibility");
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(kind, "kind");
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
        kotlin.jvm.internal.g0.p(typeTable, "typeTable");
        kotlin.jvm.internal.g0.p(versionRequirementTable, "versionRequirementTable");
        this.E = proto;
        this.F = nameResolver;
        this.G = typeTable;
        this.H = versionRequirementTable;
        this.I = sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t
    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.h A() {
        return this.G;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k0
    @NotNull
    protected kotlin.reflect.jvm.internal.impl.descriptors.impl.k0 L0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k newOwner, @NotNull Modality newModality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s newVisibility, @Nullable w0 w0Var, @NotNull CallableMemberDescriptor.Kind kind, @NotNull kotlin.reflect.jvm.internal.impl.name.f newName, @NotNull e1 source) {
        kotlin.jvm.internal.g0.p(newOwner, "newOwner");
        kotlin.jvm.internal.g0.p(newModality, "newModality");
        kotlin.jvm.internal.g0.p(newVisibility, "newVisibility");
        kotlin.jvm.internal.g0.p(kind, "kind");
        kotlin.jvm.internal.g0.p(newName, "newName");
        kotlin.jvm.internal.g0.p(source, "source");
        return new n0(newOwner, w0Var, getAnnotations(), newModality, newVisibility, C(), newName, kind, B0(), isConst(), isExternal(), X(), q0(), K(), a0(), A(), c1(), b0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t
    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.d a0() {
        return this.F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t
    @Nullable
    public s b0() {
        return this.I;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t
    @NotNull
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public ProtoBuf.Property K() {
        return this.E;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.j c1() {
        return this.H;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k0, kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean isExternal() {
        Boolean d6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.E.d(K().getFlags());
        kotlin.jvm.internal.g0.o(d6, "get(...)");
        return d6.booleanValue();
    }
}
