package com.acse.ottn.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.acse.ottn.a4;
import com.acse.ottn.c2;
import com.acse.ottn.h4;
import com.acse.ottn.n;
import com.acse.ottn.z;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SeedingLoadingActivity extends z {

    /* renamed from: e, reason: collision with root package name */
    public int f4162e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4163f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements a4.h {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.acse.ottn.activity.SeedingLoadingActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0063a implements Runnable {
            public RunnableC0063a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SeedingLoadingActivity.this.finish();
            }
        }

        public a() {
        }

        @Override // com.acse.ottn.a4.h
        public void a(String str, String str2) {
            if (SeedingLoadingActivity.this.f4163f) {
                SeedingLoadingActivity.this.finish();
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                c2.a("SeedingLoadingActivity", "write code = " + str);
                n.c().a(SeedingLoadingActivity.this, str);
            }
            try {
                if (!TextUtils.isEmpty(str2)) {
                    h4.c().a(SeedingLoadingActivity.this, str2, "", "");
                }
            } catch (Throwable unused) {
            }
            new Handler().postDelayed(new RunnableC0063a(), SeedingLoadingActivity.this.f4162e);
        }
    }

    static {
        StubApp.interface11(9032);
    }

    @Override // com.acse.ottn.z, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    public final String a(Context context) {
        if (context == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    @Override // com.acse.ottn.z, androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void z2() {
        super.z2();
        this.f4163f = true;
        a4.a().c();
    }

    @Override // com.acse.ottn.z, androidx.fragment.app.FragmentActivity, android.app.Activity
    @RequiresApi(api = 21)
    public void onPause() {
        super.onPause();
        this.f4163f = true;
        finish();
    }
}
