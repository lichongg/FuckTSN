package kotlin.reflect.jvm.internal.impl.km.internal;

import kotlin.jvm.functions.Function1;
import kotlin.n1;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: D:\Downloads\app\classes8.dex */
class k implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final ProtoBuf.VersionRequirement.b f45204a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        n1 j6;
        j6 = l.j(this.f45204a, ((Number) obj).intValue());
        return j6;
    }

    public k(ProtoBuf.VersionRequirement.b bVar) {
        this.f45204a = bVar;
    }
}
