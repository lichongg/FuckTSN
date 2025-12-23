package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class s0 {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<Object> f44058a;

    public void a(Object obj) {
        this.f44058a.add(obj);
    }

    public void b(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList<Object> arrayList = this.f44058a;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(this.f44058a, objArr);
                return;
            }
            return;
        }
        if (obj instanceof Collection) {
            this.f44058a.addAll((Collection) obj);
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                this.f44058a.add(it.next());
            }
            return;
        }
        if (obj instanceof Iterator) {
            Iterator it2 = (Iterator) obj;
            while (it2.hasNext()) {
                this.f44058a.add(it2.next());
            }
        } else {
            throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
        }
    }

    public int c() {
        return this.f44058a.size();
    }

    public Object[] d(Object[] objArr) {
        return this.f44058a.toArray(objArr);
    }

    public s0(int i6) {
        this.f44058a = new ArrayList<>(i6);
    }
}
