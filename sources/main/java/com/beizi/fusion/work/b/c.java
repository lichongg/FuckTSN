package com.beizi.fusion.work.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.beizi.ad.i;
import com.beizi.ad.internal.e.f;
import com.beizi.ad.internal.h.i;
import com.beizi.ad.internal.h.u;
import com.beizi.fusion.R;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.tool.an;
import com.beizi.fusion.tool.ap;
import com.beizi.fusion.tool.l;
import com.beizi.fusion.tool.w;
import com.beizi.fusion.widget.CustomRoundImageView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c extends a {
    private LinearLayout V;
    private LinearLayout W;
    private FrameLayout X;
    private CustomRoundImageView Y;
    private TextView Z;
    private TextView aa;
    private TextView ab;
    private ImageView ac;

    /* JADX INFO: Access modifiers changed from: private */
    public void aE() {
        try {
            AdSpacesBean.ComplainBean complainBean = this.N;
            if (complainBean != null && complainBean.getOpen() == 1) {
                l lVar = new l();
                lVar.a(((a) this).f14092n, ((a) this).f14098t, "2");
                lVar.a(new l.a() { // from class: com.beizi.fusion.work.b.c.1
                    @Override // com.beizi.fusion.tool.l.a
                    public void a(String str) {
                        try {
                            c cVar = c.this;
                            an.a(((a) cVar).f14092n, cVar.O, (Object) Long.valueOf(System.currentTimeMillis()));
                            ((com.beizi.fusion.work.a) c.this).f14053b.setComplain(str);
                            c.this.ao();
                            c.this.H();
                            c.this.aF();
                            if (((com.beizi.fusion.work.a) c.this).f14055d != null && ((com.beizi.fusion.work.a) c.this).f14055d.o() != 2) {
                                ((com.beizi.fusion.work.a) c.this).f14055d.b(c.this.f(), ((a) c.this).f14099u);
                            }
                            c.this.F();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF() {
        try {
            LinearLayout linearLayout = new LinearLayout(((a) this).f14092n);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            ImageView imageView = new ImageView(((a) this).f14092n);
            imageView.setImageResource(R.drawable.beizi_icon_checkbox);
            imageView.setColorFilter(Color.parseColor("#000000"));
            linearLayout.addView(imageView);
            TextView textView = new TextView(((a) this).f14092n);
            textView.setText("投诉成功，我们将重视您的反馈。");
            textView.setTextColor(Color.parseColor("#000000"));
            textView.setTextSize(2, 13.0f);
            textView.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 30, 0, 0);
            linearLayout.addView(textView, layoutParams);
            ((a) this).f14099u.measure(0, 0);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(((a) this).f14099u.getMeasuredWidth(), ((a) this).f14099u.getMeasuredHeight());
            layoutParams2.gravity = 17;
            ((a) this).f14098t.addView(linearLayout, layoutParams2);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG() {
        View a6;
        try {
            i iVar = this.K;
            if (iVar == null || iVar.n() == null || (a6 = f.a(((a) this).f14092n, this.K)) == null) {
                return;
            }
            this.X.measure(0, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((this.X.getMeasuredWidth() * 2) / 3, -2);
            layoutParams.gravity = 83;
            this.X.addView(a6, layoutParams);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void aH() {
        try {
            i iVar = this.K;
            if (iVar == null) {
                return;
            }
            com.beizi.ad.internal.h.i.a((Context) null).a(iVar.b(), new i.a() { // from class: com.beizi.fusion.work.b.c.2
                @Override // com.beizi.ad.internal.h.i.a
                public void a(Bitmap bitmap) {
                    ViewGroup.LayoutParams layoutParams;
                    if (bitmap != null) {
                        try {
                            if (((a) c.this).f14092n == null) {
                                return;
                            }
                            bitmap.getWidth();
                            bitmap.getHeight();
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            c cVar = c.this;
                            int a6 = ap.a(((a) cVar).f14092n, ((a) cVar).f14096r - 16.0f);
                            int i6 = (int) (a6 / ((float) ((width * 1.0d) / height)));
                            c cVar2 = c.this;
                            if (((a) cVar2).f14097s > 0.0f) {
                                int i7 = 0;
                                if (cVar2.W != null) {
                                    c.this.W.measure(0, 0);
                                    i7 = c.this.W.getMeasuredHeight();
                                }
                                c cVar3 = c.this;
                                int a7 = ap.a(((a) cVar3).f14092n, ((a) cVar3).f14097s - 16.0f);
                                if (a7 > i7) {
                                    i6 = a7 - i7;
                                }
                            }
                            c cVar4 = c.this;
                            cVar4.S = a6;
                            cVar4.T = i6;
                            if (i6 < 0) {
                                cVar4.T = height;
                            }
                            if (cVar4.Y != null && (layoutParams = c.this.Y.getLayoutParams()) != null) {
                                layoutParams.width = a6;
                                layoutParams.height = i6;
                                c.this.Y.setLayoutParams(layoutParams);
                            }
                            if (c.this.Y != null) {
                                c.this.Y.setRectRadius(ap.a(((a) c.this).f14092n, 4.0f));
                                c.this.Y.setBackground(new BitmapDrawable(w.a(((a) c.this).f14092n, bitmap, 20.0f)));
                                c.this.Y.setImageBitmap(bitmap);
                            }
                            c cVar5 = c.this;
                            cVar5.a(cVar5.Y);
                            c.this.aE();
                            c.this.aG();
                            c.this.aI();
                            c.this.ay();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            c.this.a("sdk custom error ".concat("onBitmapLoadFailed"), 99991);
                        }
                    }
                }

                @Override // com.beizi.ad.internal.h.i.a
                public void a() {
                    c.this.a("sdk custom error ".concat("onBitmapLoadFailed"), 99991);
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI() {
        try {
            if (this.K == null) {
                return;
            }
            LinearLayout linearLayout = new LinearLayout(((a) this).f14092n);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout a6 = u.a(((a) this).f14092n, this.K.l());
            a6.setVisibility(0);
            linearLayout.addView(a6, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            View b6 = u.b(((a) this).f14092n, this.K.k());
            b6.setVisibility(0);
            linearLayout.addView(b6, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b6.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            b6.setLayoutParams(layoutParams);
            ((a) this).f14098t.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 53));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            if (aB()) {
                layoutParams2.setMargins(0, ap.a(((a) this).f14092n, 16.0f), ap.a(((a) this).f14092n, 40.0f), 0);
            } else {
                layoutParams2.setMargins(0, ap.a(((a) this).f14092n, 16.0f), ap.a(((a) this).f14092n, 16.0f), 0);
            }
            linearLayout.setLayoutParams(layoutParams2);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public c(Context context, String str, long j6, long j7, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.c.d dVar, float f6, float f7) {
        super(context, str, j6, j7, buyerBean, forwardBean, dVar, f6, f7);
    }

    @Override // com.beizi.fusion.work.b.a
    public void a(com.beizi.ad.i iVar) {
        try {
            ImageView imageView = new ImageView(((a) this).f14092n);
            int a6 = ap.a(((a) this).f14092n, 24.0f) + 42;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a6, a6);
            int a7 = ap.a(((a) this).f14092n, 16.0f);
            int a8 = ap.a(((a) this).f14092n, 8.0f);
            imageView.setPadding(a8, a7, a7, a8);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.beizi_close_two);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a6, a6);
            layoutParams2.gravity = 5;
            ((a) this).f14098t.addView(imageView, layoutParams2);
            imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.b.c.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        ((a) c.this).F = motionEvent.getX();
                        ((a) c.this).G = motionEvent.getY();
                        ((a) c.this).H = motionEvent.getRawX();
                        c.this.I = motionEvent.getRawY();
                        return false;
                    }
                    return false;
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.b.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        if (!c.this.aC()) {
                            c.this.aD();
                            return;
                        }
                        c cVar = c.this;
                        cVar.U = false;
                        c.this.a(new String[]{String.valueOf(((a) cVar).F), String.valueOf(((a) c.this).G), String.valueOf(((a) c.this).H), String.valueOf(c.this.I)}, 0);
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.b.a
    public void b() {
        try {
            if (this.K == null) {
                c(-991);
                return;
            }
            View inflate = LayoutInflater.from(((a) this).f14092n).inflate(R.layout.beizi_layout_native_top_picture_bottom_text_view, (ViewGroup) null);
            this.M = inflate;
            this.V = (LinearLayout) inflate.findViewById(R.id.native_ad_tpbt_container_ll);
            this.X = (FrameLayout) this.M.findViewById(R.id.native_ad_tpbt_img_container_fl);
            this.Y = (CustomRoundImageView) this.M.findViewById(R.id.native_ad_tpbt_image_iv);
            this.W = (LinearLayout) this.M.findViewById(R.id.native_ad_tpbt_content_ll);
            this.Z = (TextView) this.M.findViewById(R.id.native_ad_tpbt_title_tv);
            this.aa = (TextView) this.M.findViewById(R.id.native_ad_tpbt_subtitle_tv);
            this.ab = (TextView) this.M.findViewById(R.id.native_ad_tpbt_go_tv);
            this.ac = (ImageView) this.M.findViewById(R.id.native_ad_tpbt_go_iv);
            int a6 = ap.a(((a) this).f14092n, ((a) this).f14096r);
            float f6 = ((a) this).f14097s;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a6, f6 > 0.0f ? ap.a(((a) this).f14092n, f6) : -2);
            int a7 = ap.a(((a) this).f14092n, 8.0f);
            LinearLayout linearLayout = this.V;
            if (linearLayout != null) {
                linearLayout.setPadding(a7, a7, a7, a7);
                this.V.setLayoutParams(layoutParams);
            }
            LinearLayout linearLayout2 = this.W;
            if (linearLayout2 != null) {
                linearLayout2.setPadding(0, ap.a(((a) this).f14092n, 8.0f), 0, ap.a(((a) this).f14092n, 8.0f));
            }
            String a8 = this.K.a();
            if (this.Z != null && !TextUtils.isEmpty(a8)) {
                this.Z.setText(a8);
            }
            String c6 = this.K.c();
            if (this.aa != null && !TextUtils.isEmpty(c6)) {
                this.aa.setText(c6);
            }
            TextView textView = this.ab;
            if (textView != null) {
                textView.setBackground(((a) this).f14092n.getDrawable(R.drawable.beizi_bg_operate_button));
            }
            if (this.ac != null) {
                this.ac.setLayoutParams(new RelativeLayout.LayoutParams(ap.a(((a) this).f14092n, 63.0f), ap.a(((a) this).f14092n, 24.0f)));
                this.ac.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            a(this.ab, this.ac);
            aH();
            az();
            aA();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
