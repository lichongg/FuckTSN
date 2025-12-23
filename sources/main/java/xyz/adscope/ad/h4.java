package xyz.adscope.ad;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface h4 extends m2<g4> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum a implements l2 {
        VIDEO_START(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER, "play_start"),
        VIDEO_PROCESS(33, "play_process"),
        VIDEO_FINISHED(MediaPlayer.MEDIA_PLAYER_OPTION_ROTATION, "play_end"),
        VIDEO_PLAY_VALID(MediaPlayer.MEDIA_PLAYER_OPTION_CLIP_HEAACV2_FIRSTPTS_PACKET, "video play valid"),
        VIDEO_ERROR(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY, "video play error"),
        VIDEO_PREPARED(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_TIMESTAMP_MONOTONIC, "video prepared");


        /* renamed from: a, reason: collision with root package name */
        private final int f55201a;

        /* renamed from: b, reason: collision with root package name */
        private final String f55202b;

        @Override // xyz.adscope.ad.l2
        public int getEventCode() {
            return this.f55201a;
        }

        a(int i6, String str) {
            this.f55201a = i6;
            this.f55202b = str;
        }
    }

    void a(l2 l2Var, int i6);

    void d(l2 l2Var);

    void e(l2 l2Var);

    void f(l2 l2Var);
}
