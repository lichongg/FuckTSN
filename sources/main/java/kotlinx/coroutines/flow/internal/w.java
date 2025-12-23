package kotlinx.coroutines.flow.internal;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.h0;
import kotlinx.coroutines.flow.y;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAbstractSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,132:1\n28#2,4:133\n28#2,4:138\n20#3:137\n20#3:142\n*S KotlinDebug\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow\n*L\n126#1:133,4\n128#1:138,4\n126#1:137\n128#1:142\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class w extends y<Integer> implements h0<Integer> {
    @Override // kotlinx.coroutines.flow.h0
    @NotNull
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public Integer getValue() {
        Integer valueOf;
        synchronized (this) {
            valueOf = Integer.valueOf(O().intValue());
        }
        return valueOf;
    }

    public final boolean d0(int i6) {
        boolean c6;
        synchronized (this) {
            c6 = c(Integer.valueOf(O().intValue() + i6));
        }
        return c6;
    }

    public w(int i6) {
        super(1, Integer.MAX_VALUE, BufferOverflow.DROP_OLDEST);
        c(Integer.valueOf(i6));
    }
}
