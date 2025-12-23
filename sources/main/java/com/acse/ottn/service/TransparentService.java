package com.acse.ottn.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.acse.ottn.R;
import com.acse.ottn.c2;
import com.acse.ottn.u0;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TransparentService extends Service {

    /* renamed from: f, reason: collision with root package name */
    public static View f5140f = null;

    /* renamed from: g, reason: collision with root package name */
    public static WindowManager f5141g = null;

    /* renamed from: h, reason: collision with root package name */
    public static String f5142h = "MainService";

    /* renamed from: a, reason: collision with root package name */
    public WindowManager.LayoutParams f5143a;

    /* renamed from: b, reason: collision with root package name */
    public RelativeLayout f5144b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f5145c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f5146d;

    /* renamed from: e, reason: collision with root package name */
    public String f5147e;

    static {
        StubApp.interface11(9608);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void a() {
        this.f5143a = new WindowManager.LayoutParams();
        f5141g = (WindowManager) getApplication().getSystemService("window");
        if (Build.VERSION.SDK_INT >= 26) {
            this.f5143a.type = 2038;
        } else {
            this.f5143a.type = 2002;
        }
        WindowManager.LayoutParams layoutParams = this.f5143a;
        layoutParams.format = 1;
        layoutParams.flags = 8;
        layoutParams.gravity = 51;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.width = u0.a((Context) this, 1.0f);
        this.f5143a.height = u0.a((Context) this, 1.0f);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void b() {
        try {
            View view = f5140f;
            if (view != null) {
                view.setVisibility(8);
            }
            f5141g.removeView(f5140f);
            stopSelf();
        } catch (Throwable unused) {
        }
    }

    public void c() {
        a(R.layout.transparent_background);
        this.f5144b = (RelativeLayout) f5140f.findViewById(R.id.treasure_box);
        this.f5146d = (ImageView) f5140f.findViewById(R.id.image);
        try {
            f5141g.addView(f5140f, this.f5143a);
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        try {
            this.f5147e = intent.getStringExtra("deeplink");
            c();
        } catch (Exception e6) {
            try {
                c2.a(f5142h, "Exception =" + e6.getMessage());
            } catch (Exception unused) {
            }
        }
        return super.onStartCommand(intent, i6, i7);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        b();
    }

    public final void a(int i6) {
        try {
            View inflate = LayoutInflater.from(getApplication()).inflate(i6, (ViewGroup) null);
            f5140f = inflate;
            inflate.measure(0, 0);
        } catch (Throwable unused) {
        }
    }
}
