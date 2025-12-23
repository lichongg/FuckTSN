package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w;

/* loaded from: D:\Downloads\app\classes8.dex */
class h0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final w.c f46849a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        Collection q5;
        q5 = w.c.q(this.f46849a, (kotlin.reflect.jvm.internal.impl.name.f) obj);
        return q5;
    }

    public h0(w.c cVar) {
        this.f46849a = cVar;
    }
}
