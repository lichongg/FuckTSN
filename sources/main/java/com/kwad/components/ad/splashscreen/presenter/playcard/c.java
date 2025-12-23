package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.sdk.utils.ak;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private ak IO;
    private ak IP;
    private ak IQ;
    private ak IR;
    private ak IS;
    private ak IT;
    private float IE = 1.0f;
    private int IU = 34;
    private int IV = 19;
    private int IW = 8;
    private int IX = 12;

    public static c c(float f6) {
        c cVar = new c();
        cVar.IO = ak.a(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, 0, 0, 0, 0, 0);
        cVar.IP = ak.a(33, 33, 0, 0, 0, 0);
        cVar.IQ = ak.a(0, 26, 0, 11, 0, 0);
        cVar.IR = ak.a(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, 0, 6, 0, 0);
        cVar.IS = ak.a(0, 0, 0, 6, 0, 0);
        cVar.IT = ak.a(0, 0, 0, 7, 0, 0);
        cVar.IU = 21;
        cVar.IV = 12;
        cVar.IW = 6;
        cVar.IE = f6;
        cVar.IX = 8;
        return cVar;
    }

    public static c nc() {
        c cVar = new c();
        cVar.IO = ak.a(MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, 0, 0, 0, 0, 0);
        cVar.IP = ak.a(53, 53, 0, 0, 0, 0);
        cVar.IQ = ak.a(0, 43, 0, 11, 0, 0);
        cVar.IR = ak.a(MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_RES_FINSIH_TIME, 0, 8, 0, 0);
        cVar.IS = ak.a(0, 0, 0, 8, 0, 0);
        cVar.IT = ak.a(0, 0, 0, 10, 0, 0);
        return cVar;
    }

    public final ak W(Context context) {
        return this.IO.c(context, this.IE);
    }

    public final ak X(Context context) {
        return this.IP.c(context, this.IE);
    }

    public final ak Y(Context context) {
        return this.IQ.c(context, this.IE);
    }

    public final ak Z(Context context) {
        return this.IR.c(context, this.IE);
    }

    public final ak aa(Context context) {
        return this.IS.c(context, this.IE);
    }

    public final ak ab(Context context) {
        return this.IT.c(context, this.IE);
    }

    public final int ac(Context context) {
        return (int) (com.kwad.sdk.c.a.a.b(context, this.IU) * this.IE);
    }

    public final int ad(Context context) {
        return (int) (com.kwad.sdk.c.a.a.b(context, this.IV) * this.IE);
    }

    public final int ae(Context context) {
        return (int) (com.kwad.sdk.c.a.a.b(context, this.IW) * this.IE);
    }

    public final int nd() {
        return this.IX;
    }
}
