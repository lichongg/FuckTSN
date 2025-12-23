package com.bytedance.sdk.openadsdk.core.v;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.nd;
import com.bytedance.sdk.openadsdk.core.ugeno.ae;
import com.bytedance.sdk.openadsdk.core.v;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    public interface j {
        void j(int i6, String str);

        void j(JSONObject jSONObject);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.v.xt$xt, reason: collision with other inner class name */
    public interface InterfaceC0490xt {
        void j();

        void j(JSONObject jSONObject);
    }

    public static void j(com.bytedance.sdk.openadsdk.core.ugeno.m.j jVar, InterfaceC0490xt interfaceC0490xt) {
        if (jVar != null) {
            j(jVar.cw(), jVar.j(), jVar.xt(), interfaceC0490xt);
        } else if (interfaceC0490xt != null) {
            interfaceC0490xt.j();
        }
    }

    public static void j(String str, final String str2, final String str3, final InterfaceC0490xt interfaceC0490xt) {
        if (TextUtils.isEmpty(str)) {
            if (interfaceC0490xt != null) {
                interfaceC0490xt.j();
            }
        } else {
            com.bytedance.sdk.component.g.xt.cw cw = up.j().xt().cw();
            cw.j(str);
            cw.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.v.xt.1
                @Override // com.bytedance.sdk.component.g.j.j
                public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                    if (xtVar == null) {
                        return;
                    }
                    if (!xtVar.tl()) {
                        InterfaceC0490xt interfaceC0490xt2 = interfaceC0490xt;
                        if (interfaceC0490xt2 != null) {
                            interfaceC0490xt2.j();
                            return;
                        }
                        return;
                    }
                    String r5 = xtVar.r();
                    ae.j().j(str2, str3, r5);
                    if (interfaceC0490xt != null) {
                        try {
                            interfaceC0490xt.j(new JSONObject(r5));
                        } catch (JSONException e6) {
                            vl.j(e6);
                            interfaceC0490xt.j();
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.g.j.j
                public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                    InterfaceC0490xt interfaceC0490xt2 = interfaceC0490xt;
                    if (interfaceC0490xt2 != null) {
                        interfaceC0490xt2.j();
                    }
                }
            });
        }
    }

    public static void j(n nVar, JSONObject jSONObject, final com.bytedance.sdk.openadsdk.core.w.cw cwVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        if (cwVar == null) {
            return;
        }
        if (nVar != null) {
            try {
                if (!TextUtils.isEmpty(nVar.os())) {
                    int tl = uf.tl(nVar);
                    com.bytedance.sdk.openadsdk.i.cw.cw.xt rr = nVar.rr();
                    if (rr != null) {
                        xtVar = rr;
                    }
                    nd ndVar = new nd();
                    ndVar.f30365r = 2;
                    if (hh.m(nVar) != null) {
                        ndVar.f30364m = 2;
                    }
                    JSONObject ag = nVar.ag();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        Iterator<String> keys = ag.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject2.put(next, ag.opt(next));
                        }
                    } catch (JSONException e6) {
                        vl.j(e6);
                    }
                    if (jSONObject != null) {
                        Iterator<String> keys2 = jSONObject.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            jSONObject2.put(next2, jSONObject.opt(next2));
                        }
                    }
                    ndVar.vl = jSONObject2;
                    v.j().j(xtVar, ndVar, tl, new s.xt() { // from class: com.bytedance.sdk.openadsdk.core.v.xt.2
                        @Override // com.bytedance.sdk.openadsdk.core.s.xt
                        public void j(int i6, String str, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2) {
                            com.bytedance.sdk.openadsdk.core.w.cw.this.j(false, null, false);
                            xtVar2.j(i6);
                            com.bytedance.sdk.openadsdk.core.tj.xt.j(xtVar2);
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.s.xt
                        public void j(com.bytedance.sdk.openadsdk.core.tj.j jVar, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2) {
                            if (jVar.xt() != null && !jVar.xt().isEmpty()) {
                                com.bytedance.sdk.openadsdk.core.w.cw.this.j(true, jVar.xt(), false);
                                return;
                            }
                            com.bytedance.sdk.openadsdk.core.w.cw.this.j(false, null, false);
                            xtVar2.j(-3);
                            com.bytedance.sdk.openadsdk.core.tj.xt.j(xtVar2);
                        }
                    });
                    return;
                }
            } catch (Exception e7) {
                vl.cw("PageNetUtils", "get ads error", e7);
                return;
            }
        }
        cwVar.j(false, null, false);
    }

    public static void j(String str, final j jVar) {
        com.bytedance.sdk.component.g.xt.cw cw = up.j().xt().cw();
        cw.j(str);
        cw.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.v.xt.3
            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                if (xtVar == null || !xtVar.tl()) {
                    j jVar2 = j.this;
                    if (jVar2 == null || xtVar == null) {
                        return;
                    }
                    jVar2.j(xtVar.j(), xtVar.xt());
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(xtVar.r());
                    j jVar3 = j.this;
                    if (jVar3 != null) {
                        jVar3.j(jSONObject);
                    }
                } catch (JSONException e6) {
                    vl.j(e6);
                }
            }

            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                j jVar2 = j.this;
                if (jVar2 != null) {
                    jVar2.j(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, iOException.getMessage());
                }
            }
        });
    }
}
