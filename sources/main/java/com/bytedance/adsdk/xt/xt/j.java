package com.bytedance.adsdk.xt.xt;

import com.bytedance.adsdk.xt.xt.cw.j.ae;
import com.bytedance.adsdk.xt.xt.cw.j.cw;
import com.bytedance.adsdk.xt.xt.cw.j.g;
import com.bytedance.adsdk.xt.xt.cw.j.m;
import com.bytedance.adsdk.xt.xt.cw.j.oq;
import com.bytedance.adsdk.xt.xt.cw.j.r;
import com.bytedance.adsdk.xt.xt.cw.j.tl;
import com.bytedance.adsdk.xt.xt.cw.j.up;
import com.bytedance.adsdk.xt.xt.cw.j.xt;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static final com.bytedance.adsdk.xt.xt.cw.j f23946j;
    private com.bytedance.adsdk.xt.xt.xt.j cw;

    /* renamed from: r, reason: collision with root package name */
    private Deque<com.bytedance.adsdk.xt.xt.xt.j> f23947r = new LinkedList();
    private String up;
    private final com.bytedance.adsdk.xt.xt.cw.j xt;

    public static j j(String str) {
        return new j(str, f23946j);
    }

    static {
        int i6 = 8;
        m[] mVarArr = {new oq(), new r(), new g(), new xt(), new up(), new com.bytedance.adsdk.xt.xt.cw.j.j(), new ae(), new cw(), new tl()};
        final com.bytedance.adsdk.xt.xt.cw.j jVar = new com.bytedance.adsdk.xt.xt.cw.j() { // from class: com.bytedance.adsdk.xt.xt.j.1
            @Override // com.bytedance.adsdk.xt.xt.cw.j
            public int j(String str, int i7, Deque<com.bytedance.adsdk.xt.xt.xt.j> deque) {
                return i7;
            }
        };
        while (i6 >= 0) {
            final m mVar = mVarArr[i6];
            i6--;
            jVar = new com.bytedance.adsdk.xt.xt.cw.j() { // from class: com.bytedance.adsdk.xt.xt.j.2
                @Override // com.bytedance.adsdk.xt.xt.cw.j
                public int j(String str, int i7, Deque<com.bytedance.adsdk.xt.xt.xt.j> deque) {
                    return m.this.j(str, i7, deque, jVar);
                }
            };
        }
        f23946j = jVar;
    }

    private void j() {
        int length = this.up.length();
        int i6 = 0;
        while (i6 < length) {
            int j6 = this.xt.j(this.up, i6, this.f23947r);
            if (j6 == i6) {
                throw new IllegalArgumentException("Unrecognized expression, unrecognized characters encountered during parsing:" + this.up.substring(0, i6));
            }
            i6 = j6;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            com.bytedance.adsdk.xt.xt.xt.j pollFirst = this.f23947r.pollFirst();
            if (pollFirst == null) {
                this.cw = com.bytedance.adsdk.xt.xt.up.xt.j(arrayList, this.up, i6);
                this.f23947r = null;
                return;
            }
            arrayList.add(0, pollFirst);
        }
    }

    private j(String str, com.bytedance.adsdk.xt.xt.cw.j jVar) {
        this.xt = jVar;
        this.up = str;
        try {
            j();
        } catch (Exception e6) {
            throw new com.bytedance.adsdk.xt.j.xt(str, e6);
        }
    }

    public <T> T j(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        hashMap.put("default_key", jSONObject);
        return (T) j(hashMap);
    }

    public <T> T j(Map<String, JSONObject> map) {
        return (T) this.cw.j(map);
    }
}
