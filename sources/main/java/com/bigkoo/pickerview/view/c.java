package com.bigkoo.pickerview.view;

import android.view.View;
import com.bigkoo.pickerview.R;
import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.lib.WheelView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class c {
    private static final int A = 12;
    private static final int B = 1;
    private static final int C = 31;

    /* renamed from: w, reason: collision with root package name */
    public static DateFormat f14476w = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: x, reason: collision with root package name */
    private static final int f14477x = 1900;

    /* renamed from: y, reason: collision with root package name */
    private static final int f14478y = 2100;

    /* renamed from: z, reason: collision with root package name */
    private static final int f14479z = 1;

    /* renamed from: a, reason: collision with root package name */
    private View f14480a;

    /* renamed from: b, reason: collision with root package name */
    private WheelView f14481b;

    /* renamed from: c, reason: collision with root package name */
    private WheelView f14482c;

    /* renamed from: d, reason: collision with root package name */
    private WheelView f14483d;

    /* renamed from: e, reason: collision with root package name */
    private WheelView f14484e;

    /* renamed from: f, reason: collision with root package name */
    private WheelView f14485f;

    /* renamed from: g, reason: collision with root package name */
    private WheelView f14486g;

    /* renamed from: h, reason: collision with root package name */
    private int f14487h;

    /* renamed from: i, reason: collision with root package name */
    private TimePickerView.Type f14488i;

    /* renamed from: j, reason: collision with root package name */
    private int f14489j;

    /* renamed from: k, reason: collision with root package name */
    private int f14490k;

    /* renamed from: l, reason: collision with root package name */
    private int f14491l;

    /* renamed from: m, reason: collision with root package name */
    private int f14492m;

    /* renamed from: n, reason: collision with root package name */
    private int f14493n;

    /* renamed from: o, reason: collision with root package name */
    private int f14494o;

    /* renamed from: p, reason: collision with root package name */
    private int f14495p;

    /* renamed from: q, reason: collision with root package name */
    private int f14496q;

    /* renamed from: r, reason: collision with root package name */
    int f14497r;

    /* renamed from: s, reason: collision with root package name */
    int f14498s;

    /* renamed from: t, reason: collision with root package name */
    int f14499t;

    /* renamed from: u, reason: collision with root package name */
    float f14500u;

    /* renamed from: v, reason: collision with root package name */
    private WheelView.DividerType f14501v;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements p.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f14502a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f14503b;

        a(List list, List list2) {
            this.f14502a = list;
            this.f14503b = list2;
        }

        @Override // p.c
        public void a(int i6) {
            int i7 = i6 + c.this.f14489j;
            c.this.f14495p = i7;
            int currentItem = c.this.f14482c.getCurrentItem();
            if (c.this.f14489j == c.this.f14490k) {
                c.this.f14482c.setAdapter(new o.b(c.this.f14491l, c.this.f14492m));
                if (currentItem > c.this.f14482c.getAdapter().a() - 1) {
                    currentItem = c.this.f14482c.getAdapter().a() - 1;
                    c.this.f14482c.setCurrentItem(currentItem);
                }
                int i8 = currentItem + c.this.f14491l;
                if (c.this.f14491l == c.this.f14492m) {
                    c cVar = c.this;
                    cVar.B(i7, i8, cVar.f14493n, c.this.f14494o, this.f14502a, this.f14503b);
                    return;
                } else if (i8 != c.this.f14491l) {
                    c.this.B(i7, i8, 1, 31, this.f14502a, this.f14503b);
                    return;
                } else {
                    c cVar2 = c.this;
                    cVar2.B(i7, i8, cVar2.f14493n, 31, this.f14502a, this.f14503b);
                    return;
                }
            }
            if (i7 == c.this.f14489j) {
                c.this.f14482c.setAdapter(new o.b(c.this.f14491l, 12));
                if (currentItem > c.this.f14482c.getAdapter().a() - 1) {
                    currentItem = c.this.f14482c.getAdapter().a() - 1;
                    c.this.f14482c.setCurrentItem(currentItem);
                }
                int i9 = currentItem + c.this.f14491l;
                if (i9 != c.this.f14491l) {
                    c.this.B(i7, i9, 1, 31, this.f14502a, this.f14503b);
                    return;
                } else {
                    c cVar3 = c.this;
                    cVar3.B(i7, i9, cVar3.f14493n, 31, this.f14502a, this.f14503b);
                    return;
                }
            }
            if (i7 != c.this.f14490k) {
                c.this.f14482c.setAdapter(new o.b(1, 12));
                c cVar4 = c.this;
                cVar4.B(i7, 1 + cVar4.f14482c.getCurrentItem(), 1, 31, this.f14502a, this.f14503b);
                return;
            }
            c.this.f14482c.setAdapter(new o.b(1, c.this.f14492m));
            if (currentItem > c.this.f14482c.getAdapter().a() - 1) {
                currentItem = c.this.f14482c.getAdapter().a() - 1;
                c.this.f14482c.setCurrentItem(currentItem);
            }
            int i10 = 1 + currentItem;
            if (i10 != c.this.f14492m) {
                c.this.B(i7, i10, 1, 31, this.f14502a, this.f14503b);
            } else {
                c cVar5 = c.this;
                cVar5.B(i7, i10, 1, cVar5.f14494o, this.f14502a, this.f14503b);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements p.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f14505a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f14506b;

        b(List list, List list2) {
            this.f14505a = list;
            this.f14506b = list2;
        }

        @Override // p.c
        public void a(int i6) {
            int i7 = i6 + 1;
            if (c.this.f14489j == c.this.f14490k) {
                int i8 = (i7 + c.this.f14491l) - 1;
                if (c.this.f14491l == c.this.f14492m) {
                    c cVar = c.this;
                    cVar.B(cVar.f14495p, i8, c.this.f14493n, c.this.f14494o, this.f14505a, this.f14506b);
                    return;
                } else if (c.this.f14491l == i8) {
                    c cVar2 = c.this;
                    cVar2.B(cVar2.f14495p, i8, c.this.f14493n, 31, this.f14505a, this.f14506b);
                    return;
                } else if (c.this.f14492m == i8) {
                    c cVar3 = c.this;
                    cVar3.B(cVar3.f14495p, i8, 1, c.this.f14494o, this.f14505a, this.f14506b);
                    return;
                } else {
                    c cVar4 = c.this;
                    cVar4.B(cVar4.f14495p, i8, 1, 31, this.f14505a, this.f14506b);
                    return;
                }
            }
            if (c.this.f14495p == c.this.f14489j) {
                int i9 = (i7 + c.this.f14491l) - 1;
                if (i9 == c.this.f14491l) {
                    c cVar5 = c.this;
                    cVar5.B(cVar5.f14495p, i9, c.this.f14493n, 31, this.f14505a, this.f14506b);
                    return;
                } else {
                    c cVar6 = c.this;
                    cVar6.B(cVar6.f14495p, i9, 1, 31, this.f14505a, this.f14506b);
                    return;
                }
            }
            if (c.this.f14495p != c.this.f14490k) {
                c cVar7 = c.this;
                cVar7.B(cVar7.f14495p, i7, 1, 31, this.f14505a, this.f14506b);
            } else if (i7 == c.this.f14492m) {
                c cVar8 = c.this;
                cVar8.B(cVar8.f14495p, c.this.f14482c.getCurrentItem() + 1, 1, c.this.f14494o, this.f14505a, this.f14506b);
            } else {
                c cVar9 = c.this;
                cVar9.B(cVar9.f14495p, c.this.f14482c.getCurrentItem() + 1, 1, 31, this.f14505a, this.f14506b);
            }
        }
    }

    public c(View view) {
        this.f14489j = 1900;
        this.f14490k = 2100;
        this.f14491l = 1;
        this.f14492m = 12;
        this.f14493n = 1;
        this.f14494o = 31;
        this.f14496q = 18;
        this.f14500u = 1.6f;
        this.f14480a = view;
        this.f14488i = TimePickerView.Type.ALL;
        H(view);
    }

    public void A(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i6 = calendar2.get(1);
            int i7 = calendar2.get(2) + 1;
            int i8 = calendar2.get(5);
            int i9 = this.f14489j;
            if (i6 > i9) {
                this.f14490k = i6;
                this.f14492m = i7;
                this.f14494o = i8;
                return;
            } else {
                if (i6 == i9) {
                    int i10 = this.f14491l;
                    if (i7 > i10) {
                        this.f14490k = i6;
                        this.f14492m = i7;
                        this.f14494o = i8;
                        return;
                    } else {
                        if (i7 != i10 || i7 <= this.f14493n) {
                            return;
                        }
                        this.f14490k = i6;
                        this.f14492m = i7;
                        this.f14494o = i8;
                        return;
                    }
                }
                return;
            }
        }
        if (calendar == null || calendar2 != null) {
            if (calendar == null || calendar2 == null) {
                return;
            }
            this.f14489j = calendar.get(1);
            this.f14490k = calendar2.get(1);
            this.f14491l = calendar.get(2) + 1;
            this.f14492m = calendar2.get(2) + 1;
            this.f14493n = calendar.get(5);
            this.f14494o = calendar2.get(5);
            return;
        }
        int i11 = calendar.get(1);
        int i12 = calendar.get(2) + 1;
        int i13 = calendar.get(5);
        int i14 = this.f14490k;
        if (i11 < i14) {
            this.f14491l = i12;
            this.f14493n = i13;
            this.f14489j = i11;
        } else if (i11 == i14) {
            int i15 = this.f14492m;
            if (i12 < i15) {
                this.f14491l = i12;
                this.f14493n = i13;
                this.f14489j = i11;
            } else {
                if (i12 != i15 || i13 >= this.f14494o) {
                    return;
                }
                this.f14491l = i12;
                this.f14493n = i13;
                this.f14489j = i11;
            }
        }
    }

    public void y(int i6, int i7, int i8) {
        z(i6, i7, i8, 0, 0, 0);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bigkoo.pickerview.view.c$c, reason: collision with other inner class name */
    static /* synthetic */ class C0146c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14508a;

        static {
            int[] iArr = new int[TimePickerView.Type.values().length];
            f14508a = iArr;
            try {
                iArr[TimePickerView.Type.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14508a[TimePickerView.Type.YEAR_MONTH_DAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14508a[TimePickerView.Type.HOURS_MINS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14508a[TimePickerView.Type.MONTH_DAY_HOUR_MIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14508a[TimePickerView.Type.YEAR_MONTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14508a[TimePickerView.Type.YEAR_MONTH_DAY_HOUR_MIN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i6, int i7, int i8, int i9, List<String> list, List<String> list2) {
        int currentItem = this.f14483d.getCurrentItem();
        if (list.contains(String.valueOf(i7))) {
            if (i9 > 31) {
                i9 = 31;
            }
            this.f14483d.setAdapter(new o.b(i8, i9));
        } else if (list2.contains(String.valueOf(i7))) {
            if (i9 > 30) {
                i9 = 30;
            }
            this.f14483d.setAdapter(new o.b(i8, i9));
        } else if ((i6 % 4 != 0 || i6 % 100 == 0) && i6 % 400 != 0) {
            if (i9 > 28) {
                i9 = 28;
            }
            this.f14483d.setAdapter(new o.b(i8, i9));
        } else {
            if (i9 > 29) {
                i9 = 29;
            }
            this.f14483d.setAdapter(new o.b(i8, i9));
        }
        if (currentItem > this.f14483d.getAdapter().a() - 1) {
            this.f14483d.setCurrentItem(this.f14483d.getAdapter().a() - 1);
        }
    }

    private void D() {
        this.f14483d.setTextColorCenter(this.f14498s);
        this.f14482c.setTextColorCenter(this.f14498s);
        this.f14481b.setTextColorCenter(this.f14498s);
        this.f14484e.setTextColorCenter(this.f14498s);
        this.f14485f.setTextColorCenter(this.f14498s);
        this.f14486g.setTextColorCenter(this.f14498s);
    }

    private void F() {
        this.f14483d.setTextColorOut(this.f14497r);
        this.f14482c.setTextColorOut(this.f14497r);
        this.f14481b.setTextColorOut(this.f14497r);
        this.f14484e.setTextColorOut(this.f14497r);
        this.f14485f.setTextColorOut(this.f14497r);
        this.f14486g.setTextColorOut(this.f14497r);
    }

    private void o() {
        this.f14483d.setTextSize(this.f14496q);
        this.f14482c.setTextSize(this.f14496q);
        this.f14481b.setTextSize(this.f14496q);
        this.f14484e.setTextSize(this.f14496q);
        this.f14485f.setTextSize(this.f14496q);
        this.f14486g.setTextSize(this.f14496q);
    }

    private void q() {
        this.f14483d.setDividerColor(this.f14499t);
        this.f14482c.setDividerColor(this.f14499t);
        this.f14481b.setDividerColor(this.f14499t);
        this.f14484e.setDividerColor(this.f14499t);
        this.f14485f.setDividerColor(this.f14499t);
        this.f14486g.setDividerColor(this.f14499t);
    }

    private void s() {
        this.f14483d.setDividerType(this.f14501v);
        this.f14482c.setDividerType(this.f14501v);
        this.f14481b.setDividerType(this.f14501v);
        this.f14484e.setDividerType(this.f14501v);
        this.f14485f.setDividerType(this.f14501v);
        this.f14486g.setDividerType(this.f14501v);
    }

    private void w() {
        this.f14483d.setLineSpacingMultiplier(this.f14500u);
        this.f14482c.setLineSpacingMultiplier(this.f14500u);
        this.f14481b.setLineSpacingMultiplier(this.f14500u);
        this.f14484e.setLineSpacingMultiplier(this.f14500u);
        this.f14485f.setLineSpacingMultiplier(this.f14500u);
        this.f14486g.setLineSpacingMultiplier(this.f14500u);
    }

    public void C(int i6) {
        this.f14489j = i6;
    }

    public void E(int i6) {
        this.f14498s = i6;
        D();
    }

    public void G(int i6) {
        this.f14497r = i6;
        F();
    }

    public void H(View view) {
        this.f14480a = view;
    }

    public int k() {
        return this.f14490k;
    }

    public int l() {
        return this.f14489j;
    }

    public String m() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f14495p == this.f14489j) {
            this.f14482c.getCurrentItem();
            System.out.getClass();
            int currentItem = this.f14482c.getCurrentItem();
            int i6 = this.f14491l;
            if (currentItem + i6 == i6) {
                stringBuffer.append(this.f14481b.getCurrentItem() + this.f14489j);
                stringBuffer.append("-");
                stringBuffer.append(this.f14482c.getCurrentItem() + this.f14491l);
                stringBuffer.append("-");
                stringBuffer.append(this.f14483d.getCurrentItem() + this.f14493n);
                stringBuffer.append(" ");
                stringBuffer.append(this.f14484e.getCurrentItem());
                stringBuffer.append(":");
                stringBuffer.append(this.f14485f.getCurrentItem());
                stringBuffer.append(":");
                stringBuffer.append(this.f14486g.getCurrentItem());
            } else {
                stringBuffer.append(this.f14481b.getCurrentItem() + this.f14489j);
                stringBuffer.append("-");
                stringBuffer.append(this.f14482c.getCurrentItem() + this.f14491l);
                stringBuffer.append("-");
                stringBuffer.append(this.f14483d.getCurrentItem() + 1);
                stringBuffer.append(" ");
                stringBuffer.append(this.f14484e.getCurrentItem());
                stringBuffer.append(":");
                stringBuffer.append(this.f14485f.getCurrentItem());
                stringBuffer.append(":");
                stringBuffer.append(this.f14486g.getCurrentItem());
            }
        } else {
            stringBuffer.append(this.f14481b.getCurrentItem() + this.f14489j);
            stringBuffer.append("-");
            stringBuffer.append(this.f14482c.getCurrentItem() + 1);
            stringBuffer.append("-");
            stringBuffer.append(this.f14483d.getCurrentItem() + 1);
            stringBuffer.append(" ");
            stringBuffer.append(this.f14484e.getCurrentItem());
            stringBuffer.append(":");
            stringBuffer.append(this.f14485f.getCurrentItem());
            stringBuffer.append(":");
            stringBuffer.append(this.f14486g.getCurrentItem());
        }
        return stringBuffer.toString();
    }

    public View n() {
        return this.f14480a;
    }

    public void p(boolean z5) {
        this.f14481b.setCyclic(z5);
        this.f14482c.setCyclic(z5);
        this.f14483d.setCyclic(z5);
        this.f14484e.setCyclic(z5);
        this.f14485f.setCyclic(z5);
        this.f14486g.setCyclic(z5);
    }

    public void r(int i6) {
        this.f14499t = i6;
        q();
    }

    public void t(WheelView.DividerType dividerType) {
        this.f14501v = dividerType;
        s();
    }

    public void u(int i6) {
        this.f14490k = i6;
    }

    public void v(String str, String str2, String str3, String str4, String str5, String str6) {
        if (str != null) {
            this.f14481b.setLabel(str);
        } else {
            this.f14481b.setLabel(this.f14480a.getContext().getString(R.string.pickerview_year));
        }
        if (str2 != null) {
            this.f14482c.setLabel(str2);
        } else {
            this.f14482c.setLabel(this.f14480a.getContext().getString(R.string.pickerview_month));
        }
        if (str3 != null) {
            this.f14483d.setLabel(str3);
        } else {
            this.f14483d.setLabel(this.f14480a.getContext().getString(R.string.pickerview_day));
        }
        if (str4 != null) {
            this.f14484e.setLabel(str4);
        } else {
            this.f14484e.setLabel(this.f14480a.getContext().getString(R.string.pickerview_hours));
        }
        if (str5 != null) {
            this.f14485f.setLabel(str5);
        } else {
            this.f14485f.setLabel(this.f14480a.getContext().getString(R.string.pickerview_minutes));
        }
        if (str6 != null) {
            this.f14486g.setLabel(str6);
        } else {
            this.f14486g.setLabel(this.f14480a.getContext().getString(R.string.pickerview_seconds));
        }
    }

    public void x(float f6) {
        this.f14500u = f6;
        w();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x032e, code lost:
    
        if (r12 != 6) goto L121;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(int r12, int r13, int r14, int r15, int r16, int r17) {
        /*
            Method dump skipped, instructions count: 894
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bigkoo.pickerview.view.c.z(int, int, int, int, int, int):void");
    }

    public c(View view, TimePickerView.Type type, int i6, int i7) {
        this.f14489j = 1900;
        this.f14490k = 2100;
        this.f14491l = 1;
        this.f14492m = 12;
        this.f14493n = 1;
        this.f14494o = 31;
        this.f14500u = 1.6f;
        this.f14480a = view;
        this.f14488i = type;
        this.f14487h = i6;
        this.f14496q = i7;
        H(view);
    }
}
