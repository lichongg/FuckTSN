package master.flame.danmaku.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class b {

    /* renamed from: f, reason: collision with root package name */
    public static final int f49801f = 1;

    /* renamed from: g, reason: collision with root package name */
    public static final int f49802g = 2;

    /* renamed from: h, reason: collision with root package name */
    public static final int f49803h = 4;

    /* renamed from: i, reason: collision with root package name */
    public static final int f49804i = 8;

    /* renamed from: j, reason: collision with root package name */
    public static final int f49805j = 16;

    /* renamed from: k, reason: collision with root package name */
    public static final int f49806k = 32;

    /* renamed from: l, reason: collision with root package name */
    public static final int f49807l = 64;

    /* renamed from: m, reason: collision with root package name */
    public static final int f49808m = 128;

    /* renamed from: n, reason: collision with root package name */
    public static final int f49809n = 256;

    /* renamed from: o, reason: collision with root package name */
    public static final int f49810o = 512;

    /* renamed from: p, reason: collision with root package name */
    public static final String f49811p = "1010_Filter";

    /* renamed from: q, reason: collision with root package name */
    public static final String f49812q = "1011_Filter";

    /* renamed from: r, reason: collision with root package name */
    public static final String f49813r = "1012_Filter";

    /* renamed from: s, reason: collision with root package name */
    public static final String f49814s = "1013_Filter";

    /* renamed from: t, reason: collision with root package name */
    public static final String f49815t = "1014_Filter";

    /* renamed from: u, reason: collision with root package name */
    public static final String f49816u = "1015_Filter";

    /* renamed from: v, reason: collision with root package name */
    public static final String f49817v = "1016_Filter";

    /* renamed from: w, reason: collision with root package name */
    public static final String f49818w = "1017_Filter";

    /* renamed from: x, reason: collision with root package name */
    public static final String f49819x = "1018_Filter";

    /* renamed from: y, reason: collision with root package name */
    public static final String f49820y = "1019_Filter";

    /* renamed from: a, reason: collision with root package name */
    public final Exception f49821a = new Exception("not suuport this filter tag");

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, e<?>> f49822b = Collections.synchronizedSortedMap(new TreeMap());

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, e<?>> f49823c = Collections.synchronizedSortedMap(new TreeMap());

    /* renamed from: d, reason: collision with root package name */
    e<?>[] f49824d = new e[0];

    /* renamed from: e, reason: collision with root package name */
    e<?>[] f49825e = new e[0];

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: master.flame.danmaku.controller.b$b, reason: collision with other inner class name */
    public static class C0968b extends a<Void> {

        /* renamed from: a, reason: collision with root package name */
        protected final master.flame.danmaku.danmaku.model.m f49826a = new master.flame.danmaku.danmaku.model.android.e(4);

        /* renamed from: b, reason: collision with root package name */
        protected final LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> f49827b = new LinkedHashMap<>();

        /* renamed from: c, reason: collision with root package name */
        private final master.flame.danmaku.danmaku.model.m f49828c = new master.flame.danmaku.danmaku.model.android.e(4);

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: master.flame.danmaku.controller.b$b$a */
        class a extends m.c<master.flame.danmaku.danmaku.model.d> {

            /* renamed from: e, reason: collision with root package name */
            long f49829e = w4.c.b();

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ long f49830f;

            @Override // master.flame.danmaku.danmaku.model.m.b
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public int a(master.flame.danmaku.danmaku.model.d dVar) {
                if (w4.c.b() - this.f49829e > this.f49830f) {
                    return 1;
                }
                return dVar.w() ? 2 : 1;
            }

            a(long j6) {
                this.f49830f = j6;
            }
        }

        public synchronized boolean c(master.flame.danmaku.danmaku.model.d dVar, int i6, int i7, master.flame.danmaku.danmaku.model.f fVar, boolean z5) {
            e(this.f49826a, 2L);
            e(this.f49828c, 2L);
            d(this.f49827b, 3);
            if (this.f49826a.g(dVar) && !dVar.s()) {
                return true;
            }
            if (this.f49828c.g(dVar)) {
                return false;
            }
            if (!this.f49827b.containsKey(dVar.f50056c)) {
                this.f49827b.put(String.valueOf(dVar.f50056c), dVar);
                this.f49828c.j(dVar);
                return false;
            }
            this.f49827b.put(String.valueOf(dVar.f50056c), dVar);
            this.f49826a.e(dVar);
            this.f49826a.j(dVar);
            return true;
        }

        @Override // master.flame.danmaku.controller.b.e
        public synchronized void reset() {
            this.f49828c.clear();
            this.f49826a.clear();
            this.f49827b.clear();
        }

        private final void e(master.flame.danmaku.danmaku.model.m mVar, long j6) {
            mVar.a(new a(j6));
        }

        private void d(LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> linkedHashMap, int i6) {
            Iterator<Map.Entry<String, master.flame.danmaku.danmaku.model.d>> it = linkedHashMap.entrySet().iterator();
            long b6 = w4.c.b();
            while (it.hasNext()) {
                try {
                    if (it.next().getValue().w()) {
                        it.remove();
                        if (w4.c.b() - b6 > i6) {
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Exception unused) {
                    return;
                }
            }
        }

        @Override // master.flame.danmaku.controller.b.e
        public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i6, int i7, master.flame.danmaku.danmaku.model.f fVar, boolean z5, DanmakuContext danmakuContext) {
            boolean c6 = c(dVar, i6, i7, fVar, z5);
            if (c6) {
                dVar.G |= 128;
            }
            return c6;
        }

        @Override // master.flame.danmaku.controller.b.a, master.flame.danmaku.controller.b.e
        public void clear() {
            reset();
        }

        @Override // master.flame.danmaku.controller.b.e
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(Void r12) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class d extends a<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        private Boolean f49833a = Boolean.FALSE;

        @Override // master.flame.danmaku.controller.b.e
        public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i6, int i7, master.flame.danmaku.danmaku.model.f fVar, boolean z5, DanmakuContext danmakuContext) {
            boolean z6 = this.f49833a.booleanValue() && dVar.D;
            if (z6) {
                dVar.G |= 64;
            }
            return z6;
        }

        @Override // master.flame.danmaku.controller.b.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Boolean bool) {
            this.f49833a = bool;
        }

        @Override // master.flame.danmaku.controller.b.e
        public void reset() {
            this.f49833a = Boolean.FALSE;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface e<T> {
        void a(T t5);

        boolean b(master.flame.danmaku.danmaku.model.d dVar, int i6, int i7, master.flame.danmaku.danmaku.model.f fVar, boolean z5, DanmakuContext danmakuContext);

        void clear();

        void reset();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class f extends a<Map<Integer, Integer>> {

        /* renamed from: a, reason: collision with root package name */
        private Map<Integer, Integer> f49834a;

        @Override // master.flame.danmaku.controller.b.e
        public void reset() {
            this.f49834a = null;
        }

        @Override // master.flame.danmaku.controller.b.e
        public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i6, int i7, master.flame.danmaku.danmaku.model.f fVar, boolean z5, DanmakuContext danmakuContext) {
            Map<Integer, Integer> map = this.f49834a;
            boolean z6 = false;
            if (map != null) {
                Integer num = map.get(Integer.valueOf(dVar.getType()));
                if (num != null && i6 >= num.intValue()) {
                    z6 = true;
                }
                if (z6) {
                    dVar.G |= 256;
                }
            }
            return z6;
        }

        @Override // master.flame.danmaku.controller.b.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Map<Integer, Integer> map) {
            this.f49834a = map;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class g extends a<Map<Integer, Boolean>> {

        /* renamed from: a, reason: collision with root package name */
        private Map<Integer, Boolean> f49835a;

        @Override // master.flame.danmaku.controller.b.e
        public void reset() {
            this.f49835a = null;
        }

        @Override // master.flame.danmaku.controller.b.e
        public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i6, int i7, master.flame.danmaku.danmaku.model.f fVar, boolean z5, DanmakuContext danmakuContext) {
            Map<Integer, Boolean> map = this.f49835a;
            boolean z6 = false;
            if (map != null) {
                Boolean bool = map.get(Integer.valueOf(dVar.getType()));
                if (bool != null && bool.booleanValue() && z5) {
                    z6 = true;
                }
                if (z6) {
                    dVar.G |= 512;
                }
            }
            return z6;
        }

        @Override // master.flame.danmaku.controller.b.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Map<Integer, Boolean> map) {
            this.f49835a = map;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class h extends a<Integer> {

        /* renamed from: a, reason: collision with root package name */
        protected int f49836a = -1;

        /* renamed from: b, reason: collision with root package name */
        protected master.flame.danmaku.danmaku.model.d f49837b = null;

        /* renamed from: c, reason: collision with root package name */
        private float f49838c = 1.0f;

        @Override // master.flame.danmaku.controller.b.e
        public synchronized boolean b(master.flame.danmaku.danmaku.model.d dVar, int i6, int i7, master.flame.danmaku.danmaku.model.f fVar, boolean z5, DanmakuContext danmakuContext) {
            try {
                try {
                    boolean c6 = c(dVar, i6, i7, fVar, z5, danmakuContext);
                    if (c6) {
                        dVar.G |= 2;
                    }
                    return c6;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }

        @Override // master.flame.danmaku.controller.b.e
        public synchronized void reset() {
            this.f49837b = null;
        }

        private boolean c(master.flame.danmaku.danmaku.model.d dVar, int i6, int i7, master.flame.danmaku.danmaku.model.f fVar, boolean z5, DanmakuContext danmakuContext) {
            if (this.f49836a > 0 && dVar.getType() == 1) {
                master.flame.danmaku.danmaku.model.d dVar2 = this.f49837b;
                if (dVar2 != null && !dVar2.w()) {
                    long b6 = dVar.b() - this.f49837b.b();
                    master.flame.danmaku.danmaku.model.g gVar = danmakuContext.D.f50010f;
                    if ((b6 >= 0 && gVar != null && b6 < gVar.f50084c * this.f49838c) || i6 > this.f49836a) {
                        return true;
                    }
                    this.f49837b = dVar;
                    return false;
                }
                this.f49837b = dVar;
            }
            return false;
        }

        @Override // master.flame.danmaku.controller.b.a, master.flame.danmaku.controller.b.e
        public void clear() {
            reset();
        }

        @Override // master.flame.danmaku.controller.b.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(Integer num) {
            reset();
            if (num != null && num.intValue() != this.f49836a) {
                int intValue = num.intValue() + (num.intValue() / 5);
                this.f49836a = intValue;
                this.f49838c = 1.0f / intValue;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class i extends a<List<Integer>> {

        /* renamed from: a, reason: collision with root package name */
        public List<Integer> f49839a = new ArrayList();

        private void c(Integer num) {
            if (this.f49839a.contains(num)) {
                return;
            }
            this.f49839a.add(num);
        }

        @Override // master.flame.danmaku.controller.b.e
        public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i6, int i7, master.flame.danmaku.danmaku.model.f fVar, boolean z5, DanmakuContext danmakuContext) {
            boolean z6 = (dVar == null || this.f49839a.contains(Integer.valueOf(dVar.f50060g))) ? false : true;
            if (z6) {
                dVar.G |= 8;
            }
            return z6;
        }

        @Override // master.flame.danmaku.controller.b.e
        public void reset() {
            this.f49839a.clear();
        }

        @Override // master.flame.danmaku.controller.b.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(List<Integer> list) {
            reset();
            if (list != null) {
                Iterator<Integer> it = list.iterator();
                while (it.hasNext()) {
                    c(it.next());
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class j extends a<List<Integer>> {

        /* renamed from: a, reason: collision with root package name */
        final List<Integer> f49840a = Collections.synchronizedList(new ArrayList());

        @Override // master.flame.danmaku.controller.b.e
        public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i6, int i7, master.flame.danmaku.danmaku.model.f fVar, boolean z5, DanmakuContext danmakuContext) {
            boolean z6 = dVar != null && this.f49840a.contains(Integer.valueOf(dVar.getType()));
            if (z6) {
                dVar.G = 1 | dVar.G;
            }
            return z6;
        }

        public void c(Integer num) {
            if (this.f49840a.contains(num)) {
                this.f49840a.remove(num);
            }
        }

        public void d(Integer num) {
            if (this.f49840a.contains(num)) {
                return;
            }
            this.f49840a.add(num);
        }

        @Override // master.flame.danmaku.controller.b.e
        public void reset() {
            this.f49840a.clear();
        }

        @Override // master.flame.danmaku.controller.b.e
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(List<Integer> list) {
            reset();
            if (list != null) {
                Iterator<Integer> it = list.iterator();
                while (it.hasNext()) {
                    d(it.next());
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class k<T> extends a<List<T>> {

        /* renamed from: a, reason: collision with root package name */
        public List<T> f49841a = new ArrayList();

        @Override // master.flame.danmaku.controller.b.e
        public abstract boolean b(master.flame.danmaku.danmaku.model.d dVar, int i6, int i7, master.flame.danmaku.danmaku.model.f fVar, boolean z5, DanmakuContext danmakuContext);

        private void c(T t5) {
            if (this.f49841a.contains(t5)) {
                return;
            }
            this.f49841a.add(t5);
        }

        @Override // master.flame.danmaku.controller.b.e
        public void reset() {
            this.f49841a.clear();
        }

        @Override // master.flame.danmaku.controller.b.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(List<T> list) {
            reset();
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    c(it.next());
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class l extends k<String> {
        @Override // master.flame.danmaku.controller.b.k, master.flame.danmaku.controller.b.e
        public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i6, int i7, master.flame.danmaku.danmaku.model.f fVar, boolean z5, DanmakuContext danmakuContext) {
            boolean z6 = dVar != null && this.f49841a.contains(dVar.C);
            if (z6) {
                dVar.G |= 32;
            }
            return z6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class m extends k<Integer> {
        @Override // master.flame.danmaku.controller.b.k, master.flame.danmaku.controller.b.e
        public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i6, int i7, master.flame.danmaku.danmaku.model.f fVar, boolean z5, DanmakuContext danmakuContext) {
            boolean z6 = dVar != null && this.f49841a.contains(Integer.valueOf(dVar.B));
            if (z6) {
                dVar.G |= 16;
            }
            return z6;
        }
    }

    public e<?> d(String str) {
        return e(str, true);
    }

    public e<?> f(String str) {
        return g(str, true);
    }

    public e<?> g(String str, boolean z5) {
        if (str == null) {
            j();
            return null;
        }
        e<?> eVar = this.f49822b.get(str);
        if (eVar == null) {
            if (f49811p.equals(str)) {
                eVar = new j();
            } else if (f49812q.equals(str)) {
                eVar = new h();
            } else if (f49813r.equals(str)) {
                eVar = new c();
            } else if (f49814s.equals(str)) {
                eVar = new i();
            } else if (f49815t.equals(str)) {
                eVar = new m();
            } else if (f49816u.equals(str)) {
                eVar = new l();
            } else if (f49817v.equals(str)) {
                eVar = new d();
            } else if (f49818w.equals(str)) {
                eVar = new C0968b();
            } else if (f49819x.equals(str)) {
                eVar = new f();
            } else if (f49820y.equals(str)) {
                eVar = new g();
            }
        }
        if (eVar == null) {
            j();
            return null;
        }
        eVar.a(null);
        if (z5) {
            this.f49822b.put(str, eVar);
            this.f49824d = (e[]) this.f49822b.values().toArray(this.f49824d);
            return eVar;
        }
        this.f49823c.put(str, eVar);
        this.f49825e = (e[]) this.f49823c.values().toArray(this.f49825e);
        return eVar;
    }

    public void k(String str) {
        l(str, true);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c extends a<Object> {

        /* renamed from: a, reason: collision with root package name */
        long f49832a = 20;

        private synchronized boolean c(master.flame.danmaku.danmaku.model.d dVar, int i6, int i7, master.flame.danmaku.danmaku.model.f fVar, boolean z5) {
            if (fVar != null) {
                if (dVar.s()) {
                    return w4.c.b() - fVar.f50080a >= this.f49832a;
                }
            }
            return false;
        }

        @Override // master.flame.danmaku.controller.b.e
        public synchronized void reset() {
        }

        @Override // master.flame.danmaku.controller.b.e
        public void a(Object obj) {
            reset();
        }

        @Override // master.flame.danmaku.controller.b.e
        public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i6, int i7, master.flame.danmaku.danmaku.model.f fVar, boolean z5, DanmakuContext danmakuContext) {
            boolean c6 = c(dVar, i6, i7, fVar, z5);
            if (c6) {
                dVar.G |= 4;
            }
            return c6;
        }

        @Override // master.flame.danmaku.controller.b.a, master.flame.danmaku.controller.b.e
        public void clear() {
            reset();
        }
    }

    private void j() {
        try {
            throw this.f49821a;
        } catch (Exception unused) {
        }
    }

    public void a() {
        for (e<?> eVar : this.f49824d) {
            if (eVar != null) {
                eVar.clear();
            }
        }
        for (e<?> eVar2 : this.f49825e) {
            if (eVar2 != null) {
                eVar2.clear();
            }
        }
    }

    public void b(master.flame.danmaku.danmaku.model.d dVar, int i6, int i7, master.flame.danmaku.danmaku.model.f fVar, boolean z5, DanmakuContext danmakuContext) {
        for (e<?> eVar : this.f49824d) {
            if (eVar != null) {
                boolean b6 = eVar.b(dVar, i6, i7, fVar, z5, danmakuContext);
                dVar.H = danmakuContext.B.f50089c;
                if (b6) {
                    return;
                }
            }
        }
    }

    public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i6, int i7, master.flame.danmaku.danmaku.model.f fVar, boolean z5, DanmakuContext danmakuContext) {
        for (e<?> eVar : this.f49825e) {
            if (eVar != null) {
                boolean b6 = eVar.b(dVar, i6, i7, fVar, z5, danmakuContext);
                dVar.H = danmakuContext.B.f50089c;
                if (b6) {
                    return true;
                }
            }
        }
        return false;
    }

    public e<?> e(String str, boolean z5) {
        e<?> eVar = (z5 ? this.f49822b : this.f49823c).get(str);
        return eVar == null ? g(str, z5) : eVar;
    }

    public void i() {
        for (e<?> eVar : this.f49824d) {
            if (eVar != null) {
                eVar.reset();
            }
        }
        for (e<?> eVar2 : this.f49825e) {
            if (eVar2 != null) {
                eVar2.reset();
            }
        }
    }

    public void l(String str, boolean z5) {
        e<?> remove = (z5 ? this.f49822b : this.f49823c).remove(str);
        if (remove != null) {
            remove.clear();
            if (z5) {
                this.f49824d = (e[]) this.f49822b.values().toArray(this.f49824d);
            } else {
                this.f49825e = (e[]) this.f49823c.values().toArray(this.f49825e);
            }
        }
    }

    public void h() {
        a();
        this.f49822b.clear();
        this.f49824d = new e[0];
        this.f49823c.clear();
        this.f49825e = new e[0];
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class a<T> implements e<T> {
        @Override // master.flame.danmaku.controller.b.e
        public void clear() {
        }
    }
}
