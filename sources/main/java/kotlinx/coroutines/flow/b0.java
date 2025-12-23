package kotlinx.coroutines.flow;

import kotlin.jvm.JvmField;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class b0<T> {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @NotNull
    public final i<T> f48847a;

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    public final int f48848b;

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    @NotNull
    public final BufferOverflow f48849c;

    /* renamed from: d, reason: collision with root package name */
    @JvmField
    @NotNull
    public final kotlin.coroutines.i f48850d;

    /* JADX WARN: Multi-variable type inference failed */
    public b0(@NotNull i<? extends T> iVar, int i6, @NotNull BufferOverflow bufferOverflow, @NotNull kotlin.coroutines.i iVar2) {
        this.f48847a = iVar;
        this.f48848b = i6;
        this.f48849c = bufferOverflow;
        this.f48850d = iVar2;
    }
}
