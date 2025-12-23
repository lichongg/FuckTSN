package com.umeng.socialize.net.dplus.cache1;

import android.content.Context;
import android.os.Handler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class CacheApi {

    /* renamed from: a, reason: collision with root package name */
    private static String f42436a = "CacheApi";

    /* renamed from: e, reason: collision with root package name */
    private static CacheApi f42437e;

    /* renamed from: b, reason: collision with root package name */
    private Handler f42438b;

    /* renamed from: c, reason: collision with root package name */
    private CacheExector f42439c = new CacheExector(a());

    /* renamed from: d, reason: collision with root package name */
    private Context f42440d;

    private String a() {
        Context context = this.f42440d;
        if (context == null) {
            return null;
        }
        return context.getFilesDir().getPath();
    }

    public static CacheApi get(Context context) {
        if (f42437e == null) {
            f42437e = new CacheApi(context);
        }
        return f42437e;
    }

    public double checkSize(String str) {
        CacheExector cacheExector = this.f42439c;
        if (cacheExector == null) {
            return 0.0d;
        }
        return cacheExector.checkSize(str);
    }

    public boolean delete(String str) {
        CacheExector cacheExector = this.f42439c;
        if (cacheExector == null) {
            return false;
        }
        return cacheExector.deleteFile(str);
    }

    public IReader read(String str, Class cls) {
        CacheExector cacheExector = this.f42439c;
        if (cacheExector == null) {
            return null;
        }
        return cacheExector.readFile(str, cls);
    }

    public boolean save(String str, String str2) {
        CacheExector cacheExector = this.f42439c;
        if (cacheExector == null) {
            return false;
        }
        return cacheExector.save(str, str2);
    }

    private CacheApi(Context context) {
        this.f42440d = context;
    }
}
