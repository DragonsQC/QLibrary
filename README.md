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
    compile 'com.github.DragonsQC:QLibrary:{X.X.X}'
}
```
# 说明
 Activity 相关类 | 描述
 --- | ---
 [BaseAppCompatActivity](/library/src/main/java/com/dqc/qlibrary/activity/BaseAppCompatActivity.java)| 简单封装startActivity()，start、finish带过度动画
 [BaseFragment](/library/src/main/java/com/dqc/qlibrary/activity/BaseFragment.java)| 简单封装startActivity()
 [BaseSwipeBackCompatActivity](/library/src/main/java/com/dqc/qlibrary/activity/BaseSwipeBackCompatActivity.java)| 简单封装startActivity()，start、finish带过度动画，可侧滑返回

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
 [JsonResponseParser](/library/src/main/java/com/dqc/qlibrary/utils/JsonResponseParser.java)| xUtil json 解析器
 [KeyboardUtils](/library/src/main/java/com/dqc/qlibrary/utils/KeyboardUtils.java)| Android 键盘工具类
 [ListViewUtil](/library/src/main/java/com/dqc/qlibrary/utils/ListViewUtil.java)| 动态设置嵌套 ListView 中高度
 [MathUtils](/library/src/main/java/com/dqc/qlibrary/utils/MathUtils.java)| 数字等公式相关工具类
 [NetStateUtils](/library/src/main/java/com/dqc/qlibrary/utils/NetStateUtils.java)| 网络状态工具类
 [QLog](/library/src/main/java/com/dqc/qlibrary/utils/QLog.java)| Android 日志工具类
 [ResourceUtils](/library/src/main/java/com/dqc/qlibrary/utils/ResourceUtils.java)| Android 资源相关工具类
 [SPUtils](/library/src/main/java/com/dqc/qlibrary/utils/SPUtils.java)| Android SharedPreferences 工具类
 [StringUtils](/library/src/main/java/com/dqc/qlibrary/utils/StringUtils.java)| 字符串相关工具类
 [SystemUtils](/library/src/main/java/com/dqc/qlibrary/utils/SystemUtils.java)| 系统/设备相关工具类
 [ThreadManager](/library/src/main/java/com/dqc/qlibrary/utils/ThreadManager.java)| 线程管理
 [ToastUtils](/library/src/main/java/com/dqc/qlibrary/utils/ToastUtils.java)| Android Toast 工具类
 [VibratorUtils](/library/src/main/java/com/dqc/qlibrary/utils/VibratorUtils.java)| Android 手机震动工具类

 第三方库 | 描述
 --- | ---
 【Android Support】|
  implementation 'com.android.support:support-v4:{*version}' | support-v4
  implementation 'com.android.support:appcompat-v7:{*version}' | appcompat-v7
  implementation 'com.android.support:palette-v7:{*version}' | palette-v7
  implementation 'com.android.support:cardview-v7:{*version}' | cardview-v7
  implementation 'com.android.support:recyclerview-v7:{*version}' | recyclerview-v7
  implementation 'com.android.support:percent:{*version}' | percent
  implementation 'com.android.support:design:{*version}' | design
 【Utils】 |
  implementation 'org.apache.commons:commons-lang3:{*version}' | Commons Lang
  implementation 'com.elvishew:xlog:{*version}' | xlog
 【HTTP】 |
  implementation 'org.xutils:xutils:{*version}' | xUtils3
  implementation 'com.squareup.retrofit2:retrofit:{*version}' | Retrofit2
  implementation 'com.squareup.retrofit2:converter-gson:{*version}' | Retrofit2 converter-gson
  implementation 'com.squareup.okhttp3:logging-interceptor:{*version}' | okhttp3 logging-interceptor
  implementation 'com.alibaba:fastjson:{*version}.android' | Fastjson
 【图片加载】 |
  implementation 'com.github.bumptech.glide:glide:{*version}' | Glide（需要使用GlideApp，请添加《annotationProcessor 'com.github.bumptech.glide:compiler:{*version}'》）
 【Animation】 |
  implementation 'com.nineoldandroids:library:{*version}' | NineoldAndroids
  implementation 'com.daimajia.easing:library:{*version}@aar'<br/> implementation 'com.daimajia.androidanimations:library:1.1.3@aar' | AndroidViewAnimations
 【Widget】 |
  implementation 'de.hdodenhof:circleimageview:{*version}' | CircleImageView
  implementation 'com.beardedhen:androidbootstrap:{*version}' | Bootstrap
  implementation 'com.flaviofaria:kenburnsview:{*version}' | KenBurnsView
  implementation 'com.twotoasters.jazzylistview:library:{*version}'<br/>implementation 'com.twotoasters.jazzylistview:library-recyclerview:{*version}' | 带载入特效的ListView、GridView、RecyclerView
  implementation 'com.afollestad.material-dialogs:core:{*version}' | Material Dialogs
  implementation 'com.github.rey5137:material:{*version}' | Material Design Library
  implementation 'com.h6ah4i.android.widget.advrecyclerview:advrecyclerview:{*version}@aar' | 拖拽排序 Advanced RecyclerView
【Other】 |
  implementation 'org.projectlombok:lombok:{*version}' | lombok（移除，需要使用单独添加，并添加《annotationProcessor 'org.projectlombok:lombok:{*version}'》）

 资源文件 | 描述
 --- | ---
  [【res/anim】](/library/src/main/res/anim) | 各种动画资源
  [【res/values/colors.xml】](/library/src/main/res/values/colors.xml) | 官方 Material Design 各种颜色
  [【res/values/dimens.xml】](/library/src/main/res/values/dimens.xml) | 常用间距（dp）、文字大小（sp）

{*version}：均为最新稳定版本

MORE AND MORE ......

***
## [Change Log](CHANGELOG.md)
