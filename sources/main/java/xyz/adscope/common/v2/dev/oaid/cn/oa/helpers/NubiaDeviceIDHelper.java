package xyz.adscope.common.v2.dev.oaid.cn.oa.helpers;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.provider.c;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class NubiaDeviceIDHelper {
    private static final String TAG = "NubiaDeviceIDHelper";
    private Context mConetxt;

    public String getNubiaID() {
        Uri parse = Uri.parse("content://cn.nubia.identity/identity");
        try {
            int i6 = Build.VERSION.SDK_INT;
            ContentProviderClient acquireContentProviderClient = this.mConetxt.getContentResolver().acquireContentProviderClient(parse);
            Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            if (i6 >= 24) {
                c.a(acquireContentProviderClient);
            } else {
                acquireContentProviderClient.release();
            }
            if (call.getInt("code", -1) == 0) {
                return call.getString("id");
            }
            call.getString(CrashHianalyticsData.MESSAGE);
            return null;
        } catch (Exception e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    public NubiaDeviceIDHelper(Context context) {
        this.mConetxt = context;
    }
}
