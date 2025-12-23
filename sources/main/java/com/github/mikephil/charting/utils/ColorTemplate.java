package com.github.mikephil.charting.utils;

import android.content.res.Resources;
import android.graphics.Color;
import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.net.ftp.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class ColorTemplate {
    public static final int COLOR_NONE = 1122867;
    public static final int COLOR_SKIP = 1122868;
    public static final int[] LIBERTY_COLORS = {Color.rgb(207, 248, 246), Color.rgb(148, 212, 212), Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH, 180, 187), Color.rgb(118, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED), Color.rgb(42, 109, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE)};
    public static final int[] JOYFUL_COLORS = {Color.rgb(217, 80, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME), Color.rgb(254, Opcodes.FCMPL, 7), Color.rgb(254, 247, 120), Color.rgb(106, 167, MediaPlayer.MEDIA_PLAYER_OPTION_SET_MAX_FPS), Color.rgb(53, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 209)};
    public static final int[] PASTEL_COLORS = {Color.rgb(64, 89, 128), Color.rgb(Opcodes.FCMPL, 165, 124), Color.rgb(217, 184, 162), Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, MediaPlayer.MEDIA_PLAYER_OPTION_SET_MAX_FPS, MediaPlayer.MEDIA_PLAYER_OPTION_SET_MAX_FPS), Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 48, 80)};
    public static final int[] COLORFUL_COLORS = {Color.rgb(193, 37, 82), Color.rgb(255, 102, 0), Color.rgb(245, 199, 0), Color.rgb(106, 150, 31), Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 100, 53)};
    public static final int[] VORDIPLOM_COLORS = {Color.rgb(192, 255, 140), Color.rgb(255, 247, 140), Color.rgb(255, 208, 140), Color.rgb(140, l.O, 255), Color.rgb(255, 140, 157)};
    public static final int[] MATERIAL_COLORS = {rgb("#2ecc71"), rgb("#f1c40f"), rgb("#e74c3c"), rgb("#3498db")};

    public static List<Integer> createColors(Resources resources, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i6 : iArr) {
            arrayList.add(Integer.valueOf(resources.getColor(i6)));
        }
        return arrayList;
    }

    public static int getHoloBlue() {
        return Color.rgb(51, 181, l.f50690q);
    }

    public static int rgb(String str) {
        int parseLong = (int) Long.parseLong(str.replace("#", ""), 16);
        return Color.rgb((parseLong >> 16) & 255, (parseLong >> 8) & 255, parseLong & 255);
    }

    public static int colorWithAlpha(int i6, int i7) {
        return (i6 & 16777215) | ((i7 & 255) << 24);
    }

    public static List<Integer> createColors(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i6 : iArr) {
            arrayList.add(Integer.valueOf(i6));
        }
        return arrayList;
    }
}
