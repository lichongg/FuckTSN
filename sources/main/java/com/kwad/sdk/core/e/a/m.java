package com.kwad.sdk.core.e.a;

import android.content.Context;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class m {
    private Context mContext;

    public final String getOAID() {
        String str;
        Exception e6;
        try {
            str = (String) i.callMethod(i.newInstance("com.android.id.impl.IdProviderImpl", new Object[0]), "getOAID", this.mContext);
            try {
                com.kwad.sdk.core.d.c.i("XiaomiDeviceIDHelper", "getOAID oaid:" + str);
                return str;
            } catch (Exception e7) {
                e6 = e7;
                com.kwad.sdk.core.d.c.i("XiaomiDeviceIDHelper", "getOAID fail");
                com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
                return str;
            }
        } catch (Exception e8) {
            str = "";
            e6 = e8;
        }
    }

    public m(Context context) {
        this.mContext = context;
    }
}
