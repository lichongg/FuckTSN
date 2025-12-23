package cn.jiguang.au;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import cn.jiguang.bz.l;
import com.google.common.primitives.SignedBytes;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1754a = l.b(new byte[]{122, 103, 123, Utf8.REPLACEMENT_BYTE, 68, 69, 119, 107, 115, Byte.MAX_VALUE, 68, 14, 104, 121, 123, 100, 67, 73, 122});

    /* renamed from: b, reason: collision with root package name */
    private static final String f1755b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f1756c;

    /* renamed from: d, reason: collision with root package name */
    private static final String f1757d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f1758e;

    /* renamed from: f, reason: collision with root package name */
    private static final String f1759f;

    /* renamed from: g, reason: collision with root package name */
    private static final ArrayList<String> f1760g;

    public static boolean a(Context context) {
        try {
            Intent intent = new Intent();
            String str = f1754a;
            intent.setClassName(str, f1759f);
            boolean a6 = a.a(context, str, intent, true);
            cn.jiguang.bb.f.c("JWakeSpecialHelper", "q has perform b act: " + a6);
            return a6;
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JWakeSpecialHelper", "check q has perform b act failed, " + th.getMessage());
            return false;
        }
    }

    private static boolean b(Context context) {
        Uri parse;
        Iterator<String> it = f1760g.iterator();
        while (it.hasNext()) {
            String next = it.next();
            try {
                if (!next.startsWith("content://")) {
                    next = "content://" + next;
                }
                parse = Uri.parse(next);
                cn.jiguang.bb.f.c("JWakeSpecialHelper", " provider: " + next + ", uri: " + parse);
            } catch (Throwable unused) {
            }
            if (StubApp.getOrigApplicationContext(context.getApplicationContext()).getContentResolver().insert(parse, new ContentValues()) != null) {
                return true;
            }
        }
        return false;
    }

    static {
        String b6 = l.b(new byte[]{122, 103, 123, Utf8.REPLACEMENT_BYTE, 68, 69, 119, 107, 115, Byte.MAX_VALUE, 68, 14, 104, 121, 123, 100, 67, 73, 122, 38, 69, 121, 81, 82, 124, 92, 119, 98, 91, 112, 107, 103, 96, 120, 84, 69, 107});
        f1755b = b6;
        String b7 = l.b(new byte[]{117, 126, 93, 14, 109, 109, 120, 114, 85, 78, 109, 38, 103, 96, 93, 85, 106, 97, 117, Utf8.REPLACEMENT_BYTE, 116, 73, 106, 100, Byte.MAX_VALUE, 122, 85, 105, 119, 110, 121, 65, 66, 79, 111, 97, 114, 116, 66});
        f1756c = b7;
        String b8 = l.b(new byte[]{114, 95, 77, 55, 124, 115, Byte.MAX_VALUE, 83, 69, 119, 124, 56, 96, 65, 77, 108, 123, Byte.MAX_VALUE, 114, 30, 97, 106, 123, Byte.MAX_VALUE, 98, 68, 112, 107, 103, 96, 120, 84, 69, 107});
        f1757d = b8;
        String b9 = l.b(new byte[]{122, 103, 123, Utf8.REPLACEMENT_BYTE, 68, 69, 119, 107, 115, Byte.MAX_VALUE, 68, 14, 104, 121, 123, 100, 67, 73, 122, 38, 80, 126, 92, 68, 124, 122, 87, 98, 68, 112, 107, 103, 96, 120, 84, 69, 107});
        f1758e = b9;
        f1759f = l.b(new byte[]{117, 126, 93, 14, 109, 109, 120, 114, 85, 78, 109, 38, 103, 96, 93, 85, 106, 97, 117, Utf8.REPLACEMENT_BYTE, SignedBytes.MAX_POWER_OF_TWO, 69, 107, 110, 56, 65, 85, 82, Byte.MAX_VALUE, 103, 100, 124, 81, 78, 122, 109, 84, 80, 83, 84, 112, 126, Byte.MAX_VALUE, 101, 73});
        ArrayList<String> arrayList = new ArrayList<>();
        f1760g = arrayList;
        arrayList.add(b6);
        arrayList.add(b7);
        arrayList.add(b8);
        arrayList.add(b9);
    }

    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str) || !TextUtils.equals(str, f1754a)) {
            return false;
        }
        return b(context);
    }

    public static boolean b(Context context, String str) {
        if (TextUtils.isEmpty(str) || !TextUtils.equals(str, f1754a)) {
            return true;
        }
        return !a(context);
    }
}
