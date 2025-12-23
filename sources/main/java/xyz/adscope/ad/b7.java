package xyz.adscope.ad;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import java.util.regex.Pattern;
import xyz.adscope.ad.publish.ASNPConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class b7 {

    /* renamed from: a, reason: collision with root package name */
    private ASNPConstants.UiModel f54887a;

    /* renamed from: b, reason: collision with root package name */
    private String f54888b;

    /* renamed from: c, reason: collision with root package name */
    private String f54889c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f54890d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final b7 f54891a = new b7();
    }

    public static b7 a() {
        return a.f54891a;
    }

    private boolean d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            return !Pattern.compile("^[A-Fa-f0-9]{2}$").matcher(str).matches();
        } catch (Exception e6) {
            e6.printStackTrace();
            return true;
        }
    }

    public boolean b() {
        return this.f54887a == ASNPConstants.UiModel.UI_MODEL_DARK;
    }

    private int b(String str) {
        return Integer.parseInt(str, 16);
    }

    public void a(Context context, ASNPConstants.UiModel uiModel, String str, String str2) {
        if (this.f54890d) {
            return;
        }
        this.f54890d = true;
        this.f54887a = uiModel;
        this.f54888b = str;
        this.f54889c = str2;
        if (TextUtils.isEmpty(str)) {
            this.f54888b = "#FFFFFF";
        }
        if (TextUtils.isEmpty(str2)) {
            this.f54889c = "#000000";
        }
        boolean a6 = a(context);
        if (uiModel == ASNPConstants.UiModel.UI_MODEL_AUTO && a6) {
            this.f54887a = ASNPConstants.UiModel.UI_MODEL_DARK;
        }
    }

    public boolean c(String str) {
        try {
            return Pattern.compile("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{8})$").matcher(str).matches();
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    private boolean a(Context context) {
        try {
            Configuration configuration = context.getResources().getConfiguration();
            if (configuration != null) {
                return (configuration.uiMode & 48) == 32;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public String a(String str) {
        String substring;
        String substring2;
        String substring3;
        String replace;
        try {
            if (this.f54887a == ASNPConstants.UiModel.UI_MODEL_LIGHT) {
                return c(str) ? str : this.f54888b;
            }
            String replace2 = str.replace("#", "");
            int length = replace2.length();
            String str2 = "FF";
            if (length == 6) {
                substring = replace2.substring(0, 2);
                substring2 = replace2.substring(2, 4);
                substring3 = replace2.substring(4, 6);
            } else if (length != 8) {
                substring3 = this.f54887a == ASNPConstants.UiModel.UI_MODEL_DARK ? "00" : "FF";
                substring = substring3;
                substring2 = substring;
            } else {
                String substring4 = replace2.substring(0, 2);
                if (!d(substring4)) {
                    str2 = substring4;
                }
                substring = replace2.substring(2, 4);
                substring2 = replace2.substring(4, 6);
                substring3 = replace2.substring(6, 8);
            }
            if (!d(substring) && !d(substring2) && !d(substring3)) {
                int b6 = b(substring);
                int b7 = b(substring2);
                int b8 = b(substring3);
                if (b6 != b7 || b7 != b8 || this.f54887a != ASNPConstants.UiModel.UI_MODEL_DARK) {
                    return str;
                }
                String upperCase = a(255 - b6).toUpperCase();
                return "#" + str2 + "" + upperCase + "" + upperCase + "" + upperCase;
            }
            if (this.f54887a == ASNPConstants.UiModel.UI_MODEL_DARK) {
                replace = this.f54889c.replace("#", "");
            } else {
                replace = this.f54888b.replace("#", "");
            }
            return "#" + str2 + "" + replace.toUpperCase();
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    private String a(int i6) {
        String hexString = Integer.toHexString(i6);
        if (hexString.length() != 1) {
            return hexString;
        }
        return "0" + hexString;
    }
}
