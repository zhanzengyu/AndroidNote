time=$(date "+%Y-%m-%d_%H:%M:%S")
echo '<---开始手机截图并拉取到本地桌面'
adb shell screencap -p /sdcard/screencap.png
adb pull /sdcard/screencap.png ~/Desktop/$time.png
echo '操作完成---->'
echo $time'.png 已经保存到本地桌面'
