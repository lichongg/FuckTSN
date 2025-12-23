package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w;

/* loaded from: D:\Downloads\app\classes8.dex */
class f0 implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final w.b f46843a;

    /* renamed from: b, reason: collision with root package name */
    private final w f46844b;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        Set D;
        D = w.b.D(this.f46843a, this.f46844b);
        return D;
    }

    public f0(w.b bVar, w wVar) {
        this.f46843a = bVar;
        this.f46844b = wVar;
    }
}
