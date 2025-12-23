package cn.jiguang.bv;

import android.content.Context;
import cn.jiguang.bz.l;
import io.netty.handler.codec.http.HttpConstants;
import java.io.File;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2573a = l.b(new byte[]{80, HttpConstants.SEMICOLON, 80, 96, 112, 82, 77, 79});

    /* renamed from: b, reason: collision with root package name */
    public static final String f2574b = l.b(new byte[]{104, 13, 76, 65, 82});

    /* renamed from: c, reason: collision with root package name */
    public static final String f2575c = l.b(new byte[]{65, 37, 85, 126, 94, 84, 124, 102, 98, 60, 125, 100, HttpConstants.COMMA});

    /* renamed from: d, reason: collision with root package name */
    public static final String f2576d = l.b(new byte[]{72, 13, 122, 103, 101, 60, 93, 69, 109, 105, HttpConstants.SEMICOLON, 124, 84, 21, 106, 125, 123});

    /* renamed from: e, reason: collision with root package name */
    public static final String f2577e = l.b(new byte[]{105, 29, 67, 118, 123, HttpConstants.SEMICOLON, 124, 85, 84, 120, 37, 117, 126, 94, 84, 124, 102, 98, 60, 93, 68, HttpConstants.COMMA});

    /* renamed from: f, reason: collision with root package name */
    public static final String f2578f = l.b(new byte[]{105, 29, 65, 116, 114, HttpConstants.SEMICOLON, 124, 85, 84, 120, 37, 117, 126, 94, 84, 124, 102, 98, 60, 93, 68, HttpConstants.COMMA});

    /* renamed from: g, reason: collision with root package name */
    public static final String f2579g = l.b(new byte[]{76, 112, 106, 124, 100, 68, 73, 117, 123, 56, 98, 95});

    public static String a(Context context, String str) {
        if (context == null) {
            context = cn.jiguang.bz.d.a();
        }
        File filesDir = context.getFilesDir();
        File file = new File(filesDir, "zl");
        return (file.exists() || file.mkdirs()) ? new File(file, str).getAbsolutePath() : new File(filesDir, str).getAbsolutePath();
    }
}
