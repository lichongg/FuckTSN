package com.baidu.idl.face.platform.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.face.platform.ILivenessStrategy;
import com.baidu.idl.face.platform.ILivenessStrategyCallback;
import com.baidu.idl.face.platform.ILivenessViewCallback;
import com.baidu.idl.face.platform.LivenessTypeEnum;
import com.baidu.idl.face.platform.manager.TimeManager;
import com.baidu.idl.face.platform.model.FaceExtInfo;
import com.baidu.idl.face.platform.model.ImageInfo;
import com.baidu.idl.face.platform.ui.utils.BrightnessUtils;
import com.baidu.idl.face.platform.ui.utils.CameraPreviewUtils;
import com.baidu.idl.face.platform.ui.utils.CameraUtils;
import com.baidu.idl.face.platform.ui.utils.VolumeUtils;
import com.baidu.idl.face.platform.ui.widget.FaceDetectRoundView;
import com.baidu.idl.face.platform.utils.Base64Utils;
import com.baidu.idl.face.platform.utils.DensityUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FaceLivenessActivity extends AppCompatActivity implements SurfaceHolder.Callback, Camera.PreviewCallback, Camera.ErrorCallback, VolumeUtils.VolumeCallback, ILivenessStrategyCallback, ILivenessViewCallback {
    public static final String TAG = "FaceLivenessActivity";
    private AnimationDrawable mAnimationDrawable;
    protected Camera mCamera;
    protected int mCameraId;
    protected Camera.Parameters mCameraParam;
    protected ImageView mCloseView;
    private Context mContext;
    protected FaceConfig mFaceConfig;
    protected FaceDetectRoundView mFaceDetectRoundView;
    protected FrameLayout mFrameLayout;
    protected boolean mHasShownTimeoutDialog;
    protected ILivenessStrategy mILivenessStrategy;
    private ImageView mImageAnim;
    protected LinearLayout mImageLayout;
    protected LinearLayout mImageLayout2;
    protected int mPreviewDegree;
    protected int mPreviewHight;
    protected int mPreviewWidth;
    private RelativeLayout mRelativeAddImageView;
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
    protected boolean mIsCreateSurface = false;
    protected boolean mIsCompletion = false;
    private LivenessTypeEnum mLivenessType = null;

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
    /* renamed from: com.baidu.idl.face.platform.ui.FaceLivenessActivity$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum;
        static final /* synthetic */ int[] $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum;

        static {
            int[] iArr = new int[LivenessTypeEnum.values().length];
            $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum = iArr;
            try {
                iArr[LivenessTypeEnum.Eye.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum[LivenessTypeEnum.HeadLeft.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum[LivenessTypeEnum.HeadRight.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum[LivenessTypeEnum.HeadDown.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum[LivenessTypeEnum.HeadUp.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum[LivenessTypeEnum.Mouth.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[FaceStatusNewEnum.values().length];
            $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum = iArr2;
            try {
                iArr2[FaceStatusNewEnum.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.FaceLivenessActionComplete.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeTooClose.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeTooFar.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeNoFaceDetected.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.FaceLivenessActionTypeLiveEye.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.FaceLivenessActionTypeLiveMouth.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.FaceLivenessActionTypeLivePitchUp.ordinal()] = 9;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.FaceLivenessActionTypeLivePitchDown.ordinal()] = 10;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.FaceLivenessActionTypeLiveYawLeft.ordinal()] = 11;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.FaceLivenessActionTypeLiveYawRight.ordinal()] = 12;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.FaceLivenessActionTypeLiveYaw.ordinal()] = 13;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange.ordinal()] = 14;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange.ordinal()] = 15;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange.ordinal()] = 16;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange.ordinal()] = 17;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[FaceStatusNewEnum.FaceLivenessActionCodeTimeout.ordinal()] = 18;
            } catch (NoSuchFieldError unused24) {
            }
        }
    }

    private void addImageView() {
        this.mFaceDetectRoundView.post(new Runnable() { // from class: com.baidu.idl.face.platform.ui.FaceLivenessActivity.3
            @Override // java.lang.Runnable
            public void run() {
                FaceLivenessActivity.this.mImageAnim = new ImageView(FaceLivenessActivity.this);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.height = DensityUtils.dip2px(FaceLivenessActivity.this.mContext, 110.0f);
                layoutParams.width = DensityUtils.dip2px(FaceLivenessActivity.this.mContext, 87.0f);
                float height = FaceLivenessActivity.this.mFaceDetectRoundView.getHeight() / 2;
                layoutParams.setMargins(0, ((int) (height - (0.1f * height))) - (layoutParams.height / 2), 0, 0);
                layoutParams.addRule(14);
                FaceLivenessActivity.this.mImageAnim.setLayoutParams(layoutParams);
                FaceLivenessActivity.this.mImageAnim.setScaleType(ImageView.ScaleType.FIT_XY);
                FaceLivenessActivity.this.mRelativeAddImageView.addView(FaceLivenessActivity.this.mImageAnim);
            }
        });
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.face.platform.ui.FaceLivenessActivity.displayOrientation(android.content.Context):int");
    }

    private void loadAnimSource() {
        LivenessTypeEnum livenessTypeEnum = this.mLivenessType;
        if (livenessTypeEnum != null) {
            switch (AnonymousClass6.$SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum[livenessTypeEnum.ordinal()]) {
                case 1:
                    this.mImageAnim.setBackgroundResource(R.drawable.anim_eye);
                    break;
                case 2:
                    this.mImageAnim.setBackgroundResource(R.drawable.anim_left);
                    break;
                case 3:
                    this.mImageAnim.setBackgroundResource(R.drawable.anim_right);
                    break;
                case 4:
                    this.mImageAnim.setBackgroundResource(R.drawable.anim_down);
                    break;
                case 5:
                    this.mImageAnim.setBackgroundResource(R.drawable.anim_up);
                    break;
                case 6:
                    this.mImageAnim.setBackgroundResource(R.drawable.anim_mouth);
                    break;
            }
            AnimationDrawable animationDrawable = (AnimationDrawable) this.mImageAnim.getBackground();
            this.mAnimationDrawable = animationDrawable;
            animationDrawable.start();
        }
    }

    private void onRefreshView(FaceStatusNewEnum faceStatusNewEnum, String str, int i6) {
        switch (AnonymousClass6.$SwitchMap$com$baidu$idl$face$platform$FaceStatusNewEnum[faceStatusNewEnum.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                this.mFaceDetectRoundView.setTipTopText(str);
                this.mFaceDetectRoundView.setTipSecondText("");
                this.mFaceDetectRoundView.setProcessCount(i6, this.mFaceConfig.getLivenessTypeList().size());
                stopAnim();
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                this.mFaceDetectRoundView.setTipTopText(str);
                this.mFaceDetectRoundView.setTipSecondText("");
                this.mFaceDetectRoundView.setProcessCount(i6, this.mFaceConfig.getLivenessTypeList().size());
                break;
            case 14:
            case 15:
            case 16:
            case 17:
                this.mFaceDetectRoundView.setTipTopText("请保持正脸");
                this.mFaceDetectRoundView.setTipSecondText(str);
                this.mFaceDetectRoundView.setProcessCount(i6, this.mFaceConfig.getLivenessTypeList().size());
                break;
            case 18:
                this.mFaceDetectRoundView.setProcessCount(i6, this.mFaceConfig.getLivenessTypeList().size());
                if (this.mRelativeAddImageView.getVisibility() == 4) {
                    this.mRelativeAddImageView.setVisibility(0);
                }
                loadAnimSource();
                int i7 = 0;
                for (int i8 = 0; i8 < this.mAnimationDrawable.getNumberOfFrames(); i8++) {
                    i7 += this.mAnimationDrawable.getDuration(i8);
                }
                TimeManager.getInstance().setActiveAnimTime(i7);
                break;
            default:
                this.mFaceDetectRoundView.setTipTopText("请保持正脸");
                this.mFaceDetectRoundView.setTipSecondText(str);
                this.mFaceDetectRoundView.setProcessCount(i6, this.mFaceConfig.getLivenessTypeList().size());
                break;
        }
    }

    private void saveAllImage(HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2) {
        if (hashMap != null && hashMap.size() > 0) {
            ArrayList arrayList = new ArrayList(hashMap.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, ImageInfo>>() { // from class: com.baidu.idl.face.platform.ui.FaceLivenessActivity.4
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
        Collections.sort(arrayList2, new Comparator<Map.Entry<String, ImageInfo>>() { // from class: com.baidu.idl.face.platform.ui.FaceLivenessActivity.5
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

    private void stopAnim() {
        AnimationDrawable animationDrawable = this.mAnimationDrawable;
        if (animationDrawable != null) {
            animationDrawable.stop();
            this.mAnimationDrawable = null;
        }
        if (this.mRelativeAddImageView.getVisibility() == 0) {
            this.mRelativeAddImageView.setVisibility(4);
        }
    }

    public void onLivenessCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2, int i6) {
        if (this.mIsCompletion) {
            return;
        }
        onRefreshView(faceStatusNewEnum, str, i6);
        if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
            this.mIsCompletion = true;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        ILivenessStrategy iLivenessStrategy = this.mILivenessStrategy;
        if (iLivenessStrategy != null) {
            iLivenessStrategy.reset();
        }
        VolumeUtils.unRegisterVolumeReceiver(this, this.mVolumeReceiver);
        this.mVolumeReceiver = null;
        this.mFaceDetectRoundView.setProcessCount(0, this.mFaceConfig.getLivenessTypeList().size());
        super.onPause();
        stopPreview();
        this.mIsCompletion = false;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.mIsCompletion) {
            return;
        }
        if (this.mILivenessStrategy == null) {
            ILivenessStrategy livenessStrategyModule = FaceSDKManager.getInstance().getLivenessStrategyModule(this);
            this.mILivenessStrategy = livenessStrategyModule;
            livenessStrategyModule.setPreviewDegree(this.mPreviewDegree);
            this.mILivenessStrategy.setLivenessStrategySoundEnable(this.mIsEnableSound);
            this.mILivenessStrategy.setLivenessStrategyConfig(this.mFaceConfig.getLivenessTypeList(), this.mPreviewRect, FaceDetectRoundView.getPreviewDetectRect(this.mDisplayWidth, this.mPreviewHight, this.mPreviewWidth), this);
        }
        this.mILivenessStrategy.livenessStrategy(bArr);
    }

    @Override // com.baidu.idl.face.platform.ILivenessViewCallback
    public void setCurrentLiveType(LivenessTypeEnum livenessTypeEnum) {
        this.mLivenessType = livenessTypeEnum;
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
        Point bestPreview = CameraPreviewUtils.getBestPreview(this.mCameraParam, new Point(640, 480));
        this.mPreviewWidth = bestPreview.x;
        this.mPreviewHight = bestPreview.y;
        ILivenessStrategy iLivenessStrategy = this.mILivenessStrategy;
        if (iLivenessStrategy != null) {
            iLivenessStrategy.setPreviewDegree(displayOrientation);
        }
        this.mPreviewRect.set(0, 0, this.mPreviewHight, this.mPreviewWidth);
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
            if (this.mILivenessStrategy != null) {
                this.mILivenessStrategy = null;
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

    @Override // com.baidu.idl.face.platform.ILivenessViewCallback
    public void viewReset() {
        this.mFaceDetectRoundView.setProcessCount(0, 1);
    }

    @Override // com.baidu.idl.face.platform.ui.utils.VolumeUtils.VolumeCallback
    public void volumeChanged() {
        try {
            AudioManager audioManager = (AudioManager) getSystemService("audio");
            if (audioManager != null) {
                this.mIsEnableSound = audioManager.getStreamVolume(3) > 0;
                this.mSoundView.setImageResource(this.mIsEnableSound ? R.mipmap.icon_titlebar_voice2 : R.mipmap.icon_titlebar_voice1);
                ILivenessStrategy iLivenessStrategy = this.mILivenessStrategy;
                if (iLivenessStrategy != null) {
                    iLivenessStrategy.setLivenessStrategySoundEnable(this.mIsEnableSound);
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

    @Override // com.baidu.idl.face.platform.ILivenessViewCallback
    public void animStop() {
        stopAnim();
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
        setContentView(R.layout.activity_face_liveness_v3100);
        this.mContext = this;
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
        View findViewById = findViewById(R.id.liveness_root_layout);
        this.mRootView = findViewById;
        this.mFrameLayout = (FrameLayout) findViewById.findViewById(R.id.liveness_surface_layout);
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
        int i7 = R.id.liveness_close;
        view.findViewById(i7).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.idl.face.platform.ui.FaceLivenessActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FaceLivenessActivity.this.z2();
            }
        });
        FaceDetectRoundView faceDetectRoundView = (FaceDetectRoundView) this.mRootView.findViewById(R.id.liveness_face_round);
        this.mFaceDetectRoundView = faceDetectRoundView;
        faceDetectRoundView.setIsActiveLive(true);
        this.mCloseView = (ImageView) this.mRootView.findViewById(i7);
        ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.liveness_sound);
        this.mSoundView = imageView;
        if (this.mIsEnableSound) {
            i6 = R.mipmap.icon_titlebar_voice2;
        } else {
            i6 = R.drawable.collect_image_voice_selector;
        }
        imageView.setImageResource(i6);
        this.mSoundView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.idl.face.platform.ui.FaceLivenessActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FaceLivenessActivity.this.mIsEnableSound = !r2.mIsEnableSound;
                FaceLivenessActivity faceLivenessActivity = FaceLivenessActivity.this;
                faceLivenessActivity.mSoundView.setImageResource(faceLivenessActivity.mIsEnableSound ? R.mipmap.icon_titlebar_voice2 : R.drawable.collect_image_voice_selector);
                FaceLivenessActivity faceLivenessActivity2 = FaceLivenessActivity.this;
                ILivenessStrategy iLivenessStrategy = faceLivenessActivity2.mILivenessStrategy;
                if (iLivenessStrategy != null) {
                    iLivenessStrategy.setLivenessStrategySoundEnable(faceLivenessActivity2.mIsEnableSound);
                }
            }
        });
        this.mTipsTopView = (TextView) this.mRootView.findViewById(R.id.liveness_top_tips);
        this.mSuccessView = (ImageView) this.mRootView.findViewById(R.id.liveness_success_image);
        this.mImageLayout = (LinearLayout) this.mRootView.findViewById(R.id.liveness_result_image_layout);
        this.mImageLayout2 = (LinearLayout) this.mRootView.findViewById(R.id.liveness_result_image_layout2);
        this.mRelativeAddImageView = (RelativeLayout) this.mRootView.findViewById(R.id.relative_add_image_view);
        addImageView();
        this.mViewBg = findViewById(R.id.view_live_bg);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
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

    @Override // com.baidu.idl.face.platform.ILivenessViewCallback
    public void setFaceInfo(FaceExtInfo faceExtInfo) {
    }

    @Override // android.hardware.Camera.ErrorCallback
    public void onError(int i6, Camera camera) {
    }
}
