package com.bytedance.pangle.cw;

import android.text.TextUtils;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.oq;
import com.bytedance.pangle.util.m;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    private String ae;
    private JSONObject cw;

    /* renamed from: j, reason: collision with root package name */
    private String f25386j;

    /* renamed from: m, reason: collision with root package name */
    private JSONObject f25387m;

    /* renamed from: r, reason: collision with root package name */
    private List<File> f25388r;
    private File up;
    private String xt;

    public static j j(JSONObject jSONObject, File file, List<File> list) {
        j jVar = new j();
        jVar.f25386j = jSONObject.optString("version");
        jVar.xt = jSONObject.optString(bi.f40972o);
        jVar.cw = jSONObject.optJSONObject("adn_adapter_md5");
        jVar.ae = jSONObject.optString("alias_package_name");
        jVar.f25388r = list;
        jVar.up = file;
        jVar.f25387m = jSONObject;
        return jVar;
    }

    private boolean g() {
        JSONObject jSONObject;
        List<File> list = this.f25388r;
        boolean z5 = false;
        if (list == null || list.size() == 0 || (jSONObject = this.cw) == null || jSONObject.length() == 0) {
            StringBuilder sb = new StringBuilder("DexPluginConfig check md5 fail, packageName=");
            sb.append(this.xt);
            sb.append(" dexlist is ");
            sb.append(this.f25388r);
            sb.append(" dexlist size is ");
            List<File> list2 = this.f25388r;
            sb.append(list2 == null ? -1 : list2.size());
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, sb.toString());
            return false;
        }
        int size = this.f25388r.size();
        int length = this.cw.length();
        for (File file : this.f25388r) {
            String j6 = m.j(file);
            if (j6 != null) {
                j6 = j6.toLowerCase();
            }
            String j7 = j(file.getName());
            if (TextUtils.equals(j7, j6)) {
                size--;
                length--;
            } else {
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginConfig check md5 fail, packageName=" + this.xt + "downloadFileMd5=" + j6 + " configMd5=" + j7);
            }
        }
        if (size == 0 && length == 0) {
            z5 = true;
        }
        StringBuilder sb2 = new StringBuilder("DexPluginConfig check md5 ");
        sb2.append(z5 ? "success" : CommonNetImpl.FAIL);
        sb2.append(", packageName=");
        sb2.append(this.xt);
        sb2.append(" fileSize=");
        sb2.append(size);
        sb2.append(" configFileSize=");
        sb2.append(length);
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, sb2.toString());
        return z5;
    }

    public String ae() {
        return this.ae;
    }

    public int cw() {
        if (TextUtils.isEmpty(this.f25386j)) {
            return -1;
        }
        String replace = this.f25386j.replace(".", "");
        if (TextUtils.isEmpty(replace)) {
            return -1;
        }
        try {
            return Integer.valueOf(replace).intValue();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public JSONObject m() {
        return this.f25387m;
    }

    public List<File> r() {
        return this.f25388r;
    }

    public String toString() {
        return "DexPluginConfig{mVersion='" + this.f25386j + "', mPackageName='" + this.xt + "'}";
    }

    public File up() {
        return this.up;
    }

    public String xt() {
        return this.xt;
    }

    private boolean tl() {
        JSONObject jSONObject;
        Map<String, JSONObject> up = oq.j().up();
        if (up != null && up.size() > 0 && (jSONObject = up.get(this.xt)) != null && jSONObject.has(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME) && TextUtils.equals(jSONObject.optString(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME), this.xt)) {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginConfig check packageName success , packageName=" + this.xt);
            return true;
        }
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginConfig check packageName fail, packageName=" + this.xt + ", packageManager=" + up);
        return false;
    }

    public boolean j() {
        return tl() && g();
    }

    public String j(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str) && (jSONObject = this.cw) != null && jSONObject.has(str)) {
            return this.cw.optString(str);
        }
        return "";
    }
}
