package org.repackage.com.meizu.flyme.openidsdk;

import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes7.dex */
class SupportInfo {

    /* renamed from: a, reason: collision with root package name */
    String f51590a;

    /* renamed from: b, reason: collision with root package name */
    Boolean f51591b;

    void a(boolean z5) {
        this.f51591b = Boolean.valueOf(z5);
    }

    void b(String str) {
        this.f51590a = str;
    }

    boolean a() {
        return this.f51591b != null;
    }

    boolean b() {
        Boolean bool = this.f51591b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    SupportInfo() {
    }

    boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f51590a, str);
    }
}
