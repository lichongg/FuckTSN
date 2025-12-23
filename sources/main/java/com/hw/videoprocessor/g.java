package com.hw.videoprocessor;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.hw.videoprocessor.util.j;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class g extends Thread implements c {

    /* renamed from: a, reason: collision with root package name */
    private MediaCodec f35365a;

    /* renamed from: b, reason: collision with root package name */
    private MediaMuxer f35366b;

    /* renamed from: c, reason: collision with root package name */
    private AtomicBoolean f35367c;

    /* renamed from: d, reason: collision with root package name */
    private CountDownLatch f35368d;

    /* renamed from: e, reason: collision with root package name */
    private Exception f35369e;

    /* renamed from: f, reason: collision with root package name */
    private int f35370f;

    /* renamed from: g, reason: collision with root package name */
    private int f35371g;

    /* renamed from: h, reason: collision with root package name */
    private int f35372h;

    /* renamed from: i, reason: collision with root package name */
    private int f35373i;

    /* renamed from: j, reason: collision with root package name */
    private int f35374j;

    /* renamed from: k, reason: collision with root package name */
    private MediaExtractor f35375k;

    /* renamed from: l, reason: collision with root package name */
    private int f35376l;

    /* renamed from: m, reason: collision with root package name */
    private volatile CountDownLatch f35377m;

    /* renamed from: n, reason: collision with root package name */
    private volatile Surface f35378n;

    /* renamed from: o, reason: collision with root package name */
    private j f35379o;

    public g(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i6, int i7, int i8, int i9, int i10, int i11, AtomicBoolean atomicBoolean, CountDownLatch countDownLatch) {
        super("VideoProcessEncodeThread");
        this.f35366b = mediaMuxer;
        this.f35367c = atomicBoolean;
        this.f35368d = countDownLatch;
        this.f35375k = mediaExtractor;
        this.f35370f = i6;
        this.f35372h = i8;
        this.f35371g = i7;
        this.f35373i = i9;
        this.f35376l = i11;
        this.f35374j = i10;
        this.f35377m = new CountDownLatch(1);
    }

    private void b() throws IOException {
        int i6;
        MediaFormat trackFormat = this.f35375k.getTrackFormat(this.f35376l);
        int i7 = this.f35374j;
        if (i7 <= 0) {
            i7 = trackFormat.containsKey("frame-rate") ? trackFormat.getInteger("frame-rate") : h.f35382c;
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.f35371g, this.f35372h);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("frame-rate", i7);
        createVideoFormat.setInteger("i-frame-interval", this.f35373i);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.f35365a = createEncoderByType;
        if (i.m(createEncoderByType, "video/avc", createVideoFormat, 8, 512)) {
            com.hw.videoprocessor.util.c.k("supportProfileHigh,enable ProfileHigh", new Object[0]);
        }
        int g6 = i.g(this.f35365a, "video/avc");
        if (g6 > 0 && this.f35370f > g6) {
            com.hw.videoprocessor.util.c.f(this.f35370f + " bitrate too large,set to:" + g6, new Object[0]);
            this.f35370f = (int) (((float) g6) * 0.8f);
        }
        createVideoFormat.setInteger("bitrate", this.f35370f);
        this.f35365a.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f35378n = this.f35365a.createInputSurface();
        this.f35365a.start();
        this.f35377m.countDown();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int i8 = (int) (1000000.0f / i7);
        boolean z5 = false;
        int i9 = 0;
        int i10 = -5;
        boolean z6 = false;
        long j6 = -1;
        while (true) {
            if (this.f35367c.get() && !z5) {
                this.f35365a.signalEndOfInputStream();
                z5 = true;
            }
            int dequeueOutputBuffer = this.f35365a.dequeueOutputBuffer(bufferInfo, 2500L);
            com.hw.videoprocessor.util.c.k("encode outputBufferIndex = " + dequeueOutputBuffer, new Object[0]);
            if (z5 && dequeueOutputBuffer == -1) {
                i9++;
                if (i9 > 10) {
                    com.hw.videoprocessor.util.c.f("INFO_TRY_AGAIN_LATER 10 times,force End!", new Object[0]);
                    return;
                }
            } else {
                i9 = 0;
            }
            if (dequeueOutputBuffer != -1) {
                if (dequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.f35365a.getOutputFormat();
                    if (i10 == -5) {
                        i10 = this.f35366b.addTrack(outputFormat);
                        this.f35366b.start();
                        this.f35368d.countDown();
                    }
                    com.hw.videoprocessor.util.c.k("encode newFormat = " + outputFormat, new Object[0]);
                } else if (dequeueOutputBuffer < 0) {
                    com.hw.videoprocessor.util.c.f("unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer, new Object[0]);
                } else {
                    ByteBuffer outputBuffer = this.f35365a.getOutputBuffer(dequeueOutputBuffer);
                    if (bufferInfo.flags == 4) {
                        i6 = i9;
                        if (bufferInfo.presentationTimeUs < 0) {
                            bufferInfo.presentationTimeUs = 0L;
                        }
                    } else {
                        i6 = i9;
                    }
                    if (!z6 && j6 != -1 && bufferInfo.presentationTimeUs < (i8 / 2) + j6) {
                        com.hw.videoprocessor.util.c.f("video 时间戳错误，lastVideoFrameTimeUs:" + j6 + " info.presentationTimeUs:" + bufferInfo.presentationTimeUs + " VIDEO_FRAME_TIME_US:" + i8, new Object[0]);
                        z6 = true;
                    }
                    if (z6) {
                        bufferInfo.presentationTimeUs = i8 + j6;
                        com.hw.videoprocessor.util.c.f("video 时间戳错误，使用修正的时间戳:" + bufferInfo.presentationTimeUs, new Object[0]);
                        z6 = false;
                    }
                    if (bufferInfo.flags != 2) {
                        j6 = bufferInfo.presentationTimeUs;
                    }
                    com.hw.videoprocessor.util.c.k("writeSampleData,size:" + bufferInfo.size + " time:" + (bufferInfo.presentationTimeUs / 1000), new Object[0]);
                    this.f35366b.writeSampleData(i10, outputBuffer, bufferInfo);
                    d(bufferInfo);
                    this.f35365a.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if (bufferInfo.flags == 4) {
                        com.hw.videoprocessor.util.c.k("encoderDone", new Object[0]);
                        return;
                    }
                    i9 = i6;
                }
                i6 = i9;
                i9 = i6;
            }
        }
    }

    private void d(MediaCodec.BufferInfo bufferInfo) {
        j jVar = this.f35379o;
        if (jVar == null) {
            return;
        }
        jVar.b((bufferInfo.flags & 4) > 0 ? Long.MAX_VALUE : bufferInfo.presentationTimeUs);
    }

    @Override // com.hw.videoprocessor.c
    public CountDownLatch a() {
        return this.f35377m;
    }

    public Exception c() {
        return this.f35369e;
    }

    public void e(j jVar) {
        this.f35379o = jVar;
    }

    @Override // com.hw.videoprocessor.c
    public Surface getSurface() {
        return this.f35378n;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0016, code lost:
    
        if (r1 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0018, code lost:
    
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0019, code lost:
    
        r3.f35369e = r1;
        com.hw.videoprocessor.util.c.g(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0039, code lost:
    
        if (r1 != null) goto L12;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r3 = this;
            super.run()
            r3.b()     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            android.media.MediaCodec r0 = r3.f35365a     // Catch: java.lang.Exception -> L13
            if (r0 == 0) goto L3c
            r0.stop()     // Catch: java.lang.Exception -> L13
            android.media.MediaCodec r0 = r3.f35365a     // Catch: java.lang.Exception -> L13
            r0.release()     // Catch: java.lang.Exception -> L13
            return
        L13:
            r0 = move-exception
            java.lang.Exception r1 = r3.f35369e
            if (r1 != 0) goto L19
        L18:
            r1 = r0
        L19:
            r3.f35369e = r1
            com.hw.videoprocessor.util.c.g(r0)
            goto L3c
        L1f:
            r0 = move-exception
            goto L3d
        L21:
            r0 = move-exception
            com.hw.videoprocessor.util.c.g(r0)     // Catch: java.lang.Throwable -> L1f
            r3.f35369e = r0     // Catch: java.lang.Throwable -> L1f
            android.media.MediaCodec r0 = r3.f35365a     // Catch: java.lang.Exception -> L36
            if (r0 == 0) goto L3c
            android.media.MediaCodec r0 = r3.f35365a     // Catch: java.lang.Exception -> L36
            r0.stop()     // Catch: java.lang.Exception -> L36
            android.media.MediaCodec r0 = r3.f35365a     // Catch: java.lang.Exception -> L36
            r0.release()     // Catch: java.lang.Exception -> L36
            goto L3c
        L36:
            r0 = move-exception
            java.lang.Exception r1 = r3.f35369e
            if (r1 != 0) goto L19
            goto L18
        L3c:
            return
        L3d:
            android.media.MediaCodec r1 = r3.f35365a     // Catch: java.lang.Exception -> L4a
            if (r1 == 0) goto L55
            r1.stop()     // Catch: java.lang.Exception -> L4a
            android.media.MediaCodec r1 = r3.f35365a     // Catch: java.lang.Exception -> L4a
            r1.release()     // Catch: java.lang.Exception -> L4a
            goto L55
        L4a:
            r1 = move-exception
            java.lang.Exception r2 = r3.f35369e
            if (r2 != 0) goto L50
            r2 = r1
        L50:
            r3.f35369e = r2
            com.hw.videoprocessor.util.c.g(r1)
        L55:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.g.run():void");
    }
}
