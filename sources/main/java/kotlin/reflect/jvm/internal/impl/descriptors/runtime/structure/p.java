package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class p implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final q f45025a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        boolean O;
        O = q.O(this.f45025a, (Method) obj);
        return Boolean.valueOf(O);
    }

    public p(q qVar) {
        this.f45025a = qVar;
    }
}
