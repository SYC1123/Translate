package com.example.translate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.lang.annotation.Annotation;

public class MainActivity extends AppCompatActivity {
    private Button button, button1, button2,button3;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //平移动画
        button = findViewById(R.id.button);
        /**
         * 使用XML控制
         * */
        /*
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate);
        animation.setDuration(5000);
        button.startAnimation(animation);
        */
        /**
         * 获取屏幕宽高，可以更好的控制距离
         * **/
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int screen_x = metric.widthPixels;     // 屏幕宽度（像素）
        int screen_y = metric.heightPixels;   // 屏幕高度（像素）
        /**
         * 使用JAVA代码控制动画
         * **/
        Animation animation = new TranslateAnimation(0, screen_x, 0, screen_y);
        animation.setDuration(3000);//动画持续时间
        animation.setFillEnabled(true);//使其可以填充效果从而不回到原地
        animation.setFillAfter(true);//不回到起始位置
        //如果不添加setFillEnabled和setFillAfter则动画执行结束后会自动回到远点
        button.startAnimation(animation);


        //缩放动画
        /**
         * android:duration：动画持续时长
         * android:fillAfter：动画结束之后是否保持动画的最终状态；true，表示保持动画的最终状态
         * android:fillBefore：动画结束之后是否保持动画开始前的状态；true，表示恢复到动画开始前的状态
         * android:interpolator：动画插值器。是实现动画不规则运动的一种方式，后面讲到
         * android:repeatCount：动画重复的次数。指定动画重复播放的次数，如果你需要无限循环播放，请填写一个小于0的数值，一般写-1
         * android:repeatMode：动画重复的Mode，有reverse和restart两种，效果看后面
         * android:startOffset：动画播放延迟时长，就是调用start之后延迟多少时间播放动画
         *
         * android:fromXScale：动画开始时X轴方向控件大小，取值和android：pivot一样；三种取值类型：数字；百分比；百分比+”p”;
         * android:fromYScale：动画开始时Y轴方向控件大小，取值类型同上
         *  动画在水平方向X的起始缩放倍数
         *  0.0表示起始大小收缩到没有
         *  1.0表示起始大小正常无伸缩
         *  值小于1.0表示起始大小收缩倍数
         *  值大于1.0表示起始大小放大倍数
         *
         * android:toXScale：动画在X轴方向上控件的目标大小，取值类型同上
         * android:toYScale：动画在Y轴方向上控件的目标大小，取值类型同上
         *
         * android:pivotX：缩放中心坐标的X值，取值类型有三种：数字；百分比；百分比+”p”;
         * 数字：例如50.0，这里的单位是px像素
         * 百分比：例如50%，这里是相对于自己控件宽度的百分比，实际的值是mIvImg.getWidth()*50%；
         * 百分比+”p”：例如50%p，这里是表示相对于自己控件的父控件的百分比，
         * android:pivotY：同上
         * **/
        imageView = findViewById(R.id.imageView);
        /**
         * 使用XML控制
         * */
        /*
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.scale);
        animation1.setDuration(3000);
        animation1.setFillAfter(true);
        animation1.setFillEnabled(true);
        imageView.startAnimation(animation1);
        */
        /**
         * 使用JAVA代码控制动画
         * **/
        Animation animation1 = new ScaleAnimation(0, 2, 0, 2, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        // 参数说明:
        // 1. fromX ：动画在水平方向X的起始缩放倍数
        // 2. toX ：动画在水平方向X的结束缩放倍数
        // 3. fromY ：动画开始前在竖直方向Y的起始缩放倍数
        // 4. toY：动画在竖直方向Y的结束缩放倍数
        // 5. pivotXType:缩放轴点的x坐标的模式
        // 6. pivotXValue:缩放轴点x坐标的相对值
        // 7. pivotYType:缩放轴点的y坐标的模式
        // 8. pivotYValue:缩放轴点y坐标的相对值

        // pivotXType = Animation.ABSOLUTE:缩放轴点的x坐标 =  View左上角的原点 在x方向 加上 pivotXValue数值的点(y方向同理)
        // pivotXType = Animation.RELATIVE_TO_SELF:缩放轴点的x坐标 = View左上角的原点 在x方向 加上 自身宽度乘上pivotXValue数值的值(y方向同理)
        // pivotXType = Animation.RELATIVE_TO_PARENT:缩放轴点的x坐标 = View左上角的原点 在x方向 加上 父控件宽度乘上pivotXValue数值的值 (y方向同理)

        animation1.setDuration(3000);
        animation1.setRepeatCount(-1);//播放次数,-1循环播放
        imageView.startAnimation(animation1);


        //旋转动画
        button1 = findViewById(R.id.button2);
        /**
         * 使用XML控制
         * */

        /*
        Animation animation2=AnimationUtils.loadAnimation(this,R.anim.rotate);
        animation2.setDuration(3000);
        button1.startAnimation(animation2);
        */

        /**
         * 使用JAVA代码控制动画
         * **/
        Animation animation2 = new RotateAnimation(0, 270, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        // 参数说明:
        // 1. fromDegrees ：动画开始时 视图的旋转角度(正数 = 顺时针，负数 = 逆时针)
        // 2. toDegrees ：动画结束时 视图的旋转角度(正数 = 顺时针，负数 = 逆时针)
        // 3. pivotXType：旋转轴点的x坐标的模式
        // 4. pivotXValue：旋转轴点x坐标的相对值
        // 5. pivotYType：旋转轴点的y坐标的模式
        // 6. pivotYValue：旋转轴点y坐标的相对值

        // pivotXType = Animation.ABSOLUTE:旋转轴点的x坐标 =  View左上角的原点 在x方向 加上 pivotXValue数值的点(y方向同理)
        // pivotXType = Animation.RELATIVE_TO_SELF:旋转轴点的x坐标 = View左上角的原点 在x方向 加上 自身宽度乘上pivotXValue数值的值(y方向同理)
        // pivotXType = Animation.RELATIVE_TO_PARENT:旋转轴点的x坐标 = View左上角的原点 在x方向 加上 父控件宽度乘上pivotXValue数值的值 (y方向同理)

        animation2.setDuration(3000);
        button1.startAnimation(animation2);


        //透明动画
        button2 = findViewById(R.id.button3);
        /**
         * 使用XML控制
         * */
        /*
        Animation animation3=AnimationUtils.loadAnimation(this,R.anim.alpha);
        animation3.setDuration(3000);
        button2.startAnimation(animation3);
        */
        /**
         * 使用JAVA代码控制动画
         * **/
        Animation animation3 = new AlphaAnimation(1, 0);
        // 参数说明:
        // 1. fromAlpha:动画开始时视图的透明度(取值范围: -1 ~ 1)
        // 2. toAlpha:动画结束时视图的透明度(取值范围: -1 ~ 1)
        animation3.setDuration(3000);
        button2.startAnimation(animation3);

        //组合动画
        button3=findViewById(R.id.button4);
        /**
         * 使用XML控制
         * */
        Animation animation4=AnimationUtils.loadAnimation(this,R.anim.combination);
        button3.startAnimation(animation4);
    }
}
