package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.gromore.R;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.addownload.compliance.r;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.downloadlib.addownload.o;
import com.ss.android.downloadlib.guide.install.ClipImageView;

/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private TextView f37646a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f37647b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f37648c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f37649d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f37650e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f37651f;

    /* renamed from: g, reason: collision with root package name */
    private ClipImageView f37652g;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f37653h;

    /* renamed from: i, reason: collision with root package name */
    private Activity f37654i;

    /* renamed from: j, reason: collision with root package name */
    private final long f37655j;

    /* renamed from: k, reason: collision with root package name */
    private long f37656k;

    /* renamed from: l, reason: collision with root package name */
    private final o.j f37657l;

    class a implements DialogInterface.OnCancelListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            com.ss.android.downloadlib.addownload.compliance.a.c("lp_app_dialog_cancel", b.this.f37656k);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.b$b, reason: collision with other inner class name */
    class C0743b implements r.c {
        C0743b() {
        }

        @Override // com.ss.android.downloadlib.addownload.compliance.r.c
        public void j(Bitmap bitmap) {
            if (bitmap != null) {
                b.this.f37652g.setImageBitmap(bitmap);
            } else {
                com.ss.android.downloadlib.addownload.compliance.a.a(8, b.this.f37656k);
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.ss.android.downloadlib.addownload.compliance.f.a().c(b.this.f37654i);
            AppDetailInfoActivity.b(b.this.f37654i, b.this.f37655j);
            com.ss.android.downloadlib.addownload.compliance.a.c("lp_app_dialog_click_detail", b.this.f37656k);
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.ss.android.downloadlib.addownload.compliance.f.a().c(b.this.f37654i);
            AppPrivacyPolicyActivity.b(b.this.f37654i, b.this.f37655j);
            com.ss.android.downloadlib.addownload.compliance.a.c("lp_app_dialog_click_privacy", b.this.f37656k);
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            com.ss.android.downloadlib.addownload.compliance.a.c("lp_app_dialog_click_giveup", b.this.f37656k);
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.ss.android.downloadlib.addownload.compliance.a.c("lp_app_dialog_click_download", b.this.f37656k);
            com.ss.android.downloadlib.addownload.compliance.f.a().i(b.this.f37656k);
            b.this.dismiss();
        }
    }

    private void c() {
        this.f37646a = (TextView) findViewById(R.id.tv_app_name);
        this.f37647b = (TextView) findViewById(R.id.tv_app_version);
        this.f37648c = (TextView) findViewById(R.id.tv_app_developer);
        this.f37649d = (TextView) findViewById(R.id.tv_app_detail);
        this.f37650e = (TextView) findViewById(R.id.tv_app_privacy);
        this.f37651f = (TextView) findViewById(R.id.tv_give_up);
        this.f37652g = (ClipImageView) findViewById(R.id.iv_app_icon);
        this.f37653h = (LinearLayout) findViewById(R.id.ll_download);
        this.f37646a.setText(a.h.q(this.f37657l.f37969e, "--"));
        this.f37647b.setText("版本号：" + a.h.q(this.f37657l.f37970f, "--"));
        this.f37648c.setText("开发者：" + a.h.q(this.f37657l.f37971g, "应用信息正在完善中"));
        this.f37652g.setRoundRadius(a.h.f(m.getContext(), 8.0f));
        this.f37652g.setBackgroundColor(Color.parseColor("#EBEBEB"));
        r.j().j(this.f37655j, new C0743b());
        this.f37649d.setOnClickListener(new c());
        this.f37650e.setOnClickListener(new d());
        this.f37651f.setOnClickListener(new e());
        this.f37653h.setOnClickListener(new f());
    }

    public b(@NonNull Activity activity, long j6) {
        super(activity);
        this.f37654i = activity;
        this.f37655j = j6;
        this.f37657l = cw.j().get(Long.valueOf(j6));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.ss.android.socialbase.appdownloader.b.u(this.f37654i);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f37657l == null) {
            dismiss();
            return;
        }
        requestWindowFeature(1);
        setContentView(R.layout.ttdownloader_dialog_appinfo);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.drawable.ttdownloader_bg_transparent);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.f37656k = this.f37657l.f37966b;
        c();
        com.ss.android.downloadlib.addownload.compliance.a.f("lp_app_dialog_show", this.f37656k);
        setOnCancelListener(new a());
    }
}
