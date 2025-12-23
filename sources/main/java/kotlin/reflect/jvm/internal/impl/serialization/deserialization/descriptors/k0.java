package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w;

/* loaded from: D:\Downloads\app\classes8.dex */
class k0 implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final w.c f46855a;

    /* renamed from: b, reason: collision with root package name */
    private final w f46856b;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        Set p5;
        p5 = w.c.p(this.f46855a, this.f46856b);
        return p5;
    }

    public k0(w.c cVar, w wVar) {
        this.f46855a = cVar;
        this.f46856b = wVar;
    }
}
