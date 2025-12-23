package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.bu;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BDDialogParams {
    public static final int ANIM_STYLE_BREATHE = 1;
    public static final int ANIM_STYLE_GUIDE = 3;
    public static final int ANIM_STYLE_NONE = 0;
    public static final int ANIM_STYLE_SWIPE = 2;
    public static final int TYPE_BOTTOM_POPUP = 0;
    public static final int TYPE_CENTER_DECORATE = 2;
    public static final int TYPE_CENTER_NORMAL = 1;
    private final Builder mBuilder;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.baidu.mobads.sdk.api.BDDialogParams$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {
        private int mDlDialogType = 0;
        private int mDlDialogAnimStyle = 0;

        public BDDialogParams build() {
            return new BDDialogParams(this, null);
        }

        public Builder setDlDialogAnimStyle(int i6) {
            this.mDlDialogAnimStyle = i6;
            return this;
        }

        public Builder setDlDialogType(int i6) {
            this.mDlDialogType = i6;
            return this;
        }
    }

    /* synthetic */ BDDialogParams(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private BDDialogParams(Builder builder) {
        this.mBuilder = builder;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.mBuilder.mDlDialogType);
            jSONObject.put("anim_style", this.mBuilder.mDlDialogAnimStyle);
            return jSONObject;
        } catch (JSONException e6) {
            bu.a().a(e6);
            return jSONObject;
        }
    }
}
