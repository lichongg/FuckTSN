package kotlinx.coroutines.flow;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class f<T> extends kotlinx.coroutines.flow.internal.d<T> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final Function2<kotlinx.coroutines.channels.z<? super T>, kotlin.coroutines.e<? super n1>, Object> f48863d;

    public /* synthetic */ f(Function2 function2, kotlin.coroutines.i iVar, int i6, BufferOverflow bufferOverflow, int i7, kotlin.jvm.internal.v vVar) {
        this(function2, (i7 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : iVar, (i7 & 4) != 0 ? -2 : i6, (i7 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    static /* synthetic */ <T> Object n(f<T> fVar, kotlinx.coroutines.channels.z<? super T> zVar, kotlin.coroutines.e<? super n1> eVar) {
        Object invoke = ((f) fVar).f48863d.invoke(zVar, eVar);
        return invoke == kotlin.coroutines.intrinsics.a.l() ? invoke : n1.f44123a;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    @NotNull
    protected kotlinx.coroutines.flow.internal.d<T> i(@NotNull kotlin.coroutines.i iVar, int i6, @NotNull BufferOverflow bufferOverflow) {
        return new f(this.f48863d, iVar, i6, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.d
    @NotNull
    public String toString() {
        return "block[" + this.f48863d + "] -> " + super.toString();
    }

    @Override // kotlinx.coroutines.flow.internal.d
    @Nullable
    protected Object h(@NotNull kotlinx.coroutines.channels.z<? super T> zVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return n(this, zVar, eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@NotNull Function2<? super kotlinx.coroutines.channels.z<? super T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2, @NotNull kotlin.coroutines.i iVar, int i6, @NotNull BufferOverflow bufferOverflow) {
        super(iVar, i6, bufferOverflow);
        this.f48863d = function2;
    }
}
