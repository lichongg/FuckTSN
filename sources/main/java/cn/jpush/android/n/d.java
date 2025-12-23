package cn.jpush.android.n;

import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d extends JPushResponse {

    /* renamed from: a, reason: collision with root package name */
    private int f3714a;

    /* renamed from: b, reason: collision with root package name */
    private JSONObject f3715b;

    /* renamed from: c, reason: collision with root package name */
    private JSONArray f3716c;

    public d(int i6, long j6, long j7, ByteBuffer byteBuffer) {
        super(i6, j6, j7, byteBuffer);
        this.f3714a = -1;
        parseBody();
    }

    public d(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public JSONObject a() {
        return this.f3715b;
    }

    public JSONArray b() {
        return this.f3716c;
    }

    @Override // cn.jpush.android.local.JPushResponse
    protected void parseBody() {
        String str;
        try {
            ByteBuffer byteBuffer = this.body;
            if (byteBuffer == null) {
                str = "geo pull response empty";
            } else {
                short s5 = byteBuffer.getShort();
                this.f3714a = s5;
                if (s5 == 0) {
                    byte[] bArr = new byte[this.body.getShort()];
                    this.body.get(bArr);
                    String str2 = new String(bArr, "UTF-8");
                    Logger.d("GeoPullResponse", "receive content：" + str2);
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(str2);
                    this.f3716c = jSONObject.getJSONArray("geofence");
                    jSONObject.remove("geofence");
                    this.f3715b = jSONObject;
                    return;
                }
                str = "geo pull response error code :" + this.f3714a;
            }
            Logger.ww("GeoPullResponse", str);
        } catch (Throwable unused) {
            Logger.ww("GeoPullResponse", "parse geo pull response failed");
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[GeoPullResponse] - limit:" + this.f3715b + " - geoArray:" + this.f3716c + " - " + super.toString();
    }
}
