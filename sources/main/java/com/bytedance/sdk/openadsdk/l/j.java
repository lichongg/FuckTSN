package com.bytedance.sdk.openadsdk.l;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private AudioManager cw;

    /* renamed from: j, reason: collision with root package name */
    private AudioAttributes f31558j;

    /* renamed from: r, reason: collision with root package name */
    private AudioManager.OnAudioFocusChangeListener f31559r;
    private boolean up;
    private AudioFocusRequest xt;

    public int j() {
        AudioFocusRequest.Builder willPauseWhenDucked;
        AudioFocusRequest.Builder acceptsDelayedFocusGain;
        AudioFocusRequest.Builder onAudioFocusChangeListener;
        AudioFocusRequest.Builder audioAttributes;
        AudioFocusRequest build;
        int requestAudioFocus;
        if (!this.up) {
            return -1;
        }
        int i6 = Build.VERSION.SDK_INT;
        this.f31558j = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
        if (i6 >= 26) {
            willPauseWhenDucked = i.a(2).setWillPauseWhenDucked(true);
            acceptsDelayedFocusGain = willPauseWhenDucked.setAcceptsDelayedFocusGain(true);
            onAudioFocusChangeListener = acceptsDelayedFocusGain.setOnAudioFocusChangeListener(this.f31559r);
            audioAttributes = onAudioFocusChangeListener.setAudioAttributes(this.f31558j);
            build = audioAttributes.build();
            this.xt = build;
            AudioManager audioManager = this.cw;
            if (audioManager != null) {
                requestAudioFocus = audioManager.requestAudioFocus(build);
                return requestAudioFocus;
            }
        } else {
            AudioManager audioManager2 = this.cw;
            if (audioManager2 != null) {
                return audioManager2.requestAudioFocus(this.f31559r, 3, 2);
            }
        }
        return -1;
    }

    public void xt() {
        if (this.up) {
            if (Build.VERSION.SDK_INT >= 26) {
                AudioManager audioManager = this.cw;
                if (audioManager != null) {
                    audioManager.abandonAudioFocusRequest(this.xt);
                    return;
                }
                return;
            }
            AudioManager audioManager2 = this.cw;
            if (audioManager2 != null) {
                audioManager2.abandonAudioFocus(this.f31559r);
            }
        }
    }

    public j() {
        this.up = false;
        boolean l6 = v.xt().l();
        this.up = l6;
        if (l6) {
            this.f31559r = new AudioManager.OnAudioFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.l.j.1
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public void onAudioFocusChange(int i6) {
                }
            };
            this.cw = (AudioManager) v.getContext().getSystemService("audio");
        }
    }
}
