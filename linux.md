# Linux


### vim 批量替换字符串

1.文件内全部替换

```
:%s#change_cotent_before#change_content_after#g
```

2.文件内局部替换：

把10行到50行内的“change_cotent_before”全部替换成“change_content_after”
```
:10,50s#change_cotent_before#change_content_after#g
```
以上命令如果在g后面再加上c，则会在替换之前显示提示符给用户确认（conform）是否需要替换。 比如
```
:%s#change_cotent_before#change_content_after#gc
```
### 我的电脑 alias 配置

```
alias gits='git status'
alias gitp='git pull'
alias cdd='cd ~/Desktop'
alias vi='vim'
alias vib='vi ~/.bash_profile'
alias sob='source ~/.bash_profile'
```

### 苹果电脑弹窗
```
osascript -e 'tell app "System Events" to display dialog "task finish"'
```

### 截屏
```
adb shell screencap -p /sdcard/screencap.png
```

### 录制视频
```
adb shell screenrecord /sdcard/screenrecord.mp4
```

更多截屏和录制视频查看[参考链接](https://blog.csdn.net/gdutxiaoxu/article/details/69802895)

### 获取手机当前显示的 Activity 名称
```
adb shell dumpsys window w | grep \\/ | grep name=
```
### 查找
- 递归查看当前目录下存在指定字符串的文件  
grep -rn '指定字符串' *
- 查看当前目录下指定文件名  
find . -name '文件名'

### 查看占用端口的程序
>lsof -i:8009

上面👆的8009指的是端口号


### Jekyll
Run: 
>bundle exec jekyll serve -w


### 拉取最新缓存

./gradlew build --refresh-dependencies 


### 去掉远程错误合并记录

**操作需谨慎。**  
**操作需谨慎。**  
**操作需谨慎。**  
建议新建一个 backup 分支，然后再操作。  
确保没问题之后，再删除 backup 分支。  
```
git reset --hard $lognum 
```
其中 **$lognum** 可以通过 **git log** 来查看要回退的具体记录。  
然后看到控制台回退成功之后。  
再执行下面命令：
```
git push --force  
```
受保护分支不能 push。  
需要先设置为非保护，然后 push 后再设置回来。  
另外设置回退过程要保证没有其他开发者对该回退分支做操作，否则可能会丢失其他开发提交的记录。

### git revert local commit
```
git reset HEAD~1
```

### git 分支重命名

**没有推送到远程，本地修改**

```
git branch -m oldName newName
```

**推送到远程，本地修改**

```
git branch -m oldName newName
git push --delete origin oldName
git push origin newName
git branch --set-upstream-to origin/newName
```

**git config**

```
git config --list
git config --global user.name xxx
git config --global user.email xxx@xxx.com
```

### git 删除本地分支并拉取远程最新代码

1. 切换到其他分支，然后删除本地分支  
git checkout 其他分支  
git branch -D 待删除分支

2. 重新拉取  
git fetch origin 待删除分支:待删除分支  
git fetch 仓库地址   
git fetch 仓库地址 待删除分支


### git 回退单个文件
1.进入到文件所在文件目录，或者能找到文件的路径

查看文件的修改记录

git log fileName

2.回退到指定版本

git reset ** fileName

3.提交到本地参考：  
git commit -m “提交的描述信息”

4.更新到工作目录  
git checkout fileName

5.提交到远程仓库  
git push origin 分支名
