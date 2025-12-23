package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class b implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final n1 f45743a;

    /* renamed from: b, reason: collision with root package name */
    private final h[] f45744b;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        h e6;
        e6 = d.e(this.f45743a, this.f45744b, ((Number) obj).intValue());
        return e6;
    }

    public b(n1 n1Var, h[] hVarArr) {
        this.f45743a = n1Var;
        this.f45744b = hVarArr;
    }
}
