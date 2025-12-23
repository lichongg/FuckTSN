package com.bytedance.sdk.component.j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.component.sdk.annotation.AnyThread;
import com.bytedance.component.sdk.annotation.MainThread;
import com.bytedance.sdk.component.j.ae;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j {
    ae ae;
    protected tl cw;

    /* renamed from: j, reason: collision with root package name */
    protected Context f26487j;
    protected String up;
    protected jy xt;

    /* renamed from: r, reason: collision with root package name */
    protected Handler f26489r = new Handler(Looper.getMainLooper());

    /* renamed from: m, reason: collision with root package name */
    protected volatile boolean f26488m = false;
    private final Map<String, ae> tl = new HashMap();

    protected abstract Context getContext(oq oqVar);

    protected abstract String j();

    protected abstract void j(oq oqVar);

    @AnyThread
    protected abstract void j(String str);

    protected void xt() {
        this.ae.j();
        Iterator<ae> it = this.tl.values().iterator();
        while (it.hasNext()) {
            it.next().j();
        }
        this.f26489r.removeCallbacksAndMessages(null);
        this.f26488m = true;
    }

    protected void invokeMethod(final String str) {
        if (this.f26488m) {
            return;
        }
        g.j("Received call: ".concat(String.valueOf(str)));
        this.f26489r.post(new Runnable() { // from class: com.bytedance.sdk.component.j.j.1
            @Override // java.lang.Runnable
            public void run() {
                av avVar;
                if (j.this.f26488m) {
                    return;
                }
                try {
                    avVar = j.this.j(new JSONObject(str));
                } catch (Exception e6) {
                    g.xt("Exception thrown while parsing function.", e6);
                    avVar = null;
                }
                if (!av.j(avVar)) {
                    j.this.j(avVar);
                    return;
                }
                g.j("By pass invalid call: ".concat(String.valueOf(avVar)));
                if (avVar != null) {
                    j.this.xt(x.j(new w(avVar.f26471j, "Failed to parse invocation.")), avVar);
                }
            }
        });
    }

    protected void j(String str, av avVar) {
        j(str);
    }

    protected j() {
    }

    @MainThread
    protected final void j(av avVar) {
        String j6;
        if (this.f26488m || (j6 = j()) == null) {
            return;
        }
        ae xt = xt(avVar.ae);
        if (xt == null) {
            g.xt("Received call with unknown namespace, ".concat(String.valueOf(avVar)));
            if (this.xt != null) {
                j();
            }
            xt(x.j(new w(-4, "Namespace " + avVar.ae + " unknown.")), avVar);
            return;
        }
        m mVar = new m();
        mVar.xt = j6;
        mVar.f26493j = this.f26487j;
        mVar.cw = xt;
        try {
            ae.j j7 = xt.j(avVar, mVar);
            if (j7 == null) {
                g.xt("Received call but not registered, ".concat(String.valueOf(avVar)));
                if (this.xt != null) {
                    j();
                }
                xt(x.j(new w(-2, "Function " + avVar.f26473r + " is not registered.")), avVar);
                return;
            }
            if (j7.f26470j) {
                xt(j7.xt, avVar);
            }
            if (this.xt != null) {
                j();
            }
        } catch (Exception e6) {
            g.j("call finished with error, ".concat(String.valueOf(avVar)), e6);
            xt(x.j(e6), avVar);
        }
    }

    final void xt(String str, av avVar) {
        JSONObject jSONObject;
        if (this.f26488m) {
            return;
        }
        if (TextUtils.isEmpty(avVar.f26472m)) {
            g.j("By passing js callback due to empty callback: ".concat(String.valueOf(str)));
            return;
        }
        if (!str.startsWith("{") || !str.endsWith("}")) {
            g.j(new IllegalArgumentException("Illegal callback data: ".concat(str)));
        }
        g.j("Invoking js callback: " + avVar.f26472m);
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        j(az.j().j("__msg_type", "callback").j("__callback_id", avVar.f26472m).j("__params", jSONObject).xt(), avVar);
    }

    private ae xt(String str) {
        if (!TextUtils.equals(str, this.up) && !TextUtils.isEmpty(str)) {
            return this.tl.get(str);
        }
        return this.ae;
    }

    final void j(oq oqVar, tj tjVar) {
        this.f26487j = getContext(oqVar);
        this.cw = oqVar.f26500r;
        this.xt = oqVar.f26497g;
        this.ae = new ae(oqVar, this, tjVar);
        this.up = oqVar.qv;
        j(oqVar);
    }

    final <T> void j(String str, T t5) {
        if (this.f26488m) {
            return;
        }
        String j6 = this.cw.j((tl) t5);
        g.j("Sending js event: ".concat(String.valueOf(str)));
        j("{\"__msg_type\":\"event\",\"__event_id\":\"" + str + "\",\"__params\":" + j6 + "}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public av j(JSONObject jSONObject) {
        String optString;
        Object opt;
        if (this.f26488m) {
            return null;
        }
        String optString2 = jSONObject.optString("__callback_id");
        String optString3 = jSONObject.optString("func");
        if (j() == null) {
            return null;
        }
        try {
            String string = jSONObject.getString("__msg_type");
            String str = "";
            try {
                opt = jSONObject.opt("params");
            } catch (Throwable unused) {
                optString = jSONObject.optString("params");
            }
            if (opt != null) {
                if (opt instanceof JSONObject) {
                    optString = String.valueOf((JSONObject) opt);
                    String string2 = jSONObject.getString("JSSDK");
                    String optString4 = jSONObject.optString("namespace");
                    return av.j().j(string2).xt(string).cw(optString3).r(optString).up(optString2).m(optString4).ae(jSONObject.optString("__iframe_url")).j();
                }
                if (opt instanceof String) {
                    str = (String) opt;
                } else {
                    str = String.valueOf(opt);
                }
            }
            optString = str;
            String string22 = jSONObject.getString("JSSDK");
            String optString42 = jSONObject.optString("namespace");
            return av.j().j(string22).xt(string).cw(optString3).r(optString).up(optString2).m(optString42).ae(jSONObject.optString("__iframe_url")).j();
        } catch (JSONException e6) {
            g.xt("Failed to create call.", e6);
            return av.j(optString2, -1);
        }
    }
}
