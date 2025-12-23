package com.beizi.ad.internal.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.beizi.ad.AdActivity;
import com.beizi.ad.internal.h.o;
import com.beizi.ad.internal.h.u;
import com.beizi.ad.internal.h.v;
import com.beizi.ad.internal.k;
import com.beizi.ad.internal.view.AdWebView;
import com.beizi.fusion.R;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import javax.mail.Part;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"InlinedApi"})
/* loaded from: D:\Downloads\app\classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    protected static final String[] f12667a = {"default", "expanded"};

    /* renamed from: b, reason: collision with root package name */
    protected final AdWebView f12668b;

    /* renamed from: e, reason: collision with root package name */
    int f12671e;

    /* renamed from: f, reason: collision with root package name */
    int f12672f;

    /* renamed from: g, reason: collision with root package name */
    int f12673g;

    /* renamed from: j, reason: collision with root package name */
    boolean f12676j;

    /* renamed from: l, reason: collision with root package name */
    private int f12678l;

    /* renamed from: m, reason: collision with root package name */
    private int f12679m;

    /* renamed from: n, reason: collision with root package name */
    private Activity f12680n;

    /* renamed from: o, reason: collision with root package name */
    private ViewGroup f12681o;

    /* renamed from: q, reason: collision with root package name */
    private int f12683q;

    /* renamed from: k, reason: collision with root package name */
    private boolean f12677k = false;

    /* renamed from: c, reason: collision with root package name */
    boolean f12669c = false;

    /* renamed from: d, reason: collision with root package name */
    boolean f12670d = false;

    /* renamed from: h, reason: collision with root package name */
    boolean f12674h = false;

    /* renamed from: i, reason: collision with root package name */
    boolean f12675i = false;

    /* renamed from: p, reason: collision with root package name */
    private int[] f12682p = new int[4];

    /* renamed from: r, reason: collision with root package name */
    private boolean f12684r = false;

    /* renamed from: s, reason: collision with root package name */
    private g f12685s = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum a {
        top_left,
        top_right,
        center,
        bottom_left,
        bottom_right,
        top_center,
        bottom_center
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected enum b {
        STARTING_DEFAULT,
        STARTING_EXPANDED
    }

    private void c(ArrayList<Pair<String, String>> arrayList) {
        Iterator<Pair<String, String>> it = arrayList.iterator();
        String str = null;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (((String) next.first).equals(ContentProviderManager.PROVIDER_URI)) {
                str = Uri.decode((String) next.second);
            }
        }
        if (o.a(str)) {
            return;
        }
        this.f12668b.b(str);
        this.f12668b.c();
    }

    private void d(ArrayList<Pair<String, String>> arrayList) {
        Iterator<Pair<String, String>> it = arrayList.iterator();
        String str = null;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (((String) next.first).equals(ContentProviderManager.PROVIDER_URI)) {
                str = (String) next.second;
            }
        }
        if (str == null) {
            return;
        }
        final String decode = Uri.decode(str);
        AlertDialog.Builder builder = new AlertDialog.Builder(u.b(this.f12668b));
        builder.setTitle(R.string.beizi_store_picture_title);
        builder.setMessage(R.string.beizi_store_picture_message);
        builder.setPositiveButton(R.string.beizi_store_picture_accept, new DialogInterface.OnClickListener() { // from class: com.beizi.ad.internal.view.f.2
            /* JADX WARN: Code restructure failed: missing block: B:24:0x00ee, code lost:
            
                if (r6 == null) goto L57;
             */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x00ea, code lost:
            
                r6.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x00e8, code lost:
            
                if (r6 == null) goto L57;
             */
            /* JADX WARN: Code restructure failed: missing block: B:29:0x00e5, code lost:
            
                if (r6 == null) goto L57;
             */
            @Override // android.content.DialogInterface.OnClickListener
            @android.annotation.SuppressLint({"NewApi"})
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onClick(android.content.DialogInterface r6, int r7) {
                /*
                    Method dump skipped, instructions count: 253
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.internal.view.f.AnonymousClass2.onClick(android.content.DialogInterface, int):void");
            }
        });
        builder.setNegativeButton(R.string.beizi_store_picture_decline, new DialogInterface.OnClickListener() { // from class: com.beizi.ad.internal.view.f.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i6) {
            }
        });
        builder.create().show();
    }

    private void e() {
        if (this.f12668b.getContextFromMutableContext() instanceof Activity) {
            Activity activity = (Activity) this.f12668b.getContextFromMutableContext();
            int[] iArr = new int[2];
            this.f12668b.getLocationOnScreen(iArr);
            iArr[1] = iArr[1] - activity.getWindow().findViewById(android.R.id.content).getTop();
            this.f12668b.measure(0, 0);
            int[] iArr2 = {this.f12668b.getMeasuredWidth(), this.f12668b.getMeasuredHeight()};
            u.a(activity, iArr2);
            this.f12668b.c(String.format("javascript:window.mraid.util.setDefaultPosition(%d, %d, %d, %d)", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1])));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:7:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void f(java.util.ArrayList<android.util.Pair<java.lang.String, java.lang.String>> r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L1e
            int r0 = r2.size()     // Catch: java.lang.Throwable -> L38
            if (r0 <= 0) goto L1e
            r0 = 0
            java.lang.Object r2 = r2.get(r0)     // Catch: java.lang.Throwable -> L38
            android.util.Pair r2 = (android.util.Pair) r2     // Catch: java.lang.Throwable -> L38
            java.lang.Object r2 = r2.second     // Catch: java.lang.Throwable -> L38
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L38
            java.lang.String r0 = "UTF-8"
            java.lang.String r2 = java.net.URLDecoder.decode(r2, r0)     // Catch: java.lang.Throwable -> L38
            com.beizi.ad.internal.h.v r2 = com.beizi.ad.internal.h.v.j(r2)     // Catch: java.lang.Throwable -> L38
            goto L1f
        L1e:
            r2 = 0
        L1f:
            if (r2 == 0) goto L38
            android.content.Intent r2 = r2.j()
            r0 = 268435456(0x10000000, float:2.524355E-29)
            r2.setFlags(r0)
            com.beizi.ad.internal.view.AdWebView r0 = r1.f12668b
            android.content.Context r0 = r0.getContext()
            r0.startActivity(r2)
            com.beizi.ad.internal.view.AdWebView r2 = r1.f12668b
            r2.c()
        L38:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.internal.view.f.f(java.util.ArrayList):void");
    }

    private void g(ArrayList<Pair<String, String>> arrayList) {
        AdActivity.b bVar = AdActivity.b.none;
        Iterator<Pair<String, String>> it = arrayList.iterator();
        int i6 = 1;
        boolean z5 = true;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (((String) next.first).equals("allow_orientation_change")) {
                z5 = Boolean.parseBoolean((String) next.second);
            } else if (((String) next.first).equals("force_orientation")) {
                bVar = a((String) next.second);
            }
        }
        try {
            if (!this.f12669c && !this.f12668b.adViewImpl.e()) {
                return;
            }
            AdWebView adWebView = this.f12668b;
            Activity c6 = adWebView.f12531a ? c() : (Activity) u.b(adWebView);
            if (z5) {
                AdActivity.b(c6);
                return;
            }
            int i7 = AnonymousClass4.f12692a[bVar.ordinal()];
            if (i7 == 1) {
                i6 = 2;
            } else if (i7 != 2) {
                i6 = 0;
            }
            AdActivity.a(c6, i6);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    void b(ArrayList<Pair<String, String>> arrayList) {
        f fVar;
        AdActivity.b bVar = AdActivity.b.none;
        Iterator<Pair<String, String>> it = arrayList.iterator();
        String str = null;
        final AdActivity.b bVar2 = bVar;
        int i6 = -1;
        int i7 = -1;
        boolean z5 = false;
        final boolean z6 = true;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (((String) next.first).equals(IAdInterListener.AdReqParam.WIDTH)) {
                try {
                    i6 = Integer.parseInt((String) next.second);
                } catch (NumberFormatException unused) {
                }
            } else if (((String) next.first).equals("h")) {
                i7 = Integer.parseInt((String) next.second);
            } else if (((String) next.first).equals("useCustomClose")) {
                z5 = Boolean.parseBoolean((String) next.second);
            } else if (((String) next.first).equals("url")) {
                str = Uri.decode((String) next.second);
            } else if (((String) next.first).equals("allow_orientation_change")) {
                z6 = Boolean.parseBoolean((String) next.second);
            } else if (((String) next.first).equals("force_orientation")) {
                bVar2 = a((String) next.second);
            }
        }
        if (o.a(str)) {
            fVar = this;
            this.f12668b.a(i6, i7, z5, fVar, z6, bVar2);
        } else {
            try {
                g gVar = new g(this.f12668b.adViewImpl, this);
                this.f12685s = gVar;
                gVar.a(str);
                this.f12668b.adViewImpl.a(this.f12685s.getMRAIDImplementation(), z5, new AdWebView.b() { // from class: com.beizi.ad.internal.view.f.1
                    @Override // com.beizi.ad.internal.view.AdWebView.b
                    public void a() {
                        if (f.this.c() != null) {
                            f.this.f12685s.a(f.this.c(), z6, bVar2);
                            AdViewImpl.setMRAIDFullscreenListener(null);
                        }
                    }
                });
            } catch (Exception unused2) {
            }
            fVar = this;
        }
        fVar.f12668b.c("javascript:window.mraid.util.stateChangeEvent('expanded');");
        fVar.f12669c = true;
        if (fVar.f12668b.adViewImpl.e()) {
            return;
        }
        fVar.f12668b.adViewImpl.getAdDispatcher().c();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.view.f$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12692a;

        static {
            int[] iArr = new int[AdActivity.b.values().length];
            f12692a = iArr;
            try {
                iArr[AdActivity.b.landscape.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12692a[AdActivity.b.portrait.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12692a[AdActivity.b.none.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    void a(AdWebView adWebView, String str) {
        if (this.f12677k) {
            return;
        }
        String str2 = this.f12668b.adViewImpl.d() ? Part.INLINE : MediationConstant.RIT_TYPE_INTERSTITIAL;
        boolean equals = str.equals(f12667a[b.STARTING_EXPANDED.ordinal()]);
        this.f12684r = equals;
        this.f12668b.f12531a = equals;
        adWebView.c("javascript:window.mraid.util.setPlacementType('" + str2 + "')");
        if (!this.f12684r) {
            a(adWebView);
            g();
            f();
            e();
        }
        this.f12668b.f();
        adWebView.c("javascript:window.mraid.util.stateChangeEvent('" + str + "')");
        adWebView.c("javascript:window.mraid.util.readyEvent();");
        this.f12671e = this.f12668b.getLayoutParams().width;
        this.f12672f = this.f12668b.getLayoutParams().height;
        if (this.f12668b.adViewImpl.getMediaType().equals(k.BANNER)) {
            this.f12673g = ((FrameLayout.LayoutParams) this.f12668b.getLayoutParams()).gravity;
        }
        this.f12677k = true;
        a(this.f12668b.g());
    }

    public f(AdWebView adWebView) {
        this.f12668b = adWebView;
    }

    private void h(ArrayList<Pair<String, String>> arrayList) {
        Iterator<Pair<String, String>> it = arrayList.iterator();
        String str = "top-right";
        int i6 = -1;
        int i7 = -1;
        int i8 = 0;
        int i9 = 0;
        boolean z5 = true;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            try {
                if (((String) next.first).equals(IAdInterListener.AdReqParam.WIDTH)) {
                    i6 = Integer.parseInt((String) next.second);
                } else if (((String) next.first).equals("h")) {
                    i7 = Integer.parseInt((String) next.second);
                } else if (((String) next.first).equals("offset_x")) {
                    i8 = Integer.parseInt((String) next.second);
                } else if (((String) next.first).equals("offset_y")) {
                    i9 = Integer.parseInt((String) next.second);
                } else if (((String) next.first).equals("custom_close_position")) {
                    str = (String) next.second;
                } else if (((String) next.first).equals("allow_offscreen")) {
                    z5 = Boolean.parseBoolean((String) next.second);
                }
            } catch (NumberFormatException unused) {
                return;
            }
        }
        if (i6 > this.f12678l && i7 > this.f12679m) {
            this.f12668b.c("javascript:mraid.util.errorEvent('Resize called with resizeProperties larger than the screen.', 'mraid.resize()')");
            return;
        }
        a aVar = a.top_right;
        try {
            aVar = a.valueOf(str.replace('-', '_'));
        } catch (IllegalArgumentException unused2) {
        }
        this.f12668b.resize(i6, i7, i8, i9, aVar, z5);
        this.f12668b.c();
        this.f12668b.c("javascript:window.mraid.util.stateChangeEvent('resized');");
        this.f12670d = true;
    }

    private void f() {
        if (this.f12668b.getContextFromMutableContext() instanceof Activity) {
            Activity activity = (Activity) this.f12668b.getContextFromMutableContext();
            int[] a6 = u.a(activity);
            int i6 = a6[0];
            int top2 = a6[1] - activity.getWindow().findViewById(android.R.id.content).getTop();
            float f6 = activity.getResources().getDisplayMetrics().density;
            int i7 = (int) ((top2 / f6) + 0.5f);
            int i8 = (int) ((i6 / f6) + 0.5f);
            this.f12668b.c("javascript:window.mraid.util.setMaxSize(" + i8 + ", " + i7 + ")");
        }
    }

    Activity c() {
        return this.f12680n;
    }

    ViewGroup d() {
        return this.f12681o;
    }

    private void g() {
        if (this.f12668b.getContextFromMutableContext() instanceof Activity) {
            int[] b6 = u.b((Activity) this.f12668b.getContextFromMutableContext());
            this.f12678l = b6[0];
            this.f12679m = b6[1];
            this.f12668b.c("javascript:window.mraid.util.setScreenSize(" + this.f12678l + ", " + this.f12679m + ")");
        }
    }

    private void e(ArrayList<Pair<String, String>> arrayList) {
        Iterator<Pair<String, String>> it = arrayList.iterator();
        String str = null;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (((String) next.first).equals(ContentProviderManager.PROVIDER_URI)) {
                str = (String) next.second;
            }
        }
        if (str == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        try {
            intent.setDataAndType(Uri.parse(URLDecoder.decode(str, "UTF-8")), "video/mp4");
            this.f12668b.getContext().startActivity(intent);
            this.f12668b.c();
        } catch (UnsupportedEncodingException | Exception unused) {
        }
    }

    private void a(AdWebView adWebView, String str, boolean z5) {
        adWebView.c(String.format("javascript:window.mraid.util.setSupports('%s', %s)", str, String.valueOf(z5)));
    }

    @SuppressLint({"NewApi"})
    private void a(AdWebView adWebView) {
        if (a(new Intent("android.intent.action.VIEW", Uri.parse("sms:5555555555")))) {
            a(adWebView, "sms", true);
        }
        if (a(new Intent("android.intent.action.VIEW", Uri.parse("tel:5555555555")))) {
            a(adWebView, "tel", true);
        }
        try {
            if (a(new Intent("android.intent.action.EDIT").setData(Uri.parse(com.beizi.ad.lance.a.b.b("Y29udGVudDovL2NvbS5hbmRyb2lkLmNhbGVuZGFyL2V2ZW50cw=="))))) {
                a(adWebView, "calendar", true);
                this.f12675i = true;
            } else if (a(new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event"))) {
                a(adWebView, "calendar", true);
                this.f12675i = true;
                v.f12176a = true;
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        a(adWebView, "inlineVideo", true);
    }

    void b() {
        boolean g6 = this.f12668b.g();
        if (this.f12676j != g6) {
            a(g6);
        }
    }

    boolean a(Intent intent) {
        return this.f12668b.getContext().getPackageManager().queryIntentActivities(intent, 0).size() > 0;
    }

    void a(boolean z5) {
        if (this.f12677k) {
            this.f12676j = z5;
            this.f12668b.c("javascript:window.mraid.util.setIsViewable(" + z5 + ")");
        }
    }

    void a(int i6, int i7, int i8, int i9) {
        if (this.f12668b.getContextFromMutableContext() instanceof Activity) {
            int[] iArr = this.f12682p;
            if (iArr[0] == i6 && iArr[1] == i7 && iArr[2] == i8 && iArr[3] == i9) {
                return;
            }
            iArr[0] = i6;
            iArr[1] = i7;
            iArr[2] = i8;
            iArr[3] = i9;
            Activity activity = (Activity) this.f12668b.getContextFromMutableContext();
            int[] iArr2 = {i6, i7 - activity.getWindow().findViewById(android.R.id.content).getTop(), i8, i9};
            u.a(activity, iArr2);
            int i10 = iArr2[0];
            int i11 = iArr2[1];
            int i12 = iArr2[2];
            int i13 = iArr2[3];
            this.f12668b.c(String.format("javascript:window.mraid.util.setCurrentPosition(%d, %d, %d, %d)", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)));
            this.f12668b.c(String.format("javascript:window.mraid.util.sizeChangeEvent(%d, %d)", Integer.valueOf(i12), Integer.valueOf(i13)));
        }
    }

    public void a() {
        Activity activity;
        Activity activity2;
        if (!this.f12669c && !this.f12670d && !this.f12684r) {
            if (this.f12668b.adViewImpl.e()) {
                this.f12668b.adViewImpl.getAdDispatcher().b();
                if (!(this.f12668b.getContextFromMutableContext() instanceof Activity) || (activity2 = (Activity) this.f12668b.getContextFromMutableContext()) == null || activity2.isFinishing()) {
                    return;
                }
                activity2.finish();
                return;
            }
            this.f12668b.d();
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f12668b.getLayoutParams());
        layoutParams.height = this.f12672f;
        layoutParams.width = this.f12671e;
        if (this.f12668b.adViewImpl.getMediaType().equals(k.BANNER)) {
            layoutParams.gravity = this.f12673g;
        } else {
            layoutParams.gravity = 17;
        }
        this.f12668b.setLayoutParams(layoutParams);
        this.f12668b.e();
        this.f12668b.c("javascript:window.mraid.util.stateChangeEvent('default');");
        if (!this.f12668b.adViewImpl.e() && !this.f12684r) {
            this.f12668b.adViewImpl.getAdDispatcher().b();
        }
        if ((this.f12668b.getContextFromMutableContext() instanceof Activity) && (activity = (Activity) this.f12668b.getContextFromMutableContext()) != null) {
            activity.setRequestedOrientation(-1);
        }
        this.f12669c = false;
        this.f12670d = false;
        this.f12685s = null;
    }

    void a(ArrayList<Pair<String, String>> arrayList) {
        this.f12668b.setMRAIDUseCustomClose(Boolean.parseBoolean((String) arrayList.get(0).second));
    }

    void a(String str, boolean z5) {
        String replaceFirst = str.replaceFirst("mraid://", "");
        String[] split = replaceFirst.split("\\?");
        String replaceAll = split[0].replaceAll("/", "");
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        if (split.length > 1) {
            for (String str2 : replaceFirst.substring(replaceFirst.indexOf("?") + 1).split(ContainerUtils.FIELD_DELIMITER)) {
                String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2.length >= 2 && !o.a(split2[1]) && !"undefined".equals(split2[1])) {
                    arrayList.add(new Pair<>(split2[0], split2[1]));
                }
            }
        }
        if (replaceAll.equals("expand")) {
            if (z5) {
                b(arrayList);
                return;
            }
            return;
        }
        if (replaceAll.equals("close")) {
            a();
            return;
        }
        if (replaceAll.equals("resize")) {
            if (z5) {
                h(arrayList);
                return;
            }
            return;
        }
        if (replaceAll.equals("setOrientationProperties")) {
            g(arrayList);
            return;
        }
        if (this.f12675i && replaceAll.equals("createCalendarEvent")) {
            if (z5) {
                f(arrayList);
                return;
            }
            return;
        }
        if (replaceAll.equals("playVideo")) {
            if (z5) {
                e(arrayList);
                return;
            }
            return;
        }
        if (this.f12674h && replaceAll.equals("storePicture")) {
            if (z5) {
                d(arrayList);
            }
        } else if (replaceAll.equals("open")) {
            if (z5) {
                c(arrayList);
            }
        } else if (replaceAll.equals("setUseCustomClose")) {
            a(arrayList);
        } else {
            replaceAll.equals("enable");
        }
    }

    private AdActivity.b a(String str) {
        AdActivity.b bVar = AdActivity.b.none;
        if (str.equals("landscape")) {
            return AdActivity.b.landscape;
        }
        return str.equals("portrait") ? AdActivity.b.portrait : bVar;
    }

    void a(int i6) {
        if (this.f12683q != i6) {
            this.f12683q = i6;
            f();
            g();
        }
    }

    public void a(Activity activity) {
        this.f12680n = activity;
    }

    void a(ViewGroup viewGroup) {
        this.f12681o = viewGroup;
    }
}
