package com.kwad.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class i {
    private AudioManager aKz;
    private AudioManager.OnAudioFocusChangeListener aYH = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.i.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(final int i6) {
            if (i.this.kf == null) {
                return;
            }
            bw.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.i.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (i6 < 0) {
                        i.this.kf.onAudioBeOccupied();
                    } else {
                        i.this.kf.onAudioBeReleased();
                    }
                }
            });
        }
    };
    private a kf;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void onAudioBeOccupied();

        void onAudioBeReleased();
    }

    public final boolean PF() {
        AudioManager audioManager;
        int requestAudioFocus;
        try {
            AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.aYH;
            if (onAudioFocusChangeListener != null && (audioManager = this.aKz) != null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    requestAudioFocus = audioManager.requestAudioFocus(PG());
                    return 1 == requestAudioFocus;
                }
                if (1 == audioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @TargetApi(26)
    private AudioFocusRequest PG() {
        AudioFocusRequest.Builder audioAttributes;
        AudioFocusRequest.Builder acceptsDelayedFocusGain;
        AudioFocusRequest.Builder onAudioFocusChangeListener;
        AudioFocusRequest build;
        audioAttributes = com.bytedance.sdk.openadsdk.l.i.a(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build());
        acceptsDelayedFocusGain = audioAttributes.setAcceptsDelayedFocusGain(false);
        onAudioFocusChangeListener = acceptsDelayedFocusGain.setOnAudioFocusChangeListener(this.aYH);
        build = onAudioFocusChangeListener.build();
        return build;
    }

    public final void c(a aVar) {
        this.kf = aVar;
    }

    public i(Context context) {
        this.aKz = (AudioManager) context.getSystemService("audio");
    }
}
