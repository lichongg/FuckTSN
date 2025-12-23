package kotlin.jvm.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class n0<T> {

    /* renamed from: a, reason: collision with root package name */
    private final int f44027a;

    /* renamed from: b, reason: collision with root package name */
    private int f44028b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final T[] f44029c;

    protected abstract int c(@NotNull T t5);

    public final void a(@NotNull T spreadArgument) {
        g0.p(spreadArgument, "spreadArgument");
        T[] tArr = this.f44029c;
        int i6 = this.f44028b;
        this.f44028b = i6 + 1;
        tArr[i6] = spreadArgument;
    }

    protected final int b() {
        return this.f44028b;
    }

    protected final void e(int i6) {
        this.f44028b = i6;
    }

    protected final int f() {
        int i6 = this.f44027a - 1;
        int i7 = 0;
        if (i6 >= 0) {
            int i8 = 0;
            while (true) {
                T t5 = this.f44029c[i8];
                i7 += t5 != null ? c(t5) : 1;
                if (i8 == i6) {
                    break;
                }
                i8++;
            }
        }
        return i7;
    }

    @NotNull
    protected final T g(@NotNull T values, @NotNull T result) {
        int i6;
        g0.p(values, "values");
        g0.p(result, "result");
        int i7 = this.f44027a - 1;
        int i8 = 0;
        if (i7 >= 0) {
            int i9 = 0;
            int i10 = 0;
            i6 = 0;
            while (true) {
                T t5 = this.f44029c[i9];
                if (t5 != null) {
                    if (i10 < i9) {
                        int i11 = i9 - i10;
                        System.arraycopy(values, i10, result, i6, i11);
                        i6 += i11;
                    }
                    int c6 = c(t5);
                    System.arraycopy(t5, 0, result, i6, c6);
                    i6 += c6;
                    i10 = i9 + 1;
                }
                if (i9 == i7) {
                    break;
                }
                i9++;
            }
            i8 = i10;
        } else {
            i6 = 0;
        }
        int i12 = this.f44027a;
        if (i8 < i12) {
            System.arraycopy(values, i8, result, i6, i12 - i8);
        }
        return result;
    }

    public n0(int i6) {
        this.f44027a = i6;
        this.f44029c = (T[]) new Object[i6];
    }

    private static /* synthetic */ void d() {
    }
}
