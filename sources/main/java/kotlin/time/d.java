package kotlin.time;

import kotlin.time.d0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class d implements d0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final d0 f47998a;

    /* renamed from: b, reason: collision with root package name */
    private final long f47999b;

    public /* synthetic */ d(d0 d0Var, long j6, kotlin.jvm.internal.v vVar) {
        this(d0Var, j6);
    }

    private d(d0 mark, long j6) {
        kotlin.jvm.internal.g0.p(mark, "mark");
        this.f47998a = mark;
        this.f47999b = j6;
    }

    @Override // kotlin.time.d0
    public long a() {
        return h.X(this.f47998a.a(), this.f47999b);
    }

    public final long d() {
        return this.f47999b;
    }

    @Override // kotlin.time.d0
    @NotNull
    public d0 e(long j6) {
        return new d(this.f47998a, h.Y(this.f47999b, j6), null);
    }

    @NotNull
    public final d0 h() {
        return this.f47998a;
    }

    @Override // kotlin.time.d0
    public /* bridge */ boolean b() {
        return d0.a.a(this);
    }

    @Override // kotlin.time.d0
    public /* bridge */ boolean c() {
        return d0.a.b(this);
    }

    @Override // kotlin.time.d0
    @NotNull
    public /* bridge */ d0 f(long j6) {
        return d0.a.c(this, j6);
    }
}
