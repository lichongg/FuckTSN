package kotlin.random;

import java.io.Serializable;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class d extends kotlin.random.a implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f44149b = new a(null);
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final java.util.Random f44150a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }
    }

    public d(@NotNull java.util.Random impl) {
        g0.p(impl, "impl");
        this.f44150a = impl;
    }

    @Override // kotlin.random.a
    @NotNull
    public java.util.Random a() {
        return this.f44150a;
    }
}
