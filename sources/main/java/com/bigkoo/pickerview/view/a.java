package com.bigkoo.pickerview.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.bigkoo.pickerview.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private Context f14430b;

    /* renamed from: c, reason: collision with root package name */
    protected ViewGroup f14431c;

    /* renamed from: d, reason: collision with root package name */
    private ViewGroup f14432d;

    /* renamed from: e, reason: collision with root package name */
    private ViewGroup f14433e;

    /* renamed from: f, reason: collision with root package name */
    private ViewGroup f14434f;

    /* renamed from: l, reason: collision with root package name */
    private p.b f14440l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f14441m;

    /* renamed from: n, reason: collision with root package name */
    private Animation f14442n;

    /* renamed from: o, reason: collision with root package name */
    private Animation f14443o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f14444p;

    /* renamed from: r, reason: collision with root package name */
    private Dialog f14446r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f14447s;

    /* renamed from: t, reason: collision with root package name */
    protected View f14448t;

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout.LayoutParams f14429a = new FrameLayout.LayoutParams(-1, -2, 80);

    /* renamed from: g, reason: collision with root package name */
    protected int f14435g = -16417281;

    /* renamed from: h, reason: collision with root package name */
    protected int f14436h = -4007179;

    /* renamed from: i, reason: collision with root package name */
    protected int f14437i = -657931;

    /* renamed from: j, reason: collision with root package name */
    protected int f14438j = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: k, reason: collision with root package name */
    protected int f14439k = -1;

    /* renamed from: q, reason: collision with root package name */
    private int f14445q = 80;

    /* renamed from: u, reason: collision with root package name */
    private View.OnKeyListener f14449u = new c();

    /* renamed from: v, reason: collision with root package name */
    private final View.OnTouchListener f14450v = new d();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bigkoo.pickerview.view.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0143a implements View.OnClickListener {
        ViewOnClickListenerC0143a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.d();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Animation.AnimationListener {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bigkoo.pickerview.view.a$b$a, reason: collision with other inner class name */
        class RunnableC0144a implements Runnable {
            RunnableC0144a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f();
            }
        }

        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.f14432d.post(new RunnableC0144a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements View.OnKeyListener {
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i6, KeyEvent keyEvent) {
            if (i6 != 4 || keyEvent.getAction() != 0 || !a.this.n()) {
                return false;
            }
            a.this.d();
            return true;
        }

        c() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.d();
                return false;
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements DialogInterface.OnDismissListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (a.this.f14440l != null) {
                a.this.f14440l.a(a.this);
            }
        }
    }

    public boolean m() {
        return false;
    }

    private void o(View view) {
        this.f14432d.addView(view);
        this.f14431c.startAnimation(this.f14443o);
    }

    public void c() {
        if (this.f14434f != null) {
            Dialog dialog = new Dialog(this.f14430b, R.style.custom_dialog2);
            this.f14446r = dialog;
            dialog.setCancelable(this.f14447s);
            this.f14446r.setContentView(this.f14434f);
            this.f14446r.setOnDismissListener(new e());
        }
    }

    public void e() {
        Dialog dialog = this.f14446r;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void f() {
        this.f14432d.removeView(this.f14433e);
        this.f14444p = false;
        this.f14441m = false;
        p.b bVar = this.f14440l;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public View g(int i6) {
        return this.f14431c.findViewById(i6);
    }

    public Animation h() {
        return AnimationUtils.loadAnimation(this.f14430b, r.a.a(this.f14445q, true));
    }

    public Animation i() {
        return AnimationUtils.loadAnimation(this.f14430b, r.a.a(this.f14445q, false));
    }

    protected void l() {
        LayoutInflater from = LayoutInflater.from(this.f14430b);
        if (m()) {
            ViewGroup viewGroup = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.f14434f = viewGroup;
            viewGroup.setBackgroundColor(0);
            ViewGroup viewGroup2 = (ViewGroup) this.f14434f.findViewById(R.id.content_container);
            this.f14431c = viewGroup2;
            FrameLayout.LayoutParams layoutParams = this.f14429a;
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            viewGroup2.setLayoutParams(layoutParams);
            c();
            this.f14434f.setOnClickListener(new ViewOnClickListenerC0143a());
        } else {
            ViewGroup viewGroup3 = (ViewGroup) ((Activity) this.f14430b).getWindow().getDecorView().findViewById(android.R.id.content);
            this.f14432d = viewGroup3;
            ViewGroup viewGroup4 = (ViewGroup) from.inflate(R.layout.layout_basepickerview, viewGroup3, false);
            this.f14433e = viewGroup4;
            viewGroup4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            ViewGroup viewGroup5 = (ViewGroup) this.f14433e.findViewById(R.id.content_container);
            this.f14431c = viewGroup5;
            viewGroup5.setLayoutParams(this.f14429a);
        }
        q(true);
    }

    public void p(boolean z5) {
        this.f14447s = z5;
    }

    public a r(p.b bVar) {
        this.f14440l = bVar;
        return this;
    }

    protected a s(boolean z5) {
        ViewGroup viewGroup = this.f14433e;
        if (viewGroup != null) {
            View findViewById = viewGroup.findViewById(R.id.outmost_container);
            if (z5) {
                findViewById.setOnTouchListener(this.f14450v);
                return this;
            }
            findViewById.setOnTouchListener(null);
        }
        return this;
    }

    public void u(View view) {
        this.f14448t = view;
        t();
    }

    public void v() {
        Dialog dialog = this.f14446r;
        if (dialog != null) {
            dialog.show();
        }
    }

    public a(Context context) {
        this.f14430b = context;
    }

    public void d() {
        if (m()) {
            e();
        } else {
            if (this.f14441m) {
                return;
            }
            this.f14441m = true;
            this.f14442n.setAnimationListener(new b());
            this.f14431c.startAnimation(this.f14442n);
        }
    }

    protected void j() {
        this.f14443o = h();
        this.f14442n = i();
    }

    public boolean n() {
        if (m()) {
            return false;
        }
        if (this.f14433e.getParent() == null && !this.f14444p) {
            return false;
        }
        return true;
    }

    public a q(boolean z5) {
        ViewGroup viewGroup;
        if (m()) {
            viewGroup = this.f14434f;
        } else {
            viewGroup = this.f14433e;
        }
        viewGroup.setFocusable(z5);
        viewGroup.setFocusableInTouchMode(z5);
        if (z5) {
            viewGroup.setOnKeyListener(this.f14449u);
            return this;
        }
        viewGroup.setOnKeyListener(null);
        return this;
    }

    public void t() {
        if (m()) {
            v();
        } else {
            if (n()) {
                return;
            }
            this.f14444p = true;
            o(this.f14433e);
            this.f14433e.requestFocus();
        }
    }

    protected void k() {
    }
}
