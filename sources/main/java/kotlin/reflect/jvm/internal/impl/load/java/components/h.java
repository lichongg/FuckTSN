package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.collections.i1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.resolve.constants.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h extends c {

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f45395h = {o0.u(new PropertyReference1Impl(h.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0))};

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f45396g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@Nullable y3.a aVar, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k c6) {
        super(c6, aVar, o.a.f44631y);
        g0.p(c6, "c");
        this.f45396g = c6.e().e(g.f45394a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map h() {
        return i1.k(kotlin.o0.a(d.f45385a.b(), new y("Deprecated in Java")));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.c, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a() {
        return (Map) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f45396g, this, f45395h[0]);
    }
}
