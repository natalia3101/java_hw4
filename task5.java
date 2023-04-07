
import java.util.ArrayDeque;
import java.util.Deque;

//Дана строка содержащая только символы '(', ')', '{', '}', '[' и ']', определите,
// является ли входная строка логически правильной.
// Входная строка логически правильная, если:
// 1) Открытые скобки должны быть закрыты скобками того же типа.
// 2) Открытые скобки должны быть закрыты в правильном порядке. Каждая закрывающая скобка имеет соответствующую
// открытую скобку того же типа.
// ()[] = true
// () = true
// {[()]} = true
// ()() = true
// )()( = false



public class task5 {

    public static boolean brackets(String line){
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                deque.push(c);
            } else if(c == ')' && !deque.isEmpty() && deque.peek() == '('){
                deque.pop();
            } else if(c == '}' && !deque.isEmpty() && deque.peek() == '{'){
                deque.pop();
            } else if(c == ']' && !deque.isEmpty() && deque.peek() == '['){
                deque.pop();
            } else {
                return false;
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()[]";
        String s2 = "()";
        String s3 = "{[()]}";
        String s4 = "()()";
        String s5 = ")(()(";
        System.out.println(brackets(s1));
        System.out.println(brackets(s2));
        System.out.println(brackets(s3));
        System.out.println(brackets(s4));
        System.out.println(brackets(s5));
    }

}
