package com.hw.videoprocessor;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class d extends Thread implements c {

    /* renamed from: a, reason: collision with root package name */
    private MediaCodec f35333a;

    /* renamed from: b, reason: collision with root package name */
    private MediaMuxer f35334b;

    /* renamed from: c, reason: collision with root package name */
    private AtomicBoolean f35335c;

    /* renamed from: d, reason: collision with root package name */
    private Exception f35336d;

    /* renamed from: e, reason: collision with root package name */
    private int f35337e;

    /* renamed from: f, reason: collision with root package name */
    private int f35338f;

    /* renamed from: g, reason: collision with root package name */
    private int f35339g;

    /* renamed from: h, reason: collision with root package name */
    private int f35340h;

    /* renamed from: i, reason: collision with root package name */
    private MediaExtractor f35341i;

    /* renamed from: j, reason: collision with root package name */
    private int f35342j;

    /* renamed from: k, reason: collision with root package name */
    private volatile CountDownLatch f35343k;

    /* renamed from: l, reason: collision with root package name */
    private volatile Surface f35344l;

    /* renamed from: m, reason: collision with root package name */
    private long f35345m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f35346n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f35347o;

    /* renamed from: p, reason: collision with root package name */
    private long f35348p;

    /* renamed from: q, reason: collision with root package name */
    private int f35349q;

    public d(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i6, int i7, int i8, int i9, int i10, AtomicBoolean atomicBoolean, long j6, boolean z5, boolean z6, int i11) {
        super("VideoProcessEncodeThread");
        this.f35334b = mediaMuxer;
        this.f35335c = atomicBoolean;
        this.f35341i = mediaExtractor;
        this.f35337e = i6;
        this.f35339g = i8;
        this.f35338f = i7;
        this.f35340h = i9;
        this.f35342j = i10;
        this.f35343k = new CountDownLatch(1);
        this.f35345m = j6;
        this.f35348p = j6;
        this.f35346n = z5;
        this.f35347o = z6;
        this.f35349q = i11;
    }

    private void b() throws IOException {
        MediaFormat trackFormat = this.f35341i.getTrackFormat(this.f35342j);
        int integer = trackFormat.containsKey("frame-rate") ? trackFormat.getInteger("frame-rate") : h.f35382c;
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.f35338f, this.f35339g);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", this.f35337e);
        createVideoFormat.setInteger("frame-rate", integer);
        createVideoFormat.setInteger("i-frame-interval", this.f35340h);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.f35333a = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f35344l = this.f35333a.createInputSurface();
        this.f35333a.start();
        this.f35343k.countDown();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        boolean z5 = false;
        int i6 = 0;
        while (true) {
            if (this.f35335c.get() && !z5) {
                this.f35333a.signalEndOfInputStream();
                z5 = true;
            }
            int dequeueOutputBuffer = this.f35333a.dequeueOutputBuffer(bufferInfo, 2500L);
            com.hw.videoprocessor.util.c.k("encode outputBufferIndex = " + dequeueOutputBuffer, new Object[0]);
            if (z5 && dequeueOutputBuffer == -1) {
                i6++;
                if (i6 > 10) {
                    com.hw.videoprocessor.util.c.f("INFO_TRY_AGAIN_LATER 10 times,force End!", new Object[0]);
                    return;
                }
            } else {
                i6 = 0;
            }
            if (dequeueOutputBuffer != -1) {
                if (dequeueOutputBuffer == -2) {
                    com.hw.videoprocessor.util.c.k("encode newFormat = " + this.f35333a.getOutputFormat(), new Object[0]);
                } else if (dequeueOutputBuffer < 0) {
                    com.hw.videoprocessor.util.c.f("unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer, new Object[0]);
                } else {
                    ByteBuffer outputBuffer = this.f35333a.getOutputBuffer(dequeueOutputBuffer);
                    long j6 = bufferInfo.presentationTimeUs + this.f35345m;
                    bufferInfo.presentationTimeUs = j6;
                    if (this.f35346n || bufferInfo.flags != 2) {
                        if (!this.f35347o && bufferInfo.flags == 4) {
                            com.hw.videoprocessor.util.c.k("encoderDone", new Object[0]);
                            this.f35333a.releaseOutputBuffer(dequeueOutputBuffer, false);
                            return;
                        }
                        if (bufferInfo.flags == 4 && j6 < 0) {
                            bufferInfo.presentationTimeUs = 0L;
                        }
                        com.hw.videoprocessor.util.c.k("writeSampleData,size:" + bufferInfo.size + " time:" + (bufferInfo.presentationTimeUs / 1000) + " flag:" + bufferInfo.flags, new Object[0]);
                        this.f35334b.writeSampleData(this.f35349q, outputBuffer, bufferInfo);
                        long j7 = this.f35348p;
                        long j8 = bufferInfo.presentationTimeUs;
                        if (j7 < j8) {
                            this.f35348p = j8;
                        }
                        this.f35333a.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if (bufferInfo.flags == 4) {
                            com.hw.videoprocessor.util.c.k("encoderDone", new Object[0]);
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // com.hw.videoprocessor.c
    public CountDownLatch a() {
        return this.f35343k;
    }

    public Exception c() {
        return this.f35336d;
    }

    public long d() {
        return this.f35348p;
    }

    @Override // com.hw.videoprocessor.c
    public Surface getSurface() {
        return this.f35344l;
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        try {
            try {
                b();
                MediaCodec mediaCodec = this.f35333a;
                if (mediaCodec != null) {
                    mediaCodec.stop();
                    this.f35333a.release();
                }
            } catch (Exception e6) {
                com.hw.videoprocessor.util.c.g(e6);
                this.f35336d = e6;
                if (this.f35333a != null) {
                    this.f35333a.stop();
                    this.f35333a.release();
                }
            }
        } catch (Throwable th) {
            MediaCodec mediaCodec2 = this.f35333a;
            if (mediaCodec2 != null) {
                mediaCodec2.stop();
                this.f35333a.release();
            }
            throw th;
        }
    }
}
