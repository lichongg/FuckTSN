package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
class hl extends l {
    private final Context up;

    hl(Context context) {
        super(true, false);
        this.up = context;
    }

    @Override // com.bytedance.embedapplog.l
    protected boolean j(JSONObject jSONObject) {
        PackageInfo packageInfo;
        Signature[] signatureArr;
        Signature signature;
        String str = null;
        try {
            packageInfo = this.up.getPackageManager().getPackageInfo(this.up.getPackageName(), 64);
        } catch (Throwable th) {
            uc.xt(th);
            packageInfo = null;
        }
        if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0 && (signature = signatureArr[0]) != null) {
            str = st.xt(signature.toByteArray());
        }
        if (str == null) {
            return true;
        }
        jSONObject.put("sig_hash", str);
        return true;
    }
}
