package com.baidu.idl.main.facesdk.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BDFaceSDKCommon {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum AlignType {
        BDFACE_ALIGN_TYPE_RGB_ACCURATE,
        BDFACE_ALIGN_TYPE_RGB_FAST,
        BDFACE_ALIGN_TYPE_NIR_ACCURATE
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum BDFaceActionLiveType {
        BDFace_ACTION_LIVE_BLINK,
        BDFACE_ACTION_LIVE_OPEN_MOUTH,
        BDFACE_ACTION_LIVE_NOD,
        BDFACE_ACTION_LIVE_SHAKE_HEAD,
        BDFACE_ACTION_LIVE_LOOK_UP,
        BDFACE_ACTION_LIVE_TURN_LEFT,
        BDFACE_ACTION_LIVE_TURN_RIGHT
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum BDFaceCoreRunMode {
        BDFACE_LITE_POWER_HIGH,
        BDFACE_LITE_POWER_LOW,
        BDFACE_LITE_POWER_FULL,
        BDFACE_LITE_POWER_NO_BIND,
        BDFACE_LITE_POWER_RAND_HIGH,
        BDFACE_LITE_POWER_RAND_LOW
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum BDFaceEmotion {
        BDFACE_EMOTION_FROWN,
        BDFACE_EMOTION_SMILE,
        BDFACE_EMOTION_CALM
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum BDFaceEmotionEnum {
        BDFACE_EMOTIONS_ANGRY,
        BDFACE_EMOTIONS_DISGUST,
        BDFACE_EMOTIONS_FEAR,
        BDFACE_EMOTIONS_HAPPY,
        BDFACE_EMOTIONS_SAD,
        BDFACE_EMOTIONS_SURPRISE,
        BDFACE_EMOTIONS_NEUTRAL
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum BDFaceGazeDirection {
        BDFACE_GACE_DIRECTION_UP,
        BDFACE_GACE_DIRECTION_DOWN,
        BDFACE_GACE_DIRECTION_RIGHT,
        BDFACE_GACE_DIRECTION_LEFT,
        BDFACE_GACE_DIRECTION_FRONT,
        BDFACE_GACE_DIRECTION_EYE_CLOSE
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum BDFaceGender {
        BDFACE_GENDER_FEMALE,
        BDFACE_GENDER_MALE
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum BDFaceGlasses {
        BDFACE_NO_GLASSES,
        BDFACE_GLASSES,
        BDFACE_SUN_GLASSES
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum BDFaceImageType {
        BDFACE_IMAGE_TYPE_RGB,
        BDFACE_IMAGE_TYPE_BGR,
        BDFACE_IMAGE_TYPE_RGBA,
        BDFACE_IMAGE_TYPE_BGRA,
        BDFACE_IMAGE_TYPE_GRAY,
        BDFACE_IMAGE_TYPE_DEPTH,
        BDFACE_IMAGE_TYPE_YUV_NV21,
        BDFACE_IMAGE_TYPE_YUV_NV12,
        BDFACE_IMAGE_TYPE_YUV_YV12
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum BDFaceLogInfo {
        BDFACE_LOG_ERROR_MESSAGE,
        BDFACE_LOG_VALUE_MESSAGE,
        BDFACE_LOG_TYPE_PERF,
        BDFACE_LOG_TYPE_ALL,
        BDFACE_LOG_TYPE_DEBUG
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum BDFaceRace {
        BDFACE_RACE_YELLOW,
        BDFACE_RACE_WHITE,
        BDFACE_RACE_BLACK,
        BDFACE_RACE_INDIAN
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum DetectType {
        DETECT_VIS,
        DETECT_NIR
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum FaceQualityType {
        BLUR,
        OCCLUSION,
        ILLUMINATION
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum FeatureType {
        BDFACE_FEATURE_TYPE_LIVE_PHOTO,
        BDFACE_FEATURE_TYPE_ID_PHOTO,
        BDFACE_FEATURE_TYPE_NIR,
        BDFACE_FEATURE_TYPE_RGBD
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum LiveType {
        BDFACE_SILENT_LIVE_TYPE_RGB,
        BDFACE_SILENT_LIVE_TYPE_NIR,
        BDFACE_SILENT_LIVE_TYPE_DEPTH
    }
}
