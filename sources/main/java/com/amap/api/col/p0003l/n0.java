package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import master.flame.danmaku.danmaku.parser.b;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@hk(a = "update_item", b = true)
/* loaded from: D:\Downloads\app\classes2.dex */
public class n0 extends q0 {

    /* renamed from: n, reason: collision with root package name */
    private String f6790n = "";

    /* renamed from: o, reason: collision with root package name */
    private Context f6791o;

    public n0() {
    }

    private static String l(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject == null || !jSONObject.has(str) || "[]".equals(jSONObject.getString(str))) ? "" : jSONObject.optString(str).trim();
    }

    private void p() {
        this.f6939d = b3.f0(this.f6791o) + this.f6948m + ".zip.tmp";
    }

    public final String k() {
        return this.f6790n;
    }

    public final void m(String str) {
        this.f6790n = str;
    }

    public final void n() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("title", this.f6936a);
            jSONObject2.put("code", this.f6938c);
            jSONObject2.put("url", this.f6937b);
            jSONObject2.put("fileName", this.f6939d);
            jSONObject2.put("lLocalLength", this.f6941f);
            jSONObject2.put("lRemoteLength", this.f6942g);
            jSONObject2.put("mState", this.f6947l);
            jSONObject2.put("version", this.f6940e);
            jSONObject2.put("localPath", this.f6943h);
            String str = this.f6790n;
            if (str != null) {
                jSONObject2.put("vMapFileNames", str);
            }
            jSONObject2.put("isSheng", this.f6944i);
            jSONObject2.put("mCompleteCode", this.f6945j);
            jSONObject2.put("mCityCode", this.f6946k);
            jSONObject2.put("pinyin", this.f6948m);
            jSONObject.put(b.f50156c, jSONObject2);
            File file = new File(this.f6939d + ".dt");
            file.delete();
            OutputStreamWriter outputStreamWriter = null;
            try {
                try {
                    try {
                        OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file, true), "utf-8");
                        try {
                            outputStreamWriter2.write(jSONObject.toString());
                            outputStreamWriter2.close();
                        } catch (IOException e6) {
                            e = e6;
                            outputStreamWriter = outputStreamWriter2;
                            v5.p(e, "UpdateItem", "saveJSONObjectToFile");
                            e.printStackTrace();
                            if (outputStreamWriter != null) {
                                outputStreamWriter.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            outputStreamWriter = outputStreamWriter2;
                            if (outputStreamWriter != null) {
                                try {
                                    outputStreamWriter.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e8) {
                    e = e8;
                }
            } catch (IOException e9) {
                e9.printStackTrace();
            }
        } catch (Throwable th3) {
            v5.p(th3, "UpdateItem", "saveJSONObjectToFile parseJson");
            th3.printStackTrace();
        }
    }

    public final void o(String str) {
        JSONObject jSONObject;
        if (str != null) {
            try {
                if (!"".equals(str) && (jSONObject = new JSONObject(str).getJSONObject(b.f50156c)) != null) {
                    this.f6936a = jSONObject.optString("title");
                    this.f6938c = jSONObject.optString("code");
                    this.f6937b = jSONObject.optString("url");
                    this.f6939d = jSONObject.optString("fileName");
                    this.f6941f = jSONObject.optLong("lLocalLength");
                    this.f6942g = jSONObject.optLong("lRemoteLength");
                    this.f6947l = jSONObject.optInt("mState");
                    this.f6940e = jSONObject.optString("version");
                    this.f6943h = jSONObject.optString("localPath");
                    this.f6790n = jSONObject.optString("vMapFileNames");
                    this.f6944i = jSONObject.optInt("isSheng");
                    this.f6945j = jSONObject.optInt("mCompleteCode");
                    this.f6946k = jSONObject.optString("mCityCode");
                    String l6 = l(jSONObject, "pinyin");
                    this.f6948m = l6;
                    if ("".equals(l6)) {
                        String str2 = this.f6937b;
                        String substring = str2.substring(str2.lastIndexOf("/") + 1);
                        this.f6948m = substring.substring(0, substring.lastIndexOf("."));
                    }
                }
            } catch (Throwable th) {
                v5.p(th, "UpdateItem", "readFileToJSONObject");
                th.printStackTrace();
            }
        }
    }

    public n0(OfflineMapCity offlineMapCity, Context context) {
        this.f6791o = context;
        this.f6936a = offlineMapCity.getCity();
        this.f6938c = offlineMapCity.getAdcode();
        this.f6937b = offlineMapCity.getUrl();
        this.f6942g = offlineMapCity.getSize();
        this.f6940e = offlineMapCity.getVersion();
        this.f6946k = offlineMapCity.getCode();
        this.f6944i = 0;
        this.f6947l = offlineMapCity.getState();
        this.f6945j = offlineMapCity.getcompleteCode();
        this.f6948m = offlineMapCity.getPinyin();
        p();
    }

    public n0(OfflineMapProvince offlineMapProvince, Context context) {
        this.f6791o = context;
        this.f6936a = offlineMapProvince.getProvinceName();
        this.f6938c = offlineMapProvince.getProvinceCode();
        this.f6937b = offlineMapProvince.getUrl();
        this.f6942g = offlineMapProvince.getSize();
        this.f6940e = offlineMapProvince.getVersion();
        this.f6944i = 1;
        this.f6947l = offlineMapProvince.getState();
        this.f6945j = offlineMapProvince.getcompleteCode();
        this.f6948m = offlineMapProvince.getPinyin();
        p();
    }
}
