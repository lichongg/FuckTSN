package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class q1 {

    /* renamed from: a, reason: collision with root package name */
    private String f33634a;

    /* renamed from: b, reason: collision with root package name */
    public k0 f33635b;

    private boolean h(int i6) {
        String str;
        if (i6 != 2) {
            c1 e6 = e(i6);
            if (e6 != null && !TextUtils.isEmpty(e6.x())) {
                return true;
            }
            str = "verifyURL(): URL check failed. type: " + i6;
        } else {
            if ("_default_config_tag".equals(this.f33634a)) {
                return true;
            }
            str = "verifyURL(): type: preins. Only default config can report Pre-install data.";
        }
        j1.l("hmsSdk", str);
        return false;
    }

    private c1 e(int i6) {
        if (i6 == 0) {
            return this.f33635b.f();
        }
        if (i6 == 1) {
            return this.f33635b.d();
        }
        if (i6 == 2) {
            return this.f33635b.g();
        }
        if (i6 != 3) {
            return null;
        }
        return this.f33635b.a();
    }

    public void a(int i6) {
        j1.j("hmsSdk", "onReport. TAG: " + this.f33634a + ", TYPE: " + i6);
        t.a().d(this.f33634a, i6);
    }

    public void b(int i6, String str, LinkedHashMap<String, String> linkedHashMap) {
        j1.j("hmsSdk", "onEvent. TAG: " + this.f33634a + ", TYPE: " + i6 + ", eventId : " + str);
        if (n.b(str) || !h(i6)) {
            j1.l("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f33634a + ", TYPE: " + i6);
            return;
        }
        if (!n.e(linkedHashMap)) {
            j1.l("hmsSdk", "onEvent() parameter mapValue will be cleared.TAG: " + this.f33634a + ", TYPE: " + i6);
            linkedHashMap = null;
        }
        t.a().e(this.f33634a, i6, str, linkedHashMap);
    }

    public void c(Context context, String str, String str2) {
        j1.j("hmsSdk", "onEvent(context). TAG: " + this.f33634a + ", eventId : " + str);
        if (context == null) {
            j1.l("hmsSdk", "context is null in onevent ");
            return;
        }
        if (n.b(str) || !h(0)) {
            j1.l("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f33634a);
            return;
        }
        if (!n.c("value", str2, 65536)) {
            j1.l("hmsSdk", "onEvent() parameter VALUE is overlong, content will be cleared.TAG: " + this.f33634a);
            str2 = "";
        }
        t.a().f(this.f33634a, context, str, str2);
    }

    public void d(c1 c1Var) {
        j1.h("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : " + this.f33634a);
        if (c1Var != null) {
            this.f33635b.c(c1Var);
        } else {
            j1.l("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
            this.f33635b.c(null);
        }
    }

    public void f(int i6, String str, LinkedHashMap<String, String> linkedHashMap) {
        j1.j("hmsSdk", "onStreamEvent. TAG: " + this.f33634a + ", TYPE: " + i6 + ", eventId : " + str);
        if (n.b(str) || !h(i6)) {
            j1.l("hmsSdk", "onStreamEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f33634a + ", TYPE: " + i6);
            return;
        }
        if (!n.e(linkedHashMap)) {
            j1.l("hmsSdk", "onStreamEvent() parameter mapValue will be cleared.TAG: " + this.f33634a + ", TYPE: " + i6);
            linkedHashMap = null;
        }
        t.a().h(this.f33634a, i6, str, linkedHashMap);
    }

    public void g(c1 c1Var) {
        j1.h("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: " + this.f33634a);
        if (c1Var != null) {
            this.f33635b.e(c1Var);
        } else {
            this.f33635b.e(null);
            j1.l("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
        }
    }

    public q1(String str) {
        this.f33634a = str;
        this.f33635b = new k0(str);
        d1.e().c(this.f33634a, this.f33635b);
    }
}
