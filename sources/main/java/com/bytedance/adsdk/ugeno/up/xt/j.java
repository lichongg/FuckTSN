package com.bytedance.adsdk.ugeno.up.xt;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.up.m;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class j {

    /* renamed from: j, reason: collision with root package name */
    public static final HashSet<String> f23769j = new HashSet<>(Arrays.asList("convert", "dislike", "openAppPermission", "openAppPolicy", "openPrivacy", "openAppFunction", "close", "skip", "videoControl", "pauseVideo", "resumeVideo", "muteVideo", "preventEvent"));
    protected String ae;
    protected com.bytedance.adsdk.ugeno.xt.cw cw;

    /* renamed from: m, reason: collision with root package name */
    protected Map<String, String> f23770m;

    /* renamed from: r, reason: collision with root package name */
    protected String f23771r;
    protected String tl;
    protected String up;
    protected m.j xt;

    /* renamed from: com.bytedance.adsdk.ugeno.up.xt.j$j, reason: collision with other inner class name */
    public static class C0324j {
        public static j j(com.bytedance.adsdk.ugeno.xt.cw cwVar, String str, m.j jVar) {
            if (jVar == null) {
                return null;
            }
            com.bytedance.adsdk.ugeno.up.xt j6 = com.bytedance.adsdk.ugeno.up.r.j(jVar.xt());
            if (j6 == null) {
                return new cw(cwVar, str, jVar);
            }
            j j7 = j6.j(cwVar, str, jVar);
            return j7 == null ? new cw(cwVar, str, jVar) : j7;
        }
    }

    public abstract void j();

    private void up() {
        m.j jVar = this.xt;
        if (jVar == null) {
            return;
        }
        this.f23771r = jVar.j();
        this.up = this.xt.xt();
        Map<String, String> cw = this.xt.cw();
        this.f23770m = cw;
        if (cw == null || cw.isEmpty() || !this.f23770m.containsKey("emitCustomEvent")) {
            return;
        }
        this.tl = this.f23770m.get("emitCustomEvent");
    }

    public boolean r() {
        return !TextUtils.isEmpty(this.tl);
    }

    public j(com.bytedance.adsdk.ugeno.xt.cw cwVar, String str, m.j jVar) {
        this.cw = cwVar;
        this.xt = jVar;
        this.ae = str;
        up();
    }

    public void cw() {
        if (r()) {
            m.j jVar = new m.j();
            jVar.j("custom");
            jVar.xt("emit");
            HashMap hashMap = new HashMap();
            hashMap.put(CommonNetImpl.NAME, this.tl);
            jVar.j(hashMap);
            new xt(this.cw, this.up, jVar).j();
        }
    }

    public void xt() {
        cw();
    }
}
