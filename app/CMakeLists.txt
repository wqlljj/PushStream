
cmake_minimum_required(VERSION 3.4.1)
set(distribution_DIR ${CMAKE_SOURCE_DIR}/libs)
include_directories(
src/main/cpp/include
#头文件多的话可以继续往下加
)
add_library(
             JasonPushStream

             SHARED

             src/main/cpp/native-lib.cpp
             src/main/cpp/JasonPushStream.cpp
#             src/main/cpp/JasonPushStream_bak.c
             )

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

add_library( avcodec
            SHARED
            IMPORTED
            )
set_target_properties(
              avcodec
              PROPERTIES IMPORTED_LOCATION
              ${distribution_DIR}/${ANDROID_ABI}/libavcodec-56.so
              )
add_library( avdevice
            SHARED
            IMPORTED
            )
set_target_properties(
              avdevice
              PROPERTIES IMPORTED_LOCATION
             ${distribution_DIR}/${ANDROID_ABI}/libavdevice-56.so
              )
add_library( avfilter
            SHARED
            IMPORTED
            )
set_target_properties(
              avfilter
              PROPERTIES IMPORTED_LOCATION
              ${distribution_DIR}/${ANDROID_ABI}/libavfilter-5.so
              )
add_library( avformat
            SHARED
            IMPORTED
            )
set_target_properties(
              avformat
              PROPERTIES IMPORTED_LOCATION
              ${distribution_DIR}/${ANDROID_ABI}/libavformat-56.so
              )
add_library( avutil
            SHARED
            IMPORTED
            )
set_target_properties(
              avutil
              PROPERTIES IMPORTED_LOCATION
              ${distribution_DIR}/${ANDROID_ABI}/libavutil-54.so
              )
add_library( postproc
            SHARED
            IMPORTED
            )
set_target_properties(
              postproc
              PROPERTIES IMPORTED_LOCATION
             ${distribution_DIR}/${ANDROID_ABI}/libpostproc-53.so
              )
add_library( swresample
            SHARED
            IMPORTED
            )
set_target_properties(
              swresample
              PROPERTIES IMPORTED_LOCATION
              ${distribution_DIR}/${ANDROID_ABI}/libswresample-1.so
              )
# 把libfmod.so预加载进来
add_library( swscale
             SHARED
             IMPORTED)
set_target_properties( swscale
                       PROPERTIES IMPORTED_LOCATION
                       ${distribution_DIR}/${ANDROID_ABI}/libswscale-3.so)

target_link_libraries( # Specifies the target library.
                       JasonPushStream
                       avcodec
                       avdevice
                       avfilter
                       avformat
                       avutil
                       postproc
                       swresample
                       swscale

                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} )