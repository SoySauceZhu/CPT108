
def climbStair(n) :
    if n == 1: return 1
    if n == 2: return 2
    else:
        return climbStair(n-1) + climbStair(n-2)

def minCostClimbingStairsRecursive(cost_ls, num) :
    if (num == 1 or num == 2) : return cost_ls[0]
    else:
        return min(minCostClimbingStairsRecursive(cost_ls, num - 1) + cost_ls[num - 1], 
                   minCostClimbingStairsRecursive(cost_ls, num - 2) + cost_ls[num - 2])


def binarySearch(ls, target) :
    left, right = 0, len(ls)
    while (left < right) :
        mid = (right - left) // 2 + left
        num = ls[mid]
        if num == target:
            return mid
        elif num > target:
            right = mid
        elif num < target:
            left = mid
    return -1


if __name__ == "__main__":
    ls =  [2, 4, 5, 7, 10, 13]
    print(binarySearch(ls, 13))