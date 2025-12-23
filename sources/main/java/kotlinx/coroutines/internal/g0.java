package kotlinx.coroutines.internal;

import java.util.List;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.p2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@InternalCoroutinesApi
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g0 implements c0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g0 f49265a = new g0();

    @Override // kotlinx.coroutines.internal.c0
    public int a() {
        return -1;
    }

    @Override // kotlinx.coroutines.internal.c0
    @NotNull
    public p2 c(@NotNull List<? extends c0> list) {
        return new f0(null, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
    }

    private g0() {
    }

    @Override // kotlinx.coroutines.internal.c0
    @Nullable
    public String b() {
        return c0.a.a(this);
    }
}
