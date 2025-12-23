package okio.internal;

import kotlin.collections.m;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.j;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlin.sequences.o;
import okio.FileSystem;
import okio.Path;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "okio.internal.-FileSystem$commonDeleteRecursively$sequence$1", f = "FileSystem.kt", i = {0}, l = {75}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"}, v = 1)
/* renamed from: okio.internal.-FileSystem$commonDeleteRecursively$sequence$1, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes4.dex */
final class FileSystem$commonDeleteRecursively$sequence$1 extends RestrictedSuspendLambda implements Function2<o<? super Path>, kotlin.coroutines.e<? super n1>, Object> {
    final /* synthetic */ Path $fileOrDirectory;
    final /* synthetic */ FileSystem $this_commonDeleteRecursively;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileSystem$commonDeleteRecursively$sequence$1(FileSystem fileSystem, Path path, kotlin.coroutines.e<? super FileSystem$commonDeleteRecursively$sequence$1> eVar) {
        super(2, eVar);
        this.$this_commonDeleteRecursively = fileSystem;
        this.$fileOrDirectory = path;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
        FileSystem$commonDeleteRecursively$sequence$1 fileSystem$commonDeleteRecursively$sequence$1 = new FileSystem$commonDeleteRecursively$sequence$1(this.$this_commonDeleteRecursively, this.$fileOrDirectory, eVar);
        fileSystem$commonDeleteRecursively$sequence$1.L$0 = obj;
        return fileSystem$commonDeleteRecursively$sequence$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(o<? super Path> oVar, kotlin.coroutines.e<? super n1> eVar) {
        return ((FileSystem$commonDeleteRecursively$sequence$1) create(oVar, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        o oVar = (o) this.L$0;
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        int i6 = this.label;
        if (i6 == 0) {
            g0.n(obj);
            FileSystem fileSystem = this.$this_commonDeleteRecursively;
            m mVar = new m();
            Path path = this.$fileOrDirectory;
            this.L$0 = j.a(oVar);
            this.label = 1;
            if (FileSystem.collectRecursively(oVar, fileSystem, mVar, path, false, true, this) == l6) {
                return l6;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            g0.n(obj);
        }
        return n1.f44123a;
    }
}
