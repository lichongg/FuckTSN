package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: D:\Downloads\app\classes8.dex */
class s0 implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final v0 f47059a;

    /* renamed from: b, reason: collision with root package name */
    private final ProtoBuf.Type f47060b;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        List r5;
        r5 = v0.r(this.f47059a, this.f47060b);
        return r5;
    }

    public s0(v0 v0Var, ProtoBuf.Type type) {
        this.f47059a = v0Var;
        this.f47060b = type;
    }
}
