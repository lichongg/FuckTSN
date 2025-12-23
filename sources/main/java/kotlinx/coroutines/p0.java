package kotlinx.coroutines;

import kotlin.PublishedApi;
import kotlin.coroutines.i;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@PublishedApi
@IgnoreJRERequirement
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p0 extends kotlin.coroutines.a implements e3<String> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f49417b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final long f49418a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements i.c<p0> {
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
        return (obj instanceof p0) && this.f49418a == ((p0) obj).f49418a;
    }

    public p0(long j6) {
        super(f49417b);
        this.f49418a = j6;
    }

    public static /* synthetic */ p0 v(p0 p0Var, long j6, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            j6 = p0Var.f49418a;
        }
        return p0Var.u(j6);
    }

    public int hashCode() {
        return androidx.camera.camera2.internal.compat.params.e.a(this.f49418a);
    }

    public final long t() {
        return this.f49418a;
    }

    @NotNull
    public String toString() {
        return "CoroutineId(" + this.f49418a + ')';
    }

    @NotNull
    public final p0 u(long j6) {
        return new p0(j6);
    }

    public final long w() {
        return this.f49418a;
    }

    @Override // kotlinx.coroutines.e3
    @NotNull
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public String U(@NotNull kotlin.coroutines.i iVar) {
        String str;
        q0 q0Var = (q0) iVar.get(q0.f49425b);
        if (q0Var == null || (str = q0Var.w()) == null) {
            str = "coroutine";
        }
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        int W3 = kotlin.text.u.W3(name, " @", 0, false, 6, null);
        if (W3 < 0) {
            W3 = name.length();
        }
        StringBuilder sb = new StringBuilder(str.length() + W3 + 10);
        String substring = name.substring(0, W3);
        kotlin.jvm.internal.g0.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb.append(substring);
        sb.append(" @");
        sb.append(str);
        sb.append('#');
        sb.append(this.f49418a);
        String sb2 = sb.toString();
        kotlin.jvm.internal.g0.o(sb2, "StringBuilder(capacity).…builderAction).toString()");
        currentThread.setName(sb2);
        return name;
    }

    @Override // kotlinx.coroutines.e3
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void n(@NotNull kotlin.coroutines.i iVar, @NotNull String str) {
        Thread.currentThread().setName(str);
    }
}
