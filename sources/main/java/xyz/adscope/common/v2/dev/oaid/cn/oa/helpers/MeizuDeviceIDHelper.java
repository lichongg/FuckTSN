package xyz.adscope.common.v2.dev.oaid.cn.oa.helpers;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import xyz.adscope.common.v2.dev.oaid.cn.oa.helpers.DevicesIDsHelper;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class MeizuDeviceIDHelper {
    private static final String TAG = "MeizuDeviceIDHelper";
    private Context mContext;

    private String getOaid(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        String string = columnIndex > 0 ? cursor.getString(columnIndex) : null;
        int columnIndex2 = cursor.getColumnIndex("code");
        if (columnIndex2 > 0) {
            cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex("expired");
        if (columnIndex3 > 0) {
            cursor.getLong(columnIndex3);
        }
        return string;
    }

    private boolean isMeizuSupport() {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            if (packageManager != null) {
                return packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void getMeizuID(DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        try {
            this.mContext.getPackageManager().getPackageInfo("com.meizu.flyme.openidsdk", 0);
        } catch (Exception e6) {
            SDKLog.stack(e6);
        }
        try {
            Cursor query = this.mContext.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            String oaid = getOaid(query);
            if (appIdsUpdater != null) {
                appIdsUpdater.OnIdsValid(oaid);
            }
            query.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public MeizuDeviceIDHelper(Context context) {
        this.mContext = context;
    }
}
