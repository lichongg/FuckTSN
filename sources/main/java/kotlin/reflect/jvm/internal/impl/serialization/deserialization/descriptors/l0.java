package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w;

/* loaded from: D:\Downloads\app\classes8.dex */
class l0 implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final w.c f46858a;

    /* renamed from: b, reason: collision with root package name */
    private final w f46859b;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        Set u5;
        u5 = w.c.u(this.f46858a, this.f46859b);
        return u5;
    }

    public l0(w.c cVar, w wVar) {
        this.f46858a = cVar;
        this.f46859b = wVar;
    }
}
