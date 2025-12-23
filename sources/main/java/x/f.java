package x;

import com.bxkj.base.v2.http.interceptor.Test;
import okhttp3.ResponseBody;
import retrofit2.c0;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface f {

    /* renamed from: a, reason: collision with root package name */
    public static final String f54745a = "https://m.boxkj.com/";

    /* renamed from: b, reason: collision with root package name */
    public static final String f54746b = "e8167ef026cbc5e456ab837d9d6d9254";

    /* renamed from: c, reason: collision with root package name */
    public static final String f54747c = "bxkj2018";

    @Test(demo = "7d7f2d3627c76f56f26fb6f1e1b8fed1")
    @FormUrlEncoded
    @POST("app/update")
    rx.e<c0<ResponseBody>> a(@Field("schoolId") String str, @Field("appSign") String str2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/api/permission/getPermission")
    rx.e<c0<ResponseBody>> b(@Field("schoolId") String str, @Field("userNum") String str2, @Field("pid") int i6);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/uploadVideo/loadUploadVideoDetail")
    rx.e<c0<ResponseBody>> c(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/uploadVideo/loadVideoType")
    rx.e<c0<ResponseBody>> d(@Field("schoolId") String str, @Field("userId") String str2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/sch/getSchoolById")
    rx.e<c0<ResponseBody>> e(@Field("schoolId") String str);

    @POST("https://m.boxkj.com/app/province/findAllProvince")
    rx.e<c0<ResponseBody>> f();

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/replyFeedBack/getReplyFeedBackBySuId")
    rx.e<c0<ResponseBody>> g(@Field("feedBackId") String str, @Field("pageIndex") int i6, @Field("pageSize") int i7);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/admin/analysis/addUploadRecord")
    rx.e<c0<ResponseBody>> h(@Field("schoolId") Integer num, @Field("platform") Integer num2, @Field("deviceId") String str, @Field("brandName") String str2, @Field("deviceNum") String str3, @Field("sysUserId") String str4, @Field("versionName") String str5);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/sys/addintegral")
    rx.e<c0<ResponseBody>> i(@Field("schoolId") String str, @Field("userNum") String str2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/replyFeedBack/addReplyFeedBack2")
    rx.e<c0<ResponseBody>> j(@Field("appVersion") String str, @Field("platform") String str2, @Field("schoolId") String str3, @Field("feedbackContent") String str4, @Field("userId") String str5, @Field("phone") String str6, @Field("fileName") String str7, @Field("images") String str8, @Field("type") String str9);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/sysFeedback/getFeedBackByUid")
    rx.e<c0<ResponseBody>> k(@Field("userId") String str, @Field("schoolId") String str2, @Field("pageIndex") int i6, @Field("pageSize") int i7);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/bindDevice/getBindDevicePagerData")
    rx.e<c0<ResponseBody>> l(@Field("schoolId") String str, @Field("keys") String str2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/sys/integralInfo")
    rx.e<c0<ResponseBody>> m(@Field("schoolId") String str, @Field("userNum") String str2, @Field("pageIndex") int i6, @Field("pageSize") int i7);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/sch/listSchoolByProvinceId")
    rx.e<c0<ResponseBody>> n(@Field("provinceId") String str);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/bindDevice/unBindDevice")
    rx.e<c0<ResponseBody>> o(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/replyFeedBack/getReplyFeedBackByUserId")
    rx.e<c0<ResponseBody>> p(@Field("schoolId") String str, @Field("userId") String str2, @Field("pageIndex") int i6, @Field("pageSize") int i7);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/uploadVideo/loadSchoolUploadVideo")
    rx.e<c0<ResponseBody>> q(@Field("schoolId") String str, @Field("keyword") String str2, @Field("typeId") String str3, @Field("pageIndex") int i6, @Field("pageSize") int i7);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/admin/appUpdate/teaAppVersion2")
    rx.e<c0<ResponseBody>> r(@Field("schoolId") String str, @Field("type") String str2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/replyFeedBack/getReplyFeedBackCountUser")
    rx.e<c0<ResponseBody>> s(@Field("schoolId") String str, @Field("userId") String str2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/replyFeedBack/addReplyFeedBack")
    rx.e<c0<ResponseBody>> t(@Field("feedBackId") String str, @Field("userId") String str2, @Field("replyContent") String str3);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/sys/sumIntegralAndIsSign")
    rx.e<c0<ResponseBody>> u(@Field("schoolId") String str, @Field("userNum") String str2, @Field("name") String str3);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/appadverties/addappadverties")
    rx.e<c0<ResponseBody>> v(@Field("advertiesId") String str, @Field("schoolId") String str2, @Field("userId") String str3);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/bindDevice/validateDeviceBind")
    rx.e<c0<ResponseBody>> w(@Field("schoolId") String str, @Field("userNum") String str2, @Field("code") String str3, @Field("manufacturer") String str4, @Field("model") String str5, @Field("platform") String str6);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/replyFeedBack/addReplyFeedBack2")
    rx.e<c0<ResponseBody>> x(@Field("schoolId") String str, @Field("userId") String str2, @Field("appVersion") String str3, @Field("platform") String str4, @Field("replyContent") String str5, @Field("fileName") String str6, @Field("userName") String str7, @Field("userNum") String str8, @Field("userPhone") String str9);
}
