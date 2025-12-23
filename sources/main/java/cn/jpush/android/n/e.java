package cn.jpush.android.n;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.ad.m;
import cn.jpush.android.helper.Logger;
import com.stub.StubApp;
import java.io.Closeable;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e {

    /* renamed from: c, reason: collision with root package name */
    public static int f3717c = 200;

    /* renamed from: a, reason: collision with root package name */
    protected Context f3718a;

    /* renamed from: b, reason: collision with root package name */
    protected int f3719b;

    /* renamed from: d, reason: collision with root package name */
    private volatile LinkedHashMap<String, cn.jpush.android.b.b> f3720d;

    /* renamed from: e, reason: collision with root package name */
    private volatile LinkedHashMap<String, cn.jpush.android.b.b> f3721e;

    /* renamed from: f, reason: collision with root package name */
    private a f3722f;

    /* renamed from: cn.jpush.android.n.e$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface a {
        void a(cn.jpush.android.b.b bVar);

        void a(cn.jpush.android.b.b bVar, cn.jpush.android.b.b bVar2);

        void a(boolean z5);

        void b(cn.jpush.android.b.b bVar);
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final e f3723a = new e(null);
    }

    private e() {
        this.f3719b = 100;
    }

    private static cn.jpush.android.b.b a(cn.jpush.android.d.d dVar) {
        cn.jpush.android.b.b bVar = new cn.jpush.android.b.b();
        bVar.f3536a = dVar.ak;
        bVar.f3537b = dVar.al;
        bVar.f3538c = dVar.am;
        bVar.f3539d = dVar.an;
        bVar.f3540e = dVar.ap;
        bVar.f3541f = dVar.aq;
        bVar.f3542g = dVar.ar;
        bVar.f3543h = dVar.as;
        return bVar;
    }

    private LinkedHashMap<String, cn.jpush.android.b.b> d(int i6) {
        return i6 == 2 ? this.f3721e : this.f3720d;
    }

    public LinkedHashMap<String, cn.jpush.android.b.b> b() {
        LinkedHashMap<String, cn.jpush.android.b.b> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.putAll(this.f3721e);
        linkedHashMap.putAll(this.f3720d);
        return linkedHashMap;
    }

    public int c() {
        return this.f3720d.size() + this.f3721e.size();
    }

    /* synthetic */ e(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static e a() {
        return b.f3723a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:0|1|2|3|(1:7)|8|(13:50|(1:(2:69|(1:71)))(2:53|(5:57|(2:60|58)|61|62|(2:64|65)))|14|15|16|(1:18)|19|(1:21)(3:32|(4:35|(3:40|41|42)|43|33)|46)|22|(1:31)|(1:30)|27|28)(1:12)|13|14|15|16|(0)|19|(0)(0)|22|(0)|31|(0)|30|27|28|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e1, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e2, code lost:
    
        cn.jpush.android.helper.Logger.dd("GeofenceDataHelper", "recover geofence failed:" + r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00c7, code lost:
    
        if (r8.f3720d.isEmpty() == false) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0160 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0167 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.n.e.b(android.content.Context):void");
    }

    private void c(int i6) {
        LinkedHashMap<String, cn.jpush.android.b.b> linkedHashMap;
        String str;
        if (i6 == 0) {
            c(2);
            c(1);
            return;
        }
        if (i6 == 2) {
            linkedHashMap = this.f3721e;
            Logger.dd("GeofenceDataHelper", "save report geofence to file");
            str = "jpush_geofence_v5_report";
        } else {
            linkedHashMap = this.f3720d;
            Logger.dd("GeofenceDataHelper", "save show geofence to file");
            str = "jpush_geofence_v5";
        }
        if (linkedHashMap == null) {
            return;
        }
        try {
            File a6 = cn.jpush.android.ad.c.a(this.f3718a, str);
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, cn.jpush.android.b.b> entry : linkedHashMap.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue().a());
            }
            cn.jpush.android.ad.c.a(a6.getAbsolutePath(), jSONObject.toString());
        } catch (Throwable th) {
            Logger.ww("GeofenceDataHelper", "save geo to file error:" + th.getMessage());
        }
    }

    private void f(int i6) {
        int size = this.f3720d.size();
        if (size > i6) {
            Logger.dd("GeofenceDataHelper", "ShowGeofence count= " + size + ",limit=" + i6 + ",need remove earliest");
            Iterator<cn.jpush.android.b.b> it = this.f3720d.values().iterator();
            while (it.hasNext() && size > i6) {
                cn.jpush.android.b.b next = it.next();
                if (next != null) {
                    a(next);
                }
                it.remove();
                size--;
            }
        }
    }

    private LinkedHashMap<String, cn.jpush.android.b.b> a(Context context, int i6) {
        if (context == null) {
            Logger.w("GeofenceDataHelper", "unexcepted , context is null");
            return null;
        }
        LinkedHashMap<String, cn.jpush.android.b.b> linkedHashMap = new LinkedHashMap<>();
        try {
            File a6 = cn.jpush.android.ad.c.a(context, i6 == 2 ? "jpush_geofence_v5_report" : "jpush_geofence_v5");
            if (a6.exists()) {
                String c6 = cn.jpush.android.ad.c.c(a6);
                if (!TextUtils.isEmpty(c6)) {
                    JSONObject jSONObject = new JSONObject(c6);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        cn.jpush.android.b.b a7 = cn.jpush.android.b.b.a(context, jSONObject.getJSONObject(keys.next()));
                        if (a7 != null) {
                            linkedHashMap.put(a7.f3536a, a7);
                        }
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            try {
                Logger.w("GeofenceDataHelper", "load objects error:" + th.getMessage());
                return linkedHashMap;
            } finally {
                m.a((Closeable) null);
            }
        }
    }

    private boolean c(cn.jpush.android.b.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.f3536a) && bVar.f3537b != -1) {
            double d6 = bVar.f3542g;
            if (d6 >= -90.0d && d6 <= 90.0d) {
                double d7 = bVar.f3541f;
                if (d7 >= -180.0d && d7 <= 180.0d) {
                    return true;
                }
            }
        }
        Logger.ww("GeofenceDataHelper", "The geofence is invalid, won't operate!");
        return false;
    }

    private void e(int i6) {
        boolean z5;
        c(i6);
        a aVar = this.f3722f;
        if (aVar != null) {
            if (this.f3720d.isEmpty() && this.f3721e.isEmpty()) {
                z5 = true;
            } else {
                z5 = false;
            }
            aVar.a(z5);
        }
    }

    public void b(cn.jpush.android.b.b bVar) {
        StringBuilder sb;
        String str;
        if (c(bVar)) {
            int i6 = bVar.f3544i;
            LinkedHashMap<String, cn.jpush.android.b.b> d6 = d(i6);
            Logger.dd("GeofenceDataHelper", "Before add.Current geofence size:" + d6.size() + ",type:" + i6);
            cn.jpush.android.b.b bVar2 = d6.get(bVar.f3536a);
            if (bVar2 == null) {
                if (i6 == 2 && d6.size() >= f3717c) {
                    sb = new StringBuilder();
                    sb.append("Report geofence size limit :");
                    sb.append(f3717c);
                    sb.append(",won't add geofence");
                    str = bVar.f3536a;
                } else if (bVar.f3540e * 1000 <= System.currentTimeMillis()) {
                    sb = new StringBuilder();
                    sb.append("The geofence ");
                    sb.append(bVar.f3536a);
                    str = " is out of date, will not create!";
                } else {
                    f(this.f3719b - 1);
                    d6.put(bVar.f3536a, bVar);
                    a aVar = this.f3722f;
                    if (aVar != null) {
                        aVar.a(bVar);
                    }
                }
                sb.append(str);
                Logger.dd("GeofenceDataHelper", sb.toString());
                return;
            }
            if (bVar.f3540e * 1000 <= System.currentTimeMillis()) {
                d6.remove(bVar.f3536a);
                a(bVar2);
            } else {
                bVar.a(bVar2);
                d6.put(bVar.f3536a, bVar);
                a aVar2 = this.f3722f;
                if (aVar2 != null) {
                    aVar2.a(bVar2, bVar);
                }
            }
            e(i6);
        }
    }

    private boolean b(int i6) {
        LinkedHashMap<String, cn.jpush.android.b.b> linkedHashMap = i6 == 2 ? this.f3721e : this.f3720d;
        boolean z5 = false;
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            Iterator<Map.Entry<String, cn.jpush.android.b.b>> it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                cn.jpush.android.b.b value = it.next().getValue();
                if (value != null && value.f3540e * 1000 <= System.currentTimeMillis()) {
                    Logger.dd("GeofenceDataHelper", "Geofence " + value.f3536a + " is out of date!");
                    it.remove();
                    z5 = true;
                }
            }
        }
        return z5;
    }

    public void a(int i6) {
        cn.jpush.android.cache.a.d(this.f3718a, i6);
        this.f3719b = i6;
        f(i6);
    }

    public synchronized void a(Context context) {
        if (context == null) {
            return;
        }
        this.f3718a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f3719b = cn.jpush.android.cache.a.e(context, 10);
        b(context);
        f(this.f3719b);
    }

    public void a(cn.jpush.android.b.b bVar) {
        if (bVar == null || !TextUtils.isEmpty(bVar.f3536a)) {
            int i6 = bVar.f3544i;
            String str = bVar.f3536a;
            LinkedHashMap<String, cn.jpush.android.b.b> d6 = d(i6);
            Logger.dd("GeofenceDataHelper", "Before delete.Current geofence size:" + d6.size() + ",type:" + i6);
            if (d6.remove(str) != null) {
                e(i6);
                a aVar = this.f3722f;
                if (aVar != null) {
                    aVar.b(bVar);
                    return;
                }
                return;
            }
            Logger.d("GeofenceDataHelper", "geofence=" + bVar.f3536a + " already not exists");
        }
    }

    public void a(a aVar) {
        this.f3722f = aVar;
    }

    public void a(String str) {
        Logger.d("GeofenceDataHelper", "will delete geofence=" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        cn.jpush.android.b.b bVar = this.f3720d.get(str);
        cn.jpush.android.b.b bVar2 = this.f3721e.get(str);
        if (bVar != null) {
            a(bVar);
        }
        if (bVar2 != null) {
            a(bVar2);
        }
        if (bVar == null && bVar2 == null) {
            Logger.d("GeofenceDataHelper", "geofence=" + str + " already not exists");
        }
    }

    private void a(String str, JSONObject jSONObject, int i6, boolean z5) {
        a aVar;
        LinkedHashMap<String, cn.jpush.android.b.b> d6 = d(i6);
        Logger.dd("GeofenceDataHelper", "Before update.Current geofence size:" + d6.size() + ",type:" + i6);
        cn.jpush.android.b.b bVar = d6.get(str);
        if (bVar == null) {
            Logger.ww("GeofenceDataHelper", "can not update geofence because origin one not found");
            return;
        }
        bVar.b(jSONObject);
        if (bVar.f3540e * 1000 <= System.currentTimeMillis()) {
            d6.remove(str);
            a(bVar);
        } else if (z5 && (aVar = this.f3722f) != null) {
            aVar.a(bVar, bVar);
        }
        e(i6);
    }

    public void a(String str, JSONObject jSONObject, boolean z5) {
        int i6;
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        if (jSONObject.has("type")) {
            i6 = jSONObject.optInt("type", 1);
        } else {
            a(str, jSONObject, 1, z5);
            i6 = 2;
        }
        a(str, jSONObject, i6, z5);
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        LinkedHashMap<String, cn.jpush.android.b.b> linkedHashMap = new LinkedHashMap<>();
        int i6 = 0;
        while (true) {
            try {
                int length = jSONArray.length();
                int i7 = f3717c;
                if (length <= i7) {
                    i7 = jSONArray.length();
                }
                if (i6 >= i7) {
                    break;
                }
                cn.jpush.android.b.b a6 = cn.jpush.android.b.b.a(jSONArray.getJSONObject(i6));
                linkedHashMap.put(a6.f3536a, a6);
                i6++;
            } catch (Throwable th) {
                Logger.dd("GeofenceDataHelper", "Replace report geofences failed:" + th.getMessage());
                return;
            }
        }
        this.f3721e = linkedHashMap;
        e(2);
        a aVar = this.f3722f;
        if (aVar != null) {
            aVar.a(null, null);
        }
    }
}
