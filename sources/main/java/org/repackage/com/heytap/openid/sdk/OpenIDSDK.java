package org.repackage.com.heytap.openid.sdk;

import android.content.Context;
import com.stub.StubApp;
import org.repackage.a.a.a.a.a;
import org.repackage.a.a.a.a.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class OpenIDSDK {
    public static void a(Context context) {
        a.f51575b = c.a.f51583a.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        a.f51574a = true;
    }

    public static String b(Context context) {
        if (a.f51574a) {
            return c.a.f51583a.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "GUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (a.f51574a) {
            return c.a.f51583a.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (a.f51574a) {
            return c.a.f51583a.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String e(Context context) {
        if (a.f51574a) {
            return c.a.f51583a.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static boolean a() {
        if (a.f51574a) {
            return a.f51575b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
