package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class k extends AbstractList<String> implements RandomAccess, l {

    /* renamed from: b, reason: collision with root package name */
    public static final l f46511b = new k().c();

    /* renamed from: a, reason: collision with root package name */
    private final List<Object> f46512a;

    public k() {
        this.f46512a = new ArrayList();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    private static d d(Object obj) {
        return obj instanceof d ? (d) obj : obj instanceof String ? d.j((String) obj) : d.f((byte[]) obj);
    }

    private static String e(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof d ? ((d) obj).z() : h.b((byte[]) obj);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void add(int i6, String str) {
        this.f46512a.add(i6, str);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i6, Collection<? extends String> collection) {
        if (collection instanceof l) {
            collection = ((l) collection).h();
        }
        boolean addAll = this.f46512a.addAll(i6, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public l c() {
        return new t(this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f46512a.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public String get(int i6) {
        Object obj = this.f46512a.get(i6);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String z5 = dVar.z();
            if (dVar.q()) {
                this.f46512a.set(i6, z5);
            }
            return z5;
        }
        byte[] bArr = (byte[]) obj;
        String b6 = h.b(bArr);
        if (h.a(bArr)) {
            this.f46512a.set(i6, b6);
        }
        return b6;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public String remove(int i6) {
        Object remove = this.f46512a.remove(i6);
        ((AbstractList) this).modCount++;
        return e(remove);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public List<?> h() {
        return Collections.unmodifiableList(this.f46512a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public d i(int i6) {
        Object obj = this.f46512a.get(i6);
        d d6 = d(obj);
        if (d6 != obj) {
            this.f46512a.set(i6, d6);
        }
        return d6;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public String set(int i6, String str) {
        return e(this.f46512a.set(i6, str));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public void k(d dVar) {
        this.f46512a.add(dVar);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f46512a.size();
    }

    public k(l lVar) {
        this.f46512a = new ArrayList(lVar.size());
        addAll(lVar);
    }
}
