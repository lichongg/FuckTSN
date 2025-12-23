package kotlinx.coroutines.channels;

import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.collections.a1;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlin.o0;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,479:1\n82#2,11:480\n82#2,11:491\n82#2,11:502\n82#2,11:513\n105#2:524\n82#2,6:525\n106#2:531\n92#2:532\n107#2:533\n88#2,3:534\n82#2,11:537\n105#2:548\n82#2,6:549\n106#2,2:555\n92#2:557\n88#2,3:558\n82#2,11:561\n82#2,11:572\n82#2,11:583\n105#2:594\n82#2,6:595\n106#2,2:601\n92#2:603\n88#2,3:604\n105#2:607\n82#2,6:608\n106#2,2:614\n92#2:616\n88#2,3:617\n105#2:620\n82#2,6:621\n106#2,2:627\n92#2:629\n88#2,3:630\n105#2:633\n82#2,6:634\n106#2,2:640\n92#2:642\n88#2,3:643\n105#2:646\n82#2,6:647\n106#2,2:653\n92#2:655\n88#2,3:656\n82#2,11:659\n105#2:670\n82#2,6:671\n106#2,2:677\n92#2:679\n88#2,3:680\n82#2,11:683\n82#2,11:694\n82#2,11:705\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt\n*L\n34#1:480,11\n49#1:491,11\n63#1:502,11\n73#1:513,11\n84#1:524\n84#1:525,6\n84#1:531\n84#1:532\n84#1:533\n84#1:534,3\n95#1:537,11\n110#1:548\n110#1:549,6\n110#1:555,2\n110#1:557\n110#1:558,3\n121#1:561,11\n134#1:572,11\n147#1:583,11\n232#1:594\n232#1:595,6\n232#1:601,2\n232#1:603\n232#1:604,3\n241#1:607\n241#1:608,6\n241#1:614,2\n241#1:616\n241#1:617,3\n277#1:620\n277#1:621,6\n277#1:627,2\n277#1:629\n277#1:630,3\n285#1:633\n285#1:634,6\n285#1:640,2\n285#1:642\n285#1:643,3\n298#1:646\n298#1:647,6\n298#1:653,2\n298#1:655\n298#1:656,3\n403#1:659,11\n411#1:670\n411#1:671,6\n411#1:677,2\n411#1:679\n411#1:680,3\n418#1:683,11\n432#1:694,11\n446#1:705,11\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class s {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0}, l = {404}, m = "any", n = {"$this$consume$iv"}, s = {"L$0"})
    static final class a<E> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48271a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f48272b;

        /* renamed from: c, reason: collision with root package name */
        int f48273c;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48272b = obj;
            this.f48273c |= Integer.MIN_VALUE;
            return s.a(null, this);
        }

        a(kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {434, org.apache.commons.net.nntp.h.C}, m = "minWith", n = {"comparator", "$this$consume$iv", "iterator", "comparator", "$this$consume$iv", "iterator", "min"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    static final class a0<E> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48274a;

        /* renamed from: b, reason: collision with root package name */
        Object f48275b;

        /* renamed from: c, reason: collision with root package name */
        Object f48276c;

        /* renamed from: d, reason: collision with root package name */
        Object f48277d;

        /* renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f48278e;

        /* renamed from: f, reason: collision with root package name */
        int f48279f;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48278e = obj;
            this.f48279f |= Integer.MIN_VALUE;
            return s.N(null, null, this);
        }

        a0(kotlin.coroutines.e<? super a0> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b extends Lambda implements Function1<Throwable, n1> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.b0<?> f48280a;

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ n1 invoke(Throwable th) {
            invoke2(th);
            return n1.f44123a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlinx.coroutines.channels.b0<?> b0Var) {
            super(1);
            this.f48280a = b0Var;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            kotlinx.coroutines.channels.p.b(this.f48280a, th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0}, l = {447}, m = "none", n = {"$this$consume$iv"}, s = {"L$0"})
    static final class b0<E> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48281a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f48282b;

        /* renamed from: c, reason: collision with root package name */
        int f48283c;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48282b = obj;
            this.f48283c |= Integer.MIN_VALUE;
            return s.O(null, this);
        }

        b0(kotlin.coroutines.e<? super b0> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$consumesAll$1\n+ 2 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,479:1\n75#2:480\n1#3:481\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$consumesAll$1\n*L\n26#1:480\n*E\n"})
    static final class c extends Lambda implements Function1<Throwable, n1> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.b0<?>[] f48284a;

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ n1 invoke(Throwable th) {
            invoke2(th);
            return n1.f44123a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(kotlinx.coroutines.channels.b0<?>[] b0VarArr) {
            super(1);
            this.f48284a = b0VarArr;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            Throwable th2 = null;
            for (kotlinx.coroutines.channels.b0<?> b0Var : this.f48284a) {
                try {
                    kotlinx.coroutines.channels.p.b(b0Var, th);
                } catch (Throwable th3) {
                    if (th2 == null) {
                        th2 = th3;
                    } else {
                        kotlin.l.a(th2, th3);
                    }
                }
            }
            if (th2 != null) {
                throw th2;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$requireNoNulls$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class c0 extends SuspendLambda implements Function2<Object, kotlin.coroutines.e<Object>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48285a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f48286b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.b0<Object> f48287c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c0(kotlinx.coroutines.channels.b0<Object> b0Var, kotlin.coroutines.e<? super c0> eVar) {
            super(2, eVar);
            this.f48287c = b0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            c0 c0Var = new c0(this.f48287c, eVar);
            c0Var.f48286b = obj;
            return c0Var;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@Nullable Object obj, @Nullable kotlin.coroutines.e<Object> eVar) {
            return ((c0) create(obj, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f48285a == 0) {
                kotlin.g0.n(obj);
                Object obj2 = this.f48286b;
                if (obj2 != null) {
                    return obj2;
                }
                throw new IllegalArgumentException("null element found in " + this.f48287c + '.');
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "count", n = {"count", "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    static final class d<E> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48288a;

        /* renamed from: b, reason: collision with root package name */
        Object f48289b;

        /* renamed from: c, reason: collision with root package name */
        Object f48290c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f48291d;

        /* renamed from: e, reason: collision with root package name */
        int f48292e;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48291d = obj;
            this.f48292e |= Integer.MIN_VALUE;
            return s.d(null, this);
        }

        d(kotlin.coroutines.e<? super d> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE}, m = "single", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "single"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class d0<E> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48293a;

        /* renamed from: b, reason: collision with root package name */
        Object f48294b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f48295c;

        /* renamed from: d, reason: collision with root package name */
        int f48296d;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48295c = obj;
            this.f48296d |= Integer.MIN_VALUE;
            return s.Q(null, this);
        }

        d0(kotlin.coroutines.e<? super d0> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinct$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class e extends SuspendLambda implements Function2<Object, kotlin.coroutines.e<Object>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48297a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f48298b;

        e(kotlin.coroutines.e<? super e> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            e eVar2 = new e(eVar);
            eVar2.f48298b = obj;
            return eVar2;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, @Nullable kotlin.coroutines.e<Object> eVar) {
            return ((e) create(obj, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f48297a == 0) {
                kotlin.g0.n(obj);
                return this.f48298b;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {Opcodes.FCMPL, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CLOCK_DIFF}, m = "singleOrNull", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "single"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class e0<E> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48299a;

        /* renamed from: b, reason: collision with root package name */
        Object f48300b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f48301c;

        /* renamed from: d, reason: collision with root package name */
        int f48302d;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48301c = obj;
            this.f48302d |= Integer.MIN_VALUE;
            return s.R(null, this);
        }

        e0(kotlin.coroutines.e<? super e0> eVar) {
            super(eVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_POST_STALL_500, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSION_TIME_MS}, m = "invokeSuspend", n = {"$this$produce", "keys", "$this$produce", "keys", "e", "$this$produce", "keys", "k"}, s = {"L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
    static final class f<E> extends SuspendLambda implements Function2<kotlinx.coroutines.channels.z<? super E>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f48303a;

        /* renamed from: b, reason: collision with root package name */
        Object f48304b;

        /* renamed from: c, reason: collision with root package name */
        Object f48305c;

        /* renamed from: d, reason: collision with root package name */
        int f48306d;

        /* renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f48307e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.b0<E> f48308f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Function2<E, kotlin.coroutines.e<? super K>, Object> f48309g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        f(kotlinx.coroutines.channels.b0<? extends E> b0Var, Function2<? super E, ? super kotlin.coroutines.e<? super K>, ? extends Object> function2, kotlin.coroutines.e<? super f> eVar) {
            super(2, eVar);
            this.f48308f = b0Var;
            this.f48309g = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            f fVar = new f(this.f48308f, this.f48309g, eVar);
            fVar.f48307e = obj;
            return fVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull kotlinx.coroutines.channels.z<? super E> zVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((f) create(zVar, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0076, code lost:
        
            if (r11 != r0) goto L16;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00a3  */
        /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v15 */
        /* JADX WARN: Type inference failed for: r6v16 */
        /* JADX WARN: Type inference failed for: r6v8, types: [java.util.Collection] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00a1 -> B:8:0x00ba). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00b4 -> B:7:0x00b6). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r10.f48306d
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L51
                if (r1 == r4) goto L41
                if (r1 == r3) goto L2c
                if (r1 != r2) goto L24
                java.lang.Object r1 = r10.f48305c
                java.lang.Object r5 = r10.f48304b
                kotlinx.coroutines.channels.l r5 = (kotlinx.coroutines.channels.l) r5
                java.lang.Object r6 = r10.f48303a
                java.util.HashSet r6 = (java.util.HashSet) r6
                java.lang.Object r7 = r10.f48307e
                kotlinx.coroutines.channels.z r7 = (kotlinx.coroutines.channels.z) r7
                kotlin.g0.n(r11)
                goto Lb6
            L24:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L2c:
                java.lang.Object r1 = r10.f48305c
                java.lang.Object r5 = r10.f48304b
                kotlinx.coroutines.channels.l r5 = (kotlinx.coroutines.channels.l) r5
                java.lang.Object r6 = r10.f48303a
                java.util.HashSet r6 = (java.util.HashSet) r6
                java.lang.Object r7 = r10.f48307e
                kotlinx.coroutines.channels.z r7 = (kotlinx.coroutines.channels.z) r7
                kotlin.g0.n(r11)
                r9 = r5
                r5 = r1
                r1 = r9
                goto L9d
            L41:
                java.lang.Object r1 = r10.f48304b
                kotlinx.coroutines.channels.l r1 = (kotlinx.coroutines.channels.l) r1
                java.lang.Object r5 = r10.f48303a
                java.util.HashSet r5 = (java.util.HashSet) r5
                java.lang.Object r6 = r10.f48307e
                kotlinx.coroutines.channels.z r6 = (kotlinx.coroutines.channels.z) r6
                kotlin.g0.n(r11)
                goto L79
            L51:
                kotlin.g0.n(r11)
                java.lang.Object r11 = r10.f48307e
                kotlinx.coroutines.channels.z r11 = (kotlinx.coroutines.channels.z) r11
                java.util.HashSet r1 = new java.util.HashSet
                r1.<init>()
                kotlinx.coroutines.channels.b0<E> r5 = r10.f48308f
                kotlinx.coroutines.channels.l r5 = r5.iterator()
                r6 = r5
                r5 = r1
                r1 = r6
                r6 = r11
            L67:
                r10.f48307e = r6
                r10.f48303a = r5
                r10.f48304b = r1
                r11 = 0
                r10.f48305c = r11
                r10.f48306d = r4
                java.lang.Object r11 = r1.c(r10)
                if (r11 != r0) goto L79
                goto Lb3
            L79:
                java.lang.Boolean r11 = (java.lang.Boolean) r11
                boolean r11 = r11.booleanValue()
                if (r11 == 0) goto Lbd
                java.lang.Object r11 = r1.next()
                kotlin.jvm.functions.Function2<E, kotlin.coroutines.e<? super K>, java.lang.Object> r7 = r10.f48309g
                r10.f48307e = r6
                r10.f48303a = r5
                r10.f48304b = r1
                r10.f48305c = r11
                r10.f48306d = r3
                java.lang.Object r7 = r7.invoke(r11, r10)
                if (r7 != r0) goto L98
                goto Lb3
            L98:
                r9 = r5
                r5 = r11
                r11 = r7
                r7 = r6
                r6 = r9
            L9d:
                boolean r8 = r6.contains(r11)
                if (r8 != 0) goto Lba
                r10.f48307e = r7
                r10.f48303a = r6
                r10.f48304b = r1
                r10.f48305c = r11
                r10.f48306d = r2
                java.lang.Object r5 = r7.T(r5, r10)
                if (r5 != r0) goto Lb4
            Lb3:
                return r0
            Lb4:
                r5 = r1
                r1 = r11
            Lb6:
                r6.add(r1)
                r1 = r5
            Lba:
                r5 = r6
                r6 = r7
                goto L67
            Lbd:
                kotlin.n1 r11 = kotlin.n1.f44123a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {254, 255}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining"}, s = {"L$0", "I$0", "L$0", "I$0"})
    @SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$take$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,479:1\n1#2:480\n*E\n"})
    static final class f0 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.z<Object>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f48310a;

        /* renamed from: b, reason: collision with root package name */
        int f48311b;

        /* renamed from: c, reason: collision with root package name */
        int f48312c;

        /* renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f48313d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f48314e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.b0<Object> f48315f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f0(int i6, kotlinx.coroutines.channels.b0<Object> b0Var, kotlin.coroutines.e<? super f0> eVar) {
            super(2, eVar);
            this.f48314e = i6;
            this.f48315f = b0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            f0 f0Var = new f0(this.f48314e, this.f48315f, eVar);
            f0Var.f48313d = obj;
            return f0Var;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull kotlinx.coroutines.channels.z<Object> zVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((f0) create(zVar, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0078, code lost:
        
            if (r5.T(r8, r7) == r0) goto L28;
         */
        /* JADX WARN: Removed duplicated region for block: B:11:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0082  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0078 -> B:6:0x001b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r7.f48312c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L33
                if (r1 == r3) goto L25
                if (r1 != r2) goto L1d
                int r1 = r7.f48311b
                java.lang.Object r4 = r7.f48310a
                kotlinx.coroutines.channels.l r4 = (kotlinx.coroutines.channels.l) r4
                java.lang.Object r5 = r7.f48313d
                kotlinx.coroutines.channels.z r5 = (kotlinx.coroutines.channels.z) r5
                kotlin.g0.n(r8)
            L1b:
                r8 = r5
                goto L7b
            L1d:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L25:
                int r1 = r7.f48311b
                java.lang.Object r4 = r7.f48310a
                kotlinx.coroutines.channels.l r4 = (kotlinx.coroutines.channels.l) r4
                java.lang.Object r5 = r7.f48313d
                kotlinx.coroutines.channels.z r5 = (kotlinx.coroutines.channels.z) r5
                kotlin.g0.n(r8)
                goto L60
            L33:
                kotlin.g0.n(r8)
                java.lang.Object r8 = r7.f48313d
                kotlinx.coroutines.channels.z r8 = (kotlinx.coroutines.channels.z) r8
                int r1 = r7.f48314e
                if (r1 != 0) goto L41
                kotlin.n1 r8 = kotlin.n1.f44123a
                return r8
            L41:
                if (r1 < 0) goto L45
                r4 = 1
                goto L46
            L45:
                r4 = 0
            L46:
                if (r4 == 0) goto L85
                kotlinx.coroutines.channels.b0<java.lang.Object> r4 = r7.f48315f
                kotlinx.coroutines.channels.l r4 = r4.iterator()
            L4e:
                r7.f48313d = r8
                r7.f48310a = r4
                r7.f48311b = r1
                r7.f48312c = r3
                java.lang.Object r5 = r4.c(r7)
                if (r5 != r0) goto L5d
                goto L7a
            L5d:
                r6 = r5
                r5 = r8
                r8 = r6
            L60:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 == 0) goto L82
                java.lang.Object r8 = r4.next()
                r7.f48313d = r5
                r7.f48310a = r4
                r7.f48311b = r1
                r7.f48312c = r2
                java.lang.Object r8 = r5.T(r8, r7)
                if (r8 != r0) goto L1b
            L7a:
                return r0
            L7b:
                int r1 = r1 + (-1)
                if (r1 != 0) goto L4e
                kotlin.n1 r8 = kotlin.n1.f44123a
                return r8
            L82:
                kotlin.n1 r8 = kotlin.n1.f44123a
                return r8
            L85:
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r0 = "Requested element count "
                r8.append(r0)
                r8.append(r1)
                java.lang.String r0 = " is less than zero."
                r8.append(r0)
                java.lang.String r8 = r8.toString()
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r8 = r8.toString()
                r0.<init>(r8)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.f0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1", f = "Deprecated.kt", i = {0, 0, 1, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_REAL_TIME, Opcodes.RET, 170}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "$this$produce"}, s = {"L$0", "I$0", "L$0", "L$0"})
    @SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$drop$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,479:1\n1#2:480\n*E\n"})
    static final class g extends SuspendLambda implements Function2<kotlinx.coroutines.channels.z<Object>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f48316a;

        /* renamed from: b, reason: collision with root package name */
        int f48317b;

        /* renamed from: c, reason: collision with root package name */
        int f48318c;

        /* renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f48319d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f48320e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.b0<Object> f48321f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(int i6, kotlinx.coroutines.channels.b0<Object> b0Var, kotlin.coroutines.e<? super g> eVar) {
            super(2, eVar);
            this.f48320e = i6;
            this.f48321f = b0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            g gVar = new g(this.f48320e, this.f48321f, eVar);
            gVar.f48319d = obj;
            return gVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull kotlinx.coroutines.channels.z<Object> zVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((g) create(zVar, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x00a4, code lost:
        
            if (r4.T(r9, r8) == r0) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
        
            if (r1 == 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0065, code lost:
        
            if (r9 == r0) goto L37;
         */
        /* JADX WARN: Removed duplicated region for block: B:10:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x00a7  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x00a4 -> B:7:0x001c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0065 -> B:23:0x0068). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r8.f48318c
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L40
                if (r1 == r4) goto L32
                if (r1 == r3) goto L26
                if (r1 != r2) goto L1e
                java.lang.Object r1 = r8.f48316a
                kotlinx.coroutines.channels.l r1 = (kotlinx.coroutines.channels.l) r1
                java.lang.Object r4 = r8.f48319d
                kotlinx.coroutines.channels.z r4 = (kotlinx.coroutines.channels.z) r4
                kotlin.g0.n(r9)
            L1c:
                r9 = r4
                goto L7e
            L1e:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L26:
                java.lang.Object r1 = r8.f48316a
                kotlinx.coroutines.channels.l r1 = (kotlinx.coroutines.channels.l) r1
                java.lang.Object r4 = r8.f48319d
                kotlinx.coroutines.channels.z r4 = (kotlinx.coroutines.channels.z) r4
                kotlin.g0.n(r9)
                goto L8e
            L32:
                int r1 = r8.f48317b
                java.lang.Object r5 = r8.f48316a
                kotlinx.coroutines.channels.l r5 = (kotlinx.coroutines.channels.l) r5
                java.lang.Object r6 = r8.f48319d
                kotlinx.coroutines.channels.z r6 = (kotlinx.coroutines.channels.z) r6
                kotlin.g0.n(r9)
                goto L68
            L40:
                kotlin.g0.n(r9)
                java.lang.Object r9 = r8.f48319d
                kotlinx.coroutines.channels.z r9 = (kotlinx.coroutines.channels.z) r9
                int r1 = r8.f48320e
                if (r1 < 0) goto L4d
                r5 = 1
                goto L4e
            L4d:
                r5 = 0
            L4e:
                if (r5 == 0) goto Laa
                if (r1 <= 0) goto L78
                kotlinx.coroutines.channels.b0<java.lang.Object> r5 = r8.f48321f
                kotlinx.coroutines.channels.l r5 = r5.iterator()
                r6 = r9
            L59:
                r8.f48319d = r6
                r8.f48316a = r5
                r8.f48317b = r1
                r8.f48318c = r4
                java.lang.Object r9 = r5.c(r8)
                if (r9 != r0) goto L68
                goto La6
            L68:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 == 0) goto L77
                r5.next()
                int r1 = r1 + (-1)
                if (r1 != 0) goto L59
            L77:
                r9 = r6
            L78:
                kotlinx.coroutines.channels.b0<java.lang.Object> r1 = r8.f48321f
                kotlinx.coroutines.channels.l r1 = r1.iterator()
            L7e:
                r8.f48319d = r9
                r8.f48316a = r1
                r8.f48318c = r3
                java.lang.Object r4 = r1.c(r8)
                if (r4 != r0) goto L8b
                goto La6
            L8b:
                r7 = r4
                r4 = r9
                r9 = r7
            L8e:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 == 0) goto La7
                java.lang.Object r9 = r1.next()
                r8.f48319d = r4
                r8.f48316a = r1
                r8.f48318c = r2
                java.lang.Object r9 = r4.T(r9, r8)
                if (r9 != r0) goto L1c
            La6:
                return r0
            La7:
                kotlin.n1 r9 = kotlin.n1.f44123a
                return r9
            Laa:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r0 = "Requested element count "
                r9.append(r0)
                r9.append(r1)
                java.lang.String r0 = " is less than zero."
                r9.append(r0)
                java.lang.String r9 = r9.toString()
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r9 = r9.toString()
                r0.<init>(r9)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 270, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
    static final class g0 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.z<Object>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f48322a;

        /* renamed from: b, reason: collision with root package name */
        Object f48323b;

        /* renamed from: c, reason: collision with root package name */
        int f48324c;

        /* renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f48325d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.b0<Object> f48326e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function2<Object, kotlin.coroutines.e<? super Boolean>, Object> f48327f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        g0(kotlinx.coroutines.channels.b0<Object> b0Var, Function2<Object, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2, kotlin.coroutines.e<? super g0> eVar) {
            super(2, eVar);
            this.f48326e = b0Var;
            this.f48327f = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            g0 g0Var = new g0(this.f48326e, this.f48327f, eVar);
            g0Var.f48325d = obj;
            return g0Var;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull kotlinx.coroutines.channels.z<Object> zVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((g0) create(zVar, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0057, code lost:
        
            if (r9 == r0) goto L28;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0087  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0097 -> B:7:0x004d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r8.f48324c
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L3f
                if (r1 == r4) goto L33
                if (r1 == r3) goto L25
                if (r1 != r2) goto L1d
                java.lang.Object r1 = r8.f48322a
                kotlinx.coroutines.channels.l r1 = (kotlinx.coroutines.channels.l) r1
                java.lang.Object r5 = r8.f48325d
                kotlinx.coroutines.channels.z r5 = (kotlinx.coroutines.channels.z) r5
                kotlin.g0.n(r9)
                goto L4d
            L1d:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L25:
                java.lang.Object r1 = r8.f48323b
                java.lang.Object r5 = r8.f48322a
                kotlinx.coroutines.channels.l r5 = (kotlinx.coroutines.channels.l) r5
                java.lang.Object r6 = r8.f48325d
                kotlinx.coroutines.channels.z r6 = (kotlinx.coroutines.channels.z) r6
                kotlin.g0.n(r9)
                goto L7c
            L33:
                java.lang.Object r1 = r8.f48322a
                kotlinx.coroutines.channels.l r1 = (kotlinx.coroutines.channels.l) r1
                java.lang.Object r5 = r8.f48325d
                kotlinx.coroutines.channels.z r5 = (kotlinx.coroutines.channels.z) r5
                kotlin.g0.n(r9)
                goto L5a
            L3f:
                kotlin.g0.n(r9)
                java.lang.Object r9 = r8.f48325d
                kotlinx.coroutines.channels.z r9 = (kotlinx.coroutines.channels.z) r9
                kotlinx.coroutines.channels.b0<java.lang.Object> r1 = r8.f48326e
                kotlinx.coroutines.channels.l r1 = r1.iterator()
                r5 = r9
            L4d:
                r8.f48325d = r5
                r8.f48322a = r1
                r8.f48324c = r4
                java.lang.Object r9 = r1.c(r8)
                if (r9 != r0) goto L5a
                goto L96
            L5a:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 == 0) goto L9a
                java.lang.Object r9 = r1.next()
                kotlin.jvm.functions.Function2<java.lang.Object, kotlin.coroutines.e<? super java.lang.Boolean>, java.lang.Object> r6 = r8.f48327f
                r8.f48325d = r5
                r8.f48322a = r1
                r8.f48323b = r9
                r8.f48324c = r3
                java.lang.Object r6 = r6.invoke(r9, r8)
                if (r6 != r0) goto L77
                goto L96
            L77:
                r7 = r1
                r1 = r9
                r9 = r6
                r6 = r5
                r5 = r7
            L7c:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 != 0) goto L87
                kotlin.n1 r9 = kotlin.n1.f44123a
                return r9
            L87:
                r8.f48325d = r6
                r8.f48322a = r5
                r9 = 0
                r8.f48323b = r9
                r8.f48324c = r2
                java.lang.Object r9 = r6.T(r1, r8)
                if (r9 != r0) goto L97
            L96:
                return r0
            L97:
                r1 = r5
                r5 = r6
                goto L4d
            L9a:
                kotlin.n1 r9 = kotlin.n1.f44123a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.g0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2, 3, 4}, l = {181, 182, 183, 187, 188}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0", "L$0", "L$0"})
    static final class h extends SuspendLambda implements Function2<kotlinx.coroutines.channels.z<Object>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f48328a;

        /* renamed from: b, reason: collision with root package name */
        Object f48329b;

        /* renamed from: c, reason: collision with root package name */
        int f48330c;

        /* renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f48331d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.b0<Object> f48332e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function2<Object, kotlin.coroutines.e<? super Boolean>, Object> f48333f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        h(kotlinx.coroutines.channels.b0<Object> b0Var, Function2<Object, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2, kotlin.coroutines.e<? super h> eVar) {
            super(2, eVar);
            this.f48332e = b0Var;
            this.f48333f = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            h hVar = new h(this.f48332e, this.f48333f, eVar);
            hVar.f48331d = obj;
            return hVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull kotlinx.coroutines.channels.z<Object> zVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((h) create(zVar, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x00ed, code lost:
        
            if (r4.T(r12, r11) == r0) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x007f, code lost:
        
            if (r12 != r0) goto L18;
         */
        /* JADX WARN: Removed duplicated region for block: B:12:0x00d3  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x00df  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00f0  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00be  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00ed -> B:9:0x0023). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00a0 -> B:27:0x0054). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
            /*
                Method dump skipped, instructions count: 243
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {487, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC}, m = "toChannel", n = {RtspHeaders.Values.DESTINATION, "$this$consume$iv$iv", RtspHeaders.Values.DESTINATION, "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class h0<E, C extends kotlinx.coroutines.channels.c0<? super E>> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48334a;

        /* renamed from: b, reason: collision with root package name */
        Object f48335b;

        /* renamed from: c, reason: collision with root package name */
        Object f48336c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f48337d;

        /* renamed from: e, reason: collision with root package name */
        int f48338e;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48337d = obj;
            this.f48338e |= Integer.MIN_VALUE;
            return kotlinx.coroutines.channels.p.e0(null, null, this);
        }

        h0(kotlin.coroutines.e<? super h0> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {38}, m = "elementAt", n = {"$this$consume$iv", "index", "count"}, s = {"L$0", "I$0", "I$1"})
    static final class i<E> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        int f48339a;

        /* renamed from: b, reason: collision with root package name */
        int f48340b;

        /* renamed from: c, reason: collision with root package name */
        Object f48341c;

        /* renamed from: d, reason: collision with root package name */
        Object f48342d;

        /* renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f48343e;

        /* renamed from: f, reason: collision with root package name */
        int f48344f;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48343e = obj;
            this.f48344f |= Integer.MIN_VALUE;
            return s.l(null, 0, this);
        }

        i(kotlin.coroutines.e<? super i> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "toCollection", n = {RtspHeaders.Values.DESTINATION, "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    static final class i0<E, C extends Collection<? super E>> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48345a;

        /* renamed from: b, reason: collision with root package name */
        Object f48346b;

        /* renamed from: c, reason: collision with root package name */
        Object f48347c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f48348d;

        /* renamed from: e, reason: collision with root package name */
        int f48349e;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48348d = obj;
            this.f48349e |= Integer.MIN_VALUE;
            return kotlinx.coroutines.channels.p.f0(null, null, this);
        }

        i0(kotlin.coroutines.e<? super i0> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {53}, m = "elementAtOrNull", n = {"$this$consume$iv", "index", "count"}, s = {"L$0", "I$0", "I$1"})
    static final class j<E> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        int f48350a;

        /* renamed from: b, reason: collision with root package name */
        int f48351b;

        /* renamed from: c, reason: collision with root package name */
        Object f48352c;

        /* renamed from: d, reason: collision with root package name */
        Object f48353d;

        /* renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f48354e;

        /* renamed from: f, reason: collision with root package name */
        int f48355f;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48354e = obj;
            this.f48355f |= Integer.MIN_VALUE;
            return s.m(null, 0, this);
        }

        j(kotlin.coroutines.e<? super j> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "toMap", n = {RtspHeaders.Values.DESTINATION, "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    static final class j0<K, V, M extends Map<? super K, ? super V>> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48356a;

        /* renamed from: b, reason: collision with root package name */
        Object f48357b;

        /* renamed from: c, reason: collision with root package name */
        Object f48358c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f48359d;

        /* renamed from: e, reason: collision with root package name */
        int f48360e;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48359d = obj;
            this.f48360e |= Integer.MIN_VALUE;
            return kotlinx.coroutines.channels.p.h0(null, null, this);
        }

        j0(kotlin.coroutines.e<? super j0> eVar) {
            super(eVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {198, 199, 199}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
    static final class k<E> extends SuspendLambda implements Function2<kotlinx.coroutines.channels.z<? super E>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f48361a;

        /* renamed from: b, reason: collision with root package name */
        Object f48362b;

        /* renamed from: c, reason: collision with root package name */
        int f48363c;

        /* renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f48364d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.b0<E> f48365e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function2<E, kotlin.coroutines.e<? super Boolean>, Object> f48366f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        k(kotlinx.coroutines.channels.b0<? extends E> b0Var, Function2<? super E, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2, kotlin.coroutines.e<? super k> eVar) {
            super(2, eVar);
            this.f48365e = b0Var;
            this.f48366f = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            k kVar = new k(this.f48365e, this.f48366f, eVar);
            kVar.f48364d = obj;
            return kVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull kotlinx.coroutines.channels.z<? super E> zVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((k) create(zVar, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
        
            r6 = r7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x005d, code lost:
        
            if (r10 == r0) goto L26;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0089  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r9.f48363c
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L43
                if (r1 == r5) goto L37
                if (r1 == r4) goto L26
                if (r1 != r3) goto L1e
                java.lang.Object r1 = r9.f48361a
                kotlinx.coroutines.channels.l r1 = (kotlinx.coroutines.channels.l) r1
                java.lang.Object r6 = r9.f48364d
                kotlinx.coroutines.channels.z r6 = (kotlinx.coroutines.channels.z) r6
                kotlin.g0.n(r10)
                goto L51
            L1e:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L26:
                java.lang.Object r1 = r9.f48362b
                java.lang.Object r6 = r9.f48361a
                kotlinx.coroutines.channels.l r6 = (kotlinx.coroutines.channels.l) r6
                java.lang.Object r7 = r9.f48364d
                kotlinx.coroutines.channels.z r7 = (kotlinx.coroutines.channels.z) r7
                kotlin.g0.n(r10)
                r8 = r6
                r6 = r1
                r1 = r8
                goto L81
            L37:
                java.lang.Object r1 = r9.f48361a
                kotlinx.coroutines.channels.l r1 = (kotlinx.coroutines.channels.l) r1
                java.lang.Object r6 = r9.f48364d
                kotlinx.coroutines.channels.z r6 = (kotlinx.coroutines.channels.z) r6
                kotlin.g0.n(r10)
                goto L60
            L43:
                kotlin.g0.n(r10)
                java.lang.Object r10 = r9.f48364d
                kotlinx.coroutines.channels.z r10 = (kotlinx.coroutines.channels.z) r10
                kotlinx.coroutines.channels.b0<E> r1 = r9.f48365e
                kotlinx.coroutines.channels.l r1 = r1.iterator()
                r6 = r10
            L51:
                r9.f48364d = r6
                r9.f48361a = r1
                r9.f48362b = r2
                r9.f48363c = r5
                java.lang.Object r10 = r1.c(r9)
                if (r10 != r0) goto L60
                goto L97
            L60:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                if (r10 == 0) goto L9a
                java.lang.Object r10 = r1.next()
                kotlin.jvm.functions.Function2<E, kotlin.coroutines.e<? super java.lang.Boolean>, java.lang.Object> r7 = r9.f48366f
                r9.f48364d = r6
                r9.f48361a = r1
                r9.f48362b = r10
                r9.f48363c = r4
                java.lang.Object r7 = r7.invoke(r10, r9)
                if (r7 != r0) goto L7d
                goto L97
            L7d:
                r8 = r6
                r6 = r10
                r10 = r7
                r7 = r8
            L81:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                if (r10 == 0) goto L98
                r9.f48364d = r7
                r9.f48361a = r1
                r9.f48362b = r2
                r9.f48363c = r3
                java.lang.Object r10 = r7.T(r6, r9)
                if (r10 != r0) goto L98
            L97:
                return r0
            L98:
                r6 = r7
                goto L51
            L9a:
                kotlin.n1 r10 = kotlin.n1.f44123a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.k.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_LOADCONTROL_BUFFERINGTIMEOUT, MediaPlayer.MEDIA_PLAYER_OPTION_PRIMING_WORK_AROUND}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0"})
    static final class k0 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.z<? super a1<Object>>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f48367a;

        /* renamed from: b, reason: collision with root package name */
        int f48368b;

        /* renamed from: c, reason: collision with root package name */
        int f48369c;

        /* renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f48370d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.b0<Object> f48371e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k0(kotlinx.coroutines.channels.b0<Object> b0Var, kotlin.coroutines.e<? super k0> eVar) {
            super(2, eVar);
            this.f48371e = b0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            k0 k0Var = new k0(this.f48371e, eVar);
            k0Var.f48370d = obj;
            return k0Var;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull kotlinx.coroutines.channels.z<? super a1<Object>> zVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((k0) create(zVar, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0053  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x007b -> B:6:0x001e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r9.f48369c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L36
                if (r1 == r3) goto L28
                if (r1 != r2) goto L20
                int r1 = r9.f48368b
                java.lang.Object r4 = r9.f48367a
                kotlinx.coroutines.channels.l r4 = (kotlinx.coroutines.channels.l) r4
                java.lang.Object r5 = r9.f48370d
                kotlinx.coroutines.channels.z r5 = (kotlinx.coroutines.channels.z) r5
                kotlin.g0.n(r10)
                r10 = r4
                r4 = r1
                r1 = r10
            L1e:
                r10 = r5
                goto L44
            L20:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L28:
                int r1 = r9.f48368b
                java.lang.Object r4 = r9.f48367a
                kotlinx.coroutines.channels.l r4 = (kotlinx.coroutines.channels.l) r4
                java.lang.Object r5 = r9.f48370d
                kotlinx.coroutines.channels.z r5 = (kotlinx.coroutines.channels.z) r5
                kotlin.g0.n(r10)
                goto L59
            L36:
                kotlin.g0.n(r10)
                java.lang.Object r10 = r9.f48370d
                kotlinx.coroutines.channels.z r10 = (kotlinx.coroutines.channels.z) r10
                kotlinx.coroutines.channels.b0<java.lang.Object> r1 = r9.f48371e
                kotlinx.coroutines.channels.l r1 = r1.iterator()
                r4 = 0
            L44:
                r9.f48370d = r10
                r9.f48367a = r1
                r9.f48368b = r4
                r9.f48369c = r3
                java.lang.Object r5 = r1.c(r9)
                if (r5 != r0) goto L53
                goto L7a
            L53:
                r8 = r5
                r5 = r10
                r10 = r8
                r8 = r4
                r4 = r1
                r1 = r8
            L59:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                if (r10 == 0) goto L7e
                java.lang.Object r10 = r4.next()
                kotlin.collections.a1 r6 = new kotlin.collections.a1
                int r7 = r1 + 1
                r6.<init>(r1, r10)
                r9.f48370d = r5
                r9.f48367a = r4
                r9.f48368b = r7
                r9.f48369c = r2
                java.lang.Object r10 = r5.T(r6, r9)
                if (r10 != r0) goto L7b
            L7a:
                return r0
            L7b:
                r1 = r4
                r4 = r7
                goto L1e
            L7e:
                kotlin.n1 r10 = kotlin.n1.f44123a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.k0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {211, 212, 212}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "e", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "I$0"})
    static final class l extends SuspendLambda implements Function2<kotlinx.coroutines.channels.z<Object>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f48372a;

        /* renamed from: b, reason: collision with root package name */
        Object f48373b;

        /* renamed from: c, reason: collision with root package name */
        int f48374c;

        /* renamed from: d, reason: collision with root package name */
        int f48375d;

        /* renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f48376e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.b0<Object> f48377f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Function3<Integer, Object, kotlin.coroutines.e<? super Boolean>, Object> f48378g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        l(kotlinx.coroutines.channels.b0<Object> b0Var, Function3<? super Integer, Object, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function3, kotlin.coroutines.e<? super l> eVar) {
            super(2, eVar);
            this.f48377f = b0Var;
            this.f48378g = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            l lVar = new l(this.f48377f, this.f48378g, eVar);
            lVar.f48376e = obj;
            return lVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull kotlinx.coroutines.channels.z<Object> zVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((l) create(zVar, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
        
            r7 = r8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0068, code lost:
        
            if (r12 == r0) goto L26;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x009c  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r11.f48375d
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L49
                if (r1 == r5) goto L3b
                if (r1 == r4) goto L28
                if (r1 != r3) goto L20
                int r1 = r11.f48374c
                java.lang.Object r6 = r11.f48372a
                kotlinx.coroutines.channels.l r6 = (kotlinx.coroutines.channels.l) r6
                java.lang.Object r7 = r11.f48376e
                kotlinx.coroutines.channels.z r7 = (kotlinx.coroutines.channels.z) r7
                kotlin.g0.n(r12)
                goto L5a
            L20:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L28:
                int r1 = r11.f48374c
                java.lang.Object r6 = r11.f48373b
                java.lang.Object r7 = r11.f48372a
                kotlinx.coroutines.channels.l r7 = (kotlinx.coroutines.channels.l) r7
                java.lang.Object r8 = r11.f48376e
                kotlinx.coroutines.channels.z r8 = (kotlinx.coroutines.channels.z) r8
                kotlin.g0.n(r12)
                r10 = r7
                r7 = r6
                r6 = r10
                goto L94
            L3b:
                int r1 = r11.f48374c
                java.lang.Object r6 = r11.f48372a
                kotlinx.coroutines.channels.l r6 = (kotlinx.coroutines.channels.l) r6
                java.lang.Object r7 = r11.f48376e
                kotlinx.coroutines.channels.z r7 = (kotlinx.coroutines.channels.z) r7
                kotlin.g0.n(r12)
                goto L6b
            L49:
                kotlin.g0.n(r12)
                java.lang.Object r12 = r11.f48376e
                kotlinx.coroutines.channels.z r12 = (kotlinx.coroutines.channels.z) r12
                kotlinx.coroutines.channels.b0<java.lang.Object> r1 = r11.f48377f
                kotlinx.coroutines.channels.l r1 = r1.iterator()
                r6 = 0
                r7 = r12
                r6 = r1
                r1 = 0
            L5a:
                r11.f48376e = r7
                r11.f48372a = r6
                r11.f48373b = r2
                r11.f48374c = r1
                r11.f48375d = r5
                java.lang.Object r12 = r6.c(r11)
                if (r12 != r0) goto L6b
                goto Lac
            L6b:
                java.lang.Boolean r12 = (java.lang.Boolean) r12
                boolean r12 = r12.booleanValue()
                if (r12 == 0) goto Laf
                java.lang.Object r12 = r6.next()
                kotlin.jvm.functions.Function3<java.lang.Integer, java.lang.Object, kotlin.coroutines.e<? super java.lang.Boolean>, java.lang.Object> r8 = r11.f48378g
                int r9 = r1 + 1
                java.lang.Integer r1 = kotlin.coroutines.jvm.internal.a.f(r1)
                r11.f48376e = r7
                r11.f48372a = r6
                r11.f48373b = r12
                r11.f48374c = r9
                r11.f48375d = r4
                java.lang.Object r1 = r8.invoke(r1, r12, r11)
                if (r1 != r0) goto L90
                goto Lac
            L90:
                r8 = r7
                r7 = r12
                r12 = r1
                r1 = r9
            L94:
                java.lang.Boolean r12 = (java.lang.Boolean) r12
                boolean r12 = r12.booleanValue()
                if (r12 == 0) goto Lad
                r11.f48376e = r8
                r11.f48372a = r6
                r11.f48373b = r2
                r11.f48374c = r1
                r11.f48375d = r3
                java.lang.Object r12 = r8.T(r7, r11)
                if (r12 != r0) goto Lad
            Lac:
                return r0
            Lad:
                r7 = r8
                goto L5a
            Laf:
                kotlin.n1 r12 = kotlin.n1.f44123a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.l.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNot$1", f = "Deprecated.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
    static final class m extends SuspendLambda implements Function2<Object, kotlin.coroutines.e<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48380a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f48381b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2<Object, kotlin.coroutines.e<? super Boolean>, Object> f48382c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        m(Function2<Object, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2, kotlin.coroutines.e<? super m> eVar) {
            super(2, eVar);
            this.f48382c = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            m mVar = new m(this.f48382c, eVar);
            mVar.f48381b = obj;
            return mVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, @Nullable kotlin.coroutines.e<? super Boolean> eVar) {
            return ((m) create(obj, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f48380a;
            if (i6 != 0) {
                if (i6 == 1) {
                    kotlin.g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                kotlin.g0.n(obj);
                Object obj2 = this.f48381b;
                Function2<Object, kotlin.coroutines.e<? super Boolean>, Object> function2 = this.f48382c;
                this.f48380a = 1;
                obj = function2.invoke(obj2, this);
                if (obj == l6) {
                    return l6;
                }
            }
            return kotlin.coroutines.jvm.internal.a.a(!((Boolean) obj).booleanValue());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {487, 469, 471}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consume$iv$iv", "$this$produce", "otherIterator", "$this$consume$iv$iv", "element1", "$this$produce", "otherIterator", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$5", "L$0", "L$1", "L$3"})
    @SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$zip$2\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,479:1\n105#2:480\n82#2,6:481\n106#2,2:487\n92#2:489\n88#2,3:490\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$zip$2\n*L\n468#1:480\n468#1:481,6\n468#1:487,2\n468#1:489\n468#1:490,3\n*E\n"})
    static final class m0<V> extends SuspendLambda implements Function2<kotlinx.coroutines.channels.z<? super V>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f48383a;

        /* renamed from: b, reason: collision with root package name */
        Object f48384b;

        /* renamed from: c, reason: collision with root package name */
        Object f48385c;

        /* renamed from: d, reason: collision with root package name */
        Object f48386d;

        /* renamed from: e, reason: collision with root package name */
        Object f48387e;

        /* renamed from: f, reason: collision with root package name */
        int f48388f;

        /* renamed from: g, reason: collision with root package name */
        private /* synthetic */ Object f48389g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.b0<R> f48390h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.b0<E> f48391i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ Function2<E, R, V> f48392j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        m0(kotlinx.coroutines.channels.b0<? extends R> b0Var, kotlinx.coroutines.channels.b0<? extends E> b0Var2, Function2<? super E, ? super R, ? extends V> function2, kotlin.coroutines.e<? super m0> eVar) {
            super(2, eVar);
            this.f48390h = b0Var;
            this.f48391i = b0Var2;
            this.f48392j = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            m0 m0Var = new m0(this.f48390h, this.f48391i, this.f48392j, eVar);
            m0Var.f48389g = obj;
            return m0Var;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull kotlinx.coroutines.channels.z<? super V> zVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((m0) create(zVar, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0088, code lost:
        
            r6 = r7;
            r7 = r8;
            r8 = r9;
            r9 = r10;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00a5 A[Catch: all -> 0x002a, TRY_LEAVE, TryCatch #2 {all -> 0x002a, blocks: (B:8:0x0026, B:9:0x0088, B:14:0x009d, B:16:0x00a5, B:34:0x00ef, B:45:0x006b, B:47:0x0080), top: B:2:0x000a }] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00cd A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #0 {all -> 0x0053, blocks: (B:19:0x00c5, B:21:0x00cd, B:42:0x004b), top: B:41:0x004b }] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00ef A[Catch: all -> 0x002a, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x002a, blocks: (B:8:0x0026, B:9:0x0088, B:14:0x009d, B:16:0x00a5, B:34:0x00ef, B:45:0x006b, B:47:0x0080), top: B:2:0x000a }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 251
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.m0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNull$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class n<E> extends SuspendLambda implements Function2<E, kotlin.coroutines.e<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48393a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f48394b;

        n(kotlin.coroutines.e<? super n> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            n nVar = new n(eVar);
            nVar.f48394b = obj;
            return nVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@Nullable E e6, @Nullable kotlin.coroutines.e<? super Boolean> eVar) {
            return ((n) create(e6, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z5;
            kotlin.coroutines.intrinsics.a.l();
            if (this.f48393a == 0) {
                kotlin.g0.n(obj);
                if (this.f48394b != null) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                return kotlin.coroutines.jvm.internal.a.a(z5);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "filterNotNullTo", n = {RtspHeaders.Values.DESTINATION, "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    static final class o<E, C extends Collection<? super E>> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48395a;

        /* renamed from: b, reason: collision with root package name */
        Object f48396b;

        /* renamed from: c, reason: collision with root package name */
        Object f48397c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f48398d;

        /* renamed from: e, reason: collision with root package name */
        int f48399e;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48398d = obj;
            this.f48399e |= Integer.MIN_VALUE;
            return s.u(null, null, this);
        }

        o(kotlin.coroutines.e<? super o> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {487, 242}, m = "filterNotNullTo", n = {RtspHeaders.Values.DESTINATION, "$this$consume$iv$iv", RtspHeaders.Values.DESTINATION, "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class p<E, C extends kotlinx.coroutines.channels.c0<? super E>> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48400a;

        /* renamed from: b, reason: collision with root package name */
        Object f48401b;

        /* renamed from: c, reason: collision with root package name */
        Object f48402c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f48403d;

        /* renamed from: e, reason: collision with root package name */
        int f48404e;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48403d = obj;
            this.f48404e |= Integer.MIN_VALUE;
            return s.v(null, null, this);
        }

        p(kotlin.coroutines.e<? super p> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {65}, m = "first", n = {"$this$consume$iv", "iterator"}, s = {"L$0", "L$1"})
    static final class q<E> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48405a;

        /* renamed from: b, reason: collision with root package name */
        Object f48406b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f48407c;

        /* renamed from: d, reason: collision with root package name */
        int f48408d;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48407c = obj;
            this.f48408d |= Integer.MIN_VALUE;
            return s.w(null, this);
        }

        q(kotlin.coroutines.e<? super q> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {75}, m = "firstOrNull", n = {"$this$consume$iv", "iterator"}, s = {"L$0", "L$1"})
    static final class r<E> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48409a;

        /* renamed from: b, reason: collision with root package name */
        Object f48410b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f48411c;

        /* renamed from: d, reason: collision with root package name */
        int f48412d;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48411c = obj;
            this.f48412d |= Integer.MIN_VALUE;
            return s.x(null, this);
        }

        r(kotlin.coroutines.e<? super r> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1", f = "Deprecated.kt", i = {0, 1, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, 322, 322}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
    /* renamed from: kotlinx.coroutines.channels.s$s, reason: collision with other inner class name */
    static final class C0931s extends SuspendLambda implements Function2<kotlinx.coroutines.channels.z<Object>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f48413a;

        /* renamed from: b, reason: collision with root package name */
        int f48414b;

        /* renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f48415c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.b0<Object> f48416d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function2<Object, kotlin.coroutines.e<? super kotlinx.coroutines.channels.b0<Object>>, Object> f48417e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C0931s(kotlinx.coroutines.channels.b0<Object> b0Var, Function2<Object, ? super kotlin.coroutines.e<? super kotlinx.coroutines.channels.b0<Object>>, ? extends Object> function2, kotlin.coroutines.e<? super C0931s> eVar) {
            super(2, eVar);
            this.f48416d = b0Var;
            this.f48417e = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            C0931s c0931s = new C0931s(this.f48416d, this.f48417e, eVar);
            c0931s.f48415c = obj;
            return c0931s;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull kotlinx.coroutines.channels.z<Object> zVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((C0931s) create(zVar, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0070, code lost:
        
            if (r8 == r0) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x007f, code lost:
        
            if (kotlinx.coroutines.channels.p.e0((kotlinx.coroutines.channels.b0) r8, r5, r7) == r0) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0081, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0055, code lost:
        
            if (r8 == r0) goto L23;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x007f -> B:7:0x004b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r7.f48414b
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L3d
                if (r1 == r4) goto L31
                if (r1 == r3) goto L25
                if (r1 != r2) goto L1d
                java.lang.Object r1 = r7.f48413a
                kotlinx.coroutines.channels.l r1 = (kotlinx.coroutines.channels.l) r1
                java.lang.Object r5 = r7.f48415c
                kotlinx.coroutines.channels.z r5 = (kotlinx.coroutines.channels.z) r5
                kotlin.g0.n(r8)
                goto L4b
            L1d:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L25:
                java.lang.Object r1 = r7.f48413a
                kotlinx.coroutines.channels.l r1 = (kotlinx.coroutines.channels.l) r1
                java.lang.Object r5 = r7.f48415c
                kotlinx.coroutines.channels.z r5 = (kotlinx.coroutines.channels.z) r5
                kotlin.g0.n(r8)
                goto L73
            L31:
                java.lang.Object r1 = r7.f48413a
                kotlinx.coroutines.channels.l r1 = (kotlinx.coroutines.channels.l) r1
                java.lang.Object r5 = r7.f48415c
                kotlinx.coroutines.channels.z r5 = (kotlinx.coroutines.channels.z) r5
                kotlin.g0.n(r8)
                goto L58
            L3d:
                kotlin.g0.n(r8)
                java.lang.Object r8 = r7.f48415c
                kotlinx.coroutines.channels.z r8 = (kotlinx.coroutines.channels.z) r8
                kotlinx.coroutines.channels.b0<java.lang.Object> r1 = r7.f48416d
                kotlinx.coroutines.channels.l r1 = r1.iterator()
                r5 = r8
            L4b:
                r7.f48415c = r5
                r7.f48413a = r1
                r7.f48414b = r4
                java.lang.Object r8 = r1.c(r7)
                if (r8 != r0) goto L58
                goto L81
            L58:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 == 0) goto L82
                java.lang.Object r8 = r1.next()
                kotlin.jvm.functions.Function2<java.lang.Object, kotlin.coroutines.e<? super kotlinx.coroutines.channels.b0<java.lang.Object>>, java.lang.Object> r6 = r7.f48417e
                r7.f48415c = r5
                r7.f48413a = r1
                r7.f48414b = r3
                java.lang.Object r8 = r6.invoke(r8, r7)
                if (r8 != r0) goto L73
                goto L81
            L73:
                kotlinx.coroutines.channels.b0 r8 = (kotlinx.coroutines.channels.b0) r8
                r7.f48415c = r5
                r7.f48413a = r1
                r7.f48414b = r2
                java.lang.Object r8 = kotlinx.coroutines.channels.p.e0(r8, r5, r7)
                if (r8 != r0) goto L4b
            L81:
                return r0
            L82:
                kotlin.n1 r8 = kotlin.n1.f44123a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.C0931s.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {487}, m = "indexOf", n = {"element", "index", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$2"})
    static final class t<E> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48418a;

        /* renamed from: b, reason: collision with root package name */
        Object f48419b;

        /* renamed from: c, reason: collision with root package name */
        Object f48420c;

        /* renamed from: d, reason: collision with root package name */
        Object f48421d;

        /* renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f48422e;

        /* renamed from: f, reason: collision with root package name */
        int f48423f;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48422e = obj;
            this.f48423f |= Integer.MIN_VALUE;
            return s.A(null, null, this);
        }

        t(kotlin.coroutines.e<? super t> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1, 1}, l = {97, 100}, m = "last", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "iterator", "last"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class u<E> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48424a;

        /* renamed from: b, reason: collision with root package name */
        Object f48425b;

        /* renamed from: c, reason: collision with root package name */
        Object f48426c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f48427d;

        /* renamed from: e, reason: collision with root package name */
        int f48428e;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48427d = obj;
            this.f48428e |= Integer.MIN_VALUE;
            return s.B(null, this);
        }

        u(kotlin.coroutines.e<? super u> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 0}, l = {487}, m = "lastIndexOf", n = {"element", "lastIndex", "index", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class v<E> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48429a;

        /* renamed from: b, reason: collision with root package name */
        Object f48430b;

        /* renamed from: c, reason: collision with root package name */
        Object f48431c;

        /* renamed from: d, reason: collision with root package name */
        Object f48432d;

        /* renamed from: e, reason: collision with root package name */
        Object f48433e;

        /* renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f48434f;

        /* renamed from: g, reason: collision with root package name */
        int f48435g;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48434f = obj;
            this.f48435g |= Integer.MIN_VALUE;
            return s.C(null, null, this);
        }

        v(kotlin.coroutines.e<? super v> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1, 1}, l = {123, 126}, m = "lastOrNull", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "iterator", "last"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class w<E> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48436a;

        /* renamed from: b, reason: collision with root package name */
        Object f48437b;

        /* renamed from: c, reason: collision with root package name */
        Object f48438c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f48439d;

        /* renamed from: e, reason: collision with root package name */
        int f48440e;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48439d = obj;
            this.f48440e |= Integer.MIN_VALUE;
            return s.D(null, this);
        }

        w(kotlin.coroutines.e<? super w> eVar) {
            super(eVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {487, 333, 333}, m = "invokeSuspend", n = {"$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
    @SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$map$1\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,479:1\n105#2:480\n82#2,6:481\n106#2,2:487\n92#2:489\n88#2,3:490\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$map$1\n*L\n332#1:480\n332#1:481,6\n332#1:487,2\n332#1:489\n332#1:490,3\n*E\n"})
    static final class x<R> extends SuspendLambda implements Function2<kotlinx.coroutines.channels.z<? super R>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f48441a;

        /* renamed from: b, reason: collision with root package name */
        Object f48442b;

        /* renamed from: c, reason: collision with root package name */
        Object f48443c;

        /* renamed from: d, reason: collision with root package name */
        Object f48444d;

        /* renamed from: e, reason: collision with root package name */
        int f48445e;

        /* renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f48446f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.b0<E> f48447g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function2<E, kotlin.coroutines.e<? super R>, Object> f48448h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        x(kotlinx.coroutines.channels.b0<? extends E> b0Var, Function2<? super E, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, kotlin.coroutines.e<? super x> eVar) {
            super(2, eVar);
            this.f48447g = b0Var;
            this.f48448h = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            x xVar = new x(this.f48447g, this.f48448h, eVar);
            xVar.f48446f = obj;
            return xVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull kotlinx.coroutines.channels.z<? super R> zVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((x) create(zVar, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0091 A[Catch: all -> 0x0027, TRY_LEAVE, TryCatch #0 {all -> 0x0027, blocks: (B:8:0x0022, B:10:0x0075, B:16:0x0089, B:18:0x0091, B:33:0x00c5, B:43:0x005f, B:45:0x006e), top: B:2:0x000a }] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00c5 A[Catch: all -> 0x0027, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0027, blocks: (B:8:0x0022, B:10:0x0075, B:16:0x0089, B:18:0x0091, B:33:0x00c5, B:43:0x005f, B:45:0x006e), top: B:2:0x000a }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00c0 -> B:10:0x0075). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
            /*
                Method dump skipped, instructions count: 209
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.x.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_PTS, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
    static final class y<R> extends SuspendLambda implements Function2<kotlinx.coroutines.channels.z<? super R>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f48449a;

        /* renamed from: b, reason: collision with root package name */
        Object f48450b;

        /* renamed from: c, reason: collision with root package name */
        int f48451c;

        /* renamed from: d, reason: collision with root package name */
        int f48452d;

        /* renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f48453e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.b0<E> f48454f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Function3<Integer, E, kotlin.coroutines.e<? super R>, Object> f48455g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        y(kotlinx.coroutines.channels.b0<? extends E> b0Var, Function3<? super Integer, ? super E, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3, kotlin.coroutines.e<? super y> eVar) {
            super(2, eVar);
            this.f48454f = b0Var;
            this.f48455g = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            y yVar = new y(this.f48454f, this.f48455g, eVar);
            yVar.f48453e = obj;
            return yVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull kotlinx.coroutines.channels.z<? super R> zVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((y) create(zVar, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00a8  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00a5 -> B:7:0x0058). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r10.f48452d
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L48
                if (r1 == r4) goto L3a
                if (r1 == r3) goto L28
                if (r1 != r2) goto L20
                int r1 = r10.f48451c
                java.lang.Object r5 = r10.f48449a
                kotlinx.coroutines.channels.l r5 = (kotlinx.coroutines.channels.l) r5
                java.lang.Object r6 = r10.f48453e
                kotlinx.coroutines.channels.z r6 = (kotlinx.coroutines.channels.z) r6
                kotlin.g0.n(r11)
                r11 = r6
                goto L58
            L20:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L28:
                int r1 = r10.f48451c
                java.lang.Object r5 = r10.f48450b
                kotlinx.coroutines.channels.z r5 = (kotlinx.coroutines.channels.z) r5
                java.lang.Object r6 = r10.f48449a
                kotlinx.coroutines.channels.l r6 = (kotlinx.coroutines.channels.l) r6
                java.lang.Object r7 = r10.f48453e
                kotlinx.coroutines.channels.z r7 = (kotlinx.coroutines.channels.z) r7
                kotlin.g0.n(r11)
                goto L93
            L3a:
                int r1 = r10.f48451c
                java.lang.Object r5 = r10.f48449a
                kotlinx.coroutines.channels.l r5 = (kotlinx.coroutines.channels.l) r5
                java.lang.Object r6 = r10.f48453e
                kotlinx.coroutines.channels.z r6 = (kotlinx.coroutines.channels.z) r6
                kotlin.g0.n(r11)
                goto L6a
            L48:
                kotlin.g0.n(r11)
                java.lang.Object r11 = r10.f48453e
                kotlinx.coroutines.channels.z r11 = (kotlinx.coroutines.channels.z) r11
                kotlinx.coroutines.channels.b0<E> r1 = r10.f48454f
                kotlinx.coroutines.channels.l r1 = r1.iterator()
                r5 = 0
                r5 = r1
                r1 = 0
            L58:
                r10.f48453e = r11
                r10.f48449a = r5
                r10.f48451c = r1
                r10.f48452d = r4
                java.lang.Object r6 = r5.c(r10)
                if (r6 != r0) goto L67
                goto La4
            L67:
                r9 = r6
                r6 = r11
                r11 = r9
            L6a:
                java.lang.Boolean r11 = (java.lang.Boolean) r11
                boolean r11 = r11.booleanValue()
                if (r11 == 0) goto La8
                java.lang.Object r11 = r5.next()
                kotlin.jvm.functions.Function3<java.lang.Integer, E, kotlin.coroutines.e<? super R>, java.lang.Object> r7 = r10.f48455g
                int r8 = r1 + 1
                java.lang.Integer r1 = kotlin.coroutines.jvm.internal.a.f(r1)
                r10.f48453e = r6
                r10.f48449a = r5
                r10.f48450b = r6
                r10.f48451c = r8
                r10.f48452d = r3
                java.lang.Object r11 = r7.invoke(r1, r11, r10)
                if (r11 != r0) goto L8f
                goto La4
            L8f:
                r7 = r6
                r1 = r8
                r6 = r5
                r5 = r7
            L93:
                r10.f48453e = r7
                r10.f48449a = r6
                r8 = 0
                r10.f48450b = r8
                r10.f48451c = r1
                r10.f48452d = r2
                java.lang.Object r11 = r5.T(r11, r10)
                if (r11 != r0) goto La5
            La4:
                return r0
            La5:
                r5 = r6
                r11 = r7
                goto L58
            La8:
                kotlin.n1 r11 = kotlin.n1.f44123a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.y.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {org.apache.commons.net.nntp.h.f50924w, org.apache.commons.net.nntp.h.f50926y}, m = "maxWith", n = {"comparator", "$this$consume$iv", "iterator", "comparator", "$this$consume$iv", "iterator", "max"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    static final class z<E> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48456a;

        /* renamed from: b, reason: collision with root package name */
        Object f48457b;

        /* renamed from: c, reason: collision with root package name */
        Object f48458c;

        /* renamed from: d, reason: collision with root package name */
        Object f48459d;

        /* renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f48460e;

        /* renamed from: f, reason: collision with root package name */
        int f48461f;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48460e = obj;
            this.f48461f |= Integer.MIN_VALUE;
            return s.M(null, null, this);
        }

        z(kotlin.coroutines.e<? super z> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class l0 extends Lambda implements Function2<Object, Object, Pair<Object, Object>> {

        /* renamed from: a, reason: collision with root package name */
        public static final l0 f48379a = new l0();

        l0() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Pair<Object, Object> invoke(Object obj, Object obj2) {
            return o0.a(obj, obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0070 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:11:0x0033, B:12:0x0067, B:14:0x0070, B:16:0x007a, B:20:0x0084, B:21:0x0053, B:25:0x008b), top: B:10:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008b A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #1 {all -> 0x0037, blocks: (B:11:0x0033, B:12:0x0067, B:14:0x0070, B:16:0x007a, B:20:0x0084, B:21:0x0053, B:25:0x008b), top: B:10:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0064 -> B:12:0x0067). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object A(kotlinx.coroutines.channels.b0 r7, java.lang.Object r8, kotlin.coroutines.e r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.channels.s.t
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.channels.s$t r0 = (kotlinx.coroutines.channels.s.t) r0
            int r1 = r0.f48423f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48423f = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.s$t r0 = new kotlinx.coroutines.channels.s$t
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f48422e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48423f
            r3 = 1
            if (r2 == 0) goto L42
            if (r2 != r3) goto L3a
            java.lang.Object r7 = r0.f48421d
            kotlinx.coroutines.channels.l r7 = (kotlinx.coroutines.channels.l) r7
            java.lang.Object r8 = r0.f48420c
            kotlinx.coroutines.channels.b0 r8 = (kotlinx.coroutines.channels.b0) r8
            java.lang.Object r2 = r0.f48419b
            kotlin.jvm.internal.Ref$IntRef r2 = (kotlin.jvm.internal.Ref.IntRef) r2
            java.lang.Object r4 = r0.f48418a
            kotlin.g0.n(r9)     // Catch: java.lang.Throwable -> L37
            goto L67
        L37:
            r7 = move-exception
            goto L9a
        L3a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L42:
            kotlin.g0.n(r9)
            kotlin.jvm.internal.Ref$IntRef r9 = new kotlin.jvm.internal.Ref$IntRef
            r9.<init>()
            kotlinx.coroutines.channels.l r2 = r7.iterator()     // Catch: java.lang.Throwable -> L96
            r6 = r8
            r8 = r7
            r7 = r2
            r2 = r9
            r9 = r6
        L53:
            r0.f48418a = r9     // Catch: java.lang.Throwable -> L37
            r0.f48419b = r2     // Catch: java.lang.Throwable -> L37
            r0.f48420c = r8     // Catch: java.lang.Throwable -> L37
            r0.f48421d = r7     // Catch: java.lang.Throwable -> L37
            r0.f48423f = r3     // Catch: java.lang.Throwable -> L37
            java.lang.Object r4 = r7.c(r0)     // Catch: java.lang.Throwable -> L37
            if (r4 != r1) goto L64
            return r1
        L64:
            r6 = r4
            r4 = r9
            r9 = r6
        L67:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L37
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L37
            r5 = 0
            if (r9 == 0) goto L8b
            java.lang.Object r9 = r7.next()     // Catch: java.lang.Throwable -> L37
            boolean r9 = kotlin.jvm.internal.g0.g(r4, r9)     // Catch: java.lang.Throwable -> L37
            if (r9 == 0) goto L84
            int r7 = r2.element     // Catch: java.lang.Throwable -> L37
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.a.f(r7)     // Catch: java.lang.Throwable -> L37
            kotlinx.coroutines.channels.p.b(r8, r5)
            return r7
        L84:
            int r9 = r2.element     // Catch: java.lang.Throwable -> L37
            int r9 = r9 + r3
            r2.element = r9     // Catch: java.lang.Throwable -> L37
            r9 = r4
            goto L53
        L8b:
            kotlin.n1 r7 = kotlin.n1.f44123a     // Catch: java.lang.Throwable -> L37
            kotlinx.coroutines.channels.p.b(r8, r5)
            r7 = -1
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.a.f(r7)
            return r7
        L96:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L9a:
            throw r7     // Catch: java.lang.Throwable -> L9b
        L9b:
            r9 = move-exception
            kotlinx.coroutines.channels.p.b(r8, r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.A(kotlinx.coroutines.channels.b0, java.lang.Object, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0093 A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #0 {all -> 0x0036, blocks: (B:12:0x0032, B:13:0x008b, B:15:0x0093), top: B:11:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0071 A[Catch: all -> 0x004e, TRY_LEAVE, TryCatch #2 {all -> 0x004e, blocks: (B:40:0x004a, B:41:0x0069, B:43:0x0071, B:45:0x00a2, B:46:0x00a9), top: B:39:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2 A[Catch: all -> 0x004e, TRY_ENTER, TryCatch #2 {all -> 0x004e, blocks: (B:40:0x004a, B:41:0x0069, B:43:0x0071, B:45:0x00a2, B:46:0x00a9), top: B:39:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0087 -> B:13:0x008b). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object B(kotlinx.coroutines.channels.b0 r6, kotlin.coroutines.e r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.s.u
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.channels.s$u r0 = (kotlinx.coroutines.channels.s.u) r0
            int r1 = r0.f48428e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48428e = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.s$u r0 = new kotlinx.coroutines.channels.s$u
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f48427d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48428e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L51
            if (r2 == r4) goto L42
            if (r2 != r3) goto L3a
            java.lang.Object r6 = r0.f48426c
            java.lang.Object r2 = r0.f48425b
            kotlinx.coroutines.channels.l r2 = (kotlinx.coroutines.channels.l) r2
            java.lang.Object r4 = r0.f48424a
            kotlinx.coroutines.channels.b0 r4 = (kotlinx.coroutines.channels.b0) r4
            kotlin.g0.n(r7)     // Catch: java.lang.Throwable -> L36
            goto L8b
        L36:
            r6 = move-exception
            r2 = r4
            goto Laa
        L3a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L42:
            java.lang.Object r6 = r0.f48425b
            kotlinx.coroutines.channels.l r6 = (kotlinx.coroutines.channels.l) r6
            java.lang.Object r2 = r0.f48424a
            kotlinx.coroutines.channels.b0 r2 = (kotlinx.coroutines.channels.b0) r2
            kotlin.g0.n(r7)     // Catch: java.lang.Throwable -> L4e
            goto L69
        L4e:
            r6 = move-exception
            goto Laa
        L51:
            kotlin.g0.n(r7)
            kotlinx.coroutines.channels.l r7 = r6.iterator()     // Catch: java.lang.Throwable -> L9e
            r0.f48424a = r6     // Catch: java.lang.Throwable -> L9e
            r0.f48425b = r7     // Catch: java.lang.Throwable -> L9e
            r0.f48428e = r4     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r2 = r7.c(r0)     // Catch: java.lang.Throwable -> L9e
            if (r2 != r1) goto L65
            goto L86
        L65:
            r5 = r2
            r2 = r6
            r6 = r7
            r7 = r5
        L69:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L4e
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L4e
            if (r7 == 0) goto La2
            java.lang.Object r7 = r6.next()     // Catch: java.lang.Throwable -> L4e
            r5 = r2
            r2 = r6
            r6 = r5
        L78:
            r0.f48424a = r6     // Catch: java.lang.Throwable -> L9e
            r0.f48425b = r2     // Catch: java.lang.Throwable -> L9e
            r0.f48426c = r7     // Catch: java.lang.Throwable -> L9e
            r0.f48428e = r3     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r4 = r2.c(r0)     // Catch: java.lang.Throwable -> L9e
            if (r4 != r1) goto L87
        L86:
            return r1
        L87:
            r5 = r4
            r4 = r6
            r6 = r7
            r7 = r5
        L8b:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L36
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L36
            if (r7 == 0) goto L99
            java.lang.Object r7 = r2.next()     // Catch: java.lang.Throwable -> L36
            r6 = r4
            goto L78
        L99:
            r7 = 0
            kotlinx.coroutines.channels.p.b(r4, r7)
            return r6
        L9e:
            r7 = move-exception
            r2 = r6
            r6 = r7
            goto Laa
        La2:
            java.util.NoSuchElementException r6 = new java.util.NoSuchElementException     // Catch: java.lang.Throwable -> L4e
            java.lang.String r7 = "ReceiveChannel is empty."
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L4e
            throw r6     // Catch: java.lang.Throwable -> L4e
        Laa:
            throw r6     // Catch: java.lang.Throwable -> Lab
        Lab:
            r7 = move-exception
            kotlinx.coroutines.channels.p.b(r2, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.B(kotlinx.coroutines.channels.b0, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007d A[Catch: all -> 0x003b, TryCatch #1 {all -> 0x003b, blocks: (B:11:0x0037, B:12:0x0075, B:14:0x007d, B:16:0x0087, B:17:0x008b, B:18:0x005f, B:23:0x0092), top: B:10:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0092 A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #1 {all -> 0x003b, blocks: (B:11:0x0037, B:12:0x0075, B:14:0x007d, B:16:0x0087, B:17:0x008b, B:18:0x005f, B:23:0x0092), top: B:10:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0072 -> B:12:0x0075). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object C(kotlinx.coroutines.channels.b0 r7, java.lang.Object r8, kotlin.coroutines.e r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.channels.s.v
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.channels.s$v r0 = (kotlinx.coroutines.channels.s.v) r0
            int r1 = r0.f48435g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48435g = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.s$v r0 = new kotlinx.coroutines.channels.s$v
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f48434f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48435g
            r3 = 1
            if (r2 == 0) goto L46
            if (r2 != r3) goto L3e
            java.lang.Object r7 = r0.f48433e
            kotlinx.coroutines.channels.l r7 = (kotlinx.coroutines.channels.l) r7
            java.lang.Object r8 = r0.f48432d
            kotlinx.coroutines.channels.b0 r8 = (kotlinx.coroutines.channels.b0) r8
            java.lang.Object r2 = r0.f48431c
            kotlin.jvm.internal.Ref$IntRef r2 = (kotlin.jvm.internal.Ref.IntRef) r2
            java.lang.Object r4 = r0.f48430b
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            java.lang.Object r5 = r0.f48429a
            kotlin.g0.n(r9)     // Catch: java.lang.Throwable -> L3b
            goto L75
        L3b:
            r7 = move-exception
            goto La3
        L3e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L46:
            kotlin.g0.n(r9)
            kotlin.jvm.internal.Ref$IntRef r9 = new kotlin.jvm.internal.Ref$IntRef
            r9.<init>()
            r2 = -1
            r9.element = r2
            kotlin.jvm.internal.Ref$IntRef r2 = new kotlin.jvm.internal.Ref$IntRef
            r2.<init>()
            kotlinx.coroutines.channels.l r4 = r7.iterator()     // Catch: java.lang.Throwable -> L9f
            r6 = r8
            r8 = r7
            r7 = r4
            r4 = r9
            r9 = r6
        L5f:
            r0.f48429a = r9     // Catch: java.lang.Throwable -> L3b
            r0.f48430b = r4     // Catch: java.lang.Throwable -> L3b
            r0.f48431c = r2     // Catch: java.lang.Throwable -> L3b
            r0.f48432d = r8     // Catch: java.lang.Throwable -> L3b
            r0.f48433e = r7     // Catch: java.lang.Throwable -> L3b
            r0.f48435g = r3     // Catch: java.lang.Throwable -> L3b
            java.lang.Object r5 = r7.c(r0)     // Catch: java.lang.Throwable -> L3b
            if (r5 != r1) goto L72
            return r1
        L72:
            r6 = r5
            r5 = r9
            r9 = r6
        L75:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L3b
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L3b
            if (r9 == 0) goto L92
            java.lang.Object r9 = r7.next()     // Catch: java.lang.Throwable -> L3b
            boolean r9 = kotlin.jvm.internal.g0.g(r5, r9)     // Catch: java.lang.Throwable -> L3b
            if (r9 == 0) goto L8b
            int r9 = r2.element     // Catch: java.lang.Throwable -> L3b
            r4.element = r9     // Catch: java.lang.Throwable -> L3b
        L8b:
            int r9 = r2.element     // Catch: java.lang.Throwable -> L3b
            int r9 = r9 + r3
            r2.element = r9     // Catch: java.lang.Throwable -> L3b
            r9 = r5
            goto L5f
        L92:
            kotlin.n1 r7 = kotlin.n1.f44123a     // Catch: java.lang.Throwable -> L3b
            r7 = 0
            kotlinx.coroutines.channels.p.b(r8, r7)
            int r7 = r4.element
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.a.f(r7)
            return r7
        L9f:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        La3:
            throw r7     // Catch: java.lang.Throwable -> La4
        La4:
            r9 = move-exception
            kotlinx.coroutines.channels.p.b(r8, r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.C(kotlinx.coroutines.channels.b0, java.lang.Object, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0097 A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #2 {all -> 0x0037, blocks: (B:12:0x0033, B:13:0x008f, B:15:0x0097), top: B:11:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0075 A[Catch: all -> 0x004f, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x004f, blocks: (B:40:0x004b, B:41:0x0069, B:45:0x0075), top: B:39:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x008b -> B:13:0x008f). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object D(kotlinx.coroutines.channels.b0 r7, kotlin.coroutines.e r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.s.w
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.channels.s$w r0 = (kotlinx.coroutines.channels.s.w) r0
            int r1 = r0.f48440e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48440e = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.s$w r0 = new kotlinx.coroutines.channels.s$w
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f48439d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48440e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L51
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r7 = r0.f48438c
            java.lang.Object r2 = r0.f48437b
            kotlinx.coroutines.channels.l r2 = (kotlinx.coroutines.channels.l) r2
            java.lang.Object r4 = r0.f48436a
            kotlinx.coroutines.channels.b0 r4 = (kotlinx.coroutines.channels.b0) r4
            kotlin.g0.n(r8)     // Catch: java.lang.Throwable -> L37
            goto L8f
        L37:
            r7 = move-exception
            r2 = r4
            goto La4
        L3b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L43:
            java.lang.Object r7 = r0.f48437b
            kotlinx.coroutines.channels.l r7 = (kotlinx.coroutines.channels.l) r7
            java.lang.Object r2 = r0.f48436a
            kotlinx.coroutines.channels.b0 r2 = (kotlinx.coroutines.channels.b0) r2
            kotlin.g0.n(r8)     // Catch: java.lang.Throwable -> L4f
            goto L69
        L4f:
            r7 = move-exception
            goto La4
        L51:
            kotlin.g0.n(r8)
            kotlinx.coroutines.channels.l r8 = r7.iterator()     // Catch: java.lang.Throwable -> La1
            r0.f48436a = r7     // Catch: java.lang.Throwable -> La1
            r0.f48437b = r8     // Catch: java.lang.Throwable -> La1
            r0.f48440e = r4     // Catch: java.lang.Throwable -> La1
            java.lang.Object r2 = r8.c(r0)     // Catch: java.lang.Throwable -> La1
            if (r2 != r1) goto L65
            goto L8a
        L65:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L69:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L4f
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L4f
            if (r8 != 0) goto L75
            kotlinx.coroutines.channels.p.b(r2, r5)
            return r5
        L75:
            java.lang.Object r8 = r7.next()     // Catch: java.lang.Throwable -> L4f
            r6 = r2
            r2 = r7
            r7 = r6
        L7c:
            r0.f48436a = r7     // Catch: java.lang.Throwable -> La1
            r0.f48437b = r2     // Catch: java.lang.Throwable -> La1
            r0.f48438c = r8     // Catch: java.lang.Throwable -> La1
            r0.f48440e = r3     // Catch: java.lang.Throwable -> La1
            java.lang.Object r4 = r2.c(r0)     // Catch: java.lang.Throwable -> La1
            if (r4 != r1) goto L8b
        L8a:
            return r1
        L8b:
            r6 = r4
            r4 = r7
            r7 = r8
            r8 = r6
        L8f:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L37
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L37
            if (r8 == 0) goto L9d
            java.lang.Object r8 = r2.next()     // Catch: java.lang.Throwable -> L37
            r7 = r4
            goto L7c
        L9d:
            kotlinx.coroutines.channels.p.b(r4, r5)
            return r7
        La1:
            r8 = move-exception
            r2 = r7
            r7 = r8
        La4:
            throw r7     // Catch: java.lang.Throwable -> La5
        La5:
            r8 = move-exception
            kotlinx.coroutines.channels.p.b(r2, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.D(kotlinx.coroutines.channels.b0, kotlin.coroutines.e):java.lang.Object");
    }

    @PublishedApi
    @NotNull
    public static final <E, R> kotlinx.coroutines.channels.b0<R> E(@NotNull kotlinx.coroutines.channels.b0<? extends E> b0Var, @NotNull kotlin.coroutines.i iVar, @NotNull Function2<? super E, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2) {
        return kotlinx.coroutines.channels.x.g(w1.f49676a, iVar, 0, null, kotlinx.coroutines.channels.p.g(b0Var), new x(b0Var, function2, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.b0 F(kotlinx.coroutines.channels.b0 b0Var, kotlin.coroutines.i iVar, Function2 function2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            iVar = g1.g();
        }
        return kotlinx.coroutines.channels.p.J(b0Var, iVar, function2);
    }

    @PublishedApi
    @NotNull
    public static final <E, R> kotlinx.coroutines.channels.b0<R> G(@NotNull kotlinx.coroutines.channels.b0<? extends E> b0Var, @NotNull kotlin.coroutines.i iVar, @NotNull Function3<? super Integer, ? super E, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3) {
        return kotlinx.coroutines.channels.x.g(w1.f49676a, iVar, 0, null, kotlinx.coroutines.channels.p.g(b0Var), new y(b0Var, function3, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.b0 H(kotlinx.coroutines.channels.b0 b0Var, kotlin.coroutines.i iVar, Function3 function3, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            iVar = g1.g();
        }
        return kotlinx.coroutines.channels.p.L(b0Var, iVar, function3);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.b0 J(kotlinx.coroutines.channels.b0 b0Var, kotlin.coroutines.i iVar, Function3 function3, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            iVar = g1.g();
        }
        return I(b0Var, iVar, function3);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.b0 L(kotlinx.coroutines.channels.b0 b0Var, kotlin.coroutines.i iVar, Function2 function2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            iVar = g1.g();
        }
        return K(b0Var, iVar, function2);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00ab A[Catch: all -> 0x00b9, TRY_LEAVE, TryCatch #2 {all -> 0x00b9, blocks: (B:15:0x00a3, B:17:0x00ab, B:20:0x008e, B:55:0x0062), top: B:54:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086 A[Catch: all -> 0x005c, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x005c, blocks: (B:44:0x0058, B:45:0x007a, B:49:0x0086), top: B:43:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x009f -> B:14:0x003d). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object M(kotlinx.coroutines.channels.b0 r8, java.util.Comparator r9, kotlin.coroutines.e r10) {
        /*
            Method dump skipped, instructions count: 200
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.M(kotlinx.coroutines.channels.b0, java.util.Comparator, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00ab A[Catch: all -> 0x00b9, TRY_LEAVE, TryCatch #2 {all -> 0x00b9, blocks: (B:15:0x00a3, B:17:0x00ab, B:20:0x008e, B:55:0x0062), top: B:54:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086 A[Catch: all -> 0x005c, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x005c, blocks: (B:44:0x0058, B:45:0x007a, B:49:0x0086), top: B:43:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x009f -> B:14:0x003d). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object N(kotlinx.coroutines.channels.b0 r8, java.util.Comparator r9, kotlin.coroutines.e r10) {
        /*
            Method dump skipped, instructions count: 200
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.N(kotlinx.coroutines.channels.b0, java.util.Comparator, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object O(kotlinx.coroutines.channels.b0 r4, kotlin.coroutines.e r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.s.b0
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.channels.s$b0 r0 = (kotlinx.coroutines.channels.s.b0) r0
            int r1 = r0.f48283c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48283c = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.s$b0 r0 = new kotlinx.coroutines.channels.s$b0
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f48282b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48283c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.f48281a
            kotlinx.coroutines.channels.b0 r4 = (kotlinx.coroutines.channels.b0) r4
            kotlin.g0.n(r5)     // Catch: java.lang.Throwable -> L2d
            goto L49
        L2d:
            r5 = move-exception
            goto L59
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.g0.n(r5)
            kotlinx.coroutines.channels.l r5 = r4.iterator()     // Catch: java.lang.Throwable -> L2d
            r0.f48281a = r4     // Catch: java.lang.Throwable -> L2d
            r0.f48283c = r3     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r5 = r5.c(r0)     // Catch: java.lang.Throwable -> L2d
            if (r5 != r1) goto L49
            return r1
        L49:
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch: java.lang.Throwable -> L2d
            boolean r5 = r5.booleanValue()     // Catch: java.lang.Throwable -> L2d
            r5 = r5 ^ r3
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.a.a(r5)     // Catch: java.lang.Throwable -> L2d
            r0 = 0
            kotlinx.coroutines.channels.p.b(r4, r0)
            return r5
        L59:
            throw r5     // Catch: java.lang.Throwable -> L5a
        L5a:
            r0 = move-exception
            kotlinx.coroutines.channels.p.b(r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.O(kotlinx.coroutines.channels.b0, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008e A[Catch: all -> 0x0032, TRY_ENTER, TryCatch #1 {all -> 0x0032, blocks: (B:12:0x002e, B:13:0x0081, B:18:0x008e, B:19:0x0095), top: B:11:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c A[Catch: all -> 0x004a, TRY_LEAVE, TryCatch #2 {all -> 0x004a, blocks: (B:33:0x0046, B:34:0x0064, B:36:0x006c, B:40:0x0096, B:41:0x009d), top: B:32:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0096 A[Catch: all -> 0x004a, TRY_ENTER, TryCatch #2 {all -> 0x004a, blocks: (B:33:0x0046, B:34:0x0064, B:36:0x006c, B:40:0x0096, B:41:0x009d), top: B:32:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object Q(kotlinx.coroutines.channels.b0 r6, kotlin.coroutines.e r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.s.d0
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.channels.s$d0 r0 = (kotlinx.coroutines.channels.s.d0) r0
            int r1 = r0.f48296d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48296d = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.s$d0 r0 = new kotlinx.coroutines.channels.s$d0
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f48295c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48296d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r6 = r0.f48294b
            java.lang.Object r0 = r0.f48293a
            kotlinx.coroutines.channels.b0 r0 = (kotlinx.coroutines.channels.b0) r0
            kotlin.g0.n(r7)     // Catch: java.lang.Throwable -> L32
            goto L81
        L32:
            r6 = move-exception
            r2 = r0
            goto La1
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            java.lang.Object r6 = r0.f48294b
            kotlinx.coroutines.channels.l r6 = (kotlinx.coroutines.channels.l) r6
            java.lang.Object r2 = r0.f48293a
            kotlinx.coroutines.channels.b0 r2 = (kotlinx.coroutines.channels.b0) r2
            kotlin.g0.n(r7)     // Catch: java.lang.Throwable -> L4a
            goto L64
        L4a:
            r6 = move-exception
            goto La1
        L4c:
            kotlin.g0.n(r7)
            kotlinx.coroutines.channels.l r7 = r6.iterator()     // Catch: java.lang.Throwable -> L9e
            r0.f48293a = r6     // Catch: java.lang.Throwable -> L9e
            r0.f48294b = r7     // Catch: java.lang.Throwable -> L9e
            r0.f48296d = r4     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r2 = r7.c(r0)     // Catch: java.lang.Throwable -> L9e
            if (r2 != r1) goto L60
            goto L7c
        L60:
            r5 = r2
            r2 = r6
            r6 = r7
            r7 = r5
        L64:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L4a
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L4a
            if (r7 == 0) goto L96
            java.lang.Object r7 = r6.next()     // Catch: java.lang.Throwable -> L4a
            r0.f48293a = r2     // Catch: java.lang.Throwable -> L4a
            r0.f48294b = r7     // Catch: java.lang.Throwable -> L4a
            r0.f48296d = r3     // Catch: java.lang.Throwable -> L4a
            java.lang.Object r6 = r6.c(r0)     // Catch: java.lang.Throwable -> L4a
            if (r6 != r1) goto L7d
        L7c:
            return r1
        L7d:
            r0 = r7
            r7 = r6
            r6 = r0
            r0 = r2
        L81:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L32
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L32
            if (r7 != 0) goto L8e
            r7 = 0
            kotlinx.coroutines.channels.p.b(r0, r7)
            return r6
        L8e:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L32
            java.lang.String r7 = "ReceiveChannel has more than one element."
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L32
            throw r6     // Catch: java.lang.Throwable -> L32
        L96:
            java.util.NoSuchElementException r6 = new java.util.NoSuchElementException     // Catch: java.lang.Throwable -> L4a
            java.lang.String r7 = "ReceiveChannel is empty."
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L4a
            throw r6     // Catch: java.lang.Throwable -> L4a
        L9e:
            r7 = move-exception
            r2 = r6
            r6 = r7
        La1:
            throw r6     // Catch: java.lang.Throwable -> La2
        La2:
            r7 = move-exception
            kotlinx.coroutines.channels.p.b(r2, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.Q(kotlinx.coroutines.channels.b0, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071 A[Catch: all -> 0x004b, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x004b, blocks: (B:33:0x0047, B:34:0x0065, B:38:0x0071), top: B:32:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object R(kotlinx.coroutines.channels.b0 r7, kotlin.coroutines.e r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.s.e0
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.channels.s$e0 r0 = (kotlinx.coroutines.channels.s.e0) r0
            int r1 = r0.f48302d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48302d = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.s$e0 r0 = new kotlinx.coroutines.channels.s$e0
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f48301c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48302d
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r7 = r0.f48300b
            java.lang.Object r0 = r0.f48299a
            kotlinx.coroutines.channels.b0 r0 = (kotlinx.coroutines.channels.b0) r0
            kotlin.g0.n(r8)     // Catch: java.lang.Throwable -> L33
            goto L86
        L33:
            r7 = move-exception
            r2 = r0
            goto L99
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            java.lang.Object r7 = r0.f48300b
            kotlinx.coroutines.channels.l r7 = (kotlinx.coroutines.channels.l) r7
            java.lang.Object r2 = r0.f48299a
            kotlinx.coroutines.channels.b0 r2 = (kotlinx.coroutines.channels.b0) r2
            kotlin.g0.n(r8)     // Catch: java.lang.Throwable -> L4b
            goto L65
        L4b:
            r7 = move-exception
            goto L99
        L4d:
            kotlin.g0.n(r8)
            kotlinx.coroutines.channels.l r8 = r7.iterator()     // Catch: java.lang.Throwable -> L96
            r0.f48299a = r7     // Catch: java.lang.Throwable -> L96
            r0.f48300b = r8     // Catch: java.lang.Throwable -> L96
            r0.f48302d = r4     // Catch: java.lang.Throwable -> L96
            java.lang.Object r2 = r8.c(r0)     // Catch: java.lang.Throwable -> L96
            if (r2 != r1) goto L61
            goto L81
        L61:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L65:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L4b
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L4b
            if (r8 != 0) goto L71
            kotlinx.coroutines.channels.p.b(r2, r5)
            return r5
        L71:
            java.lang.Object r8 = r7.next()     // Catch: java.lang.Throwable -> L4b
            r0.f48299a = r2     // Catch: java.lang.Throwable -> L4b
            r0.f48300b = r8     // Catch: java.lang.Throwable -> L4b
            r0.f48302d = r3     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r7 = r7.c(r0)     // Catch: java.lang.Throwable -> L4b
            if (r7 != r1) goto L82
        L81:
            return r1
        L82:
            r0 = r8
            r8 = r7
            r7 = r0
            r0 = r2
        L86:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L33
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L33
            if (r8 == 0) goto L92
            kotlinx.coroutines.channels.p.b(r0, r5)
            return r5
        L92:
            kotlinx.coroutines.channels.p.b(r0, r5)
            return r7
        L96:
            r8 = move-exception
            r2 = r7
            r7 = r8
        L99:
            throw r7     // Catch: java.lang.Throwable -> L9a
        L9a:
            r8 = move-exception
            kotlinx.coroutines.channels.p.b(r2, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.R(kotlinx.coroutines.channels.b0, kotlin.coroutines.e):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.b0 S(kotlinx.coroutines.channels.b0 b0Var, int i6, kotlin.coroutines.i iVar) {
        return kotlinx.coroutines.channels.x.g(w1.f49676a, iVar, 0, null, kotlinx.coroutines.channels.p.g(b0Var), new f0(i6, b0Var, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.b0 T(kotlinx.coroutines.channels.b0 b0Var, int i6, kotlin.coroutines.i iVar, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            iVar = g1.g();
        }
        return S(b0Var, i6, iVar);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.b0 U(kotlinx.coroutines.channels.b0 b0Var, kotlin.coroutines.i iVar, Function2 function2) {
        return kotlinx.coroutines.channels.x.g(w1.f49676a, iVar, 0, null, kotlinx.coroutines.channels.p.g(b0Var), new g0(b0Var, function2, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.b0 V(kotlinx.coroutines.channels.b0 b0Var, kotlin.coroutines.i iVar, Function2 function2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            iVar = g1.g();
        }
        return U(b0Var, iVar, function2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0088, code lost:
    
        if (r2.T(r8, r0) == r1) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0078 A[Catch: all -> 0x003b, TryCatch #2 {all -> 0x003b, blocks: (B:12:0x0034, B:17:0x0070, B:19:0x0078, B:21:0x008b, B:39:0x0051), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008b A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #2 {all -> 0x003b, blocks: (B:12:0x0034, B:17:0x0070, B:19:0x0078, B:21:0x008b, B:39:0x0051), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r7v0, types: [C extends kotlinx.coroutines.channels.c0<? super E>] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [kotlinx.coroutines.channels.b0] */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object, kotlinx.coroutines.channels.b0] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0088 -> B:13:0x0037). Please report as a decompilation issue!!! */
    @kotlin.PublishedApi
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <E, C extends kotlinx.coroutines.channels.c0<? super E>> java.lang.Object W(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.b0<? extends E> r6, @org.jetbrains.annotations.NotNull C r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super C> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.s.h0
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.channels.s$h0 r0 = (kotlinx.coroutines.channels.s.h0) r0
            int r1 = r0.f48338e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48338e = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.s$h0 r0 = new kotlinx.coroutines.channels.s$h0
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f48337d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48338e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L55
            if (r2 == r4) goto L45
            if (r2 != r3) goto L3d
            java.lang.Object r6 = r0.f48336c
            kotlinx.coroutines.channels.l r6 = (kotlinx.coroutines.channels.l) r6
            java.lang.Object r7 = r0.f48335b
            kotlinx.coroutines.channels.b0 r7 = (kotlinx.coroutines.channels.b0) r7
            java.lang.Object r2 = r0.f48334a
            kotlinx.coroutines.channels.c0 r2 = (kotlinx.coroutines.channels.c0) r2
            kotlin.g0.n(r8)     // Catch: java.lang.Throwable -> L3b
        L37:
            r8 = r6
            r6 = r7
            r7 = r2
            goto L5c
        L3b:
            r6 = move-exception
            goto L96
        L3d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L45:
            java.lang.Object r6 = r0.f48336c
            kotlinx.coroutines.channels.l r6 = (kotlinx.coroutines.channels.l) r6
            java.lang.Object r7 = r0.f48335b
            kotlinx.coroutines.channels.b0 r7 = (kotlinx.coroutines.channels.b0) r7
            java.lang.Object r2 = r0.f48334a
            kotlinx.coroutines.channels.c0 r2 = (kotlinx.coroutines.channels.c0) r2
            kotlin.g0.n(r8)     // Catch: java.lang.Throwable -> L3b
            goto L70
        L55:
            kotlin.g0.n(r8)
            kotlinx.coroutines.channels.l r8 = r6.iterator()     // Catch: java.lang.Throwable -> L92
        L5c:
            r0.f48334a = r7     // Catch: java.lang.Throwable -> L92
            r0.f48335b = r6     // Catch: java.lang.Throwable -> L92
            r0.f48336c = r8     // Catch: java.lang.Throwable -> L92
            r0.f48338e = r4     // Catch: java.lang.Throwable -> L92
            java.lang.Object r2 = r8.c(r0)     // Catch: java.lang.Throwable -> L92
            if (r2 != r1) goto L6b
            goto L8a
        L6b:
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r2
            r2 = r5
        L70:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L3b
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L3b
            if (r8 == 0) goto L8b
            java.lang.Object r8 = r6.next()     // Catch: java.lang.Throwable -> L3b
            r0.f48334a = r2     // Catch: java.lang.Throwable -> L3b
            r0.f48335b = r7     // Catch: java.lang.Throwable -> L3b
            r0.f48336c = r6     // Catch: java.lang.Throwable -> L3b
            r0.f48338e = r3     // Catch: java.lang.Throwable -> L3b
            java.lang.Object r8 = r2.T(r8, r0)     // Catch: java.lang.Throwable -> L3b
            if (r8 != r1) goto L37
        L8a:
            return r1
        L8b:
            kotlin.n1 r6 = kotlin.n1.f44123a     // Catch: java.lang.Throwable -> L3b
            r6 = 0
            kotlinx.coroutines.channels.p.b(r7, r6)
            return r2
        L92:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L96:
            throw r6     // Catch: java.lang.Throwable -> L97
        L97:
            r8 = move-exception
            kotlinx.coroutines.channels.p.b(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.W(kotlinx.coroutines.channels.b0, kotlinx.coroutines.channels.c0, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:11:0x0031, B:12:0x005c, B:14:0x0064, B:15:0x004a, B:20:0x006d), top: B:10:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006d A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:11:0x0031, B:12:0x005c, B:14:0x0064, B:15:0x004a, B:20:0x006d), top: B:10:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0059 -> B:12:0x005c). Please report as a decompilation issue!!! */
    @kotlin.PublishedApi
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <E, C extends java.util.Collection<? super E>> java.lang.Object X(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.b0<? extends E> r5, @org.jetbrains.annotations.NotNull C r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super C> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.s.i0
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.channels.s$i0 r0 = (kotlinx.coroutines.channels.s.i0) r0
            int r1 = r0.f48349e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48349e = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.s$i0 r0 = new kotlinx.coroutines.channels.s$i0
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f48348d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48349e
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r5 = r0.f48347c
            kotlinx.coroutines.channels.l r5 = (kotlinx.coroutines.channels.l) r5
            java.lang.Object r6 = r0.f48346b
            kotlinx.coroutines.channels.b0 r6 = (kotlinx.coroutines.channels.b0) r6
            java.lang.Object r2 = r0.f48345a
            java.util.Collection r2 = (java.util.Collection) r2
            kotlin.g0.n(r7)     // Catch: java.lang.Throwable -> L35
            goto L5c
        L35:
            r5 = move-exception
            goto L78
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3f:
            kotlin.g0.n(r7)
            kotlinx.coroutines.channels.l r7 = r5.iterator()     // Catch: java.lang.Throwable -> L74
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
        L4a:
            r0.f48345a = r7     // Catch: java.lang.Throwable -> L35
            r0.f48346b = r6     // Catch: java.lang.Throwable -> L35
            r0.f48347c = r5     // Catch: java.lang.Throwable -> L35
            r0.f48349e = r3     // Catch: java.lang.Throwable -> L35
            java.lang.Object r2 = r5.c(r0)     // Catch: java.lang.Throwable -> L35
            if (r2 != r1) goto L59
            return r1
        L59:
            r4 = r2
            r2 = r7
            r7 = r4
        L5c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L35
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r7 == 0) goto L6d
            java.lang.Object r7 = r5.next()     // Catch: java.lang.Throwable -> L35
            r2.add(r7)     // Catch: java.lang.Throwable -> L35
            r7 = r2
            goto L4a
        L6d:
            kotlin.n1 r5 = kotlin.n1.f44123a     // Catch: java.lang.Throwable -> L35
            r5 = 0
            kotlinx.coroutines.channels.p.b(r6, r5)
            return r2
        L74:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L78:
            throw r5     // Catch: java.lang.Throwable -> L79
        L79:
            r7 = move-exception
            kotlinx.coroutines.channels.p.b(r6, r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.X(kotlinx.coroutines.channels.b0, java.util.Collection, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:11:0x0031, B:12:0x005c, B:14:0x0064, B:15:0x004a, B:20:0x0077), top: B:10:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0077 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:11:0x0031, B:12:0x005c, B:14:0x0064, B:15:0x004a, B:20:0x0077), top: B:10:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0059 -> B:12:0x005c). Please report as a decompilation issue!!! */
    @kotlin.PublishedApi
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <K, V, M extends java.util.Map<? super K, ? super V>> java.lang.Object Y(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.b0<? extends kotlin.Pair<? extends K, ? extends V>> r6, @org.jetbrains.annotations.NotNull M r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super M> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.s.j0
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.channels.s$j0 r0 = (kotlinx.coroutines.channels.s.j0) r0
            int r1 = r0.f48360e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48360e = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.s$j0 r0 = new kotlinx.coroutines.channels.s$j0
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f48359d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48360e
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r6 = r0.f48358c
            kotlinx.coroutines.channels.l r6 = (kotlinx.coroutines.channels.l) r6
            java.lang.Object r7 = r0.f48357b
            kotlinx.coroutines.channels.b0 r7 = (kotlinx.coroutines.channels.b0) r7
            java.lang.Object r2 = r0.f48356a
            java.util.Map r2 = (java.util.Map) r2
            kotlin.g0.n(r8)     // Catch: java.lang.Throwable -> L35
            goto L5c
        L35:
            r6 = move-exception
            goto L82
        L37:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3f:
            kotlin.g0.n(r8)
            kotlinx.coroutines.channels.l r8 = r6.iterator()     // Catch: java.lang.Throwable -> L7e
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L4a:
            r0.f48356a = r8     // Catch: java.lang.Throwable -> L35
            r0.f48357b = r7     // Catch: java.lang.Throwable -> L35
            r0.f48358c = r6     // Catch: java.lang.Throwable -> L35
            r0.f48360e = r3     // Catch: java.lang.Throwable -> L35
            java.lang.Object r2 = r6.c(r0)     // Catch: java.lang.Throwable -> L35
            if (r2 != r1) goto L59
            return r1
        L59:
            r5 = r2
            r2 = r8
            r8 = r5
        L5c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L35
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r8 == 0) goto L77
            java.lang.Object r8 = r6.next()     // Catch: java.lang.Throwable -> L35
            kotlin.Pair r8 = (kotlin.Pair) r8     // Catch: java.lang.Throwable -> L35
            java.lang.Object r4 = r8.getFirst()     // Catch: java.lang.Throwable -> L35
            java.lang.Object r8 = r8.getSecond()     // Catch: java.lang.Throwable -> L35
            r2.put(r4, r8)     // Catch: java.lang.Throwable -> L35
            r8 = r2
            goto L4a
        L77:
            kotlin.n1 r6 = kotlin.n1.f44123a     // Catch: java.lang.Throwable -> L35
            r6 = 0
            kotlinx.coroutines.channels.p.b(r7, r6)
            return r2
        L7e:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L82:
            throw r6     // Catch: java.lang.Throwable -> L83
        L83:
            r8 = move-exception
            kotlinx.coroutines.channels.p.b(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.Y(kotlinx.coroutines.channels.b0, java.util.Map, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object a(kotlinx.coroutines.channels.b0 r4, kotlin.coroutines.e r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.s.a
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.channels.s$a r0 = (kotlinx.coroutines.channels.s.a) r0
            int r1 = r0.f48273c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48273c = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.s$a r0 = new kotlinx.coroutines.channels.s$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f48272b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48273c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.f48271a
            kotlinx.coroutines.channels.b0 r4 = (kotlinx.coroutines.channels.b0) r4
            kotlin.g0.n(r5)     // Catch: java.lang.Throwable -> L2d
            goto L49
        L2d:
            r5 = move-exception
            goto L4e
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.g0.n(r5)
            kotlinx.coroutines.channels.l r5 = r4.iterator()     // Catch: java.lang.Throwable -> L2d
            r0.f48271a = r4     // Catch: java.lang.Throwable -> L2d
            r0.f48273c = r3     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r5 = r5.c(r0)     // Catch: java.lang.Throwable -> L2d
            if (r5 != r1) goto L49
            return r1
        L49:
            r0 = 0
            kotlinx.coroutines.channels.p.b(r4, r0)
            return r5
        L4e:
            throw r5     // Catch: java.lang.Throwable -> L4f
        L4f:
            r0 = move-exception
            kotlinx.coroutines.channels.p.b(r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.a(kotlinx.coroutines.channels.b0, kotlin.coroutines.e):java.lang.Object");
    }

    @PublishedApi
    @NotNull
    public static final Function1<Throwable, n1> b(@NotNull kotlinx.coroutines.channels.b0<?> b0Var) {
        return new b(b0Var);
    }

    @PublishedApi
    @Nullable
    public static final <E> Object b0(@NotNull kotlinx.coroutines.channels.b0<? extends E> b0Var, @NotNull kotlin.coroutines.e<? super Set<E>> eVar) {
        return kotlinx.coroutines.channels.p.f0(b0Var, new LinkedHashSet(), eVar);
    }

    @PublishedApi
    @NotNull
    public static final Function1<Throwable, n1> c(@NotNull kotlinx.coroutines.channels.b0<?>... b0VarArr) {
        return new c(b0VarArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0068 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:11:0x0031, B:12:0x0060, B:14:0x0068, B:30:0x0072), top: B:10:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0072 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:11:0x0031, B:12:0x0060, B:14:0x0068, B:30:0x0072), top: B:10:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x005d -> B:12:0x0060). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object d(kotlinx.coroutines.channels.b0 r6, kotlin.coroutines.e r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.s.d
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.channels.s$d r0 = (kotlinx.coroutines.channels.s.d) r0
            int r1 = r0.f48292e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48292e = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.s$d r0 = new kotlinx.coroutines.channels.s$d
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f48291d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48292e
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r6 = r0.f48290c
            kotlinx.coroutines.channels.l r6 = (kotlinx.coroutines.channels.l) r6
            java.lang.Object r2 = r0.f48289b
            kotlinx.coroutines.channels.b0 r2 = (kotlinx.coroutines.channels.b0) r2
            java.lang.Object r4 = r0.f48288a
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            kotlin.g0.n(r7)     // Catch: java.lang.Throwable -> L35
            goto L60
        L35:
            r6 = move-exception
            goto L85
        L37:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3f:
            kotlin.g0.n(r7)
            kotlin.jvm.internal.Ref$IntRef r7 = new kotlin.jvm.internal.Ref$IntRef
            r7.<init>()
            kotlinx.coroutines.channels.l r2 = r6.iterator()     // Catch: java.lang.Throwable -> L82
            r4 = r7
            r7 = r6
            r6 = r2
        L4e:
            r0.f48288a = r4     // Catch: java.lang.Throwable -> L7f
            r0.f48289b = r7     // Catch: java.lang.Throwable -> L7f
            r0.f48290c = r6     // Catch: java.lang.Throwable -> L7f
            r0.f48292e = r3     // Catch: java.lang.Throwable -> L7f
            java.lang.Object r2 = r6.c(r0)     // Catch: java.lang.Throwable -> L7f
            if (r2 != r1) goto L5d
            return r1
        L5d:
            r5 = r2
            r2 = r7
            r7 = r5
        L60:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L35
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r7 == 0) goto L72
            r6.next()     // Catch: java.lang.Throwable -> L35
            int r7 = r4.element     // Catch: java.lang.Throwable -> L35
            int r7 = r7 + r3
            r4.element = r7     // Catch: java.lang.Throwable -> L35
            r7 = r2
            goto L4e
        L72:
            kotlin.n1 r6 = kotlin.n1.f44123a     // Catch: java.lang.Throwable -> L35
            r6 = 0
            kotlinx.coroutines.channels.p.b(r2, r6)
            int r6 = r4.element
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.a.f(r6)
            return r6
        L7f:
            r6 = move-exception
            r2 = r7
            goto L85
        L82:
            r7 = move-exception
            r2 = r6
            r6 = r7
        L85:
            throw r6     // Catch: java.lang.Throwable -> L86
        L86:
            r7 = move-exception
            kotlinx.coroutines.channels.p.b(r2, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.d(kotlinx.coroutines.channels.b0, kotlin.coroutines.e):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.b0 d0(kotlinx.coroutines.channels.b0 b0Var, kotlin.coroutines.i iVar) {
        return kotlinx.coroutines.channels.x.g(w1.f49676a, iVar, 0, null, kotlinx.coroutines.channels.p.g(b0Var), new k0(b0Var, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.b0 e0(kotlinx.coroutines.channels.b0 b0Var, kotlin.coroutines.i iVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            iVar = g1.g();
        }
        return d0(b0Var, iVar);
    }

    @PublishedApi
    @NotNull
    public static final <E, K> kotlinx.coroutines.channels.b0<E> f(@NotNull kotlinx.coroutines.channels.b0<? extends E> b0Var, @NotNull kotlin.coroutines.i iVar, @NotNull Function2<? super E, ? super kotlin.coroutines.e<? super K>, ? extends Object> function2) {
        return kotlinx.coroutines.channels.x.g(w1.f49676a, iVar, 0, null, kotlinx.coroutines.channels.p.g(b0Var), new f(b0Var, function2, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.b0 g(kotlinx.coroutines.channels.b0 b0Var, kotlin.coroutines.i iVar, Function2 function2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            iVar = g1.g();
        }
        return kotlinx.coroutines.channels.p.k(b0Var, iVar, function2);
    }

    @PublishedApi
    @NotNull
    public static final <E, R, V> kotlinx.coroutines.channels.b0<V> g0(@NotNull kotlinx.coroutines.channels.b0<? extends E> b0Var, @NotNull kotlinx.coroutines.channels.b0<? extends R> b0Var2, @NotNull kotlin.coroutines.i iVar, @NotNull Function2<? super E, ? super R, ? extends V> function2) {
        return kotlinx.coroutines.channels.x.g(w1.f49676a, iVar, 0, null, kotlinx.coroutines.channels.p.h(b0Var, b0Var2), new m0(b0Var2, b0Var, function2, null), 6, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.b0 h(kotlinx.coroutines.channels.b0 b0Var, int i6, kotlin.coroutines.i iVar) {
        return kotlinx.coroutines.channels.x.g(w1.f49676a, iVar, 0, null, kotlinx.coroutines.channels.p.g(b0Var), new g(i6, b0Var, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.b0 h0(kotlinx.coroutines.channels.b0 b0Var, kotlinx.coroutines.channels.b0 b0Var2, kotlin.coroutines.i iVar, Function2 function2, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            iVar = g1.g();
        }
        return kotlinx.coroutines.channels.p.q0(b0Var, b0Var2, iVar, function2);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.b0 i(kotlinx.coroutines.channels.b0 b0Var, int i6, kotlin.coroutines.i iVar, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            iVar = g1.g();
        }
        return h(b0Var, i6, iVar);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.b0 j(kotlinx.coroutines.channels.b0 b0Var, kotlin.coroutines.i iVar, Function2 function2) {
        return kotlinx.coroutines.channels.x.g(w1.f49676a, iVar, 0, null, kotlinx.coroutines.channels.p.g(b0Var), new h(b0Var, function2, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.b0 k(kotlinx.coroutines.channels.b0 b0Var, kotlin.coroutines.i iVar, Function2 function2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            iVar = g1.g();
        }
        return j(b0Var, iVar, function2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006c A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #2 {all -> 0x0039, blocks: (B:12:0x0035, B:13:0x0064, B:15:0x006c, B:26:0x007d, B:27:0x0094), top: B:11:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d A[Catch: all -> 0x0039, TRY_ENTER, TryCatch #2 {all -> 0x0039, blocks: (B:12:0x0035, B:13:0x0064, B:15:0x006c, B:26:0x007d, B:27:0x0094), top: B:11:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005f -> B:13:0x0064). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object l(kotlinx.coroutines.channels.b0 r9, int r10, kotlin.coroutines.e r11) {
        /*
            boolean r0 = r11 instanceof kotlinx.coroutines.channels.s.i
            if (r0 == 0) goto L13
            r0 = r11
            kotlinx.coroutines.channels.s$i r0 = (kotlinx.coroutines.channels.s.i) r0
            int r1 = r0.f48344f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48344f = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.s$i r0 = new kotlinx.coroutines.channels.s$i
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.f48343e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48344f
            r3 = 46
            java.lang.String r4 = "ReceiveChannel doesn't contain element at index "
            r5 = 1
            if (r2 == 0) goto L44
            if (r2 != r5) goto L3c
            int r9 = r0.f48340b
            int r10 = r0.f48339a
            java.lang.Object r2 = r0.f48342d
            kotlinx.coroutines.channels.l r2 = (kotlinx.coroutines.channels.l) r2
            java.lang.Object r6 = r0.f48341c
            kotlinx.coroutines.channels.b0 r6 = (kotlinx.coroutines.channels.b0) r6
            kotlin.g0.n(r11)     // Catch: java.lang.Throwable -> L39
            goto L64
        L39:
            r9 = move-exception
            goto Lb1
        L3c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L44:
            kotlin.g0.n(r11)
            if (r10 < 0) goto L99
            kotlinx.coroutines.channels.l r11 = r9.iterator()     // Catch: java.lang.Throwable -> L95
            r2 = 0
        L4e:
            r0.f48341c = r9     // Catch: java.lang.Throwable -> L95
            r0.f48342d = r11     // Catch: java.lang.Throwable -> L95
            r0.f48339a = r10     // Catch: java.lang.Throwable -> L95
            r0.f48340b = r2     // Catch: java.lang.Throwable -> L95
            r0.f48344f = r5     // Catch: java.lang.Throwable -> L95
            java.lang.Object r6 = r11.c(r0)     // Catch: java.lang.Throwable -> L95
            if (r6 != r1) goto L5f
            return r1
        L5f:
            r8 = r6
            r6 = r9
            r9 = r2
            r2 = r11
            r11 = r8
        L64:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch: java.lang.Throwable -> L39
            boolean r11 = r11.booleanValue()     // Catch: java.lang.Throwable -> L39
            if (r11 == 0) goto L7d
            java.lang.Object r11 = r2.next()     // Catch: java.lang.Throwable -> L39
            int r7 = r9 + 1
            if (r10 != r9) goto L79
            r9 = 0
            kotlinx.coroutines.channels.p.b(r6, r9)
            return r11
        L79:
            r11 = r2
            r9 = r6
            r2 = r7
            goto L4e
        L7d:
            java.lang.IndexOutOfBoundsException r9 = new java.lang.IndexOutOfBoundsException     // Catch: java.lang.Throwable -> L39
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L39
            r11.<init>()     // Catch: java.lang.Throwable -> L39
            r11.append(r4)     // Catch: java.lang.Throwable -> L39
            r11.append(r10)     // Catch: java.lang.Throwable -> L39
            r11.append(r3)     // Catch: java.lang.Throwable -> L39
            java.lang.String r10 = r11.toString()     // Catch: java.lang.Throwable -> L39
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L39
            throw r9     // Catch: java.lang.Throwable -> L39
        L95:
            r10 = move-exception
            r6 = r9
            r9 = r10
            goto Lb1
        L99:
            java.lang.IndexOutOfBoundsException r11 = new java.lang.IndexOutOfBoundsException     // Catch: java.lang.Throwable -> L95
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L95
            r0.<init>()     // Catch: java.lang.Throwable -> L95
            r0.append(r4)     // Catch: java.lang.Throwable -> L95
            r0.append(r10)     // Catch: java.lang.Throwable -> L95
            r0.append(r3)     // Catch: java.lang.Throwable -> L95
            java.lang.String r10 = r0.toString()     // Catch: java.lang.Throwable -> L95
            r11.<init>(r10)     // Catch: java.lang.Throwable -> L95
            throw r11     // Catch: java.lang.Throwable -> L95
        Lb1:
            throw r9     // Catch: java.lang.Throwable -> Lb2
        Lb2:
            r10 = move-exception
            kotlinx.coroutines.channels.p.b(r6, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.l(kotlinx.coroutines.channels.b0, int, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0070 A[Catch: all -> 0x0080, TRY_LEAVE, TryCatch #0 {all -> 0x0080, blocks: (B:13:0x0068, B:15:0x0070, B:22:0x0053, B:46:0x004e), top: B:45:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0064 -> B:13:0x0068). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object m(kotlinx.coroutines.channels.b0 r8, int r9, kotlin.coroutines.e r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.channels.s.j
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.channels.s$j r0 = (kotlinx.coroutines.channels.s.j) r0
            int r1 = r0.f48355f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48355f = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.s$j r0 = new kotlinx.coroutines.channels.s$j
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f48354e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48355f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L45
            if (r2 != r3) goto L3d
            int r8 = r0.f48351b
            int r9 = r0.f48350a
            java.lang.Object r2 = r0.f48353d
            kotlinx.coroutines.channels.l r2 = (kotlinx.coroutines.channels.l) r2
            java.lang.Object r5 = r0.f48352c
            kotlinx.coroutines.channels.b0 r5 = (kotlinx.coroutines.channels.b0) r5
            kotlin.g0.n(r10)     // Catch: java.lang.Throwable -> L3b
            r7 = r2
            r2 = r8
            r8 = r5
            r5 = r0
            r0 = r7
            goto L68
        L3b:
            r8 = move-exception
            goto L88
        L3d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L45:
            kotlin.g0.n(r10)
            if (r9 >= 0) goto L4e
            kotlinx.coroutines.channels.p.b(r8, r4)
            return r4
        L4e:
            kotlinx.coroutines.channels.l r10 = r8.iterator()     // Catch: java.lang.Throwable -> L80
            r2 = 0
        L53:
            r0.f48352c = r8     // Catch: java.lang.Throwable -> L80
            r0.f48353d = r10     // Catch: java.lang.Throwable -> L80
            r0.f48350a = r9     // Catch: java.lang.Throwable -> L80
            r0.f48351b = r2     // Catch: java.lang.Throwable -> L80
            r0.f48355f = r3     // Catch: java.lang.Throwable -> L80
            java.lang.Object r5 = r10.c(r0)     // Catch: java.lang.Throwable -> L80
            if (r5 != r1) goto L64
            return r1
        L64:
            r7 = r0
            r0 = r10
            r10 = r5
            r5 = r7
        L68:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L80
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L80
            if (r10 == 0) goto L84
            java.lang.Object r10 = r0.next()     // Catch: java.lang.Throwable -> L80
            int r6 = r2 + 1
            if (r9 != r2) goto L7c
            kotlinx.coroutines.channels.p.b(r8, r4)
            return r10
        L7c:
            r10 = r0
            r0 = r5
            r2 = r6
            goto L53
        L80:
            r9 = move-exception
            r5 = r8
            r8 = r9
            goto L88
        L84:
            kotlinx.coroutines.channels.p.b(r8, r4)
            return r4
        L88:
            throw r8     // Catch: java.lang.Throwable -> L89
        L89:
            r9 = move-exception
            kotlinx.coroutines.channels.p.b(r5, r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.m(kotlinx.coroutines.channels.b0, int, kotlin.coroutines.e):java.lang.Object");
    }

    @PublishedApi
    @NotNull
    public static final <E> kotlinx.coroutines.channels.b0<E> n(@NotNull kotlinx.coroutines.channels.b0<? extends E> b0Var, @NotNull kotlin.coroutines.i iVar, @NotNull Function2<? super E, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2) {
        return kotlinx.coroutines.channels.x.g(w1.f49676a, iVar, 0, null, kotlinx.coroutines.channels.p.g(b0Var), new k(b0Var, function2, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.b0 o(kotlinx.coroutines.channels.b0 b0Var, kotlin.coroutines.i iVar, Function2 function2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            iVar = g1.g();
        }
        return kotlinx.coroutines.channels.p.s(b0Var, iVar, function2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.b0 p(kotlinx.coroutines.channels.b0 b0Var, kotlin.coroutines.i iVar, Function3 function3) {
        return kotlinx.coroutines.channels.x.g(w1.f49676a, iVar, 0, null, kotlinx.coroutines.channels.p.g(b0Var), new l(b0Var, function3, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.b0 q(kotlinx.coroutines.channels.b0 b0Var, kotlin.coroutines.i iVar, Function3 function3, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            iVar = g1.g();
        }
        return p(b0Var, iVar, function3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.b0 r(kotlinx.coroutines.channels.b0 b0Var, kotlin.coroutines.i iVar, Function2 function2) {
        return kotlinx.coroutines.channels.p.s(b0Var, iVar, new m(function2, null));
    }

    public static /* synthetic */ kotlinx.coroutines.channels.b0 s(kotlinx.coroutines.channels.b0 b0Var, kotlin.coroutines.i iVar, Function2 function2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            iVar = g1.g();
        }
        return r(b0Var, iVar, function2);
    }

    @PublishedApi
    @NotNull
    public static final <E> kotlinx.coroutines.channels.b0<E> t(@NotNull kotlinx.coroutines.channels.b0<? extends E> b0Var) {
        kotlinx.coroutines.channels.b0<E> o5 = o(b0Var, null, new n(null), 1, null);
        kotlin.jvm.internal.g0.n(o5, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.filterNotNull>");
        return o5;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0064 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:11:0x0031, B:12:0x005c, B:14:0x0064, B:16:0x006a, B:18:0x004a, B:23:0x006f), top: B:10:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #0 {all -> 0x0035, blocks: (B:11:0x0031, B:12:0x005c, B:14:0x0064, B:16:0x006a, B:18:0x004a, B:23:0x006f), top: B:10:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0059 -> B:12:0x005c). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object u(kotlinx.coroutines.channels.b0 r5, java.util.Collection r6, kotlin.coroutines.e r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.s.o
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.channels.s$o r0 = (kotlinx.coroutines.channels.s.o) r0
            int r1 = r0.f48399e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48399e = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.s$o r0 = new kotlinx.coroutines.channels.s$o
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f48398d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48399e
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r5 = r0.f48397c
            kotlinx.coroutines.channels.l r5 = (kotlinx.coroutines.channels.l) r5
            java.lang.Object r6 = r0.f48396b
            kotlinx.coroutines.channels.b0 r6 = (kotlinx.coroutines.channels.b0) r6
            java.lang.Object r2 = r0.f48395a
            java.util.Collection r2 = (java.util.Collection) r2
            kotlin.g0.n(r7)     // Catch: java.lang.Throwable -> L35
            goto L5c
        L35:
            r5 = move-exception
            goto L7a
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3f:
            kotlin.g0.n(r7)
            kotlinx.coroutines.channels.l r7 = r5.iterator()     // Catch: java.lang.Throwable -> L76
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
        L4a:
            r0.f48395a = r7     // Catch: java.lang.Throwable -> L35
            r0.f48396b = r6     // Catch: java.lang.Throwable -> L35
            r0.f48397c = r5     // Catch: java.lang.Throwable -> L35
            r0.f48399e = r3     // Catch: java.lang.Throwable -> L35
            java.lang.Object r2 = r5.c(r0)     // Catch: java.lang.Throwable -> L35
            if (r2 != r1) goto L59
            return r1
        L59:
            r4 = r2
            r2 = r7
            r7 = r4
        L5c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L35
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r7 == 0) goto L6f
            java.lang.Object r7 = r5.next()     // Catch: java.lang.Throwable -> L35
            if (r7 == 0) goto L6d
            r2.add(r7)     // Catch: java.lang.Throwable -> L35
        L6d:
            r7 = r2
            goto L4a
        L6f:
            kotlin.n1 r5 = kotlin.n1.f44123a     // Catch: java.lang.Throwable -> L35
            r5 = 0
            kotlinx.coroutines.channels.p.b(r6, r5)
            return r2
        L76:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L7a:
            throw r5     // Catch: java.lang.Throwable -> L7b
        L7b:
            r7 = move-exception
            kotlinx.coroutines.channels.p.b(r6, r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.u(kotlinx.coroutines.channels.b0, java.util.Collection, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0088, code lost:
    
        if (r2.T(r8, r0) == r1) goto L34;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0076 A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:12:0x0034, B:17:0x006e, B:19:0x0076, B:21:0x007c, B:23:0x008f, B:41:0x004f), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008f A[Catch: all -> 0x0038, TRY_LEAVE, TryCatch #1 {all -> 0x0038, blocks: (B:12:0x0034, B:17:0x006e, B:19:0x0076, B:21:0x007c, B:23:0x008f, B:41:0x004f), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlinx.coroutines.channels.c0] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2, types: [kotlinx.coroutines.channels.b0] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object, kotlinx.coroutines.channels.b0] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x007a -> B:13:0x008b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0088 -> B:13:0x008b). Please report as a decompilation issue!!! */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object v(kotlinx.coroutines.channels.b0 r6, kotlinx.coroutines.channels.c0 r7, kotlin.coroutines.e r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.s.p
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.channels.s$p r0 = (kotlinx.coroutines.channels.s.p) r0
            int r1 = r0.f48404e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48404e = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.s$p r0 = new kotlinx.coroutines.channels.s$p
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f48403d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48404e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L53
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r6 = r0.f48402c
            kotlinx.coroutines.channels.l r6 = (kotlinx.coroutines.channels.l) r6
            java.lang.Object r7 = r0.f48401b
            kotlinx.coroutines.channels.b0 r7 = (kotlinx.coroutines.channels.b0) r7
            java.lang.Object r2 = r0.f48400a
            kotlinx.coroutines.channels.c0 r2 = (kotlinx.coroutines.channels.c0) r2
            kotlin.g0.n(r8)     // Catch: java.lang.Throwable -> L38
            goto L8b
        L38:
            r6 = move-exception
            goto L9a
        L3b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L43:
            java.lang.Object r6 = r0.f48402c
            kotlinx.coroutines.channels.l r6 = (kotlinx.coroutines.channels.l) r6
            java.lang.Object r7 = r0.f48401b
            kotlinx.coroutines.channels.b0 r7 = (kotlinx.coroutines.channels.b0) r7
            java.lang.Object r2 = r0.f48400a
            kotlinx.coroutines.channels.c0 r2 = (kotlinx.coroutines.channels.c0) r2
            kotlin.g0.n(r8)     // Catch: java.lang.Throwable -> L38
            goto L6e
        L53:
            kotlin.g0.n(r8)
            kotlinx.coroutines.channels.l r8 = r6.iterator()     // Catch: java.lang.Throwable -> L96
        L5a:
            r0.f48400a = r7     // Catch: java.lang.Throwable -> L96
            r0.f48401b = r6     // Catch: java.lang.Throwable -> L96
            r0.f48402c = r8     // Catch: java.lang.Throwable -> L96
            r0.f48404e = r4     // Catch: java.lang.Throwable -> L96
            java.lang.Object r2 = r8.c(r0)     // Catch: java.lang.Throwable -> L96
            if (r2 != r1) goto L69
            goto L8a
        L69:
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r2
            r2 = r5
        L6e:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L38
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L38
            if (r8 == 0) goto L8f
            java.lang.Object r8 = r6.next()     // Catch: java.lang.Throwable -> L38
            if (r8 == 0) goto L8b
            r0.f48400a = r2     // Catch: java.lang.Throwable -> L38
            r0.f48401b = r7     // Catch: java.lang.Throwable -> L38
            r0.f48402c = r6     // Catch: java.lang.Throwable -> L38
            r0.f48404e = r3     // Catch: java.lang.Throwable -> L38
            java.lang.Object r8 = r2.T(r8, r0)     // Catch: java.lang.Throwable -> L38
            if (r8 != r1) goto L8b
        L8a:
            return r1
        L8b:
            r8 = r6
            r6 = r7
            r7 = r2
            goto L5a
        L8f:
            kotlin.n1 r6 = kotlin.n1.f44123a     // Catch: java.lang.Throwable -> L38
            r6 = 0
            kotlinx.coroutines.channels.p.b(r7, r6)
            return r2
        L96:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L9a:
            throw r6     // Catch: java.lang.Throwable -> L9b
        L9b:
            r8 = move-exception
            kotlinx.coroutines.channels.p.b(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.v(kotlinx.coroutines.channels.b0, kotlinx.coroutines.channels.c0, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005b A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #1 {all -> 0x0031, blocks: (B:11:0x002d, B:12:0x0053, B:14:0x005b, B:18:0x0064, B:19:0x006b), top: B:10:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064 A[Catch: all -> 0x0031, TRY_ENTER, TryCatch #1 {all -> 0x0031, blocks: (B:11:0x002d, B:12:0x0053, B:14:0x005b, B:18:0x0064, B:19:0x006b), top: B:10:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object w(kotlinx.coroutines.channels.b0 r5, kotlin.coroutines.e r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.channels.s.q
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.channels.s$q r0 = (kotlinx.coroutines.channels.s.q) r0
            int r1 = r0.f48408d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48408d = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.s$q r0 = new kotlinx.coroutines.channels.s$q
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f48407c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48408d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r5 = r0.f48406b
            kotlinx.coroutines.channels.l r5 = (kotlinx.coroutines.channels.l) r5
            java.lang.Object r0 = r0.f48405a
            kotlinx.coroutines.channels.b0 r0 = (kotlinx.coroutines.channels.b0) r0
            kotlin.g0.n(r6)     // Catch: java.lang.Throwable -> L31
            goto L53
        L31:
            r5 = move-exception
            goto L6f
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            kotlin.g0.n(r6)
            kotlinx.coroutines.channels.l r6 = r5.iterator()     // Catch: java.lang.Throwable -> L6c
            r0.f48405a = r5     // Catch: java.lang.Throwable -> L6c
            r0.f48406b = r6     // Catch: java.lang.Throwable -> L6c
            r0.f48408d = r3     // Catch: java.lang.Throwable -> L6c
            java.lang.Object r0 = r6.c(r0)     // Catch: java.lang.Throwable -> L6c
            if (r0 != r1) goto L4f
            return r1
        L4f:
            r4 = r0
            r0 = r5
            r5 = r6
            r6 = r4
        L53:
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch: java.lang.Throwable -> L31
            boolean r6 = r6.booleanValue()     // Catch: java.lang.Throwable -> L31
            if (r6 == 0) goto L64
            java.lang.Object r5 = r5.next()     // Catch: java.lang.Throwable -> L31
            r6 = 0
            kotlinx.coroutines.channels.p.b(r0, r6)
            return r5
        L64:
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException     // Catch: java.lang.Throwable -> L31
            java.lang.String r6 = "ReceiveChannel is empty."
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L31
            throw r5     // Catch: java.lang.Throwable -> L31
        L6c:
            r6 = move-exception
            r0 = r5
            r5 = r6
        L6f:
            throw r5     // Catch: java.lang.Throwable -> L70
        L70:
            r6 = move-exception
            kotlinx.coroutines.channels.p.b(r0, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.w(kotlinx.coroutines.channels.b0, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0060 A[Catch: all -> 0x0031, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:11:0x002d, B:12:0x0053, B:18:0x0060), top: B:10:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object x(kotlinx.coroutines.channels.b0 r5, kotlin.coroutines.e r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.channels.s.r
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.channels.s$r r0 = (kotlinx.coroutines.channels.s.r) r0
            int r1 = r0.f48412d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48412d = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.s$r r0 = new kotlinx.coroutines.channels.s$r
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f48411c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48412d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r5 = r0.f48410b
            kotlinx.coroutines.channels.l r5 = (kotlinx.coroutines.channels.l) r5
            java.lang.Object r0 = r0.f48409a
            kotlinx.coroutines.channels.b0 r0 = (kotlinx.coroutines.channels.b0) r0
            kotlin.g0.n(r6)     // Catch: java.lang.Throwable -> L31
            goto L53
        L31:
            r5 = move-exception
            goto L6b
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            kotlin.g0.n(r6)
            kotlinx.coroutines.channels.l r6 = r5.iterator()     // Catch: java.lang.Throwable -> L68
            r0.f48409a = r5     // Catch: java.lang.Throwable -> L68
            r0.f48410b = r6     // Catch: java.lang.Throwable -> L68
            r0.f48412d = r3     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r6.c(r0)     // Catch: java.lang.Throwable -> L68
            if (r0 != r1) goto L4f
            return r1
        L4f:
            r4 = r0
            r0 = r5
            r5 = r6
            r6 = r4
        L53:
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch: java.lang.Throwable -> L31
            boolean r6 = r6.booleanValue()     // Catch: java.lang.Throwable -> L31
            r1 = 0
            if (r6 != 0) goto L60
            kotlinx.coroutines.channels.p.b(r0, r1)
            return r1
        L60:
            java.lang.Object r5 = r5.next()     // Catch: java.lang.Throwable -> L31
            kotlinx.coroutines.channels.p.b(r0, r1)
            return r5
        L68:
            r6 = move-exception
            r0 = r5
            r5 = r6
        L6b:
            throw r5     // Catch: java.lang.Throwable -> L6c
        L6c:
            r6 = move-exception
            kotlinx.coroutines.channels.p.b(r0, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.s.x(kotlinx.coroutines.channels.b0, kotlin.coroutines.e):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.b0 y(kotlinx.coroutines.channels.b0 b0Var, kotlin.coroutines.i iVar, Function2 function2) {
        return kotlinx.coroutines.channels.x.g(w1.f49676a, iVar, 0, null, kotlinx.coroutines.channels.p.g(b0Var), new C0931s(b0Var, function2, null), 6, null);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.b0 z(kotlinx.coroutines.channels.b0 b0Var, kotlin.coroutines.i iVar, Function2 function2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            iVar = g1.g();
        }
        return y(b0Var, iVar, function2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.b0 I(kotlinx.coroutines.channels.b0 b0Var, kotlin.coroutines.i iVar, Function3 function3) {
        return kotlinx.coroutines.channels.p.y(kotlinx.coroutines.channels.p.L(b0Var, iVar, function3));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ kotlinx.coroutines.channels.b0 K(kotlinx.coroutines.channels.b0 b0Var, kotlin.coroutines.i iVar, Function2 function2) {
        return kotlinx.coroutines.channels.p.y(kotlinx.coroutines.channels.p.J(b0Var, iVar, function2));
    }
}
