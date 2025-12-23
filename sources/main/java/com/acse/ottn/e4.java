package com.acse.ottn;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class e4 {

    /* renamed from: a, reason: collision with root package name */
    public static e4 f4512a;

    public static e4 a() {
        if (f4512a == null) {
            synchronized (e4.class) {
                try {
                    if (f4512a == null) {
                        f4512a = new e4();
                    }
                } finally {
                }
            }
        }
        return f4512a;
    }

    public void a(Context context, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        context.startActivity(Intent.createChooser(intent, str));
    }

    public static void a(Context context, Uri uri, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/png");
        intent.putExtra("android.intent.extra.STREAM", uri);
        context.startActivity(Intent.createChooser(intent, str));
    }
}
