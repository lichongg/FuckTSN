package n4;

import android.annotation.SuppressLint;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import kotlin.Result;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.g0;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.misc.Signal;
import sun.misc.SignalHandler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"all"})
@IgnoreJRERequirement
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f50406a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f50407b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements ClassFileTransformer {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f50408a = new a();

        @Nullable
        public byte[] transform(@Nullable ClassLoader classLoader, @NotNull String str, @Nullable Class<?> cls, @NotNull ProtectionDomain protectionDomain, @Nullable byte[] bArr) {
            if (classLoader == null || !g0.g(str, "kotlin/coroutines/jvm/internal/DebugProbesKt")) {
                return null;
            }
            kotlinx.coroutines.debug.internal.a.f48497a.b(true);
            return kotlin.io.a.p(classLoader.getResourceAsStream("DebugProbesKt.bin"));
        }

        private a() {
        }
    }

    static {
        Object m130constructorimpl;
        try {
            Result.a aVar = Result.Companion;
            String property = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
            m130constructorimpl = Result.m130constructorimpl(property != null ? Boolean.valueOf(Boolean.parseBoolean(property)) : null);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m130constructorimpl = Result.m130constructorimpl(kotlin.g0.a(th));
        }
        Boolean bool = (Boolean) (Result.m136isFailureimpl(m130constructorimpl) ? null : m130constructorimpl);
        f50407b = bool != null ? bool.booleanValue() : DebugProbesImpl.f48479a.u();
    }

    private final void b() {
        try {
            Signal.handle(new Signal("TRAP"), new SignalHandler() { // from class: n4.a
                public final void a(Signal signal) {
                    b.c(signal);
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Signal signal) {
        DebugProbesImpl debugProbesImpl = DebugProbesImpl.f48479a;
        if (debugProbesImpl.A()) {
            debugProbesImpl.f(System.out);
        } else {
            System.out.getClass();
        }
    }

    @JvmStatic
    public static final void d(@Nullable String str, @NotNull Instrumentation instrumentation) {
        kotlinx.coroutines.debug.internal.a.f48497a.b(true);
        instrumentation.addTransformer(a.f50408a);
        DebugProbesImpl debugProbesImpl = DebugProbesImpl.f48479a;
        debugProbesImpl.L(f50407b);
        debugProbesImpl.y();
        f50406a.b();
    }

    private b() {
    }
}
