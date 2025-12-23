package cn.jpush.android.x;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f3997a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static volatile Queue<String> f3998b;

    /* JADX WARN: Removed duplicated region for block: B:5:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.json.JSONArray a(android.content.Context r3) {
        /*
            java.lang.String r0 = "NotificationRecords"
            cn.jpush.android.cache.Key r1 = cn.jpush.android.cache.Key.NotiCancel()
            java.lang.Object r3 = cn.jpush.android.cache.Sp.get(r3, r1)
            java.lang.String r3 = (java.lang.String) r3
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 != 0) goto L41
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2c
            r1.<init>()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r2 = "read="
            r1.append(r2)     // Catch: java.lang.Throwable -> L2c
            r1.append(r3)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L2c
            cn.jpush.android.helper.Logger.d(r0, r1)     // Catch: java.lang.Throwable -> L2c
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L2c
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L2c
            goto L42
        L2c:
            r3 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "read NotiCancel e:"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            cn.jpush.android.helper.Logger.w(r0, r3)
        L41:
            r1 = 0
        L42:
            if (r1 == 0) goto L45
            goto L4a
        L45:
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
        L4a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.x.d.a(android.content.Context):org.json.JSONArray");
    }

    private static void b(Context context) {
        if (f3998b == null) {
            synchronized (d.class) {
                try {
                    if (f3998b == null) {
                        f3998b = new ConcurrentLinkedQueue();
                        String str = (String) Sp.get(context, Key.NotiShow());
                        if (!TextUtils.isEmpty(str)) {
                            for (String str2 : str.split(",")) {
                                if (!TextUtils.isEmpty(str2)) {
                                    f3998b.offer(str2);
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void a(Context context, List<String> list, int i6) {
        try {
            JSONArray a6 = a(context);
            JSONArray jSONArray = new JSONArray();
            long currentTimeMillis = System.currentTimeMillis();
            for (int i7 = 0; i7 < a6.length(); i7++) {
                JSONObject jSONObject = a6.getJSONObject(i7);
                String string = jSONObject.getString("id");
                if (list != null && list.remove(string)) {
                    jSONObject.put("time", currentTimeMillis);
                }
                if (currentTimeMillis < jSONObject.getLong("time") + 86400000) {
                    jSONArray.put(jSONObject);
                }
            }
            if (list != null) {
                for (String str : list) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("time", currentTimeMillis);
                    jSONObject2.put("id", str);
                    jSONObject2.put("type", i6);
                    jSONArray.put(jSONObject2);
                }
            }
            String jSONArray2 = jSONArray.length() > 0 ? jSONArray.toString() : null;
            Logger.d("NotificationRecords", "saveString=" + jSONArray2);
            Sp.set(context, Key.NotiCancel().set(jSONArray2));
        } catch (Throwable th) {
            Logger.w("NotificationRecords", "save NotiCancel e:" + th);
        }
    }

    public static void b(Context context, String str) {
        try {
            b(context);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f3997a) {
                try {
                    if (f3998b.size() >= 70) {
                        f3998b.poll();
                    }
                    f3998b.offer(str);
                    StringBuilder sb = new StringBuilder();
                    Iterator<String> it = f3998b.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next() + ",");
                    }
                    Sp.set(context, Key.NotiShow().set(sb.toString()));
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable unused) {
            Logger.e("NotificationRecords", "saveNotiHistory failed,messageId = " + str);
        }
    }

    public static boolean a(Context context, String str) {
        b(context);
        return f3998b.contains(str);
    }

    public static boolean a(Context context, String str, String str2, int i6) {
        boolean z5;
        try {
            JSONArray a6 = a(context);
            if (a6 == null || a6.length() == 0) {
                return false;
            }
            JSONArray jSONArray = new JSONArray();
            long currentTimeMillis = System.currentTimeMillis();
            boolean z6 = false;
            for (int i7 = 0; i7 < a6.length(); i7++) {
                JSONObject jSONObject = a6.getJSONObject(i7);
                long j6 = jSONObject.getLong("time");
                z5 = false;
                try {
                    int optInt = jSONObject.optInt("type", -1);
                    if (currentTimeMillis < j6 + 86400000) {
                        jSONArray.put(jSONObject);
                        if (!z6) {
                            String string = jSONObject.getString("id");
                            if (!TextUtils.isEmpty(str) && str.equals(string) && (optInt == -1 || i6 == optInt)) {
                                cn.jpush.android.helper.c.a(str, 1032L, context);
                            } else if (!TextUtils.isEmpty(str2)) {
                                if (str2.equals(string) && (optInt == -1 || i6 == optInt)) {
                                    cn.jpush.android.helper.c.a(str, 1033L, context);
                                }
                            }
                            z6 = true;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    Logger.w("NotificationRecords", "isAlreadyCancel e:" + th);
                    return z5;
                }
            }
            z5 = false;
            if (jSONArray.length() != a6.length()) {
                String jSONArray2 = jSONArray.length() > 0 ? jSONArray.toString() : null;
                Logger.d("NotificationRecords", "saveString when check=" + jSONArray2);
                Sp.set(context, Key.NotiCancel().set(jSONArray2));
            }
            return z6;
        } catch (Throwable th2) {
            th = th2;
            z5 = false;
        }
    }
}
