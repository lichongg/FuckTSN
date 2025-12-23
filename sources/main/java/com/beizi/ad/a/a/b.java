package com.beizi.ad.a.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Context f11301a;

    /* renamed from: b, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.FullScreenClickBean f11302b;

    /* renamed from: c, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.FullScreenClickBean f11303c;

    /* renamed from: e, reason: collision with root package name */
    private int f11305e;

    /* renamed from: d, reason: collision with root package name */
    private a f11304d = null;

    /* renamed from: f, reason: collision with root package name */
    private boolean f11306f = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public void a(View view, final a aVar) {
        if (view == null || aVar == null || !a(this.f11305e)) {
            return;
        }
        this.f11306f = true;
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.a.a.b.1

            /* renamed from: a, reason: collision with root package name */
            float f11307a;

            /* renamed from: b, reason: collision with root package name */
            float f11308b;

            /* renamed from: c, reason: collision with root package name */
            float f11309c;

            /* renamed from: d, reason: collision with root package name */
            float f11310d;

            /* renamed from: e, reason: collision with root package name */
            float f11311e;

            /* renamed from: f, reason: collision with root package name */
            float f11312f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a aVar2;
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            this.f11311e = motionEvent.getX();
                            this.f11312f = motionEvent.getY();
                        }
                    } else if (Math.abs(this.f11311e - this.f11307a) <= 15.0f && Math.abs(this.f11312f - this.f11308b) <= 15.0f && (aVar2 = aVar) != null) {
                        aVar2.a(String.valueOf(this.f11307a), String.valueOf(this.f11308b), String.valueOf(this.f11309c), String.valueOf(this.f11310d), String.valueOf(this.f11307a), String.valueOf(this.f11308b), String.valueOf(this.f11309c), String.valueOf(this.f11310d));
                    }
                } else {
                    this.f11307a = motionEvent.getX();
                    this.f11308b = motionEvent.getY();
                    this.f11309c = motionEvent.getRawX();
                    this.f11310d = motionEvent.getRawY();
                    this.f11311e = motionEvent.getX();
                    this.f11312f = motionEvent.getY();
                }
                return true;
            }
        });
    }

    public void b() {
        this.f11302b = null;
        this.f11303c = null;
        this.f11304d = null;
        this.f11301a = null;
    }

    public b(Context context, AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClickBean, String str) {
        this.f11301a = context;
        this.f11302b = fullScreenClickBean;
        AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean a6 = a(fullScreenClickBean.getOrderData(), str);
        if (a6 != null && a6.getFullScreenClick() != null) {
            this.f11303c = a6.getFullScreenClick();
        }
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClickBean2 = this.f11303c;
        if (fullScreenClickBean2 != null) {
            this.f11305e = fullScreenClickBean2.getRandomClickNum();
            return;
        }
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClickBean3 = this.f11302b;
        if (fullScreenClickBean3 != null) {
            this.f11305e = fullScreenClickBean3.getRandomClickNum();
        }
    }

    public static boolean a(int i6) {
        return ((int) ((Math.random() * 100.0d) + 1.0d)) <= i6;
    }

    private AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean a(List<AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean orderDataFullScreenClickBean : list) {
                List<String> orderList = orderDataFullScreenClickBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataFullScreenClickBean;
                }
            }
        }
        return null;
    }

    public boolean a() {
        return this.f11306f;
    }
}
