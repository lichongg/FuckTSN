package cn.jpush.android.u;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.jpush.android.ad.m;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.ui.RoundedImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d extends e {

    /* renamed from: g, reason: collision with root package name */
    private TextView f3860g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f3861h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f3862i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f3863j;

    /* renamed from: k, reason: collision with root package name */
    private ImageView f3864k;

    /* renamed from: l, reason: collision with root package name */
    private ImageView f3865l;

    /* renamed from: m, reason: collision with root package name */
    private View f3866m;

    /* renamed from: n, reason: collision with root package name */
    private View f3867n;

    /* renamed from: o, reason: collision with root package name */
    private View f3868o;

    /* renamed from: p, reason: collision with root package name */
    private View f3869p;

    /* renamed from: q, reason: collision with root package name */
    private FrameLayout f3870q;

    /* renamed from: r, reason: collision with root package name */
    private RoundedImageView f3871r;

    /* renamed from: s, reason: collision with root package name */
    private RoundedImageView f3872s;

    private void l() {
        this.f3871r.setVisibility(8);
        GradientDrawable gradientDrawable = (GradientDrawable) this.f3868o.getBackground();
        gradientDrawable.mutate();
        gradientDrawable.setCornerRadius(m.a(this.f3845d, 15));
    }

    @Override // cn.jpush.android.u.e
    protected void a() {
        this.f3871r = (RoundedImageView) b(SocializeProtocolConstants.IMAGE);
        this.f3865l = (ImageView) b("img_bottom_close");
        this.f3864k = (ImageView) b("img_top_close");
        this.f3872s = (RoundedImageView) b("image_only");
        this.f3863j = (TextView) b("btn_two");
        this.f3862i = (TextView) b("btn_one");
        this.f3861h = (TextView) b("text_content");
        this.f3860g = (TextView) b("text_title");
        this.f3866m = b("content_view");
        this.f3870q = (FrameLayout) b("frame");
        this.f3867n = b("margeview");
        this.f3868o = b("bg_view");
        this.f3869p = b("btn_parent_view");
        this.f3861h.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.f3861h.setMaxHeight(b(150));
    }

    @Override // cn.jpush.android.u.e
    protected String b() {
        return "jpush_interstitial";
    }

    @Override // cn.jpush.android.u.b
    public void c() {
        if (((e) this).f3874f != null) {
            ((e) this).f3874f = null;
        }
    }

    @Override // cn.jpush.android.u.b
    public void d() {
        JSONArray optJSONArray;
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(this.f3843b.f3593i);
            int a6 = a(30);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3870q.getLayoutParams();
            layoutParams.leftMargin = a6;
            layoutParams.rightMargin = a6;
            this.f3870q.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f3864k.getLayoutParams();
            layoutParams2.rightMargin = a6;
            this.f3864k.setLayoutParams(layoutParams2);
            if (21 == this.f3846e) {
                this.f3872s.setVisibility(0);
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f3872s.getLayoutParams();
                layoutParams3.width = a(MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT);
                layoutParams3.height = b(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP);
                this.f3872s.setLayoutParams(layoutParams3);
                this.f3871r.setRadius(45, 45, 45, 45);
                this.f3866m.setVisibility(8);
                if (jSONObject2.has(SocializeProtocolConstants.IMAGE)) {
                    a(this.f3872s, jSONObject2.getString(SocializeProtocolConstants.IMAGE), jSONObject2.optJSONObject(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK), 1, a(MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT), b(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP));
                }
            } else {
                this.f3872s.setVisibility(8);
                this.f3866m.setVisibility(0);
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f3867n.getLayoutParams();
                layoutParams4.leftMargin = a(22);
                layoutParams4.rightMargin = a(21);
                this.f3867n.setLayoutParams(layoutParams4);
                if (jSONObject2.has(SocializeProtocolConstants.IMAGE)) {
                    String optString = jSONObject2.optString(SocializeProtocolConstants.IMAGE);
                    if (!TextUtils.isEmpty(optString)) {
                        this.f3871r.setVisibility(0);
                        a(this.f3871r, optString, jSONObject2.optJSONObject(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK), 1, a(22), a(22));
                        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.f3871r.getLayoutParams();
                        layoutParams5.height = b(MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO);
                        layoutParams5.width = a(MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT);
                        this.f3871r.setLayoutParams(layoutParams5);
                        this.f3871r.setRadius(45, 45, 0, 0);
                    }
                }
                l();
            }
            JSONObject jSONObject3 = jSONObject2.getJSONObject(MediationConstant.RIT_TYPE_INTERSTITIAL);
            if (jSONObject3.has("title")) {
                JSONObject optJSONObject = jSONObject3.optJSONObject("title");
                if (optJSONObject == null) {
                    return;
                }
                this.f3860g.setVisibility(0);
                a(this.f3860g, optJSONObject, -1);
            } else {
                this.f3860g.setVisibility(8);
            }
            if (jSONObject3.has("content")) {
                JSONObject optJSONObject2 = jSONObject3.optJSONObject("content");
                if (optJSONObject2 == null) {
                    return;
                }
                this.f3861h.setVisibility(0);
                a(this.f3861h, optJSONObject2, -1);
            } else {
                this.f3861h.setVisibility(8);
            }
            if (jSONObject3.has("close_location")) {
                int optInt = jSONObject3.optInt("close_location", 1);
                ImageView imageView = optInt == 1 ? this.f3865l : optInt == 2 ? this.f3864k : null;
                if (imageView == null) {
                    return;
                }
                imageView.setVisibility(0);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: cn.jpush.android.u.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.a(3, "", 2);
                    }
                });
            } else {
                this.f3865l.setVisibility(8);
                this.f3864k.setVisibility(8);
            }
            if (jSONObject3.has("buttons") && (optJSONArray = jSONObject3.optJSONArray("buttons")) != null && optJSONArray.length() > 0) {
                this.f3869p.setVisibility(0);
                if (optJSONArray.length() > 1) {
                    this.f3862i.setVisibility(0);
                    a(this.f3862i, (JSONObject) optJSONArray.get(0), 4);
                    jSONObject = (JSONObject) optJSONArray.get(1);
                } else {
                    this.f3862i.setVisibility(8);
                    jSONObject = (JSONObject) optJSONArray.get(0);
                }
                a(this.f3863j, jSONObject, 5);
                return;
            }
            this.f3869p.setVisibility(8);
        } catch (Throwable th) {
            Logger.d("BaseInAppWrapper", "interstitial bindDataToView throwable=" + th);
        }
    }

    public d(Context context, cn.jpush.android.t.a aVar, cn.jpush.android.d.d dVar, int i6) {
        super(context, aVar, dVar, i6);
    }
}
