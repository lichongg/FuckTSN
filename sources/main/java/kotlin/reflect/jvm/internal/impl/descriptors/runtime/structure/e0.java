package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class e0 implements y3.x {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f45001a = new a(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final e0 a(@NotNull Type type) {
            kotlin.jvm.internal.g0.p(type, "type");
            boolean z5 = type instanceof Class;
            if (z5) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new c0(cls);
                }
            }
            return ((type instanceof GenericArrayType) || (z5 && ((Class) type).isArray())) ? new m(type) : type instanceof WildcardType ? new h0((WildcardType) type) : new s(type);
        }
    }

    @NotNull
    protected abstract Type M();

    @Override // y3.d
    @Nullable
    public y3.a b(kotlin.reflect.jvm.internal.impl.name.c fqName) {
        Object obj;
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        Iterator<T> it = getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            kotlin.reflect.jvm.internal.impl.name.b c6 = ((y3.a) next).c();
            if (kotlin.jvm.internal.g0.g(c6 != null ? c6.a() : null, fqName)) {
                obj = next;
                break;
            }
        }
        return (y3.a) obj;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof e0) && kotlin.jvm.internal.g0.g(M(), ((e0) obj).M());
    }

    @NotNull
    public String toString() {
        return getClass().getName() + ": " + M();
    }

    public int hashCode() {
        return M().hashCode();
    }
}
