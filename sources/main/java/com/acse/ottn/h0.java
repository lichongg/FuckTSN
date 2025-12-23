package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
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
import com.acse.ottn.service.a;
import java.io.ObjectStreamException;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class h0 {

    /* renamed from: g, reason: collision with root package name */
    public static View f4551g = null;

    /* renamed from: h, reason: collision with root package name */
    public static WindowManager f4552h = null;

    /* renamed from: i, reason: collision with root package name */
    public static String f4553i = "MainService";

    /* renamed from: j, reason: collision with root package name */
    public static h0 f4554j;

    /* renamed from: k, reason: collision with root package name */
    public static TimerTask f4555k;

    /* renamed from: a, reason: collision with root package name */
    public WindowManager.LayoutParams f4556a;

    /* renamed from: b, reason: collision with root package name */
    public RelativeLayout f4557b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f4558c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f4559d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f4560e;

    /* renamed from: f, reason: collision with root package name */
    public o0 f4561f = new e();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service f4562a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f4563b;

        public a(Service service, AccessiblityModel accessiblityModel) {
            this.f4562a = service;
            this.f4563b = accessiblityModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TimerTask timerTask = h0.f4555k;
            if (timerTask != null) {
                timerTask.cancel();
            }
            h0.this.b(this.f4562a);
            l2.b().a("tb_lj_circle_click");
            com.acse.ottn.service.a.b().a(this.f4562a, this.f4563b, (a.u0) null);
            y1.b().a();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service f4565a;

        public b(Service service) {
            this.f4565a = service;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h0.this.b(this.f4565a);
            l2.b().a("tb_lj_circle_close");
            y1.b().a();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements o0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service f4567a;

        public c(Service service) {
            this.f4567a = service;
        }

        @Override // com.acse.ottn.o0
        public void a() {
            TimerTask timerTask = h0.f4555k;
            if (timerTask != null) {
                timerTask.cancel();
            }
            h0.this.b(this.f4567a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service f4569a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f4570b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (k0.f4669e) {
                    return;
                }
                TimerTask timerTask = h0.f4555k;
                if (timerTask != null) {
                    timerTask.cancel();
                }
                y1.b().a();
                d dVar = d.this;
                h0.this.b(dVar.f4569a);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public class b implements View.OnClickListener {

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            public class a implements View.OnClickListener {
                public a() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TimerTask timerTask = h0.f4555k;
                    if (timerTask != null) {
                        timerTask.cancel();
                    }
                    l2.b().a("tb_lj_circle_again");
                    d dVar = d.this;
                    h0.this.b(dVar.f4569a);
                    if (d.this.f4570b == null) {
                        return;
                    }
                    com.acse.ottn.service.a b6 = com.acse.ottn.service.a.b();
                    d dVar2 = d.this;
                    b6.a(dVar2.f4569a, dVar2.f4570b, (a.u0) null);
                    y1.b().a();
                }
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.acse.ottn.h0$d$b$b, reason: collision with other inner class name */
            public class C0079b implements m0.d {

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                /* renamed from: com.acse.ottn.h0$d$b$b$a */
                public class a implements Runnable {
                    public a() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (k0.f4669e) {
                            return;
                        }
                        TimerTask timerTask = h0.f4555k;
                        if (timerTask != null) {
                            timerTask.cancel();
                        }
                        y1.b().a();
                        d dVar = d.this;
                        h0.this.b(dVar.f4569a);
                    }
                }

                @Override // com.acse.ottn.m0.d
                public void a(long j6) {
                    new Handler(Looper.getMainLooper()).postDelayed(new a(), 0L);
                }

                public C0079b() {
                }

                @Override // com.acse.ottn.m0.d
                public void a() {
                    y1.b().a();
                    d dVar = d.this;
                    h0.this.b(dVar.f4569a);
                }
            }

            public b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l2.b().a("tb_lj_fan_click");
                h0.this.f4558c.setVisibility(8);
                h0.this.f4560e.setVisibility(0);
                h0.this.f4559d.setVisibility(0);
                h0.this.f4556a.width = u0.a((Context) d.this.f4569a, 106.0f);
                h0.this.f4556a.height = u0.a((Context) d.this.f4569a, 80.0f);
                h0.f4552h.updateViewLayout(h0.f4551g, h0.this.f4556a);
                h0.this.f4559d.setOnClickListener(new a());
                h0.f4555k = m0.a().b(d.this.f4570b.getData().getTime_four(), 500, new C0079b());
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public class c implements m0.d {

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (k0.f4669e) {
                        return;
                    }
                    TimerTask timerTask = h0.f4555k;
                    if (timerTask != null) {
                        timerTask.cancel();
                    }
                    y1.b().a();
                    d dVar = d.this;
                    h0.this.b(dVar.f4569a);
                }
            }

            @Override // com.acse.ottn.m0.d
            public void a(long j6) {
                new Handler(Looper.getMainLooper()).postDelayed(new a(), 0L);
            }

            public c() {
            }

            @Override // com.acse.ottn.m0.d
            public void a() {
                y1.b().a();
                d dVar = d.this;
                h0.this.b(dVar.f4569a);
            }
        }

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            new Handler(Looper.getMainLooper()).postDelayed(new a(), 0L);
        }

        public d(Service service, AccessiblityModel accessiblityModel) {
            this.f4569a = service;
            this.f4570b = accessiblityModel;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            try {
                c2.a(h0.f4553i, "结束了");
                h0.this.f4559d.setVisibility(8);
                h0.this.f4560e.setVisibility(8);
                h0.this.f4558c.setVisibility(0);
                h0.this.f4556a.width = u0.a((Context) this.f4569a, 59.0f);
                h0.this.f4556a.height = u0.a((Context) this.f4569a, 71.0f);
                h0.f4552h.updateViewLayout(h0.f4551g, h0.this.f4556a);
                h0.this.f4558c.setOnClickListener(new b());
                h0.f4555k = m0.a().b(this.f4570b.getData().getCoupon_detail_url(), 500, new c());
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class e implements o0 {
        public e() {
        }

        @Override // com.acse.ottn.o0
        public void a() {
        }
    }

    public static h0 d() {
        if (f4554j == null) {
            synchronized (h0.class) {
                try {
                    if (f4554j == null) {
                        f4554j = new h0();
                    }
                } finally {
                }
            }
        }
        return f4554j;
    }

    public final Object e() throws ObjectStreamException {
        return f4554j;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a(Service service) {
        this.f4556a = new WindowManager.LayoutParams();
        if (d4.a().a(service)) {
            f4552h = (WindowManager) service.getApplication().getSystemService("window");
            if (Build.VERSION.SDK_INT >= 26) {
                this.f4556a.type = 2038;
            } else {
                this.f4556a.type = 2002;
            }
            this.f4556a.flags = 8;
        } else {
            f4552h = (WindowManager) service.getSystemService("window");
            WindowManager.LayoutParams layoutParams = this.f4556a;
            layoutParams.type = 2032;
            layoutParams.flags = 800;
        }
        WindowManager.LayoutParams layoutParams2 = this.f4556a;
        layoutParams2.format = 1;
        layoutParams2.windowAnimations = android.R.style.Animation.Translucent;
        layoutParams2.gravity = 85;
        layoutParams2.x = 0;
        layoutParams2.y = 700;
        layoutParams2.width = u0.a((Context) service, 106.0f);
        this.f4556a.height = u0.a((Context) service, 80.0f);
    }

    public void b(Service service, AccessiblityModel accessiblityModel) {
        a(service, R.layout.circle_lj_background);
        this.f4557b = (RelativeLayout) f4551g.findViewById(R.id.treasure_box);
        this.f4560e = (TextView) f4551g.findViewById(R.id.tv_context);
        this.f4558c = (ImageView) f4551g.findViewById(R.id.tv_fan);
        this.f4559d = (ImageView) f4551g.findViewById(R.id.image);
        this.f4560e.setText(accessiblityModel.getData().getSpop_title());
        this.f4559d.setOnClickListener(new a(service, accessiblityModel));
        ((ImageView) f4551g.findViewById(R.id.iv_didi_setting)).setOnClickListener(new b(service));
        try {
            f4552h.addView(f4551g, this.f4556a);
            if (accessiblityModel.getData().getThird_price() == 0) {
                this.f4559d.setVisibility(8);
                this.f4560e.setVisibility(8);
                this.f4558c.setVisibility(0);
                this.f4556a.width = u0.a((Context) service, 59.0f);
                this.f4556a.height = u0.a((Context) service, 71.0f);
                f4552h.updateViewLayout(f4551g, this.f4556a);
            }
            a(service, accessiblityModel);
            k0.a(new c(service));
        } catch (Throwable unused) {
        }
    }

    public final void a(Service service, AccessiblityModel accessiblityModel) {
        f4555k = m0.a().b(accessiblityModel.getData().getThird_price(), 500, new d(service, accessiblityModel));
    }

    public final void a(Service service, int i6) {
        try {
            View inflate = LayoutInflater.from(service.getApplication()).inflate(i6, (ViewGroup) null);
            f4551g = inflate;
            inflate.measure(0, 0);
        } catch (Throwable unused) {
        }
    }

    public void b(Service service) {
        try {
            View view = f4551g;
            if (view != null) {
                view.setVisibility(8);
            }
            f4552h.removeView(f4551g);
            if (!d4.a().a(service)) {
                service = (AccessibilityService) service;
            }
            service.stopSelf();
        } catch (Throwable unused) {
        }
    }
}
