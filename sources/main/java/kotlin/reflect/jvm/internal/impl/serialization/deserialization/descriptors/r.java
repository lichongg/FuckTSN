package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n;

/* loaded from: D:\Downloads\app\classes8.dex */
class r implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final n f46909a;

    /* renamed from: b, reason: collision with root package name */
    private final ProtoBuf.EnumEntry f46910b;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        List g6;
        g6 = n.c.g(this.f46909a, this.f46910b);
        return g6;
    }

    public r(n nVar, ProtoBuf.EnumEntry enumEntry) {
        this.f46909a = nVar;
        this.f46910b = enumEntry;
    }
}
