package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.e1;

/* loaded from: D:\Downloads\app\classes8.dex */
class f implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final g f44707a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        e1 I0;
        I0 = g.I0(this.f44707a, (kotlin.reflect.jvm.internal.impl.types.checker.g) obj);
        return I0;
    }

    public f(g gVar) {
        this.f44707a = gVar;
    }
}
