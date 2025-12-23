package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b implements kotlin.reflect.jvm.internal.impl.km.internal.extensions.c {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f45220b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.km.internal.extensions.f f45221c = new kotlin.reflect.jvm.internal.impl.km.internal.extensions.f(o0.d(b.class));

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private w3.d f45222a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }
    }

    @Nullable
    public final w3.d a() {
        return this.f45222a;
    }

    public final void b(@Nullable w3.d dVar) {
        this.f45222a = dVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.e
    @NotNull
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.f getType() {
        return f45221c;
    }
}
