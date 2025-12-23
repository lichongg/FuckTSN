package xyz.adscope.ad;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.net.URISyntaxException;
import java.util.List;
import xyz.adscope.ad.download.service.DownloadService;
import xyz.adscope.ad.widget.activity.ASNPAdActivity;
import xyz.adscope.ad.widget.activity.ASNPDownloadPromptActivity;
import xyz.adscope.ad.widget.activity.ASNPLandingPageActivity;
import xyz.adscope.ad.widget.activity.ASNPRewardVideoActivity;
import xyz.adscope.common.analyse.model.impl.HistoryDbModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class n4 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c implements p3 {

        /* renamed from: a, reason: collision with root package name */
        private final b f55724a;

        /* synthetic */ c(b bVar, a aVar) {
            this(bVar);
        }

        private c(b bVar) {
            this.f55724a = bVar;
        }

        @Override // xyz.adscope.ad.p3
        public void a() {
            b bVar = this.f55724a;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public static boolean a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        Intent intent = new Intent(context, (Class<?>) ASNPDownloadPromptActivity.class);
        intent.putExtra("download_info_key", str2);
        return b(context, intent);
    }

    private static boolean b(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public static boolean c(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public static void d(Context context, Intent intent) {
        context.startService(intent);
    }

    private static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("hwpps://landingpage");
    }

    private static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String host = parse.getHost();
        List<String> pathSegments = parse.getPathSegments();
        return (TextUtils.isEmpty(scheme) || !"bzopen".equals(scheme) || TextUtils.isEmpty(host) || pathSegments == null || pathSegments.isEmpty()) ? false : true;
    }

    private static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("intent://");
    }

    public static boolean a(Context context, String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent(context, (Class<?>) ASNPLandingPageActivity.class);
        intent.putExtra("url", str);
        intent.putExtra(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, bundle);
        return c(context, intent);
    }

    public static void a(Context context, ServiceConnection serviceConnection) {
        Intent intent = new Intent(context, (Class<?>) DownloadService.class);
        d(context, intent);
        a(context, intent, serviceConnection);
    }

    public static void a(Context context, Intent intent, ServiceConnection serviceConnection) {
        context.bindService(intent, serviceConnection, 1);
    }

    public static boolean a(Context context, String str, xyz.adscope.ad.c cVar, String str2, String str3) {
        Class<ASNPAdActivity> cls = cVar == xyz.adscope.ad.c.INTERSTITIAL ? ASNPAdActivity.class : null;
        if (cVar == xyz.adscope.ad.c.VIDEO) {
            cls = ASNPRewardVideoActivity.class;
        }
        if (cls == null) {
            return false;
        }
        Intent intent = new Intent(context, cls);
        Bundle bundle = new Bundle();
        bundle.putString("SpaceId", str);
        bundle.putString("AdType", cVar.c());
        bundle.putString("consumeId", str2);
        bundle.putString(HistoryDbModel.COLUMN_API_KEY, str3);
        intent.putExtra("AdBundle", bundle);
        return c(context, intent);
    }

    public static boolean a(Context context, String str) {
        return a(context, str, (b) null);
    }

    public static boolean a(Context context, String str, b bVar) {
        return a(context, str, null, bVar);
    }

    public static boolean a(Context context, String str, String str2, b bVar) {
        if (bVar != null) {
            bVar.d();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent a6 = a(str, str2);
        if (a(context, a6)) {
            if (bVar != null) {
                bVar.c();
            }
        } else if (bVar != null) {
            bVar.b();
        }
        if (d(str)) {
            a6 = a(str);
        }
        v.a().b().a(new c(bVar, null));
        boolean b6 = b(context, a6);
        if (b6) {
            if (bVar != null) {
                bVar.e();
                return b6;
            }
        } else if (bVar != null) {
            bVar.f();
        }
        return b6;
    }

    private static Intent a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        String queryParameter = parse.getQueryParameter("flags");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                if (!queryParameter.startsWith("0x") && !queryParameter.startsWith("0X")) {
                    intent.setFlags(Integer.parseInt(queryParameter));
                }
                intent.setFlags(Integer.parseInt(queryParameter.substring(2), 16));
            } catch (NumberFormatException unused) {
            }
        }
        String host = parse.getHost();
        if (TextUtils.isEmpty(host)) {
            return null;
        }
        intent.setComponent(new ComponentName(host, parse.getPathSegments().get(0)));
        String queryParameter2 = parse.getQueryParameter("rect");
        if (!TextUtils.isEmpty(queryParameter2)) {
            try {
                String[] split = queryParameter2.split(":");
                if (split.length == 4) {
                    Rect rect = new Rect();
                    rect.set(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
                    intent.setSourceBounds(rect);
                }
            } catch (NumberFormatException unused2) {
            }
        }
        return intent;
    }

    private static Intent a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (b(str)) {
            Intent intent = new Intent();
            intent.setData(Uri.parse(str));
            intent.setFlags(268435456);
            return intent;
        }
        if (c(str)) {
            try {
                Intent parseUri = Intent.parseUri(str, 1);
                parseUri.setFlags(268435456);
                return parseUri;
            } catch (URISyntaxException unused) {
                return null;
            }
        }
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent2.setFlags(268435456);
        if (!TextUtils.isEmpty(str2)) {
            intent2.setPackage(str2);
        }
        return intent2;
    }

    private static boolean a(Context context, Intent intent) {
        return !context.getPackageManager().queryIntentActivities(intent, 65536).isEmpty();
    }
}
