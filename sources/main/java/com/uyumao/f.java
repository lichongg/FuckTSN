package com.uyumao;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.uyumao.g;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class f extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 256) {
            return;
        }
        int i6 = message.arg1;
        Object obj = message.obj;
        Integer valueOf = Integer.valueOf(i6 / 100);
        HashMap<Integer, g.a> hashMap = g.f42587c;
        if (hashMap == null) {
            return;
        }
        g.a aVar = hashMap.containsKey(valueOf) ? g.f42587c.get(valueOf) : null;
        if (aVar != null) {
            aVar.a(obj, i6);
        }
    }

    public f(Looper looper) {
        super(looper);
    }
}
