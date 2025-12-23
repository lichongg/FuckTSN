package master.flame.danmaku.danmaku.model;

import java.util.Collection;
import java.util.Comparator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface m {

    /* renamed from: a, reason: collision with root package name */
    public static final int f50093a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f50094b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f50095c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f50096d = 4;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements Comparator<master.flame.danmaku.danmaku.model.d> {

        /* renamed from: a, reason: collision with root package name */
        protected boolean f50097a;

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            if (this.f50097a && w4.a.g(dVar, dVar2)) {
                return 0;
            }
            return w4.a.d(dVar, dVar2);
        }

        public void b(boolean z5) {
            this.f50097a = z5;
        }

        public a(boolean z5) {
            b(z5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class c<Progress> extends b<Progress, Void> {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class e extends a {
        @Override // master.flame.danmaku.danmaku.model.m.a, java.util.Comparator
        /* renamed from: a */
        public int compare(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            if (this.f50097a && w4.a.g(dVar, dVar2)) {
                return 0;
            }
            return Float.compare(dVar.l(), dVar2.l());
        }

        public e(boolean z5) {
            super(z5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class f extends a {
        @Override // master.flame.danmaku.danmaku.model.m.a, java.util.Comparator
        /* renamed from: a */
        public int compare(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            if (this.f50097a && w4.a.g(dVar, dVar2)) {
                return 0;
            }
            return Float.compare(dVar2.l(), dVar.l());
        }

        public f(boolean z5) {
            super(z5);
        }
    }

    void a(b<? super master.flame.danmaku.danmaku.model.d, ?> bVar);

    void b(boolean z5);

    Object c();

    void clear();

    m d(long j6, long j7);

    boolean e(master.flame.danmaku.danmaku.model.d dVar);

    void f(b<? super master.flame.danmaku.danmaku.model.d, ?> bVar);

    master.flame.danmaku.danmaku.model.d first();

    boolean g(master.flame.danmaku.danmaku.model.d dVar);

    Collection<master.flame.danmaku.danmaku.model.d> h();

    m i(long j6, long j7);

    boolean isEmpty();

    boolean j(master.flame.danmaku.danmaku.model.d dVar);

    master.flame.danmaku.danmaku.model.d last();

    int size();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class d extends a {
        public d(boolean z5) {
            super(z5);
        }

        @Override // master.flame.danmaku.danmaku.model.m.a, java.util.Comparator
        /* renamed from: a */
        public int compare(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            return super.compare(dVar, dVar2);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class b<Progress, Result> {

        /* renamed from: a, reason: collision with root package name */
        public static final int f50098a = 0;

        /* renamed from: b, reason: collision with root package name */
        public static final int f50099b = 1;

        /* renamed from: c, reason: collision with root package name */
        public static final int f50100c = 2;

        /* renamed from: d, reason: collision with root package name */
        public static final int f50101d = 3;

        public abstract int a(Progress progress);

        public Result d() {
            return null;
        }

        public void b() {
        }

        public void c() {
        }
    }
}
