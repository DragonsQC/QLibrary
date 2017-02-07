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

#工具类说明
 activity 相关类 | 描述
 ---  | ---
 [BaseAppCompatActivity](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/activity/BaseAppCompatActivity.java)| 简单封装startActivity()，start、finish带过度动画
 [BaseFragment](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/activity/BaseFragment.java)| 简单封装startActivity()
 [SwipeBackCompatActivity](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/activity/SwipeBackCompatActivity.java)| 简单封装startActivity()，start、finish带过度动画，可侧滑返回

 工具类 | 描述
  ---  | ---
 [AnimationUtils](https://github.com/DragonsQC/QLibrary/blob/master/library/src/main/java/com/dqc/qlibrary/utils/AnimationUtils)| 动画工具类