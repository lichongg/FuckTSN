package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;

/* loaded from: D:\Downloads\app\classes8.dex */
class i implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final f0 f44497a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f44498b;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        JvmBuiltIns.a O0;
        O0 = JvmBuiltIns.O0(this.f44497a, this.f44498b);
        return O0;
    }

    public i(f0 f0Var, boolean z5) {
        this.f44497a = f0Var;
        this.f44498b = z5;
    }
}
