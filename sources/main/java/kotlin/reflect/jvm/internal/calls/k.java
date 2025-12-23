package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k implements g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f44307a = new k();

    public boolean d() {
        return false;
    }

    @Nullable
    public Void e() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    @Nullable
    public Object call(@NotNull Object[] args) {
        g0.p(args, "args");
        throw new UnsupportedOperationException("call/callBy are not supported for this declaration.");
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    @NotNull
    public Type getReturnType() {
        Class TYPE = Void.TYPE;
        g0.o(TYPE, "TYPE");
        return TYPE;
    }

    private k() {
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    public boolean a() {
        return d();
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    @NotNull
    public List<Type> b() {
        return f0.J();
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    public /* bridge */ /* synthetic */ Member c() {
        return (Member) e();
    }
}
