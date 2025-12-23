package cn.jiguang.ar;

import android.content.Context;
import cn.jiguang.bb.f;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    public static class a extends cn.jiguang.by.b {

        /* renamed from: a, reason: collision with root package name */
        private Context f1685a;

        /* renamed from: b, reason: collision with root package name */
        private JSONObject f1686b;

        @Override // cn.jiguang.by.b
        public void a() {
            try {
                long f6 = cn.jiguang.m.b.f(this.f1685a, "JWakeCmdcmd");
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = this.f1686b;
                if (jSONObject == null && currentTimeMillis - f6 < 3600000) {
                    f.i("JWakeCmd", "is not cmd wake time");
                    return;
                }
                b.c(this.f1685a, jSONObject);
            } catch (Throwable th) {
                f.i("JWakeCmd", "WakeAction failed:" + th.getMessage());
            }
        }

        a(Context context, JSONObject jSONObject) {
            this.f1685a = context;
            this.f1686b = jSONObject;
            this.f2653h = "JWakeCmd#WakeAction";
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        try {
            f.c("JWakeCmd", jSONObject == null ? "executeWakeAction: [JWakeCmd] from heartBeat" : "executeWakeAction: [JWakeCmd] from cmd");
            boolean booleanValue = ((Boolean) cn.jiguang.ar.a.c(context)).booleanValue();
            f.c("JWakeCmd", "JWakeCmd isActionUserEnable:" + booleanValue);
            if (booleanValue) {
                cn.jiguang.be.b.b(new a(context, jSONObject));
            }
        } catch (Throwable th) {
            f.j("JWakeCmd", "[executeWakeAction] failed:" + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00f4 A[Catch: all -> 0x0093, TryCatch #0 {all -> 0x0093, blocks: (B:3:0x0006, B:19:0x002b, B:21:0x004a, B:29:0x0076, B:25:0x0095, B:10:0x00f4, B:31:0x005f, B:32:0x00b6, B:15:0x00fe, B:6:0x00e4, B:8:0x00ea, B:35:0x00c9, B:18:0x0025, B:27:0x0054), top: B:2:0x0006, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(android.content.Context r10, org.json.JSONObject r11) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ar.b.c(android.content.Context, org.json.JSONObject):void");
    }
}
