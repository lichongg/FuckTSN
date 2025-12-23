package cn.jiguang.as;

import android.content.Intent;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f1718a;

    /* renamed from: b, reason: collision with root package name */
    public String f1719b;

    /* renamed from: c, reason: collision with root package name */
    public int f1720c;

    /* renamed from: d, reason: collision with root package name */
    public String f1721d;

    /* renamed from: e, reason: collision with root package name */
    public Intent f1722e;

    /* renamed from: f, reason: collision with root package name */
    public Intent f1723f;

    /* renamed from: h, reason: collision with root package name */
    public String f1725h;

    /* renamed from: i, reason: collision with root package name */
    public String f1726i;

    /* renamed from: j, reason: collision with root package name */
    public int f1727j;

    /* renamed from: l, reason: collision with root package name */
    public String f1729l;

    /* renamed from: g, reason: collision with root package name */
    public int f1724g = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f1728k = 0;

    public c() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            String str = this.f1718a;
            String str2 = ((c) obj).f1718a;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public c(String str, String str2, int i6) {
        this.f1718a = str;
        this.f1719b = str2;
        this.f1720c = i6;
    }

    public String toString() {
        return "JWakeTargetInfo{packageName='" + this.f1718a + "', serviceName='" + this.f1719b + "', targetVersion=" + this.f1720c + ", providerAuthority='" + this.f1721d + "', activityIntent=" + this.f1722e + ", activityIntentBackup=" + this.f1723f + ", wakeType=" + this.f1724g + ", authenType=" + this.f1725h + ", instrumentationName=" + this.f1726i + ", cmd=" + this.f1727j + ", delaySecTime=" + this.f1728k + ", uExtra=" + this.f1729l + '}';
    }
}
