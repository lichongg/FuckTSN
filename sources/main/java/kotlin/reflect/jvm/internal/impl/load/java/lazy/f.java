package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class f implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final g f45676a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c d6;
        d6 = g.d(this.f45676a, (y3.a) obj);
        return d6;
    }

    public f(g gVar) {
        this.f45676a = gVar;
    }
}
