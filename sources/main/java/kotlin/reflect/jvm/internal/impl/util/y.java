package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class y implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final z f47465a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        int g6;
        g6 = z.g(this.f47465a, (String) obj);
        return Integer.valueOf(g6);
    }

    public y(z zVar) {
        this.f47465a = zVar;
    }
}
