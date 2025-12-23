package com.beizi.ad;

import android.content.Context;
import android.view.View;
import com.beizi.ad.internal.f.c;
import com.beizi.ad.lance.ApkBean;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface i {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum a {
        CONTENT,
        APP_INSTALL
    }

    String a();

    void a(Context context, View view, String str, String str2, String str3, String str4, int i6);

    void a(View view, String str, String str2, String str3, String str4, int i6, com.beizi.ad.internal.e.b bVar);

    boolean a(View view, com.beizi.ad.internal.e.b bVar);

    boolean a(View view, com.beizi.ad.internal.e.e eVar);

    boolean a(View view, List<View> list, com.beizi.ad.internal.e.b bVar);

    String b();

    String c();

    String d();

    String e();

    String f();

    boolean g();

    void h();

    ArrayList<String> i();

    ArrayList<String> j();

    c.a k();

    c.a l();

    String m();

    ApkBean n();
}
