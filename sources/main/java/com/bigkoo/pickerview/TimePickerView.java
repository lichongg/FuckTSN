package com.bigkoo.pickerview;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bigkoo.pickerview.lib.WheelView;
import com.bigkoo.pickerview.view.c;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TimePickerView extends com.bigkoo.pickerview.view.a implements View.OnClickListener {
    private static final String J0 = "submit";
    private static final String K0 = "cancel";
    private Button A;
    private TextView B;
    private b C;
    private int D;
    private Type E;
    private String F;
    private String F0;
    private String G;
    private String G0;
    private String H;
    private String H0;
    private int I;
    private WheelView.DividerType I0;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private Calendar Q;
    private Calendar R;
    private Calendar S;
    private int T;
    private int U;
    private boolean V;
    private boolean W;
    private int X;
    private int Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private float f14314a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f14315b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f14316c0;

    /* renamed from: k0, reason: collision with root package name */
    private String f14317k0;

    /* renamed from: p0, reason: collision with root package name */
    private String f14318p0;

    /* renamed from: w, reason: collision with root package name */
    private int f14319w;

    /* renamed from: x, reason: collision with root package name */
    private p.a f14320x;

    /* renamed from: y, reason: collision with root package name */
    c f14321y;

    /* renamed from: z, reason: collision with root package name */
    private Button f14322z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Type {
        ALL,
        YEAR_MONTH_DAY,
        HOURS_MINS,
        MONTH_DAY_HOUR_MIN,
        YEAR_MONTH,
        YEAR_MONTH_DAY_HOUR_MIN
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        private int A;
        private WheelView.DividerType B;
        private boolean D;
        private String E;
        private String F;
        private String G;
        private String H;
        private String I;
        private String J;

        /* renamed from: b, reason: collision with root package name */
        private p.a f14324b;

        /* renamed from: c, reason: collision with root package name */
        private Context f14325c;

        /* renamed from: d, reason: collision with root package name */
        private b f14326d;

        /* renamed from: g, reason: collision with root package name */
        private String f14329g;

        /* renamed from: h, reason: collision with root package name */
        private String f14330h;

        /* renamed from: i, reason: collision with root package name */
        private String f14331i;

        /* renamed from: j, reason: collision with root package name */
        private int f14332j;

        /* renamed from: k, reason: collision with root package name */
        private int f14333k;

        /* renamed from: l, reason: collision with root package name */
        private int f14334l;

        /* renamed from: m, reason: collision with root package name */
        private int f14335m;

        /* renamed from: n, reason: collision with root package name */
        private int f14336n;

        /* renamed from: r, reason: collision with root package name */
        private Calendar f14340r;

        /* renamed from: s, reason: collision with root package name */
        private Calendar f14341s;

        /* renamed from: t, reason: collision with root package name */
        private Calendar f14342t;

        /* renamed from: u, reason: collision with root package name */
        private int f14343u;

        /* renamed from: v, reason: collision with root package name */
        private int f14344v;

        /* renamed from: y, reason: collision with root package name */
        private int f14347y;

        /* renamed from: z, reason: collision with root package name */
        private int f14348z;

        /* renamed from: a, reason: collision with root package name */
        private int f14323a = R.layout.pickerview_time;

        /* renamed from: e, reason: collision with root package name */
        private Type f14327e = Type.ALL;

        /* renamed from: f, reason: collision with root package name */
        private int f14328f = 17;

        /* renamed from: o, reason: collision with root package name */
        private int f14337o = 17;

        /* renamed from: p, reason: collision with root package name */
        private int f14338p = 18;

        /* renamed from: q, reason: collision with root package name */
        private int f14339q = 18;

        /* renamed from: w, reason: collision with root package name */
        private boolean f14345w = false;

        /* renamed from: x, reason: collision with root package name */
        private boolean f14346x = true;
        private float C = 1.6f;

        public TimePickerView K() {
            return new TimePickerView(this);
        }

        public a L(int i6) {
            this.f14328f = i6;
            return this;
        }

        public a M(boolean z5) {
            this.f14345w = z5;
            return this;
        }

        public a N(boolean z5) {
            this.D = z5;
            return this;
        }

        public a O(int i6) {
            this.f14335m = i6;
            return this;
        }

        public a P(int i6) {
            this.f14333k = i6;
            return this;
        }

        public a Q(String str) {
            this.f14330h = str;
            return this;
        }

        public a R(int i6) {
            this.f14339q = i6;
            return this;
        }

        public a S(Calendar calendar) {
            this.f14340r = calendar;
            return this;
        }

        public a T(int i6) {
            this.A = i6;
            return this;
        }

        public a U(WheelView.DividerType dividerType) {
            this.B = dividerType;
            return this;
        }

        public a V(String str, String str2, String str3, String str4, String str5, String str6) {
            this.E = str;
            this.F = str2;
            this.G = str3;
            this.H = str4;
            this.I = str5;
            this.J = str6;
            return this;
        }

        public a W(int i6, p.a aVar) {
            this.f14323a = i6;
            this.f14324b = aVar;
            return this;
        }

        public a X(float f6) {
            this.C = f6;
            return this;
        }

        public a Y(boolean z5) {
            this.f14346x = z5;
            return this;
        }

        public a Z(Calendar calendar, Calendar calendar2) {
            this.f14341s = calendar;
            this.f14342t = calendar2;
            return this;
        }

        public a a0(int i6, int i7) {
            this.f14343u = i6;
            this.f14344v = i7;
            return this;
        }

        public a b0(int i6) {
            this.f14337o = i6;
            return this;
        }

        public a c0(int i6) {
            this.f14332j = i6;
            return this;
        }

        public a d0(String str) {
            this.f14329g = str;
            return this;
        }

        public a e0(int i6) {
            this.f14348z = i6;
            return this;
        }

        public a f0(int i6) {
            this.f14347y = i6;
            return this;
        }

        public a g0(int i6) {
            this.f14336n = i6;
            return this;
        }

        public a h0(int i6) {
            this.f14334l = i6;
            return this;
        }

        public a i0(int i6) {
            this.f14338p = i6;
            return this;
        }

        public a j0(String str) {
            this.f14331i = str;
            return this;
        }

        public a k0(Type type) {
            this.f14327e = type;
            return this;
        }

        public a(Context context, b bVar) {
            this.f14325c = context;
            this.f14326d = bVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a(Date date, View view);
    }

    private void A() {
        this.f14321y.C(this.T);
        this.f14321y.u(this.U);
    }

    private void w(Context context) {
        int i6;
        p(this.W);
        l();
        j();
        k();
        p.a aVar = this.f14320x;
        if (aVar == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.f14431c);
            this.B = (TextView) g(R.id.tvTitle);
            this.f14322z = (Button) g(R.id.btnSubmit);
            this.A = (Button) g(R.id.btnCancel);
            this.f14322z.setTag(J0);
            this.A.setTag("cancel");
            this.f14322z.setOnClickListener(this);
            this.A.setOnClickListener(this);
            this.f14322z.setText(TextUtils.isEmpty(this.F) ? context.getResources().getString(R.string.pickerview_submit) : this.F);
            this.A.setText(TextUtils.isEmpty(this.G) ? context.getResources().getString(R.string.pickerview_cancel) : this.G);
            this.B.setText(TextUtils.isEmpty(this.H) ? "" : this.H);
            Button button = this.f14322z;
            int i7 = this.I;
            if (i7 == 0) {
                i7 = this.f14435g;
            }
            button.setTextColor(i7);
            Button button2 = this.A;
            int i8 = this.J;
            if (i8 == 0) {
                i8 = this.f14435g;
            }
            button2.setTextColor(i8);
            TextView textView = this.B;
            int i9 = this.K;
            if (i9 == 0) {
                i9 = this.f14438j;
            }
            textView.setTextColor(i9);
            this.f14322z.setTextSize(this.N);
            this.A.setTextSize(this.N);
            this.B.setTextSize(this.O);
            RelativeLayout relativeLayout = (RelativeLayout) g(R.id.rv_topbar);
            int i10 = this.M;
            if (i10 == 0) {
                i10 = this.f14437i;
            }
            relativeLayout.setBackgroundColor(i10);
        } else {
            aVar.a(LayoutInflater.from(context).inflate(this.f14319w, this.f14431c));
        }
        LinearLayout linearLayout = (LinearLayout) g(R.id.timepicker);
        int i11 = this.L;
        if (i11 == 0) {
            i11 = this.f14439k;
        }
        linearLayout.setBackgroundColor(i11);
        this.f14321y = new c(linearLayout, this.E, this.D, this.P);
        int i12 = this.T;
        if (i12 != 0 && (i6 = this.U) != 0 && i12 <= i6) {
            A();
        }
        Calendar calendar = this.R;
        if (calendar == null || this.S == null) {
            if (calendar != null && this.S == null) {
                z();
            } else if (calendar == null && this.S != null) {
                z();
            }
        } else if (calendar.getTimeInMillis() <= this.S.getTimeInMillis()) {
            z();
        }
        B();
        this.f14321y.v(this.f14316c0, this.f14317k0, this.f14318p0, this.F0, this.G0, this.H0);
        s(this.W);
        this.f14321y.p(this.V);
        this.f14321y.r(this.Z);
        this.f14321y.t(this.I0);
        this.f14321y.x(this.f14314a0);
        this.f14321y.G(this.X);
        this.f14321y.E(this.Y);
    }

    private void z() {
        this.f14321y.A(this.R, this.S);
        Calendar calendar = this.R;
        if (calendar != null && this.S != null) {
            Calendar calendar2 = this.Q;
            if (calendar2 == null || calendar2.getTimeInMillis() < this.R.getTimeInMillis() || this.Q.getTimeInMillis() > this.S.getTimeInMillis()) {
                this.Q = this.R;
                return;
            }
            return;
        }
        if (calendar != null) {
            this.Q = calendar;
            return;
        }
        Calendar calendar3 = this.S;
        if (calendar3 != null) {
            this.Q = calendar3;
        }
    }

    @Override // com.bigkoo.pickerview.view.a
    public boolean m() {
        return this.f14315b0;
    }

    public void x() {
        if (this.C != null) {
            try {
                this.C.a(c.f14476w.parse(this.f14321y.m()), this.f14448t);
            } catch (ParseException e6) {
                e6.printStackTrace();
            }
        }
        d();
    }

    public void y(Calendar calendar) {
        this.Q = calendar;
        B();
    }

    public TimePickerView(a aVar) {
        super(aVar.f14325c);
        this.D = 17;
        this.f14314a0 = 1.6f;
        this.C = aVar.f14326d;
        this.D = aVar.f14328f;
        this.E = aVar.f14327e;
        this.F = aVar.f14329g;
        this.G = aVar.f14330h;
        this.H = aVar.f14331i;
        this.I = aVar.f14332j;
        this.J = aVar.f14333k;
        this.K = aVar.f14334l;
        this.L = aVar.f14335m;
        this.M = aVar.f14336n;
        this.N = aVar.f14337o;
        this.O = aVar.f14338p;
        this.P = aVar.f14339q;
        this.T = aVar.f14343u;
        this.U = aVar.f14344v;
        this.R = aVar.f14341s;
        this.S = aVar.f14342t;
        this.Q = aVar.f14340r;
        this.V = aVar.f14345w;
        this.W = aVar.f14346x;
        this.f14316c0 = aVar.E;
        this.f14317k0 = aVar.F;
        this.f14318p0 = aVar.G;
        this.F0 = aVar.H;
        this.G0 = aVar.I;
        this.H0 = aVar.J;
        this.Y = aVar.f14348z;
        this.X = aVar.f14347y;
        this.Z = aVar.A;
        this.f14320x = aVar.f14324b;
        this.f14319w = aVar.f14323a;
        this.f14314a0 = aVar.C;
        this.f14315b0 = aVar.D;
        this.I0 = aVar.B;
        w(aVar.f14325c);
    }

    private void B() {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = this.Q;
        if (calendar2 == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i6 = calendar.get(1);
            i7 = calendar.get(2);
            i8 = calendar.get(5);
            i9 = calendar.get(11);
            i10 = calendar.get(12);
            i11 = calendar.get(13);
        } else {
            i6 = calendar2.get(1);
            i7 = this.Q.get(2);
            i8 = this.Q.get(5);
            i9 = this.Q.get(11);
            i10 = this.Q.get(12);
            i11 = this.Q.get(13);
        }
        this.f14321y.z(i6, i7, i8, i9, i10, i11);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("cancel")) {
            d();
        } else {
            x();
        }
    }
}
