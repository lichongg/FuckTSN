package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.List;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.serialization.d f45200a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.serialization.c f45201b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<p> f45202c;

    public final int a(@NotNull String string) {
        g0.p(string, "string");
        return this.f45200a.a(string);
    }

    public final int b(@NotNull String name) {
        g0.p(name, "name");
        return i.a(this.f45200a, name);
    }

    @NotNull
    public final List<p> c() {
        return this.f45202c;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.metadata.serialization.d d() {
        return this.f45200a;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.metadata.serialization.c e() {
        return this.f45201b;
    }
}
