package com.umeng.umzid;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class b implements HostnameVerifier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f42555a;

    public b(String str) {
        this.f42555a = str;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        if (!TextUtils.isEmpty(str)) {
            if (this.f42555a.equalsIgnoreCase(str) || "pre-aaid.umeng.com".equalsIgnoreCase(str)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
