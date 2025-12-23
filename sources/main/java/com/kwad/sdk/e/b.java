package com.kwad.sdk.e;

import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b implements a {
    private static volatile b aRc;
    private static c aRd;

    public static void a(c cVar) {
        aRd = cVar;
    }

    public static synchronized b Mo() {
        b bVar;
        synchronized (b.class) {
            try {
                if (aRc == null) {
                    synchronized (b.class) {
                        try {
                            if (aRc == null) {
                                aRc = new b();
                            }
                        } finally {
                        }
                    }
                }
                bVar = aRc;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    private static String Mp() {
        return a(false, "", 2);
    }

    public static String a(boolean z5, Object obj, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("userSet", String.valueOf(z5));
        hashMap.put("value", obj);
        hashMap.put("errorCode", String.valueOf(i6));
        return new JSONObject(hashMap).toString();
    }

    @Override // com.kwad.sdk.e.a
    public final String Mc() {
        c cVar = aRd;
        return cVar != null ? cVar.Mc() : Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String Md() {
        c cVar = aRd;
        return cVar != null ? cVar.Md() : Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String Me() {
        c cVar = aRd;
        return cVar != null ? cVar.Me() : Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String Mf() {
        c cVar = aRd;
        return cVar != null ? cVar.Mf() : Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String Mg() {
        c cVar = aRd;
        return cVar != null ? cVar.Mg() : Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String Mh() {
        c cVar = aRd;
        return cVar != null ? cVar.Mh() : Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String Mi() {
        c cVar = aRd;
        return cVar != null ? cVar.Mi() : Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String Mj() {
        c cVar = aRd;
        return cVar != null ? cVar.Mj() : Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String Mk() {
        c cVar = aRd;
        return cVar != null ? cVar.Mk() : Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String Ml() {
        c cVar = aRd;
        return cVar != null ? cVar.Ml() : Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String Mm() {
        c cVar = aRd;
        return cVar != null ? cVar.Mm() : Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String Mn() {
        c cVar = aRd;
        return cVar != null ? cVar.Mn() : Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String getAppId() {
        c cVar = aRd;
        return cVar != null ? cVar.getAppId() : Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String getDeviceId() {
        c cVar = aRd;
        return cVar != null ? cVar.getDeviceId() : Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String getIccId() {
        c cVar = aRd;
        return cVar != null ? cVar.getIccId() : Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String getIp() {
        c cVar = aRd;
        return cVar != null ? cVar.getIp() : Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String getLocation() {
        c cVar = aRd;
        return cVar != null ? cVar.getLocation() : Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String getOaid() {
        c cVar = aRd;
        return cVar != null ? cVar.getOaid() : Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String getSdkVersion() {
        c cVar = aRd;
        return cVar != null ? cVar.getSdkVersion() : Mp();
    }

    private b() {
    }
}
