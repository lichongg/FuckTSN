package com.beizi.ad.internal.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.webkit.WebView;
import com.beizi.ad.AdActivity;
import com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity;
import com.beizi.ad.internal.h;
import com.beizi.ad.internal.h.e;
import com.beizi.ad.internal.h.o;
import com.beizi.ad.internal.h.q;
import com.beizi.ad.internal.h.x;
import com.beizi.ad.internal.i;
import com.beizi.ad.internal.j;
import com.beizi.ad.internal.k;
import com.beizi.ad.lance.ApkBean;
import com.beizi.ad.lance.a.l;
import com.beizi.ad.lance.a.m;
import com.beizi.ad.lance.a.r;
import com.beizi.ad.model.c;
import com.beizi.ad.model.f;
import com.beizi.ad.model.g;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"NewApi"})
/* loaded from: D:\Downloads\app\classes2.dex */
public class c {
    private boolean A;
    private c.e B;
    private c.i C;
    private String D;
    private String E;
    private String F;
    private f.EnumC0127f G;
    private int H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private c.b.C0124c O;
    private c.b.C0123b P;
    private int Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private String V;
    private String W;
    private String X;
    private String Y;
    private String Z;

    /* renamed from: a, reason: collision with root package name */
    public k f11907a;
    private String aA;
    private String aB;
    private String aC;
    private String aD;
    private String aE;
    private c.k aF;
    private String aG;
    private String aH;
    private String aI;
    private com.beizi.ad.internal.e.a aJ;
    private boolean aK;
    private String aa;
    private String ab;
    private String ac;
    private c.b.a ad;
    private boolean ae;
    private boolean af;
    private int ag;
    private int ah;
    private c.b ai;
    private List<c.j> aj;
    private String ak;
    private String al;
    private List<Pair<j, String>> am;
    private String an;
    private String ao;
    private String ap;
    private String aq;
    private LinkedList<String> ar;
    private LinkedList<com.beizi.ad.internal.d.a> as;
    private HashMap<String, Object> at;
    private boolean au;
    private boolean av;
    private String aw;
    private String ax;
    private String ay;
    private int az;

    /* renamed from: b, reason: collision with root package name */
    public String f11908b;

    /* renamed from: c, reason: collision with root package name */
    public String f11909c;

    /* renamed from: d, reason: collision with root package name */
    private String f11910d;

    /* renamed from: e, reason: collision with root package name */
    private String f11911e;

    /* renamed from: f, reason: collision with root package name */
    private f.a f11912f;

    /* renamed from: g, reason: collision with root package name */
    private int f11913g;

    /* renamed from: h, reason: collision with root package name */
    private int f11914h;

    /* renamed from: i, reason: collision with root package name */
    private int f11915i;

    /* renamed from: j, reason: collision with root package name */
    private int f11916j;

    /* renamed from: k, reason: collision with root package name */
    private int f11917k;

    /* renamed from: l, reason: collision with root package name */
    private int f11918l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f11919m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f11920n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f11921o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f11922p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f11923q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f11924r;

    /* renamed from: s, reason: collision with root package name */
    private int f11925s;

    /* renamed from: t, reason: collision with root package name */
    private int f11926t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f11927u;

    /* renamed from: v, reason: collision with root package name */
    private int f11928v;

    /* renamed from: w, reason: collision with root package name */
    private a f11929w;

    /* renamed from: x, reason: collision with root package name */
    private a f11930x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f11931y;

    /* renamed from: z, reason: collision with root package name */
    private String f11932z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static int f11937a = 0;

        /* renamed from: b, reason: collision with root package name */
        public static int f11938b = 1;

        /* renamed from: c, reason: collision with root package name */
        String f11939c;

        /* renamed from: d, reason: collision with root package name */
        int f11940d = 0;

        public int b() {
            return this.f11940d;
        }

        public String a() {
            return this.f11939c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            this.f11939c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i6) {
            this.f11940d = i6;
        }
    }

    public c(e eVar, k kVar) {
        this.f11913g = 0;
        this.f11914h = 1;
        this.f11915i = 0;
        this.f11916j = 0;
        this.f11917k = 0;
        this.f11918l = 0;
        this.f11919m = false;
        this.f11920n = true;
        this.f11921o = false;
        this.f11922p = false;
        this.f11923q = false;
        this.f11924r = false;
        this.f11925s = 0;
        this.f11926t = 0;
        this.f11927u = false;
        this.f11928v = 0;
        this.f11929w = new a();
        this.f11930x = new a();
        this.f11931y = true;
        this.A = false;
        this.B = new c.e();
        this.H = 0;
        this.ag = -1;
        this.am = new LinkedList();
        this.ar = new LinkedList<>();
        this.as = new LinkedList<>();
        this.at = new HashMap<>();
        this.au = false;
        this.av = false;
        this.aK = true;
        this.f11907a = kVar;
        c(eVar.e());
        try {
            a(c.l.a(eVar.d().toByteArray()));
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
    }

    private boolean d(c.l lVar) {
        if (lVar.a() > 0) {
            for (c.m mVar : lVar.c()) {
                this.f11920n = mVar.m();
                if (mVar.s() > 0) {
                    for (c.d dVar : mVar.r()) {
                        if (dVar.h() <= 0 || dVar.g().get(0) == null) {
                            if (dVar.d() > 0) {
                                for (c.a aVar : dVar.f()) {
                                    if (this.f11920n) {
                                        for (int i6 = 0; i6 < aVar.d(); i6++) {
                                            if (!o.a(aVar.c().get(i6).a())) {
                                                this.ar.add(aVar.c().get(i6).b());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (this.ar.isEmpty()) {
            return false;
        }
        this.au = true;
        return true;
    }

    private boolean e(c.l lVar) {
        if (lVar.a() > 0) {
            c.m mVar = lVar.c().get(0);
            this.f11910d = mVar.a();
            this.f11911e = mVar.b();
            this.f11912f = mVar.c();
            this.f11913g = mVar.d();
            this.f11914h = mVar.e() == f.h.PORTRAIT ? 1 : 2;
            this.f11918l = Integer.parseInt(mVar.f());
            this.f11917k = Integer.parseInt(mVar.g());
            List<c.d> r5 = mVar.r();
            if (r5 != null && r5.size() > 0) {
                this.f11932z = r5.get(0).i();
                this.D = r5.get(0).k();
                this.al = r5.get(0).b();
                this.H = r5.get(0).l();
                this.aG = r5.get(0).n();
                this.aH = r5.get(0).o();
                this.aI = r5.get(0).p();
            }
            this.C = mVar.t();
            this.f11919m = mVar.o();
            this.f11920n = mVar.m();
            this.f11921o = mVar.q();
            this.f11922p = mVar.n();
            this.f11923q = mVar.i();
            this.f11924r = mVar.k();
            this.f11925s = mVar.l();
            this.f11926t = mVar.j();
            this.f11927u = mVar.p();
            if (this.f11919m && this.f11918l == 0 && this.f11917k == 0) {
                this.f11918l = PredefinedCaptureConfigurations.f35647n;
                this.f11917k = PredefinedCaptureConfigurations.f35648o;
            }
            if (mVar.s() > 0) {
                for (c.d dVar : mVar.r()) {
                    if (dVar.h() <= 0 || dVar.g().get(0) == null) {
                        this.ak = dVar.a();
                        if (dVar.d() >= 0) {
                            for (c.a aVar : dVar.f()) {
                                if (this.f11920n) {
                                    for (int i6 = 0; i6 < aVar.d(); i6++) {
                                        if (!o.a(aVar.c().get(i6).a())) {
                                            this.ar.add(aVar.c().get(i6).b());
                                        }
                                    }
                                }
                                if (aVar.a() == f.EnumC0127f.RENDER_JSON && aVar.d() > 0) {
                                    try {
                                        c.C0125c e6 = dVar.e();
                                        if (e6 != null) {
                                            if (e6.a() != null) {
                                                this.f11929w.a(e6.a());
                                                this.f11929w.a(a.f11937a);
                                            } else {
                                                this.f11929w.a(e6.b());
                                                this.f11929w.a(a.f11938b);
                                            }
                                            if (e6.c() != null) {
                                                this.f11930x.a(e6.c());
                                                this.f11930x.a(a.f11937a);
                                            } else {
                                                this.f11930x.a(e6.d());
                                                this.f11930x.a(a.f11938b);
                                            }
                                        }
                                        com.beizi.ad.internal.e.a a6 = com.beizi.ad.internal.e.a.a(new JSONObject(aVar.b()));
                                        this.aJ = a6;
                                        a6.b(A());
                                        this.aJ.a(z());
                                        this.F = this.aJ.b();
                                        if (dVar.c() != null) {
                                            a(dVar.c());
                                            c.b c6 = dVar.c();
                                            this.ao = c6.a();
                                            this.ap = c6.b();
                                            this.aq = c6.h();
                                            this.aJ.b(!o.a(this.ao) ? this.ao : this.aq);
                                            this.aJ.c(this.ap);
                                            this.aJ.a(dVar.c());
                                            c.j i7 = c6.i();
                                            if (i7 != null && !TextUtils.isEmpty(i7.a())) {
                                                this.aJ.d(i7.a());
                                            }
                                            if (i7 != null && !TextUtils.isEmpty(i7.b())) {
                                                this.aJ.e(i7.b());
                                            }
                                            List<c.j> l6 = c6.l();
                                            if (l6 != null && l6.size() > 0) {
                                                for (int i8 = 0; i8 < l6.size(); i8++) {
                                                    String b6 = l6.get(i8).b();
                                                    if (!TextUtils.isEmpty(b6)) {
                                                        this.aJ.e(b6);
                                                    }
                                                    String a7 = l6.get(i8).a();
                                                    if (!TextUtils.isEmpty(a7)) {
                                                        this.aJ.d(a7);
                                                    }
                                                }
                                            }
                                        }
                                        c.e j6 = dVar.j();
                                        if (j6 != null) {
                                            this.B.a(j6.a());
                                            this.B.a(j6.b());
                                            this.B.b(j6.c());
                                        }
                                    } catch (JSONException unused) {
                                    }
                                    if (this.aJ != null) {
                                        this.au = true;
                                        return true;
                                    }
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        if (this.am.isEmpty()) {
            return false;
        }
        this.au = true;
        return true;
    }

    private boolean f(c.l lVar) {
        if (lVar.a() > 0) {
            c.m mVar = lVar.c().get(0);
            List<c.d> r5 = mVar.r();
            if (r5 != null && r5.size() > 0) {
                c.d dVar = r5.get(0);
                if (dVar.c() != null) {
                    c.b c6 = dVar.c();
                    a(c6);
                    this.ao = c6.a();
                    this.aq = c6.h();
                    c.j i6 = c6.i();
                    if (i6 != null && !TextUtils.isEmpty(i6.a())) {
                        this.f11908b = i6.a();
                    }
                    if (i6 != null && !TextUtils.isEmpty(i6.b())) {
                        this.f11909c = i6.b();
                    }
                    if (i6 != null && !TextUtils.isEmpty(i6.c())) {
                        this.an = i6.c();
                    }
                }
            }
            this.f11910d = mVar.a();
            this.f11911e = mVar.b();
            this.f11912f = mVar.c();
            this.f11913g = mVar.d();
            this.f11914h = mVar.e() == f.h.PORTRAIT ? 1 : 2;
            this.f11917k = Integer.parseInt(mVar.f());
            this.f11918l = Integer.parseInt(mVar.g());
            List<c.d> r6 = mVar.r();
            if (r6 != null && r6.size() > 0) {
                this.f11932z = r6.get(0).i();
                this.D = r6.get(0).k();
                this.al = r6.get(0).b();
                this.H = r6.get(0).l();
                this.aG = r6.get(0).n();
                this.aH = r6.get(0).o();
                this.aI = r6.get(0).p();
            }
            this.C = mVar.t();
            this.f11915i = 0;
            this.f11916j = 0;
            if (mVar.h() != null && x() == f.a.ADP_TABLE) {
                c.h h6 = mVar.h();
                this.f11915i = Integer.parseInt(h6.a());
                this.f11916j = Integer.parseInt(h6.b());
            }
            if (mVar.s() > 0) {
                for (c.d dVar2 : mVar.r()) {
                    if (dVar2.h() > 0 && dVar2.g().get(0) != null) {
                        c.g gVar = dVar2.g().get(0);
                        this.as.add(new com.beizi.ad.internal.d.a(gVar.a(), gVar.c(), this.f11918l, this.f11917k, gVar.b(), ""));
                    }
                }
            }
        }
        if (this.as.isEmpty()) {
            return false;
        }
        this.au = true;
        return true;
    }

    private boolean g(c.l lVar) {
        if (lVar.a() > 0) {
            c.m mVar = lVar.c().get(0);
            this.f11910d = mVar.a();
            this.f11911e = mVar.b();
            this.f11912f = mVar.c();
            this.f11913g = mVar.d();
            this.f11914h = mVar.e() == f.h.PORTRAIT ? 1 : 2;
            this.f11918l = Integer.parseInt(mVar.f());
            this.f11917k = Integer.parseInt(mVar.g());
            if (mVar.h() != null && (x() == f.a.ADP_TABLE || x() == f.a.ADP_CUSTOMER)) {
                c.h h6 = mVar.h();
                this.f11915i = Integer.parseInt(h6.a());
                this.f11916j = Integer.parseInt(h6.b());
            } else if (!o.a(mVar.b()) && x() == f.a.ADP_IVIDEO) {
                a("REWARD_ITEM", mVar.b());
            }
            this.f11919m = mVar.o();
            this.f11920n = mVar.m();
            this.f11921o = mVar.q();
            this.f11922p = mVar.n();
            this.f11923q = mVar.i();
            this.f11924r = mVar.k();
            this.f11925s = mVar.l();
            this.f11926t = mVar.j();
            this.f11927u = mVar.p();
            List<c.d> r5 = mVar.r();
            if (r5 != null && r5.size() > 0) {
                this.f11932z = r5.get(0).i();
                this.D = r5.get(0).k();
                this.al = r5.get(0).b();
                this.H = r5.get(0).l();
                this.aG = r5.get(0).n();
                this.aH = r5.get(0).o();
                this.aI = r5.get(0).p();
            }
            this.C = mVar.t();
            if (this.f11919m && this.f11918l == 0 && this.f11917k == 0) {
                this.f11918l = PredefinedCaptureConfigurations.f35647n;
                this.f11917k = PredefinedCaptureConfigurations.f35648o;
            }
            if (mVar.s() > 0) {
                int i6 = 0;
                for (c.d dVar : mVar.r()) {
                    if (i6 == 0) {
                        this.al = dVar.b();
                        m.a("BeiZisAd", "mAdid = " + this.al);
                    }
                    if (dVar.h() <= 0 || dVar.g().get(0) == null) {
                        this.ak = dVar.a();
                        c.C0125c e6 = dVar.e();
                        if (e6 != null) {
                            if (e6.a() != null) {
                                this.f11929w.a(e6.a());
                                this.f11929w.a(a.f11937a);
                            } else {
                                this.f11929w.a(e6.b());
                                this.f11929w.a(a.f11938b);
                            }
                            if (e6.c() != null) {
                                this.f11930x.a(e6.c());
                                this.f11930x.a(a.f11937a);
                            } else {
                                this.f11930x.a(e6.d());
                                this.f11930x.a(a.f11938b);
                            }
                        }
                        if (dVar.d() > 0) {
                            for (c.a aVar : dVar.f()) {
                                if (this.f11920n) {
                                    for (int i7 = 0; i7 < aVar.d(); i7++) {
                                        if (!o.a(aVar.c().get(i7).a())) {
                                            this.ar.add(aVar.c().get(i7).b());
                                        }
                                    }
                                }
                                a(aVar.b());
                                this.G = aVar.a();
                                if (aVar.d() > 0) {
                                    this.F = aVar.c().get(0).b();
                                }
                            }
                        }
                        if (dVar.c() != null) {
                            c.b c6 = dVar.c();
                            a(c6);
                            this.ao = c6.a();
                            this.aq = c6.h();
                            if (this.f11907a == k.REWARDEDVIDEO) {
                                this.ap = c6.b();
                            } else {
                                this.ap = Uri.decode(c6.b());
                            }
                            c.j i8 = c6.i();
                            if (i8 != null && !TextUtils.isEmpty(i8.a())) {
                                this.f11908b = i8.a();
                            }
                            if (i8 != null && !TextUtils.isEmpty(i8.b())) {
                                this.f11909c = i8.b();
                            }
                            if (i8 != null && !TextUtils.isEmpty(i8.c())) {
                                this.an = i8.c();
                            }
                        }
                        c.e j6 = dVar.j();
                        if (j6 != null) {
                            this.B.a(j6.a());
                            this.B.a(j6.b());
                            this.B.b(j6.c());
                        }
                    }
                    i6++;
                    if (!TextUtils.isEmpty(this.F)) {
                        break;
                    }
                }
            }
        }
        if (TextUtils.isEmpty(this.F)) {
            return false;
        }
        this.au = true;
        return true;
    }

    public void a(boolean z5) {
    }

    public void b(Map map) {
    }

    public boolean h() {
        return this.au;
    }

    private void ai() {
        if (this.ar.isEmpty()) {
            return;
        }
        final h a6 = h.a();
        a6.c().post(new Runnable() { // from class: com.beizi.ad.internal.f.c.1
            @Override // java.lang.Runnable
            public void run() {
                int i6;
                Iterator it = c.this.ar.iterator();
                while (it.hasNext()) {
                    try {
                        InputStream openStream = new URL(a6.b().a((String) it.next())).openStream();
                        byte[] bArr = new byte[1024];
                        while (i6 > 0) {
                            int read = openStream.read(bArr);
                            i6 = read != -1 ? i6 - read : 1024000;
                        }
                    } catch (IOException unused) {
                    }
                }
            }
        });
    }

    private boolean aj() {
        if (TextUtils.isEmpty(this.R) || TextUtils.isEmpty(this.W) || TextUtils.isEmpty(this.V) || TextUtils.isEmpty(this.Z) || TextUtils.isEmpty(this.ab)) {
            return false;
        }
        if (TextUtils.isEmpty(this.Y) && TextUtils.isEmpty(this.X)) {
            return false;
        }
        int i6 = this.Q;
        return i6 == 2 || i6 == 5;
    }

    private boolean ak() {
        int i6 = this.Q;
        return i6 == 2 ? !TextUtils.isEmpty(this.U) && this.U.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a) : i6 == 5 && !TextUtils.isEmpty(this.U) && this.U.contains("market://");
    }

    private void c(Map<String, List<String>> map) {
        if (map != null) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if (entry.getKey() != null) {
                    Iterator<String> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        TextUtils.isEmpty(it.next());
                    }
                }
            }
        }
    }

    private boolean h(c.l lVar) {
        if (lVar.a() > 0) {
            c.m mVar = lVar.c().get(0);
            this.f11910d = mVar.a();
            this.f11911e = mVar.b();
            this.f11912f = mVar.c();
            this.f11913g = mVar.d();
            this.f11914h = mVar.e() == f.h.PORTRAIT ? 1 : 2;
            this.f11918l = Integer.parseInt(mVar.f());
            this.f11917k = Integer.parseInt(mVar.g());
            if (mVar.h() != null && (x() == f.a.ADP_TABLE || x() == f.a.ADP_CUSTOMER)) {
                c.h h6 = mVar.h();
                this.f11915i = Integer.parseInt(h6.a());
                this.f11916j = Integer.parseInt(h6.b());
            } else if (!o.a(mVar.b()) && x() == f.a.ADP_IVIDEO) {
                a("REWARD_ITEM", mVar.b());
            }
            this.f11919m = mVar.o();
            this.f11920n = mVar.m();
            this.f11921o = mVar.q();
            this.f11922p = mVar.n();
            this.f11923q = mVar.i();
            this.f11924r = mVar.k();
            this.f11925s = mVar.l();
            this.f11926t = mVar.j();
            this.f11927u = mVar.p();
            List<c.d> r5 = mVar.r();
            if (r5 != null && r5.size() > 0) {
                this.f11932z = r5.get(0).i();
                this.D = r5.get(0).k();
                this.al = r5.get(0).b();
                this.H = r5.get(0).l();
                this.aG = r5.get(0).n();
                this.aH = r5.get(0).o();
                this.aI = r5.get(0).p();
            }
            this.C = mVar.t();
            if (this.f11919m && this.f11918l == 0 && this.f11917k == 0) {
                this.f11918l = PredefinedCaptureConfigurations.f35647n;
                this.f11917k = PredefinedCaptureConfigurations.f35648o;
            }
            if (mVar.s() > 0) {
                int i6 = 0;
                for (c.d dVar : mVar.r()) {
                    if (i6 == 0) {
                        this.al = dVar.b();
                        m.a("BeiZisAd", "mAdid = " + this.al);
                    }
                    if (dVar.h() <= 0 || dVar.g().get(0) == null) {
                        this.ak = dVar.a();
                        c.C0125c e6 = dVar.e();
                        if (e6 != null) {
                            if (e6.a() != null) {
                                this.f11929w.a(e6.a());
                                this.f11929w.a(a.f11937a);
                            } else {
                                this.f11929w.a(e6.b());
                                this.f11929w.a(a.f11938b);
                            }
                            if (e6.c() != null) {
                                this.f11930x.a(e6.c());
                                this.f11930x.a(a.f11937a);
                            } else {
                                this.f11930x.a(e6.d());
                                this.f11930x.a(a.f11938b);
                            }
                        }
                        if (dVar.d() > 0) {
                            for (c.a aVar : dVar.f()) {
                                if (this.f11920n) {
                                    for (int i7 = 0; i7 < aVar.d(); i7++) {
                                        if (!o.a(aVar.c().get(i7).a())) {
                                            this.ar.add(aVar.c().get(i7).b());
                                        }
                                    }
                                }
                                b(aVar.b());
                            }
                        }
                        if (dVar.c() != null) {
                            c.b c6 = dVar.c();
                            a(c6);
                            this.ao = c6.a();
                            this.aq = c6.h();
                            if (this.f11907a == k.REWARDEDVIDEO) {
                                this.ap = c6.b();
                            } else {
                                this.ap = Uri.decode(c6.b());
                            }
                            c.j i8 = c6.i();
                            if (i8 != null && !TextUtils.isEmpty(i8.a())) {
                                this.f11908b = i8.a();
                            }
                            if (i8 != null && !TextUtils.isEmpty(i8.b())) {
                                this.f11909c = i8.b();
                            }
                            if (i8 != null && !TextUtils.isEmpty(i8.c())) {
                                this.an = i8.c();
                            }
                        }
                        c.e j6 = dVar.j();
                        if (j6 != null) {
                            this.B.a(j6.a());
                            this.B.a(j6.b());
                            this.B.b(j6.c());
                        }
                        this.aF = dVar.m();
                    }
                    i6++;
                    if (!this.am.isEmpty()) {
                        break;
                    }
                }
            }
        }
        if (TextUtils.isEmpty(this.ay)) {
            return false;
        }
        this.au = true;
        return true;
    }

    public a A() {
        return this.f11930x;
    }

    public String B() {
        return this.R;
    }

    public String C() {
        return this.V;
    }

    public String D() {
        return this.W;
    }

    public String E() {
        return this.X;
    }

    public String F() {
        return this.Y;
    }

    public String G() {
        return this.Z;
    }

    public String H() {
        return this.ab;
    }

    public int I() {
        return this.Q;
    }

    public String J() {
        return this.aw;
    }

    public String K() {
        return this.ax;
    }

    public String L() {
        return this.aA;
    }

    public String M() {
        return this.ay;
    }

    public boolean N() {
        return !TextUtils.isEmpty(this.ay);
    }

    public String O() {
        return this.aC;
    }

    public boolean P() {
        return TextUtils.isEmpty(this.ap) && aj() && ak();
    }

    public Map Q() {
        if (this.B == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("forceUnreal", Boolean.valueOf(this.B.a()));
        if (this.B.b() > 0.0d) {
            hashMap.put("maxAcc", Double.valueOf(this.B.b()));
        }
        if (this.B.c() > 0.0d) {
            hashMap.put("angle", Double.valueOf(this.B.c()));
        }
        return hashMap;
    }

    public String R() {
        try {
            JSONObject jSONObject = new JSONObject();
            c.i iVar = this.C;
            if (iVar != null) {
                jSONObject.put("raiseSortPrice", iVar.a());
                jSONObject.put("effectRate", this.C.b());
                jSONObject.put("auctionType", this.C.c());
                jSONObject.put("isLastLook", this.C.d());
                jSONObject.put("winPriceMin", this.C.e());
                jSONObject.put("winPriceMax", this.C.f());
                jSONObject.put("customData", this.C.g());
            } else {
                jSONObject.put("raiseSortPrice", -1);
                jSONObject.put("effectRate", -1);
                jSONObject.put("auctionType", -1);
                jSONObject.put("isLastLook", -1);
                jSONObject.put("winPriceMin", "");
                jSONObject.put("winPriceMax", "");
                jSONObject.put("customData", "");
            }
            try {
                if (!TextUtils.isEmpty(this.D)) {
                    jSONObject.put("secondPrice", Integer.parseInt(this.D));
                }
            } catch (NumberFormatException e6) {
                e6.printStackTrace();
            } catch (JSONException e7) {
                e7.printStackTrace();
            }
            return com.beizi.ad.lance.a.a.a(l.a(), com.beizi.ad.internal.h.c.a(jSONObject.toString()));
        } catch (Exception e8) {
            e8.printStackTrace();
            return null;
        }
    }

    public String S() {
        return this.F;
    }

    public f.EnumC0127f T() {
        return this.G;
    }

    public String U() {
        return this.aD;
    }

    public int V() {
        return this.H;
    }

    public String W() {
        return this.aE;
    }

    public String X() {
        return this.aB;
    }

    public int Y() {
        return this.az;
    }

    public c.k Z() {
        return this.aF;
    }

    public String aa() {
        return this.aG;
    }

    public String ab() {
        return this.ap;
    }

    public String ac() {
        return this.ao;
    }

    public String ad() {
        return this.U;
    }

    public String ae() {
        c.b bVar = this.ai;
        if (bVar == null) {
            return null;
        }
        return bVar.u();
    }

    public String af() {
        c.b bVar = this.ai;
        if (bVar == null) {
            return null;
        }
        return bVar.v();
    }

    public String ag() {
        return this.aH;
    }

    public String ah() {
        return this.aI;
    }

    boolean i() {
        return this.av;
    }

    public HashMap<String, Object> j() {
        return this.at;
    }

    public boolean k() {
        return this.f11919m;
    }

    public boolean l() {
        return this.f11921o;
    }

    public boolean m() {
        return this.f11922p;
    }

    public boolean n() {
        return this.f11923q;
    }

    public boolean o() {
        return this.f11924r;
    }

    public boolean p() {
        return this.f11927u;
    }

    public String q() {
        return this.ak;
    }

    public int r() {
        return this.f11925s;
    }

    public int s() {
        return this.f11926t;
    }

    public int t() {
        return this.f11916j;
    }

    public int u() {
        return this.f11915i;
    }

    public int v() {
        return this.f11914h;
    }

    public int w() {
        return this.f11913g;
    }

    public f.a x() {
        return this.f11912f;
    }

    public void y() {
        List<c.j> l6;
        c.b bVar = this.ai;
        if (bVar == null || (l6 = bVar.l()) == null) {
            return;
        }
        for (int i6 = 0; i6 < l6.size(); i6++) {
            q.c(l6.get(i6));
        }
    }

    public a z() {
        return this.f11929w;
    }

    public void b(boolean z5) {
        this.A = z5;
    }

    private void a(c.b bVar) {
        this.ai = bVar;
        this.aj = bVar.l();
        this.O = bVar.k();
        this.P = bVar.j();
        this.Q = bVar.c();
        this.R = bVar.d();
        this.S = bVar.e();
        this.T = bVar.f();
        this.U = bVar.g();
        if (TextUtils.isEmpty(this.S)) {
            this.S = "lance";
        }
        if (TextUtils.isEmpty(this.R)) {
            this.R = "BeiZi";
        }
        if (TextUtils.isEmpty(this.T)) {
            this.T = "Ad Download";
        }
        this.V = bVar.m();
        this.W = bVar.n();
        this.X = bVar.o();
        this.Y = bVar.p();
        this.Z = bVar.q();
        this.aa = bVar.r();
        this.ab = bVar.s();
        c.b.a t5 = bVar.t();
        this.ad = t5;
        if (t5 != null) {
            if (t5.a() == 1) {
                this.ae = true;
            }
            if (this.ad.b() == 1) {
                this.af = true;
            }
            this.ah = this.ad.c();
        }
    }

    private boolean b(c.l lVar) {
        return lVar.b() == 0;
    }

    public List<Pair<j, String>> b() {
        return this.am;
    }

    private void b(final Context context) {
        if (context == null) {
            return;
        }
        h.a().a(new com.beizi.ad.internal.b() { // from class: com.beizi.ad.internal.f.c.2
            @Override // com.beizi.ad.internal.b
            public void a() {
                try {
                    if (c.this.P != null) {
                        com.beizi.ad.internal.h.l.a(c.this.P.f());
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }

            @Override // com.beizi.ad.internal.b
            public void b() {
                try {
                    m.a("BeiZisAd", "onFailReport");
                    if (c.this.aK) {
                        if (c.this.P != null) {
                            com.beizi.ad.internal.h.l.a(c.this.P.j());
                        }
                        c.this.c(context);
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        });
        Uri parse = Uri.parse(this.ap);
        if (parse.getScheme() != null && parse.getScheme().equals("bzopen") && !TextUtils.isEmpty(parse.getHost()) && parse.getPathSegments().size() > 0) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.MAIN");
            intent.setFlags(268435456);
            intent.addCategory("android.intent.category.LAUNCHER");
            String queryParameter = parse.getQueryParameter("flags");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    if (!queryParameter.startsWith("0x") && !queryParameter.startsWith("0X")) {
                        intent.setFlags(Integer.parseInt(queryParameter));
                    }
                    intent.setFlags(Integer.parseInt(queryParameter.substring(2), 16));
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
            intent.setComponent(new ComponentName(parse.getHost(), parse.getPathSegments().get(0)));
            String queryParameter2 = parse.getQueryParameter("rect");
            if (!TextUtils.isEmpty(queryParameter2)) {
                try {
                    String[] split = queryParameter2.split(":");
                    if (split.length == 4) {
                        Rect rect = new Rect();
                        rect.set(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
                        intent.setSourceBounds(rect);
                    }
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
            context.startActivity(intent);
            return;
        }
        if (this.ap.startsWith("hwpps://landingpage")) {
            Intent intent2 = new Intent();
            intent2.setData(parse);
            intent2.addFlags(268435456);
            context.startActivity(intent2);
            return;
        }
        if (this.ap.startsWith("intent")) {
            Intent intent3 = null;
            try {
                intent3 = Intent.parseUri(this.ap, 1);
                intent3.addFlags(268435456);
            } catch (Exception e8) {
                e8.printStackTrace();
            }
            context.startActivity(intent3);
            return;
        }
        Intent intent4 = new Intent("android.intent.action.VIEW", parse);
        intent4.addFlags(805339136);
        context.startActivity(intent4);
    }

    private boolean c(c.l lVar) {
        if (lVar.a() > 0) {
            c.m mVar = lVar.c().get(0);
            this.f11910d = mVar.a();
            this.f11911e = mVar.b();
            this.f11912f = mVar.c();
            this.f11913g = mVar.d();
            this.f11914h = mVar.e() == f.h.PORTRAIT ? 1 : 2;
            this.f11918l = Integer.parseInt(mVar.f());
            this.f11917k = Integer.parseInt(mVar.g());
            if (mVar.h() != null && (x() == f.a.ADP_TABLE || x() == f.a.ADP_CUSTOMER)) {
                c.h h6 = mVar.h();
                this.f11915i = Integer.parseInt(h6.a());
                this.f11916j = Integer.parseInt(h6.b());
            } else if (!o.a(mVar.b()) && x() == f.a.ADP_IVIDEO) {
                a("REWARD_ITEM", mVar.b());
            }
            this.f11919m = mVar.o();
            this.f11920n = mVar.m();
            this.f11921o = mVar.q();
            this.f11922p = mVar.n();
            this.f11923q = mVar.i();
            this.f11924r = mVar.k();
            this.f11925s = mVar.l();
            this.f11926t = mVar.j();
            this.f11927u = mVar.p();
            List<c.d> r5 = mVar.r();
            if (r5 != null && r5.size() > 0) {
                this.f11932z = r5.get(0).i();
                this.D = r5.get(0).k();
                this.al = r5.get(0).b();
                this.H = r5.get(0).l();
                this.aG = r5.get(0).n();
                this.aH = r5.get(0).o();
                this.aI = r5.get(0).p();
            }
            this.C = mVar.t();
            if (this.f11919m && this.f11918l == 0 && this.f11917k == 0) {
                this.f11918l = PredefinedCaptureConfigurations.f35647n;
                this.f11917k = PredefinedCaptureConfigurations.f35648o;
            }
            if (mVar.s() > 0) {
                int i6 = 0;
                for (c.d dVar : mVar.r()) {
                    if (i6 == 0) {
                        this.al = dVar.b();
                        m.a("BeiZisAd", "mAdid = " + this.al);
                    }
                    if (dVar.h() <= 0 || dVar.g().get(0) == null) {
                        this.ak = dVar.a();
                        c.C0125c e6 = dVar.e();
                        if (e6 != null) {
                            if (e6.a() != null) {
                                this.f11929w.a(e6.a());
                                this.f11929w.a(a.f11937a);
                            } else {
                                this.f11929w.a(e6.b());
                                this.f11929w.a(a.f11938b);
                            }
                            if (e6.c() != null) {
                                this.f11930x.a(e6.c());
                                this.f11930x.a(a.f11937a);
                            } else {
                                this.f11930x.a(e6.d());
                                this.f11930x.a(a.f11938b);
                            }
                        }
                        if (dVar.d() > 0) {
                            for (c.a aVar : dVar.f()) {
                                if (this.f11920n) {
                                    for (int i7 = 0; i7 < aVar.d(); i7++) {
                                        if (!o.a(aVar.c().get(i7).a())) {
                                            this.ar.add(aVar.c().get(i7).b());
                                        }
                                    }
                                }
                                a(aVar.b());
                                b(aVar);
                                if ((aVar.a() == f.EnumC0127f.RENDER_VIDEO || aVar.a() == f.EnumC0127f.RENDER_VAST_VIDEO) && aVar.d() > 0) {
                                    this.am.add(Pair.create(j.VIDEO, aVar.c().get(0).b()));
                                } else {
                                    String a6 = a(aVar);
                                    this.am.add(Pair.create(j.HTML, a6));
                                    if (a6.contains("mraid.js")) {
                                        a("MRAID", Boolean.TRUE);
                                    }
                                }
                            }
                        }
                        if (dVar.c() != null) {
                            c.b c6 = dVar.c();
                            a(c6);
                            this.ao = c6.a();
                            this.aq = c6.h();
                            if (this.f11907a == k.REWARDEDVIDEO) {
                                this.ap = c6.b();
                            } else {
                                this.ap = Uri.decode(c6.b());
                            }
                            c.j i8 = c6.i();
                            if (i8 != null && !TextUtils.isEmpty(i8.a())) {
                                this.f11908b = i8.a();
                            }
                            if (i8 != null && !TextUtils.isEmpty(i8.b())) {
                                this.f11909c = i8.b();
                            }
                            if (i8 != null && !TextUtils.isEmpty(i8.c())) {
                                this.an = i8.c();
                            }
                        }
                        c.e j6 = dVar.j();
                        if (j6 != null) {
                            this.B.a(j6.a());
                            this.B.a(j6.b());
                            this.B.b(j6.c());
                        }
                    }
                    i6++;
                    if (!this.am.isEmpty()) {
                        break;
                    }
                }
            }
        }
        if (this.am.isEmpty()) {
            return false;
        }
        this.au = true;
        return true;
    }

    public int d() {
        return this.f11918l;
    }

    private boolean d(Context context) {
        c.b bVar = this.ai;
        if (bVar == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (bVar.y() == 0) {
            return false;
        }
        String u5 = this.ai.u();
        String v5 = this.ai.v();
        String w5 = this.ai.w();
        if (!TextUtils.isEmpty(u5) && !TextUtils.isEmpty(v5)) {
            return r.a(context, u5, v5, w5);
        }
        String x5 = this.ai.x();
        if (!TextUtils.isEmpty(x5)) {
            return r.a(context, x5);
        }
        return false;
    }

    public void d(View view, String str) {
        c.b bVar;
        List<c.j> l6;
        String h6;
        if (this.L || (bVar = this.ai) == null || (l6 = bVar.l()) == null) {
            return;
        }
        this.L = true;
        for (int i6 = 0; i6 < l6.size(); i6++) {
            c.j jVar = l6.get(i6);
            if (jVar != null && !TextUtils.isEmpty(jVar.h()) && view != null) {
                if (!TextUtils.isEmpty(str)) {
                    h6 = jVar.h().replace("__REQUESTUUID__", str);
                } else {
                    h6 = jVar.h();
                }
                if (this.I) {
                    h6 = h6.replace(g.f13082b, "1");
                }
                new i(o.a(0, view, h6)).executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
            }
        }
    }

    private void a(c.l lVar) {
        if (b(lVar)) {
            k kVar = this.f11907a;
            if (kVar == k.PREFETCH) {
                if (d(lVar)) {
                    return;
                }
            } else if (kVar == k.NEW_SPLASH) {
                if (g(lVar)) {
                    return;
                }
            } else if (kVar == k.REWARDEDVIDEO) {
                if (h(lVar)) {
                    return;
                }
            } else if (kVar != k.NATIVE) {
                if (c(lVar)) {
                    return;
                }
            } else if (e(lVar)) {
                return;
            }
            f(lVar);
        }
    }

    public c(String str, Map<String, List<String>> map, k kVar) {
        this.f11913g = 0;
        this.f11914h = 1;
        this.f11915i = 0;
        this.f11916j = 0;
        this.f11917k = 0;
        this.f11918l = 0;
        this.f11919m = false;
        this.f11920n = true;
        this.f11921o = false;
        this.f11922p = false;
        this.f11923q = false;
        this.f11924r = false;
        this.f11925s = 0;
        this.f11926t = 0;
        this.f11927u = false;
        this.f11928v = 0;
        this.f11929w = new a();
        this.f11930x = new a();
        this.f11931y = true;
        this.A = false;
        this.B = new c.e();
        this.H = 0;
        this.ag = -1;
        this.am = new LinkedList();
        this.ar = new LinkedList<>();
        this.as = new LinkedList<>();
        this.at = new HashMap<>();
        this.au = false;
        this.av = false;
        this.aK = true;
        if (str == null) {
            return;
        }
        this.f11907a = kVar;
        this.aE = str;
        try {
            a(c.l.c(str));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        ai();
    }

    public void d(boolean z5) {
        try {
            this.aK = z5;
            com.beizi.ad.internal.e.a aVar = this.aJ;
            if (aVar != null) {
                aVar.d(z5);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private String a(c.a aVar) {
        if (aVar.a() != f.EnumC0127f.RENDER_H5 && aVar.a() != f.EnumC0127f.RENDER_PIC) {
            return "";
        }
        if (aVar.a() == f.EnumC0127f.RENDER_PIC && aVar.d() > 0) {
            return "<!DOCTYPE html>\n<html lang=\"en\" style=\"width: 100%; height: 100%;\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" id=\"viewport\" content=\"width=device-width, height=device-height, initial-scale=1\">\n    <title>Document</title>\n</head>\n<body style=\"width: 100%; height: 100%; padding: 0; margin: 0;\">\n<img style=\"width: 100%; height: 100%\" src=\"__IMAGE_SRC_PATH__\" alt=\"\"/>\n</body>\n</html><!DOCTYPE html>".replace("__IMAGE_SRC_PATH__", aVar.c().get(0).b());
        }
        Matcher matcher = Pattern.compile("\\{(\\d+)\\.value\\}").matcher(aVar.b());
        HashMap hashMap = new HashMap();
        for (int i6 = 0; i6 < aVar.d(); i6++) {
            hashMap.put(Integer.valueOf(i6), aVar.c().get(i6).b());
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            Integer valueOf = Integer.valueOf(Integer.parseInt(matcher.group(1)));
            if (hashMap.get(valueOf) != null) {
                matcher.appendReplacement(stringBuffer, (String) hashMap.get(valueOf));
            } else {
                matcher.appendReplacement(stringBuffer, "");
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private void b(c.a aVar) {
        List<c.f> c6;
        c.f fVar;
        if (aVar == null) {
            return;
        }
        try {
            if (aVar.a() == f.EnumC0127f.RENDER_PIC && (c6 = aVar.c()) != null && c6.size() != 0 && (fVar = c6.get(0)) != null) {
                this.aD = fVar.b();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public String f() {
        return this.al;
    }

    public void f(View view, String str) {
        c.b bVar;
        List<c.j> l6;
        String f6;
        if (this.N || (bVar = this.ai) == null || (l6 = bVar.l()) == null) {
            return;
        }
        this.N = true;
        for (int i6 = 0; i6 < l6.size(); i6++) {
            c.j jVar = l6.get(i6);
            if (jVar != null && !TextUtils.isEmpty(jVar.f()) && view != null) {
                if (!TextUtils.isEmpty(str)) {
                    f6 = jVar.f().replace("__REQUESTUUID__", str);
                } else {
                    f6 = jVar.f();
                }
                if (this.I) {
                    f6 = f6.replace(g.f13082b, "1");
                }
                new i(o.a(0, view, f6)).executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
            }
        }
    }

    private void b(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith("{")) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("title")) {
                    this.aw = com.beizi.ad.internal.h.k.c(jSONObject, "title");
                }
                if (jSONObject.has("desc")) {
                    this.ax = com.beizi.ad.internal.h.k.c(jSONObject, "desc");
                }
                if (jSONObject.has("appIcon")) {
                    this.aC = com.beizi.ad.internal.h.k.c(jSONObject, "appIcon");
                }
                if (jSONObject.has("lauchImageUrl")) {
                    this.aB = com.beizi.ad.internal.h.k.c(jSONObject, "lauchImageUrl");
                }
                if (jSONObject.has("videoUrl")) {
                    this.ay = com.beizi.ad.internal.h.k.c(jSONObject, "videoUrl");
                }
                if (jSONObject.has("videoTime")) {
                    this.az = com.beizi.ad.internal.h.k.d(jSONObject, "videoTime");
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public com.beizi.ad.i a() {
        return this.aJ;
    }

    public void a(String str, Object obj) {
        this.at.put(str, obj);
    }

    public void a(int i6) {
        this.f11914h = i6;
    }

    public void a(View view, String str) {
        List<c.j> l6;
        String a6;
        int i6 = this.f11928v;
        if (i6 <= 0) {
            this.f11928v = i6 + 1;
            if (!o.a(this.f11908b)) {
                if (!TextUtils.isEmpty(this.E)) {
                    this.f11908b = this.f11909c.replace(g.f13081a, this.E);
                }
                if (this.I) {
                    this.f11908b = this.f11909c.replace(g.f13082b, "1");
                }
                this.f11908b = q.a(this.f11908b, "", "", "", "", "", "", "");
                new i(this.f11908b).execute(new Void[0]);
                this.f11908b = "";
            }
            c.b bVar = this.ai;
            if (bVar == null || (l6 = bVar.l()) == null) {
                return;
            }
            for (int i7 = 0; i7 < l6.size(); i7++) {
                c.j jVar = l6.get(i7);
                if (jVar != null && !TextUtils.isEmpty(jVar.a()) && view != null) {
                    if (!TextUtils.isEmpty(str)) {
                        a6 = jVar.a().replace("__REQUESTUUID__", str);
                    } else {
                        a6 = jVar.a();
                    }
                    if (!TextUtils.isEmpty(this.E)) {
                        a6 = a6.replace(g.f13081a, this.E);
                    }
                    if (this.I) {
                        a6 = a6.replace(g.f13082b, "1");
                    }
                    new i(o.a(0, view, a6)).executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
                }
            }
        }
    }

    public void b(View view, String str) {
        c.b bVar;
        List<c.j> l6;
        String d6;
        if (this.J || (bVar = this.ai) == null || (l6 = bVar.l()) == null) {
            return;
        }
        this.J = true;
        for (int i6 = 0; i6 < l6.size(); i6++) {
            c.j jVar = l6.get(i6);
            if (jVar != null && !TextUtils.isEmpty(jVar.d()) && view != null) {
                if (!TextUtils.isEmpty(str)) {
                    d6 = jVar.d().replace("__REQUESTUUID__", str);
                } else {
                    d6 = jVar.d();
                }
                if (this.I) {
                    d6 = d6.replace(g.f13082b, "1");
                }
                new i(o.a(0, view, d6)).executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
            }
        }
    }

    public c(boolean z5) {
        this.f11913g = 0;
        this.f11914h = 1;
        this.f11915i = 0;
        this.f11916j = 0;
        this.f11917k = 0;
        this.f11918l = 0;
        this.f11919m = false;
        this.f11920n = true;
        this.f11921o = false;
        this.f11922p = false;
        this.f11923q = false;
        this.f11924r = false;
        this.f11925s = 0;
        this.f11926t = 0;
        this.f11927u = false;
        this.f11928v = 0;
        this.f11929w = new a();
        this.f11930x = new a();
        this.f11931y = true;
        this.A = false;
        this.B = new c.e();
        this.H = 0;
        this.ag = -1;
        this.am = new LinkedList();
        this.ar = new LinkedList<>();
        this.as = new LinkedList<>();
        this.at = new HashMap<>();
        this.au = false;
        this.aK = true;
        this.av = z5;
    }

    public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, boolean z5, String str7) {
        View rootView;
        String a6;
        m.a("BeiZisAd", "handleClick========" + z5);
        Context context = null;
        if (!z5) {
            if (!o.a(this.f11909c)) {
                String a7 = q.a(this.f11909c, str, str2, str3, str4, str5, str6, "");
                this.f11909c = a7;
                if (this.I) {
                    this.f11909c = a7.replace(g.f13082b, "1");
                }
                new i(this.f11909c).execute(new Void[0]);
                this.f11909c = "";
            }
            if (this.ai != null && this.aj != null) {
                for (int i6 = 0; i6 < this.aj.size(); i6++) {
                    c.j jVar = this.aj.get(i6);
                    if (jVar != null && !TextUtils.isEmpty(jVar.b())) {
                        if (!TextUtils.isEmpty(str7)) {
                            a6 = q.a(jVar.b(), str, str2, str3, str4, str5, str6, "").replace("__REQUESTUUID__", str7);
                        } else {
                            a6 = q.a(jVar.b(), str, str2, str3, str4, str5, str6, "");
                        }
                        if (this.I) {
                            a6 = a6.replace(g.f13082b, "1");
                        }
                        new i(o.a(view, a6)).executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
                    }
                }
                this.aj = null;
            }
        }
        m.a("BeiZisAd", "mDeepLinkUrl:" + this.ap + ",appDownloadURL = " + this.U + ",mLandingPageUrl = " + this.ao);
        if (view != null) {
            try {
                context = view.getContext();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        if (!(context instanceof Activity) && view != null && view.getRootView() != null && (rootView = view.getRootView()) != null) {
            context = rootView.getContext();
        }
        if (context == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.ap)) {
            try {
                if (!com.beizi.ad.lance.a.k.a(context, this.ap) && !com.beizi.ad.lance.a.h.a(context, this.S) && !this.ap.startsWith("hwpps://landingpage") && !this.ap.startsWith("intent") && !this.ap.startsWith("hap://")) {
                    c.b.C0123b c0123b = this.P;
                    if (c0123b != null) {
                        com.beizi.ad.internal.h.l.a(c0123b.i());
                    }
                    a(context);
                    return;
                }
                c.b.C0123b c0123b2 = this.P;
                if (c0123b2 != null) {
                    com.beizi.ad.internal.h.l.a(c0123b2.h());
                }
                b(context);
                c.b.C0123b c0123b3 = this.P;
                if (c0123b3 != null) {
                    com.beizi.ad.internal.h.l.a(c0123b3.e());
                    return;
                }
                return;
            } catch (Exception unused) {
                c.b.C0123b c0123b4 = this.P;
                if (c0123b4 != null) {
                    com.beizi.ad.internal.h.l.a(c0123b4.g());
                }
                a(context);
                return;
            }
        }
        a(context);
    }

    public LinkedList<com.beizi.ad.internal.d.a> g() {
        return this.as;
    }

    public String e() {
        return this.f11932z;
    }

    public void e(View view, String str) {
        c.b bVar;
        List<c.j> l6;
        String i6;
        if (this.M || (bVar = this.ai) == null || (l6 = bVar.l()) == null) {
            return;
        }
        this.M = true;
        for (int i7 = 0; i7 < l6.size(); i7++) {
            c.j jVar = l6.get(i7);
            if (jVar != null && !TextUtils.isEmpty(jVar.i()) && view != null) {
                if (!TextUtils.isEmpty(str)) {
                    i6 = jVar.i().replace("__REQUESTUUID__", str);
                } else {
                    i6 = jVar.i();
                }
                if (this.I) {
                    i6 = i6.replace(g.f13082b, "1");
                }
                new i(o.a(0, view, i6)).executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
            }
        }
    }

    public int c() {
        return this.f11917k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        if (context == null || d(context) || TextUtils.isEmpty(this.ao) || !this.ao.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
            return;
        }
        try {
            if (this.f11931y) {
                Class a6 = AdActivity.a();
                try {
                    WebView webView = new WebView(new MutableContextWrapper(context));
                    x.a(webView);
                    webView.loadUrl(this.ao, com.beizi.ad.lance.a.j.a());
                    com.beizi.ad.internal.activity.a.f11616a.add(webView);
                    Intent intent = new Intent(h.a().e(), (Class<?>) a6);
                    intent.setFlags(268435456);
                    intent.putExtra("ACTIVITY_TYPE", "DOWNLOADBROWSER");
                    intent.putExtra("ACTIVITY_CAN_JUMP", this.ae);
                    intent.putExtra("ACTIVITY_CAN_DOWNLOAD", aj());
                    if (!TextUtils.isEmpty(this.ap)) {
                        intent.putExtra("deeplinkUrl", this.ap);
                        intent.putExtra("webDeepLink", this.ah);
                    }
                    context.startActivity(intent);
                    return;
                } catch (ActivityNotFoundException unused) {
                    com.beizi.ad.internal.activity.a.f11616a.remove();
                    return;
                }
            }
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(this.ao)));
            intent2.addFlags(268435456);
            context.startActivity(intent2);
        } catch (Exception unused2) {
        }
    }

    public void c(boolean z5) {
        this.I = z5;
    }

    public void c(View view, String str) {
        c.b bVar;
        List<c.j> l6;
        String g6;
        if (this.K || (bVar = this.ai) == null || (l6 = bVar.l()) == null) {
            return;
        }
        this.K = true;
        for (int i6 = 0; i6 < l6.size(); i6++) {
            c.j jVar = l6.get(i6);
            if (jVar != null && !TextUtils.isEmpty(jVar.g()) && view != null) {
                if (!TextUtils.isEmpty(str)) {
                    g6 = jVar.g().replace("__REQUESTUUID__", str);
                } else {
                    g6 = jVar.g();
                }
                if (this.I) {
                    g6 = g6.replace(g.f13082b, "1");
                }
                new i(o.a(0, view, g6)).executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
            }
        }
    }

    private void a(Context context) {
        try {
            if (aj() && ak()) {
                int i6 = this.Q;
                if (i6 == 2) {
                    if (com.beizi.ad.lance.a.h.a(context, this.S)) {
                        com.beizi.ad.lance.a.h.b(context, this.S);
                        c.b.C0123b c0123b = this.P;
                        if (c0123b != null) {
                            com.beizi.ad.internal.h.l.a(c0123b.a());
                            return;
                        }
                        return;
                    }
                    a(context, 1);
                    return;
                }
                if (i6 == 5) {
                    if (com.beizi.ad.lance.a.k.a(context, this.U)) {
                        if (!this.af && this.ag != 0) {
                            a(context, 2);
                            return;
                        }
                        a(this.U, context);
                        c.b.C0123b c0123b2 = this.P;
                        if (c0123b2 != null) {
                            com.beizi.ad.internal.h.l.a(c0123b2.a());
                            return;
                        }
                        return;
                    }
                    c(context);
                    return;
                }
                return;
            }
            c(context);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void a(Context context, int i6) {
        try {
            File a6 = com.beizi.ad.lance.a.h.a(context);
            String str = "";
            if (a6 != null) {
                str = a6.getAbsolutePath();
            }
            String str2 = str;
            ApkBean apkBean = new ApkBean(this.U, this.S + ".apk", this.S, str2, this.R, this.T, context.getPackageName() + ".fileprovider", this.P, this.V, this.W, this.X, this.Y, this.Z, this.aa, this.ab);
            apkBean.setFileMD5(this.ac);
            Bundle bundle = new Bundle();
            bundle.putSerializable("apkBean", apkBean);
            bundle.putInt("type", i6);
            bundle.putBoolean("isCanJump", this.ae);
            bundle.putBoolean("isDownload", aj());
            if (i6 == 2) {
                c.b.C0123b c0123b = this.P;
                if (c0123b != null) {
                    bundle.putStringArrayList("openList", (ArrayList) c0123b.a());
                }
                bundle.putString("landingPageUrl", this.ao);
            }
            if (!TextUtils.isEmpty(this.ap)) {
                bundle.putString("deeplinkUrl", this.ap);
                bundle.putInt("webDeepLink", this.ah);
            }
            Intent intent = new Intent(context, (Class<?>) BeiZiDownloadDialogActivity.class);
            intent.putExtra("data", bundle);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void a(String str, Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
        }
    }

    public void a(View view, com.beizi.ad.model.d dVar, String str, String str2, boolean z5, String str3, int i6) {
        String a6;
        m.a("BeiZisAd", "handleClick========" + z5);
        this.ag = i6;
        Context context = null;
        if (!z5) {
            if (!o.a(this.f11909c)) {
                this.f11909c = q.a(this.f11909c, dVar, str, str2, "", i6);
                new i(this.f11909c).execute(new Void[0]);
                this.f11909c = "";
            }
            if (this.ai != null && this.aj != null) {
                for (int i7 = 0; i7 < this.aj.size(); i7++) {
                    c.j jVar = this.aj.get(i7);
                    if (jVar != null && !TextUtils.isEmpty(jVar.b())) {
                        if (!TextUtils.isEmpty(str3)) {
                            a6 = q.a(jVar.b(), dVar, str, str2, "", i6).replace("__REQUESTUUID__", str3);
                        } else {
                            a6 = q.a(jVar.b(), dVar, str, str2, "", i6);
                        }
                        if (this.I) {
                            a6 = a6.replace(g.f13082b, "1");
                        }
                        new i(o.a(view, a6)).executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
                    }
                }
                this.aj = null;
            }
        }
        m.a("BeiZisAd", "mDeepLinkUrl:" + this.ap + ",appDownloadURL = " + this.U + ",mLandingPageUrl = " + this.ao);
        if (view != null) {
            try {
                context = view.getContext();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        m.a("BeiZisAd", "context:" + context + "; flag =" + (context instanceof Activity));
        if (!(context instanceof Activity) && view != null && view.getRootView() != null) {
            View rootView = view.getRootView();
            if (rootView != null) {
                context = rootView.getContext();
            }
            m.a("BeiZisAd", " rootView context:" + context + "; flag =" + (context instanceof Activity));
        }
        if (context == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.ap)) {
            try {
                if (!com.beizi.ad.lance.a.k.a(context, this.ap) && !com.beizi.ad.lance.a.h.a(context, this.S) && !this.ap.startsWith("hwpps://landingpage") && !this.ap.startsWith("intent") && !this.ap.startsWith("hap://")) {
                    c.b.C0123b c0123b = this.P;
                    if (c0123b != null) {
                        com.beizi.ad.internal.h.l.a(c0123b.i());
                    }
                    a(context);
                    return;
                }
                c.b.C0123b c0123b2 = this.P;
                if (c0123b2 != null) {
                    com.beizi.ad.internal.h.l.a(c0123b2.h());
                }
                b(context);
                c.b.C0123b c0123b3 = this.P;
                if (c0123b3 != null) {
                    com.beizi.ad.internal.h.l.a(c0123b3.e());
                    return;
                }
                return;
            } catch (Exception unused) {
                c.b.C0123b c0123b4 = this.P;
                if (c0123b4 != null) {
                    com.beizi.ad.internal.h.l.a(c0123b4.g());
                }
                a(context);
                return;
            }
        }
        a(context);
    }

    public void a(View view, int i6) {
        List<c.j> l6;
        c.b bVar = this.ai;
        if (bVar == null || (l6 = bVar.l()) == null) {
            return;
        }
        for (int i7 = 0; i7 < l6.size(); i7++) {
            q.a(l6.get(i7));
        }
    }

    public void a(View view) {
        List<c.j> l6;
        c.b bVar = this.ai;
        if (bVar == null || (l6 = bVar.l()) == null) {
            return;
        }
        for (int i6 = 0; i6 < l6.size(); i6++) {
            q.b(l6.get(i6));
        }
    }

    private void a(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith("{")) {
                JSONObject jSONObject = new JSONObject(str);
                this.aw = com.beizi.ad.internal.h.k.c(jSONObject, "Headline");
                this.ax = com.beizi.ad.internal.h.k.c(jSONObject, "Body");
                this.aC = com.beizi.ad.internal.h.k.c(jSONObject, "AppIcon");
                JSONArray a6 = com.beizi.ad.internal.h.k.a(jSONObject, "Images");
                JSONArray a7 = com.beizi.ad.internal.h.k.a(jSONObject, "Videos");
                if (a6 != null && a6.length() > 0) {
                    this.aA = (String) a6.get(0);
                }
                if (a7 != null && a7.length() > 0) {
                    this.ay = (String) a7.get(0);
                }
                if (jSONObject.has("apkFileMD5")) {
                    this.ac = com.beizi.ad.internal.h.k.c(jSONObject, "apkFileMD5");
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(Map map) {
        Object obj;
        if (map == null) {
            return;
        }
        try {
            if (map.containsKey("auctionExt") && (obj = map.get("auctionExt")) != null) {
                if (obj instanceof String) {
                    this.E = (String) obj;
                }
                if (TextUtils.isEmpty(this.E)) {
                    return;
                }
                this.E = com.beizi.ad.lance.a.a.a(l.a(), this.E);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
