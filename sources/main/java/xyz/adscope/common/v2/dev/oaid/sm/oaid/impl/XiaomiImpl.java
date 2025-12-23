package xyz.adscope.common.v2.dev.oaid.sm.oaid.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDException;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class XiaomiImpl implements IOAID {
    private final Context context;
    private Class<?> idProviderClass;
    private Object idProviderImpl;

    private String getOAID() {
        return (String) this.idProviderClass.getMethod("getOAID", Context.class).invoke(this.idProviderImpl, this.context);
    }

    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        if (this.idProviderClass == null || this.idProviderImpl == null) {
            iGetter.onOAIDGetError(new OAIDException("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String oaid = getOAID();
            if (oaid == null || oaid.length() == 0) {
                throw new OAIDException("OAID query failed");
            }
            OAIDLog.print("OAID query success: " + oaid);
            iGetter.onOAIDGetComplete(oaid);
        } catch (Exception e6) {
            OAIDLog.print(e6);
            iGetter.onOAIDGetError(e6);
        }
    }

    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID
    public boolean supported() {
        return this.idProviderImpl != null;
    }

    @SuppressLint({"PrivateApi"})
    public XiaomiImpl(Context context) {
        this.context = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.idProviderClass = cls;
            this.idProviderImpl = cls.newInstance();
        } catch (Exception e6) {
            OAIDLog.print(e6);
        }
    }
}
