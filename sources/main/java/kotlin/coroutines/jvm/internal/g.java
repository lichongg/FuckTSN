package kotlin.coroutines.jvm.internal;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.reflect.Method;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDebugMetadata.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/ModuleNameRetriever\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,158:1\n1#2:159\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f43772a = new g();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f43773b = new a(null, null, null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private static a f43774c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        @JvmField
        @Nullable
        public final Method f43775a;

        /* renamed from: b, reason: collision with root package name */
        @JvmField
        @Nullable
        public final Method f43776b;

        /* renamed from: c, reason: collision with root package name */
        @JvmField
        @Nullable
        public final Method f43777c;

        public a(@Nullable Method method, @Nullable Method method2, @Nullable Method method3) {
            this.f43775a = method;
            this.f43776b = method2;
            this.f43777c = method3;
        }
    }

    private final a a(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", null), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(CommonNetImpl.NAME, null));
            f43774c = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = f43773b;
            f43774c = aVar2;
            return aVar2;
        }
    }

    @Nullable
    public final String b(@NotNull BaseContinuationImpl continuation) {
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        g0.p(continuation, "continuation");
        a aVar = f43774c;
        if (aVar == null) {
            aVar = a(continuation);
        }
        if (aVar != f43773b && (method = aVar.f43775a) != null && (invoke = method.invoke(continuation.getClass(), null)) != null && (method2 = aVar.f43776b) != null && (invoke2 = method2.invoke(invoke, null)) != null) {
            Method method3 = aVar.f43777c;
            Object invoke3 = method3 != null ? method3.invoke(invoke2, null) : null;
            if (invoke3 instanceof String) {
                return (String) invoke3;
            }
        }
        return null;
    }

    private g() {
    }
}
