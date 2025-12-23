package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f16300a = "AppVersionSignature";

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentMap<String, com.bumptech.glide.load.c> f16301b = new ConcurrentHashMap();

    @NonNull
    private static String b(@Nullable PackageInfo packageInfo) {
        return packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString();
    }

    @VisibleForTesting
    static void e() {
        f16301b.clear();
    }

    private b() {
    }

    @Nullable
    private static PackageInfo a(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            context.getPackageName();
            return null;
        }
    }

    @NonNull
    public static com.bumptech.glide.load.c c(@NonNull Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap<String, com.bumptech.glide.load.c> concurrentMap = f16301b;
        com.bumptech.glide.load.c cVar = concurrentMap.get(packageName);
        if (cVar == null) {
            com.bumptech.glide.load.c d6 = d(context);
            com.bumptech.glide.load.c putIfAbsent = concurrentMap.putIfAbsent(packageName, d6);
            if (putIfAbsent == null) {
                return d6;
            }
            return putIfAbsent;
        }
        return cVar;
    }

    @NonNull
    private static com.bumptech.glide.load.c d(@NonNull Context context) {
        return new e(b(a(context)));
    }
}
