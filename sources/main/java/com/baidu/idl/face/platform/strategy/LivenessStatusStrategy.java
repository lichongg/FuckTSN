package com.baidu.idl.face.platform.strategy;

import android.graphics.Rect;
import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.face.platform.LivenessTypeEnum;
import com.baidu.idl.face.platform.model.FaceExtInfo;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class LivenessStatusStrategy {
    private static final String TAG = "LivenessStatusStrategy";
    private volatile int mLivenessIndex;
    private List<LivenessTypeEnum> mLivenessList;
    private boolean mLivenessTimeoutFlag = false;
    private volatile LivenessTypeEnum mCurrentLivenessTypeEnum = null;
    private long mFaceID = -1;
    private HashMap<LivenessTypeEnum, Boolean> mLivenessStatusMap = new HashMap<>();
    private long mQualityDuration = 0;
    private long mLivenessTimeDuration = 0;
    private long mLivenessDuration = 0;

    public void reset() {
        this.mLivenessIndex = 0;
        clearLivenessStatus();
        if (this.mLivenessList != null && this.mLivenessIndex < this.mLivenessList.size()) {
            this.mCurrentLivenessTypeEnum = this.mLivenessList.get(this.mLivenessIndex);
        }
        this.mLivenessDuration = 0L;
        this.mLivenessTimeoutFlag = false;
        this.mLivenessTimeDuration = 0L;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.baidu.idl.face.platform.strategy.LivenessStatusStrategy$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum;

        static {
            int[] iArr = new int[LivenessTypeEnum.values().length];
            $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum = iArr;
            try {
                iArr[LivenessTypeEnum.Eye.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum[LivenessTypeEnum.Mouth.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum[LivenessTypeEnum.HeadUp.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum[LivenessTypeEnum.HeadDown.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum[LivenessTypeEnum.HeadLeft.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum[LivenessTypeEnum.HeadRight.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private void clearLivenessStatus() {
        this.mLivenessStatusMap.clear();
        for (int i6 = 0; i6 < this.mLivenessList.size(); i6++) {
            this.mLivenessStatusMap.put(this.mLivenessList.get(i6), Boolean.FALSE);
        }
    }

    protected int getCurrentLivenessCount() {
        return this.mLivenessIndex + 1;
    }

    public FaceStatusNewEnum getCurrentLivenessNewStatus() {
        if (this.mCurrentLivenessTypeEnum == null) {
            return null;
        }
        switch (AnonymousClass1.$SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum[this.mCurrentLivenessTypeEnum.ordinal()]) {
            case 1:
                return FaceStatusNewEnum.FaceLivenessActionTypeLiveEye;
            case 2:
                return FaceStatusNewEnum.FaceLivenessActionTypeLiveMouth;
            case 3:
                return FaceStatusNewEnum.FaceLivenessActionTypeLivePitchUp;
            case 4:
                return FaceStatusNewEnum.FaceLivenessActionTypeLivePitchDown;
            case 5:
                return FaceStatusNewEnum.FaceLivenessActionTypeLiveYawLeft;
            case 6:
                return FaceStatusNewEnum.FaceLivenessActionTypeLiveYawRight;
            default:
                return null;
        }
    }

    public LivenessTypeEnum getCurrentLivenessType() {
        return this.mCurrentLivenessTypeEnum;
    }

    public boolean isCourseTimeout(FaceConfig faceConfig) {
        if (this.mLivenessDuration == 0) {
            this.mLivenessDuration = System.currentTimeMillis();
        }
        return System.currentTimeMillis() - this.mLivenessDuration > faceConfig.getTimeLivenessCourse();
    }

    public boolean isCurrentLivenessSuccess() {
        boolean booleanValue = this.mLivenessStatusMap.containsKey(this.mCurrentLivenessTypeEnum) ? this.mLivenessStatusMap.get(this.mCurrentLivenessTypeEnum).booleanValue() : false;
        if (booleanValue) {
            this.mLivenessTimeDuration = 0L;
        }
        return booleanValue;
    }

    protected boolean isExistNextLiveness() {
        return this.mLivenessIndex + 1 < this.mLivenessList.size();
    }

    public boolean isLivenessSuccess() {
        boolean z5;
        Iterator<Map.Entry<LivenessTypeEnum, Boolean>> it = this.mLivenessStatusMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                z5 = true;
                break;
            }
            Map.Entry<LivenessTypeEnum, Boolean> next = it.next();
            if (!next.getValue().booleanValue()) {
                next.getKey().name();
                z5 = false;
                break;
            }
        }
        if (z5) {
            this.mLivenessTimeDuration = 0L;
        }
        return z5;
    }

    public boolean isTimeout() {
        return this.mLivenessTimeoutFlag;
    }

    public boolean nextLiveness() {
        if (this.mLivenessIndex + 1 >= this.mLivenessList.size()) {
            return false;
        }
        this.mLivenessIndex++;
        this.mCurrentLivenessTypeEnum = this.mLivenessList.get(this.mLivenessIndex);
        this.mLivenessDuration = 0L;
        this.mCurrentLivenessTypeEnum.name();
        return true;
    }

    public void processLiveness(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, Rect rect) {
        if (this.mLivenessTimeDuration == 0) {
            this.mLivenessTimeDuration = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() - this.mLivenessTimeDuration > FaceSDKManager.getInstance().getFaceConfig().getTimeDetectModule()) {
            this.mLivenessTimeoutFlag = true;
            return;
        }
        if (faceExtInfo != null) {
            if (faceExtInfo.getFaceId() != this.mFaceID) {
                this.mFaceID = faceExtInfo.getFaceId();
            }
            AtomicInteger atomicInteger = new AtomicInteger();
            switch (AnonymousClass1.$SwitchMap$com$baidu$idl$face$platform$LivenessTypeEnum[this.mCurrentLivenessTypeEnum.ordinal()]) {
                case 1:
                    FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFace_ACTION_LIVE_BLINK, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    atomicInteger.toString();
                    break;
                case 2:
                    FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_OPEN_MOUTH, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    atomicInteger.toString();
                    break;
                case 3:
                    FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_LOOK_UP, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    atomicInteger.toString();
                    break;
                case 4:
                    FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_NOD, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    atomicInteger.toString();
                    break;
                case 5:
                    FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_TURN_LEFT, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    atomicInteger.toString();
                    break;
                case 6:
                    FaceSDKManager.getInstance().processLiveness(BDFaceSDKCommon.BDFaceActionLiveType.BDFACE_ACTION_LIVE_TURN_RIGHT, bDFaceImageInstance, faceExtInfo, atomicInteger);
                    atomicInteger.toString();
                    break;
            }
            List<LivenessTypeEnum> list = this.mLivenessList;
            LivenessTypeEnum livenessTypeEnum = LivenessTypeEnum.Eye;
            if (list.contains(livenessTypeEnum) && !this.mLivenessStatusMap.containsKey(livenessTypeEnum)) {
                this.mLivenessStatusMap.put(livenessTypeEnum, Boolean.valueOf(atomicInteger.get() == 1));
            } else if (this.mCurrentLivenessTypeEnum == livenessTypeEnum && atomicInteger.get() == 1) {
                this.mLivenessStatusMap.put(livenessTypeEnum, Boolean.valueOf(atomicInteger.get() == 1));
            }
            List<LivenessTypeEnum> list2 = this.mLivenessList;
            LivenessTypeEnum livenessTypeEnum2 = LivenessTypeEnum.Mouth;
            if (list2.contains(livenessTypeEnum2) && !this.mLivenessStatusMap.containsKey(livenessTypeEnum2)) {
                this.mLivenessStatusMap.put(livenessTypeEnum2, Boolean.valueOf(atomicInteger.get() == 1));
            } else if (this.mCurrentLivenessTypeEnum == livenessTypeEnum2 && atomicInteger.get() == 1) {
                this.mLivenessStatusMap.put(livenessTypeEnum2, Boolean.valueOf(atomicInteger.get() == 1));
            }
            List<LivenessTypeEnum> list3 = this.mLivenessList;
            LivenessTypeEnum livenessTypeEnum3 = LivenessTypeEnum.HeadUp;
            if (list3.contains(livenessTypeEnum3) && !this.mLivenessStatusMap.containsKey(livenessTypeEnum3)) {
                this.mLivenessStatusMap.put(livenessTypeEnum3, Boolean.valueOf(atomicInteger.get() == 1));
            } else if (this.mCurrentLivenessTypeEnum == livenessTypeEnum3 && atomicInteger.get() == 1) {
                this.mLivenessStatusMap.put(livenessTypeEnum3, Boolean.valueOf(atomicInteger.get() == 1));
            }
            List<LivenessTypeEnum> list4 = this.mLivenessList;
            LivenessTypeEnum livenessTypeEnum4 = LivenessTypeEnum.HeadDown;
            if (list4.contains(livenessTypeEnum4) && !this.mLivenessStatusMap.containsKey(livenessTypeEnum4)) {
                this.mLivenessStatusMap.put(livenessTypeEnum4, Boolean.valueOf(atomicInteger.get() == 1));
            } else if (this.mCurrentLivenessTypeEnum == livenessTypeEnum4 && atomicInteger.get() == 1) {
                this.mLivenessStatusMap.put(livenessTypeEnum4, Boolean.valueOf(atomicInteger.get() == 1));
            }
            List<LivenessTypeEnum> list5 = this.mLivenessList;
            LivenessTypeEnum livenessTypeEnum5 = LivenessTypeEnum.HeadLeft;
            if (list5.contains(livenessTypeEnum5) && !this.mLivenessStatusMap.containsKey(livenessTypeEnum5)) {
                this.mLivenessStatusMap.put(livenessTypeEnum5, Boolean.valueOf(atomicInteger.get() == 1));
            } else if (this.mCurrentLivenessTypeEnum == livenessTypeEnum5 && atomicInteger.get() == 1) {
                this.mLivenessStatusMap.put(livenessTypeEnum5, Boolean.valueOf(atomicInteger.get() == 1));
            }
            List<LivenessTypeEnum> list6 = this.mLivenessList;
            LivenessTypeEnum livenessTypeEnum6 = LivenessTypeEnum.HeadRight;
            if (list6.contains(livenessTypeEnum6) && !this.mLivenessStatusMap.containsKey(livenessTypeEnum6)) {
                this.mLivenessStatusMap.put(livenessTypeEnum6, Boolean.valueOf(atomicInteger.get() == 1));
            } else if (this.mCurrentLivenessTypeEnum == livenessTypeEnum6 && atomicInteger.get() == 1) {
                this.mLivenessStatusMap.put(livenessTypeEnum6, Boolean.valueOf(atomicInteger.get() == 1));
            }
        }
    }

    public void resetState() {
        this.mLivenessDuration = 0L;
    }

    public void setLivenessList(List<LivenessTypeEnum> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mLivenessList = list;
        this.mCurrentLivenessTypeEnum = list.get(0);
        Objects.toString(this.mCurrentLivenessTypeEnum);
        clearLivenessStatus();
    }

    protected void startNextLiveness() {
        this.mLivenessIndex++;
        this.mCurrentLivenessTypeEnum = this.mLivenessList.get(this.mLivenessIndex);
        this.mLivenessDuration = 0L;
    }

    public LivenessStatusStrategy() {
        this.mLivenessIndex = 0;
        this.mLivenessIndex = 0;
    }

    public void resetQualityTime() {
        this.mQualityDuration = System.currentTimeMillis();
    }

    public boolean showQualityTips() {
        if (System.currentTimeMillis() - this.mQualityDuration > 0) {
            return true;
        }
        return false;
    }
}
