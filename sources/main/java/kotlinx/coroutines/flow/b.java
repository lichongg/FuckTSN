package kotlinx.coroutines.flow;

import com.tencent.connect.common.Constants;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class b<T> extends f<T> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final Function2<kotlinx.coroutines.channels.z<? super T>, kotlin.coroutines.e<? super n1>, Object> f48842e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.CallbackFlowBuilder", f = "Builders.kt", i = {0}, l = {334}, m = "collectTo", n = {Constants.PARAM_SCOPE}, s = {"L$0"})
    static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48843a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f48844b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b<T> f48845c;

        /* renamed from: d, reason: collision with root package name */
        int f48846d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(b<T> bVar, kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
            this.f48845c = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48844b = obj;
            this.f48846d |= Integer.MIN_VALUE;
            return this.f48845c.h(null, this);
        }
    }

    public /* synthetic */ b(Function2 function2, kotlin.coroutines.i iVar, int i6, BufferOverflow bufferOverflow, int i7, kotlin.jvm.internal.v vVar) {
        this(function2, (i7 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : iVar, (i7 & 4) != 0 ? -2 : i6, (i7 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.f, kotlinx.coroutines.flow.internal.d
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.Object h(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.z<? super T> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.b.a
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.b$a r0 = (kotlinx.coroutines.flow.b.a) r0
            int r1 = r0.f48846d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48846d = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.b$a r0 = new kotlinx.coroutines.flow.b$a
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f48844b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48846d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f48843a
            kotlinx.coroutines.channels.z r5 = (kotlinx.coroutines.channels.z) r5
            kotlin.g0.n(r6)
            goto L43
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.g0.n(r6)
            r0.f48843a = r5
            r0.f48846d = r3
            java.lang.Object r6 = super.h(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            boolean r5 = r5.z()
            if (r5 == 0) goto L4c
            kotlin.n1 r5 = kotlin.n1.f44123a
            return r5
        L4c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.b.h(kotlinx.coroutines.channels.z, kotlin.coroutines.e):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.f, kotlinx.coroutines.flow.internal.d
    @NotNull
    protected kotlinx.coroutines.flow.internal.d<T> i(@NotNull kotlin.coroutines.i iVar, int i6, @NotNull BufferOverflow bufferOverflow) {
        return new b(this.f48842e, iVar, i6, bufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull Function2<? super kotlinx.coroutines.channels.z<? super T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2, @NotNull kotlin.coroutines.i iVar, int i6, @NotNull BufferOverflow bufferOverflow) {
        super(function2, iVar, i6, bufferOverflow);
        this.f48842e = function2;
    }
}
