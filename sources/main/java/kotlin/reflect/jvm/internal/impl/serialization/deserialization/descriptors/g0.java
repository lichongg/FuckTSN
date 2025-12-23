package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w;

/* loaded from: D:\Downloads\app\classes8.dex */
class g0 implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final w.b f46846a;

    /* renamed from: b, reason: collision with root package name */
    private final w f46847b;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        Set P;
        P = w.b.P(this.f46846a, this.f46847b);
        return P;
    }

    public g0(w.b bVar, w wVar) {
        this.f46846a = bVar;
        this.f46847b = wVar;
    }
}
