package com.bytedance.msdk.ae.j;

import android.text.TextUtils;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.core.tl.jy;
import com.bytedance.msdk.core.tl.qv;
import com.bytedance.msdk.cw.tl.r;
import com.bytedance.msdk.j.up.m;
import com.bytedance.msdk.tl.l;
import com.bytedance.sdk.component.utils.vl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private static volatile cw f24313j;
    private volatile Map<Integer, l> xt = new ConcurrentHashMap();
    private Map<String, com.bytedance.msdk.core.oq.xt> cw = new ConcurrentHashMap();

    private void cw(final JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        m.r(new Runnable() { // from class: com.bytedance.msdk.ae.j.cw.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.ae.xt.xt.j().j(jSONArray);
            }
        });
    }

    private synchronized void xt(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    try {
                        this.cw.clear();
                        r.xt.clear();
                        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i6);
                            com.bytedance.msdk.core.oq.xt j6 = com.bytedance.msdk.core.oq.xt.j(jSONObject, false);
                            if (j6 != null && !TextUtils.isEmpty(j6.rn())) {
                                this.cw.put(j6.rn(), j6);
                                concurrentHashMap.put(j6.rn(), jSONObject.toString());
                            }
                        }
                        j(concurrentHashMap);
                        r.j();
                        com.bytedance.msdk.ae.j.j().j("prime_rit_count", jSONArray.length());
                    } catch (JSONException e6) {
                        vl.j(e6);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized boolean cw() {
        return com.bytedance.msdk.ae.j.j().xt("prime_rit_count", -1) <= 0;
    }

    private cw() {
    }

    public static cw j() {
        if (f24313j == null) {
            synchronized (cw.class) {
                try {
                    if (f24313j == null) {
                        f24313j = new cw();
                    }
                } finally {
                }
            }
        }
        return f24313j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized l j(int i6) {
        l lVar;
        lVar = this.xt.get(Integer.valueOf(i6));
        if (lVar == null) {
            lVar = com.bytedance.msdk.ae.j.j(i6);
            this.xt.put(Integer.valueOf(i6), lVar);
        }
        return lVar;
    }

    public synchronized void j(JSONArray jSONArray) {
        xt(jSONArray);
        cw(jSONArray);
    }

    public synchronized com.bytedance.msdk.core.oq.xt j(String str, int i6, int i7) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.bytedance.msdk.core.oq.xt xtVar = this.cw.get(str);
        if (xtVar == null && (xtVar = com.bytedance.msdk.core.oq.xt.ae(j(i6, str))) != null) {
            this.cw.put(str, xtVar);
        }
        if (i7 == 102) {
            return xtVar;
        }
        com.bytedance.msdk.core.oq.xt j6 = com.bytedance.msdk.core.g.r.j(xtVar, i7);
        return j6 != null ? j6 : xtVar;
    }

    public synchronized void xt() {
        Map<String, com.bytedance.msdk.core.oq.xt> map = this.cw;
        if (map != null) {
            map.clear();
        }
    }

    private String j(int i6, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (i6 == 0) {
            arrayList.add(1);
            arrayList.add(2);
            arrayList.add(3);
            arrayList.add(5);
            arrayList.add(7);
            arrayList.add(8);
            arrayList.add(9);
            arrayList.add(10);
        } else {
            arrayList.add(Integer.valueOf(i6));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String xt = j(((Integer) it.next()).intValue()).xt(str);
            if (!TextUtils.isEmpty(xt)) {
                return xt;
            }
        }
        return null;
    }

    private synchronized void j(final Map<String, String> map) {
        if (map != null) {
            if (map.size() != 0) {
                m.r(new Runnable() { // from class: com.bytedance.msdk.ae.j.cw.2
                    @Override // java.lang.Runnable
                    public void run() {
                        for (Map.Entry entry : map.entrySet()) {
                            try {
                                String str = (String) entry.getKey();
                                String str2 = (String) entry.getValue();
                                com.bytedance.msdk.core.oq.xt xtVar = (com.bytedance.msdk.core.oq.xt) cw.this.cw.get(str);
                                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && xtVar != null) {
                                    cw.this.j(xtVar.wq()).j(str, str2);
                                    cw.this.j(xtVar);
                                }
                            } catch (Throwable th) {
                                vl.j(th);
                            }
                        }
                        map.clear();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(com.bytedance.msdk.core.oq.xt xtVar) {
        if (xtVar != null) {
            try {
                if (xtVar.rn() != null) {
                    if (xtVar.oq()) {
                        if (jy.j().j(xtVar.g())) {
                            jy.j().xt(xtVar.g());
                        }
                        if (jy.j().j(xtVar.tl())) {
                            jy.j().xt(xtVar.tl());
                        }
                    } else {
                        jy.j().r(xtVar.rn());
                        jy.j().g(xtVar.rn());
                    }
                    for (oq oqVar : xtVar.ol()) {
                        if (oqVar.r()) {
                            if (com.bytedance.msdk.core.tl.vl.j().j(oqVar.cw())) {
                                com.bytedance.msdk.core.tl.vl.j().xt(oqVar.cw());
                            }
                            if (qv.j().j(oqVar.xt())) {
                                qv.j().xt(oqVar.xt());
                            }
                        } else {
                            com.bytedance.msdk.core.tl.vl.j().delete(xtVar.rn(), oqVar.w());
                            qv.j().delete(xtVar.rn(), oqVar.w());
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
