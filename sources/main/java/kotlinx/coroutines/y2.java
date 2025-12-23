package kotlinx.coroutines;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class y2 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n*L\n1#1,18:1\n*E\n"})
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<kotlin.n1> f49681a;

        public a(Function0<kotlin.n1> function0) {
            this.f49681a = function0;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f49681a.invoke();
        }
    }

    @NotNull
    public static final Runnable a(@NotNull Function0<kotlin.n1> function0) {
        return new a(function0);
    }
}
