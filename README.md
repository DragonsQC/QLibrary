# Android 常用工具库

# Quick Start
[![](https://jitpack.io/v/DragonsQC/QLibrary.svg)](https://jitpack.io/#DragonsQC/QLibrary)

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
            }
        }

Step 2. Add the dependency

    dependencies {
        compile 'com.github.DragonsQC:QLibrary:{X.X.X}'
    }

# 说明
 Activity 相关类 | 描述
 --- | ---
 [BaseAppCompatActivity](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/activity/BaseAppCompatActivity.java)| 简单封装startActivity()，start、finish带过度动画
 [BaseFragment](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/activity/BaseFragment.java)| 简单封装startActivity()
 [BaseSwipeBackCompatActivity](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/activity/BaseSwipeBackCompatActivity.java)| 简单封装startActivity()，start、finish带过度动画，可侧滑返回

 工具类 | 描述
 --- | ---
 [AnimationUtils](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/AnimationUtils.java)| 动画工具类
 [AppUtils](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/AppUtils.java)| APP相关信息工具类
 [CleanUtils](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/CleanUtils.java)| APP数据清除工具类
 [JsonResponseParser](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/JsonResponseParser.java)| xUtil json 解析器
 [KeyboardUtils](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/KeyboardUtils.java)| Android 键盘工具类
 [ListViewUtil](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/ListViewUtil.java)| 动态设置嵌套 ListView 中高度
 [NetStateUtils](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/NetStateUtils.java)| 网络状态工具类
 [QLog](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/QLog.java)| Android 日志工具类
 [QUtils](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/QUtils.java)| 常用 Java 工具类集合
 [>>QUtils.FileUtil](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/QUtils.java#L35)| 文件相关工具类
 [>>QUtils.MathUtil](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/QUtils.java#L187)| 数字相关工具类
 [>>QUtils.DoubleUtil](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/QUtils.java#L230)| 小数计算精确类
 [>>QUtils.StringUtil](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/QUtils.java#L328)| 字符串相关工具类
 [>>QUtils.DateUtil](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/QUtils.java#L410)| 时间相关工具类
 [ResourceUtils](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/ResourceUtils.java)| Android 资源相关工具类
 [SPUtils](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/SPUtils.java)| Android SharedPreferences 工具类
 [ToastUtils](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/ToastUtils.java)| Android Toast 工具类
 [VibratorUtils](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/VibratorUtils.java)| Android 手机震动工具类

 第三方库 | 描述
 --- | ---
 [Apache Commons Codec](https://github.com/DragonsQC/QLibrary/tree/master/library/src/main/java/com/dqc/qlibrary/library/codec)| Apache Commons Codec v1.10
 【Android Support】|
  compile 'com.android.support:support-v4:{*version}' | support-v4
  compile 'com.android.support:appcompat-v7:{*version}' | appcompat-v7
  compile 'com.android.support:palette-v7:{*version}' | palette-v7
  compile 'com.android.support:cardview-v7:{*version}' | cardview-v7
  compile 'com.android.support:recyclerview-v7:{*version}' | recyclerview-v7
  compile 'com.android.support:percent:{*version}' | percent
  compile 'com.android.support:design:{*version}' | design
 【Utils】 |
  compile 'com.elvishew:xlog:{*version}' | xlog
 【HTTP】 |
  compile 'org.xutils:xutils:{*version}' | xUtils3
  compile 'com.squareup.retrofit2:retrofit:{*version}' | Retrofit2
  compile 'com.squareup.retrofit2:converter-gson:{*version}' | Retrofit2 converter-gson
  compile 'com.squareup.okhttp3:logging-interceptor:{*version}' | okhttp3 logging-interceptor
  compile 'com.alibaba:fastjson:{*version}.android' | Fastjson
 【图片加载】 |
  compile 'com.squareup.picasso:picasso:{*version}' | Picasso
  compile 'com.github.bumptech.glide:glide:{*version}' | Glide（需要使用GlideApp，请添加《annotationProcessor 'com.github.bumptech.glide:compiler:{*version}'》）
 【Animation】 |
  compile 'com.nineoldandroids:library:{*version}' | NineoldAndroids
  compile 'com.daimajia.easing:library:{*version}@aar'<br/> compile 'com.daimajia.androidanimations:library:1.1.3@aar' | AndroidViewAnimations
 【Widget】 |
  compile 'de.hdodenhof:circleimageview:{*version}' | CircleImageView
  compile 'com.beardedhen:androidbootstrap:{*version}' | Bootstrap
  compile 'com.flaviofaria:kenburnsview:{*version}' | KenBurnsView
  compile 'com.twotoasters.jazzylistview:library:{*version}'<br/>compile 'com.twotoasters.jazzylistview:library-recyclerview:{*version}' | 带载入特效的ListView、GridView、RecyclerView
  compile 'com.afollestad.material-dialogs:core:{*version}' | Material Dialogs
  compile 'com.github.rey5137:material:{*version}' | Material Design Library
  compile 'com.h6ah4i.android.widget.advrecyclerview:advrecyclerview:{*version}@aar' | 拖拽排序 Advanced RecyclerView
【Other】 |
  compile 'org.projectlombok:lombok:{*version}' | lombok（移除，需要使用单独添加，并添加《annotationProcessor 'org.projectlombok:lombok:{*version}'》）

 资源文件 | 描述
 --- | ---
  [【res/anim】](https://github.com/DragonsQC/QLibrary/tree/master/library/src/main/res/anim) | 各种动画资源
  [【res/values/colors.xml】](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/res/values/colors.xml) | 官方 Material Design 各种颜色
  [【res/values/dimens.xml】](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/res/values/dimens.xml) | 常用间距（dp）、文字大小（sp）

{*version}：均为最新稳定版本

MORE AND MORE ......