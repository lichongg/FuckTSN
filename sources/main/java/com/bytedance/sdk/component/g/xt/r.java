package com.bytedance.sdk.component.g.xt;

import android.text.TextUtils;
import com.bytedance.sdk.component.xt.j.vl;
import com.bytedance.sdk.component.xt.j.ws;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class r {
    protected vl cw;

    /* renamed from: j, reason: collision with root package name */
    private Map<String, Object> f26457j;
    private Object xt;

    /* renamed from: r, reason: collision with root package name */
    protected String f26459r = null;
    protected final Map<String, String> up = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    protected String f26458m = null;
    protected boolean ae = false;

    public abstract com.bytedance.sdk.component.g.xt j();

    public void j(String str) {
        this.f26458m = str;
    }

    public void r(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.up.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void xt(String str, String str2) {
        this.up.put(str, str2);
    }

    public Map<String, Object> cw() {
        return this.f26457j;
    }

    protected void j(ws.j jVar) {
        if (jVar != null && this.up.size() > 0) {
            for (Map.Entry<String, String> entry : this.up.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    jVar.xt(key, value);
                }
            }
        }
    }

    public void up(Map<String, Object> map) {
        this.f26457j = map;
    }

    public void xt(String str) {
        this.f26459r = str;
    }

    public r(vl vlVar) {
        this.cw = vlVar;
        xt(UUID.randomUUID().toString());
    }

    public Object r() {
        return this.xt;
    }

    public String xt() {
        return this.f26459r;
    }

    public void j(boolean z5) {
        this.ae = z5;
    }
}
