package com.bytedance.sdk.component.xt.j;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class up extends az {

    /* renamed from: j, reason: collision with root package name */
    List<String> f27305j;
    List<String> xt;

    public static final class j {

        /* renamed from: j, reason: collision with root package name */
        private final List<String> f27306j = new ArrayList();
        private final List<String> xt = new ArrayList();

        public j j(String str, String str2) {
            this.f27306j.add(str);
            this.xt.add(str2);
            return this;
        }

        public up j() {
            return new up(this.f27306j, this.xt);
        }
    }

    up(List<String> list, List<String> list2) {
        this.f27305j = list;
        this.xt = list2;
    }
}
