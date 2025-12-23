package kotlinx.coroutines.internal;

import kotlin.Result;
import kotlin.jvm.internal.SourceDebugExtension;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFastServiceLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastServiceLoader.kt\nkotlinx/coroutines/internal/FastServiceLoaderKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,161:1\n1#2:162\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f49295a = false;

    public static final boolean a() {
        return true;
    }

    static {
        Object m130constructorimpl;
        try {
            Result.a aVar = Result.Companion;
            m130constructorimpl = Result.m130constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m130constructorimpl = Result.m130constructorimpl(kotlin.g0.a(th));
        }
        Result.m137isSuccessimpl(m130constructorimpl);
    }
}
