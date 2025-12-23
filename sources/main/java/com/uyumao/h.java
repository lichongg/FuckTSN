package com.uyumao;

import android.content.BroadcastReceiver;
import android.content.Context;
import java.io.File;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class h extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public long f42588a = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f42589a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f42590b;

        public a(h hVar, Context context, JSONObject jSONObject) {
            this.f42589a = context;
            this.f42590b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            File file = new File(this.f42589a.getCacheDir().getPath() + File.separator + "net_change");
            StringBuilder sb = new StringBuilder();
            sb.append(this.f42590b.toString());
            sb.append(com.snail.antifake.deviceid.e.f37542d);
            e.a(file, sb.toString().getBytes(), true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0102 A[Catch: all -> 0x011a, TRY_LEAVE, TryCatch #2 {all -> 0x011a, blocks: (B:3:0x0002, B:5:0x000c, B:10:0x0016, B:12:0x0033, B:14:0x0039, B:16:0x003f, B:20:0x004c, B:37:0x0102, B:43:0x0117, B:51:0x00fc, B:54:0x0068, B:56:0x006e, B:58:0x0074, B:59:0x0081, B:61:0x0087, B:63:0x008d, B:65:0x0093, B:69:0x00a0, B:39:0x0105), top: B:2:0x0002, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onReceive(android.content.Context r12, android.content.Intent r13) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uyumao.h.onReceive(android.content.Context, android.content.Intent):void");
    }
}
