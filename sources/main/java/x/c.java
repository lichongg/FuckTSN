package x;

import okhttp3.ResponseBody;
import retrofit2.c0;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f54742a = "https://h.boxkj.com/";

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appInformation/appInformationTitle")
    rx.e<c0<ResponseBody>> a(@Field("pageSize") Integer num, @Field("pageIndex") Integer num2, @Field("inforTypeId") String str);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appInformation/appInformationTitleDesc")
    rx.e<c0<ResponseBody>> b(@Field("pageSize") Integer num, @Field("pageIndex") Integer num2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appInformation/appInformationIndex")
    rx.e<c0<ResponseBody>> c(@Field("pageSize") Integer num, @Field("pageIndex") Integer num2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appInformation/appInformationindex")
    rx.e<c0<ResponseBody>> d(@Field("pageSize") Integer num, @Field("pageIndex") Integer num2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appInformation/appInformationPublish")
    rx.e<c0<ResponseBody>> e(@Field("inforId") String str);
}
