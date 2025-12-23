package com.acse.ottn.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import com.acse.ottn.c2;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.z1;
import com.baidu.mobads.sdk.internal.bn;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class LjFirstService extends Service {

    /* renamed from: b, reason: collision with root package name */
    public static View f5129b = null;

    /* renamed from: c, reason: collision with root package name */
    public static WindowManager f5130c = null;

    /* renamed from: d, reason: collision with root package name */
    public static String f5131d = "LjFirstService";

    /* renamed from: a, reason: collision with root package name */
    public Intent f5132a;

    static {
        StubApp.interface11(9603);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        try {
            AccessiblityModel accessiblityModel = (AccessiblityModel) intent.getSerializableExtra(bn.f10753i);
            if (accessiblityModel != null && accessiblityModel.getData() != null) {
                z1.a().a(this, accessiblityModel);
            }
        } catch (Exception e6) {
            try {
                c2.a(f5131d, "Exception =" + e6.getMessage());
            } catch (Exception unused) {
            }
        }
        return super.onStartCommand(intent, i6, i7);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        z1.a().a(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        z1.a().b(this);
    }
}
