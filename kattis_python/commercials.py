__author__ = 'martinpettersson'

def commercial_price():
    commercial = tuple(int(x.strip()) for x in raw_input().split(' '))
    return commercial

def listeners():
    listeners = list(int(x.strip()) for x in raw_input().split(' '))
    return listeners

def max_subarray(A, max_ending_here):
    max_so_far = max_ending_here
    for x in A:
        max_ending_here = max(0, max_ending_here + x)
        max_so_far = max(max_so_far, max_ending_here)
    return max_so_far

commercial_price = commercial_price()
listeners = listeners()
prices = []
for index in range(1, len(listeners)):
    prices.append(max_subarray(listeners, index) - (index * commercial_price[1]))
for x in prices:
    print x

print max(prices)
