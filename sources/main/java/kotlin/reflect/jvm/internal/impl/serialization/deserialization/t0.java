package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: D:\Downloads\app\classes8.dex */
class t0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final v0 f47067a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        ProtoBuf.Type z5;
        z5 = v0.z(this.f47067a, (ProtoBuf.Type) obj);
        return z5;
    }

    public t0(v0 v0Var) {
        this.f47067a = v0Var;
    }
}
