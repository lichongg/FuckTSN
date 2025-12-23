package com.amap.api.maps.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AMapCameraInfo {
    private float aspectRatio;
    private float fov;
    private float positionX;
    private float positionY;
    private float positionZ;
    private float rotate;

    public float getAspectRatio() {
        return this.aspectRatio;
    }

    public float getFov() {
        return this.fov;
    }

    public float getRotate() {
        return this.rotate;
    }

    public float getX() {
        return this.positionX;
    }

    public float getY() {
        return this.positionY;
    }

    public float getZ() {
        return this.positionZ;
    }

    public String toString() {
        return "[fov:" + this.fov + " aspectRatio:" + this.aspectRatio + " rotate:" + this.rotate + " pos_x:" + this.positionX + " pos_y:" + this.positionY + " pos_z:" + this.positionZ + "]";
    }

    public AMapCameraInfo(float f6, float f7, float f8, float f9, float f10, float f11) {
        this.fov = f6;
        this.aspectRatio = f7;
        this.rotate = f8;
        this.positionX = f9;
        this.positionY = f10;
        this.positionZ = f11;
    }
}
