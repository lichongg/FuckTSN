package com.kwad.sdk.liteapi.oaid.helpers;

import android.content.Context;
import androidx.annotation.Keep;
import com.kwad.sdk.liteapi.LiteApiLogger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class XiaomiDeviceIDHelper {
    private static final String TAG = "XiaomiDeviceIDHelper";
    private Context mContext;

    public String getOAID() {
        String str;
        Exception e6;
        try {
            str = (String) OaidJavaCalls.callMethod(OaidJavaCalls.newInstance("com.android.id.impl.IdProviderImpl", new Object[0]), "getOAID", this.mContext);
            try {
                LiteApiLogger.i(TAG, "getOAID oaid:" + str);
                return str;
            } catch (Exception e7) {
                e6 = e7;
                LiteApiLogger.i(TAG, "getOAID fail");
                LiteApiLogger.printStackTraceOnly(e6);
                return str;
            }
        } catch (Exception e8) {
            str = "";
            e6 = e8;
        }
    }

    public XiaomiDeviceIDHelper(Context context) {
        this.mContext = context;
    }
}
