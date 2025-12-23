package kotlinx.coroutines.internal;

import kotlin.jvm.functions.Function1;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@IgnoreJRERequirement
/* loaded from: D:\Downloads\app\classes8.dex */
final class d extends k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f49244a = new d();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f49245b = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends ClassValue<Function1<? super Throwable, ? extends Throwable>> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ClassValue
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Function1<Throwable, Throwable> computeValue(@Nullable Class<?> cls) {
            Function1<Throwable, Throwable> b6;
            kotlin.jvm.internal.g0.n(cls, "null cannot be cast to non-null type java.lang.Class<out kotlin.Throwable>");
            b6 = n.b(cls);
            return b6;
        }

        a() {
        }
    }

    @Override // kotlinx.coroutines.internal.k
    @NotNull
    public Function1<Throwable, Throwable> a(@NotNull Class<? extends Throwable> cls) {
        Object obj;
        obj = f49245b.get(cls);
        return (Function1) obj;
    }

    private d() {
    }
}
