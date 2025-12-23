package com.ss.android.downloadlib.addownload;

import com.bytedance.sdk.component.utils.vl;
import com.ss.android.downloadlib.addownload.o;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.downloader.mi;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class n implements mi {
    @Override // com.ss.android.socialbase.downloader.downloader.mi
    public void j(cw cwVar, int i6, int i7) {
        com.ss.android.xt.j.xt.b f6 = o.f.c().f(cwVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("reserve_wifi_source", Integer.valueOf(i7));
            jSONObject.putOpt("reserve_wifi_status", Integer.valueOf(i6));
        } catch (JSONException e6) {
            vl.j(e6);
        }
        com.ss.android.downloadlib.r.b.a().r("pause_reserve_wifi", jSONObject, f6);
    }
}
