package com.bytedance.sdk.component.cw.xt.j.ae;

import com.bytedance.sdk.component.cw.xt.x;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\Downloads\app\classes4.dex */
final class xt extends up {

    /* renamed from: j, reason: collision with root package name */
    final Method f26160j;
    final Method xt;

    @Override // com.bytedance.sdk.component.cw.xt.j.ae.up
    public void j(SSLSocket sSLSocket, String str, List<x> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> j6 = up.j(list);
            this.f26160j.invoke(sSLParameters, j6.toArray(new String[j6.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e6) {
            throw com.bytedance.sdk.component.cw.xt.j.cw.j("unable to set ssl parameters", (Exception) e6);
        }
    }

    xt(Method method, Method method2) {
        this.f26160j = method;
        this.xt = method2;
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.ae.up
    public String j(SSLSocket sSLSocket) {
        try {
            String str = (String) this.xt.invoke(sSLSocket, null);
            if (str != null) {
                if (!str.equals("")) {
                    return str;
                }
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException e6) {
            throw com.bytedance.sdk.component.cw.xt.j.cw.j("unable to get selected protocols", (Exception) e6);
        }
    }

    public static xt j() {
        try {
            return new xt(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", null));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
