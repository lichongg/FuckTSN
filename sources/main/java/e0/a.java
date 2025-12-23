package e0;

import com.bxkj.base.user.LoginUser;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.c0;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f42997a = LoginUser.getLoginUser().getServerUrl();

    @FormUrlEncoded
    @POST("app/appStuForLeaveApply/findStuLeaveCurriculumApplyByUserId")
    e<c0<ResponseBody>> A(@Field("stuTeacherCurriculumId") String stuTeacherCurriculumId);

    @FormUrlEncoded
    @POST("app/stuTermScore/listcallStu")
    e<c0<ResponseBody>> A0(@Field("id") String id);

    @FormUrlEncoded
    @POST("app/fieldPlan/getRecordCount")
    e<c0<ResponseBody>> A1(@Field("userId") String userId, @Field("appointType") int appointType, @Field("date") String date);

    @FormUrlEncoded
    @POST("app/appMeaPerformanceFeedback/applyMeaPerformanceFeedback")
    e<c0<ResponseBody>> B(@Field("userId") String userId, @Field("meaScoreId") String meaScoreId, @Field("examId") String examId, @Field("rawScores") String score, @Field("complaintResults") String complaintResults, @Field("userPhone") String userPhone, @Field("applyReason") String applyReason);

    @FormUrlEncoded
    @POST("app/appMeaPerformanceFeedback/getMeaPerformanceFeedbackDetail")
    e<c0<ResponseBody>> B0(@Field("id") String id);

    @FormUrlEncoded
    @POST("app/scheduleExamStu/toadd")
    e<c0<ResponseBody>> B1(@Field("stuId") String stuId, @Field("id") String id);

    @FormUrlEncoded
    @POST("app/scheduleExamStu/scheduleExamStuCancel")
    e<c0<ResponseBody>> C(@Field("id") String id);

    @FormUrlEncoded
    @POST("app/appStuForLeaveApply/findStuLeaveCurriculumApplyById")
    e<c0<ResponseBody>> C0(@Field("id") String id);

    @GET("app/appStuMeaSchedule/getStuMeaInfo")
    e<c0<ResponseBody>> C1();

    @FormUrlEncoded
    @POST("app/stuTermScore/isLookScoreFX")
    e<c0<ResponseBody>> D(@Field("stuTermScoreid") String stuTermScoreid);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/applyMonitor")
    e<c0<ResponseBody>> D0(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/stuTeacherCurriculum/bluetoothDian")
    e<c0<ResponseBody>> D1(@Field("teachingClockingin") String teachingClockingin, @Field("stuTeacherCurriculum") String stuTeacherCurriculum, @Field("weekNum") String weekNum, @Field("baddress") String bluetoothAddress, @Field("schoolId") String schoolId);

    @FormUrlEncoded
    @POST("app/chooseCurriculum/chooseTeachingCurriculum")
    e<c0<ResponseBody>> E(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/stuPunchRecord/findPagerOk")
    e<c0<ResponseBody>> E0(@Field("userNum") String userNum, @Field("sysTermId") String sysTermId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/getStuCanInputExams")
    e<c0<ResponseBody>> E1(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/onlineExam/explainList")
    e<c0<ResponseBody>> F(@Field("stuId") String stuId, @Field("onlineType") int onlineType);

    @FormUrlEncoded
    @POST("app/face/checkUserByFace")
    e<c0<ResponseBody>> F0(@Field("base64Images") String base64Images, @Field("userNum") String userNum);

    @POST("app/runingFace/registerFaceApi")
    @Multipart
    e<c0<ResponseBody>> F1(@Part MultipartBody.Part userId, @Part MultipartBody.Part file);

    @POST("punch/findAllTermList")
    e<c0<ResponseBody>> G();

    @FormUrlEncoded
    @POST("app/bindUserPhoneByUserId")
    e<c0<ResponseBody>> G0(@Field("userId") String userId, @Field("phone") String phone);

    @FormUrlEncoded
    @POST("app/actOrder/getCurriculum")
    e<c0<ResponseBody>> G1(@Field("uid") String studentId, @Field("id") String id);

    @FormUrlEncoded
    @POST("app/onlineExam/loadExamExplain")
    e<c0<ResponseBody>> H(@Field("onlineType") int onlineType);

    @FormUrlEncoded
    @POST("app/appMeaPerformanceFeedback/getMeaPerformanceFeedbackList")
    e<c0<ResponseBody>> H0(@Field("userId") String userId, @Field("meaScoreId") String meaScoreId);

    @FormUrlEncoded
    @POST("app/competeSign/getAppCompetitionList")
    e<c0<ResponseBody>> H1(@Field("pageSize") int pageSize, @Field("pageIndex") int pageIndex);

    @FormUrlEncoded
    @POST("app/onlineExam/stuExamOnlineList")
    e<c0<ResponseBody>> I(@Field("userId") String userId, @Field("onlineType") int onlineType);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/list")
    e<c0<ResponseBody>> I0(@Field("userId") String userId, @Field("type") String type, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/dlbindThirdInfo")
    e<c0<ResponseBody>> I1(@Field("userNum") String userNum, @Field("name") String name, @Field("type") String type, @Field("id") String id, @Field("nickName") String nickName, @Field("img") String img);

    @FormUrlEncoded
    @POST("app/chooseCurriculum/showTeaSysUser")
    e<c0<ResponseBody>> J(@Field("teacherId") String teacherId);

    @FormUrlEncoded
    @POST("punch/loadQualifiedPunchRecordWeekData")
    e<c0<ResponseBody>> J0(@Field("userId") String userId, @Field("termId") String termId);

    @FormUrlEncoded
    @POST("app/appMeaNonStuApply/getMeaNonStuApplyRecords")
    e<c0<ResponseBody>> K(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/measure/countStuMeaScore")
    e<c0<ResponseBody>> K0(@Field("sex") String sex, @Field("grade") String grade, @Field("height") String height, @Field("weight") String weight, @Field("vitalCapacity") String vitalCapacity, @Field("standingLongJump") String standingLongJump, @Field("sittingBodyFlexion") String sittingBodyFlexion, @Field("meters50") String meters50, @Field("meters") String meters, @Field("pullOrSit") String pullOrSit);

    @FormUrlEncoded
    @POST("app/ispwdmod")
    e<c0<ResponseBody>> L(@Field("userNum") String userNum);

    @FormUrlEncoded
    @POST("app/actOrder/update")
    e<c0<ResponseBody>> L0(@Field("uid") String studentId, @Field("id") String id, @Field("curriculum") String curriculum);

    @FormUrlEncoded
    @POST("app/stuTermScore/uidSelect")
    e<c0<ResponseBody>> M(@Field("uid") String userId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/cancelMeaRecordCtl")
    e<c0<ResponseBody>> M0(@Field("id") String id, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/evaluate/saveAssessPaper")
    e<c0<ResponseBody>> N(@Field("stuTeacherCurriculumId") String stuTeacherCurriculumId, @Field("stuId") String stuId, @Field("data") String data);

    @FormUrlEncoded
    @POST("app/evaluate/stuHasEvaluatedSuccess")
    e<c0<ResponseBody>> N0(@Field("stuTeacherCurriculumId") String stuTeacherCurriculumId, @Field("stuId") String stuId, @Field("onlineType") int onlineType);

    @FormUrlEncoded
    @POST("app/appstu/uploadGatherPhotoBase64")
    e<c0<ResponseBody>> O(@Field("userId") String userId, @Field("base64") String base64);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/list")
    e<c0<ResponseBody>> O0(@Field("userId") String userId, @Field("type") String type, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/measure/getStuScoreDetail")
    e<c0<ResponseBody>> P(@Field("meaScoreId") String meaScoreId);

    @FormUrlEncoded
    @POST("app/competeSign/cancelSignUpItem")
    e<c0<ResponseBody>> P0(@Field("itemId") String itemId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/teacherCurriculum/chooseTeachingCurriculum")
    e<c0<ResponseBody>> Q(@Field("stuid") String userId, @Field("parameter") Integer week);

    @FormUrlEncoded
    @POST("app/scheduleExam/stuScheduleExamList")
    e<c0<ResponseBody>> Q0(@Field("stuid") String stuid);

    @FormUrlEncoded
    @POST("app/getSysUserByThirdId")
    e<c0<ResponseBody>> R(@Field("type") String type, @Field("thirdId") String thirdId);

    @FormUrlEncoded
    @POST("app/evaluate/checkUserAssessTime")
    e<c0<ResponseBody>> R0(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appsyshelp/appsyshelplist")
    e<c0<ResponseBody>> S(@Field("helpType") int helpType, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/callStuIdentify/userAddCallStuIdentify")
    e<c0<ResponseBody>> S0(@Field("uid") String userId);

    @FormUrlEncoded
    @POST("app/appMeaNonStuApply/applyMeaNonStuApply")
    e<c0<ResponseBody>> T(@Field("userId") String userId, @Field("address") String address, @Field("applyMemo") String applyMemo, @Field("fileNames") String fileNames, @Field("imgs") String imgs, @Field("meaStatusId") String meaStatusId, @Field("yearId") String yearId);

    @FormUrlEncoded
    @POST("app/getUserInfoByTel")
    e<c0<ResponseBody>> T0(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("app/appstu/checkInfo2RestPwd")
    e<c0<ResponseBody>> U(@Field("uname") String uname, @Field("cardId") String cardId, @Field("cnames") String cnames);

    @FormUrlEncoded
    @POST("app/chooseCurriculum/showTime")
    e<c0<ResponseBody>> U0(@Field("userId") String userId, @Field("teachingId") String teachingId);

    @POST("app/scheduleExamStu/getScheduleExamExplain")
    e<c0<ResponseBody>> V();

    @FormUrlEncoded
    @POST("app/modPasswd")
    e<c0<ResponseBody>> V0(@Field("userId") String userId, @Field("originalpwd") String originalpwd, @Field("newpwd") String newpwd);

    @FormUrlEncoded
    @POST("app/stuTermPunchRecord/findList")
    e<c0<ResponseBody>> W(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/scheduleExamStu/scheduleExamStuCtlStulist")
    e<c0<ResponseBody>> W0(@Field("uid") String uid);

    @FormUrlEncoded
    @POST("app/teaMeaSchedule/addScore")
    e<c0<ResponseBody>> X(@Field("userId") String userId, @Field("userNum") String userNum, @Field("examId") String examId, @Field("variable") String variable);

    @FormUrlEncoded
    @POST("app/evaluate/loadAssessData")
    e<c0<ResponseBody>> X0(@Field("stuId") String stuId);

    @POST("app/onlineExam/explainTeacherCurriculumList")
    e<c0<ResponseBody>> Y();

    @FormUrlEncoded
    @POST("app/measure/appTiceRank")
    e<c0<ResponseBody>> Y0(@Field("type") int type, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appnotice/noReadNotice")
    e<c0<ResponseBody>> Z(@Field("userId") String userId, @Field("identity") String identity);

    @FormUrlEncoded
    @POST("app/evaluate/stuAssessTeaList")
    e<c0<ResponseBody>> Z0(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/fieldPlan/fieldPlanAppointedList")
    e<c0<ResponseBody>> a(@Field("userId") String userId, @Field("type") int type, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @GET("app/config/getCustomerServiceConfig")
    e<c0<ResponseBody>> a0();

    @FormUrlEncoded
    @POST("app/relieveBindThirdInfo")
    e<c0<ResponseBody>> a1(@Field("type") String type, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appCompetition/getAppCompeteItems")
    e<c0<ResponseBody>> b(@Field("competitionId") String competitionId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/evaluate/checkUserAssessTime1")
    e<c0<ResponseBody>> b0(@Field("userId") String userId, @Field("stuTeacherCurriculumId") String stuTeacherCurriculumId);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/doadd")
    e<c0<ResponseBody>> b1(@Field("id") String id, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/fieldPlan/stuAppointField")
    e<c0<ResponseBody>> c(@Field("userId") String userId, @Field("fieldPlanDateId") String fieldPlanDateId, @Field("detailId") String detailId, @Field("status") String status);

    @FormUrlEncoded
    @POST("app/learnWork/getLearnWorkdetail")
    e<c0<ResponseBody>> c0(@Field("learnWorkId") String learnWorkId);

    @FormUrlEncoded
    @POST("app/config/getUploadMethod")
    e<c0<ResponseBody>> c1(@Field("method") String method);

    @FormUrlEncoded
    @POST("app/appCompetition/competeUserSignUp")
    e<c0<ResponseBody>> d(@Field("itemId") String itemId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/actOrder/doList")
    e<c0<ResponseBody>> d0(@Field("uid") String studentId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/onlineExam/isCourseSelection")
    e<c0<ResponseBody>> d1(@Field("stuTeacherCurriculumId") String stuTeacherCurriculumId, @Field("onlineType") int onlineType);

    @FormUrlEncoded
    @POST("app/appCompetition/getAppCompetitionDetail")
    e<c0<ResponseBody>> e(@Field("competitionId") String competitionId);

    @FormUrlEncoded
    @POST("app/onlineExam/deleteStuPaper")
    e<c0<ResponseBody>> e0(@Field("stuId") String stuId, @Field("identify") String identify);

    @FormUrlEncoded
    @POST("app/appstu/userCheckUserNum")
    e<c0<ResponseBody>> e1(@Field("userNum") String userNum, @Field("userName") String userName, @Field("userPhone") String userPhone);

    @FormUrlEncoded
    @POST("app/appCompetition/cancelSignUpItem")
    e<c0<ResponseBody>> f(@Field("itemId") String itemId, @Field("userId") String userId);

    @POST("app/onlineExam/loadExamContentDataYD")
    e<c0<ResponseBody>> f0();

    @FormUrlEncoded
    @POST("app/updateStudentInfo")
    e<c0<ResponseBody>> f1(@Field("userId") String userId, @Field("email") String email, @Field("nationId") Object nationId, @Field("sourceId") Object sourceId, @Field("address") String address, @Field("identityCard") String identityCard, @Field("suspId") String suspId, @Field("sysStuDetailId") String sysStuDetailId);

    @FormUrlEncoded
    @POST("app/appCompetition/getAppCompetitionList")
    e<c0<ResponseBody>> g(@Field("competitionId") String competitionId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/field/getChilFieldByPid")
    e<c0<ResponseBody>> g0(@Field("id") String id);

    @FormUrlEncoded
    @POST("app/bindThirdInfo")
    e<c0<ResponseBody>> g1(@Field("userId") String userId, @Field("type") String type, @Field("id") String id, @Field("nickName") String nickName, @Field("img") String img);

    @FormUrlEncoded
    @POST("app/appCompetition/getMyAppCompeteItems")
    e<c0<ResponseBody>> h(@Field("competitionId") String competitionId, @Field("userId") String userId);

    @POST("app/appHealthStudentApply/getHealthStudentStatus")
    e<c0<ResponseBody>> h0();

    @FormUrlEncoded
    @POST("app/competeSign/competeUserSignUp")
    e<c0<ResponseBody>> h1(@Field("itemId") String itemId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/competeSign/getAppItemByUserAndCompetitionId")
    e<c0<ResponseBody>> i(@Field("competionId") String competionId, @Field("userId") String userId, @Field("pageSize") int pageSize, @Field("pageIndex") int pageIndex);

    @FormUrlEncoded
    @POST("app/actOrder/addOrder")
    e<c0<ResponseBody>> i0(@Field("uid") String studentId, @Field("id") String id);

    @FormUrlEncoded
    @POST("app/scheduleExamStu/stulist")
    e<c0<ResponseBody>> i1(@Field("uid") String uid);

    @FormUrlEncoded
    @POST("app/appCompetition/getMyAppCompetitionList")
    e<c0<ResponseBody>> j(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/stuTeacherCurriculum/stuIgnIn")
    e<c0<ResponseBody>> j0(@Field("stuTeacherCurriculum") String stuTeacherCurriculum);

    @POST("app/getStudentInfo")
    e<c0<ResponseBody>> j1();

    @FormUrlEncoded
    @POST("app/stuGymClockRecord/getStuAllGymClockRecords")
    e<c0<ResponseBody>> k(@Field("userId") String userId, @Field("sysTermId") String sysTermId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/list2")
    e<c0<ResponseBody>> k0(@Field("userId") String userId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @POST("app/appMeaNonStuApply/loadSysYears")
    e<c0<ResponseBody>> k1();

    @FormUrlEncoded
    @POST("app/appHealthStudentApply/getHealthStudentApplyList")
    e<c0<ResponseBody>> l(@Field("userId") String userId);

    @POST("app/getSources")
    e<c0<ResponseBody>> l0();

    @FormUrlEncoded
    @POST("app/appnotice/appListNoticeData")
    e<c0<ResponseBody>> l1(@Field("userId") String userId, @Field("identity") String identity, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("punch/loadPunchRecordWeekData1")
    e<c0<ResponseBody>> m(@Field("userId") String userId, @Field("termId") String termId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appStuForLeaveApply/loadStuTeacherCurriculumData")
    e<c0<ResponseBody>> m0(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/stuTeacherCurriculum/selstuTeacherCurriculum")
    e<c0<ResponseBody>> m1(@Field("stuid") String userId, @Field("stuTermScoreid") String stuTermScoreid);

    @FormUrlEncoded
    @POST("app/appStuForLeaveApply/getTermTotalScore")
    e<c0<ResponseBody>> n(@Field("userId") String userId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("punch/getTermWeekNum")
    e<c0<ResponseBody>> n0(@Field("termId") String termId);

    @FormUrlEncoded
    @POST("adminApp/gaugePoint/gainGaugePoint")
    e<c0<ResponseBody>> n1(@Field("uid") String userId, @Field("identify") String identify);

    @FormUrlEncoded
    @POST("app/chooseCurriculum/showCurriculums")
    e<c0<ResponseBody>> o(@Field("userId") String userId, @Field("timeId") String timeId);

    @FormUrlEncoded
    @POST("app/stuTeacherCurriculum/deleteStuTeaCurr")
    e<c0<ResponseBody>> o0(@Field("stuTeacherCurriculumid") String stuTeacherCurriculumid);

    @FormUrlEncoded
    @POST("app/onlineExam/getExamOnlineStuPaperDetail")
    e<c0<ResponseBody>> o1(@Field("stuId") String userId, @Field("stuTeacherCurriculumId") String stuTeacherCurriculumId, @Field("identify") String identify);

    @FormUrlEncoded
    @POST("app/runingFace/isUpFaces")
    e<c0<ResponseBody>> p(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/measure/getStuTotalScore")
    e<c0<ResponseBody>> p0(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appstu/getCheckInfo2RestPwd")
    e<c0<ResponseBody>> p1(@Field("uname") String uname);

    @FormUrlEncoded
    @POST("app/actOrder/actOrderListView")
    e<c0<ResponseBody>> q(@Field("uid") String studentId, @Field("id") String id);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/list3")
    e<c0<ResponseBody>> q0(@Field("userId") String userId, @Field("type") String type, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/learnWork/saveWorkVoteOrWorkShare")
    e<c0<ResponseBody>> q1(@Field("learnWorkId") String learnSelectionWorkId, @Field("workType") int workType, @Field("workStatus") int workStatus);

    @FormUrlEncoded
    @POST("app/appstu/login")
    e<c0<ResponseBody>> r(@Field("uname") String username, @Field("pwd") String password);

    @POST("app/announcementContent/appAnnouncementContentList")
    e<c0<ResponseBody>> r0();

    @FormUrlEncoded
    @POST("app/learnWork/getLearnWorkPagerList")
    e<c0<ResponseBody>> r1(@Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize, @Field("learnQuestionName") String learnQuestionName);

    @POST("app/evaluate/loadTeachingAssessExplain")
    e<c0<ResponseBody>> s();

    @FormUrlEncoded
    @POST("app/stuGymClockRecord/getStuGymClockRecords")
    e<c0<ResponseBody>> s0(@Field("userId") String userId, @Field("sysTermId") String sysTermId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/stuPunchRecord/findPager")
    e<c0<ResponseBody>> s1(@Field("userNum") String userNum, @Field("sysTermId") String sysTermId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/getScheduleView")
    e<c0<ResponseBody>> t(@Field("id") String id, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/isMonitor")
    e<c0<ResponseBody>> t0(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appStuForLeaveApply/addStuLeaveCurriculumApply")
    e<c0<ResponseBody>> t1(@Field("userId") String userId, @Field("stuTeacherCurriculumId") String stuTeacherCurriculumId, @Field("weekNum") Integer weekNum, @Field("applyMemo") String applyMemo, @Field("fileNames") String fileNames, @Field("imgs") String imgs);

    @FormUrlEncoded
    @POST("app/actOrder/del")
    e<c0<ResponseBody>> u(@Field("uid") String studentId, @Field("id") String id);

    @POST("app/appMeaNonStuApply/loadMeaStatus")
    e<c0<ResponseBody>> u0();

    @FormUrlEncoded
    @POST("app/stuTeacherCurriculum/chooseTeachingCurriculum")
    e<c0<ResponseBody>> u1(@Field("stuid") String userId, @Field("teaCurriculumid") String teaCurriculumid);

    @FormUrlEncoded
    @POST("app/validatePwdByUserId")
    e<c0<ResponseBody>> v(@Field("userId") String userId, @Field("pwd") String password);

    @FormUrlEncoded
    @POST("app/stuGymClockRecord/addStuGymClockRecord")
    e<c0<ResponseBody>> v0(@Field("operatorID") String operatorID, @Field("stuCardNum") String stuCardNum, @Field("type") String type);

    @FormUrlEncoded
    @POST("app/chooseCurriculum/showTeachingCurriculum")
    e<c0<ResponseBody>> v1(@Field("userId") String userId, @Field("timeId") String timeId, @Field("parameter") String parameter, @Field("teachingId") String teachingId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appMeaNonStuApply/getMeaNonStuApplyRecordDetail")
    e<c0<ResponseBody>> w(@Field("meaNonStuApplyId") String meaNonStuApplyId);

    @FormUrlEncoded
    @POST("app/actOrder/pagerActOrder")
    e<c0<ResponseBody>> w0(@Field("uid") String studentId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/changeUserPassword")
    e<c0<ResponseBody>> w1(@Field("userNum") String userNum, @Field("pwd") String pwd);

    @FormUrlEncoded
    @POST("app/appHealthStudentApply/getHealthStudentApplyDetail")
    e<c0<ResponseBody>> x(@Field("id") String id);

    @POST("app/learnWork/getLearnWorkProject")
    e<c0<ResponseBody>> x0();

    @POST("app/getNations")
    e<c0<ResponseBody>> x1();

    @FormUrlEncoded
    @POST("app/getUserInfoCountByTel")
    e<c0<ResponseBody>> y(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("app/appHealthStudentApply/applyHealthStudentApply")
    e<c0<ResponseBody>> y0(@Field("userId") String userId, @Field("applyMemo") String applyMemo, @Field("fileNames") String fileNames, @Field("imgs") String imgs, @Field("type") String type);

    @FormUrlEncoded
    @POST("app/appMeaNonStuApply/cancelMeaNonStuApply")
    e<c0<ResponseBody>> y1(@Field("id") String id);

    @FormUrlEncoded
    @POST("app/appStuMeaSchedule/viewMeaSpecification")
    e<c0<ResponseBody>> z(@Field("type") String type, @Field("uid") String uid);

    @FormUrlEncoded
    @POST("app/onlineExam/loadExamContentData")
    e<c0<ResponseBody>> z0(@Field("stuTeacherCurriculumId") String stuTeacherCurriculumId, @Field("teachingCurrIds") String teachingCurrIds, @Field("userId") String userId, @Field("onlineType") int onlineType);

    @FormUrlEncoded
    @POST("app/onlineExam/saveExamPaper")
    e<c0<ResponseBody>> z1(@Field("stuTeacherCurriculumId") String stuTeacherCurriculumId, @Field("userId") String stuId, @Field("radio") String data, @Field("check") String check, @Field("quest") String quest, @Field("startTime") String startTime, @Field("onlineType") int onlineType);
}
