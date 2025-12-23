package com.kwad.sdk.liteapi.oaid.helpers;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.Keep;
import com.kwad.sdk.liteapi.LiteApiLogger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class MeizuDeviceIDHelper {
    private static final String TAG = "MeizuDeviceIDHelper";
    private Context mContext;

    private boolean isMeizuSupport() {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            if (packageManager != null) {
                if (packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null) {
                    return true;
                }
            }
        } catch (Exception e6) {
            LiteApiLogger.printStackTrace(e6);
        }
        return false;
    }

    private String getOaid(Cursor cursor) {
        String str;
        str = "";
        if (cursor != null && !cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            str = columnIndex > 0 ? cursor.getString(columnIndex) : "";
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 > 0) {
                cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 > 0) {
                cursor.getLong(columnIndex3);
            }
        }
        return str;
    }

    public String getOAID() {
        String str = "";
        Cursor cursor = null;
        try {
            try {
                cursor = this.mContext.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
                str = getOaid(cursor);
                LiteApiLogger.i(TAG, "getOAID oaid:" + str);
                return str;
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    OaidInnerUtils.closeQuietly(cursor);
                    return str;
                } finally {
                    OaidInnerUtils.closeQuietly(cursor);
                }
            }
        } catch (Exception e6) {
            LiteApiLogger.i(TAG, "getOAID service not found;");
            LiteApiLogger.printStackTrace(e6);
        }
    }

    public MeizuDeviceIDHelper(Context context) {
        this.mContext = context;
    }
}
