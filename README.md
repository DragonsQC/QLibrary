#Android 常用工具库

#Quick Start
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

#说明
 Activity 相关类 | 描述
 --- | ---
 [BaseAppCompatActivity](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/activity/BaseAppCompatActivity.java)| 简单封装startActivity()，start、finish带过度动画
 [BaseFragment](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/activity/BaseFragment.java)| 简单封装startActivity()
 [BaseSwipeBackCompatActivity](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/activity/BaseSwipeBackCompatActivity.java)| 简单封装startActivity()，start、finish带过度动画，可侧滑返回

 工具类 | 描述
 --- | ---
 [AnimationUtils](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/AnimationUtils.java)| 动画工具类
 [AppUtils](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/AppUtils.java)| APP相关信息工具类
 [JsonResponseParser](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/JsonResponseParser.java)| xUtil json 解析器
 [KeyboardTool](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/KeyboardTool.java)| Android 键盘工具类
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
  compile 'com.android.support:support-v4:25.2.0' | support-v4
  compile 'com.android.support:appcompat-v7:25.2.0' | appcompat-v7
  compile 'com.android.support:palette-v7:25.21.0' | palette-v7
  compile 'com.android.support:cardview-v7:25.2.0' | cardview-v7
  compile 'com.android.support:recyclerview-v7:25.2.0' | recyclerview-v7
  compile 'com.android.support:percent:25.2.0' | percent
  compile 'com.android.support:design:25.2.0' | design
 【RxJava、RaAndroid 】|
  compile 'io.reactivex.rxjava2:rxjava:2.0.1' | RxJava
  compile 'io.reactivex.rxjava2:rxandroid:2.0.1' | RxAndroid
 【Utils】 |
  compile 'com.elvishew:xlog:1.3.0' | xlog
  compile 'com.yalantis:ucrop:2.2.0-native' | uCrop
 【HTTP】 |
  compile 'org.xutils:xutils:3.3.40' | xUtils3
  compile 'com.squareup.retrofit2:retrofit:2.1.0' | Retrofit2
  compile 'com.squareup.retrofit2:converter-gson:2.1.0' | Retrofit2 converter-gson
  compile 'com.squareup.okhttp3:logging-interceptor:3.5.0' | okhttp3 logging-interceptor
  compile 'com.alibaba:fastjson:1.1.56.android' | Fastjson
 【图片加载】 |
  compile 'com.squareup.picasso:picasso:2.5.2' | Picasso
  compile 'com.github.bumptech.glide:glide:3.7.0' | Glide
 【Animation】 |
  compile 'com.nineoldandroids:library:2.4.0' | NineoldAndroids
  compile 'com.daimajia.easing:library:1.0.1@aar'<br/> compile 'com.daimajia.androidanimations:library:1.1.3@aar' | AndroidViewAnimations
 【Widget】 |
  compile 'com.beardedhen:androidbootstrap:2.3.1' | Bootstrap
  compile 'com.flaviofaria:kenburnsview:1.0.7' | KenBurnsView
  compile 'com.twotoasters.jazzylistview:library:1.2.1'<br/>compile 'com.twotoasters.jazzylistview:library-recyclerview:1.2.1' | 带载入特效的ListView、GridView、RecyclerView
  compile 'com.afollestad.material-dialogs:core:0.9.2.3' | Material Dialogs
  compile 'com.github.rey5137:material:1.2.4' | Material Design Library
  compile 'com.h6ah4i.android.widget.advrecyclerview:advrecyclerview:0.10.3@aar' | 拖拽排序 Advanced RecyclerView
【Other】 |
  compile 'org.projectlombok:lombok:1.16.14' | lombok

 资源文件 | 描述
 --- | ---
  [【res/anim】](https://github.com/DragonsQC/QLibrary/tree/master/library/src/main/res/anim) | 各种动画资源
  [【res/values/colors.xml】](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/res/values/colors.xml) | 官方 Material Design 各种颜色
  [【res/values/dimens.xml】](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/res/values/dimens.xml) | 常用间距（dp）、文字大小（sp）

MORE AND MORE ......