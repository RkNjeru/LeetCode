import java.util.EmptyStackException;
import java.util.Stack;

// https://leetcode.com/problemset/top-amazon-questions/

class ParenSolution{

    public boolean isValid(String s){
        Stack myStack = new Stack();

        if (s.isEmpty()) {return true;}

        try{
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                    myStack.push(s.charAt(i));
                    continue;
                }
                else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']'){
                    // do something
                    if (s.charAt(i) == retOpposite(myStack.pop().toString().charAt(0))){
                        continue;
                    }
                    else { return false;}
                }
                else { return false;}
            }
    
            if(myStack.isEmpty() != true){
                return false;
            }
    
            return true;
        }
        catch(Exception e){
            return false;
        }
        

    }

    public char retOpposite(char anOpen){
        if (anOpen == '(') {return ')';}
        else if (anOpen == '{') { return '}';}
        else if (anOpen == '[') { return ']';}
        else return '_';
    }

    public static void main(String[] args){
        ParenSolution classObj = new ParenSolution();
        String test1 = "]()[";
        boolean ans1 = classObj.isValid(test1);
        System.out.println(ans1);

    }

}