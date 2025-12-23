package com.bytedance.sdk.openadsdk.core.component.reward.xt;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.av;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.multipro.xt.j;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.qv.cw.oq;
import com.bytedance.sdk.openadsdk.core.qv.r.cw;
import com.bytedance.sdk.openadsdk.core.qv.tl;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qv;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private String ae;

    /* renamed from: j, reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.qv.xt.cw f28508j;

    /* renamed from: m, reason: collision with root package name */
    private String f28509m;

    /* renamed from: r, reason: collision with root package name */
    private TTBaseVideoActivity f28510r;
    private n up;
    View xt = null;
    final Map<String, com.bytedance.sdk.openadsdk.core.qv.xt.cw> cw = Collections.synchronizedMap(new HashMap());
    private long tl = 0;

    /* renamed from: g, reason: collision with root package name */
    private long f28507g = 0;
    private long oq = 0;
    private long qv = 0;
    private long vl = 0;
    private long jy = 0;
    private boolean az = true;
    private final cw av = new cw();
    private boolean ws = false;

    public class cw implements DownloadListener {
        private boolean xt = true;

        public cw() {
        }

        public void j(boolean z5) {
            this.xt = z5;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j6) {
            j(this.xt);
            j.this.j(str, true);
            j.this.f28510r.j(1);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.component.reward.xt.j$j, reason: collision with other inner class name */
    public interface InterfaceC0445j {
        void j(View view, qv qvVar);

        void j(String str, JSONObject jSONObject);
    }

    public interface xt {
        void cw(boolean z5, long j6, long j7, String str, String str2);

        void j(boolean z5);

        void j(boolean z5, long j6, long j7, String str, String str2);

        void j(boolean z5, long j6, String str, String str2);

        void j(boolean z5, String str, String str2);

        void xt(boolean z5, long j6, long j7, String str, String str2);
    }

    private void tl() {
        n nVar = this.up;
        if (nVar == null || nVar.jl() != 4) {
            return;
        }
        this.f28508j = tl.j((Context) this.f28510r, this.up, this.f28509m, false);
    }

    public cw ae() {
        return this.av;
    }

    public j(TTBaseVideoActivity tTBaseVideoActivity) {
        this.f28510r = tTBaseVideoActivity;
    }

    public boolean cw() {
        return this.f28508j != null;
    }

    public void j(n nVar, String str, String str2) {
        if (this.ws) {
            return;
        }
        this.ws = true;
        this.up = nVar;
        this.f28509m = str;
        tl();
        this.ae = str2;
    }

    public void m() {
        com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = this.f28508j;
        if (cwVar != null) {
            cwVar.xt();
        }
        for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.qv.xt.cw> entry : this.cw.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().xt();
            }
        }
        try {
            j(this.ae);
        } catch (Throwable th) {
            vl.cw("RewardFullDownloadManager", "remove from ITTAppDownloadListener throw Exception : ", th);
        }
    }

    public void r() {
        com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = this.f28508j;
        if (cwVar != null) {
            cwVar.j(this.f28510r);
            this.f28508j.j();
        }
        for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.qv.xt.cw> entry : this.cw.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().j();
            }
        }
    }

    public void up() {
        for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.qv.xt.cw> entry : this.cw.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue();
            }
        }
    }

    public com.bytedance.sdk.openadsdk.core.qv.xt.cw xt() {
        return this.f28508j;
    }

    public void j() {
        n nVar;
        if (this.f28508j == null && (nVar = this.up) != null && nVar.jl() == 4) {
            this.f28508j = tl.j((Context) this.f28510r, this.up, this.f28509m, false);
        }
    }

    private void j(final String str) {
        ae.xt(new g("executeMultiProcessAppDownloadCallBack") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xt.j.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    j.this.j(3).j(str, "recycleRes", 0L, 0L, "", "");
                } catch (Throwable th) {
                    vl.cw("RewardFullDownloadManager", "executeAppDownloadCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    protected av j(int i6) {
        return av.j.j(com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j(v.getContext()).j(i6));
    }

    public void j(final xt xtVar) {
        com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = this.f28508j;
        if (cwVar == null) {
            return;
        }
        cwVar.j(new com.bytedance.sdk.openadsdk.core.qv.xt.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xt.j.2
            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void j() {
                boolean z5;
                if (System.currentTimeMillis() - j.this.tl > NativeExpressView.f29606w) {
                    j.this.tl = System.currentTimeMillis();
                    z5 = true;
                } else {
                    z5 = false;
                }
                xt xtVar2 = xtVar;
                if (xtVar2 != null) {
                    xtVar2.j(z5);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void cw(long j6, long j7, String str, String str2) {
                boolean z5;
                if (System.currentTimeMillis() - j.this.qv > NativeExpressView.f29606w) {
                    j.this.qv = System.currentTimeMillis();
                    z5 = true;
                } else {
                    z5 = false;
                }
                xt xtVar2 = xtVar;
                if (xtVar2 != null) {
                    xtVar2.cw(z5, j6, j7, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void xt(long j6, long j7, String str, String str2) {
                boolean z5;
                if (System.currentTimeMillis() - j.this.f28507g > NativeExpressView.f29606w) {
                    j.this.f28507g = System.currentTimeMillis();
                    z5 = true;
                } else {
                    z5 = false;
                }
                xt xtVar2 = xtVar;
                if (xtVar2 != null) {
                    xtVar2.xt(z5, j6, j7, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void j(long j6, long j7, String str, String str2) {
                boolean z5;
                if (System.currentTimeMillis() - j.this.oq > NativeExpressView.f29606w) {
                    j.this.oq = System.currentTimeMillis();
                    z5 = true;
                } else {
                    z5 = false;
                }
                xt xtVar2 = xtVar;
                if (xtVar2 != null) {
                    xtVar2.j(z5, j6, j7, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void j(long j6, String str, String str2) {
                boolean z5;
                if (System.currentTimeMillis() - j.this.vl > NativeExpressView.f29606w) {
                    j.this.vl = System.currentTimeMillis();
                    z5 = true;
                } else {
                    z5 = false;
                }
                xt xtVar2 = xtVar;
                if (xtVar2 != null) {
                    xtVar2.j(z5, j6, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
            public void j(String str, String str2) {
                boolean z5;
                if (System.currentTimeMillis() - j.this.jy > NativeExpressView.f29606w) {
                    j.this.jy = System.currentTimeMillis();
                    z5 = true;
                } else {
                    z5 = false;
                }
                xt xtVar2 = xtVar;
                if (xtVar2 != null) {
                    xtVar2.j(z5, str, str2);
                }
            }
        });
    }

    public void j(String str, boolean z5) {
        if (this.cw.containsKey(str)) {
            com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = this.cw.get(str);
            if (cwVar != null) {
                if (z5) {
                    cwVar.j(oq.j(this.up));
                }
                if (cwVar instanceof com.bytedance.sdk.openadsdk.core.qv.cw.up) {
                    ((com.bytedance.sdk.openadsdk.core.qv.cw.up) cwVar).tl().j(this.az);
                } else if (cwVar instanceof com.bytedance.sdk.openadsdk.core.qv.cw.tl) {
                    ((com.bytedance.sdk.openadsdk.core.qv.cw.tl) cwVar).m().j(this.az);
                }
                cwVar.j(uf.mi(this.up), false);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.qv.xt.cw j6 = tl.j(this.f28510r, str, this.up, this.f28509m);
        if (z5) {
            j6.j(oq.j(this.up));
        }
        if (j6 instanceof com.bytedance.sdk.openadsdk.core.qv.cw.up) {
            ((com.bytedance.sdk.openadsdk.core.qv.cw.up) j6).tl().j(this.az);
        } else if (j6 instanceof com.bytedance.sdk.openadsdk.core.qv.cw.tl) {
            ((com.bytedance.sdk.openadsdk.core.qv.cw.tl) j6).m().j(this.az);
        }
        this.cw.put(str, j6);
        j6.j(uf.mi(this.up), false);
    }

    public void j(final InterfaceC0445j interfaceC0445j) {
        this.f28508j.j(1, new cw.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xt.j.3
            @Override // com.bytedance.sdk.openadsdk.core.qv.r.cw.j
            public boolean j(int i6, String str, String str2, String str3, Object obj) {
                if (i6 == 1 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if ((str2.equals("rewarded_video") || str2.equals("fullscreen_interstitial_ad")) && str3.equals("click_start")) {
                        interfaceC0445j.j(j.this.xt, new qv());
                        j.this.xt = null;
                        return true;
                    }
                    if (str2.equals("fullscreen_interstitial_ad") || str2.equals("rewarded_video")) {
                        str3.getClass();
                        if (str3.equals("click_continue")) {
                            com.bytedance.sdk.openadsdk.core.jy.cw.xt(j.this.up, str2, "click_play_continue", (Map<String, Object>) null);
                        } else if (str3.equals("click_pause")) {
                            com.bytedance.sdk.openadsdk.core.jy.cw.xt(j.this.up, str2, "click_play_pause", (Map<String, Object>) null);
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            }
        });
    }

    public void j(View view, InterfaceC0445j interfaceC0445j, qv qvVar) {
        if (this.f28508j != null && view != null) {
            if (view.getId() == 2114387615) {
                interfaceC0445j.j("click_play_star_level", (JSONObject) null);
                return;
            }
            if (view.getId() == 2114387636) {
                interfaceC0445j.j("click_play_star_nums", (JSONObject) null);
                return;
            } else if (view.getId() == 2114387881) {
                interfaceC0445j.j("click_play_source", (JSONObject) null);
                return;
            } else {
                if (view.getId() == 2114387799) {
                    interfaceC0445j.j("click_play_logo", (JSONObject) null);
                    return;
                }
                return;
            }
        }
        interfaceC0445j.j(view, qvVar);
    }

    public void j(j.InterfaceC0466j interfaceC0466j) {
        com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = this.f28508j;
        if (cwVar != null) {
            cwVar.j(interfaceC0466j);
        }
    }
}
