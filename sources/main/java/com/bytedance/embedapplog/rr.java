package com.bytedance.embedapplog;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class rr implements cw {

    /* renamed from: j, reason: collision with root package name */
    private static volatile rr f24045j;
    private final CopyOnWriteArraySet<cw> xt = new CopyOnWriteArraySet<>();

    public static rr j() {
        if (f24045j == null) {
            synchronized (rr.class) {
                try {
                    if (f24045j == null) {
                        f24045j = new rr();
                    }
                } finally {
                }
            }
        }
        return f24045j;
    }

    @Override // com.bytedance.embedapplog.cw
    public void xt(boolean z5, JSONObject jSONObject) {
        Iterator<cw> it = this.xt.iterator();
        while (it.hasNext()) {
            it.next().xt(z5, jSONObject);
        }
    }

    private rr() {
    }

    @Override // com.bytedance.embedapplog.cw
    public void j(String str, String str2, String str3) {
        Iterator<cw> it = this.xt.iterator();
        while (it.hasNext()) {
            it.next().j(str, str2, str3);
        }
    }

    @Override // com.bytedance.embedapplog.cw
    public void j(boolean z5, String str, String str2, String str3, String str4, String str5, String str6) {
        Iterator<cw> it = this.xt.iterator();
        while (it.hasNext()) {
            it.next().j(z5, str, str2, str3, str4, str5, str6);
        }
    }

    @Override // com.bytedance.embedapplog.cw
    public void j(boolean z5, JSONObject jSONObject) {
        Iterator<cw> it = this.xt.iterator();
        while (it.hasNext()) {
            it.next().j(z5, jSONObject);
        }
    }
}
