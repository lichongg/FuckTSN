package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: D:\Downloads\app\classes8.dex */
class h0 implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final j0 f46976a;

    /* renamed from: b, reason: collision with root package name */
    private final ProtoBuf.Property f46977b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n0 f46978c;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        kotlin.reflect.jvm.internal.impl.resolve.constants.g x5;
        x5 = j0.x(this.f46976a, this.f46977b, this.f46978c);
        return x5;
    }

    public h0(j0 j0Var, ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n0 n0Var) {
        this.f46976a = j0Var;
        this.f46977b = property;
        this.f46978c = n0Var;
    }
}
