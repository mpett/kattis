cmake_minimum_required(VERSION 2.8.4)
project(kattis_cpp)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES hello_world.cpp)
add_executable(kattis_cpp ${SOURCE_FILES})