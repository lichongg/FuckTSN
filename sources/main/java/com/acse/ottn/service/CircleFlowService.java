package com.acse.ottn.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.acse.ottn.c2;
import com.acse.ottn.h0;
import com.acse.ottn.model.AccessiblityModel;
import com.baidu.mobads.sdk.internal.bn;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CircleFlowService extends Service {

    /* renamed from: b, reason: collision with root package name */
    public static String f5104b = "MainService";

    /* renamed from: a, reason: collision with root package name */
    public AccessiblityModel f5105a;

    static {
        StubApp.interface11(9594);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        try {
            AccessiblityModel accessiblityModel = (AccessiblityModel) intent.getSerializableExtra(bn.f10753i);
            this.f5105a = accessiblityModel;
            if (accessiblityModel != null && accessiblityModel.getData() != null) {
                h0.d().b(this, this.f5105a);
            }
        } catch (Exception e6) {
            try {
                c2.a(f5104b, "Exception =" + e6.getMessage());
            } catch (Exception unused) {
            }
        }
        return super.onStartCommand(intent, i6, i7);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        h0.d().a(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        h0.d().b(this);
    }
}
