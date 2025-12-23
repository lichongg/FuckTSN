package kotlinx.coroutines;

import kotlin.Result;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/ResumeAwaitOnCompletion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1454:1\n1#2:1455\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class v2<T> extends k2 {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final q<T> f49672e;

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.n1 invoke(Throwable th) {
        z(th);
        return kotlin.n1.f44123a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v2(@NotNull q<? super T> qVar) {
        this.f49672e = qVar;
    }

    @Override // kotlinx.coroutines.f0
    public void z(@Nullable Throwable th) {
        Object H0 = A().H0();
        if (H0 instanceof d0) {
            q<T> qVar = this.f49672e;
            Result.a aVar = Result.Companion;
            qVar.resumeWith(Result.m130constructorimpl(kotlin.g0.a(((d0) H0).f48476a)));
        } else {
            q<T> qVar2 = this.f49672e;
            Result.a aVar2 = Result.Companion;
            qVar2.resumeWith(Result.m130constructorimpl(m2.h(H0)));
        }
    }
}
