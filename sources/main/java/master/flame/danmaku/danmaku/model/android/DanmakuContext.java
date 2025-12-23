package master.flame.danmaku.danmaku.model.android;

import android.graphics.Typeface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import master.flame.danmaku.danmaku.model.android.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class DanmakuContext {

    /* renamed from: o, reason: collision with root package name */
    public master.flame.danmaku.danmaku.model.a f49929o;

    /* renamed from: t, reason: collision with root package name */
    private List<WeakReference<a>> f49934t;

    /* renamed from: x, reason: collision with root package name */
    private b f49938x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f49939y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f49940z;

    /* renamed from: a, reason: collision with root package name */
    public Typeface f49915a = null;

    /* renamed from: b, reason: collision with root package name */
    public int f49916b = master.flame.danmaku.danmaku.model.c.f50052a;

    /* renamed from: c, reason: collision with root package name */
    public float f49917c = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    public int f49918d = 0;

    /* renamed from: e, reason: collision with root package name */
    public boolean f49919e = true;

    /* renamed from: f, reason: collision with root package name */
    public boolean f49920f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f49921g = true;

    /* renamed from: h, reason: collision with root package name */
    public boolean f49922h = true;

    /* renamed from: i, reason: collision with root package name */
    public boolean f49923i = true;

    /* renamed from: j, reason: collision with root package name */
    List<Integer> f49924j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public int f49925k = -1;

    /* renamed from: l, reason: collision with root package name */
    public float f49926l = 1.0f;

    /* renamed from: m, reason: collision with root package name */
    public int f49927m = 15;

    /* renamed from: n, reason: collision with root package name */
    public BorderType f49928n = BorderType.SHADOW;

    /* renamed from: p, reason: collision with root package name */
    public int f49930p = 3;

    /* renamed from: q, reason: collision with root package name */
    List<Integer> f49931q = new ArrayList();

    /* renamed from: r, reason: collision with root package name */
    List<Integer> f49932r = new ArrayList();

    /* renamed from: s, reason: collision with root package name */
    List<String> f49933s = new ArrayList();

    /* renamed from: u, reason: collision with root package name */
    private boolean f49935u = false;

    /* renamed from: v, reason: collision with root package name */
    private boolean f49936v = false;

    /* renamed from: w, reason: collision with root package name */
    private boolean f49937w = false;
    private final master.flame.danmaku.danmaku.model.b A = new master.flame.danmaku.danmaku.model.android.a();
    public final master.flame.danmaku.danmaku.model.j B = new master.flame.danmaku.danmaku.model.j();
    public final master.flame.danmaku.controller.b C = new master.flame.danmaku.controller.b();
    public final d D = d.a();
    public c E = c.f49989n;
    public byte F = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum BorderType {
        NONE,
        SHADOW,
        STROKEN
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum DanmakuConfigTag {
        FT_DANMAKU_VISIBILITY,
        FB_DANMAKU_VISIBILITY,
        L2R_DANMAKU_VISIBILITY,
        R2L_DANMAKU_VISIBILIY,
        SPECIAL_DANMAKU_VISIBILITY,
        TYPEFACE,
        TRANSPARENCY,
        SCALE_TEXTSIZE,
        MAXIMUM_NUMS_IN_SCREEN,
        DANMAKU_STYLE,
        DANMAKU_BOLD,
        COLOR_VALUE_WHITE_LIST,
        USER_ID_BLACK_LIST,
        USER_HASH_BLACK_LIST,
        SCROLL_SPEED_FACTOR,
        BLOCK_GUEST_DANMAKU,
        DUPLICATE_MERGING_ENABLED,
        MAXIMUN_LINES,
        OVERLAPPING_ENABLE,
        ALIGN_BOTTOM,
        DANMAKU_MARGIN;

        public boolean isVisibilityRelatedTag() {
            return equals(FT_DANMAKU_VISIBILITY) || equals(FB_DANMAKU_VISIBILITY) || equals(L2R_DANMAKU_VISIBILITY) || equals(R2L_DANMAKU_VISIBILIY) || equals(SPECIAL_DANMAKU_VISIBILITY) || equals(COLOR_VALUE_WHITE_LIST) || equals(USER_ID_BLACK_LIST);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        boolean a(DanmakuContext danmakuContext, DanmakuConfigTag danmakuConfigTag, Object... objArr);
    }

    private <T> void J(String str, T t5) {
        K(str, t5, true);
    }

    public DanmakuContext H(boolean z5) {
        F(z5, 4);
        J(master.flame.danmaku.controller.b.f49811p, this.f49924j);
        this.B.b();
        if (this.f49920f != z5) {
            this.f49920f = z5;
            s(DanmakuConfigTag.FB_DANMAKU_VISIBILITY, Boolean.valueOf(z5));
        }
        return this;
    }

    public DanmakuContext I(boolean z5) {
        F(z5, 5);
        J(master.flame.danmaku.controller.b.f49811p, this.f49924j);
        this.B.b();
        if (this.f49919e != z5) {
            this.f49919e = z5;
            s(DanmakuConfigTag.FT_DANMAKU_VISIBILITY, Boolean.valueOf(z5));
        }
        return this;
    }

    public DanmakuContext L(boolean z5) {
        F(z5, 6);
        J(master.flame.danmaku.controller.b.f49811p, this.f49924j);
        this.B.b();
        if (this.f49921g != z5) {
            this.f49921g = z5;
            s(DanmakuConfigTag.L2R_DANMAKU_VISIBILITY, Boolean.valueOf(z5));
        }
        return this;
    }

    public DanmakuContext N(Map<Integer, Integer> map) {
        this.f49939y = map != null;
        if (map == null) {
            this.C.l(master.flame.danmaku.controller.b.f49819x, false);
        } else {
            K(master.flame.danmaku.controller.b.f49819x, map, false);
        }
        this.B.b();
        s(DanmakuConfigTag.MAXIMUN_LINES, map);
        return this;
    }

    public DanmakuContext Q(boolean z5) {
        F(z5, 1);
        J(master.flame.danmaku.controller.b.f49811p, this.f49924j);
        this.B.b();
        if (this.f49922h != z5) {
            this.f49922h = z5;
            s(DanmakuConfigTag.R2L_DANMAKU_VISIBILIY, Boolean.valueOf(z5));
        }
        return this;
    }

    public DanmakuContext T(boolean z5) {
        F(z5, 7);
        J(master.flame.danmaku.controller.b.f49811p, this.f49924j);
        this.B.b();
        if (this.f49923i != z5) {
            this.f49923i = z5;
            s(DanmakuConfigTag.SPECIAL_DANMAKU_VISIBILITY, Boolean.valueOf(z5));
        }
        return this;
    }

    public DanmakuContext t(Map<Integer, Boolean> map) {
        this.f49940z = map != null;
        if (map == null) {
            this.C.l(master.flame.danmaku.controller.b.f49820y, false);
        } else {
            K(master.flame.danmaku.controller.b.f49820y, map, false);
        }
        this.B.b();
        s(DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    private void F(boolean z5, int i6) {
        if (z5) {
            this.f49924j.remove(Integer.valueOf(i6));
        } else {
            if (this.f49924j.contains(Integer.valueOf(i6))) {
                return;
            }
            this.f49924j.add(Integer.valueOf(i6));
        }
    }

    private <T> void K(String str, T t5, boolean z5) {
        this.C.e(str, z5).a(t5);
    }

    public static DanmakuContext e() {
        return new DanmakuContext();
    }

    private void s(DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        List<WeakReference<a>> list = this.f49934t;
        if (list != null) {
            Iterator<WeakReference<a>> it = list.iterator();
            while (it.hasNext()) {
                a aVar = it.next().get();
                if (aVar != null) {
                    aVar.a(this, danmakuConfigTag, objArr);
                }
            }
        }
    }

    public DanmakuContext A(boolean z5) {
        this.A.x(z5);
        s(DanmakuConfigTag.DANMAKU_BOLD, Boolean.valueOf(z5));
        return this;
    }

    public DanmakuContext B(int i6) {
        if (this.f49918d != i6) {
            this.f49918d = i6;
            this.A.f(i6);
            this.B.b();
            this.B.g();
            s(DanmakuConfigTag.DANMAKU_MARGIN, Integer.valueOf(i6));
        }
        return this;
    }

    public DanmakuContext C(int i6, float... fArr) {
        this.A.b(i6, fArr);
        s(DanmakuConfigTag.DANMAKU_STYLE, Integer.valueOf(i6), fArr);
        return this;
    }

    public DanmakuContext D(master.flame.danmaku.danmaku.model.a aVar) {
        this.f49929o = aVar;
        return this;
    }

    public DanmakuContext E(float f6) {
        int i6 = (int) (master.flame.danmaku.danmaku.model.c.f50052a * f6);
        if (i6 != this.f49916b) {
            this.f49916b = i6;
            this.A.z(i6);
            s(DanmakuConfigTag.TRANSPARENCY, Float.valueOf(f6));
        }
        return this;
    }

    public DanmakuContext G(boolean z5) {
        if (this.f49936v != z5) {
            this.f49936v = z5;
            this.B.b();
            s(DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, Boolean.valueOf(z5));
        }
        return this;
    }

    public DanmakuContext M(int i6) {
        this.A.q(i6);
        return this;
    }

    public DanmakuContext O(int i6) {
        this.f49925k = i6;
        if (i6 == 0) {
            this.C.k(master.flame.danmaku.controller.b.f49812q);
            this.C.k(master.flame.danmaku.controller.b.f49813r);
            s(DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN, Integer.valueOf(i6));
            return this;
        }
        if (i6 == -1) {
            this.C.k(master.flame.danmaku.controller.b.f49812q);
            this.C.f(master.flame.danmaku.controller.b.f49813r);
            s(DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN, Integer.valueOf(i6));
            return this;
        }
        J(master.flame.danmaku.controller.b.f49812q, Integer.valueOf(i6));
        this.B.b();
        s(DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN, Integer.valueOf(i6));
        return this;
    }

    public DanmakuContext R(float f6) {
        if (this.f49917c != f6) {
            this.f49917c = f6;
            this.A.r();
            this.A.y(f6);
            this.B.d();
            this.B.g();
            s(DanmakuConfigTag.SCALE_TEXTSIZE, Float.valueOf(f6));
        }
        return this;
    }

    public DanmakuContext S(float f6) {
        if (this.f49926l != f6) {
            this.f49926l = f6;
            this.D.l(f6);
            this.B.d();
            this.B.g();
            s(DanmakuConfigTag.SCROLL_SPEED_FACTOR, Float.valueOf(f6));
        }
        return this;
    }

    public DanmakuContext U(Typeface typeface) {
        if (this.f49915a != typeface) {
            this.f49915a = typeface;
            this.A.r();
            this.A.A(typeface);
            s(DanmakuConfigTag.TYPEFACE, new Object[0]);
        }
        return this;
    }

    public DanmakuContext V(String... strArr) {
        this.f49933s.clear();
        if (strArr == null || strArr.length == 0) {
            this.C.k(master.flame.danmaku.controller.b.f49816u);
        } else {
            Collections.addAll(this.f49933s, strArr);
            J(master.flame.danmaku.controller.b.f49816u, this.f49933s);
        }
        this.B.b();
        s(DanmakuConfigTag.USER_HASH_BLACK_LIST, this.f49933s);
        return this;
    }

    public DanmakuContext W(Integer... numArr) {
        this.f49932r.clear();
        if (numArr == null || numArr.length == 0) {
            this.C.k(master.flame.danmaku.controller.b.f49815t);
        } else {
            Collections.addAll(this.f49932r, numArr);
            J(master.flame.danmaku.controller.b.f49815t, this.f49932r);
        }
        this.B.b();
        s(DanmakuConfigTag.USER_ID_BLACK_LIST, this.f49932r);
        return this;
    }

    public void X() {
        List<WeakReference<a>> list = this.f49934t;
        if (list != null) {
            list.clear();
            this.f49934t = null;
        }
    }

    public void Y(a aVar) {
        List<WeakReference<a>> list;
        if (aVar == null || (list = this.f49934t) == null) {
            return;
        }
        Iterator<WeakReference<a>> it = list.iterator();
        while (it.hasNext()) {
            if (aVar.equals(it.next().get())) {
                this.f49934t.remove(aVar);
                return;
            }
        }
    }

    public DanmakuContext a(String... strArr) {
        if (strArr != null && strArr.length != 0) {
            Collections.addAll(this.f49933s, strArr);
            J(master.flame.danmaku.controller.b.f49816u, this.f49933s);
            this.B.b();
            s(DanmakuConfigTag.USER_HASH_BLACK_LIST, this.f49933s);
        }
        return this;
    }

    public DanmakuContext b(Integer... numArr) {
        if (numArr != null && numArr.length != 0) {
            Collections.addAll(this.f49932r, numArr);
            J(master.flame.danmaku.controller.b.f49815t, this.f49932r);
            this.B.b();
            s(DanmakuConfigTag.USER_ID_BLACK_LIST, this.f49932r);
        }
        return this;
    }

    public DanmakuContext c(boolean z5) {
        if (this.f49937w != z5) {
            this.f49937w = z5;
            s(DanmakuConfigTag.ALIGN_BOTTOM, Boolean.valueOf(z5));
            this.B.g();
        }
        return this;
    }

    public DanmakuContext d(boolean z5) {
        if (this.f49935u != z5) {
            this.f49935u = z5;
            if (z5) {
                J(master.flame.danmaku.controller.b.f49817v, Boolean.valueOf(z5));
            } else {
                this.C.k(master.flame.danmaku.controller.b.f49817v);
            }
            this.B.b();
            s(DanmakuConfigTag.BLOCK_GUEST_DANMAKU, Boolean.valueOf(z5));
        }
        return this;
    }

    public List<Integer> f() {
        return this.f49931q;
    }

    public master.flame.danmaku.danmaku.model.b g() {
        return this.A;
    }

    public boolean h() {
        return this.f49920f;
    }

    public boolean i() {
        return this.f49919e;
    }

    public boolean j() {
        return this.f49921g;
    }

    public boolean k() {
        return this.f49922h;
    }

    public boolean l() {
        return this.f49923i;
    }

    public List<String> m() {
        return this.f49933s;
    }

    public List<Integer> n() {
        return this.f49932r;
    }

    public boolean o() {
        return this.f49937w;
    }

    public boolean p() {
        return this.f49936v;
    }

    public boolean q() {
        return this.f49939y;
    }

    public boolean r() {
        return this.f49940z;
    }

    public void u(a aVar) {
        if (aVar == null || this.f49934t == null) {
            this.f49934t = Collections.synchronizedList(new ArrayList());
        }
        Iterator<WeakReference<a>> it = this.f49934t.iterator();
        while (it.hasNext()) {
            if (aVar.equals(it.next().get())) {
                return;
            }
        }
        this.f49934t.add(new WeakReference<>(aVar));
    }

    public DanmakuContext v(String... strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                this.f49933s.remove(str);
            }
            J(master.flame.danmaku.controller.b.f49816u, this.f49933s);
            this.B.b();
            s(DanmakuConfigTag.USER_HASH_BLACK_LIST, this.f49933s);
        }
        return this;
    }

    public DanmakuContext w(Integer... numArr) {
        if (numArr != null && numArr.length != 0) {
            for (Integer num : numArr) {
                this.f49932r.remove(num);
            }
            J(master.flame.danmaku.controller.b.f49815t, this.f49932r);
            this.B.b();
            s(DanmakuConfigTag.USER_ID_BLACK_LIST, this.f49932r);
        }
        return this;
    }

    public DanmakuContext x(b bVar, b.a aVar) {
        this.f49938x = bVar;
        if (bVar != null) {
            bVar.h(aVar);
            this.A.v(this.f49938x);
        }
        return this;
    }

    public DanmakuContext y(c cVar) {
        this.E = cVar;
        return this;
    }

    public DanmakuContext z(Integer... numArr) {
        this.f49931q.clear();
        if (numArr == null || numArr.length == 0) {
            this.C.k(master.flame.danmaku.controller.b.f49814s);
        } else {
            Collections.addAll(this.f49931q, numArr);
            J(master.flame.danmaku.controller.b.f49814s, this.f49931q);
        }
        this.B.b();
        s(DanmakuConfigTag.COLOR_VALUE_WHITE_LIST, this.f49931q);
        return this;
    }

    @Deprecated
    public DanmakuContext P(Map<Integer, Boolean> map) {
        return t(map);
    }
}
