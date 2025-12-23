package cn.easyar.engine.recorder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(18)
/* loaded from: D:\Downloads\app\classes2.dex */
public class AudioEncorderCore {
    private static final boolean DEBUG = false;
    protected static final String MIME_TYPE = "audio/mp4a-latm";
    protected int mChannelConfig;
    protected MediaCodec mEncoder;
    protected Muxer mMuxer;
    protected int mSampleRate;
    protected int mTrackIndex;
    private final String TAG = "EasyAR";
    protected volatile boolean mForceEos = false;
    int mEosSpinCount = 0;
    final int MAX_EOS_SPINS = 10;
    protected MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();

    public static boolean isKitKat() {
        return true;
    }

    public void signalEndOfStream() {
        this.mForceEos = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ac, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void drainEncoder(boolean r10) {
        /*
            r9 = this;
            cn.easyar.engine.recorder.Muxer r0 = r9.mMuxer
            monitor-enter(r0)
            cn.easyar.engine.recorder.Muxer r1 = r9.mMuxer     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r1.isStarted()     // Catch: java.lang.Throwable -> L1d
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L31
            if (r10 == 0) goto L27
            cn.easyar.engine.recorder.Muxer r10 = r9.mMuxer     // Catch: java.lang.Throwable -> L1d
            boolean r10 = r10.endBeforeStart()     // Catch: java.lang.Throwable -> L1d
            if (r10 != 0) goto L20
            cn.easyar.engine.recorder.Muxer r10 = r9.mMuxer     // Catch: java.lang.Throwable -> L1d
            r10.endBeforeStart(r3)     // Catch: java.lang.Throwable -> L1d
            goto L25
        L1d:
            r10 = move-exception
            goto Lc9
        L20:
            cn.easyar.engine.recorder.Muxer r10 = r9.mMuxer     // Catch: java.lang.Throwable -> L1d
            r10.release(r2)     // Catch: java.lang.Throwable -> L1d
        L25:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1d
            return
        L27:
            cn.easyar.engine.recorder.Muxer r1 = r9.mMuxer     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r1.endBeforeStart()     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L31
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1d
            return
        L31:
            android.media.MediaCodec r1 = r9.mEncoder     // Catch: java.lang.Throwable -> L1d
            java.nio.ByteBuffer[] r1 = r1.getOutputBuffers()     // Catch: java.lang.Throwable -> L1d
        L37:
            android.media.MediaCodec r4 = r9.mEncoder     // Catch: java.lang.Throwable -> L1d
            android.media.MediaCodec$BufferInfo r5 = r9.mBufferInfo     // Catch: java.lang.Throwable -> L1d
            r6 = 1000(0x3e8, double:4.94E-321)
            int r4 = r4.dequeueOutputBuffer(r5, r6)     // Catch: java.lang.Throwable -> L1d
            r5 = -1
            if (r4 != r5) goto L51
            if (r10 != 0) goto L47
            goto Lab
        L47:
            int r4 = r9.mEosSpinCount     // Catch: java.lang.Throwable -> L1d
            int r4 = r4 + r3
            r9.mEosSpinCount = r4     // Catch: java.lang.Throwable -> L1d
            r5 = 10
            if (r4 <= r5) goto L37
            goto Lab
        L51:
            r5 = -3
            if (r4 != r5) goto L5b
            android.media.MediaCodec r1 = r9.mEncoder     // Catch: java.lang.Throwable -> L1d
            java.nio.ByteBuffer[] r1 = r1.getOutputBuffers()     // Catch: java.lang.Throwable -> L1d
            goto L37
        L5b:
            r5 = -2
            if (r4 != r5) goto L6d
            android.media.MediaCodec r4 = r9.mEncoder     // Catch: java.lang.Throwable -> L1d
            android.media.MediaFormat r4 = r4.getOutputFormat()     // Catch: java.lang.Throwable -> L1d
            cn.easyar.engine.recorder.Muxer r5 = r9.mMuxer     // Catch: java.lang.Throwable -> L1d
            int r4 = r5.addTrack(r4)     // Catch: java.lang.Throwable -> L1d
            r9.mTrackIndex = r4     // Catch: java.lang.Throwable -> L1d
            goto L37
        L6d:
            if (r4 >= 0) goto L70
            goto L37
        L70:
            r5 = r1[r4]     // Catch: java.lang.Throwable -> L1d
            if (r5 == 0) goto Lad
            android.media.MediaCodec$BufferInfo r6 = r9.mBufferInfo     // Catch: java.lang.Throwable -> L1d
            int r7 = r6.size     // Catch: java.lang.Throwable -> L1d
            if (r7 < 0) goto L9e
            int r6 = r6.offset     // Catch: java.lang.Throwable -> L1d
            r5.position(r6)     // Catch: java.lang.Throwable -> L1d
            android.media.MediaCodec$BufferInfo r6 = r9.mBufferInfo     // Catch: java.lang.Throwable -> L1d
            int r7 = r6.offset     // Catch: java.lang.Throwable -> L1d
            int r6 = r6.size     // Catch: java.lang.Throwable -> L1d
            int r7 = r7 + r6
            r5.limit(r7)     // Catch: java.lang.Throwable -> L1d
            boolean r6 = r9.mForceEos     // Catch: java.lang.Throwable -> L1d
            if (r6 == 0) goto L95
            android.media.MediaCodec$BufferInfo r6 = r9.mBufferInfo     // Catch: java.lang.Throwable -> L1d
            int r7 = r6.flags     // Catch: java.lang.Throwable -> L1d
            r7 = r7 | 4
            r6.flags = r7     // Catch: java.lang.Throwable -> L1d
        L95:
            cn.easyar.engine.recorder.Muxer r6 = r9.mMuxer     // Catch: java.lang.Throwable -> L1d
            int r7 = r9.mTrackIndex     // Catch: java.lang.Throwable -> L1d
            android.media.MediaCodec$BufferInfo r8 = r9.mBufferInfo     // Catch: java.lang.Throwable -> L1d
            r6.writeSampleData(r7, r5, r8)     // Catch: java.lang.Throwable -> L1d
        L9e:
            android.media.MediaCodec r5 = r9.mEncoder     // Catch: java.lang.Throwable -> L1d
            r5.releaseOutputBuffer(r4, r2)     // Catch: java.lang.Throwable -> L1d
            android.media.MediaCodec$BufferInfo r4 = r9.mBufferInfo     // Catch: java.lang.Throwable -> L1d
            int r4 = r4.flags     // Catch: java.lang.Throwable -> L1d
            r4 = r4 & 4
            if (r4 == 0) goto L37
        Lab:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1d
            return
        Lad:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L1d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1d
            r1.<init>()     // Catch: java.lang.Throwable -> L1d
            java.lang.String r2 = "encoderOutputBuffer "
            r1.append(r2)     // Catch: java.lang.Throwable -> L1d
            r1.append(r4)     // Catch: java.lang.Throwable -> L1d
            java.lang.String r2 = " was null"
            r1.append(r2)     // Catch: java.lang.Throwable -> L1d
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L1d
            r10.<init>(r1)     // Catch: java.lang.Throwable -> L1d
            throw r10     // Catch: java.lang.Throwable -> L1d
        Lc9:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1d
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.easyar.engine.recorder.AudioEncorderCore.drainEncoder(boolean):void");
    }

    public MediaCodec getMediaCodec() {
        return this.mEncoder;
    }

    public void release() {
        Muxer muxer = this.mMuxer;
        if (muxer != null) {
            muxer.onEncoderReleased(this.mTrackIndex);
        }
        MediaCodec mediaCodec = this.mEncoder;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.mEncoder.release();
            this.mEncoder = null;
        }
    }

    public AudioEncorderCore(int numChannels, int bitRate, int sampleRate, Muxer muxer) throws IOException {
        this.mSampleRate = sampleRate;
        this.mMuxer = muxer;
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(MIME_TYPE, this.mSampleRate, numChannels);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE, this.mSampleRate);
        createAudioFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT, numChannels);
        createAudioFormat.setInteger("bitrate", bitRate);
        createAudioFormat.setInteger("max-input-size", 16384);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType(MIME_TYPE);
        this.mEncoder = createEncoderByType;
        createEncoderByType.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.mEncoder.start();
        this.mTrackIndex = -1;
    }
}
