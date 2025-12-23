package kotlinx.coroutines.flow;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.BuilderInference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.collections.a1;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.n1;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final String f49045a = "kotlinx.coroutines.flow.defaultConcurrency";

    @Nullable
    public static final <T> Object A(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return FlowKt__CollectKt.f(iVar, function2, eVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    @NotNull
    public static final <T, R> i<R> A0(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super i<? extends R>>, ? extends Object> function2) {
        return FlowKt__MigrationKt.l(iVar, function2);
    }

    @NotNull
    public static final <T> i<T> A1(@NotNull i<? extends T> iVar, @NotNull Function3<? super T, ? super T, ? super kotlin.coroutines.e<? super T>, ? extends Object> function3) {
        return FlowKt__TransformKt.j(iVar, function3);
    }

    @Nullable
    public static final <T> Object B(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return FlowKt__LimitKt.b(iVar, function2, eVar);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> i<R> B0(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super i<? extends R>>, ? extends Object> function2) {
        return FlowKt__MergeKt.a(iVar, function2);
    }

    @FlowPreview
    @NotNull
    public static final <T> i<T> B1(@NotNull i<? extends T> iVar, long j6) {
        return p.h(iVar, j6);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> i<R> C0(@NotNull i<? extends T> iVar, @BuilderInference @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super i<? extends R>>, ? extends Object> function2) {
        return FlowKt__MergeKt.b(iVar, function2);
    }

    @FlowPreview
    @NotNull
    public static final <T> i<T> C1(@NotNull i<? extends T> iVar, long j6) {
        return p.i(iVar, j6);
    }

    @NotNull
    public static final <T1, T2, R> i<R> D(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull Function3<? super T1, ? super T2, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3) {
        return FlowKt__ZipKt.c(iVar, iVar2, function3);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> i<R> D0(@NotNull i<? extends T> iVar, int i6, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super i<? extends R>>, ? extends Object> function2) {
        return FlowKt__MergeKt.c(iVar, i6, function2);
    }

    @NotNull
    public static final <T, R> i<R> D1(@NotNull i<? extends T> iVar, R r5, @BuilderInference @NotNull Function3<? super R, ? super T, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3) {
        return FlowKt__TransformKt.k(iVar, r5, function3);
    }

    @NotNull
    public static final <T1, T2, T3, R> i<R> E(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull i<? extends T3> iVar3, @BuilderInference @NotNull Function4<? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.e<? super R>, ? extends Object> function4) {
        return FlowKt__ZipKt.d(iVar, iVar2, iVar3, function4);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @ReplaceWith(expression = "scan(initial, operation)", imports = {}))
    @NotNull
    public static final <T, R> i<R> E1(@NotNull i<? extends T> iVar, R r5, @BuilderInference @NotNull Function3<? super R, ? super T, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3) {
        return FlowKt__MigrationKt.B(iVar, r5, function3);
    }

    @NotNull
    public static final <T1, T2, T3, T4, R> i<R> F(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull i<? extends T3> iVar3, @NotNull i<? extends T4> iVar4, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.e<? super R>, ? extends Object> function5) {
        return FlowKt__ZipKt.e(iVar, iVar2, iVar3, iVar4, function5);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    @NotNull
    public static final <T> i<T> F0(@NotNull i<? extends i<? extends T>> iVar) {
        return FlowKt__MigrationKt.m(iVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @ReplaceWith(expression = "runningReduce(operation)", imports = {}))
    @NotNull
    public static final <T> i<T> F1(@NotNull i<? extends T> iVar, @NotNull Function3<? super T, ? super T, ? super kotlin.coroutines.e<? super T>, ? extends Object> function3) {
        return FlowKt__MigrationKt.C(iVar, function3);
    }

    @NotNull
    public static final <T1, T2, T3, T4, T5, R> i<R> G(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull i<? extends T3> iVar3, @NotNull i<? extends T4> iVar4, @NotNull i<? extends T5> iVar5, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.e<? super R>, ? extends Object> function6) {
        return FlowKt__ZipKt.f(iVar, iVar2, iVar3, iVar4, iVar5, function6);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> i<T> G0(@NotNull i<? extends i<? extends T>> iVar) {
        return FlowKt__MergeKt.e(iVar);
    }

    @NotNull
    public static final <T> x<T> G1(@NotNull i<? extends T> iVar, @NotNull r0 r0Var, @NotNull c0 c0Var, int i6) {
        return r.g(iVar, r0Var, c0Var, i6);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> i<T> H0(@NotNull i<? extends i<? extends T>> iVar, int i6) {
        return FlowKt__MergeKt.f(iVar, i6);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "this.combine(other, transform)", imports = {}))
    @NotNull
    public static final <T1, T2, R> i<R> I(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull Function3<? super T1, ? super T2, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3) {
        return FlowKt__MigrationKt.b(iVar, iVar2, function3);
    }

    @Nullable
    public static final <T> Object I1(@NotNull i<? extends T> iVar, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return FlowKt__ReduceKt.j(iVar, eVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, transform)", imports = {}))
    @NotNull
    public static final <T1, T2, T3, R> i<R> J(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull i<? extends T3> iVar3, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.e<? super R>, ? extends Object> function4) {
        return FlowKt__MigrationKt.c(iVar, iVar2, iVar3, function4);
    }

    @NotNull
    public static final <T> i<T> J0(@BuilderInference @NotNull Function2<? super j<? super T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        return FlowKt__BuildersKt.n(function2);
    }

    @Nullable
    public static final <T> Object J1(@NotNull i<? extends T> iVar, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return FlowKt__ReduceKt.k(iVar, eVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @NotNull
    public static final <T1, T2, T3, T4, R> i<R> K(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull i<? extends T3> iVar3, @NotNull i<? extends T4> iVar4, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.e<? super R>, ? extends Object> function5) {
        return FlowKt__MigrationKt.d(iVar, iVar2, iVar3, iVar4, function5);
    }

    @JvmName(name = "flowCombine")
    @NotNull
    public static final <T1, T2, R> i<R> K0(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull Function3<? super T1, ? super T2, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3) {
        return FlowKt__ZipKt.p(iVar, iVar2, function3);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @ReplaceWith(expression = "drop(count)", imports = {}))
    @NotNull
    public static final <T> i<T> K1(@NotNull i<? extends T> iVar, int i6) {
        return FlowKt__MigrationKt.D(iVar, i6);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @NotNull
    public static final <T1, T2, T3, T4, T5, R> i<R> L(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull i<? extends T3> iVar3, @NotNull i<? extends T4> iVar4, @NotNull i<? extends T5> iVar5, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.e<? super R>, ? extends Object> function6) {
        return FlowKt__MigrationKt.e(iVar, iVar2, iVar3, iVar4, iVar5, function6);
    }

    @JvmName(name = "flowCombineTransform")
    @NotNull
    public static final <T1, T2, R> i<R> L0(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @BuilderInference @NotNull Function4<? super j<? super R>, ? super T1, ? super T2, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function4) {
        return FlowKt__ZipKt.q(iVar, iVar2, function4);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @ReplaceWith(expression = "onStart { emit(value) }", imports = {}))
    @NotNull
    public static final <T> i<T> L1(@NotNull i<? extends T> iVar, T t5) {
        return FlowKt__MigrationKt.E(iVar, t5);
    }

    @NotNull
    public static final <T> i<T> M0(T t5) {
        return FlowKt__BuildersKt.o(t5);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onStart { emitAll(other) }", imports = {}))
    @NotNull
    public static final <T> i<T> M1(@NotNull i<? extends T> iVar, @NotNull i<? extends T> iVar2) {
        return FlowKt__MigrationKt.F(iVar, iVar2);
    }

    @NotNull
    public static final <T1, T2, R> i<R> N(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @BuilderInference @NotNull Function4<? super j<? super R>, ? super T1, ? super T2, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function4) {
        return FlowKt__ZipKt.i(iVar, iVar2, function4);
    }

    @NotNull
    public static final <T> i<T> N0(@NotNull T... tArr) {
        return FlowKt__BuildersKt.p(tArr);
    }

    @Nullable
    public static final <T> Object N1(@NotNull i<? extends T> iVar, @NotNull r0 r0Var, @NotNull kotlin.coroutines.e<? super h0<? extends T>> eVar) {
        return r.i(iVar, r0Var, eVar);
    }

    @NotNull
    public static final <T1, T2, T3, R> i<R> O(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull i<? extends T3> iVar3, @BuilderInference @NotNull Function5<? super j<? super R>, ? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function5) {
        return FlowKt__ZipKt.j(iVar, iVar2, iVar3, function5);
    }

    @NotNull
    public static final <T> i<T> O0(@NotNull i<? extends T> iVar, @NotNull kotlin.coroutines.i iVar2) {
        return n.h(iVar, iVar2);
    }

    @NotNull
    public static final <T> h0<T> O1(@NotNull i<? extends T> iVar, @NotNull r0 r0Var, @NotNull c0 c0Var, T t5) {
        return r.j(iVar, r0Var, c0Var, t5);
    }

    @NotNull
    public static final <T1, T2, T3, T4, R> i<R> P(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull i<? extends T3> iVar3, @NotNull i<? extends T4> iVar4, @BuilderInference @NotNull Function6<? super j<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function6) {
        return FlowKt__ZipKt.k(iVar, iVar2, iVar3, iVar4, function6);
    }

    @Nullable
    public static final <T, R> Object P0(@NotNull i<? extends T> iVar, R r5, @NotNull Function3<? super R, ? super T, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3, @NotNull kotlin.coroutines.e<? super R> eVar) {
        return FlowKt__ReduceKt.e(iVar, r5, function3, eVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void P1(@NotNull i<? extends T> iVar) {
        FlowKt__MigrationKt.G(iVar);
    }

    @NotNull
    public static final <T1, T2, T3, T4, T5, R> i<R> Q(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull i<? extends T3> iVar3, @NotNull i<? extends T4> iVar4, @NotNull i<? extends T5> iVar5, @BuilderInference @NotNull Function7<? super j<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function7) {
        return FlowKt__ZipKt.l(iVar, iVar2, iVar3, iVar4, iVar5, function7);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @ReplaceWith(expression = "collect(action)", imports = {}))
    public static final <T> void Q0(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        FlowKt__MigrationKt.n(iVar, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void Q1(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        FlowKt__MigrationKt.H(iVar, function2);
    }

    public static final int R0() {
        return FlowKt__MergeKt.h();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void R1(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2, @NotNull Function2<? super Throwable, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function22) {
        FlowKt__MigrationKt.I(iVar, function2, function22);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @ReplaceWith(expression = "let(transformer)", imports = {}))
    @NotNull
    public static final <T, R> i<R> S(@NotNull i<? extends T> iVar, @NotNull Function1<? super i<? extends T>, ? extends i<? extends R>> function1) {
        return FlowKt__MigrationKt.f(iVar, function1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'flowOn' instead")
    @NotNull
    public static final <T> i<T> S1(@NotNull i<? extends T> iVar, @NotNull kotlin.coroutines.i iVar2) {
        return FlowKt__MigrationKt.J(iVar, iVar2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    @NotNull
    public static final <T, R> i<R> T(@NotNull i<? extends T> iVar, @NotNull Function1<? super T, ? extends i<? extends R>> function1) {
        return FlowKt__MigrationKt.g(iVar, function1);
    }

    @Nullable
    public static final <T> Object T0(@NotNull i<? extends T> iVar, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return FlowKt__ReduceKt.g(iVar, eVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @ReplaceWith(expression = "this.flatMapLatest(transform)", imports = {}))
    @NotNull
    public static final <T, R> i<R> T1(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super i<? extends R>>, ? extends Object> function2) {
        return FlowKt__MigrationKt.K(iVar, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emit(value) }", imports = {}))
    @NotNull
    public static final <T> i<T> U(@NotNull i<? extends T> iVar, T t5) {
        return FlowKt__MigrationKt.h(iVar, t5);
    }

    @Nullable
    public static final <T> Object U0(@NotNull i<? extends T> iVar, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return FlowKt__ReduceKt.h(iVar, eVar);
    }

    @NotNull
    public static final <T> i<T> U1(@NotNull i<? extends T> iVar, int i6) {
        return FlowKt__LimitKt.g(iVar, i6);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { if (it == null) emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onCompletion { if (it == null) emitAll(other) }", imports = {}))
    @NotNull
    public static final <T> i<T> V(@NotNull i<? extends T> iVar, @NotNull i<? extends T> iVar2) {
        return FlowKt__MigrationKt.i(iVar, iVar2);
    }

    @NotNull
    public static final <T> e2 V0(@NotNull i<? extends T> iVar, @NotNull r0 r0Var) {
        return FlowKt__CollectKt.h(iVar, r0Var);
    }

    @NotNull
    public static final <T> i<T> V1(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2) {
        return FlowKt__LimitKt.h(iVar, function2);
    }

    @NotNull
    public static final <T> i<T> W(@NotNull i<? extends T> iVar) {
        return n.g(iVar);
    }

    @NotNull
    public static final <T, R> i<R> W0(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2) {
        return FlowKt__TransformKt.f(iVar, function2);
    }

    @FlowPreview
    @NotNull
    public static final <T> i<T> W1(@NotNull i<? extends T> iVar, long j6) {
        return p.j(iVar, j6);
    }

    @NotNull
    public static final <T> i<T> X(@NotNull kotlinx.coroutines.channels.b0<? extends T> b0Var) {
        return l.c(b0Var);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> i<R> X0(@NotNull i<? extends T> iVar, @BuilderInference @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2) {
        return FlowKt__MergeKt.k(iVar, function2);
    }

    @Nullable
    public static final <T, C extends Collection<? super T>> Object X1(@NotNull i<? extends T> iVar, @NotNull C c6, @NotNull kotlin.coroutines.e<? super C> eVar) {
        return m.a(iVar, c6, eVar);
    }

    @Nullable
    public static final <T> Object Y(@NotNull i<? extends T> iVar, @NotNull kotlin.coroutines.e<? super Integer> eVar) {
        return o.a(iVar, eVar);
    }

    @NotNull
    public static final <T, R> i<R> Y0(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2) {
        return FlowKt__TransformKt.g(iVar, function2);
    }

    @Nullable
    public static final <T> Object Y1(@NotNull i<? extends T> iVar, @NotNull List<T> list, @NotNull kotlin.coroutines.e<? super List<? extends T>> eVar) {
        return m.b(iVar, list, eVar);
    }

    @Nullable
    public static final <T> Object Z(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super Integer> eVar) {
        return o.b(iVar, function2, eVar);
    }

    @NotNull
    public static final <T> i<T> Z0(@NotNull Iterable<? extends i<? extends T>> iterable) {
        return FlowKt__MergeKt.l(iterable);
    }

    @NotNull
    public static final <T> i<T> a(@NotNull Iterable<? extends T> iterable) {
        return FlowKt__BuildersKt.a(iterable);
    }

    @FlowPreview
    @NotNull
    public static final <T> i<T> a0(@NotNull i<? extends T> iVar, long j6) {
        return p.a(iVar, j6);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    @NotNull
    public static final <T> i<T> a1(@NotNull i<? extends i<? extends T>> iVar) {
        return FlowKt__MigrationKt.o(iVar);
    }

    @Nullable
    public static final <T> Object a2(@NotNull i<? extends T> iVar, @NotNull Set<T> set, @NotNull kotlin.coroutines.e<? super Set<? extends T>> eVar) {
        return m.d(iVar, set, eVar);
    }

    @NotNull
    public static final <T> i<T> b(@NotNull Iterator<? extends T> it) {
        return FlowKt__BuildersKt.b(it);
    }

    @FlowPreview
    @OverloadResolutionByLambdaReturnType
    @NotNull
    public static final <T> i<T> b0(@NotNull i<? extends T> iVar, @NotNull Function1<? super T, Long> function1) {
        return p.b(iVar, function1);
    }

    @NotNull
    public static final <T> i<T> b1(@NotNull i<? extends T>... iVarArr) {
        return FlowKt__MergeKt.m(iVarArr);
    }

    @NotNull
    public static final <T> i<T> c(@NotNull Function0<? extends T> function0) {
        return FlowKt__BuildersKt.c(function0);
    }

    @FlowPreview
    @NotNull
    public static final <T> i<T> c0(@NotNull i<? extends T> iVar, long j6) {
        return p.c(iVar, j6);
    }

    @NotNull
    public static final Void c1() {
        return FlowKt__MigrationKt.p();
    }

    @NotNull
    public static final <T, R> i<R> c2(@NotNull i<? extends T> iVar, @BuilderInference @NotNull Function3<? super j<? super R>, ? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3) {
        return FlowKt__EmittersKt.g(iVar, function3);
    }

    @NotNull
    public static final <T> i<T> d(@NotNull Function1<? super kotlin.coroutines.e<? super T>, ? extends Object> function1) {
        return FlowKt__BuildersKt.d(function1);
    }

    @FlowPreview
    @JvmName(name = "debounceDuration")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T> i<T> d0(@NotNull i<? extends T> iVar, @NotNull Function1<? super T, kotlin.time.h> function1) {
        return p.d(iVar, function1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @NotNull
    public static final <T> i<T> d1(@NotNull i<? extends T> iVar, @NotNull kotlin.coroutines.i iVar2) {
        return FlowKt__MigrationKt.q(iVar, iVar2);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> i<R> d2(@NotNull i<? extends T> iVar, @BuilderInference @NotNull Function3<? super j<? super R>, ? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3) {
        return FlowKt__MergeKt.n(iVar, function3);
    }

    @NotNull
    public static final i<Integer> e(@NotNull kotlin.ranges.m mVar) {
        return FlowKt__BuildersKt.e(mVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onEach { delay(timeMillis) }", imports = {}))
    @NotNull
    public static final <T> i<T> e0(@NotNull i<? extends T> iVar, long j6) {
        return FlowKt__MigrationKt.j(iVar, j6);
    }

    @NotNull
    public static final <T> i<T> e1(@NotNull i<? extends T> iVar, @NotNull Function3<? super j<? super T>, ? super Throwable, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3) {
        return FlowKt__EmittersKt.d(iVar, function3);
    }

    @NotNull
    public static final <T, R> i<R> e2(@NotNull i<? extends T> iVar, @BuilderInference @NotNull Function3<? super j<? super R>, ? super T, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function3) {
        return FlowKt__LimitKt.i(iVar, function3);
    }

    @NotNull
    public static final i<Long> f(@NotNull kotlin.ranges.p pVar) {
        return FlowKt__BuildersKt.f(pVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onStart { delay(timeMillis) }", imports = {}))
    @NotNull
    public static final <T> i<T> f0(@NotNull i<? extends T> iVar, long j6) {
        return FlowKt__MigrationKt.k(iVar, j6);
    }

    @NotNull
    public static final <T> i<T> f1(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        return FlowKt__TransformKt.h(iVar, function2);
    }

    @PublishedApi
    @NotNull
    public static final <T, R> i<R> f2(@NotNull i<? extends T> iVar, @BuilderInference @NotNull Function3<? super j<? super R>, ? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3) {
        return FlowKt__EmittersKt.h(iVar, function3);
    }

    @NotNull
    public static final <T> i<T> g(@NotNull kotlin.sequences.m<? extends T> mVar) {
        return FlowKt__BuildersKt.g(mVar);
    }

    @NotNull
    public static final <T> i<T> g0(@NotNull i<? extends T> iVar) {
        return q.a(iVar);
    }

    @NotNull
    public static final <T> i<T> g1(@NotNull i<? extends T> iVar, @NotNull Function2<? super j<? super T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        return FlowKt__EmittersKt.e(iVar, function2);
    }

    @NotNull
    public static final <T> i<a1<T>> g2(@NotNull i<? extends T> iVar) {
        return FlowKt__TransformKt.l(iVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    @NotNull
    public static final <T> i<T> h(@NotNull kotlinx.coroutines.channels.d<T> dVar) {
        return l.b(dVar);
    }

    @NotNull
    public static final <T> i<T> h0(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super T, Boolean> function2) {
        return q.b(iVar, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    @NotNull
    public static final <T> i<T> h1(@NotNull i<? extends T> iVar, @NotNull i<? extends T> iVar2) {
        return FlowKt__MigrationKt.r(iVar, iVar2);
    }

    @NotNull
    public static final <T1, T2, R> i<R> h2(@NotNull i<? extends T1> iVar, @NotNull i<? extends T2> iVar2, @NotNull Function3<? super T1, ? super T2, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3) {
        return FlowKt__ZipKt.s(iVar, iVar2, function3);
    }

    @NotNull
    public static final i<Integer> i(@NotNull int[] iArr) {
        return FlowKt__BuildersKt.h(iArr);
    }

    @NotNull
    public static final <T, K> i<T> i0(@NotNull i<? extends T> iVar, @NotNull Function1<? super T, ? extends K> function1) {
        return q.c(iVar, function1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    @NotNull
    public static final <T> i<T> i1(@NotNull i<? extends T> iVar, @NotNull i<? extends T> iVar2) {
        return FlowKt__MigrationKt.s(iVar, iVar2);
    }

    @NotNull
    public static final i<Long> j(@NotNull long[] jArr) {
        return FlowKt__BuildersKt.i(jArr);
    }

    @NotNull
    public static final <T> i<T> j0(@NotNull i<? extends T> iVar, int i6) {
        return FlowKt__LimitKt.d(iVar, i6);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emit(fallback) }", imports = {}))
    @NotNull
    public static final <T> i<T> j1(@NotNull i<? extends T> iVar, T t5) {
        return FlowKt__MigrationKt.t(iVar, t5);
    }

    @NotNull
    public static final <T> i<T> k(@NotNull T[] tArr) {
        return FlowKt__BuildersKt.j(tArr);
    }

    @NotNull
    public static final <T> i<T> k0(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2) {
        return FlowKt__LimitKt.e(iVar, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    @NotNull
    public static final <T> i<T> k1(@NotNull i<? extends T> iVar, T t5, @NotNull Function1<? super Throwable, Boolean> function1) {
        return FlowKt__MigrationKt.u(iVar, t5, function1);
    }

    @NotNull
    public static final <T> x<T> l(@NotNull s<T> sVar) {
        return r.a(sVar);
    }

    @Nullable
    public static final <T> Object l0(@NotNull j<? super T> jVar, @NotNull kotlinx.coroutines.channels.b0<? extends T> b0Var, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return l.d(jVar, b0Var, eVar);
    }

    @NotNull
    public static final <T> h0<T> m(@NotNull t<T> tVar) {
        return r.b(tVar);
    }

    @Nullable
    public static final <T> Object m0(@NotNull j<? super T> jVar, @NotNull i<? extends T> iVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return FlowKt__CollectKt.g(jVar, iVar, eVar);
    }

    @NotNull
    public static final <T> i<T> m1(@NotNull i<? extends T> iVar, @NotNull Function2<? super j<? super T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        return FlowKt__EmittersKt.f(iVar, function2);
    }

    @NotNull
    public static final <T> i<T> n0() {
        return FlowKt__BuildersKt.m();
    }

    @NotNull
    public static final <T> x<T> n1(@NotNull x<? extends T> xVar, @NotNull Function2<? super j<? super T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        return r.f(xVar, function2);
    }

    @NotNull
    public static final <T> i<T> o(@NotNull i<? extends T> iVar, int i6, @NotNull BufferOverflow bufferOverflow) {
        return n.b(iVar, i6, bufferOverflow);
    }

    public static final void o0(@NotNull j<?> jVar) {
        FlowKt__EmittersKt.b(jVar);
    }

    @NotNull
    public static final <T> kotlinx.coroutines.channels.b0<T> o1(@NotNull i<? extends T> iVar, @NotNull r0 r0Var) {
        return l.f(iVar, r0Var);
    }

    @NotNull
    public static final <T> i<T> p0(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2) {
        return FlowKt__TransformKt.a(iVar, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, 0)", imports = {}))
    @NotNull
    public static final <T> i<T> p1(@NotNull i<? extends T> iVar) {
        return FlowKt__MigrationKt.w(iVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.buffer(bufferSize).shareIn(scope, 0)", imports = {}))
    @NotNull
    public static final <T> i<T> q1(@NotNull i<? extends T> iVar, int i6) {
        return FlowKt__MigrationKt.x(iVar, i6);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports = {}))
    @NotNull
    public static final <T> i<T> r(@NotNull i<? extends T> iVar) {
        return FlowKt__MigrationKt.a(iVar);
    }

    @NotNull
    public static final <R> i<R> r0(@NotNull i<?> iVar, @NotNull kotlin.reflect.d<R> dVar) {
        return FlowKt__TransformKt.c(iVar, dVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @NotNull
    public static final <T> i<T> r1(@NotNull i<? extends T> iVar, @NotNull kotlin.coroutines.i iVar2) {
        return FlowKt__MigrationKt.y(iVar, iVar2);
    }

    @NotNull
    public static final <T> i<T> s(@BuilderInference @NotNull Function2<? super kotlinx.coroutines.channels.z<? super T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        return FlowKt__BuildersKt.k(function2);
    }

    @NotNull
    public static final <T> i<T> s0(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2) {
        return FlowKt__TransformKt.d(iVar, function2);
    }

    @NotNull
    public static final <T> i<T> s1(@NotNull kotlinx.coroutines.channels.b0<? extends T> b0Var) {
        return l.g(b0Var);
    }

    @NotNull
    public static final <T> i<T> t(@NotNull i<? extends T> iVar) {
        return n.e(iVar);
    }

    @NotNull
    public static final <T> i<T> t0(@NotNull i<? extends T> iVar) {
        return FlowKt__TransformKt.e(iVar);
    }

    @Nullable
    public static final <S, T extends S> Object t1(@NotNull i<? extends T> iVar, @NotNull Function3<? super S, ? super T, ? super kotlin.coroutines.e<? super S>, ? extends Object> function3, @NotNull kotlin.coroutines.e<? super S> eVar) {
        return FlowKt__ReduceKt.i(iVar, function3, eVar);
    }

    @NotNull
    public static final <T> i<T> u(@NotNull i<? extends T> iVar, @NotNull Function3<? super j<? super T>, ? super Throwable, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3) {
        return FlowKt__ErrorsKt.a(iVar, function3);
    }

    @Nullable
    public static final <T> Object u0(@NotNull i<? extends T> iVar, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return FlowKt__ReduceKt.a(iVar, eVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE)", imports = {}))
    @NotNull
    public static final <T> i<T> u1(@NotNull i<? extends T> iVar) {
        return FlowKt__MigrationKt.z(iVar);
    }

    @Nullable
    public static final <T> Object v(@NotNull i<? extends T> iVar, @NotNull j<? super T> jVar, @NotNull kotlin.coroutines.e<? super Throwable> eVar) {
        return FlowKt__ErrorsKt.b(iVar, jVar, eVar);
    }

    @Nullable
    public static final <T> Object v0(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return FlowKt__ReduceKt.b(iVar, function2, eVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, bufferSize)", imports = {}))
    @NotNull
    public static final <T> i<T> v1(@NotNull i<? extends T> iVar, int i6) {
        return FlowKt__MigrationKt.A(iVar, i6);
    }

    @NotNull
    public static final <T> i<T> w(@BuilderInference @NotNull Function2<? super kotlinx.coroutines.channels.z<? super T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        return FlowKt__BuildersKt.l(function2);
    }

    @Nullable
    public static final <T> Object w0(@NotNull i<? extends T> iVar, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return FlowKt__ReduceKt.c(iVar, eVar);
    }

    @NotNull
    public static final <T> i<T> w1(@NotNull i<? extends T> iVar, long j6, @NotNull Function2<? super Throwable, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2) {
        return FlowKt__ErrorsKt.e(iVar, j6, function2);
    }

    @Nullable
    public static final Object x(@NotNull i<?> iVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return FlowKt__CollectKt.a(iVar, eVar);
    }

    @Nullable
    public static final <T> Object x0(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return FlowKt__ReduceKt.d(iVar, function2, eVar);
    }

    @NotNull
    public static final kotlinx.coroutines.channels.b0<n1> y0(@NotNull r0 r0Var, long j6, long j7) {
        return p.f(r0Var, j6, j7);
    }

    @NotNull
    public static final <T> i<T> y1(@NotNull i<? extends T> iVar, @NotNull Function4<? super j<? super T>, ? super Throwable, ? super Long, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function4) {
        return FlowKt__ErrorsKt.g(iVar, function4);
    }

    @Nullable
    public static final <T> Object z(@NotNull i<? extends T> iVar, @NotNull Function3<? super Integer, ? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return FlowKt__CollectKt.d(iVar, function3, eVar);
    }

    @NotNull
    public static final <T, R> i<R> z1(@NotNull i<? extends T> iVar, R r5, @BuilderInference @NotNull Function3<? super R, ? super T, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3) {
        return FlowKt__TransformKt.i(iVar, r5, function3);
    }
}
