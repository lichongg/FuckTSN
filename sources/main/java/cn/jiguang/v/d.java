package cn.jiguang.v;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import cn.jiguang.u.e;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.kwad.library.solder.lib.ext.PluginError;
import java.util.Locale;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: e, reason: collision with root package name */
    private static d f3302e = new d();

    /* renamed from: a, reason: collision with root package name */
    private String f3303a;

    /* renamed from: b, reason: collision with root package name */
    private String f3304b;

    /* renamed from: c, reason: collision with root package name */
    private String f3305c;

    /* renamed from: d, reason: collision with root package name */
    private String f3306d;

    /* renamed from: cn.jiguang.v.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final d f3307a = new d(null);
    }

    private d() {
    }

    public static d a() {
        return a.f3307a;
    }

    /* synthetic */ d(AnonymousClass1 anonymousClass1) {
        this();
    }

    public String a(Context context) {
        if (!TextUtils.isEmpty(this.f3303a)) {
            return this.f3303a;
        }
        String str = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.aH());
        this.f3303a = str;
        if (!TextUtils.isEmpty(str)) {
            return this.f3303a;
        }
        if (!cn.jiguang.g.a.a().e(PluginError.ERROR_UPD_FILE_NOT_FOUND)) {
            return "";
        }
        this.f3303a = String.format(Locale.ENGLISH, Build.MODEL, new Object[0]);
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.aH().a((cn.jiguang.e.a<String>) this.f3303a)});
        return this.f3303a;
    }

    public String b(Context context) {
        if (!TextUtils.isEmpty(this.f3305c)) {
            return this.f3305c;
        }
        String str = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.aI());
        this.f3305c = str;
        if (!TextUtils.isEmpty(str)) {
            return this.f3305c;
        }
        if (!cn.jiguang.g.a.a().e(PluginError.ERROR_UPD_NO_DOWNLOADER)) {
            return "";
        }
        this.f3305c = String.format(Locale.ENGLISH, Build.MANUFACTURER, new Object[0]);
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.aI().a((cn.jiguang.e.a<String>) this.f3305c)});
        return this.f3305c;
    }

    public String c(Context context) {
        if (!TextUtils.isEmpty(this.f3304b)) {
            return this.f3304b;
        }
        String str = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.aK());
        this.f3304b = str;
        if (!TextUtils.isEmpty(str)) {
            return this.f3304b;
        }
        if (!cn.jiguang.g.a.a().e(GLMapStaticValue.MAP_PARAMETERNAME_SATELLITE)) {
            return "";
        }
        this.f3304b = Integer.toString(Build.VERSION.SDK_INT);
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.aK().a((cn.jiguang.e.a<String>) this.f3304b)});
        return this.f3304b;
    }

    public String d(Context context) {
        if (!TextUtils.isEmpty(this.f3306d)) {
            return this.f3306d;
        }
        String str = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.aJ());
        this.f3306d = str;
        if (!TextUtils.isEmpty(str)) {
            return this.f3306d;
        }
        if (!cn.jiguang.g.a.a().e(PointerIconCompat.TYPE_ZOOM_OUT)) {
            return "";
        }
        this.f3306d = e.a(context);
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.aJ().a((cn.jiguang.e.a<String>) this.f3306d)});
        return this.f3306d;
    }

    public void a(Context context, String str) {
        this.f3304b = str;
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.aK().a((cn.jiguang.e.a<String>) str)});
    }
}
