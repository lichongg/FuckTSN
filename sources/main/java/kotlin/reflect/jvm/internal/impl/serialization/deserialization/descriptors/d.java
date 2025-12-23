package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d extends kotlin.reflect.jvm.internal.impl.descriptors.impl.i implements c {

    @NotNull
    private final ProtoBuf.Constructor G;

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.d H;

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.h I;

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.j J;

    @Nullable
    private final s K;

    public /* synthetic */ d(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, kotlin.reflect.jvm.internal.impl.descriptors.j jVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, boolean z5, CallableMemberDescriptor.Kind kind, ProtoBuf.Constructor constructor, kotlin.reflect.jvm.internal.impl.metadata.deserialization.d dVar2, kotlin.reflect.jvm.internal.impl.metadata.deserialization.h hVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.j jVar2, s sVar, e1 e1Var, int i6, kotlin.jvm.internal.v vVar) {
        this(dVar, jVar, gVar, z5, kind, constructor, dVar2, hVar, jVar2, sVar, (i6 & 1024) != 0 ? null : e1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isSuspend() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean y() {
        return false;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public d(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.d r12, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.descriptors.j r13, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g r14, boolean r15, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind r16, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor r17, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d r18, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h r19, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.j r20, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.s r21, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.descriptors.e1 r22) {
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
            if (r22 != 0) goto L38
            kotlin.reflect.jvm.internal.impl.descriptors.e1 r0 = kotlin.reflect.jvm.internal.impl.descriptors.e1.f44683a
            r6 = r0
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r0 = r11
            goto L3f
        L38:
            r6 = r22
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
        L3f:
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r11.G = r7
            r11.H = r8
            r11.I = r9
            r11.J = r10
            r1 = r21
            r11.K = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d.<init>(kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.j, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g, boolean, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor, kotlin.reflect.jvm.internal.impl.metadata.deserialization.d, kotlin.reflect.jvm.internal.impl.metadata.deserialization.h, kotlin.reflect.jvm.internal.impl.metadata.deserialization.j, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.s, kotlin.reflect.jvm.internal.impl.descriptors.e1):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t
    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.h A() {
        return this.I;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t
    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.d a0() {
        return this.H;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t
    @Nullable
    public s b0() {
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.i
    @NotNull
    /* renamed from: n1, reason: merged with bridge method [inline-methods] */
    public d G0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k newOwner, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.y yVar, @NotNull CallableMemberDescriptor.Kind kind, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, @NotNull e1 source) {
        kotlin.jvm.internal.g0.p(newOwner, "newOwner");
        kotlin.jvm.internal.g0.p(kind, "kind");
        kotlin.jvm.internal.g0.p(annotations, "annotations");
        kotlin.jvm.internal.g0.p(source, "source");
        d dVar = new d((kotlin.reflect.jvm.internal.impl.descriptors.d) newOwner, (kotlin.reflect.jvm.internal.impl.descriptors.j) yVar, annotations, this.E, kind, K(), a0(), A(), p1(), b0(), source);
        dVar.T0(L0());
        return dVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t
    @NotNull
    /* renamed from: o1, reason: merged with bridge method [inline-methods] */
    public ProtoBuf.Constructor K() {
        return this.G;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.j p1() {
        return this.J;
    }
}
