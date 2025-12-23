package com.bytedance.sdk.component.panglearmor;

import android.content.Context;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private Context f26679j;

    /* renamed from: r, reason: collision with root package name */
    private boolean f26680r;
    private tl up;
    private String xt;

    public static class j {
        private final String cw;

        /* renamed from: j, reason: collision with root package name */
        private final Context f26681j;

        /* renamed from: r, reason: collision with root package name */
        private boolean f26682r = false;
        private tl up = null;
        private final String xt;

        public void j(tl tlVar) {
            this.up = tlVar;
        }

        public j j(boolean z5) {
            this.f26682r = z5;
            return this;
        }

        public j(Context context, String str, String str2) {
            this.f26681j = context;
            this.cw = str2;
            this.xt = str;
        }

        public ae j() {
            ae aeVar = new ae();
            aeVar.f26679j = this.f26681j;
            aeVar.xt = this.xt;
            aeVar.cw = this.cw;
            aeVar.up = this.up;
            aeVar.f26680r = this.f26682r;
            return aeVar;
        }
    }

    public boolean cw() {
        return this.f26680r;
    }

    public tl r() {
        return this.up;
    }

    public String xt() {
        return this.xt;
    }

    public Context j() {
        return this.f26679j;
    }
}
