package com.huawei.hms.hmsscankit;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.huawei.hms.scankit.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class a implements DialogInterface {

    /* renamed from: a, reason: collision with root package name */
    private final Context f33708a;

    /* renamed from: b, reason: collision with root package name */
    private final CharSequence f33709b;

    /* renamed from: c, reason: collision with root package name */
    private final CharSequence f33710c;

    /* renamed from: d, reason: collision with root package name */
    private final String f33711d;

    /* renamed from: e, reason: collision with root package name */
    private final String f33712e;

    /* renamed from: f, reason: collision with root package name */
    private final int f33713f;

    /* renamed from: g, reason: collision with root package name */
    private final int f33714g;

    /* renamed from: h, reason: collision with root package name */
    private final int f33715h;

    /* renamed from: i, reason: collision with root package name */
    private final int f33716i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f33717j;

    /* renamed from: k, reason: collision with root package name */
    private final int f33718k;

    /* renamed from: l, reason: collision with root package name */
    private final DialogInterface.OnClickListener f33719l;

    /* renamed from: m, reason: collision with root package name */
    private final DialogInterface.OnClickListener f33720m;

    /* renamed from: n, reason: collision with root package name */
    private AlertDialog f33721n;

    /* renamed from: o, reason: collision with root package name */
    TextView f33722o;

    /* renamed from: p, reason: collision with root package name */
    TextView f33723p;

    /* renamed from: q, reason: collision with root package name */
    TextView f33724q;

    /* renamed from: r, reason: collision with root package name */
    TextView f33725r;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.huawei.hms.hmsscankit.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0545a implements View.OnClickListener {
        ViewOnClickListenerC0545a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f33720m != null) {
                a.this.f33720m.onClick(a.this, -2);
            }
            a.this.dismiss();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f33719l != null) {
                a.this.f33719l.onClick(a.this, -1);
            }
            a.this.dismiss();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final Context f33728a;

        /* renamed from: b, reason: collision with root package name */
        private CharSequence f33729b;

        /* renamed from: c, reason: collision with root package name */
        private CharSequence f33730c;

        /* renamed from: d, reason: collision with root package name */
        private String f33731d;

        /* renamed from: e, reason: collision with root package name */
        private String f33732e;

        /* renamed from: f, reason: collision with root package name */
        private int f33733f;

        /* renamed from: g, reason: collision with root package name */
        private int f33734g;

        /* renamed from: h, reason: collision with root package name */
        private int f33735h;

        /* renamed from: i, reason: collision with root package name */
        private int f33736i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f33737j = true;

        /* renamed from: k, reason: collision with root package name */
        private int f33738k = 80;

        /* renamed from: l, reason: collision with root package name */
        private DialogInterface.OnClickListener f33739l;

        /* renamed from: m, reason: collision with root package name */
        private DialogInterface.OnClickListener f33740m;

        public c a(CharSequence charSequence) {
            this.f33730c = charSequence;
            return this;
        }

        public c b(CharSequence charSequence) {
            this.f33729b = charSequence;
            return this;
        }

        public c(Context context) {
            this.f33728a = context;
        }

        public c a(String str, DialogInterface.OnClickListener onClickListener) {
            this.f33731d = str;
            this.f33740m = onClickListener;
            return this;
        }

        public c b(String str, DialogInterface.OnClickListener onClickListener) {
            this.f33732e = str;
            this.f33739l = onClickListener;
            return this;
        }

        public a a() {
            return new a(this, null);
        }
    }

    /* synthetic */ a(c cVar, ViewOnClickListenerC0545a viewOnClickListenerC0545a) {
        this(cVar);
    }

    private a(c cVar) {
        this.f33708a = cVar.f33728a;
        this.f33709b = cVar.f33729b;
        this.f33710c = cVar.f33730c;
        this.f33711d = cVar.f33732e;
        this.f33712e = cVar.f33731d;
        this.f33713f = cVar.f33733f;
        this.f33714g = cVar.f33734g;
        this.f33715h = cVar.f33736i;
        this.f33716i = cVar.f33735h;
        this.f33717j = cVar.f33737j;
        this.f33718k = cVar.f33738k;
        this.f33719l = cVar.f33739l;
        this.f33720m = cVar.f33740m;
        a();
    }

    @SuppressLint({"SetTextI18n"})
    private void a() {
        if (this.f33708a != null) {
            this.f33721n = new AlertDialog.Builder(this.f33708a, R.style.BottomFullDialogStyle).create();
            View inflate = LayoutInflater.from(this.f33708a).inflate(R.layout.scankit_dialog_custom, (ViewGroup) null);
            Window window = this.f33721n.getWindow();
            if (window != null) {
                window.setGravity(this.f33718k);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.y = 16;
                window.setAttributes(attributes);
            }
            this.f33722o = (TextView) inflate.findViewById(R.id.dialog_title);
            this.f33723p = (TextView) inflate.findViewById(R.id.dialog_message);
            this.f33724q = (TextView) inflate.findViewById(R.id.dialog_negative);
            this.f33725r = (TextView) inflate.findViewById(R.id.dialog_positive);
            this.f33721n.setView(inflate);
            CharSequence charSequence = this.f33709b;
            if (charSequence != null) {
                this.f33722o.setText(charSequence);
            }
            this.f33721n.setCanceledOnTouchOutside(false);
            this.f33722o.setMovementMethod(LinkMovementMethod.getInstance());
            this.f33723p.setMovementMethod(LinkMovementMethod.getInstance());
            this.f33723p.setText(this.f33710c);
            b();
        }
    }

    private void b() {
        this.f33724q.setText(this.f33712e);
        int i6 = this.f33716i;
        if (i6 != 0) {
            this.f33724q.setTextColor(i6);
        }
        this.f33724q.setOnClickListener(new ViewOnClickListenerC0545a());
        if (TextUtils.isEmpty(this.f33712e)) {
            this.f33724q.setVisibility(8);
        } else {
            this.f33724q.setVisibility(0);
        }
        this.f33725r.setText(this.f33711d);
        int i7 = this.f33715h;
        if (i7 != 0) {
            this.f33725r.setTextColor(i7);
        }
        this.f33725r.setOnClickListener(new b());
        if (TextUtils.isEmpty(this.f33711d)) {
            this.f33725r.setVisibility(8);
        } else {
            this.f33725r.setVisibility(0);
        }
        this.f33721n.setCancelable(this.f33717j);
    }

    public void c() {
        AlertDialog alertDialog = this.f33721n;
        if (alertDialog != null) {
            alertDialog.show();
        }
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        AlertDialog alertDialog = this.f33721n;
        if (alertDialog != null) {
            alertDialog.cancel();
        }
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        AlertDialog alertDialog = this.f33721n;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.f33721n.dismiss();
    }
}
