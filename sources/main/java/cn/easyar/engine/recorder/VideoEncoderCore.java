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
public class VideoEncoderCore {
    private static final boolean DEBUG = false;
    private static final int FRAME_RATE = 30;
    private static final int IFRAME_INTERVAL = 5;
    private static final String MIME_TYPE = "video/avc";
    private static final String TAG = "EasyAR";
    private MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();
    private MediaCodec mEncoder;
    private Surface mInputSurface;
    private Muxer mMuxer;
    private int mTrackIndex;

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e6, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void drainEncoder(boolean r9) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.easyar.engine.recorder.VideoEncoderCore.drainEncoder(boolean):void");
    }

    public Surface getInputSurface() {
        return this.mInputSurface;
    }

    public void release() {
        MediaCodec mediaCodec = this.mEncoder;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.mEncoder.release();
            this.mEncoder = null;
        }
    }

    public VideoEncoderCore(int width, int height, int bitRate, Muxer muxer) throws IOException {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(MIME_TYPE, width, height);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", bitRate);
        createVideoFormat.setInteger("frame-rate", 30);
        createVideoFormat.setInteger("i-frame-interval", 5);
        createVideoFormat.getInteger("width");
        createVideoFormat.getInteger("height");
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType(MIME_TYPE);
        this.mEncoder = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.mInputSurface = this.mEncoder.createInputSurface();
        this.mEncoder.start();
        this.mMuxer = muxer;
        this.mTrackIndex = -1;
    }
}
