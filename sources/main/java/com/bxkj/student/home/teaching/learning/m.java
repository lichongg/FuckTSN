package com.bxkj.student.home.teaching.learning;

import java.util.List;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.c0;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface m {
    @FormUrlEncoded
    @POST("app/appLearnQuestion/saveRadioLearnQuestion")
    rx.e<c0<ResponseBody>> a(@Field("learnQuestionId") String learnQuestionId, @Field("answer") String answer);

    @POST("app/appLearnQuestion/saveRadioLearnQuestion")
    @Multipart
    rx.e<c0<ResponseBody>> b(@Part List<MultipartBody.Part> parts);

    @FormUrlEncoded
    @POST("app/appLearnQuestion/getLearnQuestiondetail")
    rx.e<c0<ResponseBody>> c(@Field("questionId") String questionId, @Field("isQualified") int isQualified);

    @FormUrlEncoded
    @POST("app/appLearnResource/myLearnResourceDetail")
    rx.e<c0<ResponseBody>> d(@Field("userId") String userId, @Field("resultType") String resultType, @Field("pageSize") Integer pageSize, @Field("pageIndex") Integer pageIndex);

    @FormUrlEncoded
    @POST("app/appLearnResource/nextRresourceTypes")
    rx.e<c0<ResponseBody>> e(@Field("pId") String pid);

    @POST("app/appLearnResource/startLearnData")
    rx.e<c0<ResponseBody>> f();

    @FormUrlEncoded
    @POST("app/appLearnQuestion/deleteLearnWork")
    rx.e<c0<ResponseBody>> g(@Field("questionId") String questionId);

    @FormUrlEncoded
    @POST("app/appLearnResource/myLearnUserRecord")
    rx.e<c0<ResponseBody>> h(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appLearnResource/learnResourceList")
    rx.e<c0<ResponseBody>> i(@Field("userId") String userId, @Field("oneTypeId") String oneTypeId, @Field("twoTypeId") String twoTypeId, @Field("pageSize") Integer pageSize, @Field("pageIndex") Integer pageIndex);

    @FormUrlEncoded
    @POST("app/appLearnQuestion/getStuUnqualifiedLearnQuestionList")
    rx.e<c0<ResponseBody>> j(@Field("pageSize") Integer pageSize, @Field("pageIndex") Integer pageIndex);

    @FormUrlEncoded
    @POST("app/appLearnResource/getTheLearnResource")
    rx.e<c0<ResponseBody>> k(@Field("userId") String userId, @Field("id") String id);

    @FormUrlEncoded
    @POST("app/appLearnQuestion/loadLearnQuestionList")
    rx.e<c0<ResponseBody>> l(@Field("type") int type, @Field("resourceId") String resourceId);

    @FormUrlEncoded
    @POST("app/appLearnResource/childTypesAndRresources")
    rx.e<c0<ResponseBody>> m(@Field("pId") String pId);

    @POST("app/appLearnResource/firstRresourceTypes")
    rx.e<c0<ResponseBody>> n();

    @FormUrlEncoded
    @POST("app/appLearnResource/saveLearnQuestionPaper")
    rx.e<c0<ResponseBody>> o(@Field("userId") String userId, @Field("radio") String radio, @Field("check") String check);

    @POST("app/appLearnResource/listResourceType")
    rx.e<c0<ResponseBody>> p();

    @POST("app/appLearnResource/showResourceTypePage")
    rx.e<c0<ResponseBody>> q();

    @FormUrlEncoded
    @POST("app/appLearnResource/isCompetedLearnByTypeId")
    rx.e<c0<ResponseBody>> r(@Field("typeId") String typeId);

    @POST("app/appLearnInstructions/loadLearnInstructions")
    rx.e<c0<ResponseBody>> s();

    @POST("app/appLearnResource/getReviewNotOkCount")
    rx.e<c0<ResponseBody>> t();

    @FormUrlEncoded
    @POST("app/appLearnResource/selectdTypeRresoure")
    rx.e<c0<ResponseBody>> u(@Field("typeId") String typeId);

    @FormUrlEncoded
    @POST("app/appLearnResource/learnResourceDetailOperation")
    rx.e<c0<ResponseBody>> v(@Field("detailId") String detailId, @Field("operateType") String operateType, @Field("status") int status);

    @FormUrlEncoded
    @POST("app/appLearnResource/clickAnswerButton")
    rx.e<c0<ResponseBody>> w(@Field("userId") String userId, @Field("detailId") String detailId);

    @FormUrlEncoded
    @POST("app/appLearnResource/loadLearnQuestionPaper")
    rx.e<c0<ResponseBody>> x(@Field("userId") String userId, @Field("learnResourceId") String learnResourceId);
}
