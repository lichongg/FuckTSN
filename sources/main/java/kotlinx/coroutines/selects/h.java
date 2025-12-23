package kotlinx.coroutines.selects;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.v;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h<Q> implements g<Q> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Object f49542a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Function3<Object, m<?>, Object, n1> f49543b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Function3<Object, Object, Object, Object> f49544c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final Function3<m<?>, Object, Object, Function1<Throwable, n1>> f49545d;

    /* JADX WARN: Multi-variable type inference failed */
    public h(@NotNull Object obj, @NotNull Function3<Object, ? super m<?>, Object, n1> function3, @NotNull Function3<Object, Object, Object, ? extends Object> function32, @Nullable Function3<? super m<?>, Object, Object, ? extends Function1<? super Throwable, n1>> function33) {
        this.f49542a = obj;
        this.f49543b = function3;
        this.f49544c = function32;
        this.f49545d = function33;
    }

    @Override // kotlinx.coroutines.selects.k
    @Nullable
    public Function3<m<?>, Object, Object, Function1<Throwable, n1>> a() {
        return this.f49545d;
    }

    @Override // kotlinx.coroutines.selects.k
    @NotNull
    public Function3<Object, Object, Object, Object> b() {
        return this.f49544c;
    }

    @Override // kotlinx.coroutines.selects.k
    @NotNull
    public Function3<Object, m<?>, Object, n1> c() {
        return this.f49543b;
    }

    @Override // kotlinx.coroutines.selects.k
    @NotNull
    public Object d() {
        return this.f49542a;
    }

    public /* synthetic */ h(Object obj, Function3 function3, Function3 function32, Function3 function33, int i6, v vVar) {
        this(obj, function3, function32, (i6 & 8) != 0 ? null : function33);
    }
}
