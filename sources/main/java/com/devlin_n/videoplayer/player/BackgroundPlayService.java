package com.devlin_n.videoplayer.player;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.devlin_n.videoplayer.controller.FloatController;
import com.devlin_n.videoplayer.widget.FloatView;
import com.stub.StubApp;
import h1.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class BackgroundPlayService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private WindowManager f32342a;

    /* renamed from: b, reason: collision with root package name */
    private WindowManager.LayoutParams f32343b;

    /* renamed from: c, reason: collision with root package name */
    private IjkVideoView f32344c;

    /* renamed from: d, reason: collision with root package name */
    private String f32345d;

    /* renamed from: e, reason: collision with root package name */
    private FloatView f32346e;

    /* renamed from: f, reason: collision with root package name */
    private int f32347f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f32348g;

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void b() {
        if (this.f32348g) {
            this.f32344c.T();
        }
        this.f32344c.h0(this.f32345d, this.f32347f).f0(new FloatController(StubApp.getOrigApplicationContext(getApplicationContext()))).start();
        this.f32342a.addView(this.f32346e, this.f32343b);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        this.f32345d = intent.getStringExtra("url");
        this.f32347f = intent.getIntExtra("position", 0);
        this.f32348g = intent.getBooleanExtra(h1.b.f43031c, false);
        h1.a.f43027c = true;
        b();
        return 2;
    }

    private void a() {
        this.f32342a = f.g(StubApp.getOrigApplicationContext(getApplicationContext()));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f32343b = layoutParams;
        layoutParams.type = 2003;
        layoutParams.format = 1;
        layoutParams.flags = 8;
        layoutParams.gravity = 8388659;
        int a6 = f.a(StubApp.getOrigApplicationContext(getApplicationContext()), 250.0f);
        WindowManager.LayoutParams layoutParams2 = this.f32343b;
        layoutParams2.width = a6;
        layoutParams2.height = (a6 * 9) / 16;
        layoutParams2.x = f.e(StubApp.getOrigApplicationContext(getApplicationContext())) - a6;
        this.f32343b.y = f.d(StubApp.getOrigApplicationContext(getApplicationContext()), false) / 2;
        FloatView floatView = new FloatView(StubApp.getOrigApplicationContext(getApplicationContext()), this.f32342a, this.f32343b);
        this.f32346e = floatView;
        this.f32344c = floatView.f32412c;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        h1.a.f43027c = false;
        FloatView floatView = this.f32346e;
        if (floatView != null) {
            this.f32342a.removeView(floatView);
        }
        this.f32344c.Z();
    }
}
