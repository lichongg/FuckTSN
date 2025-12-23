package com.beizi.ad.internal.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.Nullable;
import com.beizi.ad.a.a.a;
import com.beizi.ad.a.a.b;
import com.beizi.ad.a.a.c;
import com.beizi.ad.a.a.d;
import com.beizi.ad.a.a.e;
import com.beizi.ad.internal.h.i;
import com.beizi.ad.internal.h.j;
import com.beizi.ad.internal.h.n;
import com.beizi.ad.internal.h.t;
import com.beizi.ad.internal.h.u;
import com.beizi.ad.internal.view.CustomRoundImageView;
import com.beizi.ad.internal.view.a.a;
import com.beizi.ad.lance.a.m;
import com.beizi.ad.lance.a.q;
import com.beizi.fusion.R;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BeiZiInterstitialActivity extends Activity {
    private boolean B;
    private MediaPlayer C;
    private int E;
    private boolean F;
    private int G;
    private CountDownTimer H;
    private String J;
    private String K;
    private String L;
    private String M;
    private String N;
    private AdSpacesBean.BuyerBean O;
    private com.beizi.ad.a.a.c P;
    private e Q;
    private com.beizi.ad.a.a.d R;
    private com.beizi.ad.a.a.a S;
    private com.beizi.ad.a.a.b T;
    private Timer V;
    private TimerTask W;
    private boolean X;

    /* renamed from: a, reason: collision with root package name */
    private com.beizi.ad.internal.c.a f11473a;

    /* renamed from: b, reason: collision with root package name */
    private com.beizi.ad.internal.f.c f11474b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f11475c;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f11476d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f11477e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f11478f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f11479g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f11480h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f11481i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f11482j;

    /* renamed from: k, reason: collision with root package name */
    private RelativeLayout f11483k;

    /* renamed from: l, reason: collision with root package name */
    private RelativeLayout f11484l;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f11485m;

    /* renamed from: n, reason: collision with root package name */
    private RelativeLayout f11486n;

    /* renamed from: o, reason: collision with root package name */
    private RelativeLayout f11487o;

    /* renamed from: p, reason: collision with root package name */
    private RelativeLayout f11488p;

    /* renamed from: q, reason: collision with root package name */
    private FrameLayout f11489q;

    /* renamed from: r, reason: collision with root package name */
    private CustomRoundImageView f11490r;

    /* renamed from: s, reason: collision with root package name */
    private CustomRoundImageView f11491s;

    /* renamed from: t, reason: collision with root package name */
    private ImageView f11492t;

    /* renamed from: u, reason: collision with root package name */
    private ImageView f11493u;

    /* renamed from: v, reason: collision with root package name */
    private ImageView f11494v;

    /* renamed from: w, reason: collision with root package name */
    private VideoView f11495w;

    /* renamed from: x, reason: collision with root package name */
    private View f11496x;

    /* renamed from: y, reason: collision with root package name */
    private View f11497y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f11498z = false;
    private boolean A = false;
    private boolean D = false;
    private boolean I = true;
    private boolean U = true;

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        if (i6 == 4 || i6 == 3) {
            return true;
        }
        return super.onKeyDown(i6, keyEvent);
    }

    private void A() {
        try {
            if (this.f11495w != null && this.B) {
                if (this.f11486n.getVisibility() == 0) {
                    this.E = 0;
                } else {
                    this.E = this.f11495w.getCurrentPosition();
                }
                this.f11495w.pause();
            }
            e eVar = this.Q;
            if (eVar != null) {
                eVar.b();
            }
            com.beizi.ad.a.a.a aVar = this.S;
            if (aVar != null) {
                aVar.b();
            }
            CountDownTimer countDownTimer = this.H;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.H = null;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void c() {
        try {
            com.beizi.ad.internal.c.a aVar = com.beizi.ad.internal.c.a.f11685b;
            this.f11473a = aVar;
            this.O = aVar.a();
            this.X = this.f11473a.e();
            AdSpacesBean.BuyerBean buyerBean = this.O;
            if (buyerBean == null) {
                return;
            }
            if (buyerBean.getTemplate() == 1) {
                this.f11498z = true;
            } else {
                this.f11498z = false;
            }
            com.beizi.ad.internal.f.c cVar = this.f11473a.f11686a;
            this.f11474b = cVar;
            if (cVar == null) {
                return;
            }
            this.N = cVar.f();
            boolean N = this.f11474b.N();
            this.B = N;
            if (N) {
                this.M = this.f11474b.M();
            } else {
                this.M = this.f11474b.L();
            }
            this.J = this.f11474b.O();
            this.F = this.f11474b.n();
            this.G = this.f11474b.s();
            this.K = this.f11474b.J();
            this.L = this.f11474b.K();
            this.A = !this.f11474b.m();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void d() {
        RelativeLayout.LayoutParams layoutParams;
        double d6;
        double d7;
        RelativeLayout.LayoutParams layoutParams2;
        LinearLayout.LayoutParams layoutParams3;
        try {
            int a6 = u.a((Context) this, 10.0f);
            n.a(this.f11475c, "#FFFFFF", 0, (String) null, a6);
            int a7 = u.a((Context) this, 49.0f);
            int a8 = u.a((Context) this, 19.0f);
            int a9 = u.a((Context) this, 8.0f);
            int a10 = u.a((Context) this, 52.0f);
            TextView textView = this.f11478f;
            if (textView != null) {
                n.a(textView, "#66303030", 0, (String) null, a6);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f11478f.getLayoutParams();
                layoutParams4.width = a7;
                layoutParams4.height = a8;
                layoutParams4.setMargins(a9, a9, 0, 0);
                layoutParams4.addRule(17);
                this.f11478f.setLayoutParams(layoutParams4);
            }
            ImageView imageView = this.f11492t;
            if (imageView != null && this.B) {
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams5.width = a8;
                layoutParams5.height = a8;
                layoutParams5.setMargins(0, a9, a6, 0);
                this.f11492t.setLayoutParams(layoutParams5);
            }
            LinearLayout linearLayout = this.f11476d;
            if (linearLayout != null) {
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams6.width = a10;
                layoutParams6.height = a8;
                layoutParams6.setMargins(0, a9, a9, 0);
                this.f11476d.setLayoutParams(layoutParams6);
                n.a(this.f11476d, "#66303030", 0, (String) null, a6);
            }
            TextView textView2 = this.f11479g;
            if (textView2 != null) {
                LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) textView2.getLayoutParams();
                layoutParams7.width = a8;
                layoutParams7.height = a8;
                this.f11479g.setLayoutParams(layoutParams7);
                n.a(this.f11479g, "#66303030", 0, (String) null, a6 * 2);
            }
            ImageView imageView2 = this.f11493u;
            if (imageView2 != null) {
                RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
                layoutParams8.width = a8;
                layoutParams8.height = a8;
                layoutParams8.setMargins(0, a9, a9, 0);
                this.f11493u.setLayoutParams(layoutParams8);
            }
            int f6 = q.f(this);
            int g6 = q.g(this);
            double d8 = f6;
            int i6 = (int) (0.65d * d8);
            int a11 = u.a((Context) this, 5.0f);
            if (this.f11498z) {
                i6 = (int) (d8 * 0.85d);
                a11 = u.a((Context) this, 10.0f);
                this.f11488p.setVisibility(0);
                RelativeLayout relativeLayout = this.f11488p;
                if (relativeLayout != null && (layoutParams3 = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams()) != null) {
                    layoutParams3.width = i6 - (a11 * 3);
                    layoutParams3.height = -2;
                    if (!TextUtils.isEmpty(this.J) && TextUtils.isEmpty(this.K) && TextUtils.isEmpty(this.L)) {
                        layoutParams3.setMargins(0, a11, 0, u.a((Context) this, 5.0f));
                    } else {
                        layoutParams3.setMargins(0, (int) (a11 * 1.5d), 0, u.a((Context) this, 5.0f));
                    }
                    this.f11488p.setLayoutParams(layoutParams3);
                }
            } else {
                this.f11487o.setVisibility(0);
                RelativeLayout relativeLayout2 = this.f11487o;
                if (relativeLayout2 != null && (layoutParams = (RelativeLayout.LayoutParams) relativeLayout2.getLayoutParams()) != null) {
                    layoutParams.width = i6;
                    layoutParams.height = -2;
                    layoutParams.setMargins(0, a11 * 3, 0, 0);
                    this.f11487o.setLayoutParams(layoutParams);
                }
            }
            LinearLayout linearLayout2 = this.f11475c;
            if (linearLayout2 != null && (layoutParams2 = (RelativeLayout.LayoutParams) linearLayout2.getLayoutParams()) != null) {
                layoutParams2.width = i6;
                layoutParams2.height = -2;
                this.f11475c.setLayoutParams(layoutParams2);
                this.f11475c.setPadding(a11, a11, a11, a11);
            }
            RelativeLayout relativeLayout3 = this.f11485m;
            if (relativeLayout3 != null) {
                int i7 = i6 - (a11 * 2);
                if (this.f11498z) {
                    d6 = i7;
                    d7 = 0.56d;
                } else {
                    d6 = i7;
                    d7 = 1.78d;
                }
                int i8 = (int) (d6 * d7);
                double d9 = g6;
                if (i8 > 0.7d * d9) {
                    i8 = (int) (d9 * 0.5d);
                }
                RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) relativeLayout3.getLayoutParams();
                if (layoutParams9 != null) {
                    layoutParams9.width = i7;
                    layoutParams9.height = i8;
                    this.f11485m.setLayoutParams(layoutParams9);
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private boolean e() {
        if (this.B) {
            return true;
        }
        return this.F && this.G > 0;
    }

    private void f() {
        try {
            if (!e()) {
                this.f11476d.setVisibility(8);
                this.f11493u.setVisibility(0);
            } else {
                this.f11476d.setVisibility(0);
                this.f11493u.setVisibility(8);
                this.f11476d.measure(0, 0);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        int i6;
        try {
            this.H = null;
            i6 = this.G;
            TextView textView = this.f11479g;
            if (textView != null) {
                try {
                    String charSequence = textView.getText().toString();
                    if (!TextUtils.isEmpty(charSequence) && !"0".equals(charSequence)) {
                        i6 = Integer.parseInt(charSequence);
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                this.f11479g.setText(String.valueOf(i6));
            }
        } catch (Exception e7) {
            e = e7;
            e.printStackTrace();
        }
        try {
            CountDownTimer countDownTimer = new CountDownTimer(i6 * 1000, 1000L) { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    try {
                        m.a("BeiZisAd", "onFinish");
                        if (!BeiZiInterstitialActivity.this.F || BeiZiInterstitialActivity.this.G <= 0) {
                            return;
                        }
                        BeiZiInterstitialActivity.this.q();
                    } catch (Exception e8) {
                        e8.printStackTrace();
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j6) {
                    try {
                        int i7 = (int) ((j6 / 1000) + 1);
                        if (BeiZiInterstitialActivity.this.f11479g != null) {
                            BeiZiInterstitialActivity.this.f11479g.setText(String.valueOf(i7));
                        }
                    } catch (Exception e8) {
                        e8.printStackTrace();
                    }
                }
            };
            this.H = countDownTimer;
            countDownTimer.start();
        } catch (Exception e8) {
            e = e8;
            e.printStackTrace();
        }
    }

    private void h() {
        try {
            if (!this.B && this.f11490r != null && !TextUtils.isEmpty(this.M)) {
                this.f11490r.setVisibility(0);
                i.a((Context) null).a(this.M, new i.a() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.12
                    @Override // com.beizi.ad.internal.h.i.a
                    public void a(Bitmap bitmap) {
                        try {
                            if (BeiZiInterstitialActivity.this.f11490r != null) {
                                if (BeiZiInterstitialActivity.this.f11485m != null) {
                                    BeiZiInterstitialActivity.this.f11485m.measure(0, 0);
                                    ViewGroup.LayoutParams layoutParams = BeiZiInterstitialActivity.this.f11490r.getLayoutParams();
                                    if (layoutParams != null) {
                                        layoutParams.width = BeiZiInterstitialActivity.this.f11485m.getMeasuredWidth();
                                        layoutParams.height = BeiZiInterstitialActivity.this.f11485m.getMeasuredHeight();
                                        BeiZiInterstitialActivity.this.f11490r.setLayoutParams(layoutParams);
                                    }
                                }
                                BeiZiInterstitialActivity.this.f11490r.setRectRadius(u.a((Context) BeiZiInterstitialActivity.this, 6.0f));
                                BeiZiInterstitialActivity.this.f11490r.setBackground(new BitmapDrawable(j.a(BeiZiInterstitialActivity.this, bitmap, 20.0f)));
                                BeiZiInterstitialActivity.this.f11490r.setImageBitmap(bitmap);
                                BeiZiInterstitialActivity.this.o();
                                BeiZiInterstitialActivity.this.u();
                                BeiZiInterstitialActivity.this.r();
                                if (!BeiZiInterstitialActivity.this.F || BeiZiInterstitialActivity.this.G <= 0) {
                                    return;
                                }
                                BeiZiInterstitialActivity.this.g();
                            }
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }

                    @Override // com.beizi.ad.internal.h.i.a
                    public void a() {
                        BeiZiInterstitialActivity.this.finish();
                    }
                });
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void i() {
        AdSpacesBean.ComplainBean complain;
        TextView textView;
        try {
            AdSpacesBean.BuyerBean buyerBean = this.O;
            if (buyerBean == null || (complain = buyerBean.getComplain()) == null || complain.getOpen() != 1 || (textView = this.f11478f) == null) {
                return;
            }
            textView.setVisibility(0);
            this.f11478f.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BeiZiInterstitialActivity.this.j();
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        try {
            A();
            a.C0116a c0116a = new a.C0116a(this);
            c0116a.a(new a.b() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.14
                @Override // com.beizi.ad.internal.view.a.a.b
                public void a(String str) {
                    try {
                        com.beizi.ad.internal.c d6 = BeiZiInterstitialActivity.this.f11473a.d();
                        if (d6 == null) {
                            return;
                        }
                        d6.a(str);
                        d6.b();
                        BeiZiInterstitialActivity.this.finish();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }

                @Override // com.beizi.ad.internal.view.a.a.b
                public void a() {
                    BeiZiInterstitialActivity.this.t();
                }
            });
            c0116a.a().show();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void k() {
        try {
            if (this.f11474b == null) {
                return;
            }
            if (TextUtils.isEmpty(this.J)) {
                View view = this.f11496x;
                if (view != null) {
                    view.setVisibility(8);
                }
                CustomRoundImageView customRoundImageView = this.f11491s;
                if (customRoundImageView != null) {
                    customRoundImageView.setVisibility(8);
                    return;
                }
                return;
            }
            int a6 = u.a((Context) this, 20.0f);
            CustomRoundImageView customRoundImageView2 = this.f11491s;
            if (customRoundImageView2 != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) customRoundImageView2.getLayoutParams();
                int i6 = a6 * 2;
                layoutParams.width = i6;
                layoutParams.height = i6;
                this.f11491s.setLayoutParams(layoutParams);
                this.f11491s.setVisibility(0);
            }
            View view2 = this.f11496x;
            if (view2 != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view2.getLayoutParams();
                layoutParams2.width = -1;
                layoutParams2.height = a6;
                this.f11496x.setLayoutParams(layoutParams2);
                this.f11496x.setVisibility(0);
            }
            i.a((Context) null).a(this.J, new i.a() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.15
                @Override // com.beizi.ad.internal.h.i.a
                public void a() {
                }

                @Override // com.beizi.ad.internal.h.i.a
                public void a(Bitmap bitmap) {
                    try {
                        if (BeiZiInterstitialActivity.this.f11491s != null) {
                            BeiZiInterstitialActivity.this.f11491s.setImageBitmap(bitmap);
                        }
                        BeiZiInterstitialActivity.this.f11491s.setRectRadius(u.a((Context) BeiZiInterstitialActivity.this, 6.0f));
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a A[Catch: Exception -> 0x001a, TryCatch #0 {Exception -> 0x001a, blocks: (B:2:0x0000, B:4:0x000b, B:7:0x0014, B:8:0x0022, B:10:0x002a, B:12:0x0032, B:14:0x0048, B:16:0x0050, B:17:0x005f, B:18:0x0058, B:19:0x0064, B:20:0x006a, B:21:0x006f, B:23:0x0073, B:25:0x007b, B:27:0x0097, B:29:0x00aa, B:30:0x00af, B:31:0x00a1, B:32:0x00b5, B:33:0x00ba, B:35:0x00be, B:37:0x00c2, B:41:0x00c6, B:43:0x00ca, B:45:0x00d2, B:47:0x00da, B:49:0x00e2, B:51:0x00e8, B:53:0x00fb, B:55:0x0103, B:57:0x010b, B:58:0x011a, B:60:0x0114, B:62:0x001d), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0073 A[Catch: Exception -> 0x001a, TryCatch #0 {Exception -> 0x001a, blocks: (B:2:0x0000, B:4:0x000b, B:7:0x0014, B:8:0x0022, B:10:0x002a, B:12:0x0032, B:14:0x0048, B:16:0x0050, B:17:0x005f, B:18:0x0058, B:19:0x0064, B:20:0x006a, B:21:0x006f, B:23:0x0073, B:25:0x007b, B:27:0x0097, B:29:0x00aa, B:30:0x00af, B:31:0x00a1, B:32:0x00b5, B:33:0x00ba, B:35:0x00be, B:37:0x00c2, B:41:0x00c6, B:43:0x00ca, B:45:0x00d2, B:47:0x00da, B:49:0x00e2, B:51:0x00e8, B:53:0x00fb, B:55:0x0103, B:57:0x010b, B:58:0x011a, B:60:0x0114, B:62:0x001d), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00be A[Catch: Exception -> 0x001a, TryCatch #0 {Exception -> 0x001a, blocks: (B:2:0x0000, B:4:0x000b, B:7:0x0014, B:8:0x0022, B:10:0x002a, B:12:0x0032, B:14:0x0048, B:16:0x0050, B:17:0x005f, B:18:0x0058, B:19:0x0064, B:20:0x006a, B:21:0x006f, B:23:0x0073, B:25:0x007b, B:27:0x0097, B:29:0x00aa, B:30:0x00af, B:31:0x00a1, B:32:0x00b5, B:33:0x00ba, B:35:0x00be, B:37:0x00c2, B:41:0x00c6, B:43:0x00ca, B:45:0x00d2, B:47:0x00da, B:49:0x00e2, B:51:0x00e8, B:53:0x00fb, B:55:0x0103, B:57:0x010b, B:58:0x011a, B:60:0x0114, B:62:0x001d), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c6 A[Catch: Exception -> 0x001a, TryCatch #0 {Exception -> 0x001a, blocks: (B:2:0x0000, B:4:0x000b, B:7:0x0014, B:8:0x0022, B:10:0x002a, B:12:0x0032, B:14:0x0048, B:16:0x0050, B:17:0x005f, B:18:0x0058, B:19:0x0064, B:20:0x006a, B:21:0x006f, B:23:0x0073, B:25:0x007b, B:27:0x0097, B:29:0x00aa, B:30:0x00af, B:31:0x00a1, B:32:0x00b5, B:33:0x00ba, B:35:0x00be, B:37:0x00c2, B:41:0x00c6, B:43:0x00ca, B:45:0x00d2, B:47:0x00da, B:49:0x00e2, B:51:0x00e8, B:53:0x00fb, B:55:0x0103, B:57:0x010b, B:58:0x011a, B:60:0x0114, B:62:0x001d), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void l() {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.l():void");
    }

    private void m() {
        try {
            if (this.B && this.f11495w != null && !TextUtils.isEmpty(this.M)) {
                RelativeLayout relativeLayout = this.f11485m;
                if (relativeLayout != null) {
                    n.a(relativeLayout, "#000000", 0, (String) null, u.a((Context) this, 6.0f));
                }
                ImageView imageView = this.f11492t;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    if (this.A) {
                        this.f11492t.setImageResource(R.drawable.voice_on);
                    } else {
                        this.f11492t.setImageResource(R.drawable.voice_off);
                    }
                }
                RelativeLayout relativeLayout2 = this.f11486n;
                if (relativeLayout2 != null) {
                    n.a(relativeLayout2, "#66303030", 0, (String) null, u.a((Context) this, 6.0f));
                    this.f11486n.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            try {
                                if (BeiZiInterstitialActivity.this.f11486n != null) {
                                    BeiZiInterstitialActivity.this.f11486n.setVisibility(8);
                                }
                                if (BeiZiInterstitialActivity.this.f11495w != null) {
                                    if (Build.VERSION.SDK_INT >= 26) {
                                        BeiZiInterstitialActivity.this.C.seekTo(0L, 3);
                                    }
                                    BeiZiInterstitialActivity.this.f11495w.start();
                                }
                                int duration = BeiZiInterstitialActivity.this.C.getDuration() / 1000;
                                if (BeiZiInterstitialActivity.this.f11479g != null) {
                                    BeiZiInterstitialActivity.this.f11479g.setText(String.valueOf(duration));
                                }
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                    });
                }
                if (this.f11494v != null) {
                    int a6 = u.a((Context) this, 54.0f);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f11494v.getLayoutParams();
                    layoutParams.width = a6;
                    layoutParams.height = a6;
                    this.f11494v.setLayoutParams(layoutParams);
                }
                this.f11495w.setVisibility(0);
                t.a().a(this, this.M, new t.a() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.17
                    @Override // com.beizi.ad.internal.h.t.a
                    public void a(String str) {
                        try {
                            m.a("BeiZisAd", "onVideoLoaded: 加载成功");
                            BeiZiInterstitialActivity.this.f11495w.setVideoPath(str);
                            BeiZiInterstitialActivity.this.f11495w.requestFocus();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }

                    @Override // com.beizi.ad.internal.h.t.a
                    public void a() {
                        BeiZiInterstitialActivity.this.finish();
                    }
                });
                this.f11495w.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.18
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        m.a("BeiZisAd", "onCompletion: 播放完成");
                        try {
                            BeiZiInterstitialActivity.this.E = 0;
                            if (BeiZiInterstitialActivity.this.f11486n != null) {
                                BeiZiInterstitialActivity.this.f11486n.setVisibility(0);
                            }
                            if (!BeiZiInterstitialActivity.this.F || BeiZiInterstitialActivity.this.G <= 0) {
                                if (BeiZiInterstitialActivity.this.F) {
                                    BeiZiInterstitialActivity.this.q();
                                } else if (BeiZiInterstitialActivity.this.f11479g != null) {
                                    BeiZiInterstitialActivity.this.f11479g.setText("0");
                                }
                            }
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                });
                this.f11495w.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.19
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        try {
                            BeiZiInterstitialActivity.this.C = mediaPlayer;
                            m.a("BeiZisAd", "onPrepared: 准备完成");
                            if (BeiZiInterstitialActivity.this.A) {
                                BeiZiInterstitialActivity.this.C.setVolume(0.0f, 1.0f);
                            } else {
                                BeiZiInterstitialActivity.this.C.setVolume(0.0f, 0.0f);
                            }
                            if (BeiZiInterstitialActivity.this.f11495w != null) {
                                if (BeiZiInterstitialActivity.this.E > 0) {
                                    if (Build.VERSION.SDK_INT >= 26) {
                                        BeiZiInterstitialActivity.this.C.seekTo(BeiZiInterstitialActivity.this.E, 3);
                                    }
                                } else if (Build.VERSION.SDK_INT >= 26) {
                                    BeiZiInterstitialActivity.this.C.seekTo(2L, 3);
                                }
                                if (BeiZiInterstitialActivity.this.f11486n != null && BeiZiInterstitialActivity.this.f11486n.getVisibility() == 8) {
                                    BeiZiInterstitialActivity.this.f11495w.start();
                                }
                            }
                            if (BeiZiInterstitialActivity.this.U) {
                                if (!BeiZiInterstitialActivity.this.F || BeiZiInterstitialActivity.this.G <= 0) {
                                    int duration = mediaPlayer.getDuration() / 1000;
                                    if (BeiZiInterstitialActivity.this.f11479g != null) {
                                        BeiZiInterstitialActivity.this.f11479g.setText(String.valueOf(duration));
                                    }
                                }
                                BeiZiInterstitialActivity.this.n();
                                BeiZiInterstitialActivity.this.o();
                                BeiZiInterstitialActivity.this.u();
                                BeiZiInterstitialActivity.this.r();
                            }
                            BeiZiInterstitialActivity.this.U = false;
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                });
                this.f11495w.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.2
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i6, int i7) {
                        return false;
                    }
                });
                if (!this.F || this.G <= 0) {
                    a();
                } else {
                    g();
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0043, code lost:
    
        r6.width = r7;
        r6.height = r8;
        r9.f11495w.setLayoutParams(r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void n() {
        /*
            r9 = this;
            android.widget.VideoView r0 = r9.f11495w     // Catch: java.lang.Exception -> L4d
            if (r0 != 0) goto L6
            goto L97
        L6:
            android.widget.RelativeLayout r0 = r9.f11485m     // Catch: java.lang.Exception -> L4d
            int r0 = r0.getWidth()     // Catch: java.lang.Exception -> L4d
            android.widget.RelativeLayout r1 = r9.f11485m     // Catch: java.lang.Exception -> L4d
            int r1 = r1.getHeight()     // Catch: java.lang.Exception -> L4d
            android.widget.VideoView r2 = r9.f11495w     // Catch: java.lang.Exception -> L4d
            r3 = 0
            r2.measure(r3, r3)     // Catch: java.lang.Exception -> L4d
            android.widget.VideoView r2 = r9.f11495w     // Catch: java.lang.Exception -> L4d
            int r2 = r2.getMeasuredWidth()     // Catch: java.lang.Exception -> L4d
            android.widget.VideoView r4 = r9.f11495w     // Catch: java.lang.Exception -> L4d
            int r4 = r4.getMeasuredHeight()     // Catch: java.lang.Exception -> L4d
            double r5 = (double) r2     // Catch: java.lang.Exception -> L4d
            r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r5 = r5 * r7
            double r7 = (double) r4     // Catch: java.lang.Exception -> L4d
            double r5 = r5 / r7
            float r5 = (float) r5     // Catch: java.lang.Exception -> L4d
            android.widget.VideoView r6 = r9.f11495w     // Catch: java.lang.Exception -> L4d
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()     // Catch: java.lang.Exception -> L4d
            r7 = -2
            r8 = -1
            if (r2 < r0) goto L39
        L36:
            r7 = -1
            r8 = -2
            goto L41
        L39:
            if (r4 <= r1) goto L3c
            goto L41
        L3c:
            int r0 = r0 - r2
            int r1 = r1 - r4
            if (r0 > r1) goto L41
            goto L36
        L41:
            if (r6 == 0) goto L4f
            r6.width = r7     // Catch: java.lang.Exception -> L4d
            r6.height = r8     // Catch: java.lang.Exception -> L4d
            android.widget.VideoView r0 = r9.f11495w     // Catch: java.lang.Exception -> L4d
            r0.setLayoutParams(r6)     // Catch: java.lang.Exception -> L4d
            goto L4f
        L4d:
            r0 = move-exception
            goto L98
        L4f:
            boolean r0 = r9.f11498z     // Catch: java.lang.Exception -> L4d
            if (r0 == 0) goto L57
            r0 = 1071896330(0x3fe3d70a, float:1.78)
            goto L5a
        L57:
            r0 = 1057971241(0x3f0f5c29, float:0.56)
        L5a:
            float r0 = r0 - r5
            float r1 = java.lang.Math.abs(r0)     // Catch: java.lang.Exception -> L4d
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 < 0) goto L97
            float r0 = java.lang.Math.abs(r0)     // Catch: java.lang.Exception -> L4d
            double r0 = (double) r0     // Catch: java.lang.Exception -> L4d
            r4 = 4594572339843380019(0x3fc3333333333333, double:0.15)
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 > 0) goto L97
            android.widget.VideoView r0 = r9.f11495w     // Catch: java.lang.Exception -> L4d
            com.beizi.ad.a.a.f r1 = new com.beizi.ad.a.a.f     // Catch: java.lang.Exception -> L4d
            r2 = 1086324736(0x40c00000, float:6.0)
            int r4 = com.beizi.ad.internal.h.u.a(r9, r2)     // Catch: java.lang.Exception -> L4d
            float r4 = (float) r4     // Catch: java.lang.Exception -> L4d
            r1.<init>(r4)     // Catch: java.lang.Exception -> L4d
            r0.setOutlineProvider(r1)     // Catch: java.lang.Exception -> L4d
            android.widget.VideoView r0 = r9.f11495w     // Catch: java.lang.Exception -> L4d
            r1 = 1
            r0.setClipToOutline(r1)     // Catch: java.lang.Exception -> L4d
            android.widget.RelativeLayout r0 = r9.f11485m     // Catch: java.lang.Exception -> L4d
            if (r0 == 0) goto L97
            java.lang.String r1 = "#FFFFFF"
            int r2 = com.beizi.ad.internal.h.u.a(r9, r2)     // Catch: java.lang.Exception -> L4d
            r4 = 0
            com.beizi.ad.internal.h.n.a(r0, r1, r3, r4, r2)     // Catch: java.lang.Exception -> L4d
        L97:
            return
        L98:
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.n():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        try {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout a6 = u.a(this, this.f11474b.A());
            a6.setVisibility(0);
            linearLayout.addView(a6, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            View b6 = u.b(this, this.f11474b.z());
            b6.setVisibility(0);
            linearLayout.addView(b6, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b6.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            b6.setLayoutParams(layoutParams);
            if (this.f11489q != null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 85);
                int a7 = u.a((Context) this, 8.0f);
                layoutParams2.setMargins(0, 0, a7, a7);
                this.f11489q.addView(linearLayout, layoutParams2);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void p() {
        RelativeLayout relativeLayout = this.f11484l;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        BeiZiInterstitialActivity.this.q();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            });
        }
        ImageView imageView = this.f11492t;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        if (BeiZiInterstitialActivity.this.A) {
                            BeiZiInterstitialActivity.this.f11492t.setImageResource(R.drawable.voice_off);
                            if (BeiZiInterstitialActivity.this.C != null) {
                                BeiZiInterstitialActivity.this.C.setVolume(0.0f, 0.0f);
                            }
                        } else {
                            BeiZiInterstitialActivity.this.f11492t.setImageResource(R.drawable.voice_on);
                            if (BeiZiInterstitialActivity.this.C != null) {
                                BeiZiInterstitialActivity.this.C.setVolume(0.0f, 1.0f);
                            }
                        }
                        BeiZiInterstitialActivity.this.A = !r3.A;
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        CountDownTimer countDownTimer = this.H;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.H = null;
        }
        com.beizi.ad.internal.c.a aVar = this.f11473a;
        if (aVar != null && aVar.d() != null) {
            this.f11473a.d().b();
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.beizi.ad.internal.f.c cVar;
        com.beizi.ad.internal.c d6;
        try {
            com.beizi.ad.internal.c.a aVar = this.f11473a;
            if (aVar == null || (cVar = aVar.f11686a) == null || (d6 = aVar.d()) == null) {
                return;
            }
            com.beizi.ad.internal.e c6 = this.f11473a.c();
            cVar.a(this.f11475c, c6 != null ? c6.a() : null);
            d6.a();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void s() {
        try {
            com.beizi.ad.internal.f.c cVar = this.f11474b;
            if (cVar == null) {
                return;
            }
            int I = cVar.I();
            if (I != 2 && I != 5) {
                return;
            }
            this.f11480h.setVisibility(0);
            final String B = this.f11474b.B();
            String D = this.f11474b.D();
            String C = this.f11474b.C();
            String F = this.f11474b.F();
            final String E = !TextUtils.isEmpty(F) ? F : this.f11474b.E();
            final String G = this.f11474b.G();
            final String H = this.f11474b.H();
            this.f11480h.setText(Html.fromHtml("应用名称：" + B + " | 开发者：" + D + " | 应用版本：" + C + " | <u>权限详情</u> | <u>隐私协议</u> | <u>功能介绍</u>"));
            this.f11480h.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        Intent intent = new Intent(BeiZiInterstitialActivity.this, (Class<?>) DownloadAppInfoActivity.class);
                        intent.putExtra("title_content_key", B);
                        intent.putExtra("privacy_content_key", G);
                        intent.putExtra("permission_content_key", E);
                        intent.putExtra("intro_content_key", H);
                        intent.setFlags(268435456);
                        BeiZiInterstitialActivity.this.startActivity(intent);
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        try {
            VideoView videoView = this.f11495w;
            if (videoView != null && this.B) {
                videoView.resume();
            }
            e eVar = this.Q;
            if (eVar != null) {
                eVar.a();
            }
            com.beizi.ad.a.a.a aVar = this.S;
            if (aVar != null) {
                aVar.a();
            }
            if (!this.I && this.F && this.G > 0) {
                g();
            }
            this.I = false;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        try {
            if (this.O == null) {
                return;
            }
            z();
            v();
            w();
            x();
            y();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void v() {
        try {
            AdSpacesBean.BuyerBean buyerBean = this.O;
            if (buyerBean == null) {
                return;
            }
            AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickView = buyerBean.getRegionalClickView();
            if (regionalClickView == null) {
                regionalClickView = new AdSpacesBean.BuyerBean.RegionalClickViewBean();
                regionalClickView.setBackgroundAlpha(1.0d);
                regionalClickView.setBackgroundColor("#3976FF");
                regionalClickView.setTitle("点击跳转网页或第三方应用");
                regionalClickView.setTitleColor("#FFFFFF");
            }
            com.beizi.ad.a.a.c cVar = new com.beizi.ad.a.a.c(this, regionalClickView, this.N, this.X);
            this.P = cVar;
            if (this.f11498z) {
                cVar.a(this.f11488p);
            } else {
                cVar.a(this.f11487o);
            }
            this.P.a(new c.a() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.6
                @Override // com.beizi.ad.a.a.c.a
                public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
                    m.a("BeiZisAd", "handleRegionalClickViewContent click");
                    BeiZiInterstitialActivity.this.a(str, str2, str3, str4, str5, str6, str7, str8, 0);
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void w() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView;
        try {
            if (this.O == null || com.beizi.fusion.c.b.a().n() || (shakeView = this.O.getShakeView()) == null) {
                return;
            }
            e eVar = new e(this, shakeView, this.O.getSpaceId(), this.N);
            this.Q = eVar;
            if (this.f11498z) {
                eVar.a(this.f11488p);
            } else {
                eVar.a(this.f11487o);
            }
            this.Q.a(new e.a() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.7
                @Override // com.beizi.ad.a.a.e.a
                public void a() {
                    m.a("BeiZisAd", "handleShakeViewContent click");
                    BeiZiInterstitialActivity.this.a("", "", "", "", "", "", "", "", 2);
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void x() {
        AdSpacesBean.BuyerBean.ScrollClickBean scrollClick;
        try {
            AdSpacesBean.BuyerBean buyerBean = this.O;
            if (buyerBean == null || (scrollClick = buyerBean.getScrollClick()) == null) {
                return;
            }
            com.beizi.ad.a.a.d dVar = new com.beizi.ad.a.a.d(this, scrollClick, this.O.getSpaceId(), this.N);
            this.R = dVar;
            if (this.f11498z) {
                dVar.a(this.f11488p);
            } else {
                dVar.a(this.f11487o);
            }
            this.R.a(this.f11483k, new d.a() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.8
                @Override // com.beizi.ad.a.a.d.a
                public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
                    m.a("BeiZisAd", "handleScrollViewContent scroll");
                    BeiZiInterstitialActivity.this.a(str, str2, str3, str4, str5, str6, str7, str8, 1);
                }

                @Override // com.beizi.ad.a.a.d.a
                public void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
                    if (BeiZiInterstitialActivity.this.T == null || !BeiZiInterstitialActivity.this.T.a()) {
                        return;
                    }
                    m.a("BeiZisAd", "handleScrollViewContent scroll click");
                    BeiZiInterstitialActivity.this.a(str, str2, str3, str4, str5, str6, str7, str8, 0);
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void y() {
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule;
        try {
            if (this.O == null || com.beizi.fusion.c.b.a().n() || (eulerAngleRule = this.O.getEulerAngleRule()) == null) {
                return;
            }
            com.beizi.ad.a.a.a aVar = new com.beizi.ad.a.a.a(this, eulerAngleRule, this.O.getSpaceId(), this.N);
            this.S = aVar;
            if (this.f11498z) {
                aVar.a(this.f11488p);
            } else {
                aVar.a(this.f11487o);
            }
            this.S.a(new a.InterfaceC0102a() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.9
                @Override // com.beizi.ad.a.a.a.InterfaceC0102a
                public void a() {
                    m.a("BeiZisAd", "handleEulerAngleViewContent click");
                    BeiZiInterstitialActivity.this.a("", "", "", "", "", "", "", "", 2);
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void z() {
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClick;
        try {
            AdSpacesBean.BuyerBean buyerBean = this.O;
            if (buyerBean == null || (fullScreenClick = buyerBean.getFullScreenClick()) == null) {
                return;
            }
            com.beizi.ad.a.a.b bVar = new com.beizi.ad.a.a.b(this, fullScreenClick, this.N);
            this.T = bVar;
            bVar.a(this.f11483k, new b.a() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.10
                @Override // com.beizi.ad.a.a.b.a
                public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
                    m.a("BeiZisAd", "handleFullScreenClickContent click");
                    BeiZiInterstitialActivity.this.a(str, str2, str3, str4, str5, str6, str7, str8, 0);
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void b() {
        this.f11483k = (RelativeLayout) findViewById(R.id.beizi_interstitial_ad_content_rl);
        this.f11475c = (LinearLayout) findViewById(R.id.beizi_interstitial_ad_container_ll);
        this.f11478f = (TextView) findViewById(R.id.beizi_interstitial_ad_complain_tv);
        this.f11484l = (RelativeLayout) findViewById(R.id.beizi_interstitial_ad_close_container_rl);
        this.f11476d = (LinearLayout) findViewById(R.id.beizi_interstitial_ad_close_text_container_ll);
        this.f11493u = (ImageView) findViewById(R.id.beizi_interstitial_ad_close_iv);
        this.f11479g = (TextView) findViewById(R.id.beizi_interstitial_ad_countdown_tv);
        this.f11485m = (RelativeLayout) findViewById(R.id.beizi_interstitial_ad_material_container_rl);
        this.f11486n = (RelativeLayout) findViewById(R.id.beizi_interstitial_ad_video_replay_container_rl);
        this.f11494v = (ImageView) findViewById(R.id.beizi_interstitial_ad_video_replay_iv);
        this.f11489q = (FrameLayout) findViewById(R.id.beizi_interstitial_ad_logo_container_fl);
        this.f11490r = (CustomRoundImageView) findViewById(R.id.beizi_interstitial_ad_img_iv);
        this.f11495w = (VideoView) findViewById(R.id.beizi_interstitial_ad_video_vv);
        this.f11491s = (CustomRoundImageView) findViewById(R.id.beizi_interstitial_ad_app_icon_iv);
        this.f11496x = findViewById(R.id.beizi_interstitial_ad_divide_view);
        this.f11492t = (ImageView) findViewById(R.id.beizi_interstitial_ad_voice_iv);
        this.f11477e = (LinearLayout) findViewById(R.id.beizi_interstitial_ad_title_container_ll);
        this.f11481i = (TextView) findViewById(R.id.beizi_interstitial_ad_title_tv);
        this.f11482j = (TextView) findViewById(R.id.beizi_interstitial_ad_subtitle_tv);
        this.f11497y = findViewById(R.id.beizi_interstitial_ad_title_divider_view);
        this.f11488p = (RelativeLayout) findViewById(R.id.beizi_interstitial_ad_interaction_container_landscape_rl);
        this.f11487o = (RelativeLayout) findViewById(R.id.beizi_interstitial_ad_interaction_container_portrait_rl);
        this.f11480h = (TextView) findViewById(R.id.beizi_interstitial_ad_app_download_info_tv);
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.activity_beizi_interstitial);
            b();
            c();
            d();
            i();
            k();
            h();
            m();
            f();
            l();
            p();
            s();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        try {
            com.beizi.ad.a.a.c cVar = this.P;
            if (cVar != null) {
                cVar.b();
            }
            this.P = null;
            e eVar = this.Q;
            if (eVar != null) {
                eVar.d();
            }
            this.Q = null;
            com.beizi.ad.a.a.a aVar = this.S;
            if (aVar != null) {
                aVar.d();
            }
            this.S = null;
            com.beizi.ad.a.a.d dVar = this.R;
            if (dVar != null) {
                dVar.a();
            }
            this.R = null;
            com.beizi.ad.a.a.b bVar = this.T;
            if (bVar != null) {
                bVar.b();
            }
            this.T = null;
            Timer timer = this.V;
            if (timer != null) {
                timer.cancel();
            }
            this.V = null;
            TimerTask timerTask = this.W;
            if (timerTask != null) {
                timerTask.cancel();
            }
            this.W = null;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        A();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i6) {
        com.beizi.ad.internal.c.a aVar;
        com.beizi.ad.internal.f.c cVar;
        com.beizi.ad.internal.c d6;
        try {
            if (this.f11473a == null || !hasWindowFocus() || (cVar = (aVar = this.f11473a).f11686a) == null || (d6 = aVar.d()) == null) {
                return;
            }
            com.beizi.ad.model.d dVar = new com.beizi.ad.model.d();
            dVar.a(str);
            dVar.e(str5);
            dVar.b(str2);
            dVar.f(str6);
            dVar.c(str3);
            dVar.g(str7);
            dVar.d(str4);
            dVar.h(str8);
            cVar.a(true);
            cVar.a(this.f11475c, dVar, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() + 10), this.D, this.f11473a.c().a(), i6);
            this.D = true;
            d6.d();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void a() {
        try {
            if (this.V == null) {
                this.V = new Timer();
            }
            if (this.W == null) {
                this.W = new TimerTask() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.11
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        try {
                            if (BeiZiInterstitialActivity.this.f11495w == null || !BeiZiInterstitialActivity.this.f11495w.isPlaying()) {
                                return;
                            }
                            BeiZiInterstitialActivity.this.runOnUiThread(new Runnable() { // from class: com.beizi.ad.internal.activity.BeiZiInterstitialActivity.11.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    int duration;
                                    try {
                                        if (BeiZiInterstitialActivity.this.f11479g == null || (duration = (BeiZiInterstitialActivity.this.f11495w.getDuration() - BeiZiInterstitialActivity.this.f11495w.getCurrentPosition()) / 1000) <= 0) {
                                            return;
                                        }
                                        BeiZiInterstitialActivity.this.f11479g.setText(String.valueOf(duration));
                                    } catch (Exception e6) {
                                        e6.printStackTrace();
                                    }
                                }
                            });
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                };
            }
            this.V.scheduleAtFixedRate(this.W, 0L, 1000L);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
