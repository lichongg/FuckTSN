package cn.jpush.android.u;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.ui.RoundedImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends e {

    /* renamed from: g, reason: collision with root package name */
    private View f3832g;

    /* renamed from: h, reason: collision with root package name */
    private RoundedImageView f3833h;

    /* renamed from: i, reason: collision with root package name */
    private RoundedImageView f3834i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f3835j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f3836k;

    /* renamed from: l, reason: collision with root package name */
    private View f3837l;

    /* renamed from: m, reason: collision with root package name */
    private View f3838m;

    @Override // cn.jpush.android.u.e
    protected void a() {
        this.f3832g = b("banner_content");
        this.f3833h = (RoundedImageView) b("image_only");
        this.f3835j = (TextView) b("text_content");
        this.f3836k = (TextView) b("text_title");
        this.f3834i = (RoundedImageView) b("image_small");
        this.f3837l = b("banner");
        this.f3838m = b("bg_view");
    }

    @Override // cn.jpush.android.u.e
    protected String b() {
        return "jpush_banner";
    }

    @Override // cn.jpush.android.u.b
    public void d() {
        try {
            JSONObject jSONObject = new JSONObject(this.f3843b.f3593i);
            JSONObject optJSONObject = jSONObject.optJSONObject(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3837l.getLayoutParams();
            layoutParams.leftMargin = a(14);
            layoutParams.width = a(MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS);
            layoutParams.rightMargin = a(14);
            if (optJSONObject != null) {
                final int optInt = optJSONObject.optInt("type");
                final String optString = optJSONObject.optString(com.umeng.ccg.a.f41544t);
                ((e) this).f3874f.setOnClickListener(new View.OnClickListener() { // from class: cn.jpush.android.u.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.a(optInt, optString, 1);
                    }
                });
            }
            if (11 == this.f3846e) {
                layoutParams.height = b(92);
                this.f3837l.setLayoutParams(layoutParams);
                this.f3838m.setVisibility(8);
                this.f3833h.setVisibility(0);
                String string = jSONObject.getString(SocializeProtocolConstants.IMAGE);
                this.f3833h.setRadius(45, 45, 45, 45);
                a(this.f3833h, string, null, -1, -1, -1);
                return;
            }
            this.f3838m.setVisibility(0);
            this.f3833h.setVisibility(8);
            this.f3837l.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f3832g.getLayoutParams();
            layoutParams2.leftMargin = a(17);
            layoutParams2.rightMargin = a(19);
            layoutParams2.topMargin = b(15);
            layoutParams2.bottomMargin = b(12);
            this.f3832g.setLayoutParams(layoutParams2);
            JSONObject jSONObject2 = jSONObject.getJSONObject("banner");
            try {
                if (jSONObject2.has("small_image")) {
                    String optString2 = jSONObject2.optString("small_image");
                    if (!TextUtils.isEmpty(optString2)) {
                        this.f3834i.setVisibility(0);
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f3834i.getLayoutParams();
                        layoutParams3.width = a(42);
                        layoutParams3.height = a(42);
                        this.f3834i.setLayoutParams(layoutParams3);
                        this.f3834i.setRadius(0, 0, 0, 0);
                        a(this.f3834i, optString2, null, -1, -1, -1);
                        a(this.f3836k, jSONObject2.getJSONObject("title"), -1);
                        a(this.f3835j, jSONObject2.getJSONObject("content"), -1);
                    }
                }
                this.f3834i.setVisibility(8);
                a(this.f3836k, jSONObject2.getJSONObject("title"), -1);
                a(this.f3835j, jSONObject2.getJSONObject("content"), -1);
            } catch (Throwable th) {
                Logger.d("BaseInAppWrapper", "banner bindDataToView throwable=" + th);
            }
        } catch (Throwable th2) {
            Logger.d("BaseInAppWrapper", "banner bindDataToView throwable=" + th2);
        }
    }

    public a(Context context, cn.jpush.android.t.a aVar, cn.jpush.android.d.d dVar, int i6) {
        super(context, aVar, dVar, i6);
    }

    @Override // cn.jpush.android.u.b
    public void c() {
    }
}
