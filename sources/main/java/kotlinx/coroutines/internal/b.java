package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@InternalCoroutinesApi
@SourceDebugExtension({"SMAP\nAtomic.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Atomic.kt\nkotlinx/coroutines/internal/AtomicOp\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class b<T> extends k0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f49241a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus");

    @Volatile
    @Nullable
    private volatile Object _consensus = a.f49215a;

    public abstract void c(T t5, @Nullable Object obj);

    @Nullable
    public abstract Object e(T t5);

    private final Object d(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49241a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        Object obj3 = a.f49215a;
        return obj2 != obj3 ? obj2 : androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj3, obj) ? obj : atomicReferenceFieldUpdater.get(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.k0
    @Nullable
    public final Object b(@Nullable Object obj) {
        Object obj2 = f49241a.get(this);
        if (obj2 == a.f49215a) {
            obj2 = d(e(obj));
        }
        c(obj, obj2);
        return obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.k0
    @NotNull
    public b<?> a() {
        return this;
    }
}
