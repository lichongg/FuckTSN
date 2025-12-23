package com.kwad.sdk.utils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class k {
    public static void aq(String str, String str2) {
        com.kwad.sdk.core.d.c.d("callbackLog", str + str2);
    }

    public static void b(String str, String str2, String str3, String str4) {
        aq(str, str2 + "_" + str3 + "_" + str4);
    }

    public static void r(String str, int i6) {
        com.kwad.sdk.core.d.c.d("audioVideoLog", str + "_type_" + i6 + "_time_" + System.currentTimeMillis());
    }
}
