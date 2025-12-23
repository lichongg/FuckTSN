package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, PackageInfo> f42098a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static Object f42099b = new Object();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.commonsdk.utils.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f42100a = new b(null);

        private a() {
        }
    }

    /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static b a() {
        return a.f42100a;
    }

    private b() {
    }

    public PackageInfo a(Context context, String str, int i6) {
        PackageInfo packageInfo;
        synchronized (f42099b) {
            try {
                if (f42098a.containsKey(str)) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", pkgInfo缓存命中，直接返回");
                    packageInfo = f42098a.get(str);
                } else {
                    try {
                        packageInfo = context.getPackageManager().getPackageInfo(str, i6);
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", 获取pkgInfo并缓存");
                        f42098a.put(str, packageInfo);
                    } catch (PackageManager.NameNotFoundException unused) {
                        f42098a.put(str, null);
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg: " + str + "，目标包未安装。");
                        packageInfo = null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return packageInfo;
    }
}
