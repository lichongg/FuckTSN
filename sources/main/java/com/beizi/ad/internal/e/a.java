package com.beizi.ad.internal.e;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.beizi.ad.AdActivity;
import com.beizi.ad.i;
import com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity;
import com.beizi.ad.internal.f.c;
import com.beizi.ad.internal.h.k;
import com.beizi.ad.internal.h.l;
import com.beizi.ad.internal.h.q;
import com.beizi.ad.internal.h.x;
import com.beizi.ad.internal.o;
import com.beizi.ad.lance.ApkBean;
import com.beizi.ad.lance.a.h;
import com.beizi.ad.lance.a.j;
import com.beizi.ad.lance.a.m;
import com.beizi.ad.lance.a.r;
import com.beizi.ad.model.c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a implements i {
    private boolean A;
    private com.beizi.ad.lance.a.f B;
    private View C;
    private List<View> D;
    private b E;
    private View.OnClickListener F;
    private long H;
    private int I;
    private String J;
    private String K;
    private String L;
    private String M;
    private String N;
    private String O;
    private String P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private c.b.C0123b U;
    private c.b.a V;
    private boolean W;
    private boolean X;
    private int Z;

    /* renamed from: a, reason: collision with root package name */
    private i.a f11788a;

    /* renamed from: b, reason: collision with root package name */
    private String f11789b;

    /* renamed from: c, reason: collision with root package name */
    private String f11790c;

    /* renamed from: d, reason: collision with root package name */
    private String f11791d;

    /* renamed from: f, reason: collision with root package name */
    private String f11793f;

    /* renamed from: g, reason: collision with root package name */
    private String f11794g;

    /* renamed from: h, reason: collision with root package name */
    private String f11795h;

    /* renamed from: i, reason: collision with root package name */
    private c.b f11796i;

    /* renamed from: j, reason: collision with root package name */
    private String f11797j;

    /* renamed from: k, reason: collision with root package name */
    private double f11798k;

    /* renamed from: l, reason: collision with root package name */
    private String f11799l;

    /* renamed from: m, reason: collision with root package name */
    private String f11800m;

    /* renamed from: n, reason: collision with root package name */
    private String f11801n;

    /* renamed from: o, reason: collision with root package name */
    private HashMap<String, Object> f11802o;

    /* renamed from: x, reason: collision with root package name */
    private c.a f11811x;

    /* renamed from: y, reason: collision with root package name */
    private c.a f11812y;

    /* renamed from: z, reason: collision with root package name */
    private String f11813z;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<Bitmap> f11792e = new ArrayList<>();

    /* renamed from: p, reason: collision with root package name */
    private boolean f11803p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f11804q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f11805r = false;

    /* renamed from: s, reason: collision with root package name */
    private ArrayList<String> f11806s = new ArrayList<>();

    /* renamed from: t, reason: collision with root package name */
    private ArrayList<String> f11807t = new ArrayList<>();

    /* renamed from: u, reason: collision with root package name */
    private ArrayList<String> f11808u = new ArrayList<>();

    /* renamed from: v, reason: collision with root package name */
    private ArrayList<String> f11809v = new ArrayList<>();

    /* renamed from: w, reason: collision with root package name */
    private ArrayList<String> f11810w = new ArrayList<>();
    private String G = "";
    private int Y = 0;
    private boolean aa = true;
    private boolean ab = false;
    private long ac = System.currentTimeMillis();
    private boolean ad = true;

    void a(boolean z5) {
    }

    private void o() {
        this.F = new View.OnClickListener() { // from class: com.beizi.ad.internal.e.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (a.this.f11810w != null) {
                        Iterator it = a.this.f11810w.iterator();
                        while (it.hasNext()) {
                            String str = (String) it.next();
                            m.a("lance", "setClickListener:" + str);
                            new com.beizi.ad.internal.i(str).execute(new Void[0]);
                        }
                    }
                    Context context = view.getContext();
                    View rootView = view.getRootView();
                    if (rootView != null) {
                        context = rootView.getContext();
                    }
                    a.this.Y = 0;
                    a aVar = a.this;
                    aVar.a(aVar.f11795h, a.this.f11794g, context);
                    if (a.this.E != null) {
                        a.this.E.a();
                    }
                    a.this.f11810w = null;
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        };
    }

    private boolean p() {
        if (TextUtils.isEmpty(this.J) || TextUtils.isEmpty(this.O) || TextUtils.isEmpty(this.N) || TextUtils.isEmpty(this.R) || TextUtils.isEmpty(this.T)) {
            return false;
        }
        if (TextUtils.isEmpty(this.Q) && TextUtils.isEmpty(this.P)) {
            return false;
        }
        int i6 = this.I;
        return i6 == 2 || i6 == 5;
    }

    private boolean q() {
        int i6 = this.I;
        return i6 == 2 ? !TextUtils.isEmpty(this.M) && this.M.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a) : i6 == 5 && !TextUtils.isEmpty(this.M) && this.M.contains("market://");
    }

    @Override // com.beizi.ad.i
    public String c() {
        return this.f11790c;
    }

    @Override // com.beizi.ad.i
    public String d() {
        return this.f11793f;
    }

    @Override // com.beizi.ad.i
    public String e() {
        return this.f11797j;
    }

    @Override // com.beizi.ad.i
    public String f() {
        return this.f11800m;
    }

    @Override // com.beizi.ad.i
    public boolean g() {
        return this.f11803p;
    }

    @Override // com.beizi.ad.i
    public void h() {
        com.beizi.ad.lance.a.f fVar = this.B;
        if (fVar != null) {
            fVar.a();
        }
        this.f11803p = true;
        this.C = null;
        this.D = null;
        this.E = null;
    }

    @Override // com.beizi.ad.i
    public ArrayList<String> i() {
        return this.f11806s;
    }

    @Override // com.beizi.ad.i
    public ArrayList<String> j() {
        return this.f11808u;
    }

    @Override // com.beizi.ad.i
    public c.a k() {
        return this.f11811x;
    }

    @Override // com.beizi.ad.i
    public c.a l() {
        return this.f11812y;
    }

    @Override // com.beizi.ad.i
    public String m() {
        return this.f11794g;
    }

    @Override // com.beizi.ad.i
    public ApkBean n() {
        int i6 = this.I;
        if (i6 != 2 && i6 != 5) {
            return null;
        }
        ApkBean apkBean = new ApkBean();
        apkBean.setApkName(this.J);
        apkBean.setAppVersion(this.N);
        apkBean.setAppDeveloper(this.O);
        apkBean.setAppPermissionsDesc(this.P);
        apkBean.setAppPermissionsUrl(this.Q);
        apkBean.setAppPrivacyUrl(this.R);
        apkBean.setAppintro(this.T);
        return apkBean;
    }

    a() {
    }

    public void b(c.a aVar) {
        this.f11812y = aVar;
    }

    public void c(String str) {
        this.f11795h = str;
    }

    public void d(String str) {
        this.f11809v.add(str);
    }

    public void e(String str) {
        this.f11810w.add(str);
    }

    @Override // com.beizi.ad.i
    public String b() {
        return this.f11791d;
    }

    public void c(boolean z5) {
        this.A = z5;
    }

    public void d(boolean z5) {
        this.ad = z5;
    }

    public void b(String str) {
        this.f11794g = str;
    }

    void b(boolean z5) {
        this.ab = z5;
    }

    private boolean b(Context context) {
        c.b bVar = this.f11796i;
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
        String u5 = this.f11796i.u();
        String v5 = this.f11796i.v();
        String w5 = this.f11796i.w();
        if (!TextUtils.isEmpty(u5) && !TextUtils.isEmpty(v5)) {
            return r.a(context, u5, v5, w5);
        }
        String x5 = this.f11796i.x();
        if (!TextUtils.isEmpty(x5)) {
            return r.a(context, x5);
        }
        return false;
    }

    public void a(c.a aVar) {
        this.f11811x = aVar;
    }

    public void a(String str) {
        this.G = str;
    }

    public static a a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        ArrayList<String> a6 = k.a(k.a(jSONObject, "ImpressionTrackers"));
        a aVar = new a();
        if (a6 != null) {
            aVar.f11809v = a6;
        }
        aVar.f11789b = k.c(jSONObject, "Headline");
        aVar.f11790c = k.c(jSONObject, "Body");
        aVar.f11791d = k.c(jSONObject, "Image");
        JSONArray a7 = k.a(jSONObject, "Images");
        JSONArray a8 = k.a(jSONObject, "Videos");
        JSONArray a9 = k.a(jSONObject, "Texts");
        if (a7 != null) {
            for (int i6 = 0; i6 < a7.length(); i6++) {
                aVar.f11806s.add((String) a7.get(i6));
            }
        }
        if (a8 != null) {
            for (int i7 = 0; i7 < a8.length(); i7++) {
                aVar.f11807t.add((String) a8.get(i7));
            }
        }
        if (a9 != null) {
            for (int i8 = 0; i8 < a9.length(); i8++) {
                aVar.f11808u.add((String) a9.get(i8));
            }
        }
        if (jSONObject.has("AppIcon")) {
            aVar.f11788a = i.a.APP_INSTALL;
            aVar.f11793f = k.c(jSONObject, "AppIcon");
            aVar.f11797j = k.c(jSONObject, "Action");
            aVar.f11798k = k.e(jSONObject, "Star");
            aVar.f11799l = k.c(jSONObject, "Store");
            aVar.f11800m = k.c(jSONObject, "Price");
        } else {
            aVar.f11788a = i.a.CONTENT;
            aVar.f11793f = k.c(jSONObject, "Logo");
            aVar.f11797j = k.c(jSONObject, "Action");
            aVar.f11801n = k.c(jSONObject, "Advertiser");
        }
        ArrayList<String> a10 = k.a(k.a(jSONObject, "ClickTrackers"));
        if (a10 != null) {
            aVar.f11810w = a10;
        }
        aVar.f11802o = k.a(k.b(jSONObject, "Custom"));
        return aVar;
    }

    private boolean b(String str, Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    @Override // com.beizi.ad.i
    public boolean a(final View view, e eVar) {
        if (!this.f11803p && view != null) {
            this.B = new com.beizi.ad.lance.a.f(view, eVar, new g() { // from class: com.beizi.ad.internal.e.a.1
                @Override // com.beizi.ad.internal.e.g
                public void a() {
                    if (a.this.f11809v == null || a.this.f11809v.size() == 0) {
                        return;
                    }
                    Iterator it = a.this.f11809v.iterator();
                    while (it.hasNext()) {
                        new o(a.this.a((String) it.next(), view)).b();
                    }
                    a.this.f11809v = null;
                }
            });
            this.C = view;
        }
        return false;
    }

    public String a(String str, View view) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f11813z)) {
            str = str.replace(com.beizi.ad.model.g.f13081a, this.f11813z);
        }
        String str2 = str;
        if (view != null) {
            if (!TextUtils.isEmpty(this.G)) {
                str2 = str2.replace("__REQUESTUUID__", this.G);
            }
            if (this.A) {
                str2 = str2.replace(com.beizi.ad.model.g.f13082b, "1");
            }
            return com.beizi.ad.internal.h.o.a(0, view, str2);
        }
        return q.a(str2, "", "", "", "", "", "", "");
    }

    @Override // com.beizi.ad.i
    public void a(Context context, View view, String str, String str2, String str3, String str4, int i6) {
        int i7 = i6;
        this.Y = i7;
        ArrayList<String> arrayList = this.f11810w;
        if (arrayList != null) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String a6 = q.a(it.next(), str + "", str2 + "", str3 + "", str4 + "", String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis()), "", i7);
                if (!TextUtils.isEmpty(this.G)) {
                    a6 = a6.replace("__REQUESTUUID__", this.G);
                }
                if (this.A) {
                    a6 = a6.replace(com.beizi.ad.model.g.f13082b, "1");
                }
                new com.beizi.ad.internal.i(com.beizi.ad.internal.h.o.a(view, a6)).execute(new Void[0]);
                i7 = i6;
            }
        }
        this.f11810w = null;
        a(this.f11795h, this.f11794g, context);
        b bVar = this.E;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.beizi.ad.i
    public String a() {
        return this.f11789b;
    }

    @Override // com.beizi.ad.i
    public boolean a(final View view, b bVar) {
        if (this.f11803p || view == null) {
            return false;
        }
        this.E = bVar;
        this.C = view;
        final GestureDetector gestureDetector = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.beizi.ad.internal.e.a.2
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                a.this.H = System.currentTimeMillis();
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (a.this.f11810w != null) {
                    float x5 = motionEvent.getX();
                    float y5 = motionEvent.getY();
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    Iterator it = a.this.f11810w.iterator();
                    while (it.hasNext()) {
                        String a6 = q.a((String) it.next(), x5 + "", y5 + "", rawX + "", rawY + "", String.valueOf(a.this.H), String.valueOf(System.currentTimeMillis()), "", 0);
                        if (!TextUtils.isEmpty(a.this.G)) {
                            a6 = a6.replace("__REQUESTUUID__", a.this.G);
                        }
                        if (a.this.A) {
                            a6 = a6.replace(com.beizi.ad.model.g.f13082b, "1");
                        }
                        new com.beizi.ad.internal.i(com.beizi.ad.internal.h.o.a(view, a6)).execute(new Void[0]);
                    }
                }
                a.this.f11810w = null;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }
        });
        o();
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.internal.e.a.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return gestureDetector.onTouchEvent(motionEvent);
            }
        });
        view.setOnClickListener(this.F);
        return true;
    }

    @Override // com.beizi.ad.i
    public boolean a(final View view, List<View> list, b bVar) {
        if (!a(view, bVar)) {
            return false;
        }
        if (list == null || list.size() <= 0) {
            return true;
        }
        view.setOnClickListener(null);
        for (View view2 : list) {
            final GestureDetector gestureDetector = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.beizi.ad.internal.e.a.4
                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onDown(MotionEvent motionEvent) {
                    a.this.H = System.currentTimeMillis();
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    if (a.this.f11810w != null) {
                        float x5 = motionEvent.getX();
                        float y5 = motionEvent.getY();
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        Iterator it = a.this.f11810w.iterator();
                        while (it.hasNext()) {
                            String a6 = q.a((String) it.next(), x5 + "", y5 + "", rawX + "", rawY + "", String.valueOf(a.this.H), String.valueOf(System.currentTimeMillis()), "", 0);
                            if (!TextUtils.isEmpty(a.this.G)) {
                                a6 = a6.replace("__REQUESTUUID__", a.this.G);
                            }
                            if (a.this.A) {
                                a6 = a6.replace(com.beizi.ad.model.g.f13082b, "1");
                            }
                            new com.beizi.ad.internal.i(com.beizi.ad.internal.h.o.a(view, a6)).execute(new Void[0]);
                        }
                    }
                    a.this.f11810w = null;
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent motionEvent) {
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onShowPress(MotionEvent motionEvent) {
                }
            });
            view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.internal.e.a.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view3, MotionEvent motionEvent) {
                    return gestureDetector.onTouchEvent(motionEvent);
                }
            });
            view2.setOnClickListener(this.F);
        }
        this.D = list;
        return true;
    }

    public void a(c.b bVar) {
        this.f11796i = bVar;
        this.U = bVar.j();
        this.I = bVar.c();
        this.J = bVar.d();
        this.K = bVar.e();
        this.L = bVar.f();
        this.M = bVar.g();
        if (TextUtils.isEmpty(this.K)) {
            this.K = "lance";
        }
        if (TextUtils.isEmpty(this.J)) {
            this.J = "BeiZi";
        }
        if (TextUtils.isEmpty(this.L)) {
            this.L = "Ad Download";
        }
        this.N = bVar.m();
        this.O = bVar.n();
        this.P = bVar.o();
        this.Q = bVar.p();
        this.R = bVar.q();
        this.S = bVar.r();
        this.T = bVar.s();
        c.b.a t5 = bVar.t();
        this.V = t5;
        if (t5 != null) {
            if (t5.a() == 1) {
                this.W = true;
            }
            if (this.V.b() == 1) {
                this.X = true;
            }
            this.Z = this.V.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, String str2, Context context) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (!com.beizi.ad.lance.a.k.a(context, str) && !h.a(context, this.K) && !str.startsWith("hwpps://landingpage") && !str.startsWith("intent") && !str.startsWith("hap://")) {
                    c.b.C0123b c0123b = this.U;
                    if (c0123b != null) {
                        l.a(c0123b.i());
                    }
                    a(context, str2);
                    return true;
                }
                c.b.C0123b c0123b2 = this.U;
                if (c0123b2 != null) {
                    l.a(c0123b2.h());
                }
                a(context);
                c.b.C0123b c0123b3 = this.U;
                if (c0123b3 != null) {
                    l.a(c0123b3.e());
                }
                return true;
            } catch (Exception unused) {
                c.b.C0123b c0123b4 = this.U;
                if (c0123b4 != null) {
                    l.a(c0123b4.g());
                }
                a(context, str2);
                return true;
            }
        }
        a(context, str2);
        return true;
    }

    private void a(Context context, String str) {
        try {
            if (p() && q()) {
                int i6 = this.I;
                if (i6 == 2) {
                    if (h.a(context, this.K)) {
                        h.b(context, this.K);
                        c.b.C0123b c0123b = this.U;
                        if (c0123b != null) {
                            l.a(c0123b.a());
                            return;
                        }
                        return;
                    }
                    a(context, 1);
                    return;
                }
                if (i6 == 5) {
                    if (com.beizi.ad.lance.a.k.a(context, this.M)) {
                        if (!this.X && this.Y != 0) {
                            a(context, 2);
                            return;
                        }
                        b(this.M, context);
                        c.b.C0123b c0123b2 = this.U;
                        if (c0123b2 != null) {
                            l.a(c0123b2.a());
                            return;
                        }
                        return;
                    }
                    a(str, context);
                    return;
                }
                return;
            }
            a(str, context);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void a(Context context, int i6) {
        try {
            File a6 = h.a(context);
            String str = "";
            if (a6 != null) {
                str = a6.getAbsolutePath();
            }
            String str2 = str;
            ApkBean apkBean = new ApkBean(this.M, this.K + ".apk", this.K, str2, this.J, this.L, context.getPackageName() + ".fileprovider", this.U, this.N, this.O, this.P, this.Q, this.R, this.S, this.T);
            Bundle bundle = new Bundle();
            bundle.putSerializable("apkBean", apkBean);
            bundle.putInt("type", i6);
            bundle.putBoolean("isCanJump", this.W);
            bundle.putBoolean("isDownload", p());
            if (i6 == 2) {
                c.b.C0123b c0123b = this.U;
                if (c0123b != null) {
                    bundle.putStringArrayList("openList", (ArrayList) c0123b.a());
                }
                bundle.putString("landingPageUrl", this.f11794g);
            }
            if (!TextUtils.isEmpty(this.f11795h)) {
                bundle.putString("deeplinkUrl", this.f11795h);
                bundle.putInt("webDeepLink", this.Z);
            }
            Intent intent = new Intent(context, (Class<?>) BeiZiDownloadDialogActivity.class);
            intent.putExtra("data", bundle);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void a(final Context context) {
        this.ac = System.currentTimeMillis();
        com.beizi.ad.internal.h.a().a(new com.beizi.ad.internal.b() { // from class: com.beizi.ad.internal.e.a.7
            @Override // com.beizi.ad.internal.b
            public void a() {
                try {
                    if (a.this.U != null) {
                        l.a(a.this.U.f());
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }

            @Override // com.beizi.ad.internal.b
            public void b() {
                try {
                    if (a.this.ad && System.currentTimeMillis() - a.this.ac <= 2000) {
                        if (a.this.U != null) {
                            l.a(a.this.U.j());
                        }
                        a aVar = a.this;
                        aVar.a(aVar.f11794g, context);
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        });
        Uri parse = Uri.parse(this.f11795h);
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
            if (context != null) {
                context.startActivity(intent);
                return;
            }
            return;
        }
        if (this.f11795h.startsWith("hwpps://landingpage")) {
            Intent intent2 = new Intent();
            intent2.setData(parse);
            intent2.addFlags(268435456);
            if (context != null) {
                context.startActivity(intent2);
                return;
            }
            return;
        }
        if (this.f11795h.startsWith("intent")) {
            Intent intent3 = null;
            try {
                intent3 = Intent.parseUri(this.f11795h, 1);
                intent3.addFlags(268435456);
            } catch (Exception e8) {
                e8.printStackTrace();
            }
            if (context != null) {
                context.startActivity(intent3);
                return;
            }
            return;
        }
        Intent intent4 = new Intent("android.intent.action.VIEW", parse);
        intent4.addFlags(805339136);
        if (context != null) {
            context.startActivity(intent4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, Context context) {
        if (str != null && !str.isEmpty()) {
            if (b(context)) {
                return true;
            }
            if (!this.aa) {
                if (!b(str, context)) {
                    return false;
                }
                b bVar = this.E;
                if (bVar != null) {
                    bVar.b();
                }
                return true;
            }
            Class a6 = AdActivity.a();
            try {
                WebView webView = new WebView(new MutableContextWrapper(context));
                x.a(webView);
                webView.loadUrl(str, j.a());
                com.beizi.ad.internal.activity.a.f11616a.add(webView);
                Intent intent = new Intent(context, (Class<?>) a6);
                intent.setFlags(268435456);
                intent.putExtra("ACTIVITY_TYPE", "DOWNLOADBROWSER");
                intent.putExtra("ACTIVITY_CAN_JUMP", this.W);
                intent.putExtra("ACTIVITY_CAN_DOWNLOAD", p());
                if (!TextUtils.isEmpty(this.f11795h)) {
                    intent.putExtra("deeplinkUrl", this.f11795h);
                    intent.putExtra("webDeepLink", this.Z);
                }
                context.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException unused) {
                com.beizi.ad.internal.activity.a.f11616a.remove();
            } catch (Exception unused2) {
                return false;
            }
        }
        return false;
    }

    @Override // com.beizi.ad.i
    public void a(View view, String str, String str2, String str3, String str4, int i6, b bVar) {
        int i7 = i6;
        try {
            this.Y = i7;
            ArrayList<String> arrayList = this.f11810w;
            if (arrayList != null) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String a6 = q.a(it.next(), str + "", str2 + "", str3 + "", str4 + "", String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis()), "", i7);
                    if (!TextUtils.isEmpty(this.G)) {
                        a6 = a6.replace("__REQUESTUUID__", this.G);
                    }
                    if (this.A) {
                        a6 = a6.replace(com.beizi.ad.model.g.f13082b, "1");
                    }
                    new com.beizi.ad.internal.i(com.beizi.ad.internal.h.o.a(view, a6)).execute(new Void[0]);
                    i7 = i6;
                }
            }
            this.f11810w = null;
            Context context = view.getContext();
            View rootView = view.getRootView();
            if (rootView != null) {
                context = rootView.getContext();
            }
            a(this.f11795h, this.f11794g, context);
            if (bVar != null) {
                bVar.a();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
