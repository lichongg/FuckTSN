package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.reflect.jvm.internal.impl.resolve.scopes.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class c {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends c {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f46736a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final int f46737b;

        static {
            d.a aVar = d.f46739c;
            f46737b = (~(aVar.i() | aVar.d())) & aVar.b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.c
        public int a() {
            return f46737b;
        }

        private a() {
        }
    }

    public abstract int a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends c {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f46738a = new b();

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.c
        public int a() {
            return 0;
        }

        private b() {
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
