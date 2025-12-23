package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: D:\Downloads\app\classes8.dex */
class c0 implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final j0 f46828a;

    /* renamed from: b, reason: collision with root package name */
    private final ProtoBuf.Property f46829b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n0 f46830c;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        kotlin.reflect.jvm.internal.impl.storage.j y5;
        y5 = j0.y(this.f46828a, this.f46829b, this.f46830c);
        return y5;
    }

    public c0(j0 j0Var, ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n0 n0Var) {
        this.f46828a = j0Var;
        this.f46829b = property;
        this.f46830c = n0Var;
    }
}
