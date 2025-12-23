package cn.jiguang.ab;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import cn.jiguang.bb.f;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f1465a;

    /* renamed from: b, reason: collision with root package name */
    private String f1466b;

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Cursor query = this.f1465a.getContentResolver().query(Uri.parse(this.f1466b), null, null, new String[]{str}, null);
            if (query == null) {
                f.c("MeizuDB", "return cursor is null,return");
                return null;
            }
            String string = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
            query.close();
            return string;
        } catch (Exception e6) {
            f.i("MeizuDB", "getId error: " + e6.getMessage());
            return null;
        }
    }

    public a(Context context) {
        this.f1466b = "";
        this.f1465a = context;
        this.f1466b = cn.jiguang.d.a.c("SyfFpc71r1BITMlIo0m1Vt2cR3sdiPGnMd0WMSsF4yU8+J95KN/jHVtZShu2ONYO");
    }
}
