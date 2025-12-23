package com.beizi.ad.a.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.beizi.ad.internal.h.u;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private Context f11315a;

    /* renamed from: b, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.RegionalClickViewBean f11316b;

    /* renamed from: c, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.RegionalClickViewBean f11317c;

    /* renamed from: d, reason: collision with root package name */
    private a f11318d = null;

    /* renamed from: e, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.PercentPositionBean f11319e;

    /* renamed from: f, reason: collision with root package name */
    private String f11320f;

    /* renamed from: g, reason: collision with root package name */
    private String f11321g;

    /* renamed from: h, reason: collision with root package name */
    private double f11322h;

    /* renamed from: i, reason: collision with root package name */
    private String f11323i;

    /* renamed from: j, reason: collision with root package name */
    private int f11324j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071 A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003a, B:16:0x0045, B:18:0x004b, B:20:0x0052, B:22:0x0071, B:23:0x0077, B:25:0x00b3, B:27:0x00bd, B:29:0x00c3, B:31:0x00cb, B:33:0x00d1, B:34:0x00ee, B:36:0x00f4, B:37:0x0111, B:39:0x0117, B:40:0x0134, B:42:0x013a, B:43:0x0158, B:45:0x017a, B:47:0x017e, B:48:0x0180, B:50:0x014b, B:52:0x0151, B:54:0x0128, B:56:0x012e, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:67:0x00b9, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d1 A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003a, B:16:0x0045, B:18:0x004b, B:20:0x0052, B:22:0x0071, B:23:0x0077, B:25:0x00b3, B:27:0x00bd, B:29:0x00c3, B:31:0x00cb, B:33:0x00d1, B:34:0x00ee, B:36:0x00f4, B:37:0x0111, B:39:0x0117, B:40:0x0134, B:42:0x013a, B:43:0x0158, B:45:0x017a, B:47:0x017e, B:48:0x0180, B:50:0x014b, B:52:0x0151, B:54:0x0128, B:56:0x012e, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:67:0x00b9, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f4 A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003a, B:16:0x0045, B:18:0x004b, B:20:0x0052, B:22:0x0071, B:23:0x0077, B:25:0x00b3, B:27:0x00bd, B:29:0x00c3, B:31:0x00cb, B:33:0x00d1, B:34:0x00ee, B:36:0x00f4, B:37:0x0111, B:39:0x0117, B:40:0x0134, B:42:0x013a, B:43:0x0158, B:45:0x017a, B:47:0x017e, B:48:0x0180, B:50:0x014b, B:52:0x0151, B:54:0x0128, B:56:0x012e, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:67:0x00b9, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0117 A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003a, B:16:0x0045, B:18:0x004b, B:20:0x0052, B:22:0x0071, B:23:0x0077, B:25:0x00b3, B:27:0x00bd, B:29:0x00c3, B:31:0x00cb, B:33:0x00d1, B:34:0x00ee, B:36:0x00f4, B:37:0x0111, B:39:0x0117, B:40:0x0134, B:42:0x013a, B:43:0x0158, B:45:0x017a, B:47:0x017e, B:48:0x0180, B:50:0x014b, B:52:0x0151, B:54:0x0128, B:56:0x012e, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:67:0x00b9, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013a A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003a, B:16:0x0045, B:18:0x004b, B:20:0x0052, B:22:0x0071, B:23:0x0077, B:25:0x00b3, B:27:0x00bd, B:29:0x00c3, B:31:0x00cb, B:33:0x00d1, B:34:0x00ee, B:36:0x00f4, B:37:0x0111, B:39:0x0117, B:40:0x0134, B:42:0x013a, B:43:0x0158, B:45:0x017a, B:47:0x017e, B:48:0x0180, B:50:0x014b, B:52:0x0151, B:54:0x0128, B:56:0x012e, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:67:0x00b9, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x017a A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003a, B:16:0x0045, B:18:0x004b, B:20:0x0052, B:22:0x0071, B:23:0x0077, B:25:0x00b3, B:27:0x00bd, B:29:0x00c3, B:31:0x00cb, B:33:0x00d1, B:34:0x00ee, B:36:0x00f4, B:37:0x0111, B:39:0x0117, B:40:0x0134, B:42:0x013a, B:43:0x0158, B:45:0x017a, B:47:0x017e, B:48:0x0180, B:50:0x014b, B:52:0x0151, B:54:0x0128, B:56:0x012e, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:67:0x00b9, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x017e A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003a, B:16:0x0045, B:18:0x004b, B:20:0x0052, B:22:0x0071, B:23:0x0077, B:25:0x00b3, B:27:0x00bd, B:29:0x00c3, B:31:0x00cb, B:33:0x00d1, B:34:0x00ee, B:36:0x00f4, B:37:0x0111, B:39:0x0117, B:40:0x0134, B:42:0x013a, B:43:0x0158, B:45:0x017a, B:47:0x017e, B:48:0x0180, B:50:0x014b, B:52:0x0151, B:54:0x0128, B:56:0x012e, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:67:0x00b9, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014b A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003a, B:16:0x0045, B:18:0x004b, B:20:0x0052, B:22:0x0071, B:23:0x0077, B:25:0x00b3, B:27:0x00bd, B:29:0x00c3, B:31:0x00cb, B:33:0x00d1, B:34:0x00ee, B:36:0x00f4, B:37:0x0111, B:39:0x0117, B:40:0x0134, B:42:0x013a, B:43:0x0158, B:45:0x017a, B:47:0x017e, B:48:0x0180, B:50:0x014b, B:52:0x0151, B:54:0x0128, B:56:0x012e, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:67:0x00b9, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0128 A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003a, B:16:0x0045, B:18:0x004b, B:20:0x0052, B:22:0x0071, B:23:0x0077, B:25:0x00b3, B:27:0x00bd, B:29:0x00c3, B:31:0x00cb, B:33:0x00d1, B:34:0x00ee, B:36:0x00f4, B:37:0x0111, B:39:0x0117, B:40:0x0134, B:42:0x013a, B:43:0x0158, B:45:0x017a, B:47:0x017e, B:48:0x0180, B:50:0x014b, B:52:0x0151, B:54:0x0128, B:56:0x012e, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:67:0x00b9, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0105 A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003a, B:16:0x0045, B:18:0x004b, B:20:0x0052, B:22:0x0071, B:23:0x0077, B:25:0x00b3, B:27:0x00bd, B:29:0x00c3, B:31:0x00cb, B:33:0x00d1, B:34:0x00ee, B:36:0x00f4, B:37:0x0111, B:39:0x0117, B:40:0x0134, B:42:0x013a, B:43:0x0158, B:45:0x017a, B:47:0x017e, B:48:0x0180, B:50:0x014b, B:52:0x0151, B:54:0x0128, B:56:0x012e, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:67:0x00b9, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e2 A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003a, B:16:0x0045, B:18:0x004b, B:20:0x0052, B:22:0x0071, B:23:0x0077, B:25:0x00b3, B:27:0x00bd, B:29:0x00c3, B:31:0x00cb, B:33:0x00d1, B:34:0x00ee, B:36:0x00f4, B:37:0x0111, B:39:0x0117, B:40:0x0134, B:42:0x013a, B:43:0x0158, B:45:0x017a, B:47:0x017e, B:48:0x0180, B:50:0x014b, B:52:0x0151, B:54:0x0128, B:56:0x012e, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:67:0x00b9, B:4:0x01c1), top: B:7:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int[] b(android.view.ViewGroup r20) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.a.a.c.b(android.view.ViewGroup):int[]");
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            try {
                if (this.f11315a == null) {
                    return;
                }
                TextView textView = new TextView(this.f11315a);
                textView.setVisibility(0);
                textView.setLines(1);
                textView.setGravity(17);
                textView.setMaxLines(1);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                if (this.f11324j == 0) {
                    textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.a.a.c.1

                        /* renamed from: a, reason: collision with root package name */
                        float f11325a;

                        /* renamed from: b, reason: collision with root package name */
                        float f11326b;

                        /* renamed from: c, reason: collision with root package name */
                        float f11327c;

                        /* renamed from: d, reason: collision with root package name */
                        float f11328d;

                        /* renamed from: e, reason: collision with root package name */
                        float f11329e;

                        /* renamed from: f, reason: collision with root package name */
                        float f11330f;

                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            int action = motionEvent.getAction();
                            if (action != 0) {
                                if (action != 1) {
                                    if (action == 2) {
                                        this.f11329e = motionEvent.getX();
                                        this.f11330f = motionEvent.getY();
                                    }
                                } else if (Math.abs(this.f11329e - this.f11325a) <= 15.0f && Math.abs(this.f11330f - this.f11326b) <= 15.0f && c.this.f11318d != null) {
                                    c.this.f11318d.a(String.valueOf(this.f11325a), String.valueOf(this.f11326b), String.valueOf(this.f11327c), String.valueOf(this.f11328d), String.valueOf(this.f11325a), String.valueOf(this.f11326b), String.valueOf(this.f11327c), String.valueOf(this.f11328d));
                                }
                            } else {
                                this.f11325a = motionEvent.getX();
                                this.f11326b = motionEvent.getY();
                                this.f11327c = motionEvent.getRawX();
                                this.f11328d = motionEvent.getRawY();
                                this.f11329e = motionEvent.getX();
                                this.f11330f = motionEvent.getY();
                            }
                            return true;
                        }
                    });
                }
                if (!TextUtils.isEmpty(this.f11323i)) {
                    textView.setText(this.f11323i);
                }
                if (TextUtils.isEmpty(this.f11320f)) {
                    this.f11320f = "#FFFFFF";
                }
                if (!TextUtils.isEmpty(this.f11320f) && this.f11320f.startsWith("#")) {
                    textView.setTextColor(Color.parseColor(this.f11320f));
                }
                if (TextUtils.isEmpty(this.f11321g)) {
                    this.f11321g = "#80000000";
                }
                GradientDrawable gradientDrawable = new GradientDrawable();
                if (!TextUtils.isEmpty(this.f11321g) && this.f11321g.startsWith("#")) {
                    gradientDrawable.setColor(Color.parseColor(this.f11321g));
                }
                double d6 = this.f11322h;
                if (d6 > 0.0d) {
                    gradientDrawable.setAlpha((int) (d6 * 255.0d));
                }
                gradientDrawable.setCornerRadius(u.a(this.f11315a, 7.0f));
                textView.setBackgroundDrawable(gradientDrawable);
                int[] b6 = b(viewGroup);
                try {
                    textView.setTextSize(2, (float) (b6[1] > 0 ? u.b(this.f11315a, r7) / 3 : 14.0d));
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
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
                    viewGroup.addView(textView, layoutParams);
                    return;
                }
                if (viewGroup instanceof FrameLayout) {
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
                    viewGroup.addView(textView, layoutParams2);
                    return;
                }
                if (!(viewGroup instanceof LinearLayout)) {
                    ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-1, -2);
                    int i10 = b6[0];
                    if (i10 > 0) {
                        layoutParams3.width = i10;
                    }
                    int i11 = b6[1];
                    if (i11 > 0) {
                        layoutParams3.height = i11;
                    }
                    viewGroup.addView(textView, layoutParams3);
                    return;
                }
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                int i12 = b6[0];
                if (i12 > 0) {
                    layoutParams4.width = i12;
                }
                int i13 = b6[1];
                if (i13 > 0) {
                    layoutParams4.height = i13;
                }
                layoutParams4.leftMargin = b6[2];
                layoutParams4.topMargin = b6[3];
                viewGroup.addView(textView, layoutParams4);
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        }
    }

    public c(Context context, AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean, String str, boolean z5) {
        this.f11320f = null;
        this.f11321g = null;
        this.f11322h = 0.0d;
        this.f11323i = null;
        this.f11324j = 0;
        try {
            this.f11315a = context;
            this.f11316b = regionalClickViewBean;
            AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean a6 = a(regionalClickViewBean.getOrderData(), str);
            if (a6 != null && a6.getRegionalClickView() != null) {
                this.f11317c = a6.getRegionalClickView();
            }
            AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean2 = this.f11317c;
            if (regionalClickViewBean2 != null) {
                if (!z5) {
                    this.f11323i = regionalClickViewBean2.getTitle();
                } else {
                    String downloadTitle = regionalClickViewBean2.getDownloadTitle();
                    this.f11323i = downloadTitle;
                    if (TextUtils.isEmpty(downloadTitle)) {
                        this.f11323i = "点击下载应用";
                    }
                }
                this.f11319e = this.f11317c.getPosition();
                this.f11320f = this.f11317c.getTitleColor();
                this.f11321g = this.f11317c.getBackgroundColor();
                this.f11322h = this.f11317c.getBackgroundAlpha();
                this.f11324j = this.f11317c.getIsDisableClick();
            } else {
                AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean3 = this.f11316b;
                if (regionalClickViewBean3 != null) {
                    if (!z5) {
                        this.f11323i = regionalClickViewBean3.getTitle();
                    } else {
                        String downloadTitle2 = regionalClickViewBean3.getDownloadTitle();
                        this.f11323i = downloadTitle2;
                        if (TextUtils.isEmpty(downloadTitle2)) {
                            this.f11323i = "点击下载应用";
                        }
                    }
                    this.f11319e = this.f11316b.getPosition();
                    this.f11320f = this.f11316b.getTitleColor();
                    this.f11321g = this.f11316b.getBackgroundColor();
                    this.f11322h = this.f11316b.getBackgroundAlpha();
                    this.f11324j = this.f11316b.getIsDisableClick();
                }
            }
            if (TextUtils.isEmpty(this.f11323i)) {
                this.f11323i = "点击跳转网页或第三方应用";
            }
            if (TextUtils.isEmpty(this.f11321g)) {
                this.f11321g = "#3976FF";
            }
            if (TextUtils.isEmpty(this.f11320f)) {
                this.f11320f = "#FFFFFF";
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void b() {
        this.f11316b = null;
        this.f11317c = null;
        this.f11319e = null;
        this.f11318d = null;
        this.f11315a = null;
    }

    public void a(LinearLayout linearLayout, TextView textView) {
        if (linearLayout == null || textView == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(this.f11323i)) {
                textView.setText(this.f11323i);
            }
            if (this.f11324j != 0) {
                return;
            }
            linearLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.a.a.c.2

                /* renamed from: a, reason: collision with root package name */
                float f11332a;

                /* renamed from: b, reason: collision with root package name */
                float f11333b;

                /* renamed from: c, reason: collision with root package name */
                float f11334c;

                /* renamed from: d, reason: collision with root package name */
                float f11335d;

                /* renamed from: e, reason: collision with root package name */
                float f11336e;

                /* renamed from: f, reason: collision with root package name */
                float f11337f;

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action != 0) {
                        if (action != 1) {
                            if (action == 2) {
                                this.f11336e = motionEvent.getX();
                                this.f11337f = motionEvent.getY();
                            }
                        } else if (Math.abs(this.f11336e - this.f11332a) <= 15.0f && Math.abs(this.f11337f - this.f11333b) <= 15.0f && c.this.f11318d != null) {
                            c.this.f11318d.a(String.valueOf(this.f11332a), String.valueOf(this.f11333b), String.valueOf(this.f11334c), String.valueOf(this.f11335d), String.valueOf(this.f11332a), String.valueOf(this.f11333b), String.valueOf(this.f11334c), String.valueOf(this.f11335d));
                        }
                    } else {
                        this.f11332a = motionEvent.getX();
                        this.f11333b = motionEvent.getY();
                        this.f11334c = motionEvent.getRawX();
                        this.f11335d = motionEvent.getRawY();
                        this.f11336e = motionEvent.getX();
                        this.f11337f = motionEvent.getY();
                    }
                    return true;
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void a(a aVar) {
        this.f11318d = aVar;
    }

    private AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean a(List<AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean orderDataRegionalClickViewBean : list) {
                List<String> orderList = orderDataRegionalClickViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataRegionalClickViewBean;
                }
            }
        }
        return null;
    }

    public String a() {
        return this.f11321g;
    }
}
