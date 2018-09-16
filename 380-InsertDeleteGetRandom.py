import random
class RandomizedSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.myDict = dict()
        self.myArray = []
        
        
        
        

    def insert(self, val):
        """
        Inserts a value to the set. Returns true if the set did not already contain the
        specified element.
        :type val: int
        :rtype: bool
        """
        if((val in self.myDict) != True):
            self.myArray.append(val)
            i = len(self.myArray) - 1
            self.myDict[val] = i
            return True
        else:
            return False
        

    def remove(self, val):
        """
        Removes a value from the set. Returns true if the set contained the specified
        element.
        :type val: int
        :rtype: bool
        """
        if(val in self.myDict):
            index = self.myDict[val] ## find index of value going to delete
            self.myArray[index] = self.myArray[len(self.myArray)-1] ## move last entry into value position
            del self.myDict[val] ## delete value from dictionary
            self.myDict[self.myArray[index]] = index ## update dictionary value of old last entry
            ## to reflect new index in the array
            self.myArray = self.myArray[:-1]
            return True
        else:
            return False
        

    def getRandom(self):
        """
        Get a random element from the set.
        :rtype: int
        """

        return self.myArray[random.randint(0, (len(self.myArray)-1))]
        
        


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
