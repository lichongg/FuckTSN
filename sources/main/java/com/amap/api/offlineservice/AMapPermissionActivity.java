package com.amap.api.offlineservice;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AMapPermissionActivity extends Activity {
    protected String[] needPermissions = new String[0];

    /* renamed from: a, reason: collision with root package name */
    private boolean f9087a = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i6) {
            try {
                AMapPermissionActivity.this.finish();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i6) {
            try {
                AMapPermissionActivity.this.f();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static boolean d(int[] iArr) {
        try {
            for (int i6 : iArr) {
                if (i6 != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    private boolean g(String str) {
        try {
            return ((Boolean) getClass().getMethod("shouldShowRequestPermissionRationale", String.class).invoke(this, str)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private int a(String str) {
        try {
            return ((Integer) getClass().getMethod("checkSelfPermission", String.class).invoke(this, str)).intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    private void b() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("提示");
            builder.setMessage("当前应用缺少必要权限。\n\n请点击\"设置\"-\"权限\"-打开所需权限");
            builder.setNegativeButton("取消", new a());
            builder.setPositiveButton("设置", new b());
            builder.setCancelable(false);
            builder.show();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @TargetApi(23)
    private void c(String... strArr) {
        List<String> e6;
        try {
            if (Build.VERSION.SDK_INT < 23 || getApplicationInfo().targetSdkVersion < 23 || (e6 = e(strArr)) == null) {
                return;
            }
            if (e6.size() > 0) {
                try {
                    getClass().getMethod("requestPermissions", String[].class, Integer.TYPE).invoke(this, (String[]) e6.toArray(new String[e6.size()]), 0);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @TargetApi(23)
    private List<String> e(String[] strArr) {
        int i6;
        try {
            ArrayList arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 23 && getApplicationInfo().targetSdkVersion >= 23) {
                int length = strArr.length;
                while (i6 < length) {
                    String str = strArr[i6];
                    i6 = (a(str) == 0 && !g(str)) ? i6 + 1 : 0;
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    @TargetApi(23)
    public void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        try {
            StubApp.interface22(i6, strArr, iArr);
            if (Build.VERSION.SDK_INT < 23 || i6 != 0 || d(iArr)) {
                return;
            }
            b();
            this.f9087a = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        try {
            super.onResume();
            if (Build.VERSION.SDK_INT >= 23 && this.f9087a) {
                c(this.needPermissions);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
