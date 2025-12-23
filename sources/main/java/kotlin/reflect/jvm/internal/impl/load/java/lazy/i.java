package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.d0;
import y3.u;

/* loaded from: D:\Downloads\app\classes8.dex */
class i implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final j f45681a;

    /* renamed from: b, reason: collision with root package name */
    private final u f45682b;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        d0 f6;
        f6 = j.f(this.f45681a, this.f45682b);
        return f6;
    }

    public i(j jVar, u uVar) {
        this.f45681a = jVar;
        this.f45682b = uVar;
    }
}
