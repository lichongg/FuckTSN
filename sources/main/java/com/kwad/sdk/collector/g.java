package com.kwad.sdk.collector;

import android.text.TextUtils;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g {
    public static int PERMISSION_DENIED = 2;
    public static int PERMISSION_GRANTED = 1;
    public static int avh;
    private String avg;
    private int state;

    private String DJ() {
        int lastIndexOf;
        String str = this.avg;
        return !TextUtils.isEmpty(str) ? ((str.startsWith("com.android.") || str.startsWith("android.permission")) && (lastIndexOf = str.lastIndexOf(".")) < str.length() + (-1)) ? str.substring(lastIndexOf + 1) : str : str;
    }

    private JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CommonNetImpl.NAME, DJ());
            jSONObject.put("state", this.state);
            return jSONObject;
        } catch (JSONException e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            return jSONObject;
        }
    }

    public static JSONArray w(List<g> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            Iterator<g> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
        }
        return jSONArray;
    }

    public g(String str, int i6) {
        this.avg = str;
        this.state = i6;
    }
}
