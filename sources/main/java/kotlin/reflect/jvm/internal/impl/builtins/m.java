package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;

/* loaded from: D:\Downloads\app\classes8.dex */
class m implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final f0 f44543a;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k f6;
        f6 = n.f(this.f44543a);
        return f6;
    }

    public m(f0 f0Var) {
        this.f44543a = f0Var;
    }
}
