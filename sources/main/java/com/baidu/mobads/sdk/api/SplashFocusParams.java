package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.bu;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SplashFocusParams {
    private final Builder mBuilder;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {
        private int iconRightMarginDp = 15;
        private int iconBottomMarginDp = 95;
        private int iconSizeDp = 44;
        private boolean autoAnimOffset = true;
        private int animOffsetPx = 0;
        private double darkAlpha = 0.0d;

        @Deprecated
        public Builder setAnimOffsetPx(int i6) {
            this.autoAnimOffset = false;
            this.animOffsetPx = i6;
            return this;
        }

        public SplashFocusParams build() {
            return new SplashFocusParams(this);
        }

        public Builder setDarkAlpha(double d6) {
            this.darkAlpha = d6;
            return this;
        }

        public Builder setIconBottomMarginDp(int i6) {
            this.iconBottomMarginDp = i6;
            return this;
        }

        public Builder setIconRightMarginDp(int i6) {
            this.iconRightMarginDp = i6;
            return this;
        }

        public Builder setIconSizeDp(int i6) {
            this.iconSizeDp = i6;
            return this;
        }
    }

    public JSONObject getFocusParams() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("right_margin", this.mBuilder.iconRightMarginDp);
            jSONObject.put("bottom_margin", this.mBuilder.iconBottomMarginDp);
            jSONObject.put("icon_size", this.mBuilder.iconSizeDp);
            if (!this.mBuilder.autoAnimOffset) {
                jSONObject.put("anim_offset_y", this.mBuilder.animOffsetPx);
            }
            jSONObject.put("icon_dark_alpha", this.mBuilder.darkAlpha);
            return jSONObject;
        } catch (JSONException e6) {
            bu.a().a(e6);
            return jSONObject;
        }
    }

    public SplashFocusParams(Builder builder) {
        this.mBuilder = builder;
    }
}
