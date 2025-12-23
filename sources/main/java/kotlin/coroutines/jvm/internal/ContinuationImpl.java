package kotlin.coroutines.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.coroutines.i;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.3")
@SourceDebugExtension({"SMAP\nContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContinuationImpl.kt\nkotlin/coroutines/jvm/internal/ContinuationImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,169:1\n1#2:170\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {

    @Nullable
    private final kotlin.coroutines.i _context;

    @Nullable
    private transient kotlin.coroutines.e<Object> intercepted;

    public ContinuationImpl(@Nullable kotlin.coroutines.e<Object> eVar, @Nullable kotlin.coroutines.i iVar) {
        super(eVar);
        this._context = iVar;
    }

    @Override // kotlin.coroutines.e
    @NotNull
    public kotlin.coroutines.i getContext() {
        kotlin.coroutines.i iVar = this._context;
        g0.m(iVar);
        return iVar;
    }

    @NotNull
    public final kotlin.coroutines.e<Object> intercepted() {
        kotlin.coroutines.e<Object> eVar = this.intercepted;
        if (eVar == null) {
            kotlin.coroutines.f fVar = (kotlin.coroutines.f) getContext().get(kotlin.coroutines.f.f43765o0);
            if (fVar == null || (eVar = fVar.interceptContinuation(this)) == null) {
                eVar = this;
            }
            this.intercepted = eVar;
        }
        return eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    protected void releaseIntercepted() {
        kotlin.coroutines.e<?> eVar = this.intercepted;
        if (eVar != null && eVar != this) {
            i.b bVar = getContext().get(kotlin.coroutines.f.f43765o0);
            g0.m(bVar);
            ((kotlin.coroutines.f) bVar).releaseInterceptedContinuation(eVar);
        }
        this.intercepted = b.f43769a;
    }

    public ContinuationImpl(@Nullable kotlin.coroutines.e<Object> eVar) {
        this(eVar, eVar != null ? eVar.getContext() : null);
    }
}
