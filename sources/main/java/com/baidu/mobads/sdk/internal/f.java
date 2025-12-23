package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.mobads.sdk.internal.an;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static volatile f f11032a;

    public static f a() {
        if (f11032a == null) {
            synchronized (f.class) {
                try {
                    if (f11032a == null) {
                        f11032a = new f();
                    }
                } finally {
                }
            }
        }
        return f11032a;
    }

    private f() {
    }

    public void a(double d6, an.b bVar) {
        cr a6 = cr.a();
        String c6 = a6.c(z.f11211a);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("v", "" + d6);
        hashMap.put("os", FaceEnvironment.OS);
        hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_REQUEST_TYPE, a(bn.a((Context) null).d()));
        hashMap.put("bdr", a(bn.a((Context) null).b()));
        an anVar = new an(a6.a(c6, hashMap));
        anVar.a(bVar);
        anVar.b();
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException | NullPointerException unused) {
            return str;
        }
    }

    public DexClassLoader a(String str, String str2, String str3, ClassLoader classLoader) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            file.setReadOnly();
            return new DexClassLoader(str, str2, str3, classLoader);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
