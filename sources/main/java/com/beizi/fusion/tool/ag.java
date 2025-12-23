package com.beizi.fusion.tool;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.RegionClickView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ag {

    /* renamed from: d, reason: collision with root package name */
    private static String f13588d;

    /* renamed from: e, reason: collision with root package name */
    private static String f13589e;

    /* renamed from: f, reason: collision with root package name */
    private static String f13590f;

    /* renamed from: g, reason: collision with root package name */
    private static String f13591g;

    /* renamed from: a, reason: collision with root package name */
    private Context f13592a;

    /* renamed from: b, reason: collision with root package name */
    private a f13593b;

    /* renamed from: c, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.RegionalClickViewBean f13594c = null;

    /* renamed from: h, reason: collision with root package name */
    private Boolean f13595h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public ag(Context context) {
        this.f13592a = context;
    }

    public void a(AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean) {
        this.f13594c = regionalClickViewBean;
    }

    public View a(int i6, int i7, AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean, boolean z5) {
        if (this.f13592a == null || percentPositionBean == null) {
            return null;
        }
        aa.c("BeiZis", "adWidthDp = " + i6 + ",adHeightDp = " + i7);
        RegionClickView regionClickView = new RegionClickView(this.f13592a);
        if (this.f13594c != null) {
            regionClickView.setDownloadApp(this.f13595h);
            regionClickView.setRegionalClickViewBean(this.f13594c);
        }
        regionClickView.setLayoutParams(a(i6, i7, percentPositionBean));
        if (z5) {
            regionClickView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.tool.ag.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ag.this.f13593b != null) {
                        ag.this.f13593b.a(ag.f13588d, ag.f13589e, ag.f13590f, ag.f13591g, ag.f13588d, ag.f13589e, ag.f13590f, ag.f13591g);
                    }
                }
            });
            regionClickView.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.fusion.tool.ag.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                        if (motionEvent.getAction() != 0) {
                            return false;
                        }
                        String unused = ag.f13588d = motionEvent.getX() + "";
                        String unused2 = ag.f13589e = motionEvent.getY() + "";
                        String unused3 = ag.f13590f = motionEvent.getRawX() + "";
                        String unused4 = ag.f13591g = motionEvent.getRawY() + "";
                        return false;
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        return false;
                    }
                }
            });
        }
        return regionClickView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00fd, code lost:
    
        if (r2 >= 400) goto L43;
     */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.ViewGroup.MarginLayoutParams a(int r11, int r12, com.beizi.fusion.model.AdSpacesBean.BuyerBean.PercentPositionBean r13) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.tool.ag.a(int, int, com.beizi.fusion.model.AdSpacesBean$BuyerBean$PercentPositionBean):android.view.ViewGroup$MarginLayoutParams");
    }

    public void a(a aVar) {
        this.f13593b = aVar;
    }

    public void a() {
        this.f13592a = null;
        this.f13594c = null;
    }

    public void a(Boolean bool) {
        this.f13595h = bool;
    }
}
