package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.channels.n;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/channels/ChannelsKt__ChannelsKt\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n*L\n1#1,61:1\n514#2,6:62\n*S KotlinDebug\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/channels/ChannelsKt__ChannelsKt\n*L\n37#1:62,6\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class q {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$sendBlocking$1", f = "Channels.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48248a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c0<Object> f48249b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f48250c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(c0<Object> c0Var, Object obj, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f48249b = c0Var;
            this.f48250c = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            return new a(this.f48249b, this.f48250c, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull r0 r0Var, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f48248a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                c0<Object> c0Var = this.f48249b;
                Object obj2 = this.f48250c;
                this.f48248a = 1;
                if (c0Var.T(obj2, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/channels/ChannelsKt__ChannelsKt$trySendBlocking$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
    static final class b extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n<? extends n1>>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48251a;

        /* renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f48252b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ c0<E> f48253c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ E f48254d;

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(r0 r0Var, kotlin.coroutines.e<? super n<? extends n1>> eVar) {
            return invoke2(r0Var, (kotlin.coroutines.e<? super n<n1>>) eVar);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(c0<? super E> c0Var, E e6, kotlin.coroutines.e<? super b> eVar) {
            super(2, eVar);
            this.f48253c = c0Var;
            this.f48254d = e6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            b bVar = new b(this.f48253c, this.f48254d, eVar);
            bVar.f48252b = obj;
            return bVar;
        }

        @Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull r0 r0Var, @Nullable kotlin.coroutines.e<? super n<n1>> eVar) {
            return ((b) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m130constructorimpl;
            Object a6;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f48251a;
            try {
                if (i6 != 0) {
                    if (i6 == 1) {
                        g0.n(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    g0.n(obj);
                    c0<E> c0Var = this.f48253c;
                    E e6 = this.f48254d;
                    Result.a aVar = Result.Companion;
                    this.f48251a = 1;
                    if (c0Var.T(e6, this) == l6) {
                        return l6;
                    }
                }
                m130constructorimpl = Result.m130constructorimpl(n1.f44123a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.Companion;
                m130constructorimpl = Result.m130constructorimpl(g0.a(th));
            }
            if (Result.m137isSuccessimpl(m130constructorimpl)) {
                a6 = n.f48241b.c(n1.f44123a);
            } else {
                a6 = n.f48241b.a(Result.m133exceptionOrNullimpl(m130constructorimpl));
            }
            return n.b(a6);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'trySendBlocking'. Consider handling the result of 'trySendBlocking' explicitly and rethrow exception if necessary", replaceWith = @ReplaceWith(expression = "trySendBlocking(element)", imports = {}))
    public static final /* synthetic */ void a(c0 c0Var, Object obj) {
        if (!n.m(c0Var.r(obj))) {
            kotlinx.coroutines.j.b(null, new a(c0Var, obj, null), 1, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <E> Object b(@NotNull c0<? super E> c0Var, E e6) {
        Object b6;
        Object r5 = c0Var.r(e6);
        if (r5 instanceof n.c) {
            b6 = kotlinx.coroutines.j.b(null, new b(c0Var, e6, null), 1, null);
            return ((n) b6).o();
        }
        return n.f48241b.c(n1.f44123a);
    }
}
