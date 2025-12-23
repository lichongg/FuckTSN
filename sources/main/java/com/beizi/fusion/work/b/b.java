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
import com.beizi.fusion.tool.am;
import com.beizi.fusion.tool.an;
import com.beizi.fusion.tool.ap;
import com.beizi.fusion.tool.l;
import com.beizi.fusion.tool.w;
import com.beizi.fusion.widget.CustomRoundImageView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b extends a {
    private RelativeLayout V;
    private TextView W;
    private TextView X;
    private TextView Y;
    private ImageView Z;
    private ImageView aa;
    private CustomRoundImageView ab;

    /* JADX INFO: Access modifiers changed from: private */
    public void aE() {
        try {
            AdSpacesBean.ComplainBean complainBean = this.N;
            if (complainBean != null && complainBean.getOpen() == 1) {
                l lVar = new l();
                lVar.a(((a) this).f14092n, ((a) this).f14098t, "3");
                lVar.a(new l.a() { // from class: com.beizi.fusion.work.b.b.1
                    @Override // com.beizi.fusion.tool.l.a
                    public void a(String str) {
                        try {
                            b bVar = b.this;
                            an.a(((a) bVar).f14092n, bVar.O, (Object) Long.valueOf(System.currentTimeMillis()));
                            ((com.beizi.fusion.work.a) b.this).f14053b.setComplain(str);
                            b.this.ao();
                            b.this.H();
                            b.this.aF();
                            if (((com.beizi.fusion.work.a) b.this).f14055d != null && ((com.beizi.fusion.work.a) b.this).f14055d.o() != 2) {
                                ((com.beizi.fusion.work.a) b.this).f14055d.b(b.this.f(), ((a) b.this).f14099u);
                            }
                            b.this.F();
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
            linearLayout.setOrientation(0);
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
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(20, 0, 0, 0);
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
            ((a) this).f14098t.measure(0, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((((a) this).f14098t.getMeasuredWidth() * 2) / 3, -2);
            layoutParams.gravity = 83;
            ((a) this).f14098t.addView(a6, layoutParams);
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
            com.beizi.ad.internal.h.i.a((Context) null).a(iVar.b(), new i.a() { // from class: com.beizi.fusion.work.b.b.2
                @Override // com.beizi.ad.internal.h.i.a
                public void a(Bitmap bitmap) {
                    ViewGroup.LayoutParams layoutParams;
                    if (bitmap != null) {
                        try {
                            if (((a) b.this).f14092n == null) {
                                return;
                            }
                            bitmap.getWidth();
                            bitmap.getHeight();
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            float f6 = (float) ((width * 1.0d) / height);
                            b bVar = b.this;
                            int a6 = (int) (ap.a(((a) bVar).f14092n, ((a) bVar).f14096r) * 0.285d);
                            b bVar2 = b.this;
                            float f7 = ((a) bVar2).f14097s;
                            int a7 = f7 > 0.0f ? ap.a(((a) bVar2).f14092n, f7) - ap.a(((a) b.this).f14092n, 20.0f) : (int) (a6 / f6);
                            b bVar3 = b.this;
                            bVar3.S = a6;
                            bVar3.T = a7;
                            if (a7 < 0) {
                                bVar3.T = height;
                            }
                            if (bVar3.ab != null && (layoutParams = b.this.ab.getLayoutParams()) != null) {
                                layoutParams.width = a6;
                                layoutParams.height = a7;
                                b.this.ab.setLayoutParams(layoutParams);
                            }
                            if (b.this.ab != null) {
                                b.this.ab.setRectRadius(ap.a(((a) b.this).f14092n, 8.0f));
                                b.this.ab.setBackground(new BitmapDrawable(w.a(((a) b.this).f14092n, bitmap, 20.0f)));
                                b.this.ab.setImageBitmap(bitmap);
                            }
                            b bVar4 = b.this;
                            bVar4.a(bVar4.ab);
                            b.this.aE();
                            b.this.aG();
                            b.this.aI();
                            b.this.ay();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                }

                @Override // com.beizi.ad.internal.h.i.a
                public void a() {
                    b.this.a("sdk custom error ".concat("onBitmapLoadFailed"), 99991);
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
            ((a) this).f14098t.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams2.setMargins(0, 0, 15, 15);
            linearLayout.setLayoutParams(layoutParams2);
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
            View inflate = LayoutInflater.from(((a) this).f14092n).inflate(R.layout.beizi_layout_native_left_text_right_picture_view, (ViewGroup) null);
            this.M = inflate;
            this.V = (RelativeLayout) inflate.findViewById(R.id.native_ad_ltrg_content_rl);
            LinearLayout linearLayout = (LinearLayout) this.M.findViewById(R.id.native_ad_ltrg_title_ll);
            this.W = (TextView) this.M.findViewById(R.id.native_ad_ltrg_title_tv);
            RelativeLayout relativeLayout = (RelativeLayout) this.M.findViewById(R.id.native_ad_ltrg_subtitle_rl);
            this.X = (TextView) this.M.findViewById(R.id.native_ad_ltrg_subtitle_tv);
            this.Y = (TextView) this.M.findViewById(R.id.native_ad_ltrg_go_tv);
            this.Z = (ImageView) this.M.findViewById(R.id.native_ad_ltrg_go_iv);
            this.ab = (CustomRoundImageView) this.M.findViewById(R.id.native_ad_ltrg_image_iv);
            this.aa = (ImageView) this.M.findViewById(R.id.native_ad_ltrg_ad_text_iv);
            RelativeLayout relativeLayout2 = this.V;
            if (relativeLayout2 != null) {
                relativeLayout2.setPadding(0, ap.a(((a) this).f14092n, 10.0f), ap.a(((a) this).f14092n, 10.0f), 0);
            }
            if (linearLayout != null) {
                linearLayout.setPadding(ap.a(((a) this).f14092n, 20.0f), ap.a(((a) this).f14092n, 8.0f), ap.a(((a) this).f14092n, 11.0f), 0);
            }
            String a6 = this.K.a();
            if (this.W != null && !TextUtils.isEmpty(a6)) {
                this.W.setText(a6);
            }
            if (relativeLayout != null) {
                relativeLayout.setPadding(0, ap.a(((a) this).f14092n, 5.0f), 0, 0);
            }
            String c6 = this.K.c();
            if (this.X != null && !TextUtils.isEmpty(c6)) {
                this.X.setText(c6);
            }
            ImageView imageView = this.aa;
            if (imageView != null) {
                imageView.setPadding(0, ap.a(((a) this).f14092n, 10.0f), 0, 0);
            }
            TextView textView = this.Y;
            if (textView != null) {
                am.a(textView, "#71A0FF", 0, null, ap.a(((a) this).f14092n, 10.0f));
            }
            a(this.Y, this.Z);
            aH();
            az();
            aA();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public b(Context context, String str, long j6, long j7, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, com.beizi.fusion.c.d dVar, float f6, float f7) {
        super(context, str, j6, j7, buyerBean, forwardBean, dVar, f6, f7);
    }

    @Override // com.beizi.fusion.work.b.a
    public void a(com.beizi.ad.i iVar) {
        try {
            ImageView imageView = new ImageView(((a) this).f14092n);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(65, 65);
            imageView.setPadding(15, 8, 8, 15);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.beizi_close);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(65, 65);
            layoutParams2.gravity = 5;
            ((a) this).f14098t.addView(imageView, layoutParams2);
            imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.work.b.b.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        ((a) b.this).F = motionEvent.getX();
                        ((a) b.this).G = motionEvent.getY();
                        ((a) b.this).H = motionEvent.getRawX();
                        b.this.I = motionEvent.getRawY();
                        return false;
                    }
                    return false;
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.work.b.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        if (!b.this.aC()) {
                            b.this.aD();
                            return;
                        }
                        b bVar = b.this;
                        bVar.U = false;
                        b.this.a(new String[]{String.valueOf(((a) bVar).F), String.valueOf(((a) b.this).G), String.valueOf(((a) b.this).H), String.valueOf(b.this.I)}, 0);
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
