package kotlin.reflect.jvm.internal.impl.km.internal;

import kotlin.jvm.functions.Function1;
import kotlin.n1;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: D:\Downloads\app\classes8.dex */
class j implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final ProtoBuf.VersionRequirement.b f45203a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        n1 i6;
        i6 = l.i(this.f45203a, ((Number) obj).intValue());
        return i6;
    }

    public j(ProtoBuf.VersionRequirement.b bVar) {
        this.f45203a = bVar;
    }
}
