package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: D:\Downloads\app\classes8.dex */
class e0 implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final j0 f46957a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f46958b;

    /* renamed from: c, reason: collision with root package name */
    private final ProtoBuf.Property f46959c;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        List n6;
        n6 = j0.n(this.f46957a, this.f46958b, this.f46959c);
        return n6;
    }

    public e0(j0 j0Var, boolean z5, ProtoBuf.Property property) {
        this.f46957a = j0Var;
        this.f46958b = z5;
        this.f46959c = property;
    }
}
