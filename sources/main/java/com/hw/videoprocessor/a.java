package com.hw.videoprocessor;

import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import androidx.annotation.Nullable;
import com.hw.videoprocessor.util.j;
import com.hw.videoprocessor.util.k;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends Thread implements k {

    /* renamed from: a, reason: collision with root package name */
    private String f35315a;

    /* renamed from: b, reason: collision with root package name */
    private Integer f35316b;

    /* renamed from: c, reason: collision with root package name */
    private Integer f35317c;

    /* renamed from: d, reason: collision with root package name */
    private Float f35318d;

    /* renamed from: e, reason: collision with root package name */
    private Context f35319e;

    /* renamed from: f, reason: collision with root package name */
    private Exception f35320f;

    /* renamed from: g, reason: collision with root package name */
    private MediaMuxer f35321g;

    /* renamed from: h, reason: collision with root package name */
    private int f35322h;

    /* renamed from: i, reason: collision with root package name */
    private MediaExtractor f35323i;

    /* renamed from: j, reason: collision with root package name */
    private CountDownLatch f35324j;

    /* renamed from: k, reason: collision with root package name */
    private j f35325k;

    public a(Context context, String str, MediaMuxer mediaMuxer, @Nullable Integer num, @Nullable Integer num2, @Nullable Float f6, int i6, CountDownLatch countDownLatch) {
        super("VideoProcessDecodeThread");
        this.f35315a = str;
        this.f35316b = num;
        this.f35317c = num2;
        this.f35318d = f6;
        this.f35321g = mediaMuxer;
        this.f35319e = context;
        this.f35322h = i6;
        this.f35323i = new MediaExtractor();
        this.f35324j = countDownLatch;
    }

    private void b() throws Exception {
        a aVar;
        this.f35323i.setDataSource(this.f35315a);
        int k6 = i.k(this.f35323i, true);
        if (k6 >= 0) {
            this.f35323i.selectTrack(k6);
            MediaFormat trackFormat = this.f35323i.getTrackFormat(k6);
            String string = trackFormat.containsKey(IMediaFormat.KEY_MIME) ? trackFormat.getString(IMediaFormat.KEY_MIME) : "audio/mp4a-latm";
            Integer num = this.f35316b;
            Integer valueOf = num == null ? null : Integer.valueOf(num.intValue() * 1000);
            Integer num2 = this.f35317c;
            Integer valueOf2 = num2 != null ? Integer.valueOf(num2.intValue() * 1000) : null;
            if (!this.f35324j.await(3L, TimeUnit.SECONDS)) {
                throw new TimeoutException("wait muxerStartLatch timeout!");
            }
            if (this.f35318d == null && string.equals("audio/mp4a-latm")) {
                aVar = this;
                com.hw.videoprocessor.util.b.u(this.f35323i, this.f35321g, this.f35322h, valueOf, valueOf2, aVar);
            } else {
                Context context = this.f35319e;
                MediaExtractor mediaExtractor = this.f35323i;
                MediaMuxer mediaMuxer = this.f35321g;
                Integer num3 = valueOf;
                int i6 = this.f35322h;
                Float f6 = this.f35318d;
                com.hw.videoprocessor.util.b.v(context, mediaExtractor, mediaMuxer, i6, num3, valueOf2, Float.valueOf(f6 == null ? 1.0f : f6.floatValue()), this);
                aVar = this;
            }
        } else {
            aVar = this;
        }
        j jVar = aVar.f35325k;
        if (jVar != null) {
            jVar.a(1.0f);
        }
    }

    @Override // com.hw.videoprocessor.util.k
    public void a(float f6) {
        j jVar = this.f35325k;
        if (jVar != null) {
            jVar.a(f6);
        }
    }

    public Exception c() {
        return this.f35320f;
    }

    public void d(j jVar) {
        this.f35325k = jVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        try {
            try {
                b();
            } catch (Exception e6) {
                this.f35320f = e6;
                com.hw.videoprocessor.util.c.g(e6);
            }
        } finally {
            this.f35323i.release();
        }
    }
}
