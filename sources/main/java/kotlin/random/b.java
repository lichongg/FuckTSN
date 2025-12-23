package kotlin.random;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b extends kotlin.random.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final a f44145a = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends ThreadLocal<java.util.Random> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.Random initialValue() {
            return new java.util.Random();
        }

        a() {
        }
    }

    @Override // kotlin.random.a
    @NotNull
    public java.util.Random a() {
        java.util.Random random = this.f44145a.get();
        g0.o(random, "get(...)");
        return random;
    }
}
