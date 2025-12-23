package com.ss.android.socialbase.appdownloader.view;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.ss.android.socialbase.appdownloader.up.c;
import com.ss.android.socialbase.downloader.downloader.cw;
import com.ss.android.socialbase.downloader.xt.up;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends Fragment {
    public static Intent d() {
        return new Intent("android.settings.APPLICATION_SETTINGS");
    }

    public void b() {
        try {
            try {
                try {
                    startActivityForResult(c(), 1000);
                } catch (Throwable unused) {
                    startActivityForResult(f(), 1000);
                }
            } catch (Throwable unused2) {
                startActivityForResult(d(), 1000);
            }
        } catch (Throwable unused3) {
            startActivityForResult(a(), 1000);
        }
    }

    private Intent c() {
        Context e6 = e();
        if (e6 == null) {
            return null;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        String packageName = e6.getPackageName();
        intent.putExtra(WiseOpenHianalyticsData.UNION_PACKAGE, packageName);
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra("app_package", packageName);
        int i6 = e6.getApplicationInfo().uid;
        intent.putExtra("uid", i6);
        intent.putExtra("app_uid", i6);
        return intent;
    }

    private Context e() {
        Context nd = cw.nd();
        if (nd == null && getActivity() != null && !getActivity().isFinishing()) {
            return StubApp.getOrigApplicationContext(getActivity().getApplicationContext());
        }
        return nd;
    }

    public Intent a() {
        Context e6 = e();
        if (e6 == null) {
            return null;
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + e6.getPackageName()));
    }

    public Intent f() {
        Context e6 = e();
        if (e6 == null) {
            return null;
        }
        String packageName = e6.getPackageName();
        String str = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.contains(up.cw)) {
                Intent intent = new Intent();
                intent.putExtra(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, packageName);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                return intent;
            }
            if (lowerCase.contains("vivo")) {
                Intent intent2 = new Intent();
                intent2.putExtra("packagename", packageName);
                if (Build.VERSION.SDK_INT >= 25) {
                    intent2.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
                    return intent2;
                }
                intent2.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
                return intent2;
            }
            if (lowerCase.contains("meizu") && Build.VERSION.SDK_INT < 25) {
                Intent intent3 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                intent3.putExtra(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, packageName);
                intent3.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
                return intent3;
            }
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + e6.getPackageName()));
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i6, int i7, Intent intent) {
        super.onActivityResult(i6, i7, intent);
        if (c.e()) {
            c.d(true);
        } else {
            c.d(false);
        }
    }
}
