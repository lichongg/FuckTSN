package kotlin.reflect.jvm.internal.calls;

import java.util.Map;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\Downloads\app\classes8.dex */
class b implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final Class f44280a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f44281b;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        String l6;
        l6 = e.l(this.f44280a, this.f44281b);
        return l6;
    }

    public b(Class cls, Map map) {
        this.f44280a = cls;
        this.f44281b = map;
    }
}
