package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\Downloads\app\classes8.dex */
class y2 implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final z2 f47621a;

    /* renamed from: b, reason: collision with root package name */
    private final int f47622b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.s f47623c;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        Type s5;
        s5 = z2.s(this.f47621a, this.f47622b, this.f47623c);
        return s5;
    }

    public y2(z2 z2Var, int i6, kotlin.s sVar) {
        this.f47621a = z2Var;
        this.f47622b = i6;
        this.f47623c = sVar;
    }
}
