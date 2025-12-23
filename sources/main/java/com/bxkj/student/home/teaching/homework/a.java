package com.bxkj.student.home.teaching.homework;

import java.util.List;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.c0;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface a {
    @FormUrlEncoded
    @POST("app/homeAppLearnQuestion/saveRadioHomeWorkLearnQuestion")
    e<c0<ResponseBody>> a(@Field("learnQuestionId") String learnQuestionId, @Field("answer") String answer);

    @POST("app/homeAppLearnQuestion/saveRadioHomeWorkLearnQuestion")
    @Multipart
    e<c0<ResponseBody>> b(@Part List<MultipartBody.Part> parts);

    @FormUrlEncoded
    @POST("app/homeAppLearnQuestion/getHomeWorkLearnQuestiondetail")
    e<c0<ResponseBody>> c(@Field("questionId") String questionId, @Field("isQualified") int isQualified);

    @FormUrlEncoded
    @POST("app/homeAppLearnQuestion/deleteLearnHomeWork")
    e<c0<ResponseBody>> d(@Field("questionId") String questionId);

    @FormUrlEncoded
    @POST("app/homeAppLearnQuestion/loadHomeWorkLearnQuestionList")
    e<c0<ResponseBody>> e(@Field("teacherCurriculumId") String teacherCurriculumId, @Field("week") Integer week);
}
