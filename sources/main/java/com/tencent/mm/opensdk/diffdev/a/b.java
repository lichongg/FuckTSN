package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.util.Base64;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b extends AsyncTask<Void, Void, a> {

    /* renamed from: a, reason: collision with root package name */
    private String f40414a;

    /* renamed from: b, reason: collision with root package name */
    private String f40415b;

    /* renamed from: c, reason: collision with root package name */
    private String f40416c;

    /* renamed from: d, reason: collision with root package name */
    private String f40417d;

    /* renamed from: e, reason: collision with root package name */
    private String f40418e;

    /* renamed from: f, reason: collision with root package name */
    private OAuthListener f40419f;

    /* renamed from: g, reason: collision with root package name */
    private c f40420g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        public OAuthErrCode f40421a;

        /* renamed from: b, reason: collision with root package name */
        public String f40422b;

        /* renamed from: c, reason: collision with root package name */
        public String f40423c;

        /* renamed from: d, reason: collision with root package name */
        public String f40424d;

        /* renamed from: e, reason: collision with root package name */
        public byte[] f40425e;

        public static a a(byte[] bArr) {
            OAuthErrCode oAuthErrCode;
            String format;
            a aVar = new a();
            if (bArr != null && bArr.length != 0) {
                try {
                } catch (Exception e6) {
                    format = String.format("parse fail, build String fail, ex = %s", e6.getMessage());
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                    int i6 = jSONObject.getInt(com.huawei.hms.feature.dynamic.b.f33209h);
                    if (i6 != 0) {
                        Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", Integer.valueOf(i6)));
                        aVar.f40421a = OAuthErrCode.WechatAuth_Err_NormalErr;
                        jSONObject.optString("errmsg");
                        return aVar;
                    }
                    String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                    if (string != null && string.length() != 0) {
                        byte[] decode = Base64.decode(string, 0);
                        if (decode != null && decode.length != 0) {
                            aVar.f40421a = OAuthErrCode.WechatAuth_Err_OK;
                            aVar.f40425e = decode;
                            aVar.f40422b = jSONObject.getString("uuid");
                            String string2 = jSONObject.getString("appname");
                            aVar.f40423c = string2;
                            Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", aVar.f40422b, string2, Integer.valueOf(aVar.f40425e.length)));
                            return aVar;
                        }
                        Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                        aVar.f40421a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        return aVar;
                    }
                    Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                    aVar.f40421a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                    return aVar;
                } catch (Exception e7) {
                    format = String.format("parse json fail, ex = %s", e7.getMessage());
                    Log.e("MicroMsg.SDK.GetQRCodeResult", format);
                    oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                    aVar.f40421a = oAuthErrCode;
                    return aVar;
                }
            }
            Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            aVar.f40421a = oAuthErrCode;
            return aVar;
        }

        private a() {
        }
    }

    public boolean a() {
        Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        c cVar = this.f40420g;
        return cVar == null ? cancel(true) : cVar.cancel(true);
    }

    @Override // android.os.AsyncTask
    protected a doInBackground(Void[] voidArr) {
        Thread.currentThread().setName("OpenSdkGetQRCodeTask");
        Log.i("MicroMsg.SDK.GetQRCodeTask", "doInBackground");
        String format = String.format("https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s", this.f40414a, this.f40416c, this.f40417d, this.f40415b, this.f40418e);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] a6 = com.tencent.mm.opensdk.channel.a.a.a(format, 60000);
        Log.d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", format, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        return a.a(a6);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(a aVar) {
        a aVar2 = aVar;
        OAuthErrCode oAuthErrCode = aVar2.f40421a;
        if (oAuthErrCode != OAuthErrCode.WechatAuth_Err_OK) {
            Log.e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", oAuthErrCode));
            this.f40419f.onAuthFinish(aVar2.f40421a, null);
            return;
        }
        Log.d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success imgBufSize = " + aVar2.f40425e.length);
        this.f40419f.onAuthGotQrcode(aVar2.f40424d, aVar2.f40425e);
        c cVar = new c(aVar2.f40422b, this.f40419f);
        this.f40420g = cVar;
        cVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public b(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.f40414a = str;
        this.f40415b = str2;
        this.f40416c = str3;
        this.f40417d = str4;
        this.f40418e = str5;
        this.f40419f = oAuthListener;
    }
}
