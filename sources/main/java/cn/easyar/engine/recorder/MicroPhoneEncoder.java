package cn.easyar.engine.recorder;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.MediaCodec;
import com.bykv.vk.component.ttvideo.player.C;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class MicroPhoneEncoder implements Runnable {
    protected static final int AUDIO_FORMAT = 2;
    private static final boolean DEBUG = false;
    protected static final int SAMPLES_PER_FRAME = 1024;
    private static final String TAG = "EasyAR";
    private static final boolean TRACE = false;
    long audioAbsolutePtsUs;
    int audioInputBufferIndex;
    int audioInputLength;
    private AudioRecord mAudioRecord;
    private AudioEncorderCore mEncoderCore;
    MediaCodec mMediaCodec;
    private boolean mRecordingRequested;
    private boolean mThreadReady;
    private boolean mThreadRunning;
    private volatile boolean isEnd = false;
    private final Object mReadyFence = new Object();
    private final Object mRecordingFence = new Object();
    long startPTS = 0;
    long totalSamplesNum = 0;

    @TargetApi(18)
    private void sendAudioToEncoder(boolean endOfStream) {
        if (this.mMediaCodec == null) {
            this.mMediaCodec = this.mEncoderCore.getMediaCodec();
        }
        try {
            ByteBuffer[] inputBuffers = this.mMediaCodec.getInputBuffers();
            int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(-1L);
            this.audioInputBufferIndex = dequeueInputBuffer;
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                this.audioInputLength = this.mAudioRecord.read(byteBuffer, 2048);
                long nanoTime = System.nanoTime() / 1000;
                this.audioAbsolutePtsUs = nanoTime;
                long jitterFreePTS = getJitterFreePTS(nanoTime, this.audioInputLength / 2);
                this.audioAbsolutePtsUs = jitterFreePTS;
                int i6 = this.audioInputLength;
                if (endOfStream) {
                    this.mMediaCodec.queueInputBuffer(this.audioInputBufferIndex, 0, i6, jitterFreePTS, 4);
                } else {
                    this.mMediaCodec.queueInputBuffer(this.audioInputBufferIndex, 0, i6, jitterFreePTS, 0);
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void startThread() {
        synchronized (this.mReadyFence) {
            try {
                if (this.mThreadRunning) {
                    return;
                }
                Thread thread = new Thread(this, "MicrophoneEncoder");
                thread.setPriority(10);
                thread.start();
                while (!this.mThreadReady) {
                    try {
                        this.mReadyFence.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean isRecording() {
        return this.mRecordingRequested;
    }

    @Override // java.lang.Runnable
    @TargetApi(18)
    public void run() {
        synchronized (this.mReadyFence) {
            this.mThreadReady = true;
            this.mReadyFence.notify();
        }
        synchronized (this.mRecordingFence) {
            while (!this.mRecordingRequested && !this.isEnd) {
                try {
                    this.mRecordingFence.wait();
                } catch (InterruptedException e6) {
                    e6.printStackTrace();
                }
            }
        }
        while (this.mRecordingRequested) {
            this.mEncoderCore.drainEncoder(false);
            sendAudioToEncoder(false);
        }
        this.mThreadReady = false;
        sendAudioToEncoder(true);
        this.mEncoderCore.drainEncoder(true);
        this.mEncoderCore.release();
        this.mAudioRecord.stop();
        this.mAudioRecord.release();
        this.mAudioRecord = null;
        this.mEncoderCore = null;
        this.mThreadRunning = false;
    }

    public void startRecording() throws IllegalStateException {
        try {
            this.mAudioRecord.startRecording();
            startThread();
            synchronized (this.mRecordingFence) {
                this.totalSamplesNum = 0L;
                this.startPTS = 0L;
                this.mRecordingRequested = true;
                this.mRecordingFence.notify();
            }
        } catch (IllegalStateException unused) {
            this.mEncoderCore.release();
            this.mAudioRecord.release();
            this.mEncoderCore = null;
            this.mAudioRecord = null;
            throw new IllegalStateException();
        }
    }

    public void stopRecording() {
        synchronized (this.mRecordingFence) {
            this.mRecordingRequested = false;
            this.isEnd = true;
            this.mRecordingFence.notify();
        }
    }

    public MicroPhoneEncoder(AVRecorderConfig config) throws RuntimeException {
        init(config);
    }

    private long getJitterFreePTS(long bufferPts, long bufferSamplesNum) {
        long j6 = bufferSamplesNum * C.MICROS_PER_SECOND;
        int i6 = this.mEncoderCore.mSampleRate;
        long j7 = j6 / i6;
        long j8 = bufferPts - j7;
        if (this.totalSamplesNum == 0) {
            this.startPTS = j8;
            this.totalSamplesNum = 0L;
        }
        long j9 = this.startPTS + ((this.totalSamplesNum * C.MICROS_PER_SECOND) / i6);
        if (j8 - j9 >= j7 * 2) {
            this.startPTS = j8;
            this.totalSamplesNum = 0L;
        } else {
            j8 = j9;
        }
        this.totalSamplesNum += bufferSamplesNum;
        return j8;
    }

    private void init(AVRecorderConfig config) throws RuntimeException {
        int i6;
        int numAudioChannels = config.getNumAudioChannels();
        if (numAudioChannels != 1) {
            if (numAudioChannels == 2) {
                i6 = 12;
            } else {
                throw new IllegalArgumentException("Invalid channel count. Must be 1 or 2");
            }
        } else {
            i6 = 16;
        }
        int minBufferSize = AudioRecord.getMinBufferSize(config.getAudioSamplerate(), i6, 2);
        try {
            this.mEncoderCore = new AudioEncorderCore(config.getNumAudioChannels(), config.getAudioBitrate(), config.getAudioSamplerate(), config.getMuxer());
            this.mAudioRecord = new AudioRecord(5, config.getAudioSamplerate(), i6, 2, minBufferSize * 4);
            this.mThreadReady = false;
            this.mThreadRunning = false;
            this.mRecordingRequested = false;
        } catch (IOException unused) {
            throw new RuntimeException("IOException");
        } catch (IllegalArgumentException unused2) {
            this.mEncoderCore.release();
            this.mEncoderCore = null;
            throw new RuntimeException("IllegalArgumentException");
        } catch (IllegalStateException unused3) {
            this.mEncoderCore.release();
            this.mAudioRecord.release();
            this.mEncoderCore = null;
            this.mAudioRecord = null;
            throw new RuntimeException("IllegalStateException");
        }
    }

    public void releaseRecording() {
    }
}
