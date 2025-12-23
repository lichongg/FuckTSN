package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f46491b;

    /* renamed from: c, reason: collision with root package name */
    private static final f f46492c = new f(true);

    /* renamed from: a, reason: collision with root package name */
    private final Map<a, GeneratedMessageLite.f<?, ?>> f46493a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Object f46494a;

        /* renamed from: b, reason: collision with root package name */
        private final int f46495b;

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f46494a == aVar.f46494a && this.f46495b == aVar.f46495b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f46494a) * 65535) + this.f46495b;
        }

        a(Object obj, int i6) {
            this.f46494a = obj;
            this.f46495b = i6;
        }
    }

    f() {
        this.f46493a = new HashMap();
    }

    public static f c() {
        return f46492c;
    }

    public static f d() {
        return new f();
    }

    public final void a(GeneratedMessageLite.f<?, ?> fVar) {
        this.f46493a.put(new a(fVar.b(), fVar.d()), fVar);
    }

    public <ContainingType extends n> GeneratedMessageLite.f<ContainingType, ?> b(ContainingType containingtype, int i6) {
        return (GeneratedMessageLite.f) this.f46493a.get(new a(containingtype, i6));
    }

    private f(boolean z5) {
        this.f46493a = Collections.EMPTY_MAP;
    }
}
