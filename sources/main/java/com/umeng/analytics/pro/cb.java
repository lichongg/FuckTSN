package com.umeng.analytics.pro;

import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.cb;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class cb<T extends cb<?, ?>, F extends by> implements br<T, F> {

    /* renamed from: c, reason: collision with root package name */
    private static final Map<Class<? extends cy>, cz> f41075c;

    /* renamed from: a, reason: collision with root package name */
    protected Object f41076a;

    /* renamed from: b, reason: collision with root package name */
    protected F f41077b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.analytics.pro.cb$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a extends da<cb> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cq cqVar, cb cbVar) throws bx {
            cbVar.f41077b = null;
            cbVar.f41076a = null;
            cqVar.j();
            cl l6 = cqVar.l();
            Object a6 = cbVar.a(cqVar, l6);
            cbVar.f41076a = a6;
            if (a6 != null) {
                cbVar.f41077b = (F) cbVar.a(l6.f41142c);
            }
            cqVar.m();
            cqVar.l();
            cqVar.k();
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cq cqVar, cb cbVar) throws bx {
            if (cbVar.a() == null || cbVar.b() == null) {
                throw new cr("Cannot write a TUnion with no set value!");
            }
            cqVar.a(cbVar.d());
            cqVar.a(cbVar.c(cbVar.f41077b));
            cbVar.a(cqVar);
            cqVar.c();
            cqVar.d();
            cqVar.b();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b implements cz {
        private b() {
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cz
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a(null);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c extends db<cb> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cq cqVar, cb cbVar) throws bx {
            cbVar.f41077b = null;
            cbVar.f41076a = null;
            short v5 = cqVar.v();
            Object a6 = cbVar.a(cqVar, v5);
            cbVar.f41076a = a6;
            if (a6 != null) {
                cbVar.f41077b = (F) cbVar.a(v5);
            }
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cq cqVar, cb cbVar) throws bx {
            if (cbVar.a() == null || cbVar.b() == null) {
                throw new cr("Cannot write a TUnion with no set value!");
            }
            cqVar.a(cbVar.f41077b.a());
            cbVar.b(cqVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class d implements cz {
        private d() {
        }

        /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cz
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c(null);
        }
    }

    protected cb() {
        this.f41077b = null;
        this.f41076a = null;
    }

    private static Object a(Object obj) {
        return obj instanceof br ? ((br) obj).deepCopy() : obj instanceof ByteBuffer ? bs.d((ByteBuffer) obj) : obj instanceof List ? a((List) obj) : obj instanceof Set ? a((Set) obj) : obj instanceof Map ? a((Map<Object, Object>) obj) : obj;
    }

    protected abstract F a(short s5);

    protected abstract Object a(cq cqVar, cl clVar) throws bx;

    protected abstract Object a(cq cqVar, short s5) throws bx;

    protected abstract void a(cq cqVar) throws bx;

    public Object b() {
        return this.f41076a;
    }

    protected abstract void b(F f6, Object obj) throws ClassCastException;

    protected abstract void b(cq cqVar) throws bx;

    protected abstract cl c(F f6);

    public boolean c() {
        return this.f41077b != null;
    }

    @Override // com.umeng.analytics.pro.br
    public final void clear() {
        this.f41077b = null;
        this.f41076a = null;
    }

    protected abstract cv d();

    static {
        HashMap hashMap = new HashMap();
        f41075c = hashMap;
        AnonymousClass1 anonymousClass1 = null;
        hashMap.put(da.class, new b(anonymousClass1));
        hashMap.put(db.class, new d(anonymousClass1));
    }

    public boolean b(F f6) {
        return this.f41077b == f6;
    }

    @Override // com.umeng.analytics.pro.br
    public void read(cq cqVar) throws bx {
        f41075c.get(cqVar.D()).b().b(cqVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(getClass().getSimpleName());
        sb.append(" ");
        if (a() != null) {
            Object b6 = b();
            sb.append(c(a()).f41140a);
            sb.append(":");
            if (b6 instanceof ByteBuffer) {
                bs.a((ByteBuffer) b6, sb);
            } else {
                sb.append(b6.toString());
            }
        }
        sb.append(">");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.br
    public void write(cq cqVar) throws bx {
        f41075c.get(cqVar.D()).b().a(cqVar, this);
    }

    public boolean b(int i6) {
        return b((cb<T, F>) a((short) i6));
    }

    protected cb(F f6, Object obj) {
        a((cb<T, F>) f6, obj);
    }

    protected cb(cb<T, F> cbVar) {
        if (cbVar.getClass().equals(getClass())) {
            this.f41077b = cbVar.f41077b;
            this.f41076a = a(cbVar.f41076a);
            return;
        }
        throw new ClassCastException();
    }

    private static Map a(Map<Object, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            hashMap.put(a(entry.getKey()), a(entry.getValue()));
        }
        return hashMap;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(a(it.next()));
        }
        return hashSet;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    public F a() {
        return this.f41077b;
    }

    public Object a(F f6) {
        if (f6 == this.f41077b) {
            return b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f6 + " because union's set field is " + this.f41077b);
    }

    public Object a(int i6) {
        return a((cb<T, F>) a((short) i6));
    }

    public void a(F f6, Object obj) {
        b(f6, obj);
        this.f41077b = f6;
        this.f41076a = obj;
    }

    public void a(int i6, Object obj) {
        a((cb<T, F>) a((short) i6), obj);
    }
}
