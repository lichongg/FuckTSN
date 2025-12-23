package com.bxkj.base.util;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class s {

    /* renamed from: b, reason: collision with root package name */
    private static volatile s f16633b = null;

    /* renamed from: c, reason: collision with root package name */
    private static String f16634c = null;

    /* renamed from: d, reason: collision with root package name */
    private static String f16635d = "TAG.Util.MediaPlay";

    /* renamed from: a, reason: collision with root package name */
    private MediaPlayer f16636a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements MediaPlayer.OnPreparedListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            String unused = s.f16635d;
            mediaPlayer.getDuration();
            mediaPlayer.start();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements MediaPlayer.OnCompletionListener {
        b() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            s.f16634c = "";
            if (s.this.f16636a != null) {
                s.this.f16636a.release();
            }
            if (s.this.f16636a != null) {
                s.this.f16636a = null;
            }
        }
    }

    public static s e() {
        if (f16633b == null) {
            synchronized (s.class) {
                try {
                    if (f16633b == null) {
                        f16633b = new s();
                    }
                } finally {
                }
            }
        }
        return f16633b;
    }

    public void f(Context context, String str) {
        if (this.f16636a != null) {
            h();
        } else {
            g(context, str);
        }
    }

    public void g(Context context, String str) {
        if (TextUtils.equals(str, f16634c)) {
            return;
        }
        h();
        f16634c = str;
        if (this.f16636a == null) {
            this.f16636a = MediaPlayer.create(context, Uri.parse(str));
        }
        try {
            this.f16636a.reset();
            this.f16636a.setDataSource(str);
            this.f16636a.prepareAsync();
            this.f16636a.setOnPreparedListener(new a());
            this.f16636a.setOnCompletionListener(new b());
        } catch (IOException e6) {
            e6.getMessage();
        }
    }

    public void h() {
        f16634c = "";
        try {
            MediaPlayer mediaPlayer = this.f16636a;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
            MediaPlayer mediaPlayer2 = this.f16636a;
            if (mediaPlayer2 != null) {
                mediaPlayer2.release();
            }
            if (this.f16636a != null) {
                this.f16636a = null;
            }
        } catch (Exception e6) {
            e6.toString();
        }
    }

    private s() {
    }
}
