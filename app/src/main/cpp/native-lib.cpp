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


// ---------- 希尔排序 start -----------
void swapInt(int *a, int *b) {
    int c = *a;
    *a = *b;
    *b = c;
};

void shell(int *data, unsigned int len) {
    if (len <= 1 || data == NULL) {
        return;
    }
    for (int div = len / 2; div >= 1; div = div / 2) {//定增量div，并不断减小
        for (int i = 0; i <= div; ++i) { //分组成div组
            for (int j = i; j < len - div; j += div) {//对每组进行插入排序
                for (int k = j; k < len; k += div) {
                    if (data[j] > data[k]) {
                        swapInt(data + j, data + k);//交换两个数的值
                    }
                }
            }
        }
    }
};
// ---------- 希尔排序 end -----------