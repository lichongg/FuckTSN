package xyz.adscope.ad;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface y1 extends m2<x1> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum a implements l2 {
        AD_CLICK(502, "ad_click"),
        DOWNLOAD_START(MediaPlayer.MEDIA_PLAYER_OPTION_LICENSE_DIR, "download_start"),
        DOWNLOAD_PAUSE(511, "download_pause"),
        DOWNLOAD_CONTINUE(512, "download_continue"),
        DOWNLOAD_COMPLETE(513, "download_complete"),
        DOWNLOAD_FAILED(MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS, "download_failed"),
        INSTALL_START(514, "install_start"),
        INSTALL_COMPLETE(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT, "install_complete"),
        APP_LAUNCHED(MediaPlayer.MEDIA_PLAYER_OPTION_FILE_FORMAT, "app_launched"),
        INVOKE_DEEPLINK(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CURRENT_DOWNLOAD_INDEX, "start_deeplink"),
        DEEPLINK_INVOKE_SUCCESS(MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_INFOS, "deeplink_success"),
        DEEPLINK_INVOKE_ASSUME_SUCCESS(525, "deeplink_assume_success"),
        DEEPLINK_INVOKE_FAILED(522, "deeplink_failed"),
        APP_NOT_INSTALLED(MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_AUDIO_WINDOW_SIZE, "app_not_installed"),
        APP_INSTALLED(524, "app_installed"),
        AD_CLOSE(530, "ad_closed"),
        COMPLAIN_CONFIRM(900, "complain_confirm");


        /* renamed from: a, reason: collision with root package name */
        private final int f56178a;

        /* renamed from: b, reason: collision with root package name */
        private final String f56179b;

        @Override // xyz.adscope.ad.l2
        public int getEventCode() {
            return this.f56178a;
        }

        a(int i6, String str) {
            this.f56178a = i6;
            this.f56179b = str;
        }
    }

    void a(l2 l2Var);

    void a(a aVar);

    void b(l2 l2Var);

    void c(l2 l2Var);
}
