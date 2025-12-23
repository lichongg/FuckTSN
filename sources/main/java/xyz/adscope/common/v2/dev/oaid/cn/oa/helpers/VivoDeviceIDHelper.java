package xyz.adscope.common.v2.dev.oaid.cn.oa.helpers;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.acse.ottn.l3;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class VivoDeviceIDHelper {
    private static final String TAG = "VivoDeviceIDHelper";
    private Handler handler;
    private HandlerThread handlerThread;
    private Context mConetxt;
    private boolean isSupportIds = false;
    String oaid = null;

    /* JADX INFO: Access modifiers changed from: private */
    public String getContentResolver(int i6, String str) {
        Cursor query = this.mConetxt.getContentResolver().query(i6 != 0 ? null : Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
        if (query != null) {
            r8 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
            query.close();
        }
        return r8;
    }

    private void f() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        this.handlerThread = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.handlerThread.getLooper()) { // from class: xyz.adscope.common.v2.dev.oaid.cn.oa.helpers.VivoDeviceIDHelper.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 11) {
                    VivoDeviceIDHelper.this.getContentResolver(message.getData().getInt("type"), message.getData().getString("appid"));
                }
            }
        };
    }

    private boolean isSupportIds() {
        boolean equals = sysProperty("persist.sys.identifierid.supported", "0").equals("1");
        this.isSupportIds = equals;
        return equals;
    }

    private String sysProperty(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(l3.f4736f, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e6) {
            SDKLog.stack(e6);
            return str2;
        }
    }

    private void timeCheck(int i6, String str) {
        Message obtainMessage = this.handler.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", 0);
        if (i6 == 1 || i6 == 2) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        this.handler.sendMessage(obtainMessage);
    }

    public String getOaid() {
        Cursor query = this.mConetxt.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
        if (query != null) {
            r1 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
            query.close();
        }
        return r1;
    }

    public VivoDeviceIDHelper(Context context) {
        this.mConetxt = context;
    }

    public String loge() {
        f();
        isSupportIds();
        if (!this.isSupportIds || this.oaid != null) {
            return null;
        }
        timeCheck(0, null);
        return null;
    }
}
