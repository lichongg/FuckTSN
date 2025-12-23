package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final /* synthetic */ class JobInfoSchedulerService$$Lambda$1 implements Runnable {
    private final JobInfoSchedulerService arg$1;
    private final JobParameters arg$2;

    public static Runnable lambdaFactory$(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        return new JobInfoSchedulerService$$Lambda$1(jobInfoSchedulerService, jobParameters);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.arg$1.jobFinished(this.arg$2, false);
    }

    private JobInfoSchedulerService$$Lambda$1(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.arg$1 = jobInfoSchedulerService;
        this.arg$2 = jobParameters;
    }
}
