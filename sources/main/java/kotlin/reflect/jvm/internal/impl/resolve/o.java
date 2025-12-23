package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.functions.Function1;
import kotlin.n1;

/* loaded from: D:\Downloads\app\classes8.dex */
class o implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.utils.k f46731a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        n1 c6;
        c6 = p.c(this.f46731a, obj);
        return c6;
    }

    public o(kotlin.reflect.jvm.internal.impl.utils.k kVar) {
        this.f46731a = kVar;
    }
}
