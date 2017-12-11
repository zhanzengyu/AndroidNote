# AndroidFamily

- [NumberPicker篇](#numberpicker)
- [View篇](#view)
- [异常篇](#exception)
- [调试篇](#debug)
- [线程篇](#thread)
- [compareTo](#compareTo)



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
