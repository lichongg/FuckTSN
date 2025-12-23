package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.meizu.flyme.openidsdk.OpenIdHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class bb implements av {
    @Override // com.umeng.analytics.pro.av
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean a6 = OpenIdHelper.a();
        bh.a("getOAID", "isSupported", Boolean.valueOf(a6));
        if (a6) {
            return OpenIdHelper.b(context);
        }
        return null;
    }

    bb() {
    }
}
