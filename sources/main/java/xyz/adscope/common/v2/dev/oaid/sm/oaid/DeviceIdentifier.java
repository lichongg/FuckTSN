package xyz.adscope.common.v2.dev.oaid.sm.oaid;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class DeviceIdentifier {
    private static volatile String clientId;
    private static volatile String oaid;
    private static volatile boolean registered;

    public static String getOAID(Context context) {
        if (TextUtils.isEmpty(oaid)) {
            synchronized (DeviceIdentifier.class) {
                try {
                    if (TextUtils.isEmpty(oaid)) {
                        oaid = DeviceID.getOAID();
                        if (oaid != null) {
                            if (oaid.length() == 0) {
                            }
                        }
                        DeviceID.getOAID(context, new IGetter() { // from class: xyz.adscope.common.v2.dev.oaid.sm.oaid.DeviceIdentifier.1
                            @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter
                            public void onOAIDGetError(Exception exc) {
                                String unused = DeviceIdentifier.oaid = "";
                            }

                            @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter
                            public void onOAIDGetComplete(String str) {
                                String unused = DeviceIdentifier.oaid = str;
                            }
                        });
                    }
                } finally {
                }
            }
        }
        if (oaid == null) {
            oaid = "";
        }
        return oaid;
    }

    public static void register(Application application) {
        if (registered) {
            return;
        }
        synchronized (DeviceIdentifier.class) {
            try {
                if (!registered) {
                    DeviceID.register(application);
                    registered = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private DeviceIdentifier() {
    }
}
