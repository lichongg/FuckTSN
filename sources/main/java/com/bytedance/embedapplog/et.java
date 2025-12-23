package com.bytedance.embedapplog;

import android.content.Context;
import android.os.SystemProperties;
import com.bytedance.embedapplog.tk;

/* loaded from: D:\Downloads\app\classes3.dex */
final class et implements tk {

    /* renamed from: j, reason: collision with root package name */
    private static final wf<Boolean> f23986j = new wf<Boolean>() { // from class: com.bytedance.embedapplog.et.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.wf
        /* renamed from: cw, reason: merged with bridge method [inline-methods] */
        public Boolean j(Object... objArr) {
            return Boolean.valueOf("1".equals(et.xt("persist.sys.identifierid.supported", "0")));
        }
    };

    @Override // com.bytedance.embedapplog.tk
    public tk.j xt(Context context) {
        tk.j jVar = new tk.j();
        jVar.xt = j(context, 0, null);
        return jVar;
    }

    static boolean j() {
        return f23986j.xt(new Object[0]).booleanValue();
    }

    et(Context context) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String xt(String str, String str2) {
        try {
            return SystemProperties.get(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    @Override // com.bytedance.embedapplog.tk
    public boolean j(Context context) {
        return j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    @androidx.annotation.Nullable
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String j(@androidx.annotation.NonNull android.content.Context r8, int r9, java.lang.String r10) {
        /*
            r1 = 0
            if (r9 == 0) goto L2a
            r0 = 1
            if (r9 == r0) goto L1b
            r0 = 2
            if (r9 == r0) goto Lb
            r3 = r1
            goto L31
        Lb:
            java.lang.String r9 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r9 = r9.concat(r10)
            android.net.Uri r9 = android.net.Uri.parse(r9)
        L19:
            r3 = r9
            goto L31
        L1b:
            java.lang.String r9 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r9 = r9.concat(r10)
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L19
        L2a:
            java.lang.String r9 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L19
        L31:
            if (r3 == 0) goto L6e
            android.content.ContentResolver r2 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            r6 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            if (r8 == 0) goto L59
            boolean r9 = r8.moveToNext()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L56
            if (r9 == 0) goto L59
            java.lang.String r9 = "value"
            int r9 = r8.getColumnIndex(r9)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L56
            java.lang.String r1 = r8.getString(r9)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L56
            goto L59
        L52:
            r0 = move-exception
            r9 = r0
            r1 = r8
            goto L6a
        L56:
            r0 = move-exception
            r9 = r0
            goto L63
        L59:
            com.bytedance.embedapplog.ri.j(r8)
            return r1
        L5d:
            r0 = move-exception
            r9 = r0
            goto L6a
        L60:
            r0 = move-exception
            r9 = r0
            r8 = r1
        L63:
            com.bytedance.embedapplog.uc.j(r9)     // Catch: java.lang.Throwable -> L52
            com.bytedance.embedapplog.ri.j(r8)
            goto L6e
        L6a:
            com.bytedance.embedapplog.ri.j(r1)
            throw r9
        L6e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.et.j(android.content.Context, int, java.lang.String):java.lang.String");
    }
}
