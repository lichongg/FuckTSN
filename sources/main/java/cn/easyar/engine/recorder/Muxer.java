package cn.easyar.engine.recorder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(18)
/* loaded from: D:\Downloads\app\classes2.dex */
public class Muxer {
    private static final boolean DEBUG = false;
    private static final String TAG = "EasyAR";
    protected int mFormat;
    private volatile RecordListener mListener;
    private MediaMuxer mMuxer;
    protected String mOutputPath;
    private volatile boolean mStarted;
    private int mExpectedNumTracks = 2;
    private Object mObject = new Object();
    private boolean endBeforeStart = false;
    protected volatile int mNumTracks = 0;
    protected volatile int mNumTracksFinished = 0;
    protected long mFirstPts = 0;
    protected long[] mLastPts = new long[this.mExpectedNumTracks];

    public void endBeforeStart(boolean endBeforeStart) {
        this.endBeforeStart = endBeforeStart;
    }

    private long getSafePts(long pts, int trackIndex) {
        long[] jArr;
        long j6;
        try {
            jArr = this.mLastPts;
            j6 = jArr[trackIndex];
        } catch (Exception unused) {
        }
        if (j6 < pts) {
            jArr[trackIndex] = pts;
            return pts;
        }
        long j7 = j6 + 9643;
        jArr[trackIndex] = j7;
        return j7;
    }

    @TargetApi(18)
    public int addTrack(MediaFormat trackFormat) {
        int addTrack;
        if (this.mStarted) {
            throw new RuntimeException("format changed twice");
        }
        synchronized (this.mObject) {
            try {
                addTrack = this.mMuxer.addTrack(trackFormat);
                this.mNumTracks++;
                if (allTracksAdded()) {
                    start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return addTrack;
    }

    protected boolean allTracksAdded() {
        return this.mNumTracks == this.mExpectedNumTracks;
    }

    protected boolean allTracksFinished() {
        return this.mNumTracks == this.mNumTracksFinished;
    }

    public boolean endBeforeStart() {
        return this.endBeforeStart;
    }

    protected long getNextRelativePts(long absPts, int trackIndex) {
        long j6 = this.mFirstPts;
        if (j6 != 0) {
            return getSafePts(absPts - j6, trackIndex);
        }
        this.mFirstPts = absPts;
        return 0L;
    }

    public String getOutputPath() {
        return this.mOutputPath;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public void release(boolean filestatus) {
        if (this.mMuxer == null) {
            return;
        }
        this.mListener.onMessage(filestatus ? 1024 : 1025, this.mOutputPath);
        this.mMuxer.release();
        this.mListener = null;
        this.mMuxer = null;
    }

    protected void setExpectedTracks(int num) {
        this.mExpectedNumTracks = num;
    }

    public void setListener(RecordListener listener) {
        this.mListener = listener;
    }

    protected void signalEndOfTrack() {
        this.mNumTracksFinished++;
    }

    @TargetApi(18)
    protected void start() {
        this.mMuxer.start();
        this.mStarted = true;
    }

    @TargetApi(18)
    protected void stop() {
        synchronized (TAG) {
            try {
                try {
                    if (this.mStarted) {
                        this.mMuxer.stop();
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    release(true);
                    throw th;
                }
                release(true);
                this.mStarted = false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void writeSampleData(int trackIndex, ByteBuffer encodedData, MediaCodec.BufferInfo bufferInfo) {
        if ((bufferInfo.flags & 4) != 0) {
            signalEndOfTrack();
        }
        if ((bufferInfo.flags & 2) == 0 && this.mStarted) {
            if (bufferInfo.size == 0) {
                if (allTracksFinished()) {
                    stop();
                    return;
                }
                return;
            }
            bufferInfo.presentationTimeUs = getNextRelativePts(bufferInfo.presentationTimeUs, trackIndex);
            synchronized (this.mObject) {
                this.mMuxer.writeSampleData(trackIndex, encodedData, bufferInfo);
            }
            if (allTracksFinished()) {
                stop();
            }
        }
    }

    protected Muxer(String outputPath, int format) throws IOException {
        this.mOutputPath = outputPath;
        this.mFormat = format;
        int i6 = 0;
        while (true) {
            long[] jArr = this.mLastPts;
            if (i6 < jArr.length) {
                jArr[i6] = 0;
                i6++;
            } else {
                this.mMuxer = new MediaMuxer(outputPath.toString(), 0);
                return;
            }
        }
    }

    public void onEncoderReleased(int trackIndex) {
    }
}
