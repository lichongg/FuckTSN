package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class u0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final w1 f47348a;

    /* renamed from: b, reason: collision with root package name */
    private final List f47349b;

    /* renamed from: c, reason: collision with root package name */
    private final t1 f47350c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f47351d;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        e1 n6;
        n6 = w0.n(this.f47348a, this.f47349b, this.f47350c, this.f47351d, (kotlin.reflect.jvm.internal.impl.types.checker.g) obj);
        return n6;
    }

    public u0(w1 w1Var, List list, t1 t1Var, boolean z5) {
        this.f47348a = w1Var;
        this.f47349b = list;
        this.f47350c = t1Var;
        this.f47351d = z5;
    }
}
