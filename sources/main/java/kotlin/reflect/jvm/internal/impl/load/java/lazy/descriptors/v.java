package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;

/* loaded from: D:\Downloads\app\classes8.dex */
class v implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final d1 f45651a;

    /* renamed from: b, reason: collision with root package name */
    private final z f45652b;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        Collection h12;
        h12 = z.h1(this.f45651a, this.f45652b, (kotlin.reflect.jvm.internal.impl.name.f) obj);
        return h12;
    }

    public v(d1 d1Var, z zVar) {
        this.f45651a = d1Var;
        this.f45652b = zVar;
    }
}
