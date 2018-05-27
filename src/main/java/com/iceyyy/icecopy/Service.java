package com.iceyyy.icecopy;

import java.io.File;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;

public class Service {

	public static void copy(String oldFolder, String newFolder) {
		oldFolder = oldFolder.replace("\\", "/");
		newFolder = newFolder.replace("\\", "/");
		File oldFile = new File(oldFolder);
		File newFile = new File(newFolder);
		copy(oldFolder, newFolder, oldFile, newFile, oldFolder, newFolder);
	}

	private static void copy(String oldFolder, String newFolder, File oldFile, File newFile, String baseOld,
			String baseNew) {
		if (oldFile.isDirectory()) {
			File[] listFiles = oldFile.listFiles();
			for (File file : listFiles) {
				File oldFileSub = file;
				String oldFolderSub = oldFileSub.getAbsolutePath();
				oldFolderSub = oldFolderSub.replace("\\", "/");
				String simple = StrUtil.removePrefix(oldFolderSub, baseOld);
				newFolder = baseNew + simple;
				File newFileSub = new File(newFolder);
				copy(oldFolderSub, newFolder, oldFileSub, newFileSub, baseOld, baseNew);
			}
		} else {
			FileUtil.copy(oldFile, newFile, true);
		}
	}

}
