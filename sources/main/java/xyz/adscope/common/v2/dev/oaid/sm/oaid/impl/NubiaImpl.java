package xyz.adscope.common.v2.dev.oaid.sm.oaid.impl;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.provider.c;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDException;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class NubiaImpl implements IOAID {
    private final Context context;

    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        if (!supported()) {
            OAIDLog.print("Only supports Android 10.0 and above for Nubia");
            iGetter.onOAIDGetError(new OAIDException("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient acquireContentProviderClient = this.context.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (acquireContentProviderClient == null) {
                return;
            }
            Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            if (Build.VERSION.SDK_INT >= 24) {
                c.a(acquireContentProviderClient);
            } else {
                acquireContentProviderClient.release();
            }
            if (call == null) {
                throw new OAIDException("OAID query failed: bundle is null");
            }
            String string = call.getInt("code", -1) == 0 ? call.getString("id") : null;
            if (string == null || string.length() == 0) {
                throw new OAIDException("OAID query failed: " + call.getString(CrashHianalyticsData.MESSAGE));
            }
            OAIDLog.print("OAID query success: " + string);
            iGetter.onOAIDGetComplete(string);
        } catch (Exception e6) {
            OAIDLog.print(e6);
            iGetter.onOAIDGetError(e6);
        }
    }

    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID
    @SuppressLint({"AnnotateVersionCheck"})
    public boolean supported() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public NubiaImpl(Context context) {
        this.context = context;
    }
}
