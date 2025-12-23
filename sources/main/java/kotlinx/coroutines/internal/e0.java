package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.p2;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatchersKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final String f49250a = "kotlinx.coroutines.fast.service.loader";

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f49251b = false;

    private static final f0 a(Throwable th, String str) {
        if (th != null) {
            throw th;
        }
        e();
        throw new KotlinNothingValueException();
    }

    static /* synthetic */ f0 b(Throwable th, String str, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            th = null;
        }
        if ((i6 & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    @NotNull
    public static final Void e() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    @InternalCoroutinesApi
    public static final boolean d(@NotNull p2 p2Var) {
        return p2Var.t() instanceof f0;
    }

    @InternalCoroutinesApi
    @NotNull
    public static final p2 f(@NotNull c0 c0Var, @NotNull List<? extends c0> list) {
        try {
            return c0Var.c(list);
        } catch (Throwable th) {
            return a(th, c0Var.b());
        }
    }

    private static /* synthetic */ void c() {
    }
}
