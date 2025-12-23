package com.acse.ottn.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.acse.ottn.c2;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.n0;
import com.baidu.mobads.sdk.internal.bn;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CountdownService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public static String f5106a = "CountdownService";

    static {
        StubApp.interface11(9595);
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
                n0.a().b(this, accessiblityModel);
            }
        } catch (Exception e6) {
            try {
                c2.a(f5106a, "Exception =" + e6.getMessage());
            } catch (Exception unused) {
            }
        }
        return super.onStartCommand(intent, i6, i7);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        n0.a().a(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        n0.a().b(this);
    }
}
