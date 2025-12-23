package kotlinx.coroutines;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    @InternalCoroutinesApi
    public final <T> void invoke(@NotNull Function1<? super kotlin.coroutines.e<? super T>, ? extends Object> function1, @NotNull kotlin.coroutines.e<? super T> eVar) {
        int i6 = a.f48078a[ordinal()];
        if (i6 == 1) {
            o4.a.d(function1, eVar);
            return;
        }
        if (i6 == 2) {
            kotlin.coroutines.g.h(function1, eVar);
        } else if (i6 == 3) {
            o4.b.a(function1, eVar);
        } else if (i6 != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f48078a;

        static {
            int[] iArr = new int[CoroutineStart.values().length];
            try {
                iArr[CoroutineStart.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CoroutineStart.ATOMIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CoroutineStart.LAZY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f48078a = iArr;
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }

    @InternalCoroutinesApi
    public final <R, T> void invoke(@NotNull Function2<? super R, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2, R r5, @NotNull kotlin.coroutines.e<? super T> eVar) {
        int i6 = a.f48078a[ordinal()];
        if (i6 == 1) {
            o4.a.f(function2, r5, eVar, null, 4, null);
            return;
        }
        if (i6 == 2) {
            kotlin.coroutines.g.i(function2, r5, eVar);
        } else if (i6 == 3) {
            o4.b.b(function2, r5, eVar);
        } else if (i6 != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void isLazy$annotations() {
    }
}
