package com.bytedance.android.live.base.api.outer.data;

import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class RoomInfo {
    City city;
    String count;
    CouponInfo couponInfo;
    String cover;
    HashMap<Integer, String> extraCover;
    String openRoomId;
    long orientation;
    AnchorInfo owner;
    String requestId;
    long status;
    String title;
    String trackExtra;

    public RoomInfo() {
        this.couponInfo = null;
    }

    public RoomInfo(String str, String str2, String str3, String str4, long j6, City city, long j7, AnchorInfo anchorInfo, String str5, String str6, HashMap<Integer, String> hashMap, CouponInfo couponInfo) {
        this.openRoomId = str;
        this.title = str2;
        this.cover = str3;
        this.count = str4;
        this.orientation = j6;
        this.city = city;
        this.status = j7;
        this.owner = anchorInfo;
        this.requestId = str5;
        this.trackExtra = str6;
        this.extraCover = hashMap;
        this.couponInfo = couponInfo;
    }

    public City getCity() {
        return this.city;
    }

    public String getCount() {
        return this.count;
    }

    public CouponInfo getCouponInfo() {
        return this.couponInfo;
    }

    public String getCover() {
        return this.cover;
    }

    public HashMap<Integer, String> getExtraCover() {
        return this.extraCover;
    }

    public String getOpenRoomId() {
        return this.openRoomId;
    }

    public long getOrientation() {
        return this.orientation;
    }

    public AnchorInfo getOwner() {
        return this.owner;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public long getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTrackExtra() {
        return this.trackExtra;
    }

    public void setCount(String str) {
        this.count = str;
    }

    public void setCover(String str) {
        this.cover = str;
    }

    public void setOrientation(long j6) {
        this.orientation = j6;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
