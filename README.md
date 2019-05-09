# AndroidFamily

- [实用工具类](#userful_utils)
- [有用博客收集](#userful_blog)
- [NumberPicker篇](#numberpicker)
- [View篇](#view)
- [异常篇](#exception)
- [调试篇](#debug)
- [线程篇](#thread)
- [compareTo](#compareTo)
- [将异常栈放到字符串](#StringWriter)
- [正负值相关](#positive_an_negative)
- [strings.xml](#strings)

<h3 id="userful_utils">实用工具类</h3>

[BaseRecyclerViewAdapter.java](https://github.com/nesger/AndroidNote/blob/master/utils/BaseRecyclerViewAdapter.java)

<h3 id="userful_blog">有用博客收集</h3>

[ItemDecoration in Android](https://proandroiddev.com/itemdecoration-in-android-e18a0692d848)


<h3 id="numberpicker">NumberPicker篇</h3>

**Q**:如何设置只能滑动改变值，不能通过点击和键盘修改。 

**A**:XML修改方法为
  >android:descendantFocusability="blocksDescendants" 
  
  代码中修改方法为
  >numberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);


<h3 id="view">View篇</h3>

**Q**:如何获取一个未展示的view的宽高？

**A**:使用MeasureSpec.makeMeasureSpec(0, MeasureSpec. UNSPECIFIED);
```
view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
```
[参考](https://stackoverflow.com/questions/15862052/get-the-measures-of-popup-window)

<h3 id="exception">异常篇</h3>

**Q**:如何解决Unsupported major.minor version 52.0问题？  

**A**:修改gradle命令的执行环境。一般命令行打包会出现这个问题。  
  
修改gradle.properties，  
  
添加org.gradle.java.home=/Applications/Android Studio.app/Contents/jre/jdk/Contents/Home  
  
参考  
  
[如何解决Unsupported major.minor version 52.0问题？](http://www.jianshu.com/p/5eebd3c609d6)

<h3 id="debug">调试篇</h3>

**Q**:android开发时如何无线连接手机？

**A**:  
虽然是无线连接，但是第一次还是需要USB滴～  

1. 将手机通过USB与电脑连接。

2. 在终端输入命令：adb tcpip 5555,会看到提示restarting in TCP mode port: 5555

3. 在终端输入命令：adb shell netcfg,在显示的信息中查找wlan0所在的行，会看到一串IP值xx.xx.xx.xx。

4. 在终端输入命令：adb connect xx.xx.xx.xx:5555

**原文可以点击下面链接传送**  
[博客地址](https://nesger.github.io//posts/android-wireless)  
[简书地址](http://www.jianshu.com/p/ce92c0ee132f)


<h3 id="thread">线程篇</h3>

**Q**:android 判断当前线程是不是主线程的几种方法?

**A**:  
方法一：
```
public boolean isMainThread() {
    return Looper.getMainLooper() == Looper.myLooper();
}
```
方法二：
```
public boolean isMainThread() {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
}
```
方法三：
```
public boolean isMainThread() {
    return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
}
```
[参考](http://blog.csdn.net/ddddwwww2/article/details/53521831)

<h3 id="compareTo">compareTo</h3>
compareTo的结果可以通过执行减法来得到。

结果取值-1，1，0


<h3 id="StringWriter">StringWriter</h3>

StringWriter sw = new StringWriter();  
PrintWriter pw = new PrintWriter(sw);  
e.printStackTrace(pw);  

sw.toString()



<h3 id="positive_an_negative">正负值相关</h3>

Android坐标，X轴往右值逐渐增大。Y轴往下值逐渐增大。

Android滑动，从左往右滑动mScrollX是负值。从上往下滑动mScrollY是负值。

第二个看起来似乎和第一个有点矛盾？如何记忆呢？

其实只要记住「力的作用是相互的」就行了。这样滑动得出的结果和原本的结果相反。

这样第二个和第一个就吻合了。

当然这只是一种记忆方式，实际的情况其实还是可以按照第一种方式理解的。

比如水平方向，由于mScrollX为View左边缘-View内容左边缘。而从左往右滑，View内容在View左边缘右边，因此mScrollX为负。

<h3 id="strings">strings.xml</h3>
字符串里面&应该写成&amp;
