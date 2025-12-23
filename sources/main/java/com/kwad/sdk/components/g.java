package com.kwad.sdk.components;

import com.kwad.sdk.components.DevelopMangerComponents;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g {
    public static boolean encryptDisable() {
        return df("KEY_HOST_ENCRYPT_DISABLE");
    }

    public static boolean df(String str) {
        DevelopMangerComponents.DevelopValue de = d.de(str);
        if (de != null && ((Boolean) de.getValue()).booleanValue()) {
            return true;
        }
        return false;
    }
}
