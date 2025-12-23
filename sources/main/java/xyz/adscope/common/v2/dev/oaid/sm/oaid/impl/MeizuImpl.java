package xyz.adscope.common.v2.dev.oaid.sm.oaid.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.Objects;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDException;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class MeizuImpl implements IOAID {
    private final Context context;

    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        try {
            Cursor query = this.context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            try {
                Objects.requireNonNull(query);
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex("value"));
                if (string == null || string.length() == 0) {
                    throw new OAIDException("OAID query failed");
                }
                OAIDLog.print("OAID query success: " + string);
                iGetter.onOAIDGetComplete(string);
                query.close();
            } finally {
            }
        } catch (Exception e6) {
            OAIDLog.print(e6);
            iGetter.onOAIDGetError(e6);
        }
    }

    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID
    public boolean supported() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception e6) {
            OAIDLog.print(e6);
            return false;
        }
    }

    public MeizuImpl(Context context) {
        this.context = context;
    }
}
