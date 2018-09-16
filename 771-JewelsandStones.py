## https://leetcode.com/problems/jewels-and-stones/description/

count = 0
for x in range(0, len(J)):
    for y in range(0, len(S)):
        if(J[x] == S[y]):
            ##print("s is: ", j[x], "j is: ", s[y])
            count +=1

return count


print ("Count: ", count)
