package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class l implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.c f44665a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        c e6;
        e6 = n.e(this.f44665a, (g) obj);
        return e6;
    }

    public l(kotlin.reflect.jvm.internal.impl.name.c cVar) {
        this.f44665a = cVar;
    }
}
