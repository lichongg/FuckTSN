package com.bigkoo.pickerview;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bigkoo.pickerview.lib.WheelView;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b<T> extends com.bigkoo.pickerview.view.a implements View.OnClickListener {
    private static final String G0 = "submit";
    private static final String H0 = "cancel";
    private Button A;
    private TextView B;
    private InterfaceC0142b C;
    private String D;
    private String E;
    private String F;
    private WheelView.DividerType F0;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private float R;
    private boolean S;
    private boolean T;
    private boolean U;
    private String V;
    private String W;
    private String X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f14355a0;

    /* renamed from: b0, reason: collision with root package name */
    private Typeface f14356b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f14357c0;

    /* renamed from: k0, reason: collision with root package name */
    private int f14358k0;

    /* renamed from: p0, reason: collision with root package name */
    private int f14359p0;

    /* renamed from: w, reason: collision with root package name */
    com.bigkoo.pickerview.view.b<T> f14360w;

    /* renamed from: x, reason: collision with root package name */
    private int f14361x;

    /* renamed from: y, reason: collision with root package name */
    private p.a f14362y;

    /* renamed from: z, reason: collision with root package name */
    private Button f14363z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        private Typeface C;
        private int D;
        private int E;
        private int F;
        private WheelView.DividerType G;

        /* renamed from: b, reason: collision with root package name */
        private p.a f14365b;

        /* renamed from: c, reason: collision with root package name */
        private Context f14366c;

        /* renamed from: d, reason: collision with root package name */
        private InterfaceC0142b f14367d;

        /* renamed from: e, reason: collision with root package name */
        private String f14368e;

        /* renamed from: f, reason: collision with root package name */
        private String f14369f;

        /* renamed from: g, reason: collision with root package name */
        private String f14370g;

        /* renamed from: h, reason: collision with root package name */
        private int f14371h;

        /* renamed from: i, reason: collision with root package name */
        private int f14372i;

        /* renamed from: j, reason: collision with root package name */
        private int f14373j;

        /* renamed from: k, reason: collision with root package name */
        private int f14374k;

        /* renamed from: l, reason: collision with root package name */
        private int f14375l;

        /* renamed from: r, reason: collision with root package name */
        private int f14381r;

        /* renamed from: s, reason: collision with root package name */
        private int f14382s;

        /* renamed from: t, reason: collision with root package name */
        private int f14383t;

        /* renamed from: v, reason: collision with root package name */
        private boolean f14385v;

        /* renamed from: w, reason: collision with root package name */
        private String f14386w;

        /* renamed from: x, reason: collision with root package name */
        private String f14387x;

        /* renamed from: y, reason: collision with root package name */
        private String f14388y;

        /* renamed from: a, reason: collision with root package name */
        private int f14364a = R.layout.pickerview_options;

        /* renamed from: m, reason: collision with root package name */
        private int f14376m = 17;

        /* renamed from: n, reason: collision with root package name */
        private int f14377n = 18;

        /* renamed from: o, reason: collision with root package name */
        private int f14378o = 18;

        /* renamed from: p, reason: collision with root package name */
        private boolean f14379p = true;

        /* renamed from: q, reason: collision with root package name */
        private boolean f14380q = true;

        /* renamed from: u, reason: collision with root package name */
        private float f14384u = 1.6f;

        /* renamed from: z, reason: collision with root package name */
        private boolean f14389z = false;
        private boolean A = false;
        private boolean B = false;

        public b H() {
            return new b(this);
        }

        public a I(boolean z5) {
            this.f14385v = z5;
            return this;
        }

        public a J(int i6) {
            this.f14374k = i6;
            return this;
        }

        public a K(int i6) {
            this.f14372i = i6;
            return this;
        }

        public a L(String str) {
            this.f14369f = str;
            return this;
        }

        public a M(int i6) {
            this.f14378o = i6;
            return this;
        }

        public a N(boolean z5, boolean z6, boolean z7) {
            this.f14389z = z5;
            this.A = z6;
            this.B = z7;
            return this;
        }

        public a O(int i6) {
            this.f14383t = i6;
            return this;
        }

        public a P(WheelView.DividerType dividerType) {
            this.G = dividerType;
            return this;
        }

        public a Q(String str, String str2, String str3) {
            this.f14386w = str;
            this.f14387x = str2;
            this.f14388y = str3;
            return this;
        }

        public a R(int i6, p.a aVar) {
            this.f14364a = i6;
            this.f14365b = aVar;
            return this;
        }

        public a S(float f6) {
            this.f14384u = f6;
            return this;
        }

        @Deprecated
        public a T(boolean z5) {
            this.f14380q = z5;
            return this;
        }

        public a U(boolean z5) {
            this.f14379p = z5;
            return this;
        }

        public a V(int i6) {
            this.D = i6;
            return this;
        }

        public a W(int i6, int i7) {
            this.D = i6;
            this.E = i7;
            return this;
        }

        public a X(int i6, int i7, int i8) {
            this.D = i6;
            this.E = i7;
            this.F = i8;
            return this;
        }

        public a Y(int i6) {
            this.f14376m = i6;
            return this;
        }

        public a Z(int i6) {
            this.f14371h = i6;
            return this;
        }

        public a a0(String str) {
            this.f14368e = str;
            return this;
        }

        public a b0(int i6) {
            this.f14382s = i6;
            return this;
        }

        public a c0(int i6) {
            this.f14381r = i6;
            return this;
        }

        public a d0(int i6) {
            this.f14375l = i6;
            return this;
        }

        public a e0(int i6) {
            this.f14373j = i6;
            return this;
        }

        public a f0(int i6) {
            this.f14377n = i6;
            return this;
        }

        public a g0(String str) {
            this.f14370g = str;
            return this;
        }

        public a h0(Typeface typeface) {
            this.C = typeface;
            return this;
        }

        public a(Context context, InterfaceC0142b interfaceC0142b) {
            this.f14366c = context;
            this.f14367d = interfaceC0142b;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bigkoo.pickerview.b$b, reason: collision with other inner class name */
    public interface InterfaceC0142b {
        void a(int i6, int i7, int i8, View view);
    }

    private void w() {
        com.bigkoo.pickerview.view.b<T> bVar = this.f14360w;
        if (bVar != null) {
            bVar.j(this.f14357c0, this.f14358k0, this.f14359p0);
        }
    }

    private void x(Context context) {
        p(this.T);
        l();
        j();
        k();
        p.a aVar = this.f14362y;
        if (aVar == null) {
            LayoutInflater.from(context).inflate(this.f14361x, this.f14431c);
            this.B = (TextView) g(R.id.tvTitle);
            this.f14363z = (Button) g(R.id.btnSubmit);
            this.A = (Button) g(R.id.btnCancel);
            this.f14363z.setTag(G0);
            this.A.setTag("cancel");
            this.f14363z.setOnClickListener(this);
            this.A.setOnClickListener(this);
            this.f14363z.setText(TextUtils.isEmpty(this.D) ? context.getResources().getString(R.string.pickerview_submit) : this.D);
            this.A.setText(TextUtils.isEmpty(this.E) ? context.getResources().getString(R.string.pickerview_cancel) : this.E);
            this.B.setText(TextUtils.isEmpty(this.F) ? "" : this.F);
            Button button = this.f14363z;
            int i6 = this.G;
            if (i6 == 0) {
                i6 = this.f14435g;
            }
            button.setTextColor(i6);
            Button button2 = this.A;
            int i7 = this.H;
            if (i7 == 0) {
                i7 = this.f14435g;
            }
            button2.setTextColor(i7);
            TextView textView = this.B;
            int i8 = this.I;
            if (i8 == 0) {
                i8 = this.f14438j;
            }
            textView.setTextColor(i8);
            RelativeLayout relativeLayout = (RelativeLayout) g(R.id.rv_topbar);
            int i9 = this.K;
            if (i9 == 0) {
                i9 = this.f14437i;
            }
            relativeLayout.setBackgroundColor(i9);
            this.f14363z.setTextSize(this.L);
            this.A.setTextSize(this.L);
            this.B.setTextSize(this.M);
            this.B.setText(this.F);
        } else {
            aVar.a(LayoutInflater.from(context).inflate(this.f14361x, this.f14431c));
        }
        LinearLayout linearLayout = (LinearLayout) g(R.id.optionspicker);
        int i10 = this.J;
        if (i10 == 0) {
            i10 = this.f14439k;
        }
        linearLayout.setBackgroundColor(i10);
        com.bigkoo.pickerview.view.b<T> bVar = new com.bigkoo.pickerview.view.b<>(linearLayout, Boolean.valueOf(this.U));
        this.f14360w = bVar;
        bVar.z(this.N);
        this.f14360w.q(this.V, this.W, this.X);
        this.f14360w.l(this.Y, this.Z, this.f14355a0);
        this.f14360w.A(this.f14356b0);
        s(this.T);
        TextView textView2 = this.B;
        if (textView2 != null) {
            textView2.setText(this.F);
        }
        this.f14360w.n(this.Q);
        this.f14360w.p(this.F0);
        this.f14360w.s(this.R);
        this.f14360w.y(this.O);
        this.f14360w.w(this.P);
    }

    public void A(List<T> list) {
        this.f14360w.u(list, null, null);
        w();
    }

    public void B(List<T> list, List<List<T>> list2) {
        this.f14360w.u(list, list2, null);
        w();
    }

    public void C(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        this.f14360w.u(list, list2, list3);
        w();
    }

    public void D(int i6) {
        this.f14357c0 = i6;
        w();
    }

    public void E(int i6, int i7) {
        this.f14357c0 = i6;
        this.f14358k0 = i7;
        w();
    }

    public void F(int i6, int i7, int i8) {
        this.f14357c0 = i6;
        this.f14358k0 = i7;
        this.f14359p0 = i8;
        w();
    }

    @Override // com.bigkoo.pickerview.view.a
    public boolean m() {
        return this.S;
    }

    public void y() {
        if (this.C != null) {
            int[] g6 = this.f14360w.g();
            this.C.a(g6[0], g6[1], g6[2], this.f14448t);
        }
        d();
    }

    public void z(List<T> list, List<T> list2, List<T> list3) {
        this.f14360w.t(list, list2, list3);
        w();
    }

    public b(a aVar) {
        super(aVar.f14366c);
        this.R = 1.6f;
        this.C = aVar.f14367d;
        this.D = aVar.f14368e;
        this.E = aVar.f14369f;
        this.F = aVar.f14370g;
        this.G = aVar.f14371h;
        this.H = aVar.f14372i;
        this.I = aVar.f14373j;
        this.J = aVar.f14374k;
        this.K = aVar.f14375l;
        this.L = aVar.f14376m;
        this.M = aVar.f14377n;
        this.N = aVar.f14378o;
        this.Y = aVar.f14389z;
        this.Z = aVar.A;
        this.f14355a0 = aVar.B;
        this.T = aVar.f14379p;
        this.U = aVar.f14380q;
        this.V = aVar.f14386w;
        this.W = aVar.f14387x;
        this.X = aVar.f14388y;
        this.f14356b0 = aVar.C;
        this.f14357c0 = aVar.D;
        this.f14358k0 = aVar.E;
        this.f14359p0 = aVar.F;
        this.P = aVar.f14382s;
        this.O = aVar.f14381r;
        this.Q = aVar.f14383t;
        this.R = aVar.f14384u;
        this.f14362y = aVar.f14365b;
        this.f14361x = aVar.f14364a;
        this.S = aVar.f14385v;
        this.F0 = aVar.G;
        x(aVar.f14366c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("cancel")) {
            d();
        } else {
            y();
        }
    }
}
