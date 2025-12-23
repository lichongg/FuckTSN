package cn.jiguang.net;

import android.text.TextUtils;
import cn.jiguang.bb.f;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: D:\Downloads\app\classes2.dex */
public class DefaultHostVerifier implements HostnameVerifier {

    /* renamed from: a, reason: collision with root package name */
    public String f3119a;

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        f.c("DefaultHostVerifier", "host:" + str + ",checkHost:" + this.f3119a);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f3119a, str);
    }

    public DefaultHostVerifier(String str) {
        this.f3119a = str;
    }
}
