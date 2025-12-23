package com.acse.ottn.service;

import android.R;
import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.acse.ottn.activity.ExcessActivity;
import com.acse.ottn.c2;
import com.acse.ottn.model.AccessiblityModel;
import com.stub.StubApp;
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ExcessService extends Service {

    /* renamed from: e, reason: collision with root package name */
    public static View f5112e = null;

    /* renamed from: f, reason: collision with root package name */
    public static WindowManager f5113f = null;

    /* renamed from: g, reason: collision with root package name */
    public static String f5114g = "MainService";

    /* renamed from: a, reason: collision with root package name */
    public WindowManager.LayoutParams f5115a;

    /* renamed from: b, reason: collision with root package name */
    public AccessiblityModel f5116b;

    /* renamed from: c, reason: collision with root package name */
    public int f5117c = -1;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5118d = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f5119a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f5120b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f5121c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f5122d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f5123e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f5124f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f5125g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f5126h;

        public a(String str, String str2, String str3, int i6, String str4, String str5, int i7, String str6) {
            this.f5119a = str;
            this.f5120b = str2;
            this.f5121c = str3;
            this.f5122d = i6;
            this.f5123e = str4;
            this.f5124f = str5;
            this.f5125g = i7;
            this.f5126h = str6;
        }

        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(ExcessService.this, (Class<?>) ExcessActivity.class);
            intent.putExtra("password", this.f5119a);
            intent.putExtra("deeplink", this.f5120b);
            intent.putExtra("link", this.f5121c);
            intent.putExtra("time", this.f5122d);
            intent.putExtra(CommonNetImpl.NAME, this.f5123e);
            intent.putExtra("origin_url", this.f5124f);
            intent.putExtra("dissmiss_time", this.f5125g);
            intent.putExtra("jump_type", this.f5126h);
            intent.addFlags(268435456);
            ExcessService.this.startActivity(intent);
            ExcessService.this.b();
        }
    }

    static {
        StubApp.interface11(9601);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void a() {
        this.f5115a = new WindowManager.LayoutParams();
        f5113f = (WindowManager) getApplication().getSystemService("window");
        if (Build.VERSION.SDK_INT >= 26) {
            this.f5115a.type = 2038;
        } else {
            this.f5115a.type = 2002;
        }
        WindowManager.LayoutParams layoutParams = this.f5115a;
        layoutParams.format = 1;
        layoutParams.flags = 8;
        layoutParams.windowAnimations = R.style.Animation.Translucent;
        layoutParams.gravity = 51;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.width = -2;
        layoutParams.height = -2;
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void b() {
        try {
            f5112e.setVisibility(8);
            f5113f.removeView(f5112e);
        } catch (Exception e6) {
            c2.a(f5114g, e6.getMessage());
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        c2.c(f5114g, "MainService Created");
        a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            com.acse.ottn.service.a.b();
            com.acse.ottn.service.a.d();
            View view = f5112e;
            if (view != null) {
                f5113f.removeView(view);
            }
        } catch (Exception e6) {
            c2.c(f5114g, "e=" + e6.getMessage());
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        try {
            a(intent);
            return 2;
        } catch (Exception e6) {
            c2.c(f5114g, "onStartCommand e=" + e6.getMessage());
            return 2;
        }
    }

    public final void a(Intent intent) {
        if (intent == null) {
            return;
        }
        a(com.acse.ottn.R.layout.excess_view);
        try {
            String stringExtra = intent.getStringExtra("password");
            String stringExtra2 = intent.getStringExtra("deeplink");
            String stringExtra3 = intent.getStringExtra("link");
            String stringExtra4 = intent.getStringExtra("origin_url");
            String stringExtra5 = intent.getStringExtra(CommonNetImpl.NAME);
            int intExtra = intent.getIntExtra("time", 100);
            int intExtra2 = intent.getIntExtra("dissmiss_time", 0);
            String stringExtra6 = intent.getStringExtra("jump_type");
            try {
                WindowManager windowManager = f5113f;
                if (windowManager != null) {
                    windowManager.addView(f5112e, this.f5115a);
                }
            } catch (Exception e6) {
                c2.a(f5114g, "添加失败 e=" + e6.getMessage());
            }
            new Handler().postDelayed(new a(stringExtra, stringExtra2, stringExtra3, intExtra, stringExtra5, stringExtra4, intExtra2, stringExtra6), 0L);
        } catch (Exception e7) {
            c2.a(f5114g, "startExcessActivity e=" + e7.getMessage());
        }
    }

    public final void a(int i6) {
        try {
            View inflate = LayoutInflater.from(getApplication()).inflate(i6, (ViewGroup) null);
            f5112e = inflate;
            inflate.measure(0, 0);
        } catch (Exception e6) {
            c2.a(f5114g, "setLayoutView e = " + e6.getMessage());
        }
    }
}
