package xyz.adscope.common.v2.dev.oaid.cn.oa.helpers;

import android.content.Context;
import java.lang.reflect.Method;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class XiaomiDeviceIDHelper {
    private static final String TAG = "XiaomiDeviceIDHelper";
    private Object idImpl;
    private Class idProvider;
    private Context mContext;
    private Method oaid;

    private String invokeMethod(Context context, Method method) {
        Object obj = this.idImpl;
        if (obj == null || method == null) {
            return null;
        }
        try {
            return (String) method.invoke(obj, context);
        } catch (Exception e6) {
            SDKLog.stack(e6);
            return null;
        }
    }

    public String getOAID() {
        return invokeMethod(this.mContext, this.oaid);
    }

    public XiaomiDeviceIDHelper(Context context) {
        this.mContext = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.idProvider = cls;
            this.idImpl = cls.newInstance();
        } catch (Exception e6) {
            SDKLog.stack(e6);
        }
        try {
            this.oaid = this.idProvider.getMethod("getOAID", Context.class);
        } catch (Exception e7) {
            SDKLog.stack(e7);
        }
    }
}
