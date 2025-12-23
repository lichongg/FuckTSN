package kotlinx.coroutines.future;

import java.util.function.BiFunction;
import kotlin.jvm.JvmField;
import kotlin.n1;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class g<T> implements BiFunction<T, Throwable, n1> {

    @JvmField
    @Nullable
    public volatile kotlin.coroutines.e<? super T> cont;

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        r2 = r2.getCause();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(@org.jetbrains.annotations.Nullable T r2, @org.jetbrains.annotations.Nullable java.lang.Throwable r3) {
        /*
            r1 = this;
            kotlin.coroutines.e<? super T> r0 = r1.cont
            if (r0 != 0) goto L5
            return
        L5:
            if (r3 != 0) goto L11
            kotlin.Result$a r3 = kotlin.Result.Companion
            java.lang.Object r2 = kotlin.Result.m130constructorimpl(r2)
            r0.resumeWith(r2)
            return
        L11:
            boolean r2 = kotlinx.coroutines.future.d.a(r3)
            if (r2 == 0) goto L1c
            java.util.concurrent.CompletionException r2 = kotlinx.coroutines.future.e.a(r3)
            goto L1d
        L1c:
            r2 = 0
        L1d:
            if (r2 == 0) goto L27
            java.lang.Throwable r2 = kotlinx.coroutines.future.f.a(r2)
            if (r2 != 0) goto L26
            goto L27
        L26:
            r3 = r2
        L27:
            kotlin.Result$a r2 = kotlin.Result.Companion
            java.lang.Object r2 = kotlin.g0.a(r3)
            java.lang.Object r2 = kotlin.Result.m130constructorimpl(r2)
            r0.resumeWith(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.future.g.a(java.lang.Object, java.lang.Throwable):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.BiFunction
    public /* bridge */ /* synthetic */ n1 apply(Object obj, Throwable th) {
        a(obj, th);
        return n1.f44123a;
    }

    public g(@Nullable kotlin.coroutines.e<? super T> eVar) {
        this.cont = eVar;
    }
}
