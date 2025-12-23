package com.bxkj.student.run.app;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface a {
    @FormUrlEncoded
    @POST("app/sportRecordSetting/setting")
    rx.e<retrofit2.c0<ResponseBody>> a(@Field("uid") String userId);

    @FormUrlEncoded
    @POST("app/runingFeedback/add")
    rx.e<retrofit2.c0<ResponseBody>> b(@Field("sportRecordId") String sportRecordId, @Field("content") String content, @Field("base64Images") String base64Images);

    @FormUrlEncoded
    @POST("app/appRunningLeaderboard/findAppRunningLeaderboardByUserId")
    rx.e<retrofit2.c0<ResponseBody>> c(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/sportRecordSetting/checkTimeOut")
    rx.e<retrofit2.c0<ResponseBody>> d(@Field("identify") String identify);

    @FormUrlEncoded
    @POST("app/appSportRecord/getSportSpecification")
    rx.e<retrofit2.c0<ResponseBody>> e(@Field("runType") int runType);

    @FormUrlEncoded
    @POST("app/sportRecordSetting/getRunningStartTime")
    rx.e<retrofit2.c0<ResponseBody>> f(@Field("identify") String identify);

    @FormUrlEncoded
    @POST("app/appSportRecord/appSportRecordList")
    rx.e<retrofit2.c0<ResponseBody>> g(@Field("userId") String userId, @Field("sportType") int sportType, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @POST("app/runingFace/appRuningFace")
    @Multipart
    rx.e<retrofit2.c0<ResponseBody>> h(@Part MultipartBody.Part userId, @Part MultipartBody.Part identify, @Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST("app/appAvoidRunningUser/findAvoidRunningUserListByUserId")
    rx.e<retrofit2.c0<ResponseBody>> i(@Field("userId") String userId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appRuningStatistics/appPersonalStatistics")
    rx.e<retrofit2.c0<ResponseBody>> j(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/sportRecordSetting/getSetting")
    rx.e<retrofit2.c0<ResponseBody>> k(@Field("runType") int runType, @Field("uid") String uid);

    @FormUrlEncoded
    @POST("app/appSportRecord/appAddSportRecord")
    rx.e<retrofit2.c0<ResponseBody>> l(@Field("userId") String userId, @Field("runType") int runType, @Field("startTime") long startTime, @Field("endTime") long endTime, @Field("gitudeLatitude") String latLngList, @Field("identify") String identify, @Field("formatSportTime") String formatSportTime, @Field("formatSportRange") String formatSportRange, @Field("avgspeed") String avgSpeed, @Field("speed") String speed, @Field("okPointList") String okPointList, @Field("brand") String brand, @Field("model") String model, @Field("system") String system, @Field("version") String version, @Field("appVersion") String appVersion, @Field("stepNumbers") String stepNumbers, @Field("isFaceStatus") String isFaceStatus, @Field("points") String points, @Field("uploadType") Integer uploadType, @Field("keepId") String keepId);

    @FormUrlEncoded
    @POST("app/appSportRecord/getSportRecordId")
    rx.e<retrofit2.c0<ResponseBody>> m(@Field("sportRecordId") String sportRecordId);

    @FormUrlEncoded
    @POST("app/appAvoidRunningUser/applyAvoidRunningUserApply")
    rx.e<retrofit2.c0<ResponseBody>> n(@Field("userId") String userId, @Field("applyReason") String applyReason, @Field("fileNames") String fileNames, @Field("imgs") String imgs);

    @FormUrlEncoded
    @POST("app/appAvoidRunningUser/findAppAvoidRunningUserById")
    rx.e<retrofit2.c0<ResponseBody>> o(@Field("avoidRunningUserId") String avoidRunningUserId);

    @FormUrlEncoded
    @POST("app/appSportRecord/sumSportRecord")
    rx.e<retrofit2.c0<ResponseBody>> p(@Field("userId") String userId);

    @GET("https://keep.boxkj.com/keep/records")
    rx.e<retrofit2.c0<ResponseBody>> q(@Query("token") String token, @Query("date") String date);
}
