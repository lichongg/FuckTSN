package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: D:\Downloads\app\classes8.dex */
class i0 implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final j0 f46979a;

    /* renamed from: b, reason: collision with root package name */
    private final ProtoBuf.Property f46980b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n0 f46981c;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        kotlin.reflect.jvm.internal.impl.resolve.constants.g z5;
        z5 = j0.z(this.f46979a, this.f46980b, this.f46981c);
        return z5;
    }

    public i0(j0 j0Var, ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n0 n0Var) {
        this.f46979a = j0Var;
        this.f46980b = property;
        this.f46981c = n0Var;
    }
}
