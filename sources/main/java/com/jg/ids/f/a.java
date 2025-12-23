package com.jg.ids.f;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.jg.ids.g;

/* loaded from: D:\Downloads\app\classes10.dex */
public final class a extends g {

    /* renamed from: b, reason: collision with root package name */
    private String f35526b;

    public a(Context context) {
        super(context);
    }

    @Override // com.jg.ids.g
    protected final Intent a() {
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.f35526b);
        return intent;
    }

    @Override // com.jg.ids.g
    protected final void a(IBinder iBinder) {
        if (this.f35525a != null) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    String string = Settings.Global.getString(this.f35525a.getContentResolver(), "pps_oaid");
                    if (!TextUtils.isEmpty(string)) {
                        c(string);
                        return;
                    }
                }
                b a6 = c.a(iBinder);
                if (!a6.b()) {
                    String a7 = a6.a();
                    if (!TextUtils.isEmpty(a7)) {
                        c(a7);
                    }
                }
                b();
            } catch (Exception e6) {
            }
        }
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final boolean d() {
        boolean z5 = true;
        if (this.f35525a == null) {
            return false;
        }
        try {
            PackageManager packageManager = this.f35525a.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.f35526b = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.f35526b = "com.huawei.hwid.tv";
            } else {
                this.f35526b = "com.huawei.hms";
                if (packageManager.getPackageInfo(this.f35526b, 0) == null) {
                    z5 = false;
                }
            }
        } catch (Exception e6) {
            z5 = false;
        }
        return z5;
    }

    @Override // com.jg.ids.f
    protected final boolean c() {
        return TextUtils.isEmpty(a(this.f35525a));
    }
}
