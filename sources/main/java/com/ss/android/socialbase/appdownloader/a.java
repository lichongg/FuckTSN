package com.ss.android.socialbase.appdownloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.ss.android.socialbase.downloader.downloader.cw;

/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {

    /* renamed from: com.ss.android.socialbase.appdownloader.a$a, reason: collision with other inner class name */
    public static class C0770a {

        /* renamed from: a, reason: collision with root package name */
        private String f38342a;

        /* renamed from: b, reason: collision with root package name */
        private String f38343b;

        /* renamed from: c, reason: collision with root package name */
        private Drawable f38344c;

        /* renamed from: d, reason: collision with root package name */
        private String f38345d;

        /* renamed from: e, reason: collision with root package name */
        private String f38346e;

        /* renamed from: f, reason: collision with root package name */
        private int f38347f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f38348g;

        public String a() {
            return this.f38346e;
        }

        public String b() {
            return this.f38342a;
        }

        public void c(String str) {
            this.f38345d = str;
        }

        public Drawable d() {
            return this.f38344c;
        }

        public void e(int i6) {
            this.f38347f = i6;
        }

        public void f(Drawable drawable) {
            this.f38344c = drawable;
        }

        public void g(String str) {
            this.f38342a = str;
        }

        public void h(boolean z5) {
            this.f38348g = z5;
        }

        public int i() {
            return this.f38347f;
        }

        public String j() {
            return this.f38343b;
        }

        public void k(String str) {
            this.f38346e = str;
        }

        public String l() {
            return this.f38345d;
        }

        public void m(String str) {
            this.f38343b = str;
        }

        public boolean n() {
            return this.f38348g;
        }

        public String toString() {
            return "{\n  pkg name: " + b() + "\n  app icon: " + d() + "\n  app name: " + j() + "\n  app path: " + l() + "\n  app v name: " + a() + "\n  app v code: " + i() + "\n  is system: " + n() + "}";
        }

        public C0770a(String str, String str2, Drawable drawable, String str3, String str4, int i6, boolean z5) {
            m(str2);
            f(drawable);
            g(str);
            c(str3);
            k(str4);
            e(i6);
            h(z5);
        }
    }

    private static boolean a(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            if (!Character.isWhitespace(str.charAt(i6))) {
                return false;
            }
        }
        return true;
    }

    private static C0770a c(PackageManager packageManager, PackageInfo packageInfo) {
        Drawable drawable = null;
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        String str = packageInfo.packageName;
        String charSequence = (applicationInfo == null || applicationInfo.loadLabel(packageManager) == null) ? "" : applicationInfo.loadLabel(packageManager).toString();
        try {
            drawable = applicationInfo.loadIcon(packageManager);
        } catch (Exception unused) {
        }
        return new C0770a(str, charSequence, drawable, applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }

    public static C0770a d(String str) {
        try {
            PackageManager packageManager = cw.nd().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return c(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e6) {
            com.ss.android.socialbase.downloader.m.j.up("AppUtils", "getAppInfo:" + e6.getMessage());
            return null;
        }
    }

    public static int b(String str) {
        if (a(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = cw.nd().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e6) {
            com.ss.android.socialbase.downloader.m.j.up("AppUtils", "getAppVersionCode:" + e6.getMessage());
            return -1;
        }
    }
}
