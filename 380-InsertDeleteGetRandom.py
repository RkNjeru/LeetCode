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
        Inserts a value to the set. Returns true if the set did not already contain
        the specified element.
        :type val: int
        :rtype: bool
        """
        if((val in self.myDict) != True):
            self.myArray.append(val)
            ## add value to back of array
            i = len(self.myArray) - 1
            ## position of value in array
            self.myDict[val] = i
            """for x in range(0, len(self.myArray)):
                print (self.myArray[x])j"""
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
            if(len(self.myArray) > 1):
                self.myArray[index] = self.myArray[len(self.myArray)-1]
                ##move lastValue to replace val that is going to be deleted
                del self.myDict[val] ##test independently for behavior
                ## remove val from Dictionary
                self.myArray = self.myArray[:-1] ##test independently for behavior
                ## reduce array size by 1
                ##print ("the index i'm trying to remove: ", index)
                if (index < len(self.myArray)):
                    self.myDict[self.myArray[index]] = index
                ## update value of old lastValue to its new position in the array
                
                
            elif(len(self.myArray) == 1):
                del self.myDict[val]
                self.myArray = self.myArray[:-1]                
                                
        else:
            return False
        """for x in range(0, len(self.myArray)):
                print (self.myArray[x])"""
        return True

    def getRandom(self):
        """
        Get a random element from the set.
        :rtype: int
        """

        if (len(self.myArray) != 0 ):
            return self.myArray[random.randint(0, (len(self.myArray)-1))]
        else:
            return -1
        
# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()

######### This code is used to run the script outside of LeetCode #########

def main():
    obj = RandomizedSet()
    print ("Enter input as follows: ")
    print ("'i 1' ----- to insert a 1")
    print ("'r' ---- to get a random number")
    print ("'rm 1' ---- to remove 1")
    print ("'done' ---- to exit ")
    userInput = ""

    while (True):
        userInput = input()
        if (userInput[0] == "i"):
            # do some stuff
            continue
        elif (userInput[0] == "r"):
            # do some stuff
            continue
        elif (userInput[0:1] == "rm"):
            # do some stuff
            continue
        elif (userInput == "done"):
            break
        else:
            print ("input was not valid. please try again")
            continue

main()

################ End of main #################################