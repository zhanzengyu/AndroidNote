# AndroidFamily

### NumberPicker篇
- Q:如何设置只能滑动改变值，不能通过点击和键盘修改。  
  A:XML修改方法为
  >android:descendantFocusability="blocksDescendants" 
  
  代码中修改方法为
  >numberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
