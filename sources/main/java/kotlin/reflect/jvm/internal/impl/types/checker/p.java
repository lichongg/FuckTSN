package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface p extends e {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f47188b = a.f47189a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f47189a = new a();

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private static final q f47190b = new q(g.a.f47170a, null, 2, 0 == true ? 1 : 0);

        @NotNull
        public final q a() {
            return f47190b;
        }

        private a() {
        }
    }

    @NotNull
    OverridingUtil b();

    @NotNull
    g c();
}
