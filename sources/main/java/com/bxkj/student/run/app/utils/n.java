package com.bxkj.student.run.app.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.umeng.socialize.common.SocializeConstants;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f20287a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static Map<String, String> f20288b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.run.app.utils.n$a$a, reason: collision with other inner class name */
        public static final class C0271a {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final C0271a f20289a = new C0271a();

            public final boolean a(@NotNull Context context) {
                g0.p(context, "context");
                Object systemService = context.getSystemService(SocializeConstants.KEY_LOCATION);
                g0.n(systemService, "null cannot be cast to non-null type android.location.LocationManager");
                try {
                    return ((LocationManager) systemService).isProviderEnabled(GeocodeSearch.GPS);
                } catch (Exception unused) {
                    return false;
                }
            }

            private C0271a() {
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        public final boolean c(@NotNull Context context) {
            g0.p(context, "context");
            Map<String, String> b6 = b();
            PackageManager packageManager = context.getPackageManager();
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            g0.o(installedPackages, "getInstalledPackages(...)");
            StringBuilder sb = new StringBuilder();
            int size = installedPackages.size();
            for (int i6 = 0; i6 < size; i6++) {
                String obj = packageManager.getApplicationLabel(installedPackages.get(i6).applicationInfo).toString();
                String packageName = installedPackages.get(i6).packageName;
                g0.o(packageName, "packageName");
                sb.append("appName: " + obj + " packageName: " + packageName);
                sb.append(com.snail.antifake.deviceid.e.f37542d);
                if (b6.get(installedPackages.get(i6).packageName) != null) {
                    String str = b6.get(installedPackages.get(i6).packageName);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append((Object) str);
                    com.orhanobut.logger.j.d(sb2.toString(), new Object[0]);
                    return true;
                }
            }
            com.orhanobut.logger.j.c(sb);
            return false;
        }

        public final boolean d(@NotNull Location location, @NotNull Context context) {
            g0.p(location, "location");
            g0.p(context, "context");
            return location.isFromMockProvider();
        }

        public final void e(@NotNull Map<String, String> map) {
            g0.p(map, "<set-?>");
            n.f20288b = map;
        }

        private final Map<String, String> b() {
            return a();
        }

        @NotNull
        public final Map<String, String> a() {
            return n.f20288b;
        }
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("com.lerist.fakelocation", "com.lerist.fakelocation");
        linkedHashMap.put("top.a1024bytes.mockloc.ca.pro", "top.a1024bytes.mockloc.ca.pro");
        linkedHashMap.put("com.qgwapp.shadowside", "com.qgwapp.shadowside");
        linkedHashMap.put("net.superal", "net.superal");
        linkedHashMap.put("com.deniu.daniu", "com.deniu.daniu");
        linkedHashMap.put("com.deniu.multi", "com.deniu.multi");
        linkedHashMap.put("com.txy.anywhere", "com.txy.anywhere");
        linkedHashMap.put("de.robv.android.xposed.installer", "de.robv.android.xposed.installer");
        linkedHashMap.put("github.tornaco.xposedmoduletest", "github.tornaco.xposedmoduletest");
        f20288b = linkedHashMap;
    }
}
