package com.ss.android.socialbase.downloader.qv;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.NonNull;
import master.flame.danmaku.danmaku.model.android.d;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class ws {

    /* renamed from: j, reason: collision with root package name */
    private final JSONObject f38957j;
    private int xt;

    public void j(int i6) {
        this.xt = xt(i6);
    }

    public boolean xt() {
        return av() > 0;
    }

    private int av() {
        return this.f38957j.optInt("url_balance", 2);
    }

    private int xt(int i6) {
        int optInt = this.f38957j.optInt("thread_count", 4);
        if (optInt > 16) {
            optInt = 16;
        }
        if (optInt > 0) {
            return av() == 1 ? Math.min(optInt, i6) : optInt;
        }
        if (av() > 0) {
            return i6;
        }
        return 1;
    }

    public long ae() {
        long optInt = this.f38957j.optInt("segment_min_kb", 512) * 1024;
        if (optInt < 65536) {
            return 65536L;
        }
        return optInt;
    }

    public float az() {
        return Math.min(Math.max(0.0f, (float) this.f38957j.optDouble("poor_speed_ratio", 0.0d)), 1.0f);
    }

    public long g() {
        long optInt = this.f38957j.optInt("segment_max_kb", 0) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        if (optInt < ae()) {
            return -1L;
        }
        return optInt;
    }

    public int j() {
        return this.xt;
    }

    public float jy() {
        return (float) this.f38957j.optDouble("main_ratio", 0.0d);
    }

    public boolean m() {
        return this.f38957j.optInt("segment_mode", 1) == 0;
    }

    public long oq() {
        long optInt = this.f38957j.optInt("connect_timeout", -1);
        if (optInt >= 2000) {
            return optInt;
        }
        return -1L;
    }

    public long qv() {
        long optInt = this.f38957j.optInt("read_timeout", -1);
        if (optInt >= d.f50003r) {
            return optInt;
        }
        return -1L;
    }

    public int r() {
        return this.f38957j.optInt("buffer_count", 512);
    }

    public long tl() {
        long optInt = this.f38957j.optInt("segment_min_init_mb", 10) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        if (optInt < 5242880) {
            return 5242880L;
        }
        return optInt;
    }

    public int up() {
        return this.f38957j.optInt("buffer_size", 8192);
    }

    public int vl() {
        return this.f38957j.optInt("ip_strategy", 0);
    }

    public int ws() {
        return this.f38957j.optInt("ratio_segment", 0);
    }

    private ws(JSONObject jSONObject) {
        this.f38957j = jSONObject;
    }

    @NonNull
    public static ws j(@NonNull JSONObject jSONObject) {
        return new ws(jSONObject);
    }

    public boolean cw() {
        if (av() == 1) {
            return true;
        }
        return false;
    }
}
