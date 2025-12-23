package com.umeng.socialize.net.verify;

import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class VerifyResponse extends SocializeReseponse {

    /* renamed from: a, reason: collision with root package name */
    private int f42478a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f42479b;

    public VerifyResponse(Integer num, JSONObject jSONObject) {
        super(null);
        this.f42478a = num.intValue();
        this.f42479b = false;
        parseJsonObject(jSONObject);
    }

    @Override // com.umeng.socialize.net.base.SocializeReseponse
    public boolean isHttpOK() {
        return this.f42478a == 200;
    }

    @Override // com.umeng.socialize.net.base.SocializeReseponse
    public boolean isOk() {
        return this.f42479b;
    }

    public void parseJsonObject(JSONObject jSONObject) {
        try {
            if (jSONObject.getString("result").startsWith("success")) {
                this.f42479b = true;
            } else {
                this.f42479b = false;
            }
        } catch (JSONException e6) {
            SLog.error(UmengText.NET.PARSEERROR, e6);
        }
    }
}
