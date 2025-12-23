package cn.jpush.android.c;

import android.os.Bundle;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f3562a;

    /* renamed from: b, reason: collision with root package name */
    private int f3563b;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f3564c;

    public int a() {
        return this.f3563b;
    }

    public void a(Bundle bundle) {
        this.f3564c = bundle;
    }

    public String toString() {
        return "CmdMessage{cmd='" + this.f3562a + "', errorCode=" + this.f3563b + ", extra=" + this.f3564c + '}';
    }

    public a(String str, int i6) {
        this.f3562a = str;
        this.f3563b = i6;
    }
}
