package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface p<T> extends kotlin.coroutines.e<T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public static /* synthetic */ boolean a(p pVar, Throwable th, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i6 & 1) != 0) {
                th = null;
            }
            return pVar.a(th);
        }

        public static /* synthetic */ Object b(p pVar, Object obj, Object obj2, int i6, Object obj3) {
            if (obj3 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
            }
            if ((i6 & 2) != 0) {
                obj2 = null;
            }
            return pVar.C(obj, obj2);
        }
    }

    @InternalCoroutinesApi
    void B(@NotNull Object obj);

    @InternalCoroutinesApi
    @Nullable
    Object C(T t5, @Nullable Object obj);

    void I(@NotNull Function1<? super Throwable, kotlin.n1> function1);

    @InternalCoroutinesApi
    @Nullable
    Object J(@NotNull Throwable th);

    @InternalCoroutinesApi
    @Nullable
    Object O(T t5, @Nullable Object obj, @Nullable Function1<? super Throwable, kotlin.n1> function1);

    @ExperimentalCoroutinesApi
    void P(@NotNull m0 m0Var, T t5);

    @InternalCoroutinesApi
    void Q();

    boolean a(@Nullable Throwable th);

    @ExperimentalCoroutinesApi
    void h(@NotNull m0 m0Var, @NotNull Throwable th);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    @ExperimentalCoroutinesApi
    void o(T t5, @Nullable Function1<? super Throwable, kotlin.n1> function1);
}
