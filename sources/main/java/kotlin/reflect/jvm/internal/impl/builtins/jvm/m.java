package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.Pair;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class m implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final t f44503a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g s5;
        s5 = t.s(this.f44503a, (Pair) obj);
        return s5;
    }

    public m(t tVar) {
        this.f44503a = tVar;
    }
}
