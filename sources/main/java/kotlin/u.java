package kotlin;

import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class u {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f48057a;

        static {
            int[] iArr = new int[LazyThreadSafetyMode.values().length];
            try {
                iArr[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LazyThreadSafetyMode.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f48057a = iArr;
        }
    }

    @NotNull
    public static final <T> s<T> a(@Nullable Object obj, @NotNull Function0<? extends T> initializer) {
        kotlin.jvm.internal.g0.p(initializer, "initializer");
        return new m0(initializer, obj);
    }

    @NotNull
    public static <T> s<T> b(@NotNull LazyThreadSafetyMode mode, @NotNull Function0<? extends T> initializer) {
        kotlin.jvm.internal.g0.p(mode, "mode");
        kotlin.jvm.internal.g0.p(initializer, "initializer");
        int i6 = a.f48057a[mode.ordinal()];
        int i7 = 2;
        if (i6 == 1) {
            kotlin.jvm.internal.v vVar = null;
            return new m0(initializer, vVar, i7, vVar);
        }
        if (i6 == 2) {
            return new h0(initializer);
        }
        if (i6 == 3) {
            return new UnsafeLazyImpl(initializer);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static <T> s<T> c(@NotNull Function0<? extends T> initializer) {
        kotlin.jvm.internal.g0.p(initializer, "initializer");
        kotlin.jvm.internal.v vVar = null;
        return new m0(initializer, vVar, 2, vVar);
    }
}
