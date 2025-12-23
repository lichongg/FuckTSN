package com.kuaishou.weapon.p0;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.work.PeriodicWorkRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public static final int f36167a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static final int f36168b = 2;

    /* renamed from: c, reason: collision with root package name */
    public static final int f36169c = 4;

    /* renamed from: d, reason: collision with root package name */
    public static final int f36170d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static final int f36171e = 8;

    /* renamed from: f, reason: collision with root package name */
    public static final int f36172f = 1;

    /* renamed from: g, reason: collision with root package name */
    public static final int f36173g = 3;

    /* renamed from: h, reason: collision with root package name */
    public static final int f36174h = 4;

    /* renamed from: o, reason: collision with root package name */
    private static long f36175o;

    /* renamed from: j, reason: collision with root package name */
    private Context f36177j;

    /* renamed from: k, reason: collision with root package name */
    private q f36178k;

    /* renamed from: l, reason: collision with root package name */
    private t f36179l;

    /* renamed from: m, reason: collision with root package name */
    private File f36180m;

    /* renamed from: n, reason: collision with root package name */
    private dp f36181n;

    /* renamed from: p, reason: collision with root package name */
    private int f36182p;

    /* renamed from: r, reason: collision with root package name */
    private boolean f36184r;

    /* renamed from: q, reason: collision with root package name */
    private int f36183q = 0;

    /* renamed from: i, reason: collision with root package name */
    List<Integer> f36176i = new ArrayList();

    /* renamed from: s, reason: collision with root package name */
    private Map<Integer, a> f36185s = new HashMap();

    class a {

        /* renamed from: a, reason: collision with root package name */
        int f36186a;

        public a(int i6) {
            this.f36186a = i6;
        }
    }

    public JSONObject a() {
        try {
            String str = cu.f35929a + cu.f35935g;
            String a6 = cv.a(this.f36177j);
            if (!TextUtils.isEmpty(a6)) {
                str = str + "?" + a6;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject c6 = cv.c(this.f36177j);
            if (c6 != null) {
                jSONObject.put("data", new bn(this.f36177j).c(c6.toString()));
            }
            l a7 = l.a(this.f36177j);
            m mVar = new m(str, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            JSONObject jSONObject2 = new JSONObject(a7.a(mVar));
            int optInt = jSONObject2.optInt("result", 0);
            if (optInt != 1) {
                if (optInt != -7) {
                    return null;
                }
                dp.a(this.f36177j).a(dp.f36022a, 1, false);
                return null;
            }
            String a8 = new bn(this.f36177j).a(jSONObject2.getString("antispamPluginManageRsp"));
            if (TextUtils.isEmpty(a8)) {
                if (this.f36183q == 0) {
                    this.f36183q = 8;
                }
                throw new NetworkErrorException("kuaishou risk pluginloader response is null");
            }
            JSONObject jSONObject3 = new JSONObject(a8);
            if (jSONObject3.optInt(NotificationCompat.CATEGORY_STATUS, 0) == 1) {
                return jSONObject3.optJSONObject("plugin");
            }
            dp dpVar = this.f36181n;
            if (dpVar == null) {
                return null;
            }
            dpVar.a(dp.f36023b, System.currentTimeMillis(), true);
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<String> it;
        JSONObject jSONObject;
        boolean z5;
        try {
            synchronized (u.class) {
                try {
                    int i6 = this.f36182p;
                    if (i6 == 1 || i6 == 2 || i6 == 4 || this.f36184r || System.currentTimeMillis() - f36175o >= PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
                        this.f36179l.d();
                        f36175o = System.currentTimeMillis();
                        if ((System.currentTimeMillis() - this.f36181n.a(dp.f36023b)) - (this.f36181n.a(dp.f36024c, 6) * 3600000) > 0) {
                            List<s> a6 = this.f36179l.a();
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList<s> arrayList3 = new ArrayList();
                            ArrayList arrayList4 = new ArrayList();
                            JSONObject a7 = a();
                            if (a7 == null) {
                                throw new Exception("pluginJsonObject is null ");
                            }
                            boolean z6 = false;
                            try {
                                boolean b6 = dm.b(this.f36177j);
                                Iterator<String> keys = a7.keys();
                                HashSet hashSet = new HashSet();
                                boolean z7 = false;
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    if (b6 && next.endsWith("64")) {
                                        if (next.length() > 3) {
                                            hashSet.add(next.substring(0, next.length() - 3));
                                            hashSet.add(next.substring(0, next.length() - 3) + ".32");
                                            z7 = true;
                                        } else {
                                            z7 = true;
                                        }
                                    } else if (b6 || !next.endsWith("32")) {
                                        if (b6 && next.endsWith("v8")) {
                                            if (next.length() > 3) {
                                                hashSet.add(next.substring(0, next.length() - 3));
                                                hashSet.add(next.substring(0, next.length() - 3) + ".v7");
                                                z7 = true;
                                            }
                                        } else if (!b6 && next.endsWith("v7")) {
                                            if (next.length() > 3) {
                                                hashSet.add(next.substring(0, next.length() - 3));
                                                hashSet.add(next.substring(0, next.length() - 3) + ".v8");
                                            }
                                        }
                                        z7 = true;
                                    } else if (next.length() > 3) {
                                        hashSet.add(next.substring(0, next.length() - 3));
                                        hashSet.add(next.substring(0, next.length() - 3) + ".64");
                                        z7 = true;
                                    } else {
                                        z7 = true;
                                    }
                                }
                                if (z7) {
                                    Iterator it2 = hashSet.iterator();
                                    while (it2.hasNext()) {
                                        a7.remove((String) it2.next());
                                    }
                                }
                                z6 = z7;
                            } catch (Throwable unused) {
                            }
                            Iterator<String> keys2 = a7.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                s a8 = o.a(a7.optJSONObject(next2));
                                if (a8 != null) {
                                    if (z6 && !a8.f36139y && (next2.endsWith("32") || next2.endsWith("64") || next2.endsWith("v7") || next2.endsWith("v8"))) {
                                        a8.f36139y = true;
                                    }
                                    if (a8.f36136v) {
                                        arrayList4.add(next2);
                                    }
                                    if (!a8.f36139y) {
                                        arrayList3.add(a8);
                                    }
                                    int indexOf = a6.indexOf(a8);
                                    if (indexOf < 0 || !a8.f36139y) {
                                        it = keys2;
                                        jSONObject = a7;
                                        z5 = z6;
                                        if (a8.f36139y) {
                                            arrayList2.add(a8);
                                        }
                                    } else {
                                        s sVar = a6.get(indexOf);
                                        if (dn.b(a8.f36118d, sVar.f36118d)) {
                                            int i7 = a8.f36138x;
                                            if (i7 != sVar.f36138x) {
                                                this.f36179l.c(a8.f36115a, i7);
                                            }
                                            if (!this.f36179l.d(a8.f36115a)) {
                                                arrayList2.add(a8);
                                            }
                                            it = keys2;
                                            jSONObject = a7;
                                            z5 = z6;
                                        } else {
                                            jSONObject = a7;
                                            z5 = z6;
                                            it = keys2;
                                            this.f36181n.a(dp.f36023b, System.currentTimeMillis(), true);
                                            int i8 = a8.f36138x;
                                            if (i8 != sVar.f36138x) {
                                                this.f36179l.c(a8.f36115a, i8);
                                            }
                                            arrayList.add(a8);
                                        }
                                        a6.remove(indexOf);
                                    }
                                    a7 = jSONObject;
                                    z6 = z5;
                                    keys2 = it;
                                }
                            }
                            for (s sVar2 : a6) {
                                if (!arrayList4.contains(sVar2.f36117c)) {
                                    List<Integer> list = this.f36176i;
                                    if (list != null) {
                                        list.add(Integer.valueOf(sVar2.f36115a));
                                    }
                                    this.f36178k.a(sVar2.f36117c);
                                }
                            }
                            for (s sVar3 : arrayList3) {
                                if (!arrayList4.contains(sVar3.f36117c)) {
                                    List<Integer> list2 = this.f36176i;
                                    if (list2 != null) {
                                        list2.add(Integer.valueOf(sVar3.f36115a));
                                    }
                                    this.f36178k.a(sVar3.f36117c);
                                }
                            }
                            ArrayList<s> arrayList5 = new ArrayList();
                            if (arrayList2.size() != 0) {
                                arrayList5.addAll(arrayList2);
                            }
                            if (arrayList.size() != 0) {
                                arrayList5.addAll(arrayList);
                            }
                            for (s sVar4 : arrayList5) {
                                if (sVar4 != null) {
                                    if (arrayList.contains(sVar4)) {
                                        this.f36178k.a(sVar4.f36115a, sVar4.f36118d, (PackageInfo) null);
                                    } else if (arrayList2.contains(sVar4)) {
                                        a(sVar4);
                                    }
                                }
                            }
                        } else {
                            this.f36178k.c();
                            this.f36179l.b();
                        }
                    }
                } finally {
                    WeaponHI.iD();
                }
            }
        } catch (Throwable unused2) {
            this.f36178k.c();
            this.f36179l.b();
        }
    }

    public u(Context context, int i6, boolean z5) {
        this.f36182p = 0;
        this.f36184r = false;
        this.f36177j = context;
        this.f36178k = q.a(context);
        this.f36179l = t.a(context);
        this.f36181n = dp.a(context);
        this.f36180m = new File(context.getFilesDir(), ".tmp");
        this.f36182p = i6;
        this.f36184r = z5;
    }

    private void a(s sVar) {
        try {
            if (!TextUtils.isEmpty(sVar.f36124j) && sVar.f36124j.length() >= 10) {
                if (!this.f36180m.exists()) {
                    this.f36180m.mkdir();
                }
                File file = new File(this.f36180m, sVar.f36115a + "-" + sVar.f36118d + ".tmp");
                File file2 = new File(this.f36180m, sVar.f36115a + "-" + sVar.f36118d + ".zip");
                boolean a6 = l.a(this.f36177j).a(sVar.f36123i, file);
                if (!a6) {
                    a6 = l.a(this.f36177j).a(sVar.f36123i, file);
                }
                if (a6) {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    int c6 = b.c(file.getAbsolutePath(), file2.getAbsolutePath(), c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes("utf-8"), 2));
                    if (c6 != 0) {
                        if (file2.exists()) {
                            file2.delete();
                        }
                        a6 = false;
                    }
                    if (c6 == 0 && file.exists()) {
                        file.delete();
                    }
                } else {
                    this.f36185s.put(Integer.valueOf(sVar.f36115a), new a(3));
                }
                String a7 = f.a(file2);
                if (a6 && sVar.f36124j.equals(a7)) {
                    dn.a(file2.getAbsolutePath(), Boolean.TRUE);
                    sVar.f36119e = file2.getAbsolutePath();
                    if (this.f36178k.a(sVar, (String) null, (String) null)) {
                        Map<Integer, a> map = this.f36185s;
                        if (map != null && !map.containsKey(Integer.valueOf(sVar.f36115a))) {
                            this.f36185s.put(Integer.valueOf(sVar.f36115a), new a(1));
                        }
                        this.f36181n.a(dp.f36023b, System.currentTimeMillis(), true);
                        return;
                    }
                    Map<Integer, a> map2 = this.f36185s;
                    if (map2 != null && !map2.containsKey(Integer.valueOf(sVar.f36115a))) {
                        this.f36185s.put(Integer.valueOf(sVar.f36115a), new a(4));
                    }
                    this.f36178k.a(sVar.f36115a, sVar.f36118d, (PackageInfo) null);
                    return;
                }
                if (file.exists()) {
                    file.length();
                    file.delete();
                }
                this.f36178k.a(sVar.f36115a, sVar.f36118d, (PackageInfo) null);
                return;
            }
            this.f36178k.a(sVar.f36115a, sVar.f36118d, (PackageInfo) null);
        } catch (Throwable unused) {
            this.f36178k.a(sVar.f36115a, sVar.f36118d, (PackageInfo) null);
        }
    }
}
