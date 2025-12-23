package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.v0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDeserializedTypeParameterDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedTypeParameterDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedTypeParameterDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,58:1\n1563#2:59\n1634#2,3:60\n*S KotlinDebug\n*F\n+ 1 DeserializedTypeParameterDescriptor.kt\norg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedTypeParameterDescriptor\n*L\n51#1:59\n51#1:60,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class r0 extends kotlin.reflect.jvm.internal.impl.descriptors.impl.b {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.o f46911k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private final ProtoBuf.TypeParameter f46912l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private final b f46913m;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public r0(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.o r12, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter r13, int r14) {
        /*
            r11 = this;
            java.lang.String r0 = "c"
            kotlin.jvm.internal.g0.p(r12, r0)
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.g0.p(r13, r0)
            kotlin.reflect.jvm.internal.impl.storage.n r2 = r12.h()
            kotlin.reflect.jvm.internal.impl.descriptors.k r3 = r12.e()
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g$a r0 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g r4 = r0.b()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.d r0 = r12.g()
            int r1 = r13.getName()
            kotlin.reflect.jvm.internal.impl.name.f r5 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.k0.b(r0, r1)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.n0 r0 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.n0.f47030a
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter$Variance r1 = r13.getVariance()
            java.lang.String r6 = "getVariance(...)"
            kotlin.jvm.internal.g0.o(r1, r6)
            kotlin.reflect.jvm.internal.impl.types.Variance r6 = r0.d(r1)
            boolean r7 = r13.getReified()
            kotlin.reflect.jvm.internal.impl.descriptors.e1 r9 = kotlin.reflect.jvm.internal.impl.descriptors.e1.f44683a
            kotlin.reflect.jvm.internal.impl.descriptors.h1$a r10 = kotlin.reflect.jvm.internal.impl.descriptors.h1.a.f44688a
            r1 = r11
            r8 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r1.f46911k = r12
            r1.f46912l = r13
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b r13 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b
            kotlin.reflect.jvm.internal.impl.storage.n r12 = r12.h()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.q0 r14 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.q0
            r14.<init>(r11)
            r13.<init>(r12, r14)
            r1.f46913m = r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.r0.<init>(kotlin.reflect.jvm.internal.impl.serialization.deserialization.o, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List I0(r0 r0Var) {
        return kotlin.collections.f0.a6(r0Var.f46911k.c().d().d(r0Var.f46912l, r0Var.f46911k.g()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.h
    @NotNull
    protected List<kotlin.reflect.jvm.internal.impl.types.t0> G0() {
        List<ProtoBuf.Type> t5 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.g.t(this.f46912l, this.f46911k.j());
        if (t5.isEmpty()) {
            return kotlin.collections.f0.l(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.m(this).z());
        }
        List<ProtoBuf.Type> list = t5;
        v0 i6 = this.f46911k.i();
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(i6.u((ProtoBuf.Type) it.next()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public b getAnnotations() {
        return this.f46913m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.h
    @NotNull
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public Void F0(@NotNull kotlin.reflect.jvm.internal.impl.types.t0 type) {
        kotlin.jvm.internal.g0.p(type, "type");
        throw new IllegalStateException("There should be no cycles for deserialized type parameters, but found for: " + this);
    }
}
