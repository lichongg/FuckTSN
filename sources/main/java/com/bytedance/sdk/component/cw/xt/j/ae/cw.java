package com.bytedance.sdk.component.cw.xt.j.ae;

import com.acse.ottn.l3;
import com.bytedance.sdk.component.cw.xt.x;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\Downloads\app\classes4.dex */
class cw extends up {
    private final Method cw;

    /* renamed from: j, reason: collision with root package name */
    private final Method f26149j;

    /* renamed from: r, reason: collision with root package name */
    private final Class<?> f26150r;
    private final Class<?> up;
    private final Method xt;

    @Override // com.bytedance.sdk.component.cw.xt.j.ae.up
    public void j(SSLSocket sSLSocket, String str, List<x> list) {
        try {
            this.f26149j.invoke(null, sSLSocket, Proxy.newProxyInstance(up.class.getClassLoader(), new Class[]{this.f26150r, this.up}, new j(up.j(list))));
        } catch (IllegalAccessException | InvocationTargetException e6) {
            throw com.bytedance.sdk.component.cw.xt.j.cw.j("unable to set alpn", (Exception) e6);
        }
    }

    private static class j implements InvocationHandler {
        private final List<String> cw;

        /* renamed from: j, reason: collision with root package name */
        boolean f26151j;
        String xt;

        j(List<String> list) {
            this.cw = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = com.bytedance.sdk.component.cw.xt.j.cw.xt;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f26151j = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.cw;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i6 = 0; i6 < size; i6++) {
                        if (this.cw.contains(list.get(i6))) {
                            String str = (String) list.get(i6);
                            this.xt = str;
                            return str;
                        }
                    }
                    String str2 = this.cw.get(0);
                    this.xt = str2;
                    return str2;
                }
            }
            if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                this.xt = (String) objArr[0];
                return null;
            }
            return method.invoke(this, objArr);
        }
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.ae.up
    public void xt(SSLSocket sSLSocket) {
        try {
            this.cw.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e6) {
            throw com.bytedance.sdk.component.cw.xt.j.cw.j("unable to remove alpn", (Exception) e6);
        }
    }

    cw(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f26149j = method;
        this.xt = method2;
        this.cw = method3;
        this.f26150r = cls;
        this.up = cls2;
    }

    @Override // com.bytedance.sdk.component.cw.xt.j.ae.up
    public String j(SSLSocket sSLSocket) {
        try {
            j jVar = (j) Proxy.getInvocationHandler(this.xt.invoke(null, sSLSocket));
            boolean z5 = jVar.f26151j;
            if (!z5 && jVar.xt == null) {
                up.xt().j(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            }
            if (z5) {
                return null;
            }
            return jVar.xt;
        } catch (IllegalAccessException e6) {
            e = e6;
            throw com.bytedance.sdk.component.cw.xt.j.cw.j("unable to get selected protocol", e);
        } catch (InvocationTargetException e7) {
            e = e7;
            throw com.bytedance.sdk.component.cw.xt.j.cw.j("unable to get selected protocol", e);
        }
    }

    public static up j() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new cw(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod(l3.f4736f, SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }
}
