package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.n1;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.channels.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final String f48247a = "Channel was closed";

    @PublishedApi
    @NotNull
    public static final <E, R> b0<R> J(@NotNull b0<? extends E> b0Var, @NotNull kotlin.coroutines.i iVar, @NotNull Function2<? super E, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2) {
        return s.E(b0Var, iVar, function2);
    }

    @PublishedApi
    @NotNull
    public static final <E, R> b0<R> L(@NotNull b0<? extends E> b0Var, @NotNull kotlin.coroutines.i iVar, @NotNull Function3<? super Integer, ? super E, ? super kotlin.coroutines.e<? super R>, ? extends Object> function3) {
        return s.G(b0Var, iVar, function3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Left for binary compatibility")
    public static final /* synthetic */ b0 W(b0 b0Var) {
        b0 F;
        F = s.F(b0Var, null, new s.c0(b0Var, null), 1, null);
        return F;
    }

    @PublishedApi
    public static final void b(@NotNull b0<?> b0Var, @Nullable Throwable th) {
        r.a(b0Var, th);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @ObsoleteCoroutinesApi
    public static final <E, R> R c(@NotNull d<E> dVar, @NotNull Function1<? super b0<? extends E>, ? extends R> function1) {
        return (R) r.b(dVar, function1);
    }

    public static final <E, R> R d(@NotNull b0<? extends E> b0Var, @NotNull Function1<? super b0<? extends E>, ? extends R> function1) {
        return (R) r.c(b0Var, function1);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @Nullable
    public static final <E> Object e(@NotNull d<E> dVar, @NotNull Function1<? super E, n1> function1, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return r.d(dVar, function1, eVar);
    }

    @PublishedApi
    @Nullable
    public static final <E, C extends c0<? super E>> Object e0(@NotNull b0<? extends E> b0Var, @NotNull C c6, @NotNull kotlin.coroutines.e<? super C> eVar) {
        return s.W(b0Var, c6, eVar);
    }

    @Nullable
    public static final <E> Object f(@NotNull b0<? extends E> b0Var, @NotNull Function1<? super E, n1> function1, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return r.e(b0Var, function1, eVar);
    }

    @PublishedApi
    @Nullable
    public static final <E, C extends Collection<? super E>> Object f0(@NotNull b0<? extends E> b0Var, @NotNull C c6, @NotNull kotlin.coroutines.e<? super C> eVar) {
        return s.X(b0Var, c6, eVar);
    }

    @PublishedApi
    @NotNull
    public static final Function1<Throwable, n1> g(@NotNull b0<?> b0Var) {
        return s.b(b0Var);
    }

    @Nullable
    public static final <E> Object g0(@NotNull b0<? extends E> b0Var, @NotNull kotlin.coroutines.e<? super List<? extends E>> eVar) {
        return r.j(b0Var, eVar);
    }

    @PublishedApi
    @NotNull
    public static final Function1<Throwable, n1> h(@NotNull b0<?>... b0VarArr) {
        return s.c(b0VarArr);
    }

    @PublishedApi
    @Nullable
    public static final <K, V, M extends Map<? super K, ? super V>> Object h0(@NotNull b0<? extends Pair<? extends K, ? extends V>> b0Var, @NotNull M m6, @NotNull kotlin.coroutines.e<? super M> eVar) {
        return s.Y(b0Var, m6, eVar);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object i0(b0 b0Var, kotlin.coroutines.e eVar) {
        Object h02;
        h02 = h0(b0Var, new LinkedHashMap(), eVar);
        return h02;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ b0 j(b0 b0Var) {
        b0 g6;
        g6 = s.g(b0Var, null, new s.e(null), 1, null);
        return g6;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object j0(b0 b0Var, kotlin.coroutines.e eVar) {
        Object f02;
        f02 = f0(b0Var, new ArrayList(), eVar);
        return f02;
    }

    @PublishedApi
    @NotNull
    public static final <E, K> b0<E> k(@NotNull b0<? extends E> b0Var, @NotNull kotlin.coroutines.i iVar, @NotNull Function2<? super E, ? super kotlin.coroutines.e<? super K>, ? extends Object> function2) {
        return s.f(b0Var, iVar, function2);
    }

    @PublishedApi
    @Nullable
    public static final <E> Object k0(@NotNull b0<? extends E> b0Var, @NotNull kotlin.coroutines.e<? super Set<E>> eVar) {
        return s.b0(b0Var, eVar);
    }

    @NotNull
    public static final <E> Object m0(@NotNull c0<? super E> c0Var, E e6) {
        return q.b(c0Var, e6);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ b0 p0(b0 b0Var, b0 b0Var2) {
        b0 h02;
        h02 = s.h0(b0Var, b0Var2, null, s.l0.f48379a, 2, null);
        return h02;
    }

    @PublishedApi
    @NotNull
    public static final <E, R, V> b0<V> q0(@NotNull b0<? extends E> b0Var, @NotNull b0<? extends R> b0Var2, @NotNull kotlin.coroutines.i iVar, @NotNull Function2<? super E, ? super R, ? extends V> function2) {
        return s.g0(b0Var, b0Var2, iVar, function2);
    }

    @PublishedApi
    @NotNull
    public static final <E> b0<E> s(@NotNull b0<? extends E> b0Var, @NotNull kotlin.coroutines.i iVar, @NotNull Function2<? super E, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2) {
        return s.n(b0Var, iVar, function2);
    }

    @PublishedApi
    @NotNull
    public static final <E> b0<E> y(@NotNull b0<? extends E> b0Var) {
        return s.t(b0Var);
    }
}
