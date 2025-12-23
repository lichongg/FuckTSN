package com.bytedance.sdk.openadsdk.tools;

import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.wq.j.cw;
import com.bytedance.sdk.openadsdk.l.ae;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class j implements cw.j {

    /* renamed from: j, reason: collision with root package name */
    private final cw.j f31851j;
    private xt xt = new xt();

    /* renamed from: com.bytedance.sdk.openadsdk.tools.j$j, reason: collision with other inner class name */
    private interface InterfaceC0504j {
        void j(String str, String str2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.cw.j
    public void cw(String str, String str2) {
        if (str2 == null || str2.length() <= 4096) {
            this.f31851j.cw(str, str2);
        } else {
            j(str, str2, new InterfaceC0504j() { // from class: com.bytedance.sdk.openadsdk.tools.j.3
                @Override // com.bytedance.sdk.openadsdk.tools.j.InterfaceC0504j
                public void j(String str3, String str4) {
                    j.this.f31851j.cw(str3, str4);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.cw.j
    public void j(String str, String str2) {
        if (str2 == null || str2.length() <= 4096) {
            this.f31851j.j(str, str2);
        } else {
            j(str, str2, new InterfaceC0504j() { // from class: com.bytedance.sdk.openadsdk.tools.j.1
                @Override // com.bytedance.sdk.openadsdk.tools.j.InterfaceC0504j
                public void j(String str3, String str4) {
                    j.this.f31851j.j(str3, str4);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.cw.j
    public void r(String str, String str2) {
        if (str2 == null || str2.length() <= 4096) {
            this.f31851j.r(str, str2);
        } else {
            j(str, str2, new InterfaceC0504j() { // from class: com.bytedance.sdk.openadsdk.tools.j.4
                @Override // com.bytedance.sdk.openadsdk.tools.j.InterfaceC0504j
                public void j(String str3, String str4) {
                    j.this.f31851j.r(str3, str4);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.cw.j
    public void up(String str, String str2) {
        if (str2 == null || str2.length() <= 4096) {
            this.f31851j.up(str, str2);
        } else {
            j(str, str2, new InterfaceC0504j() { // from class: com.bytedance.sdk.openadsdk.tools.j.5
                @Override // com.bytedance.sdk.openadsdk.tools.j.InterfaceC0504j
                public void j(String str3, String str4) {
                    j.this.f31851j.up(str3, str4);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.cw.j
    public void xt(String str, String str2) {
        if (str2 == null || str2.length() <= 4096) {
            this.f31851j.xt(str, str2);
        } else {
            j(str, str2, new InterfaceC0504j() { // from class: com.bytedance.sdk.openadsdk.tools.j.2
                @Override // com.bytedance.sdk.openadsdk.tools.j.InterfaceC0504j
                public void j(String str3, String str4) {
                    j.this.f31851j.xt(str3, str4);
                }
            });
        }
    }

    public j(cw.j jVar) {
        this.f31851j = jVar;
    }

    private class xt {
        private xt() {
        }

        void j(String str, String str2, InterfaceC0504j interfaceC0504j) {
            String hexString = Integer.toHexString(str2.hashCode());
            int i6 = 0;
            while (i6 < str2.length()) {
                int min = Math.min(i6 + 4096, str2.length());
                interfaceC0504j.j(j(str, hexString, i6, min), str2.substring(i6, min));
                i6 = min;
            }
        }

        private String j(String str, String str2, int i6, int i7) {
            return str + "_" + i6 + "_" + i7 + "_" + str2;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.cw.j
    public void j(String str, String str2, Throwable th) {
        this.f31851j.j(str, str2, th);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.cw.j
    public void xt(String str, String str2, Throwable th) {
        this.f31851j.xt(str, str2, th);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.cw.j
    public void j(String str, Throwable th) {
        this.f31851j.j(str, th);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.j.cw.j
    public void j() {
        this.f31851j.j();
    }

    private void j(final String str, final String str2, final InterfaceC0504j interfaceC0504j) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (ae.j()) {
                ae.xt(new g("log-big-str") { // from class: com.bytedance.sdk.openadsdk.tools.j.6
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.xt.j(str, str2, interfaceC0504j);
                    }
                });
            } else {
                this.xt.j(str, str2, interfaceC0504j);
            }
        } catch (Throwable th2) {
            th = th2;
            vl.xt("", "print big Str failed!", th);
        }
    }
}
