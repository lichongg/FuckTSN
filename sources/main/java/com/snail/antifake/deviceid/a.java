package com.snail.antifake.deviceid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.snail.antifake.deviceid.d;
import com.snail.antifake.jni.PropertiesGet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static BatteryChangeReceiver f37529a;

    public static String b() {
        return PropertiesGet.a("ro.product.board");
    }

    public static String c() {
        return PropertiesGet.a("ro.bootloader");
    }

    public static String d() {
        return PropertiesGet.a("ro.product.brand");
    }

    public static String e() {
        return PropertiesGet.a("ro.product.cpu.abi");
    }

    public static int f() {
        BatteryChangeReceiver batteryChangeReceiver = f37529a;
        if (batteryChangeReceiver != null) {
            return batteryChangeReceiver.a();
        }
        return -1;
    }

    public static String g() {
        return PropertiesGet.a("ro.product.device");
    }

    public static String i() {
        return PropertiesGet.a("ro.hardware");
    }

    @SuppressLint({"MissingPermission"})
    public static String j(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
    }

    public static void k(d.c cVar) {
        new d().e(cVar);
    }

    public static String m() {
        return PropertiesGet.a("ro.product.manufacturer");
    }

    public static String n() {
        return PropertiesGet.a("ro.product.model");
    }

    @SuppressLint({"MissingPermission"})
    public static String o() {
        String serial;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                serial = Build.getSerial();
                return serial;
            }
            String a6 = PropertiesGet.a("ro.serialno");
            return TextUtils.isEmpty(a6) ? Build.SERIAL : a6;
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean p() {
        BatteryChangeReceiver batteryChangeReceiver = f37529a;
        return (batteryChangeReceiver == null || batteryChangeReceiver.b()) ? false : true;
    }

    public static void r(Context context) {
        if (f37529a == null) {
            f37529a = new BatteryChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            context.registerReceiver(f37529a, intentFilter);
        }
    }

    public static void s(Context context) {
        BatteryChangeReceiver batteryChangeReceiver = f37529a;
        if (batteryChangeReceiver == null) {
            context.unregisterReceiver(batteryChangeReceiver);
            f37529a = null;
        }
    }

    public static String a(Context context) {
        return o2.a.a(context);
    }

    public static String h(Context context) {
        return p2.a.a(context);
    }

    public static String l(Context context) {
        return r2.b.b(context);
    }

    public static boolean q(Context context) {
        return q2.a.n(context);
    }
}
