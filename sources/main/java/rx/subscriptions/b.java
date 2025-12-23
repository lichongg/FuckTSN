package rx.subscriptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import rx.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class b implements m {

    /* renamed from: a, reason: collision with root package name */
    private Set<m> f54585a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f54586b;

    public b() {
    }

    public b(m... mVarArr) {
        this.f54585a = new HashSet(Arrays.asList(mVarArr));
    }

    private static void g(Collection<m> collection) {
        if (collection == null) {
            return;
        }
        Iterator<m> it = collection.iterator();
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

    public void b(m... mVarArr) {
        int i6 = 0;
        if (!this.f54586b) {
            synchronized (this) {
                try {
                    if (!this.f54586b) {
                        if (this.f54585a == null) {
                            this.f54585a = new HashSet(mVarArr.length);
                        }
                        int length = mVarArr.length;
                        while (i6 < length) {
                            m mVar = mVarArr[i6];
                            if (!mVar.isUnsubscribed()) {
                                this.f54585a.add(mVar);
                            }
                            i6++;
                        }
                        return;
                    }
                } finally {
                }
            }
        }
        int length2 = mVarArr.length;
        while (i6 < length2) {
            mVarArr[i6].unsubscribe();
            i6++;
        }
    }

    public void d() {
        Set<m> set;
        if (this.f54586b) {
            return;
        }
        synchronized (this) {
            if (!this.f54586b && (set = this.f54585a) != null) {
                this.f54585a = null;
                g(set);
            }
        }
    }

    public boolean e() {
        Set<m> set;
        boolean z5 = false;
        if (this.f54586b) {
            return false;
        }
        synchronized (this) {
            try {
                if (!this.f54586b && (set = this.f54585a) != null && !set.isEmpty()) {
                    z5 = true;
                }
            } finally {
            }
        }
        return z5;
    }

    public void f(m mVar) {
        Set<m> set;
        if (this.f54586b) {
            return;
        }
        synchronized (this) {
            if (!this.f54586b && (set = this.f54585a) != null) {
                boolean remove = set.remove(mVar);
                if (remove) {
                    mVar.unsubscribe();
                }
            }
        }
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f54586b;
    }

    @Override // rx.m
    public void unsubscribe() {
        if (this.f54586b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f54586b) {
                    return;
                }
                this.f54586b = true;
                Set<m> set = this.f54585a;
                this.f54585a = null;
                g(set);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(m mVar) {
        if (mVar.isUnsubscribed()) {
            return;
        }
        if (!this.f54586b) {
            synchronized (this) {
                try {
                    if (!this.f54586b) {
                        if (this.f54585a == null) {
                            this.f54585a = new HashSet(4);
                        }
                        this.f54585a.add(mVar);
                        return;
                    }
                } finally {
                }
            }
        }
        mVar.unsubscribe();
    }
}
