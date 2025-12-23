package com.bytedance.adsdk.ugeno.up;

import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.up.cw.xt;
import com.bytedance.adsdk.ugeno.up.m;
import com.bytedance.adsdk.ugeno.up.xt.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class g implements qv {
    private com.bytedance.adsdk.ugeno.xt.cw cw;

    /* renamed from: j, reason: collision with root package name */
    private j f23746j;

    /* renamed from: m, reason: collision with root package name */
    private boolean f23747m;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.cw.m f23748r;
    private boolean up;
    private Map<String, List<com.bytedance.adsdk.ugeno.up.cw.xt>> xt;

    public void j(com.bytedance.adsdk.ugeno.cw.m mVar) {
        this.f23748r = mVar;
    }

    public static class j {

        /* renamed from: j, reason: collision with root package name */
        public Map<String, List<com.bytedance.adsdk.ugeno.up.cw.xt>> f23749j;
        public Map<String, com.bytedance.adsdk.ugeno.up.cw.xt> xt;

        public j(Map<String, List<com.bytedance.adsdk.ugeno.up.cw.xt>> map, Map<String, com.bytedance.adsdk.ugeno.up.cw.xt> map2) {
            this.f23749j = map;
            this.xt = map2;
        }
    }

    public void cw() {
        List<com.bytedance.adsdk.ugeno.up.cw.xt> value;
        j jVar = this.f23746j;
        if (jVar == null) {
            return;
        }
        for (Map.Entry<String, List<com.bytedance.adsdk.ugeno.up.cw.xt>> entry : jVar.f23749j.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && !value.isEmpty()) {
                for (com.bytedance.adsdk.ugeno.up.cw.xt xtVar : value) {
                    if (xtVar instanceof com.bytedance.adsdk.ugeno.up.cw.cw) {
                        xtVar.j(this);
                        xtVar.j(new Object[0]);
                    }
                }
            }
        }
    }

    public void j() {
        List<com.bytedance.adsdk.ugeno.up.cw.xt> j6 = j("shake");
        if (j6 == null || j6.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.up.cw.xt xtVar : j6) {
            if (xtVar != null) {
                xtVar.j(this);
                xtVar.j(new Object[0]);
            }
        }
    }

    public void r() {
        List<com.bytedance.adsdk.ugeno.up.cw.xt> j6 = j("animateState");
        if (j6 == null || j6.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.up.cw.xt xtVar : j6) {
            if (xtVar != null) {
                xtVar.j(this);
                xtVar.j(new Object[0]);
            }
        }
    }

    public void up() {
        List<com.bytedance.adsdk.ugeno.up.cw.xt> j6 = j("timer");
        if (j6 == null || j6.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.up.cw.xt xtVar : j6) {
            if (xtVar != null) {
                xtVar.j(this);
                xtVar.j(new Object[0]);
            }
        }
    }

    public void xt() {
        List<com.bytedance.adsdk.ugeno.up.cw.xt> j6 = j("twist");
        if (j6 == null || j6.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.up.cw.xt xtVar : j6) {
            if (xtVar != null) {
                xtVar.j(this);
                xtVar.j(new Object[0]);
            }
        }
    }

    public g(com.bytedance.adsdk.ugeno.xt.cw cwVar, j jVar) {
        this.cw = cwVar;
        this.f23746j = jVar;
        if (jVar != null) {
            this.xt = jVar.f23749j;
        }
    }

    public boolean j(MotionEvent motionEvent) {
        List<com.bytedance.adsdk.ugeno.up.cw.xt> j6 = j("touchStart");
        if (j6 != null && !j6.isEmpty()) {
            for (com.bytedance.adsdk.ugeno.up.cw.xt xtVar : j6) {
                if (xtVar instanceof com.bytedance.adsdk.ugeno.up.cw.tl) {
                    xtVar.j(this);
                    xtVar.j(motionEvent);
                }
            }
        }
        List<com.bytedance.adsdk.ugeno.up.cw.xt> j7 = j("touchEnd");
        List<com.bytedance.adsdk.ugeno.up.cw.xt> j8 = j("tap");
        List<com.bytedance.adsdk.ugeno.up.cw.xt> j9 = j("slide");
        if (j6 != null && !j6.isEmpty()) {
            for (com.bytedance.adsdk.ugeno.up.cw.xt xtVar2 : j7) {
                if (xtVar2 instanceof com.bytedance.adsdk.ugeno.up.cw.ae) {
                    xtVar2.j(this);
                    this.f23747m = xtVar2.j(motionEvent);
                }
            }
        }
        if ((j8 != null && !j8.isEmpty()) || (j9 != null && !j9.isEmpty())) {
            if (this.f23747m && motionEvent.getAction() == 1) {
                return true;
            }
            if (j8 != null && !j8.isEmpty()) {
                for (com.bytedance.adsdk.ugeno.up.cw.xt xtVar3 : j8) {
                    if (xtVar3 instanceof com.bytedance.adsdk.ugeno.up.cw.up) {
                        xtVar3.j(this);
                        this.up = xtVar3.j(motionEvent);
                    }
                }
            }
            if (this.up) {
                return true;
            }
            if (j9 != null && !j9.isEmpty()) {
                for (com.bytedance.adsdk.ugeno.up.cw.xt xtVar4 : j9) {
                    if (xtVar4 instanceof com.bytedance.adsdk.ugeno.up.cw.r) {
                        xtVar4.j(this);
                        return xtVar4.j(motionEvent);
                    }
                }
            }
            return this.up;
        }
        return this.f23747m;
    }

    private void j(String str, List<m.j> list) {
        com.bytedance.adsdk.ugeno.up.xt.j j6;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (m.j jVar : list) {
            if (jVar != null && (j6 = j.C0324j.j(this.cw, str, jVar)) != null) {
                j6.j();
                j6.xt();
            }
        }
    }

    public List<com.bytedance.adsdk.ugeno.up.cw.xt> j(String str) {
        Map<String, List<com.bytedance.adsdk.ugeno.up.cw.xt>> map = this.xt;
        if (map == null || map.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.xt.get(str);
    }

    @Override // com.bytedance.adsdk.ugeno.up.qv
    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar, String str, List<m.j> list) {
        j(str, list);
    }

    public static g j(com.bytedance.adsdk.ugeno.xt.cw cwVar, String str) {
        com.bytedance.adsdk.ugeno.up.cw.xt j6;
        if (cwVar != null && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() <= 0) {
                    return null;
                }
                j jVar = new j(new HashMap(), new HashMap());
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                    if (optJSONObject != null && (j6 = xt.j.j(cwVar.g().getContext(), cwVar, optJSONObject, cwVar.oq())) != null) {
                        if (jVar.f23749j.containsKey(j6.ae())) {
                            List<com.bytedance.adsdk.ugeno.up.cw.xt> list = jVar.f23749j.get(j6.ae());
                            if (list == null) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(j6);
                                jVar.f23749j.put(j6.ae(), arrayList);
                            } else {
                                list.add(j6);
                            }
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(j6);
                            jVar.f23749j.put(j6.ae(), arrayList2);
                        }
                        jVar.xt.put(j6.tl(), j6);
                    }
                }
                return new g(cwVar, jVar);
            } catch (JSONException e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
        }
        return null;
    }
}
