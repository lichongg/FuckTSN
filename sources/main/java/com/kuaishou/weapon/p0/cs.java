package com.kuaishou.weapon.p0;

import android.location.Location;
import android.net.wifi.WifiInfo;
import android.telephony.TelephonyManager;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class cs {

    /* renamed from: a, reason: collision with root package name */
    private ct f35926a = new ct();

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            ct ctVar = new ct();
            int a6 = ctVar.a(TelephonyManager.class, "getDeviceId", new Object[0]);
            if (a6 > 0) {
                jSONObject.put("0", a6);
            }
            int a7 = ctVar.a(TelephonyManager.class, "getSubscriberId", new Object[0]);
            if (a7 > 0) {
                jSONObject.put("1", a7);
            }
            int a8 = ctVar.a(TelephonyManager.class, "getSimSerialNumber", new Object[0]);
            if (a8 > 0) {
                jSONObject.put("2", a8);
            }
            int a9 = ctVar.a(Location.class, "getLatitude", new Object[0]);
            if (a9 > 0) {
                jSONObject.put("3", a9);
            }
            int a10 = ctVar.a(Location.class, "getLongitude", new Object[0]);
            if (a10 > 0) {
                jSONObject.put("4", a10);
            }
            int a11 = ctVar.a(WifiInfo.class, "getMacAddress", new Object[0]);
            if (a11 > 0) {
                jSONObject.put("6", a11);
            }
            int a12 = ctVar.a(WifiInfo.class, "getBSSID", new Object[0]);
            if (a12 > 0) {
                jSONObject.put("7", a12);
            }
            int a13 = ctVar.a(WifiInfo.class, "getRssi", new Object[0]);
            if (a13 > 0) {
                jSONObject.put("8", a13);
            }
            int a14 = ctVar.a(JSONObject.class, "toString", new Object[0]);
            if (a14 > 0) {
                jSONObject.put("9", a14);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            int a6 = this.f35926a.a();
            if (a6 <= 0) {
                return null;
            }
            int a7 = this.f35926a.a(a6, TelephonyManager.class, "getDeviceId", new Object[0]);
            if (a7 > 0) {
                jSONObject.put("0", a7);
            }
            int a8 = this.f35926a.a(a6, TelephonyManager.class, "getSubscriberId", new Object[0]);
            if (a8 > 0) {
                jSONObject.put("1", a8);
            }
            int a9 = this.f35926a.a(a6, TelephonyManager.class, "getSimSerialNumber", new Object[0]);
            if (a9 > 0) {
                jSONObject.put("2", a9);
            }
            int a10 = this.f35926a.a(a6, Location.class, "getLatitude", new Object[0]);
            if (a10 > 0) {
                jSONObject.put("3", a10);
            }
            int a11 = this.f35926a.a(a6, Location.class, "getLongitude", new Object[0]);
            if (a11 > 0) {
                jSONObject.put("4", a11);
            }
            int a12 = this.f35926a.a(a6, WifiInfo.class, "getMacAddress", new Object[0]);
            if (a12 > 0) {
                jSONObject.put("6", a12);
            }
            int a13 = this.f35926a.a(a6, WifiInfo.class, "getBSSID", new Object[0]);
            if (a13 > 0) {
                jSONObject.put("7", a13);
            }
            int a14 = this.f35926a.a(a6, WifiInfo.class, "getRssi", new Object[0]);
            if (a14 > 0) {
                jSONObject.put("8", a14);
            }
            int a15 = this.f35926a.a(a6, JSONObject.class, "toString", new Object[0]);
            if (a15 > 0) {
                jSONObject.put("9", a15);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
