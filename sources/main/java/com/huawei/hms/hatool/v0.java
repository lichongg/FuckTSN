package com.huawei.hms.hatool;

import java.util.Calendar;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class v0 {

    /* renamed from: a, reason: collision with root package name */
    private long f33666a = 1800000;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f33667b = false;

    /* renamed from: c, reason: collision with root package name */
    private a f33668c = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a {

        /* renamed from: a, reason: collision with root package name */
        String f33669a = UUID.randomUUID().toString().replace("-", "");

        /* renamed from: b, reason: collision with root package name */
        boolean f33670b;

        /* renamed from: c, reason: collision with root package name */
        private long f33671c;

        private boolean d(long j6, long j7) {
            return j7 - j6 >= v0.this.f33666a;
        }

        a(long j6) {
            this.f33669a += "_" + j6;
            this.f33671c = j6;
            this.f33670b = true;
            v0.this.f33667b = false;
        }

        private void c(long j6) {
            j1.h("hmsSdk", "getNewSession() session is flush!");
            String uuid = UUID.randomUUID().toString();
            this.f33669a = uuid;
            this.f33669a = uuid.replace("-", "");
            this.f33669a += "_" + j6;
            this.f33671c = j6;
            this.f33670b = true;
        }

        void a(long j6) {
            if (v0.this.f33667b) {
                v0.this.f33667b = false;
                c(j6);
            } else if (d(this.f33671c, j6) || b(this.f33671c, j6)) {
                c(j6);
            } else {
                this.f33671c = j6;
                this.f33670b = false;
            }
        }

        private boolean b(long j6, long j7) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j6);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j7);
            if (calendar.get(1) != calendar2.get(1) || calendar.get(6) != calendar2.get(6)) {
                return true;
            }
            return false;
        }
    }

    public String a() {
        a aVar = this.f33668c;
        if (aVar != null) {
            return aVar.f33669a;
        }
        j1.m("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    }

    void b(long j6) {
        a aVar = this.f33668c;
        if (aVar != null) {
            aVar.a(j6);
        } else {
            j1.h("hmsSdk", "Session is first flush");
            this.f33668c = new a(j6);
        }
    }

    public boolean f() {
        a aVar = this.f33668c;
        if (aVar != null) {
            return aVar.f33670b;
        }
        j1.m("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    }
}
