#include "Item66Example.h"
#include <stdio.h>

JNIEXPORT void JNICALL Java_Item66Example_print
(JNIEnv *env, jobject obj, jint value){
    printf("In the native method, ");
    printf("Item66Example.print(iVal = %d\n)", value);
}