package com.bxkj.student.v2.retrofit;

import com.bxkj.base.v2.http.interceptor.Test;
import com.bxkj.base.v2.http.result.ApiResult;
import com.bxkj.base.v2.http.result.OldApiResult;
import com.bxkj.base.v2.http.result.PgyerApiResult;
import com.bxkj.student.App;
import com.bxkj.student.v2.common.data.CommitResult;
import java.util.List;
import java.util.Map;
import kotlin.n1;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.c0;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f21275a = a.f21276a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f21276a = new a();

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private static final String f21277b;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        private static final String f21278c;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        private static final String f21279d;

        static {
            c0.b bVar = c0.b.f1042a;
            App.a aVar = App.f17573d;
            f21277b = bVar.l(aVar.a(), "05dbfd8c595b3687f8351745f27c449b");
            f21278c = bVar.l(aVar.a(), "7ff944758843f909e729065961954713");
            f21279d = bVar.l(aVar.a(), "f16f7cfccc6d82a3a6ae248da4d16a1d");
        }

        @NotNull
        public final String a() {
            return f21277b;
        }

        @NotNull
        public final String b() {
            return f21279d;
        }

        @NotNull
        public final String c() {
            return f21278c;
        }

        private a() {
        }
    }

    @Test(demo = "7a4b002c14f6cf723035e7ebbb6d91ce")
    @GET("app/getDefaultPass")
    @Nullable
    Object A(@NotNull kotlin.coroutines.e<? super ApiResult<Map<String, Object>>> eVar);

    @Test(demo = "e8ed1c044ac961926d8f79bd70dee316")
    @GET("app/getTopAd")
    @Nullable
    Object B(@Nullable @Query("type") String str, @Nullable @Query("mark") String str2, @Nullable @Query("size") String str3, @Nullable @Query("current") String str4, @NotNull kotlin.coroutines.e<? super ApiResult<List<Map<String, Object>>>> eVar);

    @Test(demo = "f4f56111c5a9899b708925cd66f39d4e")
    @GET("app/timeOutCheck")
    @Nullable
    Object C(@NotNull @Query("identify") String str, @NotNull kotlin.coroutines.e<? super ApiResult<String>> eVar);

    @Test(demo = "785796286eb58ca15168713af4fce70c")
    @POST("app/login")
    @Nullable
    Object D(@Nullable @Query("username") String str, @Nullable @Query("password") String str2, @Nullable @Query("grant_type") String str3, @Nullable @Query("type") String str4, @Nullable @Query("appType") String str5, @Header("model") @Nullable String str6, @NotNull kotlin.coroutines.e<? super Map<String, ? extends Object>> eVar);

    @Nullable
    @Test(demo = "42b54ea6aaaf0689c4a35414077d92bc")
    @POST("app/faceCheck")
    @Multipart
    Object E(@Nullable @Part MultipartBody.Part part, @NotNull kotlin.coroutines.e<? super ApiResult<Boolean>> eVar);

    @Test(demo = "c9aab1c07f7f73d7598e9ac13361c663")
    @GET("app/getNotice")
    @Nullable
    Object F(@Nullable @Query("noticeWindowsPos") String str, @NotNull kotlin.coroutines.e<? super ApiResult<Map<String, Object>>> eVar);

    @Test(demo = "70ba21ded261ce2933e968e14b32ef34")
    @GET("app/getExerciseStatistics")
    @Nullable
    Object G(@NotNull kotlin.coroutines.e<? super ApiResult<Map<String, Object>>> eVar);

    @Test(demo = "fa7e67fe9e95d3f60e6195b7e28dd8fd")
    @GET("app/getQuestion")
    @Nullable
    Object H(@NotNull kotlin.coroutines.e<? super ApiResult<Map<String, Object>>> eVar);

    @Test(demo = "d44b2b293b348070162b31ea5d139130")
    @GET("app/getNotice")
    @Nullable
    Object I(@NotNull @Query("id") String str, @NotNull kotlin.coroutines.e<? super ApiResult<Object>> eVar);

    @Test(demo = "8d4bbeb78ddde6cd39874081d49f1989")
    @GET("app/thirdCheck")
    @Nullable
    Object J(@NotNull @Query("openid") String str, @NotNull @Query("type") String str2, @NotNull kotlin.coroutines.e<? super ApiResult<Map<String, Object>>> eVar);

    @Nullable
    @Test(demo = "ad93462ddf9ffa8365e94742e8c6f09e")
    @FormUrlEncoded
    @POST("app/addExerciseRecord")
    Object K(@Header("timestamp") @NotNull String str, @Field("key") @NotNull String str2, @Field("param") @NotNull String str3, @NotNull kotlin.coroutines.e<? super CommitResult<Object>> eVar);

    @Test(demo = "ea78c742acd5a3b5d88cea8b018ee05e")
    @GET("app/exerciseSettingV2")
    @Nullable
    Object L(@Header("timestamp") @NotNull String str, @NotNull @Query("key") String str2, @NotNull @Query("param") String str3, @NotNull kotlin.coroutines.e<? super ApiResult<String>> eVar);

    @Test(demo = "21eac57f6453f133c23636f1001cfec5")
    @GET("app/getAppealCount")
    @Nullable
    Object M(@NotNull kotlin.coroutines.e<? super ApiResult<Map<String, Object>>> eVar);

    @Test(demo = "e5c6b9630a11efdfa31a4cfa4b227688")
    @GET("app/getHomeMenu")
    @Nullable
    Object N(@Nullable @Query("location") String str, @NotNull kotlin.coroutines.e<? super ApiResult<Map<String, Object>>> eVar);

    @Test(demo = "f924a2407811f3ba790d8816a27fa03d")
    @GET("app/checkFaceResult")
    @Nullable
    Object O(@NotNull kotlin.coroutines.e<? super ApiResult<Object>> eVar);

    @Nullable
    @Test(demo = "e99908106a680b07ef8beee488dcf6cb")
    @POST("app/faceCollect")
    @Multipart
    Object P(@Nullable @Part MultipartBody.Part part, @NotNull kotlin.coroutines.e<? super ApiResult<Boolean>> eVar);

    @Test(demo = "d60d116f2cd0fa1ff936d515b8a55f83")
    @POST("app/logout")
    @Nullable
    Object Q(@NotNull kotlin.coroutines.e<? super n1> eVar);

    @Test(demo = "75023684c498bc2726f8e691060ffecb")
    @GET("app/getUrl")
    @Nullable
    Object R(@NotNull @Query("key") String str, @NotNull kotlin.coroutines.e<? super ApiResult<Map<String, Object>>> eVar);

    @Nullable
    @Test(demo = "746bb441d7c9966c2f2c05284bb4e277")
    @FormUrlEncoded
    @POST("app/checkCount")
    Object S(@Field("identifys") @Nullable String str, @NotNull kotlin.coroutines.e<? super ApiResult<Map<String, Object>>> eVar);

    @Test(demo = "e5c6b9630a11efdfa31a4cfa4b227688")
    @GET("app/getClassifyMenu")
    @Nullable
    Object a(@Nullable @Query("location") String str, @NotNull kotlin.coroutines.e<? super ApiResult<List<Map<String, Object>>>> eVar);

    @Nullable
    @Test(demo = "51f3f9d9b6c4443621b37fa740c82fb8")
    @FormUrlEncoded
    @POST("app/setTian")
    Object b(@Field("city") @NotNull String str, @Field("weather") @NotNull String str2, @NotNull kotlin.coroutines.e<? super ApiResult<Object>> eVar);

    @Test(demo = "785796286eb58ca15168713af4fce70c")
    @POST("app/thirdLogin")
    @Nullable
    Object c(@Nullable @Query("username") String str, @Nullable @Query("password") String str2, @Nullable @Query("grant_type") String str3, @Nullable @Query("type") String str4, @NotNull kotlin.coroutines.e<? super Map<String, ? extends Object>> eVar);

    @Test(demo = "02941f2e7a00142dbf74699df84b52dd")
    @GET("app/getTian")
    @Nullable
    Object d(@NotNull @Query("city") String str, @NotNull kotlin.coroutines.e<? super ApiResult<Map<String, Object>>> eVar);

    @Test(demo = "e5c6b9630a11efdfa31a4cfa4b227688")
    @GET("app/getMyMenu")
    @Nullable
    Object e(@Nullable @Query("location") String str, @NotNull kotlin.coroutines.e<? super ApiResult<List<Map<String, Object>>>> eVar);

    @Test(demo = "595161576dff77f4a803c0ed91716d76")
    @GET("app/shareCircleUrl")
    @Nullable
    Object f(@Nullable @Query("schoolCode") String str, @Nullable @Query("userName") String str2, @NotNull kotlin.coroutines.e<? super ApiResult<Map<String, Object>>> eVar);

    @Test(demo = "7e9c6f977d2da2dbe67cd1005eaaf6e1")
    @GET("app/getAppIdV2")
    @Nullable
    Object g(@NotNull kotlin.coroutines.e<? super ApiResult<String>> eVar);

    @Test(demo = "38c9640f6ff5813c5c109acfa894f550")
    @GET("app/getExerciseDescription")
    @Nullable
    Object h(@NotNull kotlin.coroutines.e<? super ApiResult<Map<String, Object>>> eVar);

    @Test(demo = "5b4b6be878dca78c15579ef99b9fb774")
    @GET("app/clickBanner")
    @Nullable
    Object i(@NotNull @Query("messageArticleId") String str, @Nullable @Query("basUserId") String str2, @NotNull kotlin.coroutines.e<? super ApiResult<Object>> eVar);

    @Nullable
    @Test(demo = "c1107b22d1b83779cda4c4392c7c1cb6")
    @FormUrlEncoded
    @POST("app/getPgyerAppVersion")
    Object j(@Field("_api_key") @NotNull String str, @Field("appKey") @NotNull String str2, @NotNull kotlin.coroutines.e<? super PgyerApiResult<Map<String, Object>>> eVar);

    @Test(demo = "fdd57c5a055c28fbaf8bdaa034c6cc23")
    @GET("app/getStartTime")
    @Nullable
    Object k(@NotNull @Query("identify") String str, @NotNull kotlin.coroutines.e<? super ApiResult<Map<String, Object>>> eVar);

    @Streaming
    @GET
    @Nullable
    Object l(@Url @NotNull String str, @NotNull kotlin.coroutines.e<? super c0<ResponseBody>> eVar);

    @Test(demo = "8f27a7ee3082fff7aa759b38c697857a")
    @GET("app/getExerciseRecord")
    @Nullable
    Object m(@NotNull kotlin.coroutines.e<? super ApiResult<Map<String, Object>>> eVar);

    @Nullable
    @Test(demo = "d6b92e37a9625a7bc4b4486ecb906b76")
    @FormUrlEncoded
    @POST("app/getSchoolInfo")
    Object n(@Field("schoolId") @NotNull String str, @Field("model") @NotNull String str2, @NotNull kotlin.coroutines.e<? super OldApiResult<Map<String, Object>>> eVar);

    @Test(demo = "c395524a1fcdcb89f13a8a352bb8ee7b")
    @POST("app/faceDetect")
    @Nullable
    Object o(@Header("timestamp") @NotNull String str, @Body @Nullable MultipartBody multipartBody, @NotNull kotlin.coroutines.e<? super ApiResult<Boolean>> eVar);

    @DELETE("https://device.jpush.cn/v3/aliases/{alias_value}")
    @Nullable
    Object p(@Path("alias_value") @NotNull String str, @Header("Authorization") @NotNull String str2, @Header("Accept") @NotNull String str3, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @Test(demo = "2e3c1cc7b254311b8ad82f2d2d2fb550")
    @GET("app/getRecordList")
    @Nullable
    Object q(@NotNull @Query("status") String str, @NotNull @Query("date") String str2, @Query("datePageIndex") int i6, @Nullable @Query("isFeedback") String str3, @NotNull kotlin.coroutines.e<? super ApiResult<Map<String, Object>>> eVar);

    @Test(demo = "e40355ffec0e5271aa3515d1877263e8")
    @GET("app/getRecordDetail")
    @Nullable
    Object r(@NotNull @Query("exerciseRecordId") String str, @NotNull kotlin.coroutines.e<? super ApiResult<Map<String, Object>>> eVar);

    @Test(demo = "84e66a8b2fcf9bfd9840bd17a5dd38cb")
    @GET("app/searchSchool")
    @Nullable
    Object s(@NotNull @Query("name") String str, @NotNull @Query("model") String str2, @NotNull kotlin.coroutines.e<? super OldApiResult<List<Map<String, Object>>>> eVar);

    @Nullable
    @Test(demo = "fac59b800623b1146b41984c3c8df858")
    @POST("app/bugReport")
    @Multipart
    Object t(@NotNull @Part List<MultipartBody.Part> list, @NotNull kotlin.coroutines.e<? super OldApiResult<Map<String, Object>>> eVar);

    @Nullable
    @Test(demo = "e813ce47703893c5be40802067a5472b")
    @POST("app/feedbackExerciseRecord")
    @Multipart
    Object u(@NotNull @Part List<MultipartBody.Part> list, @NotNull kotlin.coroutines.e<? super ApiResult<Map<String, Object>>> eVar);

    @Test(demo = "16dd77786f3c3e1ac964437c978434ef")
    @GET("app/getAuth")
    @Nullable
    Object v(@NotNull kotlin.coroutines.e<? super ApiResult<Map<String, Object>>> eVar);

    @Test(demo = "785796286eb58ca15168713af4fce70c")
    @POST("app/autoLogin")
    @Nullable
    Object w(@Nullable @Query("refresh_token") String str, @Nullable @Query("scope") String str2, @Nullable @Query("grant_type") String str3, @Nullable @Query("type") String str4, @Nullable @Query("appType") String str5, @NotNull kotlin.coroutines.e<? super Map<String, ? extends Object>> eVar);

    @Test(demo = "785796286eb58ca15168713af4fce70c")
    @POST("app/login")
    @Nullable
    Object x(@Nullable @Query("username") String str, @Nullable @Query("grant_type") String str2, @Nullable @Query("type") String str3, @NotNull kotlin.coroutines.e<? super Map<String, ? extends Object>> eVar);

    @Nullable
    @Test(demo = "7d7f2d3627c76f56f26fb6f1e1b8fed1")
    @FormUrlEncoded
    @POST("app/update")
    Object y(@Field("schoolId") @Nullable String str, @Field("appSign") @Nullable String str2, @NotNull kotlin.coroutines.e<? super OldApiResult<Map<String, Object>>> eVar);

    @Test(demo = "7299e5cc759387e8eba523ca5ad16b56")
    @GET("app/getUserInfo")
    @Nullable
    Object z(@NotNull kotlin.coroutines.e<? super ApiResult<Map<String, Object>>> eVar);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bxkj.student.v2.retrofit.b$b, reason: collision with other inner class name */
    public static final class C0290b {
    }
}
