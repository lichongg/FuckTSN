package com.bytedance.embedapplog;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
class hh extends l {
    hh() {
        super(true, false);
    }

    @Override // com.bytedance.embedapplog.l
    protected boolean j(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder(16);
        if (j()) {
            sb.append("MIUI-");
        } else if (xt()) {
            sb.append("FLYME-");
        } else {
            String j6 = g.j();
            if (g.j(j6)) {
                sb.append("EMUI-");
            }
            if (!TextUtils.isEmpty(j6)) {
                sb.append(j6);
                sb.append("-");
            }
        }
        sb.append(Build.VERSION.INCREMENTAL);
        jSONObject.put("rom", sb.toString());
        return true;
    }

    private boolean xt() {
        String str = Build.DISPLAY;
        return (!TextUtils.isEmpty(str) && str.contains("Flyme")) || "flyme".equals(Build.USER);
    }

    private boolean j() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
