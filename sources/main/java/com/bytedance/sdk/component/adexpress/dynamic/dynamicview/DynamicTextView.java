package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.adexpress.dynamic.r.qv;
import com.bytedance.sdk.component.adexpress.r.tl;
import com.bytedance.sdk.component.adexpress.widget.AnimationText;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.vl;
import com.snail.antifake.deviceid.e;
import com.tencent.open.SocialConstants;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicTextView extends DynamicBaseWidgetImp {
    private boolean g() {
        DynamicRootView dynamicRootView = this.ws;
        return (dynamicRootView == null || dynamicRootView.getRenderRequest() == null || this.ws.getRenderRequest().jy() == 4) ? false : true;
    }

    private void oq() {
        int j6;
        if (TextUtils.equals(this.jy.oq().getType(), SocialConstants.PARAM_SOURCE) || TextUtils.equals(this.jy.oq().getType(), "title") || TextUtils.equals(this.jy.oq().getType(), "text_star")) {
            int[] xt = qv.xt(this.vl.m(), this.vl.up(), true);
            int j7 = (int) tl.j(getContext(), this.vl.xt());
            int j8 = (int) tl.j(getContext(), this.vl.cw());
            int j9 = (int) tl.j(getContext(), this.vl.r());
            int j10 = (int) tl.j(getContext(), this.vl.j());
            int min = Math.min(j7, j10);
            if (TextUtils.equals(this.jy.oq().getType(), SocialConstants.PARAM_SOURCE) && (j6 = ((this.tl - ((int) tl.j(getContext(), this.vl.up()))) - j7) - j10) > 1 && j6 <= min * 2) {
                int i6 = j6 / 2;
                this.az.setPadding(j8, j7 - i6, j9, j10 - (j6 - i6));
                return;
            }
            int i7 = (((xt[1] + j7) + j10) - this.tl) - 2;
            if (i7 <= 1) {
                return;
            }
            if (i7 <= min * 2) {
                int i8 = i7 / 2;
                this.az.setPadding(j8, j7 - i8, j9, j10 - (i7 - i8));
            } else if (i7 > j7 + j10) {
                final int i9 = (i7 - j7) - j10;
                this.az.setPadding(j8, 0, j9, 0);
                if (i9 <= ((int) tl.j(getContext(), 1.0f)) + 1) {
                    ((TextView) this.az).setTextSize(this.vl.up() - 1.0f);
                } else if (i9 <= (((int) tl.j(getContext(), 1.0f)) + 1) * 2) {
                    ((TextView) this.az).setTextSize(this.vl.up() - 2.0f);
                } else {
                    post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicTextView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ViewGroup.LayoutParams layoutParams = DynamicTextView.this.az.getLayoutParams();
                                DynamicTextView dynamicTextView = DynamicTextView.this;
                                layoutParams.height = dynamicTextView.tl + i9;
                                dynamicTextView.az.setLayoutParams(layoutParams);
                                DynamicTextView.this.az.setTranslationY(-i9);
                                ((ViewGroup) DynamicTextView.this.az.getParent()).setClipChildren(false);
                                ((ViewGroup) DynamicTextView.this.az.getParent().getParent()).setClipChildren(false);
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } else if (j7 > j10) {
                this.az.setPadding(j8, j7 - (i7 - min), j9, j10 - min);
            } else {
                this.az.setPadding(j8, j7 - min, j9, j10 - (i7 - min));
            }
        }
        if (TextUtils.equals(this.jy.oq().getType(), "fillButton")) {
            this.az.setTextAlignment(2);
            ((TextView) this.az).setGravity(17);
        }
    }

    private void qv() {
        if (this.az instanceof AnimationText) {
            String text = getText();
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(text);
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    arrayList.add(jSONArray.optString(i6));
                }
            } catch (JSONException e6) {
                vl.j(e6);
                arrayList.add(text);
            }
            ((AnimationText) this.az).setMaxLines(1);
            ((AnimationText) this.az).setTextColor(this.vl.ae());
            ((AnimationText) this.az).setTextSize(this.vl.up());
            ((AnimationText) this.az).setAnimationText(arrayList);
            ((AnimationText) this.az).setAnimationType(this.vl.n());
            ((AnimationText) this.az).setAnimationDuration(this.vl.gx() * 1000);
            ((AnimationText) this.az).j();
        }
    }

    public String getText() {
        String m6 = this.vl.m();
        if (TextUtils.isEmpty(m6)) {
            if (!com.bytedance.sdk.component.adexpress.r.j() && TextUtils.equals(this.jy.oq().getType(), "text_star")) {
                m6 = "5";
            }
            if (!com.bytedance.sdk.component.adexpress.r.j() && TextUtils.equals(this.jy.oq().getType(), "score-count")) {
                m6 = "6870";
            }
        }
        return (TextUtils.equals(this.jy.oq().getType(), "title") || TextUtils.equals(this.jy.oq().getType(), MediaFormat.KEY_SUBTITLE)) ? m6.replace(e.f37542d, "") : m6;
    }

    public DynamicTextView(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar) {
        super(context, dynamicRootView, tlVar);
        this.tl += 6;
        if (this.vl.c()) {
            AnimationText animationText = new AnimationText(context, this.vl.ae(), this.vl.up(), 1, this.vl.tl());
            this.az = animationText;
            animationText.setMaxLines(1);
        } else {
            TextView textView = new TextView(context);
            this.az = textView;
            textView.setIncludeFontPadding(false);
        }
        this.az.setTag(Integer.valueOf(getClickArea()));
        addView(this.az, getWidgetLayoutParams());
    }

    public void j(TextView textView, int i6, Context context, String str) {
        textView.setText("(" + String.format(kt.j(context, str), Integer.valueOf(i6)) + ")");
        if (i6 == -1) {
            textView.setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.r
    public boolean tl() {
        int i6;
        double d6;
        super.tl();
        if (TextUtils.isEmpty(getText())) {
            this.az.setVisibility(4);
            return true;
        }
        if (this.vl.c()) {
            qv();
            return true;
        }
        ((TextView) this.az).setText(this.vl.m());
        ((TextView) this.az).setTextDirection(5);
        this.az.setTextAlignment(this.vl.tl());
        ((TextView) this.az).setTextColor(this.vl.ae());
        ((TextView) this.az).setTextSize(this.vl.up());
        if (!this.vl.f()) {
            ((TextView) this.az).setMaxLines(1);
            ((TextView) this.az).setGravity(17);
            ((TextView) this.az).setEllipsize(TextUtils.TruncateAt.END);
        } else {
            int v5 = this.vl.v();
            if (v5 > 0) {
                ((TextView) this.az).setLines(v5);
                ((TextView) this.az).setEllipsize(TextUtils.TruncateAt.END);
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar = this.jy;
        if (tlVar != null && tlVar.oq() != null) {
            if (com.bytedance.sdk.component.adexpress.r.j() && g() && (TextUtils.equals(this.jy.oq().getType(), "text_star") || TextUtils.equals(this.jy.oq().getType(), "score-count") || TextUtils.equals(this.jy.oq().getType(), "score-count-type-1") || TextUtils.equals(this.jy.oq().getType(), "score-count-type-2"))) {
                setVisibility(8);
                return true;
            }
            if (!TextUtils.equals(this.jy.oq().getType(), "score-count") && !TextUtils.equals(this.jy.oq().getType(), "score-count-type-2")) {
                if (TextUtils.equals(this.jy.oq().getType(), "text_star")) {
                    try {
                        d6 = Double.parseDouble(getText());
                    } catch (Exception e6) {
                        vl.r("DynamicStarView applyNativeStyle", e6.toString());
                        d6 = -1.0d;
                    }
                    if (d6 < 0.0d || d6 > 5.0d) {
                        if (com.bytedance.sdk.component.adexpress.r.j()) {
                            setVisibility(8);
                            return true;
                        }
                        this.az.setVisibility(0);
                    }
                    ((TextView) this.az).setIncludeFontPadding(false);
                    ((TextView) this.az).setText(String.format("%.1f", Double.valueOf(d6)));
                } else if (TextUtils.equals("privacy-detail", this.jy.oq().getType())) {
                    ((TextView) this.az).setText("功能 | 权限 | 隐私");
                } else if (TextUtils.equals(this.jy.oq().getType(), "development-name")) {
                    ((TextView) this.az).setText(kt.j(com.bytedance.sdk.component.adexpress.r.getContext(), "tt_text_privacy_development") + getText());
                } else if (TextUtils.equals(this.jy.oq().getType(), "app-version")) {
                    ((TextView) this.az).setText(kt.j(com.bytedance.sdk.component.adexpress.r.getContext(), "tt_text_privacy_app_version") + getText());
                } else {
                    ((TextView) this.az).setText(getText());
                }
            } else {
                try {
                    try {
                        i6 = Integer.parseInt(getText());
                    } catch (Exception unused) {
                    }
                } catch (NumberFormatException unused2) {
                    i6 = -1;
                }
                if (i6 < 0) {
                    if (com.bytedance.sdk.component.adexpress.r.j()) {
                        setVisibility(8);
                        return true;
                    }
                    this.az.setVisibility(0);
                }
                if (TextUtils.equals(this.jy.oq().getType(), "score-count-type-2")) {
                    ((TextView) this.az).setText(String.format(new DecimalFormat("(###,###,###)").format(i6), Integer.valueOf(i6)));
                    ((TextView) this.az).setGravity(17);
                    return true;
                }
                j((TextView) this.az, i6, getContext(), "tt_comment_num");
            }
            this.az.setTextAlignment(this.vl.tl());
            ((TextView) this.az).setGravity(this.vl.g());
            if (com.bytedance.sdk.component.adexpress.r.j()) {
                oq();
            }
        }
        return true;
    }
}
