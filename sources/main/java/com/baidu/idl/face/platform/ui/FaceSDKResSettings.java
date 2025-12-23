package com.baidu.idl.face.platform.ui;

import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.idl.face.platform.FaceStatusNewEnum;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FaceSDKResSettings {
    public static void initializeResId() {
        FaceStatusNewEnum faceStatusNewEnum = FaceStatusNewEnum.DetectRemindCodeNoFaceDetected;
        int i6 = R.raw.detect_face_in;
        FaceEnvironment.setSoundId(faceStatusNewEnum, i6);
        FaceStatusNewEnum faceStatusNewEnum2 = FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame;
        FaceEnvironment.setSoundId(faceStatusNewEnum2, i6);
        FaceEnvironment.setSoundId(faceStatusNewEnum, i6);
        FaceStatusNewEnum faceStatusNewEnum3 = FaceStatusNewEnum.FaceLivenessActionTypeLiveEye;
        FaceEnvironment.setSoundId(faceStatusNewEnum3, R.raw.liveness_eye);
        FaceStatusNewEnum faceStatusNewEnum4 = FaceStatusNewEnum.FaceLivenessActionTypeLiveMouth;
        FaceEnvironment.setSoundId(faceStatusNewEnum4, R.raw.liveness_mouth);
        FaceStatusNewEnum faceStatusNewEnum5 = FaceStatusNewEnum.FaceLivenessActionTypeLivePitchUp;
        FaceEnvironment.setSoundId(faceStatusNewEnum5, R.raw.liveness_head_up);
        FaceStatusNewEnum faceStatusNewEnum6 = FaceStatusNewEnum.FaceLivenessActionTypeLivePitchDown;
        FaceEnvironment.setSoundId(faceStatusNewEnum6, R.raw.liveness_head_down);
        FaceStatusNewEnum faceStatusNewEnum7 = FaceStatusNewEnum.FaceLivenessActionTypeLiveYawLeft;
        FaceEnvironment.setSoundId(faceStatusNewEnum7, R.raw.liveness_head_left);
        FaceStatusNewEnum faceStatusNewEnum8 = FaceStatusNewEnum.FaceLivenessActionTypeLiveYawRight;
        FaceEnvironment.setSoundId(faceStatusNewEnum8, R.raw.liveness_head_right);
        FaceStatusNewEnum faceStatusNewEnum9 = FaceStatusNewEnum.FaceLivenessActionComplete;
        int i7 = R.raw.face_good;
        FaceEnvironment.setSoundId(faceStatusNewEnum9, i7);
        FaceStatusNewEnum faceStatusNewEnum10 = FaceStatusNewEnum.OK;
        FaceEnvironment.setSoundId(faceStatusNewEnum10, i7);
        int i8 = R.string.detect_face_in;
        FaceEnvironment.setTipsId(faceStatusNewEnum, i8);
        FaceEnvironment.setTipsId(faceStatusNewEnum2, i8);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodePoorIllumination, R.string.detect_low_light);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeImageBlured, R.string.detect_keep);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeOcclusionLeftEye, R.string.detect_occ_left_eye);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeOcclusionRightEye, R.string.detect_occ_right_eye);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeOcclusionNose, R.string.detect_occ_nose);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeOcclusionMouth, R.string.detect_occ_mouth);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeOcclusionLeftContour, R.string.detect_occ_left_check);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeOcclusionRightContour, R.string.detect_occ_right_check);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeOcclusionChinContour, R.string.detect_occ_chin);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodePitchOutofUpRange, R.string.detect_head_down);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodePitchOutofDownRange, R.string.detect_head_up);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeYawOutofLeftRange, R.string.detect_head_right);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeYawOutofRightRange, R.string.detect_head_left);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeTooFar, R.string.detect_zoom_in);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeTooClose, R.string.detect_zoom_out);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeLeftEyeClosed, R.string.detect_left_eye_close);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeRightEyeClosed, R.string.detect_right_eye_close);
        FaceEnvironment.setTipsId(faceStatusNewEnum3, R.string.liveness_eye);
        FaceEnvironment.setTipsId(faceStatusNewEnum4, R.string.liveness_mouth);
        FaceEnvironment.setTipsId(faceStatusNewEnum5, R.string.liveness_head_up);
        FaceEnvironment.setTipsId(faceStatusNewEnum6, R.string.liveness_head_down);
        FaceEnvironment.setTipsId(faceStatusNewEnum7, R.string.liveness_head_left);
        FaceEnvironment.setTipsId(faceStatusNewEnum8, R.string.liveness_head_right);
        int i9 = R.string.liveness_good;
        FaceEnvironment.setTipsId(faceStatusNewEnum9, i9);
        FaceEnvironment.setTipsId(faceStatusNewEnum10, i9);
        FaceEnvironment.setTipsId(FaceStatusNewEnum.DetectRemindCodeTimeout, R.string.detect_timeout);
    }
}
