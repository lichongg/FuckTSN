package com.kwad.sdk.b;

import android.content.Context;
import com.kuaishou.weapon.p0.WeaponHI;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    public static void init(Context context) {
        if (com.kwad.framework.a.a.MW.booleanValue()) {
            try {
                WeaponHI.init(context, new b());
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }
}
