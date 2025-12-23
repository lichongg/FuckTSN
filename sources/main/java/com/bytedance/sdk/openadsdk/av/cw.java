package com.bytedance.sdk.openadsdk.av;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.oq;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    public String cw;

    /* renamed from: j, reason: collision with root package name */
    public String f27619j;

    /* renamed from: r, reason: collision with root package name */
    private String f27620r;
    public String xt;

    /* renamed from: com.bytedance.sdk.openadsdk.av.cw$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class j {

        /* renamed from: j, reason: collision with root package name */
        private static cw f27621j = new cw(null);
    }

    /* synthetic */ cw(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static cw j() {
        return j.f27621j;
    }

    public String cw() {
        Map<String, Object> qv = qv();
        if (qv == null) {
            return null;
        }
        Object obj = qv.get("blt");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public String xt() {
        Map<String, Object> qv;
        try {
            qv = qv();
        } catch (Exception e6) {
            vl.j(e6);
        }
        if (qv == null) {
            cw(null);
            return null;
        }
        Object obj = qv.get("motion_info");
        if (obj instanceof String) {
            if (TextUtils.equals("0", (String) obj)) {
                cw("0");
                return "0";
            }
            cw("1");
            return "1";
        }
        cw(null);
        return null;
    }

    private cw() {
    }

    private boolean j(String str) {
        return !TextUtils.equals(str, "0");
    }

    private Map<String, Object> qv() {
        com.bytedance.sdk.openadsdk.i.cw.cw.r w5;
        if (h.xt >= 6408 && (w5 = oq.i().w()) != null) {
            return w5.az();
        }
        return null;
    }

    private String oq() {
        Map<String, Object> qv = qv();
        if (qv != null) {
            Object obj = qv.get("od");
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }
        return null;
    }

    private boolean vl() {
        String f6 = oq.i().f();
        if (TextUtils.isEmpty(f6)) {
            return false;
        }
        f6.getClass();
        switch (f6) {
        }
        return false;
    }

    public boolean ae() {
        Map<String, Object> qv = qv();
        if (qv != null) {
            Object obj = qv.get("mcod");
            if (obj instanceof String) {
                String str = (String) obj;
                this.xt = str;
                if (!TextUtils.equals(str, "0")) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    public boolean g() {
        return xt(cw());
    }

    public boolean m() {
        if (!vl()) {
            return true;
        }
        return j(oq());
    }

    public void r() {
        if (vl()) {
            String oq = oq();
            if (!TextUtils.equals(oq, this.f27619j)) {
                com.bytedance.sdk.openadsdk.core.live.xt.j().j("setOaidEnabled", j(oq));
                this.f27619j = oq;
            }
        }
    }

    public boolean tl() {
        Map<String, Object> qv = qv();
        if (qv != null) {
            Object obj = qv.get("mcbcid");
            if (obj instanceof String) {
                String str = (String) obj;
                this.cw = str;
                if (!TextUtils.equals(str, "0")) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    public boolean up() {
        if (!TextUtils.equals(xt(), "0")) {
            return true;
        }
        return false;
    }

    private void cw(String str) {
        if (!TextUtils.equals(this.f27620r, str)) {
            com.bytedance.sdk.openadsdk.core.live.xt.j().j("setSensorEnable", !TextUtils.equals(str, "0"));
        }
        this.f27620r = str;
    }

    private boolean xt(String str) {
        return !TextUtils.equals(str, "0");
    }
}
