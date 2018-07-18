#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_example_ycl_structuredata_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "数据结构与算法复习（存于structure_data目录）";
    return env->NewStringUTF(hello.c_str());
}
