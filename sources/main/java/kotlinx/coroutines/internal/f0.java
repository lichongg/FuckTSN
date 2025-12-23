package kotlinx.coroutines.internal;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.j1;
import kotlinx.coroutines.p2;
import kotlinx.coroutines.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MissingMainCoroutineDispatcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class f0 extends p2 implements kotlinx.coroutines.z0 {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final Throwable f49258a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f49259b;

    public /* synthetic */ f0(Throwable th, String str, int i6, kotlin.jvm.internal.v vVar) {
        this(th, (i6 & 2) != 0 ? null : str);
    }

    public f0(@Nullable Throwable th, @Nullable String str) {
        this.f49258a = th;
        this.f49259b = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
    
        if (r1 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Void w() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f49258a
            if (r0 == 0) goto L36
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.f49259b
            if (r1 == 0) goto L25
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 != 0) goto L27
        L25:
            java.lang.String r1 = ""
        L27:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.f49258a
            r1.<init>(r0, r2)
            throw r1
        L36:
            kotlinx.coroutines.internal.e0.e()
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.f0.w():java.lang.Void");
    }

    @Override // kotlinx.coroutines.p2, kotlinx.coroutines.m0
    @NotNull
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.f49258a != null) {
            str = ", cause=" + this.f49258a;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }

    @Override // kotlinx.coroutines.m0
    public boolean isDispatchNeeded(@NotNull kotlin.coroutines.i iVar) {
        w();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.p2, kotlinx.coroutines.m0
    @NotNull
    public kotlinx.coroutines.m0 limitedParallelism(int i6) {
        w();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.z0
    @NotNull
    public j1 m(long j6, @NotNull Runnable runnable, @NotNull kotlin.coroutines.i iVar) {
        w();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.z0
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @Nullable
    public Object r(long j6, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return z0.a.a(this, j6, eVar);
    }

    @Override // kotlinx.coroutines.m0
    @NotNull
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public Void dispatch(@NotNull kotlin.coroutines.i iVar, @NotNull Runnable runnable) {
        w();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.z0
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public Void i(long j6, @NotNull kotlinx.coroutines.p<? super n1> pVar) {
        w();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.p2
    @NotNull
    public p2 t() {
        return this;
    }
}
