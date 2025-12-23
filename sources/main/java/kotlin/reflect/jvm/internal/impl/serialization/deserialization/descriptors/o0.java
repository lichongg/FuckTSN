package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o0 extends kotlin.reflect.jvm.internal.impl.descriptors.impl.o0 implements c {

    @NotNull
    private final ProtoBuf.Function E;

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.d F;

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.h G;

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.j H;

    @Nullable
    private final s I;

    public /* synthetic */ o0(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, d1 d1Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, kotlin.reflect.jvm.internal.impl.name.f fVar, CallableMemberDescriptor.Kind kind, ProtoBuf.Function function, kotlin.reflect.jvm.internal.impl.metadata.deserialization.d dVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.h hVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.j jVar, s sVar, e1 e1Var, int i6, kotlin.jvm.internal.v vVar) {
        this(kVar, d1Var, gVar, fVar, kind, function, dVar, hVar, jVar, sVar, (i6 & 1024) != 0 ? null : e1Var);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public o0(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.k r12, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.descriptors.d1 r13, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g r14, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.f r15, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind r16, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function r17, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d r18, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h r19, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.j r20, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.s r21, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.descriptors.e1 r22) {
        /*
            r11 = this;
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            java.lang.String r0 = "containingDeclaration"
            kotlin.jvm.internal.g0.p(r12, r0)
            java.lang.String r0 = "annotations"
            kotlin.jvm.internal.g0.p(r14, r0)
            java.lang.String r0 = "name"
            kotlin.jvm.internal.g0.p(r15, r0)
            java.lang.String r0 = "kind"
            r5 = r16
            kotlin.jvm.internal.g0.p(r5, r0)
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.g0.p(r7, r0)
            java.lang.String r0 = "nameResolver"
            kotlin.jvm.internal.g0.p(r8, r0)
            java.lang.String r0 = "typeTable"
            kotlin.jvm.internal.g0.p(r9, r0)
            java.lang.String r0 = "versionRequirementTable"
            kotlin.jvm.internal.g0.p(r10, r0)
            if (r22 != 0) goto L3d
            kotlin.reflect.jvm.internal.impl.descriptors.e1 r0 = kotlin.reflect.jvm.internal.impl.descriptors.e1.f44683a
            r6 = r0
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r0 = r11
            goto L44
        L3d:
            r6 = r22
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
        L44:
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r11.E = r7
            r11.F = r8
            r11.G = r9
            r11.H = r10
            r1 = r21
            r11.I = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.o0.<init>(kotlin.reflect.jvm.internal.impl.descriptors.k, kotlin.reflect.jvm.internal.impl.descriptors.d1, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g, kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function, kotlin.reflect.jvm.internal.impl.metadata.deserialization.d, kotlin.reflect.jvm.internal.impl.metadata.deserialization.h, kotlin.reflect.jvm.internal.impl.metadata.deserialization.j, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.s, kotlin.reflect.jvm.internal.impl.descriptors.e1):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t
    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.h A() {
        return this.G;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.o0, kotlin.reflect.jvm.internal.impl.descriptors.impl.s
    @NotNull
    protected kotlin.reflect.jvm.internal.impl.descriptors.impl.s G0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k newOwner, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.y yVar, @NotNull CallableMemberDescriptor.Kind kind, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, @NotNull e1 source) {
        kotlin.reflect.jvm.internal.impl.name.f fVar2;
        kotlin.jvm.internal.g0.p(newOwner, "newOwner");
        kotlin.jvm.internal.g0.p(kind, "kind");
        kotlin.jvm.internal.g0.p(annotations, "annotations");
        kotlin.jvm.internal.g0.p(source, "source");
        d1 d1Var = (d1) yVar;
        if (fVar == null) {
            kotlin.reflect.jvm.internal.impl.name.f name = getName();
            kotlin.jvm.internal.g0.o(name, "getName(...)");
            fVar2 = name;
        } else {
            fVar2 = fVar;
        }
        o0 o0Var = new o0(newOwner, d1Var, annotations, fVar2, kind, K(), a0(), A(), l1(), b0(), source);
        o0Var.T0(L0());
        return o0Var;
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
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public ProtoBuf.Function K() {
        return this.E;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.j l1() {
        return this.H;
    }
}
