package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.reflect.jvm.internal.impl.types.checker.e;
import kotlin.reflect.jvm.internal.impl.types.w1;

/* loaded from: D:\Downloads\app\classes8.dex */
class e implements e.a {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f46702a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.a f46703b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.a f46704c;

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.e.a
    public boolean a(w1 w1Var, w1 w1Var2) {
        boolean h6;
        h6 = g.h(this.f46702a, this.f46703b, this.f46704c, w1Var, w1Var2);
        return h6;
    }

    public e(boolean z5, kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        this.f46702a = z5;
        this.f46703b = aVar;
        this.f46704c = aVar2;
    }
}
