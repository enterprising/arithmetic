#!/bin/bash
echo "Total parameter number is ==> $#"
echo "Your whole parameter is   ==> '$@'"
shift   # 进行第一次『一个变量的 shift 』
echo "Total parameter number is ==> $#"
echo "Your whole parameter is   ==> '$@'"
shift 3 # 进行第二次『三个变量的 shift 』
echo "Total parameter number is ==> $#"
echo "Your whole parameter is   ==> '$@'"
