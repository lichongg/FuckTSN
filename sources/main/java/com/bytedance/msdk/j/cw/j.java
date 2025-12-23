package com.bytedance.msdk.j.cw;

import android.content.Context;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.bytedance.msdk.api.r.ws;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j implements com.bytedance.msdk.j.j.r {

    /* renamed from: j, reason: collision with root package name */
    private cw f25134j;

    @Override // com.bytedance.msdk.j.j.r
    public int j(com.bytedance.msdk.api.r.cw cwVar) {
        return 0;
    }

    @Override // com.bytedance.msdk.j.j.r
    public int m() {
        return 0;
    }

    @Override // com.bytedance.msdk.j.j.r
    public Map<String, Object> xt(Context context, Map<String, Object> map) {
        return null;
    }

    private void g() {
        xt.xt(xt.j(xt.j(), "personal_ads_type", this.f25134j.ae() ? "0" : "1"));
    }

    @Override // com.bytedance.msdk.j.j.r
    public String j() {
        return xt() + ".0";
    }

    @Override // com.bytedance.msdk.j.j.r
    public long up() {
        return 0L;
    }

    @Override // com.bytedance.msdk.j.j.r
    public String xt() {
        return com.bytedance.sdk.gromore.init.j.cw();
    }

    private void tl() {
        g();
    }

    @Override // com.bytedance.msdk.j.j.r
    public String cw() {
        return com.bytedance.sdk.gromore.init.j.r();
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x007a, code lost:
    
        if (r4 == 7) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0087, code lost:
    
        if (r4 == 3) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0063, code lost:
    
        if (r4 == 2) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0065, code lost:
    
        r2 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x006f, code lost:
    
        if (r4 == 4) goto L34;
     */
    @Override // com.bytedance.msdk.j.j.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String j(android.content.Context r18, java.util.Map<java.lang.String, java.lang.Object> r19) {
        /*
            Method dump skipped, instructions count: 607
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.j.cw.j.j(android.content.Context, java.util.Map):java.lang.String");
    }

    @Override // com.bytedance.msdk.j.j.r
    public void ae() {
    }

    @Override // com.bytedance.msdk.j.j.r
    public void r() {
    }

    @Override // com.bytedance.msdk.j.j.r
    public void j(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        Object obj = map.get(com.bytedance.msdk.j.j.j.up);
        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        if (intValue == 0 || intValue == 1) {
            com.bytedance.sdk.gromore.init.j.j(intValue);
        }
    }

    @Override // com.bytedance.msdk.j.j.r
    public void j(ws wsVar, SparseArray<Object> sparseArray) {
        this.f25134j.xt(sparseArray);
        tl();
    }

    @Override // com.bytedance.msdk.j.j.xt
    public void j(@NonNull Context context, @NonNull Map<String, Object> map, @NonNull com.bytedance.msdk.j.j.cw cwVar) {
        this.f25134j = com.bytedance.msdk.core.j.qv().xt();
        g();
        cwVar.j();
    }
}
