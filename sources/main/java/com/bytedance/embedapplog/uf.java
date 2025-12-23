package com.bytedance.embedapplog;

import android.content.Context;
import android.util.DisplayMetrics;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
class uf extends l {
    private final Context up;

    uf(Context context) {
        super(true, false);
        this.up = context;
    }

    @Override // com.bytedance.embedapplog.l
    protected boolean j(JSONObject jSONObject) {
        String str;
        DisplayMetrics displayMetrics = this.up.getResources().getDisplayMetrics();
        int i6 = displayMetrics.densityDpi;
        switch (i6) {
            case 120:
                str = "ldpi";
                break;
            case 240:
                str = "hdpi";
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN /* 280 */:
            case 300:
            case 320:
                str = "xhdpi";
                break;
            case 340:
            case 360:
            case 400:
            case org.apache.commons.net.nntp.h.f50924w /* 420 */:
            case org.apache.commons.net.nntp.h.E /* 440 */:
            case 480:
                str = "xxhdpi";
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ /* 560 */:
            case 640:
                str = "xxxhdpi";
                break;
            default:
                str = "mdpi";
                break;
        }
        jSONObject.put("density_dpi", i6);
        jSONObject.put("display_density", str);
        jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        return true;
    }
}
