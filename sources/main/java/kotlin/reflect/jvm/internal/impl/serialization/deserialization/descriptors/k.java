package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n;

/* loaded from: D:\Downloads\app\classes8.dex */
class k implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final List f46854a;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        List C;
        C = n.a.C(this.f46854a);
        return C;
    }

    public k(List list) {
        this.f46854a = list;
    }
}
