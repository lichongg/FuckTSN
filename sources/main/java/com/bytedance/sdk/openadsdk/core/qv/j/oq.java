package com.bytedance.sdk.openadsdk.core.qv.j;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.core.qv.j.m;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq implements ITTDownloadVisitor {
    public static final String EXTRA_DOWN_INFO_KEY = "open_ad_sdk_download_extra";

    private boolean isPangolinDownloadReport(TTDownloadEventModel tTDownloadEventModel) {
        JSONObject extJson;
        if (tTDownloadEventModel == null || (extJson = tTDownloadEventModel.getExtJson()) == null) {
            return false;
        }
        String optString = extJson.optString("ad_extra_data");
        if (TextUtils.isEmpty(optString)) {
            return false;
        }
        try {
            return new JSONObject(optString).optJSONObject(EXTRA_DOWN_INFO_KEY) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public TTDownloadEventLogger getTTDownloadEventLogger() {
        return null;
    }

    public void postBody(String str, byte[] bArr, String str2, ITTHttpCallback iTTHttpCallback) {
        ae.postBody(str, bArr, str2, 0, iTTHttpCallback);
    }

    public static ITTDownloadVisitor create() {
        return new oq();
    }

    public void checkAutoControl(JSONObject jSONObject, String str) {
        com.bytedance.sdk.openadsdk.core.qv.cw.xt.j j6;
        n nVar;
        JSONObject optJSONObject = jSONObject.optJSONObject(EXTRA_DOWN_INFO_KEY);
        if (optJSONObject == null || !ed.j() || (j6 = com.bytedance.sdk.openadsdk.core.qv.cw.xt.j.j(optJSONObject)) == null || (nVar = j6.f29940j) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.qv.g.j(str, nVar);
    }

    private oq() {
    }

    public void clearAllData(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.bytedance.sdk.component.utils.m.cw(new File(str));
        }
    }

    public void execute(int i6, String str, Map<String, Object> map, ITTHttpCallback iTTHttpCallback) {
        ae.execute(i6, str, map, iTTHttpCallback);
    }

    public void executeLogUpload(TTDownloadEventModel tTDownloadEventModel, boolean z5) {
        if (isPangolinDownloadReport(tTDownloadEventModel)) {
            try {
                com.bytedance.sdk.component.oq.ae.j(m.j.build(tTDownloadEventModel, z5), 5);
            } catch (Throwable unused) {
            }
        }
    }

    public boolean getAppIsBackground() {
        return com.bytedance.sdk.openadsdk.core.oq.i().j();
    }

    public JSONObject getDownloadSettings() {
        JSONObject xt = com.bytedance.sdk.openadsdk.core.qv.g.xt();
        try {
            if (!v.xt().a()) {
                xt.put("enable_app_install_receiver", 0);
            }
        } catch (Exception unused) {
        }
        return xt;
    }

    public boolean hasPermission(Context context, String str) {
        return g.hasPermission(context, str);
    }

    public String initPath(boolean z5) {
        return com.bytedance.sdk.openadsdk.core.qv.g.j(z5);
    }

    public boolean isOpenSdkEvent(String str) {
        return com.bytedance.sdk.openadsdk.core.qv.r.g.j(str);
    }

    public void requestPermission(Activity activity, String[] strArr, ITTPermissionCallback iTTPermissionCallback) {
        g.requestPermission(activity, strArr, iTTPermissionCallback);
    }

    public void showDialogByDelegate(WeakReference<Context> weakReference, boolean z5, DialogBuilder dialogBuilder) {
        tl.showDialogByDelegate(weakReference, z5, dialogBuilder);
    }

    public AlertDialog showDialogBySelf(Activity activity, boolean z5, DialogBuilder dialogBuilder) {
        return tl.showDialogBySelf(activity, z5, dialogBuilder);
    }
}
