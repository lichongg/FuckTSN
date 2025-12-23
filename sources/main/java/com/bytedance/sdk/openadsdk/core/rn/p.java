package com.bytedance.sdk.openadsdk.core.rn;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class p {

    /* renamed from: j, reason: collision with root package name */
    private String f30143j;

    public static p j() {
        return new p();
    }

    private void xt() {
        File j6;
        Context context = com.bytedance.sdk.openadsdk.core.v.getContext();
        if (context == null) {
            return;
        }
        try {
            if ("mounted".equals(com.bytedance.sdk.openadsdk.l.cw.j()) && (j6 = com.bytedance.sdk.openadsdk.api.plugin.xt.j(context, "TTCache")) != null) {
                j6.mkdirs();
                this.f30143j = j6.getPath();
            }
            if (TextUtils.isEmpty(this.f30143j)) {
                File file = new File(com.bytedance.sdk.openadsdk.api.plugin.xt.j(context), "TTCache");
                file.mkdirs();
                this.f30143j = file.getPath();
            }
        } catch (Throwable unused) {
        }
    }

    public void j(Thread thread, Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            r0 = stringWriter2 != null ? stringWriter2.contains(TTAdConstant.class.getPackage().getName()) : false;
            com.bytedance.sdk.openadsdk.core.ae.r.j().j(thread, th);
        } catch (Throwable unused) {
        }
        if (r0) {
            xt(thread, th);
        }
    }

    private p() {
        xt();
    }

    private void cw() {
        try {
            com.bytedance.sdk.openadsdk.core.component.splash.j.j.j().cw();
        } catch (Throwable unused) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.j.j.xt.j().xt();
        } catch (Throwable unused2) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.p.tl.j();
        } catch (Throwable unused3) {
        }
        try {
            com.bytedance.sdk.component.adexpress.j.xt.xt.xt();
            com.bytedance.sdk.openadsdk.core.ugeno.up.j.xt().m();
        } catch (Throwable unused4) {
        }
        try {
            Function<SparseArray<Object>, Object> gx = com.bytedance.sdk.openadsdk.core.oq.i().gx();
            if (gx != null) {
                gx.apply(com.bytedance.sdk.openadsdk.i.r.j().j(7).j(Void.class).xt());
            }
        } catch (Throwable unused5) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.cw.cw.j().oq();
            com.bytedance.sdk.openadsdk.core.cw.r.j().v();
            com.bytedance.sdk.openadsdk.core.cw.up.j().av();
        } catch (Throwable unused6) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0118 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0111 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.Properties] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.Properties] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void xt(java.lang.Thread r19, java.lang.Throwable r20) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.rn.p.xt(java.lang.Thread, java.lang.Throwable):void");
    }
}
