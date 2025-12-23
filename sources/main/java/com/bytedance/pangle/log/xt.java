package com.bytedance.pangle.log;

import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.up.r;
import com.bytedance.pangle.util.vl;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    public static void j(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (jSONObject3 == null) {
            jSONObject3 = new JSONObject();
        }
        String j6 = Zeus.getAppApplication() != null ? r.j(r.j(Zeus.getAppApplication())) : null;
        String packageName = Zeus.getAppApplication() != null ? Zeus.getAppApplication().getPackageName() : "";
        if (j6 == null) {
            j6 = "unknown";
        }
        try {
            jSONObject.putOpt(ContentProviderManager.PLUGIN_PROCESS_NAME, j(j6));
            jSONObject.putOpt("host_package_name", packageName);
            Plugin plugin = Zeus.getPlugin(jSONObject.optString("plugin_package_name", ""), false);
            jSONObject.putOpt("plugin_api_version", j(Integer.valueOf(plugin != null ? plugin.getApiVersionCode() : -1)));
            jSONObject.putOpt("zeus_sdk_version", j("0.0.1-beta.4200.115-bugfix.33"));
            ZeusLogger.v(ZeusLogger.TAG_REPORTER, "eventName: " + str + "\ncategoryData:" + jSONObject.toString(1) + "\nmetricData:" + jSONObject2.toString(1) + "\nlogExtrData:" + jSONObject3.toString(1));
            IZeusReporter reporter = GlobalParam.getInstance().getReporter();
            if (reporter != null) {
                JSONObject jSONObject4 = new JSONObject();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject4.putOpt(next, jSONObject.opt(next));
                }
                Iterator<String> keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    jSONObject4.putOpt(next2, jSONObject2.opt(next2));
                }
                Iterator<String> keys3 = jSONObject3.keys();
                while (keys3.hasNext()) {
                    String next3 = keys3.next();
                    jSONObject4.putOpt(next3, jSONObject3.opt(next3));
                }
                reporter.report(str, jSONObject4);
            }
        } catch (JSONException e6) {
            ZeusLogger.w(ZeusLogger.TAG_REPORTER, e6.getMessage(), e6);
        }
    }

    public static int xt(Object obj) {
        if (obj == null) {
            return -1;
        }
        return vl.j(obj.toString(), -1);
    }

    public static String j(Object obj) {
        if (obj == null) {
            return "";
        }
        return obj.toString();
    }

    public static String j(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
