package com.bytedance.sdk.openadsdk.xt;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.cw.cw;
import com.bykv.vk.openvk.component.video.api.cw.r;
import com.bytedance.sdk.component.utils.tl;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.v.up;
import com.bytedance.sdk.openadsdk.l.g;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    private Set<String> cw;

    /* renamed from: j, reason: collision with root package name */
    private Map<String, com.bytedance.sdk.openadsdk.xt.j> f31993j;
    private ReentrantLock xt;

    private static final class j {

        /* renamed from: j, reason: collision with root package name */
        private static final xt f31997j = new xt();
    }

    private JSONArray cw(JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2 = jSONObject.optJSONArray("creatives");
        JSONArray jSONArray = new JSONArray();
        if (optJSONArray2 != null) {
            for (int i6 = 0; i6 < optJSONArray2.length(); i6++) {
                JSONObject optJSONObject = optJSONArray2.optJSONObject(i6);
                if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("precache_brand_video")) != null) {
                    for (int i7 = 0; i7 < optJSONArray.length(); i7++) {
                        jSONArray.put(optJSONArray.opt(i7));
                    }
                }
            }
        }
        return jSONArray;
    }

    private com.bytedance.sdk.component.g.j xt() {
        return up.j().xt();
    }

    private xt() {
        this.f31993j = new HashMap();
        this.xt = new ReentrantLock();
        this.cw = new HashSet();
        String xt = com.bytedance.sdk.openadsdk.core.xt.j().xt("sdk_brand_video_cahce", "");
        if (TextUtils.isEmpty(xt)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(xt);
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                xt(jSONArray.optJSONObject(i6));
            }
        } catch (Throwable unused) {
        }
    }

    private void r() {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f31993j.keySet().iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.openadsdk.xt.j jVar = this.f31993j.get(it.next());
            if (jVar != null) {
                jSONArray.put(jVar.up());
            }
        }
        com.bytedance.sdk.openadsdk.core.xt.j().j("sdk_brand_video_cahce", jSONArray.toString());
    }

    private Map<String, com.bytedance.sdk.openadsdk.xt.j> up() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, com.bytedance.sdk.openadsdk.xt.j>> it = this.f31993j.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, com.bytedance.sdk.openadsdk.xt.j> next = it.next();
            if (next.getValue().r()) {
                hashMap.put(next.getKey(), next.getValue());
                it.remove();
            } else {
                arrayList.add(next.getValue());
            }
        }
        int size = this.f31993j.size() - v.xt().os();
        if (size > 0) {
            Collections.sort(arrayList, new Comparator<com.bytedance.sdk.openadsdk.xt.j>() { // from class: com.bytedance.sdk.openadsdk.xt.xt.3
                @Override // java.util.Comparator
                /* renamed from: j, reason: merged with bridge method [inline-methods] */
                public int compare(com.bytedance.sdk.openadsdk.xt.j jVar, com.bytedance.sdk.openadsdk.xt.j jVar2) {
                    long cw = jVar2.cw() - jVar.cw();
                    if (cw == 0) {
                        String j6 = g.j();
                        cw = jVar.j(j6) - jVar2.j(j6);
                    }
                    return (int) cw;
                }
            });
            for (int i6 = 0; i6 < size; i6++) {
                com.bytedance.sdk.openadsdk.xt.j jVar = (com.bytedance.sdk.openadsdk.xt.j) arrayList.get(i6);
                this.f31993j.remove(jVar.xt());
                hashMap.put(jVar.xt(), jVar);
            }
        }
        return hashMap;
    }

    private void xt(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.bytedance.sdk.openadsdk.xt.j jVar = new com.bytedance.sdk.openadsdk.xt.j(jSONObject);
            this.f31993j.put(jVar.xt(), jVar);
        }
    }

    private void delete(Map<String, com.bytedance.sdk.openadsdk.xt.j> map) {
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            map.get(it.next()).xt(g.j());
        }
    }

    public static xt j() {
        return j.f31997j;
    }

    public void j(JSONObject jSONObject) {
        final JSONArray cw = cw(jSONObject);
        if (cw == null || cw.length() == 0) {
            return;
        }
        tl.j().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.xt.xt.1
            @Override // java.lang.Runnable
            public void run() {
                cw.length();
                xt.this.j(cw);
            }
        }, 20000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(JSONArray jSONArray) {
        try {
            this.xt.lock();
            int length = jSONArray.length();
            for (int i6 = 0; i6 < length; i6++) {
                xt(jSONArray.optJSONObject(i6));
            }
            Map<String, com.bytedance.sdk.openadsdk.xt.j> up = up();
            int cw = cw();
            r();
            delete(up);
            this.xt.unlock();
            j(cw);
        } catch (Throwable th) {
            this.xt.unlock();
            throw th;
        }
    }

    private int cw() {
        Iterator<String> it = this.f31993j.keySet().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            r j6 = j(this.f31993j.get(it.next()));
            if (j6 != null) {
                String up = j6.up();
                String i7 = j6.i();
                String av = j6.av();
                File file = new File(up, i7);
                if (!file.exists() || file.length() <= 0) {
                    i6++;
                    if (this.cw.contains(i7)) {
                        vl.j("BrandVideoCacheManager", " task :" + i7 + " is running!");
                    } else {
                        this.cw.add(i7);
                        j(av, up, i7);
                    }
                }
            }
        }
        return i6;
    }

    private void j(int i6) {
        File[] listFiles = new File(g.j()).listFiles();
        int os = v.xt().os();
        if (listFiles == null || listFiles.length <= os - i6) {
            return;
        }
        for (int i7 = 0; i7 < listFiles.length; i7++) {
            String j6 = j(listFiles[i7]);
            if (!this.f31993j.containsKey(j6) && listFiles[i7].exists()) {
                listFiles[i7].delete();
                vl.xt("BrandVideoCacheManager", "delete not need:".concat(String.valueOf(j6)));
            }
        }
    }

    private String j(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        return lastIndexOf != -1 ? name.substring(0, lastIndexOf) : name;
    }

    private void j(final String str, String str2, final String str3) {
        com.bytedance.sdk.component.g.xt.xt r5 = xt().r();
        r5.j(str);
        r5.j(str2, str3);
        r5.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.xt.xt.2
            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                xt.this.j(str3);
            }

            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                vl.xt("BrandVideoCacheManager", "download " + str + " failed: " + iOException);
                xt.this.j(str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str) {
        try {
            this.xt.lock();
            this.cw.remove(str);
        } finally {
            this.xt.unlock();
        }
    }

    private r j(com.bytedance.sdk.openadsdk.xt.j jVar) {
        if (jVar == null) {
            return null;
        }
        String xt = jVar.xt();
        if (TextUtils.isEmpty(xt)) {
            xt = com.bytedance.sdk.component.utils.up.xt(jVar.j());
        }
        cw cwVar = new cw();
        cwVar.cw(jVar.j());
        cwVar.up(xt);
        cwVar.up(0);
        r rVar = new r(g.j(), cwVar, cwVar, 0, 0);
        rVar.j(g.j());
        return rVar;
    }
}
