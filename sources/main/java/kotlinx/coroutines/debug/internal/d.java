package kotlinx.coroutines.debug.internal;

import java.util.List;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@PublishedApi
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.coroutines.i f48525a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final kotlin.coroutines.jvm.internal.c f48526b;

    /* renamed from: c, reason: collision with root package name */
    private final long f48527c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final List<StackTraceElement> f48528d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final String f48529e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private final Thread f48530f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private final kotlin.coroutines.jvm.internal.c f48531g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final List<StackTraceElement> f48532h;

    @Nullable
    public final kotlin.coroutines.jvm.internal.c a() {
        return this.f48526b;
    }

    @NotNull
    public final List<StackTraceElement> b() {
        return this.f48528d;
    }

    @Nullable
    public final kotlin.coroutines.jvm.internal.c c() {
        return this.f48531g;
    }

    @Nullable
    public final Thread d() {
        return this.f48530f;
    }

    public final long e() {
        return this.f48527c;
    }

    @NotNull
    public final String f() {
        return this.f48529e;
    }

    @JvmName(name = "lastObservedStackTrace")
    @NotNull
    public final List<StackTraceElement> g() {
        return this.f48532h;
    }

    @NotNull
    public final kotlin.coroutines.i getContext() {
        return this.f48525a;
    }

    public d(@NotNull e eVar, @NotNull kotlin.coroutines.i iVar) {
        this.f48525a = iVar;
        this.f48526b = eVar.c();
        this.f48527c = eVar.f48534b;
        this.f48528d = eVar.d();
        this.f48529e = eVar.f();
        this.f48530f = eVar.lastObservedThread;
        this.f48531g = eVar.e();
        this.f48532h = eVar.g();
    }
}
