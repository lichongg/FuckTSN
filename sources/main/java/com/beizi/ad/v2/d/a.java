package com.beizi.ad.v2.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.beizi.ad.h;
import com.beizi.ad.internal.e.e;
import com.beizi.ad.internal.h.u;
import com.beizi.ad.lance.a.g;
import com.beizi.ad.lance.a.m;
import com.beizi.ad.lance.a.p;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends com.beizi.ad.v2.a.a {

    /* renamed from: b, reason: collision with root package name */
    private int f13232b;

    /* renamed from: c, reason: collision with root package name */
    private List<Pair<String, Integer>> f13233c;

    /* renamed from: d, reason: collision with root package name */
    private View f13234d;

    public void a(int i6, View view, View view2, String str) {
        int n6 = n();
        boolean a6 = p.a(n6);
        m.c("BeiZisAd", "percent = " + n6 + ",isPass = " + a6);
        if (a6) {
            this.f13234d = g.a(i6, view, view2, str);
        }
    }

    public void b(int i6) {
        this.f13232b = i6;
    }

    public int n() {
        int i6;
        com.beizi.ad.v2.a.b bVar = this.f13083a;
        if (bVar == null || !(bVar instanceof b)) {
            return -1;
        }
        String u5 = ((b) bVar).u();
        if (TextUtils.isEmpty(u5)) {
            return -1;
        }
        List<Pair<String, Integer>> list = this.f13233c;
        if (list != null) {
            i6 = -1;
            for (Pair<String, Integer> pair : list) {
                if (u5.contains((CharSequence) pair.first)) {
                    i6 = ((Integer) pair.second).intValue();
                }
            }
        } else {
            i6 = -1;
        }
        return i6 == -1 ? this.f13232b : i6;
    }

    public void o() {
        View view = this.f13234d;
        if (view != null) {
            u.a(view);
        }
    }

    public a(Context context, String str, int i6, h hVar) {
        b bVar = new b(context, str, i6);
        this.f13083a = bVar;
        if (bVar instanceof b) {
            bVar.a(hVar);
        }
    }

    public void a(List<Pair<String, Integer>> list) {
        this.f13233c = list;
    }

    public void a(View view, e eVar) {
        com.beizi.ad.v2.a.b bVar = this.f13083a;
        if (bVar == null || view == null || eVar == null || !(bVar instanceof b)) {
            return;
        }
        ((b) bVar).a(view, eVar);
    }
}
