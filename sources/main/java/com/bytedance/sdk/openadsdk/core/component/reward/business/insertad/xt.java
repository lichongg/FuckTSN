package com.bytedance.sdk.openadsdk.core.component.reward.business.insertad;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardFullBaseLayout;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.la;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements j {
    private int ae;
    private LinearLayout av;
    private LinearLayout az;
    private cw cw;

    /* renamed from: g, reason: collision with root package name */
    private int f28116g;

    /* renamed from: i, reason: collision with root package name */
    private TranslateAnimation f28117i;
    private LinearLayout jy;

    /* renamed from: m, reason: collision with root package name */
    private int f28119m;
    private int oq;
    private int qv;
    private int tl;
    private TextView up;
    private TextView vl;
    private SmallSlideView ws;
    private final j.InterfaceC0436j xt;

    /* renamed from: j, reason: collision with root package name */
    protected final AtomicBoolean f28118j = new AtomicBoolean(false);

    /* renamed from: r, reason: collision with root package name */
    private boolean f28120r = true;

    /* renamed from: w, reason: collision with root package name */
    private boolean f28121w = false;
    private boolean mi = false;
    private boolean kt = false;

    /* renamed from: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xt$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            xt.this.xt.j().j(new RewardFullBaseLayout.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xt.1.1
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardFullBaseLayout.j
                public void j() {
                    r rVar = new r();
                    rVar.f28114j = false;
                    rVar.cw = true;
                    rVar.f28115r = true;
                    xt.this.xt.j().j();
                    xt.this.xt.getActivity().j(3, rVar);
                }
            });
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) xt.this.av.getLayoutParams();
            layoutParams.bottomMargin = -xt.this.av.getMeasuredHeight();
            xt.this.av.setLayoutParams(layoutParams);
            xt.this.av.setVisibility(0);
            xt.this.f28117i = new TranslateAnimation(0.0f, 0.0f, 0.0f, -xt.this.av.getMeasuredHeight());
            xt.this.f28117i.setDuration(300L);
            xt.this.f28117i.setRepeatCount(3);
            xt.this.f28117i.setRepeatMode(2);
            xt.this.f28117i.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xt.1.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (xt.this.f28121w) {
                        xt.this.av.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xt.1.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (xt.this.f28121w && xt.this.f28117i != null) {
                                    xt.this.xt.j().getSceneFrameContainer().startAnimation(xt.this.f28117i);
                                }
                            }
                        }, 2000L);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    xt.this.ws.j();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            if (xt.this.f28117i != null) {
                xt.this.xt.j().getSceneFrameContainer().startAnimation(xt.this.f28117i);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j
    public void ae() {
        int i6;
        int i7;
        int i8;
        if (j(3)) {
            return;
        }
        if (this.ae > 0 && this.xt.up() >= this.ae) {
            this.ae = 0;
            r rVar = new r();
            rVar.f28114j = false;
            rVar.cw = false;
            rVar.f28115r = true;
            this.xt.getActivity().j(3, rVar);
        }
        if (this.vl != null && (i8 = this.tl) > 0) {
            this.tl = Math.max(0, i8 - 1);
            TextView textView = this.vl;
            StringBuilder sb = new StringBuilder();
            sb.append(this.tl);
            textView.setText(sb.toString());
            if (this.tl == 0) {
                r rVar2 = new r();
                rVar2.f28114j = false;
                rVar2.cw = false;
                rVar2.f28115r = true;
                this.xt.getActivity().j(1, rVar2);
                m();
            }
        }
        if (this.vl != null && (i7 = this.f28116g) > 0) {
            this.f28116g = Math.max(0, i7 - 1);
            TextView textView2 = this.vl;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f28116g);
            textView2.setText(sb2.toString());
            if (this.f28116g == 0) {
                r rVar3 = new r();
                rVar3.f28114j = false;
                rVar3.cw = false;
                rVar3.f28115r = true;
                this.xt.getActivity().j(2, rVar3);
                m();
            }
        }
        int i9 = this.qv;
        if (i9 > 0) {
            int max = Math.max(0, i9 - 1);
            this.qv = max;
            if (max == 0) {
                this.xt.j(-1, this.oq);
                return;
            }
            return;
        }
        if (this.vl == null || (i6 = this.oq) <= 0) {
            return;
        }
        this.oq = Math.max(0, i6 - 1);
        TextView textView3 = this.vl;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.oq);
        textView3.setText(sb3.toString());
        if (this.oq == 0) {
            m();
            this.xt.qv();
        }
    }

    private void oq() {
        String str;
        this.ae = this.xt.up() + (la.g() / 1000);
        this.az = new LinearLayout(this.xt.getActivity());
        int cw = ed.cw(this.xt.getActivity(), 10.0f);
        this.az.setPadding(cw, cw, cw, cw);
        this.az.setOrientation(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#242424"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.j.j.xt().j(this.xt.getActivity(), 12.0f));
        this.az.setBackground(gradientDrawable);
        this.ws = new SmallSlideView(this.xt.getActivity());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ed.cw(this.xt.getActivity(), 80.0f), ed.cw(this.xt.getActivity(), 80.0f));
        layoutParams.gravity = 17;
        this.az.addView(this.ws, layoutParams);
        TextView textView = new TextView(this.xt.getActivity());
        if (la.oq() > 0) {
            str = "上滑继续观看\n提前" + la.oq() + "秒领奖";
        } else {
            str = "上滑继续观看\n才能领奖哦";
        }
        textView.setText(str);
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setTextSize(2, 18.0f);
        this.az.addView(textView);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ed.cw(this.xt.getActivity(), 160.0f), ed.cw(this.xt.getActivity(), 160.0f));
        layoutParams2.gravity = 17;
        this.xt.j().addView(this.az, layoutParams2);
        this.av = new LinearLayout(this.xt.getActivity());
        ImageView imageView = new ImageView(this.xt.getActivity());
        kt.j((Context) this.xt.getActivity(), "tt_ic_back_light", imageView);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = ed.cw(this.xt.getActivity(), 10.0f);
        layoutParams3.bottomMargin = ed.cw(this.xt.getActivity(), 10.0f);
        this.av.addView(imageView, layoutParams3);
        this.xt.j().getSceneFrameContainer().setClipChildren(false);
        this.av.setVisibility(4);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams4.gravity = 80;
        this.xt.j().getSceneFrameContainer().addView(this.av, layoutParams4);
        this.f28121w = true;
        this.av.post(new AnonymousClass1());
    }

    public void g() {
        TextView textView = this.up;
        if (textView == null || textView.getParent() == null) {
            return;
        }
        ((ViewGroup) this.up.getParent()).removeView(this.up);
        this.up = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j
    public void m() {
        if (this.jy != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xt.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    xt.this.jy.removeAllViews();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.jy.startAnimation(alphaAnimation);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j
    public boolean r() {
        return this.cw != null;
    }

    public void tl() {
        int m6 = this.xt.m();
        String str = "继续看" + m6 + "秒可领取奖励";
        if (this.cw.cw() > 0) {
            if (m6 <= 0) {
                str = "成功加速" + this.cw.cw() + "秒，奖励已下发";
            } else {
                str = "加速成功！".concat(String.valueOf(str));
            }
        } else if (m6 <= 0) {
            g();
            return;
        }
        this.up.setText(str);
        int i6 = this.f28119m;
        if (i6 <= 0) {
            g();
            return;
        }
        this.f28119m = i6 - 1;
        TextView textView = this.up;
        if (textView != null) {
            textView.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xt.3
                @Override // java.lang.Runnable
                public void run() {
                    xt.this.tl();
                }
            }, 500L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j
    public boolean up() {
        return this.f28118j.get();
    }

    public xt(j.InterfaceC0436j interfaceC0436j) {
        this.xt = interfaceC0436j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j
    public void cw() {
        if (this.f28121w && j(3)) {
            SmallSlideView smallSlideView = this.ws;
            if (smallSlideView != null) {
                smallSlideView.xt();
            }
            TranslateAnimation translateAnimation = this.f28117i;
            if (translateAnimation != null) {
                translateAnimation.cancel();
            }
            LinearLayout linearLayout = this.az;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                this.xt.j().removeView(this.az);
            }
            LinearLayout linearLayout2 = this.av;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
                this.xt.j().getSceneFrameContainer().removeView(this.av);
            }
            this.xt.j().j();
            this.xt.j(3);
            this.f28121w = false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j
    public int xt() {
        cw cwVar = this.cw;
        if (cwVar != null) {
            return cwVar.ae();
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
    
        r2.remove(r0);
        r3.uf(r2.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002f, code lost:
    
        r1 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j(com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.cw r6, int r7, com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.r r8) {
        /*
            r5 = this;
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j$j r0 = r5.xt
            com.bytedance.sdk.openadsdk.core.tj.n r0 = r0.cw()
            r1 = 0
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: org.json.JSONException -> L37
            java.lang.String r0 = r0.kg()     // Catch: org.json.JSONException -> L37
            r2.<init>(r0)     // Catch: org.json.JSONException -> L37
            r0 = 0
        L11:
            int r3 = r2.length()     // Catch: org.json.JSONException -> L37
            if (r0 >= r3) goto L3b
            org.json.JSONObject r3 = r2.getJSONObject(r0)     // Catch: org.json.JSONException -> L37
            com.bytedance.sdk.openadsdk.core.tj.n r3 = com.bytedance.sdk.openadsdk.core.j.j(r3)     // Catch: org.json.JSONException -> L37
            boolean r4 = r5.j(r3, r7)     // Catch: org.json.JSONException -> L37
            if (r4 == 0) goto L34
            r2.remove(r0)     // Catch: org.json.JSONException -> L31
            java.lang.String r0 = r2.toString()     // Catch: org.json.JSONException -> L31
            r3.uf(r0)     // Catch: org.json.JSONException -> L31
            r1 = r3
            goto L3b
        L31:
            r0 = move-exception
            r1 = r3
            goto L38
        L34:
            int r0 = r0 + 1
            goto L11
        L37:
            r0 = move-exception
        L38:
            com.bytedance.sdk.component.utils.vl.j(r0)
        L3b:
            if (r1 == 0) goto Lc3
            r0 = 1
            if (r7 != r0) goto L53
            if (r8 == 0) goto L53
            boolean r2 = r8.f28114j
            if (r2 == 0) goto L53
            boolean r6 = r5.mi
            if (r6 != 0) goto Lc3
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j$j r6 = r5.xt
            int r8 = r8.xt
            r6.j(r7, r8)
            goto Lc3
        L53:
            r2 = 2
            if (r7 != r2) goto L68
            if (r8 == 0) goto L68
            boolean r2 = r8.f28114j
            if (r2 == 0) goto L68
            boolean r6 = r5.kt
            if (r6 != 0) goto Lc3
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j$j r6 = r5.xt
            int r8 = r8.xt
            r6.j(r7, r8)
            goto Lc3
        L68:
            r2 = 3
            if (r7 != r2) goto L7d
            if (r8 == 0) goto L7d
            boolean r2 = r8.f28114j
            if (r2 == 0) goto L7d
            boolean r6 = r5.f28121w
            if (r6 != 0) goto Lc3
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j$j r6 = r5.xt
            int r8 = r8.xt
            r6.j(r7, r8)
            goto Lc3
        L7d:
            com.bytedance.sdk.openadsdk.core.component.reward.j.j.xt r7 = com.bytedance.sdk.openadsdk.core.component.reward.j.j.xt.j()
            java.lang.String r8 = ""
            java.lang.String r8 = com.bytedance.sdk.openadsdk.core.rn.uf.j(r1, r8)
            com.bytedance.sdk.openadsdk.i.cw.cw.xt r7 = r7.j(r8)
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j$j r8 = r5.xt
            boolean r8 = r8.xt()
            if (r8 == 0) goto La9
            com.bytedance.sdk.openadsdk.core.component.reward.cw r8 = new com.bytedance.sdk.openadsdk.core.component.reward.cw
            android.content.Context r2 = com.bytedance.sdk.openadsdk.core.v.getContext()
            r8.<init>(r2, r1, r7)
            r8.j(r6)
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j$j r6 = r5.xt
            com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity r6 = r6.getActivity()
            r8.j(r6)
            goto Lbe
        La9:
            com.bytedance.sdk.openadsdk.core.component.reward.xt r8 = new com.bytedance.sdk.openadsdk.core.component.reward.xt
            android.content.Context r2 = com.bytedance.sdk.openadsdk.core.v.getContext()
            r8.<init>(r2, r1, r7)
            r8.j(r6)
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j$j r6 = r5.xt
            com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity r6 = r6.getActivity()
            r8.j(r6)
        Lbe:
            java.util.concurrent.atomic.AtomicBoolean r6 = r5.f28118j
            r6.set(r0)
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xt.j(com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.cw, int, com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.r):void");
    }

    private void xt(final int i6, int i7, int i8) {
        if (i6 == 1) {
            this.tl = i7;
        } else if (i6 == 2) {
            i7++;
            this.f28116g = i7;
        } else if (i6 == -1) {
            this.oq = i7;
            if (i8 > 0) {
                this.qv = i8;
                return;
            }
            this.qv = 0;
        } else {
            i7 = 0;
        }
        LinearLayout linearLayout = this.jy;
        if (linearLayout == null) {
            LinearLayout linearLayout2 = new LinearLayout(this.xt.getActivity());
            this.jy = linearLayout2;
            linearLayout2.setBackgroundColor(Color.parseColor("#80161823"));
            this.jy.setOrientation(0);
            this.jy.setGravity(16);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 81;
            ((ViewGroup) this.xt.getActivity().getWindow().getDecorView()).addView(this.jy, layoutParams);
        } else {
            linearLayout.removeAllViews();
        }
        TextView textView = new TextView(this.xt.getActivity());
        this.vl = textView;
        textView.setTextColor(Color.parseColor("#FFBA33"));
        this.vl.setText(String.valueOf(i7));
        TextView textView2 = this.vl;
        Typeface typeface = Typeface.DEFAULT_BOLD;
        textView2.setTypeface(typeface);
        this.vl.setTextSize(2, 14.0f);
        this.jy.addView(this.vl);
        TextView textView3 = new TextView(this.xt.getActivity());
        textView3.setTextColor(-1);
        textView3.setTypeface(typeface);
        textView3.setSingleLine();
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setText(la.m(this.xt.cw()));
        textView3.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.setMargins(ed.cw(this.xt.getActivity(), 4.0f), 0, 0, 0);
        layoutParams2.weight = 1.0f;
        this.jy.addView(textView3, layoutParams2);
        TextView textView4 = new TextView(this.xt.getActivity());
        textView4.setText("取消");
        textView4.setTypeface(typeface);
        textView4.setTextSize(2, 13.0f);
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xt.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i9 = i6;
                if (i9 == 1) {
                    xt.this.tl = 0;
                } else if (i9 == 2) {
                    xt.this.f28116g = 0;
                } else if (i9 == -1) {
                    xt.this.oq = 0;
                    i9 = 2;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", i9);
                } catch (JSONException unused) {
                }
                ws.j().j(xt.this.xt.cw(), "stats_switch_tip_cancel", jSONObject);
                xt.this.m();
                xt.this.xt.oq();
            }
        });
        this.jy.addView(textView4);
        this.jy.setPadding(ed.cw(this.xt.getActivity(), 20.0f), ed.cw(this.xt.getActivity(), 16.0f), ed.cw(this.xt.getActivity(), 20.0f), ed.w(this.xt.getActivity()));
        this.jy.setClickable(false);
        if (i6 == 1) {
            this.mi = true;
        } else if (i6 == 2) {
            this.kt = true;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, ed.cw(this.xt.getActivity(), 100.0f), 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(true);
        this.jy.startAnimation(translateAnimation);
    }

    private boolean j(n nVar, int i6) {
        if (i6 != 1) {
            return i6 != 2 ? i6 == 3 && la.xt(nVar, true) : la.j(nVar, true);
        }
        return la.j(this.xt.xt(), nVar, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j
    public void j(cw cwVar) {
        this.cw = cwVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j
    public int j() {
        cw cwVar = this.cw;
        if (cwVar != null) {
            return Math.max(0, cwVar.xt() - this.cw.cw());
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j
    public void j(boolean z5) {
        this.f28120r = z5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j
    public int j(int i6, boolean z5) {
        if (!this.f28120r || j(i6)) {
            return 0;
        }
        if (i6 == 1) {
            if (la.j(this.xt.cw()) != 1) {
                return 0;
            }
            if (!z5) {
                if (!la.j(this.xt.xt(), r() ? this.xt.r() : n.xt(this.xt.cw()), this.xt.up())) {
                    return 0;
                }
            }
        } else if (i6 == 2) {
            if (la.xt(this.xt.cw()) != 1) {
                return 0;
            }
            if (!z5 && this.xt.ae()) {
                return 0;
            }
            if (!z5 && !la.j(this.xt.up(), this.xt.cw(), this.xt.xt())) {
                return 0;
            }
        } else {
            if (i6 != 3 || la.cw(this.xt.cw()) != 1 || this.xt.tl()) {
                return 0;
            }
            if (!z5 && !la.j(this.xt.up(), this.xt.cw())) {
                return 0;
            }
        }
        return i6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j
    public boolean j(int i6) {
        if (this.xt.g()) {
            if (e.a(this.xt.cw()) == com.bytedance.sdk.openadsdk.core.tl.r.ae) {
                return true;
            }
            if (e.a(this.xt.cw()) == com.bytedance.sdk.openadsdk.core.tl.r.tl && !this.xt.tl()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j
    public void xt(boolean z5) {
        this.qv = 0;
        if (z5) {
            this.oq = 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j
    public void j(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return;
        }
        if (this.up == null) {
            this.up = ed.i(this.xt.getActivity());
        }
        if (this.up.getParent() != null) {
            ((ViewGroup) this.up.getParent()).removeView(this.up);
        }
        this.f28119m = la.tl() * 2;
        frameLayout.addView(this.up);
        tl();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j
    public void j(int i6, int i7, int i8) {
        if (i6 == -1 || i6 == 1 || i6 == 2) {
            xt(i6, i7, i8);
        } else {
            if (i6 != 3) {
                return;
            }
            oq();
        }
    }
}
