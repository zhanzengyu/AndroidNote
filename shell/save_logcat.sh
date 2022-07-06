time=$(date "+%Y-%m-%d_%H:%M:%S")
cd ~/Desktop
adb logcat -c
echo '日志存入中......'
echo '请执行完需要的操作后按 ctrl+c 结束'
echo '然后到桌面查找 '$time'.txt 文件'
adb logcat >> $time.txt
