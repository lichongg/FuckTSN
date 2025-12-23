package com.bytedance.sdk.openadsdk.core.xt.j.xt;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.xt;
import com.bytedance.sdk.openadsdk.core.jy.m;
import com.bytedance.sdk.openadsdk.core.rn.tj;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.xp;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.l.ae;
import com.tencent.open.SocialConstants;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {
    private static volatile boolean tl;
    private xp ae;
    private final Context cw;

    /* renamed from: j, reason: collision with root package name */
    private Toast f31348j;

    /* renamed from: m, reason: collision with root package name */
    private boolean f31349m;

    /* renamed from: r, reason: collision with root package name */
    private int f31350r;
    private String up;
    private final n xt;

    public interface j {
        void j();

        void xt();
    }

    class xt implements s.cw<JSONObject> {

        /* renamed from: j, reason: collision with root package name */
        private final j f31355j;

        /* renamed from: r, reason: collision with root package name */
        private final Toast f31356r;
        private final xp xt;

        xt(j jVar, xp xpVar, Toast toast) {
            this.f31355j = jVar;
            this.xt = xpVar;
            this.f31356r = toast;
        }

        @Override // com.bytedance.sdk.openadsdk.core.s.cw
        public void j(int i6, String str) {
            vl.xt("WechatClickHandler", "getWechatLink failed:" + i6 + ", " + str);
            this.xt.xt(0);
            Toast toast = this.f31356r;
            if (toast != null) {
                toast.cancel();
            }
            j jVar = this.f31355j;
            if (jVar != null) {
                jVar.xt();
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.sdk.openadsdk.core.s.cw
        public void j(JSONObject jSONObject) {
            String optString = jSONObject.optString("scheme");
            if (!TextUtils.isEmpty(optString)) {
                up.this.j(optString, this.xt, this.f31355j);
            } else {
                j(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, " scheme is null!");
            }
        }
    }

    public up xt(boolean z5) {
        this.f31349m = z5;
        return this;
    }

    public up(n nVar, Context context) {
        this.xt = nVar;
        this.cw = context;
    }

    private int xt(j jVar) {
        xp al;
        n nVar = this.xt;
        if (nVar == null || (al = nVar.al()) == null) {
            return 0;
        }
        if (al.m() != 1 || !r.cw().j()) {
            return 1;
        }
        if (TextUtils.isEmpty(al.ae())) {
            return 0;
        }
        j(jVar, al);
        return 2;
    }

    public static boolean j() {
        return tl;
    }

    public static void j(boolean z5) {
        tl = z5;
    }

    public up j(String str) {
        this.up = str;
        return this;
    }

    public up j(int i6) {
        this.f31350r = i6;
        return this;
    }

    public boolean j(j jVar) {
        int xt2;
        if (this.ae == null) {
            n nVar = this.xt;
            this.ae = nVar != null ? nVar.al() : null;
        }
        xp xpVar = this.ae;
        if (xpVar == null) {
            return false;
        }
        int xt3 = xpVar.xt();
        if (xt3 != 1) {
            if (xt3 != 2 || (xt2 = xt(jVar)) == 0) {
                return false;
            }
            if (xt2 == 2) {
                return true;
            }
            if (TextUtils.isEmpty(this.ae.j())) {
                return false;
            }
            j(jVar, this.ae, 2000L);
            return true;
        }
        if (this.f31349m && (TextUtils.isEmpty(this.ae.tl()) || xt(jVar) == 2)) {
            return true;
        }
        return false;
    }

    private void xt() {
        ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xt.j.xt.up.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (up.this.f31348j != null) {
                        up.this.f31348j.cancel();
                    }
                    up upVar = up.this;
                    upVar.f31348j = a.j(upVar.cw, "即将跳转微信...", 1, 17, 0, 0);
                    up.this.f31348j.show();
                } catch (Throwable th) {
                    vl.cw("toast error:" + th.getMessage());
                }
            }
        });
    }

    private void j(final j jVar, xp xpVar) {
        xt();
        v.j().j(xpVar, this.xt.yb(), this.xt.os(), new xt(jVar, xpVar, this.f31348j) { // from class: com.bytedance.sdk.openadsdk.core.xt.j.xt.up.1
            @Override // com.bytedance.sdk.openadsdk.core.xt.j.xt.up.xt, com.bytedance.sdk.openadsdk.core.s.cw
            public void j(JSONObject jSONObject) {
                String optString = jSONObject.optString("userName");
                String optString2 = jSONObject.optString("path");
                if (TextUtils.isEmpty(optString)) {
                    j(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, " userName or path is null!");
                    return;
                }
                if (up.this.f31348j != null) {
                    up.this.f31348j.cancel();
                }
                r.cw().j(up.this.xt, optString, optString2, jVar, up.this.up, up.this.f31349m);
            }
        }, 1, 2000L);
    }

    private void j(j jVar, xp xpVar, long j6) {
        xt();
        v.j().j(xpVar, this.xt.yb(), this.xt.os(), new xt(jVar, xpVar, this.f31348j), 2, j6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, final xp xpVar, final j jVar) {
        Toast toast = this.f31348j;
        if (toast != null) {
            toast.cancel();
        }
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        intent.addFlags(268435456);
        final String j6 = tj.xt(this.xt) ? this.up : uf.j(this.f31350r);
        com.bytedance.sdk.component.utils.xt.j(this.cw, intent, new xt.j() { // from class: com.bytedance.sdk.openadsdk.core.xt.j.xt.up.3
            @Override // com.bytedance.sdk.component.utils.xt.j
            public void j() {
                xpVar.xt(1);
                com.bytedance.sdk.openadsdk.core.jy.cw.j(up.this.xt, j6, "deeplink_success_realtime", (Throwable) null);
                HashMap hashMap = new HashMap();
                hashMap.put(SocialConstants.PARAM_SOURCE, "WechatClickProcesser");
                com.bytedance.sdk.openadsdk.core.jy.cw.tl(up.this.xt, j6, "open_url_app", hashMap);
                m.j().j(up.this.xt, j6, false);
                j jVar2 = jVar;
                if (jVar2 != null) {
                    jVar2.j();
                }
            }

            @Override // com.bytedance.sdk.component.utils.xt.j
            public void j(Throwable th) {
                xpVar.xt(0);
                j jVar2 = jVar;
                if (jVar2 != null) {
                    jVar2.xt();
                }
            }
        }, TextUtils.equals("main", UMModuleRegister.INNER));
    }
}
