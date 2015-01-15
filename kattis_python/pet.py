from __future__ import print_function
import sys
__author__ = 'martinpettersson'

def handleInput():
    number_of_contestants = 5
    point_array = []
    for contestant in range(0, number_of_contestants):
        input_string = sys.stdin.readline().replace(" ", "").replace("\n", "")
        point_array.append(input_string)
    return map(int, point_array)

def sum_digits(n):
   r = 0
   while n:
       r, n = r + n % 10, n / 10
   return r

points = []
input_array = handleInput()
for point in input_array:
    points.append(sum_digits(point))
print(points.index(max(points))+1, max(points))
