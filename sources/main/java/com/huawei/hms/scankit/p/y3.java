package com.huawei.hms.scankit.p;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.mlsdk.common.AgConnectInfo;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class y3 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35041a = "y3";

    /* renamed from: b, reason: collision with root package name */
    private static volatile Bundle f35042b = null;

    /* renamed from: c, reason: collision with root package name */
    public static String f35043c = "";

    /* renamed from: d, reason: collision with root package name */
    public static HashSet<String> f35044d = new HashSet<>();

    public static Bundle a(Context context) {
        if (context == null) {
            return new Bundle();
        }
        if (f35042b == null) {
            Bundle bundle = new Bundle();
            try {
                String string = j1.a.d(context).getString(AgConnectInfo.AgConnectKey.APPLICATION_ID);
                if (string == null) {
                    string = context.getPackageName();
                }
                bundle.putString("appid", string);
            } catch (RuntimeException | Exception unused) {
            }
            f35042b = bundle;
        }
        return f35042b;
    }

    public static String b(Context context) {
        if (f35043c.length() == 0) {
            f35043c = context.getPackageName();
        }
        return f35043c;
    }

    public static HashSet<String> a() {
        if (f35044d.size() == 0) {
            f35044d.add("com.huawei.scanner");
            f35044d.add("com.huawei.hitouch");
        }
        return f35044d;
    }

    public static boolean a(String str, HashSet<String> hashSet) {
        if (str.length() == 0) {
            return true;
        }
        Iterator<String> it = hashSet.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return false;
            }
        }
        return true;
    }
}
