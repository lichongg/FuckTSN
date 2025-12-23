package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private int f45298a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<d> f45299b;

    public t(int i6) {
        this.f45298a = i6;
        this.f45299b = new ArrayList(0);
    }

    @NotNull
    public final List<d> a() {
        return this.f45299b;
    }

    public final int b() {
        return this.f45298a;
    }

    public final void c(int i6) {
        this.f45298a = i6;
    }

    public t() {
        this(0);
    }
}
