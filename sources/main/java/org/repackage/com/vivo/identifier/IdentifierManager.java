package org.repackage.com.vivo.identifier;

import android.content.Context;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class IdentifierManager {
    public static boolean a(Context context) {
        if (IdentifierIdClient.b(context) == null) {
            return false;
        }
        return IdentifierIdClient.a();
    }

    public static String b(Context context) {
        IdentifierIdClient b6 = IdentifierIdClient.b(context);
        if (b6 == null) {
            return null;
        }
        return b6.c();
    }

    public static boolean a(Context context, List<String> list) {
        IdentifierIdClient b6 = IdentifierIdClient.b(context);
        if (b6 == null) {
            return false;
        }
        return b6.a(list);
    }

    public static List b(Context context, List<String> list) {
        IdentifierIdClient b6 = IdentifierIdClient.b(context);
        if (b6 == null) {
            return null;
        }
        return b6.b(list);
    }

    public static String c(Context context) {
        IdentifierIdClient b6 = IdentifierIdClient.b(context);
        if (b6 == null) {
            return null;
        }
        return b6.d();
    }

    public static String d(Context context) {
        IdentifierIdClient b6 = IdentifierIdClient.b(context);
        if (b6 == null) {
            return null;
        }
        return b6.e();
    }

    public static String e(Context context) {
        IdentifierIdClient b6 = IdentifierIdClient.b(context);
        if (b6 == null) {
            return null;
        }
        return b6.f();
    }

    public static String f(Context context) {
        IdentifierIdClient b6 = IdentifierIdClient.b(context);
        if (b6 == null) {
            return null;
        }
        return b6.g();
    }

    public static String g(Context context) {
        IdentifierIdClient b6 = IdentifierIdClient.b(context);
        if (b6 == null) {
            return null;
        }
        return b6.h();
    }

    public static String h(Context context) {
        IdentifierIdClient b6 = IdentifierIdClient.b(context);
        if (b6 == null) {
            return null;
        }
        return b6.b();
    }

    public static String i(Context context) {
        IdentifierIdClient b6 = IdentifierIdClient.b(context);
        if (b6 == null) {
            return null;
        }
        return b6.i();
    }

    public static String j(Context context) {
        IdentifierIdClient a6 = IdentifierIdClient.a(context);
        if (a6 == null) {
            return null;
        }
        return a6.j();
    }

    public static String k(Context context) {
        IdentifierIdClient a6 = IdentifierIdClient.a(context);
        if (a6 == null) {
            return null;
        }
        return a6.k();
    }
}
