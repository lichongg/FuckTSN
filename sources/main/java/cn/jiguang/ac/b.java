package cn.jiguang.ac;

import android.content.Context;
import android.net.Uri;
import cn.jiguang.bb.f;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Context f1480a;

    /* renamed from: b, reason: collision with root package name */
    private Uri f1481b;

    public String a() {
        try {
            return a.a(this.f1480a, this.f1481b);
        } catch (Exception e6) {
            f.i("NubiaOpenIDHelper", "get Ids-oa error: " + e6.getMessage());
            return "";
        }
    }

    public b(Context context) {
        this.f1480a = context;
        String c6 = cn.jiguang.d.a.c("k97muQEI3n3mlJTZdD9q3lC6tvCVkeY7wPOrf0wd0l4zQtrGyn5uq0enBKOySISr");
        f.c("NubiaOpenIDHelper", "url: " + c6);
        this.f1481b = Uri.parse(c6);
    }
}
