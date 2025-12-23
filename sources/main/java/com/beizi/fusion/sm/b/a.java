package com.beizi.fusion.sm.b;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.sm.b.a.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    private String f13503a;

    @Override // com.beizi.fusion.sm.b.b
    public void a(Exception exc) {
    }

    public static void a(Context context, b bVar) {
        l.a(context).a(bVar);
    }

    public static boolean a(Context context) {
        return l.a(context).a();
    }

    @Override // com.beizi.fusion.sm.b.b
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            a(new d("OAID is empty"));
        } else {
            this.f13503a = str;
        }
    }
}
