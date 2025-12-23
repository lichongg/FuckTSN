package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class x implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final z f45656a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        Collection C0;
        C0 = z.C0(this.f45656a, (kotlin.reflect.jvm.internal.impl.name.f) obj);
        return C0;
    }

    public x(z zVar) {
        this.f45656a = zVar;
    }
}
