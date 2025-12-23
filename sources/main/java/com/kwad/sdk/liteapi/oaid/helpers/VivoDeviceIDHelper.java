package com.kwad.sdk.liteapi.oaid.helpers;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.Keep;
import com.kwad.sdk.liteapi.LiteApiLogger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class VivoDeviceIDHelper {
    private static final String TAG = "VivoDeviceIDHelper";
    private Context mContext;

    public String getOAID() {
        String str = "";
        Cursor cursor = null;
        try {
            cursor = this.mContext.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (cursor != null && cursor.moveToNext()) {
                str = cursor.getString(cursor.getColumnIndex("value"));
                LiteApiLogger.i(TAG, "getOAID oaid:" + str);
            }
            return str;
        } catch (Exception e6) {
            LiteApiLogger.i(TAG, "getOAID fail");
            LiteApiLogger.printStackTraceOnly(e6);
            return str;
        } finally {
            OaidInnerUtils.closeQuietly(cursor);
        }
    }

    public VivoDeviceIDHelper(Context context) {
        this.mContext = context;
    }
}
