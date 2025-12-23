package com.tencent.open.a;

import android.os.Build;
import com.huawei.hms.framework.common.ContainerUtils;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static f f40504a;

    /* renamed from: b, reason: collision with root package name */
    private i f40505b;

    /* renamed from: c, reason: collision with root package name */
    private a f40506c;

    public static f a() {
        if (f40504a == null) {
            synchronized (f.class) {
                try {
                    if (f40504a == null) {
                        f40504a = new f();
                    }
                } finally {
                }
            }
        }
        f40504a.c();
        return f40504a;
    }

    private void b() {
        String str = "AndroidSDK_" + Build.VERSION.SDK + "_" + com.tencent.open.utils.f.a().b(com.tencent.open.utils.g.a()) + "_" + Build.VERSION.RELEASE;
        try {
            this.f40506c = new e(str);
        } catch (NoClassDefFoundError e6) {
            SLog.e("openSDK_LOG.OpenHttpService", "initClient okHttp catch error", e6);
        } catch (Throwable th) {
            SLog.e("openSDK_LOG.OpenHttpService", "initClient okHttp catch throwable", th);
        }
        if (this.f40506c == null) {
            this.f40506c = new b(str);
        }
    }

    private void c() {
        i iVar = this.f40505b;
        if (iVar == null) {
            return;
        }
        int a6 = iVar.a("Common_HttpConnectionTimeout");
        if (a6 == 0) {
            a6 = 15000;
        }
        int a7 = this.f40505b.a("Common_SocketConnectionTimeout");
        if (a7 == 0) {
            a7 = KSImageLoader.InnerImageLoadingListener.MAX_DURATION;
        }
        a(a6, a7);
    }

    protected f() {
        b();
    }

    public void a(i iVar) {
        this.f40505b = iVar;
        c();
    }

    public g b(String str, Map<String, String> map) throws IOException {
        SLog.i("openSDK_LOG.OpenHttpService", "post data");
        return this.f40506c.a(str, map);
    }

    public void a(long j6, long j7) {
        a aVar = this.f40506c;
        if (aVar != null) {
            aVar.a(j6, j7);
        }
    }

    public g a(String str, Map<String, String> map) throws IOException {
        if (map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder("");
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str3 != null) {
                    sb.append(URLEncoder.encode(str2, "UTF-8"));
                    sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb.append(URLEncoder.encode(str3, "UTF-8"));
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return a(str, sb.toString());
        }
        return a(str, "");
    }

    public g a(String str, String str2) throws IOException {
        SLog.i("openSDK_LOG.OpenHttpService", "get.");
        return this.f40506c.a(str, str2);
    }

    public g a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 != null && map2.size() != 0) {
            return this.f40506c.a(str, map, map2);
        }
        return b(str, map);
    }
}
