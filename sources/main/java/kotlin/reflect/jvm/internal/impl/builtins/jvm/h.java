package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;

/* loaded from: D:\Downloads\app\classes8.dex */
class h implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final JvmBuiltIns f44495a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.n f44496b;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        t J0;
        J0 = JvmBuiltIns.J0(this.f44495a, this.f44496b);
        return J0;
    }

    public h(JvmBuiltIns jvmBuiltIns, kotlin.reflect.jvm.internal.impl.storage.n nVar) {
        this.f44495a = jvmBuiltIns;
        this.f44496b = nVar;
    }
}
