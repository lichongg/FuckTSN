package com.beizi.fusion.update;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.tool.an;
import com.beizi.fusion.tool.ao;
import com.beizi.fusion.tool.d;
import com.beizi.fusion.tool.t;
import com.beizi.fusion.tool.v;
import com.beizi.fusion.tool.y;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c extends AsyncTask<String, Integer, a> {

    /* renamed from: a, reason: collision with root package name */
    private Context f13826a;

    /* renamed from: b, reason: collision with root package name */
    private b f13827b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a doInBackground(String... strArr) {
        String a6;
        try {
            if (!RequestInfo.getInstance(this.f13826a).isInit) {
                RequestInfo.getInstance(this.f13826a).init();
            }
            if (strArr == null || strArr.length <= 0) {
                a6 = d.a("aHR0cDovL3Nkay5iZWl6aS5iaXovdjQvYXBpL3Nkay9jZi9wP2FwcElkPV9fQVBQSURfXyZwYWNrYWdlTmFtZT1fX1BBQ0tBR0VOQU1FX18maW5zdGFsbFRpbWU9X19JTlNUQUxMVElNRV9fJnVwZGF0ZVRpbWU9X19VUERBVEVUSU1FX18mbm93VGltZT1fX05PV1RJTUVfXyZhcHBWZXJzaW9uPV9fQVBQVkVSU0lPTl9fJmFwcFZlcnNpb25Db2RlPV9fQVBQVkVSU0lPTkNPREVfXyZzZGtWZXJzaW9uPV9fU0RLVkVSU0lPTl9fJlVzZXJBZ2VudD1fX1VTRVJBR0VOVF9fJnNka1VJRD1fX1NES1VJRF9fJmlkZmE9X19JREZBX18maWRmdj1fX0lERlZfXyZvcz1fX09TX18mcGxhdGZvcm09X19QTEFURk9STV9fJmRldlR5cGU9X19ERVZUWVBFX18mYnJhbmQ9X19CUkFORF9fJm1vZGVsPV9fTU9ERUxfXyZyZXNvbHV0aW9uPV9fUkVTT0xVVElPTl9fJnNjcmVlblNpemU9X19TQ1JFRU5TSVpFX18mbGFuZ3VhZ2U9X19MQU5HVUFHRV9fJmRlbnNpdHk9X19ERU5TSVRZX18mcm9vdD1fX1JPT1RfXyZuZXQ9X19ORVRfXyZpc3A9X19JU1BfXyZiYXR0ZXJ5PV9fQkFUVEVSWV9fJmRldmVsb3Blck1vZGU9X19ERVZFTE9QRVJNT0RFX18maXNVc2I9X19JU1VTQl9fJmlzRGVidWdBcGs9X19JU0RFQlVHQVBLX18maXNEZWJ1Z0Nvbm5lY3RlZD1fX0lTREVCVUdDT05ORUNURURfXyZkZWJ1Z1N5c3RlbT1fX0RFQlVHU1lTVEVNX18maXNXaWZpUHJveHk9X19JU1dJRklQUk9YWV9fJmlzQmx1ZXRvb3RoPV9fSVNCTFVFVE9PVEhfXyZpc0NhbWVyYT1fX0lTQ0FNRVJBX18maXNMb2NrU2NyZWVuPV9fSVNMT0NLU0NSRUVOX18mbmVpZ2hib3JpbmdMYWM9X19ORUlHSEJPUklOR0xBQ19fJmlzVnBuPV9fSVNWUE5fXyZpc1NpbXVsYXRvcj1fX0lTU0lNVUxBVE9SX18mY29uZmlnVmVyc2lvbj1fX0NPTkZJR1ZFUlNJT05fXyZjb25maWd1cmF0b3JDb25maWdWZXJzaW9uPV9fQ09ORklHVVJBVE9SQ09ORklHVkVSU0lPTl9fJm1lc3NlbmdlckNvbmZpZ1ZlcnNpb249X19NRVNTRU5HRVJDT05GSUdWRVJTSU9OX18mYmFubmVyRXhjdXRvckZvckxpZVlpbmdDb25maWdWZXJzaW9uPV9fQkFOTkVSRVhDVVRPUkZPUkxJRVlJTkdDT05GSUdWRVJTSU9OX18maHJDb25maWdWZXJzaW9uPV9fSFJDT05GSUdWRVJTSU9OX18mbWFuYWdlckNvbmZpZ1ZlcnNpb249X19NQU5BR0VSQ09ORklHVkVSU0lPTl9fJmxvZ1ZlcnNpb249X19MT0dWRVJTSU9OX18mZXZlbnRUaW1lPV9fRVZFTlRUSU1FX18mdXBsb2FkdGltZT1fX1VQTE9BRFRJTUVfXyZTZXNzaW9uSUQ9X19TRVNTSU9OSURfXyZldmVudElEPV9fRVZFTlRJRF9fJmV2ZW50Q29kZT1fX0VWRU5UQ09ERV9fJmFkVHlwZT1fX0FEVFlQRV9fJnJlc2VydmVUaW1lPV9fUkVTRVJWRVRJTUVfXyZhZHhJRD1fX0FEWElEX18mYWRQb3NpdGlvbklkPV9fQURQT1NJVElPTklEX18mT0FJRD1fX09BSURfXyZHQUlEPV9fR0FJRF9fJl9fRVJSSU5GT19fJmFwcFN0YXJ0PV9fQVBQU1RBUlRfXyZhcHBJbml0PV9fQVBQU0RLSU5JVF9fJmFwcFNwbGFzaFJlcXVlc3Q9X19BUFBTUExBU0hSRVFVRVNUX18=");
                if (TextUtils.isEmpty(a6)) {
                    return null;
                }
                if (BeiZis.getTransferProtocol()) {
                    a6 = a6.replace("http:", "https:");
                }
            } else {
                a6 = strArr[0];
            }
            int indexOf = a6.indexOf("?");
            String substring = a6.substring(0, indexOf);
            String a7 = com.beizi.fusion.tool.b.a(y.a(), t.a(ao.a(this.f13826a, a6.substring(indexOf + 1), null)));
            if (a7 != null) {
                String a8 = v.a(substring, a7.getBytes());
                if (!TextUtils.isEmpty(a8)) {
                    JSONObject jSONObject = new JSONObject(a8);
                    if (jSONObject.optInt("code") == 200) {
                        an.a(this.f13826a, "lastUpdateTime", (Object) Long.valueOf(System.currentTimeMillis()));
                        String optString = jSONObject.optString("data");
                        if (!TextUtils.isEmpty(optString) && !optString.equalsIgnoreCase("null") && !optString.equals("{}")) {
                            return new a(this.f13826a, optString);
                        }
                    }
                }
            }
        } catch (Error e6) {
            e6.printStackTrace();
        } catch (RuntimeException e7) {
            e7.printStackTrace();
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        return null;
    }

    c(Context context, b bVar) {
        try {
            this.f13826a = context;
            this.f13827b = bVar;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(a aVar) {
        if (aVar != null && aVar.a()) {
            this.f13827b.a(aVar);
            return;
        }
        b bVar = this.f13827b;
        if (bVar != null) {
            bVar.a(1000);
        }
    }
}
