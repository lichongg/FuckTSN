package cn.jpush.android.u;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import cn.jpush.android.helper.Logger;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c extends e {

    /* renamed from: g, reason: collision with root package name */
    private ImageView f3854g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f3855h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f3856i;

    /* renamed from: j, reason: collision with root package name */
    private View f3857j;

    @Override // cn.jpush.android.u.e
    protected void a() {
        this.f3855h = (ImageView) b(SocializeProtocolConstants.IMAGE);
        this.f3856i = (TextView) b("btn_countdown");
        this.f3854g = (ImageView) b("image_close");
        this.f3857j = b("countdown_container");
    }

    @Override // cn.jpush.android.u.e
    protected String b() {
        return "jpush_full";
    }

    @Override // cn.jpush.android.u.b
    public void d() {
        View view;
        View.OnClickListener onClickListener;
        try {
            JSONObject jSONObject = new JSONObject(this.f3843b.f3593i);
            if (31 == this.f3846e) {
                this.f3854g.setVisibility(0);
                this.f3856i.setVisibility(8);
                view = this.f3854g;
                onClickListener = new View.OnClickListener() { // from class: cn.jpush.android.u.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        c.this.a(3, (String) null, 2);
                    }
                };
            } else {
                this.f3854g.setVisibility(8);
                this.f3856i.setVisibility(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3857j.getLayoutParams();
                layoutParams.width = a(140);
                this.f3857j.setLayoutParams(layoutParams);
                a(this.f3856i, jSONObject.getJSONObject("full"), 3);
                view = this.f3856i;
                onClickListener = new View.OnClickListener() { // from class: cn.jpush.android.u.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        c.this.a(3, (String) null, 3);
                    }
                };
            }
            view.setOnClickListener(onClickListener);
            String string = jSONObject.getString(SocializeProtocolConstants.IMAGE);
            JSONObject optJSONObject = jSONObject.optJSONObject(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK);
            DisplayMetrics displayMetrics = this.f3845d.getResources().getDisplayMetrics();
            a(this.f3855h, string, optJSONObject, 1, displayMetrics.widthPixels, displayMetrics.heightPixels);
        } catch (Throwable th) {
            Logger.d("BaseInAppWrapper", "full bindDataToView throwable=" + th);
        }
    }

    @Override // cn.jpush.android.u.e, cn.jpush.android.u.b
    public void g() {
        a(this.f3856i);
    }

    public c(Context context, cn.jpush.android.t.a aVar, cn.jpush.android.d.d dVar, int i6) {
        super(context, aVar, dVar, i6);
    }

    @Override // cn.jpush.android.u.b
    public void c() {
    }
}
