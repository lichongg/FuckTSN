package cn.easyar.engine;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.view.Surface;
import com.stub.StubApp;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class VideoPlayer implements MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener {
    private Context mContext;
    private MediaPlayer mPlayer;
    private int mState;
    private VideoTexture mVideoTexture;
    private int nativeId;
    int STATE_ERROR = -1;
    int STATE_PREPARED = 0;
    int STATE_COMPLETED = 1;
    private float audioVolume = 1.0f;
    private boolean ready = false;
    private boolean readyForUpdate = false;
    private boolean readyForPause = false;
    private boolean renderTextureAvailable = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class VideoTexture implements SurfaceTexture.OnFrameAvailableListener {
        private SurfaceTexture mSurfaceTexture;
        private Boolean mUpdateSurface = Boolean.FALSE;

        VideoTexture() {
        }

        public SurfaceTexture getSurfaceTexture() {
            return this.mSurfaceTexture;
        }

        public void init(int textureId) {
            SurfaceTexture surfaceTexture = new SurfaceTexture(VideoPlayer.nativePlayerInitGL(VideoPlayer.this.nativeId, textureId));
            this.mSurfaceTexture = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            synchronized (this.mUpdateSurface) {
                this.mUpdateSurface = Boolean.TRUE;
            }
        }

        public void release() {
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
            }
            VideoPlayer.this.renderTextureAvailable = false;
        }

        public void updateTargetTexture() {
            synchronized (this.mUpdateSurface) {
                try {
                    if (this.mUpdateSurface.booleanValue()) {
                        this.mSurfaceTexture.updateTexImage();
                        float[] fArr = new float[16];
                        this.mSurfaceTexture.getTransformMatrix(fArr);
                        VideoPlayer.nativePlayerUpdate(VideoPlayer.this.nativeId, fArr);
                        this.mUpdateSurface = Boolean.FALSE;
                        VideoPlayer.this.renderTextureAvailable = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativePlayerInitGL(int id, int textureId);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativePlayerUpdate(int id, float[] transform);

    private static native void onVideoStateChanged(int id, int oldState, int newState);

    public void prepare(String url, int texture, boolean isAsset) {
        this.ready = false;
        try {
            if (isAsset) {
                AssetFileDescriptor openFd = this.mContext.getAssets().openFd(url);
                this.mPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            } else {
                this.mPlayer.setDataSource(url);
            }
            this.mVideoTexture.init(texture);
            this.mPlayer.prepareAsync();
        } catch (IOException unused) {
            setState(this.STATE_ERROR);
        }
    }

    private void setState(int state) {
        int i6 = this.mState;
        this.mState = state;
        onVideoStateChanged(this.nativeId, i6, state);
    }

    public int getCurrentPosition() {
        if (this.ready) {
            return this.mPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        if (this.ready) {
            return this.mPlayer.getDuration();
        }
        return 0;
    }

    public int getVideoHeight() {
        if (this.ready) {
            return this.mPlayer.getVideoHeight();
        }
        return 0;
    }

    public int getVideoWidth() {
        if (this.ready) {
            return this.mPlayer.getVideoWidth();
        }
        return 0;
    }

    public float getVolume() {
        return this.audioVolume;
    }

    public boolean isRenderTextureAvailable() {
        return this.renderTextureAvailable;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.mPlayer.seekTo(0);
        setState(this.STATE_COMPLETED);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
        setState(this.STATE_ERROR);
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.mPlayer.setSurface(new Surface(this.mVideoTexture.getSurfaceTexture()));
        setVolume(this.audioVolume);
        this.ready = true;
        setState(this.STATE_PREPARED);
    }

    public boolean pause() {
        if (!this.ready || !this.readyForPause) {
            return false;
        }
        this.mPlayer.pause();
        this.readyForUpdate = false;
        return true;
    }

    public void release() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mPlayer.release();
        }
        VideoTexture videoTexture = this.mVideoTexture;
        if (videoTexture != null) {
            videoTexture.release();
        }
    }

    public boolean seekTo(int position) {
        if (!this.ready) {
            return false;
        }
        this.mPlayer.seekTo(position);
        return true;
    }

    public boolean setVolume(float volume) {
        float max = Math.max(Math.min(volume, 1.0f), 0.0f);
        this.audioVolume = max;
        this.mPlayer.setVolume(max, max);
        return true;
    }

    public boolean start() {
        if (!this.ready) {
            return false;
        }
        this.mPlayer.start();
        this.readyForUpdate = true;
        this.readyForPause = true;
        return true;
    }

    public boolean stop() {
        if (!this.ready || !this.readyForPause) {
            return false;
        }
        this.mPlayer.pause();
        this.mPlayer.seekTo(0);
        this.readyForUpdate = false;
        return true;
    }

    public void updateFrame() {
        if (this.readyForUpdate) {
            this.mVideoTexture.updateTargetTexture();
        }
    }

    public VideoPlayer(Context context, int id) {
        this.nativeId = id;
        this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mPlayer = mediaPlayer;
        mediaPlayer.setOnErrorListener(this);
        this.mPlayer.setOnCompletionListener(this);
        this.mPlayer.setOnPreparedListener(this);
        this.mVideoTexture = new VideoTexture();
    }
}
