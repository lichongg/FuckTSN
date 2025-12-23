package com.bytedance.sdk.component.panglearmor.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.panglearmor.SoftDecTool;
import com.bytedance.sdk.component.panglearmor.j.xt.m;
import com.bytedance.sdk.openadsdk.api.plugin.xt;
import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static j f26691j;
    private long xt = 0;

    public static j j() {
        if (f26691j == null) {
            synchronized (j.class) {
                try {
                    if (f26691j == null) {
                        j jVar = new j();
                        f26691j = jVar;
                        jVar.xt = 0L;
                    }
                } finally {
                }
            }
        }
        return f26691j;
    }

    private boolean xt() {
        return new SecureRandom().nextInt(10) == 1;
    }

    @DungeonFlag
    private boolean cw() {
        SharedPreferences sharedPreferences = SoftDecTool.getSharedPreferences(SoftDecTool.SP_NAME);
        if (sharedPreferences == null) {
            return false;
        }
        this.xt = (System.currentTimeMillis() / 1000) - SoftDecTool.fr();
        int i6 = sharedPreferences.getInt("hit_times", 0);
        if (i6 < 2 && this.xt >= 172800) {
            sharedPreferences.edit().putInt("hit_times", 2).apply();
            return xt();
        }
        if (i6 != 0 || this.xt < 21600) {
            return false;
        }
        sharedPreferences.edit().putInt("hit_times", 1).apply();
        return xt();
    }

    private String xt(Context context) {
        if (context == null) {
            return null;
        }
        String packageCodePath = context.getPackageCodePath();
        if (TextUtils.isEmpty(packageCodePath)) {
            return null;
        }
        File file = new File(packageCodePath);
        if (file.exists() && file.canRead()) {
            return packageCodePath;
        }
        return null;
    }

    public synchronized JSONObject j(Context context, String str) {
        String xt;
        JSONObject jSONObject = new JSONObject();
        try {
            xt = xt(context);
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(xt) && cw()) {
            File file = new File(xt);
            if (file.exists()) {
                jSONObject = j(file, context, str);
            }
            return jSONObject;
        }
        return null;
    }

    @DungeonFlag
    private JSONObject j(File file, Context context, String str) {
        JSONObject j6 = m.j(file);
        File j7 = xt.j(context);
        if (j7 != null) {
            m.j(j6, "files", j(!TextUtils.isEmpty(str) ? xt.j(context).getParent() : xt.j(context).getPath()), false);
            File parentFile = j7.getParentFile();
            if (parentFile != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(!TextUtils.isEmpty(str) ? parentFile.getParent() : parentFile.getPath());
                sb.append("/shared_prefs");
                List<String> j8 = j(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(!TextUtils.isEmpty(str) ? parentFile.getParent() : parentFile.getPath());
                sb2.append("/databases");
                List<String> j9 = j(sb2.toString());
                m.j(j6, "prefs", j8, false);
                m.j(j6, "databases", j9, false);
            }
        }
        try {
            JSONObject j10 = j(context);
            if (j10 != null && j10.length() > 0) {
                j6.put("manifest", j10);
            }
            j6.put("rt", this.xt);
            j6.put("path", str);
        } catch (JSONException unused) {
        }
        return j6;
    }

    private List<String> j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isFile() && file2.exists()) {
                    arrayList.add(file2.getName());
                }
            }
        }
        return arrayList;
    }

    private JSONObject j(Context context) {
        if (context == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String packageName = context.getPackageName();
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 4239);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                jSONObject.put("application_name", applicationInfo.name);
                jSONObject.put("label", packageManager.getApplicationLabel(applicationInfo));
            }
            if (packageInfo != null) {
                ActivityInfo[] activityInfoArr = packageInfo.activities;
                String[] strArr = packageInfo.requestedPermissions;
                ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                if (activityInfoArr != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        jSONArray.put(activityInfo.name);
                    }
                    jSONObject.put("activities", jSONArray);
                }
                if (strArr != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (String str : strArr) {
                        jSONArray2.put(str);
                    }
                    jSONObject.put("permissions", jSONArray2);
                }
                if (activityInfoArr2 != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (ActivityInfo activityInfo2 : activityInfoArr2) {
                        jSONArray3.put(activityInfo2.name);
                    }
                    jSONObject.put("receivers", jSONArray3);
                }
                if (serviceInfoArr != null) {
                    JSONArray jSONArray4 = new JSONArray();
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        jSONArray4.put(serviceInfo.name);
                    }
                    jSONObject.put("services", jSONArray4);
                }
                if (providerInfoArr != null) {
                    JSONArray jSONArray5 = new JSONArray();
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        jSONArray5.put(providerInfo.name);
                    }
                    jSONObject.put("providers", jSONArray5);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
