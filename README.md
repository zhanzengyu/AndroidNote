# AndroidNote

**问题解决方法见 [Issues](https://github.com/nesger/AndroidNote/issues)**

**实用技巧见 [Wiki](https://github.com/nesger/AndroidNote/wiki)**


- [View篇](#view)

<h3 id="view">View篇</h3>

**Q**:如何获取一个未展示的view的宽高？

**A**:使用MeasureSpec.makeMeasureSpec(0, MeasureSpec. UNSPECIFIED);
```
view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
```
[参考](https://stackoverflow.com/questions/15862052/get-the-measures-of-popup-window)
