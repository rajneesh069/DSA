# Notes

## !!!Some important things!!!

### - Always use pen and paper and dry run it!

#### - `char to int conversion : char - '0'`

#### - `number of digits in a number(say, a) = (int)(Math.log(a)) + 1`

#### - Once you identify that the question is from a certain algo, stick to it and tweak it as per needs.

### Linear Search Recursion

Linear Search program in which the list has not been passed as an argument, it contains a very important concept that the function call returns finally to the place where it was called:

```java
static ArrayList<Integer> search(int[] arr, int target, int start) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (start == arr.length) {
            return list;
        }
        if (arr[start] == target) {
            list.add(start);
        }

        ArrayList<Integer> ansFromBelow = search(arr, target, ++start); // very clever line!
        list.addAll(ansFromBelow);

        return list;
    }
```

## Binary Search tid-bits

1. You find target when start = end = target.
2. Create an `ans` variable to store the potential answer.
3. To find the last occurence of a repeated element in a sorted array, use `start = mid+1` in the `else` statement to break the loop and make sure you're storing the answer in that only.
4. To find the first occurence, use `end = mid-1` to break the loop.
5. If asked for searching in a sorted array(or `if sorted array mentioned`) then `think of Binary Search.` Or the time complexity of O(log(N)) is required.

#### Following example illustrates those useful insights :

```java
    public class BSTidBits{
        public static void main(String[] args){

        }

        static int binarySearch(int[] arr, int target){
            int ans = -1;
            int start = 0;
            int end = arr.length-1;
            while(start<=end){
                int mid = start + (end - start)/2;
                if(arr[mid] < target){
                    start = mid+1;
                }else if(arr[mid] > target){
                    end = mid-1;
                }else{
                    start = mid+1;
                    //gives the last occurence of the repeated element, and of course
                    //helps in breaking the loop as start will exceed end.
                    ans = mid;
                }
            }
        }
    }

```

### Cyclic sort

1. Array contains elements from (1,n) or (0, n) then you can think of cyclic sort.
2. Could be the case that some element is missing in between the range, then also cyclic sort could be applied.

## Recursion

### Do not overthink. Overthink about recursion after solving the problem.

#### Function calls return finally to the place they were called.

##### !!! Important !!!

```java
public class Main{
    public static void main(String[] args){
        int ans = someFunction();
        System.out.println("ans: "+ans);
    }

    static int someFunction(){
        return 69;
    }
}
```

After execution of `someFunction()`, it'll return(69 here) to that line(`int a = someFunction()`) defined above and ans will be assigned the return value of `someFunction()`.

1. Identify if problem could be broken down into smaller problems.
2. Write recurrence relation if needed.
3. Draw the recursion tree.
4. About the tree :

   a. See the flow of the functions, and how they are called.

   b. Identify and focus on left tree calls (firstly left side will be evaluated (in fibo(n-1)+fibo(n-2), fibo(n-1) will be called first)) and right tree calls.

   c. Until the left tree call completes, right side won't be called.

   d. See how the values are returned 'at each step'!

   e. See where the function call comes out.

#### Types of recurrence relation

1. Linear: (fibo(n-1) + fibo(n-2))
2. Divide and Conquer (e.g. Binary Search) :
   f(n) = O(1) + f(n/2) -> Recurrence Relation for Binary Search, O(1) denotes some constant time comparison/operation and since the search space is reduced by a factor(of 2 here), it is very fast.

#### Variables in Recursion :

1. Arguments (updated value is passed from previous function to the current function) -> think about it
2. Return type -> easy to figure out
3. Body of the function (variable's value doesn't persist and is re-calculated each time) -> think about it

Here's the example of Binary Search :

This is the starting code, following code snippets will be updated to show the thinking process according to the points that follow through.

```java
public class BinarySearch{
    public static void main(String[] args){

    }

    //we'll return the index, so return type is int.
    static int search(int[] arr, int target){
    }
}

```

In the above code snippet we can clearly see that return type is easy to figure out. Now we'll try to think about the arguments, i.e., what arguments to pass and what should be their data type.

Now in the body of the function we'll need three varibles of `int` type which are : `start`, `end` and `mid`, and the next function call will require the `start` and `end` of the previous call hence we'll need to pass them in the arguments of the function as well (`mid` would be evaluated in the body itself, so needs not to be passed).

`Whatever you'll put in the arguments is going to go in the next function call, remember that!`

And since we want to divide the array in half(see the recurrence relation) then obviously we'll need the previous `end` and `start` and the only way to get it is : through arguments!

`mid` here is the variable which will be in the body of the function because it will be specific(based on `start` and `end`) for each function.

#### Whichever variable is needed in the future function calls pass them as arguments/parameters of the function and whichever are specific to a function call should be kept in the body.

```java
public class BinarySearch{
    public static void main(String[] args){

    }

    //start and end are required in the future function calls hence they are provided in the argument itself.
    static int search(int[] arr, int target, int start, int end){
        if(start > end){
            return -1;
        }

        int mid = start + (end - start) / 2; //body variable
        if(arr[mid] ==  target){
            return mid;
        }else if(target < arr[mid]){
            end = mid-1;
            search(arr, target, start, end); //function call made with updated end variable
        }else{
            start = mid+1;
            search(arr, target, start, end); //function call made with updated start variable
        }

    }
}

```

#### But there's an error in the above code, can you spot it?

### It is that whenever we call the function we don't return anything and `whenever you have a return type always return the function`.

##### Final code :

```java
public class BinarySearch{
    public static void main(String[] args){

    }

    //start and end are required in the future function calls hence they are provided in the argument itself.
    static int search(int[] arr, int target, int start, int end){
        if(start > end){
            return -1;
        }

        int mid = start + (end - start) / 2; //body variable
        if(arr[mid] ==  target){
            return mid;
        }else if(target < arr[mid]){
            end = mid-1;
           return search(arr, target, start, end);
           //function call made with updated end variable and added the return statement
        }else{
            start = mid+1;
           return search(arr, target, start, end);
           //function call made with updated start variable and added the return statement
        }

    }
}

```

## Time Complexity

### Time Complexity != Time Taken

#### It is actually how (in what fashion) the time increases as the input size increases.

1. Constants and less power terms are ignored(only degree terms are kept) while writing the function in the big O notation. We are not interested in actual time, but how does it grow when `dataset increases and becomes large`.
2. Always look for the worst case time complexity.

#### General trend : O(1) < O(log(n)) < O(n) < O(n<sup>2</sup>) < O(2<sup>n</sup>)

Other time complexities like `nlog(n)` exist too, we'll have to figure out the trend accordingly if asked to compare.
Exponential time complexity is the worst as even for the small amount of data the time grows exponentially.

#### Big-O notation gives the upper bound, i.e., the time complexity won't exceed the function inside it.

For example, O(N<sup>3</sup>) means that the algorithm could have time complexities of the order of 1, N<sup>2</sup>, NlogN, logN but shouldn't exceed N<sup>3</sup>.

f(N) = O(g(N))
lim (N -> inf) f(N)/g(N) < inf

#### Big-Omega gives the lower bound, i.e., the time complexity should be atleast the function inside it.

Opposite of Big-O

f(N) = O(g(N))
lim (N -> inf) f(N)/g(N) > 0

#### Theta Notation gives the upper and lower bound both, like if the upper and lower bound both are N<sup>2</sup> for an alogrithm then Theta(N<sup>2</sup>) will represent that.

Theta(N<sup>2</sup>)
inf > lim (N -> inf) f(N)/g(N) > 0

##### Little O Notation gives the loose upper bound, not strict like Big O.

Little O is the less than and Big O is less than or equal to.

#### Little omega gives the loose lower bound, not strict like Big Omega.

Little omega is less than and Big Omega is less than or equal to.

## Space Complexity

It is the `input` space and the `auxiliary` space. In interviews we can't do anything about the input space hence we care about `auxiliary` space.

### Recursive Algorithms

Space complexity = Height of the recursion tree, and remember that the interlinked function calls will be in the stack at the same time and NOT the unlinked ones!

For fibonacci, the space complexity is O(n).

Types of Recurrence relations :

1. Linear
2. Divide and Conquer

Recursions have recurrence relations, i.e., can be represented in the form of an equation.

#### Divide and Conquer Recurrence Relation :

##### Form : T(x) = a1*T(b1*x+e1*(x)) + a2*T(b2*x+e2*(x)) +....+ak*T(bk*x+ek\*(x)) + g(x);

For binary search : a1 = 1, b1 = 1/2, e1(x) = 0, g(x) = c

## Bitwise Operators and Bit Manipulation

1. n & (-n) gives us the position right most set bit.
2. XOR from 0 to a :
   1. a % 4 == 0 : a
   2. a % 4 == 1 : 1
   3. a % 4 == 2 : a + 1
   4. a % 4 == 3 : 0
3. bit ^ 1 = flipped bit
4. To find ith set bit in 'n', do (1<<(i-1)) & (n) : This is masking and is used at many places.

### AND(&)

1. If you do '&' operation with 1, then the bits remain same.
   1 & a = a

### XOR(^)

1. If you do '^' operation with 1, it gives the complement of that number.
2. a ^ a = 0
3. a ^ 0 = a

### Left shift operator(<<)

1. a<<1 = a*2 -> a << b = a * 2<sup>b</sup>(generally true unless there's an overflow).

   Multiplies by 2.

   Add 0 when you need an extra bit

   Eg. 1010 << 1 = 10100 which is 20 in decimal.

2. 1 << (n-1) = 1 \* 2<sup>(n-1)</sup>

### Right shift operator(>>)

1. a>>b = a/(2<sup>b</sup>), divides by 2.(always true)
   1010 >> 1 = 0101, which is 5 in decimal.

   Leading zeroes are ignored in every number system.

Examples :

1. a<sup>b</sup> in O(log(b)) time complexity using right shift operator

   ```java
   // O(log(b)) -> time complexity

    public static int pow(int base, int index) {
       int ans = 1;
       while (index != 0) {
           if ((index & 1) != 0) {
               ans = ans * base;
           }
           base *= base;
           index = index >> 1;
       }
       return ans;
   }
   ```

2. Find ith bit in a number
   Ans. Use masking.

   "110101, find the 3rd bit(from right obviously)

   110101 & (1<<2) = 1.

   1 << (n-1) -> and with this value, and here n = 3;

   0110101
   &000100

   This will give 1.

3. Set ith bit

   110101, set the 4th bit.

   OR it with the proper mask, i.e., (1<<3) OR 110101

4. Reset ith bit

   110101, reset the 5th bit.

   AND it with the complement of the mask, i.e., !(1<<4) & 110101

#### Time complexity of Sieve Of Eratostheneses = O(N\*log(logN))

## Modulo Properties

1. (a+b)%m = ((a%m) + (b%m))%m
2. (a-b)%m = ((a%m) - (b%m)+m)%m
3. (a\*b)%m = ((a%m)\*(b%m))%m
4. (a/b)%m = ((a%m)\*((b<sup>-1</sup>)%m))%m

   (b<sup>-1</sup>)%m is known as multiplicative modulo inverse.
   It also means that `b` and `m` are co-primes.

5. (a%m)%m = a % m
6. m<sup>x</sup> % m = 0, for all x > 0.
7. If p is a prime number which is not a divisor of b then ab<sup>p-1</sup>%p = a%p, due to Fermat's little theorem.

## GCD/HCF

Definition : HCF of 2 numbers(say, a and b) is the `minimum positive` value of the equation `ax+by`, where `x and y are integers`.

Whatever HCF you'll get will be `common`.

So, suppose 3x + 9y = 18, then the GCD of 3 and 9 will be 3 and will come out as `common`, so the equation reduces to x+3y = 6, i.e., 18 is divisible by 3. That gives us the solution to die-hard problem that yes using 3L and 9L bucket we can form 18L of water, because 3 came out as common and gave us an integer so combination of x and y will be there.

For, 2x+4y = 5 however, we can't do it, as 2 will be HCF and come out as common from the equation which won't divide 5 hence no combination of x and y will ever result in 5 as an answer.

If GCD is 1, then you can form any type RHS from the combination of x and y.

### Euclid's algorithm : gcd(a,b) = gcd(rem(b,a),a)

## LCM

Definition : Minimum number dvisible by both the numbers.

HCF \* LCM = Product of 2 numbers

## Linked List

A linked list is a linear data structure in which elements, known as nodes, are stored in a sequential manner. Each node contains two parts:

1. Data: The value or data stored in the node.
2. Reference (or Pointer): A reference or pointer to the next node in the sequence.

### Singly Linked List

```java
package linkedList;

public class SinglyLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        int[] array = { 1, 2, 3, 4, 5 };
        list.addRecursively(array);
        list.display();
    }

    private class Node {
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }

    }

    private Node head; // head is initially null
    private Node tail; // tail is initially null
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }

    public void add(int value) { // 18 -> 7
        Node newNode = new Node(value);
        this.size += 1;
        if (head == null) {
            head = newNode;
            tail = head;
            return; // neat way of initializing the first node
        }
        tail.next = newNode;
        tail = newNode;

    }

    public void add(int value, int index) {
        Node node = new Node(value);
        Node temp = head;
        this.size++;
        if (index == 0) {
            node.next = head;
            head = node;
            return;
        }

        else if (index == size) {
            tail.next = node;
            tail = node;
            return;
        }
        for (int i = 0; i < index; i++) {
            if (i == index - 1) {
                Node preserveNextNode = temp.next;
                temp.next = node;
                node.next = preserveNextNode;
                break;
            }
            temp = temp.next;
        }
    }

    public void delete(int index) {
        this.size--;
        if (index == 0) {
            head = head.next;
            return;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            if (i == index - 1) {
                Node node = temp.next;
                temp.next = node.next;
                return;
            }
            temp = temp.next;
        }
        if (head == null) {
            tail = null;
        }
    }

    public Node nodeAtIndex(int index) { // a utility function for getting node at a particular index
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void insertFirst(int value) {
        Node newNode = new Node(value);
        this.size += 1;
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
    }

    public Node find(int value) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value == value) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END\n");
        System.out.println("Size: " + this.size);
    }

    // add using recursion
    public void addRecursively(int[] array) {
        for (int i = 0; i < array.length; i++) {
            head = addRecursively(head, array[i]);
        }
    }

    private Node addRecursively(Node node, int value) {
        if (node == null) {
            Node newNode = new Node(value);
            newNode.next = null;
            this.size++;
            return newNode;
        }

        node.next = addRecursively(node.next, value);
        tail = node;
        return node;
    }

    // insert with recursion
    public void insert(int value, int index) {
        head = insert(head, value, index);
    }

    private Node insert(Node node, int value, int index) {
        if (index == 0) {
            Node newNode = new Node(value);
            newNode.next = node.next;
            this.size++;
            return newNode;
        }
        node.next = insert(node.next, value, index - 1);
        return node;
    }

}
```

### Doubly Linked List

```java
package linkedList;

public class DoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(0, 0);
        list.add(1);
        list.display();
    }

    private class Node {
        private int value;
        private Node next = null;
        private Node previous = null;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        this.size++;
        if (head == null) { // for the first node, we don't need to update the head ever
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.previous = tail;
        tail.next = newNode;
        tail = newNode;
    }

    public void insertFirst(int value) {
        Node newNode = new Node(value);
        this.size++;
        if (tail == null) { // for the first node, we don't need to update the tail ever again
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.next = head;
        head.previous = newNode;
        head = newNode;

    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL\n");
        System.out.println("Size: " + this.size);
        return;
    }

    public void displayInverted() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.previous;
        }
        System.out.print("NULL\n");
        System.out.println("Size: " + this.size);
    }

    public Node getNodeAtIndex(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Cannot be deleted. Index out of bounds.");
            return;
        }

        this.size--; // size is at least 1
        Node nodeToBeDeleted = getNodeAtIndex(index);

        if (nodeToBeDeleted == head) {
            if (head.next != null) { // head.next will be null if there's only one element
                head = head.next;
                head.previous = null;
            } else {
                head = null;
                tail = null;
            }
            return;
        } else if (nodeToBeDeleted == tail) {
            if (tail.previous != null) {
                tail = tail.previous;
                tail.next = null;
            } else { // tail.previous will be null if and only there's one element
                head = null;
                tail = null;
            }
            return;
        }

        nodeToBeDeleted.previous.next = nodeToBeDeleted.next;
        nodeToBeDeleted.next.previous = nodeToBeDeleted.previous;
    }

    public void insert(int value, int index) {
        if (index < 0) {
            System.out.println("Index out of bounds.");
            return;
        }
        Node newNode = new Node(value);
        Node nodeAtThatIndex = getNodeAtIndex(index);
        if (nodeAtThatIndex != null && nodeAtThatIndex == head) {
            this.size++;
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
            head.previous = null;
        } else if (nodeAtThatIndex != null && nodeAtThatIndex != tail) {
            this.size++;
            newNode.previous = nodeAtThatIndex;
            newNode.next = nodeAtThatIndex.next;
            nodeAtThatIndex.next.previous = newNode;
            nodeAtThatIndex.next = newNode;
        } else {
            this.add(value);
            return;
        }
    }

}

```

### Circular Linked List

- Demonstrates the implementation without tail and how to traverse through the list.

```java
package javaPlayground;

public class j8 {
    public static void main(String[] args) {
        j8 CLL = new j8();
        for (int i = 0; i < 10; i++) {
            CLL.add(i);
        }
        CLL.display();
        CLL.insertAfter(9, 33);
        CLL.display();
    }

    private class Node {
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }
    }

    private int size;
    private Node head;

    /*
     * To reach the node just before the head
     * Node temp = head;
     * do{
     * temp = temp.next;
     * }while(temp.next!=head);
     * Now temp, just before head and obviously since temp.next == head, hence for
     * that last node the do{} block won't run obviously.
     */

    public void add(int value) {
        if (head == null) {
            Node headNode = new Node(value);
            head = headNode;
            headNode.next = head;
            this.size++;
            return;
        }

        Node newNode = new Node(value);
        Node temp = head;
        do {
            temp = temp.next;
        } while (temp.next != head);
        temp.next = newNode;
        newNode.next = head;
        this.size++;
        return;
    }

    public void insertFirst(int value) {
        if (head == null) {
            Node headNode = new Node(value);
            head = headNode;
            headNode.next = head;
            this.size++;
            return;
        }

        Node temp = head;
        Node newNode = new Node(value);
        newNode.next = head;

        do {
            temp = temp.next;
        } while (temp.next != head);

        temp.next = newNode;
        head = newNode;
        this.size++;
    }

    public void insertAfter(int index, int value) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds, cannot insert.");
            return;
        } else if (index == size - 1) {
            this.add(value);
            this.size++;
        } else {
            Node newNode = new Node(value);
            Node temp = head;
            int i = 0;
            do {
                temp = temp.next;
                i++;
            } while (temp.next != head && i < index);
            newNode.next = temp.next;
            temp.next = newNode;
            this.size++;
            return;
        }
    }

    public void display() {
        display(head);
    }

    private void display(Node node) {
        if (node == null) {
            System.out.println("Linked list is empty.");
            return;
        }

        Node temp = node;
        do {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        } while (temp != head); // keep this in mind, we have to go till head
        System.out.print("HEAD\n");
        System.out.println("Size: " + size);
    }

}

```

## Stack

A stack is a linear data structure that follows the Last In, First Out (LIFO) principle. This means that the last element added to the stack will be the first one to be removed. Stacks are used in various applications such as expression evaluation, function call management in recursion, and backtracking algorithms.

Key Operations:

1. Push: Add an element to the top of the stack.
2. Pop: Remove and return the top element from the stack.
3. Peek (or Top): Return the top element without removing it.
4. isEmpty: Check if the stack is empty.
5. Size: Get the number of elements in the stack.

### Custom Stack

```java
package stackAndQueues;
public class Stack {
    public static void main(String[] args) {
        Stack stack = new Stack(15);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 10; i++) {
            int val = stack.pop();
            System.out.println(val);
        }
    }

    private int[] data;
    private int top = -1;
    private static final int DEFAULT_SIZE = 10;

    public Stack() {
        // data = new int[DEFAULT_SIZE];
        this(DEFAULT_SIZE); // calls the appropriate constructor
    }

    public Stack(int size) {
        data = new int[size];
    }

    public boolean push(int value) {
        if (isFull()) {
            System.out.println("Cannot add to a full stack.");
            return false;
        }
        data[++this.top] = value;
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Cannot remove from an empty stack.");
            return -1;
        }
        return data[this.top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Cannot peek in an empty stack.");
            return -1;
        }
        return data[top];
    }

    private boolean isFull() {
        return top == data.length - 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

}

```

### Dynamic Stack

```java
package stackAndQueues;

public class DynamicStack {
    public static void main(String[] args) {
        DynamicStack stack = new DynamicStack();
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }
        System.out.println(stack.peek());

    }

    private int top = -1;
    private static final int DEFAULT_SIZE = 10;
    private int[] data;

    public DynamicStack() {
        this.data = new int[DEFAULT_SIZE];
    }

    public boolean push(int value) {
        if (isFull()) {
            resize();
        }
        data[++this.top] = value;
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Cannot pop from an empty stack.");
            return -1;
        }
        return data[top--];
    }

    public int peek() {
        return data[top];
    }

    private boolean isFull() {
        return top == data.length - 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private void resize() {
        int[] temp = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        this.data = temp; // very important line
    }

}

```

## Queue

Definition of Queue
A queue is a linear data structure that follows the First In, First Out (FIFO) principle. This means that the first element added to the queue will be the first one to be removed. Queues are used in various applications such as task scheduling, handling requests in a server, and breadth-first search (BFS) in graphs.

Key Operations:

1. Enqueue (or Offer): Add an element to the end of the queue.
2. Dequeue (or Poll): Remove and return the front element from the queue.
3. Peek (or Front): Return the front element without removing it.
4. isEmpty: Check if the queue is empty.
5. Size: Get the number of elements in the queue.

### Queue Methods

| Method       | Action                     | Empty Queue Behavior            | Exception Thrown         |
| ------------ | -------------------------- | ------------------------------- | ------------------------ |
| `add(E e)`   | Inserts element            | Throws `IllegalStateException`  | `IllegalStateException`  |
| `offer(E e)` | Inserts element            | Returns `false`                 | None                     |
| `peek()`     | Retrieves head (no remove) | Returns `null`                  | None                     |
| `element()`  | Retrieves head (no remove) | Throws `NoSuchElementException` | `NoSuchElementException` |
| `poll()`     | Retrieves and removes head | Returns `null`                  | None                     |
| `remove()`   | Retrieves and removes head | Throws `NoSuchElementException` | `NoSuchElementException` |

```java
package stackAndQueues;

public class Queue {
    public static void main(String[] args) {
        Queue queue = new Queue();
        for (int i = 0; i < 15; i++) {
            queue.add(i);
        }
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }

    private int[] data;
    private int first = 0;
    private int current = -1;
    private static final int DEFAULT_SIZE = 10;

    public Queue() {
        this(DEFAULT_SIZE);
    }

    public Queue(int size) {
        this.data = new int[size];
    }

    public boolean add(int value) {
        if (isFull()) {
            System.out.println("Cannot add to a full queue.");
            return false;
        }
        data[++this.current] = value;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Cannot remove from an empty queue.");
            return -1;
        }
        return data[this.first++];
    }

    private boolean isFull() {
        return this.current == data.length - 1;
    }

    private boolean isEmpty() {
        return this.current == -1;
    }

}

```

### Queue with One Pointer

```java
package stackAndQueues;


public class QueueWithOnePointer {
    public static void main(String[] args) {
        QueueWithOnePointer queue = new QueueWithOnePointer();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        queue.remove();
        queue.remove();
        queue.display();
    }

    private int ptr = -1;
    private int[] data;
    private static final int DEFAULT_SIZE = 10;

    public QueueWithOnePointer() {
        this(DEFAULT_SIZE);
    }

    public QueueWithOnePointer(int size) {
        this.data = new int[size];
    }

    public boolean add(int value) {
        if (isFull()) {
            System.out.println("Cannot add to a full queue.");
            return false;
        }
        data[++ptr] = value;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Cannot remove from an empty queue.");
            return -1;
        }
        int deletedValue = data[0];
        for (int i = 0; i < data.length - 1; i++) { // left shifting the array by 1
            data[i] = data[i + 1];
        }
        this.ptr--;
        return deletedValue;
    }

    public void display() {
        for (int i = 0; i <= ptr; i++) {
            System.out.print(data[i] + " <-\s");
        }
        System.out.print("END");
    }

    private boolean isEmpty() {
        return ptr == -1;
    }

    private boolean isFull() {
        return ptr == data.length - 1;
    }
}
```

### Dynamic Queue

```java
package stackAndQueues;

public class DynamicQueue {
    public static void main(String[] args) {
        DynamicQueue queue = new DynamicQueue();

        queue.add(1);
        queue.add(2);
        queue.display();

        queue.remove();
        queue.display();
    }

    private int[] data;
    private int first = 0;
    private int last = 0;
    private int size = 0;
    private static final int DEFAULT_SIZE = 10;

    public DynamicQueue() {
        this(DEFAULT_SIZE);
    }

    public DynamicQueue(int initialSize) {
        this.data = new int[initialSize];
    }

    private boolean isFull() {
        return size == data.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean resize() {
        int[] temp = new int[2 * data.length];
        for (int i = first; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
        return true;
    }

    public boolean add(int value) {
        if (isFull()) {
            resize();
        }
        data[this.last] = value;
        last = last + 1;
        this.size++;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Cannot remove from an empty queue.");
            return -1;
        }

        int value = data[this.first];
        first = first + 1;
        this.size--;
        return value;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        for (int i = first; i < last; i++) {
            System.out.print(data[i] + " -> ");
        }
        System.out.print("END\n");
    }

```

## Circular Queue

```java
package stackAndQueues;

public class CircularQueue {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        queue.remove();
        queue.add(99);
        queue.display();
        // for (int i = 0; i < 10; i++) {
        // System.out.println(queue.remove());
        // }
    }

    private int first = 0;
    private int last = 0;
    private int[] data;
    private int size;
    private final static int DEFAULT_SIZE = 10;

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    public boolean add(int value) {
        if (isFull()) {
            System.out.println("Cannot add to a full circular queue.");
            return false;
        }
        data[last] = value;
        this.last = this.last + 1;
        this.last = (this.last) % data.length;
        this.size++;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Cannot remove from an empty circular queue.");
            return -1;
        }
        int value = data[this.first];
        this.first = this.first + 1;
        this.first = (this.first) % data.length;
        this.size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Cannot peek in an empty circular queue.");
            return -1;
        }
        return data[first];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        int i = first;
        do {
            System.out.print(data[i] + " -> ");
            i = (i + 1) % data.length;
        } while (i != last);
        System.out.print("END");
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == data.length;
    }
}
```

### Dynamic Circular Queue

```java
package stackAndQueues;

public class DynamicCircularQueue {
    public static void main(String[] args) {
        DynamicCircularQueue queue = new DynamicCircularQueue();
        for (int i = 0; i < 20; i++) {
            queue.add(i);
        }
        queue.remove();
        queue.display();
    }

    private int[] data;
    private int size;
    private int first;
    private int last;
    private final static int DEFAULT_SIZE = 10;

    public DynamicCircularQueue() {
        this(DEFAULT_SIZE);
    }

    public DynamicCircularQueue(int initialSize) {
        this.data = new int[initialSize];
    }

    private boolean resize() {
        int[] temp = new int[data.length * 2];
        int i = 0;
        do {
            temp[i] = data[(first + i) % data.length];
            ++i;
        } while (i != data.length);
        first = 0;
        last = data.length;
        data = temp;
        return true;
    }

    private boolean isFull() {
        return size == data.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public boolean add(int value) {
        if (isFull()) {
            resize();
        }
        data[last] = value;
        last = (last + 1) % data.length;
        this.size++;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Cannot remove from an empty queue.");
            return -1;
        }

        int value = data[first];
        first = (first + 1) % data.length;
        this.size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Cannot peak in an empty queue.");
            return -1;
        }
        return data[first];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        int i = first;
        do {
            System.out.print(data[i] + " -> ");
            i = (i + 1) % data.length;
        } while (i != last);
        System.out.print("END");
    }
}

```

## Trees

1. It consists of nodes. In case of a binary tree, they are atmost 2 in number.
2. Nodes &rarr; root , internal, leaf.
3. Leaf : They have no children.
4. Root : Topmost node is root.
5. Internal : Nodes with atleast 1 child.
6. `Height of a tree =  Max(height(leftSubtree), height(rightSubtree)).`
7. `Height of a node is Max number of edges from that node to the leaf node.`
8. Level of a node = Height of root - Height of the node.

#### `Time complexity while inserting, removing or traversing a binary tree(balanced) is O(log(N)).`

```java
import java.util.Scanner;

public class BinaryTree {
    private Node root; // intially null

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

    }

    public void populate(Scanner scanner) {
        System.out.println("Input the value of root node: ");
        root = new Node(scanner.nextInt());
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.print("Do you want to add a left node to  " + node.value + ": ");
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.print("Enter the value of the left node: ");
            int val = scanner.nextInt();
            node.left = new Node(val);
            populate(scanner, node.left);
        }

        System.out.print("Do you want to add a right node to " + node.value + ": ");
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.print("Enter the value of the right node: ");
            int val = scanner.nextInt();
            node.right = new Node(val);
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(this.root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, "\t");
        display(node.right, "\t");
    }

}

```

### Calculating height of a node in a binary tree

```java
package binaryTrees;

@SuppressWarnings("unused")
public class HeightOfANode {
    private class Node {
        private int value;
        private Node left;
        private Node right;
    }

    private Node root;

    private int height(Node node) {
        if (node == null) {
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        return Math.max(left, right) + 1;

    }
}

```

### Finding a Node in a binary tree

```java
private Node findNode(Node root, Node node, int x) {

        if (root == node) {
            return node;
        }

        if (node == null) {
            return null;
        }

        if (node.value == x) {
            return node;
        }

        Node left = findNode(root, node.left, x);
        if (left != null) {
            return left;
        }
        return findNode(root, node.right, x);

    }
```

### Finding level of a node in a binary tree

```java
package binaryTrees;

@SuppressWarnings("unused")
public class LevelOfNodes {
    // We'll find the level of nodes.
    private class Node {
        private int value;
        private Node left;
        private Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    private int findLevel(Node node, Node x, int level) {
        if (root == null) {
            return -1;
        }

        if (node == null) {
            return 0;
        }

        if (node == x) {
            return level;
        }

        int left = findLevel(node.left, x, level + 1);
        if (left != 0) {
            return left;
        }
        return findLevel(node.right, x, level + 1);

    }
}

```

## Traversal Methods in [Depth First Search](#depth-first-search)

#### The traversal methods are for Binary Trees in general.

#### Pre-order : N &rarr; L &rarr; R

- Can be seen as "top-to bottom"
- Used for evaluating mathematical expressions or making a copy.
- Convert string/array in a Binary Tree or serialize data.

```java
private void preOrder(Node node){
    if(node==null){
        return;
    }

    System.out.println(node.value +"\s");
    preOrder(node.left);
    preOrder(node.right);
}
```

#### In-order : L &rarr; N &rarr; R

- For sorted order traversal in a Binary Tree, we can use this.

```java
private void inOrder(Node node){
    if(node==null){
        return;
    }

    inOrder(node.left);
    System.out.println(node.value +"\s");
    inOrder(node.right);
}
```

#### Post-order : L &rarr; R &rarr; N

- Can be seen as "bottom-to-top"
- To delete something from the Binary Tree.
- When we perform bottom-up calculation(like calculating the height or diameter of a tree), then we can use it.

```java
private void postOrder(Node node){
    if(node==null){
        return;
    }

    postOrder(node.left);
    postOrder(node.right);
    System.out.println(node.value +"\s");
}
```

## Binary Search Trees

- The left child node always contains value less than the parent node.
- The right child node always contains value greater than the parent node.
- BSTs are helpful while traversing, inserting or removing elements as they follow above constraints and have a time complexity of O(log(N)).

### What are Balanced Binary Search Trees?

#### Height(Left Subtree) - Height(Right Subtree) <=1.

### Why Balanced Binary Search Trees?

#### Because, in unbalanced the time complexity of worst case rises upto O(N).

```java
public class BST {
    public BST() {

    }

    private Node root;

    private class Node {
        private int value;
        private int height;
        private Node right;
        private Node left;

        public Node(int value) {
            this.value = value;
        }

    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        }

        else if (value > node.value) {
            node.right = insert(node.right, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;

    }

    public void display() {
        display(root, "Root Value is : ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left node value of " + node.value + " is: ");
        display(node.right, "Right node value of " + node.value + " is: ");
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    public void populateSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid + 1, end);

    }

}

```

Some self balancing binary search trees are : AVL trees, Red Black Tree etc.

## AVL tree

1. Insert the node normally.
2. From `bottom-up` check for the unbalanced node(p).
3. Then according to the following `4 cases`, rotate the tree while leaving the balanced part of the tree.

- `Time Complexity  : O(log(N))`

- Parent unbalanced Node : p
- Child Node : c
- Node which is displaced : t

1. Left Rotate :

```java
private Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        c.right = t;
        p.left = c;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return p;
    }
```

2. Right Rotate :

```java
private Node rightRotate(Node p) {

        Node c = p.left;
        Node t = c.left;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }

```

- Case 1 : Left - Left : Right rotate the unbalanced node(p).
- Case 2 : Left - Right : Left rotate the child node(c) of the unbalanced node(p) and then right rotate the unbalanced node(p).
- Case 3 : Right - Right : Left rotate the unbalanced node(p).
- Case 4 : Right - Left : Right rotate the child node(c) of the unbalanced node(p) and then left rotate the unbalanced node(p).

### Code of AVL Tree

```java
public class AVL {
    private class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }

        return node.height;
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value > node.value) {
            node.right = insert(node.right, value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return rotate(node);

    }

    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            // left heavy
            if (height(node.left.left) - height(node.left.right) > 0) {
                // left-left case
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {
                // left-right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (height(node.left) - height(node.right) < -1) {
            // right heavy
            if (height(node.right.left) - height(node.right.right) < 0) {
                // right-right
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0) {
                // right-left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        c.right = t;
        p.left = c;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return p;
    }

    private Node rightRotate(Node p) {

        Node c = p.left;
        Node t = c.left;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }

    public void populate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
    }

    public void display() {
        display("Root node is : ", root);
    }

    private void display(String details, Node node) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display("Left child of " + node.value + " is : ", node.left);
        display("Right child of " + node.value + " is : ", node.right);
    }
}
```

## Segment Trees : Perform query(sum, average, product, max, min, etc.) in a range(in an array).

- Not a BST.
- Disadvantage : Extra Space.
- Time Complexity : O(log(n))
- It is a full binary tree, every node has 2 children except leaf nodes.
- Leaf nodes = n-1. Internal Nodes = n. Total Nodes = 2n-1.

#### Update function is also of O(log(n)) time.

#### The traversal methods are for Binary Trees in general.

## Breadth First Search or Level Order Traversal

- Iterative approach is more intuitive in this case.
- When you've reached at the end of a level, the whole next level is already in the queue.
- Or it can be said that when you remove a node it's children of the next level are already inside the queue.

```java
package binaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    private class TreeNode {
        private int value;
        private int height;
        private TreeNode left;
        private TreeNode right;

        private TreeNode(int value) {
            this.value = value;
        }
    }

    private TreeNode root;

    private List<List<Integer>> BFSTraversal() {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>(); // to maintain the order of the nodes that needs to be explored and
        // keep track of current level nodes to be processed.
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevelList = new ArrayList<Integer>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelList.add(currentNode.value);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                // at this point the next level children of the node which was polled
                // is already in the queue.
            }
            result.add(currentLevelList);
        }

        return result;
    }

}

```

### Finding if the nodes are siblings

```java
package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")

public class IsSibling {
    // We'll find if the nodes of a binary tree are siblings.

    private class Node {
        private int value;
        private Node left;
        private Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    private boolean isSibling(Node root, int x, int y) {

        if (root == null) {
            return false;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        boolean foundX = false;
        boolean foundY = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                // in each iteration, we are looking at the node itself
                foundX = false;
                foundY = false;
                Node currentNode = queue.poll();

                // Sibling check
                if (currentNode.left != null && currentNode.right != null) {
                    if ((currentNode.left.value == x && currentNode.right.value == y) ||
                            (currentNode.left.value == y && currentNode.right.value == x)) {
                        return true;
                    }
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

            }
        }
        return false;
    }
}

```

### Finding a node using BFS

```java
    private class Node {
        private int value;
        private Node left;
        private Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    private Node findNodeByValue(Node root, int val) {
        if (root == null) {
            return null;
        }

        if (root.value == val) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                if (currentNode.value == val) {
                    return currentNode;
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return null;
    }

    private Node findNode(Node root, Node target) {
        if (root == null) {
            return null;
        }

        if (root == target) {
            return target;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                if (currentNode == target) {
                    return target;
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return null;
    }
```

#### Tips related to BFS questions

- While solving BFS questions, you should `consider deque` if you need to traverse the tree in left to right and then right to left manner, basically, deque shouldn't be out of picture.

```java
package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("unused")
public class $103_BinaryTreeZigZagLevelOrderTraversal {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root); // left to right once done
        boolean reverse = true;

        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> currentLevelList = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                if (reverse) {
                    TreeNode currentNode = deque.removeLast();
                    currentLevelList.add(currentNode.val);
                    if (currentNode.left != null) {
                        deque.addFirst(currentNode.left);
                    }

                    if (currentNode.right != null) {
                        deque.addFirst(currentNode.right);
                    }
                } else {
                    TreeNode currentNode = deque.removeFirst();
                    currentLevelList.add(currentNode.val);
                    if (currentNode.right != null) {
                        deque.addLast(currentNode.right);
                    }

                    if (currentNode.left != null) {
                        deque.addLast(currentNode.left);
                    }
                }

            }
            result.add(currentLevelList);
            if (reverse == true) {
                reverse = false;
            } else {
                reverse = true;
            }
        }

        return result;
    }
}

```

- Depending on the question, you might need to change the way how nodes are stored, don't just stick to the original order, improvise if need be, like in the case of symmetric trees.

```java
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class $101_SymmetricTree {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            // here we can see the elements are stored differently in the queue
            // as per requirements
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);

        }

        return true;
    }
}

```

## Depth First Search

- The more intuitive approach is recursion in this algorithm.
- The methods (Pre-order, In-Order and Post-order) have been described [above](#traversal-methods-in-depth-first-search).

Some Tid-bits regarding those methods:-

- Do something at that level and then move down : Use Pre-Order Traversal (N &rarr; L &rarr; R)

- To get the leftmost(smallest value in BST) value in a tree, we can use In-Order Traversal (L &rarr; N &rarr; R)

- Perform some operations on the root at the last, e.g. to delete a tree, we'll have to delete all the left nodes first then the right nodes and then the root node, therefore we'll use Post-Order Traversal (L &rarr; R &rarr; N).

- Always use queue or stack when you want to store the node to perform an operation later.
  (Like flattening a binary tree into a linked list where the left pointers need to be null
  and right ones need to point to the next node)

#### Diameter of a binary tree

```java
public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter - 1; // we have calculated node wise
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, dia); // diameter is the max value of dia of each individual tree

        return Math.max(leftHeight, rightHeight) + 1;
    }
```

### Invert a binary tree

```java
package leetcode;

public class $226_InvertBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode invertTree(TreeNode node) {
        if (node == null) {
            return node;
        }

        if (node.left == null && node.right == null) {
            return node;
        }

        invertTree(node.left);
        invertTree(node.right);
        return swap(node);
    }

    private TreeNode swap(TreeNode x) {
        TreeNode temp = x.left;
        x.left = x.right;
        x.right = temp;
        return x;
    }
}

```

### Traversing from one node to another in a binary tree and printing the path

```java
package leetcode;

public class $2096_StepByStepDirectionsFromABinaryTreeNodeToAnother {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    StringBuilder s = new StringBuilder(""), d = new StringBuilder("");

    public String getDirections(TreeNode root, int startValue, int destValue) {
        traverse(root, startValue, s); // s -> start
        traverse(root, destValue, d); // d -> destination
        int i = 0;
        // Find the common path prefix length
        while (i < s.length() && i < d.length() && s.charAt(i) == d.charAt(i)) {
            i++;
        }

        // Number of steps to move up from the start node to the common ancestor
        StringBuilder finalPath = new StringBuilder();
        for (int j = i; j < s.length(); j++) {
            finalPath.append('U');
        }

        // Append remaining path to the destination node
        finalPath.append(d.substring(i));

        return finalPath.toString();
    }

    // Main thing here is that how you stop the traversal using booleans
    private boolean traverse(TreeNode root, int value, StringBuilder path) {
        // Optimize traversal by stopping it the moment value is found!!
        if (root == null) {
            return false;
        }

        if (root.val == value) {
            return true;
        }

        path.append("L");
        if (traverse(root.left, value, path)) {
            return true;
        }

        path.setLength(path.length() - 1);

        path.append("R");
        if (traverse(root.right, value, path)) {
            return true;
        }
        path.setLength(path.length() - 1);
        return false;
    }
}

```

## Graphs

### What is a graph?

- A structure with nodes/vertices and/or edges.
- A graph could have multiple connected components and we use the concept of `visitedArray`(with length = number of nodes(if 0-based indexing) or number of nodes+1 (if 1-based indexing)) to keep track of the vertices we visit, even if the components don't appear to be connected they could be of the same graph, hence the visited array. (Will become more clear once we dive into algorithms)

### Types of Graph:

1. Directed -> The edges have arrows towards the vertices, hence giving it a direction.
2. Undirected -> The edges don't have specific directions.

- For an undirected cyclic graph the degree of the graph is 2\*(number of edges).

### Other forms are:

1. Cyclic -> When you start with a node and end up back again at that node.
2. Acyclic -> When there's no way to reach back to the node you started with.

### Degree of a graph

- For undirected graph:
  Degree of an undirected cyclic graph = 2 \* E, where E is the number of edges.
  To calculate degree of a vertex, simply calculate the number of edges attached to it and then sum of them all would be the degree of the grapgh.

- For directed graph:
  Degree of a directed graph has been defined using the `In-degree` and the `Out-degree` of the nodes. As the name suggests `in-degree` of a node is the edges with arrows pointing inwards the node and `out-degree` is the edges with arrows pointing outwards.

---

### Ways to store a Graph(complex data structure):

1. Adjacency Matrix(adjMatrix.length = number of nodes), space complexity is O(n<sup>2</sup>), where, n is the number of nodes, that's why avoided.
2. `Adjacency list(adjList.length = number of nodes), space complexity is ~O(2n), hence this is preferred. n is the number of edges.`
3. `Length of visited array = length of adjList+1 or length of adjList = length of adjMatrix or length of adjMatrix+1`

```java
package graphs;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unused")
public class AdjacencyList {
    public static void main(String[] args) {
        // 1 -- 2 -- 3 -- 1 -> graph
        int n = 3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); // adjacency list

        // we'll insert (n+1) empty lists in the 'adj' list, where 'n' is the number of
        // nodes.
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>()); // (n+1) array lists inserted
        }

        // 1 -- 2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // 2 -- 3
        adj.get(2).add(3);
        adj.get(3).add(2);

        // 3--1
        adj.get(3).add(1);
        adj.get(1).add(3);

        /*
         * u--v : Undirected graph
         * adj.get(u).add(v);
         * adj.get(v).add(u);
         *
         * u-->v : Directed graph
         * adj.get(u).add(v);
         */

        for (int i = 1; i <= n; i++) {
            System.out.print("Node " + i + ": ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + "\s");
            }
            System.out.println();
        }
    }

}
```

For a directed graph one of the `adj.get(u).add(v)` or `adj.get(v).add(u)` is omitted as the direction would be specified.

## Breadth First Search or Level Order Traversal

```java
package javaPlayground;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

 // Time complexity = O(N) + O(2*E)
 // Space complexity = O(3*N)

public class j10 {
    public void bfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> bfs = new ArrayList<>();
        q.offer(1); // Starting with node 1 (1-based indexing)
        vis[1] = true;
        while (!q.isEmpty()) {
            Integer currentNode = q.poll();
            bfs.add(currentNode);
            for (Integer connectedNode : adj.get(currentNode)) {
                if (!vis[connectedNode]) {
                    q.offer(connectedNode);
                    vis[connectedNode] = true;
                }
            }
        }
        System.out.println(bfs);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 6; i++) { // Create adjacency list for 6 nodes (0 to 5)
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(4);
        adj.get(2).add(5);
        adj.get(3).add(5);

        j10 obj = new j10();
        obj.bfs(adj);
    }
}

```

- Queue stores the next level while the alogrithm traverses the current one.

## Depth First Search or DFS traversal

```java
package graphs;

import java.util.ArrayList;

public class DFS {
    public void dfsTraversal(ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[adj.size()]; // this calls every component!
        for (int i = 0; i < vis.length; i++) {
            dfs(i, vis, adj);
        }
    }

    private void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        // this visits/traverses every node!
        vis[node] = true;
        System.out.println("Node: " + node);
        for (Integer connectedNode : adj.get(node)) {
            if (!vis[connectedNode])
                dfs(connectedNode, vis, adj);
        }
    }
}

```

---

The following code illustrates the `conversion of adjacency matrix to adjacency list` along with DFS traversal.

```java
package javaPlayground;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unused")
public class j9 {
    public static void main(String[] args) {
        int[][] isConnected = {
                { 1, 1, 0 }, // 0
                { 1, 1, 0 }, // 1
                { 0, 0, 1 } // 2
        };
        findCircleNum(isConnected);
    }

    public static void findCircleNum(int[][] isConnected) {
        // 0-based indexed graph
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < isConnected.length; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjacencyList.get(i).add(j);
                    adjacencyList.get(j).add(i);
                }
            }
        }

        System.out.println("adjacencyList: " + adjacencyList);
        boolean[] vis = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < vis.length; i++) { // it calls every component
            if (vis[i] == false) {
                count++;
                dfs(i, adjacencyList, vis);
            }
        }
        System.out.println(count);
    }

    private static void dfs(Integer node, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] vis) {
        // this visits every connected node of that component
        vis[node] = true;
        for (Integer connectedNode : adjacencyList.get(node)) {
            if (vis[connectedNode] == false) {
                dfs(connectedNode, adjacencyList, vis);
            }
        }
    }
}

```

- The above code also shows the importance of visited array as when the graph has been divided into 'k' connected components then how to reach every node using the visited array.

---
