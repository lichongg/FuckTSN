package com.baidu.idl.face.platform;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FaceConfig implements Serializable {
    private static final String TAG = "FaceConfig";
    private int minFaceSize = 200;
    private float notFaceValue = 0.6f;
    private float brightnessValue = 82.0f;
    private float brightnessMaxValue = 200.0f;
    private float blurnessValue = 0.7f;
    private float occlusionValue = 0.5f;
    private float occlusionLeftEyeValue = 0.5f;
    private float occlusionRightEyeValue = 0.5f;
    private float occlusionNoseValue = 0.5f;
    private float occlusionMouthValue = 0.5f;
    private float occlusionLeftContourValue = 0.5f;
    private float occlusionRightContourValue = 0.5f;
    private float occlusionChinValue = 0.5f;
    private int headPitchValue = 8;
    private int headYawValue = 8;
    private int headRollValue = 8;
    private float eyeClosedValue = 0.7f;
    private boolean isSound = true;
    private boolean isLivenessRandom = false;
    private int cacheImageNum = 3;
    private int livenessRandomCount = 3;
    private List<LivenessTypeEnum> livenessTypeList = FaceEnvironment.livenessTypeDefaultList;
    private boolean isOpenOnline = true;
    private int cropHeight = 640;
    private int cropWidth = 480;
    private float enlargeRatio = 1.5f;
    private float scale = 1.0f;
    private int secType = 0;
    private float maskValue = 0.7f;
    private boolean isOpenMask = true;
    private long timeDetectModule = 15000;
    private long timeLivenessCourse = 5000;
    private int qualityLevel = 0;
    private float faceFarRatio = 0.4f;
    private float faceClosedRatio = 1.0f;

    public float getBlurnessValue() {
        return this.blurnessValue;
    }

    public float getBrightnessMaxValue() {
        return this.brightnessMaxValue;
    }

    public float getBrightnessValue() {
        return this.brightnessValue;
    }

    public int getCacheImageNum() {
        return this.cacheImageNum;
    }

    public int getCropHeight() {
        return this.cropHeight;
    }

    public int getCropWidth() {
        return this.cropWidth;
    }

    public float getEnlargeRatio() {
        return this.enlargeRatio;
    }

    public float getEyeClosedValue() {
        return this.eyeClosedValue;
    }

    public float getFaceClosedRatio() {
        return this.faceClosedRatio;
    }

    public float getFaceFarRatio() {
        return this.faceFarRatio;
    }

    public int getHeadPitchValue() {
        return this.headPitchValue;
    }

    public int getHeadRollValue() {
        return this.headRollValue;
    }

    public int getHeadYawValue() {
        return this.headYawValue;
    }

    public int getLivenessRandomCount() {
        return this.livenessRandomCount;
    }

    public List<LivenessTypeEnum> getLivenessTypeList() {
        List<LivenessTypeEnum> list = this.livenessTypeList;
        if (list == null || list.size() == 0) {
            ArrayList arrayList = new ArrayList();
            this.livenessTypeList = arrayList;
            arrayList.addAll(FaceEnvironment.livenessTypeDefaultList);
            Collections.shuffle(this.livenessTypeList);
            this.livenessTypeList = this.livenessTypeList.subList(0, getLivenessRandomCount());
        } else if (this.isLivenessRandom) {
            List<LivenessTypeEnum> list2 = this.livenessTypeList;
            return getRandomList(list2, list2.size());
        }
        return this.livenessTypeList;
    }

    public float getMaskValue() {
        return this.maskValue;
    }

    public int getMinFaceSize() {
        return this.minFaceSize;
    }

    public float getNotFaceValue() {
        return this.notFaceValue;
    }

    public float getOcclusionChinValue() {
        return this.occlusionChinValue;
    }

    public float getOcclusionLeftContourValue() {
        return this.occlusionLeftContourValue;
    }

    public float getOcclusionLeftEyeValue() {
        return this.occlusionLeftEyeValue;
    }

    public float getOcclusionMouthValue() {
        return this.occlusionMouthValue;
    }

    public float getOcclusionNoseValue() {
        return this.occlusionNoseValue;
    }

    public float getOcclusionRightContourValue() {
        return this.occlusionRightContourValue;
    }

    public float getOcclusionRightEyeValue() {
        return this.occlusionRightEyeValue;
    }

    public float getOcclusionValue() {
        return this.occlusionValue;
    }

    public int getQualityLevel() {
        return this.qualityLevel;
    }

    public float getScale() {
        return this.scale;
    }

    public int getSecType() {
        return this.secType;
    }

    public long getTimeDetectModule() {
        return this.timeDetectModule;
    }

    public long getTimeLivenessCourse() {
        return this.timeLivenessCourse;
    }

    public boolean isLivenessRandom() {
        return this.isLivenessRandom;
    }

    public boolean isOpenMask() {
        return this.isOpenMask;
    }

    public boolean isOpenOnline() {
        return this.isOpenOnline;
    }

    public boolean isSound() {
        return this.isSound;
    }

    public void setBlurnessValue(float f6) {
        this.blurnessValue = f6;
    }

    public void setBrightnessMaxValue(float f6) {
        this.brightnessMaxValue = f6;
    }

    public void setBrightnessValue(float f6) {
        this.brightnessValue = f6;
    }

    public void setCacheImageNum(int i6) {
        this.cacheImageNum = i6;
    }

    public void setCropHeight(int i6) {
        this.cropHeight = i6;
    }

    public void setCropWidth(int i6) {
        this.cropWidth = i6;
    }

    public void setEnlargeRatio(float f6) {
        this.enlargeRatio = f6;
    }

    public void setEyeClosedValue(float f6) {
        this.eyeClosedValue = f6;
    }

    public void setFaceClosedRatio(float f6) {
        this.faceClosedRatio = f6;
    }

    public void setFaceFarRatio(float f6) {
        this.faceFarRatio = f6;
    }

    public void setHeadPitchValue(int i6) {
        this.headPitchValue = i6;
    }

    public void setHeadRollValue(int i6) {
        this.headRollValue = i6;
    }

    public void setHeadYawValue(int i6) {
        this.headYawValue = i6;
    }

    public void setLivenessRandom(boolean z5) {
        this.isLivenessRandom = z5;
    }

    public void setLivenessRandomCount(int i6) {
        int size = FaceEnvironment.livenessTypeDefaultList.size();
        if (i6 > size) {
            i6 = size;
        }
        this.livenessRandomCount = i6;
    }

    public void setLivenessTypeList(List<LivenessTypeEnum> list) {
        this.livenessTypeList = list;
    }

    public void setMaskValue(float f6) {
        this.maskValue = f6;
    }

    public void setMinFaceSize(int i6) {
        this.minFaceSize = i6;
    }

    public void setNotFaceValue(float f6) {
        this.notFaceValue = f6;
    }

    public void setOcclusionChinValue(float f6) {
        this.occlusionChinValue = f6;
    }

    public void setOcclusionLeftContourValue(float f6) {
        this.occlusionLeftContourValue = f6;
    }

    public void setOcclusionLeftEyeValue(float f6) {
        this.occlusionLeftEyeValue = f6;
    }

    public void setOcclusionMouthValue(float f6) {
        this.occlusionMouthValue = f6;
    }

    public void setOcclusionNoseValue(float f6) {
        this.occlusionNoseValue = f6;
    }

    public void setOcclusionRightContourValue(float f6) {
        this.occlusionRightContourValue = f6;
    }

    public void setOcclusionRightEyeValue(float f6) {
        this.occlusionRightEyeValue = f6;
    }

    public void setOcclusionValue(float f6) {
        this.occlusionValue = f6;
    }

    public void setOpenMask(boolean z5) {
        this.isOpenMask = z5;
    }

    public void setOpenOnline(boolean z5) {
        this.isOpenOnline = z5;
    }

    public void setQualityLevel(int i6) {
        this.qualityLevel = i6;
    }

    public void setScale(float f6) {
        this.scale = f6;
    }

    public void setSecType(int i6) {
        this.secType = i6;
    }

    public void setSound(boolean z5) {
        this.isSound = z5;
    }

    public void setTimeDetectModule(long j6) {
        this.timeDetectModule = j6;
    }

    public void setTimeLivenessCourse(long j6) {
        this.timeLivenessCourse = j6;
    }

    public static List<LivenessTypeEnum> getRandomList(List<LivenessTypeEnum> list, int i6) {
        if (list.size() < i6) {
            return list;
        }
        Random random = new Random();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i7 = 0;
        while (i7 < i6) {
            int nextInt = random.nextInt(list.size());
            if (!arrayList.contains(Integer.valueOf(nextInt))) {
                arrayList.add(Integer.valueOf(nextInt));
                arrayList2.add(list.get(nextInt));
            } else {
                i7--;
            }
            i7++;
        }
        return arrayList2;
    }
}
