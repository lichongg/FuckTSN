package com.baidu.idl.face.platform.ui;

import android.content.BroadcastReceiver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.face.platform.IDetectStrategy;
import com.baidu.idl.face.platform.IDetectStrategyCallback;
import com.baidu.idl.face.platform.model.ImageInfo;
import com.baidu.idl.face.platform.ui.utils.BrightnessUtils;
import com.baidu.idl.face.platform.ui.utils.CameraPreviewUtils;
import com.baidu.idl.face.platform.ui.utils.CameraUtils;
import com.baidu.idl.face.platform.ui.utils.VolumeUtils;
import com.baidu.idl.face.platform.ui.widget.FaceDetectRoundView;
import com.baidu.idl.face.platform.utils.Base64Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FaceDetectActivity extends AppCompatActivity implements SurfaceHolder.Callback, Camera.PreviewCallback, Camera.ErrorCallback, VolumeUtils.VolumeCallback, IDetectStrategyCallback {
    public static final String TAG = "FaceDetectActivity";
    protected Camera mCamera;
    protected int mCameraId;
    protected Camera.Parameters mCameraParam;
    protected ImageView mCloseView;
    protected FaceConfig mFaceConfig;
    protected FaceDetectRoundView mFaceDetectRoundView;
    protected FrameLayout mFrameLayout;
    protected boolean mHasShownTimeoutDialog;
    protected IDetectStrategy mIDetectStrategy;
    protected LinearLayout mImageLayout;
    protected LinearLayout mImageLayout2;
    protected int mPreviewDegree;
    protected int mPreviewHight;
    protected int mPreviewWidth;
    protected View mRootView;
    protected ImageView mSoundView;
    protected ImageView mSuccessView;
    protected SurfaceHolder mSurfaceHolder;
    protected SurfaceView mSurfaceView;
    protected Drawable mTipsIcon;
    protected TextView mTipsTopView;
    public View mViewBg;
    protected BroadcastReceiver mVolumeReceiver;
    private Rect mPreviewRect = new Rect();
    protected int mDisplayWidth = 0;
    protected int mDisplayHeight = 0;
    protected int mSurfaceWidth = 0;
    protected int mSurfaceHeight = 0;
    protected volatile boolean mIsEnableSound = true;
    protected HashMap<String, String> mBase64ImageMap = new HashMap<>();
    protected boolean mIsCreateSurface = false;
    protected volatile boolean mIsCompletion = false;

    private static Bitmap base64ToBitmap(String str) {
        byte[] decode = Base64Utils.decode(str, 2);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mIsCreateSurface = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.mIsCreateSurface = false;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.baidu.idl.face.platform.ui.FaceDetectActivity$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum;

        static {
            int[] iArr = new int[FaceStatusNewEnum.values().length];
            $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum = iArr;
            try {
                iArr[FaceStatusNewEnum.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int displayOrientation(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "window"
            java.lang.Object r4 = r4.getSystemService(r0)
            android.view.WindowManager r4 = (android.view.WindowManager) r4
            r0 = 90
            if (r4 != 0) goto Ld
            return r0
        Ld:
            android.view.Display r4 = r4.getDefaultDisplay()
            int r4 = r4.getRotation()
            r1 = 0
            r2 = 1
            if (r4 == 0) goto L21
            if (r4 == r2) goto L28
            r0 = 2
            if (r4 == r0) goto L26
            r0 = 3
            if (r4 == r0) goto L23
        L21:
            r0 = 0
            goto L28
        L23:
            r0 = 270(0x10e, float:3.78E-43)
            goto L28
        L26:
            r0 = 180(0xb4, float:2.52E-43)
        L28:
            int r4 = 360 - r0
            int r4 = r4 % 360
            boolean r1 = com.baidu.idl.face.platform.utils.APIUtils.hasGingerbread()
            if (r1 == 0) goto L51
            android.hardware.Camera$CameraInfo r4 = new android.hardware.Camera$CameraInfo
            r4.<init>()
            int r1 = r3.mCameraId
            android.hardware.Camera.getCameraInfo(r1, r4)
            int r1 = r4.facing
            if (r1 != r2) goto L4a
            int r4 = r4.orientation
            int r4 = r4 + r0
            int r4 = r4 % 360
            int r4 = 360 - r4
            int r4 = r4 % 360
            return r4
        L4a:
            int r4 = r4.orientation
            int r4 = r4 - r0
            int r4 = r4 + 360
            int r4 = r4 % 360
        L51:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.face.platform.ui.FaceDetectActivity.displayOrientation(android.content.Context):int");
    }

    private void onRefreshView(FaceStatusNewEnum faceStatusNewEnum, String str) {
        int i6 = AnonymousClass5.$SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[faceStatusNewEnum.ordinal()];
        if (i6 == 1) {
            this.mFaceDetectRoundView.setTipTopText(str);
            return;
        }
        if (i6 == 2 || i6 == 3 || i6 == 4 || i6 == 5) {
            this.mFaceDetectRoundView.setTipTopText(str);
        } else {
            this.mFaceDetectRoundView.setTipTopText(str);
        }
    }

    private void saveAllImage(HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2) {
        if (hashMap != null && hashMap.size() > 0) {
            ArrayList arrayList = new ArrayList(hashMap.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, ImageInfo>>() { // from class: com.baidu.idl.face.platform.ui.FaceDetectActivity.3
                @Override // java.util.Comparator
                public int compare(Map.Entry<String, ImageInfo> entry, Map.Entry<String, ImageInfo> entry2) {
                    return Float.valueOf(entry2.getKey().split("_")[2]).compareTo(Float.valueOf(entry.getKey().split("_")[2]));
                }
            });
            setImageView1(arrayList);
        }
        if (hashMap2 == null || hashMap2.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(hashMap2.entrySet());
        Collections.sort(arrayList2, new Comparator<Map.Entry<String, ImageInfo>>() { // from class: com.baidu.idl.face.platform.ui.FaceDetectActivity.4
            @Override // java.util.Comparator
            public int compare(Map.Entry<String, ImageInfo> entry, Map.Entry<String, ImageInfo> entry2) {
                return Float.valueOf(entry2.getKey().split("_")[2]).compareTo(Float.valueOf(entry.getKey().split("_")[2]));
            }
        });
        setImageView2(arrayList2);
    }

    private void setImageView1(List<Map.Entry<String, ImageInfo>> list) {
        this.mImageLayout.removeAllViews();
        Iterator<Map.Entry<String, ImageInfo>> it = list.iterator();
        while (it.hasNext()) {
            Bitmap base64ToBitmap = base64ToBitmap(it.next().getValue().getBase64());
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(base64ToBitmap);
            this.mImageLayout.addView(imageView, new LinearLayout.LayoutParams(300, 300));
        }
    }

    private void setImageView2(List<Map.Entry<String, ImageInfo>> list) {
        this.mImageLayout2.removeAllViews();
        Iterator<Map.Entry<String, ImageInfo>> it = list.iterator();
        while (it.hasNext()) {
            Bitmap base64ToBitmap = base64ToBitmap(it.next().getValue().getBase64());
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(base64ToBitmap);
            this.mImageLayout2.addView(imageView, new LinearLayout.LayoutParams(300, 300));
        }
    }

    public void onDetectCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2) {
        if (this.mIsCompletion) {
            return;
        }
        onRefreshView(faceStatusNewEnum, str);
        if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
            this.mIsCompletion = true;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IDetectStrategy iDetectStrategy = this.mIDetectStrategy;
        if (iDetectStrategy != null) {
            iDetectStrategy.reset();
        }
        super.onPause();
        VolumeUtils.unRegisterVolumeReceiver(this, this.mVolumeReceiver);
        this.mVolumeReceiver = null;
        this.mIsCompletion = false;
        stopPreview();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        FaceDetectRoundView faceDetectRoundView;
        if (this.mIsCompletion) {
            return;
        }
        if (this.mIDetectStrategy == null && (faceDetectRoundView = this.mFaceDetectRoundView) != null && faceDetectRoundView.getRound() > 0.0f) {
            IDetectStrategy detectStrategyModule = FaceSDKManager.getInstance().getDetectStrategyModule();
            this.mIDetectStrategy = detectStrategyModule;
            detectStrategyModule.setPreviewDegree(this.mPreviewDegree);
            this.mIDetectStrategy.setDetectStrategySoundEnable(this.mIsEnableSound);
            this.mIDetectStrategy.setDetectStrategyConfig(this.mPreviewRect, FaceDetectRoundView.getPreviewDetectRect(this.mDisplayWidth, this.mPreviewHight, this.mPreviewWidth), this);
        }
        IDetectStrategy iDetectStrategy = this.mIDetectStrategy;
        if (iDetectStrategy != null) {
            iDetectStrategy.detectStrategy(bArr);
        }
    }

    protected void startPreview() {
        SurfaceView surfaceView = this.mSurfaceView;
        if (surfaceView != null && surfaceView.getHolder() != null) {
            SurfaceHolder holder = this.mSurfaceView.getHolder();
            this.mSurfaceHolder = holder;
            holder.addCallback(this);
        }
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.setPreviewCallback(null);
                this.mCamera.stopPreview();
                this.mCamera.release();
                this.mCamera = null;
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        if (this.mCamera == null) {
            try {
                this.mCamera = open();
            } catch (RuntimeException e7) {
                e7.printStackTrace();
            } catch (Exception e8) {
                e8.printStackTrace();
            }
        }
        Camera camera2 = this.mCamera;
        if (camera2 == null) {
            return;
        }
        if (this.mCameraParam == null) {
            this.mCameraParam = camera2.getParameters();
        }
        this.mCameraParam.setPictureFormat(256);
        int displayOrientation = displayOrientation(this);
        this.mCamera.setDisplayOrientation(displayOrientation);
        this.mCameraParam.set("rotation", displayOrientation);
        this.mPreviewDegree = displayOrientation;
        IDetectStrategy iDetectStrategy = this.mIDetectStrategy;
        if (iDetectStrategy != null) {
            iDetectStrategy.setPreviewDegree(displayOrientation);
        }
        Point bestPreview = CameraPreviewUtils.getBestPreview(this.mCameraParam, new Point(640, 480));
        int i6 = bestPreview.x;
        this.mPreviewWidth = i6;
        int i7 = bestPreview.y;
        this.mPreviewHight = i7;
        this.mPreviewRect.set(0, 0, i7, i6);
        this.mCameraParam.setPreviewSize(this.mPreviewWidth, this.mPreviewHight);
        this.mCamera.setParameters(this.mCameraParam);
        try {
            this.mCamera.setPreviewDisplay(this.mSurfaceHolder);
            this.mCamera.stopPreview();
            this.mCamera.setErrorCallback(this);
            this.mCamera.setPreviewCallback(this);
            this.mCamera.startPreview();
        } catch (RuntimeException e9) {
            e9.printStackTrace();
            CameraUtils.releaseCamera(this.mCamera);
            this.mCamera = null;
        } catch (Exception e10) {
            e10.printStackTrace();
            CameraUtils.releaseCamera(this.mCamera);
            this.mCamera = null;
        }
    }

    protected void stopPreview() {
        Camera camera = this.mCamera;
        try {
            if (camera != null) {
                try {
                    camera.setErrorCallback(null);
                    this.mCamera.setPreviewCallback(null);
                    this.mCamera.stopPreview();
                } catch (RuntimeException e6) {
                    e6.printStackTrace();
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
            SurfaceHolder surfaceHolder = this.mSurfaceHolder;
            if (surfaceHolder != null) {
                surfaceHolder.removeCallback(this);
            }
            IDetectStrategy iDetectStrategy = this.mIDetectStrategy;
            if (iDetectStrategy != null) {
                iDetectStrategy.reset();
                this.mIDetectStrategy = null;
            }
        } finally {
            CameraUtils.releaseCamera(this.mCamera);
            this.mCamera = null;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i6, int i7, int i8) {
        this.mSurfaceWidth = i7;
        this.mSurfaceHeight = i8;
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        startPreview();
    }

    @Override // com.baidu.idl.face.platform.ui.utils.VolumeUtils.VolumeCallback
    public void volumeChanged() {
        try {
            AudioManager audioManager = (AudioManager) getSystemService("audio");
            if (audioManager != null) {
                this.mIsEnableSound = audioManager.getStreamVolume(3) > 0;
                this.mSoundView.setImageResource(this.mIsEnableSound ? R.mipmap.icon_titlebar_voice2 : R.mipmap.icon_titlebar_voice1);
                IDetectStrategy iDetectStrategy = this.mIDetectStrategy;
                if (iDetectStrategy != null) {
                    iDetectStrategy.setDetectStrategySoundEnable(this.mIsEnableSound);
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private Camera open() {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            return null;
        }
        int i6 = 0;
        while (i6 < numberOfCameras) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i6, cameraInfo);
            if (cameraInfo.facing == 1) {
                break;
            }
            i6++;
        }
        if (i6 < numberOfCameras) {
            Camera open = Camera.open(i6);
            this.mCameraId = i6;
            return open;
        }
        Camera open2 = Camera.open(0);
        this.mCameraId = 0;
        return open2;
    }

    private void setScreenBright() {
        BrightnessUtils.setBrightness(this, BrightnessUtils.getScreenBrightness(this) + 100);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z5;
        int i6;
        super.onCreate(bundle);
        setScreenBright();
        getWindow().addFlags(128);
        setContentView(R.layout.activity_face_detect_v3100);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mDisplayWidth = displayMetrics.widthPixels;
        this.mDisplayHeight = displayMetrics.heightPixels;
        FaceSDKResSettings.initializeResId();
        this.mFaceConfig = FaceSDKManager.getInstance().getFaceConfig();
        if (((AudioManager) getSystemService("audio")).getStreamVolume(3) > 0) {
            z5 = this.mFaceConfig.isSound();
        } else {
            z5 = false;
        }
        this.mIsEnableSound = z5;
        View findViewById = findViewById(R.id.detect_root_layout);
        this.mRootView = findViewById;
        this.mFrameLayout = (FrameLayout) findViewById.findViewById(R.id.detect_surface_layout);
        SurfaceView surfaceView = new SurfaceView(this);
        this.mSurfaceView = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        this.mSurfaceHolder = holder;
        holder.setSizeFromLayout();
        this.mSurfaceHolder.addCallback(this);
        this.mSurfaceHolder.setType(3);
        float f6 = this.mDisplayWidth * 0.75f * 0.9f;
        this.mSurfaceView.setLayoutParams(new FrameLayout.LayoutParams((int) f6, (int) ((f6 * 640.0f) / 480.0f), 17));
        this.mFrameLayout.addView(this.mSurfaceView);
        View view = this.mRootView;
        int i7 = R.id.detect_close;
        view.findViewById(i7).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.idl.face.platform.ui.FaceDetectActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FaceDetectActivity.this.onBackPressed();
            }
        });
        FaceDetectRoundView faceDetectRoundView = (FaceDetectRoundView) this.mRootView.findViewById(R.id.detect_face_round);
        this.mFaceDetectRoundView = faceDetectRoundView;
        faceDetectRoundView.setIsActiveLive(false);
        this.mCloseView = (ImageView) this.mRootView.findViewById(i7);
        ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.detect_sound);
        this.mSoundView = imageView;
        if (this.mIsEnableSound) {
            i6 = R.mipmap.icon_titlebar_voice2;
        } else {
            i6 = R.drawable.collect_image_voice_selector;
        }
        imageView.setImageResource(i6);
        this.mSoundView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.idl.face.platform.ui.FaceDetectActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FaceDetectActivity.this.mIsEnableSound = !r2.mIsEnableSound;
                FaceDetectActivity faceDetectActivity = FaceDetectActivity.this;
                faceDetectActivity.mSoundView.setImageResource(faceDetectActivity.mIsEnableSound ? R.mipmap.icon_titlebar_voice2 : R.drawable.collect_image_voice_selector);
                FaceDetectActivity faceDetectActivity2 = FaceDetectActivity.this;
                IDetectStrategy iDetectStrategy = faceDetectActivity2.mIDetectStrategy;
                if (iDetectStrategy != null) {
                    iDetectStrategy.setDetectStrategySoundEnable(faceDetectActivity2.mIsEnableSound);
                }
            }
        });
        this.mTipsTopView = (TextView) this.mRootView.findViewById(R.id.detect_top_tips);
        this.mSuccessView = (ImageView) this.mRootView.findViewById(R.id.detect_success_image);
        this.mImageLayout = (LinearLayout) this.mRootView.findViewById(R.id.detect_result_image_layout);
        this.mImageLayout2 = (LinearLayout) this.mRootView.findViewById(R.id.detect_result_image_layout2);
        this.mViewBg = findViewById(R.id.view_bg);
        HashMap<String, String> hashMap = this.mBase64ImageMap;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.mHasShownTimeoutDialog) {
            setVolumeControlStream(3);
            this.mVolumeReceiver = VolumeUtils.registerVolumeReceiver(this, this);
            FaceDetectRoundView faceDetectRoundView = this.mFaceDetectRoundView;
            if (faceDetectRoundView != null) {
                faceDetectRoundView.setTipTopText("请将脸移入取景框");
            }
            startPreview();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // android.hardware.Camera.ErrorCallback
    public void onError(int i6, Camera camera) {
    }
}
