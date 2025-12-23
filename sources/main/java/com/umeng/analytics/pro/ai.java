package com.umeng.analytics.pro;

import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ai {

    /* renamed from: a, reason: collision with root package name */
    private String f40833a;

    /* renamed from: e, reason: collision with root package name */
    private boolean f40837e = false;

    /* renamed from: d, reason: collision with root package name */
    private int f40836d = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f40835c = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f40834b = -1;

    private void a() {
        try {
            if (!this.f40833a.contains("-")) {
                this.f40836d = Integer.valueOf(this.f40833a).intValue();
                this.f40837e = false;
                return;
            }
            String[] split = this.f40833a.split("-");
            if (split.length == 2) {
                this.f40834b = Integer.valueOf(split[0]).intValue();
                int intValue = Integer.valueOf(split[1]).intValue();
                this.f40835c = intValue;
                if (this.f40834b < 1) {
                    this.f40834b = 1;
                }
                if (intValue > 24) {
                    this.f40835c = 24;
                }
            }
            this.f40837e = true;
        } catch (Throwable unused) {
        }
    }

    public ai(String str) {
        this.f40833a = str;
        if (!TextUtils.isEmpty(str)) {
            a();
        }
    }

    public boolean a(int i6) {
        int i7;
        if (this.f40837e) {
            int i8 = this.f40834b;
            return i8 != -1 && (i7 = this.f40835c) != -1 && i6 >= i8 && i6 <= i7;
        }
        int i9 = this.f40836d;
        return i9 != -1 && i6 == i9;
    }
}
