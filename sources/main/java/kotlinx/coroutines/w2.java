package kotlinx.coroutines;

import kotlin.Result;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class w2 extends k2 {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.coroutines.e<kotlin.n1> f49677e;

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.n1 invoke(Throwable th) {
        z(th);
        return kotlin.n1.f44123a;
    }

    @Override // kotlinx.coroutines.f0
    public void z(@Nullable Throwable th) {
        kotlin.coroutines.e<kotlin.n1> eVar = this.f49677e;
        Result.a aVar = Result.Companion;
        eVar.resumeWith(Result.m130constructorimpl(kotlin.n1.f44123a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w2(@NotNull kotlin.coroutines.e<? super kotlin.n1> eVar) {
        this.f49677e = eVar;
    }
}
