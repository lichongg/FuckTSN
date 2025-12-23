package kotlin.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.SinceKotlin;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.3")
@PublishedApi
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k<T> implements e<T>, kotlin.coroutines.jvm.internal.c {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f43779b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater<k<?>, Object> f43780c = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "result");

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final e<T> f43781a;

    @Nullable
    private volatile Object result;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }

        private static /* synthetic */ void a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(@NotNull e<? super T> delegate, @Nullable Object obj) {
        g0.p(delegate, "delegate");
        this.f43781a = delegate;
        this.result = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @PublishedApi
    @Nullable
    public final Object b() {
        Object obj = this.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
        if (obj == coroutineSingletons) {
            if (androidx.concurrent.futures.a.a(f43780c, this, coroutineSingletons, kotlin.coroutines.intrinsics.a.l())) {
                return kotlin.coroutines.intrinsics.a.l();
            }
            obj = this.result;
        }
        if (obj == CoroutineSingletons.RESUMED) {
            return kotlin.coroutines.intrinsics.a.l();
        }
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
        return obj;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public kotlin.coroutines.jvm.internal.c getCallerFrame() {
        e<T> eVar = this.f43781a;
        if (eVar instanceof kotlin.coroutines.jvm.internal.c) {
            return (kotlin.coroutines.jvm.internal.c) eVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.e
    @NotNull
    public i getContext() {
        return this.f43781a.getContext();
    }

    @Override // kotlin.coroutines.e
    public void resumeWith(@NotNull Object obj) {
        while (true) {
            Object obj2 = this.result;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
            if (obj2 == coroutineSingletons) {
                if (androidx.concurrent.futures.a.a(f43780c, this, coroutineSingletons, obj)) {
                    return;
                }
            } else {
                if (obj2 != kotlin.coroutines.intrinsics.a.l()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (androidx.concurrent.futures.a.a(f43780c, this, kotlin.coroutines.intrinsics.a.l(), CoroutineSingletons.RESUMED)) {
                    this.f43781a.resumeWith(obj);
                    return;
                }
            }
        }
    }

    @NotNull
    public String toString() {
        return "SafeContinuation for " + this.f43781a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @PublishedApi
    public k(@NotNull e<? super T> delegate) {
        this(delegate, CoroutineSingletons.UNDECIDED);
        g0.p(delegate, "delegate");
    }
}
