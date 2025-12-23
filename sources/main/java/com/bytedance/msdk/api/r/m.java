package com.bytedance.msdk.api.r;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m {
    private Map<String, String> tl;

    /* renamed from: j, reason: collision with root package name */
    public final String f24382j = MediationConstant.TAG;
    private String xt = "";
    private String cw = "";

    /* renamed from: r, reason: collision with root package name */
    private String f24384r = "";
    private int up = 0;

    /* renamed from: m, reason: collision with root package name */
    private String f24383m = "";
    private String ae = "";

    @Nullable
    public String cw() {
        return this.cw;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b1, code lost:
    
        if (r7 == null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r6 != r7) goto L4
            return r0
        L4:
            r1 = 0
            if (r7 == 0) goto Lba
            java.lang.Class r2 = r6.getClass()
            java.lang.Class r3 = r7.getClass()
            if (r2 == r3) goto L13
            goto Lba
        L13:
            com.bytedance.msdk.api.r.m r7 = (com.bytedance.msdk.api.r.m) r7
            int r2 = r6.up()
            int r3 = r7.up()
            if (r2 != r3) goto L67
            java.lang.String r2 = r6.ae()
            java.lang.String r3 = r7.ae()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.xt()
            java.lang.String r3 = r7.xt()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.cw()
            java.lang.String r3 = r7.cw()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.r()
            java.lang.String r3 = r7.r()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.m()
            java.lang.String r3 = r7.m()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            r2 = 1
            goto L68
        L67:
            r2 = 0
        L68:
            java.util.Map r7 = r7.j()
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.tl
            if (r3 == 0) goto Laf
            if (r7 == 0) goto Laf
            int r3 = r3.size()
            int r4 = r7.size()
            if (r3 != r4) goto Lb4
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.tl
            java.util.Set r3 = r3.keySet()
            java.util.Iterator r3 = r3.iterator()
        L86:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto Lad
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L86
            java.util.Map<java.lang.String, java.lang.String> r5 = r6.tl
            java.lang.Object r5 = r5.get(r4)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.Object r4 = r7.get(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.equals(r5, r4)
            if (r4 == 0) goto Lb4
            goto L86
        Lad:
            r7 = 1
            goto Lb5
        Laf:
            if (r3 != 0) goto Lb4
            if (r7 != 0) goto Lb4
            goto Lad
        Lb4:
            r7 = 0
        Lb5:
            if (r2 == 0) goto Lba
            if (r7 == 0) goto Lba
            return r0
        Lba:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.api.r.m.equals(java.lang.Object):boolean");
    }

    public void j(Map<String, String> map) {
        this.tl = new HashMap();
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                if (!m(entry.getKey())) {
                    com.bytedance.sdk.component.utils.vl.r(MediationConstant.TAG, "流量分组" + entry.getKey() + "字段存在不合法输入");
                } else if (m(entry.getValue())) {
                    this.tl.put(entry.getKey(), entry.getValue());
                } else {
                    com.bytedance.sdk.component.utils.vl.r(MediationConstant.TAG, "流量分组" + entry.getKey() + "字段的值" + entry.getValue() + "存在不合法输入");
                }
            }
        }
    }

    @Nullable
    public String m() {
        return this.f24383m;
    }

    @Nullable
    public String r() {
        return this.f24384r;
    }

    public int up() {
        return this.up;
    }

    @Nullable
    public String xt() {
        return this.xt;
    }

    public static boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[A-Za-z0-9-_]{1,100}");
    }

    @Nullable
    public String ae() {
        return this.ae;
    }

    public void cw(String str) {
        if (m(str)) {
            this.f24384r = str;
        } else {
            com.bytedance.sdk.component.utils.vl.r(MediationConstant.TAG, "流量分组sub_channer字段存在不合法输入");
        }
    }

    public void r(String str) {
        if (m(str)) {
            this.f24383m = str;
        } else {
            com.bytedance.sdk.component.utils.vl.r(MediationConstant.TAG, "流量分组gender字段存在不合法输入");
        }
    }

    public void up(String str) {
        if (m(str)) {
            this.ae = str;
        } else {
            com.bytedance.sdk.component.utils.vl.r(MediationConstant.TAG, "流量分组user_value_group字段存在不合法输入");
        }
    }

    public void xt(String str) {
        if (m(str)) {
            this.cw = str;
        } else {
            com.bytedance.sdk.component.utils.vl.r(MediationConstant.TAG, "流量分组channer字段存在不合法输入");
        }
    }

    @Nullable
    public Map<String, String> j() {
        return this.tl;
    }

    public void j(String str) {
        if (m(str)) {
            this.xt = str;
        } else {
            com.bytedance.sdk.component.utils.vl.r(MediationConstant.TAG, "流量分组user_id字段存在不合法输入");
        }
    }

    public void j(int i6) {
        this.up = i6;
    }
}
