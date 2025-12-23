package cn.jiguang.bz;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bn;
import com.umeng.analytics.pro.bi;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static String f2727a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f2728b = "";

    public static JSONObject a(Context context) {
        StringBuilder sb;
        String str;
        if (context == null) {
            cn.jiguang.bb.f.i("JDeviceHelper", "when getDInfo, context can't be null");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String k6 = a.a().k(context);
            String a6 = cn.jiguang.u.a.a(context);
            if (TextUtils.isEmpty(k6)) {
                k6 = "";
            }
            jSONObject.put("resolution", k6);
            if (TextUtils.isEmpty(a6)) {
                a6 = "";
            }
            jSONObject.put("screensize", a6);
            jSONObject.put("os_version", a.a().D(context));
            jSONObject.put(bn.f10753i, a.a().y(context));
            jSONObject.put(bn.f10754j, a.a().z(context));
            jSONObject.put("product", a.a().t(context));
            jSONObject.put("language", a.a().A(context));
            jSONObject.put("manufacturer", a.a().B(context));
            jSONObject.put(bi.M, a.a().C(context));
            return jSONObject;
        } catch (JSONException e6) {
            e = e6;
            sb = new StringBuilder();
            str = "package json exception: ";
            sb.append(str);
            sb.append(e.getMessage());
            cn.jiguang.bb.f.i("JDeviceHelper", sb.toString());
            return null;
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder();
            str = "getDInfo exception: ";
            sb.append(str);
            sb.append(e.getMessage());
            cn.jiguang.bb.f.i("JDeviceHelper", sb.toString());
            return null;
        }
    }
}
