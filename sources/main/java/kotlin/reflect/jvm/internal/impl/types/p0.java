package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class p0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final Function1 f47310a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        CharSequence q5;
        q5 = s0.q(this.f47310a, (t0) obj);
        return q5;
    }

    public p0(Function1 function1) {
        this.f47310a = function1;
    }
}
