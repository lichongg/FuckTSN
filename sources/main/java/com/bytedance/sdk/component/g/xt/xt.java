package com.bytedance.sdk.component.g.xt;

import android.text.TextUtils;
import com.bytedance.sdk.component.xt.j.vl;
import com.bytedance.sdk.component.xt.j.ws;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends r {

    /* renamed from: j, reason: collision with root package name */
    public File f26462j;
    public File xt;

    /* JADX INFO: Access modifiers changed from: private */
    public static long ae(Map<String, String> map) {
        String str = map.containsKey("content-length") ? map.get("content-length") : map.containsKey("Content-Length") ? map.get("Content-Length") : null;
        if (!TextUtils.isEmpty(str) && str != null) {
            try {
                return Long.valueOf(str).longValue();
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean m(Map<String, String> map) {
        if (TextUtils.equals(map.get("Accept-Ranges"), "bytes") || TextUtils.equals(map.get("accept-ranges"), "bytes")) {
            return true;
        }
        String str = map.get("Content-Range");
        if (TextUtils.isEmpty(str)) {
            str = map.get("content-range");
        }
        return str != null && str.startsWith("bytes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean tl(Map<String, String> map) {
        return TextUtils.equals(map.get("Content-Encoding"), "gzip");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up() {
        try {
            this.f26462j.delete();
        } catch (Throwable unused) {
        }
        try {
            this.xt.delete();
        } catch (Throwable unused2) {
        }
    }

    public xt(vl vlVar) {
        super(vlVar);
    }

    public void j(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f26462j = new File(str, str2);
        this.xt = new File(str, str2 + ".temp");
    }

    public void j(final com.bytedance.sdk.component.g.j.j jVar) {
        File file = this.f26462j;
        if (file == null || this.xt == null) {
            if (jVar != null) {
                jVar.j(this, new IOException("File info is null, please exec setFileInfo(String dir, String fileName)"));
                return;
            }
            return;
        }
        if (file.exists() && this.f26462j.length() != 0 && jVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.component.g.xt xtVar = new com.bytedance.sdk.component.g.xt(true, 200, "Success", null, null, currentTimeMillis, currentTimeMillis);
            xtVar.j(this.f26462j);
            jVar.j(this, xtVar);
            return;
        }
        long length = this.xt.length();
        final long j6 = length >= 0 ? length : 0L;
        ws.j jVar2 = new ws.j();
        jVar2.j((Object) xt());
        xt("Range", "bytes=" + j6 + "-");
        if (TextUtils.isEmpty(this.f26458m)) {
            jVar.j(this, new IOException("Url is Empty"));
            return;
        }
        try {
            jVar2.j(this.f26458m);
            j(jVar2);
            this.cw.j(jVar2.j().xt()).j(new com.bytedance.sdk.component.xt.j.cw() { // from class: com.bytedance.sdk.component.g.xt.xt.1
                @Override // com.bytedance.sdk.component.xt.j.cw
                public void onFailure(com.bytedance.sdk.component.xt.j.xt xtVar2, IOException iOException) {
                    com.bytedance.sdk.component.g.j.j jVar3 = jVar;
                    if (jVar3 != null) {
                        jVar3.j(xt.this, iOException);
                    }
                    xt.this.up();
                }

                /* JADX WARN: Removed duplicated region for block: B:53:0x015c A[Catch: all -> 0x0148, TryCatch #5 {all -> 0x0148, blocks: (B:45:0x012f, B:47:0x013d, B:49:0x0141, B:50:0x014b, B:51:0x0152, B:53:0x015c, B:55:0x0168, B:59:0x0170, B:63:0x017e, B:66:0x018a, B:68:0x0194, B:70:0x01a0, B:72:0x01ac, B:82:0x01bb, B:83:0x01c8, B:86:0x01e2), top: B:44:0x012f }] */
                /* JADX WARN: Removed duplicated region for block: B:61:0x017c A[EDGE_INSN: B:61:0x017c->B:62:0x017c BREAK  A[LOOP:1: B:51:0x0152->B:58:0x0179], SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:63:0x017e A[Catch: all -> 0x0148, TryCatch #5 {all -> 0x0148, blocks: (B:45:0x012f, B:47:0x013d, B:49:0x0141, B:50:0x014b, B:51:0x0152, B:53:0x015c, B:55:0x0168, B:59:0x0170, B:63:0x017e, B:66:0x018a, B:68:0x0194, B:70:0x01a0, B:72:0x01ac, B:82:0x01bb, B:83:0x01c8, B:86:0x01e2), top: B:44:0x012f }] */
                /* JADX WARN: Removed duplicated region for block: B:85:0x01e1  */
                @Override // com.bytedance.sdk.component.xt.j.cw
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onResponse(com.bytedance.sdk.component.xt.j.xt r22, com.bytedance.sdk.component.xt.j.av r23) throws java.io.IOException {
                    /*
                        Method dump skipped, instructions count: 559
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.g.xt.xt.AnonymousClass1.onResponse(com.bytedance.sdk.component.xt.j.xt, com.bytedance.sdk.component.xt.j.av):void");
                }
            });
        } catch (IllegalArgumentException unused) {
            jVar.j(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0213 A[EDGE_INSN: B:115:0x0213->B:116:0x0213 BREAK  A[LOOP:1: B:69:0x01e1->B:81:0x020b], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0215 A[Catch: all -> 0x0210, TryCatch #10 {all -> 0x0210, blocks: (B:76:0x01f3, B:78:0x01fb, B:82:0x0201, B:117:0x0215, B:124:0x0230, B:126:0x0238, B:128:0x0242, B:130:0x024c, B:140:0x0258, B:150:0x026e, B:153:0x0282, B:164:0x0226), top: B:75:0x01f3 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02b8 A[Catch: all -> 0x02bc, TryCatch #19 {all -> 0x02bc, blocks: (B:87:0x02b1, B:89:0x02b8, B:90:0x02be), top: B:86:0x02b1, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v7 */
    @Override // com.bytedance.sdk.component.g.xt.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.g.xt j() {
        /*
            Method dump skipped, instructions count: 811
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.g.xt.xt.j():com.bytedance.sdk.component.g.xt");
    }
}
