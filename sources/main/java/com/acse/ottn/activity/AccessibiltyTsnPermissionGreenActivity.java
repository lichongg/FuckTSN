package com.acse.ottn.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.acse.ottn.R;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.acse.ottn.b2;
import com.acse.ottn.b4;
import com.acse.ottn.c;
import com.acse.ottn.c2;
import com.acse.ottn.c3;
import com.acse.ottn.d0;
import com.acse.ottn.d1;
import com.acse.ottn.g0;
import com.acse.ottn.j3;
import com.acse.ottn.j4;
import com.acse.ottn.k0;
import com.acse.ottn.k2;
import com.acse.ottn.l2;
import com.acse.ottn.n1;
import com.acse.ottn.r0;
import com.acse.ottn.v4;
import com.acse.ottn.w0;
import com.acse.ottn.x4;
import com.acse.ottn.z;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AccessibiltyTsnPermissionGreenActivity extends z {
    public RelativeLayout A;
    public RelativeLayout B;
    public RelativeLayout C;
    public RelativeLayout D;
    public AutoScrollViewPager E;
    public TextView F;
    public RelativeLayout G;
    public d0.b H = new b();
    public long I = 0;
    public Handler J = new Handler();
    public Runnable K = new d();
    public Runnable L = new e();

    /* renamed from: e, reason: collision with root package name */
    public ImageView f4086e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f4087f;

    /* renamed from: g, reason: collision with root package name */
    public ImageView f4088g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f4089h;

    /* renamed from: i, reason: collision with root package name */
    public ImageView f4090i;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f4091j;

    /* renamed from: k, reason: collision with root package name */
    public ImageView f4092k;

    /* renamed from: l, reason: collision with root package name */
    public ImageView f4093l;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f4094m;

    /* renamed from: n, reason: collision with root package name */
    public TextView f4095n;

    /* renamed from: o, reason: collision with root package name */
    public AlertDialog f4096o;

    /* renamed from: p, reason: collision with root package name */
    public AppCompatCheckBox f4097p;

    /* renamed from: q, reason: collision with root package name */
    public TextView f4098q;

    /* renamed from: r, reason: collision with root package name */
    public TextView f4099r;

    /* renamed from: s, reason: collision with root package name */
    public TextView f4100s;

    /* renamed from: t, reason: collision with root package name */
    public TextView f4101t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f4102u;

    /* renamed from: v, reason: collision with root package name */
    public TextView f4103v;

    /* renamed from: w, reason: collision with root package name */
    public TextView f4104w;

    /* renamed from: x, reason: collision with root package name */
    public TextView f4105x;

    /* renamed from: y, reason: collision with root package name */
    public TextView f4106y;

    /* renamed from: z, reason: collision with root package name */
    public TextView f4107z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(AccessibiltyTsnPermissionGreenActivity.this, (Class<?>) SeedWebViewActivity.class);
            intent.putExtra("url", g0.a().b(AccessibiltyTsnPermissionGreenActivity.this));
            AccessibiltyTsnPermissionGreenActivity.this.startActivity(intent);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements d0.b<Integer> {
        public b() {
        }

        @Override // com.acse.ottn.d0.b
        @RequiresApi(api = 23)
        public void a(int i6, Integer num) {
            AccessibiltyTsnPermissionGreenActivity.this.m();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements w0.c {
        public c() {
        }

        @Override // com.acse.ottn.w0.c
        public void a() {
            l2.b().a("refuse_vivo_buttery_manage");
        }

        @Override // com.acse.ottn.w0.c
        public void b() {
            l2.b().a("allow_vivo_buttery_manage");
            v4.a((Activity) AccessibiltyTsnPermissionGreenActivity.this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        @RequiresApi(api = 23)
        public void run() {
            AccessibiltyTsnPermissionGreenActivity.this.m();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        @RequiresApi(api = 23)
        public void run() {
            AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity = AccessibiltyTsnPermissionGreenActivity.this;
            accessibiltyTsnPermissionGreenActivity.c(accessibiltyTsnPermissionGreenActivity.getResources().getString(R.string.dialog_vivo_battery_message));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class f implements w0.c {
        public f() {
        }

        @Override // com.acse.ottn.w0.c
        public void a() {
            l2.b().a("refuse_service_permission");
        }

        @Override // com.acse.ottn.w0.c
        public void b() {
            l2.b().a("allow_service_permission");
            if ("honor".equals(j4.b()) && Build.VERSION.SDK_INT >= 36) {
                j3.a().a("battery_white", Boolean.TRUE);
                j3.a().b("OpenPermissionName", "应用启动管理");
                n1.b(AccessibiltyTsnPermissionGreenActivity.this);
            } else {
                j3.a().b("OpenPermissionName", "应用启动管理");
                x4 a6 = x4.a();
                AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity = AccessibiltyTsnPermissionGreenActivity.this;
                a6.a(accessibiltyTsnPermissionGreenActivity, accessibiltyTsnPermissionGreenActivity.getPackageName());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class g implements w0.c {
        public g() {
        }

        @Override // com.acse.ottn.w0.c
        public void b() {
            l2.b().a("all_permission_open");
            AccessibiltyTsnPermissionGreenActivity.this.setResult(-1);
            AccessibiltyTsnPermissionGreenActivity.this.finish();
        }

        @Override // com.acse.ottn.w0.c
        public void a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class h implements c.d {
        public h() {
        }

        @Override // com.acse.ottn.c.d
        public void onDismiss() {
            l2.b().a("refuse_continue_open_permission");
            AccessibiltyTsnPermissionGreenActivity.this.finish();
        }

        @Override // com.acse.ottn.c.d
        public void onOpen() {
            l2.b().a("continue_open_permission");
            AccessibiltyTsnPermissionGreenActivity.this.m();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class i implements w0.c {
        public i() {
        }

        @Override // com.acse.ottn.w0.c
        public void a() {
            l2.b().a("cancle_flow_window_list");
        }

        @Override // com.acse.ottn.w0.c
        public void b() {
            d1.b().a((Activity) AccessibiltyTsnPermissionGreenActivity.this, 10011);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class j implements b4.h {
        public j() {
        }

        @Override // com.acse.ottn.b4.h
        public void onDismiss() {
            l2.b().a("refuse_service");
        }

        @Override // com.acse.ottn.b4.h
        public void onOpen() {
            j3.a().a("is_agree_service", Boolean.TRUE);
            l2.b().a("allow_service");
            AccessibiltyTsnPermissionGreenActivity.this.f4097p.setChecked(true);
            AccessibiltyTsnPermissionGreenActivity.this.m();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class k implements CompoundButton.OnCheckedChangeListener {
        public k() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
            if (z5) {
                AccessibiltyTsnPermissionGreenActivity.this.f4097p.setSupportButtonTintList(ColorStateList.valueOf(Color.parseColor(g0.a().e(AccessibiltyTsnPermissionGreenActivity.this))));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class l implements w0.c {
        public l() {
        }

        @Override // com.acse.ottn.w0.c
        public void a() {
            l2.b().a("refuse_minu_service_run");
        }

        @Override // com.acse.ottn.w0.c
        public void b() {
            l2.b().a("allow_minu_service_run");
            k2.c(AccessibiltyTsnPermissionGreenActivity.this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class m implements w0.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4120a;

        public m(String str) {
            this.f4120a = str;
        }

        @Override // com.acse.ottn.w0.c
        public void b() {
            if (j3.a().c("location_permission_size") == 0) {
                j3.a().a("location_permission_size", 1);
                if ("honor".equals(j4.b()) && Build.VERSION.SDK_INT >= 36) {
                    j3 a6 = j3.a();
                    Boolean bool = Boolean.TRUE;
                    a6.a("battery_white", bool);
                    j3.a().b("OpenPermissionName", "权限管理");
                    j3.a().a("location_permission", bool);
                    b2.a().d(AccessibiltyTsnPermissionGreenActivity.this);
                    return;
                }
                j3.a().a("battery_white", Boolean.TRUE);
                b2.a().f(AccessibiltyTsnPermissionGreenActivity.this);
                return;
            }
            if (this.f4120a.equals("1")) {
                j3.a().a("location_permission_size", 2);
                b2.a().c((Activity) AccessibiltyTsnPermissionGreenActivity.this);
            } else if (this.f4120a.equals("2")) {
                if ("samsung".equals(j4.b())) {
                    j3.a().a("battery_white_samsung", Boolean.TRUE);
                }
                j3.a().a("location_permission_size", 3);
                b2.a().b((Activity) AccessibiltyTsnPermissionGreenActivity.this);
            }
        }

        @Override // com.acse.ottn.w0.c
        public void a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class n implements w0.c {
        public n() {
        }

        @Override // com.acse.ottn.w0.c
        public void a() {
            l2.b().a("refuse_service_permission");
        }

        @Override // com.acse.ottn.w0.c
        public void b() {
            j3 a6 = j3.a();
            Boolean bool = Boolean.TRUE;
            a6.a("oppo_35_autostart", bool);
            j3.a().a("battery_white", bool);
            AccessibiltyTsnPermissionGreenActivity.this.startActivity(new Intent("android.settings.SETTINGS"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccessibiltyTsnPermissionGreenActivity.this.m();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccessibiltyTsnPermissionGreenActivity.this.m();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccessibiltyTsnPermissionGreenActivity.this.m();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccessibiltyTsnPermissionGreenActivity.this.m();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccessibiltyTsnPermissionGreenActivity.this.m();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class t implements View.OnClickListener {
        public t() {
        }

        @Override // android.view.View.OnClickListener
        @RequiresApi(api = 23)
        public void onClick(View view) {
            AccessibiltyTsnPermissionGreenActivity.this.m();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccessibiltyTsnPermissionGreenActivity.this.g();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class v implements View.OnClickListener {
        public v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(AccessibiltyTsnPermissionGreenActivity.this, (Class<?>) SeedWebViewActivity.class);
            intent.putExtra("url", g0.a().d(AccessibiltyTsnPermissionGreenActivity.this));
            AccessibiltyTsnPermissionGreenActivity.this.startActivity(intent);
        }
    }

    static {
        StubApp.interface11(9005);
    }

    public final void d(String str) {
        a(this, this.f4096o);
        this.f4096o = w0.a(this, "耗电管理:", getResources().getString(R.string.dialog_vivo_battery_message), "好的", false, new c());
    }

    @Override // com.acse.ottn.z, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @RequiresApi(api = 23)
    public native void onCreate(Bundle bundle);

    public final void b(String str) {
        com.acse.ottn.b.c().a(false);
        a(this, this.f4096o);
        this.f4096o = w0.a(this, getResources().getString(R.string.dialog_flow_title), getResources().getString(R.string.dialog_flow_message), "好的", false, new i());
    }

    @RequiresApi(api = 23)
    public final void c() {
        if (!com.acse.ottn.b.c().e()) {
            com.acse.ottn.a.c().a((Activity) this, 10010);
        } else if (com.acse.ottn.b.c().a()) {
            d();
        } else {
            b(k0.f4687w);
        }
        k();
    }

    public final void e() {
        a(this, this.f4096o);
        int c6 = j3.a().c("location_permission_size");
        if (!x4.a().b(getPackageName())) {
            a(getPackageName(), getResources().getString(R.string.dialog_keep_back_two_title));
            return;
        }
        if (j4.b().equals("vivo")) {
            if (!x4.a().b()) {
                d(getPackageName());
                return;
            }
            if (!b2.a().a((Context) this) && c6 <= 1) {
                a(getResources().getString(R.string.location_title), getResources().getString(R.string.location_content), "1");
                return;
            } else if (!b2.a().b((Context) this) && c6 <= 2) {
                a(getResources().getString(R.string.location_background_title), getResources().getString(R.string.location_background_content), "2");
                return;
            }
        } else {
            if (("oneplus".equals(j4.b()) || "oppo".equals(j4.b()) || "realme".equals(j4.b())) && Build.VERSION.SDK_INT >= 35 && !j3.a().a("oppo_35_autostart")) {
                this.J.postDelayed(this.L, 100L);
                return;
            }
            if (!b2.a().a((Context) this) && c6 <= 1) {
                a(getResources().getString(R.string.location_title), getResources().getString(R.string.location_content), "1");
                return;
            } else if (!b2.a().b((Context) this) && c6 <= 2) {
                a(getResources().getString(R.string.location_background_title), getResources().getString(R.string.location_background_content), "2");
                return;
            }
        }
        l();
    }

    public final void g() {
        a(this, this.f4096o);
        this.f4096o = com.acse.ottn.c.a(this, getResources().getString(R.string.permission_warning), new h());
    }

    @RequiresApi(api = 23)
    @SuppressLint({"RestrictedApi"})
    public final void h() {
        this.f4086e = (ImageView) findViewById(R.id.banner);
        this.f4101t = (TextView) findViewById(R.id.tv_first_line);
        this.f4102u = (TextView) findViewById(R.id.tv_secend_line);
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) findViewById(R.id.checkbox);
        this.f4097p = appCompatCheckBox;
        appCompatCheckBox.setSupportButtonTintList(ColorStateList.valueOf(Color.parseColor(g0.a().e(this))));
        this.f4097p.setOnCheckedChangeListener(new k());
        this.E = (AutoScrollViewPager) findViewById(R.id.banner1);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_accessiblity);
        this.A = relativeLayout;
        relativeLayout.setOnClickListener(new o());
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.rl_location);
        this.C = relativeLayout2;
        relativeLayout2.setOnClickListener(new p());
        this.f4086e.setOnClickListener(new q());
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(R.id.rl_flow_window);
        this.B = relativeLayout3;
        relativeLayout3.setOnClickListener(new r());
        RelativeLayout relativeLayout4 = (RelativeLayout) findViewById(R.id.rl_battery);
        this.D = relativeLayout4;
        relativeLayout4.setOnClickListener(new s());
        this.f4087f = (ImageView) findViewById(R.id.iv_accessiblity_two);
        this.f4088g = (ImageView) findViewById(R.id.iv_flow_window_two);
        this.f4089h = (ImageView) findViewById(R.id.iv_battery_two);
        this.f4090i = (ImageView) findViewById(R.id.iv_accessiblity);
        this.f4092k = (ImageView) findViewById(R.id.iv_location);
        this.f4093l = (ImageView) findViewById(R.id.iv_location_two);
        this.f4091j = (ImageView) findViewById(R.id.iv_flow_window);
        this.f4094m = (ImageView) findViewById(R.id.iv_battery);
        this.G = (RelativeLayout) findViewById(R.id.rl_service);
        this.f4107z = (TextView) findViewById(R.id.tv_location_describe);
        this.f4098q = (TextView) findViewById(R.id.tv_accessiblity_describe);
        this.f4099r = (TextView) findViewById(R.id.tv_flow_describe);
        this.f4095n = (TextView) findViewById(R.id.tv_content);
        this.F = (TextView) findViewById(R.id.tv_warning);
        g0.a().a(this, (LinearLayout) findViewById(R.id.linearLayout_1));
        TextView textView = (TextView) findViewById(R.id.step_one);
        TextView textView2 = (TextView) findViewById(R.id.step_two);
        TextView textView3 = (TextView) findViewById(R.id.step_three);
        TextView textView4 = (TextView) findViewById(R.id.step_four);
        g0.a().a(this, textView, this.f4098q);
        g0.a().a(this, textView2, this.f4099r);
        g0.a().a(this, textView3, this.f4095n);
        g0.a().a(this, textView4, this.f4107z);
        RelativeLayout relativeLayout5 = (RelativeLayout) findViewById(R.id.av_back);
        RelativeLayout relativeLayout6 = (RelativeLayout) findViewById(R.id.rl_context);
        g0.a().b(this, relativeLayout5);
        g0.a().b(this, relativeLayout6);
        k();
        this.f4086e.setImageResource(R.mipmap.banner_6);
        TextView textView5 = (TextView) findViewById(R.id.tv_open);
        this.f4100s = textView5;
        textView5.setOnClickListener(new t());
        this.f4106y = (TextView) findViewById(R.id.tv_my_think);
        g0.a().a(this, (TextView) null, this.f4106y);
        this.f4106y.setOnClickListener(new u());
        this.f4104w = (TextView) findViewById(R.id.tv_service);
        this.f4103v = (TextView) findViewById(R.id.tv_privacy);
        j();
    }

    public final void l() {
        this.f4096o = w0.a(this, null, getString(R.string.permission_all_open), "好的", false, new g());
    }

    public final void n() {
        a(this, this.f4096o);
        this.f4096o = b4.a(this, new j());
    }

    @Override // com.acse.ottn.z, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        a(this, this.f4096o);
        c2.a("AccessibiltyTsnPermissionGreenActivity", "onDestroy");
        super.onDestroy();
    }

    @Override // com.acse.ottn.z, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        a(this, this.f4096o);
        super.onPause();
    }

    @Override // com.acse.ottn.z, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        l2.b().a("open_accessiblity_page_pv");
        try {
            k();
            boolean a6 = com.acse.ottn.b.c().a();
            if (com.acse.ottn.b.c().e() && this.f4097p.isChecked()) {
                a(this, this.f4096o);
                this.J.postDelayed(this.K, 500L);
            }
            String a7 = r0.d().a();
            String e6 = j3.a().e("send_open_flow_window");
            if (!a6 || a7.equals(e6)) {
                return;
            }
            l2.b().a("open_flow_window");
            j3.a().b("send_open_flow_window", a7);
        } catch (Exception e7) {
            c2.a("samon", "Exception e =" + e7.getMessage());
        }
    }

    public final void a(String str, String str2) {
        String str3;
        if (Build.VERSION.SDK_INT >= 35) {
            str3 = "允许后台运行:";
        } else {
            str3 = "允许后台运行和自启动权限:";
        }
        String str4 = str3;
        a(this, this.f4096o);
        this.f4096o = w0.a(this, str4, str2, "好的", false, new f());
    }

    public final void d() {
        e();
    }

    public final void f() {
        if (System.currentTimeMillis() - this.I > 2000) {
            Toast.makeText(this, "再按返回键一次退出", 0).show();
            this.I = System.currentTimeMillis();
        } else {
            finish();
        }
    }

    public final boolean i() {
        boolean z5;
        if (!c3.a().d()) {
            return true;
        }
        if (com.acse.ottn.b.c().e() && com.acse.ottn.b.c().a() && x4.a().b(k0.f4687w)) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (("oneplus".equals(j4.b()) || "oppo".equals(j4.b()) || "realme".equals(j4.b())) && Build.VERSION.SDK_INT >= 35) {
            if (z5 && j3.a().a("oppo_35_autostart")) {
                return true;
            }
            return false;
        }
        return z5;
    }

    public final void j() {
        g0.a().d(this, this.f4101t);
        g0.a().d(this, this.f4104w);
        g0.a().d(this, this.f4103v);
        g0.a().b(this, this.f4100s);
        this.f4100s.setText(R.string.permission_commit);
        this.f4101t.setText(R.string.permission_title);
        this.f4102u.setText(R.string.permission_title_two);
        g0.a().a(this, this.f4102u, (TextView) null);
        this.f4098q.setText(R.string.permission_accessiblity);
        this.f4099r.setText(R.string.permission_flowwindow);
        this.f4095n.setText(R.string.permission_home_back);
        this.f4104w.setOnClickListener(new v());
        this.f4103v.setOnClickListener(new a());
        g0.a().a(this, this.f4090i, this.f4092k, this.f4091j, this.f4094m, this.E, this.f4086e);
    }

    public final void k() {
        g0.a().a(this, this.f4087f, this.f4093l, this.f4088g, this.f4089h, this.A, this.C, this.B, this.D, this.f4107z);
    }

    public final void m() {
        if (i()) {
            d();
            return;
        }
        if (!this.f4097p.isChecked()) {
            n();
            return;
        }
        if (!com.acse.ottn.b.c().e()) {
            com.acse.ottn.a.c().a((Activity) this, 10010);
            return;
        }
        if (!com.acse.ottn.b.c().a()) {
            b(k0.f4687w);
            return;
        }
        if (("xiaomi".equals(j4.b()) || "redmi".equals(j4.b())) && !j3.a().a("background_battery_hignt") && "2".equals(j3.a().e("flow_window_state"))) {
            a(k0.f4687w);
            return;
        }
        if (!x4.a().b(getPackageName())) {
            String string = getResources().getString(R.string.dialog_keep_back_two_title);
            if (j4.b().equals("vivo")) {
                string = getResources().getString(R.string.dialog_keep_back_message);
            }
            a(getPackageName(), string);
            return;
        }
        if (j4.b().equals("vivo")) {
            if (!x4.a().b()) {
                d(getPackageName());
                return;
            } else {
                d();
                return;
            }
        }
        if (("oneplus".equals(j4.b()) || "oppo".equals(j4.b()) || "realme".equals(j4.b())) && Build.VERSION.SDK_INT >= 35) {
            if (!j3.a().a("oppo_35_autostart")) {
                this.J.postDelayed(this.L, 100L);
                return;
            } else {
                d();
                return;
            }
        }
        d();
    }

    @Override // com.acse.ottn.z, androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void r1() {
        f();
    }

    public final void a(AppCompatActivity appCompatActivity, String str, int i6) {
        com.acse.ottn.a.c().a(appCompatActivity, i6);
    }

    public final void c(String str) {
        a(this, this.f4096o);
        this.f4096o = w0.a(this, "允许自启动权限:", str, "好的", false, new n());
    }

    @Override // com.acse.ottn.z
    public void a(int i6) {
        Window window = getWindow();
        a(this, i6, 0);
        window.addFlags(2048);
        window.clearFlags(1024);
        window.getDecorView().setSystemUiVisibility(PredefinedCaptureConfigurations.f35648o);
    }

    public final void a(String str) {
        String string = getResources().getString(R.string.dialog_keep_back_title);
        a(this, this.f4096o);
        this.f4096o = w0.a(this, string, getResources().getString(R.string.dialog_keep_back_message), "好的", false, new l());
    }

    public static void a(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        } catch (Exception unused) {
        }
    }

    public final void a(String str, String str2, String str3) {
        a(this, this.f4096o);
        this.f4096o = w0.a(this, str, str2, "好的", false, new m(str3));
    }
}
