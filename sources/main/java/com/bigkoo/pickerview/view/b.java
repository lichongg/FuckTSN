package com.bigkoo.pickerview.view;

import android.graphics.Typeface;
import android.view.View;
import com.bigkoo.pickerview.R;
import com.bigkoo.pickerview.lib.WheelView;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class b<T> {

    /* renamed from: a, reason: collision with root package name */
    private View f14457a;

    /* renamed from: b, reason: collision with root package name */
    private WheelView f14458b;

    /* renamed from: c, reason: collision with root package name */
    private WheelView f14459c;

    /* renamed from: d, reason: collision with root package name */
    private WheelView f14460d;

    /* renamed from: e, reason: collision with root package name */
    private List<T> f14461e;

    /* renamed from: f, reason: collision with root package name */
    private List<List<T>> f14462f;

    /* renamed from: g, reason: collision with root package name */
    private List<T> f14463g;

    /* renamed from: h, reason: collision with root package name */
    private List<List<List<T>>> f14464h;

    /* renamed from: i, reason: collision with root package name */
    private List<T> f14465i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f14466j;

    /* renamed from: k, reason: collision with root package name */
    private p.c f14467k;

    /* renamed from: l, reason: collision with root package name */
    private p.c f14468l;

    /* renamed from: m, reason: collision with root package name */
    int f14469m;

    /* renamed from: n, reason: collision with root package name */
    int f14470n;

    /* renamed from: o, reason: collision with root package name */
    int f14471o;

    /* renamed from: p, reason: collision with root package name */
    private WheelView.DividerType f14472p;

    /* renamed from: q, reason: collision with root package name */
    float f14473q = 1.6f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements p.c {
        a() {
        }

        @Override // p.c
        public void a(int i6) {
            int i7;
            if (b.this.f14462f != null) {
                i7 = b.this.f14459c.getCurrentItem();
                if (i7 >= ((List) b.this.f14462f.get(i6)).size() - 1) {
                    i7 = ((List) b.this.f14462f.get(i6)).size() - 1;
                }
                b.this.f14459c.setAdapter(new o.a((List) b.this.f14462f.get(i6)));
                b.this.f14459c.setCurrentItem(i7);
            } else {
                i7 = 0;
            }
            if (b.this.f14464h != null) {
                b.this.f14468l.a(i7);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bigkoo.pickerview.view.b$b, reason: collision with other inner class name */
    class C0145b implements p.c {
        C0145b() {
        }

        @Override // p.c
        public void a(int i6) {
            if (b.this.f14464h != null) {
                int currentItem = b.this.f14458b.getCurrentItem();
                if (currentItem >= b.this.f14464h.size() - 1) {
                    currentItem = b.this.f14464h.size() - 1;
                }
                if (i6 >= ((List) b.this.f14462f.get(currentItem)).size() - 1) {
                    i6 = ((List) b.this.f14462f.get(currentItem)).size() - 1;
                }
                int currentItem2 = b.this.f14460d.getCurrentItem();
                if (currentItem2 >= ((List) ((List) b.this.f14464h.get(currentItem)).get(i6)).size() - 1) {
                    currentItem2 = ((List) ((List) b.this.f14464h.get(currentItem)).get(i6)).size() - 1;
                }
                b.this.f14460d.setAdapter(new o.a((List) ((List) b.this.f14464h.get(b.this.f14458b.getCurrentItem())).get(i6)));
                b.this.f14460d.setCurrentItem(currentItem2);
            }
        }
    }

    public int[] g() {
        int[] iArr = new int[3];
        iArr[0] = this.f14458b.getCurrentItem();
        List<List<T>> list = this.f14462f;
        if (list == null || list.size() <= 0) {
            iArr[1] = this.f14459c.getCurrentItem();
        } else {
            iArr[1] = this.f14459c.getCurrentItem() > this.f14462f.get(iArr[0]).size() - 1 ? 0 : this.f14459c.getCurrentItem();
        }
        List<List<List<T>>> list2 = this.f14464h;
        if (list2 == null || list2.size() <= 0) {
            iArr[2] = this.f14460d.getCurrentItem();
            return iArr;
        }
        iArr[2] = this.f14460d.getCurrentItem() <= this.f14464h.get(iArr[0]).get(iArr[1]).size() - 1 ? this.f14460d.getCurrentItem() : 0;
        return iArr;
    }

    private void i(int i6, int i7, int i8) {
        List<List<T>> list = this.f14462f;
        if (list != null) {
            this.f14459c.setAdapter(new o.a(list.get(i6)));
            this.f14459c.setCurrentItem(i7);
        }
        List<List<List<T>>> list2 = this.f14464h;
        if (list2 != null) {
            this.f14460d.setAdapter(new o.a(list2.get(i6).get(i7)));
            this.f14460d.setCurrentItem(i8);
        }
    }

    private void m() {
        this.f14458b.setDividerColor(this.f14471o);
        this.f14459c.setDividerColor(this.f14471o);
        this.f14460d.setDividerColor(this.f14471o);
    }

    private void o() {
        this.f14458b.setDividerType(this.f14472p);
        this.f14459c.setDividerType(this.f14472p);
        this.f14460d.setDividerType(this.f14472p);
    }

    private void r() {
        this.f14458b.setLineSpacingMultiplier(this.f14473q);
        this.f14459c.setLineSpacingMultiplier(this.f14473q);
        this.f14460d.setLineSpacingMultiplier(this.f14473q);
    }

    private void v() {
        this.f14458b.setTextColorCenter(this.f14470n);
        this.f14459c.setTextColorCenter(this.f14470n);
        this.f14460d.setTextColorCenter(this.f14470n);
    }

    private void x() {
        this.f14458b.setTextColorOut(this.f14469m);
        this.f14459c.setTextColorOut(this.f14469m);
        this.f14460d.setTextColorOut(this.f14469m);
    }

    public void A(Typeface typeface) {
        this.f14458b.setTypeface(typeface);
        this.f14459c.setTypeface(typeface);
        this.f14460d.setTypeface(typeface);
    }

    public void B(View view) {
        this.f14457a = view;
    }

    public View h() {
        return this.f14457a;
    }

    public void j(int i6, int i7, int i8) {
        if (this.f14466j) {
            i(i6, i7, i8);
        }
        this.f14458b.setCurrentItem(i6);
        this.f14459c.setCurrentItem(i7);
        this.f14460d.setCurrentItem(i8);
    }

    public void k(boolean z5) {
        this.f14458b.setCyclic(z5);
        this.f14459c.setCyclic(z5);
        this.f14460d.setCyclic(z5);
    }

    public void l(boolean z5, boolean z6, boolean z7) {
        this.f14458b.setCyclic(z5);
        this.f14459c.setCyclic(z6);
        this.f14460d.setCyclic(z7);
    }

    public void n(int i6) {
        this.f14471o = i6;
        m();
    }

    public void p(WheelView.DividerType dividerType) {
        this.f14472p = dividerType;
        o();
    }

    public void q(String str, String str2, String str3) {
        if (str != null) {
            this.f14458b.setLabel(str);
        }
        if (str2 != null) {
            this.f14459c.setLabel(str2);
        }
        if (str3 != null) {
            this.f14460d.setLabel(str3);
        }
    }

    public void s(float f6) {
        this.f14473q = f6;
        r();
    }

    public void t(List<T> list, List<T> list2, List<T> list3) {
        this.f14461e = list;
        this.f14463g = list2;
        this.f14465i = list3;
        int i6 = list3 == null ? 8 : 4;
        if (list2 == null) {
            i6 = 12;
        }
        this.f14458b.setAdapter(new o.a(list, i6));
        this.f14458b.setCurrentItem(0);
        List<T> list4 = this.f14463g;
        if (list4 != null) {
            this.f14459c.setAdapter(new o.a(list4));
        }
        this.f14459c.setCurrentItem(this.f14458b.getCurrentItem());
        List<T> list5 = this.f14465i;
        if (list5 != null) {
            this.f14460d.setAdapter(new o.a(list5));
        }
        WheelView wheelView = this.f14460d;
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        this.f14458b.setIsOptions(true);
        this.f14459c.setIsOptions(true);
        this.f14460d.setIsOptions(true);
        if (this.f14463g == null) {
            this.f14459c.setVisibility(8);
        }
        if (this.f14465i == null) {
            this.f14460d.setVisibility(8);
        }
    }

    public void u(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        this.f14461e = list;
        this.f14462f = list2;
        this.f14464h = list3;
        int i6 = list3 == null ? 8 : 4;
        if (list2 == null) {
            i6 = 12;
        }
        this.f14458b.setAdapter(new o.a(list, i6));
        this.f14458b.setCurrentItem(0);
        List<List<T>> list4 = this.f14462f;
        if (list4 != null) {
            this.f14459c.setAdapter(new o.a(list4.get(0)));
        }
        this.f14459c.setCurrentItem(this.f14458b.getCurrentItem());
        List<List<List<T>>> list5 = this.f14464h;
        if (list5 != null) {
            this.f14460d.setAdapter(new o.a(list5.get(0).get(0)));
        }
        WheelView wheelView = this.f14460d;
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        this.f14458b.setIsOptions(true);
        this.f14459c.setIsOptions(true);
        this.f14460d.setIsOptions(true);
        if (this.f14462f == null) {
            this.f14459c.setVisibility(8);
        }
        if (this.f14464h == null) {
            this.f14460d.setVisibility(8);
        }
        this.f14467k = new a();
        this.f14468l = new C0145b();
        if (list2 != null && this.f14466j) {
            this.f14458b.setOnItemSelectedListener(this.f14467k);
        }
        if (list3 == null || !this.f14466j) {
            return;
        }
        this.f14459c.setOnItemSelectedListener(this.f14468l);
    }

    public void w(int i6) {
        this.f14470n = i6;
        v();
    }

    public void y(int i6) {
        this.f14469m = i6;
        x();
    }

    public void z(int i6) {
        float f6 = i6;
        this.f14458b.setTextSize(f6);
        this.f14459c.setTextSize(f6);
        this.f14460d.setTextSize(f6);
    }

    public b(View view, Boolean bool) {
        this.f14466j = bool.booleanValue();
        this.f14457a = view;
        this.f14458b = (WheelView) view.findViewById(R.id.options1);
        this.f14459c = (WheelView) view.findViewById(R.id.options2);
        this.f14460d = (WheelView) view.findViewById(R.id.options3);
    }
}
