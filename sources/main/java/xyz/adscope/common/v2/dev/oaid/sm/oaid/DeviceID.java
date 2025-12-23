package xyz.adscope.common.v2.dev.oaid.sm.oaid;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.impl.OAIDFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class DeviceID implements IGetter {
    private Application application;
    private String gaid;
    private String oaid;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.dev.oaid.sm.oaid.DeviceID$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* synthetic */ DeviceID(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static String getOAID() {
        String str = Holder.INSTANCE.oaid;
        return str == null ? "" : str;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class Holder {
        static final DeviceID INSTANCE = new DeviceID(null);

        private Holder() {
        }
    }

    private DeviceID() {
    }

    public static void register(Application application) {
        if (application == null) {
            return;
        }
        DeviceID deviceID = Holder.INSTANCE;
        deviceID.application = application;
        getOAID(application, deviceID);
    }

    public static void getGAID(Context context, IGetter iGetter) {
        OAIDFactory.createGaid(context).doGet(iGetter);
    }

    public static void getOAID(Context context, IGetter iGetter) {
        OAIDFactory.create(context).doGet(iGetter);
    }

    public static boolean supportedOAID(Context context) {
        return OAIDFactory.create(context).supported();
    }

    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter
    public void onOAIDGetComplete(String str) {
        if (TextUtils.isEmpty(str)) {
            onOAIDGetError(new OAIDException("OAID is empty"));
        } else {
            this.oaid = str;
        }
    }

    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter
    public void onOAIDGetError(Exception exc) {
    }
}
