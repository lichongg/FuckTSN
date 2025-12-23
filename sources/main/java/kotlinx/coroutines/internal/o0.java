package kotlinx.coroutines.internal;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class o0<T> extends kotlinx.coroutines.a<T> implements kotlin.coroutines.jvm.internal.c {

    /* renamed from: d, reason: collision with root package name */
    @JvmField
    @NotNull
    public final kotlin.coroutines.e<T> f49294d;

    /* JADX WARN: Multi-variable type inference failed */
    public o0(@NotNull kotlin.coroutines.i iVar, @NotNull kotlin.coroutines.e<? super T> eVar) {
        super(iVar, true, true);
        this.f49294d = eVar;
    }

    @Override // kotlinx.coroutines.l2
    protected final boolean N0() {
        return true;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.l2
    protected void e0(@Nullable Object obj) {
        m.e(kotlin.coroutines.intrinsics.a.e(this.f49294d), kotlinx.coroutines.i0.a(obj, this.f49294d), null, 2, null);
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public final kotlin.coroutines.jvm.internal.c getCallerFrame() {
        kotlin.coroutines.e<T> eVar = this.f49294d;
        if (eVar instanceof kotlin.coroutines.jvm.internal.c) {
            return (kotlin.coroutines.jvm.internal.c) eVar;
        }
        return null;
    }

    @Override // kotlinx.coroutines.a
    protected void v1(@Nullable Object obj) {
        kotlin.coroutines.e<T> eVar = this.f49294d;
        eVar.resumeWith(kotlinx.coroutines.i0.a(obj, eVar));
    }
}
