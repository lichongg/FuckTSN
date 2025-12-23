package com.beizi.ad.internal.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.Nullable;
import com.beizi.ad.a.a.a;
import com.beizi.ad.a.a.b;
import com.beizi.ad.a.a.c;
import com.beizi.ad.a.a.e;
import com.beizi.ad.internal.h.i;
import com.beizi.ad.internal.h.j;
import com.beizi.ad.internal.h.n;
import com.beizi.ad.internal.h.u;
import com.beizi.ad.internal.view.CustomRoundImageView;
import com.beizi.ad.internal.view.a.a;
import com.beizi.ad.lance.a.m;
import com.beizi.ad.lance.a.q;
import com.beizi.ad.model.c;
import com.beizi.fusion.R;
import com.beizi.fusion.model.AdSpacesBean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BeiZiRewardVideoActivity extends Activity {
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private TextView N;
    private TextView O;
    private FrameLayout P;
    private FrameLayout Q;
    private CustomRoundImageView R;
    private CustomRoundImageView S;
    private CustomRoundImageView T;
    private VideoView U;
    private ProgressBar V;
    private boolean X;

    /* renamed from: a, reason: collision with root package name */
    private com.beizi.ad.internal.g.a f11523a;
    private int aA;
    private int aH;
    private boolean aI;
    private boolean aJ;
    private boolean aK;
    private boolean aL;
    private String aM;
    private int aN;
    private boolean aO;
    private boolean aP;
    private boolean aQ;
    private boolean aR;
    private boolean aS;
    private boolean aT;
    private int aa;
    private boolean ab;
    private MediaPlayer ac;
    private int ae;
    private boolean af;
    private int ag;
    private String ai;
    private String aj;
    private String ak;
    private String al;
    private String am;
    private AdSpacesBean.BuyerBean an;
    private com.beizi.ad.a.a.c ao;
    private e ap;
    private com.beizi.ad.a.a.d aq;
    private com.beizi.ad.a.a.a ar;
    private com.beizi.ad.a.a.b as;
    private boolean au;
    private String av;
    private String aw;
    private String ax;
    private long ay;

    /* renamed from: b, reason: collision with root package name */
    private com.beizi.ad.internal.f.c f11524b;

    /* renamed from: c, reason: collision with root package name */
    private RelativeLayout f11525c;

    /* renamed from: d, reason: collision with root package name */
    private RelativeLayout f11526d;

    /* renamed from: e, reason: collision with root package name */
    private RelativeLayout f11527e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f11528f;

    /* renamed from: g, reason: collision with root package name */
    private LinearLayout f11529g;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f11530h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f11531i;

    /* renamed from: j, reason: collision with root package name */
    private LinearLayout f11532j;

    /* renamed from: k, reason: collision with root package name */
    private LinearLayout f11533k;

    /* renamed from: l, reason: collision with root package name */
    private LinearLayout f11534l;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f11535m;

    /* renamed from: n, reason: collision with root package name */
    private LinearLayout f11536n;

    /* renamed from: o, reason: collision with root package name */
    private View f11537o;

    /* renamed from: p, reason: collision with root package name */
    private ImageView f11538p;

    /* renamed from: q, reason: collision with root package name */
    private ImageView f11539q;

    /* renamed from: r, reason: collision with root package name */
    private ImageView f11540r;

    /* renamed from: s, reason: collision with root package name */
    private ImageView f11541s;

    /* renamed from: t, reason: collision with root package name */
    private ImageView f11542t;

    /* renamed from: u, reason: collision with root package name */
    private ImageView f11543u;

    /* renamed from: v, reason: collision with root package name */
    private TextView f11544v;

    /* renamed from: w, reason: collision with root package name */
    private TextView f11545w;

    /* renamed from: x, reason: collision with root package name */
    private TextView f11546x;

    /* renamed from: y, reason: collision with root package name */
    private TextView f11547y;

    /* renamed from: z, reason: collision with root package name */
    private TextView f11548z;
    private boolean W = false;
    private boolean Y = false;
    private int Z = 30;
    private boolean ad = false;
    private boolean ah = true;
    private boolean at = true;
    private boolean az = false;
    private int aB = 1;
    private int aC = 2;
    private int aD = 5;
    private int aE = 15;
    private int aF = 15;
    private int aG = 10;
    private Handler aU = new Handler(Looper.getMainLooper()) { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i6;
            super.handleMessage(message);
            try {
                if (message.what == 10010) {
                    BeiZiRewardVideoActivity.this.aU.sendEmptyMessageDelayed(10010, 1000L);
                    BeiZiRewardVideoActivity.this.y();
                    if (BeiZiRewardVideoActivity.this.U != null && BeiZiRewardVideoActivity.this.U.isPlaying()) {
                        int duration = BeiZiRewardVideoActivity.this.U.getDuration();
                        int currentPosition = BeiZiRewardVideoActivity.this.U.getCurrentPosition();
                        BeiZiRewardVideoActivity.this.c(currentPosition);
                        if (BeiZiRewardVideoActivity.this.aA == BeiZiRewardVideoActivity.this.aB) {
                            i6 = ((BeiZiRewardVideoActivity.this.aD * 1000) - currentPosition) / 1000;
                        } else {
                            i6 = ((BeiZiRewardVideoActivity.this.Z * 1000) - currentPosition) / 1000;
                        }
                        BeiZiRewardVideoActivity beiZiRewardVideoActivity = BeiZiRewardVideoActivity.this;
                        beiZiRewardVideoActivity.aa = ((beiZiRewardVideoActivity.Z * 1000) - currentPosition) / 1000;
                        BeiZiRewardVideoActivity.this.b(i6);
                        if ((BeiZiRewardVideoActivity.this.aD * 1000) - currentPosition < 0 && BeiZiRewardVideoActivity.this.aA == BeiZiRewardVideoActivity.this.aC && !BeiZiRewardVideoActivity.this.aI) {
                            BeiZiRewardVideoActivity.this.x();
                        }
                        BeiZiRewardVideoActivity.this.a(duration, currentPosition);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        if (i6 == 4 || i6 == 3) {
            return true;
        }
        return super.onKeyDown(i6, keyEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0060, code lost:
    
        if (r0 > (r5.aF * 1000)) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0074 A[Catch: Exception -> 0x0022, TryCatch #0 {Exception -> 0x0022, blocks: (B:2:0x0000, B:7:0x0006, B:11:0x000c, B:15:0x0012, B:19:0x0018, B:21:0x001c, B:25:0x0025, B:29:0x002f, B:31:0x0035, B:34:0x0039, B:36:0x0046, B:40:0x004b, B:43:0x0062, B:45:0x006c, B:47:0x0074, B:48:0x0079, B:50:0x0086, B:51:0x0089, B:53:0x008d, B:54:0x00a3, B:56:0x00a7, B:57:0x00ac, B:59:0x00b0, B:62:0x0055, B:64:0x0059), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0086 A[Catch: Exception -> 0x0022, TryCatch #0 {Exception -> 0x0022, blocks: (B:2:0x0000, B:7:0x0006, B:11:0x000c, B:15:0x0012, B:19:0x0018, B:21:0x001c, B:25:0x0025, B:29:0x002f, B:31:0x0035, B:34:0x0039, B:36:0x0046, B:40:0x004b, B:43:0x0062, B:45:0x006c, B:47:0x0074, B:48:0x0079, B:50:0x0086, B:51:0x0089, B:53:0x008d, B:54:0x00a3, B:56:0x00a7, B:57:0x00ac, B:59:0x00b0, B:62:0x0055, B:64:0x0059), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008d A[Catch: Exception -> 0x0022, TryCatch #0 {Exception -> 0x0022, blocks: (B:2:0x0000, B:7:0x0006, B:11:0x000c, B:15:0x0012, B:19:0x0018, B:21:0x001c, B:25:0x0025, B:29:0x002f, B:31:0x0035, B:34:0x0039, B:36:0x0046, B:40:0x004b, B:43:0x0062, B:45:0x006c, B:47:0x0074, B:48:0x0079, B:50:0x0086, B:51:0x0089, B:53:0x008d, B:54:0x00a3, B:56:0x00a7, B:57:0x00ac, B:59:0x00b0, B:62:0x0055, B:64:0x0059), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a7 A[Catch: Exception -> 0x0022, TryCatch #0 {Exception -> 0x0022, blocks: (B:2:0x0000, B:7:0x0006, B:11:0x000c, B:15:0x0012, B:19:0x0018, B:21:0x001c, B:25:0x0025, B:29:0x002f, B:31:0x0035, B:34:0x0039, B:36:0x0046, B:40:0x004b, B:43:0x0062, B:45:0x006c, B:47:0x0074, B:48:0x0079, B:50:0x0086, B:51:0x0089, B:53:0x008d, B:54:0x00a3, B:56:0x00a7, B:57:0x00ac, B:59:0x00b0, B:62:0x0055, B:64:0x0059), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b0 A[Catch: Exception -> 0x0022, TRY_LEAVE, TryCatch #0 {Exception -> 0x0022, blocks: (B:2:0x0000, B:7:0x0006, B:11:0x000c, B:15:0x0012, B:19:0x0018, B:21:0x001c, B:25:0x0025, B:29:0x002f, B:31:0x0035, B:34:0x0039, B:36:0x0046, B:40:0x004b, B:43:0x0062, B:45:0x006c, B:47:0x0074, B:48:0x0079, B:50:0x0086, B:51:0x0089, B:53:0x008d, B:54:0x00a3, B:56:0x00a7, B:57:0x00ac, B:59:0x00b0, B:62:0x0055, B:64:0x0059), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A() {
        /*
            r5 = this;
            boolean r0 = r5.ah     // Catch: java.lang.Exception -> L22
            if (r0 == 0) goto L6
            goto Lb5
        L6:
            boolean r0 = r5.ad     // Catch: java.lang.Exception -> L22
            if (r0 != 0) goto Lc
            goto Lb5
        Lc:
            boolean r0 = r5.aP     // Catch: java.lang.Exception -> L22
            if (r0 == 0) goto L12
            goto Lb5
        L12:
            boolean r0 = r5.aQ     // Catch: java.lang.Exception -> L22
            if (r0 == 0) goto L18
            goto Lb5
        L18:
            int r0 = r5.aE     // Catch: java.lang.Exception -> L22
            if (r0 <= 0) goto L25
            boolean r0 = r5.aJ     // Catch: java.lang.Exception -> L22
            if (r0 != 0) goto L25
            goto Lb5
        L22:
            r0 = move-exception
            goto Lb6
        L25:
            long r0 = r5.ay     // Catch: java.lang.Exception -> L22
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L2f
            goto Lb5
        L2f:
            int r0 = r5.aA     // Catch: java.lang.Exception -> L22
            int r1 = r5.aB     // Catch: java.lang.Exception -> L22
            if (r0 == r1) goto L39
            int r1 = r5.aC     // Catch: java.lang.Exception -> L22
            if (r0 != r1) goto Lb5
        L39:
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L22
            long r2 = r5.ay     // Catch: java.lang.Exception -> L22
            long r0 = r0 - r2
            int r2 = r5.aA     // Catch: java.lang.Exception -> L22
            int r3 = r5.aB     // Catch: java.lang.Exception -> L22
            if (r2 != r3) goto L55
            boolean r2 = r5.aK     // Catch: java.lang.Exception -> L22
            if (r2 != 0) goto L4b
            goto Lb5
        L4b:
            int r2 = r5.aF     // Catch: java.lang.Exception -> L22
            int r2 = r2 * 1000
            long r2 = (long) r2     // Catch: java.lang.Exception -> L22
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L6c
            goto L62
        L55:
            int r3 = r5.aC     // Catch: java.lang.Exception -> L22
            if (r2 != r3) goto L6c
            int r2 = r5.aF     // Catch: java.lang.Exception -> L22
            int r2 = r2 * 1000
            long r2 = (long) r2     // Catch: java.lang.Exception -> L22
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L6c
        L62:
            r5.p()     // Catch: java.lang.Exception -> L22
            r5.z()     // Catch: java.lang.Exception -> L22
            r5.f()     // Catch: java.lang.Exception -> L22
            return
        L6c:
            r2 = -999(0xfffffffffffffc19, float:NaN)
            r5.aH = r2     // Catch: java.lang.Exception -> L22
            android.widget.TextView r2 = r5.H     // Catch: java.lang.Exception -> L22
            if (r2 == 0) goto L79
            java.lang.String r3 = "浏览时间不足，无法提前获取奖励"
            r2.setText(r3)     // Catch: java.lang.Exception -> L22
        L79:
            int r2 = r5.aF     // Catch: java.lang.Exception -> L22
            int r2 = r2 * 1000
            long r2 = (long) r2     // Catch: java.lang.Exception -> L22
            long r2 = r2 - r0
            int r0 = (int) r2     // Catch: java.lang.Exception -> L22
            int r0 = r0 / 1000
            r5.aF = r0     // Catch: java.lang.Exception -> L22
            if (r0 != 0) goto L89
            r0 = 1
            r5.aF = r0     // Catch: java.lang.Exception -> L22
        L89:
            android.widget.TextView r0 = r5.D     // Catch: java.lang.Exception -> L22
            if (r0 == 0) goto La3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L22
            r1.<init>()     // Catch: java.lang.Exception -> L22
            int r2 = r5.aF     // Catch: java.lang.Exception -> L22
            r1.append(r2)     // Catch: java.lang.Exception -> L22
            java.lang.String r2 = "秒"
            r1.append(r2)     // Catch: java.lang.Exception -> L22
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L22
            r0.setText(r1)     // Catch: java.lang.Exception -> L22
        La3:
            android.widget.TextView r0 = r5.E     // Catch: java.lang.Exception -> L22
            if (r0 == 0) goto Lac
            java.lang.String r1 = "继续体验内容"
            r0.setText(r1)     // Catch: java.lang.Exception -> L22
        Lac:
            android.widget.TextView r0 = r5.J     // Catch: java.lang.Exception -> L22
            if (r0 == 0) goto Lb5
            java.lang.String r1 = "继续体验，提前获取奖励"
            r0.setText(r1)     // Catch: java.lang.Exception -> L22
        Lb5:
            return
        Lb6:
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.A():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        try {
            if (this.f11527e == null) {
                return;
            }
            if (this.aL) {
                f();
                return;
            }
            this.aP = true;
            C();
            this.f11527e.setVisibility(0);
            TextView textView = this.L;
            if (textView != null && this.f11544v != null && this.aa > 0) {
                textView.setText("仅需" + this.aa + "秒即可获得奖励");
            }
            TextView textView2 = this.M;
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        try {
                            BeiZiRewardVideoActivity.this.aP = false;
                            if (BeiZiRewardVideoActivity.this.f11527e != null) {
                                BeiZiRewardVideoActivity.this.f11527e.setVisibility(8);
                            }
                            BeiZiRewardVideoActivity.this.r();
                            BeiZiRewardVideoActivity.this.h();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                });
            }
            TextView textView3 = this.N;
            if (textView3 != null) {
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.16
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BeiZiRewardVideoActivity.this.aP = false;
                        BeiZiRewardVideoActivity.this.n();
                    }
                });
            }
            this.f11527e.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void C() {
        try {
            VideoView videoView = this.U;
            if (videoView != null && this.ab) {
                this.ae = videoView.getCurrentPosition();
                i();
            }
            e eVar = this.ap;
            if (eVar != null) {
                eVar.b();
            }
            com.beizi.ad.a.a.a aVar = this.ar;
            if (aVar != null) {
                aVar.b();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void D() {
        Handler handler = this.aU;
        if (handler != null) {
            handler.removeMessages(10010);
        }
        this.aU = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        com.beizi.ad.internal.f.c cVar;
        try {
            com.beizi.ad.internal.g.a aVar = this.f11523a;
            if (aVar == null || (cVar = aVar.f11963a) == null) {
                return;
            }
            com.beizi.ad.internal.e d6 = aVar.d();
            cVar.b(this.f11525c, d6 != null ? d6.a() : null);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        com.beizi.ad.internal.f.c cVar;
        try {
            com.beizi.ad.internal.g.a aVar = this.f11523a;
            if (aVar == null || (cVar = aVar.f11963a) == null) {
                return;
            }
            com.beizi.ad.internal.e d6 = aVar.d();
            cVar.f(this.f11525c, d6 != null ? d6.a() : null);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        MediaPlayer mediaPlayer;
        try {
            if (this.U != null && this.ab && !this.aJ && !this.aP && !this.aQ) {
                int i6 = this.ae;
                if (i6 > 0 && (mediaPlayer = this.ac) != null && Build.VERSION.SDK_INT >= 26) {
                    mediaPlayer.seekTo(i6, 3);
                }
                this.U.start();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void i() {
        VideoView videoView = this.U;
        if (videoView == null) {
            return;
        }
        videoView.pause();
    }

    private String j() {
        com.beizi.ad.internal.g.a aVar = this.f11523a;
        if (aVar == null) {
            return null;
        }
        return aVar.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        try {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout a6 = u.a(this, this.f11524b.A());
            a6.setVisibility(0);
            linearLayout.addView(a6, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            View b6 = u.b(this, this.f11524b.z());
            b6.setVisibility(0);
            linearLayout.addView(b6, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b6.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            b6.setLayoutParams(layoutParams);
            if (this.P != null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 85);
                int a7 = u.a((Context) this, 8.0f);
                layoutParams2.setMargins(0, 0, a7, a7);
                this.P.addView(linearLayout, layoutParams2);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void l() {
        try {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout a6 = u.a(this, this.f11524b.A());
            a6.setVisibility(0);
            linearLayout.addView(a6, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            View b6 = u.b(this, this.f11524b.z());
            b6.setVisibility(0);
            linearLayout.addView(b6, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b6.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            b6.setLayoutParams(layoutParams);
            if (this.Q != null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 85);
                layoutParams2.setMargins(0, 0, u.a((Context) this, 12.0f), u.a((Context) this, 30.0f));
                this.Q.addView(linearLayout, layoutParams2);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void m() {
        TextView textView = this.f11545w;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        if (BeiZiRewardVideoActivity.this.f11545w != null && "关闭".equals(BeiZiRewardVideoActivity.this.f11545w.getText().toString())) {
                            BeiZiRewardVideoActivity.this.n();
                        } else {
                            if (BeiZiRewardVideoActivity.this.aO) {
                                return;
                            }
                            BeiZiRewardVideoActivity.this.B();
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            });
        }
        ImageView imageView = this.f11538p;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        if (BeiZiRewardVideoActivity.this.Y) {
                            BeiZiRewardVideoActivity.this.f11538p.setImageResource(R.drawable.voice_off);
                            if (BeiZiRewardVideoActivity.this.ac != null) {
                                BeiZiRewardVideoActivity.this.ac.setVolume(0.0f, 0.0f);
                            }
                        } else {
                            BeiZiRewardVideoActivity.this.f11538p.setImageResource(R.drawable.voice_on);
                            if (BeiZiRewardVideoActivity.this.ac != null) {
                                BeiZiRewardVideoActivity.this.ac.setVolume(0.0f, 1.0f);
                            }
                        }
                        BeiZiRewardVideoActivity.this.Y = !r3.Y;
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        Handler handler = this.aU;
        if (handler != null) {
            handler.removeCallbacks(null);
        }
        com.beizi.ad.internal.g.a aVar = this.f11523a;
        if (aVar != null && aVar.g() != null) {
            this.f11523a.g().b();
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        com.beizi.ad.internal.f.c cVar;
        com.beizi.ad.internal.c g6;
        try {
            com.beizi.ad.internal.g.a aVar = this.f11523a;
            if (aVar == null || (cVar = aVar.f11963a) == null || (g6 = aVar.g()) == null) {
                return;
            }
            com.beizi.ad.internal.e d6 = this.f11523a.d();
            cVar.a(this.f11525c, d6 != null ? d6.a() : null);
            g6.a();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        com.beizi.ad.internal.g.a aVar;
        com.beizi.ad.internal.c g6;
        try {
            if (this.aL || (aVar = this.f11523a) == null || aVar.f11963a == null || (g6 = aVar.g()) == null) {
                return;
            }
            this.aL = true;
            g6.a((String) null, 0);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void q() {
        try {
            com.beizi.ad.internal.f.c cVar = this.f11524b;
            if (cVar == null) {
                return;
            }
            int I = cVar.I();
            if (I != 2 && I != 5) {
                return;
            }
            this.K.setVisibility(0);
            final String B = this.f11524b.B();
            String D = this.f11524b.D();
            String C = this.f11524b.C();
            String F = this.f11524b.F();
            final String E = !TextUtils.isEmpty(F) ? F : this.f11524b.E();
            final String G = this.f11524b.G();
            final String H = this.f11524b.H();
            this.K.setText(Html.fromHtml("应用名称：" + B + " | 开发者：" + D + " | 应用版本：" + C + " | <u>权限详情</u> | <u>隐私协议</u> | <u>功能介绍</u>"));
            this.K.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        Intent intent = new Intent(BeiZiRewardVideoActivity.this, (Class<?>) DownloadAppInfoActivity.class);
                        intent.putExtra("title_content_key", B);
                        intent.putExtra("privacy_content_key", G);
                        intent.putExtra("permission_content_key", E);
                        intent.putExtra("intro_content_key", H);
                        intent.setFlags(268435456);
                        BeiZiRewardVideoActivity.this.startActivity(intent);
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
    public void r() {
        try {
            e eVar = this.ap;
            if (eVar != null) {
                eVar.a();
            }
            com.beizi.ad.a.a.a aVar = this.ar;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        try {
            if (this.an == null) {
                return;
            }
            LinearLayout linearLayout = this.f11530h;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            w();
            t();
            u();
            v();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void t() {
        try {
            AdSpacesBean.BuyerBean buyerBean = this.an;
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
            this.av = regionalClickView.getTitle();
            com.beizi.ad.a.a.c cVar = new com.beizi.ad.a.a.c(this, regionalClickView, this.am, this.au);
            this.ao = cVar;
            String a6 = cVar.a();
            if (TextUtils.isEmpty(a6)) {
                a6 = "#3976FF";
            }
            LinearLayout linearLayout = this.f11530h;
            if (linearLayout != null) {
                n.a(linearLayout, a6, 0, (String) null, u.a((Context) this, 5.0f));
                this.ao.a(this.f11530h, this.f11548z);
                this.ao.a(new c.a() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.5
                    @Override // com.beizi.ad.a.a.c.a
                    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
                        m.a("BeiZisAd", "handleRegionalClickViewContent click");
                        BeiZiRewardVideoActivity.this.a(str, str2, str3, str4, str5, str6, str7, str8, 0);
                    }
                });
            }
            LinearLayout linearLayout2 = this.f11531i;
            if (linearLayout2 != null) {
                n.a(linearLayout2, "#3976FF", 0, (String) null, u.a((Context) this, 25.0f));
            }
            LinearLayout linearLayout3 = this.f11535m;
            if (linearLayout3 != null) {
                n.a(linearLayout3, "#2A8BEF", 0, (String) null, u.a((Context) this, 25.0f));
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void u() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView;
        try {
            if (this.an == null || com.beizi.fusion.c.b.a().n() || (shakeView = this.an.getShakeView()) == null) {
                return;
            }
            e eVar = new e(this, shakeView, this.an.getSpaceId(), this.am);
            this.ap = eVar;
            eVar.a(new e.a() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.6
                @Override // com.beizi.ad.a.a.e.a
                public void a() {
                    m.a("BeiZisAd", "handleShakeViewContent click");
                    BeiZiRewardVideoActivity.this.a("", "", "", "", "", "", "", "", 2);
                }
            });
            this.ax = "shake";
            this.aw = this.ap.c();
            a(this.f11540r);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void v() {
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule;
        try {
            if (this.an == null || com.beizi.fusion.c.b.a().n() || (eulerAngleRule = this.an.getEulerAngleRule()) == null) {
                return;
            }
            com.beizi.ad.a.a.a aVar = new com.beizi.ad.a.a.a(this, eulerAngleRule, this.an.getSpaceId(), this.am);
            this.ar = aVar;
            aVar.a(new a.InterfaceC0102a() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.7
                @Override // com.beizi.ad.a.a.a.InterfaceC0102a
                public void a() {
                    m.a("BeiZisAd", "handleEulerAngleViewContent click");
                    BeiZiRewardVideoActivity.this.a("", "", "", "", "", "", "", "", 2);
                }
            });
            this.ax = "eulerAngle";
            this.aw = this.ar.c();
            a(this.f11540r);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void w() {
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClick;
        try {
            AdSpacesBean.BuyerBean buyerBean = this.an;
            if (buyerBean == null || (fullScreenClick = buyerBean.getFullScreenClick()) == null) {
                return;
            }
            com.beizi.ad.a.a.b bVar = new com.beizi.ad.a.a.b(this, fullScreenClick, this.am);
            this.as = bVar;
            bVar.a(this.f11525c, new b.a() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.8
                @Override // com.beizi.ad.a.a.b.a
                public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
                    m.a("BeiZisAd", "handleFullScreenClickContent click");
                    BeiZiRewardVideoActivity.this.a(str, str2, str3, str4, str5, str6, str7, str8, 0);
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        try {
            LinearLayout linearLayout = this.f11532j;
            if (linearLayout == null) {
                return;
            }
            this.aI = true;
            this.aJ = true;
            linearLayout.setVisibility(0);
            this.f11532j.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
            TextView textView = this.E;
            if (textView != null) {
                textView.setText("打开并体验内容");
            }
            TextView textView2 = this.D;
            if (textView2 != null && this.aF > 0) {
                textView2.setText(this.aF + "秒");
            }
            i();
            if (this.f11534l != null) {
                if (TextUtils.isEmpty(this.ai) && TextUtils.isEmpty(this.aj) && TextUtils.isEmpty(this.ak)) {
                    this.f11534l.setVisibility(8);
                } else {
                    this.f11534l.setVisibility(0);
                }
            }
            a(this.T, 47);
            a(this.F, this.G);
            a(this.f11543u);
            a(this.f11535m);
            TextView textView3 = this.I;
            if (textView3 != null) {
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BeiZiRewardVideoActivity beiZiRewardVideoActivity = BeiZiRewardVideoActivity.this;
                        beiZiRewardVideoActivity.aF = beiZiRewardVideoActivity.aE;
                        BeiZiRewardVideoActivity.this.z();
                        if (BeiZiRewardVideoActivity.this.az) {
                            BeiZiRewardVideoActivity.this.h();
                        }
                        BeiZiRewardVideoActivity beiZiRewardVideoActivity2 = BeiZiRewardVideoActivity.this;
                        beiZiRewardVideoActivity2.a(beiZiRewardVideoActivity2.f11540r);
                    }
                });
            }
            if (this.aA == this.aB) {
                TextView textView4 = this.H;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                    this.H.setText("浏览时间不足，无法提前获取奖励");
                    return;
                }
                return;
            }
            TextView textView5 = this.H;
            if (textView5 != null) {
                textView5.setVisibility(0);
                this.H.setText(this.aH + "秒后继续播放视频");
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        int i6;
        try {
            if (this.aA == this.aC && this.aJ && this.az && !this.aP && (i6 = this.aH) != -999) {
                if (i6 > 0) {
                    TextView textView = this.H;
                    if (textView != null) {
                        textView.setText(this.aH + "秒后继续播放视频");
                    }
                    this.aH--;
                    return;
                }
                if (i6 == 0) {
                    this.aJ = false;
                    z();
                    if (this.az) {
                        h();
                    }
                    a(this.f11540r);
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        this.aJ = false;
        LinearLayout linearLayout = this.f11532j;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            C();
            a.C0116a c0116a = new a.C0116a(this);
            c0116a.a(new a.b() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.18
                @Override // com.beizi.ad.internal.view.a.a.b
                public void a(String str) {
                    try {
                        com.beizi.ad.internal.c g6 = BeiZiRewardVideoActivity.this.f11523a.g();
                        if (g6 == null) {
                            return;
                        }
                        g6.a(str);
                        g6.b();
                        BeiZiRewardVideoActivity.this.finish();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }

                @Override // com.beizi.ad.internal.view.a.a.b
                public void a() {
                    BeiZiRewardVideoActivity.this.r();
                    BeiZiRewardVideoActivity.this.h();
                }
            });
            c0116a.a().show();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        TextView textView;
        try {
            this.aQ = true;
            i();
            ImageView imageView = this.f11538p;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            View view = this.f11537o;
            if (view != null) {
                view.setVisibility(8);
            }
            LinearLayout linearLayout = this.f11529g;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            TextView textView2 = this.f11544v;
            if (textView2 != null) {
                textView2.setText("已获得奖励");
            }
            TextView textView3 = this.f11545w;
            if (textView3 != null) {
                textView3.setText("关闭");
            }
            LinearLayout linearLayout2 = this.f11529g;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            ProgressBar progressBar = this.V;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            RelativeLayout relativeLayout = this.f11526d;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            D();
            if (this.f11541s != null && !TextUtils.isEmpty(this.aM)) {
                i.a(this).a(this.aM, new i.a() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.20
                    @Override // com.beizi.ad.internal.h.i.a
                    public void a() {
                    }

                    @Override // com.beizi.ad.internal.h.i.a
                    public void a(Bitmap bitmap) {
                        try {
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(j.a(BeiZiRewardVideoActivity.this, bitmap, 10.0f));
                            if (BeiZiRewardVideoActivity.this.f11541s == null || bitmap == null) {
                                return;
                            }
                            BeiZiRewardVideoActivity.this.f11541s.setBackground(bitmapDrawable);
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                });
            }
            a(this.S, 89);
            a(this.A, this.B);
            if (!TextUtils.isEmpty(this.av) && (textView = this.C) != null) {
                textView.setText(this.av);
            }
            a(this.f11542t);
            a(this.f11531i);
            FrameLayout frameLayout = this.Q;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
                l();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void g() {
        try {
            if (this.ab && this.U != null && !TextUtils.isEmpty(this.al)) {
                if (this.aA == this.aB) {
                    b(this.aD);
                } else {
                    b(this.Z);
                }
                ImageView imageView = this.f11538p;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    if (this.Y) {
                        this.f11538p.setImageResource(R.drawable.voice_on);
                    } else {
                        this.f11538p.setImageResource(R.drawable.voice_off);
                    }
                }
                this.U.setVisibility(0);
                if (this.X) {
                    m.a("BeiZisAd", "isVideoCacheSuccess: true");
                    a(0);
                } else {
                    m.a("BeiZisAd", "isVideoCacheSuccess: false");
                    this.U.setVideoPath(this.al);
                    this.U.requestFocus();
                }
                this.U.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.21
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        m.a("BeiZisAd", "onCompletion: 播放完成");
                        try {
                            BeiZiRewardVideoActivity.this.aO = true;
                            if (BeiZiRewardVideoActivity.this.V != null) {
                                BeiZiRewardVideoActivity.this.V.setVisibility(8);
                            }
                            BeiZiRewardVideoActivity.this.ae = 0;
                            BeiZiRewardVideoActivity.this.p();
                            BeiZiRewardVideoActivity.this.f();
                            if (mediaPlayer != null) {
                                BeiZiRewardVideoActivity.this.c(mediaPlayer.getDuration());
                            }
                            BeiZiRewardVideoActivity.this.F();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                });
                this.U.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.22
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        try {
                            BeiZiRewardVideoActivity.this.ac = mediaPlayer;
                            if (BeiZiRewardVideoActivity.this.Y) {
                                BeiZiRewardVideoActivity.this.ac.setVolume(0.0f, 1.0f);
                            } else {
                                BeiZiRewardVideoActivity.this.ac.setVolume(0.0f, 0.0f);
                            }
                            BeiZiRewardVideoActivity.this.h();
                            if (BeiZiRewardVideoActivity.this.at) {
                                int duration = mediaPlayer.getDuration() / 1000;
                                if (BeiZiRewardVideoActivity.this.Z > duration) {
                                    BeiZiRewardVideoActivity.this.Z = duration;
                                }
                                BeiZiRewardVideoActivity beiZiRewardVideoActivity = BeiZiRewardVideoActivity.this;
                                beiZiRewardVideoActivity.aa = beiZiRewardVideoActivity.Z;
                                if (BeiZiRewardVideoActivity.this.V != null) {
                                    BeiZiRewardVideoActivity.this.V.setMax(duration);
                                }
                                BeiZiRewardVideoActivity.this.k();
                                BeiZiRewardVideoActivity.this.s();
                                BeiZiRewardVideoActivity.this.o();
                                if (BeiZiRewardVideoActivity.this.aU != null) {
                                    BeiZiRewardVideoActivity.this.aU.sendEmptyMessageDelayed(10010, 1000L);
                                }
                                BeiZiRewardVideoActivity.this.E();
                            }
                            BeiZiRewardVideoActivity.this.at = false;
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                });
                this.U.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.23
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i6, int i7) {
                        if (mediaPlayer == null) {
                            return false;
                        }
                        try {
                            BeiZiRewardVideoActivity.this.a(mediaPlayer.getCurrentPosition());
                            return true;
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            return false;
                        }
                    }
                });
                this.U.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.24
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer, int i6, int i7) {
                        if (mediaPlayer == null || i6 != 701) {
                            return false;
                        }
                        try {
                            BeiZiRewardVideoActivity.this.a(mediaPlayer.getCurrentPosition());
                            return false;
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            return false;
                        }
                    }
                });
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.activity_beizi_reward_video);
            a();
            b();
            c();
            d();
            a(this.R, 55);
            a(this.f11546x, this.f11547y);
            g();
            m();
            q();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        try {
            com.beizi.ad.internal.g.a aVar = this.f11523a;
            if (aVar != null) {
                aVar.b();
            }
            com.beizi.ad.a.a.c cVar = this.ao;
            if (cVar != null) {
                cVar.b();
            }
            this.ao = null;
            e eVar = this.ap;
            if (eVar != null) {
                eVar.d();
            }
            this.ap = null;
            com.beizi.ad.a.a.a aVar2 = this.ar;
            if (aVar2 != null) {
                aVar2.d();
            }
            this.ar = null;
            com.beizi.ad.a.a.d dVar = this.aq;
            if (dVar != null) {
                dVar.a();
            }
            this.aq = null;
            com.beizi.ad.a.a.b bVar = this.as;
            if (bVar != null) {
                bVar.b();
            }
            this.as = null;
            D();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.az = false;
        C();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.az = true;
        r();
        A();
        this.ay = 0L;
        if (this.aL) {
            return;
        }
        VideoView videoView = this.U;
        if (videoView != null && this.ab && !this.aO && !this.aP && !this.aJ && !this.aQ) {
            videoView.resume();
        }
        this.ah = false;
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        int i6 = this.aA;
        if (i6 == this.aB) {
            if (this.aK && this.ad) {
                if (this.aE >= 0) {
                    this.ay = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.ay = 0L;
            return;
        }
        if (i6 == this.aC) {
            if (this.aJ && this.ad) {
                this.ay = System.currentTimeMillis();
                return;
            } else {
                this.ay = 0L;
                return;
            }
        }
        this.ay = 0L;
    }

    private void b() {
        try {
            com.beizi.ad.internal.g.a aVar = com.beizi.ad.internal.g.a.f11962b;
            this.f11523a = aVar;
            this.an = aVar.a();
            this.au = this.f11523a.h();
            this.X = this.f11523a.e();
            AdSpacesBean.BuyerBean buyerBean = this.an;
            if (buyerBean == null) {
                return;
            }
            if (buyerBean.getTemplate() == 1) {
                this.W = true;
            } else {
                this.W = false;
            }
            com.beizi.ad.internal.f.c cVar = this.f11523a.f11963a;
            this.f11524b = cVar;
            if (cVar == null) {
                return;
            }
            this.am = cVar.f();
            boolean N = this.f11524b.N();
            this.ab = N;
            if (N) {
                this.al = this.f11524b.M();
            } else {
                this.al = this.f11524b.L();
            }
            this.aN = this.f11524b.Y();
            this.ai = this.f11524b.O();
            this.af = this.f11524b.n();
            this.ag = this.f11524b.s();
            this.aj = this.f11524b.J();
            this.ak = this.f11524b.K();
            this.Y = !this.f11524b.m();
            int r5 = this.f11524b.r();
            this.Z = r5;
            if (r5 <= 0) {
                this.Z = 30;
            }
            int i6 = this.Z;
            int i7 = this.aN;
            if (i6 > i7) {
                this.Z = i7;
            }
            this.aM = this.f11524b.X();
            c.k Z = this.f11524b.Z();
            if (Z != null) {
                this.aA = Z.a();
                this.aD = Z.b();
                int c6 = Z.c();
                this.aG = c6;
                this.aH = c6;
                int d6 = Z.d();
                this.aE = d6;
                this.aF = d6;
            }
            this.aa = this.Z;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void c() {
        try {
            int a6 = u.a((Context) this, 15.0f);
            int a7 = u.a((Context) this, 30.0f);
            ImageView imageView = this.f11538p;
            if (imageView != null && this.ab) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams.width = a7;
                layoutParams.height = a7;
                this.f11538p.setLayoutParams(layoutParams);
            }
            View view = this.f11537o;
            if (view != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                layoutParams2.width = a7;
                layoutParams2.height = a7;
                this.f11537o.setLayoutParams(layoutParams2);
                n.a(this.f11537o, (String) null, 1, "#66FFFFFF", a7 / 2);
            }
            LinearLayout linearLayout = this.f11528f;
            if (linearLayout != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams3.width = -2;
                layoutParams3.height = a7;
                this.f11528f.setLayoutParams(layoutParams3);
                n.a(this.f11528f, "#66000000", 1, "#66FFFFFF", a6);
            }
            LinearLayout linearLayout2 = this.f11530h;
            if (linearLayout2 != null) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) linearLayout2.getLayoutParams();
                layoutParams4.width = -1;
                layoutParams4.height = u.a((Context) this, 44.0f);
                this.f11530h.setLayoutParams(layoutParams4);
            }
            if (this.f11526d != null) {
                int f6 = q.f(this);
                int g6 = q.g(this);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f11526d.getLayoutParams();
                layoutParams5.width = f6;
                layoutParams5.height = g6;
                this.f11526d.setLayoutParams(layoutParams5);
            }
            LinearLayout linearLayout3 = this.f11531i;
            if (linearLayout3 != null) {
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) linearLayout3.getLayoutParams();
                layoutParams6.width = -1;
                layoutParams6.height = u.a((Context) this, 50.0f);
                this.f11531i.setLayoutParams(layoutParams6);
            }
            LinearLayout linearLayout4 = this.f11533k;
            if (linearLayout4 != null) {
                n.a(linearLayout4, "#FFFFFF", 0, (String) null, a6);
            }
            LinearLayout linearLayout5 = this.f11534l;
            if (linearLayout5 != null) {
                n.a(linearLayout5, "#EBF1FF", 0, (String) null, a7 / 3);
            }
            LinearLayout linearLayout6 = this.f11535m;
            if (linearLayout6 != null) {
                LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) linearLayout6.getLayoutParams();
                layoutParams7.width = -1;
                layoutParams7.height = u.a((Context) this, 50.0f);
                this.f11535m.setLayoutParams(layoutParams7);
            }
            TextView textView = this.I;
            if (textView != null) {
                LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) textView.getLayoutParams();
                int a8 = u.a((Context) this, 120.0f);
                int a9 = u.a((Context) this, 35.0f);
                layoutParams8.width = a8;
                layoutParams8.height = a9;
                this.I.setLayoutParams(layoutParams8);
                n.a(this.I, "#4DFFFFFF", 0, (String) null, a9 / 2);
            }
            LinearLayout linearLayout7 = this.f11536n;
            if (linearLayout7 != null) {
                n.a(linearLayout7, "#FFFFFF", 0, (String) null, a6);
            }
            TextView textView2 = this.M;
            if (textView2 != null) {
                LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) textView2.getLayoutParams();
                layoutParams9.width = -1;
                int a10 = u.a((Context) this, 44.0f);
                layoutParams9.height = a10;
                n.a(this.M, "#3976FF", 0, (String) null, a10 / 2);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void d() {
        AdSpacesBean.ComplainBean complain;
        TextView textView;
        try {
            AdSpacesBean.BuyerBean buyerBean = this.an;
            if (buyerBean == null || (complain = buyerBean.getComplain()) == null || complain.getOpen() != 1 || (textView = this.O) == null) {
                return;
            }
            textView.setVisibility(0);
            this.O.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BeiZiRewardVideoActivity.this.e();
                }
            });
            float a6 = u.a((Context) this, 5.0f);
            n.a(this.O, "#66000000", 1, "#66FFFFFF", new float[]{0.0f, 0.0f, a6, a6, a6, a6, 0.0f, 0.0f});
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void a() {
        this.f11525c = (RelativeLayout) findViewById(R.id.beizi_reward_video_ad_container_rl);
        this.U = (VideoView) findViewById(R.id.beizi_reward_video_ad_video_vv);
        this.V = (ProgressBar) findViewById(R.id.beizi_reward_video_progress_bar);
        this.O = (TextView) findViewById(R.id.beizi_reward_video_complaint_tv);
        this.f11538p = (ImageView) findViewById(R.id.beizi_reward_video_ad_voice_iv);
        this.f11537o = findViewById(R.id.beizi_reward_video_ad_voice_outline_view);
        this.f11528f = (LinearLayout) findViewById(R.id.beizi_reward_video_ad_get_rewards_container_ll);
        this.f11539q = (ImageView) findViewById(R.id.beizi_reward_video_ad_gift_iv);
        this.f11544v = (TextView) findViewById(R.id.beizi_reward_video_ad_get_rewards_countdown_tv);
        this.f11545w = (TextView) findViewById(R.id.beizi_reward_video_ad_get_rewards_close_tv);
        this.f11529g = (LinearLayout) findViewById(R.id.beizi_reward_video_ad_app_interaction_container_ll);
        this.R = (CustomRoundImageView) findViewById(R.id.beizi_reward_video_ad_app_icon_iv);
        this.f11546x = (TextView) findViewById(R.id.beizi_reward_video_ad_app_title_tv);
        this.f11547y = (TextView) findViewById(R.id.beizi_reward_video_ad_app_subtitle_tv);
        this.P = (FrameLayout) findViewById(R.id.beizi_reward_video_ad_logo_container_fl);
        this.f11530h = (LinearLayout) findViewById(R.id.beizi_reward_video_ad_interaction_container_ll);
        this.f11540r = (ImageView) findViewById(R.id.beizi_reward_video_ad_interaction_iv);
        this.f11548z = (TextView) findViewById(R.id.beizi_reward_video_ad_interaction_title_tv);
        this.K = (TextView) findViewById(R.id.beizi_reward_video_ad_app_download_info_tv);
        this.f11526d = (RelativeLayout) findViewById(R.id.beizi_reward_video_ad_detainment_container_rl);
        this.f11541s = (ImageView) findViewById(R.id.beizi_reward_video_ad_detainment_image_iv);
        this.S = (CustomRoundImageView) findViewById(R.id.beizi_reward_video_ad_detainment_app_icon_iv);
        this.A = (TextView) findViewById(R.id.beizi_reward_video_ad_detainment_app_title_tv);
        this.B = (TextView) findViewById(R.id.beizi_reward_video_ad_detainment_app_subtitle_tv);
        this.f11531i = (LinearLayout) findViewById(R.id.beizi_reward_video_ad_detainment_interaction_container_ll);
        this.f11542t = (ImageView) findViewById(R.id.beizi_reward_video_ad_detainment_interaction_iv);
        this.C = (TextView) findViewById(R.id.beizi_reward_video_ad_detainment_interaction_title_tv);
        this.Q = (FrameLayout) findViewById(R.id.beizi_reward_video_ad_detainment_logo_container_fl);
        this.f11532j = (LinearLayout) findViewById(R.id.beizi_reward_video_privilege_dialog_container_ll);
        this.f11533k = (LinearLayout) findViewById(R.id.beizi_reward_video_privilege_dialog_content_container_ll);
        this.E = (TextView) findViewById(R.id.beizi_reward_video_privilege_dialog_tip_sub_title_tv);
        this.D = (TextView) findViewById(R.id.beizi_reward_video_privilege_dialog_in_background_time_tv);
        this.f11534l = (LinearLayout) findViewById(R.id.beizi_reward_video_privilege_dialog_app_info_ll);
        this.T = (CustomRoundImageView) findViewById(R.id.beizi_reward_video_privilege_dialog_app_icon_iv);
        this.F = (TextView) findViewById(R.id.beizi_reward_video_privilege_dialog_app_title_tv);
        this.G = (TextView) findViewById(R.id.beizi_reward_video_privilege_dialog_app_subtitle_tv);
        this.f11535m = (LinearLayout) findViewById(R.id.beizi_reward_video_privilege_dialog_interaction_container_ll);
        this.J = (TextView) findViewById(R.id.beizi_reward_video_privilege_dialog_interaction_title_tv);
        this.f11543u = (ImageView) findViewById(R.id.beizi_reward_video_privilege_dialog_interaction_iv);
        this.H = (TextView) findViewById(R.id.beizi_reward_video_privilege_dialog_countdown_tv);
        this.I = (TextView) findViewById(R.id.beizi_reward_video_cancel_privilege_dialog_tv);
        this.f11527e = (RelativeLayout) findViewById(R.id.beizi_reward_video_quit_dialog_container_rl);
        this.f11536n = (LinearLayout) findViewById(R.id.beizi_reward_video_quit_dialog_content_container_ll);
        this.L = (TextView) findViewById(R.id.beizi_reward_video_quit_dialog_get_reward_tv);
        this.M = (TextView) findViewById(R.id.beizi_reward_video_quit_dialog_continue_play_tv);
        this.N = (TextView) findViewById(R.id.beizi_reward_video_quit_dialog_close_ad_tv);
    }

    private void d(int i6) {
        com.beizi.ad.internal.f.c cVar;
        com.beizi.ad.internal.g.a aVar = this.f11523a;
        if (aVar == null || (cVar = aVar.f11963a) == null) {
            return;
        }
        com.beizi.ad.internal.e d6 = aVar.d();
        String a6 = d6 != null ? d6.a() : null;
        if (i6 == 25) {
            cVar.c(this.f11525c, a6);
        } else if (i6 == 50) {
            cVar.d(this.f11525c, a6);
        } else if (i6 == 75) {
            cVar.e(this.f11525c, a6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i6) {
        try {
            TextView textView = this.f11544v;
            if (this.aa <= 0) {
                textView.setText("已获得奖励");
                p();
                return;
            }
            if (!this.aK && !this.aL) {
                if (this.aA != this.aB) {
                    if (i6 > 0) {
                        textView.setText(i6 + "秒后可领取奖励");
                        return;
                    }
                    textView.setText("已获得奖励");
                    p();
                    return;
                }
                this.f11539q.setVisibility(0);
                if (i6 > 0) {
                    this.f11544v.setText(i6 + "秒后点击广告可领取奖励");
                    return;
                }
                this.aK = true;
                this.f11544v.setText("立即领取");
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i6) {
        try {
            ProgressBar progressBar = this.V;
            if (progressBar == null) {
                return;
            }
            progressBar.setProgress(i6 / 1000);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void a(final CustomRoundImageView customRoundImageView, int i6) {
        try {
            if (this.f11524b == null || customRoundImageView == null) {
                return;
            }
            if (TextUtils.isEmpty(this.ai)) {
                customRoundImageView.setVisibility(8);
                return;
            }
            final int a6 = u.a(this, i6);
            customRoundImageView.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) customRoundImageView.getLayoutParams();
            layoutParams.width = a6;
            layoutParams.height = a6;
            customRoundImageView.setLayoutParams(layoutParams);
            i.a((Context) null).a(this.ai, new i.a() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.19
                @Override // com.beizi.ad.internal.h.i.a
                public void a() {
                }

                @Override // com.beizi.ad.internal.h.i.a
                public void a(Bitmap bitmap) {
                    try {
                        CustomRoundImageView customRoundImageView2 = customRoundImageView;
                        if (customRoundImageView2 != null) {
                            customRoundImageView2.setImageBitmap(bitmap);
                            customRoundImageView.setRectRadius(a6 / 2);
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void a(TextView textView, TextView textView2) {
        if (textView != null) {
            try {
                if (!TextUtils.isEmpty(this.aj)) {
                    textView.setVisibility(0);
                    textView.setText(this.aj);
                } else {
                    textView.setVisibility(8);
                }
            } catch (Exception e6) {
                e6.printStackTrace();
                return;
            }
        }
        if (textView2 != null) {
            if (!TextUtils.isEmpty(this.ak)) {
                textView2.setVisibility(0);
                textView2.setText(this.ak);
            } else {
                textView2.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i6) {
        try {
            String j6 = j();
            if (TextUtils.isEmpty(j6)) {
                return;
            }
            this.U.setVideoPath(j6);
            if (i6 == 0) {
                this.U.requestFocus();
            } else {
                this.U.start();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i6) {
        com.beizi.ad.internal.g.a aVar;
        com.beizi.ad.internal.f.c cVar;
        com.beizi.ad.internal.c g6;
        try {
            if (this.f11523a == null || this.aP || !hasWindowFocus() || (cVar = (aVar = this.f11523a).f11963a) == null || (g6 = aVar.g()) == null) {
                return;
            }
            if (this.aA == this.aB && this.aK && this.aE > 0 && !this.aL) {
                x();
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
            cVar.a(this.f11525c, dVar, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() + 10), this.ad, this.f11523a.d().a(), i6);
            this.ad = true;
            g6.d();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ImageView imageView) {
        if (imageView == null) {
            return;
        }
        try {
            if ("shake".equals(this.ax)) {
                imageView.setVisibility(0);
                imageView.setImageResource(R.mipmap.beizi_interaction_icon_shake);
                if (!TextUtils.isEmpty(this.aw)) {
                    i.a(this).b(this.aw, new i.a() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.11
                        @Override // com.beizi.ad.internal.h.i.a
                        public void a() {
                        }

                        @Override // com.beizi.ad.internal.h.i.a
                        public void a(Bitmap bitmap) {
                            try {
                                ImageView imageView2 = imageView;
                                if (imageView2 == null || bitmap == null) {
                                    return;
                                }
                                imageView2.setVisibility(0);
                                imageView.setImageBitmap(bitmap);
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                    });
                }
                e eVar = this.ap;
                if (eVar != null) {
                    eVar.a(imageView);
                    return;
                }
                return;
            }
            if ("eulerAngle".equals(this.ax)) {
                imageView.setVisibility(0);
                imageView.setImageResource(R.mipmap.beizi_interaction_icon_euler_angle);
                if (!TextUtils.isEmpty(this.aw)) {
                    i.a(this).b(this.aw, new i.a() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.13
                        @Override // com.beizi.ad.internal.h.i.a
                        public void a() {
                        }

                        @Override // com.beizi.ad.internal.h.i.a
                        public void a(Bitmap bitmap) {
                            try {
                                ImageView imageView2 = imageView;
                                if (imageView2 == null || bitmap == null) {
                                    return;
                                }
                                imageView2.setVisibility(0);
                                imageView.setImageBitmap(bitmap);
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                    });
                }
                com.beizi.ad.a.a.a aVar = this.ar;
                if (aVar != null) {
                    aVar.a(imageView);
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void a(View view) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.internal.activity.BeiZiRewardVideoActivity.14

            /* renamed from: a, reason: collision with root package name */
            float f11556a;

            /* renamed from: b, reason: collision with root package name */
            float f11557b;

            /* renamed from: c, reason: collision with root package name */
            float f11558c;

            /* renamed from: d, reason: collision with root package name */
            float f11559d;

            /* renamed from: e, reason: collision with root package name */
            float f11560e;

            /* renamed from: f, reason: collision with root package name */
            float f11561f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            this.f11560e = motionEvent.getX();
                            this.f11561f = motionEvent.getY();
                        }
                    } else if (Math.abs(this.f11560e - this.f11556a) <= 15.0f && Math.abs(this.f11561f - this.f11557b) <= 15.0f) {
                        BeiZiRewardVideoActivity.this.a(String.valueOf(this.f11556a), String.valueOf(this.f11557b), String.valueOf(this.f11558c), String.valueOf(this.f11559d), String.valueOf(this.f11556a), String.valueOf(this.f11557b), String.valueOf(this.f11558c), String.valueOf(this.f11559d), 0);
                    }
                } else {
                    this.f11556a = motionEvent.getX();
                    this.f11557b = motionEvent.getY();
                    this.f11558c = motionEvent.getRawX();
                    this.f11559d = motionEvent.getRawY();
                    this.f11560e = motionEvent.getX();
                    this.f11561f = motionEvent.getY();
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i6, int i7) {
        double d6 = i7;
        double d7 = i6;
        if (d6 >= 0.25d * d7 && !this.aR) {
            this.aR = true;
            d(25);
        }
        if (d6 >= 0.5d * d7 && !this.aS) {
            this.aS = true;
            d(50);
        }
        if (d6 < d7 * 0.75d || this.aT) {
            return;
        }
        this.aT = true;
        d(75);
    }
}
