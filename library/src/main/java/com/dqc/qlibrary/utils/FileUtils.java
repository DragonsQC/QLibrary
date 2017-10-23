package com.dqc.qlibrary.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;

/**
 * 文件相关工具类
 *
 * @author DragonsQC
 */
@SuppressWarnings("WeakerAccess,unused,UnusedReturnValue")
public class FileUtils {

    /**
     * 获取文件大小
     *
     * @param file File实例
     * @return long
     */
    public static long getFileSize(File file) {

        long size = 0;
        try {
            File[] fileList = file.listFiles();
            for (File aFileList : fileList) {
                if (aFileList.isDirectory()) {
                    size = size + getFileSize(aFileList);
                } else {
                    size = size + aFileList.length();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }

    /**
     * 删除文件，如果是文件夹则删除文件夹内所有文件
     *
     * @param file               指定文件夹
     * @param isDeleteRootFolder 是否删除根目录
     * @return boolean
     */
    public static boolean deleteFile(File file, boolean isDeleteRootFolder) {
        if (file == null || !file.exists()) {
            return false;
        }
        //如果是文件则直接删除
        if (file.isFile()) {
            return file.delete();
        }
        //如果是目录，则遍历目录，删除目录内文件
        for (File subfile : file.listFiles()) {
            if (subfile.isFile()) {
                //noinspection ResultOfMethodCallIgnored
                subfile.delete(); // 删除所有文件
            } else if (subfile.isDirectory()) {
                // 递规的方式删除文件夹
                deleteFile(subfile, true);
            }
        }
        if (isDeleteRootFolder) {
            //noinspection ResultOfMethodCallIgnored
            file.delete();// 删除目录本身
        }
        return true;
    }

    /**
     * 新建文件夹
     *
     * @param folderPath 文件夹路径
     * @return 是否创建
     */
    public static boolean newCreateFolder(String folderPath) {
        File file = new File(folderPath);
        return !file.exists() && file.mkdirs();
    }

    /**
     * 复制单个文件
     *
     * @param sourcePath 源文件路径
     * @param targetPath 目标文件路径
     */
    public static boolean copyFile(String sourcePath, String targetPath) {
        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);
        if (sourceFile.exists()) {
            return false;
        }
        try {
            // 新建文件输入流并对它进行缓冲
            FileInputStream     input  = new FileInputStream(sourceFile);
            BufferedInputStream inBuff = new BufferedInputStream(input);

            // 新建文件输出流并对它进行缓冲
            FileOutputStream     output  = new FileOutputStream(targetFile);
            BufferedOutputStream outBuff = new BufferedOutputStream(output);

            // 缓冲数组
            byte[] b = new byte[1024 * 5];
            int    len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            outBuff.flush();

            inBuff.close();
            outBuff.close();
            output.close();
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 格式化文件大小
     *
     * @param size 文件 length
     * @return 格式化后字符串
     */
    public static String formatFileSize(double size) {
        double kiloByte = size / 1024;
        if (kiloByte < 1) {
            return size + "Byte";
        }
        double megaByte = kiloByte / 1024;
        if (megaByte < 1) {
            BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
            return result1.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "KB";
        }

        double gigaByte = megaByte / 1024;
        if (gigaByte < 1) {
            BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
            return result2.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "MB";
        }

        double teraBytes = gigaByte / 1024;
        if (teraBytes < 1) {
            BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
            return result3.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "GB";
        }
        BigDecimal result4 = new BigDecimal(teraBytes);
        return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "TB";
    }

}