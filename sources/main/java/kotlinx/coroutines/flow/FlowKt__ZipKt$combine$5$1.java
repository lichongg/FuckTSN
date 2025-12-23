package kotlinx.coroutines.flow;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combine$5$1\n*L\n1#1,332:1\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class FlowKt__ZipKt$combine$5$1<T> extends Lambda implements Function0<T[]> {
    final /* synthetic */ i<T>[] $flows;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$5$1(i<? extends T>[] iVarArr) {
        super(0);
        this.$flows = iVarArr;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final T[] invoke() {
        int length = this.$flows.length;
        kotlin.jvm.internal.g0.y(0, "T?");
        return (T[]) new Object[length];
    }
}
