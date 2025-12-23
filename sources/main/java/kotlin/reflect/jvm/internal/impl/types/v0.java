package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class v0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final w1 f47355a;

    /* renamed from: b, reason: collision with root package name */
    private final List f47356b;

    /* renamed from: c, reason: collision with root package name */
    private final t1 f47357c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f47358d;

    /* renamed from: e, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.k f47359e;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        e1 q5;
        q5 = w0.q(this.f47355a, this.f47356b, this.f47357c, this.f47358d, this.f47359e, (kotlin.reflect.jvm.internal.impl.types.checker.g) obj);
        return q5;
    }

    public v0(w1 w1Var, List list, t1 t1Var, boolean z5, kotlin.reflect.jvm.internal.impl.resolve.scopes.k kVar) {
        this.f47355a = w1Var;
        this.f47356b = list;
        this.f47357c = t1Var;
        this.f47358d = z5;
        this.f47359e = kVar;
    }
}
