package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.functions.Function1;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f47123a = a.f47124a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f47124a = new a();

        @NotNull
        public final d a(@Nullable Runnable runnable, @Nullable Function1<? super InterruptedException, n1> function1) {
            return (runnable == null || function1 == null) ? new d(null, 1, null) : new c(runnable, function1);
        }

        private a() {
        }
    }

    void lock();

    void unlock();
}
