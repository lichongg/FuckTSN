package org.repackage.com.meizu.flyme.openidsdk;

/* loaded from: D:\Downloads\app\classes7.dex */
class ValueData {

    /* renamed from: a, reason: collision with root package name */
    public String f51592a;

    /* renamed from: b, reason: collision with root package name */
    public int f51593b;

    /* renamed from: c, reason: collision with root package name */
    public long f51594c = System.currentTimeMillis() + 86400000;

    public String toString() {
        return "ValueData{value='" + this.f51592a + "', code=" + this.f51593b + ", expired=" + this.f51594c + '}';
    }

    public ValueData(String str, int i6) {
        this.f51592a = str;
        this.f51593b = i6;
    }
}
