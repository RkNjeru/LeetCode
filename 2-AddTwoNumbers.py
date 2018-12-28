##You are given two non-empty linked lists representing two non-negative 
# integers. The digits are stored in reverse order and each of their 
# nodes contain a single digit. Add the two numbers and return it as a linked list.
##
##You may assume the two numbers do not contain any leading zero, 
# except the number 0 itself.
##
##Example:
##
##Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
##Output: 7 -> 0 -> 8
##Explanation: 342 + 465 = 807.


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        n1 = ""
        n2 = ""
        pTemp = l1
        while(pTemp != None):
            n1 = str(pTemp.val) + n1
            pTemp = pTemp.next

        pTemp = l2 
        while(pTemp != None):
            n2 = str(pTemp.val) + n2
            pTemp = pTemp.next

        num1 = int(n1)
        num2 = int(n2)

        sum = num1 + num2
        
        
        string1 = str(num1)
        string2 = str(num2)
        
        

    
    

        
