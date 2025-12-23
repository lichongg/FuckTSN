package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.q;

/* loaded from: D:\Downloads\app\classes8.dex */
class k implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final q f47283a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        kotlin.n1 C;
        C = q.C(this.f47283a, (q.b) obj);
        return C;
    }

    public k(q qVar) {
        this.f47283a = qVar;
    }
}
