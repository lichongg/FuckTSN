package rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import rx.e;
import rx.internal.operators.v;
import rx.subjects.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class b<T> extends f<T, T> {

    /* renamed from: c, reason: collision with root package name */
    private static final Object[] f54498c = new Object[0];

    /* renamed from: b, reason: collision with root package name */
    private final g<T> f54499b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements rx.functions.b<g.c<T>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f54500a;

        a(g gVar) {
            this.f54500a = gVar;
        }

        @Override // rx.functions.b
        public void call(g.c<T> cVar) {
            cVar.e(this.f54500a.c());
        }
    }

    public static <T> b<T> y7() {
        return A7(null, false);
    }

    public static <T> b<T> z7(T t5) {
        return A7(t5, true);
    }

    private static <T> b<T> A7(T t5, boolean z5) {
        g gVar = new g();
        if (z5) {
            gVar.g(v.j(t5));
        }
        a aVar = new a(gVar);
        gVar.f54549d = aVar;
        gVar.f54550e = aVar;
        return new b<>(gVar, gVar);
    }

    public Throwable B7() {
        Object c6 = this.f54499b.c();
        if (v.g(c6)) {
            return v.d(c6);
        }
        return null;
    }

    public T C7() {
        Object c6 = this.f54499b.c();
        if (v.h(c6)) {
            return (T) v.e(c6);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] D7() {
        Object[] objArr = f54498c;
        Object[] E7 = E7(objArr);
        return E7 == objArr ? new Object[0] : E7;
    }

    public T[] E7(T[] tArr) {
        Object c6 = this.f54499b.c();
        if (!v.h(c6)) {
            if (tArr.length > 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        if (tArr.length == 0) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
        }
        tArr[0] = v.e(c6);
        if (tArr.length > 1) {
            tArr[1] = null;
        }
        return tArr;
    }

    public boolean F7() {
        return v.f(this.f54499b.c());
    }

    public boolean G7() {
        return v.g(this.f54499b.c());
    }

    public boolean H7() {
        return v.h(this.f54499b.c());
    }

    int I7() {
        return this.f54499b.e().length;
    }

    @Override // rx.f
    public void onCompleted() {
        if (this.f54499b.c() == null || this.f54499b.f54547b) {
            Object b6 = v.b();
            for (g.c<T> cVar : this.f54499b.h(b6)) {
                cVar.g(b6);
            }
        }
    }

    @Override // rx.f
    public void onError(Throwable th) {
        if (this.f54499b.c() == null || this.f54499b.f54547b) {
            Object c6 = v.c(th);
            ArrayList arrayList = null;
            for (g.c<T> cVar : this.f54499b.h(c6)) {
                try {
                    cVar.g(c6);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.d(arrayList);
        }
    }

    @Override // rx.f
    public void onNext(T t5) {
        if (this.f54499b.c() == null || this.f54499b.f54547b) {
            Object j6 = v.j(t5);
            for (g.c<T> cVar : this.f54499b.d(j6)) {
                cVar.g(j6);
            }
        }
    }

    @Override // rx.subjects.f
    public boolean w7() {
        return this.f54499b.e().length > 0;
    }

    protected b(e.a<T> aVar, g<T> gVar) {
        super(aVar);
        this.f54499b = gVar;
    }
}
