package com.baidu.idl.main.facesdk.model;

import android.util.Base64;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Feature {
    private long ctime;
    private byte[] feature;
    private int id;
    private boolean isChecked;
    private float score;
    private long updateTime;
    private String faceToken = "";
    private String userId = "";
    private String groupId = "";
    private String imageName = "";
    private String userName = "";
    private String cropImageName = "";

    public Feature() {
    }

    public String getCropImageName() {
        return this.cropImageName;
    }

    public long getCtime() {
        return this.ctime;
    }

    public String getFaceToken() {
        byte[] bArr = this.feature;
        if (bArr != null) {
            this.faceToken = new String(Base64.encode(bArr, 2));
        }
        return this.faceToken;
    }

    public byte[] getFeature() {
        return this.feature;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public int getId() {
        return this.id;
    }

    public String getImageName() {
        return this.imageName;
    }

    public float getScore() {
        return this.score;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z5) {
        this.isChecked = z5;
    }

    public void setCropImageName(String str) {
        this.cropImageName = str;
    }

    public void setCtime(long j6) {
        this.ctime = j6;
    }

    public void setFaceToken(String str) {
        this.faceToken = str;
    }

    public void setFeature(byte[] bArr) {
        this.feature = bArr;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setId(int i6) {
        this.id = i6;
    }

    public void setImageName(String str) {
        this.imageName = str;
    }

    public void setScore(float f6) {
        this.score = f6;
    }

    public void setUpdateTime(long j6) {
        this.updateTime = j6;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public Feature(int i6, float f6) {
        this.id = i6;
        this.score = f6;
    }
}
