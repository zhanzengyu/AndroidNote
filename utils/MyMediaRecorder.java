package com.zzy.soundrecorder;

import java.io.File;
import android.media.MediaRecorder;

/***
 * 此外，还有和MediaRecorder有关的几个参数与方法，我们一起来看一下： sampleRateInHz
 * :音频的采样频率，每秒钟能够采样的次数，采样率越高，音质越高。
 * 给出的实例是44100、22050、11025但不限于这几个参数。例如要采集低质量的音频就可以使用4000、8000等低采样率 channelConfig
 * ：声道设置：android支持双声道立体声和单声道。MONO单声道，STEREO立体声 recorder.stop();停止录音
 * recorder.reset(); 重置录音 ，会重置到setAudioSource这一步 recorder.release(); 解除对录音资源的占用
 */
public class MyMediaRecorder {
	MediaRecorder mMediaRecord;
	String mPath;
	long start;

	public MyMediaRecorder(String path) {
		mPath = path;
	}

	public boolean startRecord() {
		if (mMediaRecord != null) {
			mMediaRecord.release();
			mMediaRecord = null;
		}
		mMediaRecord = new MediaRecorder();
		// mediaRecorder.setAudioSource设置声音来源。
		// MediaRecorder.AudioSource这个内部类详细的介绍了声音来源。
		// 该类中有许多音频来源，不过最主要使用的还是手机上的麦克风，MediaRecorder.AudioSource.MIC
		mMediaRecord.setAudioSource(MediaRecorder.AudioSource.MIC);
		// mediaRecorder.setOutputFormat代表输出文件的格式。该语句必须在setAudioSource之后，在prepare之前。
		// OutputFormat内部类，定义了音频输出的格式，主要包含MPEG_4、THREE_GPP、RAW_AMR……等。
		mMediaRecord.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB);
		// mediaRecorder.setAddioEncoder()方法可以设置音频的编码
		// AudioEncoder内部类详细定义了两种编码：AudioEncoder.DEFAULT、AudioEncoder.AMR_NB
		mMediaRecord.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
		// 设置录音之后，保存音频文件的位置
		mMediaRecord.setOutputFile(mPath);
		// mMediaRecord.setAudioChannels(1);
		// mMediaRecord.setAudioSamplingRate(8000);
		// mMediaRecord.setAudioEncodingBitRate(64);
		// 调用start开始录音之前，一定要调用prepare方法。
		try {
			mMediaRecord.prepare();
			mMediaRecord.start();
			start = System.currentTimeMillis();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int stopRecord() {
		if (mMediaRecord != null) {
			try {
				mMediaRecord.stop();
				mMediaRecord.release();
				mMediaRecord = null;
				return (int) ((System.currentTimeMillis() - start)/1000);
			} catch (Exception e) {
				mMediaRecord = null;
			}
		}
		return -1;
	}

	public void discardRecord() {
		stopRecord();
		File file = new File(mPath);
		if (file != null && file.exists()) {
			file.delete();
		}
	}

}
