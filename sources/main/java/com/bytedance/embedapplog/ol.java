package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
class ol extends l {

    /* renamed from: m, reason: collision with root package name */
    private final rn f24020m;
    private final Context up;

    ol(Context context, rn rnVar) {
        super(false, false);
        this.up = context;
        this.f24020m = rnVar;
    }

    @Override // com.bytedance.embedapplog.l
    protected boolean j(JSONObject jSONObject) {
        int i6;
        ApplicationInfo applicationInfo;
        int i7;
        String packageName = this.up.getPackageName();
        PackageInfo packageInfo = null;
        if (TextUtils.isEmpty(this.f24020m.z())) {
            jSONObject.put(WiseOpenHianalyticsData.UNION_PACKAGE, packageName);
        } else {
            if (uc.xt) {
                uc.j("has zijie pkg", null);
            }
            jSONObject.put(WiseOpenHianalyticsData.UNION_PACKAGE, this.f24020m.z());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            packageInfo = this.up.getPackageManager().getPackageInfo(packageName, 0);
        } catch (Throwable unused) {
        }
        if (packageInfo != null) {
            try {
                i6 = packageInfo.versionCode;
            } catch (Throwable th) {
                uc.xt(th);
                return false;
            }
        } else {
            i6 = 0;
        }
        if (TextUtils.isEmpty(this.f24020m.gq())) {
            jSONObject.put("app_version", packageInfo != null ? packageInfo.versionName : "");
        } else {
            jSONObject.put("app_version", this.f24020m.gq());
        }
        if (TextUtils.isEmpty(this.f24020m.c())) {
            jSONObject.put("app_version_minor", "");
        } else {
            jSONObject.put("app_version_minor", this.f24020m.c());
        }
        if (this.f24020m.p() != 0) {
            jSONObject.put("version_code", this.f24020m.p());
        } else {
            jSONObject.put("version_code", i6);
        }
        if (this.f24020m.h() != 0) {
            jSONObject.put("update_version_code", this.f24020m.h());
        } else {
            jSONObject.put("update_version_code", i6);
        }
        if (this.f24020m.la() != 0) {
            jSONObject.put("manifest_version_code", this.f24020m.la());
        } else {
            jSONObject.put("manifest_version_code", i6);
        }
        if (!TextUtils.isEmpty(this.f24020m.l())) {
            jSONObject.put("app_name", this.f24020m.l());
        }
        if (!TextUtils.isEmpty(this.f24020m.rn())) {
            jSONObject.put("tweaked_channel", this.f24020m.rn());
        }
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (i7 = applicationInfo.labelRes) <= 0) {
            return true;
        }
        jSONObject.put("display_name", this.up.getString(i7));
        return true;
    }
}
