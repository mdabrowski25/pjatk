cmake_minimum_required(VERSION 3.21)
include_directories("${PROJECT_SOURCE_DIR}/")
project(project)

set(CMAKE_CXX_STANDARD 17)

add_executable(project main.cpp game_controller.h pokemon.h special_attack.h game_controller.cpp pokemon.cpp special_attack.cpp)
