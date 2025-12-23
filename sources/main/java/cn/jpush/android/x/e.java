package cn.jpush.android.x;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.SchedulerReceiver;
import cn.jpush.android.x.b;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static volatile e f3999a;

    /* renamed from: b, reason: collision with root package name */
    private LinkedList<a> f4000b;

    /* renamed from: c, reason: collision with root package name */
    private LinkedList<a> f4001c;

    /* renamed from: d, reason: collision with root package name */
    private final Comparator<a> f4002d = new Comparator<a>() { // from class: cn.jpush.android.x.e.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(a aVar, a aVar2) {
            if (aVar.f4004a < aVar2.f4004a) {
                return -1;
            }
            if (aVar.f4004a == aVar2.f4004a) {
                return 0;
            }
            return 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private long f4004a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f4005b;

        /* renamed from: c, reason: collision with root package name */
        private cn.jpush.android.d.d f4006c;

        /* renamed from: d, reason: collision with root package name */
        private int f4007d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f4008e;

        public a(long j6, int i6) {
            this.f4004a = j6;
            this.f4005b = false;
            this.f4007d = i6;
        }

        public a(long j6, cn.jpush.android.d.d dVar, boolean z5) {
            this.f4004a = j6;
            this.f4005b = true;
            this.f4006c = dVar;
            this.f4008e = z5;
        }

        public JSONObject a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("operationTime", this.f4004a);
                jSONObject.put("showOrDismiss", this.f4005b);
                if (!this.f4005b) {
                    jSONObject.put("notifyId", this.f4007d);
                    return jSONObject;
                }
                cn.jpush.android.d.d dVar = this.f4006c;
                jSONObject.put("pushEntity", dVar != null ? dVar.c() : null);
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }

        public String toString() {
            return "Item{operationTime=" + this.f4004a + ", showOrDismiss=" + this.f4005b + ", pushEntity=" + this.f4006c + ", notifyId=" + this.f4007d + ", isDelayByInapp=" + this.f4008e + '}';
        }

        public a(JSONObject jSONObject) {
            try {
                this.f4004a = jSONObject.getLong("operationTime");
                this.f4005b = jSONObject.optBoolean("showOrDismiss");
                String optString = jSONObject.optString("pushEntity");
                if (!TextUtils.isEmpty(optString)) {
                    this.f4006c = cn.jpush.android.d.d.b(optString);
                }
                this.f4007d = jSONObject.optInt("notifyId");
            } catch (Throwable unused) {
            }
        }
    }

    public static e a() {
        if (f3999a == null) {
            synchronized (e.class) {
                try {
                    if (f3999a == null) {
                        f3999a = new e();
                    }
                } finally {
                }
            }
        }
        return f3999a;
    }

    public void b(Context context) {
        if (this.f4000b != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<a> it = this.f4000b.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.f4008e) {
                    this.f4001c.add(next);
                } else {
                    jSONArray.put(next.a());
                }
            }
            String jSONArray2 = jSONArray.toString();
            Collections.sort(this.f4000b, this.f4002d);
            Sp.set(context, Key.NotiSchedule().set(jSONArray2));
        }
    }

    private void b(Context context, a aVar) {
        try {
            Logger.d("NotificationScheduler", "schedule item=" + aVar);
            Intent intent = new Intent(context, (Class<?>) SchedulerReceiver.class);
            intent.setAction(SchedulerReceiver.DELAY_NOTIFY);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 1000, intent, 67108864);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (alarmManager != null) {
                alarmManager.setWindow(0, aVar.f4004a, 300L, broadcast);
                Logger.d("NotificationScheduler", "setAlarm at=" + cn.jpush.android.ad.b.a("yyyy-MM-dd HH:mm:ss").format(new Date(aVar.f4004a)));
            }
        } catch (Throwable th) {
            Logger.ww("NotificationScheduler", "can't trigger alarm cause by exception:" + th);
        }
    }

    public void a(Context context) {
        this.f4000b = new LinkedList<>();
        if (this.f4001c == null) {
            this.f4001c = new LinkedList<>();
        }
        String str = (String) Sp.get(context, Key.NotiSchedule());
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    this.f4000b.add(new a(jSONArray.getJSONObject(i6)));
                }
            } catch (Throwable unused) {
            }
        }
        if (this.f4001c.size() > 0) {
            this.f4000b.addAll(this.f4001c);
            this.f4001c.clear();
            Collections.sort(this.f4000b, this.f4002d);
        }
    }

    private e() {
    }

    public synchronized void a(Context context, a aVar) {
        try {
            a(context);
            LinkedList<a> linkedList = new LinkedList<>();
            long currentTimeMillis = System.currentTimeMillis();
            boolean z5 = aVar != null;
            Iterator<a> it = this.f4000b.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (z5 && next.f4004a > aVar.f4004a) {
                    a(context, linkedList, currentTimeMillis, aVar);
                    z5 = false;
                }
                a(context, linkedList, currentTimeMillis, next);
            }
            if (z5) {
                a(context, linkedList, currentTimeMillis, aVar);
            }
            this.f4000b = linkedList;
            b(context);
            if (!linkedList.isEmpty()) {
                b(context, linkedList.getFirst());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private static void a(Context context, LinkedList<a> linkedList, long j6, a aVar) {
        if (aVar == null) {
            return;
        }
        if (aVar.f4006c != null && TextUtils.equals(aVar.f4006c.K, "ssp")) {
            Logger.d("NotificationScheduler", "ssp notification message");
            return;
        }
        if (aVar.f4004a > j6) {
            linkedList.add(aVar);
            return;
        }
        if (aVar.f4005b) {
            if (aVar.f4006c != null && d.a(context, aVar.f4006c.f3588d, aVar.f4006c.f3592h, aVar.f4006c.f3585a)) {
                Logger.d("NotificationScheduler", "item: " + aVar + " already cancel");
                return;
            }
            long b6 = cn.jpush.android.ad.b.b(aVar.f4006c.aw);
            int a6 = b.a(aVar.f4006c);
            if (b6 <= 0) {
                Logger.d("NotificationScheduler", "handleNotification:" + aVar);
                b.a.a(context, aVar.f4006c);
                return;
            }
            if (b6 <= j6) {
                Logger.d("NotificationScheduler", "cancelNotification:" + aVar);
                b.d(context, a6);
                return;
            }
            Logger.d("NotificationScheduler", "handleNotification:" + aVar);
            b.a.a(context, aVar.f4006c);
            linkedList.add(new a(b6, a6));
            return;
        }
        Logger.d("NotificationScheduler", "cancelNotification:" + aVar);
        b.d(context, aVar.f4007d);
    }
}
