package kotlinx.coroutines;

import kotlin.coroutines.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q0 extends kotlin.coroutines.a {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f49425b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f49426a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements i.c<q0> {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof q0) && kotlin.jvm.internal.g0.g(this.f49426a, ((q0) obj).f49426a);
    }

    public q0(@NotNull String str) {
        super(f49425b);
        this.f49426a = str;
    }

    public static /* synthetic */ q0 v(q0 q0Var, String str, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = q0Var.f49426a;
        }
        return q0Var.u(str);
    }

    public int hashCode() {
        return this.f49426a.hashCode();
    }

    @NotNull
    public final String t() {
        return this.f49426a;
    }

    @NotNull
    public String toString() {
        return "CoroutineName(" + this.f49426a + ')';
    }

    @NotNull
    public final q0 u(@NotNull String str) {
        return new q0(str);
    }

    @NotNull
    public final String w() {
        return this.f49426a;
    }
}
