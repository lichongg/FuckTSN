package x;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import okhttp3.ResponseBody;
import retrofit2.c0;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f54744a = "https://h.boxkj.com/";

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/closeLostFoundNotice")
    rx.e<c0<ResponseBody>> a(@Field("noticeId") String str, @Field("regionUserId") String str2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/deleteLostFoundNotice")
    rx.e<c0<ResponseBody>> b(@Field("noticeId") String str, @Field("regionUserId") String str2);

    @POST("https://h.boxkj.com/app/goodsType/topLevelGoodsTypeList")
    rx.e<c0<ResponseBody>> c();

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/addLostNoticeQAValidate")
    rx.e<c0<ResponseBody>> d(@Field("noticeId") String str, @Field("regionUserId") String str2, @Field("question") String str3, @Field("answer") String str4);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/user/grantUser")
    rx.e<c0<ResponseBody>> e(@Field("schoolId") String str, @Field("userId") String str2, @Field("userName") String str3, @Field("sex") String str4, @Field("userNum") String str5, @Field("phone") String str6);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/user/userHasGranted")
    rx.e<c0<ResponseBody>> f(@Field("regionUserId") String str);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/allUsefulLostFoundNoticeList")
    rx.e<c0<ResponseBody>> g(@Field("pageIndex") int i6, @Field("pageSize") int i7);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/reviewQAValidate")
    rx.e<c0<ResponseBody>> h(@Field("regionUserId") String str, @Field("validateAnswerId") String str2, @Field("status") String str3);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/addLostFoundNotice")
    rx.e<c0<ResponseBody>> i(@NonNull @Field("regionUserId") String str, @NonNull @Field("goodsTypeId") String str2, @NonNull @Field("lostOrFound") int i6, @NonNull @Field("description") String str3, @Nullable @Field("img") String str4, @Nullable @Field("phone") String str5, @Nullable @Field("qq") String str6, @Nullable @Field("wechat") String str7, @Nullable @Field("price") String str8, @Nullable @Field("isValidate") String str9, @Nullable @Field("validateCount") int i7, @Nullable @Field("question") String str10);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/getNoticeDetail")
    rx.e<c0<ResponseBody>> j(@Field("noticeId") String str, @Field("regionUserId") String str2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/myLostFoundNoticeList")
    rx.e<c0<ResponseBody>> k(@Field("regionUserId") String str, @Field("pageIndex") int i6, @Field("pageSize") int i7);
}
