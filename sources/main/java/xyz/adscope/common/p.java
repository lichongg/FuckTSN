package xyz.adscope.common;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import xyz.adscope.common.v2.persistent.db.IBaseDatabaseModel;
import xyz.adscope.common.v2.thread.timer.task.ICommonTimeoutTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
final class p<E extends IBaseDatabaseModel> extends CopyOnWriteArrayList<E> {

    /* renamed from: a, reason: collision with root package name */
    private final int f56745a;

    /* renamed from: b, reason: collision with root package name */
    private final p<E>.b f56746b;

    /* renamed from: c, reason: collision with root package name */
    private a<E> f56747c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a<E extends IBaseDatabaseModel> {
        void a(List<E> list);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b extends ICommonTimeoutTask {
        public b(long j6) {
            super(j6);
        }

        @Override // xyz.adscope.common.v2.thread.timer.task.ICommonTimeoutTask
        protected void onScheduleTimeout() {
            synchronized (p.this) {
                p.this.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f56746b.cancelCountDown();
        a(a());
    }

    void a(a<E> aVar) {
        this.f56747c = aVar;
    }

    p(int i6, long j6) {
        this.f56745a = i6 <= 0 ? 1 : i6;
        this.f56746b = new b(j6);
    }

    private void a(List<E> list) {
        a<E> aVar = this.f56747c;
        if (aVar != null) {
            aVar.a(list);
        }
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean add(E e6) {
        boolean add;
        synchronized (this) {
            try {
                add = super.add(e6);
                if (add && size() == 1) {
                    this.f56746b.startCountDown();
                }
                if (add && size() == this.f56745a) {
                    b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return add;
    }

    private List<E> a() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this);
            clear();
        }
        return arrayList;
    }
}
