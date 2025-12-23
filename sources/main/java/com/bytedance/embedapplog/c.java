package com.bytedance.embedapplog;

import android.content.Context;
import com.huawei.hms.mlsdk.common.AgConnectInfo;
import com.umeng.analytics.pro.bi;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
class c extends l {
    private final Context up;

    c(Context context) {
        super(true, true);
        this.up = context;
    }

    @Override // com.bytedance.embedapplog.l
    protected boolean j(JSONObject jSONObject) {
        wq.j(jSONObject, "language", this.up.getResources().getConfiguration().locale.getLanguage());
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            rawOffset = 12;
        }
        jSONObject.put(bi.M, rawOffset);
        wq.j(jSONObject, AgConnectInfo.AgConnectKey.REGION, Locale.getDefault().getCountry());
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        wq.j(jSONObject, "tz_name", timeZone.getID());
        jSONObject.put("tz_offset", timeZone.getOffset(System.currentTimeMillis() / 1000));
        return true;
    }
}
