package cn.jpush.android.w;

import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a implements HostnameVerifier {

    /* renamed from: a, reason: collision with root package name */
    public String f3940a;

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        Logger.d("DefaultHostVerifier", "host:" + str + ",checkHost:" + this.f3940a);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f3940a, str);
    }

    public a(String str) {
        this.f3940a = str;
    }
}
