package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.List;
import kotlin.contracts.ExperimentalContracts;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ExperimentalContracts
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private int f45252a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private Integer f45253b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private i f45254c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private u f45255d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final List<n> f45256e = new ArrayList(0);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final List<n> f45257f = new ArrayList(0);

    @NotNull
    public final List<n> a() {
        return this.f45256e;
    }

    public final int b() {
        return this.f45252a;
    }

    @NotNull
    public final List<n> c() {
        return this.f45257f;
    }

    public final void d(@Nullable i iVar) {
        this.f45254c = iVar;
    }

    public final void e(int i6) {
        this.f45252a = i6;
    }

    public final void f(@Nullable u uVar) {
        this.f45255d = uVar;
    }

    public final void g(@Nullable Integer num) {
        this.f45253b = num;
    }
}
