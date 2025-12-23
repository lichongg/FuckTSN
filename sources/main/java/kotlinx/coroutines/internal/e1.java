package kotlinx.coroutines.internal;

import kotlin.jvm.JvmField;
import kotlinx.coroutines.e3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class e1 {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @NotNull
    public final kotlin.coroutines.i f49252a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Object[] f49253b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final e3<Object>[] f49254c;

    /* renamed from: d, reason: collision with root package name */
    private int f49255d;

    public final void a(@NotNull e3<?> e3Var, @Nullable Object obj) {
        Object[] objArr = this.f49253b;
        int i6 = this.f49255d;
        objArr[i6] = obj;
        e3<Object>[] e3VarArr = this.f49254c;
        this.f49255d = i6 + 1;
        kotlin.jvm.internal.g0.n(e3Var, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        e3VarArr[i6] = e3Var;
    }

    public final void b(@NotNull kotlin.coroutines.i iVar) {
        int length = this.f49254c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i6 = length - 1;
            e3<Object> e3Var = this.f49254c[length];
            kotlin.jvm.internal.g0.m(e3Var);
            e3Var.n(iVar, this.f49253b[length]);
            if (i6 < 0) {
                return;
            } else {
                length = i6;
            }
        }
    }

    public e1(@NotNull kotlin.coroutines.i iVar, int i6) {
        this.f49252a = iVar;
        this.f49253b = new Object[i6];
        this.f49254c = new e3[i6];
    }
}
