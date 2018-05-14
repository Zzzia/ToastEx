# ToastEx

#### 让你的Toast动起来

#### 能轻松添加自己的动画，欢迎pr

<img src="https://github.com/Zzzia/ToastEx/blob/master/pic/toast.gif">

## 用法

##### 基础用法，默认有图标+动画

```java
ToastEx.error(context, "...").show();
ToastEx.success(context, "...").show();
ToastEx.info(context, "...").show();
ToastEx.warning(context, "...").show();
ToastEx.normal(context, "...").show();
```

##### 可以深度定制自己的动画

图标需要继承ToastImage，文字需要继承ToastText。重写ondraw方法即可，若需要设置颜色或动画时长，重写方法即可

```java
//自定义图标的方法
ToastEx.custom(context
	, "..."
	, Toast.LENGTH_SHORT//时间
	, ToastEx.NO_COLOR//背景颜色
	, toastImage)//自定义图标
    .show();

//自定义图标和文字的方法，若只需要自定义文字，图标传入null即可
ToastEx.custom(context
	, new CustomText(context)//自定义文字
    , Toast.LENGTH_SHORT
	, ToastEx.NO_COLOR
	, new InfoAnim(context))
    .show();

//获取颜色和动画时长
public void setDuration(int duration);
public void setColor(int color);
```

## 修改默认效果

在任意地方使用即可

```java
ToastEx.Config.getInstance()
    .setErrorColor(@ColorInt int errorColor) // optional
    .setInfoColor(@ColorInt int infoColor) // optional
    .setSuccessColor(@ColorInt int successColor) // optional
    .setWarningColor(@ColorInt int warningColor) // optional
    .setTextColor(@ColorInt int textColor) // optional
    .tintIcon(boolean tintIcon) // 是否显示图标
    .setUseAnim(boolean useAnim) //是否显示动画
    .setToastTypeface(@NonNull Typeface typeface) // optional
    .setTextSize(int sizeInSp) // optional
    .apply(); // 别忘使用这个方法
```

重置为默认效果

```java
ToastEx.Config.reset();
```

## 默认属性

```java
//一些颜色和字体常亮，使用ToastEx.SUCCESS_COLOR引用
public static int DEFAULT_TEXT_COLOR = Color.parseColor("#FFFFFF");
public static int ERROR_COLOR = Color.parseColor("#D50000");
public static int INFO_COLOR = Color.parseColor("#3F51B5");
public static int SUCCESS_COLOR = Color.parseColor("#388E3C");
public static int WARNING_COLOR = Color.parseColor("#FFA900");
public static int NORMAL_COLOR = Color.parseColor("#353A3E");//黑色背景
public static int NO_COLOR = 0;//默认背景，等同于#353A3E
public static int textSize = 16; // in SP

//已实现的图标动画类
SuccessAnim //对勾动画
ErrorAnim //错误动画
InfoAnim //圆圈加反感叹号
WarningAnim //圆圈加感叹号

//已实现的文字动画类
TextFadeAnim // 文字渐入动画，默认使用
```



# Thanks

参考了[Toasty](https://github.com/GrenderG/Toasty)