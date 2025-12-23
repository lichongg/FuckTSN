package o;

import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a<T> implements c {

    /* renamed from: c, reason: collision with root package name */
    public static final int f50447c = 4;

    /* renamed from: a, reason: collision with root package name */
    private List<T> f50448a;

    /* renamed from: b, reason: collision with root package name */
    private int f50449b;

    public a(List<T> list, int i6) {
        this.f50448a = list;
        this.f50449b = i6;
    }

    @Override // o.c
    public int a() {
        return this.f50448a.size();
    }

    @Override // o.c
    public Object getItem(int i6) {
        return (i6 < 0 || i6 >= this.f50448a.size()) ? "" : this.f50448a.get(i6);
    }

    @Override // o.c
    public int indexOf(Object obj) {
        return this.f50448a.indexOf(obj);
    }

    public a(List<T> list) {
        this(list, 4);
    }
}
