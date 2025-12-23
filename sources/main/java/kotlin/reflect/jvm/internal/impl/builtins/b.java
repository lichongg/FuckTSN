package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ServiceLoader;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.m0;
import kotlin.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f44399a = a.f44400a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f44400a = new a();

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private static final s<b> f44401b = t.b(LazyThreadSafetyMode.PUBLICATION, kotlin.reflect.jvm.internal.impl.builtins.a.f44398a);

        /* JADX INFO: Access modifiers changed from: private */
        public static final b a() {
            ServiceLoader load = ServiceLoader.load(b.class, b.class.getClassLoader());
            g0.m(load);
            b bVar = (b) f0.J2(load);
            if (bVar != null) {
                return bVar;
            }
            throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
        }

        @NotNull
        public final b c() {
            return f44401b.getValue();
        }

        private a() {
        }
    }

    @NotNull
    m0 a(@NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 f0Var, @NotNull Iterable<? extends r3.b> iterable, @NotNull r3.c cVar, @NotNull r3.a aVar, boolean z5);
}
