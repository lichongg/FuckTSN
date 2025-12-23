package com.acse.ottn.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import com.acse.ottn.c2;
import com.acse.ottn.h2;
import com.acse.ottn.m1;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.a;
import com.baidu.mobads.sdk.internal.bn;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class MainService extends Service implements a.u0 {

    /* renamed from: c, reason: collision with root package name */
    public static View f5133c = null;

    /* renamed from: d, reason: collision with root package name */
    public static WindowManager f5134d = null;

    /* renamed from: e, reason: collision with root package name */
    public static String f5135e = "MainService";

    /* renamed from: a, reason: collision with root package name */
    public WindowManager.LayoutParams f5136a;

    /* renamed from: b, reason: collision with root package name */
    public AccessiblityModel f5137b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements m1.b0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f5138a;

        @Override // com.acse.ottn.m1.b0
        public void a(int i6, int i7) {
            if (i6 != 1) {
                h2.a().b(MainService.this);
            } else {
                if (i7 != 1) {
                    h2.a().b(MainService.this);
                    return;
                }
                h2 a6 = h2.a();
                MainService mainService = MainService.this;
                a6.a(mainService, this.f5138a, mainService);
            }
        }

        public a(String str) {
            this.f5138a = str;
        }
    }

    static {
        StubApp.interface11(9605);
    }

    @Override // com.acse.ottn.service.a.u0
    public void a(String str) {
        m1.c().a(str, new a(str));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.acse.ottn.service.a.u0
    public void a() {
        h2.a().b(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            c2.c(f5135e, "onDestroy ");
            com.acse.ottn.service.a.b();
            com.acse.ottn.service.a.d();
            h2.a().b(this);
        } catch (Exception e6) {
            c2.c(f5135e, "onDestroy e=" + e6.getMessage());
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        try {
            AccessiblityModel accessiblityModel = (AccessiblityModel) intent.getSerializableExtra(bn.f10753i);
            this.f5137b = accessiblityModel;
            if (accessiblityModel != null && accessiblityModel.getData() != null) {
                if (this.f5137b.getData().getService_control().equals("0")) {
                    h2.a().c(this, this.f5137b, this);
                } else if (this.f5137b.getData().getService_control().equals("1")) {
                    h2.a().a(this, this.f5137b, this);
                }
            }
        } catch (Exception e6) {
            c2.a(f5135e, "Exception =" + e6.getMessage());
        }
        return super.onStartCommand(intent, i6, i7);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void b() {
        h2.a().a(this);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        c2.c(f5135e, "MainService Created");
        b();
    }
}
