package kotlin.reflect.jvm.internal.calls;

import java.util.Map;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\Downloads\app\classes8.dex */
class a implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final Map f44279a;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        int j6;
        j6 = e.j(this.f44279a);
        return Integer.valueOf(j6);
    }

    public a(Map map) {
        this.f44279a = map;
    }
}
