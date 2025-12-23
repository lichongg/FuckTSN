package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.v;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.m;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i implements m {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f45244b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.km.internal.extensions.f f45245c = new kotlin.reflect.jvm.internal.impl.km.internal.extensions.f(o0.d(i.class));

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<kotlin.reflect.jvm.internal.impl.km.d> f45246a = new ArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }
    }

    @NotNull
    public final List<kotlin.reflect.jvm.internal.impl.km.d> a() {
        return this.f45246a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.e
    @NotNull
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.f getType() {
        return f45245c;
    }
}
