package kotlinx.coroutines;

import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @Nullable
    public final Object f48562a;

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public final Function1<Throwable, kotlin.n1> f48563b;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return kotlin.jvm.internal.g0.g(this.f48562a, e0Var.f48562a) && kotlin.jvm.internal.g0.g(this.f48563b, e0Var.f48563b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ e0 d(e0 e0Var, Object obj, Function1 function1, int i6, Object obj2) {
        if ((i6 & 1) != 0) {
            obj = e0Var.f48562a;
        }
        if ((i6 & 2) != 0) {
            function1 = e0Var.f48563b;
        }
        return e0Var.c(obj, function1);
    }

    @Nullable
    public final Object a() {
        return this.f48562a;
    }

    @NotNull
    public final Function1<Throwable, kotlin.n1> b() {
        return this.f48563b;
    }

    @NotNull
    public final e0 c(@Nullable Object obj, @NotNull Function1<? super Throwable, kotlin.n1> function1) {
        return new e0(obj, function1);
    }

    public int hashCode() {
        Object obj = this.f48562a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f48563b.hashCode();
    }

    @NotNull
    public String toString() {
        return "CompletedWithCancellation(result=" + this.f48562a + ", onCancellation=" + this.f48563b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e0(@Nullable Object obj, @NotNull Function1<? super Throwable, kotlin.n1> function1) {
        this.f48562a = obj;
        this.f48563b = function1;
    }
}
