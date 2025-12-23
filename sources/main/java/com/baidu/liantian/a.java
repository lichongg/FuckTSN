package com.baidu.liantian;

import android.content.Context;
import android.content.Intent;
import com.baidu.liantian.ac.Callback;
import com.baidu.liantian.core.g;
import com.stub.StubApp;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a {
    public static void a(Context context, Intent intent) {
        try {
            String[] g6 = com.baidu.liantian.b.e.g(context);
            String str = g6[0];
            String str2 = g6[1];
            b.a();
            com.baidu.liantian.core.e.a(context, 0, true);
            int i6 = 0;
            while (true) {
                Thread.sleep(500L);
                i6++;
                b.a();
                if (i6 > 60) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", "152");
                    hashMap.put("1", g6[0]);
                    com.baidu.liantian.b.e.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "1014115", hashMap);
                    hashMap.toString();
                    b.a();
                    break;
                }
                g a6 = g.a();
                if (a6 == null) {
                    b.a();
                } else if (a6.d("com.baidu.liantian.x24") != null) {
                    break;
                }
            }
            b.a();
            com.baidu.liantian.core.e.a(100028, "onReceiveAwakeMessage", new Callback() { // from class: com.baidu.liantian.a.1
                @Override // com.baidu.liantian.ac.Callback
                public final Object onEnd(Object... objArr) {
                    return super.onEnd(objArr);
                }
            }, (Class<?>[]) new Class[]{Context.class, Intent.class}, context, intent);
        } catch (Throwable unused) {
            b.a();
            com.baidu.liantian.b.e.a();
        }
    }
}
