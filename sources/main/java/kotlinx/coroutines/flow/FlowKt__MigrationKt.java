package kotlinx.coroutines.flow;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import kotlin.BuilderInference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.ReplaceWith;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.a1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMigration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Migration.kt\nkotlinx/coroutines/flow/FlowKt__MigrationKt\n+ 2 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n*L\n1#1,496:1\n193#2:497\n*S KotlinDebug\n*F\n+ 1 Migration.kt\nkotlinx/coroutines/flow/FlowKt__MigrationKt\n*L\n435#1:497\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class FlowKt__MigrationKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$delayEach$1", f = "Migration.kt", i = {}, l = {427}, m = "invokeSuspend", n = {}, s = {})
    static final class a<T> extends SuspendLambda implements Function2<T, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48697a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f48698b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j6, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f48698b = j6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            return new a(this.f48698b, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(T t5, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(t5, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f48697a;
            if (i6 != 0) {
                if (i6 == 1) {
                    kotlin.g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                kotlin.g0.n(obj);
                long j6 = this.f48698b;
                this.f48697a = 1;
                if (a1.b(j6, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$delayFlow$1", f = "Migration.kt", i = {}, l = {TTAdConstant.VIDEO_COVER_URL_CODE}, m = "invokeSuspend", n = {}, s = {})
    static final class b<T> extends SuspendLambda implements Function2<j<? super T>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48699a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f48700b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j6, kotlin.coroutines.e<? super b> eVar) {
            super(2, eVar);
            this.f48700b = j6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            return new b(this.f48700b, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull j<? super T> jVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((b) create(jVar, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f48699a;
            if (i6 != 0) {
                if (i6 == 1) {
                    kotlin.g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                kotlin.g0.n(obj);
                long j6 = this.f48700b;
                this.f48699a = 1;
                if (a1.b(j6, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c extends Lambda implements Function1<Throwable, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f48701a = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(@NotNull Throwable th) {
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$onErrorReturn$2", f = "Migration.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_PREDELAY}, m = "invokeSuspend", n = {}, s = {})
    static final class d<T> extends SuspendLambda implements Function3<j<? super T>, Throwable, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48702a;

        /* renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f48703b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f48704c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Throwable, Boolean> f48705d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ T f48706e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(Function1<? super Throwable, Boolean> function1, T t5, kotlin.coroutines.e<? super d> eVar) {
            super(3, eVar);
            this.f48705d = function1;
            this.f48706e = t5;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull j<? super T> jVar, @NotNull Throwable th, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            d dVar = new d(this.f48705d, this.f48706e, eVar);
            dVar.f48703b = jVar;
            dVar.f48704c = th;
            return dVar.invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f48702a;
            if (i6 != 0) {
                if (i6 == 1) {
                    kotlin.g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                kotlin.g0.n(obj);
                j jVar = (j) this.f48703b;
                Throwable th = (Throwable) this.f48704c;
                if (this.f48705d.invoke(th).booleanValue()) {
                    T t5 = this.f48706e;
                    this.f48703b = null;
                    this.f48702a = 1;
                    if (jVar.emit(t5, this) == l6) {
                        return l6;
                    }
                } else {
                    throw th;
                }
            }
            return n1.f44123a;
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @ReplaceWith(expression = "this.flatMapLatest(transform)", imports = {}))
    @NotNull
    public static final <T, R> i<R> K(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super i<? extends R>>, ? extends Object> function2) {
        return k.d2(iVar, new FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(function2, null));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onEach { delay(timeMillis) }", imports = {}))
    @NotNull
    public static final <T> i<T> j(@NotNull i<? extends T> iVar, long j6) {
        return k.f1(iVar, new a(j6, null));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onStart { delay(timeMillis) }", imports = {}))
    @NotNull
    public static final <T> i<T> k(@NotNull i<? extends T> iVar, long j6) {
        return k.m1(iVar, new b(j6, null));
    }

    @NotNull
    public static final Void p() {
        throw new UnsupportedOperationException("Not implemented, should not be called");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    @NotNull
    public static final <T> i<T> u(@NotNull i<? extends T> iVar, T t5, @NotNull Function1<? super Throwable, Boolean> function1) {
        return k.u(iVar, new d(function1, t5, null));
    }

    public static /* synthetic */ i v(i iVar, Object obj, Function1 function1, int i6, Object obj2) {
        if ((i6 & 2) != 0) {
            function1 = c.f48701a;
        }
        return k.k1(iVar, obj, function1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, bufferSize)", imports = {}))
    @NotNull
    public static final <T> i<T> A(@NotNull i<? extends T> iVar, int i6) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @ReplaceWith(expression = "scan(initial, operation)", imports = {}))
    @NotNull
    public static final <T, R> i<R> B(@NotNull i<? extends T> iVar, R r5, @BuilderInference @NotNull Function3<? super R, ? super T, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @ReplaceWith(expression = "runningReduce(operation)", imports = {}))
    @NotNull
    public static final <T> i<T> C(@NotNull i<? extends T> iVar, @NotNull Function3<? super T, ? super T, ? super kotlin.coroutines.e<? super T>, ? extends Object> function3) {
        return k.A1(iVar, function3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @ReplaceWith(expression = "drop(count)", imports = {}))
    @NotNull
    public static final <T> i<T> D(@NotNull i<? extends T> iVar, int i6) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @ReplaceWith(expression = "onStart { emit(value) }", imports = {}))
    @NotNull
    public static final <T> i<T> E(@NotNull i<? extends T> iVar, T t5) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onStart { emitAll(other) }", imports = {}))
    @NotNull
    public static final <T> i<T> F(@NotNull i<? extends T> iVar, @NotNull i<? extends T> iVar2) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void G(@NotNull i<? extends T> iVar) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void H(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void I(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2, @NotNull Function2<? super Throwable, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function22) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'flowOn' instead")
    @NotNull
    public static final <T> i<T> J(@NotNull i<? extends T> iVar, @NotNull kotlin.coroutines.i iVar2) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports = {}))
    @NotNull
    public static final <T> i<T> a(@NotNull i<? extends T> iVar) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "this.combine(other, transform)", imports = {}))
    @NotNull
    public static final <T1, T2, R> i<R> b(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull Function3<? super T1, ? super T2, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3) {
        return k.D(iVar, iVar2, function3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, transform)", imports = {}))
    @NotNull
    public static final <T1, T2, T3, R> i<R> c(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull i<? extends T3> iVar3, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.e<? super R>, ? extends Object> function4) {
        return k.E(iVar, iVar2, iVar3, function4);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @NotNull
    public static final <T1, T2, T3, T4, R> i<R> d(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull i<? extends T3> iVar3, @NotNull i<? extends T4> iVar4, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.e<? super R>, ? extends Object> function5) {
        return k.F(iVar, iVar2, iVar3, iVar4, function5);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @NotNull
    public static final <T1, T2, T3, T4, T5, R> i<R> e(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull i<? extends T3> iVar3, @NotNull i<? extends T4> iVar4, @NotNull i<? extends T5> iVar5, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.e<? super R>, ? extends Object> function6) {
        return k.G(iVar, iVar2, iVar3, iVar4, iVar5, function6);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @ReplaceWith(expression = "let(transformer)", imports = {}))
    @NotNull
    public static final <T, R> i<R> f(@NotNull i<? extends T> iVar, @NotNull Function1<? super i<? extends T>, ? extends i<? extends R>> function1) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    @NotNull
    public static final <T, R> i<R> g(@NotNull i<? extends T> iVar, @NotNull Function1<? super T, ? extends i<? extends R>> function1) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emit(value) }", imports = {}))
    @NotNull
    public static final <T> i<T> h(@NotNull i<? extends T> iVar, T t5) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { if (it == null) emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onCompletion { if (it == null) emitAll(other) }", imports = {}))
    @NotNull
    public static final <T> i<T> i(@NotNull i<? extends T> iVar, @NotNull i<? extends T> iVar2) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    @NotNull
    public static final <T, R> i<R> l(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super i<? extends R>>, ? extends Object> function2) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    @NotNull
    public static final <T> i<T> m(@NotNull i<? extends i<? extends T>> iVar) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @ReplaceWith(expression = "collect(action)", imports = {}))
    public static final <T> void n(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    @NotNull
    public static final <T> i<T> o(@NotNull i<? extends i<? extends T>> iVar) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @NotNull
    public static final <T> i<T> q(@NotNull i<? extends T> iVar, @NotNull kotlin.coroutines.i iVar2) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    @NotNull
    public static final <T> i<T> r(@NotNull i<? extends T> iVar, @NotNull i<? extends T> iVar2) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    @NotNull
    public static final <T> i<T> s(@NotNull i<? extends T> iVar, @NotNull i<? extends T> iVar2) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emit(fallback) }", imports = {}))
    @NotNull
    public static final <T> i<T> t(@NotNull i<? extends T> iVar, T t5) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, 0)", imports = {}))
    @NotNull
    public static final <T> i<T> w(@NotNull i<? extends T> iVar) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.buffer(bufferSize).shareIn(scope, 0)", imports = {}))
    @NotNull
    public static final <T> i<T> x(@NotNull i<? extends T> iVar, int i6) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @NotNull
    public static final <T> i<T> y(@NotNull i<? extends T> iVar, @NotNull kotlin.coroutines.i iVar2) {
        k.c1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE)", imports = {}))
    @NotNull
    public static final <T> i<T> z(@NotNull i<? extends T> iVar) {
        k.c1();
        throw new KotlinNothingValueException();
    }
}
