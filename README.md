# FuckTSN 2.0.25（社区适配版）

> 基于 [pansoul1/FuckTSN](https://github.com/pansoul1/FuckTSN) v2.0.18 源码，适配体适能 **2.0.25**（SecShell 加固）的 Xposed 模块。
> 本仓库 = 上游基线 + [PR#2](https://github.com/pansoul1/FuckTSN/pull/2) 的 2.0.25 适配 + 可复现的构建/签名流水线。

| 项 | 值 |
|---|---|
| 目标应用 | `com.bxkj.student`（体适能）**2.0.25 / versionCode 20250** |
| 模块版本 | `com.pansoul.fucktsn` **2.0.25 / versionCode 20250** |
| 兼容范围 | 体适能 2.0.15 – 2.0.25（旧类名分支保留） |
| 运行环境 | Android 10+（minSdk 29）+ LSPosed / 其他 Xposed 框架 |
| 构建环境 | JDK 17+、Gradle 8.13、AGP 8.13.0、compileSdk 36、build-tools 36.0.0 |
| 产物 | `dist/FuckTSN-2.0.25.apk`（15.81 MB，v3 签名） |
| 产物 SHA-256 | `A161B744B98DF9ED2CAB280E927C0ECB26E74F16DF14BD9E77A261C36211DC72` |

---

## 1. 这个仓库解决什么问题

上游作者 **只把模块更新到 2.0.18**（最后更新 2026-10-17），而体适能在 2.0.22 之后换了加固方案：

- 2.0.22：还是 360 加固，安全类叫 `com.bxkj.student.v2.common.utils.safe.c/d/f/g/h`；
- 2.0.25：**SecShell** 加固，真实 DEX 由 `InMemoryDexClassLoader` 加载，R8 把安全类重命名到**默认包**（`ce`、`cj4`、`rp1` 这种单字母/短名），旧的 `safe.*` Hook 全部匹配失败。

结果就是：模块装得上、LSPosed 也注入成功，但目标进程在 `App.onCreate()` 里被启动总控连着做 7 项检测，任一命中就 `System.exit(0)`，表现为"打开就闪退"。

本仓库把这条链路重新接上，并给出**能一键复现的构建流程**，而不是只丢一段改过的 Java 代码。

> 注意：模块是独立 APK，运行时注入，**不修改 `com.bxkj.student` 的 APK**，目标应用的签名和完整性都不动。

---

## 2. 相对上游（pansoul1/FuckTSN）的改进

### 2.1 差异总表

| 维度 | 上游 v2.0.18 | 本仓库 v2.0.25 | 影响 |
|---|---|---|---|
| 加固方案适配 | 360 加固 | 360 + **SecShell** | 2.0.22 以后不再闪退 |
| 安全类定位 | `safe.c/d/f/g/h` 固定包名 | 新增默认包精确类名集合 | 类名对不上导致 hook 全失效的问题解决 |
| 启动总控 | 无（逐项 hook） | 新增 `ce.b()` / `ce.a()` 短路 | 一条 hook 跳过整条启动检测链，容错更高 |
| 签名校验 | 旧 `SignatureHook` | 新增 `a12.c(Context)` → `true`、`Transform.d(Context)` → `true` | 过掉 Java 包装层与 native 层签名校验 |
| 类加载监听 | 只匹配 `com.bxkj.student` / `com.kuaishou.weapon` | 追加默认包类名匹配 | SecShell 脱壳后加载的类也能捕获 |
| 加载竞态 | 纯 `loadClass` 监听 | 追加 `App.onCreate()` 前主动 `findClass` 预加载 | 解决 `InMemoryDexClassLoader` 下"监听还没装上，检测已经跑完" |
| 线程安全 | `HashSet` | `Collections.synchronizedSet` | 多线程加载不重复 hook、不抛并发异常 |
| 退出兜底 | 无 | `hookProcessExit()` 拦截 `System.exit` / `Runtime.exit/halt` / `Process.killProcess` | 漏网检测杀不掉进程（可关，见 §7） |
| 版本标识 | 20180 / 2.0.18 | 20250 / 2.0.25 | 产物可区分 |
| 工程化 | 无构建脚本 | 补丁文件、一键构建/签名脚本、构建手册、实测记录 | 换机器也能复现 |

上游 PR#2 的原始改动量：**5 个文件、+418 / −12**；本仓库在此基础上固化了可复现的构建流程。

### 2.2 代码级改动清单

| 文件 | 改了什么 |
|---|---|
| `app/app/build.gradle.kts` | `versionCode 20180 → 20250`，`versionName 2.0.18 → 2.0.25` |
| `MainActivity.java` | 副标题 `Version 2.0.25 (for TSN 2.0.25)` |
| `hooks/RootDetectionHook.java` | 2.0.25 类名集合、`switch` 新分支、`ce/a12/Transform` hook、`App.onCreate` 预加载、退出拦截、线程安全集合 |
| `README.md` / `docs/2.0.25-adaptation.md` | 适配说明与部署要求 |

### 2.3 本仓库额外补的工程件

- `patches/ft-2.0.25.patch` —— 可直接 `git apply` 的补丁（不需要手动改 Java）；
- `build-release.ps1` —— 环境检查 → `assembleRelease` → `zipalign` → `apksigner sign/verify`；
- `docs/build-2.0.25-guide.md` —— 从零装 SDK 到签名的完整手册，含网络镜像与踩坑记录；
- `dist/` —— 已签名产物（本机实测 `BUILD SUCCESSFUL in 12m 13s`）。

---

## 3. 安全规则更新：2.0.18 → 2.0.25

### 3.1 类名映射表（核心规则）

| 2.0.18 旧类 | 功能 | 2.0.25 新类 | Hook 方法 | 期望返回值 |
|---|---|---|---|---|
| `...utils.safe.c` | Debug 检测 | `yj0` | `d()` | `false` |
| `...utils.safe.d` | 模拟器检测 | `tz0` | `a()` | `false` |
| `...utils.safe.f` | Hook 检测 | `rp1` | `a()` / `b()` / `c()` | `false` |
| `...utils.safe.g` | Root 检测 | `cj4` | `d()` | `false` |
| `...utils.safe.h` | TracerPid | `b15` | `a()` | `false` |
| —（新增） | 启动总控 | `ce` | `b()` / `a()` | 置空 |
| —（新增） | 签名 Java 包装 | `a12` | `c(Context)` | `true` |
| —（新增） | 原生签名 | `com.google.android.datatransport.Transform` | `d(Context)` | `true` |

实现位置：[`RootDetectionHook.java`](app/app/src/main/java/com/pansoul/fucktsn/hooks/RootDetectionHook.java)

```java
private static final Set<String> MODERN_SAFETY_CLASSES = new HashSet<>(Arrays.asList(
        "ce", "cj4", "tz0", "rp1", "b15", "yj0", "a12",
        "com.google.android.datatransport.Transform"));
```

### 3.2 2.0.25 的启动检测链

```text
com.bxkj.student.App.onCreate()
  → ce.b()                    启动总控
    → yj0.d()                 Debugger / 22 端口 / debuggable
    → SafeGuardThread         每 100ms 轮询 Debug.isDebuggerConnected() + b15.a()
    → tz0.a()                 模拟器（libemulator_check.so / Build 属性 / qemu 文件）
    → rp1.c()                 /data/local/tmp/frida-server 或 XposedBridge
    → b15.a()                 /proc/self/status 的 TracerPid
    → cj4.d()                 test-keys / 10 个 su 路径 / which su
    → a12.c() → Transform.d() 原生签名 / 正版校验
  任一命中 → System.exit(0)
```

对应地，模块的处理策略是"**总控短路 + 单项兜底 + 退出拦截**"三层：

1. **总控短路**：`ce.b()` 直接置空，整条链不再执行（最稳，也是 2.0.25 能起来的关键）；
2. **单项兜底**：`yj0/tz0/rp1/b15/cj4/a12/Transform` 逐个 hook，覆盖跑步入口 `k55.a0()` 的二次校验（错误码 1001–1006）；
3. **退出拦截**：万一有漏网检测调用 `System.exit`，进程也不会被杀。

### 3.3 加载策略（SecShell 的关键差异）

360 加固时代，安全类是普通 DEX 里的类，`ClassLoader.loadClass` 监听足够。SecShell 用
`InMemoryDexClassLoader` 加载真实 DEX，存在竞态：监听装上了，检测可能已经跑完。因此模块做三件事：

1. Hook `ClassLoader.loadClass(String)` 与 `loadClass(String, boolean)` 双签名；
2. 在 `com.bxkj.student.App.onCreate()` 的 `beforeHookedMethod` 里主动 `XposedHelpers.findClass` 预加载 `ce/cj4/tz0/rp1/b15/yj0/a12/Transform`；
3. `hookedClasses` 用 `Collections.synchronizedSet`，避免多线程重复 hook。

### 3.4 兼容性

- 旧的 `safe.c/d/f/g/h`、`com.kuaishou.weapon.*` 分支**全部保留**，所以 2.0.15–2.0.18 仍然可用；
- 新分支只按精确类名匹配，不会误伤其他应用的同名短类（默认包的 `ce` 只会在目标进程里被匹配到）。

### 3.5 规则失效怎么重算（2.0.26+）

R8 的类名是每次发版重新生成的，`ce/cj4` 这种名字**不会跨版本稳定**。重算流程：

1. 脱壳 dump 真实 DEX（`frida-dexdump`，或按 `dex\n035` 切分 `/proc/<pid>/mem`）；
2. `jadx -d out <dump>.dex`；
3. 搜特征串定位安全类：`TracerPid`、`/data/local/tmp/frida-server`、`test-keys`、`which su`、`XposedBridge`、`ro.kernel.qemu`；
4. 回溯到 `App.onCreate()` 里的总控类（比逐个 hook 单项更稳）；
5. 更新 `MODERN_SAFETY_CLASSES` + `switch` + 方法签名，重新构建。

---

## 4. 构建

完整步骤见 [docs/build-2.0.25-guide.md](docs/build-2.0.25-guide.md)。最短路径：

```powershell
# 1) SDK（platform 36 + build-tools 36.0.0）
(1..60 | ForEach-Object { 'y' }) | & "$SDK\cmdline-tools\latest\bin\sdkmanager.bat" --sdk_root=$SDK --licenses
& "$SDK\cmdline-tools\latest\bin\sdkmanager.bat" --sdk_root=$SDK 'platform-tools' 'platforms;android-36' 'build-tools;36.0.0'

# 2) 源码 + 补丁
git apply --check patches/ft-2.0.25.patch
git apply patches/ft-2.0.25.patch

# 3) 编译 + 签名（脚本内部会设 JAVA_HOME / ANDROID_HOME）
powershell -ExecutionPolicy Bypass -File .\build-release.ps1
```

只重新签名（不重编）：

```powershell
powershell -ExecutionPolicy Bypass -File .\build-release.ps1 -SkipBuild
```

### 4.1 网络注意点（实测）

| 现象 | 处理 |
|---|---|
| `services.gradle.org` 下载 Gradle 超时 | `gradle/wrapper/gradle-wrapper.properties` 的 `distributionUrl` 换成 `https://mirrors.cloud.tencent.com/gradle/gradle-8.13-bin.zip` |
| `github.com` 443 不可达 | 用 `https://ghfast.top/https://github.com/...` 镜像拉 zip |
| `api.xposed.info` 不可达 | 把 `api-82.jar` 放 `app/libs`，依赖改 `compileOnly(files("libs/api-82.jar"))` |

首次构建约 3–10 分钟（含 AGP 自动补装 build-tools 35、依赖下载约 500 MB）。

### 4.2 签名

`release.keystore` 是本地测试证书（自签名 RSA 2048，v3 签名），**与官方签名无关**——
Xposed 模块只要求能被系统安装，LSPosed 认的是包名 + `xposedmodule` 元数据。
换正式分发时自己 `keytool -genkeypair` 生成一份，别把私钥提交到仓库。

---

## 5. 安装与部署

1. 安装 `dist/FuckTSN-2.0.25.apk`；
2. LSPosed 中启用模块；
3. 作用域勾选 `com.bxkj.student`；
4. **把体适能从 Magisk DenyList 移出**（DenyList 会拦住 Zygote 注入）【如使用 KSU 则将体适能移出注入白名单即可】，如无可跳过；
5. **删掉 `/data/local/tmp/frida-server`**（`rp1.a()` 就查这个路径，文件名不改必命中）；
6. 强制停止体适能，重新打开。

### 5.1 验证清单

LSPosed 日志里应出现：

```text
FuckTSN: [2.0.25] App.onCreate 前主动加载安全类
FuckTSN:  SafeGuard(ce.b) Hook成功: ce
FuckTSN:  Hook检测类(rp1.c) Hook成功: rp1
FuckTSN:  签名包装类(a12.c) Hook成功: a12
FuckTSN:  Transform.d 原生签名校验 Hook成功
FuckTSN:  SafeGuard.ce.b() -> 跳过全部启动检测
```

APK 侧自检：

```powershell
aapt2 dump badging dist\FuckTSN-2.0.25.apk        # versionCode 20250 / versionName 2.0.25
apksigner verify --print-certs dist\FuckTSN-2.0.25.apk
# assets/xposed_init 内容应为 com.pansoul.fucktsn.MainHook
```

---

## 6. 目录结构

```text
.
├─ app/                                  # Gradle 工程根（含已打补丁的源码）
│  ├─ app/build.gradle.kts               # 版本号 2.0.25 / 20250
│  └─ app/src/main/
│     ├─ AndroidManifest.xml             # xposedmodule / xposedminversion=82 / xposedscope
│     ├─ assets/xposed_init              # com.pansoul.fucktsn.MainHook
│     └─ java/com/pansoul/fucktsn/
│        ├─ MainHook.java                # 入口，注册 9 个 hook
│        └─ hooks/
│           ├─ RootDetectionHook.java    # ★ 2.0.25 规则都在这里
│           ├─ SignatureHook.java        # 签名/加密日志
│           ├─ UniversalHook.java
│           ├─ AdSkipHook.java / DialogBlockHook.java / PrivacyAgreementHook.java
│           ├─ SportsDescriptionHook.java / DeveloperOptionsHook.java
│           ├─ DeviceIdDisplayHook.java / AccountQuickSelectHook.java
│           └─ BaseHook.java
├─ docs/
│  ├─ 2.0.25-adaptation.md               # 适配说明（类名、检测链、部署要求）
│  └─ build-2.0.25-guide.md              # 从零构建手册
├─ patches/ft-2.0.25.patch               # 上游基线 → 2.0.25 的补丁
├─ build-release.ps1                     # 一键构建/签名/校验
├─ release.keystore                      # 本地测试签名证书
└─ dist/
   ├─ FuckTSN-2.0.25.apk                 # 已签名产物
   ├─ FuckTSN-2.0.25-aligned.apk         # zipalign 中间产物
   └─ FuckTSN-2.0.25.apk.idsig
```

---

## 7. 已知限制

1. **类名不跨版本稳定**：`ce/cj4/tz0/rp1/b15/yj0/a12` 是 2.0.25 的 R8 产物，2.0.26 大概率会变，按 §3.5 重算。
2. **只适配了安全检测链**：广告跳过、隐私协议、账号快速选择、开发者选项等 UI 类 hook 仍指向旧类名（如 `com.bxkj.student.v2.ui.sports.safe.*`、`LoginActivity`、`LoginViewModel`），在 2.0.25 上可能静默失效——不影响启动，但这些附加功能需要按新版重新定位。
3. **退出拦截是双刃剑**：`hookProcessExit()` 会拦掉进程内所有 `System.exit`，包括正常退出流程。只想保启动的话，删掉 `hook()` 里的 `hookProcessExit();` 一行即可。
4. **未做服务端验证**：本模块只处理客户端检测/签名，跑步记录是否被判有效由服务端风控决定，模块给不了任何保证。
5. **真机验证仅来自 PR 作者自述**：PR#2 至今 open 未合并，日志是其单设备结果；本仓库完成了"能编译、能签名、能装上"，行为层面的验证请以你自己的 LSPosed 日志为准。

---

## 8. 更新日志

### v2.0.25（本仓库）

- 适配体适能 2.0.25（SecShell 加固）：新增默认包安全类映射 `ce/cj4/tz0/rp1/b15/yj0/a12`
- 新增启动总控 `ce.b()/a()` 短路，一条 hook 跳过整条检测链
- 新增签名校验绕过：`a12.c(Context)`、`Transform.d(Context)`
- 新增 `App.onCreate()` 预加载，解决 `InMemoryDexClassLoader` 竞态
- 新增退出拦截（可关）、线程安全集合
- 工程化：补丁、构建脚本、构建手册、已签名产物

### v2.0.18（上游）

- 适配体适能 2.0.18，设备指纹账号绑定优化，源码结构整理

---

## 9. 上游、致谢与许可

- 上游项目：[pansoul1/FuckTSN](https://github.com/pansoul1/FuckTSN)（作者 Pansoul，**未声明 LICENSE**）
- 2.0.25 适配来源：kdjdhe 的 [PR#2](https://github.com/pansoul1/FuckTSN/pull/2) 与逆向报告 [tishineng-reverse-2.0.25](https://github.com/kdjdhe/tishineng-reverse-2.0.25)
- 本仓库改动：版本号/文案、构建签名流水线、文档；核心 hook 逻辑来自上述 PR

**许可提示**：上游仓库没有 LICENSE 文件，严格来说二次分发/衍生作品处于授权不明状态。
自己本地编译自用没问题；要公开发布或商用，先联系上游作者取得书面许可。

**用途边界**：本项目面向**授权的安全测试**（校方/厂商书面授权、厂商 staging 环境、自己的测试账号）
与 Xposed/加固对抗的技术学习。拿它去刷校园跑成绩属于学术不端，风险自负，与本仓库作者无关。
