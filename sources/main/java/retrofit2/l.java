package retrofit2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private final Method f52151a;

    /* renamed from: b, reason: collision with root package name */
    private final List<?> f52152b;

    public static l c(Method method, List<?> list) {
        Objects.requireNonNull(method, "method == null");
        Objects.requireNonNull(list, "arguments == null");
        return new l(method, new ArrayList(list));
    }

    public List<?> a() {
        return this.f52152b;
    }

    public Method b() {
        return this.f52151a;
    }

    public String toString() {
        return String.format("%s.%s() %s", this.f52151a.getDeclaringClass().getName(), this.f52151a.getName(), this.f52152b);
    }

    l(Method method, List<?> list) {
        this.f52151a = method;
        this.f52152b = Collections.unmodifiableList(list);
    }
}
