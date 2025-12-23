package com.bytedance.sdk.component.adexpress.dynamic.cw;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.a;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {

    /* renamed from: j, reason: collision with root package name */
    public static final Map<String, Integer> f25637j;
    private String ae;
    private String cw;

    /* renamed from: m, reason: collision with root package name */
    private m f25638m;

    /* renamed from: r, reason: collision with root package name */
    private String f25639r;
    private m up;
    private String xt;

    public String cw() {
        return this.f25639r;
    }

    public int j() {
        if (TextUtils.isEmpty(this.xt)) {
            return 0;
        }
        if (this.xt.equals("logo")) {
            String str = this.xt + this.cw;
            this.xt = str;
            if (str.contains("logoad")) {
                return 4;
            }
            if (this.xt.contains("logounion")) {
                return 5;
            }
        }
        Map<String, Integer> map = f25637j;
        if (map.get(this.xt) != null) {
            return map.get(this.xt).intValue();
        }
        return -1;
    }

    public void r(String str) {
        this.ae = str;
    }

    public String xt() {
        return this.cw;
    }

    static {
        HashMap hashMap = new HashMap();
        f25637j = hashMap;
        hashMap.put("root", 8);
        hashMap.put("footer", 6);
        hashMap.put("empty", 6);
        hashMap.put("title", 0);
        hashMap.put(MediaFormat.KEY_SUBTITLE, 0);
        hashMap.put(SocialConstants.PARAM_SOURCE, 0);
        hashMap.put("score-count", 0);
        hashMap.put("text_star", 0);
        hashMap.put(a.f10501b, 0);
        hashMap.put("tag-group", 17);
        hashMap.put("app-version", 0);
        hashMap.put("development-name", 0);
        hashMap.put("privacy-detail", 23);
        hashMap.put(SocializeProtocolConstants.IMAGE, 1);
        hashMap.put("image-wide", 1);
        hashMap.put("image-square", 1);
        hashMap.put("image-long", 1);
        hashMap.put("image-splash", 1);
        hashMap.put("image-cover", 1);
        hashMap.put("app-icon", 1);
        hashMap.put("icon-download", 1);
        hashMap.put("logoad", 4);
        hashMap.put("logounion", 5);
        hashMap.put("logo-union", 9);
        hashMap.put("dislike", 3);
        hashMap.put("close", 3);
        hashMap.put("close-fill", 3);
        hashMap.put("webview-close", 22);
        hashMap.put("feedback-dislike", 12);
        hashMap.put("button", 2);
        hashMap.put("downloadWithIcon", 2);
        hashMap.put("downloadButton", 2);
        hashMap.put("fillButton", 2);
        hashMap.put("laceButton", 2);
        hashMap.put("cardButton", 2);
        hashMap.put("colourMixtureButton", 2);
        hashMap.put("arrowButton", 1);
        hashMap.put("download-progress-button", 2);
        hashMap.put("vessel", 6);
        hashMap.put("image-group", 6);
        hashMap.put("custom-component-vessel", 6);
        hashMap.put("carousel", 24);
        hashMap.put("carousel-vessel", 26);
        hashMap.put("leisure-interact", 25);
        hashMap.put("video-hd", 7);
        hashMap.put("video", 7);
        hashMap.put("video-vd", 7);
        hashMap.put("video-sq", 7);
        hashMap.put("muted", 10);
        hashMap.put("star", 11);
        hashMap.put("skip-countdowns", 19);
        hashMap.put("skip-with-countdowns-skip-btn", 21);
        hashMap.put("skip-with-countdowns-video-countdown", 13);
        hashMap.put("skip-with-countdowns-skip-countdown", 20);
        hashMap.put("skip-with-time", 14);
        hashMap.put("skip-with-time-countdown", 13);
        hashMap.put("skip-with-time-skip-btn", 15);
        hashMap.put("skip", 27);
        hashMap.put("timedown", 13);
        hashMap.put("icon", 16);
        hashMap.put("scoreCountWithIcon", 6);
        hashMap.put("split-line", 18);
        hashMap.put("creative-playable-bait", 0);
        hashMap.put("score-count-type-2", 0);
        hashMap.put("lottie", 28);
        hashMap.put("image-flip-slide", 29);
    }

    public m ae() {
        return this.f25638m;
    }

    public void cw(String str) {
        this.f25639r = str;
    }

    public String getType() {
        return this.xt;
    }

    public int m() {
        return this.up.im();
    }

    public String r() {
        return this.ae;
    }

    public String toString() {
        return "DynamicLayoutBrick{type='" + this.xt + "', data='" + this.cw + "', value=" + this.up + ", themeValue=" + this.f25638m + ", dataExtraInfo='" + this.ae + "'}";
    }

    public m up() {
        return this.up;
    }

    public void xt(String str) {
        this.cw = str;
    }

    public void xt(m mVar) {
        this.f25638m = mVar;
    }

    public void j(String str) {
        this.xt = str;
    }

    public void j(m mVar) {
        this.up = mVar;
    }
}
