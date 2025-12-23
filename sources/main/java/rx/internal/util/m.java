package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class m implements rx.m {

    /* renamed from: a, reason: collision with root package name */
    private List<rx.m> f54199a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f54200b;

    public m() {
    }

    public m(rx.m... mVarArr) {
        this.f54199a = new LinkedList(Arrays.asList(mVarArr));
    }

    private static void f(Collection<rx.m> collection) {
        if (collection == null) {
            return;
        }
        Iterator<rx.m> it = collection.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            try {
                it.next().unsubscribe();
            } catch (Throwable th) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        rx.exceptions.a.d(arrayList);
    }

    public void b() {
        List<rx.m> list;
        if (this.f54200b) {
            return;
        }
        synchronized (this) {
            list = this.f54199a;
            this.f54199a = null;
        }
        f(list);
    }

    public boolean d() {
        List<rx.m> list;
        boolean z5 = false;
        if (this.f54200b) {
            return false;
        }
        synchronized (this) {
            try {
                if (!this.f54200b && (list = this.f54199a) != null && !list.isEmpty()) {
                    z5 = true;
                }
            } finally {
            }
        }
        return z5;
    }

    public void e(rx.m mVar) {
        if (this.f54200b) {
            return;
        }
        synchronized (this) {
            List<rx.m> list = this.f54199a;
            if (!this.f54200b && list != null) {
                boolean remove = list.remove(mVar);
                if (remove) {
                    mVar.unsubscribe();
                }
            }
        }
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f54200b;
    }

    @Override // rx.m
    public void unsubscribe() {
        if (this.f54200b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f54200b) {
                    return;
                }
                this.f54200b = true;
                List<rx.m> list = this.f54199a;
                this.f54199a = null;
                f(list);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(rx.m mVar) {
        if (mVar.isUnsubscribed()) {
            return;
        }
        if (!this.f54200b) {
            synchronized (this) {
                try {
                    if (!this.f54200b) {
                        List list = this.f54199a;
                        if (list == null) {
                            list = new LinkedList();
                            this.f54199a = list;
                        }
                        list.add(mVar);
                        return;
                    }
                } finally {
                }
            }
        }
        mVar.unsubscribe();
    }

    public m(rx.m mVar) {
        LinkedList linkedList = new LinkedList();
        this.f54199a = linkedList;
        linkedList.add(mVar);
    }
}
