# AndroidFamily

### NumberPicker篇
- Q:如何设置只能滑动改变值，不能通过点击和键盘修改。  
  A:XML修改方法为
  >android:descendantFocusability="blocksDescendants" 
  
  代码中修改方法为
  >numberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);


### 异常篇
**Q**:如何解决Unsupported major.minor version 52.0问题？  

**A**:修改gradle命令的执行环境。一般命令行打包会出现这个问题。  
  
修改gradle.properties，  
  
添加org.gradle.java.home=/Applications/Android Studio.app/Contents/jre/jdk/Contents/Home  
  
参考  
  
[如何解决Unsupported major.minor version 52.0问题？](http://www.jianshu.com/p/5eebd3c609d6)
