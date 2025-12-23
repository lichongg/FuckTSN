package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.m.j;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes6.dex */
public class DownloadHandleNotificationActivity extends Activity {

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f38550b;

    /* renamed from: a, reason: collision with root package name */
    private DownloadHandlerService f38551a = new DownloadHandlerService();

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public native void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr);

    static {
        StubApp.interface11(41484);
        f38550b = new String[]{"android.permission.POST_NOTIFICATIONS"};
    }

    private void a() {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                requestPermissions(f38550b, 1000);
            }
        } catch (Throwable th) {
            j.xt("DownloadNotificationJumpActivity", "requestNotificationPermissionError:".concat(String.valueOf(th)));
        }
    }
}
