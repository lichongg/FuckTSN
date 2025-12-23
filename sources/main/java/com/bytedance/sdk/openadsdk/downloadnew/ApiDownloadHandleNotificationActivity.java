package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import com.bytedance.sdk.openadsdk.api.m;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ApiDownloadHandleNotificationActivity extends Activity {

    /* renamed from: j, reason: collision with root package name */
    private static final String[] f31371j;
    private ApiDownloadHandlerService xt = new ApiDownloadHandlerService();

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public native void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr);

    static {
        StubApp.interface11(25172);
        f31371j = new String[]{"android.permission.POST_NOTIFICATIONS"};
    }

    private void j() {
        try {
            ActivityCompat.requestPermissions(this, f31371j, 1000);
        } catch (Throwable th) {
            m.xt("DownloadNotificationJumpActivity", "requestNotificationPermissionError:".concat(String.valueOf(th)));
        }
    }
}
