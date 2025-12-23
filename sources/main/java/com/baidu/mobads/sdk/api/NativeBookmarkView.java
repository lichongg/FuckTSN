package com.baidu.mobads.sdk.api;

import android.view.View;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.internal.az;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class NativeBookmarkView {
    private View bookmarkView;
    private final NativeResponse nativeResponse;
    private final JSONObject params = new JSONObject();

    private void putValue(String str, Object obj) {
        try {
            this.params.put(str, obj);
        } catch (JSONException e6) {
            az.b(e6);
        }
    }

    public NativeBookmarkView bottomCardColor(String str) {
        putValue("bottom_card_color", str);
        return this;
    }

    public NativeBookmarkView closeListener(NativeResponse.AdCloseListener adCloseListener) {
        NativeResponse nativeResponse = this.nativeResponse;
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).setAdCloseListener(adCloseListener);
        }
        return this;
    }

    public NativeBookmarkView dislikeListener(NativeResponse.AdDislikeListener adDislikeListener) {
        NativeResponse nativeResponse = this.nativeResponse;
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).setAdDislikeListener(adDislikeListener);
        }
        return this;
    }

    public NativeResponse getNativeResponse() {
        return this.nativeResponse;
    }

    public View getView() {
        return this.bookmarkView;
    }

    public NativeBookmarkView hideAdLogo(boolean z5) {
        putValue("hide_ad_logo", Boolean.valueOf(z5));
        return this;
    }

    public NativeBookmarkView hideDislike(boolean z5) {
        putValue("hide_dislike", Boolean.valueOf(z5));
        return this;
    }

    public NativeBookmarkView hideMuteButton(boolean z5) {
        putValue("hide_mute", Boolean.valueOf(z5));
        return this;
    }

    public NativeBookmarkView mute(boolean z5) {
        putValue("mute", Boolean.valueOf(z5));
        return this;
    }

    public NativeBookmarkView regionClick(boolean z5) {
        putValue("region_click", Boolean.valueOf(z5));
        return this;
    }

    public View render() {
        NativeResponse nativeResponse = this.nativeResponse;
        if (!(nativeResponse instanceof XAdNativeResponse)) {
            return null;
        }
        View renderNativeView = ((XAdNativeResponse) nativeResponse).renderNativeView("bookmark", this.params);
        this.bookmarkView = renderNativeView;
        return renderNativeView;
    }

    public NativeBookmarkView(NativeResponse nativeResponse, int i6, int i7) {
        this.nativeResponse = nativeResponse;
        putValue("type", "template");
        putValue(IAdInterListener.AdReqParam.WIDTH, Integer.valueOf(i6));
        putValue("h", Integer.valueOf(i7));
    }
}
