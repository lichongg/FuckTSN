package y2;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f56784a;

    static {
        StringBuilder sb = new StringBuilder();
        String str = Build.VERSION.RELEASE;
        boolean isEmpty = TextUtils.isEmpty(str);
        String str2 = Build.ID;
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        boolean z5 = "REL".equals(Build.VERSION.CODENAME) && !TextUtils.isEmpty(Build.MODEL);
        sb.append("AppDownloader");
        if (!isEmpty) {
            sb.append("/");
            sb.append(str);
        }
        sb.append(" (Linux; U; Android");
        if (!isEmpty) {
            sb.append(" ");
            sb.append(str);
        }
        if (z5 || !isEmpty2) {
            sb.append(";");
            if (z5) {
                sb.append(" ");
                sb.append(Build.MODEL);
            }
            if (!isEmpty2) {
                sb.append(" Build/");
                sb.append(str2);
            }
        }
        sb.append(")");
        f56784a = sb.toString();
    }
}
