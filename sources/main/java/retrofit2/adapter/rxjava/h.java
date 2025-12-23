package retrofit2.adapter.rxjava;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.c;
import retrofit2.c0;
import retrofit2.d0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class h extends c.a {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final rx.h f52048a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f52049b;

    public static h d() {
        return new h(null, false);
    }

    public static h e() {
        return new h(null, true);
    }

    public static h f(rx.h hVar) {
        if (hVar != null) {
            return new h(hVar, false);
        }
        throw new NullPointerException("scheduler == null");
    }

    private h(@Nullable rx.h hVar, boolean z5) {
        this.f52048a = hVar;
        this.f52049b = z5;
    }

    @Override // retrofit2.c.a
    @Nullable
    public retrofit2.c<?, ?> a(Type type, Annotation[] annotationArr, d0 d0Var) {
        boolean z5;
        boolean z6;
        Type type2;
        boolean z7;
        boolean z8;
        String str;
        Class<?> c6 = c.a.c(type);
        if (c6 == rx.i.class) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (c6 == rx.b.class) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (c6 != rx.e.class && !z5 && !z6) {
            return null;
        }
        if (z6) {
            return new g(Void.class, this.f52048a, this.f52049b, false, true, false, true);
        }
        if (!(type instanceof ParameterizedType)) {
            if (z5) {
                str = "Single";
            } else {
                str = "Observable";
            }
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type b6 = c.a.b(0, (ParameterizedType) type);
        Class<?> c7 = c.a.c(b6);
        if (c7 == c0.class) {
            if (b6 instanceof ParameterizedType) {
                type2 = c.a.b(0, (ParameterizedType) b6);
                z7 = false;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (c7 == e.class) {
            if (b6 instanceof ParameterizedType) {
                type2 = c.a.b(0, (ParameterizedType) b6);
                z7 = true;
            } else {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
        } else {
            type2 = b6;
            z7 = false;
            z8 = true;
            return new g(type2, this.f52048a, this.f52049b, z7, z8, z5, false);
        }
        z8 = false;
        return new g(type2, this.f52048a, this.f52049b, z7, z8, z5, false);
    }
}
