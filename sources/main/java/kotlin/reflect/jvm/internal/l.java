package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class l<V> extends ClassValue<SoftReference<V>> {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @NotNull
    public final Function1<Class<?>, V> f47515a;

    /* JADX WARN: Multi-variable type inference failed */
    public l(@NotNull Function1<? super Class<?>, ? extends V> compute) {
        kotlin.jvm.internal.g0.p(compute, "compute");
        this.f47515a = compute;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ClassValue
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SoftReference<V> computeValue(@NotNull Class<?> type) {
        kotlin.jvm.internal.g0.p(type, "type");
        return new SoftReference<>(this.f47515a.invoke(type));
    }

    @NotNull
    public final l<V> b() {
        return new l<>(this.f47515a);
    }
}
