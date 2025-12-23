package com.beizi.ad.a.a;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.beizi.ad.lance.a.m;
import com.beizi.fusion.R;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.ScrollClickView;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private Context f11339a;

    /* renamed from: b, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.ScrollClickBean f11340b;

    /* renamed from: c, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.ScrollClickBean f11341c;

    /* renamed from: d, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.ScrollClickPositionBean f11342d;

    /* renamed from: f, reason: collision with root package name */
    private View f11344f;

    /* renamed from: g, reason: collision with root package name */
    private String f11345g;

    /* renamed from: l, reason: collision with root package name */
    private int f11350l;

    /* renamed from: m, reason: collision with root package name */
    private ValueAnimator f11351m;

    /* renamed from: n, reason: collision with root package name */
    private int f11352n;

    /* renamed from: o, reason: collision with root package name */
    private ImageView f11353o;

    /* renamed from: p, reason: collision with root package name */
    private ImageView f11354p;

    /* renamed from: q, reason: collision with root package name */
    private ImageView f11355q;

    /* renamed from: u, reason: collision with root package name */
    private LinearLayout f11359u;

    /* renamed from: e, reason: collision with root package name */
    private a f11343e = null;

    /* renamed from: h, reason: collision with root package name */
    private String f11346h = "up";

    /* renamed from: i, reason: collision with root package name */
    private String f11347i = ScrollClickView.DIR_DOWN;

    /* renamed from: j, reason: collision with root package name */
    private String f11348j = ScrollClickView.DIR_LEFT;

    /* renamed from: k, reason: collision with root package name */
    private String f11349k = "right";

    /* renamed from: r, reason: collision with root package name */
    private String f11356r = "#9CBBFF";

    /* renamed from: s, reason: collision with root package name */
    private String f11357s = "#C1D4FF";

    /* renamed from: t, reason: collision with root package name */
    private String f11358t = "#FFFFFF";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

        void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    private void b() {
        this.f11359u.setGravity(17);
        int i6 = this.f11359u.getLayoutParams().width;
        int i7 = this.f11359u.getLayoutParams().height;
        this.f11353o = new ImageView(this.f11339a);
        this.f11354p = new ImageView(this.f11339a);
        this.f11355q = new ImageView(this.f11339a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.f11346h.equals(this.f11345g)) {
            this.f11359u.setOrientation(1);
            ImageView imageView = this.f11353o;
            int i8 = R.mipmap.beizi_interaction_icon_arrow_up;
            imageView.setImageResource(i8);
            this.f11354p.setImageResource(i8);
            this.f11355q.setImageResource(i8);
            this.f11353o.setColorFilter(Color.parseColor(this.f11356r));
            this.f11354p.setColorFilter(Color.parseColor(this.f11357s));
            this.f11355q.setColorFilter(Color.parseColor(this.f11358t));
            layoutParams.width = i6;
            layoutParams.height = i7 / 3;
        } else if (this.f11347i.equals(this.f11345g)) {
            this.f11359u.setOrientation(1);
            ImageView imageView2 = this.f11353o;
            int i9 = R.mipmap.beizi_interaction_icon_arrow_down;
            imageView2.setImageResource(i9);
            this.f11354p.setImageResource(i9);
            this.f11355q.setImageResource(i9);
            this.f11353o.setColorFilter(Color.parseColor(this.f11358t));
            this.f11354p.setColorFilter(Color.parseColor(this.f11357s));
            this.f11355q.setColorFilter(Color.parseColor(this.f11356r));
            layoutParams.width = i6;
            layoutParams.height = i7 / 3;
        } else if (this.f11348j.equals(this.f11345g)) {
            this.f11359u.setOrientation(0);
            ImageView imageView3 = this.f11353o;
            int i10 = R.mipmap.beizi_interaction_icon_arrow_left;
            imageView3.setImageResource(i10);
            this.f11354p.setImageResource(i10);
            this.f11355q.setImageResource(i10);
            this.f11353o.setColorFilter(Color.parseColor(this.f11356r));
            this.f11354p.setColorFilter(Color.parseColor(this.f11357s));
            this.f11355q.setColorFilter(Color.parseColor(this.f11358t));
            layoutParams.width = i6 / 3;
            layoutParams.height = i7;
        } else if (this.f11349k.equals(this.f11345g)) {
            this.f11359u.setOrientation(0);
            ImageView imageView4 = this.f11353o;
            int i11 = R.mipmap.beizi_interaction_icon_arrow_right;
            imageView4.setImageResource(i11);
            this.f11354p.setImageResource(i11);
            this.f11355q.setImageResource(i11);
            this.f11353o.setColorFilter(Color.parseColor(this.f11358t));
            this.f11354p.setColorFilter(Color.parseColor(this.f11357s));
            this.f11355q.setColorFilter(Color.parseColor(this.f11356r));
            layoutParams.width = i6 / 3;
            layoutParams.height = i7;
        }
        this.f11359u.addView(this.f11353o, layoutParams);
        this.f11359u.addView(this.f11354p, layoutParams);
        this.f11359u.addView(this.f11355q, layoutParams);
    }

    private void c() {
        View view = this.f11344f;
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.a.a.d.1

            /* renamed from: a, reason: collision with root package name */
            float f11360a;

            /* renamed from: b, reason: collision with root package name */
            float f11361b;

            /* renamed from: c, reason: collision with root package name */
            float f11362c;

            /* renamed from: d, reason: collision with root package name */
            float f11363d;

            /* renamed from: e, reason: collision with root package name */
            float f11364e;

            /* renamed from: f, reason: collision with root package name */
            float f11365f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f11360a = motionEvent.getX();
                    this.f11361b = motionEvent.getY();
                    this.f11362c = motionEvent.getX();
                    this.f11363d = motionEvent.getY();
                    this.f11364e = motionEvent.getRawX();
                    this.f11365f = motionEvent.getRawY();
                } else if (action == 1) {
                    m.b("BeiZisAd", "mCurPosX = " + this.f11362c + ",mCurPosY = " + this.f11363d + ",mPosX = " + this.f11360a + ",mPosY = " + this.f11361b);
                    float f6 = this.f11363d;
                    float f7 = this.f11361b;
                    if (f6 - f7 <= 0.0f || Math.abs(f6 - f7) <= d.this.f11350l) {
                        float f8 = this.f11363d;
                        float f9 = this.f11361b;
                        if (f8 - f9 >= 0.0f || Math.abs(f8 - f9) <= d.this.f11350l) {
                            float f10 = this.f11362c;
                            float f11 = this.f11360a;
                            if (f10 - f11 >= 0.0f || Math.abs(f10 - f11) <= d.this.f11350l) {
                                float f12 = this.f11362c;
                                float f13 = this.f11360a;
                                if (f12 - f13 <= 0.0f || Math.abs(f12 - f13) <= d.this.f11350l) {
                                    if (Math.abs(this.f11362c - this.f11360a) <= 15.0f && Math.abs(this.f11363d - this.f11361b) <= 15.0f && d.this.f11343e != null) {
                                        d.this.f11343e.b(this.f11360a + "", this.f11361b + "", this.f11364e + "", this.f11365f + "", this.f11360a + "", this.f11361b + "", this.f11364e + "", this.f11365f + "");
                                    }
                                } else if (d.this.f11349k.equalsIgnoreCase(d.this.f11345g) && d.this.f11343e != null) {
                                    d.this.f11343e.a(this.f11360a + "", this.f11361b + "", this.f11364e + "", this.f11365f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                                }
                            } else if (d.this.f11348j.equalsIgnoreCase(d.this.f11345g) && d.this.f11343e != null) {
                                d.this.f11343e.a(this.f11360a + "", this.f11361b + "", this.f11364e + "", this.f11365f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                            }
                        } else if (d.this.f11346h.equalsIgnoreCase(d.this.f11345g) && d.this.f11343e != null) {
                            d.this.f11343e.a(this.f11360a + "", this.f11361b + "", this.f11364e + "", this.f11365f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                        }
                    } else if (d.this.f11347i.equalsIgnoreCase(d.this.f11345g) && d.this.f11343e != null) {
                        d.this.f11343e.a(this.f11360a + "", this.f11361b + "", this.f11364e + "", this.f11365f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                    }
                } else if (action == 2) {
                    this.f11362c = motionEvent.getX();
                    this.f11363d = motionEvent.getY();
                }
                return true;
            }
        });
    }

    private void d() {
        try {
            ValueAnimator ofInt = ValueAnimator.ofInt(10, 0);
            this.f11351m = ofInt;
            ofInt.setDuration(500L);
            this.f11351m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.beizi.ad.a.a.d.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                }
            });
            this.f11351m.addListener(new AnimatorListenerAdapter() { // from class: com.beizi.ad.a.a.d.3
                /* JADX WARN: Removed duplicated region for block: B:15:0x01f4 A[Catch: Exception -> 0x005a, TryCatch #0 {Exception -> 0x005a, blocks: (B:3:0x0007, B:5:0x0021, B:8:0x0035, B:10:0x0047, B:13:0x01ec, B:15:0x01f4, B:16:0x01fa, B:18:0x0202, B:23:0x005d, B:25:0x0065, B:26:0x00a0, B:28:0x00a8, B:29:0x00e3, B:31:0x00eb, B:32:0x0126, B:34:0x012e, B:35:0x0169, B:37:0x0171, B:38:0x01ab, B:40:0x01b3), top: B:2:0x0007 }] */
                /* JADX WARN: Removed duplicated region for block: B:18:0x0202 A[Catch: Exception -> 0x005a, TRY_LEAVE, TryCatch #0 {Exception -> 0x005a, blocks: (B:3:0x0007, B:5:0x0021, B:8:0x0035, B:10:0x0047, B:13:0x01ec, B:15:0x01f4, B:16:0x01fa, B:18:0x0202, B:23:0x005d, B:25:0x0065, B:26:0x00a0, B:28:0x00a8, B:29:0x00e3, B:31:0x00eb, B:32:0x0126, B:34:0x012e, B:35:0x0169, B:37:0x0171, B:38:0x01ab, B:40:0x01b3), top: B:2:0x0007 }] */
                /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onAnimationEnd(android.animation.Animator r5) {
                    /*
                        Method dump skipped, instructions count: 528
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.a.a.d.AnonymousClass3.onAnimationEnd(android.animation.Animator):void");
                }
            });
            ValueAnimator valueAnimator = this.f11351m;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    static /* synthetic */ int h(d dVar) {
        int i6 = dVar.f11352n;
        dVar.f11352n = i6 + 1;
        return i6;
    }

    public d(Context context, AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean, String str, String str2) {
        try {
            this.f11339a = context;
            this.f11340b = scrollClickBean;
            AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean a6 = a(scrollClickBean.getOrderData(), str2);
            if (a6 != null && a6.getScrollClick() != null) {
                this.f11341c = a6.getScrollClick();
            }
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean2 = this.f11341c;
            if (scrollClickBean2 != null) {
                this.f11345g = scrollClickBean2.getScrollDirection();
                this.f11350l = this.f11341c.getScrollDistance();
                this.f11342d = this.f11341c.getPosition();
            } else {
                AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean3 = this.f11340b;
                if (scrollClickBean3 != null) {
                    this.f11345g = scrollClickBean3.getScrollDirection();
                    this.f11350l = this.f11340b.getScrollDistance();
                    this.f11342d = this.f11340b.getPosition();
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            try {
                if (this.f11339a == null) {
                    return;
                }
                this.f11359u = new LinearLayout(this.f11339a);
                int[] b6 = b(viewGroup);
                if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    int i6 = b6[0];
                    if (i6 > 0) {
                        layoutParams.width = i6;
                    }
                    int i7 = b6[1];
                    if (i7 > 0) {
                        layoutParams.height = i7;
                    }
                    layoutParams.leftMargin = b6[2];
                    layoutParams.topMargin = b6[3];
                    layoutParams.addRule(17);
                    viewGroup.addView(this.f11359u, layoutParams);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                    int i8 = b6[0];
                    if (i8 > 0) {
                        layoutParams2.width = i8;
                    }
                    int i9 = b6[1];
                    if (i9 > 0) {
                        layoutParams2.height = i9;
                    }
                    layoutParams2.leftMargin = b6[2];
                    layoutParams2.topMargin = b6[3];
                    viewGroup.addView(this.f11359u, layoutParams2);
                } else if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                    int i10 = b6[0];
                    if (i10 > 0) {
                        layoutParams3.width = i10;
                    }
                    int i11 = b6[1];
                    if (i11 > 0) {
                        layoutParams3.height = i11;
                    }
                    layoutParams3.leftMargin = b6[2];
                    layoutParams3.topMargin = b6[3];
                    viewGroup.addView(this.f11359u, layoutParams3);
                } else {
                    ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(-1, -2);
                    int i12 = b6[0];
                    if (i12 > 0) {
                        layoutParams4.width = i12;
                    }
                    int i13 = b6[1];
                    if (i13 > 0) {
                        layoutParams4.height = i13;
                    }
                    viewGroup.addView(this.f11359u, layoutParams4);
                }
                b();
                d();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    public void a(View view, a aVar) {
        this.f11344f = view;
        this.f11343e = aVar;
        c();
    }

    private AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean a(List<AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean orderDataScrollViewOrderBean : list) {
                List<String> orderList = orderDataScrollViewOrderBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataScrollViewOrderBean;
                }
            }
        }
        return null;
    }

    public void a() {
        try {
            this.f11344f = null;
            this.f11343e = null;
            this.f11341c = null;
            this.f11340b = null;
            ValueAnimator valueAnimator = this.f11351m;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.f11351m.removeAllListeners();
            }
            this.f11351m = null;
            this.f11353o = null;
            this.f11354p = null;
            this.f11355q = null;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0073 A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003e, B:16:0x0049, B:18:0x004f, B:20:0x0056, B:22:0x0073, B:23:0x0079, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d1 A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003e, B:16:0x0049, B:18:0x004f, B:20:0x0056, B:22:0x0073, B:23:0x0079, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f4 A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003e, B:16:0x0049, B:18:0x004f, B:20:0x0056, B:22:0x0073, B:23:0x0079, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0119 A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003e, B:16:0x0049, B:18:0x004f, B:20:0x0056, B:22:0x0073, B:23:0x0079, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013d A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003e, B:16:0x0049, B:18:0x004f, B:20:0x0056, B:22:0x0073, B:23:0x0079, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x017a A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003e, B:16:0x0049, B:18:0x004f, B:20:0x0056, B:22:0x0073, B:23:0x0079, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x017e A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003e, B:16:0x0049, B:18:0x004f, B:20:0x0056, B:22:0x0073, B:23:0x0079, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x014e A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003e, B:16:0x0049, B:18:0x004f, B:20:0x0056, B:22:0x0073, B:23:0x0079, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012a A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003e, B:16:0x0049, B:18:0x004f, B:20:0x0056, B:22:0x0073, B:23:0x0079, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0105 A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003e, B:16:0x0049, B:18:0x004f, B:20:0x0056, B:22:0x0073, B:23:0x0079, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e2 A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003e, B:16:0x0049, B:18:0x004f, B:20:0x0056, B:22:0x0073, B:23:0x0079, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int[] b(android.view.ViewGroup r20) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.a.a.d.b(android.view.ViewGroup):int[]");
    }
}
