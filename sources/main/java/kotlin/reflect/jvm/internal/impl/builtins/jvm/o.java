package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class o implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.f f44505a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        Collection x5;
        x5 = t.x(this.f44505a, (kotlin.reflect.jvm.internal.impl.resolve.scopes.k) obj);
        return x5;
    }

    public o(kotlin.reflect.jvm.internal.impl.name.f fVar) {
        this.f44505a = fVar;
    }
}
