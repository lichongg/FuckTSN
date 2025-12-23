package com.amap.api.col.p0003l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class l9 {

    /* renamed from: a, reason: collision with root package name */
    public long f6745a;

    /* renamed from: b, reason: collision with root package name */
    public String f6746b;

    /* renamed from: d, reason: collision with root package name */
    public int f6748d;

    /* renamed from: e, reason: collision with root package name */
    public long f6749e;

    /* renamed from: g, reason: collision with root package name */
    public short f6751g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6752h;

    /* renamed from: c, reason: collision with root package name */
    public int f6747c = -113;

    /* renamed from: f, reason: collision with root package name */
    public long f6750f = 0;

    public static long a(String str) {
        if (str == null || str.length() == 0) {
            return 0L;
        }
        int i6 = 0;
        long j6 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            long charAt = str.charAt(length);
            long j7 = 48;
            if (charAt < 48 || charAt > 57) {
                if (charAt >= 97 && charAt <= 102) {
                    j7 = 87;
                } else if (charAt < 65 || charAt > 70) {
                    if (charAt != 58 && charAt != 124) {
                        return 0L;
                    }
                } else {
                    j7 = 55;
                }
            }
            j6 += (charAt - j7) << i6;
            i6 += 4;
        }
        if (i6 != 48) {
            return 0L;
        }
        return j6;
    }

    public static String c(long j6) {
        if (j6 < 0 || j6 > 281474976710655L) {
            return null;
        }
        return u9.a(u9.b(j6), ":");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public l9 clone() {
        l9 l9Var = new l9(this.f6752h);
        l9Var.f6745a = this.f6745a;
        l9Var.f6746b = this.f6746b;
        l9Var.f6747c = this.f6747c;
        l9Var.f6748d = this.f6748d;
        l9Var.f6749e = this.f6749e;
        l9Var.f6750f = this.f6750f;
        l9Var.f6751g = this.f6751g;
        l9Var.f6752h = this.f6752h;
        return l9Var;
    }

    public final String b() {
        return this.f6752h + "#" + this.f6745a;
    }

    public final String toString() {
        return "AmapWifi{mac=" + this.f6745a + ", ssid='" + this.f6746b + "', rssi=" + this.f6747c + ", frequency=" + this.f6748d + ", timestamp=" + this.f6749e + ", lastUpdateUtcMills=" + this.f6750f + ", freshness=" + ((int) this.f6751g) + ", connected=" + this.f6752h + '}';
    }

    public l9(boolean z5) {
        this.f6752h = z5;
    }
}
