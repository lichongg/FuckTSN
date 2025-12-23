package com.beizi.fusion.work.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.beizi.fusion.R;
import com.beizi.fusion.c.c;
import com.beizi.fusion.c.d;
import com.beizi.fusion.c.e;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.CoordinateBean;
import com.beizi.fusion.tool.aa;
import com.beizi.fusion.tool.aj;
import com.beizi.fusion.tool.al;
import com.beizi.fusion.tool.ap;
import com.beizi.fusion.tool.f;
import com.beizi.fusion.tool.o;
import com.beizi.fusion.widget.ScrollClickView;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends com.beizi.fusion.work.a implements c {
    protected ImageView A;
    protected ImageView B;
    protected TextView C;
    protected TextView D;
    protected TextView E;
    protected TextView F;
    protected TextView G;
    protected long H;
    protected float I;
    protected float J;
    protected boolean K = false;
    protected boolean L = false;
    protected boolean M = false;
    protected Context N;
    protected Activity O;
    protected al P;
    protected aj Q;
    protected CountDownTimer R;
    protected AdSpacesBean.RenderViewBean S;
    protected AdSpacesBean.BuyerBean.RenderAds T;
    protected List<AdSpacesBean.RenderViewBean> U;
    protected List<Pair<String, Integer>> V;

    /* renamed from: n, reason: collision with root package name */
    protected View f14230n;

    /* renamed from: o, reason: collision with root package name */
    protected View f14231o;

    /* renamed from: p, reason: collision with root package name */
    protected View f14232p;

    /* renamed from: q, reason: collision with root package name */
    protected ViewGroup f14233q;

    /* renamed from: r, reason: collision with root package name */
    protected ViewGroup f14234r;

    /* renamed from: s, reason: collision with root package name */
    protected ViewGroup f14235s;

    /* renamed from: t, reason: collision with root package name */
    protected ViewGroup f14236t;

    /* renamed from: u, reason: collision with root package name */
    protected ViewGroup f14237u;

    /* renamed from: v, reason: collision with root package name */
    protected ViewGroup f14238v;

    /* renamed from: w, reason: collision with root package name */
    protected ViewGroup f14239w;

    /* renamed from: x, reason: collision with root package name */
    protected ViewGroup f14240x;

    /* renamed from: y, reason: collision with root package name */
    protected ImageView f14241y;

    /* renamed from: z, reason: collision with root package name */
    protected ImageView f14242z;

    private void c(int i6, int i7) {
        a(this.f14236t, this.T.getImageCoordinate(), i6, i7);
        aJ();
    }

    private void f(int i6, int i7) {
        a(this.A, this.T.getIconCoordinate(), i6, i7);
        if (this.A.getVisibility() != 0 || TextUtils.isEmpty(aM())) {
            return;
        }
        f.a(this.N).a(aM(), new f.a() { // from class: com.beizi.fusion.work.e.a.2
            @Override // com.beizi.fusion.tool.f.a
            public void a() {
            }

            @Override // com.beizi.fusion.tool.f.a
            public void a(Bitmap bitmap) {
                a.this.A.setImageBitmap(bitmap);
            }
        });
    }

    public void a(List<View> list) {
    }

    public int ay() {
        return -1;
    }

    public void b(boolean z5) {
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        if (this.f14055d == null || ay() == -1) {
            return;
        }
        this.f14059h = this.f14056e.getAppId();
        this.f14060i = this.f14056e.getSpaceId();
        this.f14054c = this.f14056e.getBuyerSpaceUuId();
        List<AdSpacesBean.RenderViewBean> renderView = this.f14056e.getRenderView();
        this.U = renderView;
        if (renderView != null && renderView.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean = this.U.get(0);
            this.S = renderViewBean;
            this.V = o.a(renderViewBean.getDpLinkUrlList());
        }
        com.beizi.fusion.events.b bVar = this.f14052a;
        if (bVar != null) {
            EventBean a6 = bVar.a().a(this.f14054c);
            this.f14053b = a6;
            if (a6 != null) {
                s();
                aA();
            }
        }
    }

    @Override // com.beizi.fusion.work.a
    public void e() {
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.e.a h() {
        return this.f14061j;
    }

    private void aR() {
        List<String> clickView = this.T.getClickView();
        ArrayList arrayList = new ArrayList();
        if (clickView != null && clickView.size() > 0) {
            if (clickView.contains("bg")) {
                arrayList.add(this.f14233q);
                arrayList.add(this.f14235s);
                arrayList.add(this.f14239w);
            } else if (clickView.contains(bi.az)) {
                arrayList.add(this.f14235s);
            } else {
                if (clickView.contains(SocializeProtocolConstants.IMAGE)) {
                    arrayList.add(this.f14236t);
                }
                if (clickView.contains("title")) {
                    arrayList.add(this.D);
                }
                if (clickView.contains("desc")) {
                    arrayList.add(this.E);
                }
                if (clickView.contains("icon")) {
                    arrayList.add(this.A);
                }
                if (clickView.contains("target")) {
                    arrayList.add(this.f14238v);
                }
            }
        }
        a(arrayList);
    }

    private void aS() {
        ((FrameLayout) this.f14230n).removeView(this.f14232p);
    }

    private void b(Activity activity) {
        if (activity == null || this.f14232p == null) {
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        this.f14230n = decorView;
        if (decorView instanceof FrameLayout) {
            ap.a(this.f14232p);
            ((FrameLayout) this.f14230n).addView(this.f14232p);
            b(this.f14234r);
        }
    }

    private void e(int i6, int i7) {
        a(this.E, this.T.getDescCoordinate(), i6, i7);
        if (TextUtils.isEmpty(aL())) {
            return;
        }
        this.E.setText(aL());
    }

    private void g(int i6, int i7) {
        a(this.f14238v, this.T.getActionCoordinate(), i6, i7);
        if (TextUtils.isEmpty(aN())) {
            return;
        }
        this.F.setText(aN());
    }

    private void h(int i6, int i7) {
        a(this.f14237u, this.T.getCloseCoordinate(), i6, i7);
    }

    private void i(int i6, int i7) {
        b(this.f14239w, this.T.getScrollCoordinate(), i6, i7);
    }

    @Override // com.beizi.fusion.work.a
    public void a(Activity activity) {
        try {
            if (this.M) {
                return;
            }
            this.M = true;
            this.O = activity;
            b(activity);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected void aC() {
        d dVar = this.f14055d;
        if (dVar != null && dVar.o() != 2) {
            this.f14055d.d(f());
        }
        if (this.L) {
            return;
        }
        this.L = true;
        D();
        ad();
        if (this.f14062k != 2) {
            aQ();
        }
    }

    protected void aD() {
        this.f14061j = com.beizi.fusion.e.a.ADSHOW;
        d dVar = this.f14055d;
        if (dVar != null && dVar.o() != 2) {
            this.f14055d.b(f());
        }
        if (this.K) {
            return;
        }
        this.K = true;
        aO();
        B();
        C();
        ac();
    }

    protected void aF() {
        if (this.T != null) {
            a((int) this.I, (int) this.J);
            this.f14242z.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.e.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aG();
                }
            });
        }
        this.f14232p = this.f14231o;
        aH();
    }

    public String aK() {
        return "";
    }

    public String aL() {
        return "";
    }

    public String aM() {
        return "";
    }

    public String aN() {
        return "";
    }

    protected void aO() {
        AdSpacesBean.BuyerBean.RenderAds renderAds;
        if (this.C == null || this.f14242z == null || (renderAds = this.T) == null) {
            return;
        }
        if (renderAds.getAutoClose() == 0 && this.T.getMinTime() == 0) {
            this.C.setVisibility(8);
            this.f14242z.setVisibility(0);
        } else {
            this.f14242z.setVisibility(8);
            this.C.setVisibility(0);
            a(this.T.getAutoClose(), this.T.getMinTime(), this.T.getMaxTime());
        }
        this.f14237u.setVisibility(0);
    }

    protected void aQ() {
        al alVar = this.P;
        if (alVar != null) {
            alVar.c();
        }
        aj ajVar = this.Q;
        if (ajVar != null) {
            ajVar.b();
        }
        aa();
        F();
        c(this.O);
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean j() {
        return this.f14056e;
    }

    @Override // com.beizi.fusion.work.a
    public View o() {
        return this.f14232p;
    }

    public a(Context context, long j6, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, d dVar, int i6) {
        this.N = context;
        this.H = j6;
        this.f14056e = buyerBean;
        this.f14055d = dVar;
        this.f14062k = i6;
        this.f14057f = forwardBean;
        this.I = ap.k(context);
        this.J = ap.l(context);
        az();
        r();
    }

    protected void aE() {
        try {
            if (Y()) {
                b();
            } else {
                P();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void az() {
        if (ay() == -1) {
            return;
        }
        View inflate = LayoutInflater.from(this.N).inflate(ay(), (ViewGroup) null);
        this.f14231o = inflate;
        this.f14233q = (ViewGroup) inflate.findViewById(R.id.rl_bg_container);
        this.f14234r = (ViewGroup) this.f14231o.findViewById(R.id.rl_anim_container);
        this.f14235s = (ViewGroup) this.f14231o.findViewById(R.id.rl_container);
        this.f14236t = (ViewGroup) this.f14231o.findViewById(R.id.fl_img_container);
        this.f14241y = (ImageView) this.f14231o.findViewById(R.id.iv_imageview);
        this.f14237u = (ViewGroup) this.f14231o.findViewById(R.id.rl_close);
        this.C = (TextView) this.f14231o.findViewById(R.id.tv_close);
        this.f14242z = (ImageView) this.f14231o.findViewById(R.id.iv_close);
        this.D = (TextView) this.f14231o.findViewById(R.id.tv_title);
        this.E = (TextView) this.f14231o.findViewById(R.id.tv_desc);
        this.A = (ImageView) this.f14231o.findViewById(R.id.iv_icon);
        this.f14238v = (ViewGroup) this.f14231o.findViewById(R.id.rl_action);
        this.F = (TextView) this.f14231o.findViewById(R.id.tv_action);
        this.f14239w = (ViewGroup) this.f14231o.findViewById(R.id.rl_slide_down_container);
        this.G = (TextView) this.f14231o.findViewById(R.id.tv_slide_down_title);
        this.B = (ImageView) this.f14231o.findViewById(R.id.iv_slide_down_arrow);
        this.f14240x = (ViewGroup) this.f14231o.findViewById(R.id.fl_event_container);
    }

    @Override // com.beizi.fusion.work.a
    protected void k() {
        v();
        ab();
        this.T = this.f14056e.getRenderAds();
        aB();
    }

    private void c(Activity activity) {
        if (activity != null) {
            if (this.f14230n == null) {
                this.f14230n = activity.getWindow().getDecorView();
            }
            if (this.f14230n instanceof FrameLayout) {
                aS();
            }
        }
        l();
    }

    @Override // com.beizi.fusion.work.a
    public String f() {
        return "";
    }

    private void a(int i6, int i7) {
        a(this.f14233q, this.T.getBgCoordinate(), i6, i7);
        int i8 = this.f14233q.getLayoutParams().width;
        int i9 = this.f14233q.getLayoutParams().height;
        b(i8, i9);
        i(i8, i9);
    }

    private void b(View view) {
        if (view != null) {
            view.setVisibility(8);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(500L);
            view.setVisibility(0);
            view.startAnimation(translateAnimation);
        }
    }

    private void a(final int i6, final int i7, final int i8) {
        CountDownTimer countDownTimer = this.R;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer((i8 * 1000) + 600, 1000L) { // from class: com.beizi.fusion.work.e.a.3
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (i6 == 1) {
                    a.this.aQ();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j6) {
                a aVar = a.this;
                TextView textView = aVar.C;
                if (textView == null || aVar.f14242z == null) {
                    return;
                }
                int i9 = (int) (j6 / 1000.0f);
                if (i8 - i9 < i7) {
                    textView.setText(String.valueOf(i9));
                } else {
                    textView.setVisibility(8);
                    a.this.f14242z.setVisibility(0);
                }
            }
        };
        this.R = countDownTimer2;
        countDownTimer2.start();
    }

    private void b() {
        d dVar = this.f14055d;
        if (dVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> n6 = dVar.n();
        f();
        n6.toString();
        Z();
        e eVar = this.f14058g;
        if (eVar == e.SUCCESS) {
            aP();
            if (this.f14232p != null) {
                this.f14055d.a(f(), this.f14232p);
                return;
            } else {
                this.f14055d.a(10140);
                return;
            }
        }
        if (eVar == e.FAIL) {
            f();
        }
    }

    private void d(int i6, int i7) {
        a(this.D, this.T.getTitleCoordinate(), i6, i7);
        if (TextUtils.isEmpty(aK())) {
            return;
        }
        this.D.setText(aK());
    }

    private void a(View view, String str, int i6, int i7) {
        RelativeLayout.LayoutParams layoutParams;
        boolean z5;
        if (view == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            view.setVisibility(8);
            return;
        }
        if (str.equals("-1:-1:-1:-1:-1:-1:-1:-1:-1")) {
            view.setVisibility(8);
            return;
        }
        CoordinateBean coordinate = CoordinateBean.getCoordinate(str);
        if (coordinate == null) {
            view.setVisibility(8);
            return;
        }
        int[] a6 = a(coordinate, i6, i7);
        int[] a7 = a(coordinate, i6, i7, a6);
        boolean z6 = view instanceof TextView;
        if (z6) {
            layoutParams = new RelativeLayout.LayoutParams(a7[0], -2);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(a7[0], a7[1]);
        }
        layoutParams.setMargins(a6[0], a6[1], a6[2], a6[3]);
        if (!coordinate.getTop().equals("-1") || coordinate.getBottom().equals("-1")) {
            z5 = false;
        } else {
            layoutParams.addRule(12, -1);
            z5 = true;
        }
        if (coordinate.getLeft().equals("-1") && !coordinate.getRight().equals("-1")) {
            layoutParams.addRule(11, -1);
        }
        view.setLayoutParams(layoutParams);
        if (!coordinate.getFontOrCorner().equals("-1")) {
            if (z6) {
                ((TextView) view).setTextSize(Float.parseFloat(coordinate.getFontOrCorner()));
            } else if (view.getBackground() instanceof GradientDrawable) {
                GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
                if (view != this.f14237u && view != this.f14238v) {
                    int a8 = ap.a(this.N, Float.parseFloat(coordinate.getFontOrCorner()));
                    if (z5) {
                        float f6 = a8;
                        gradientDrawable.setCornerRadii(new float[]{f6, f6, f6, f6, 0.0f, 0.0f, 0.0f, 0.0f});
                    } else {
                        gradientDrawable.setCornerRadius(a8);
                    }
                } else {
                    gradientDrawable.setCornerRadius(a7[1]);
                }
            }
        }
        if (coordinate.getColor().equals("-1")) {
            return;
        }
        if (z6) {
            ((TextView) view).setTextColor(Color.parseColor(coordinate.getColor()));
        } else if (view != this.f14240x) {
            if (view.getBackground() instanceof GradientDrawable) {
                ((GradientDrawable) view.getBackground()).setColor(Color.parseColor(coordinate.getColor()));
            } else {
                view.setBackgroundColor(Color.parseColor(coordinate.getColor()));
            }
        }
    }

    public void aA() {
    }

    public void aB() {
    }

    public void aG() {
    }

    public void aH() {
    }

    public void aI() {
    }

    public void aJ() {
    }

    public void aP() {
    }

    @Override // com.beizi.fusion.work.a
    public void l() {
    }

    private void b(int i6, int i7) {
        String adCoordinate = this.T.getAdCoordinate();
        a(this.f14235s, adCoordinate, i6, i7);
        a(this.f14240x, adCoordinate, i6, i7);
        int i8 = this.f14235s.getLayoutParams().width;
        int i9 = this.f14235s.getLayoutParams().height;
        c(i8, i9);
        d(i8, i9);
        e(i8, i9);
        f(i8, i9);
        g(i8, i9);
        h(i8, i9);
        aI();
        aR();
    }

    private int b(String str, int i6) {
        if (str.contains("%")) {
            return (i6 * ((int) Float.parseFloat(str.substring(0, str.indexOf("%"))))) / 100;
        }
        return ap.a(this.N, Float.parseFloat(str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0145, code lost:
    
        if (r2 <= 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0170, code lost:
    
        if (r3 <= 0) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x028b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(android.view.View r20, java.lang.String r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 735
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.work.e.a.b(android.view.View, java.lang.String, int, int):void");
    }

    private int[] a(CoordinateBean coordinateBean, int i6, int i7, int[] iArr) {
        int b6;
        int b7;
        if (coordinateBean.getWidth().equals("-1")) {
            b6 = (i6 - iArr[0]) - iArr[2];
        } else {
            b6 = b(coordinateBean.getWidth(), i6);
        }
        if (!coordinateBean.getScale().equals("-1") && !coordinateBean.getScale().equals("0")) {
            b7 = (int) (b6 / Float.parseFloat(coordinateBean.getScale()));
        } else if (coordinateBean.getHeight().equals("-1")) {
            b7 = (i7 - iArr[1]) - iArr[3];
        } else {
            b7 = b(coordinateBean.getHeight(), i7);
        }
        return new int[]{b6, b7};
    }

    private int[] a(CoordinateBean coordinateBean, int i6, int i7) {
        String left = coordinateBean.getLeft();
        int i8 = 0;
        int b6 = (left.equals("0%") || left.equals("0") || left.equals("-1")) ? 0 : b(left, i6);
        String top2 = coordinateBean.getTop();
        int b7 = (top2.equals("0%") || top2.equals("0") || top2.equals("-1")) ? 0 : b(top2, i7);
        String right = coordinateBean.getRight();
        int b8 = (right.equals("0%") || right.equals("0") || right.equals("-1")) ? 0 : b(right, i6);
        String bottom = coordinateBean.getBottom();
        if (!bottom.equals("0%") && !bottom.equals("0") && !bottom.equals("-1")) {
            i8 = b(bottom, i7);
        }
        return new int[]{b6, b7, b8, i8};
    }

    protected void a(View view) {
        a(view, "", 30, (aj.a) null);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    protected void a(View view, final String str, int i6, final aj.a aVar) {
        final int a6 = ap.a(this.N, i6);
        final boolean z5 = view == this.f14233q;
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.e.a.4

            /* renamed from: a, reason: collision with root package name */
            float f14249a;

            /* renamed from: b, reason: collision with root package name */
            float f14250b;

            /* renamed from: c, reason: collision with root package name */
            float f14251c;

            /* renamed from: d, reason: collision with root package name */
            float f14252d;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                aj.a aVar2;
                aj.a aVar3;
                aj.a aVar4;
                aj.a aVar5;
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            this.f14251c = motionEvent.getX();
                            this.f14252d = motionEvent.getY();
                        }
                    } else {
                        aa.b("SlideClickUtil", "mCurPosX = " + this.f14251c + ",mCurPosY = " + this.f14252d + ",mPosX = " + this.f14249a + ",mPosY = " + this.f14250b);
                        float f6 = this.f14252d;
                        float f7 = this.f14250b;
                        float f8 = f6 - f7;
                        int i7 = a6;
                        if (f8 > i7) {
                            if (!TextUtils.isEmpty(a.this.T.getScrollCoordinate()) && !a.this.T.getScrollCoordinate().equals("-1:-1:-1:-1:-1:-1:-1:-1:-1")) {
                                a.this.b(z5);
                            } else if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(str) && (aVar5 = aVar) != null) {
                                aVar5.a_();
                            }
                        } else if (f7 - f6 > i7) {
                            if ("up".equalsIgnoreCase(str) && (aVar4 = aVar) != null) {
                                aVar4.a_();
                            }
                        } else {
                            float f9 = this.f14249a;
                            float f10 = this.f14251c;
                            if (f9 - f10 > i7) {
                                if (ScrollClickView.DIR_LEFT.equalsIgnoreCase(str) && (aVar3 = aVar) != null) {
                                    aVar3.a_();
                                }
                            } else if (f10 - f9 > i7) {
                                if ("right".equalsIgnoreCase(str) && (aVar2 = aVar) != null) {
                                    aVar2.a_();
                                }
                            } else if (z5) {
                                a.this.f14233q.onTouchEvent(motionEvent);
                            } else {
                                a.this.f14235s.dispatchTouchEvent(motionEvent);
                            }
                        }
                    }
                } else {
                    this.f14249a = motionEvent.getX();
                    this.f14250b = motionEvent.getY();
                    this.f14251c = motionEvent.getX();
                    this.f14252d = motionEvent.getY();
                    if (z5) {
                        a.this.f14233q.onTouchEvent(motionEvent);
                    } else {
                        a.this.f14235s.dispatchTouchEvent(motionEvent);
                    }
                }
                return true;
            }
        });
    }
}
