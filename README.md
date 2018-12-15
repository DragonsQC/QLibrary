# Android 常用工具库

# Quick Start

[![](https://jitpack.io/v/DragonsQC/QLibrary.svg)](https://jitpack.io/#DragonsQC/QLibrary)

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency

```
dependencies {
    implementation 'com.github.DragonsQC:QLibrary:{X.X.X}'
}
```

# 说明
Activity 相关类 | 说明
--- | ---
[BaseAppCompatActivity](/library/src/main/java/com/dqc/qlibrary/activity/BaseAppCompatActivity.java)| 简单封装startActivity()，封装 StatusBar 相关方法
[BaseFragment](/library/src/main/java/com/dqc/qlibrary/activity/BaseFragment.java)| 简单封装startActivity()

***
工具类 | 描述
--- | ---
[AnimationUtils](/library/src/main/java/com/dqc/qlibrary/utils/AnimationUtils.java)| 动画工具类
[AppUtils](/library/src/main/java/com/dqc/qlibrary/utils/AppUtils.java)| APP相关信息工具类
[CleanUtils](/library/src/main/java/com/dqc/qlibrary/utils/CleanUtils.java)| APP数据清除工具类
[DateUtils](/library/src/main/java/com/dqc/qlibrary/utils/DateUtils.java)| 时间相关工具类
[DigestUtils](/library/src/main/java/com/dqc/qlibrary/utils/DigestUtils.java)| 摘要/加密解密工具类
[DoubleUtils](/library/src/main/java/com/dqc/qlibrary/utils/DoubleUtils.java)| 小数(Double)计算精确工具类类
[FileUtils](/library/src/main/java/com/dqc/qlibrary/utils/FileUtils.java)| 文件相关工具类
[ImageUtils](/library/src/main/java/com/dqc/qlibrary/utils/ImageUtils.java)| 图片相关工具类
[KeyboardUtils](/library/src/main/java/com/dqc/qlibrary/utils/KeyboardUtils.java)| Android 键盘工具类
[ListViewUtil](/library/src/main/java/com/dqc/qlibrary/utils/ListViewUtil.java)| 动态设置嵌套 ListView 中高度
[MathUtils](/library/src/main/java/com/dqc/qlibrary/utils/MathUtils.java)| 数字等公式相关工具类
[NetStateUtils](/library/src/main/java/com/dqc/qlibrary/utils/NetStateUtils.java)| 网络状态工具类
[OSUtil](/library/src/main/java/com/dqc/qlibrary/utils/OSUtil.java)| 设备系统工具类
[QLog](/library/src/main/java/com/dqc/qlibrary/utils/QLog.java)| 日志工具类
[ResourceUtils](/library/src/main/java/com/dqc/qlibrary/utils/ResourceUtils.java)| 资源相关工具类
[SPUtils](/library/src/main/java/com/dqc/qlibrary/utils/SPUtils.java)| SharedPreferences 工具类
[StatusBarUtils](/library/src/main/java/com/dqc/qlibrary/utils/StatusBarUtils.java)| 状态栏相关工具类
[StringUtils](/library/src/main/java/com/dqc/qlibrary/utils/StringUtils.java)| 字符串相关工具类
[SystemUtils](/library/src/main/java/com/dqc/qlibrary/utils/SystemUtils.java)| 系统/设备相关工具类
[ThreadManager](/library/src/main/java/com/dqc/qlibrary/utils/ThreadManager.java)| 线程管理
[ToastUtils](/library/src/main/java/com/dqc/qlibrary/utils/ToastUtils.java)| Toast 工具类
[VibratorUtils](/library/src/main/java/com/dqc/qlibrary/utils/VibratorUtils.java)| 手机震动工具类

***
第三方库 | 说明
--- | ---
**【Android Support for Androidx】** |
androidx.legacy:legacy-support-v4 |
androidx.appcompat:appcompat |
androidx.palette:palette |
androidx.cardview:cardview |
androidx.recyclerview:recyclerview |
androidx.annotation:annotation |
androidx.constraintlayout |
com.google.android.material:material |
com.trello.rxlifecycle3:rxlifecycle |
com.trello.rxlifecycle3:rxlifecycle-components |
androidx.lifecycle:lifecycle-compiler |
androidx.lifecycle:lifecycle-extensions |
**【Utils】** |
[Commons Lang](https://mvnrepository.com/artifact/org.apache.commons/commons-lang3) |
[xLog](https://github.com/elvishew/xLog) | 已封装入 [QLog](/library/src/main/java/com/dqc/qlibrary/utils/QLog.java)
[沉浸式状态栏 StatusBarUtil](https://github.com/laobie/StatusBarUtil) | 已封装入 BaseAppCompatActivity，使用setStatusBarXXX方法调用
[滑动返回 ParallaxBackLayout](https://github.com/anzewei/ParallaxBackLayout) | 必须在 Application 初始化 registerActivityLifecycleCallbacks(ParallaxHelper.getInstance()); [详细说明](https://github.com/anzewei/ParallaxBackLayout/blob/master/README_ZH.md)
[xUtils3](https://github.com/wyouflf/xUtils3) | xUtils3
**【HTTP】** |
[Retrofit2](https://github.com/square/retrofit) |
[Retrofit2 converter-gson](http://www.mvnrepository.com/artifact/com.squareup.retrofit2/converter-gson) |
[okhttp3 logging-interceptor](http://www.mvnrepository.com/artifact/com.squareup.okhttp3/logging-interceptor) |
[Fastjson](http://www.mvnrepository.com/artifact/com.alibaba/fastjson) |
**【图片加载】** |
[Glide](https://github.com/bumptech/glide) | 需使用GlideApp时，自行添 annotationProcessor
**【Animation】** |
[AndroidViewAnimations](https://github.com/daimajia/AndroidViewAnimations) |
**【Widget】** |
[CircleImageView](https://github.com/hdodenhof/CircleImageView) |
[Android-Bootstrap](https://github.com/Bearded-Hen/Android-Bootstrap) |
[Android-KenBurnsView](https://github.com/flavioarfaria/KenBurnsView) |
[Material Dialogs](https://github.com/afollestad/material-dialogs) |
[Advanced RecyclerView](https://github.com/h6ah4i/android-advancedrecyclerview) |

***
资源文件 | 描述
--- | ---
[res/anim](/library/src/main/res/anim) | 各种动画资源
[res/values/colors.xml](/library/src/main/res/values/colors.xml) | 官方 Material Design 各种颜色
[res/values/dimens.xml](/library/src/main/res/values/dimens.xml) | 常用间距（dp）、文字大小（sp）

***
# [Change Log](CHANGELOG.md)
