package com.acse.ottn.service;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.acse.ottn.c2;
import com.acse.ottn.i1;
import com.acse.ottn.j3;
import com.acse.ottn.util.HelpShopAppUtil;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ExcessiveService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public static String f5128a = "DemoService";

    static {
        StubApp.interface11(9602);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        if (intent != null) {
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    String d6 = i1.a().d("sessionID");
                    if (TextUtils.isEmpty(d6)) {
                        HelpShopAppUtil.getInstance();
                        HelpShopAppUtil.sessionExID();
                    } else {
                        j3.a().b("sessionID", d6);
                        i1.a().b("sessionID", "");
                    }
                    j3.a().a("open_battery_white", Boolean.valueOf(i1.a().a("open_battery_white")));
                }
            } catch (Exception unused) {
                c2.b(f5128a, "request code fail ");
            }
        }
        stopSelf();
        return super.onStartCommand(intent, i6, i7);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }
}
