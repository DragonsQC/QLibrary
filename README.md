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
 >> compile 'com.android.support:support-v4:25.1.0' |
 >> compile 'com.android.support:appcompat-v7:25.1.0' |
 >> compile 'com.android.support:palette-v7:25.1.0' |
