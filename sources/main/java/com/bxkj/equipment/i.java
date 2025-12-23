package com.bxkj.equipment;

import okhttp3.ResponseBody;
import retrofit2.c0;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface i {
    @FormUrlEncoded
    @POST("app/appEquipment/teaEquDistributeRecords")
    rx.e<c0<ResponseBody>> a(@Field("teacherCurriculumId") String teacherCurriculumId, @Field("teacherCurriculumWeek") int teacherCurriculumWeek, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @POST("app/syscampus/getCampusList")
    rx.e<c0<ResponseBody>> b();

    @FormUrlEncoded
    @POST("app/appEquipment/myEquDistributeRecords")
    rx.e<c0<ResponseBody>> c(@Field("userId") String userId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appEquipment/updateEdrRoomPerson")
    rx.e<c0<ResponseBody>> d(@Field("userId") String userId, @Field("campusId") String campusId, @Field("eDetailId") String eDetailId, @Field("applyReason") String applyReason, @Field("amount") Integer amount, @Field("forReceiveTime") String forReceiveTime, @Field("forBackTime") String forBackTime, @Field("status") String status, @Field("recordId") String recordId);

    @FormUrlEncoded
    @POST("app/appEquipment/getEquipmentList")
    rx.e<c0<ResponseBody>> e(@Field("campusId") String campusId);

    @FormUrlEncoded
    @POST("app/appEquipment/addTeacherEquRoomDealRecord")
    rx.e<c0<ResponseBody>> f(@Field("teacherCurriculumId") String teacherCurriculumId, @Field("week") int week, @Field("eDetailId") String eDetailId, @Field("applyReason") String applyReason, @Field("amount") Integer amount, @Field("forReceiveTime") String forReceiveTime, @Field("forBackTime") String forBackTime, @Field("status") String status, @Field("recordId") String recordId);
}
