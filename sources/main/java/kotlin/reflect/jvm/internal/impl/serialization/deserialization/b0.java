package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: D:\Downloads\app\classes8.dex */
class b0 implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final j0 f46816a;

    /* renamed from: b, reason: collision with root package name */
    private final ProtoBuf.Property f46817b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n0 f46818c;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        kotlin.reflect.jvm.internal.impl.storage.j w5;
        w5 = j0.w(this.f46816a, this.f46817b, this.f46818c);
        return w5;
    }

    public b0(j0 j0Var, ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n0 n0Var) {
        this.f46816a = j0Var;
        this.f46817b = property;
        this.f46818c = n0Var;
    }
}
