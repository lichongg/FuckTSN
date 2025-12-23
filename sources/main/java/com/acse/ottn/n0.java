package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.app.Service;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.m0;
import com.acse.ottn.model.AccessiblityModel;
import java.io.ObjectStreamException;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class n0 {

    /* renamed from: j, reason: collision with root package name */
    public static n0 f4880j = null;

    /* renamed from: k, reason: collision with root package name */
    public static View f4881k = null;

    /* renamed from: l, reason: collision with root package name */
    public static WindowManager f4882l = null;

    /* renamed from: m, reason: collision with root package name */
    public static String f4883m = "CountdownService";

    /* renamed from: a, reason: collision with root package name */
    public WindowManager.LayoutParams f4884a;

    /* renamed from: b, reason: collision with root package name */
    public RelativeLayout f4885b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f4886c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f4887d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f4888e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f4889f;

    /* renamed from: g, reason: collision with root package name */
    public ImageView f4890g;

    /* renamed from: h, reason: collision with root package name */
    public TimerTask f4891h;

    /* renamed from: i, reason: collision with root package name */
    public TimerTask f4892i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service f4893a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f4894b;

        public a(Service service, AccessiblityModel accessiblityModel) {
            this.f4893a = service;
            this.f4894b = accessiblityModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            n0.this.b(this.f4893a);
            h4.c().b(this.f4893a, this.f4894b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service f4896a;

        public b(Service service) {
            this.f4896a = service;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            n0.this.b(this.f4896a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service f4898a;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            n0.this.f4887d.setText((j6 / 60000) + "");
            n0.this.f4888e.setText(((j6 % 60000) / 1000) + "");
        }

        public c(Service service) {
            this.f4898a = service;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            n0.this.b(this.f4898a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service f4900a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (k0.f4669e) {
                    return;
                }
                TimerTask timerTask = n0.this.f4891h;
                if (timerTask != null) {
                    timerTask.cancel();
                }
                d dVar = d.this;
                n0.this.b(dVar.f4900a);
            }
        }

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            new Handler(Looper.getMainLooper()).postDelayed(new a(), 0L);
        }

        public d(Service service) {
            this.f4900a = service;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            n0.this.b(this.f4900a);
        }
    }

    public static n0 a() {
        if (f4880j == null) {
            synchronized (n0.class) {
                try {
                    if (f4880j == null) {
                        f4880j = new n0();
                    }
                } finally {
                }
            }
        }
        return f4880j;
    }

    public final Object b() throws ObjectStreamException {
        return f4880j;
    }

    public void b(Service service, AccessiblityModel accessiblityModel) {
        a(service, R.layout.count_down_background);
        this.f4885b = (RelativeLayout) f4881k.findViewById(R.id.beijing);
        this.f4886c = (ImageView) f4881k.findViewById(R.id.iv_image);
        this.f4887d = (TextView) f4881k.findViewById(R.id.tv_hour);
        this.f4888e = (TextView) f4881k.findViewById(R.id.tv_minute);
        this.f4890g = (ImageView) f4881k.findViewById(R.id.iv_setting);
        this.f4889f = (TextView) f4881k.findViewById(R.id.tv_price);
        a(service, accessiblityModel);
        f4882l.addView(f4881k, this.f4884a);
    }

    public void a(Service service) {
        this.f4884a = new WindowManager.LayoutParams();
        if (d4.a().a(service)) {
            f4882l = (WindowManager) service.getApplication().getSystemService("window");
            if (Build.VERSION.SDK_INT >= 26) {
                this.f4884a.type = 2038;
            } else {
                this.f4884a.type = 2002;
            }
            this.f4884a.flags = 8;
        } else {
            f4882l = (WindowManager) service.getSystemService("window");
            WindowManager.LayoutParams layoutParams = this.f4884a;
            layoutParams.type = 2032;
            layoutParams.flags = 800;
        }
        WindowManager.LayoutParams layoutParams2 = this.f4884a;
        layoutParams2.format = 1;
        layoutParams2.windowAnimations = android.R.style.Animation.Translucent;
        layoutParams2.gravity = 85;
        layoutParams2.x = 30;
        layoutParams2.y = 700;
        layoutParams2.width = u0.a((Context) service, 93.0f);
        this.f4884a.height = u0.a((Context) service, 100.0f);
    }

    public void b(Service service) {
        try {
            View view = f4881k;
            if (view != null) {
                view.setVisibility(8);
            }
            TimerTask timerTask = this.f4891h;
            if (timerTask != null) {
                timerTask.cancel();
            }
            TimerTask timerTask2 = this.f4892i;
            if (timerTask2 != null) {
                timerTask2.cancel();
            }
            f4882l.removeView(f4881k);
            if (!d4.a().a(service)) {
                service = (AccessibilityService) service;
            }
            service.stopSelf();
        } catch (Throwable unused) {
        }
    }

    public final void a(Service service, AccessiblityModel accessiblityModel) {
        if (!accessiblityModel.getData().getPackage_name().equals(n.c().O) && !accessiblityModel.getData().getPackage_name().equals(n.c().R)) {
            if (!accessiblityModel.getData().getPackage_name().equals(n.c().f4861o) && !accessiblityModel.getData().getPackage_name().equals(n.c().f4862p)) {
                if (accessiblityModel.getData().getPackage_name().equals(n.c().D)) {
                    this.f4886c.setImageResource(R.mipmap.smallfloat_mtchaoshi);
                    this.f4889f.setTextColor(Color.parseColor("#FFFFFF"));
                    this.f4889f.setText(accessiblityModel.getData().getOriginal_price());
                } else if (accessiblityModel.getData().getPackage_name().equals(n.c().B)) {
                    this.f4886c.setImageResource(R.mipmap.smallfloat_mtjiudian);
                    this.f4889f.setTextColor(Color.parseColor("#FF0000"));
                    this.f4889f.setText(accessiblityModel.getData().getOriginal_price());
                } else if (accessiblityModel.getData().getPackage_name().equals(n.c().f4871y)) {
                    this.f4886c.setImageResource(R.mipmap.smallfloat_mtxianhua);
                    this.f4889f.setTextColor(Color.parseColor("#FFF344"));
                    this.f4889f.setText(accessiblityModel.getData().getOriginal_price());
                } else if (accessiblityModel.getData().getPackage_name().equals(n.c().A)) {
                    this.f4886c.setImageResource(R.mipmap.smallfloat_mtyiyao);
                    this.f4889f.setTextColor(Color.parseColor("#FC5702"));
                    this.f4889f.setText(accessiblityModel.getData().getOriginal_price());
                } else if (accessiblityModel.getData().getPackage_name().equals(n.c().G)) {
                    this.f4886c.setImageResource(R.mipmap.smallfloat_shangou);
                    this.f4889f.setTextColor(Color.parseColor("#EB2A23"));
                    this.f4889f.setText(accessiblityModel.getData().getOriginal_price());
                } else if (accessiblityModel.getData().getPackage_name().equals(n.c().P)) {
                    this.f4886c.setImageResource(R.mipmap.smallfloat_taobaoeleme);
                    this.f4889f.setTextColor(Color.parseColor("#EB2A23"));
                    this.f4889f.setText(accessiblityModel.getData().getOriginal_price());
                } else if (accessiblityModel.getData().getPackage_name().equals(n.c().f4848b0)) {
                    this.f4889f.setTextColor(Color.parseColor("#FF0057"));
                    this.f4886c.setImageResource(R.mipmap.smallfloat_vipshop);
                } else if (accessiblityModel.getData().getPackage_name().equals(n.c().F)) {
                    this.f4886c.setImageResource(R.mipmap.smallfloat_xianyu);
                    this.f4889f.setTextColor(Color.parseColor("#FF5031"));
                    this.f4889f.setText(accessiblityModel.getData().getOriginal_price());
                } else if (accessiblityModel.getData().getPackage_name().equals(n.c().f4846a0)) {
                    this.f4889f.setTextColor(Color.parseColor("#FFFFFF"));
                    this.f4886c.setImageResource(R.mipmap.smallfloat_yidong);
                    this.f4889f.setText(accessiblityModel.getData().getOriginal_price());
                } else if (accessiblityModel.getData().getPackage_name().equals(n.c().E)) {
                    this.f4889f.setTextColor(Color.parseColor("#FFFFFF"));
                    this.f4886c.setImageResource(R.mipmap.smallfloat_mtguoshu);
                    this.f4889f.setText(accessiblityModel.getData().getOriginal_price());
                } else if (!accessiblityModel.getData().getPackage_name().equals(n.c().J) && !accessiblityModel.getData().getPackage_name().equals(n.c().N) && !accessiblityModel.getData().getPackage_name().equals(n.c().f4858l)) {
                    if (accessiblityModel.getData().getPackage_name().equals(n.c().U)) {
                        com.bumptech.glide.b.D(service).a(accessiblityModel.getData().getSpop_pic()).m1(this.f4886c);
                    }
                } else {
                    this.f4889f.setTextColor(Color.parseColor("#FFFFFF"));
                    this.f4886c.setImageResource(R.mipmap.smallfloat_mt);
                    this.f4889f.setText(accessiblityModel.getData().getOriginal_price());
                }
            } else {
                this.f4886c.setImageResource(R.mipmap.smallfloat_kuaishou);
                this.f4889f.setTextColor(Color.parseColor("#FFFCC6"));
                this.f4889f.setText(accessiblityModel.getData().getOriginal_price());
            }
        } else {
            this.f4886c.setImageResource(R.mipmap.smallfloat_eleme);
            this.f4889f.setTextColor(Color.parseColor("#1A7BCF"));
            this.f4889f.setText(accessiblityModel.getData().getOriginal_price());
        }
        this.f4885b.setOnClickListener(new a(service, accessiblityModel));
        this.f4890g.setOnClickListener(new b(service));
        this.f4892i = m0.a().b(accessiblityModel.getData().getSmallfloat_hour() * 1000, 1000, new c(service));
        this.f4891h = m0.a().b(accessiblityModel.getData().getTime_four(), 500, new d(service));
    }

    public final void a(Service service, int i6) {
        try {
            View inflate = LayoutInflater.from(service.getApplication()).inflate(i6, (ViewGroup) null);
            f4881k = inflate;
            inflate.measure(0, 0);
        } catch (Throwable unused) {
        }
    }
}
